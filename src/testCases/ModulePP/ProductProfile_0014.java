/**
 * This class contains a method for RFS flow (New User) (GSOL PP page entry point)
 * Created: Mon 11 Sep 2017
 * @author Teng Shyh Wei
 * @version 0.1 Date: 2017/09/11
 * 
 * @TestCaseID 39N
 * @TestArea Product Profile
 * @TestScenarioDesc RFS flow (New User) (GSOL PP page entry point)
 * @TestStep
 * 
 * 		1. As a non logged-in user, go to GSOL PP page.
 * 		2. Click on "Request Sample" link.
 * 		3. Fill in all the relevant fields.
 * 		4. Click on the "Continue to Next Step" button.
 * 		5. Fill in the "Password" field with valid password and click on "Send Your Inquiry Now" button.	
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
import appModules.MiniRegistration_Action;
import appModules.ProductInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.MiniRegistration_Page;
import pageObjects.ProductListing_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.RFIConfirmation_Page;
import testCases.SuiteBase;

/**
 * This test case contain method to test RFS flow (New User) (GSOL PP page entry point).
 * @author Teng Shyh Wei
 *
 */
public class ProductProfile_0014 extends SuiteBasePP{
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
		FilePath = TestCaseListExcel_SuitePP_002_TestData;
		FilePath_TestResult = ProductProfile_0014_TestResult;
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
	@Test(dataProvider= "ProductProfile_0014Data")
	public void ProductProfile_0014Test(String dataTestCaseName, 
			String dataSearchKeyword,
			String dataSubject,
			String dataMessage,
			String dataNumOfSamples,
			String dataUOM, 
			String dataSamplePayment, 
			String dataSampleShipment, 
			String dataTitle, 
			String dataFirstName,
			String dataLastName, 
			String dataBusinessEmail, 
			String dataCompName,
			String dataCountryTerritory, 
			String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL,
			String dataRFQUpsell,
			String dataPAUpsell,
			String dataPassword,
			String dataRePassword) throws Exception{
		
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
			
			// 1. As a non logged-in user, go to GSOL PP page.

			// Perform a product keyword search and go to Supplier List tab view.
			ProductInquiry_Action.ExecuteSearchByProducts_GoToSupplierListTab(dataSearchKeyword);
			
			// Get Product Name
			WebElement pdtElement = driver.findElement(By.xpath("(//*[contains(@class, 's_supName')]//a)[position()=1]"));
    		String getPdtName = pdtElement.getText();
    		Add_Log.info("Print supplier name ::" + getPdtName);
			
			// To click on the Rollover Larger image.
			ProductListing_Page.img_clickOnRolloverLargerImage();
			
			// To verify GSOL PP page is displayed.
			ProductProfile_Page.check_GSOLPPpageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getPdtName);
			
			// 2. Click on "Request Sample" link.
			ProductProfile_Page.btn_clickRequestSample();
			
			// To verify RFS form is displayed.
			InquiryForm_Page.check_RFSFormIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// 3. Fill in all the relevant fields.
			InquiryForm_Action.ExecuteRFS_FillInAllTheRelevantFields(dataSubject, dataMessage, dataNumOfSamples, dataUOM, dataSamplePayment, 
					dataSampleShipment, dataTitle, dataFirstName, dataLastName, dataBusinessEmail, dataCompName, dataCountryTerritory, 
					dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL, dataRFQUpsell, dataPAUpsell);
			
			// To verify all the relevant fields are filled up.
			
			// 4. Click on the "Continue to Next Step" button.
			InquiryForm_Page.btn_clickContinueToNextStep().click();
			
			// To verify Mini Registration page is displayed.
			MiniRegistration_Page.check_miniRegistrationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
			// 5. Fill in the "Create a Password" and "Re-enter Password" fields with valid password and click on "Send Your Inquiry Now" button.
			MiniRegistration_Action.ExecuteMiniReg_EnterPassword_ClickSendYourInquiryNow(dataPassword, dataRePassword);
			
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
	public Object[][] ProductProfile_0014Data(){
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
