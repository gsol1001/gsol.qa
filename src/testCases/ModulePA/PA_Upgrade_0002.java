/**
 * This class contains a method for PA Upgrade
 * Created: Thu 15 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/15
 * 
 * @TestCaseID 1046/ 6C
 * @TestArea PA Upgrade
 * @TestScenarioDesc PA upgrade from PA RFI
 * 
 * @TestStep
 * 
 *     	Pre-req: Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com.

 *     	1. As a PA Lite user, inquire for multiple categories products and go to RFI form.
 *     	2. Fill in the relevant fields. Make sure the Business Email entered is the same as in pre-req and the PA upsell checkbox is checked.
 *     	3. Click on the "Continue to Next Step" button.
 *     	4. Fill in the "Create a Password" and "Re-enter Password" fields with valid password and click on "Send Your Inquiry Now" button.
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

import pageObjects.BaseClass;
import pageObjects.InquiryForm_Page;
import pageObjects.MiniRegistration_Page;
import pageObjects.PA_AddCategories_Page;
import pageObjects.RFIConfirmation_Page;
import pageObjects.TopNav_MenuBar;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.InquiryForm_Action;
import appModules.MiniRegistration_Action;
import appModules.PALite_Signup_Action;
import appModules.PA_AddCategories_Action;
import appModules.ProductInquiry_Action;

/**
 * This test case contain method to test PA upgrade from RFI.
 * @author Teng Shyh Wei
 *
 */
public class PA_Upgrade_0002 extends SuiteBasePA{
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
		FilePath = TestCaseListExcel_SuitePA_005_TestData;
		FilePath_TestResult = PA_Upgrade_0002_TestResult;
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
	@Test(dataProvider="PA_Upgrade_0002Data")
	public void PA_Upgrade_0002Test(String dataTestCaseName, 
			String dataBusinessEmail,
			String dataPALiteProductKeyword,
			String dataSearchKeyword,
			String dataCcEmailAddress,  
			String dataSubject, 
			String dataExpOrderQuantity, 
			String dataRequestFor, 
			String dataMessage, 
			String dataTitle, 
			String dataFirstName,
			String dataLastName, 
			String dataCompName, 
			String dataCountryTerritory, 
			String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL,
			String dataPAUpsell,
			String dataPassword, 
			String dataRePassword) throws Exception{
			
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
			
			// Pre-req: Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com
			
			// Enter a brand new email address in the Get Notified section textbox and click on "Subscribe" button.
			PALite_Signup_Action.ExecutePAGetNotified_EnterEmailAddr_ClickSubsribeBtn(dataBusinessEmail);
			
			// Click on "Browser categories" tab and choose a category from "Choose an industry" dropdown list.
		//	PA_AddCategories_Action.ExecuteBrowserCategories_ChooseACategory();
			PA_AddCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCatBtn(dataPALiteProductKeyword);
			
			// Check on any category checkboxes.
			PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
			
			// Store checked Categories Suggestions Name
			WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> PALiteCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='catList_container']/dl[1]/dd/label/span")));
    		
    		List<String> checkedPACatNameList = new ArrayList<String>();
			for (WebElement element : PALiteCategoriesNameList){
				Add_Log.info("checkedPACatNameList ::" + element.getText());
				checkedPACatNameList.add(element.getText());
			}	
			
			// Click on 'Go to Confirmation' button.
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			// 1. As a PA Lite user, inquire for multiple categories products and go to RFI form.
			TopNav_MenuBar.lnk_backToGSOLHomePage();
			ProductInquiry_Action.ExecuteInqNow_MulVerPdt_MulCat(dataSearchKeyword);
			
			// To verify RFI form is displayed. Verify that user's contact details are not pre-populated. 
			// To verify the PA upsell copy is "I want e-mail updates when new {Inquired L4 category} are available." and the checkbox is checked by default.
			InquiryForm_Action.check_RFIFormIsDisplayed_UserContactDetailsNotPrepopulated(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryForm_Page.check_PAUpsellCopyIsSeen(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			InquiryForm_Page.check_PAUpsellChkbxSelectedAsDefault(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Fill in the relevant fields. Make sure the Business Email entered is the same as in pre-req and the PA upsell checkbox is checked.
			InquiryForm_Action.ExecuteNL1_PdtInq_InqNow_MulVerPdt_MulCat_Info(dataCcEmailAddress, dataSubject, dataExpOrderQuantity, 
					dataRequestFor, dataMessage, dataTitle, dataFirstName, dataLastName, dataBusinessEmail, dataCompName, 
					dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL, dataPAUpsell);
			
			// To verify the relevant fields are filled up and the PA upsell checkbox is checked.
			InquiryForm_Page.check_textBusinessEmailEnteredSameAsPrereq(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			InquiryForm_Page.check_PAUpsellChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 3. Click on the "Continue to Next Step" button.
			InquiryForm_Page.btn_clickContinueToNextStep().click();
			
			// To verify mini registration page is displayed.
			MiniRegistration_Page.check_miniRegistrationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Fill in the "Create a Password" and "Re-enter Password" fields with valid password and click on "Send Your Inquiry Now" button.
			MiniRegistration_Action.ExecuteMiniReg_EnterPassword_ClickSendYourInquiryNow(dataPassword, dataRePassword);
			
			// To verify RFI confirmation page is displayed. Verify that the copy for PA upsell section:
			// - Update me on new products
			// - You're just a step away from receiving e-mail updates! Activate using the confirmation e-mail sent to you. Resend e-mail.
			// - Category(s) for your Product Alert: {Inquired L4 category}
			RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			RFIConfirmation_Page.check_PASection_UpdateMeOnNewPdtExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			RFIConfirmation_Page.check_PASection_DOIReminderExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			RFIConfirmation_Page.check_PASection_CategoryForYourPA(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
	 * 
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
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] PA_Upgrade_0002Data(){
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

