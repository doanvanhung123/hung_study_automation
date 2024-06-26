package testcases.user;

import actions.commons.BaseTest;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class Level_4_Multiple_Browser extends BaseTest {
    WebDriver driver;
    String emailAdress;
    String firstName,lastName,password;
    UserHomePageObject homePage ;
    UserRegisterPageObject registerPage ;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
    }

    @Test
    public void Register_01_Register_Empty_Data() {
        homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getErrorMessageAtFisrtnameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
    }

    @Test
    public void Register_02_Register_Invalid_Email() {
        homePage.clickToRegisterLink();

        registerPage.inputToFistnameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox("123");
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Register_03_Register_Success() {
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
    public void Register_04_Register_Existing_Email() {
        homePage.clickToRegisterLink();

        registerPage.inputToFistnameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAdress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
    }

    @Test
    public void Register_05_Register_Password_Less_Than_6_Chars() {
        homePage.clickToRegisterLink();

        registerPage.inputToFistnameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAdress);
        registerPage.inputToPasswordTextbox("123");
        registerPage.inputToConfirmPasswordTextbox("123");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_06_Register_Invalid_Password() {
        homePage.clickToRegisterLink();

        registerPage.inputToFistnameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAdress);
        registerPage.inputToPasswordTextbox("123");
        registerPage.inputToConfirmPasswordTextbox("123456");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
    }

    public int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9000);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
