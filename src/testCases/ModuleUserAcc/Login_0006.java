/**
 * This class contains a method for Login.
 * Created: Tue 08 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/08
 * 
 * @TestCaseID 2D
 * @TestArea Login
 * @TestScenarioDesc User is able to login when username and password are valid.
 * @TestStep
 * 
 * 		Pre-req: Clear Cache & Cookie on the browse before starting the test.
 * 		
 * 		14. Click on "Magazines" tab in the Top Nav.
 * 		15. Click on the "Login" link in eMag Marketing page.
 * 		16. Fill in "E-mail (or Username)" and "Password" field with valid email and password.
 * 		17. Click on "Login Now" button.
 * 		18. Click on "Logout" button in Global Nav.
 *
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleUserAcc;

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

import appModules.ProductInquiry_Action;
import appModules.SignIn_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.TopNav_MenuBar;
import pageObjects.eMag_Marketing_Page;
import testCases.SuiteBase;
import testCases.ModuleUserAcc.SuiteBaseUserAcc;

/**
 * This test case contain method to test user is able to login when username and password are valid.
 * 
 * @author Teng Shyh Wei
 *
 */
public class Login_0006 extends SuiteBaseUserAcc{
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
		FilePath = TestCaseListExcel_SuiteUserAcc_001_TestData;
		FilePath_TestResult = Login_0006_TestResult;
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
	@Test(dataProvider="Login_0006Data")
	public void Login_0006Test(String dataTestCaseName, 
			String dataSearchKeyword,
			String dataUsername, 
			String dataPassword,
			String dataFirstName) throws Exception{

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
						
			// Enter search keyword by select Products Page Types.
			ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
			
			// 1. Click on "Magazines" tab in the Top Nav.
			TopNav_MenuBar.subMenu_selectMagazines();
			
			// Switch to new window opened
			switchToNewWindowOpened();
			
			// To verify eMag Marketing page is displayed.
			eMag_Marketing_Page.check_eMagMarketingPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 2. Click on the "Login" button in eMag Marketing page.
			GlobalNav_MenuBar.menuBar_clickGlobalNavigationLogin();
			
			// To verify Login page is displayed
			LogIn_Page.check_loginPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 3. Fill in "E-mail (or Username)" and "Password" field with valid email and password.
			SignIn_Action.ExecuteFillIn_UsernamePassword(dataUsername, dataPassword);            
            
			// To verify "E-mail (or Username)" and "Password" fields are filled up.
			LogIn_Page.check_txtbxUsernamePasswordIsEntered(FilePath_TestResult, TestCaseName, DataSet+1, testFail, 
					dataUsername, dataPassword);
			
			
			// 4. Click on "Login Now" button.
			LogIn_Page.btn_clickLoginNow();
			
			// To verify user login successfully. eMag Preferece page is displayed. 
			// To verify "Logout" button is exists under menu User Nav in Global Nav.
			// To verify First/Given Name (FirstName) is displayed in Global Nav.
		//	eMag_Preference_Page.check_eMagPreferencePageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			// Generate mouse hover on User Nav menu bar at Global Navigator.
			GlobalNav_MenuBar.menuBar_mousehoverOnUserNav();
			// To verify Logout are displayed under menu User Nav at Global Navigator
			GlobalNav_MenuBar.check_logoutBtnExistsInGlobalNav(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			GlobalNav_MenuBar.check_firstNameDisplayedInGlobalNav(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataFirstName);
			
			
			// 5. Click on "Logout" button in Global Nav.
			GlobalNav_MenuBar.menuBar_clickLogout();
			
			// To verify user logout successfully. GSOL homepage is displayed. 
			// To verify "Login" button and a buyer "Register" button are exist in Global Nav. 
			// To verify PA upsell and "Subscribe" button are displayed in Get Notified section (Footer).
			Home_Page.check_GSOLHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			GlobalNav_MenuBar.check_loginBtnExistsInGlobalNav(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
	        // Generate mouse hover on Register menu bar at Global Navigator.
			GlobalNav_MenuBar.menuBar_mousehoverOnRegister();
	        // To verify buyer "Register" menu are exist in Global Navigator.
			GlobalNav_MenuBar.check_buyerRegisterBtnExistsInGlobalNav(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			Home_Page.check_PAUpsell_SubsBtn_DisplayedInGetNotifiedSec(FilePath_TestResult, TestCaseName, DataSet+1, testFail);		
					
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
	public Object[][] Login_0006Data(){
		// To retrieve data from column of SuiteUserAcc data Sheet.
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
