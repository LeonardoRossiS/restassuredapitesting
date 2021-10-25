package br.com.restassredapitesting.tests.auth.requests;

import br.com.restassredapitesting.tests.auth.requests.payloads.AuthPayloads;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import org.json.JSONObject;

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
