package actions.commons;

import java.io.File;

public class GlobalConstants {

    public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com";
    public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "uploadFiles";
    public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "downloadFiles";
    public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "downloadFiles";
    public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "downloadFiles";

    //date base
    public static final String DB_DEV_URL = "32.18.252.185:9860";
    public static final String DB_DEV_USER = "automationfc";
    public static final String DB_DEV_PASS = "P@ssworld1!";

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 10;
    public static final long RETRY_TEST_FAIL = 3;

}
