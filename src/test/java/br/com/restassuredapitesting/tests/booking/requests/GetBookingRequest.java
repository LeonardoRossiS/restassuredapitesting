package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Retorna os IDs da listagem de reservas")
    public Response bookingReturnIDs(){
        return given()
                .when()
                .get("booking");
    }

    @Step("Retorna os detlhes da reserva 'id'")
    public Response bookingReturn(int id){
        return given()
                .when()
                .get("booking/"+id);
    }
}
