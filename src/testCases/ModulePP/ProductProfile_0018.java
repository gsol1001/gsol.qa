/**
 * This class contains a method for RFI Form from Floating Window (Login on form)
 * Created: Mon 11 Sep 2017
 * @author Teng Shyh Wei
 * @version 0.1 Date: 2017/09/11
 * 
 * @TestCaseID 39R
 * @TestArea Product Profile
 * @TestScenarioDesc RFI Form from Floating Window (Login on form
 * @TestStep
 * 
 * 		1. As a non-logged user, go to GSOL PP entry point, verify that RFI floating window is available
 * 		2. Click on the RFI floating window.
 * 		3. Fill in some text in the RFI floating window.
 * 		4. Click on the "Continue" button.
 * 		5. Click on the "Login Now" button.
 * 		6. Fill in E-mail and Password and click on "Login Now" button.
 * 		7. Fill in all the relevant fields and click on "Continue to Next Step" button.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModulePP;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.InquiryForm_Action;
import appModules.ProductInquiry_Action;
import appModules.SignIn_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.RFIConfirmation_Page;
import testCases.SuiteBase;

/**
 * This test case contain method to test RFI Form from Floating Window (Login on form)
 * @author Teng Shyh Wei
 *
 */
public class ProductProfile_0018 extends SuiteBasePP{
	Read_XLS FilePath = null;
	Read_XLS FilePath_TestResult = null;
	String SheetName = null;
	String TestCaseName = null;	
	String ToRunColumnNameTestCase = null;
	String ToRunColumnNameTestData = null;
	String TestDataToRun[] = null;
	static boolean TestCasePass = true;	
	static boolean Testskip = false;
	static boolean Testfail = false;
	static int DataSet = -1;
	SoftAssert s_assert = null;
	public WebDriver driver;
	List<Boolean> testFail = Arrays.asList(Boolean.FALSE);
	
	/**
	 * <code>@BeforeTest</code> annotated method will be executed before any @Test annotated method
	 * of those classes which are inside <test> tag in testng.xml file.
	 * 
	 * @throws IOException  if an input or output exception occurred
	 */
	@BeforeTest
	public void checkCaseToRun() throws IOException{
		
		// Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		
		// To set .xls file's path In FilePath Variable.
		FilePath = TestCaseListExcel_SuitePP_003_TestData;
		FilePath_TestResult = ProductProfile_0018_TestResult;
		TestCaseName = this.getClass().getSimpleName();	
		
		// SheetName to check CaseToRun flag against test case.
		SheetName = "TestCasesList";
		
		// Name of column In TestCasesList Excel sheet.
		ToRunColumnNameTestCase = "CaseToRun";
		
		// Name of column In Test Case Data sheets.
		ToRunColumnNameTestData = "DataToRun";
		
		// Bellow given syntax will Insert log In applog.log file.
		Add_Log.info(TestCaseName+" : Execution started.");
		
		// To check test case's CaseToRun = Y or N In related excel sheet.
		// If CaseToRun = N or blank, Test case will skip execution. Else It will be executed.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnNameTestCase, TestCaseName)){
			Add_Log.info(TestCaseName+" : CaseToRun = N for So Skipping Execution.");
			// To report result as skip for test cases In TestCasesList sheet.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_SKIP);
			// To throw skip exception for this test case.
			throw new SkipException(TestCaseName+"'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+TestCaseName);
		}
		
		// To retrieve DataToRun flags of all data set lines from related test data sheet.
		TestDataToRun = SuiteUtility.checkToRunUtilityOfData(FilePath, TestCaseName, ToRunColumnNameTestData);
				
	}
	
	/**
	 * <code>@BeforeMethod</code> annotated will be executed before each and very @Test annotated method.
	 * 
	 * @throws Exception
	 */
	@BeforeMethod
	public void beforeMethod() throws Exception {
        
		// To Initialize Firefox browser.
		driver = SuiteBase.loadWebBrowser();
		new BaseClass(driver);
		
	}
	
	// This is the starting of the Main Test. Accepts all column's String data In every Iteration.
	@Test(dataProvider= "ProductProfile_0018Data")
	public void ProductProfile_0018Test(String dataTestCaseName, 
			String dataSearchKeyword,
			String dataMessage,
			String dataUsername,
			String dataPassword) throws Exception{
		
		DataSet++;
			
		// Created object of testng SoftAssert class.
		s_assert = new SoftAssert();
			
		// If found DataToRun = "N" for data set then execution will be skipped for that data set.
		if(!TestDataToRun[DataSet].equalsIgnoreCase("Y")){	
			Add_Log.info(TestCaseName+" : DataToRun = N for data set line "+(DataSet+1)+" So skipping Its execution.");
			// If DataToRun = "N", Set Testskip=true.
			Testskip=true;
			throw new SkipException("DataToRun for row number "+DataSet+" Is No Or Blank. So Skipping Its Execution.");
		}
			
		// If found DataToRun = "Y" for data set then bellow given lines will be executed.				
		try{
			
			// 1. As a non-logged user, go to GSOL PP entry point, verify that RFI floating window is available

			// Go to GSOL PP page entry point.
			ProductInquiry_Action.ExecuteNonLoggedIn_GSOLPPEntryPoint(dataSearchKeyword);	
    		
			// To verify RFI floating window is displayed at the bottom right hand corner of the browser. 
		    // To verify the text in the RFI floating window is grey-ed out. 
    		ProductProfile_Page.check_RFIFloatingWindowExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		ProductProfile_Page.check_textRFIFloatingWindowIsGray(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
		    
			// 2. Click on the RFI floating window
    		ProductProfile_Page.click_RFIFloatingWindow();
    		
		    // To verify RFI floating window is enlarged.
    		ProductProfile_Page.check_RFIFloatingWindowEnlarged(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 3. Fill in some text in the RFI floating window 
    		ProductProfile_Page.txtbx_enterMessageInRFIFloatingWindow().sendKeys(dataMessage);			
			
			// To verify the text in the RFI floating window become black color.
    		ProductProfile_Page.check_textRFIFloatingWindowIsBlack(FilePath_TestResult, TestCaseName, DataSet+1, testFail);		
			
			// 4. Click on the 'Continue' button
    		ProductProfile_Page.btn_clickContinueAtRFIFloatingWindow().click();
			
			// To verify RFI form is displayed. The text entered in Step 3 are remain in the Message field.
			InquiryForm_Action.check_RFIFormDisplayed_TextEnteredInRFIFloatingWindowRemainUnchanged(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataMessage);
        	
			// 5. To click on "Login Now" button.
			InquiryForm_Page.btn_clickLoginOnFormLoginNow().click();
			
			// To verify Login overlay is displayed.
			InquiryForm_Page.check_loginOverlayIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
			// Identify and switch to the Login frame
        	WebElement iframe = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginFrame')]"));
    		driver.switchTo().frame(iframe);    		
    		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		
			// 6. Fill in E-mail and Password and click on "Login Now" button.
			SignIn_Action.ExecuteLoginOnForm_EnterUsernamePassword_ClickLoginNowBtn(dataUsername, dataPassword);
			
			// To verify RFI form is displayed. Verify that user's contact details are pre-populated. 
			// To verify that the text entered in Step 3 are remain unchanged in the Message field.
			InquiryForm_Action.check_RFIFormDisplayed_TextEnteredInRFIFloatingWindowRemainUnchanged(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataUsername, dataMessage);
			
			// 7. Fill in all the relevant fields and click on "Continue to Next Step" button.
			InquiryForm_Page.btn_clickContactSupplierNow();
			
			// To verify RFI confirmation page is displayed.
			RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
		}catch(Exception e){
			Testfail = true;
			throw (e);
		}
		    		    		 		    	    		  	
		if(Testfail){
			// Test data assertion failure will be reported In testNG reports and It will mark test data, test case and test suite as fail.
			s_assert.assertAll();		
		}
	}
	
	/**
	 * <code>@AfterMethod</code> method will be executed after execution of @Test method every time.
	 * @throws Exception 
	 */
	@AfterMethod
	public void reporterDataResults() throws Exception{		
		if(Testskip){
			Add_Log.info(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as SKIP In excel.");
			// If found Testskip = true, Result will be reported as SKIP against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, Constant.COL_PASS_FAIL_SKIP, DataSet+1, Constant.KEYWORD_SKIP);
			SuiteUtility.WriteResultUtility(
					FilePath_TestResult, TestCaseName, Constant.COL_OVERALL_TEST_CASE_RESULT, DataSet+1, Constant.KEYWORD_SKIP);
		}
		else if((Testfail) || (testFail.get(0))){
			Add_Log.info(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as FAIL In excel.");
			// To make object reference null after reporting In report.
			s_assert = null;
			// Set TestCasePass = false to report test case as fail In excel sheet.
			TestCasePass=false;	
			// If found Testfail = true, Result will be reported as FAIL against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, Constant.COL_PASS_FAIL_SKIP, DataSet+1, Constant.KEYWORD_FAIL);
			SuiteUtility.WriteResultUtility(
					FilePath_TestResult, TestCaseName, Constant.COL_OVERALL_TEST_CASE_RESULT, DataSet+1, Constant.KEYWORD_FAIL);
			
		}else{
			Add_Log.info(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as PASS In excel.");
			// If found Testskip = false and Testfail = false, Result will be reported as PASS against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, Constant.COL_PASS_FAIL_SKIP, DataSet+1, Constant.KEYWORD_PASS);			
			SuiteUtility.WriteResultUtility(
					FilePath_TestResult, TestCaseName, Constant.COL_OVERALL_TEST_CASE_RESULT, DataSet+1, Constant.KEYWORD_PASS);
		}
		// At last make both flags as false for next data set.
		Testskip=false;
		Testfail=false;
		testFail.set(0, false);
	}
	
	/**
	 * To use @DataProvider as a data supplier.
	 * This data provider method will return all column's data one by one In every Iteration.
	 * @return
	 */
	@DataProvider
	public Object[][] ProductProfile_0018Data(){
		// To retrieve data from column of SuiteRFI data Sheet.
		// Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programmatically when reading test data.
		return SuiteUtility.GetTestDataUtility(FilePath, TestCaseName);
	}			
	
	/**
	 * To report result as pass or fail for test cases In TestCasesList sheet.
	 */
	@AfterTest
	public void closeBrowser(){
		// To Close the web browser at the end of test.
		closeWebBrowser();

		if(TestCasePass){
			Add_Log.info(TestCaseName+" : Reporting test case as PASS In excel.");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_PASS);
		}
		else{
			Add_Log.info(TestCaseName+" : Reporting test case as FAIL In excel.");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_FAIL);			
		}
	}
	
}
