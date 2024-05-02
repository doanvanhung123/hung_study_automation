package interfaces.PageUIs.jquery.uploadFIle;

import actions.commons.BasePage;

public class HomePageUI extends BasePage {
    public static final String FILE_NAME_LOADED = "xpath=//p[@class='name' and text()='%s']";
    public static final String START_UPLOAD_BUTTON = "xpath=//td//button[@class='btn btn-primary start']";
    public static final String FILE_NAME_UPLOADED_LINK = "xpath=//a[text()='%s']";
    public static final String FILE_NAME_UPLOADED_IMAGE = "xpath=//a[@title='%s']/img";


}
