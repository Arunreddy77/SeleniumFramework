package Selenium.Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;

public class Listeners extends Baseclass implements ITestListener{
	
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	ExtentReports extent = ExtentReporterNG.getReportObject();
	 @Override
	    public void onTestStart(ITestResult result) {
	       test = extent.createTest(result.getMethod().getMethodName());
	       extentTest.set(test);  //unique thread id when tests run in parallel
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test passed: " + result.getName());
	        //test.log(Status.PASS, "Status Passed");
	        try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	        
	       String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	    
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	extentTest.get().fail(result.getThrowable());
	        try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	        
	       String filepath = null;
		try {
			System.out.println(driver);
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test skipped: " + result.getName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Method called when a test fails but is within the success percentage defined in your TestNG configuration.
	        // You can implement actions to be taken in this scenario.
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Test suite started: " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}
