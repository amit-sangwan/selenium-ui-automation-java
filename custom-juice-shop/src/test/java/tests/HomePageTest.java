package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;

public class HomePageTest extends BaseTest {

    LandingPage lp;

    @BeforeMethod
    public void testSetUp() {
        driver.get(baseUrl);
        lp = new LandingPage(driver);
    }

    @Test
    public void verifyDisclaimer() throws InterruptedException {

        Assert.assertTrue(lp.assertDesclaimerHeading(), "Heading mismatch");
    }

    @Test
    public void login() throws InterruptedException {
        lp.acceptDesclaimer();

    }

    @Test
    public void acceptDisclaimer() throws InterruptedException {
        lp.acceptcompliance();

    }

    @Test
    public void verifyPortfolioNavigation() {
        Assert.assertTrue(lp.verifyPortfolioAccess().contains("amitsangwan.com"));
    }
}
