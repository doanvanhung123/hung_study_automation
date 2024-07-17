package actions.pageObjects.sauceLab;

import actions.commons.BasePage;
import interfaces.PageUIs.sauceLab.ProductPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductPageObject extends BasePage {
    WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInProductSortDropDown(String item) {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, item);
    }

    public boolean isProductNameSortByAscending() {
        List<String> productUIList = new ArrayList<>();

        List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

        for (WebElement element : elements) {
            productUIList.add(element.getText());
        }

        List<String> productSortList = new ArrayList<>(productUIList);
        Collections.sort(productSortList);
        return productSortList.equals(productUIList);
    }

    public boolean isProductNameSortBydDescending() {
        List<String> productUIList = new ArrayList<>();

        List<WebElement> elements = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

        for (WebElement element : elements) {
            productUIList.add(element.getText());
        }

        List<String> productSortList = new ArrayList<>(productUIList);
        Collections.sort(productSortList);
        Collections.reverse(productSortList);
        return productSortList.equals(productUIList);
    }
}
