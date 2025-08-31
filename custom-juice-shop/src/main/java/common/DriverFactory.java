package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    // Thread-safe WebDriver instance for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Get the current WebDriver instance for the current thread
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(initDriver());
        }
        return driver.get();
    }

    /**
     * Initialize WebDriver based on browser from run.properties or Maven profile
     */
    private static WebDriver initDriver() {
        String browser = ConfigLoader.getBrowser().toLowerCase();
        WebDriver wd;

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                wd = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                wd = new FirefoxDriver();
                break;

            case "safari":
                // SafariDriver does not require WebDriverManager on Mac
                wd = new SafariDriver();
                break;

            default:
                System.out.println("Browser not recognized, launching Chrome by default");
                WebDriverManager.chromedriver().setup();
                wd = new ChromeDriver();
                break;
        }

        return wd;
    }

    /**
     * Quit WebDriver and remove from ThreadLocal storage
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
