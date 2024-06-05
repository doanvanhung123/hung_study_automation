package actions.pageObjects.sauceLab;

import actions.commons.BasePage;
import interfaces.PageUIs.sauceLab.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String userName) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX,userName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public ProductPageObject clickLoginButton() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return new ProductPageObject(driver);
    }
}
