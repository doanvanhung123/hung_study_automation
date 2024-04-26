package actions.BaseObjectJquery.dataTable;

import actions.commons.BasePage;
import interfaces.PageUIs.jquery.dataTable.HomePageUI;
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
        int totalPge = getListElementsSize(driver, HomePageUI.TOTAL_PAGINATION);
        System.out.println("Total size = " + totalPge);

        List<String> allRowValues = new ArrayList<String>();
        for (int i = 1; i < totalPge; i++) {
            clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(i));

            sleepInSecond(1);
            List<WebElement> allRowEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
            for (WebElement eachRow : allRowEachPage) {
                allRowValues.add(eachRow.getText());
            }
        }

        for (String value : allRowValues) {
            System.out.println(value);
        }
        return allRowValues;
    }


    public void enterToTextBoxAtRowNumberByColumnName(String columnName, String rowIndex, String values) {
        int comlumnIndex = getListElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        //sendkey to what row
        waitForElementVisible(driver,HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowIndex,String.valueOf(comlumnIndex));
        sendkeyToElement(driver,HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,values,rowIndex,String.valueOf(comlumnIndex));
    }

    public void selectDropDownAtRowNumberByColumnName(String columnName, String rowIndex, String values) {
        int comlumnIndex = getListElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        waitForElementClickable(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowIndex,String.valueOf(comlumnIndex));
        selectItemInDefaultDropdown(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,values,rowIndex,String.valueOf(comlumnIndex));
    }

    public void checkToCheckBoxAtRowNumberByColumnName(String columnName, String rowIndex) {

        int comlumnIndex = getListElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        waitForElementClickable(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowIndex,String.valueOf(comlumnIndex));
        checkToDefaultCheckBoxOrRadio(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowIndex,String.valueOf(comlumnIndex));
    }
}
