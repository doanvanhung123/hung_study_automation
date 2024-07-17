package actions.commons;

import actions.FactoryEnvironment.EnvironmentList;
import actions.FactoryEnvironment.GridFactory;
import actions.FactoryEnvironment.LocalFactory;
import actions.FactoryEnvironment.SouceLabFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected final Logger log;

    @BeforeSuite
    public void initBeforSuite() {
        deleteAllAllureReport();
    }

    protected BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    @BeforeSuite
    public void deleteAllAllureReport() {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + "allure-json";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected WebDriver getBrowserDriver(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH + "firefoxLog.txt");
            driver.set(new FirefoxDriver());
        }
        if (browserName.equalsIgnoreCase("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("chrome")) {
//            File file = new File(GlobalConstants.PROJECT_PATH + "\\file.crx");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=vn");
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            prefs.put("profile.default_content_setting.popups", 0);
            prefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE_FOLDER);
            options.setExperimentalOption("prefs", prefs);
//            options.addExtensions(file);
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(options);

            driver.set(new ChromeDriver());

        } else if (browserName.equalsIgnoreCase("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        } else {
            throw new RuntimeException("Browser name invalid");
        }
        driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.get().get(GlobalConstants.PORTAL_PAGE_URL);
        driver.get().manage().window().maximize();
        return driver.get();
    }

    protected WebDriver getBrowserDriver(String browserName,String appUrl, String environmentName,String ipAdress,String portNumber,String osName,String osVersion) {
        switch (environmentName){
            case "local":
                driver.set(new LocalFactory(browserName).createDriver());
                break;
            case "grid":
                driver.set(new GridFactory(browserName,ipAdress,portNumber).createDriver());
                break;
            case "browserStack":
                driver.set(new LocalFactory(browserName).createDriver());
                break;
            case "soucelab":
                driver.set(new SouceLabFactory(browserName,"Windows 10").createDriver());
                break;
            default:
                driver.set(new LocalFactory(browserName).createDriver());
                break;
        }
        driver.get().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        if(appUrl!="dev") {
            driver.get().get(appUrl);
        }else {
            driver.get().get(getEnvironmentUrl(appUrl));
        }

        driver.get().manage().window().maximize();
        return driver.get();
    }

    protected String getEnvironmentUrl(String environmentName) {
        EnvironmentList env = EnvironmentList.valueOf(environmentName.toUpperCase());
        if(env== EnvironmentList.DEV){
            return "https://demo.nopcommerce.com";
        }else if(env== EnvironmentList.TESTING){
            return "https://demo.nopcommerce.com";
        }else if(env== EnvironmentList.STAGING){
            return "https://demo.nopcommerce.com";
        }else if(env== EnvironmentList.PRODUCTION){
            return "https://demo.nopcommerce.com";
        }
        return null;
    }


    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.get().toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.get().manage().deleteAllCookies();
                driver.get().quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();

                driver.remove();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9000);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            System.out.println(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            System.out.println(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }


    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            System.out.println(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public WebDriver getDriverInstance() {
        return driver.get();
    }

    public void sleepInSecond(int time) {
        try {
            Thread.sleep(time *1000);
        }catch (Exception e){

        }

    }

}
