package testcases.jquery.datatable;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Level_10_DataTable extends BaseTest {
    WebDriver driver;


    @Parameters({"browser" , "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName,appUrl);

    }

    @Test
    public void Table_01() {

    }


    @Test
    public void Table_02() {

    }


    public void afterClass() {
        driver.quit();
    }
}
