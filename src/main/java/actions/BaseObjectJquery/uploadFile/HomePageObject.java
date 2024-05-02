package actions.BaseObjectJquery.uploadFile;

import actions.commons.BasePage;
import interfaces.PageUIs.jquery.uploadFIle.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoadedByName(String fileNames) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileNames);
        return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileNames);
    }

    public void clickToStartButton() {
        List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_UPLOAD_BUTTON);

        for(WebElement startButton : startButtons){
            startButton.click();
            sleepInSecond(2);
        }
    }

    public boolean isFileLinkUpLoadedByName(String uploadFileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, uploadFileName);
        return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, uploadFileName);
    }

    public boolean isFileImageUpLoadedByName(String uploadFileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, uploadFileName);
        sleepInSecond(5);
        return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, uploadFileName);
    }
}
