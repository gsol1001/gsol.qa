/**
 * This class contains a method for PA Edit Categories
 * Created: Mon 07 Jul 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/07/07
 * 
 * @TestCaseID 5AA
 * @TestArea PA Edit Categories
 * @TestScenarioDesc PA edit categories from PA homepage
 * @TestStep
 * 
 * 		Pre-req: Login to GSOL using following information before starting the test:
 * 		email: autoqa_gsol1007@gmail.com
 * 		password: asdf9876

 * 		1. From any of the entry points in Appendix A (other than Homepage), click on the "Select your product categories now" link.
 * 		2. Enter a product keyword in product keyword textbox (e.g: MP3) and click on "Find Matching Categories" button.
 * 		3. Check on any category checkboxes.
 * 		4. Repeat Step 2-3 using another keyword.
 * 		5. Click on "Go to Confirmation" button.
 * 		6. Check on any category checkboxes in the recommended categories section.
 * 		7. Click on "Add These Categories" button.
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

import appModules.PA_EditCategories_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.PA_EditCategories_Page;
import pageObjects.PA_Home_Page;
import testCases.SuiteBase;
import testCases.ModulePA.SuiteBasePA;

/**
 * This test case contain method to test PA edit categories from RFI Confirmation page (Mini Marketing Box)
 * @author Teng Shyh Wei
 *
 */
public class PA_EditCategories_0026 extends SuiteBasePA{
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
		FilePath = TestCaseListExcel_SuitePA_008_TestData;
		FilePath_TestResult = PA_EditCategories_0026_TestResult;
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
	@Test(dataProvider="PA_EditCategories_0026Data")
	public void PA_EditCategories_0026Test(String dataTestCaseName, 
			String dataUsername, 
			String dataPassword,
			String dataProductKeyword,
			String data2ndProductKeyword) throws Exception{

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
			
			// As a logged in user, clean up all the PA Categories. 
			PA_EditCategories_Action.ExecuteLoggedIn_CleanUpPACategories(dataUsername, dataPassword);
			
        	// 1. From any of the entry points in Appendix A (other than Homepage), click on the "select your product categories now." link.
			GlobalNav_MenuBar.menuBar_selectMyProductAlert();
			PA_Home_Page.lnk_clickSelectPdtCategoriesNow().click();
			
			// To verify Product Alert Edit Categories page is displayed. There is no suggested categories.
			PA_EditCategories_Page.check_PAEditCategoriesPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_EditCategories_Page.check_noPASuggestedCategories(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
		//	PA_EditCategories_Action.ExecutePAEditCatPageDisplayed_SuggCatNotAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
        	// 2. Enter a product keyword in product keyword textbox (e.g: MP3) and click on "Find Matching Categories" button.
			PA_EditCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCategoriesBtn(dataProductKeyword);
			
			// To verify suggested categories for the product keyword entered are displayed.
			PA_EditCategories_Page.check_suggCatForPdtKeyword_EnteredInPAEditCatPageExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
        	// 3. Check on any category checkboxes.
			PA_EditCategories_Page.chkbx_selectFirstPACategories();
			
			// Store checked Categories Suggestions Name
			WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> categoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='catList_container']/dl[1]/dd/label/span")));
    		
    		List<String> checkedCatNameList = new ArrayList<String>();
			for (WebElement element : categoriesNameList){
				Add_Log.info("checkedCatNameList ::" + element.getText());
				checkedCatNameList.add(element.getText());
			}	
			
			// To verify Category checkboxes are checked. 
			// To verify selected categories are grey-ed out and the categories are appear in the selected categories column.
			PA_EditCategories_Action.ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			
        	// 4. Repeat Step 2-3 using another keyword.
			// Enter a product keyword in product keyword textbox and click on "Find Matching Categories" button.
			PA_EditCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCategoriesBtn(data2ndProductKeyword);
			
			// To verify suggested categories for the product keyword entered are displayed.
			PA_EditCategories_Page.check_suggCatFor2ndPdtKeyword_EnteredInPAEditCatPageExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// Check on any category checkboxes
			PA_EditCategories_Page.chkbx_selectFirstPACategories();
			
			// Store checked Categories Suggestions Name
    		List<WebElement> categoriesNameList2 = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='catList_container']/dl[1]/dd/label/span")));
    		
    		List<String> checkedCatNameList2 = new ArrayList<String>();
			for (WebElement element : categoriesNameList2){
				Add_Log.info("checkedCatNameList2 ::" + element.getText());
				checkedCatNameList2.add(element.getText());
			}
			
			// To verify same expected result as Step 2 - 3.
			PA_EditCategories_Page.check_catChkbxChecked_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList2);
		
			
        	// 5. Click on "Go to Confirmation" button.
			PA_EditCategories_Page.btn_clickGoToConfirmation();
			
			// To verify PA Edit Categories confirmation page with message "Successful! You have added x product categories." is displayed. 
			// To verify recommended categories section is available.
			PA_EditCategories_Action.ExecutePAEditCatConfPage_MsgSuccAdded_RecCatSecExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			
        	// 6. Check on any category checkboxes in the recommended categories section.
			PA_EditCategories_Page.chkbx_selectRecommendedCategories();
			
			// To verify the categories checkboxes are checked.
			PA_EditCategories_Page.check_recommendedCategoriesChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Store checked recommended categories
			List<WebElement> recCategoriesNameList = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[contains(@class, 'PA_recommend_cat mt15')]//li")));
			
			List<String> checkedRecCatNameList = new ArrayList<String>();
			for (WebElement element : recCategoriesNameList){
				Add_Log.info("checkedRecCatNameList ::" + element.getText());
				checkedRecCatNameList.add(element.getText());
			}
			
			
			// 7. Click on "Add These Categories" button.
			PA_EditCategories_Page.btn_clickAddTheseCategories().click();
			
			// To verify PA Edit Categories confirmation page with message "Successful! You have added x product categories." is displayed. 
			// To verify selected categories are added into the selected categories column.
			PA_EditCategories_Action.ExecutePAEditCatConfPage_MsgSuccessfulAddedDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_EditCategories_Page.check_PAEditCatConfPage_MsgSuccessfulAddedDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_EditCategories_Page.check_addedToSelectedCategoriesColumn(FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedRecCatNameList);

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
	public Object[][] PA_EditCategories_0026Data(){
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
