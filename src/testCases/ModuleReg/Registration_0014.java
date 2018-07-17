/**
 * This class contains a method for Registration process.
 * Created: Wed 07 Jul 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/07/07
 * 
 * @TestCaseID 1N
 * @TestArea Registration
 * @TestScenarioDesc Registration from Edit Categories page
 * @TestStep
 * 
 *     	1. Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com and go to PA Lite Confirmation page.
 *     	2. Click on the Edit categories link.
 *     	3. Click on "Register now" link in upgrade upsell section.
 *     	4. Fill up all the mandatory fields.
 *     	5. Check any eMag title checkbox (e.g: Electronics).
 *     	6. Make sure the Notification checkboxes are checked.
 *     	7. Click on the "Register Now" button.
 *     	8. Search for a keyword or choose an industry and check on any category checkboxes which are different from the categories in pre-req.
 *     	9. Click on "Go to Confirmation" button.
 *     	10. Go to "User Profile" page.
 *     	11. Click on the "Notifications" link at the left nav.
 *     
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleReg;

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
import pageObjects.PALite_Confirmation_Page;
import pageObjects.PALite_EditCategories_Page;
import pageObjects.PALite_UpgradeConf_Page;
import pageObjects.PA_AddCategories_Page;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.PALite_Signup_Action;
import appModules.PA_AddCategories_Action;
import appModules.Registration_Action;
import appModules.UserProfile_Action;

/**
 * This test case contain method to test user is able to register from Edit Categories page.
 * @author Teng Shyh Wei
 *
 */
public class Registration_0014 extends SuiteBaseReg{
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
		FilePath = TestCaseListExcel_SuiteReg_002_TestData;
		FilePath_TestResult = Registration_0014_TestResult;
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
	@Test(dataProvider="Registration_0014Data")
	public void Registration_0014Test(String dataTestCaseName, 
			String dataBusinessEmail, 
			String dataPAProductKeyword,
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
			String dataMailMarketing,
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
			// Store the parent window handle
			String parentHandle = driver.getWindowHandle();
			
			// 1. Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com and go to PA Lite Confirmation page.
			PALite_Signup_Action.ExecutePALiteSignup_GoToPALiteConfPage(dataBusinessEmail, dataPAProductKeyword);
			
			// To verify PA Lite Confirmation page is displayed.			
			PALite_Confirmation_Page.check_PALiteConfPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Click on the Edit Categories link.
			PALite_Confirmation_Page.lnk_clickEditCategories().click();
			
			// To verify PA Lite edit categories page is displayed.
			// To verify upgrade upsell section is available.
			PALite_EditCategories_Page.check_PALiteEditCategoriesPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PALite_EditCategories_Page.check_upgUpsellSecExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 3. Click on "Register now" link in upgrade upsell section.
			PALite_EditCategories_Page.lnk_clickUpgradeUpsellRegisterNow();
			
			// Switch to new window opened.
			switchToNewWindowOpened();
			
			// To verify Registration page is displayed.
			// To verify PA Lite user email address is pre-populated and grey-ed out in the Business Email field.
			// To verify PA upsell section is not available
			BuyerRegistration_Page.check_buyerRegPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			BuyerRegistration_Page.check_txtEmailAddrPrepopulatedInGray(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			BuyerRegistration_Page.check_PAUpsellSectionNotExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Fill up all the mandatory fields.
			// 5. Check any eMag title checkbox.
			// 6. Make sure the Notification checkboxes are checked.
			Registration_Action.ExecuteReg_FillUp_eMag_Notification(dataCreateAPassword, dataReenterPassword, dataTitle, dataFirstName, 
					dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL,
					dataEmagTitle, dataMailAnnouce, dataMailMarketing);
			
			// To verify all mandatory fields are filled up.
			// To verify eMag title checkboxes are checked.
			// To verify The Notification checkboxes are checked.
			Registration_Action.ExecutePAUpgrade_OnlyEmagNotification_FilledUp(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataEmagTitle);
			
			// 7. Click on the "Register Now" button.
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify Select Product Alert Categories page is displayed. There is no suggested categories.
			PA_AddCategories_Action.ExecuteSelPACatPageDisplayed_SuggCatNotAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 8. Search for a keyword or choose an industry and check on any category checkboxes which are different from the categories in pre-req
			PA_AddCategories_Action.ExecuteEnterPdtKeyword_SelectCategoriesSuggestionsChkbx(dataProductKeyword);
			
			// Store checked Categories Suggestions Name
    		WebDriverWait wait = new WebDriverWait (driver, 15);
			List<WebElement> categoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='catList_container']/dl[1]/dd/label/span")));
    		
    		List<String> checkedCatNameList = new ArrayList<String>();
			for (WebElement element : categoriesNameList){
				Add_Log.info("checkedCatNameList ::" + element.getText());
				checkedCatNameList.add(element.getText());
			}	
			
			// To verify category checkboxes are checked. Selected categories are grey-ed out and the categories are appear in the selected categories column.
			PA_AddCategories_Action.ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			// 9. Click on "Go to Confirmation" button.
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			// Click on the "OK" button in DOI reminder overlay.
			PALite_UpgradeConf_Page.btn_clickDOIReminderOverlay_OkBtn().click();
			
			// To verify PA Lite upgrade confirmation page is displayed.
			// To verify the PA categories selected in Step 8 are displayed.
			PALite_UpgradeConf_Page.check_PALiteUpgConfPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PALite_UpgradeConf_Page.check_PACatSelectedIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			// 10. Go to "User Profile" page.
			// To verify User Profile page is displayed.
			// To verify that the information entered are correct.
			UserProfile_Action.check_userProfilePageDisplayed_InfoEnteredMatched(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataTitle, dataFirstName, dataLastName, 
					dataCompanyName, dataBusinessEmail, dataCountryTerritory, dataTelephoneNumber);			
			
			// 11. Click on the "Notifications" link at the left nav.
			// To verify Notifications page is displayed
			// To verify that Notifications checkboxes are checked and preferred e-mail format is set to default (HTML).
			UserProfile_Action.check_notificationsPageDisplayed_AllNofChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			
			// Switch back to parent window
			switchBackToParentWindow(parentHandle);
			
		}catch(Exception e){
			Testfail = true;
			throw (e);
		}
			
		if(Testfail && testFail.get(0)){
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
	public Object[][] Registration_0014Data(){
		// To retrieve data from column of SuiteReg data Sheet.
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