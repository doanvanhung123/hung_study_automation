package interfaces.PageUIs.jquery.dataTable;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageUI extends BasePage {

    public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
    public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";
    public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']//li";
    public static final String PAGINATION_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']//li[%s]/a";
    public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
    public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";

//    public static final String ALL_PAGE_LINK = "xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
//    public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%S']//ancestor::th";
//    public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//tr/td[%s]";

    public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//tr/th[text()='%s']//preceding-sibling::th";
    public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]/td[%s]/input";
    public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]/td[%s]//select";
    public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]/td[%s]//input[@type='checkbox']";


}
