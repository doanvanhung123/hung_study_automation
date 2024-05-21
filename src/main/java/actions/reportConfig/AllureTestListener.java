package actions.reportConfig;

import actions.commons.BaseTest;
import actions.commons.GlobalConstants;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;
    import java.lang.reflect.Method;

public class AllureTestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        Method method = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        if (method.isAnnotationPresent(Step.class)) {
            Step step = method.getAnnotation(Step.class);
            return step.value();
        }
        return iTestResult.getMethod().getMethodName();
    }

    // Screenshot attachments for Allure
    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public static void saveScreenshotPNG(String testName, WebDriver driver) {
        Allure.addAttachment(testName, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    // Text attachments for Allure
    @Attachment(value = "Text attachment of {0}", type = "text/plain")
    public static void saveTextLog(String message) {
        Allure.addAttachment(message, "");
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriverInstance();
        saveScreenshotPNG(iTestResult.getName(), driver);
//        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }
        // TODO Auto-generated method stub

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        saveTextLog(getTestMethodName(iTestResult) + " passed!");
    }


    }