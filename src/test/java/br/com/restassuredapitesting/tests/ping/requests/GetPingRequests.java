package br.com.restassuredapitesting.tests.ping.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPingRequests {

    @Step ("Retorna se a API está online")
    public Response pingReturnAPI(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .get("ping");

    }
}
