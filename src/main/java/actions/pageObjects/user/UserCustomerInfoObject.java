package actions.pageObjects.user;

import actions.commons.BasePage;
import interfaces.PageUIs.user.UserCustomerInforPageUI;
import org.openqa.selenium.WebDriver;

public class UserCustomerInfoObject extends BasePage {
    private WebDriver driver;
    public UserCustomerInfoObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isMyAccountPageDisplayed(){
        waitForElementVisible(driver, UserCustomerInforPageUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver, UserCustomerInforPageUI.CUSTOMER_INFO_HEADER);
    }


}
