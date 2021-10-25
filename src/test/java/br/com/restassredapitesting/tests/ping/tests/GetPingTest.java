package br.com.restassredapitesting.tests.ping.tests;

import br.com.restassredapitesting.base.BaseTest;
import br.com.restassredapitesting.suites.AllTests;
import br.com.restassredapitesting.tests.ping.requests.GetPingRequests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class GetPingTest extends BaseTest {

    GetPingRequests getPingRequests = new GetPingRequests();

    @Test
    @Category({AllTests.class})
    public void healthCheck(){
        getPingRequests.pingReturnAPI()
                .then()
                //.time(lessThan(2L), TimeUnit.SECONDS)
                .statusCode(201);
    }


}
