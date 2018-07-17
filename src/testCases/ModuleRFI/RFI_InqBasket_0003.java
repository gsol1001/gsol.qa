/**
 * This class contains a method for RFI Inquiry Basket
 * Created: Thu 30 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/29
 * 
 * @TestCaseID 1144 / 17C
 * @TestArea RFI Inquiry Basket
 * @TestScenarioDesc Inquiry Basket (RFI)
 * @TestStep
 * 
 * 		Pre-req: Login to GSOL using following information before starting the test:
 * 		email: autoqa_gsol1001@gmail.com
 * 		password: asdf9876
 * 		Add more than 1 products and suppliers into the inquiry basket
 * 
 * 		1. Go to Inquiry Basket page.
 * 		2. Verify that the checkboxes for each products and suppliers are checked as default.
 * 		3. Uncheck all the checkboxes for products and suppliers.
 * 		4. Check the checkbox on ONE product and click on "Inquire Now" button.
 * 		5. Fill up and submit the RFI form.
 * 		6. Go back to Inquiry Basket page.
 * 		7. Verify that the inquired PP is removed from the basket.
 * 		8. Verify that the checkboxes for each products and suppliers are checked as default.
 * 		9. Make sure all the checkboxes are check and click on the "Inquire Now" button.
 * 		10. Fill up and submit the RFI form.
 * 		11. Go back to Inquiry Basket page.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleRFI;

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

import appModules.InquiryBasket_Action;
import appModules.ProductInquiry_Action;
import appModules.SignIn_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryBasket_Page;
import pageObjects.InquiryForm_Page;
import pageObjects.ProductListing_Page;
import pageObjects.RFIConfirmation_Page;
import pageObjects.TopNav_MenuBar;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test Inquiry Basket (RFI)
 * @author Teng Shyh Wei
 *
 */
public class RFI_InqBasket_0003 extends SuiteBaseRFI{
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
//	private final static String SUPP_NAME_PATTERN = 
//			"//*[contains(@class, 'listing_table_row inqBsk_row')]/li[2]/p[1]";
	private final static String SUPP_NAME_PATTERN = 
			"//*[contains(@class, 'listing_table_row inqBsk_row')]/li[3]/p[1]";
	
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
		FilePath = TestCaseListExcel_SuiteRFI_013_TestData;
		FilePath_TestResult = RFI_InqBasket_0003_TestResult;
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
	@Test(dataProvider="RFI_InqBasket_0003Data")
	public void RFI_InqBasket_0003Test(String dataTestCaseName, 
			String dataUsername, 
			String dataPassword, 
			String dataPdtPageTypes,
			String dataPdtSearchKeyword, 
			String dataSuppPageTypes,
			String dataSuppSearchKeyword, 
			String dataMessage) throws Exception{
		
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
			
			// Pre-req: Login to GSOL and add more than 1 products and suppliers into the inquiry basket
			SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);	
			
			// Make sure the Inquiry Basket cart is empty
			InquiryBasket_Page.check_cleanUpInqBasketItems();
			
			// Add more than 1 products and suppliers into the inquiry basket
		//	InquiryBasket_Action.ExecuteRFIForm_AddPdtSuppIntoInqBasket(dataPdtSearchKeyword, dataSuppSearchKeyword);

			// Add more than 1 products into the inquiry basket
		//	ProductInquiry_Action.ExecuteSelectMulVerPdt_ClickAddToBasketBtn(dataPdtSearchKeyword);
			
		//	TopNav_MenuBar.check_topMenuBarIsVisible();
			
			// Add more than 1 suppliers into the inquiry basket
		//	SupplierInquiry_Action.ExecuteSelectMulVerSupp_ClickAddToBasketBtn(dataSuppSearchKeyword);
			
			ProductInquiry_Action.ExecuteSearchByProducts(dataPdtSearchKeyword);
			ProductListing_Page.tab_clickSupplierList().click();
			ProductListing_Page.btn_clickMultipleAddToBasket();
			
			// 1. Go to Inquiry Basket page.
			ProductListing_Page.lnk_clickGlobalNavAddToBasketIcon().click();
			
			// To verify Inquiry Basket page is displayed.
			InquiryBasket_Page.check_inqBasketPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Select 60 Items per page
			ProductListing_Page.drpdwn_select60ItemsPerPage();	
						
			// Store Supplier Name added to Inquiry Basket
			WebDriverWait wait = new WebDriverWait(driver, 15);
			List<WebElement> suppliersNameList = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SUPP_NAME_PATTERN)));
						
			List<String> defaultSuppNameList = new ArrayList<String>();
			for (WebElement element : suppliersNameList){
				Add_Log.info("defaultSuppNameList ::" + element.getText());
				defaultSuppNameList.add(element.getText());
			}
			
			// 2. To verify that the checkboxes for each products and suppliers are checked as default.
			InquiryBasket_Page.check_allInquiryBasketChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 3. Uncheck all the checkboxes for products and suppliers
			InquiryBasket_Page.chkbx_uncheckedAllInqBasket();
			
			// To verify all the Inquiry Basket checkboxes are unchecked.
			InquiryBasket_Page.check_allInqBasketChkbxNotSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Check the checkbox on ONE product and click on 'Inquire Now' button.
			InquiryBasket_Page.chkbx_selectOneInqBasket().click();			
			InquiryBasket_Page.btn_clickInqNowAtInquiryBar().click();
						
			// 5. Fill up and submit the RFI form
			// To verify RFI Confirmation page is displayed
			// 6. Go back to Inquiry Basket page.
			InquiryBasket_Action.ExecuteRFIForm_FillUpAndSubmitRFIForm(dataMessage, FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			// Select 60 Items per page
			ProductListing_Page.drpdwn_select60ItemsPerPage();	
			
			// 7. To verify that the inquired PP is removed from the basket.
			InquiryBasket_Page.check_inquiredPPIsRemoved(FilePath_TestResult, TestCaseName, DataSet+1, testFail, defaultSuppNameList);			
			
			// 8. To verify that the checkboxes for each products and suppliers are checked as default.
			InquiryBasket_Page.check_allInqBasketChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// 9. Make sure all the checkboxes are check and click on the 'Inquire Now' button.
			InquiryBasket_Page.btn_clickInqNowAtInquiryBar().click();
			
			// 10. Fill up and submit the RFI form
			InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
			InquiryForm_Page.btn_clickContactSupplierNow();
						
			// To verify is RFI Confirmation page displayed
			RFIConfirmation_Page.check_RFIConfirmationPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			    		
			// 11. Go back to Inquiry Basket page.
			TopNav_MenuBar.lnk_backToGSOLHomePage();
			ProductListing_Page.lnk_clickGlobalNavAddToBasketIcon().click();
						
			// To verify the Inquiry Basket is refreshed. All the items are removed from the basket and message 'Your inquiry basket is empty' is displayed.
			InquiryBasket_Page.check_allAddedItemsRemoved(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryBasket_Page.check_msgYourInqBasketIsEmpty(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// To capture Inquiry Basket page screen shot
			captureInquiryBasketPageScreenShot();
			
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
	public Object[][] RFI_InqBasket_0003Data(){
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
