/**
 * This class contains a method to test Supplier Alert from Floating Contact section at Supplier AGG homepage (New user)
 * Created: Thu 07 Sep 2017
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2017/09/07
 * 
 * @TestCaseID 41T
 * @TestArea SA
 * @TestScenarioDesc Supplier AGG homepage - Floating Contact section - Follow Me (New user)
 * 
 * @TestStep
 * 
 *     	1. As a non logged-in user, go to Supplier homepage.
 *     	2. Click on the "Follow Me" button at the Floating contact section.
 *     	3. Enter a brand new email address and click on "Send me updates" button.
 *     	4. Fill up all the mandatory fields.
 *     	5. Click on "Register Now" button.
 *     	6. Click on the "View my followed suppliers" link.
 *     
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSP;

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

import pageObjects.BaseClass;
import pageObjects.BuyerRegistration_Page;
import pageObjects.PA_AddCategories_Page;
import pageObjects.SA_Marketing_Page;
import pageObjects.SupplierHome_Page;
import pageObjects.SupplierListing_Page;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.Registration_Action;
import appModules.SupplierAlert_Action;
import appModules.SupplierInquiry_Action;

/**
 * This test case contain method to test Supplier Alert from Floating Contact section at Supplier AGG homepage (New user)
 * @author Teng Shyh Wei
 *
 */
public class SupplierProfile_0020 extends SuiteBaseSP{
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
		FilePath = TestCaseListExcel_SuiteSP_003_TestData;
		FilePath_TestResult = SupplierProfile_0020_TestResult;
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
	 * <code>@BeforeTest</code> annotated will be executed before each and very @test annotated method
	 * @throws Exception
	 */
	@BeforeMethod
	public void beforeMethod() throws Exception {
        
		// To Initialize Firefox browser.
		driver = SuiteBase.loadWebBrowser();
		new BaseClass(driver);
		
	}
	
	// This is the starting of the Main Test. Accepts all column's String data In every Iteration.
	@Test(dataProvider="SupplierProfile_0020Data")
	public void SupplierProfile_0020Test(String dataTestCaseName, 
			String dataSearchKeyword,
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
			// Store the current window handle
			String parentHandle = driver.getWindowHandle();
			
			// 1. As a non logged-in user, go to Supplier homepage.
			// Enter Supplier search keyword.
    		SupplierInquiry_Action.ExecuteSearchBySuppliers(dataSearchKeyword);
    		
			WebElement suppElement = driver.findElement(By.xpath("(//a[contains(@class, 'supplierTit')])[position()=1]"));
    		String getSuppName = suppElement.getText();
    		Add_Log.info("Print supplier name ::" + getSuppName);
    		    		
    		// Click on first Supplier Name Title.
    		SupplierListing_Page.lnk_clickSupplierName().click();
    		
    		// To verify Supplier MW Homepage is displayed.
    		SupplierHome_Page.check_suppMWHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);
    		
    		// In order to view Floating Contact section, scroll to the footer of the page.
    		SupplierHome_Page.scrollToFooterSection();
    		
			// 2. Click on the "Follow Me" button at the Floating contact section.
			SupplierHome_Page.btn_clickFollowMeAtFloatingContactSection().click();
    		
			// Switch to new window opened.
			switchToNewWindowOpened();
			
    		// To verify SA marketing pop-up page is displayed.
    		SA_Marketing_Page.check_SAMarketingPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    					
			// 3. Enter a brand new email address and click on "Send me updates" button.
			SupplierAlert_Action.ExecuteSA_EnterBusinessEmail_ClickSendMeUpdatesBtn(dataBusinessEmail);
			
			// To verify GSOL Registration page is displayed.
			BuyerRegistration_Page.check_buyerRegPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Fill up all the mandatory fields.
			Registration_Action.ExecuteReg_FillUp_eMag_PA_Notification(dataCreateAPassword, dataReenterPassword, dataTitle, 
					dataFirstName, dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber, 
					dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL, dataEmagTitle, dataProductKeyword, dataMailAnnouce, dataMailMarketing);
			
			// To verify all mandatory fields are filled up.
			BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 5. Click on "Register Now" button.
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify PA Select Categories page is displayed.
			PA_AddCategories_Page.check_selPACatPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Switch back to parent window
			switchBackToParentWindow(parentHandle);
			
			// To verify page is refreshed.
			// To verify that the "Follow Me" button in the original page became "(green tick) Following".
			// To verify that the "View my followed suppliers" hyperlink is displayed.
			SupplierHome_Page.check_btnFollowingWithGreenTickExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			SupplierHome_Page.check_lnkViewFollowedSuppExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 6. Click on the "View my followed suppliers" link.
			SupplierHome_Page.lnk_clickViewMyFollowedSuppliers().click();
			
			// To verify SA Edit Suppliers page is displayed. Following's Supplier name is added into Edit Suppliers page.
			SupplierAlert_Action.ExecuteSAEditSuppPage_FollowingSuppAddedToSupplierAlert(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);
		
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
	public Object[][] SupplierProfile_0020Data(){
		// To retrieve data from column of SuiteSA data Sheet.
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
