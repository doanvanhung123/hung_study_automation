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

public class Level_9_Dynamic_Xpath extends BaseTest {
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

        Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextBox(validEmail);
        loginPage.inputToPasswordTextBox(password);
        homePage = loginPage.clickToLoginButton();

        Assert.assertEquals(homePage.isMyAccountLinkDisplayed(), true);

        customerInforPage = homePage.clickToMyAccountLink();
        Assert.assertTrue(customerInforPage.isMyAccountPageDisplayed());
    }


    @Test
    public void Login_02_Switch_Page() {
        addressPage = customerInforPage.openAddressPage(driver);

        myProductReviewPage = addressPage.openMyProductReviewPage(driver);

        rewardPointPage = myProductReviewPage.openRewardPointPage(driver);

        addressPage = rewardPointPage.openAddressPage(driver);

        rewardPointPage = addressPage.openRewardPointPage(driver);

        myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
    }

    @Test
    public void Login_03_Dynamic_Page_01() {

        rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountPageByName(driver,"Reward points");

        addressPage = (UserAddressPageObject) rewardPointPage.openPageAtMyAccountPageByName(driver,"Addresses");

        rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountPageByName(driver,"Reward points");

        myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountPageByName(driver,"My product reviews");

        customerInforPage = (UserCustomerInfoObject) myProductReviewPage.openPageAtMyAccountPageByName(driver,"Customer info");
    }



    public void afterClass() {
        driver.quit();
    }
}
