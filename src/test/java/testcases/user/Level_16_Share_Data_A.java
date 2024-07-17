package testcases.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserLoginPageObject;
import testcases.common.Register_New_Account_EndUser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_16_Share_Data_A extends BaseTest {
    WebDriver driver;
    String emailAdress,password;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;


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

        log.info("Login - Step 02 : Enter to Email Text box with value is " + emailAdress);

        loginPage.inputToEmailTextBox(emailAdress);
        loginPage.inputToPasswordTextBox(password);

        log.info("Login - Step 03 : click to login button ");
        homePage = loginPage.clickToLoginButton();

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
