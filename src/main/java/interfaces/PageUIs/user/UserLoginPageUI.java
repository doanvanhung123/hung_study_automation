package interfaces.PageUIs.user;

public class UserLoginPageUI {
    public static final String EMAIL_TEXTBOX= "id=Email";
    public static final String PASSWORD_TEXTBOX= "id=Password";
    public static final String LOGIN_BUTTON= "css=button[class*='login-button']";

    public static final String EMAIL_ERROR_MESSAGE= "css=span[id='Email-error']";
    public static final String UNSUCCESSFULL_ERROR_MESSAGE= "xpath=//div[contains(@class,'validation-summary-errors')]";

}
