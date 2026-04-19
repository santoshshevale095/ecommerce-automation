package PageObjects;

import Resources.ExtendReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.net.httpserver.Authenticator;
import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentTest test;
    ExtentReports extend =  ExtendReporterNG.getReportObject();

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test Pass");

    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
       test = extend.createTest(result.getMethod().getMethodName());
       extentTest.set(test);
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        extentTest.get().fail(result.getThrowable());
        String filepath = new SubmitOrderTest().getScreenshot(result.getMethod().getMethodName());
        extentTest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);



    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);

        extend.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}
