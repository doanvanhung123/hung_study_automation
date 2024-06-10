package testcases.jquery;

import actions.BaseObjectJquery.uploadFile.HomePageObject;
import actions.BaseObjectJquery.uploadFile.PageGeneratorManager;
import actions.commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_11_Upload_File extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    String uploadFileName = "download.png";
    String javaFileName = "java.png";

    String[] listFileNames = {uploadFileName,javaFileName};
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }
    @Test
    public void Upload_01_OneFile(){
        homePage.uploadMultipleFiles(driver,uploadFileName);
        Assert.assertTrue(homePage.isFileLoadedByName(uploadFileName));
        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileLinkUpLoadedByName(uploadFileName));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(uploadFileName));
    }

    @Test
    public void Upload_02_Multiple(){
        homePage.refreshCurrentPage(driver);
        homePage.uploadMultipleFiles(driver,listFileNames);
        Assert.assertTrue(homePage.isFileLoadedByName(uploadFileName));
        Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileLinkUpLoadedByName(uploadFileName));
        Assert.assertTrue(homePage.isFileLinkUpLoadedByName(javaFileName));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(uploadFileName));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(javaFileName));
    }

//    @AfterClass
//    public void afterClass(){
//        driver.quit();
//    }

}