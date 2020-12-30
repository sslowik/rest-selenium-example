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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.Comment;
import pojo.Post;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TypicodeApiTests {

    static Logger logger = Logger.getLogger(TypicodeApiTests.class);

    final String baseUrl = "https://jsonplaceholder.typicode.com";

    private List<Post> posts;
    Post firstPost;

    private int firstPostCommentsCount = -1;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUrl;
    }

    /**
     * Pokryj przypadkami testowymi wszystkie metody posts oraz comments dla API
     * https://jsonplaceholder.typicode.com/ .
     * <p>
     * API methods:
     * TC1: GET	/posts
     * TC2: GET	/posts/1
     * TC3: GET	/posts/1/comments
     * TC4: GET	/comments?postId=1
     * TC5: POST /posts
     * TC6: PUT	/posts/1
     * TC7: PATCH /posts/1
     * TC8: DELETE /posts/1
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
        logger.info("PASS -> Received response with status code: " + res.statusCode());
        return res;
    }

    @Test
    public void TC1_getPostsTest() {
        Response res = getResponse("/posts");
        List<String> userIds = res.jsonPath().getList("id");
        Reporter.log("User id size: " + userIds.size());
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
        firstPost = res.getBody().as(Post.class);
        Assert.assertEquals(firstPost.getId(), "1");
    }

    @Test
    public void TC3_getFirstPostCommentsTest() {
        Response res = getResponseAndCheckCode("/posts/1/comments", 200);
        List<Comment> comments = Arrays.asList(res.getBody().as(Comment[].class));
        firstPostCommentsCount = comments.size();
        logger.info("First post comments size = " + firstPostCommentsCount);
        Comment comment = comments.get(0);
        logger.info("Comment = " + comment);
    }

    @Test
    public void TC4_getCommentsByPostIdTest() {
        RequestSpecification req = given()
                .basePath("/comments")
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .queryParam("postId", "1");
        Response res = req.when().get()
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON).extract().response();
        List<Comment> comments = Arrays.asList(res.getBody().as(Comment[].class));
        int commentsById = comments.size();
        if (firstPostCommentsCount != -1) Assert.assertEquals(firstPostCommentsCount, commentsById);
        logger.info("comments.size() = " + commentsById);
        Comment comment = comments.get(0);
        logger.info("Comment = " + comment);
    }

    @Test
    void TC5_createPostTest() {
        Post post = new Post("11", "101", "new comment", "per aspera ad astra");
        logger.info("PASS -> Created new post: " + post.toString());
        given().body(post)
                .when().post("/posts")
                .then().assertThat().statusCode(201);
    }

    @Test
    void TC6_putToFirstPostTest() {
        if (firstPost == null) TC2_getFirstPostTest();
        logger.info("firstPost before= " + firstPost.toString());
        firstPost.setTitle("updated title: " + firstPost.getTitle());
        firstPost.setBody("updated body: " + firstPost.getBody());
        Response res = given().body(firstPost)
                .when().put("/posts/1")
                .then().assertThat().statusCode(200)
                .and().extract().response();
        Post afterPost = res.body().as(Post.class);
        logger.info("afterPost.toString() = " + afterPost.toString());
    }

    @Test
    void TC7_patchFirstPostTest() {
        if (firstPost == null) TC2_getFirstPostTest();
        logger.info("firstPost before= " + firstPost.toString());
        String patchBody = "{\n \"title\": \"semper fidelis\" \n}";
        Response res = given()
                .body(patchBody)
                .when().patch("/posts/1")
                .then().assertThat().statusCode(200)
                .and().extract().response();
        logger.info("res.toString() = " + res.toString());
        Assert.assertEquals(res.jsonPath().getString("userId"), "1");
        Assert.assertEquals(res.jsonPath().getString("id"), "1");
        Assert.assertEquals(res.jsonPath().getString("title"), "semper fidelis");
    }

    @Test
    void TC8_deleteFirstPostTest() {
        given().when().delete("/posts/1")
                .then().assertThat().statusCode(200);
    }
}
