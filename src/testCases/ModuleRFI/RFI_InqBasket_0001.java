/**
 * This class contains a method for RFI Inquiry Basket
 * Created: Thu 30 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/29
 * 
 * @TestCaseID 1142 / 17A
 * @TestArea RFI Inquiry Basket
 * @TestScenarioDesc Inquiry basket count and the add to basket workflow
 * @TestStep
 * 
 * Pre-req: Login to GSOL using following information before starting the test:
 * email: autoqa_gsol1001@gmail.com
 * password: asdf9876
 * Add more than 1 products and suppliers into the inquiry basket
 * 
 * 		1. From any of the entry point listed below, check on one or more products and click on the 'Add to Basket' button:
 * 		   a) KWS page
 * 		   b) L1, L2, L3 or L4 page
 * 		   c) NP page
 * 		   d) TP page
 * 		   e) TCS page
 * 		   f) PA Landing page
 * 		   g) Supplier MW
 * 		2. Click on either the product name or image of a product that is not added to basket
 * 		3. Click on the 'Add' button
 * 		4. From any of the entry point listed below, check on one or more suppliers and click on the 'Add to Basket' button:
 * 		   a) Product KWS page (compare all supplier view)
 * 		   b) Supplier KWS page
 * 		   c) L3 or L4 page (compare all supplier view)
 * 		   f) TP Supplier List page
 * 		   e) TCS Supplier List page
 * 		5. Click on any supplier name that is not added to basket to go to Supplier MW
 * 		6. Click on the 'Add to basket' button on the top right of the page.
 * 		7. Repeat Step 1 to add until there are more than 50 products/suppliers in the basket
 * 		8. Clear Cookies on the browser and close and relaunch browser
 * 		9. Check that there should be no count beside the  'Inquiry basket' in the Global navigation are correct in the following pages:
 * 		   - GSOL Homepage
 * 		   - any product vertical pages 
 *         - any dynamic pages e.g. kws result pages.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleRFI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.ProductInquiry_Action;
import appModules.SupplierHome_Action;
import appModules.SupplierInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.InquiryBasket_Page;
import pageObjects.ProductListing_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.SupplierHome_Page;
import pageObjects.SupplierListing_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test Inquiry basket count and the add to basket workflow
 * @author Teng Shyh Wei
 *
 */
public class RFI_InqBasket_0001 extends SuiteBaseRFI{
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
	private final static String COUNT_PATTERN = "navcount";
	
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
		FilePath_TestResult = RFI_InqBasket_0001_TestResult;
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
	@Test(dataProvider="RFI_InqBasket_0001Data")
	public void RFI_InqBasket_0001Test(String dataTestCaseName, 
			String dataPdtSearchKeyword, 
			String dataSuppSearchKeyword, 
			String dataMWSearchKeyword) throws Exception, NumberFormatException{
		
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
			
			// 1. From any of the entry point listed below, check on one or more products and click on the 'Add to Basket' button
			// (KWS page, L1,L2, L3 or L4 page, NP page, TP page, TCS page, PA Landing page, Supplier MW)				
			
			// 'Add to Basket' for multiple verified products, 
			ProductInquiry_Action.ExecuteInqBasket_SelectMulVerPdtChkbx(dataPdtSearchKeyword);			
			
			List<WebElement> chkbxVerPdt = driver.findElements(
    				By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox' ]"));
    		int chkbxVerPdtSelected = chkbxVerPdt.size();
    		Add_Log.info("Total verified products chkbx selected ::" + chkbxVerPdtSelected);
    		    	
			// Click Add to Basket
    		ProductListing_Page.lnk_clickAddToBasketInqBar().click();
						
			// To verify a 'Added' is seen instead of checkboxes on those selected products.
			// Check that the count (red in color) beside the 'Inquiry basket' in the Global navigation tally the number of products added.			
    		ProductListing_Page.check_btnAddedIsSeen_selectedPdtChkbxHidden(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		ProductListing_Page.check_inqBasketCountIsRed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
	//		ProductListing_Page.check_inqBasketCountMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail, chkbxVerPdtSelected);
			
			String countInqBasketVerPdt = driver.findElement(By.id(COUNT_PATTERN)).getText();			
			int countInqBasketForVerPdt = Integer.parseInt(countInqBasketVerPdt.substring(1, countInqBasketVerPdt.length()-1));		// ignore '(' and ')'
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketForVerPdt);			
    		
    		if(countInqBasketForVerPdt == chkbxVerPdtSelected){    			
    			ProductListing_Page.check_inqBasketCountIsMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		}else{
    			ProductListing_Page.check_inqBasketCountNotMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		}    		
    		
    		
    		// Store Supplier Name	    	
    		WebElement pdtElement = driver.findElement(By.xpath("(//*[contains(@class, 's_supName')]//a)[position()=1]"));
    		String getPdtName = pdtElement.getText();
    		Add_Log.info("Selected supplier name ::" + getPdtName);
    		
			// 2. Click on either the product name of image of a product that is not added to basket.
    		ProductListing_Page.img_clickOnRolloverLargerImage();
    		
    		// To verify the GSOL PP page/ Supplier PP page is displayed
    		ProductProfile_Page.check_GSOLPPpageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getPdtName);
    		
			// 3. Click on the 'Add" button
			ProductProfile_Page.btn_clickAddToBasket().click();
    								
			// To verify 'Add to Basket' button is changed to 'Added to Basket'
	//		ProductListing_Page.check_btnChangedToViewBasket(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			String btnAddedToBasketPdt = driver.findElement(
    				By.xpath("//*[contains(@class, 'wt_basket')]//span[contains(text(),'Added to Basket')]")).getText();
			Add_Log.info("Pdt button text ::" + btnAddedToBasketPdt);
			
			String countInqBasketVerPdtPlusOne = driver.findElement(By.id(COUNT_PATTERN)).getText();
			int countInqBasketVerPdtAfterPlusOne = Integer.parseInt(countInqBasketVerPdtPlusOne.substring(1, countInqBasketVerPdtPlusOne.length()-1));
			Add_Log.info("Count beside Inquiry basket after plus one ::" + countInqBasketVerPdtAfterPlusOne);
			
			int totalChkbxVerPdtSelected = countInqBasketForVerPdt + 1;
			Add_Log.info("Total verified products chkbx selected after plus one ::" + totalChkbxVerPdtSelected);
			
			if(btnAddedToBasketPdt.contains("Added to Basket") && countInqBasketVerPdtAfterPlusOne == totalChkbxVerPdtSelected){
				Add_Log.info("'Add To Basket' button is changed to 'Added to Basket'");
				Add_Log.info("Passed. Total count products is correct" + "\n ");
				SuiteUtility.WriteResultUtility(
						FilePath_TestResult, TestCaseName, Constant.COL_PP_PAGE_BTN_ADDED_TO_BASKET, DataSet+1, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("'Add To Basket' button is NOT changed to 'Added to Basket'");
				Add_Log.info("Failed. Total count products is NOT correct");
				SuiteUtility.WriteResultUtility(
						FilePath_TestResult, TestCaseName, Constant.COL_PP_PAGE_BTN_ADDED_TO_BASKET, DataSet+1, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
			
			
								
			// 4. From any of the entry point listed below, check on one or more suppliers and click on the 'Add to Basket' link/button
    		// (Product KWS page (compare all supplier view), Supplier KWS page, L3 or L4 page (compare all supplier view), 
    		// TP Supplier List page, TCS Supplier List page)    		
    		
			// 'Add to Basket' for multiple verified suppliers 			
    		SupplierInquiry_Action.ExecuteSelectMulVerSupp(dataSuppSearchKeyword);
    		    		
    	/*	// Enter search keyword by select Suppliers Page Types
    		SupplierInquiry_Action.ExecuteSearchBySuppliers(driver, dataSuppSearchKeyword);
    		
    		List<WebElement> chkbxSupp = 
    				driver.findElements(By.xpath("//*[contains(@class, 'supplierName_tit')]//input[@type='checkbox']"));

    		for(int i=1; i<chkbxSupp.size(); i=i+2){
    			chkbxSupp.get(i).click();
    		}
    		
    		int checkedCount = 0, uncheckedCount = 0;
    		for(int i=1; i<chkbxSupp.size(); i++){
    			Add_Log.info(i + " checkbox is selected ::" + chkbxSupp.get(i).isSelected());
    			if(chkbxSupp.get(i).isSelected()){
    				checkedCount++;
    			}else{
    				uncheckedCount++;
    			}
    			Add_Log.info("Number of selected chkbx ::" + checkedCount);
    			Add_Log.info("Number of unselected chkbx ::" + uncheckedCount);
    		}
    	*/	
    		
    		List<WebElement> chkbxVerSupp = 
    				driver.findElements(By.xpath("//*[contains(@class, 'supplierName_tit')]//input[@type='checkbox']"));
    		int chkbxVerSuppSelected = chkbxVerSupp.size();
    		Add_Log.info("Total verified suppliers chkbx selected ::" + chkbxVerSuppSelected);	
    		
    		// Click Add to Basket
    		SupplierListing_Page.btn_clickAddToBasketInquiryBar().click();
    		    		    		
			// To verify a 'Added to basket' is seen instead of checkboxes on those selected suppliers.
			// Check that the count (red in color) beside the 'Inquiry basket' in the Global navigation tally the number of products added.
    		SupplierListing_Page.check_btnAddedToBasketIsSeen_selectedPdtChkbxHidden(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
    		SupplierListing_Page.check_inqBasketCountIsRed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
    		String countInqBasketVerSupp = driver.findElement(By.id(COUNT_PATTERN)).getText();
			int countInqBasketForVerSupp = Integer.parseInt(countInqBasketVerSupp.substring(1, countInqBasketVerSupp.length()-1));
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketForVerSupp);			
    		
			int totalChkbxSelected = totalChkbxVerPdtSelected + chkbxVerSuppSelected;
	//		int totalChkbxSelected = totalChkbxVerPdtSelected + checkedCount;
			Add_Log.info("Total chkbx verified products and suppliers selected ::" + totalChkbxSelected);
			
    		if(countInqBasketForVerSupp == totalChkbxSelected){
    			SupplierListing_Page.check_inqBasketTotalCountIsMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		}else{
    			SupplierListing_Page.check_inqBasketTotalCountNotMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail);    			
    		}    		
    		
    		
    		    		
    		// Store Supplier Name
            WebElement suppElement = driver.findElement(By.xpath("(//*[contains(@class, 'supplierName_tit')]//a)[position()=1]"));
            String getSuppName = suppElement.getText();
            Add_Log.info("Selected supplier name ::" + getSuppName);
            
			// 5. Click on any supplier name that is not added to basket to go to Supplier MW
            SupplierListing_Page.lnk_clickSupplierName().click();
    		
    		// To verify Supplier MW Homepage is displayed
    		SupplierHome_Page.check_suppMWHomepageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);                        
            
			// 6. Click on the 'Add to basket' button on the top right of the page.
    //		SupplierHome_Page.btn_clickAddToBasket().click();
    		SupplierHome_Page.btn_clickAddToBasketInRolloverImage();
    		
    		// To verify 'Add to Basket' button is changed to 'Added to Basket'.
    		String countInqBasketVerSuppPlusOne = driver.findElement(By.id(COUNT_PATTERN)).getText();
    		int countInqBasketVerSuppAfterPlusOne = Integer.parseInt(countInqBasketVerSuppPlusOne.substring(1, countInqBasketVerSuppPlusOne.length()-1));
    		Add_Log.info("Count beside Inquiry basket after plus one ::" + countInqBasketVerSuppAfterPlusOne);
    		
    		int totalChkbxVerSuppSelected = countInqBasketForVerSupp + 1;
    		Add_Log.info("Total verified suppliers chkbx selected after plus one ::" + totalChkbxVerSuppSelected);
    		
    		if(countInqBasketVerSuppAfterPlusOne == totalChkbxVerSuppSelected){
    			Add_Log.info("Passed. Total count suppliers is correct" + "\n ");
    			SuiteUtility.WriteResultUtility(
    					FilePath_TestResult, TestCaseName, Constant.COL_MW_PAGE_BTN_ADDED_TO_BASKET, DataSet+1, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. Total count suppliers is NOT correct");
    			SuiteUtility.WriteResultUtility(
    					FilePath_TestResult, TestCaseName, Constant.COL_MW_PAGE_BTN_ADDED_TO_BASKET, DataSet+1, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}	
    		
    		
    		    		    		
			// 7. Repeat Step 1 to add until there are more than 50 products/suppliers in the basket.
    		SupplierHome_Action.ExecuteInqBasket_AddMorePdtSupp(dataMWSearchKeyword);    		
			
    		// To verify the count (in red) beside the 'Inquiry basket' in the Global navigation should indicate '50+'
            InquiryBasket_Page.check_countInqBasket50Plus(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
            
			// 8. Clear Cookies on the browser and close and relaunch browser
   //       Home_Page.clearCookies_CloseAndRelaunchBrowse(driver);
            driver.manage().deleteAllCookies();			// Clear Cookies on the browser
            driver.navigate().refresh();
			driver.close();								// Close a single browser window
			
			ProfilesIni firProfiles = new ProfilesIni();		
			FirefoxProfile wbdrverprofile = firProfiles.getProfile("default");			
			driver = new FirefoxDriver(wbdrverprofile);					
			driver.get("http://www.globalsources.com/");						
							
			// To verify browser is relaunched
			Add_Log.info("Firefox is relaunched");
			
			// 9. Check that there should no count beside the 'Inquiry basket' in the Global navigation are correct in the following page 
			// (GSOL Homepage, any product vertical pages, any dynamic pages e.g. kws result pages.) 
			
			// To verify no count is seen beside the 'Inquiry basket' in the Global navigation
	//		Home_Page.check_noCountBesideInqBasket(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// IMPORTANT! if put in common function not working
	//		Boolean isInquiryBasketCartContainItems = driver.findElement(By.xpath("//*[@id='navcount']")).isDisplayed();
			Boolean isInquiryBasketCartContainItems = driver.findElements(By.xpath("//*[@id='navcount']")).size() != 0;
    		if(isInquiryBasketCartContainItems == true){    			
    			Home_Page.check_countIsSeenBesideInqBasket(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		}else{			
    			Home_Page.check_countIsUnseenBesideInqBasket(FilePath_TestResult, TestCaseName, DataSet+1, testFail);    		
    		}			    		
    		
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
	public Object[][] RFI_InqBasket_0001Data(){
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
		//closeWebBrowser();
		
	/*	if(driver != null){
			driver.close();
		}
		ExistingmozillaBrowser=null;	*/		
		
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
