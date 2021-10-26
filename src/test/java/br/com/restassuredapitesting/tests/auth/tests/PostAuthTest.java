package br.com.restassuredapitesting.tests.auth.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import io.qameta.allure.Feature;

import static org.hamcrest.Matchers.notNullValue;

@Feature("Feature - Autenticação de Usuário")
public class PostAuthTest extends BaseTest {

    PostAuthRequest postAuthRequest = new PostAuthRequest();

    //@Test
    //@Severity(SeverityLevel.BLOCKER)
    //@Category({AllTests.class, SmokeTests.class})
    //@DisplayName("Retornar token para o usuário")
    public void validaRetornoDeTokenParaUsuario(){
        postAuthRequest.postTokenReturn()
                .then()
                .statusCode(200)
                //.log().all()
                .body("token",notNullValue());
    }

}
