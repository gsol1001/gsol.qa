/**
 * This class contains a method for eMag subscription
 * Created: Thu 10 Dec 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/12/10
 * 
 * @TestCaseID 10J
 * @TestArea eMag subscription 
 * @TestScenarioDesc eMag subscription from dynamic pages
 * @TestStep
 *  	
 *     	Pre-req: Login to GSOL using following information before starting the test:
 *     	email: autoqa_gsol1007@gmail.com
 *     	password: asdf9876
 *     
 *     	1. From TP entry point, click on the "Subscribe now" button in the eMag cross Promotion (centrewell) section.
 *     	2. Click on the "More e-magazine titles available" link.
 *     	3. Click on the "Subscribe for print copies" link.
 *     	4. Click on the "Global Sources Magazines" app link
 *     	5. Click on the "Available on the App Store" button.
 *     	6. Click on the "Available on Google Play " button.
 *     
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleeMag;

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
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.ProductListing_Page;
import pageObjects.TopProducts_Page;
import pageObjects.eMag_Marketing_Page;
import pageObjects.eMag_Preference_Page;
import pageObjects.eMag_Subscriptions_Page;
import testCases.SuiteBase;

/**
 * This test case contain method to test eMag subscription from eMag preference page (TP entry point).
 * @author Teng Shyh Wei
 *
 */
public class eMagSubscription_0010 extends SuiteBaseeMag{
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
	 * @BeforeTest annotated method will be executed before any @Test annotated method
	 * of those classes which are inside <test> tag in testng.xml file.
	 * 
	 * @throws IOException
	 */
	@BeforeTest
	public void checkCaseToRun() throws IOException{
		
		// Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		
		// To set .xls file's path In FilePath Variable.
		FilePath = TestCaseListExcel_SuiteeMag_002_TestData;
		FilePath_TestResult = eMagSubscription_0010_TestResult;
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
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName,ToRunColumnNameTestCase,TestCaseName)){
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
	 * @BeforeMethod annotated will be executed before each and very @test annotated method.
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
	@Test(dataProvider="eMagSubscription_0010Data")
	public void eMagSubscription_0010Test(
			String dataTestCaseName,
			String dataUsername,
			String dataPassword,
			String dataSearchKeyword,
			String dataL2Category) throws Exception{

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
			
			// 1. As a logged-in user, from TP entry point, click on the 'Subscribe' button in the eMag cross promotion (centrewell) section.
			ProductInquiry_Action.ExecuteLoggedIn_GoToTPEntryPoint(dataUsername, dataPassword, dataSearchKeyword);
			
			// Switch to new window opened.
			switchToNewWindowOpened();		// 2nd new window opened
			
			// Store the 2nd window handle
			String parentHandle2 = driver.getWindowHandle();
			
			TopProducts_Page.lnk_clickL2CategoryKeyword(dataL2Category).click();
			TopProducts_Page.lnk_clickSubscribeNow().click();
			
			// Switch to new window opened.
			switchToNewWindowOpened();		// 3rd new window opened
							
			// To verify eMag Preference page is displayed.
			eMag_Preference_Page.check_eMagPreferencePageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle2);	// switch back to 2nd window	
			
			
			// 2. Click on the "More e-magazine title available" link.
			ProductListing_Page.lnk_clickMoreEmagTitlesAvailable().click();
			
			// Switch to new window opened.
			switchToNewWindowOpened();		// 3rd new window opened again
			
			// To verify Sourcing Magazine page is displayed.
			eMag_Marketing_Page.check_eMagMarketingPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle2);	// switch back to 2nd window
			
			
			// 3. Click on the "Subscribe for print copies" link.
			ProductListing_Page.lnk_clickSubsPrintCopies().click();
			
			// Switch to new window opened.
			switchToNewWindowOpened();		// 3rd new window opened again 
			
			// To verify eMag Subscription page is displayed.
			eMag_Subscriptions_Page.check_eMagSubscriptionsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle2);	// switch back to 2nd window
			
			
			// 4. Click on the "Global Sources Magazines" app link.
			ProductListing_Page.lnk_clickGSMagazinesApp().click();
			
			// Switch to new window opened.
			switchToNewWindowOpened();		// 3rd new window opened again
			
			// To verify Global Sources Magazines Mobile App page is displayed.
			eMag_Subscriptions_Page.check_GSMagazinesMobileAppPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 5. Click on the "Available on the App Store" button.
			eMag_Subscriptions_Page.btn_clickAvailableOnAppStore().click();
			
			
			// To verify App Store for Global Sources Magazines Mobile App is displayed.
			// 22-Feb-2018 Removed because the page title contain unknown symbol.
		//	eMag_Subscriptions_Page.check_appStoreGSMagazineDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			// 6. Click on the "Available on Google Play" button.
			eMag_Subscriptions_Page.btn_clickAvailableOnGooglePlay().click();
			
			// To verify Google Play for Global Sources Magazines Mobile App is displayed.
			// Removed because the page title contain unknown symbol.
			eMag_Subscriptions_Page.check_googlePlayGSMagazineDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// Switch back to parent window
			switchBackToParentWindow(parentHandle2);	// switch back to 2nd window
			
			// Switch back to parent window
			switchBackToParentWindow(parentHandle);		// switch back to parent window
			
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
	 * @AfterMethod method will be executed after execution of @Test method every time.
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
	public Object[][] eMagSubscription_0010Data(){
		// To retrieve data from column of SuiteEmag data Sheet.
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