/**
 * This class contains a method for RFI Inquiry Basket
 * Created: Thu 30 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/29
 * 
 * @TestCaseID 1143 / 17B
 * @TestArea RFI Inquiry Basket
 * @TestScenarioDesc Inquiry Basket (RFI)
 * @TestStep
 * 
 * 		Pre-req: There are more than 1 products and suppliers in the inquiry basket
 * 
 * 		1. Go to Inquiry Basket page.
 * 		2. Verify that the checkboxes for each products and suppliers are checked as default.
 * 		3. Verify that the PPs and suppliers are sorted by supplier name in alphabetical order.
 * 		4. Click on "Sort" icon in Supplier Name column.
 * 		5. Click on "Filter" link in Supplier Name column.
 * 		6. Select any supplier name in filter page and click on "Filter button".
 * 		7. Unfilter the result by clicking on the "Filter" link and "Show All" button in filter page.
 * 		8. Click on "Filter by Product Category" link in Products column.
 * 		9. Select any category in filter page and click on "Filter button".
 * 		10. Unfilter the result by clicking on the "Filter" link and "Show All" button in filter page.
 * 		11. Click on "Sort" icon in Date Added column.
 * 		12. Click on "Filter" link in Date Added column.
 * 		13. Select any date in filter page and click on "Filter button".
 * 		14. Unfilter the result by clicking on the "Filter" link and "Show All" button in filter page.
 * 		15. Click on the any dustbin icon to remove a PP/supplier.
 * 		16. Click on "Remove All" link.
 * 		17. Click on "Cancel" button.
 * 		18. Click on "Remove All" link.
 * 		19. Click on "OK" button.
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

import appModules.ProductInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryBasket_Page;
import pageObjects.ProductListing_Page;
import pageObjects.SupplierHome_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test view basket workflow and inquiry basket page test
 * @author Teng Shyh Wei
 *
 */
public class RFI_InqBasket_0002 extends SuiteBaseRFI{
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
	//private final static String COUNT_PATTERN = "//*[@id='navcount']";
	private final static String SUPP_NAME_PATTERN = 
			"//*[contains(@class, 'listing_table_row inqBsk_row')]/li[3]/p[1]";
	private final static String DATE_PATTERN = 
			"//*[contains(@class, 'listing_table_row inqBsk_row')]/li[4]";
//	private final static String PDT_CAT_PATTERN = 
//			"//*[contains(@class, 'listing_table_row inqBsk_row')]/li[2]/p[1]";
//	private final static String FILTER_BTN_PATTERN = "//*[@name='filterVal']/option[1]";
		
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
		FilePath_TestResult = RFI_InqBasket_0002_TestResult;
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
	@Test(dataProvider="RFI_InqBasket_0002Data")
	public void RFI_InqBasket_0002Test(String dataTestCaseName, 
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
			// Make sure the Inquiry Basket cart is empty
			InquiryBasket_Page.check_cleanUpInqBasketItems();
			
			// Pre-req: There are more than 1 products and suppliers in the inquiry basket																
		//	InquiryBasket_Action.ExecuteRFIForm_AddPdtSuppIntoInqBasket(dataPdtSearchKeyword, dataSuppSearchKeyword);    		
			
			// Add more than 1 products into the inquiry basket
		//	ProductInquiry_Action.ExecuteSelectMulVerPdt_ClickAddToBasketBtn(dataPdtSearchKeyword);
			
			// Enter search keyword by select Products Page Types
			ProductInquiry_Action.ExecuteSearchByProducts(dataPdtSearchKeyword);
			ProductListing_Page.tab_clickSupplierList().click();
			ProductListing_Page.btn_clickMultipleAddToBasket();
			
			// Go to Verified Supplier Marketing Homepage		
			ProductListing_Page.lnk_clickSupplierNameTitle().click();
			SupplierHome_Page.lnk_clickOnSelectAll();
			SupplierHome_Page.btn_clickAddToBasketOnLatestProducts();
			
			// Due to page optimization, waits for 10 seconds
			Thread.sleep(10000);
			Add_Log.info("Waits for 10 seconds.");
		//	TopNav_MenuBar.check_topMenuBarIsVisible();
			
			// Add more than 1 suppliers into the inquiry basket
		//	SupplierInquiry_Action.ExecuteSelectMulVerSupp_ClickAddToBasketBtn(dataSuppSearchKeyword);
						
			
			// 1. Go to Inquiry Basket page.
			ProductListing_Page.lnk_clickGlobalNavAddToBasketIcon().click();
			
			// Due to page optimization, waits for 3 seconds
			Thread.sleep(3000);
			Add_Log.info("Waits for 3 seconds.");
			
			// To verify Inquiry Basket page is displayed.
			InquiryBasket_Page.check_inqBasketPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Select 60 Items per page
			ProductListing_Page.drpdwn_select60ItemsPerPage();	
			
			// Store Supplier Name added to Inquiry Basket
		//	InquiryBasket_Page.store_defaultSuppNameList(driver, defaultSuppNameList);
			WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> suppliersNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SUPP_NAME_PATTERN)));
    		
    		List<String> defaultSuppNameList = new ArrayList<String>();
			for (WebElement element : suppliersNameList){
				Add_Log.info("defaultSuppNameList ::" + element.getText());
				defaultSuppNameList.add(element.getText());
			}	
			
    		
		/*	// Store Product Category added to Inquiry Basket
			List<WebElement> categoryList = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PDT_CAT_PATTERN)));
			
			List<String> defaultCategoryList = new ArrayList<String>();
			for (WebElement element : categoryList){
				Add_Log.info("defaultCategoryList ::" + element.getText());
				defaultCategoryList.add(element.getText());
			}
		*/	
			
			// Store Date available on the Inquiry Basket page
			List<WebElement> dateList = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DATE_PATTERN)));
			
			List<String> defaultDateList = new ArrayList<String>();
			for (WebElement element : dateList){
			//	Add_Log.info("defaultDateList" + element.getText());
				defaultDateList.add(element.getText());
			}
			
			// 2. To verify that the checkboxes for each products and suppliers are checked as default.
			InquiryBasket_Page.check_allInquiryBasketChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
						
			// 4. Click on "Sort" icon in Supplier Name column.
			InquiryBasket_Page.lnk_clickSortBySupplierName().click();
			
			// To verify the PPs and suppliers are sorted by supplier name in descending alphabetical order
			InquiryBasket_Page.check_suppNameSortByDescending(FilePath_TestResult, TestCaseName, DataSet+1, testFail);	
			
			// 3. Verify that the PPs and suppliers are sorted by supplier name in ascending alphabetical order.
			InquiryBasket_Page.lnk_clickSortBySupplierName().click();	// added
			InquiryBasket_Page.check_suppNameSortByAscending(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
						
		/*	// Store the current window handle
			String parentHandle = driver.getWindowHandle();	
						
			// 5. Click on "Filter" link in Supplier Name column.
			InquiryBasket_Page.lnk_clickFilterBySuppName().click();										
			
			// Switch to new window opened
			switchToNewWindowOpened_FilterProductsPage();
			
			// 6. Select any supplier name in filter page and click on "Filter button".
			WebElement filteredSuppName = driver.findElement(By.xpath(FILTER_BTN_PATTERN));			
			filteredSuppName.click();
			String selectedSuppName = filteredSuppName.getText();
    		Add_Log.info("Selected Supplier Name::" + selectedSuppName);
    		
			InquiryBasket_Page.btn_clickFilterOnFilterProductsPage().click();
			
			// Switch back to parent window
			switchBackToParentWindow_InquiryBasketPage(parentHandle);
			
			// To verify Inquiry Basket page is refreshed with only results from selected suppliers are displayed.
			InquiryBasket_Page.check_onlySelectedSuppDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, selectedSuppName);			
    															
			// 7. Unfilter the result by clicking on the "Filter" link and "Show All" button in filter page.
			InquiryBasket_Page.lnk_clickFilterBySuppName().click();
			
			// Switch to new window opened
			switchToNewWindowOpened_FilterProductsPage();
			
			InquiryBasket_Page.btn_clickShowAllOnFilterProductsPage().click();
			
			// Switch back to parent window
			switchBackToParentWindow_InquiryBasketPage(parentHandle);
			
			// To verify Inquiry Basket page is refreshed with all the added items are displayed.
			InquiryBasket_Page.check_allAddedSuppItemsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, defaultSuppNameList);					

			
						
			// 8. Click on "Filter by Product Category" link in Products column.
			InquiryBasket_Page.lnk_clickFilterByProductCategory().click();
						
			// Switch to new window opened
			switchToNewWindowOpened_FilterProductsPage();
			
			// 9. Select any category in filter page and click on "Filter button".
			WebElement filteredCategoryName = driver.findElement(By.xpath(FILTER_BTN_PATTERN));
			filteredCategoryName.click();
			String selectedCategoryName = filteredCategoryName.getText();
			Add_Log.info("Selected Category Name ::" + selectedCategoryName);
			
			InquiryBasket_Page.btn_clickFilterByPdtCatOnFilterProductsPage().click();
			
			// Switch back to parent window
			switchBackToParentWindow_InquiryBasketPage(parentHandle);
			
			// To verify Inquiry Basket page is refreshed with only results from selected category are displayed.
			InquiryBasket_Page.check_onlySelectedCategoryDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, selectedCategoryName);												
					
			// 10. Unfilter the result by clicking on the "Filter" link and "Show All" button in filter page.
			InquiryBasket_Page.lnk_clickFilterByProductCategory().click();
			
			// Switch to new window opened
			switchToNewWindowOpened_FilterProductsPage();
			
			InquiryBasket_Page.btn_clickShowAllPdtCatOnFilterProductsPage().click();
			
			// Switch back to parent window
			switchBackToParentWindow_InquiryBasketPage(parentHandle);
			
			// To verify Inquiry Basket page is refreshed with all the added category items are displayed.
			InquiryBasket_Page.check_allAddedCategoryItemsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, defaultCategoryList);			    		
		*/	
			
			
			// 11. Click on "Sort" icon in Date Added column.
			InquiryBasket_Page.lnk_clickSortByDateAdded().click();
			
			// To verify the PPs and suppliers are sorted by date in descending order.
			InquiryBasket_Page.check_suppNameSortByDateDescending(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
							
		/*	// 12. Click on "Filter" link in Date Added column.
			InquiryBasket_Page.lnk_clickFilterByDateAdded().click();
			
			// Switch to new window opened
			switchToNewWindowOpened_FilterProductsPage();
			
			// 13. Select any date in filter page and click on "Filter button".	
			WebElement filteredDate = driver.findElement(By.xpath(FILTER_BTN_PATTERN));
			filteredDate.click();
			String selectedDate = filteredDate.getText();
			Add_Log.info("Selected Date ::" + selectedDate);
			
			InquiryBasket_Page.btn_clickFilterByDateOnFilterProductsPage().click();
			
			// Switch back to parent window
			switchBackToParentWindow_InquiryBasketPage(parentHandle);
			
			// To verify Inquiry Basket page is refreshed with only results from selected date are displayed.
			InquiryBasket_Page.check_onlySelectedDateDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, selectedDate);
			
			

			// 14. Unfilter the result by clicking on the "Filter" link and "Show All" button in filter page.
			InquiryBasket_Page.lnk_clickFilterByDateAdded().click();
			Add_Log.info("Click on the filter link");
			
			// Switch to new window opened
			switchToNewWindowOpened_FilterProductsPage();
			
			InquiryBasket_Page.btn_showAllDateOnFilterProductsPage().click();
			
			// Switch back to parent window
			switchBackToParentWindow_InquiryBasketPage(parentHandle);
			
			// To verify Inquiry Basket page is refreshed with all the added items are displayed.
			InquiryBasket_Page.check_allAddedItemsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, defaultDateList);			
		*/	
			
			
			String countInqBasket = driver.findElement(By.id("navcount")).getText();			
			int countInqBasketbefore = Integer.parseInt(countInqBasket.substring(1, countInqBasket.length()-1));
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketbefore);
			
			// 15. Click on the any dustbin icon to remove a PP/supplier.
			InquiryBasket_Page.icon_clickDustbin().click();
			Add_Log.info("Click on dustbin icon to remove a PP/Supplier.");
			
			// To verify PP/Supplier is removed from Inquiry Basket.
	//		InquiryBasket_Page.check_selectedPPSuppIsRemoved(FilePath_TestResult, TestCaseName, DataSet+1, testFail, countInqBasketbefore);	
			
			String countInqBasketAgain = driver.findElement(By.id("navcount")).getText();
			int countInqBasketAfter = Integer.parseInt(countInqBasketAgain.substring(1, countInqBasketAgain.length()-1));
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketAfter);			
			
			if(countInqBasketAfter == countInqBasketbefore - 1){
				InquiryBasket_Page.check_selectedPPSuppIsRemoved(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			}else{
				InquiryBasket_Page.check_selectedPPSuppIsNotRemoved(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			}
			

			
			// 16. Click on "Remove All" link. 
			// To verify a pop up window with message 'Are you sure you want to remove all items in inquiry basket?' is displayed
			// 17. Click on "Cancel" button.
			InquiryBasket_Page.lnk_clickRemoveAll_ClickCancelToReject(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// To verify Inquiry Basket page with all the added items are displayed
			String countInqBasketCancel = driver.findElement(By.id("navcount")).getText();
			int countInqBasketCancelToReject = Integer.parseInt(countInqBasketCancel.substring(1, countInqBasketCancel.length()-1));
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketCancelToReject);
			
			if(countInqBasketCancelToReject == countInqBasketAfter){
				InquiryBasket_Page.check_allAddedItemsAreDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);				
			}else{
				InquiryBasket_Page.check_allAddedItemsAreNotDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);				
			}
			
			// 18. Click on "Remove All" link.
			// To verify a pop up window with message 'Are you sure you want to remove all items in inquiry basket?' is displayed
			// 19. Click on "OK" button.
			InquiryBasket_Page.lnk_clickRemoveAll_ClickOKToAccept(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
	
			// To verify the Inquiry Basket is refreshed. All the items are removed from the basket and message 'Your inquiry basket is empty' is displayed.
			InquiryBasket_Page.check_allAddedItemsRemoved(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryBasket_Page.check_msgYourInqBasketIsEmpty(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
	public Object[][] RFI_InqBasket_0002Data(){
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

