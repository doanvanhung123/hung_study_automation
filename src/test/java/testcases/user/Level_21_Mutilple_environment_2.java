package testcases.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.UserHomePageObject;
import actions.pageObjects.user.UserLoginPageObject;
import actions.pageObjects.user.UserRegisterPageObject;
import actions.utilities.Environment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.UserDataMapper;

public class Level_21_Mutilple_environment_2 extends BaseTest {
//    UserDataMapper userData;
//    WebDriver driver;
//    String emailAdress;
//    String firstName, lastName,  password,date,month,year;
//    UserHomePageObject homePage;
//    UserRegisterPageObject registerPage;
//    UserLoginPageObject loginPage;
//    Environment env;
//    @Parameters({"browser","environment"})
//    @BeforeClass
//    public void beforeClass(String browserName,String environmentName) {
//        ConfigFactory.setProperty("env",environmentName);
//        env = ConfigFactory.create(Environment.class);
//        log.info("Test log");
//        driver = getBrowserDriver(browserName,env.appUrl());
//        homePage = PageGeneratorManager.getUserHomePage(driver);
//        userData = UserDataMapper.getUserData();
////        emailAdress = UserData.EMAIL + generateFakeNumber() + "@mail.vn";
////        firstName = UserData.FIRSt_NAME;
////        lastName = UserData.LAST_NAME;
////        password = UserData.PASSWORD;
////        date = UserData.DATE;
////        month = UserData.MONTH;
////        year = UserData.YEAR;
//
//        emailAdress = userData.getEmail() + generateFakeNumber() + "@mail.vn";
//        firstName = userData.getFirstName();
//        lastName = userData.getLastName();
//        password = userData.getPassword();
//        date = userData.getDate();
//        month = userData.getMonth();
//        year = userData.getYear();
//
//    }
//
//    @Test
//    public void Login_01_Register_Login_My_Account() {
//        log.info("Register - Step 01: Navigate to Register page");
//        registerPage = homePage.clickToRegisterLink();
//
//        log.info("Register - Step 01: Select gender");
//        registerPage.clickToRadioButtonByLabel(driver,"Female");
//
//
//        log.info("Register - Step 02 : Enter to Firtname textbox with value is" + firstName);
//        registerPage.inputToTextBoxByID(driver,"FirstName",firstName);
//
//        log.info("Register - Step 02 : Enter to lastName textbox with value is" + firstName);
//        registerPage.inputToTextBoxByID(driver,"LastName",lastName);
//
//        registerPage.selectToDropdownByName(driver,"DateOfBirthDay",date);
//        registerPage.selectToDropdownByName(driver,"DateOfBirthMonth",month);
//        registerPage.selectToDropdownByName(driver,"DateOfBirthYear",year);
//
//        log.info("Register - Step 02 : Enter to Email textbox with value is" + firstName);
//        registerPage.inputToTextBoxByID(driver,"Email",emailAdress);
//
//        log.info("Register - Step 01: Select checkbox");
//        registerPage.clickToCheckBoxByLabel(driver,"Newsletter");
//
//        log.info("Register - Step 02 : Enter to Password textbox with value is" + firstName);
//        registerPage.inputToTextBoxByID(driver,"Password",password);
//
//        log.info("Register - Step 02 : Enter to Confirm Password textbox with value is" + firstName);
//        registerPage.inputToTextBoxByID(driver,"ConfirmPassword",password);
//
//        log.info("Register - Step 03 : Click to Register button");
//        registerPage.clickToButtonByText(driver,"Register");
//
//        log.info("Register - Step 04 : Verify register success message is displayed");
//        verifyEquals(registerPage.getSuccessMessage(), "Your registration completed");
//    }
//
//    @Test
//    public void Login_02_Login() {
//        log.info("Register - Step 05 : Click to logout link");
//        homePage = registerPage.clickLogoutLink();
//
//        log.info("Login - Step 01 : Navigate to Login page");
//        loginPage = homePage.clickToLoginLink();
//        loginPage = PageGeneratorManager.getUserLoginPagePage(driver);
//
//        log.info("Login - Step 02 : Enter to Email Text box with value is " + emailAdress);
//        loginPage.inputToTextBoxByID(driver,"Email",emailAdress);
//
//        log.info("Login - Step 02 : Enter to Password Text box with value is " + password);
//        loginPage.inputToTextBoxByID(driver,"Password",password);
//
//
//        log.info("Login - Step 03 : click to login button ");
//        loginPage.clickToButtonByText(driver,"Log in");
//        homePage = PageGeneratorManager.getUserHomePage(driver);
//
//        log.info("Login - Step 04 : verify My account link is displayed");
//        verifyTrue(homePage.isMyAccountLinkDisplayed());
//    }

//    @Test
//    public void User_03_My_Account(){
//        log.info("Login - Step 05 : click to my account link");
//        customerInforPage = homePage.clickToMyAccountLink();
//
//        verifyTrue(customerInforPage.isMyAccountPageDisplayed());
//
//        log.info("Login - Step 05 : verify fisrtname");
//
//        Assert.assertEquals(firstName,customerInforPage.getTextboxValueByID(driver,"FirstName"));
//
//        Assert.assertEquals(lastName,customerInforPage.getTextboxValueByID(driver,"LastName"));
//
//        Assert.assertEquals(emailAdress,customerInforPage.getTextboxValueByID(driver,"Email"));
//
//
//    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
