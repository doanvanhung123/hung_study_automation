package testcases.user;

import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.admin.AdminLoginPageObject;
import actions.pageObjects.user.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Level_8_Switch_Role extends BaseTest {
    WebDriver driver;
    String emailAdress;
    String firstName, lastName, invalidEmail, notFoundEmail, validEmail, password;
    UserHomePageObject userHomePage;
    UserRegisterPageObject userRegisterPage;
    AdminLoginPageObject adminLoginPage;
    UserLoginPageObject userLoginPage;
    UserCustomerInfoObject userCustomerInfoPage;
    UserAddressPageObject userDddressPage;
    UserMyProductReviewPageObject userMyProductReviewPage;

    UserRewardPointPageObject userRewardPointPage;
    String projectPath = System.getProperty("user.dir");


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        emailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        firstName = "Automation";
        lastName = "FC";
        invalidEmail = "afc@afc.com@.vn";
        validEmail = emailAdress;
        notFoundEmail = "afc" + generateFakeNumber() + "@mail.vn";
        emailAdress = "hh@fc.com";
        password = "123132";


    }

    @Test
    public void Login_01_User() {
      userLoginPage = userHomePage.clickToLoginLink();

      userHomePage = userLoginPage.loginAsUser(emailAdress,password);

      Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void Login_02_Admin() {
        userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
       adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
    }


    public void afterClass() {
        driver.quit();
    }
}
