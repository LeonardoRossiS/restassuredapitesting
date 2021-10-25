package br.com.restassredapitesting.tests.booking.tests;

import br.com.restassredapitesting.base.BaseTest;
import br.com.restassredapitesting.suites.AllTests;
import br.com.restassredapitesting.tests.booking.requests.GetBookingRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Category({AllTests.class})
    public void validaListagemIDReservas(){
        getBookingRequest.bookingReturnIDs()
                .then()
                .statusCode(200)
                //.log().all()
                .body("size()",greaterThan(0));
    }

}
