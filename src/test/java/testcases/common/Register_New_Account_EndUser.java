package testcases.common;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class Register_New_Account_EndUser extends BaseTest {

    WebDriver driver;
    public static String emailAdress,password;
    String firstName, lastName;
    UserHomePageObject homePage;
    UserRegisterPageObject registerPage;


    @Parameters("browser")
    @BeforeTest(description = "Create new User for all class")
    public void Register(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
        emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        log.info("Register - Step 01: Navigate to Register page");
        registerPage = homePage.clickToRegisterLink();
        log.info("Register - Step 02 : Enter to Firtname textbox with value is" + firstName);
        registerPage.inputToFistnameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAdress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        log.info("Register - Step 03 : Click to Register button");

        registerPage.clickToRegisterButton();
        log.info("Register - Step 04 : Verify register success message is displayed");

        verifyEquals(registerPage.getSuccessMessage(), "Your registration completed");

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
