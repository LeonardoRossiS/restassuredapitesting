package br.com.restassredapitesting.tests.booking.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    public Response bookingReturnIDs(){
        return given()
                .when()
                .get("booking");
    }
}
