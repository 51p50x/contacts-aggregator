package org.pablo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ContactsResourceTest {
    @Test
    void testEndpoint() {
        given()
          .when().get("/contacts")
          .then().statusCode(200);
    }

}