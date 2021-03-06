/**
 * This class contains a method for PA Upgrade
 * Created: Thu 15 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/15
 * 
 * @TestCaseID 1049/ 6F
 * @TestArea PA Upgrade
 * @TestScenarioDesc PA upgrade from Maximum Categories page
 * 
 * @TestStep
 * 
 *     	1. Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com and go to PA Lite Confirmation page.
 *     	2. Click on the Edit categories link.
 *     	3. Choose an industry and check on more than 20 category checkboxes, click on "Save changes" button.
 *     	4. Click on the "Register Now" link in the warning message or "Register Now" button.
 *     	5.  Fill up all the mandatory fields.
 *     	6. Check any eMag title checkbox (e.g: Electronics).
 *     	7. Make sure the Notification checkboxes are checked.
 *     	8. Click on the "Register Now" button.
 *     	9. Check on any category checkboxes.
 *     	10. Click on "Subscribe Now" button.
 *     	11. Go to "User Profile" page.
 *     	12. Click on the "Notifications" link at the left nav.
 *     	13. Click on the "Sourcing Magazines" link at the left nav.
 *     	14. Click on the "Product Alert" link at the left nav.
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
import pageObjects.BuyerRegistration_Page;
import pageObjects.PALite_Confirmation_Page;
import pageObjects.PALite_EditCategories_Page;
import pageObjects.PA_AddCategories_Page;
import pageObjects.PA_EditCategories_Page;
import pageObjects.RegistrationConfirmation_Page;
import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import appModules.PALite_Signup_Action;
import appModules.PALite_UpgradeConf_Action;
import appModules.PA_AddCategories_Action;
import appModules.ProductAlert_Action;
import appModules.Registration_Action;
import appModules.UserProfile_Action;
import appModules.eMag_Preference_Action;

/**
 * This test case contain method to test PA upgrade from Maximum Categories page.
 * @author Teng Shyh Wei
 *
 */
public class PA_Upgrade_0005 extends SuiteBasePA{
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
		FilePath_TestResult = PA_Upgrade_0005_TestResult;
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
	@Test(dataProvider="PA_Upgrade_0005Data")
	public void PA_Upgrade_0005Test(String dataTestCaseName, 
			String dataBusinessEmail,
			String dataPALiteProductKeyword,
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
			
			// 1. Subscribe to PA Lite using autoqa_gsolnewxxxx@gmail.com and go to PA Lite Confirmation page.
			
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
			
			// To verify PA Lite Confirmation page is displayed.
			PALite_Confirmation_Page.check_PALiteConfPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Click on the Edit categories link.
			PALite_Confirmation_Page.lnk_clickEditCategories().click();
			
			// To verify PA Lite edit categories page is displayed.
		//	PALite_EditCategories_Page.check_PALiteEditCategoriesPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_EditCategories_Page.check_PAEditCategoriesPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 3. Choose an industry and check on more than 10 category checkboxes, click on "Save changes" button.
			PA_AddCategories_Action.ExecuteBrowseCategories_CheckedMoreThan10Cat_ClickSaveChangesBtn();
			
			// To verify Warning message "We're sorry, but you can only receive Product Alert updates in a maximum of 10 categories 
			// without full Global Sources registration. Register Now to get updates in all the categories you've selected, 
			// or uncheck some of the categories." is displayed.
			PA_EditCategories_Page.check_msgExceed10CatSubs_ClickOKToAccept(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Click on the "Register Now" link in the warning message or "Register Now" button.
			PALite_EditCategories_Page.btn_clickRegisterNow().click();
			
			// To verify Registration page is displayed. 
			// To verify that the PA Lite user email address is pre-populated and grey-ed out in the Business Email field. 
			// To verify PA upsell section is not available.
			Registration_Action.ExecuteRegPage_EmailPrepopulated_PAUpsellSecNotExists(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			
			// 5. Fill up all the mandatory fields.			
			// 6. Check any eMag title checkbox (e.g: Electronics).		
			// 7. Make sure the Notification checkboxes are checked.
			Registration_Action.ExecuteReg_FillUp_eMag_Notification(dataCreateAPassword, dataReenterPassword, dataTitle, dataFirstName, 
					dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL, 
					dataEmagTitle, dataMailAnnouce, dataMailMarketing);
			
			// To verify Mandatory fields are filled up.
			// To verify eMag title checkbox is checked.
			// To verify The Notification checkboxes are checked.
			Registration_Action.ExecutePAUpgrade_OnlyEmagNotification_FilledUp(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataEmagTitle);
			
			// Store checked eMag title Name
    		String eMagTitle = dataEmagTitle.trim();
    		Add_Log.info(eMagTitle);
    		
    		ArrayList<String> checkedeMagNameList = new ArrayList<String>();
    	/*	if(eMagTitle.contains("APAD")){
    			Add_Log.info("Auto Parts & Accessories");
    			String eMagAPAD = "Auto Parts & Accessories";
    			checkedeMagNameList.add(eMagAPAD);
    		}	
    	*/	
    		if(eMagTitle.contains("ECD")){
    			Add_Log.info("Electronic Components");
    			String eMagECD = "Electronic Components";
    			checkedeMagNameList.add(eMagECD);
    		}
    		if(eMagTitle.contains("ELECD")){
    			Add_Log.info("Electronics");
    			String eMagELECD = "Electronics";
    			checkedeMagNameList.add(eMagELECD);
    		}
    		if(eMagTitle.contains("FAD")){
    			Add_Log.info("Fashion Accessories & Footwear");
    			String eMagFAD = "Fashion Accessories & Footwear";
    			checkedeMagNameList.add(eMagFAD);
    		}
    		if(eMagTitle.contains("GATD")){
    			Add_Log.info("Fashion Apparel & Fabrics");
    			String eMagGATD = "Fashion Apparel & Fabrics";
    			checkedeMagNameList.add(eMagGATD);
    		}
    		if(eMagTitle.contains("GHD")){
    			Add_Log.info("Gifts & Premiums");
    			String eMagGHD = "Gifts & Premiums";
    			checkedeMagNameList.add(eMagGHD);
    		}
    		if(eMagTitle.contains("HWD")){
    			Add_Log.info("Hardware, Auto & Machinery");
    			String eMagHWD = "Hardware, Auto & Machinery";
    			checkedeMagNameList.add(eMagHWD);
    		}
    		if(eMagTitle.contains("HPD")){
    			Add_Log.info("Home Products");
    			String eMagHPD = "Home Products";
    			checkedeMagNameList.add(eMagHPD);
    		}
    		if(eMagTitle.contains("EIS")){
    			Add_Log.info("India Products");
    			String eMagEIS = "India Products";
    			checkedeMagNameList.add(eMagEIS);
    		}
    		if(eMagTitle.contains("EKS")){
    			Add_Log.info("Korea Products");
    			String eMagEKS = "Korea Products";
    			checkedeMagNameList.add(eMagEKS);
    		}
    		if(eMagTitle.contains("SLVD")){
    			Add_Log.info("Smart Living");
    			String eMagSLVD = "Smart Living";
    			checkedeMagNameList.add(eMagSLVD);
    		}
    		
    		Add_Log.info("Selected eMag ::" + checkedeMagNameList);
			
			// 8. Click on the "Register Now" button.
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify Select Product Alert Categories page is displayed. There are suggested categories based on the keyword in step 3.		
		//	PA_AddCategories_Action.ExecuteSelPACatPageDisplayed_SuggCatNotAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PA_AddCategories_Action.ExecuteSelPACatPage_SuggCatByPdtKeywordEnteredExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 9. Search for a keyword or choose an industry and check on any category checkboxes which are different from the categories in pre-req.
		//	PA_AddCategories_Action.ExecuteEnterPdtKeyword_SelectCategoriesSuggestionsChkbx(dataProductKeyword);
			PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
			
			// Store checked Categories Suggestions Name
    		List<WebElement> categoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='catList_container']/dl[1]/dd/label/span")));
    		
    		List<String> checkedCatNameList = new ArrayList<String>();
			for (WebElement element : categoriesNameList){
				Add_Log.info("checkedCatNameList ::" + element.getText());
				checkedCatNameList.add(element.getText());
			}	
										
			// To verify Category checkboxes are checked. 
			// To verify Selected categories are grey-ed out and the categories are appear in the selected categories column.
			PA_AddCategories_Action.ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			// 10. Click on "Go to Confirmation" button.
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			// Click on the "OK" button in DOI reminder overlay.
			RegistrationConfirmation_Page.btn_clickDOIReminderOverlay_OkBtn().click();
			
			// To verify PA Lite upgrade confirmation page is displayed. 
			// To verify that the PA categories selected in Step 9 are displayed.
			PALite_UpgradeConf_Action.ExecutePALiteUpgConfPage_PACatSelAreDisplayed(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			

			// 11. Go to "User Profile" page.			
			// To verify User Profile page is displayed.
			// To verify that the information entered are correct.
			UserProfile_Action.check_userProfilePageDisplayed_InfoEnteredMatched(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataTitle, dataFirstName, dataLastName, 
					dataCompanyName, dataBusinessEmail, dataCountryTerritory, dataTelephoneNumber);
			
			
			// 12. Click on the "Notifications" link at the left nav.
			// To verify Notifications page is displayed
			// To verify that Notifications checkboxes are checked and preferred e-mail format is set to default (HTML).
			UserProfile_Action.check_notificationsPageDisplayed_AllNofChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 13. Click on the "Sourcing Magazines" link at the left nav.						
			// To verify eMag Preference page is displayed.			
			// To verify the eMag title selected in Step 9 are displayed in "Magazine(s) Subscribed" section.
			eMag_Preference_Action.ExecuteEmagPrefPage_eMagTitleSelectedIsDisplayed(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedeMagNameList);
			
			
			// 14. Click on the "Product Alert" link at the left nav.
			// To verify PA homepage is displayed. 
			// To verify that the PA categories selected in pre-req as well as Step 9 are displayed.
			ProductAlert_Action.ExecutePAHomepage_PACatSelIsDisplayed(
					driver, FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedPACatNameList, checkedCatNameList);

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
	public Object[][] PA_Upgrade_0005Data(){
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

