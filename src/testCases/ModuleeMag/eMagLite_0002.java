/**
 * This class contains a method for eMag Lite signup from Our Services
 * Created: Tue 01 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/01
 * 
 * @TestCaseID 1057 / 8B
 * @TestArea eMag Lite 
 * @TestScenarioDesc eMag Lite signup from Our Services
 * @TestStep
 *  	
 *     	Pre-req: Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com.
 *     	
 *     	1. Go to Our Services page.
 *     	2. Click on "Sample preview" link under eMag section.
 *     	3. Check any eMag title checkbox (e.g: Mobile Electronics).
 *     	4. In Business Email field, enter PA Lite email address which is the same as in Pre-req and click on "Continue" button.
 *     	5. Fill up all the mandatory fields and click on "Submit" button.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleeMag;

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

import appModules.PA_AddCategories_Action;
import appModules.PALite_Signup_Action;
import appModules.eMagLite_Confirmation_Action;
import appModules.eMagLite_Form_Action;
import pageObjects.BaseClass;
import pageObjects.PA_AddCategories_Page;
import pageObjects.eMagLite_Form_Page;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * This test case contain method to test eMag Lite signup from Our Services.
 * @author Teng Shyh Wei
 *
 */
public class eMagLite_0002 extends SuiteBaseeMag{
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
		FilePath = TestCaseListExcel_SuiteeMag_001_TestData;
		FilePath_TestResult = eMagLite_0002_TestResult;
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
	@Test(dataProvider="eMagLite_0002Data")
	public void eMagLite_0002Test(String dataTestCaseName, 
			String dataEmagTitle,
			String dataBusinessEmail,
			String dataFirstName, 
			String dataLastName,
			String dataCompName, 
			String dataCountryTerritory) throws Exception{
			
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
			
			// Pre-req: Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com.
			
			// Enter a brand new email address in the Get Notified section textbox and click on "Subscribe" button.
			PALite_Signup_Action.ExecutePAGetNotified_EnterEmailAddr_ClickSubsribeBtn(dataBusinessEmail);
			
			// Click on "Browse categories" tab and choose a category (e.g: Electronics) from "Choose an industry" dropdown list.
			PA_AddCategories_Action.ExecuteBrowseCategories_ChooseACategory();
			PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
			
			// Store checked Categories Suggestions Name
			WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> PALiteCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='catList_container']/dl[1]/dd/label/span")));
    		
    		List<String> checkedPACatNameList = new ArrayList<String>();
			for (WebElement element : PALiteCategoriesNameList){
				Add_Log.info("checkedPACatNameList ::" + element.getText());
				checkedPACatNameList.add(element.getText());
			}	
			
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			
			// ========================================================================================================
			
			// 1. Go to eMag Lite form page.
			driver.get(Param.getProperty("eMagLiteFormURL"));
			
			// To verify eMag Lite form is displayed.
			eMagLite_Form_Page.check_eMagLiteFormPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// 2. Check any eMag title checkbox (e.g: Mobile Electronics).
			eMagLite_Form_Page.chkbx_selectAnyEmagTitle(dataEmagTitle);
			
			// To verify eMag title checkbox is checked.
			eMagLite_Form_Page.check_eMagLiteTitleChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataEmagTitle);
			
			// 3. In Business Email field, enter PA Lite email address which is the same as in Pre-req and click on "Continue" button.
			eMagLite_Form_Action.ExecuteEmagLiteSignup_EnterEmailAddr_ClickContinueBtn(dataBusinessEmail);
			
			// To verify eMag title checkbox is remains checked. 
			// To verify Name, Company Name and Country/Territory fields are available. 
			// To verify Email address entered in Step 4 is grey-ed out in Business Email field.
			eMagLite_Form_Page.check_eMagLiteTitleChkbxRemainSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataEmagTitle);
			eMagLite_Form_Page.check_allMandatoryFieldsAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			eMagLite_Form_Page.check_emailAddrIsGreyedOut(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
						
			// 4. Fill up all the mandatory fields and click on "Submit" button.
			eMagLite_Form_Action.ExecuteFillInMandatoryFields_ClickSubmitBtn(dataFirstName, dataLastName, dataCompName, dataCountryTerritory);
			
			// Switch to new alert and click on 'OK' button.
			switchToAlert_ClickOnOKBtn();
			
			// To verify eMag Lite confirmation page is displayed. 
			// Verify that PAIDSUB, PA upsell and upgrade upsell section are available.
			eMagLite_Confirmation_Action.ExecuteEmagLite_PAIDSUB_PAUpsell_UpgUpsellSecExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			        	
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
	public Object[][] eMagLite_0002Data(){
		// To retrieve data from column of SuiteeMag data Sheet.
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
