package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.PageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void inputToEmailTextBox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
        return getElementText(driver, LoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
    }

    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserHomePageObject loginAsUser(String email,String password) {
        inputToEmailTextBox(email);
        inputToPasswordTextBox(password);
        return clickToLoginButton();
    }
}
