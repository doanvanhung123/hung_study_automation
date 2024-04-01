package actions.pageObjects.admin;

import actions.commons.BasePage;
import interfaces.PageUIs.admin.AdminDashBoardPageUI;
import org.openqa.selenium.WebDriver;

public class AdminDashBoardPageObject extends BasePage {
    private WebDriver driver;

    public AdminDashBoardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isDashBoardHeaderDisplayed(){
        waitForElementVisible(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
        return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
    }
}
