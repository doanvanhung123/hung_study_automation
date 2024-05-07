package actions.commons;

import actions.pageObjects.admin.AdminLoginPageObject;
import actions.pageObjects.user.*;
import interfaces.PageUIs.jquery.uploadFIle.BasePageJqueryUploadFileUI;
import interfaces.PageUIs.user.BasePageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;

    public static BasePage getBasePageObject() {
        return new BasePage();
    }


    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("class=")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported!");
        }
        return by;
    }

    //Open url
    public void openPageUrl(WebDriver driver, String url) {
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

    public void refreshCurrentPage(WebDriver driver) {
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

    protected WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    protected List<WebElement> getListWebElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }


    private String getDynamicXpath(String locatorType, String... values) {
        System.out.println("Locator Type Befor = " + locatorType);
        if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
            locatorType = String.format(locatorType, (Object[]) values);
        }
        System.out.println("Value map to locator = " + values.toString());
        System.out.println("Locator Type After = " + locatorType);
        return locatorType;
    }

    protected void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    protected void clickToElement(WebDriver driver, String locator, String... dynamicValues) {
        getWebElement(driver, getDynamicXpath(locator, dynamicValues)).click();
    }

    protected void sendkeyToElement(WebDriver driver, String locator, String textValue) {
        WebElement element = getWebElement(driver, locator);
        element.clear();
        element.sendKeys(textValue);
    }

    protected void sendkeyToElement(WebDriver driver, String locator, String textValue, String... dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(locator, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    protected String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    protected String getElementText(WebDriver driver, String locator, String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locator, dynamicValues)).getText();
    }

    protected void selectItemInDefaultDropdown(WebDriver webDriver, String locator, String itemText) {
        Select select = new Select(getWebElement(webDriver, locator));
        select.selectByValue(itemText);
    }

    protected void selectItemInDefaultDropdown(WebDriver webDriver, String locator, String itemText, String... dynamicText) {
        Select select = new Select(getWebElement(webDriver, getDynamicXpath(locator, dynamicText)));
        select.selectByVisibleText(itemText);
    }

    protected String getSelectedItemDefaultDropdown(WebDriver webDriver, String locator) {
        Select select = new Select(getWebElement(webDriver, locator));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropdownMultiple(WebDriver webDriver, String locator) {
        Select select = new Select(getWebElement(webDriver, locator));
        return select.isMultiple();
    }

    protected void selectItemInCustomDropdown(WebDriver webDriver, String parentXpath, String childXpath, String expectedItem) {
        getWebElement(webDriver, parentXpath).click();
        sleepInSecond(1);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        WebDriverWait explicitWait = new WebDriverWait(webDriver, longTimeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true),item");
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    protected String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    protected String getElementCssValue(WebDriver driver, String locator, String propertyName) {
        return getWebElement(driver, locator).getCssValue(propertyName);
    }

    protected String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    protected int getListElementsSize(WebDriver driver, String locator) {
        return getListWebElement(driver, locator).size();
    }

    protected int getListElementsSize(WebDriver driver, String locator, String... dynamicValues) {
        return getListWebElement(driver, getDynamicXpath(locator, dynamicValues)).size();
    }

    protected void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locator, String... dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(locator, dynamicValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToDefaultCheckBoxRadio(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToDefaultCheckBoxRadio(WebDriver driver, String locator, String dynamicValues) {
        WebElement element = getWebElement(driver, getDynamicXpath(locator, dynamicValues));
        if (element.isSelected()) {
            element.click();
        }
    }

    public void overrideGlobalTimeout(WebDriver driver,long timeOUt){
        driver.manage().timeouts().implicitlyWait(timeOUt, TimeUnit.SECONDS);
    }

    public boolean isElementUndisplayed(WebDriver driver,String locator){
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListWebElement(driver,locator);
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
        if(elements.size() ==0){
            System.out.println("Element not in DOM");
            return true;
        }else if (elements.size() >0 && !elements.get(0).isDisplayed()){
            System.out.println("Element in DOM but not visible");
            return true;
        }else {
            System.out.println("Element not in DOM and visible");
            return false;
        }
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator) {
        try {
            return getWebElement(driver, locator).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicValues) {
        return getWebElement(driver, getDynamicXpath(locator, dynamicValues)).isDisplayed();
    }



    protected boolean isElementDEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    protected void switchToFrameIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getWebElement(driver, locator));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    protected void hoverMouseToElement(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver, locator)).perform();
    }

    protected void pressKeyToElement(WebDriver driver, String locator, Keys key, String... dynamicValue) {
        Actions actions = new Actions(driver);
        actions.sendKeys(getWebElement(driver, locator), key).perform();
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

    protected boolean isImageLoaded(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \\\"undefined\\\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
    }

    protected boolean isImageLoaded(WebDriver driver, String locator, String dynamicValue) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locator, dynamicValue)));
    }

    protected void waitForElementVisible(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForElementVisible(WebDriver driver, String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected void waitForAllElementVisible(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    protected void waitForAllElementVisible(WebDriver driver, String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected void waitForElementInVisible(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForElementUndisplayed(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForElementInVisible(WebDriver driver, String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected void waitForAllElementInVisible(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
    }

    protected void waitForElementClickable(WebDriver driver, String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected void waitForElementClickable(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getWebElement(driver, getDynamicXpath(BasePageJqueryUploadFileUI.UPLOAD_FILE, fileNames)).sendKeys(fullFileName);
    }

    protected void waitForElementPresence(WebDriver driver, String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    // Tối ưu ở bài học lv_7_switch_page
    public UserCustomerInfoObject openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
        return PageGeneratorManager.getUserCustomerInfor(driver);
    }

    public UserAddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
        clickToElement(driver, BasePageUI.ADDRESS_LINK);
        return PageGeneratorManager.getUserAddressPage(driver);
    }

    public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_lINK);
        clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_lINK);
        return PageGeneratorManager.getUserMyProductPage(driver);
    }

    public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
        clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
        return PageGeneratorManager.getUserRewardPointPage(driver);
    }

    //lv_9_get_Dynamic_MyAccount_Page
    public BasePage openPageAtMyAccountPageByName(WebDriver driver, String pageName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
        switch (pageName) {
            case "Customer info":
                return PageGeneratorManager.getUserCustomerInfor(driver);

            case "Addresses":
                return PageGeneratorManager.getUserAddressPage(driver);

            case "My product reviews":
                return PageGeneratorManager.getUserMyProductPage(driver);

            case "Reward points":
                return PageGeneratorManager.getUserRewardPointPage(driver);
            default:
                throw new RuntimeException("Invalid page nam at My Account");

        }
    }


    public void sleepInSecond(int secondNumber) {
        try {
            Thread.sleep(secondNumber * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_USER);
        clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
        clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

}
