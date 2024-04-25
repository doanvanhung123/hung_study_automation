package actions.BaseObjectJquery;

import actions.commons.BasePage;
import interfaces.PageUIs.jquery.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
    }

    public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
        waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
        sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
        pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
    }

    public boolean isPageNumberActived(String number) {
        waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, number);
        return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, number);
    }

    public List<String> getValueEachRowAllPage() {
        int totalPge = getElementsSize(driver, HomePageUI.TOTAL_PAGINATION);
        System.out.println("Total size = " + totalPge);

        List<String> allRowValues = new ArrayList<String>();
        for (int i = 1; i < totalPge; i++) {
            clickToElement(driver,HomePageUI.PAGINATION_PAGE_INDEX,String.valueOf(i));

            sleepInSecond(1);
            List<WebElement> allRowEachPage = getListWebElement(driver,HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
            for (WebElement eachRow : allRowEachPage){
                allRowValues.add(eachRow.getText());
            }
        }

        for (String value : allRowValues){
            System.out.println(value);
        }
        return allRowValues;
    }

    public void getAllPageColumnValuesByColumnName(String columnName) {
        List<WebElement> allPageLinks =  getListWebElement(driver,HomePageUI.ALL_PAGE_LINK);

        getListElementsSize(driver,HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME,columnName);
        for(WebElement pageLink :allPageLinks){
            pageLink.click();
        }
    }
}
