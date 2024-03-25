package actions.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class BasePageFactory {
    private long longTimeout = 30;

    public static BasePage getBasePageObject(){
        return new BasePage();
    }

    protected void waitForElementVisible(WebDriver driver,WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForAllElementVisible(WebDriver driver,List<WebElement> elements){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForElementInVisible(WebDriver driver,WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForAllElementInVisible(WebDriver driver,List<WebElement> elements){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    protected void waitForElementClickable(WebDriver driver,WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickToElement(WebElement element) {
        element.click();
    }

    protected void sendkeyToElement(WebElement element, String textValue) {
        element.clear();
        element.sendKeys(textValue);
    }

    protected String getElementText(WebElement element) {
        return element.getText();
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }


}
