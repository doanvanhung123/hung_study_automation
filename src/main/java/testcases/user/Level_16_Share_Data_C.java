package testcases.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserCustomerInfoObject;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserLoginPageObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testcases.common.Register_New_Account_Cookie;
import testcases.common.Register_New_Account_EndUser;

import java.util.Set;

public class Level_16_Share_Data_C extends BaseTest {
    WebDriver driver;
    String emailAdress,password;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;

    UserCustomerInfoObject customerInforPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        emailAdress = Register_New_Account_EndUser.emailAdress;

        password = Register_New_Account_EndUser.password;
        System.out.println(emailAdress + password + "");
        log.info("Login - Step 01 : Navigate to Login page");
        loginPage = homePage.clickToLoginLink();

        log.info("Login - Step 02 : Set cookie and reload page" + emailAdress);
        loginPage.setCookies(driver,Register_New_Account_Cookie.loggedCookies);
        for (Cookie cookie:Register_New_Account_Cookie.loggedCookies){
            System.out.println(cookie);
        }
        loginPage.refreshCurrentPage(driver);

        log.info("Login - Step 03 : Verify is my account displayed");
        verifyTrue(customerInforPage.isMyAccountPageDisplayed());

    }

    @Test
    public void Search_01_Empty_Data() {

    }

    @Test
    public void Search_02_Relative_Product_Name() {

    }

    @Test
    public void Search_03_Absolute_Product_Name() {

    }

    @Test
    public void Search_04_Parent_Category() {

    }

    @Test
    public void Search_05_Incorrect_Manufactorer() {

    }

    @Test
    public void Search_06_Correct_Manufactorer() {

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
