package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver ;
    public LoginPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver , this);
    }

    @FindBy(xpath="//input[@id='email']")
    WebElement emailInputBox;

    @FindBy(id="password")
    WebElement passwordInputBox;

    @FindBy(id="loginButton")
    WebElement loginBtn;

    //Page Action:

    public void login(String user , String pass){
        emailInputBox.sendKeys(user);
        passwordInputBox.sendKeys( pass );
        loginBtn.click();
    }
}
