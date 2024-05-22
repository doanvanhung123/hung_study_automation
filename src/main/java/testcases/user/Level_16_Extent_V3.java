package testcases.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserCustomerInfoObject;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserLoginPageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Level_16_Extent_V3 extends BaseTest {
    WebDriver driver;
    String emailAdress;
    String firstName, lastName, invalidEmail, notFoundEmail, validEmail, password;
    UserHomePageObject homePage;
    UserRegisterPageObject registerPage;
    UserLoginPageObject loginPage;
    UserCustomerInfoObject customerInforPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);
        emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        firstName = "Automation";
        lastName = "FC";
        invalidEmail = "afc@afc.com@.vn";
        validEmail = emailAdress;
        notFoundEmail = "afc" + generateFakeNumber() + "@mail.vn";
        password = "123456";
    }

    @Test
    public void Login_01_Register_Login_My_Account(Method method) {
        ExtentTestManager.startTest(method.getName(),"Register to system with valid Email and process");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
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
        Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed..");

    }

    @Test
    public void Login_02_Login(Method method) {
        ExtentTestManager.startTest(method.getName(),"Register to system with valid Email and process");
        log.info("Login - Step 0 : Click to logout link");
        homePage.clickToLogoutLink();
        log.info("Login - Step 01 : Navigate to Login page");
        loginPage = homePage.clickToLoginLink();

        log.info("Login - Step 02 : Enter to Email Text box with value is " + validEmail);

        loginPage.inputToEmailTextBox(validEmail);
        loginPage.inputToPasswordTextBox(password);
        log.info("Login - Step 03 : click to login button ");

        homePage = loginPage.clickToLoginButton();

        log.info("Login - Step 04 : verify My account link is displayed");

        Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

        log.info("Login - Step 04 : click to my account link");
        customerInforPage = homePage.clickToMyAccountLink();
        Assert.assertFalse(customerInforPage.isMyAccountPageDisplayed());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
