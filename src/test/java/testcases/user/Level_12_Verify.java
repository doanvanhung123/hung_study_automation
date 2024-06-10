package testcases.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Level_12_Verify extends BaseTest {
    WebDriver driver;
    String emailAdress;
    String firstName, lastName, invalidEmail, notFoundEmail, validEmail, password;
    UserHomePageObject homePage;
    UserRegisterPageObject registerPage;
    UserLoginPageObject loginPage;
    UserCustomerInfoObject customerInforPage;
    UserAddressPageObject addressPage;
    UserMyProductReviewPageObject myProductReviewPage;

    UserRewardPointPageObject rewardPointPage;
    String projectPath = System.getProperty("user.dir");


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
    public void Login_01_Register_Login_My_Account() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.inputToFistnameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAdress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getSuccessMessage(), "Your registration completed...");
        homePage.clickToLogoutLink();
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextBox(validEmail);
        loginPage.inputToPasswordTextBox(password);
        homePage = loginPage.clickToLoginButton();

        verifyFalse(homePage.isMyAccountLinkDisplayed());

        customerInforPage = homePage.clickToMyAccountLink();
        verifyFalse(customerInforPage.isMyAccountPageDisplayed());
    }






    public void afterClass() {
        driver.quit();
    }
}
