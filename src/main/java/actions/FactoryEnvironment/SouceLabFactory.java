package actions.FactoryEnvironment;

import actions.commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SouceLabFactory {
    WebDriver driver;

    public SouceLabFactory(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;
    }

    private String browserName;
    private String osName;

    public WebDriver createDriver() {
        DesiredCapabilities capabitity = new DesiredCapabilities();
        capabitity.setCapability("platformName",osName);
        capabitity.setCapability("browserName",browserName);
        capabitity.setCapability("browserVersion","latest");
        capabitity.setCapability("name","Run on" + osName + "and" + browserName + "with version lasted");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("screenResolution","1920x1080");
        capabitity.setCapability("souce:options",sauceOptions);
        try{
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSER_SOURCE_LAB_URL),capabitity);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
