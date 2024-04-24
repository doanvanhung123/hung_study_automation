package actions.BaseObjectJquery;

import actions.commons.BasePage;
import interfaces.PageUIs.jquery.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER,pageNumber);
        clickToElement(driver,HomePageUI.PAGINATION_PAGE_BY_NUMBER,pageNumber);
    }

    public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
            waitForElementVisible(driver,HomePageUI.HEADER_TEXTBOX_BY_LABEL,headerLabel);
            sendkeyToElement(driver,HomePageUI.HEADER_TEXTBOX_BY_LABEL,value,headerLabel);
            pressKeyToElement(driver,HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER,headerLabel);
    }

    public boolean isPageNumberActived(String number) {
        waitForElementVisible(driver,HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER,number);
        return isElementDisplayed(driver,HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER,number);
    }
}
