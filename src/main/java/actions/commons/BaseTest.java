package actions.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class BaseTest {
    private WebDriver driver;
    private String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserDriver(String browserName){

        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath + "/src/main/browserDrivers/geckodriver.exe");
            return driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/browserDrivers/chromedriver.exe");
            return driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", projectPath + "/src/main/browserDrivers/msedgedriver.exe");
            return driver = new EdgeDriver();
        }else {
            throw new RuntimeException("Browser name invalid");
        }

    }
}
