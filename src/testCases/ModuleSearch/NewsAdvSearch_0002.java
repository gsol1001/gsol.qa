/**
 * This class contains a method for News advance search
 * Created: Tue 27 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/27
 * 
 * @TestCaseID 18Z
 * @TestArea Search
 * @TestScenarioDesc News advance search
 * @TestStep
 * 
 *     	1. From any of the page, select 'Advanced Search' from 'Search Options' drop down list.
 *     	2. Select "News" in "I am Looking for:" field. 
 *     	3. Enter a keyword in keyword search textbox (e.g: Car MP3 Player). 
 *     	4. Select "Match any of my words" in "Search Method" field.
 *     	5. Select "All categories" in "Just in the category:" field.
 *     	6. Select "All Countries" in "Select countries:" field.
 *     	7. Click on "Search" button.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSearch;

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

import pageObjects.AdvancedSearch_Page;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.NewsListing_Page;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.AdvancedSearch_Action;

/**
 * This test case contain method to test News advance search.
 * @author Teng Shyh Wei
 *
 */
public class NewsAdvSearch_0002 extends SuiteBaseSearch{
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
		FilePath = TestCaseListExcel_SuiteSearch_004_TestData;
		FilePath_TestResult = NewsAdvSearch_0002_TestResult;
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
	@Test(dataProvider="NewsAdvSearch_0002Data")
	public void NewsAdv_Search_0002Test(String dataTestCaseName, 
			String dataLookingFor,
			String data1stKeyword,
			String data2ndKeyword,
			String data3rdKeyword,
			String dataSearchMethod,
			String dataCategory,
			String dataCountry) throws Exception{

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

			String dataSearchKeyword = data1stKeyword + " " + data2ndKeyword + " " + data3rdKeyword;
			Add_Log.info("Print keywords entered ::" + dataSearchMethod);
			
			// 1. From any of the page, select 'Advanced Search' from 'Search Options' drop down list.
			Home_Page.drpdwn_selectAdvancedSearch();
			
			// To verify Advance Search page is displayed.
			AdvancedSearch_Page.check_advancedSearchPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Select 'News' in 'I am Looking for:' field.
			// 3. Enter a keyword in keyword search textbox (e.g: mp3).
			// 4. Select "Match any of my words" in "Search Method" field.
			// 5. Select "All categories" in "Just in the category:" field.
			// 6. Select "All Countries" in "Select countries:" field.
			AdvancedSearch_Action.ExecuteAdvSearch_FillInAllFields(
					dataLookingFor, data1stKeyword, data2ndKeyword, data3rdKeyword, dataSearchMethod, dataCategory, dataCountry);
			
			// To verify 'News' is selected in 'I am Looking for:' field.
			AdvancedSearch_Page.check_IamLookingForNewsIsSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);					
			
			// To verify the keyword is entered in the keyword search textbox.
			AdvancedSearch_Page.check_txtbxKeywordIsEntered(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataSearchKeyword);			

			// To verify "Match any of my words" is selected in "Search Method" field.
			AdvancedSearch_Page.check_radbtnMatchAnyOfMyWordsIsSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// To verify "All categories"is selected in "Just in the category:" field.
			AdvancedSearch_Page.check_allCategoriesIsSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
												
			// To verify "All Countries" is selected in "Select countries:" field.
			AdvancedSearch_Page.check_allCountriesIsSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 7. Click on "Search" button.
			AdvancedSearch_Page.btn_clickSearch().click();
			
			// To verify Keyword Search result page is displayed. 
			// To verify the results displayed contains at least one of the keywords entered in Step 3.
			NewsListing_Page.check_newsKeywordSearchResultPageIsDisplayed(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataSearchKeyword);
			AdvancedSearch_Page.check_newsResultsContainsAtLeastOneKeywords(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, data1stKeyword, data2ndKeyword, data3rdKeyword);
			
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
	public Object[][] NewsAdvSearch_0002Data(){
		// To retrieve data from column of SuiteSearch data Sheet.
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
