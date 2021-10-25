package br.com.restassuredapitesting.tests.ping.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPingRequests {

    public Response pingReturnAPI(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .get("ping");

    }
}
