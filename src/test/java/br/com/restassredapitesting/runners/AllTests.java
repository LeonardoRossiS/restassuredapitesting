package br.com.restassredapitesting.runners;


import br.com.restassredapitesting.tests.auth.tests.PostAuthTest;
import br.com.restassredapitesting.tests.booking.tests.GetBookingTest;
import br.com.restassredapitesting.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassredapitesting.suites.AllTests.class)
@Suite.SuiteClasses({
        GetPingTest.class,
        GetBookingTest.class,
        PostAuthTest.class
})
public class AllTests {

}
