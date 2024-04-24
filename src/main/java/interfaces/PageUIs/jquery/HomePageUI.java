package interfaces.PageUIs.jquery;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageUI extends BasePage {

    public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
    public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";

}
