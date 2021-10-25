package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
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
