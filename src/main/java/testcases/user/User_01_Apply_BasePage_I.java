package testcases.user;

import actions.commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User_01_Apply_BasePage_I extends BasePage {
    WebDriver driver;
    String emailAdress;

    BasePage basePage;
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
        basePage = getBasePageObject();
        emailAdress = "afc" +generateFakeNumber() + "@mail.vn";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Register_Empty_Data() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");
        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='Password-error']"),"Password is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");
    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");

        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","HEHE");
        sendkeyToElement(driver,"//input[@id='Email']","hungdoan123");
        sendkeyToElement(driver,"//input[@id='Password']","hungdoan123");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","hungdoan123");

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"),"Wrong email");
    }

    @Test
    public void TC_03_Register_Success() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");
        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","HEHE");
        sendkeyToElement(driver,"//input[@id='Email']",emailAdress);
        sendkeyToElement(driver,"//input[@id='Password']","hungdoan123");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","hungdoan123");

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//div[@class='result']"),"Your registration completed");
//        waitForElementClickable(driver,"//a[@class='ico-logout']");
//        clickToElement(driver,"//a[@class='ico-logout']");
    }

    @Test
    public void TC_04_Register_Existing_Email() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");
        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","HEHE");
        sendkeyToElement(driver,"//input[@id='Email']",emailAdress);
        sendkeyToElement(driver,"//input[@id='Password']","hungdoan123");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","hungdoan123");

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//div[contains(@class,'message-error')]//li"),"The specified email already exists");
    }

    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");
        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","HEHE");
        sendkeyToElement(driver,"//input[@id='Email']",emailAdress);
        sendkeyToElement(driver,"//input[@id='Password']","123");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123");

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//span[@id='Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_06_Register_Invalid_Password() {
        waitForElementClickable(driver,"//a[@class='ico-register']");
        clickToElement(driver,"//a[@class='ico-register']");
        sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        sendkeyToElement(driver,"//input[@id='LastName']","HEHE");
        sendkeyToElement(driver,"//input[@id='Email']",emailAdress);
        sendkeyToElement(driver,"//input[@id='Password']","hunghehe");
        sendkeyToElement(driver,"//input[@id='ConfirmPassword']","hunghehe123213");

        waitForElementClickable(driver,"//button[@id='register-button']");
        clickToElement(driver,"//button[@id='register-button']");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");
    }
    public int generateFakeNumber(){
        Random rand = new Random();
        return rand.nextInt(9000);
    }

    public void afterClass() {
        driver.quit();
    }
}
