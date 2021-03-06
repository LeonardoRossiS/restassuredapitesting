package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();
    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();

    @Step("Retorna os IDs da listagem de reservas")
    public Response bookingReturnIDs(){
        return given()
                .when()
                .get("booking");
    }

    @Step("Retorna o primeiro ID válido da listagem de reservas")
    public int bookingReturnValidID(){
        if (bookingReturnIDs()
                .then()
                .extract()
                .path("[0].bookingid")==null) postBookingRequest
                .createBookingRequest();

        return bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");
    }

    @Step("Retorna o primeiro ID que não consta na listagem de reservas")
    public int bookingReturnInvalidID(){
        int i;
        for (i=1; i< 1000; i++){
            if(bookingReturn(i).then().extract().statusCode()==404) break;
        }
        return i;
    }

    @Step("Retorna os IDs da listagem de reservas, afetados por um filtro")
    public Response bookingFilterReturnIDs(String filter, String attribute){
        return given()
                .when()
                .get("booking?"+filter+"="+attribute);
    }

    @Step("Retorna os IDs da listagem de reservas, afetados por dois filtros")
    public Response booking2FiltersReturnIDs(String filter, String attribute,
                                             String filter2, String attribute2){
        return given()
                .when()
                .get("booking?"+filter+"="+attribute
                        +"&"+filter2+"="+attribute2);
    }

    @Step("Retorna os IDs da listagem de reservas, afetados por quatro filtros")
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

    @Step("Retorna os parâmetros da reserva 'id'")
    public Response bookingReturn(int id){
        return given()
                .when()
                .get("booking/"+id);
    }
}
