package actions.pageObjects.admin;

import actions.commons.BasePage;
import actions.commons.PageGeneratorManager;
import interfaces.PageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
