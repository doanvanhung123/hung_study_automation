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

public class BasePage {
    private long longTimeout = 30;

    public static BasePage getBasePageObject(){
        return new BasePage();
    }

    private By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    //Open url
    protected void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getPageURl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
        {
            return explicitwait.until(ExpectedConditions.alertIsPresent());
        }
    }

    protected void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    protected void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    protected String getAlertText(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    protected void sendkeyToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    protected void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allWindowsID = driver.getWindowHandles();
        for (String id : allWindowsID) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    protected void switchToWindowByTitle(WebDriver driver, String tabTitle) {
        Set<String> allWindowsID = driver.getWindowHandles();
        for (String id : allWindowsID) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(tabTitle)) {
                break;
            }
        }
    }

    protected void closeAllTabWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindowsID = driver.getWindowHandles();
        for (String id : allWindowsID) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    protected WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }

    protected List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElements(getByXpath(xpathLocator));
    }

    protected void clickToElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    protected void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    protected String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText();
    }

    protected void selectItemInDefaultDropdown(WebDriver webDriver, String xpathLocator, String itemText) {
        Select select = new Select(getWebElement(webDriver, xpathLocator));
        select.selectByValue(itemText);
    }

    protected String getSelectedItemDefaultDropdown(WebDriver webDriver, String xpathLocator) {
        Select select = new Select(getWebElement(webDriver, xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropdownMultiple(WebDriver webDriver, String xpathLocator) {
        Select select = new Select(getWebElement(webDriver, xpathLocator));
        return select.isMultiple();
    }

    protected void selectItemInCustomDropdown(WebDriver webDriver, String parentXpath, String childXpath, String expectedItem) {
        getWebElement(webDriver, parentXpath).click();
        sleepInSecond(1);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        WebDriverWait explicitWait = new WebDriverWait(webDriver, longTimeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true),item");
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return getWebElement(driver, xpathLocator).getAttribute(attributeName);
    }

    protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }

    protected String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    protected int getElementsSize(WebDriver driver, String xpathLocator) {
        return getListWebElement(driver, xpathLocator).size();
    }

    protected void checkToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isDisplayed();
    }

    protected boolean isElementDEnabled(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isSelected();
    }

    protected void switchToFrameIframe(WebDriver driver, String xpathLocator) {
        driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    protected void hoverMouseToElement(WebDriver driver, String xpathLocator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    protected void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].style.backgroundColor = 'red'", element);
    }

    protected void clickToElementByJS(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    protected void scrollToElementByJS(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    protected boolean isImageLoaded(WebDriver driver,String locator){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \\\"undefined\\\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
    }

    protected void waitForElementVisible(WebDriver driver,String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    protected void waitForAllElementVisible(WebDriver driver,String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    protected void waitForElementInVisible(WebDriver driver,String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    protected void waitForAllElementInVisible(WebDriver driver,String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,locator)));
    }

    protected void waitForElementClickable(WebDriver driver,String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    protected void waitForElementPresence(WebDriver driver,String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }

    protected void sleepInSecond(int secondNumber) {
        try {
            Thread.sleep(secondNumber * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
