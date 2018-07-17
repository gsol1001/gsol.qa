/**
 * This class contains a method for PA Edit Categories
 * Created: Wed 24 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/24
 * 
 * @TestCaseID 1039 / 5K
 * @TestArea PA Edit Categories
 * @TestScenarioDesc PA Edit Categories from RFI confirmation
 * @TestStep
 * 
 * 		1. As a new user, inquire for single category product(s) and go to RFI form.
 * 		2. Fill in the relevant fields and unchecked the PA upsell checkbox.
 * 		3. Click on the "Continue to Next Step" button.
 * 		4. Fill in the "Create a Password" and "Re-enter Password" fields with valid password and click on "Send Your Inquiry Now" button.
 * 		5. Make sure the L4 category checkbox is checked and click on "Subscribe Now" button.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModulePA;

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
import appModules.ProductInquiry_Action;
import appModules.SignIn_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.PA_CategoryConf_Page;
import pageObjects.RFIConfirmation_Page;
import testCases.SuiteBase;
import testCases.ModulePA.SuiteBasePA;

/**
 * This test case contain method to test PA edit categories from RFI confirmation
 * @author Teng Shyh Wei
 *
 */
public class PA_EditCategories_0010 extends SuiteBasePA{
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
		FilePath = TestCaseListExcel_SuitePA_002_TestData;
		FilePath_TestResult = PA_EditCategories_0010_TestResult;
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
	@Test(dataProvider="PA_EditCategories_0010Data")
	public void PA_EditCategories_0010Test(String dataTestCaseName,
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
			
			// 1. As a new user, inquire for single category product(s) and go to RFI form.
			ProductInquiry_Action.ExecuteNonLoggedIn_InqSglVerPdt(dataSearchKeyword);
			
			// To verify the RFI form is displayed. Verify that user's contact details are not pre-populated. 
			// The PA upsell copy is "I want e-mail updates when new {Inquired L4 category} are available." 
			// and the checkbox is checked by default.
			InquiryForm_Page.check_RFIFormIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryForm_Page.check_userContactDetailsNotPrepopulated(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryForm_Page.check_PAUpsellCopyAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryForm_Page.check_PAUpsellChkbxSelectedAsDefault(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Fill in the relevant fields and unchecked the PA upsell checkbox.
    		InquiryForm_Action.ExecuteNL1_PdtInq_InqNow_SglVerPdt_SglCat_Info(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage, 
    				dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks, dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
    				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL, dataPAUpsell);
			
			// To verify the relevant fields are filled up and the PA upsell checkbox is unchecked.
			InquiryForm_Page.check_PAUpsellChkbxNotSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
    		// To store inquired L4 category
    		String elementL4 = driver.findElement(By.xpath(Object.getProperty("inqL4Category"))).getText();
    		String getL4Category = elementL4.substring(4).trim();
    		Add_Log.info("Print {Inquired L4 category} ::" + getL4Category);
    		
			// 3. Click on the "Continue to Next Step" button.						
			// 4. Fill in the "Create a Password" and "Re-enter Password" fields with valid password and click on "Send Your Inquiry Now" button.
    		SignIn_Action.ExecuteNewUserLogin(dataPassword, dataRePassword);

    		// To verify RFI confirmation page is displayed. Verify that the copy for PA upsell section:
    		// - Update me on new {Inquired L4 category}
    		// - Hi First Name, as a registered user, you are eligible for free Product Alert e-mail updates.    		
    		// - [List the inquired L4 category (checkbox is pre-checked)]    	
    		RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		RFIConfirmation_Page.check_PASection_UpdateMeOnNewL4Exists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getL4Category);
			RFIConfirmation_Page.check_PASection_FreePAEmailUpdatesExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataFirstName);
    		RFIConfirmation_Page.check_PASection_InqL4CatChkbxPrechecked(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
			// Store PA upsell section Categories Name
			WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'form_PA_cat form_PA_catCheck')]//li"));
			String selectedPACategory = element.getText();
			Add_Log.info("Print selected PA Category ::" + selectedPACategory);
			
			// 5. Make sure the L4 category checkbox is checked and click on "Subscribe Now" button.
        	RFIConfirmation_Page.btn_clickSubscribeNow().click();
    		
    		// To verify Product Alert Category Confirmation page is displayed
    		// To verify the category is added to Product Alert.
			PA_CategoryConf_Page.check_PACategoryConfPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_CategoryConf_Page.check_singlePACategoryAddedToPdtAlert(FilePath_TestResult, TestCaseName, DataSet+1, testFail, selectedPACategory);
        	
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
	public Object[][] PA_EditCategories_0010Data(){
		// To retrieve data from column of SuitePA data Sheet.
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
