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

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

        driver = getBrowserDriver(browserName);
        loginPage = PageGeneratorManager.getLoginPage(driver);

    }

//    @Test
//    public void Login_01_Verify_Element_Displayed() {
//        loginPage.clickToCreateNewAccountButton();
//        verifyTrue(loginPage.isEmailAddressTextBoxDisplayed());
//    }
//
//    @Test
//    public void Login_02_Verify_Element_Displayed() {
//        loginPage.enterToEmailAddressTextBox("hung@gmail.com");
//        loginPage.sleepInSecond(3);
//        verifyTrue(loginPage.isConfirmEmailAddressTextBoxDisplayed());
//
//        loginPage.enterToEmailAddressTextBox("");
//        loginPage.sleepInSecond(3);
//        verifyFalse(loginPage.isConfirmEmailAddressTextBoxDisplayed());
//
//
//    }

    @Test
    public void Login_03_Verify_Element_Not_Displayed() {

        //isDisplayed func can't verify 1 element in DOM
        verifyTrue(loginPage.isConfirmEmailAddressTextBoxUnDisplayed());

    }


    public void afterClass() {
        driver.quit();
    }
}
