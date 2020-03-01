package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Post;
import org.wcci.blog.service.BlogServiceImpl;
import org.wcci.blog.service.IBlogService;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private IBlogService iBlogService;

    private Author testAuthor;
    private Post testPost;

    @BeforeEach
    public void testClassSetup() {
        testAuthor = new Author("testAuthor");
        iBlogService.saveAuthor("testAuthor");
        testPost= new Post("testTitle","postBody",testAuthor, LocalDateTime.now());
        iBlogService.savePost(testPost);
    }

    @Test
    public void authorsEndPointReturnsOK() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/authors", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

//    @Test
//    public void postsEndPointReturnsOK() {
//        ResponseEntity<String> response = testRestTemplate.getForEntity(
//                "http://localhost:" + port + "/all-posts", String.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//
//
//
//
//    @Test
//    public void specificEndPointReturnsOK() {
//        ResponseEntity<String> response = testRestTemplate.getForEntity(
//                "http://localhost:" + port + "/post/" + testPost.getPostId(), String.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//



}
