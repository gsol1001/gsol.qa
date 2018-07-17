/**
 * This class contains a method for PA Homepage
 * Created: Wed 17 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/17
 * 
 * @TestCaseID 1053 / 7A
 * @TestArea Registration
 * @TestScenarioDesc PA Homepage for Logged-in user with no category subscribed
 * @TestStep
 * 
 *     	Pre-req: Login to GSOL using the following information before starting the test:
 *     	Email: 
 *     	password: 

 *     	1. Go to GSOL Homepage.
 *     	2. Click on "My Product Alert" tab in the Top Nav.
 *     	3. Enter a product keyword in product keyword textbox (e.g: MP3) and click on "Search" button.
 *     	4. Check on any category checkboxes.
 *     	5. Click on "Go to Confirmation" button.
 *     	6. Remove all the PA categories by clicking on the "x" beside each category and click on "Remove From Alert" button.
 *     	7. Click on "Ok" button.
 *     	8. Repeat Step 1 and 2.
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

import appModules.PA_AddCategories_Action;
import appModules.PA_EditCategories_Action;
import appModules.ProductAlert_Action;
import appModules.SignIn_Action;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.PA_AddCategories_Page;
import pageObjects.BaseClass;
import pageObjects.PA_EditCategories_Page;
import pageObjects.Home_Page;
import pageObjects.PA_Home_Page;
import pageObjects.TopNav_MenuBar;
import testCases.SuiteBase;
import testCases.ModulePA.SuiteBasePA;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * This test case contain method to test PA Homepage for logged-in user with no category subscribed
 * @author Teng Shyh Wei
 *
 */
public class PA_Homepage_0001 extends SuiteBasePA{
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
		FilePath_TestResult = PA_Homepage_0001_TestResult;
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
	@Test(dataProvider="PA_Homepage_0001Data")
	public void PA_Homepage_0001Test(String dataTestCaseName, 
			String dataUsername,
			String dataPassword,
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
			
			// 1. Login and go to GSOL Homepage
			SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
			
			// To verify GSOL Homepage is displayed.
			Home_Page.check_GSOLHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// To clean up PA Categories if available on the page.
			ProductAlert_Action.ExecuteCleanUpPACategories();
			
			
        	// 2. Click on "My Product Alert" tab in the Global Nav.
			GlobalNav_MenuBar.menuBar_selectMyProductAlert();
			
			// PA homepage is displayed. Verify that "You currently have no categories selected for Product Alert." statement exists.
			ProductAlert_Action.ExecutePAHomepage_MsgNoSubsPACatDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			
        	// 3. Enter a product keyword in product keyword textbox (e.g: MP3) and click on "Search" button.
			ProductAlert_Action.ExecutePAHomepage_EnterPdtKeyword_ClickSearchBtn(dataProductKeyword);
			
			// To verify Product Alert Add Categories page is displayed. 
			// There are suggested categories based on the keyword entered in Step 2.
			PA_AddCategories_Action.ExecutePAAddCatPage_SuggCatByKeywordExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			
			// 4. Check on any category checkboxes.
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
			
			// To verify category checkboxes are checked. 
			// To verify selected categories are grey-ed out and the categories are appear in the selected categories column.
			PA_AddCategories_Action.ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			
			// 5. Click on "Go to Confirmation" button.
        	PA_AddCategories_Page.btn_clickGoToConfirmation();
        	
        	// To verify PA Edit Categories confirmation page with message "Successful! You have added x product categories." is displayed. 
        	PA_EditCategories_Action.ExecutePAEditCatConfPage_MsgSuccessfulAddedDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
        	
			// 6. Remove all the PA categories by clicking on the "tick" beside each category and click on "Remove From Alert" button.
    		// Select PA Categories checkboxes
    		PA_EditCategories_Page.chkbx_selectAllPACategories();    
    		PA_EditCategories_Page.btn_clickRemoveFromAlert().click();	
    		
    		// To verify a pop up message is displayed asking user whether want to continue.    		
    		// 7. Click on "Ok" button.
    		PA_EditCategories_Page.check_alertMsgContExists_ClickOKBtn(FilePath_TestResult, TestCaseName, DataSet+1, testFail);    
    					        	
    		// To verify the pop up message is closed. PA Edit Categories confirmation page with message "Updated! You have removed all of your product categories." is displayed.
    		PA_EditCategories_Action.ExecutePAEditCatConfPage_MsgSuccessfulUpdateDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
    		
			// 8. Repeat Step 1 and 2.
        	// Go to GSOL homepage.
    		TopNav_MenuBar.lnk_backToGSOLHomePage();
    		
			// To verify GSOL Homepage is displayed.
			Home_Page.check_GSOLHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Click on "My Product Alert" tab in the Global Nav.
    		GlobalNav_MenuBar.menuBar_selectMyProductAlert();
			    		
			// PA homepage is displayed. Verify that "You currently have no categories selected for Product Alert." statement exists.			
		//	ProductAlert_Action.ExecutePAHomepage_MsgNoSubsPACatDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Home_Page.check_PAHomepage_MsgNoSubsPACatDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
        	
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
	public Object[][] PA_Homepage_0001Data(){
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
