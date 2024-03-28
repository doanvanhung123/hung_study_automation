package actions.commons;

import actions.pageObjects.admin.AdminLoginPageObject;
import actions.pageObjects.user.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPagePage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserCustomerInfoObject getUserCustomerInfor(WebDriver driver) {
        return new UserCustomerInfoObject(driver);
    }

    public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
        return new UserAddressPageObject(driver);
    }

    public static UserMyProductReviewPageObject getUserMyProductPage(WebDriver driver) {
        return new UserMyProductReviewPageObject(driver);
    }

    public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
        return new UserRewardPointPageObject(driver);
    }
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }
}
