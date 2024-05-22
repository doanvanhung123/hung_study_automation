package testcases.common;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserLoginPageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Set;


public class Register_New_Account_Cookie extends BaseTest {

    WebDriver driver;
    private String emailAdress,password;

    public static Set<Cookie> loggedCookies;
    UserLoginPageObject loginPage;
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

        homePage.clickToLogoutLink();

        log.info("Login - Step 01 : Navigate to Login page");
        loginPage = homePage.clickToLoginLink();

        log.info("Login - Step 02 : Enter to Email Text box with value is " + emailAdress);

        loginPage.inputToEmailTextBox(emailAdress);
        loginPage.inputToPasswordTextBox(password);

        log.info("Login - Step 03 : click to login button ");
        homePage = loginPage.clickToLoginButton();

        loggedCookies = homePage.getAllCookies(driver);
        for(Cookie cookie:loggedCookies){
            System.out.println("Cookie at Common class: "+ cookie);

        }

    }


    @AfterTest
    public void afterClass() {
        driver.quit();
    }
}
