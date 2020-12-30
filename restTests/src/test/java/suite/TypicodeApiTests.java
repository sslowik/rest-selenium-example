package suite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
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
     * TC1:  GET	/posts
     * TC2: GET	/posts/1
     * TC3: GET	/posts/1/comments
     * TC4: GET	/comments?postId=1
     * TC5: POST	/posts
     * TC6: PUT	/posts/1
     * TC7: PATCH	/posts/1
     * TC8: DELETE	/posts/1
     */
    @Test
    public void TC1_getPostsTest() {
        Response res = getResponse("/posts");

        ResponseBody postsBody = res.getBody();
        List<String> userIds = res.jsonPath().getList("id");
        Reporter.log("User id size: "+ userIds.size());
        Reporter.log("List of userIds = " + userIds.toString());
        posts = Arrays.asList(res.getBody().as(Post[].class));
    }

    @Test
    public void TC2_getFirstPostTest() {
        Response res = getResponse("/posts/1");
        res.then().assertThat().statusCode(200);
        Reporter.log("PASS -> response code is 200.", 1, true);
        ResponseBody postsBody = res.getBody();
        logger.info("Posts body = " + postsBody.asString());
        String userId = res.jsonPath().getString("id");
        logger.info("userId = " + userId);
        Post firstPost = res.getBody().as(Post.class);
        Assert.assertEquals(firstPost.getId(), "1");
    }

    @Test
    public void TC3_getFirstPostComments() {
        Response res = getResponse("/posts/1/comments");
        ResponseBody postsBody = res.getBody();
        List<String> userIds = res.jsonPath().getList("id");
        Reporter.log("User id size: "+ userIds.size());
        Reporter.log("List of userIds = " + userIds.toString());
        posts = Arrays.asList(res.getBody().as(Post[].class));
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
