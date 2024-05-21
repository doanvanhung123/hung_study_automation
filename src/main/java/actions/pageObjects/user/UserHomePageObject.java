package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.PageUIs.user.UserHomePageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;
    public UserHomePageObject(WebDriver driver){
        this.driver = driver;
    }
    @Step("Navigate to Register page")
    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }


    public UserCustomerInfoObject clickToMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserCustomerInfor(driver);
    }

    @Step("Navigate to login page")
    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLoginPagePage(driver);
    }
    @Step ("Verify my account link displayed")
    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    public UserLoginPageObject clickToLogoutLink() {
        waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
        clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
        return PageGeneratorManager.getUserLoginPagePage(driver);
    }

}
