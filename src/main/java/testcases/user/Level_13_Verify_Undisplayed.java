package testcases.user;

import actions.PageObject.faceBook.LoginPageObject;
import actions.PageObject.faceBook.PageGeneratorManager;
import actions.commons.BaseTest;
import actions.pageObjects.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Level_13_Verify_Undisplayed extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {

        driver = getBrowserDriver(browserName,url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

    }

    @Test
    public void Login_01_Verify_Element_Displayed() {
            loginPage.clickToCreateNewAccountButton();
            verifyTrue(loginPage.isEmailAddressTextBoxDisplayed());
    }

    @Test
    public void Login_02_Verify_Element_Displayed() {
        loginPage.clickToCreateNewAccountButton();
        verifyTrue(loginPage.isEmailAddressTextBoxDisplayed());
    }






    public void afterClass() {
        driver.quit();
    }
}
