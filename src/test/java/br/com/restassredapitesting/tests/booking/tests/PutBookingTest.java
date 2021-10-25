package br.com.restassredapitesting.tests.booking.tests;

import br.com.restassredapitesting.base.BaseTest;
import br.com.restassredapitesting.suites.AllTests;
import br.com.restassredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassredapitesting.tests.auth.tests.PostAuthTest;
import br.com.restassredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassredapitesting.tests.booking.requests.PutBookingRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

public class PutBookingTest extends BaseTest {

    PutBookingRequest putBookingRequest = new PutBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Category({AllTests.class})
    public void validarAlteracaoDeUmaReservaUsandoToken(){
        int primeiroID = getBookingRequest.bookingReturnIDs()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");


        putBookingRequest.updateBookingToken(primeiroID,postAuthRequest.getToken())
                .then()
                .statusCode(200)
                //.log().all()
                .body("size()",greaterThan(0));
    }

}
