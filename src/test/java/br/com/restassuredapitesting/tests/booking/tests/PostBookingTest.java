package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2e;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Criação de reservas")
public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Category({AllTests.class, Acceptance.class})
    @DisplayName("Criar uma nova reserva")
    @Severity(SeverityLevel.NORMAL)
    public void criarNovaReserva(){
        postBookingRequest.createBookingRequest()
                .then()
                .statusCode(200)
                //.log().all()
                .body("size()",greaterThan(0));
    }

    @Test
    @Category({AllTests.class, E2e.class})
    @DisplayName("Validar retorno 500 quando o payload da reserva estiver inválido")
    @Severity(SeverityLevel.NORMAL)
    public void criarNovaReservaPayloadInvalido(){
        postBookingRequest.createInvalidBookingRequest()
                .then()
                .statusCode(500);
    }

    @Test
    @Category({AllTests.class, E2e.class})
    @DisplayName("Validar a criação de mais de um livro em sequencia")
    @Severity(SeverityLevel.NORMAL)
    public void criarDuasNovasReservas(){
        postBookingRequest.createBookingRequest()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
        postBookingRequest.createBookingRequest()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Category({AllTests.class, E2e.class})
    @DisplayName("Criar uma reserva enviando mais parâmetros no payload da reserva")
    @Severity(SeverityLevel.NORMAL)
    public void criarNovaReservaPayloadMaior(){
        postBookingRequest.createBookingRequestPayloadMaior()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Category({AllTests.class, E2e.class})
    @DisplayName("Validar retorno 418 quando o header Accept for invalido")
    @Severity(SeverityLevel.NORMAL)
    public void criarNovaReservaAcceptInvalido(){
        postBookingRequest.createInvalidAcceptBookingRequest()
                .then()
                .statusCode(418);
    }

}
