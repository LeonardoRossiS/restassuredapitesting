package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.ping.requests.GetPingRequests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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
