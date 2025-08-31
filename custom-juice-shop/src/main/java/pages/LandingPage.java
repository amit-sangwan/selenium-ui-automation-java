package pages;

import common.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage {

    private WebDriver driver;
    // WebElements
    @FindBy(xpath = "//app-welcome-banner/h1")
    private WebElement desclaimerHeading;
    @FindBy(xpath = "//button[@color='primary']")
    private WebElement desclaimer;
    @FindBy(xpath = "//div[@class='cc-compliance']/a")
    private WebElement complianceButton;
    @FindBy(xpath = "//span[contains(text(),'Portfolio')]/parent::span/parent::button")
    private WebElement portfolioBtn;

    //Constructor
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialise WebElements
    }

    public boolean assertDesclaimerHeading() {
        return Utils.explicitWaitForText(driver, "Welcome to OWASP Custom Juice Shop", desclaimerHeading);
    }

    public void acceptDesclaimer() {
        desclaimer.click();
    }

    public void acceptcompliance() {
        complianceButton.click();
    }

    public String verifyPortfolioAccess() {
        portfolioBtn.click();
        Utils.genericExplicitWait(driver).until(ExpectedConditions.urlContains("amitsangwan"));
        return driver.getCurrentUrl();
    }


}
