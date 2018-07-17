/**
 * This class contains a method to verified Global Nav for logged-in/cookied non SYP user (non DOI-ed user)
 * Created: Mon 06 Mar 2017
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2017/03/06
 * 
 * @TestCaseID 
 * @TestArea Global Nav for logged-in/cookied non SYP user (non DOI-ed user)
 * @TestScenarioDesc Global Nav for logged-in/cookied non SYP user (non DOI-ed user)
 * @TestStep
 * 
 * 		Pre-req: 1. Clear Cache & Cookie on the browser before starting the test.
 * 		2. User has already subscribed to PA
 * 		3. User has not yet DOI
 * 		Email: autoqa_gsol1007@gmail.com
 * 		Password: asdf9876
 * 		
 * 		1. As a logged in user, go to GSOL PP page.
 * 		2. Mouseover the user's menu at Global Navigator.
 * 		3. Under Path + PA Link, verified that DOI message is displayed.
 * 		4. Click on "Resend e-mail" link
 * 		5. Go to Supplier homepage.
 * 		6. Repeat step 2.
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

import appModules.ProductInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.ProductListing_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.SupplierHome_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;
/**
 * This test case contain method to test Global Nav for logged-in/cookied non SYP user (non DOI-ed user)
 * @author Teng Shyh Wei
 *
 */
public class GlobalNavigator_0005 extends SuiteBaseRFI{
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
		FilePath_TestResult = GlobalNavigator_0005_TestResult;
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
	@Test(dataProvider="GlobalNavigator_0005Data")
	public void GlobalNavigator_0005Test(String dataTestCaseName,
			String dataUsername,
			String dataPassword,
			String dataSearchKeyword) throws Exception{
			
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
			// Pre-req: 1. Clear Cache & Cookie on the browser before starting the test.
			// 2. User has already subscribed to PA
			// 3. User has not yet DOI
			
			// 1. Login as non SYP user and non DOI user, go to GSOL PP page.
		//	ProductInquiry_Action.ExecuteLoggedIn_GSOLPPEntryPoint(dataUsername, dataPassword, dataSearchKeyword);
			
			// As a logged in user, enter search keyword and go to Supplier List tab.
			ProductInquiry_Action.ExecuteLoggedIn_GoToSupplierListTab(dataUsername, dataPassword, dataSearchKeyword);
			
			WebElement pdtElement = driver.findElement(By.xpath("(//*[contains(@class, 's_supName')]//a)[position()=1]"));
    		String getPdtName = pdtElement.getText();
    		Add_Log.info("Print supplier name ::" + getPdtName);
    		
			// To click on the Rollover Larger image to go to GSOL PP page
			ProductListing_Page.img_clickOnRolloverLargerImage();
			
			// To verify GSOL PP page is displayed.
			ProductProfile_Page.check_GSOLPPpageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getPdtName);
			
			WebElement suppElement = driver.findElement(By.className("pp_supName"));
			String  getSuppName = suppElement.getText();
			Add_Log.info("Print Supplier name ::" + getSuppName);
			
			// 2. Mouse hover the user's First Name at Global Navigator.
			GlobalNav_MenuBar.menuBar_mousehoverOnUserNav();
			
			// To verify DOI message is displayed.			
			// To verify User Profile, My Product Alert, My Preferred Exhibitors, Register as Supplier and Logout button are displayed.
			GlobalNav_MenuBar.check_DOIMsgExistsInGlobalNav(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			GlobalNav_MenuBar.check_subMenuNonSYPUserAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

			// 3. Under PA Path + PA Link, verified that DOI message is displayed.						
			// To verify DOI reminder message "You're just a step away from receiving e-mail updates! 
			// Activate using the confirmation e-mail sent to you. Resend e-mail." is displayed.
			ProductProfile_Page.check_DOIMsgUnderPALinkIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Under PA Path + PA Link, click on "Resend e-mail" link
			ProductProfile_Page.link_clickResendEmail().click();
			
			// To verify DOI message changed to "The confirmation e-mail has been sent to autoqa_gsolxxxx@gmail.com. 
			// Click on the link in the e-mail to activate." is displayed.
			ProductProfile_Page.check_DOIMsgChangedIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 5. Go to Supplier homepage.
			ProductProfile_Page.lnk_clickSupplierName().click();
			
			// To verify Supplier homepage is displayed.
			SupplierHome_Page.check_suppMWHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);
			
			
			// 6. Repeat step 2.
			GlobalNav_MenuBar.menuBar_mousehoverOnUserNav();
			
			// To verify DOI message is displayed.
			// To verify User Profile, My Product Alert, My Preferred Exhibitors, Register as Supplier and Logout button are displayed.
			GlobalNav_MenuBar.check_DOIMsgExistsInGlobalNav(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			GlobalNav_MenuBar.check_subMenuNonSYPUserAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

			
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
	public Object[][] GlobalNavigator_0005Data(){
		// To retrieve data from column of SuiteRefactor data Sheet.
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
