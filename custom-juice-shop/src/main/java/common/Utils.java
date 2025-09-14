package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Utils extends ConfigLoader{

    public static boolean explicitWaitForText(WebDriver driver, String text, WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        boolean element = wait.until(ExpectedConditions.textToBePresentInElement(webelement, text));
        return element;
    }

    public static WebDriverWait genericExplicitWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }

    // Random string of given length
    public static  String getRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // Generic getter method
    public static String getTestProperty(String key) {
        String value = testProperties.getProperty(key);
        if (value == null) {
            throw new RuntimeException(" Property '" + key + "' not found in  custom-juice-shop.properties");
        }
        return value;
    }
}
