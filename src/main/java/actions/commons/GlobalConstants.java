package actions.commons;

import java.io.File;

public class GlobalConstants {

    public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com";
    public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
    public static final String PROJECT_PATH = System.getProperty("user.dir");

    public static final String RESOURCE_FOLDER = PROJECT_PATH + File.separator + "src" + File.separator + "test" + File.separator + "resources";

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "downloadFiles";
    public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "downloadFiles";
    public static final String REPORT_NG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
    public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "extentV2" + File.separator;

    //date base
    public static final String DB_DEV_URL = "32.18.252.185:9860";
    public static final String DB_DEV_USER = "automationfc";
    public static final String DB_DEV_PASS = "P@ssworld1!";

    public static final int SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 10;
    public static final long RETRY_TEST_FAIL = 3;
    public static final String JAVA_VERSION = System.getProperty("java.version");

    public static final String BROWSER_USERNAME = "oauth-doanvanhungcntt-23c16";
    public static final String BROWSER_AUTOMATE_KEY = "27175a45-9d6f-4943-8d80-4e40ae514a65";
//    public static final String BROWSER_SOURCE_LAB_URL = "https://" + BROWSER_USERNAME+ ":"+BROWSER_AUTOMATE_KEY+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static final String BROWSER_SOURCE_LAB_URL = "https://oauth-doanvanhungcntt-23c16:27175a45-9d6f-4943-8d80-4e40ae514a65@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

}
