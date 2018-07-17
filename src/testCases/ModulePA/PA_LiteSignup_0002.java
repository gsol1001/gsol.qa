/**
 * This class contains a method for PA Lite Signup
 * Created: Wed 24 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/24
 * 
 * @TestCaseID 1020 / 4C
 * @TestArea PA Lite Signup
 * @TestScenarioDesc PA Lite signup from cross promotion (centrewell)
 * @TestStep
 * 
 *     	1. From any of the following entry points, enter a brand new email address in the 
 *         PA cross promotion (centrewell) section textbox and click on "Subscribe" button.
 *     	   - L1
 *     	   - L2
 *     	   - L3
 *     	   - New Product
 *     	2. Check on any category checkboxes.
 *     	3. Enter a product keyword in product keyword textbox (e.g: MP3) and click on "Find Matching Categories" button.
 *     	4. Check on any category checkboxes.
 *     	5. Click on "Go to Confirmation" button.
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

import appModules.BrowseProductCategories_Action;
import appModules.PALite_Signup_Action;
import appModules.PA_AddCategories_Action;
import appModules.PALite_Confirmation_Action;
import appModules.ProductInquiry_Action;
import pageObjects.PA_AddCategories_Page;
import pageObjects.BaseClass;
import pageObjects.ProductListing_Page;
import testCases.SuiteBase;
import testCases.ModulePA.SuiteBasePA;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * This test case contain method to test PA Lite signup from PA cross promotion (centrewell) (L1 entry point).
 * @author Teng Shyh Wei
 *
 */
public class PA_LiteSignup_0002 extends SuiteBasePA{
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
		FilePath = TestCaseListExcel_SuitePA_003_TestData;
		FilePath_TestResult = PA_LiteSignup_0002_TestResult;
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
	@Test(dataProvider="PA_LiteSignup_0002Data")
	public void PA_LiteSignup_0002Test(String dataTestCaseName, 
			String dataSearchKeyword,
			String dataCategoryKeyword,
			String dataEmailAddress,
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
			// Store the parent window handle
			String parentHandle = driver.getWindowHandle();
			
			// 1. From any of the following entry points, enter a brand new email address in the PA cross promotion (centrewell) section textbox
			// and click on "Subscribe" button.			
			// - L1, - L2, - L3, - New Product
			
			// Perform a product keyword search and click on "Browse Product Categories" link.
			BrowseProductCategories_Action.ExecuteBrowsePdtCategoriesEntryPoint(dataSearchKeyword);
			
			// Switch to new window
			switchToNewWindowOpened();
			
			// Go to L1 entry point
			ProductInquiry_Action.ExecuteL1EntryPoint(dataCategoryKeyword);		// L1 entry point
			
			// Due to page optimization, waits for 3 seconds
			Thread.sleep(3000);
			Add_Log.info("Waits for 3 seconds.");
			
			// Close the PA Catfish Banner
			ProductListing_Page.icon_PACatfishBanner_ClickOnCloseBtn();

			// Enter a brand new email address in the PA cross promotion (centrewell) section textbox and click on "Subscribe" button.			
			PALite_Signup_Action.ExecutePACrossPromotion_EnterEmailAddr_ClickSubscribeBtn(dataEmailAddress);
			
			// To verify Select Product Alert Categories page is displayed. There are suggested categories based on the keyword in L1, L2 or L3.
			PA_AddCategories_Action.ExecuteSelPACatPage_SuggCatByKeywordL3Exists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 2. Check on any category checkboxes.
			PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
			
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
			
			// To verify category checkboxex are checked. Selected categories are grey-ed out and 
			// the categories are appear in the selected categories column.
			PA_AddCategories_Action.ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			// 3. Enter a product keyword in product keyword textbox (e.g: MP3) and click on "Find Matching Categories" button.
			PA_AddCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCatBtn(dataProductKeyword);
			
			// To verify suggested categories for the product keyword entered in Select PA Categories page are displayed.
			PA_AddCategories_Page.check_suggCatByKeyword_EnteredInSelPAPageExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Check on any category checkboxes.
			PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
			
			// Store checked Categories Suggestions Name
    		List<WebElement> categoriesNameList2 = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='catList_container']/dl[1]/dd/label/span")));
    		
    		List<String> checkedCatNameList2 = new ArrayList<String>();
			for (WebElement element : categoriesNameList2){
				Add_Log.info("checkedCatNameList2 ::" + element.getText());
				checkedCatNameList2.add(element.getText());
			}
						
			// To verify category checkboxes are checked. 
			// To verify selected categories are grey-ed out and the categories are appear in the selected categories column.
			PA_AddCategories_Page.check_catChkbxChecked_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList2);
			
			// 5. Click on "Go to Confirmation" button.
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			// To verify PA Lite confirmation page is displayed. Verify that upgrade upsell section is available 
			// and up to 10 PA categories selected in Step 3-4 are displayed.
			PALite_Confirmation_Action.ExecutePALiteConfPage_UpgUpsellSec_UpTo10CatSelAreDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
	public Object[][] PA_LiteSignup_0002Data(){
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
