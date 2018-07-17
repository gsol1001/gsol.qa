/**
 * This class contains a method for RFI Form - field test
 * Created: Mon 12 Dec 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/12/14
 * 
 * @TestCaseID 11J
 * @TestArea RFI Form
 * @TestScenarioDesc RFI form from Static Form
 * @TestStep
 * 
 * 		Pre-req: Login to GSOL using following information before starting the test:
 * 		email: autoqa_gsol1001@gmail.com
 * 		password: asdf9876

 * 		1. Go to any of the following entry point, mouse over to any PP image:
 * 		   - PA Landing page
 * 		   - L3
 * 		   - L4
 * 		   - KWS
 * 		2. Click on the "Product List" tab.
 * 		3. Click on the Inquire Now button in Rollover Large Image.
 * 		4. Click on the "To:  1 verified supplier (1 product)" link.
 */

package testCases.ModuleRFI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.BrowseProductCategories_Action;
import appModules.InquiryForm_Action;
import appModules.ProductInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.ProductListing_Page;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;

/**
 * This test case contain method to test RFI form from Rollover Image (L3 entry point).
 * @author Teng Shyh Wei
 *
 */
public class RFI_Form_0009 extends SuiteBaseRFI{
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
		FilePath = TestCaseListExcel_SuiteRFI_014_TestData;
		FilePath_TestResult = RFI_Form_0009_TestResult;
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
	@Test(dataProvider="RFI_Form_0009Data")
	public void RFI_Form_0009Test(String dataTestCaseName, 
			String dataUsername,
			String dataPassword,
			String dataSearchKeyword,
			String dataCategoryKeyword) throws Exception{
		
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

    		// Store the current window handle
    		String parentHandle = driver.getWindowHandle();
    		
			// 1. Go to any of the following entry point, mouse over to any PP image:
			// - PA Landing page, - L3, - L4, or - KWS
			
			// As a logged-in user, perform a product keyword search and click on "Browse Product Categories" link.
			BrowseProductCategories_Action.ExecuteLoggedIn_BrowsePdtCategoriesEntryPoint(dataUsername, dataPassword, dataSearchKeyword);
			
			// Switch to new window opened
			switchToNewWindowOpened();					
			
			// Go to L3 entry point.
			ProductInquiry_Action.ExecuteL3EntryPoint(dataCategoryKeyword);
			
    		// 2. Click on the "Product List" tab.
    	//	ProductListing_Page.tab_clickProductList().click();
    		
    		// Select "List View" icon.
    	//	ProductListing_Page.icon_selectListView();
    		
			// Click on "Supplier List" tab
			ProductListing_Page.tab_clickSupplierList().click();
			
			// Store the Supplier Name value	
			// (//*[@id='unverifpparea']//a)[position()=1]
    		// (//*[contains(@class, 'supplierTit')])[position()=1]
    		// (//*[contains(@class, 'detail_name')])[position()=1]		// MR#46889
			WebElement selectedElement = driver.findElement(By.xpath("(//*[contains(@class, 's_supName')])[position()=1]"));			
			String suppName = selectedElement.getText();
    		Add_Log.info("Inquired Verified Supplier is ::" + suppName);		    		
    		    
    		// Due to Bug#85, move the mouse to temp fixed the issue
    		ProductListing_Page.btn_mouseoverToSearchBtn();
    		
    		// Click on the 'Matching products' link.
    		ProductListing_Page.lnk_clickMatchingProducts().click();
    		
			// To verify that Rollover Large Image is displayed when mouse over to any PP image
    	//	ProductListing_Page.img_rolloverLargerImageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			    	
			// 3. Click on the Inquire Now button below the Rollover Large Image.
			ProductListing_Page.btn_clickInqNowOnRolloverImage();
    	//	ProductListing_Page.btn_clickInqNowOnRolloverImagePdtListTab();
    		
    		// To verify RFI form is displayed. Verified that user's contact details are pre-populated
    		InquiryForm_Action.check_RFIFormIsDisplayed_UserContactDetailsArePrepopulated(
    				FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataUsername);			
    		
			// 4. Click on the "To: 1 verified supplier (1 product)" link.								        										
			InquiryForm_Page.lnk_clickToVerifiedSupplier().click();
			
			// Switch to new window opened
		//	switchToNewWindowOpened();			
			
			// To verify RFI Inquiry Details window is displayed.
		//	InquiryForm_Page.check_RFIInqDetailsWindowIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// To verify that the PP in the RFI Inquiry Details window is tally with the PP in Product Search page
			InquiryForm_Page.check_PPVerSuppIsMatch(FilePath_TestResult, TestCaseName, DataSet+1, testFail, suppName);
						
			// Close opened window and switch back to parent window
		//	switchBackToParentWindow(parentHandle);		

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
	public Object[][] RFI_Form_0009Data(){
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
