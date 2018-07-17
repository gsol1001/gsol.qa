/**
 * This class contains a method for eMag subscription
 * Created: Mon 05 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/05
 * 
 * @TestCaseID 1063 / 10C
 * @TestArea eMag subscription 
 * @TestScenarioDesc eMag subscription from RFI confirmation page
 * @TestStep
 *  	
 *     	Pre-req: Login to GSOL using following information before starting the test:
 *     	email: autoqa_gsol1007@gmail.com
 *     	password: asdf9876

 *     	1. Inquire for any products and go to RFI form.
 *     	2. Fill in the relevant fields and click on the "Contact Supplier Now" button.
 *     	3. Click on the "Subscribe" button in the eMag upsell section
 *     	4. Go to "User Profile" page.
 *     	5. Click on the "Sourcing Magazines" link at the left nav.
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

import org.openqa.selenium.By;
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
import appModules.eMag_Preference_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.InquiryForm_Page;
import pageObjects.RFIConfirmation_Page;
import pageObjects.TopNav_MenuBar;
import pageObjects.UserProfile_Page;
import pageObjects.eMag_Preference_Page;
import testCases.SuiteBase;

/**
 * This test case contain method to test eMag subscription from RFI confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class eMagSubscription_0003 extends SuiteBaseeMag{
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
		FilePath = TestCaseListExcel_SuiteeMag_001_TestData;
		FilePath_TestResult = eMagSubscription_0003_TestResult;
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
	@Test(dataProvider="eMagSubscription_0003Data")
	public void eMagSubscription_0003Test(
			String dataTestCaseName,
			String dataUsername,
			String dataPassword,
			String dataSearchKeyword,
			String dataSubject,
			String dataExpOrderQuantity,
			String dataRequestFor,
			String dataMessage) throws Exception{

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
			
			// As a logged in user, go to eMag Preference page and clean up all subscribed magazines.
			eMag_Preference_Action.ExecuteEmagPrefPage_ClearAllSubsCategory(dataUsername, dataPassword);
			
			// 1. Inquire for any products and go to RFI form.
			ProductInquiry_Action.ExecuteInqSglVerPdt(dataSearchKeyword);
			
			// To verify RFI form is displayed. Verify that user's contact details are pre-populated.
			InquiryForm_Page.check_RFIFormIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryForm_Page.check_userContactDetailsPrepopulated(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataUsername);
			
			// 2. Fill in the relevant fields and click on the "Contact Supplier Now" button.
			InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
			InquiryForm_Page.btn_clickContactSupplierNow();
			
			// To verify RFI confirmation page is displayed. Verify that eMag upsell section is available.
			RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
		//	RFIConfirmation_Page.check_eMagCrosspromoSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Store eMag title subscribed.
		//	String eMagTitleSubs = driver.findElement(By.xpath("//*[contains(@class, 'form_confirmOther RFI_eMag clearfix')]//b")).getText();
		//	Add_Log.info("eMag title added is ::" + eMagTitleSubs);
			
			// 3. Click on the "Subscribe" button in the eMag upsell section
			RFIConfirmation_Page.btn_clickSubscribe().click();
			
			// To verify that "Subscribe" button is replaced by "You are subscribed to this magazine" message.
			RFIConfirmation_Page.check_msgSubsToThisMagExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			String addedEmagTitle = driver.findElement(By.xpath("//*[contains(@class, 'form_confirmOther RFI_eMag clearfix')]/h2/b")).getText();
			Add_Log.info("eMag title added is ::" + addedEmagTitle);
			
			// 4. Go to "User Profile" page.
			TopNav_MenuBar.lnk_backToGSOLHomePage();
			GlobalNav_MenuBar.menuBar_selectUserProfile();
						
			// 5. Click on the "Sourcing Magazines" link at the left nav.
			UserProfile_Page.lnk_clickSideBarSourcingMagazines().click();
			
			// To verify eMag Preference page is displayed. Verify that the eMag title added in Step 3 is displayed in "Magazine(s) Subscribed" section.
			eMag_Preference_Page.check_eMagPreferencePageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			eMag_Preference_Page.check_eMagTitleSelectedIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, addedEmagTitle);
						
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
	public Object[][] eMagSubscription_0003Data(){
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
