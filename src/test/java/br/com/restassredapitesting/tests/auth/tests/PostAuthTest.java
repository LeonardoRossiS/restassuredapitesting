package br.com.restassredapitesting.tests.auth.tests;

import br.com.restassredapitesting.base.BaseTest;
import br.com.restassredapitesting.suites.AllTests;
import br.com.restassredapitesting.tests.auth.requests.PostAuthRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.notNullValue;

public class PostAuthTest extends BaseTest {

    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Category({AllTests.class})
    public void validaRetornoDeTokenParaUsuario(){
        postAuthRequest.postTokenReturn()
                .then()
                .statusCode(200)
                //.log().all()
                .body("token",notNullValue());
    }

}
