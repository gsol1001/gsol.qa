/**
 * This class contains a method for Registration process
 * Created: Wed 17 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/17
 * 
 * @TestCaseID 1007 / 1G
 * @TestArea Registration
 * @TestScenarioDesc User is able to register when Emag=N PA=N Nof=Y
 * @TestStep
 * 
 *     	1. From any of the following entry point to a registration page, click on the register link or register button:
 *     	   - Global Navigation
 *     	   - Login Page
 *     	   - PA Marketing page
 *     	2. Fill up all the mandatory fields.
 *     	3. Make sure all the eMag title checkboxes are unchecked.
 *     	4. Make sure the PA Alert field is blank.
 *     	5. Make sure the Notification checkboxes are checked.
 *     	6. Click on the "Register Now" button.
 *     	7. Go to "User Profile" page.
 *     	8. Click on the "Notifications" link at the left nav.
 *     	9. Click on the "Sourcing Magazines" link at the left nav.
 *     	10. Click on the "Product Alert" link at the left nav.
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

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.PA_AddCategories_Action;
import appModules.ProductAlert_Action;
import appModules.Registration_Action;
import appModules.eMag_Preference_Action;
import appModules.UserProfile_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.BuyerRegistration_Page;
import testCases.SuiteBase;
import testCases.ModuleReg.SuiteBaseReg;

/**
 * This test case contain method to test user is able to register when eMag=N PA=N Nof=Y
 * @author Teng Shyh Wei
 *
 */
public class Registration_0007 extends SuiteBaseReg{
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
		FilePath = TestCaseListExcel_SuiteReg_001_TestData;
		FilePath_TestResult = Registration_0007_TestResult;
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
	@Test(dataProvider="Registration_0007Data")
	public void Registration_0007Test(String dataTestCaseName, 
			String dataBusinessEmail, 
			String dataCreateAPassword,
			String dataReenterPassword, 
			String dataTitle,
			String dataFirstName, 
			String dataLastName, 
			String dataCountryTerritory,
			String dataCompanyName, 
			String dataTelephoneNumber,
			String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL,
			String dataEmagTitle,
			String dataProductKeyword,
			String dataMailAnnouce,
			String dataMailMarketing) throws Exception{

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
			// - Global Navigation, - Login Page, or - PA Marketing page
			GlobalNav_MenuBar.menuBar_selectRegisterForBuyer();
			
			// To verify Registration page is displayed
			BuyerRegistration_Page.check_buyerRegPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Fill up all the mandatory fields.
			// 3. Make sure all the eMag title checkboxes are unchecked.
			// 4. Make sure the PA Alert field is blank.
			// 5. Make sure the Notification checkboxes are checked.
			Registration_Action.ExecuteReg_FillUp_eMag_PA_Notification(dataBusinessEmail, dataCreateAPassword, 
					dataReenterPassword, dataTitle, dataFirstName, dataLastName, dataCountryTerritory, 
					dataCompanyName, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL, 
					dataEmagTitle, dataProductKeyword, dataMailAnnouce, dataMailMarketing);
			
			// To verify all mandatory fields are filled up.
			// To verify eMag title checkboxes are unchecked.
			// To verify PA Alert field is blank.
			// To verify The Notification checkboxes are checked.
			Registration_Action.ExecuteReg_OnlyNotificationChkbxFilledUp(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 6. Click on the "Register Now" button.
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify Select Product Alert Categories page is displayed. There is no suggested categories.
			PA_AddCategories_Action.ExecuteSelPACatPageDisplayed_SuggCatNotAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 7. Go to "User Profile" page.
			// To verify User Profile page is displayed.
			// To verify that the information entered are correct.
			UserProfile_Action.check_userProfilePageDisplayed_InfoEnteredMatched(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataTitle, dataFirstName, dataLastName, 
					dataCompanyName, dataBusinessEmail, dataCountryTerritory, dataTelephoneNumber);
			
			
			// 8. Click on the "Notifications" link at the left nav.
			// To verify Notifications page is displayed
			// To verify that Notifications checkboxes are checked and preferred e-mail format is set to default (HTML).
			UserProfile_Action.check_notificationsPageDisplayed_AllNofChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 9. Click on the "Sourcing Magazines" link at the left nav.
			// To verify eMag Preference page is displayed. 
			// To verify all the eMag titles are not selected.
			eMag_Preference_Action.ExecuteEmagPrefPageDisplayed_AlleMagTitleNotSelected(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 10. Click on the "Product Alert" link at the left nav.
			// To verify PA homepage is displayed.
			// To verify "You currently have no categories selected for Product Alert." statement exists.
			ProductAlert_Action.ExecutePAHomepage_MsgNoSubsPACatIsDisplayed(driver, FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
	public Object[][] Registration_0007Data(){
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
			Add_Log.info(TestCaseName+" : Reporting test case as PASS In excel.");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_PASS);
		}
		else{
			Add_Log.info(TestCaseName+" : Reporting test case as FAIL In excel.");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_FAIL);			
		}
	}
	
}
