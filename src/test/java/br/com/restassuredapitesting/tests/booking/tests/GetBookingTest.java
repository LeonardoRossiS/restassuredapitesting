package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
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
    @Category({AllTests.class})
    @DisplayName("Listar IDs de reservas")
    public void validaListagemIDReservas(){
        getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                //.log().all()
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o schema do retorno da lista de reservas")
    public void validaSchemaListagemReservas(){
        getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                //.log().all()
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
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
                //.log().all()
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","reservaespecifica"))));
    }

}
