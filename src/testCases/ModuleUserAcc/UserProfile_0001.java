/**
 * This class contains a method for Global Navigator
 * Created: Mon 29 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/29
 * 
 * @TestCaseID 1157 / 20A
 * @TestArea User Profile
 * @TestScenarioDesc User profile for logged-in user, User profile for cookied-in user
 * @TestStep
 * 
 * 		Reference: Appendix A
 * 		Pre-req: Clear Cache & Cookie on the browse before starting the test.

 * 		1. In GSOL Homepage, click on the "Login" link from any of the following entry point:
 * 		- Global Navigation
 * 		- CPP
 * 		2. Fill in "E-mail Address (or Username)" and "Password" field and click on "Login Now" button.
 * 		3. From any of the entry points in Appendix A, click on the "User Profile" link on Global Nav.
 * 		4. Close all the windows under the same browser without logging out.
 * 		5. Launch a window using the same browser again.
 * 		6. Go to GSOL homepage.
 * 		7. Click on the "User Profile" link on Global Nav.
 * 		8. Fill in "E-mail Address (or Username)" and "Password" field and click on "Login Now" button.
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
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
import pageObjects.LogIn_Page;
import pageObjects.UserProfile_Page;
import testCases.SuiteBase;
import testCases.ModuleUserAcc.SuiteBaseUserAcc;

/**
 * This test case contain method to test User Profile for logged-in and cookied-in user.
 * @author Teng Shyh Wei
 *
 */
public class UserProfile_0001 extends SuiteBaseUserAcc{
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
		FilePath_TestResult = UserProfile_0001_TestResult;
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
	@Test(dataProvider="UserProfile_0001Data")
	public void UserProfile_0001Test(String dataTestCaseName, 
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
			
			// 1. In GSOL Homepage, click on the "Login" link from any of the following entry point:
			// - Global Navigation - CPP
			GlobalNav_MenuBar.menuBar_clickGlobalNavigationLogin();
			
			// To verify Login page is displayed.
			LogIn_Page.check_loginPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 2. Fill in "E-mail Address (or Username)" and "Password" field and click on "Login Now" button.
			SignIn_Action.ExecuteFillIn_UsernamePassword_ClickLoginNowBtn(dataUsername, dataPassword);
			
			// To verify User login successfully. GSOL homepage is displayed.
			Home_Page.check_GSOLHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 3. From any of the entry points in Appendix A, click on the "User Profile" link on Global Nav.
			GlobalNav_MenuBar.menuBar_selectUserProfile();
			
			// To verify User Profile page is displayed.
			UserProfile_Page.check_userProfilePageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 4. Close all the windows under the same browser without logging out.			
			// 5. Launch a window using the same browser again.		
			// 6. Go to GSOL homepage.
			driver.close();
			
			ProfilesIni firProfiles = new ProfilesIni();		
			FirefoxProfile wbdrverprofile = firProfiles.getProfile("default");			
			driver = new FirefoxDriver(wbdrverprofile);	
			ExistingmozillaBrowser = driver;
			driver.get(Param.getProperty("globalsourcesURL"));	
			
			// To verify all the windows under the same browser are closed.
			// A window under the same browser is launched.
			// A Cookie-in user GSOL homepage is displayed.
			
			
			// 7. Click on the "User Profile" link on Global Nav.
		//	GlobalNav_MenuBar.menuBar_selectUserProfile();
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));        		
    		WebElement subMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]"
    				+ "//*[contains(text(),'User Profile')]"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		
			// To verify Login page is displayed.
		//	LogIn_Page.check_loginPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		String loginPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginForm_tit')]")).getText();
    		String expectedTitle = "Login for access to all your Global Sources services";
    		Add_Log.info("Page title ::" + loginPageTitle);
    		
            if(loginPageTitle.equals(expectedTitle)){
            	Add_Log.info("GSOL Login page is displayed");
             	SuiteUtility.WriteResultUtility(
             			FilePath_TestResult, TestCaseName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, DataSet+1, Constant.KEYWORD_PASS);
             	
            }else{
             	Add_Log.info("GSOL Login page is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			FilePath_TestResult, TestCaseName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, DataSet+1, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }
			
			// 8. Fill in "E-mail Address (or Username)" and "Password" field and click on "Login Now" button.
		//	SignIn_Action.ExecuteFillIn_UsernamePassword_ClickLoginNowBtn(dataUsername, dataPassword);
        	// Enter text for Username field            	
            driver.findElement(By.name("fld_UserID")).clear();
            driver.findElement(By.name("fld_UserID")).sendKeys(dataUsername);
            
            // Enter text for Password field
            driver.findElement(By.name("fld_UserPassword")).sendKeys(dataPassword);
            
            // Click on the Login Now submit button
            driver.findElement(By.xpath("//*[@value='Login Now']")).click();
            
            
			// To verify User Profile page is displayed.
		//	UserProfile_Page.check_userProfilePageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'pageheader')]"));
    		String userProfileTitle = driver.findElement(By.xpath("//*[contains(@class, 'pageheader')]")).getText();
    		String expectedUserProfileTitle = "User Profile";
    		Add_Log.info("Page title ::" + userProfileTitle);
    		
    		if(userProfileTitle.equals(expectedUserProfileTitle)){
    			Add_Log.info("User Profile page is displayed");
    			SuiteUtility.WriteResultUtility(
    					FilePath_TestResult, TestCaseName, Constant.COL_USER_PROFILE_PAGE_DISPLAYED, DataSet+1, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("User Profile page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					FilePath_TestResult, TestCaseName, Constant.COL_USER_PROFILE_PAGE_DISPLAYED, DataSet+1, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
			
        	// Go back to Home page after each test case completed. 
        	driver.get(Param.getProperty("globalsourcesURL"));
    		Add_Log.info("Go back to Global Sources Homepage after test case completed");
    		driver.manage().deleteAllCookies();	
    		driver.navigate().refresh();
        	
    		
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
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "SKIP");
			SuiteUtility.WriteResultUtility(FilePath_TestResult, TestCaseName, Constant.COL_OVERALL_TEST_CASE_RESULT, DataSet+1, Constant.KEYWORD_SKIP);
		}
		else if(Testfail || testFail.get(0)){
			Add_Log.info(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as FAIL In excel.");
			// To make object reference null after reporting In report.
			s_assert = null;
			// Set TestCasePass = false to report test case as fail In excel sheet.
			TestCasePass=false;	
			// If found Testfail = true, Result will be reported as FAIL against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "FAIL");
			SuiteUtility.WriteResultUtility(FilePath_TestResult, TestCaseName, Constant.COL_OVERALL_TEST_CASE_RESULT, DataSet+1, Constant.KEYWORD_FAIL);
			
		}else{
			Add_Log.info(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as PASS In excel.");
			// If found Testskip = false and Testfail = false, Result will be reported as PASS against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "PASS");			
			SuiteUtility.WriteResultUtility(FilePath_TestResult, TestCaseName, Constant.COL_OVERALL_TEST_CASE_RESULT, DataSet+1, Constant.KEYWORD_PASS);
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
	public Object[][] UserProfile_0001Data(){
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
	//	closeWebBrowser();

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
