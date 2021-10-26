package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.ping.requests.GetPingRequests;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Feature("Feature - API Online")
public class GetPingTest extends BaseTest {

    GetPingRequests getPingRequests = new GetPingRequests();

    @Test
    @Category({AllTests.class})
    @DisplayName("Verificar se API está online")
    @Severity(SeverityLevel.BLOCKER)
    public void healthCheck(){
        getPingRequests.pingReturnAPI()
                .then()
                //.time(lessThan(2L), TimeUnit.SECONDS)
                .statusCode(201);
    }


}
