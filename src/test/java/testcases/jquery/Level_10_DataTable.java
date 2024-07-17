package testcases.jquery;

import actions.BaseObjectJquery.dataTable.HomePageObject;
import actions.BaseObjectJquery.dataTable.PageGeneratorManager;
import actions.commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Level_10_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    List<String> allCountryValues;

    @Parameters({"browser","url","env"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String browserName, @Optional("dev") String url, @Optional("local") String env, @Optional("localHost") String ipAddress, @Optional("4444") String portNumber
            , @Optional("Windows 10") String osName, @Optional("latest") String osVersion) {
        driver = getBrowserDriver(browserName,url,env,ipAddress,portNumber,osName,osVersion);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

//    @Test
//    public void Table_01_Paging() {
//        homePage.openPagingByPageNumber("10");
//
//        homePage.sleepInSecond(3);
//        homePage.openPagingByPageNumber("20");
//        homePage.sleepInSecond(3);
//
//        homePage.openPagingByPageNumber("24");
//        homePage.sleepInSecond(3);
//        homePage.isPageNumberActived("24");
//
//    }


//    @Test
//    public void Table_02_Enter_To_Header() {
//        homePage.enterToHeaderTextboxByLabel("Country", "Seychelles");
//        homePage.enterToHeaderTextboxByLabel("Females", "624");
//        homePage.enterToHeaderTextboxByLabel("Males", "651");
//        homePage.enterToHeaderTextboxByLabel("Total", "1270");
//
//        homePage.sleepInSecond(3);
//
//        homePage.enterToHeaderTextboxByLabel("Country", "US Virgin Islands");
//        homePage.enterToHeaderTextboxByLabel("Females", "643");
//        homePage.enterToHeaderTextboxByLabel("Males", "709");
//        homePage.enterToHeaderTextboxByLabel("Total", "1350");
//    }

//    @Test
//    public void Table_3_get_Cell_Value() {
//        allCountryValues = homePage.getValueEachRowAllPage();
//    }

    @Test
    public void Table_5_Enter_To_Cell() {
        homePage.enterToTextBoxAtRowNumberByColumnName("Company","1","Welch LLC");
        homePage.enterToTextBoxAtRowNumberByColumnName("Contact Person","1","Welch LLC");
        homePage.enterToTextBoxAtRowNumberByColumnName("Order Placed","1","Welch LLC");
        homePage.selectDropDownAtRowNumberByColumnName("Country","1","Germany");
        homePage.sleepInSecond(1);
        homePage.selectDropDownAtRowNumberByColumnName("Country","1","Hong Kong");
        homePage.sleepInSecond(1);

        homePage.checkToCheckBoxAtRowNumberByColumnName("NPO?","1");
        homePage.sleepInSecond(1);
    }


    public void afterClass() {
        driver.quit();
    }
}
