package testcases.sauceLab;

import actions.commons.BaseTest;
import actions.pageObjects.sauceLab.LoginPageObject;
import actions.pageObjects.sauceLab.PageGeneratorManager;
import actions.pageObjects.sauceLab.ProductPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Level_19_Sort_Desc extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPage;
    ProductPageObject productPageObject;


    @Parameters({"browser","url","env","ipAddress","portNumber","osName","osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("chrome") String browserName,@Optional("dev") String url,@Optional("local") String env,@Optional("localHost") String ipAddress,@Optional("4444") String portNumber,
        @Optional("Windows 10") String osName,@Optional("latest") String osVersion) {
        driver = getBrowserDriver(browserName,url,env,ipAddress,portNumber,osName,osVersion);
        loginPage = PageGeneratorManager.getLoginPageObject(driver);

        loginPage.enterToUserNameTextbox("standard_user");
        loginPage.enterToPasswordTextbox("secret_sauce");
        productPageObject = loginPage.clickLoginButton();
        log.info("before class successfully");
        System.out.println(String.format("Luồng: %s có độ ưu tiên %d -id %d \n",Thread.currentThread().getName(),Thread.currentThread().getPriority(),Thread.currentThread().getId()));

    }

    @Test
    public void Sort_01_Name() {
        //Ascending
        productPageObject.selectItemInProductSortDropDown("Name (A to Z)");
        Assert.assertTrue(productPageObject.isProductNameSortByAscending());
        sleepInSecond(3);

        //Decending
        productPageObject.selectItemInProductSortDropDown("Name (Z to A)");
        sleepInSecond(3);
        Assert.assertTrue(productPageObject.isProductNameSortBydDescending());


    }

    @Test
    public void Sort_02_Price() {
        //Ascending
        productPageObject.selectItemInProductSortDropDown("Price (low to high)");

        //Decending
        productPageObject.selectItemInProductSortDropDown("Price (high to low)");

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
        log.info("after class successfully");

    }
}
