package testcases.user;

import actions.commons.BaseTest;
import actions.commons.PageGeneratorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(actions.commons.MethodListener.class)
public class Level_10_Verify_Assert extends BaseTest {
    WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        driver = getBrowserDriver("chrome","https://www.facebook.com/");
    }

    @Test
    public void TC_01(){
        System.out.println("Assert 01");
        String loginPageUrl = driver.getCurrentUrl();
        verifyEquals(loginPageUrl,"https:://www.facebook.com");

        System.out.println("Assert 02");
        String loginPageTitle = driver.getTitle();
        verifyEquals(loginPageTitle,"asdasd");

        System.out.println("Assert 03");
        verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());

        System.out.println("Assert 04_fail");
        verifyTrue(driver.findElement(By.xpath("//input[@name='login_source']")).isDisplayed());


    }
}