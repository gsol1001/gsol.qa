/**
 * This class contains a method for Inquire Now for single verified product from single category
 * Created: Wed 25 Mar 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/25
 * 
 * @TestCaseID 1070 / 12B
 * @TestArea RFI Flow New User
 * @TestScenarioDesc Product Inquiry - Verified, 1 PP/>1 PP, 1 Category, Inquire Now
 * @TestStep
 * 
 * 		Pre-req: User has not subscribe to any service in GSOL.
 * 
 *     	1. As a new user, 'inquire now' for single verified product from single category and go to RFI form.
 *     	2. a. Fill in all the relevant fields. (use autoqa_gsolnewxxxx@gmail.com in Business E-mail field)
 *     	   b. Uncheck Both Verified and Unverified products Inquire All upsell checkbox.
 *     	   c. Uncheck the PA upsell checkbox.
 *     	3. Click on the "Continue to Next Step" button.
 *     	4. Fill in the "Create a Password", and "Re-enter Password" fields with valid password and click on "Send Your Inquiry Now" button.
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
import appModules.InquiryForm_Action;
import appModules.ProductInquiry_Action;
import appModules.RFIConfirmation_Action;
import appModules.SignIn_Action;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.RFIConfirmation_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test RFI Flow New User.
 * Profuct Inquiry - Verified, 1 PP/>1 PP, 1 Category, Inquire Now.
 * @author Teng Shyh Wei
 *
 */
public class InqFlowNL1_PdtInq_0002 extends SuiteBaseRFI{
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
		FilePath = TestCaseListExcel_SuiteRFI_010_TestData;
		FilePath_TestResult = InqFlowNL1_PdtInq_0002_TestResult;
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
	@Test(dataProvider="InqFlowNL1_PdtInq_0002Data")
	public void InqFlowNL1_PdtInq_0002Test(String dataTestCaseName, 
			String dataPageTypes, 
			String dataSearchKeyword, 
			String dataSubject, 
			String dataExpOrderQuantity, 
			String dataRequestFor, 
			String dataMessage, 
			String dataInqAllVerUpsell, 
			String dataInqAllUnvUpsell,
			String dataInqAllRemarks,
			String dataTitle, 
			String dataFirstName, 
			String dataLastName, 
			String dataBusinessEmail, 
			String dataCompName, 
			String dataCountryTerritory, 
			String dataTelephoneNumber,	
			String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL,
			String dataPAUpsell, 
			String dataPassword, 
			String dataRePassword) throws Exception{
			
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
			
			// Enter search keyword by select Products Page Types
			ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);			
    		
			// 'inquire now' for single verified product from single category
			ProductInquiry_Action.ExecuteInqNow_SglVerPdt_SglCat();
    		
			// To verify RFI Form is displayed.
			InquiryForm_Page.check_RFIFormIsDisplayed();
			
			
			// To check Verified products Inquire All upsell checkbox is available on the page.
        	// To check Unverified products Inquire All upsell checkbox is available on the page.        	
        	// To verify CC Email Address checkbox is not available on the page.    	
        	// To verify PA upsell checkbox is available on the page.
    		InquiryForm_Action.check_bothInqAll_PAUpsellChkbxExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);	
        	
        	
			// 3. a. Fill in all the relevant fields. 
			//    b. Uncheck Both Verified and Unverified products Inquire All upsell checkbox.
			//    c. Uncheck the PA upsell checkbox.        	
    		InquiryForm_Action.ExecuteNL1_PdtInq_InqNow_SglVerPdt_SglCat_Info(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage, 
    				dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks, dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
    				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL, dataPAUpsell);   	        	
    		
    		
    		// To check Verified products Inquire All upsell checkbox is not selected.
    		// To check Unverified products Inquire All upsell checkbox is not selected.
    		// To verify PA upsell checkbox is not selected.
        	InquiryForm_Action.check_bothInqAll_PAUpsellChkbxNotSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

    		// To store inquired L4 category
    		String element = driver.findElement(By.xpath(Object.getProperty("inqL4Category"))).getText();
    		String getL4Category = element.substring(4).trim();
    		Add_Log.info("Print {Inquired L4 category} ::" + getL4Category);
    		
    		
    		// 4. Click on the 'Continue to Next Step' button
    		// 5. Fill in the 'Create a Password' and 'Re-enter Password' field with valid password and click on 'Send Your Inquiry Now' button
    		SignIn_Action.ExecuteNewUserLogin(dataPassword, dataRePassword);

    		// To verify is RFI Confirmation page displayed
    		RFIConfirmation_Page.check_isRFIConfirmationPageDisplayed();
    		
    		// To capture RFI Confirmation page screen shot
    	//	captureRFIConfirmationPageScreenShot(); 
    		
    		    		
    		// To verify Inquire All upsell section is available on the page.
    	//	RFIConfirmation_Action.check_inqAllUpsellSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    	//	RFIConfirmation_Action.check_inqAllUpsellSection_DontMissOutOtherSuppExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
    		// To verify SA upsell section is available on the page.
    	//	RFIConfirmation_Page.check_SASectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
        	
    		// To check is PA upsell section available
    		// To verify PA upsell section 'update me on new {Inquired L4 category}' is available on the page.
    		RFIConfirmation_Page.check_PASection_UpdateMeOnNewL4Exists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getL4Category);

    		// To verify PA upsell section 'Hi First Name, as a registered user, you are eligible for free Product Alert e-mail updates.' is available on the page.
    		RFIConfirmation_Page.check_PASection_FreePAEmailUpdatesExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataFirstName);
    		
    		// To verify PA upsell section '[List the inquired L4 category (max 6, 3 in a row, checkbox pre-checked)]
    		// [Subscribe Now]' is available on the page.
    		RFIConfirmation_Page.check_PASection_SubsNowBtnExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);        	
    		
    		// To check is RFI upsell Section Available
    		// To verify RFI upsell section 'find other products similar to {inquired L4 category}' is available on the page.
    		// To verify RFI upsell section '8 sibling categories of the inquired L4 category' is available on the page.
    		// To verify RFI upsell section 'Inquire Now' button displayed below each category  
    	//	RFIConfirmation_Action.check_RFIUpsellSection_PdtSimilar_InqNowExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getL4Category);
    		
    		// To check is RFI upsell section available
    		// To verify RFI upsell section 'Recommended Products For You' is available on the page.	// Dec1611_eGSOL_v320_Implement_Certona
    		// To verify RFI upsell section '8 PPs of the inquired L4 category are displayed in each tab' is available on the page.   			  
    		// To verify RFI upsell section 'Inquire Now' button displayed below each category
    		RFIConfirmation_Action.check_RFIUpsellSection_RecommendedPdt_InqNowExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
        	// To verify eMag Crosspromo section is available on the page
        //	RFIConfirmation_Page.check_eMagCrosspromoSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
    		// To verify Mini Marketing Box section 'View all products in {Inquired L4 category} category' is available on the page.
        //	RFIConfirmation_Page.check_miniMarketingBoxSection_ViewAllProductsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getL4Category);

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
	public Object[][] InqFlowNL1_PdtInq_0002Data(){
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