package base;

import common.ConfigLoader;
import common.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = DriverFactory.getDriver();
        // *******  More time delays as the app under test is hosted on a small-sized machine *******
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        baseUrl = ConfigLoader.getAppUrl();
    }

    @AfterMethod
    public void quitBrowser() {
        DriverFactory.quitDriver();
    }
}
