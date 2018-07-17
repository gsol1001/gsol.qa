/**
 * This class contains a method for RFI Inquire Now
 * Created: Wed 02 Mar 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/03/02
 * 
 * @TestCaseID 35B
 * @TestArea RFI Inquire Now
 * @TestScenarioDesc RFI Inquire Now for Multiple Verified PPs (PA Landing page entry point)
 * @TestStep
 * 
 * 		Pre-req: Login to GSOL using following information before starting the test:
 * 		email: autoqa_gsol1003@gmail.com
 * 		password: asdf9876

 * 		1. As a logged in user, go to PA Landing page.
 * 		2. Select single verified products checkbox.
 * 		3. Click on "Inquire Now" button at top Inquiry Bar.
 * 		4. a. Fill in all the relevant fields.
 * 		   b. Check both Verified and Unverified products Inquire All upsell checkbox.
 * 		   c. Check the PA upsell checkbox.
 * 		5. Click on "Contact Supplier Now" button
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleRFI;

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

import appModules.InquiryForm_Action;
import appModules.ProductAlert_Action;
import appModules.RFIConfirmation_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.InquiryForm_Page;
import pageObjects.PA_EditCategories_Page;
import pageObjects.PA_Landing_Page;
import pageObjects.RFIConfirmation_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test RFI Inquire Now for Single Verified PP (PA Landing page entry point)
 * @author Teng Shyh Wei
 *
 */
public class RFI_PALanding_0002 extends SuiteBaseRFI{
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
		FilePath = TestCaseListExcel_SuiteRFI_015_TestData;
		FilePath_TestResult = RFI_PALanding_0002_TestResult;
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
	@Test(dataProvider="RFI_PALanding_0002Data")
	public void RFI_PALanding_0002Test(String dataTestCaseName, 
			String dataUsername,
			String dataPassword,			
			String dataSubject,
			String dataExpOrderQuantity,
			String dataRequestFor,
			String dataMessage,
			String dataInqAllVerUpsell,
			String dataInqAllUnvUpsell,
			String dataInqAllRemarks,
			String dataPAUpsell) throws Exception{
		
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
						
			// Login to GSOL, clean up all PA categories and add PA categories.
			ProductAlert_Action.ExecuteLoginAction_CleanUpPACategories_AddPACategories(dataUsername, dataPassword);
			
			// Go to PA Edit Categories page.
			GlobalNav_MenuBar.menuBar_selectEditCategories();
			
			WebElement element = driver.findElement(By.xpath("(//*[contains(@class, 'form_remove_catCon')]//a)[position()=1]"));
			String getL4Category = element.getText();
			Add_Log.info("Print Inquired L4 category ::" + getL4Category);
			
			// Click on any of the subscribed categories to go to PA Landing Page.
			PA_EditCategories_Page.lnk_clickSubsCategories().click();
			
			
			// To verify the PA Landing page is displayed.
			PA_Landing_Page.check_PALandingPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Select single verified product checkbox
		//	PA_Landing_Page.chkbx_selectSingleVerPdt().click();
			
			// To verify the verified product checkbox is selected.
		//	PA_Landing_Page.check_ppChkbxIsSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// 3. Click on "Inquire Now" button at Inquiry Bar
			PA_Landing_Page.btn_clickInqNowForVerPdtAtPdtListing().click();
			
			// To verify the RFI form is displayed.
			InquiryForm_Page.check_RFIFormIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. a. Fill in all the relevant fields
			// b. Check both Verified and Unverified products Inquire All upsell checkbox.
			// c. Check the PA upsell checkbox.
			InquiryForm_Action.ExecuteLI1_PdtInq_InqNow_SglVerPdt_SglCat_Info(dataSubject, dataExpOrderQuantity, 
					dataRequestFor, dataMessage, dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks, dataPAUpsell);
			
			// To verify both Verified and Unverified products Inquire All upsell checkbox is checked.
			// To verify the PA upsell checkbox is checked.
			InquiryForm_Action.check_bothInqAll_PAUpsellChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
        	String getSibCategory = driver.findElement(By.xpath(Object.getProperty("siblingCategory"))).getText();
        	Add_Log.info("Print {Sibling Category} ::" + getSibCategory);
        	
			// 5. Click on "Contact Supplier Now" button.
			InquiryForm_Page.btn_clickContactSupplierNow();
			
			// To verify the RFI Confirmation page is displayed.
			RFIConfirmation_Page.check_RFIConfirmationPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// To verify Inquire All upsell section is not available on the page.
			RFIConfirmation_Page.check_inqAllUpsellSectionNotExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// To verify PA upsell section is available on the page.
			// To verify PA upsell section 'update me on new {Sibling category}' is available on the page
			// To verify PA upsell section 'Category(s) below has been added to your Product Alert: {Sibling category}' is available on the page.
			RFIConfirmation_Page.check_PASection_UpdateMeOnNewSiblingCatExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSibCategory);
			RFIConfirmation_Page.check_PASection_CategoryAddedExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// To verify RFI upsell section is available on the page.
    		// To verify RFI upsell section 'find other products similar to {inquired L4 category}' is available on the page.
    		// To verify RFI upsell section '8 sibling categories of the inquired L4 category' is available on the page.
    		// To verify RFI upsell section 'Inquire All' button displayed below each category
    	//	RFIConfirmation_Action.check_RFIUpsellSection_PdtSimilar_InqAllExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getL4Category);
			
    		// To check is RFI upsell section available  			
    		// To verify RFI upsell section 'Find other products you might be interested in' is available on the page.
    		// To verify RFI upsell section '8 PPs of the inquired L4 category are displayed in each tab' is available on the page.   			  
    		// To verify RFI upsell section 'Inquire Now' button displayed below each category
    	//	RFIConfirmation_Action.check_RFIUpsellSection_PdtInterested_InqNowExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
    		// To check is RFI upsell section available
    		// To verify RFI upsell section 'Recommended Products For You' is available on the page.	// Dec1611_eGSOL_v320_Implement_Certona
    		// To verify RFI upsell section '8 PPs of the inquired L4 category are displayed in each tab' is available on the page.   			  
    		// To verify RFI upsell section 'Inquire Now' button displayed below each category
    		RFIConfirmation_Action.check_RFIUpsellSection_RecommendedPdt_InqNowExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
			// To verify Mini Marketing Box section 'Go to Global Sources Homepage' is available on the page.
    	//	RFIConfirmation_Page.check_miniMarketingBoxSection_GoToHomepageExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
        	
    		// To verify Mini Marketing Box section 'View all products in {Inquired L4 category} category' is available on the page.
        //	RFIConfirmation_Page.check_miniMarketingBoxSection_ViewAllProductsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
        	
    		// To verify Mini Marketing Box section is available on the page.
    		RFIConfirmation_Page.check_miniMarketingBoxSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
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
	public Object[][] RFI_PALanding_0002Data(){
		// To retrieve data from column of SuiteRFI data Sheet.
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
