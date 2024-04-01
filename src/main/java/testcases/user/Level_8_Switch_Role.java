package testcases.user;

import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.admin.AdminDashBoardPageObject;
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
    String userEmailAdress;
    String firstName, lastName, userPassword, adminEmailAddress, adminPassword;
    UserHomePageObject userHomePage;
    AdminLoginPageObject adminLoginPage;
    UserLoginPageObject userLoginPage;
    AdminDashBoardPageObject adminDashBoardPage;
    UserCustomerInfoObject userCustomerInfoPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
//        userEmailAdress = "afc" + generateFakeNumber() + "@mail.vn";
        userEmailAdress = "abcd@fc.com";
        System.out.println(userEmailAdress);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        firstName = "Automation";
        lastName = "FC";
        userPassword = "123123";
        adminEmailAddress = "admin@yourstore.com";
        adminPassword = "admin";
    }

    @Test
    public void Login_01_User_To_Admin() {
        userLoginPage = userHomePage.clickToLoginLink();
        userHomePage = userLoginPage.loginAsUser(userEmailAdress, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        userCustomerInfoPage = userHomePage.clickToMyAccountLink();
        userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);

        userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashBoardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
        Assert.assertTrue(adminDashBoardPage.isDashBoardHeaderDisplayed());

        //DashBoarc click to logout
        adminLoginPage = adminDashBoardPage.clickToLogoutLinkAtAdminPage(driver);
    }

    @Test
    public void Login_02_Admin_To_User() {
        adminLoginPage.openPageUrl(driver,GlobalConstants.PORTAL_PAGE_URL);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        userLoginPage = userHomePage.clickToLoginLink();

        userHomePage = userLoginPage.loginAsUser(userEmailAdress,userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }


//    public void afterClass() {
//        driver.quit();
//    }
}
