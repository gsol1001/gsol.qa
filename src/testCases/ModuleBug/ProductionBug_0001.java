/**
 * This test case contain method to test Supplier Profile
 * Created: Wed 25 May 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/05/25
 * 
 * @TestCaseID 2352
 * @TestArea Supplier Profile
 * @TestScenarioDesc Supplier icon in KWS and Supplier homepage are tally.
 * @TestStep
 * 
 *     	1. As a non-logged in user, perform a product keyword search.
 *      2. Look for Supplier Super Accord Industrial Ltd.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleBug;

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

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.SupplierInquiry_Action;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.SupplierHome_Page;
import pageObjects.SupplierListing_Page;
import testCases.SuiteBase;

/**
 * This test case contain method to test RFI Flow Logged-in user.
 * @author Teng Shyh Wei
 *
 */
public class ProductionBug_0001 extends SuiteBaseBug{
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
		FilePath = TestCaseListExcel_SuiteBug_001_TestData;
		FilePath_TestResult = ProductionBug_0001_TestResult;
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
	@Test(dataProvider="ProductionBug_0001Data")
	public void ProductionBug_0001Test(String dataTestCaseName, 
			String dataPageTypes,
			String dataSuppKeyword,
			String dataProductKeyword) throws Exception{
			
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
			
        	// 1. As a non-logged in user, perform a supplier keyword search.
			SupplierInquiry_Action.ExecuteSearchBySuppliers(dataPageTypes, dataSuppKeyword);
			
			// To verify Supplier KWS page is displayed.
			SupplierListing_Page.check_supplierKWSPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataSuppKeyword);
			
			// Due to Bug#85, move the mouse to temp fixed the issue
			ProductListing_Page.btn_mouseoverToSearchBtn();
			
			// To verify Supplier Service icons in Supplier KWS page are matching.
			SupplierListing_Page.check_supplierServiceIconsAreMatching(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 2. Go to Product KWS page.
		//	ProductInquiry_Action.ExecuteSearchByProducts(dataProductKeyword);			
			Home_Page.drpdwn_selectProductsPageTypes();
			Home_Page.txtbx_clearGSOLSearchField();
			Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataProductKeyword);
			Home_Page.btn_clickKeywordButtonSearch();
				
			// Close Help Tour overlay and click on Supplier List tab
		//	ProductInquiry_Action.ExecuteCloseHelpTourOverlay_ClickOnSuppListTab();
			
			// Close the Help Tour overlay
		//	ProductListing_Page.btn_closeHelpTourOverlay();	
			
			// To verify Product KWS page is displayed.
			ProductListing_Page.check_productKWSPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataProductKeyword);
			
			// To verify Supplier Service icons in Product KWS page are matching.
			ProductListing_Page.check_supplierServiceIconsAreMatching(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
    		// 3. Go to L4 Drilldown page.
		//	ProductListing_Page.lnk_selectSingleCategory().click();
			
			// To verify L4 Drilldown page is displayed.
			// To verify the Supplier icon in L4 Drilldown page are matching with Supplier icon in Step 2.
			
			WebElement element = driver.findElement(By.xpath("(//*[contains(@class, 'supplierTit')])[position()=1]"));
			String getSuppName = element.getText();
			Add_Log.info("Print supplier name ::" + getSuppName);
    		
			// 3. Go to GSOL PP page.
			// To click on the Rollover Larger image to go to GSOL PP page
			ProductListing_Page.img_clickOnRolloverLargerImage();
			
			// To verify Product PP page is displayed.
			ProductProfile_Page.check_GSOLPPpageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);
			
			// To verify the Supplier icon in GSOL PP page are matching.
			// MR#45755 Supplier icon in GSOL PP page are removed.
		//	ProductProfile_Page.check_supplierServiceIconsAreMatching(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			// Due to page optimization, waits for 3 seconds
			Thread.sleep(3000);
    		Add_Log.info("Waits for 3 seconds");
    		
			// Close the Help Tour overlay
		//	ProductListing_Page.btn_closeHelpTourOverlay();	
			
			// 4. Go to Supplier MWS page.
			ProductListing_Page.lnk_clickSupplierNameTitle().click();
			
			// To verify Supplier MWS page is displayed.
			// To verify the Supplier icon in Supplier MWS page are matching with Supplier icon in Step 2.
			SupplierHome_Page.check_suppMWHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);
			
			// To verify Supplier Service icons in Supplier Homepage are matching
			SupplierHome_Page.check_supplierServiceIconsAreMatching(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
	public Object[][] ProductionBug_0001Data(){
		// To retrieve data from column of SuiteRFI data Sheet.
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
		
		// To Copy applog file to backup directory.
		copyApplogFileToDestDir();
		
		// To Copy TestNG report folder to backup directory.
		copyTestngReportFileToDestDir();
		
		// To Copy TestData folder to backup directory.
		copyTestDataFolderToDestDir();
		
		// To Copy TestResult folder to backup directory
		copyTestResultFolderToDestDir();
		
	}
	
}
