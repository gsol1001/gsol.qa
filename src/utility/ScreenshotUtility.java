/**
 * Functions related to capture screenshots will be will be created In this class.
 * Created: Wed 21 January 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/22
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testCases.SuiteBase;

/**
 * This class contains method to capture screenshots
 * @author Teng Shyh Wei
 *
 */
public class ScreenshotUtility implements ITestListener{
	
	/**
	 * This method will execute before starting of Test suite.
	 */
	public void onStart(ITestContext tr) {	
		
	}

	/**
	 * This method will execute, Once the Test suite is finished.
	 */
	public void onFinish(ITestContext tr) {
		
	}

	/**
	 * This method will execute only when the test is pass.
	 */
	public void onTestSuccess(ITestResult tr) {
		// If screenShotOnPass = yes, call captureScreenShot.
		if(SuiteBase.Param.getProperty("screenShotOnPass").equalsIgnoreCase("yes"))
		{
			captureScreenShot(tr,"pass");
		}
	}

	/**
	 * This method will execute only on the event of fail test.
	 */
	public void onTestFailure(ITestResult tr) {		
		// If screenShotOnFail = yes, call captureScreenShot.
		if(SuiteBase.Param.getProperty("screenShotOnFail").equalsIgnoreCase("yes"))
		{
			captureScreenShot(tr,"fail");
		}
	}

	/**
	 * This method will execute before the main test start (@Test)
	 */
	public void onTestStart(ITestResult tr) {
		
	}

	/**
	 * This method will execute only if any of the main test(@Test) get skipped
	 */
	public void onTestSkipped(ITestResult tr) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		
	}
	
	/**
	 * Function to capture screenshot.
	 * 
	 * @param result
	 * @param status
	 */
	public void captureScreenShot(ITestResult result, String status){
		
		String destDir = "";
		String passfailMethod = result.getMethod().getRealClass().getSimpleName();
		
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) SuiteBase.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
    	
    	// If status = fail then set folder name "screenshots/Failures"
    	if(status.equalsIgnoreCase("fail")){
    		destDir = "Screenshots/Failures";
    	}
    	// If status = pass then set folder name "screenshots/Success"
    	else if(status.equalsIgnoreCase("pass")){
    		destDir = "Screenshots/Success";
    	}
    	
    	// To create folder to store screenshots
    	new File(destDir).mkdirs();
    	// Set file name with combination of test class name + date time.
    	String destFile = passfailMethod + "_" + dateFormat.format(new Date()) + ".png";
    	
        try {
        	// Store file at destination folder location
     	   	FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch (IOException e) {
             e.printStackTrace();
        }
	}
	
	/**
	 * To capture RFI Confirmation page screen shot.
	 */
	public void captureRFIConfirmationPageScreenShot(){
		
		String destDir = "Screenshots/RFI_Confirmation_Page";
		String fileName = this.getClass().getSimpleName();
		
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) SuiteBase.driver).getScreenshotAs(OutputType.FILE);
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
    	
    	// To create folder to store screenshots
    	new File(destDir).mkdirs();
    	// Set file name with combination of test class name + date time.
    	String destFile = fileName + "_" + dateFormat.format(new Date()) + ".png";
    	
        try {
        	// Store file at destination folder location
     	   	FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch (IOException e) {
             e.printStackTrace();
        }
	}

	
}