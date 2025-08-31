package base;

import common.ConfigLoader;
import common.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = DriverFactory.getDriver();
        baseUrl = ConfigLoader.get("baseUrl");
    }

    @AfterMethod
    public void quitBrowser() {
        DriverFactory.quitDriver();
    }
}