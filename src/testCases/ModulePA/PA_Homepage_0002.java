/**
 * This class contains a method for PA Homepage.
 * Created: Fri 1 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/19
 * 
 * @TestCaseID 1054 / 7B
 * @TestArea Registration
 * @TestScenarioDesc PA Setting
 * @TestStep
 * 
 *     	Pre-req: Login to GSOL using following information before starting the test:
 *     	email: autoqa_gsol1007@gmail.com
 *     	password: asdf9876

 *     	1. Click on "Product Alert" tab in the Top Nav.
 *     	2. Click on the Settings link
 *     	3. If the Products Alerts, News Alerts and Supplier Alerts settings are not checked, checked on the checkboxes and click on 'Update button'
 *     	4. Uncheck all checkboxes and click on Update
 *     	5. Select 'Good idea. Take me to Edit Categories page.' option and click on submit
 *     	6. Click on the 'Settings' link on the left
 *     	7. Uncheck 'Product Alerts' checkbox and click on Update
 *     	8. Select 'Good idea. Take me to Edit Categories page.' option and click on submit
 *     	9. Click on the 'Settings' link on the left
 *     	10. Uncheck 'News Alerts' checkbox and click on Update
 *     	11. Select 'Good idea. Take me to Edit Categories page.' option and click on submit
 *     	11a. Click on the 'Settings' link on the left
 *     	12. Uncheck 'Supplier Alerts' checkbox and click on Update
 *     	13. Select 'Good idea. Take me to Edit Suppliers page.' option and click on submit
 *     	14. Click on the 'Settings' link on the left
 *     	15. Uncheck all the checkboxes and click on Update
 *     	16. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit
 *     	17. Checked all the checkboxes and click on submit
 *     	18. Uncheck 'Product Alerts' checkbox and click on Update
 *     	19. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit
 *     	20. Uncheck 'News Alerts' checkbox and click on Update
 *     	21. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit
 *     	22. Uncheck 'Supplier Alerts' checkbox and click on Update
 *     	23. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit

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

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.PA_Settings_Action;
import appModules.SignIn_Action;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.PA_EditCategories_Page;
import pageObjects.PA_Settings_Page;
import pageObjects.SA_EditSuppliers_Page;
import testCases.SuiteBase;
import testCases.ModulePA.SuiteBasePA;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * This test case contain method to test PA Homepage with different PA Setting.
 * @author Teng Shyh Wei
 *
 */
public class PA_Homepage_0002 extends SuiteBasePA{
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
		FilePath_TestResult = PA_Homepage_0002_TestResult;
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
	@Test(dataProvider="PA_Homepage_0002Data")
	public void PA_Homepage_0002Test(String dataTestCaseName, 
			String dataUsername,
			String dataPassword,
			String dataConfirmRadbtn) throws Exception{
			
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
			
			// Login to GSOL
			SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
			
			
        	// 1. Click on "Edit Categories" tab in the Global Nav.
			GlobalNav_MenuBar.menuBar_selectEditCategories();
			
			// To verify PA Edit Categories is displayed.
			PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 2. Click on the Settings link
			PA_EditCategories_Page.lnk_clickSettings().click();
			
			// To verify Product Alert - Settings page is displayed.
			PA_Settings_Page.check_PASettingsPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 3. If the Products Alerts, News Alerts and Supplier Alerts settings are not checked, checked on the checkboxes and click on 'Update button'.
			PA_Settings_Action.ExecuteCheckedAllCheckboxes_ClickUpdateBtn();
			
			// To verify Product Alert - Settings page is refreshed, with 'You have updated your settings successfully.' copy seen. 
			// To verify All checkboxes should be checked.
			PA_Settings_Action.check_msgUpdateSuccessfullyIsSeen_AllChkbxAreSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 4. Uncheck all checkboxes and click on Update
			PA_Settings_Action.ExecuteUncheckAllCheckboxes_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving Product Alerts,News Alerts and Supplier Alerts?' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Categories page.' and 'Thanks, but please proceed with unsubscribe.' options.
		//	PA_Settings_Action.ExecuteMsgStopAlertsSeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopAllAlertsSeen_RdbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 5. Select 'Good idea. Take me to Edit Categories page.' option and click on submit.
			PA_Settings_Action.ExecuteSelectGoodIdeaRadbtn_ClickSubmitBtn();
			
			// To verify Product Alert - Edit Categories page is displayed
			PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			
			// 6. Click on the 'Settings' link on the left
			PA_EditCategories_Page.lnk_clickSettings().click();
			
			// To verify Product Alert - Settings page is displayed. All the checkboxes should still be checked
			PA_Settings_Action.check_PASettingsPageDisplayed_AllChkbxRemainSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 7. Uncheck 'Product Alerts' checkbox and click on Update
			PA_Settings_Action.ExecuteUncheckPAChkbx_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving Product Alerts?' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Categories page.' and 'Thanks, but please proceed with unsubscribe.' options.
		//	PA_Settings_Action.ExecuteMsgStopPASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopPASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 8. Select 'Good idea. Take me to Edit Categories page.' option and click on submit
			PA_Settings_Action.ExecuteSelectGoodIdeaRadbtn_ClickSubmitBtn();
			
			// To verify Product Alert - Edit Categories page is displayed
			PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			
			// 9. Click on the 'Settings' link on the left
			PA_EditCategories_Page.lnk_clickSettings().click();
			
			// To verify Product Alert - Settings page is displayed. All the checkboxes should still be checked.
			PA_Settings_Action.check_PASettingsPageDisplayed_AllChkbxRemainSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 10. Uncheck 'News Alerts' checkbox and click on Update
			PA_Settings_Action.ExecuteUncheckNewsAlertChkbx_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving News Alerts? ' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Categories page.' and 'Thanks, but please proceed with unsubscribe.' options.
		//	PA_Settings_Action.ExecuteMsgStopNewsAlertsSeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopNewsAlertsSeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 11.Select 'Good idea. Take me to Edit Categories page.' option and click on submit
			PA_Settings_Action.ExecuteSelectGoodIdeaRadbtn_ClickSubmitBtn();
			
			// To verify Product Alert - Edit Categories page is displayed
			PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			
			// 11a.  Click on the 'Settings' link on the left
			PA_EditCategories_Page.lnk_clickSettings().click();
			
			// To verify Product Alert - Settings page is displayed. All the checkboxes should still be checked.
			PA_Settings_Action.check_PASettingsPageDisplayed_AllChkbxRemainSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
						
			// 12. Uncheck 'Supplier Alerts' checkbox and click on Update
			PA_Settings_Action.ExecuteUncheckSAChkbx_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving Supplier Alerts? ' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Suppliers page.' and 'Thanks, but please proceed with unsubscribe all.' options.
		//	PA_Settings_Action.ExecuteMsgStopSASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopSASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
						
			// 13.Select 'Good idea. Take me to Edit Suppliers page.' option and click on submit
			PA_Settings_Action.ExecuteSelectGoodIdeaRadbtn_ClickSubmitBtn();
			
			// To verify Supplier Alert - Edit Suppliers page is displayed.
			SA_EditSuppliers_Page.check_SAEditSuppliersPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 14. Click on the 'Settings' link on the left
			PA_EditCategories_Page.lnk_clickSettings().click();
			
			// To verify Product Alert - Settings page is displayed. All the checkboxes should still be checked.
			PA_Settings_Action.check_PASettingsPageDisplayed_AllChkbxRemainSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 15. Uncheck all the checkboxes and click on Update
			PA_Settings_Action.ExecuteUncheckAllCheckboxes_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving Product Alerts,News Alerts and Supplier Alerts?' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Categories page.' and 'Thanks, but please proceed with unsubscribe.' options.
		//	PA_Settings_Action.ExecuteMsgStopAlertsSeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopAllAlertsSeen_RdbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 16. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit
			PA_Settings_Action.ExecuteSelectThanksRadbtn_ClickSubmitBtn();
			
			// 28-Aug-17 MR#39192
			// PA Unsubscribe Survey is displayed. Close the Survey.
			PA_Settings_Page.btn_clickOnCloseIcon();

			// To verify the Alert settings page is displayed with 'You have updated your settings successfully' copy is seen. 
			// All the checkboxes are unchecked.
			PA_Settings_Action.check_msgUpdateSuccessfullyIsSeen_AllChkbxNotSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			
			// 17. Checked all the checkboxes and click on submit
			PA_Settings_Action.ExecuteCheckedAllCheckboxes_ClickUpdateBtn();
			
			// To verify Product Alert - Settings page is refreshed, with 'You have updated your settings successfully' copy seen. 
			// To verify All the checkboxes should be checked.
			PA_Settings_Action.check_msgUpdateSuccessfullyIsSeen_AllChkbxAreSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			
			// 18. Uncheck 'Product Alerts' checkbox and click on Update
			PA_Settings_Action.ExecuteUncheckPAChkbx_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving Product Alerts?' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Categories page.' and 'Thanks, but please proceed with unsubscribe.' options.
		//	PA_Settings_Action.ExecuteMsgStopPASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopPASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 19. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit
			PA_Settings_Action.ExecuteSelectThanksRadbtn_ClickSubmitBtn();
			
			// 28-Aug-17 MR#39192
			// PA Unsubscribe Survey is displayed. Close the Survey.
			PA_Settings_Page.btn_clickOnCloseIcon();
			
			// To verify the Alert settings page is displayed with 'You have updated your settings successfully' copy is seen. 
			// To verify Product Alert checkbox is unchecked.
			PA_Settings_Action.check_msgUpdateSuccessfullyIsSeen_PAChkbxNotSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			
			// 20. Uncheck 'News Alerts' checkbox and click on Update
			PA_Settings_Action.ExecuteUncheckNewsAlertChkbx_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving News Alerts? ' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Categories page.' and 'Thanks, but please proceed with unsubscribe.' options.
		//	PA_Settings_Action.ExecuteMsgStopNewsAlertsSeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopNewsAlertsSeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 21. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit
			PA_Settings_Action.ExecuteSelectThanksRadbtn_ClickSubmitBtn();
			
			// To verify the Alert settings page is displayed with 'You have updated your settings successfully' copy is seen. 
			// To verify News Alert checkbox is unchecked.
			PA_Settings_Action.check_msgUpdateSuccessfullyIsSeen_NewsAlertChkbxNotSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 22. Uncheck 'Supplier Alerts' checkbox and click on Update
			PA_Settings_Action.ExecuteUncheckSAChkbx_ClickUpdateBtn();
			
			// To verify a 'Are you sure you want to stop receiving Supplier Alerts? ' copy is seen. 
			// There should be 2 radio buttons 'Good idea. Take me to Edit Suppliers page.' and 'Thanks, but please proceed with unsubscribe all.' options.
		//	PA_Settings_Action.ExecuteMsgStopSASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_Settings_Page.check_msgStopSASeen_RadbtnOptionsExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 23. Select the 'Thanks, but please proceed with unsubscribe.' option and click on submit
			PA_Settings_Action.ExecuteSelectThanksRadbtn_ClickSubmitBtn();
			
			// To verify the Product Alert settings page is displayed with 'You have updated your settings successfully' copy is seen. 
			// To verify Supplier Alert checkbox is unchecked.
			PA_Settings_Action.check_msgUpdateSuccessfullyIsSeen_SAChkbxNotSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
	public Object[][] PA_Homepage_0002Data(){
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
			Add_Log.info(TestCaseName+" : Reporting test case as PASS In excel." + "\n ");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_PASS);
		}
		else{
			Add_Log.info(TestCaseName+" : Reporting test case as FAIL In excel." + "\n ");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_FAIL);			
		}
	}
	
}
