package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static boolean explicitWaitForText(WebDriver driver, String text, WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean element = wait.until(ExpectedConditions.textToBePresentInElement(webelement, text));
        return element;
    }

    public static WebDriverWait genericExplicitWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }
}
