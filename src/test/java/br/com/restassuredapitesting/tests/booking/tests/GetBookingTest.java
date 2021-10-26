package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2e;
import br.com.restassuredapitesting.suites.Schema;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar uma reserva específica")
    public void validaListagemReservaEspecifica(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturn(primeiroID)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar IDs das reservas")
    public void validaListagemIDReservas(){
        getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro firstname")
    public void validaFiltragemFirstName(){
        getBookingRequest.bookingFilterReturnIDs("firstname",Utils.nometeste())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro lastname")
    public void validaFiltragemLastName(){
        getBookingRequest.bookingFilterReturnIDs("lastname",Utils.sobrenometeste())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkin")
    public void validaFiltragemCheckIn(){
        getBookingRequest.bookingFilterReturnIDs("checkin",Utils.checkinteste())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkout")
    public void validaFiltragemCheckOut(){
        getBookingRequest.bookingFilterReturnIDs("checkout",Utils.checkoutteste())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkout and checkout")
    public void validaFiltragemCheckOutECheckOut(){
        getBookingRequest.booking2FiltersReturnIDs("checkout",Utils.checkoutteste(),
                                                    "checkout",Utils.checkoutteste())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro name, checkin and checkout date")
    public void validaFiltragemNameECheckInECheckOut(){
        getBookingRequest.booking4FiltersReturnIDs("firstname",Utils.nometeste(),
                                                    "lastname",Utils.sobrenometeste(),
                                                    "checkin",Utils.checkinteste(),
                                                     "checkout",Utils.checkoutteste())
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Visualizar erro de servidor 500 quando enviar filtro mal formatado")
    public void validaFiltragemMalFormatada(){
        getBookingRequest.bookingFilterReturnIDs("fistne",Utils.nometeste())
                .then()
                .statusCode(500);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, Schema.class})
    @DisplayName("Garantir o schema do retorno da lista de reservas")
    public void validaSchemaListagemReservas(){
        getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, Schema.class})
    @DisplayName("Garantir o schema do retorno de uma reserva específica")
    public void validaSchemaReservaEspecifica(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturn(primeiroID)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","reservaespecifica"))));
    }

}
