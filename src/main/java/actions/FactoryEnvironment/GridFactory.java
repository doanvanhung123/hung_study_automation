package actions.FactoryEnvironment;

import org.openqa.selenium.WebDriver;

public class GridFactory {
    WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String portNumber;
    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }
    public WebDriver createDriver(){
        return driver;
    }
}
