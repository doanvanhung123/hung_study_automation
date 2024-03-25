package testcases.user;

import actions.commons.BaseTest;

import actions.pageFactory.HomePageObject;
import actions.pageFactory.LoginPageObject;
import actions.pageFactory.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class Level_5_Page_Factory extends BaseTest {
    WebDriver driver;
    String emailAdress;
    String firstName,lastName,invalidEmail,notFoundEmail,validEmail,password;
    HomePageObject homePage ;
    RegisterPageObject registerPage ;
    LoginPageObject loginPage;
    String projectPath = System.getProperty("user.dir");

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);
        emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        firstName = "Automation";
        lastName = "FC";
        invalidEmail = "afc@afc.com@.vn";
        validEmail = emailAdress;
        notFoundEmail = "afc" + generateFakeNumber() + "@mail.vn";
        password = "123456";
        homePage = new HomePageObject(driver);
        registerPage = new RegisterPageObject(driver);

        System.out.println("Pre-condition:Step 01");
        homePage.clickToRegisterLink();

        registerPage.inputToFistnameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAdress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
    }

    @Test
    public void Login_01_Empty_Data() {
        homePage.clickToLoginLink();
        loginPage = new LoginPageObject(driver);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Please enter your email");

    }

    @Test
    public void Login_02_Invalid_Email() {
        homePage.clickToLoginLink();
        loginPage.inputToEmailTextBox(invalidEmail);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Wrong email");
    }

    @Test
    public void Login_03_Email_Not_Found() {
        homePage.clickToLoginLink();
        loginPage.inputToEmailTextBox(notFoundEmail);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Existing_Email_Empty_Password() {
        homePage.clickToLoginLink();
        loginPage.inputToEmailTextBox(validEmail);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }
    @Test
    public void Login_05_Existing_Email_Incorrect_Password() {
        homePage.clickToLoginLink();
        loginPage.inputToEmailTextBox(validEmail);
        loginPage.inputToPasswordTextBox("654321");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
    @Test
    public void Login_06_Valid_Email_Password() {
        homePage.clickToLoginLink();
        loginPage.inputToEmailTextBox(validEmail);
        loginPage.inputToPasswordTextBox(password);
        loginPage.clickToLoginButton();

        Assert.assertEquals(homePage.isMyAccountLinkDisplayed(),true);
    }

    public int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9000);
    }

    public void afterClass() {
        driver.quit();
    }
}
