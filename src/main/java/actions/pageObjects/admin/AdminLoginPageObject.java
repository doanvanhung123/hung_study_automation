package actions.pageObjects.admin;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserHomePageObject;
import interfaces.PageUIs.admin.AdminLoginPageUI;
import interfaces.PageUIs.user.UserLoginPageUI;
import org.openqa.selenium.WebDriver;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, AdminLoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void inputToEmailTextBox(String email) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public String getErrorMessageUnsuccessfull() {
        waitForElementVisible(driver, AdminLoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
        return getElementText(driver, AdminLoginPageUI.UNSUCCESSFULL_ERROR_MESSAGE);
    }

    public void inputToPasswordTextBox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserHomePageObject loginAsUser(String email,String password) {
        inputToEmailTextBox(email);
        inputToPasswordTextBox(password);
        return clickToLoginButton();
    }

}
