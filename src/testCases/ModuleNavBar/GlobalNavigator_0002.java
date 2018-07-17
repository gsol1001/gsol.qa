/**
 * This class contains a method for Global Navigator
 * Created: Wed 24 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/24
 * 
 * @TestCaseID 1159 / 21B
 * @TestArea Global Navigator
 * @TestScenarioDesc Global Nav for non logged-in user
 * @TestStep
 * 
 * 		Reference: Appendix A
 * 		Pre-req: Clear Cache & Cookie on the browse before starting the test.

 * 		1. As a non-logged in user, go to any page in the Appendix A, verify the links in Global Nav.
 * 		2. Click on "Global Sources Home" link at Global Nav.
 * 		3. Repeat Step 1-2 for:
 * 		   a. "Register" link besides the "Suppliers" at Global Nav.
 * 		   b. "Register" link besides the "Buyers" at Global Nav.
 * 		   c. "Login" link at Global Nav.
 * 		   d. "User Profile" link at Global Nav.
 * 		   e. "Inquiry Basket" link at Global Nav.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleNavBar;

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

import appModules.SignIn_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.Home_Page;
import pageObjects.InquiryBasket_Page;
import pageObjects.MessageCenter_Page;
import pageObjects.PA_EditCategories_Page;
import pageObjects.PA_Home_Page;
import pageObjects.SupplierRegistration_Page;
import pageObjects.UserProfile_Page;
import testCases.SuiteBase;
import testCases.ModuleNavBar.SuiteBaseNavBar;

/**
 * Contain method to test Global Nav for logged-in/cookied in user.
 * @author Teng Shyh Wei
 *
 */
public class GlobalNavigator_0002 extends SuiteBaseNavBar{
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
		FilePath = TestCaseListExcel_SuiteNavBar_001_TestData;
		FilePath_TestResult = GlobalNavigator_0002_TestResult;
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
	
	/**
	 * This is the starting of the Main Test. Accepts all column's string data In every Iteration.
	 * 
	 * @param dataTestCaseName
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	@Test(dataProvider="GlobalNavigator_0002Data")
	public void GlobalNavigator_0002Test(String dataTestCaseName,
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
			
			// 1. As a logged in user, go to any page in the Appendix A, verify the links in Global Nav.
			// Login to GSOL 
			SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
						
			// 2. Click on "User Profile" menu at Global Nav.
			GlobalNav_MenuBar.menuBar_selectUserProfile();
			
			// To verify User Profile page is displayed
			UserProfile_Page.check_userProfilePageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			// 3. Repeat Step 1-2 for:
			// a. "My Product Alert" at Global Nav.
			GlobalNav_MenuBar.menuBar_selectMyProductAlert();
			
			// To verify Product Alert page is displayed.
			PA_Home_Page.check_PAHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// b. Mouseover the "My Product Alert" menu, select "Edit Categories" menu at Global Nav.
			GlobalNav_MenuBar.menuBar_selectEditCategories();
			
			// To verify Edit Categories page is displayed.
			PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			// c. "Register as Supplier" at Global Nav
			GlobalNav_MenuBar.menuBar_selectRegisterAsSupplier();
			
			// To verify Registration page for supplier is displayed
			SupplierRegistration_Page.check_suppRegPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			// d. "Message" menu at Global Nav.
			GlobalNav_MenuBar.menuBar_clickMessages().click();
			
			// To verify Message Center homepage is displayed
		//	MessageCenter_Page.check_messageCenterHomePageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			MessageCenter_Page.check_MCEmailVerificationPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			Add_Log.info("Print page URL ::" + driver.getCurrentUrl());
			Add_Log.info("Print page title ::" + driver.getTitle());
			
			// e. "Inquiry Basket" icon at Global Nav.
			GlobalNav_MenuBar.icon_clickInquiryBasketCart().click();
			
			// To verify Inquiry Basket page is displayed. 
			InquiryBasket_Page.check_inqBasketPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// f. "Logout" menu at Global Nav
			GlobalNav_MenuBar.menuBar_clickLogout();
			
			// To verify user logout successfully, GSOL Homepage is displayed.
			Home_Page.check_GSOLHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
	public Object[][] GlobalNavigator_0002Data(){
		// To retrieve data from column of SuiteNavBar data Sheet.
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
