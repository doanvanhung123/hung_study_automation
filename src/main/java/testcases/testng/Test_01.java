package testcases.testng;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testcases.common.Register_New_Account_Cookie;
import testcases.common.Register_New_Account_EndUser;

public class Test_01 extends BaseTest {
    WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void Search_01_1() {
    }

    @Test
    public void Search_01_2() {
    }

    @Test
    public void Search_01_3() {

    }

    @AfterMethod
    public void afterClass() {
        driver.quit();
    }
}
