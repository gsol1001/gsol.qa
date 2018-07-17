/**
 * This class contains a method for PA Lite Signup
 * Created: Thu 07 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/07
 * 
 * @TestCaseID 4U
 * @TestArea PA Lite Signup
 * @TestScenarioDesc PA Lite signup from PA catfish banner
 * @TestStep
 * 
 *     	1. Go to any of the following entry points, verify the PA Catfish Banner section:
 *     	   - L1
 *     	   - L2
 *     	   - L3
 *     	   - Article
 *     	2. Enter a brand new email address (autoqa_gsolnewxxxx@gmail.com) in the PA Catfish Banner email field and click on "Subscribe" button.
 *     	3. Check on any category checkboxes.
 *     	4. Click on "Browser categories" tab and choose a category (e.g: Electronics) from "Choose an industry" dropdown list.
 *     	5. Check on any category checkboxes.
 *     	6. Click on "Subscribe Now" button.
 *     
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModulePA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import pageObjects.ProductListing_Page;
import pageObjects.RegistrationConfirmation_Page;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.BrowseProductCategories_Action;
import appModules.PALite_Signup_Action;
import appModules.ProductInquiry_Action;
import appModules.RegConfirmation_Action;
import appModules.Registration_Action;

/**
 * This test case contain method to test PA Lite signup from PA catfish banner (L2 entry point)
 * @author Teng Shyh Wei
 *
 */
public class PA_LiteSignup_0021 extends SuiteBasePA{
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
		FilePath = TestCaseListExcel_SuitePA_006_TestData;
		FilePath_TestResult = PA_LiteSignup_0021_TestResult;
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
	@Test(dataProvider="PA_LiteSignup_0021Data")
	public void PA_LiteSignup_0021Test(String dataTestCaseName,
			String dataSearchKeyword,
			String dataCategoryKeyword,
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
			String dataTxtbxCompWebsiteURL) throws Exception{
			
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
			// Store the parent window handle
			String parentHandle = driver.getWindowHandle();
			
			// 1. Go to any of the following entry points, verify the PA Catfish Banner section:
			// - L1, - L2, - L3, - Article
			
			// Perform a product keyword search and click on "Browse Product Categories" link.
			BrowseProductCategories_Action.ExecuteBrowsePdtCategoriesEntryPoint(dataSearchKeyword);
			
			// Switch to new window
			switchToNewWindowOpened();
			
			// Go to L2 entry point.
			ProductInquiry_Action.ExecuteL2EntryPoint(dataCategoryKeyword);		//L2 entry point
			
			// To verify the page is displayed.
			// To verify there are suggested categories in PA Catfish Banner section with the first category's checkbox is checked.
			PALite_Signup_Action.ExecutePACatfishBanner_SuggCatExists_1stCatChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Check on any category checkboxes.
			// Select all category checkboxes (except the first category's chkbx which is pre-checked)
			ProductListing_Page.chkbx_selectAllPACatfishBanner();
			
			// To verify the categories checkboxes are checked.		
			ProductListing_Page.check_PACatfishBanner_AllCatChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

			// Store PA categories selected.
			WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> categoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'catfishPAList')]//label")));
    		
    		List<String> checkedCatNameList = new ArrayList<String>();
			for (WebElement element : categoriesNameList){
				Add_Log.info("checkedCatNameList ::" + element.getText());
				checkedCatNameList.add(element.getText());
			}	
			
			
			// 3. Enter a brand new email address (autoqa_gsolnewxxxx@gmail.com) in the PA Catfish Banner email field and click on "Register" button.
			PALite_Signup_Action.ExecutePACatfishBanner_EnterEmailAddr_ClickRegisterBtn(dataBusinessEmail);
			
			// To verify the Registration page is displayed.
			// To verify the email address entered in Step 3 is pre-populated and grey-ed out in the Business Email field.
		//	Registration_Action.ExecuteRegPageDisplayed_EmailAddrPrepopulatedInGray(
		//			FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			Registration_Action.ExecuteRegPageDisplayed_EmailAddrPrepopulatedInBusinessEmailField(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			
			// 4. Fill up all the mandatory fields and click on "Register Now" button. 
			Registration_Action.ExecuteReg_EnterMandatoryField(dataCreateAPassword, dataReenterPassword, dataTitle, dataFirstName, 
					dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify the Registration confirmation page with DOI reminder overlay is displayed.
			RegistrationConfirmation_Page.check_regConfPage_DOIReminderOverlayDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 5. Click on the "OK" button in DOI reminder overlay.
			RegistrationConfirmation_Page.btn_clickDOIReminderOverlay_OkBtn().click();
			
			// To verify the Registration confirmation page is displayed.
			// To verify that "You've also requested sourcing magazines." statement is not exists.
			// To verify that the PA categories selected in Step 2 are displayed.
			RegConfirmation_Action.ExecuteRegConfPage_NoReqSMCopy_PACatSelectedIsDisplayed(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			// Switch back to parent window
			switchBackToParentWindow(parentHandle);
        	
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
	public Object[][] PA_LiteSignup_0021Data(){
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
