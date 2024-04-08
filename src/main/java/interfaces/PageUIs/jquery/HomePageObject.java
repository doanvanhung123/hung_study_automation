package interfaces.PageUIs.jquery;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }
}
