package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2e;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Atualização de reservas")
public class PutBookingTest extends BaseTest {

    PutBookingRequest putBookingRequest = new PutBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Alterar uma reserva usando o token")
    @Severity(SeverityLevel.NORMAL)
    public void validarAlteracaoDeUmaReservaUsandoToken(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");


        putBookingRequest.updateBookingToken(primeiroID,postAuthRequest.getToken())
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Alterar uma reserva usando o Basic auth")
    @Severity(SeverityLevel.NORMAL)
    public void validarAlteracaoDeUmaReservaUsandoBasicAuth(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");


        putBookingRequest.updateBookingAuthorisation(primeiroID,"Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Category({AllTests.class, E2e.class})
    @DisplayName("Tentar alterar uma reserva quando o token não for enviado")
    @Severity(SeverityLevel.NORMAL)
    public void validarAlteracaoDeUmaReservaSemToken(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");


        putBookingRequest.updateBookingToken(primeiroID,"")
                .then()
                .statusCode(200);
    }

    @Test
    @Category({AllTests.class, E2e.class})
    @DisplayName("Tentar alterar uma reserva quando o token enviado for inválido")
    @Severity(SeverityLevel.NORMAL)
    public void validarAlteracaoDeUmaReservaUsandoTokenErrado(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");


        putBookingRequest.updateBookingToken(primeiroID,"abc123")
                .then()
                .statusCode(200);
    }

    @Test
    @Category({AllTests.class, E2e.class})
    @DisplayName("Tentar alterar uma reserva que não existe")
    @Severity(SeverityLevel.NORMAL)
    public void validarAlteracaoDeUmaReservaInexistenteUsandoToken(){
        int idInvalido = 1;

        putBookingRequest.updateBookingToken(idInvalido,postAuthRequest.getToken())
                .then()
                .statusCode(200);
    }

}
