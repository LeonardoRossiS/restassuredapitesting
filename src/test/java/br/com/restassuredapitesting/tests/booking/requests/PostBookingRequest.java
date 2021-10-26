package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.requests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    BookingPayloads bookingPayloads = new BookingPayloads();

    @Step("Atualiza uma reserva específica com o parâmetro token")
    public Response createBookingRequest(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }

    @Step("Atualiza uma reserva específica com o payload inválido")
    public Response createInvalidBookingRequest(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .body(bookingPayloads.payloadInvalidBooking().toString())
                .post("booking");
    }

    @Step("Atualiza uma reserva específica com o payload maior")
    public Response createBookingRequestPayloadMaior(){
        return given()
                .header("Content-Type","application/json")
                .when()
                .body(bookingPayloads.payloadBiggerBooking().toString())
                .post("booking");
    }

    @Step("Atualiza uma reserva específica com o header 'Accept' inválido")
    public Response createInvalidAcceptBookingRequest(){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","invalid")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }
}
