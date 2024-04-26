package testcases.jquery;

import actions.BaseObjectJquery.dataTable.HomePageObject;
import actions.BaseObjectJquery.dataTable.PageGeneratorManager;
import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_11_Upload_File extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }
    @Test
    public void Upload_01(){
        System.out.println(GlobalConstants.UPLOAD_FILE_FOLDER);
    }


}
