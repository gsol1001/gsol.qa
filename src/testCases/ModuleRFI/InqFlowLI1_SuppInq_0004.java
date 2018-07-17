/**
 * This class contains a method for Inquire Now for single unverified  supplier
 * Created: Mon 02 Febuary 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/02/02
 * 
 * @TestCaseID 1138 /15R
 * @TestArea RFI Flow Logged-in User
 * @TestScenarioDesc Supplier Inquiry - Verified, >1 Supp, Inquire Now
 * @TestStep
 * 
 * 		Pre-req: Login to GSOL using following information before starting the test:
 * 		email: autoqa_gsol1001@gmail.com
 * 		password: asdf9876
 * 
 * 		1. As a logged in user, 'inquire now' for single unverified  suppliers and go to RFI form.
 * 		2. Fill in all the relevant fields.
 * 		3. Click on the "Contact Supplier Now" button.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleRFI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.InquiryForm_Action;
import appModules.SignIn_Action;
import appModules.SupplierInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.RFIConfirmation_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test RFI Flow Logged-in user.
 * Supplier Inquiry - Unverified, 1 Supp, Inquire Now.
 * @author Teng Shyh Wei
 *
 */
public class InqFlowLI1_SuppInq_0004 extends SuiteBaseRFI{
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
		FilePath = TestCaseListExcel_SuiteRFI_003_TestData;
		FilePath_TestResult = InqFlowLI1_SuppInq_0004_TestResult;
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
	@Test(dataProvider="InqFlowLI1_SuppInq_0004Data")
	public void InqFlowLI1_SuppInq_0004Test(String dataTestCaseName,
			String dataUsername, 
			String dataPassword, 
			String dataPageTypes, 
			String dataSearchKeyword,
			String dataSubject, 
			String dataMessage) throws Exception{
			
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
			
			// Login to GSOL 
			SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);											
			
			// To capture GSOL after Login screen shot 
		//	captureAfterLoginScreenShot();
			
        	// 1. As a logged in user, 'inquire now' for single unverified supplier and go to RFI form.
			// Enter search keyword by select Suppliers Page Types
            SupplierInquiry_Action.ExecuteSearchBySuppliers(dataPageTypes, dataSearchKeyword);	
    		
			// To capture GSOL Home page screen shot
		//	captureHomePageScreenShot();
			
            // Select single unverified supplier and click 'Inquire Now' button
            SupplierInquiry_Action.ExecuteInqNow_SglUnvSupp();                		
    		
			// To verify RFI Form is displayed.
			InquiryForm_Page.check_RFIFormIsDisplayed();
    		
    		
    		// To verify Inquire All upsell drop-down list is not available on the page.
        	// To check CC Email Address checkbox is not available on the page.
        	// To verify PA upsell checkbox is not available on the page.        	        	        	
        	InquiryForm_Action.check_allDrpdwnChkbxNotExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
        	
			// 2. Fill in all the relevant fields.         	    
    		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);

    		// To capture RFI Inquiry Form page screen shot
    	//	captureInquiryFormPageScreenShot();
    		
    		// 3. Click on "Contact Supplier Now" button
    		InquiryForm_Page.btn_clickContactSupplierNow();
    		
    		// To capture RFI Confirmation page screen shot
    	//	captureRFIConfirmationPageScreenShot();   
    		
    		// To verify is RFI Confirmation page displayed
    		RFIConfirmation_Page.check_isRFIConfirmationPageDisplayed();
    		
    		// To capture RFI Confirmation page screen shot
    	//	captureRFIConfirmationPageScreenShot(); 
    		
    		
    		// To verify only RFI Confirmation Copy and Mini Marketing Box Section Exists.    		
    		// To verify RFI Confirmation Copy Section is available on the page.
    		RFIConfirmation_Page.check_RFIConfirmationCopySectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		                	
    		// To verify Mini Marketing Box section is available on the page.
        	RFIConfirmation_Page.check_miniMarketingBoxSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
        	        	
		}catch(Exception e){
			Testfail = true;
			throw (e);
		}
					    		    		 		    	    		  	
		if(Testfail && testFail.get(0)){
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
	public Object[][] InqFlowLI1_SuppInq_0004Data(){
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
			Add_Log.info(TestCaseName+" : Reporting test case as PASS In excel." + "\n ");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_PASS);
		}
		else{
			Add_Log.info(TestCaseName+" : Reporting test case as FAIL In excel." + "\n ");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_FAIL);			
		}	
	}
	
}
