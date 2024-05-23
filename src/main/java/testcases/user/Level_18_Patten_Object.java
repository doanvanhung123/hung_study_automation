package testcases.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserCustomerInfoObject;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserLoginPageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Level_18_Patten_Object extends BaseTest {
    WebDriver driver;
    String emailAdress;
    String firstName, lastName, validEmail, password;
    UserHomePageObject homePage;
    UserRegisterPageObject registerPage;
    UserLoginPageObject loginPage;
    UserCustomerInfoObject customerInforPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        log.info("");
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
        emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        driver.manage().window().maximize();
        firstName = "Automation";
        lastName = "FC";
        validEmail = emailAdress;
        password = "123456";

    }

    @Test
    public void Login_01_Register_Login_My_Account() {
        log.info("Register - Step 01: Navigate to Register page");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 02 : Enter to Firtname textbox with value is" + firstName);
        registerPage.inputToTextBoxByID(driver,"FirstName",firstName);

        log.info("Register - Step 02 : Enter to lastName textbox with value is" + firstName);
        registerPage.inputToTextBoxByID(driver,"LastName",lastName);

        log.info("Register - Step 02 : Enter to Email textbox with value is" + firstName);
        registerPage.inputToTextBoxByID(driver,"Email",emailAdress);

        log.info("Register - Step 02 : Enter to Password textbox with value is" + firstName);
        registerPage.inputToTextBoxByID(driver,"Password",password);

        log.info("Register - Step 02 : Enter to Confirm Password textbox with value is" + firstName);
        registerPage.inputToTextBoxByID(driver,"ConfirmPassword",password);

        log.info("Register - Step 03 : Click to Register button");
        registerPage.clickToRegisterButton();
        log.info("Register - Step 04 : Verify register success message is displayed");

        verifyEquals(registerPage.getSuccessMessage(), "Your registration completed..");
        log.info("Register - Step 05 : Click to logout link");
        homePage.clickToLogoutLink();

    }

    @Test
    public void Login_02_Login() {
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

        verifyEquals(registerPage.getSuccessMessage(), "Your registration completed..");
        log.info("Register - Step 05 : Click to logout link");
        homePage.clickToLogoutLink();

        log.info("Login - Step 01 : Navigate to Login page");
        loginPage = homePage.clickToLoginLink();

        log.info("Login - Step 02 : Enter to Email Text box with value is " + validEmail);

        loginPage.inputToEmailTextBox(validEmail);
        loginPage.inputToPasswordTextBox(password);
        log.info("Login - Step 03 : click to login button ");

        homePage = loginPage.clickToLoginButton();

        log.info("Login - Step 04 : verify My account link is displayed");

        verifyFalse(homePage.isMyAccountLinkDisplayed());

        log.info("Login - Step 04 : click to my account link");
        customerInforPage = homePage.clickToMyAccountLink();
        verifyFalse(customerInforPage.isMyAccountPageDisplayed());
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
