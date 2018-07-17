/**
 * This class contains a method for Supplier Alert.
 * Created: Fri 30 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/30
 * 
 * @TestCaseID 1177 / 27C
 * @TestArea SA
 * @TestScenarioDesc SA for Lite upgrade user
 * 
 * @TestStep
 * 
 *     	Pre-req: Subscribe to PA Lite  or eMag Lite using autoqa_gsolnewxxxx@gmail.com. Note down the email address used.
 *     
 *     	1. From any of the following entry points, click on the "Follow Me" button next to supplier's name:
 *     	   - GSOL PP page
 *     	   - Supplier Homepage
 *     	   - Supplier Company Profile page
 *     	   - Supplier Product Showroom page
 *     	   - Supplier PP page
 *     	   - Supplier ECI pages
 *     	2. Enter email address which is used in pre-req and click on "Send me updates" button.
 *     	3. Click on "Upgrade Now Free" button.
 *     	4. Fill up all the mandatory fields.
 *     	5. Click on "Register Now" button.
 *     	6. Verify that "Skip this step if you wish to follow suppliers only. (You can choose Product Alert categories at a later time.)" 
 *         link copy is available below the "Registration" copy.
 *     	7. Select a few categories and click on "Go to Confirmation" button.
 *     	8. Click on "click here" button in SA copy.
 *     	9. Verify that the "Follow Me" link in the original page became "(green tick) Following".
 *     
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSA;

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
import pageObjects.BuyerRegistration_Page;
import pageObjects.PALite_UpgradeConf_Page;
import pageObjects.PA_AddCategories_Page;
import pageObjects.SA_Confirmation_Page;
import pageObjects.SA_EditSuppliers_Page;
import pageObjects.SA_Marketing_Page;
import pageObjects.SA_Upgrade_Page;
import pageObjects.SupplierHome_Page;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.PALite_Signup_Action;
import appModules.PA_AddCategories_Action;
import appModules.Registration_Action;
import appModules.SupplierAlert_Action;

/**
 * This test case contain method to test SA for Lite upgrade user (Supplier Company Profile page entry point).
 * @author Teng Shyh Wei
 *
 */
public class SupplierAlert_0003 extends SuiteBaseSA{
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
		FilePath = TestCaseListExcel_SuiteSA_001_TestData;
		FilePath_TestResult = SupplierAlert_0003_TestResult;
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
	@Test(dataProvider="SupplierAlert_0003Data")
	public void SupplierAlert_0003Test(String dataTestCaseName, 
			String dataBusinessEmail,
			String dataPALitePdtKeyword,
			String dataSearchKeyword,
			String dataCreateAPassword,
			String dataReenterPassword, 
			String dataTitle,
			String dataFirstName, 
			String dataLastName, 
			String dataCountryTerritory,
			String dataCompanyName, 
			String dataTelephoneNumber,
			String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL,
			String dataEmagTitle,
			String dataMailAnnouce,
			String dataMailMarketing) throws Exception{
			
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
			
			// Pre-req: Subscribe to PA Lite or eMag Lite using autoqa1008@gmail.com
		//	PALite_Signup_Action.ExecutePALiteSignup(dataBusinessEmail);	// add categories by browse
			PALite_Signup_Action.ExecutePALiteSignup(dataBusinessEmail, dataPALitePdtKeyword);		// add categories by search
			
			// 1. From Supplier Company Profile page entry points, click on the "Follow Me" button next to supplier's name:
			SupplierAlert_Action.ExecuteSA_GoToSuppCompProfile_ClickFollowMeBtn(dataSearchKeyword);
			
			WebElement suppElement = driver.findElement(By.xpath("//p[contains(@class, 'spName')]"));
			String suppName = suppElement.getText();
			Add_Log.info("Print selected supp name ::" + suppName);
			
			// Switch to new window opened.
			switchToNewWindowOpened();
			
			// To verify SA marketing pop-up page is displayed.
			SA_Marketing_Page.check_SAMarketingPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Enter a brand new email address and click on "Send me updates" button.
			SA_Marketing_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
			SA_Marketing_Page.btn_clickSendMeUpdates().click();
			
			// To verify SA upgrade page is displayed.
			SA_Upgrade_Page.check_SAUpgradePageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
			// 3. Click on "Upgrade Now Free" button
			SA_Upgrade_Page.btn_clickUpgradeNowFree().click();
			
			// To verify GSOL Registration page is displayed. 
			// To verify the PA Lite user email address is pre-populated and grey-ed out in the Business Email field.			
			Registration_Action.ExecuteRegPageDisplayed_EmailAddrPrepopulatedInGrey(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			
			// 4. Fill up all the mandatory fields.
			Registration_Action.ExecuteReg_FillUp_eMag_Notification(dataCreateAPassword, dataReenterPassword, dataTitle, dataFirstName, 
					dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL,
					dataEmagTitle, dataMailAnnouce, dataMailMarketing);
			
			// To verify all mandatory fields are filled up.
			BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 5. Click on "Register Now" button.
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify PA Select Categories page is displayed.
			PA_AddCategories_Page.check_selPACatPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 6. Verify that "Skip this step if you wish to follow suppliers only. (You can choose Product Alert categories at a later time.)" 
			// link copy is available below the "Registration" copy.
			PA_AddCategories_Page.check_copySkipThisStepExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// Enter product search keyword and click on 'Find Matching Categories' button.
		//	PA_AddCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCatBtn(dataProductKeyword);
			PA_AddCategories_Action.ExecuteBrowseCategories_ChooseACategory();
			
			// 7. Select a few categories and Click on "Go to Confirmation" button.
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
			
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			// To verify PA Lite Upgrade Confirmation page is displayed.
			// To verify Copy "You are now successfully following <supplier name>. 
			// To verify "To view - or edit - all the suppliers you're following, click here." is displayed in a yellow color background.
			// To verify Categories selected in Step 7 are displayed.
			PALite_UpgradeConf_Page.check_PALiteUpgConfPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PALite_UpgradeConf_Page.btn_clickDOIReminderOverlay_OkBtn().click();
			PALite_UpgradeConf_Page.check_copySuccFollowingExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail, suppName);
			PALite_UpgradeConf_Page.check_copyViewEditSuppExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PALite_UpgradeConf_Page.check_PACatSelectedIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			// 8. Click on "click here" link in SA copy.			
			SA_Confirmation_Page.lnk_clickOnClickHere().click();
			
			// To verify SA Edit Suppliers page is displayed.
			SA_EditSuppliers_Page.check_SAEditSuppliersPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

			// Switch back to parent window
			switchBackToParentWindow(parentHandle);
			
			// 9. The "Follow Me" button in the original page became "(green tick) Following."
						
			// To verify that the "Follow Me" button in the original page became "(green tick) Following".
			// To verify that the "View my followed suppliers" is displayed.
			SupplierHome_Page.check_btnFollowingWithGreenTickExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			SupplierHome_Page.check_lnkViewFollowedSuppExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
        	
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
	public Object[][] SupplierAlert_0003Data(){
		// To retrieve data from column of SuiteSA data Sheet.
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
