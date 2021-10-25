package br.com.restassuredapitesting.tests.auth.requests;

import br.com.restassuredapitesting.tests.auth.requests.payloads.AuthPayloads;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class PostAuthRequest {

    AuthPayloads authPayloads = new AuthPayloads();


    public Response postTokenReturn(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .body(authPayloads.jsonAuthLogin().toString())
                .post("auth");
    }

    public String getToken(){
        return "token="+this.postTokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}