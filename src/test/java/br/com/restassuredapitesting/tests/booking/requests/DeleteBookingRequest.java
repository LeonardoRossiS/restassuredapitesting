package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    @Step("Deleta a reserva 'id'")
    public Response deleteRequest(int id,String token){
        return given()
                .header("Content-Type","application/json")
                .header("Cookie",token)
                .when()
                .delete("booking/"+id);
    }

}
