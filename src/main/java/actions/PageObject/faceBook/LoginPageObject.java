package actions.PageObject.faceBook;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import interfaces.PageUIs.faceBook.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateNewAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public boolean isEmailAddressTextBoxDisplayed() {
        waitForElementVisible(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        return isElementDisplayed(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
    }
}
