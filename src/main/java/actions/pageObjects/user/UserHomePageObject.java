package actions.pageObjects.user;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.PageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;
    public UserHomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserCustomerInfoObject clickToMyAccountLink() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getUserCustomerInfor(driver);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
        clickToElement(driver,HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLoginPagePage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

}
