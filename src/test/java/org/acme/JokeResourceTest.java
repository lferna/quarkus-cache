package org.acme;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class JokeResourceTest {

    @Test
    public void testJokeEndpoint() {
        given()
          .when().get("/jokes/get")
          .then()
             .statusCode(200);
    }

}