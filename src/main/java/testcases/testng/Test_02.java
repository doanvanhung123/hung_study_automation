package testcases.testng;

import actions.commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_02 extends BaseTest {
    WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void Search_02_1() {
    }

    @Test
    public void Search_02_2() {
    }

    @Test
    public void Search_02_3() {

    }

    @AfterMethod
    public void afterClass() {
        driver.quit();
    }
}
