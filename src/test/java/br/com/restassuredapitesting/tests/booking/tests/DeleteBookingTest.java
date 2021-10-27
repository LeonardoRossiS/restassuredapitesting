package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2e;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;


@Feature("Feature - Exclusão de reservas")
public class DeleteBookingTest extends BaseTest {

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Excluir um reserva com sucesso")
    public void deletaReservaEspecifica(){
        int primeiroID = getBookingRequest.bookingReturnValidID();

        deleteBookingRequest.deleteRequest(primeiroID,postAuthRequest.getToken())
                .then()
                .statusCode(201);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Tentar excluir um reserva que não existe")
    public void deletaReservaInexistente(){
        int idInexistente = getBookingRequest.bookingReturnInvalidID();
        System.out.println(idInexistente);
        deleteBookingRequest.deleteRequest(idInexistente,postAuthRequest.getToken())
                .then()
                .statusCode(201);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Tentar excluir uma reserva sem autorização")
    public void deletaReservaSemToken(){
        int primeiroID = getBookingRequest.bookingReturnValidID();

        deleteBookingRequest.deleteRequest(primeiroID,"token=abc123")
                .then()
                .statusCode(201);
    }

}
