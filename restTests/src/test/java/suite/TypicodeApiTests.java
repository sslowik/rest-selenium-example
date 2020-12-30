package suite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo.Post;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TypicodeApiTests {

    static Logger logger = Logger.getLogger(TypicodeApiTests.class);

    final String baseUrl = "https://jsonplaceholder.typicode.com";

    private List<Post> posts;

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = baseUrl;
    }

    /**
     * Pokryj przypadkami testowymi wszystkie metody posts oraz comments dla API
     * https://jsonplaceholder.typicode.com/ .
     */

    private static Response getResponse(String path) {
        RestAssured.defaultParser = Parser.JSON;
        RequestSpecification req = given()
                .basePath(path)
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON);
        Response res = req.when().get()
                .then().contentType(ContentType.JSON).extract().response();
        return res;
    }

    private static Response getResponseAndCheckCode(String path, int expectedCode) {
        RestAssured.defaultParser = Parser.JSON;
        RequestSpecification req = given()
                .basePath(path)
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON);
        Response res = req.when().get()
                .then().assertThat().statusCode(expectedCode)
                .and().contentType(ContentType.JSON).extract().response();
        return res;
    }

    /**
     * GET	/posts
     * GET	/posts/1
     * GET	/posts/1/comments
     * GET	/comments?postId=1
     * POST	/posts
     * PUT	/posts/1
     * PATCH	/posts/1
     * DELETE	/posts/1
     */
    @Test
    public void getPostsTest() {
        Response response = getResponse("/posts");

        ResponseBody postsBody = response.getBody();
//        System.out.println("Posts body = " + postsBody.asString());
        List<String> userIds = response.jsonPath().getList("id");
        System.out.println(userIds.size());
        System.out.println("List of userIds = " + userIds.toString());
        posts = Arrays.asList(response.getBody().as(Post[].class));
    }

//    @Test(priority = 2, dependsOnMethods = "getPostsTest")
    void mapResponseTest() {
        Response response = getResponse(baseUrl + "users/1");
        Map<String, String> company = response.jsonPath().getMap("company");
        System.out.println("company.size() = " + company.size() + "\n");
        company.forEach((k, v) -> System.out.println("key: = " + k + " / value: = " + v));
        String name = company.get("name");
        System.out.println("\nname = " + name);
    }

    @Test
    void createPostTest() {
        Post post = new Post("11", "101", "new comment", "per aspera ad astra");
        logger.info("PASS -> Created new post: " + post.toString());
        given().body(post)
                .when().post("/posts")
                .then().assertThat().statusCode(201);
    }

    @Test(priority = 2, dependsOnMethods = "getPostsTest", enabled = false)
    void userTest() {
        Response res = getResponse("/users");
        List<String> usernames = res.jsonPath().getList("username");
        System.out.println(usernames.size());
        int[] counters = new int[1];
        counters[0] = 1;
        usernames.forEach(s -> {
                    System.out.println("user " + counters[0] + " = " + s);
                    counters[0] += 1;
                }
        );
        System.out.println("\n\n\nuser 1 = " + res.jsonPath().getString("username[0]"));
    }

    @Test(priority = 2, dependsOnMethods = "getPostsTest", enabled = false)
    void firstUserTest() {
        Response response = getResponse(baseUrl + "users/1");
        Map<String, String> company = response.jsonPath().getMap("company");
        System.out.println("company.size() = " + company.size() + "\n");
        company.forEach((k, v) -> System.out.println("key: = " + k + " / value: = " + v));
        String name = company.get("name");
        System.out.println("\nname = " + name);
    }
}
