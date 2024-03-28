package actions.pageObjects.user;

import actions.commons.BasePage;
import interfaces.PageUIs.CustomerInforPageUI;
import org.openqa.selenium.WebDriver;

public class UserCustomerInfoObject extends BasePage {
    private WebDriver driver;
    public UserCustomerInfoObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isMyAccountPageDisplayed(){
        waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFO_HEADER);
    }


}
