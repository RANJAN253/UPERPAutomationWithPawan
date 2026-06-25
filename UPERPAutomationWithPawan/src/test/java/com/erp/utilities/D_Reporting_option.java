package com.erp.utilities;
//Listener class  used to generate Extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class D_Reporting_option implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;//specify the location of the report
    public ExtentTest test; // What details should be populated in the report

	
	public void onStart(ITestContext testContext)
	{
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        String repName = "Test-Report-" + timeStamp + ".html";

	        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        extent.setSystemInfo("Host name", "localhost");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User", "Ranjan");

	        sparkReporter.config().setDocumentTitle("Up Forest Test Project");
	        sparkReporter.config().setReportName("Functional Test Automation Report");
	        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
	}
	 public void onTestSuccess(ITestResult tr) {
	        test = extent.createTest(tr.getName());
	        test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	    }
	 public void onTestFailure(ITestResult tr) {
	        test = extent.createTest(tr.getName());
	        test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

	        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";

	        File f = new File(screenshotPath);

	        if (f.exists()) {
	            test.addScreenCaptureFromPath(screenshotPath);
	        }
	 }
	 
	        public void onTestSkipped(ITestResult tr) {
	            test = extent.createTest(tr.getName());
	            test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	        }
	        public void onFinish(ITestContext testContext) {
	            extent.flush();
	        }
}