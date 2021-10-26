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

    @Step("Retorna os IDs da listagem de reservas, afetados por um filtro")
    public Response bookingFilterReturnIDs(String filter, String attribute){
        return given()
                .when()
                .get("booking?"+filter+"="+attribute);
    }

    @Step("Retorna os IDs da listagem de reservas, afetados por um filtro")
    public Response booking2FiltersReturnIDs(String filter, String attribute,
                                             String filter2, String attribute2){
        return given()
                .when()
                .get("booking?"+filter+"="+attribute
                        +"&"+filter2+"="+attribute2);
    }

    @Step("Retorna os IDs da listagem de reservas, afetados por um filtro")
    public Response booking4FiltersReturnIDs(String filter, String attribute,
                                             String filter2, String attribute2,
                                             String filter3, String attribute3,
                                             String filter4, String attribute4){
        return given()
                .when()
                .get("booking?"+filter+"="+attribute
                        +"&"+filter2+"="+attribute2
                        +"&"+filter3+"="+attribute3
                        +"&"+filter4+"="+attribute4);
    }

    @Step("Retorna os detlhes da reserva 'id'")
    public Response bookingReturn(int id){
        return given()
                .when()
                .get("booking/"+id);
    }
}
