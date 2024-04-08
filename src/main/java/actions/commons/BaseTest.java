package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected RemoteWebDriver driver;
    private String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserDriver(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (browserName.equalsIgnoreCase("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(GlobalConstants.PORTAL_PAGE_URL);
        driver.manage().window().maximize();
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName,String environmentName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (browserName.equalsIgnoreCase("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get(environmentName);
        driver.manage().window().maximize();
        return driver;
    }

    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9000);
    }

   }
