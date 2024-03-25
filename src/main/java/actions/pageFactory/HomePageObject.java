package actions.pageFactory;

import actions.commons.BasePageFactory;
import interfaces.PageUIs.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePageFactory {
    private WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='ico-register']")
    private WebElement registerLink;

    @FindBy(xpath="//a[@class='ico-login']")
    private WebElement loginLink;

    @FindBy(xpath="//a[@class='ico-account']")
    private WebElement myAccountLink;

    public void clickToRegisterLink() {
        waitForElementClickable(driver,registerLink);
        clickToElement(registerLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,myAccountLink);
        clickToElement(myAccountLink);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver,loginLink);
        clickToElement(loginLink);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver,myAccountLink);
        return isElementDisplayed(myAccountLink);
    }
}
