package com.erp.utilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.erp.baseclass.BaseClass;


public class D_Listeners implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/Report.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Ranjan");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        // 🔥 Screenshot logic
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseClass) currentClass).driver;

        try {
            String path = ((BaseClass) currentClass).captureScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}