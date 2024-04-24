package testcases.jquery.datatable;

import actions.BaseObjectJquery.HomePageObject;
import actions.BaseObjectJquery.PageGeneratorManager;
import actions.commons.BaseTest;
import actions.pageObjects.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Level_10_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;


    @Parameters({"browser" , "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName,appUrl);
        homePage  = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Table_01_Paging() {
        homePage.openPagingByPageNumber("10");

        homePage.sleepInSecond(3);
        homePage.openPagingByPageNumber("20");
        homePage.sleepInSecond(3);

        homePage.openPagingByPageNumber("24");
        homePage.sleepInSecond(3);
        homePage.isPageNumberActived("24");

    }


    @Test
    public void Table_02_Enter_To_Header() {
        homePage.enterToHeaderTextboxByLabel("Country","Seychelles");
        homePage.enterToHeaderTextboxByLabel("Females","624");
        homePage.enterToHeaderTextboxByLabel("Males","651");
        homePage.enterToHeaderTextboxByLabel("Total","1270");

        homePage.sleepInSecond(3);

        homePage.enterToHeaderTextboxByLabel("Country","US Virgin Islands");
        homePage.enterToHeaderTextboxByLabel("Females","643");
        homePage.enterToHeaderTextboxByLabel("Males","709");
        homePage.enterToHeaderTextboxByLabel("Total","1350");
    }

//    @Test
//    public void Table_02_Enter_To_Header() {
//
//    }


    public void afterClass() {
        driver.quit();
    }
}
