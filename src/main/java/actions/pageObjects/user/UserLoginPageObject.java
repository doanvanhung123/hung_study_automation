package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.PageUIs.user.UserLoginPageUI;
import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void inputToEmailTextBox(String email) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, UserLoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
    }

    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserHomePageObject loginAsUser(String email,String password) {
        inputToEmailTextBox(email);
        inputToPasswordTextBox(password);
        return clickToLoginButton();
    }
}
