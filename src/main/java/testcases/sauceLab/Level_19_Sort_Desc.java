package testcases.sauceLab;

import actions.commons.BaseTest;
import actions.pageObjects.sauceLab.LoginPageObject;
import actions.pageObjects.sauceLab.PageGeneratorManager;
import actions.pageObjects.sauceLab.ProductPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_19_Sort_Desc extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPage;
    ProductPageObject productPageObject;


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(browserName,url);
        loginPage = PageGeneratorManager.getLoginPageObject(driver);

        loginPage.enterToUserNameTextbox("standard_user");
        loginPage.enterToPasswordTextbox("secret_sauce");
        productPageObject = loginPage.clickLoginButton();
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
//        driver.quit();
    }
}
