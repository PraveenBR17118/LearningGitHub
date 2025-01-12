package com.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orange.hrm.test.BaseTest;

public class ExtentReportUtils 
{
	
	
	/*
	 * ExtentTest Object is required to create a Test
	 */
	public static ExtentTest test;

	/*
	 * ExtentReport object is required to create a report.
	 */
	public static ExtentReports report;
	
	
	public static ExtentSparkReporter sparkReporter;
	String repName;

	/*
	 * This method is invoked in @BeforeSuite annotation to initialize the report.
	 */
	
	public static void setUpReport() 
	{
		String repName;
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        repName="Test-Report-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/Report/"+ repName);//specify location of the report
        sparkReporter.config().setDocumentTitle("Orange HRM Automation Report"); //Title of the Report
        sparkReporter.config().setReportName("Functional Testing");
        //sparkReporter.config().setReportName("Praveen");
        sparkReporter.config().setTheme(Theme.STANDARD);
		
        
        
		report = new ExtentReports();
		
		report.attachReporter(sparkReporter);
		
		
		report.setSystemInfo("Host name","localhost");
		report.setSystemInfo("Application","Orange HRM");
		report.setSystemInfo("Environemnt","QA");
        report.setSystemInfo("user",System.getProperty("user.name"));

        //String os = context.getCurrentXmlTest().getParameter("os");
        report.setSystemInfo("Operating System","MAC");

        //String browser = context.getCurrentXmlTest().getParameter("browser");
        report.setSystemInfo("browser","Chrome");

	}

	/*
	 * Creates the test case, testName parameter accepts name of the @Test method
	 */
	public static void createTest(String testName) {
		test = report.createTest(testName);
	}

	/*
	 * This method adds the step in each test case. In the parameter you can specify
	 * the Message or step
	 */
	public static void addStep(String stepMessage,String str) 
	{
		if(str == "yes")
		{
			test.info(stepMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreenshot()).build());
		}
		else
		{
			test.info(stepMessage);
		}
		
	}

	

	/*
	 * This method captures the screenshot of application. It is invoked in addStep
	 * method of this class.
	 */
	public static String captureScreenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) BaseTest.driver;

		File file = screenshot.getScreenshotAs(OutputType.FILE);

		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(file);

		} catch (IOException e) {

		}

		String str = Base64.getEncoder().encodeToString(fileContent);
		System.out.println(str);

		return str;
	}
	
	/*
	 * This methods flushes the report. It is invoked at the end of execution.
	 */

	public static void flushReport() {
		report.flush();
	}

}
