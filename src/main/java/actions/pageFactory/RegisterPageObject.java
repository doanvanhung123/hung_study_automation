package actions.pageFactory;

import actions.commons.BasePage;
import actions.commons.BasePageFactory;
import interfaces.PageUIs.RegisterPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordTextbox;
    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;
    @FindBy(xpath = "//span[@id='FirstName-error']")
    private WebElement fisrtNameErrorMessage;
    @FindBy(xpath = "//span[@id='LastName-error']")
    private WebElement lastNameErrorMessage;
    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMessage;
    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrorMesssage;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    private WebElement confirmPasswordErrorMesssage;
    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerSuccessMessage;
    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logoutLink;
    @FindBy(xpath = "//div[contains(@class,'message-error')]//li")
    private WebElement existingEmailErrorMessage;

    public RegisterPageObject( WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
        
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(registerButton);
    }

    public String getErrorMessageAtFisrtnameTextbox() {
        waitForElementVisible(driver,fisrtNameErrorMessage);
        return getElementText(fisrtNameErrorMessage);
    }

    public String getErrorMessageAtLastnameTextbox() {
        waitForElementVisible(driver,lastNameErrorMessage);
        return getElementText(lastNameErrorMessage);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver,emailErrorMessage);
        return getElementText(emailErrorMessage);
    }

    public String getErrorMessageAtPasswordTextbox() {
        waitForElementVisible(driver,passwordErrorMesssage);
        return getElementText(passwordErrorMesssage);
    }

    public String getErrorMessageAtConfirmPasswordTextbox() {
        waitForElementVisible(driver,confirmPasswordErrorMesssage);
        return getElementText(confirmPasswordErrorMesssage);
    }

    public void inputToFistnameTextbox(String firstName) {
        waitForElementVisible(driver,firstNameTextbox);
        sendkeyToElement(firstNameTextbox,firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver,lastNameTextbox);
        sendkeyToElement(lastNameTextbox,lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver,emailTextBox);
        sendkeyToElement(emailTextBox,email);

    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendkeyToElement(passwordTextbox,password);

    }

    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,confirmPasswordTextbox);
        sendkeyToElement(confirmPasswordTextbox,confirmPassword);
    }

    public String getSuccessMessage() {
        return getElementText(registerSuccessMessage);
    }

    public void clickLogoutLink() {
        waitForElementClickable(driver,logoutLink);
        clickToElement(logoutLink);
    }

    public String getErrorExistingEmailMessage() {
        waitForElementVisible(driver,existingEmailErrorMessage);
        return getElementText(existingEmailErrorMessage);
    }
}
