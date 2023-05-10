package com.redhat.greetings;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.apache.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;

@QuarkusTest
public class RESTApiTest {

    @Test
    public void testCreatingGreeting() {

        String json = """
                    {
                        "text":"Hello, REST Api!",
                        "author": "Ozzy Osbourne"
                    }
                """;

        with()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .request("POST", "/greetings")
                .then()
                .statusCode(202);
    }
}
