/**
 * This class contains a method for Wholesale Drilldown page.
 * Created: Mon 07 Jul 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/07/07
 * 
 * @TestCaseID 35A
 * @TestArea Wholesale Drilldown page
 * @TestScenarioDesc 'Inquire Now' for Verified PPs (Wholesale L1 Drilldown entry point)
 * 
 * @TestStep
 * 
 *     	Pre-req: Login to GSOL using the following information before starting the test:
 *     	Email: autoqa_gsol1007@gmail.com
 *     	password: asdf9876
 *     	
 *     	1. As a logged in user, go to Wholesale L1 Drilldown page.
 *     	2. Select some PPs from Verified PP section
 *     	3. Click on the "Inquiry Now" button within the Verified PP section.
 *     	4. Check the "To:" section of the RFI Form
 *     	5. Fill in all the relevant fields.
 *     	6. Click on the "Contact Supplier Now" button.
 *     
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleWholesale;

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
import appModules.ProductInquiry_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.InquiryForm_Page;
import pageObjects.RFIConfirmation_Page;
import pageObjects.WholesaleDrilldown_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * This test case contain method to test 'Inquire Now' for Verified PPs (Wholesale L1 Drilldown entry point)
 * @author Teng Shyh Wei
 *
 */
public class WholesaleDrilldown_0001 extends SuiteBaseRFI{
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
		FilePath = TestCaseListExcel_SuiteRFI_001_TestData;
		FilePath_TestResult = InqFlowLI1_PdtInq_0001_TestResult;
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
	 * 
	 * @throws Exception  if any exception occurred
	 */
	@BeforeMethod
	public void beforeMethod() throws Exception {
        
		// To Initialize Firefox browser.
		driver = SuiteBase.loadWebBrowser();
		new BaseClass(driver);
		
	}
	
	/**
	 * This is the starting of the Main Test. Accepts all column's String data In every Iteration.
	 */
	@Test(dataProvider="WholesaleDrilldown_0001Data")
	public void WholesaleDrilldown_0001Test(String dataTestCaseName, 
			String dataUsername, 
			String dataPassword, 
			String dataPageTypes, 
			String dataSearchKeyword, 
			String dataSubject, 
			String dataExpOrderQuantity, 
			String dataRequestFor, 
			String dataMessage, 
			String dataInqAllVerUpsell, 
			String dataInqAllUnvUpsell, 
			String dataInqAllRemarks,
			String dataPAUpsell) throws Exception{
			
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

			// Store the current window handle
			String parentHandle = driver.getWindowHandle();
			
			// 1. As a logged in user, go to Wholesale L1 Drilldown page.
			ProductInquiry_Action.ExecuteLoggedIn_EnterSearchKeyword(dataUsername, dataPassword, dataSearchKeyword);
			Home_Page.lnk_clickWholesaleProducts().click();
			
			// Switch to new window opened
			switchToNewWindowOpened();
			
			// To verify user lands on Wholesale L1 Drilldown page.
			WholesaleDrilldown_Page.check_wholesaleL1DrilldownPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Select some PPs from Verified PP section
			WholesaleDrilldown_Page.chkbx_selectMultipleVerPdt();
			
			// To verify PPs from Verified PP section are selected.
			
			
			// 3. Click on the "Inquiry Now" button within the Verified PP section.
			WholesaleDrilldown_Page.btn_clickInqNowForVerPdtAtInqBar().click();
			
			// To verify RFI form is displayed.
			InquiryForm_Page.check_RFIFormIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Store the current window handle
			String inqFormHandle = driver.getWindowHandle();
			
			// 4. Check the "To:" section of the RFI Form
			InquiryForm_Page.lnk_clickToVerifiedSupplier().click();
			
			// Switch to new window opened
			switchToNewWindowOpened();
			
			// To verify the 'To:' section only contains Verified PPs
		//	InquiryForm_Page.check_PPVerSuppIsMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail, suppName);
			
			// Close opened window and switch back to parent window
			switchBackToParentWindow(inqFormHandle);
			
			// 5. Fill in all the relevant fields.
			InquiryForm_Action.ExecuteLI1_PdtInq_InqNow_MulVerPdt_SglCat_Info(dataInqAllVerUpsell, dataInqAllUnvUpsell, 
					dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage, dataPAUpsell);
			
			// To verify all the relevant fields are filled up.
			
			
			// 6. Click on the "Contact Supplier Now" button.
    		InquiryForm_Page.btn_clickContactSupplierNow();
    		
			// To verify RFI confirmation page is displayed.
    		RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
    		// Switch back to parent window
    		switchBackToParentWindow(parentHandle);
    		

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
	 * 
	 * @throws Exception  if any exception occurred
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
	 * 
	 * @return  all column's data
	 */
	@DataProvider
	public Object[][] WholesaleDrilldown_0001Data(){
		// To retrieve data from column of SuiteWholesale data Sheet.
		// Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programmatically when reading test data.
		return SuiteUtility.GetTestDataUtility(FilePath, TestCaseName);
	}			
	
	/**
	 * To close browser and report result as pass or fail for test cases In TestCasesList sheet.
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
