package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class DeleteBookingTest extends BaseTest {

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Excluir um reserva com sucesso")
    public void deletaReservaEspecifica(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.deleteRequest(primeiroID,postAuthRequest.getToken())
                .then()
                .statusCode(201);
    }

}
