/**
 * This class contains a method for RFS Form - field test
 * Created: Wed 01 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/01
 * 
 * @TestCaseID 1069 / 11E
 * @TestArea RFS Form
 * @TestScenarioDesc RFS form - fields test
 * @TestStep
 * 
 * 		Pre-req: DO NOT Login to GSOL

 * 		1. Inquire for any products and go to RFS form.
 * 		2. Without entering any details, click on the "Continue to next step" button.
 * 		3. In the Business Email field, enter an email without the @.
 * 		4. In the Business Email field, enter an email with special character (e.g: #$%).
 * 		5. In Contact Phone Number (Country Code) field, enter alphabets or special character (e.g: #$%).
 * 		6. In Contact Phone Number (Area Code) field,  enter alphabets or special character (e.g: #$%).
 * 		7. In Contact Phone Number (Telephone Number) field,  enter alphabets or special character (e.g: #$%).
 * 		8. In Contact Phone Number (Ext) field,  enter alphabets or special character (e.g: #$%).
 * 		9. In Message field, enter less than 20 characters.
 * 		10. Verify all the tip boxes/messages.
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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.ProductInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test RFS form - fields test
 * @author Teng Shyh Wei
 *
 */
public class RFS_Form_0001 extends SuiteBaseRFI{
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
		FilePath = TestCaseListExcel_SuiteRFI_013_TestData;
		FilePath_TestResult = RFS_Form_0001_TestResult;
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
	@Test(dataProvider="RFS_Form_0001Data")
	public void RFS_Form_0001Test(String dataTestCaseName, 
			String dataSearchKeyword, 
			String dataBusinessEmailWithoutAtSign,
			String dataBusinessEmailWithSymbol,
			String dataCountryCodeWithAlphabet,
			String dataAreaCodeWithAlphabet,
			String dataPhoneNoWithAlphabet,
			String dataPhoneExtWithAlphabet,				
			String dataMessage, 
			String dataSubject, 
			String dataExpOrderQuantity, 
			String dataRequestFor, 
			String dataTitle,
			String dataFirstName,
			String dataLastName,	
			String dataBusinessEmail,
			String dataCompName,
			String dataCountry,
			String dataBusinessContact,
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

			// 1. Inquiry for any products and go to RFS form									        										
			ProductInquiry_Action.ExecuteNonLoggedIn_InqSglVerPdt(dataSearchKeyword);
			
			// To verify RFS form is displayed.
			InquiryForm_Page.check_RFSFormIsDisplayed();
			
			// 2. Without entering any details, click on the "Continue to next step" button.
			InquiryForm_Page.btn_clickContinueToNextStep().click();
	
			// To verify on the mandatory fields (fields with *), the validation message is displayed in a red color box.
			InquiryForm_Page.check_validationMsgIsDisplayedInRedColor(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 3. In the Business Email field, enter an email without the @.
			InquiryForm_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmailWithoutAtSign);
			InquiryForm_Page.txtbx_enterBusinessEmail().sendKeys(Keys.TAB);

			// To verify error message for invalid Business Email with at-sign is displayed in a red color box.
			InquiryForm_Page.check_errorMsgBusinessEmailWithoutAtSign(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
		
			// 4. In the Business Email field, enter an email with special character (e.g: #$%).
			InquiryForm_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmailWithSymbol);
			InquiryForm_Page.txtbx_enterBusinessEmail().sendKeys(Keys.TAB);

			// To verify error message for invalid Business Email with special character is available on the page.
			InquiryForm_Page.check_errorMsgBusinessEmailWithSpecialChar(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			

			// 5. In Contact Phone Number (Country Code) field, enter alphabets or special character (e.g: #$%).
			InquiryForm_Page.txtbx_enterContactNumberCountryCode().clear();
			InquiryForm_Page.txtbx_enterContactNumberCountryCode().sendKeys(dataCountryCodeWithAlphabet);
			InquiryForm_Page.txtbx_enterContactNumberCountryCode().sendKeys(Keys.TAB);

			// To verify error message for invalid Country Code is displayed in a red color box
			InquiryForm_Page.check_errorMsgInvCountryCode(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
						
			// 6. In Contact Phone Number (Area Code) field,  enter alphabets or special character (e.g: #$%).
			InquiryForm_Page.txtbx_enterContactNumberAreaCode().sendKeys(dataAreaCodeWithAlphabet);
			InquiryForm_Page.txtbx_enterContactNumberAreaCode().sendKeys(Keys.TAB);

			// To verify error message for invalid Area Code is displayed in a red color box
			InquiryForm_Page.check_errorMsgInvAreaCode(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			
			// 7. In Contact Phone Number (Telephone Number) field,  enter alphabets or special character (e.g: #$%).
			InquiryForm_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(dataPhoneNoWithAlphabet);
			InquiryForm_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(Keys.TAB);	

			// To verify error message for invalid Telephone Number is displayed in a red color box
			InquiryForm_Page.check_errorMsgInvTelephoneNumber(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 8. In Contact Phone Number (Ext) field,  enter alphabets or special character (e.g: #$%).
			InquiryForm_Page.txtbx_enterContactNumberExtNumber().sendKeys(dataPhoneExtWithAlphabet);
			InquiryForm_Page.txtbx_enterContactNumberExtNumber().sendKeys(Keys.TAB);

			// To verify error message for invalid Telephone Ext is displayed in a red color box
			InquiryForm_Page.check_errorMsgInvPhoneExt(FilePath_TestResult, TestCaseName, DataSet+1, testFail);						
			
			
			// 9. In Message field, enter less than 20 characters.
			InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
			InquiryForm_Page.txtbx_enterMessage().sendKeys(Keys.TAB);
			
			// To verify error message for invalid Message field is available on the page.
			InquiryForm_Page.check_errorMsgMessageFieldMin20Char(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			

			// 10. Verify all the tip boxes/messages.
			// To verify all the tip boxes/messages are displayed correctly.
			InquiryForm_Page.check_verifyAllTipBoxesAndMessage(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

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
	public Object[][] RFS_Form_0001Data(){
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
