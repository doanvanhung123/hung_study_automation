package testcases.user;

import actions.commons.BasePage;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_3_Base_Object extends BasePage {
    WebDriver driver;
    String emailAdress;
    String firstName,lastName,password;
    HomePageObject homePage ;
    RegisterPageObject registerPage ;
    String projectPath = System.getProperty("user.dir");

//    @BeforeClass
//    public void beforeClass() {
//        System.setProperty("webdriver.gecko.driver", projectPath + "/src/main/browserDrivers/geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("https://demo.nopcommerce.com/");
//    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        homePage = new HomePageObject(driver);
        registerPage = new RegisterPageObject(driver);
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

    public void afterClass() {
        driver.quit();
    }
}
