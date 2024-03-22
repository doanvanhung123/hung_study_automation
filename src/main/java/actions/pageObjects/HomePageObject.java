package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.PageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
        clickToElement(driver,HomePageUI.LOGIN_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }
}
