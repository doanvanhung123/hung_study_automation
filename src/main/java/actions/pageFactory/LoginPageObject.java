package actions.pageFactory;

import actions.commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;
    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMessage;
    @FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
    private WebElement unsuccessfulErrorMessage;
    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(loginButton);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, emailErrorMessage);
        return getElementText( emailErrorMessage);
    }

    public void inputToEmailTextBox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(emailTextbox, email);
    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, unsuccessfulErrorMessage);
        return getElementText( unsuccessfulErrorMessage);
    }

    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(passwordTextbox, password);
    }
}
