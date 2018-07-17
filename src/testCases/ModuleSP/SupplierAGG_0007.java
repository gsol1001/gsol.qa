/**
 * This class contains a method for Product Alert from Left Nav at Supplier AGG Homepage (New user)
 * Created: Wed 04 Oct 2017
 * @author Teng Shyh Wei
 * @version 0.1 Date: 2017/10/04
 * 
 * @TestCaseID 43G
 * @TestArea Supplier Profile
 * @TestScenarioDesc Product Alert from Left Nav at Supplier AGG Homepage (New user)
 * @TestStep
 * 
 * 		1. As a non-logged in user, go to Supplier AGG homepage
 * 		2. Click on "Get e-mail alerts on latest products!" link on the Left Nav.
 * 		3. Enter a brand new email address (autoqa_gsolnewxxxx@gmail.com) in the email textbox and click on "Subscribe" button.
 * 		4. Search for a keyword or choose an industry and check on any category checkboxes.
 * 		5. Click on "Go to Confirmation" button.
 * 		6. Click on "Upgrade Free" button.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSP;

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
import appModules.Registration_Action;
import appModules.SupplierInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.PALite_Confirmation_Page;
import pageObjects.PA_AddCategories_Page;
import pageObjects.SupplierListing_Page;
import pageObjects.UnvSupplier_Homepage;
import testCases.SuiteBase;

/**
 * This test case contain method to test Product Alert from Left Nav at Supplier AGG Homepage (New user)
 * @author Teng Shyh Wei
 *
 */
public class SupplierAGG_0007 extends SuiteBaseSP{
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
		FilePath = TestCaseListExcel_SuiteSP_004_TestData;
		FilePath_TestResult = SupplierAGG_0007_TestResult;
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
	@Test(dataProvider= "SupplierAGG_0007Data")
	public void SupplierAGG_0007Test(String dataTestCaseName, 
			String dataSearchKeyword,
			String dataBusinessEmail) throws Exception{
		
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
			
			// 1. As a non-logged in user, go to Supplier AGG Homepage
						
			// Do a Supplier keyword search. (Supplier keyword: SPP)
			SupplierInquiry_Action.ExecuteSearchBySuppliers(dataSearchKeyword);
			
			WebElement suppElement = driver.findElement(By.xpath("(//*[contains(@class, 'unverified_listing')]//a)[position()=1]"));
    		String getSuppName = suppElement.getText();
    		Add_Log.info("Print supplier name ::" + getSuppName);
    		
			// Click on Unverified Supplier Name link
			SupplierListing_Page.lnk_clickUnvSupplierNameTitle().click();
			
			// Close the RFQ overlay.
			UnvSupplier_Homepage.icon_clickCloseBtnOnTradeMatchOverlay();
			Thread.sleep(3000);
			
			// To verify Supplier AGG Homepage is displayed.
			UnvSupplier_Homepage.check_AGGSuppHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);
			
			// 2. Click on "Get e-mail alerts on latest products!" link on the Left Nav.
			UnvSupplier_Homepage.lnk_clickGetEmailAlertsOnLatestPdt().click();
			
			// To verify Email address textbox is displayed beside Product Alert link.
			UnvSupplier_Homepage.check_txtbxEmailAddrBesideProductAlertLink(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 3. Enter a brand new email address in the email textbox and click on "Subscribe" button.
			UnvSupplier_Homepage.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
			UnvSupplier_Homepage.btn_clickProductAlertSubscribe();
			
			// Switch to new window opened.
			switchToNewWindowOpened();			
			
			// To verify Select PA Categories page is displayed.
			PA_AddCategories_Page.check_selPACatPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Search for a keyword or choose an industry and check on any category checkboxes.
			PA_AddCategories_Action.ExecuteEnterPdtKeyword_SelectCategoriesSuggestionsChkbx(dataSearchKeyword);
			
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
			// Selected categories are grey-ed out and the categories are appear in the selected categories column.
			PA_AddCategories_Action.ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
						
			// 5. Click on "Go to Confirmation" button.
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			// To verify PA Lite Confirmation page is displayed.
			PALite_Confirmation_Page.check_PALiteConfPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 6. Click on "Upgrade Free" button.
			PALite_Confirmation_Page.btn_clickUpgradeFree().click();			
			
			// To verify Registration form is displayed. Verify that the email address entered in Step 2 is pre-populated
			// and grey-ed out in the Business Email field.
			Registration_Action.ExecuteRegPageDisplayed_EmailAddrPrepopulatedInGray(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			
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
	public Object[][] SupplierAGG_0007Data(){
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