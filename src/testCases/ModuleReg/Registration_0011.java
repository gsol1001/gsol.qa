/**
 * This class contains a method for Registration process
 * Created: Wed 17 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/17
 * 
 * @TestCaseID 1010 / 1J
 * @TestArea Registration
 * @TestScenarioDesc User is unable to register when email entered is a GSOL registered user. Registration form - fields test
 * @TestStep
 * 
 *     	1. From any of the following entry point to a registration page, click on the register link or register button:
 *     	   - Global Navigation
 *     	   - Login Page
 *     	   - PA Marketing page
 *     	2. Without entering any details, click on the Continue button
 *     	3. In Business Email field, fill in email address which has already registered in GSOL (autoqa_gsol1007@gmail.com).
 *     	4. In the Business Email field, enter an email without the @.
 *     	5. In the Business Email field, enter an email with special character (e.g: #$%).
 *     	6. In Create a Password field, enter a password with special character (e.g: #$%).
 *     	7. In Re-enter Password field, enter a password which is not match with the password entered in Step 8.
 *     	8. In Contact Phone Number (Country Code) field, enter alphabets or special character (e.g: #$%).
 *     	9. In Contact Phone Number (Area Code) field,  enter alphabets or special character (e.g: #$%).
 *     	10. In Contact Phone Number (Telephone Number) field,  enter alphabets or special character (e.g: #$%).
 *     	11. In Contact Phone Number (Ext) field,  enter alphabets or special character (e.g: #$%).
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleReg;

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

import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.BuyerRegistration_Page;
import testCases.SuiteBase;
import testCases.ModuleReg.SuiteBaseReg;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/** 
 * This test case contain method to test user is able to register when email entered is a GSOL registered user.
 * @author Teng Shyh Wei
 *
 */
public class Registration_0011 extends SuiteBaseReg{
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
		FilePath = TestCaseListExcel_SuiteReg_002_TestData;
		FilePath_TestResult = Registration_0011_TestResult;
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
	@Test(dataProvider="Registration_0011Data")
	public void Registration_0011Test(String dataTestCaseName, 
			String dataBusinessEmailRegistered, 
			String dataBusinessEmailWithoutAtSign,
			String dataBusinessEmailWithSymbol,
			String dataPasswordWithSpace,
			String dataPasswordWithNotMatch,
			String dataCountryCodeWithAlphabet,
			String dataAreaCodeWithAlphabet,	
			String dataPhoneNoWithAlphabet,
			String dataPhoneExtWithAlphabet) throws Exception{
			
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
			
        	// 1. From any of the following entry point to a registration page, click on the register link or register button:
			//    - Global Navigation, - Login Page, or - PA Marketing page
			GlobalNav_MenuBar.menuBar_selectRegisterForBuyer();
			
			// To verify Registration page is displayed
			BuyerRegistration_Page.check_buyerRegPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// 2. Without entering any details, click on the Continue button
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify on the mandatory fields (fields with *), the validation message is displayed in a red color box
			BuyerRegistration_Page.check_validationMsgIsDisplayedInRedColor(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			// 3. In Business Email field, fill in email address which has already registered in GSOL (autoqa_gsol1007@gmail.com).
			BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmailRegistered);
			BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(Keys.TAB);			
			
			// To verify message "This e-mail address is already registered. 
			// Please use another e-mail address or login now using this address." is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgBusinessEmailAlrRegistered(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. In the Business Email field, enter an email without the @. (e.g: autoqa_gsol1007gmail.com) 
			BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmailWithoutAtSign);
			BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(Keys.TAB);
			
			// To verify message "Please enter a valid e-mail address. Example: jsun@company.com"  is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgBusinessEmailWithoutAtSign(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			// 5. In the Business Email field, enter an email with special character (e.g: autoqa_g$o!1007@gmail.com).
			BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmailWithSymbol);
			BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(Keys.TAB);
			
			// To verify message "Your e-mail address can contain only characters A-Z a-z 0-9 . @ _ -"  is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgBusinessEmailWithSpecialChar(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// 6. In Create a Password field, enter a password with space (e.g: #$% 9876).
			BuyerRegistration_Page.txtbx_enterCreateAPassword().sendKeys(dataPasswordWithSpace);
			BuyerRegistration_Page.txtbx_enterCreateAPassword().sendKeys(Keys.TAB);
			
			// To verify message "Your password can only contain A-Z, a-z, 0-9 and special characters (such as @, &, ?) with no spaces." 
			// is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgPasswordWithSpace(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 7. In Re-enter Password field, enter a password which is not match with the password entered in Step 8.
			BuyerRegistration_Page.txtbx_enterReenterPassword().sendKeys(dataPasswordWithNotMatch);
			BuyerRegistration_Page.txtbx_enterCreateAPassword().sendKeys(Keys.TAB);
			
			// To verify message "Passwords do not match." is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgPasswordsDoNotMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 8. In Contact Phone Number (Country Code) field, enter alphabets or special character (e.g: #$%).
			BuyerRegistration_Page.txtbx_enterContactNumberCountryCode().clear();
			BuyerRegistration_Page.txtbx_enterContactNumberCountryCode().sendKeys(dataCountryCodeWithAlphabet);
			BuyerRegistration_Page.txtbx_enterContactNumberCountryCode().sendKeys(Keys.TAB);
		
			// To verify message "Please enter only numbers." is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgInvCountryCode(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 9. In Contact Phone Number (Area Code) field, enter alphabets or special character (e.g: #$%).
			BuyerRegistration_Page.txtbx_enterContactNumberAreaCode().sendKeys(dataAreaCodeWithAlphabet);
			BuyerRegistration_Page.txtbx_enterContactNumberAreaCode().sendKeys(Keys.TAB);
		
			// To verify message "Please enter only numbers." is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgInvAreaCode(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
		
			// 10. In Contact Phone Number (Telephone Number) field, enter alphabets or special character (e.g: #$%).
			BuyerRegistration_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(dataPhoneNoWithAlphabet);
		Thread.sleep(3000);	
			BuyerRegistration_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(Keys.TAB);
		
			// To verify message "Please enter only numbers." is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgInvTelephoneNumber(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
		
			// 11. In Contact Phone Number (Ext) field, enter alphabets or special character (e.g: #$%).
			BuyerRegistration_Page.txtbx_enterContactNumberExtNumber().sendKeys(dataPhoneExtWithAlphabet);
			BuyerRegistration_Page.txtbx_enterContactNumberExtNumber().sendKeys(Keys.TAB);
			
			// To verify message "Please enter only numbers." is displayed in a red color box.
			BuyerRegistration_Page.check_errorMsgInvPhoneExt(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
        	
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
	 * 
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
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] Registration_0011Data(){
		// To retrieve data from column of SuiteReg data Sheet.
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
