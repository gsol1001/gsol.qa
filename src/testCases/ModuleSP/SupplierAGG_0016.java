/**
 * This class contains a method for Inquire now from Production Promotion section at Supplier AGG Homepage (Login on form)
 * Created: Wed 04 Oct 2017
 * @author Teng Shyh Wei
 * @version 0.1 Date: 2017/10/04
 * 
 * @TestCaseID 43P
 * @TestArea Supplier Profile
 * @TestScenarioDesc Inquire now from Production Promotion section at Supplier AGG Homepage (Login on form)
 * @TestStep
 * 
 * 		1. As a non-logged in user, go to Supplier AGG homepage.
 * 		2. At Production Promotion section, click on any PP image.
 * 		3. Click on "Inquire Now" button at PP info section.
 * 		4. Enter some texts in "Subject" and "Message" fields.
 * 		5. Click on the "Login Now" button.
 * 		6. Fill in E-mail and Password and click on "Login Now" button
 * 		7. Click on "Contact Supplier Now" button.
 * 		
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSP;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

import appModules.InquiryForm_Action;
import appModules.RFIConfirmation_Action;
import appModules.SignIn_Action;
import appModules.SupplierInquiry_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.RFIConfirmation_Page;
import pageObjects.SupplierListing_Page;
import pageObjects.UnvSupplierPP_Page;
import pageObjects.UnvSupplier_Homepage;
import testCases.SuiteBase;

/**
 * This test case contain method to test Inquire now from Production Promotion section at Supplier AGG Homepage (Login on form)
 * @author Teng Shyh Wei
 *
 */
public class SupplierAGG_0016 extends SuiteBaseSP{
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
		FilePath = TestCaseListExcel_SuiteSP_005_TestData;
		FilePath_TestResult = SupplierAGG_0016_TestResult;
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
	@Test(dataProvider= "SupplierAGG_0016Data")
	public void SupplierAGG_0016Test(String dataTestCaseName, 
			String dataSearchKeyword,			
			String dataSubject,
			String dataMessage,
			String dataUsername,
			String dataPassword) throws Exception{
		
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
				
			// 1. As a non-logged in user, go to Supplier AGG homepage.
			
			// Do a Supplier keyword search.
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

			// 2. At Production Promotion section, click on any PP image.
			UnvSupplier_Homepage.img_clickFirstPPImgAtProdPromoSection();
			
			// To verify Unverified Supplier PP page is displayed.
		//	UnvSupplierPP_Page.check_unvSupplierPPPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName, getPPName);
			
			// 3. Click on "Inquire Now" button at PP info section.
			UnvSupplierPP_Page.btn_clickInquireNow().click();
			
			// To verify the RFI form is displayed.
			InquiryForm_Page.check_RFIFormIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Enter some texts in "Subject" and "Message" fields.
			InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
			
			// To verify "Subject" and "Message" fields are entered with text.
			InquiryForm_Page.check_subjectMessageFieldsEnteredWithText(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataSubject, dataMessage);
			
			// 5. Click on the "Login Now" button.
			InquiryForm_Page.btn_clickLoginOnFormLoginNow().click();
			
			// To verify Login overlay is displayed.
			InquiryForm_Page.check_loginOverlayIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
    		// Identify and switch to the Login frame
        	WebElement iframe = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginFrame')]"));
    		driver.switchTo().frame(iframe);    		
    		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		
			// 6. Fill in E-mail and Password and click on "Login Now" button.
			SignIn_Action.ExecuteLoginOnForm_EnterUsernamePassword_ClickLoginNowBtn(dataUsername, dataPassword);
		
			// To verify RFI form is displayed. To verify the texts entered in "Subject" and "Message" fields are remain unchanged.
            InquiryForm_Page.check_textSubjectMessageRemainUnchanged(FilePath_TestResult, TestCaseName, DataSet+1, testFail, 
            		dataSubject, dataMessage);
			
			// 7. Click on "Contact Supplier Now" button.
			InquiryForm_Page.btn_clickContactSupplierNow();
			
			// To verify RFI confirmation page is displayed.
			RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);				

			// To verify RFI confirmation copy is available on the page.		
        	// To verify Mini Marketing Box section is available on the page.       
			RFIConfirmation_Action.check_onlyRFIConfirmationCopy_MiniMarketingBoxSectionExists(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, getSuppName);
        	
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
	public Object[][] SupplierAGG_0016Data(){
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
