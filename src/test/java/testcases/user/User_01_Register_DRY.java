package testcases.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User_01_Register_DRY {
    WebDriver driver;
    String emailAdress;
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
        emailAdress = "afc" +generateFakeNumber() + "@mail.vn";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Register_Empty_Data() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),"First name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),"Last name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),"Email is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),"Password is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),"Password is required.");
    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hung doan");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("HEHE");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("hungdoan123");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("hungdoan123");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("hungdoan123");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),"Wrong email");
    }

    @Test
    public void TC_03_Register_Success() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hung doan");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("HEHE");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys("hungdoan123");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("hungdoan123");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
    }

    @Test
    public void TC_04_Register_Existing_Email() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hung doan");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("HEHE");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys("hungdoan123");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("hungdoan123");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("//div[contains(@class,'message-error')]//li")).getText(),"The specified email already exists");
    }

    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hung doan");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("HEHE");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");


        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(),"Password must meet the following rules:\n" +"must have at least 6 characters");
    }

    @Test
    public void TC_06_Register_Invalid_Password() {
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("hung doan");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("HEHE");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("hungdoan@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),"The password and confirmation password do not match.");

    }
    public int generateFakeNumber(){
        Random rand = new Random();
        return rand.nextInt(9000);
    }

    public void afterClass() {
        driver.quit();
    }
}
