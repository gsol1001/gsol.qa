/**
 * This class contains a method for eMag upgrade.
 * Created: Mon 05 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/05
 * 
 * @TestCaseID 1060 / 19A
 * @TestArea eMag Upgrade 
 * @TestScenarioDesc eMag upgrade from eMag Lite confirmation page
 * @TestStep
 *  	
 *     1. Go to eMag Lite form page.
 *     2. Check any eMag title checkbox (e.g: Electronics).
 *     3. In Business Email field, enter a brand new email address (autoqa_gsolnewxxxx@gmail.com) and click on "Continue" button.
 *     4. Fill up all the mandatory fields and click on "Submit" button.
 *     5. Click on "Register Now!" button in upgrade upsell section.
 *     6. Fill up all the mandatory fields, make sure the email adress entered in Business E-mail field si the same as in Step 3.
 *     7. Check any eMag title checkbox which is different from Step 2 (e.g: Home Products).
 *     8. Make sure the Notification checkboxes are checked.
 *     9. Search for a keyword or choose an industry and check on any category checkboxes.
 *     10. Click on the "Register Now" button.
 *     11. Check on any category checkboxes.
 *     12. Click on "Subscribe Now" button.
 *     13. Click on the "OK" button in DOI reminder overlay.
 *     14. Go to "User Profile" page.
 *     15. Click on the "Notifications" link at the left nav.
 *     16. Click on the "Sourcing Magazines" link at the left nav.
 *     17. Click on the "Product Alert" link at the left nav.     
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleeMag;

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
import appModules.ProductAlert_Action;
import appModules.Registration_Action;
import appModules.UserProfile_Action;
import appModules.eMagLite_Form_Action;
import appModules.eMag_Preference_Action;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.BuyerRegistration_Page;
import pageObjects.PALite_UpgradeConf_Page;
import pageObjects.PA_AddCategories_Page;
import pageObjects.RegistrationConfirmation_Page;
import pageObjects.eMagLite_Confirmation_Page;
import pageObjects.eMagLite_Form_Page;
import testCases.SuiteBase;

/**
 * This test case contain method to test eMag upgrade from eMag Lite confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class eMagUpgrade_0001 extends SuiteBaseeMag{
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
	 * @BeforeTest annotated method will be executed before any @Test annotated method
	 * of those classes which are inside <test> tag in testng.xml file.
	 * 
	 * @throws IOException
	 */
	@BeforeTest
	public void checkCaseToRun() throws IOException{
		
		// Called init() function from SuiteBase class to Initialize .xls Files
		init();	
		
		// To set .xls file's path In FilePath Variable.
		FilePath = TestCaseListExcel_SuiteeMag_001_TestData;
		FilePath_TestResult = eMagUpgrade_0001_TestResult;
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
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName,ToRunColumnNameTestCase,TestCaseName)){
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
	 * @BeforeMethod annotated will be executed before each and very @test annotated method.
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
	@Test(dataProvider="eMagUpgrade_0001Data")
	public void eMagUpgrade_0001Test(String dataTestCaseName,
			String dataPrefEmagTitle,
			String dataBusinessEmail,
			String dataFirstName,
			String dataLastName,
			String dataCompName,
			String dataCountryTerritory,
			String dataCreateAPassword,
			String dataReenterPassword,
			String dataTitle,
			String dataTelephoneNumber,
			String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL,
			String dataEmagTitle,
			String dataProductKeyword,
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
			
			// 1. Go to eMag Lite form page.
			driver.get(Param.getProperty("eMagLiteFormURL"));
			
			// To verify eMag Lite form is displayed.
			eMagLite_Form_Page.check_eMagLiteFormPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Check any eMag title checkbox (e.g: Mobile Electronics)
			eMagLite_Form_Page.chkbx_selectAnyEmagTitle(dataPrefEmagTitle);
			
			// To verify eMag title checkbox is checked.
			eMagLite_Form_Page.check_eMagLiteTitleChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataPrefEmagTitle);
			
			// Store checked eMag Lite title Name
			String eMagTitleLite = dataPrefEmagTitle.trim();
			Add_Log.info(dataPrefEmagTitle);
			
    		ArrayList<String> checkedeMagLiteList = new ArrayList<String>();
    	/*	if(eMagTitleLite.contains("APAD")){
    			Add_Log.info("Auto Parts & Accessories");
    			String eMagAPAD = "Auto Parts & Accessories";
    			checkedeMagLiteList.add(eMagAPAD);
    		}
    	*/	
    		if(eMagTitleLite.contains("ECD")){
    			Add_Log.info("Electronic Components");
    			String eMagECD = "Electronic Components";
    			checkedeMagLiteList.add(eMagECD);
    		}
    		if(eMagTitleLite.contains("ELECD")){
    			Add_Log.info("Electronics");
    			String eMagELECD = "Electronics";
    			checkedeMagLiteList.add(eMagELECD);
    		}
    		if(eMagTitleLite.contains("FAD")){
    			Add_Log.info("Fashion Accessories & Footwear");
    			String eMagFAD = "Fashion Accessories & Footwear";
    			checkedeMagLiteList.add(eMagFAD);
    		}
    		if(eMagTitleLite.contains("GATD")){
    			Add_Log.info("Fashion Apparel & Fabrics");
    			String eMagGATD = "Fashion Apparel & Fabrics";
    			checkedeMagLiteList.add(eMagGATD);
    		}
    		if(eMagTitleLite.contains("GHD")){
    			Add_Log.info("Gifts & Premiums");
    			String eMagGHD = "Gifts & Premiums";
    			checkedeMagLiteList.add(eMagGHD);
    		}
    		if(eMagTitleLite.contains("HWD")){
    			Add_Log.info("Hardware, Auto & Machinery");
    			String eMagHWD = "Hardware, Auto & Machinery";
    			checkedeMagLiteList.add(eMagHWD);
    		}
    		if(eMagTitleLite.contains("HPD")){
    			Add_Log.info("Home Products");
    			String eMagHPD = "Home Products";
    			checkedeMagLiteList.add(eMagHPD);
    		}
    		if(eMagTitleLite.contains("EIS")){
    			Add_Log.info("India Products");
    			String eMagEIS = "India Products";
    			checkedeMagLiteList.add(eMagEIS);
    		}
    		if(eMagTitleLite.contains("EKS")){
    			Add_Log.info("Korea Products");
    			String eMagEKS = "Korea Products";
    			checkedeMagLiteList.add(eMagEKS);
    		}
    		if(eMagTitleLite.contains("SLVD")){
    			Add_Log.info("Smart Living");
    			String eMagSLVD = "Smart Living";
    			checkedeMagLiteList.add(eMagSLVD);
    		}
    		
    		Add_Log.info("Selected eMag Lite::" + checkedeMagLiteList);
    		
			// 3. In Business Email field, enter a brand new email address and click on "Continue" button.
			eMagLite_Form_Action.ExecuteEmagLiteSignup_EnterEmailAddr_ClickContinueBtn(dataBusinessEmail);
			
			// To verify eMag title checkbox is remains checked. 
			// To verify Name, Company Name and Country/Territory fields are available. 
			// To verify Email address entered in Step 4 is grey-ed out in Business Email field.
			eMagLite_Form_Page.check_eMagLiteTitleChkbxRemainSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataPrefEmagTitle);
			eMagLite_Form_Page.check_allMandatoryFieldsAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			eMagLite_Form_Page.check_emailAddrIsGreyedOut(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			
			// 4. Fill up all the mandatory fields and click on "Submit" button.
			eMagLite_Form_Action.ExecuteFillInMandatoryFields_ClickSubmitBtn(dataFirstName, dataLastName, dataCompName, dataCountryTerritory);
			
			// Switch to alert and click on 'OK' button to accept.
			switchToAlert_ClickOnOKBtn();
			
			// To verify eMag Lite confirmation page is displayed. 
			// Verify that PAIDSUB, PA upsell and upgrade upsell section are available.
			eMagLite_Confirmation_Page.check_eMagLiteConfPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			eMagLite_Confirmation_Page.check_PAIDSUBSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			eMagLite_Confirmation_Page.check_PAUpsellSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			eMagLite_Confirmation_Page.check_upgradeUpsellSectionExists(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 5. Click on "Register Now!" button in upgrade upsell section
			eMagLite_Confirmation_Page.btn_clickRegisterNow().click();
			
			// To verify Registration page is displayed.
			BuyerRegistration_Page.check_buyerRegPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 6. Fill up all the mandatory fields, make sure the email address entered in Business E-mail field is the same as in Step3.
			// 7. Check any eMag title checkbox which is different from Step 2 (e.g: Home Products)
			// 8. Make sure the Notification checkboxes are checked.
			Registration_Action.ExecuteReg_FillUp_PswAndPhoneNo(dataCreateAPassword, dataReenterPassword, dataTitle, dataTelephoneNumber, 
					dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
			BuyerRegistration_Page.chkbx_selectAnyEmagTitle(dataEmagTitle);
			BuyerRegistration_Page.chkbx_selectMailAnnounce(dataMailAnnouce);
			BuyerRegistration_Page.chkbx_selectMailMarketing(dataMailMarketing);
						
			// To verify mandatory fields are filled up.
			// To verify the email address entered in Business E-mail field is the same as Step 3.
			// To verify eMag title checkbox is checked.
			// To verify Notification checkbox is selected.
			BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			BuyerRegistration_Page.check_txtEmailAddrPrepopulated(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataBusinessEmail);
			BuyerRegistration_Page.check_eMagTitleChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataEmagTitle);										
			BuyerRegistration_Page.check_notificationChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
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
    		
			// 9. Click on the "Register Now" button.
			BuyerRegistration_Page.btn_clickRegisterNow().click();
			
			// To verify Select Product Alert Categories page is displayed. There are no suggested categories.
			PA_AddCategories_Action.ExecuteSelPACatPageDisplayed_SuggCatNotAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 10. Search for a keyword or choose an industry and check on any category checkboxes.
			PA_AddCategories_Action.ExecuteBrowseCategories_SelectCategoriesSuggestionsChkbx();
			
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
			
			// To verify selected categories are grey-ed out and the categories are appear in the selected categories column.
			PA_AddCategories_Action.ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);					

			// 11. Click on "Go to Confirmation" button.
			PA_AddCategories_Page.btn_clickGoToConfirmation();
			
			// To verify Registration confirmation page with DOI reminder overlay is displayed.
			RegistrationConfirmation_Page.check_regConfPage_DOIReminderOverlayDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
						
        	// 12. Click on the "OK" button in DOI reminder overlay.
			RegistrationConfirmation_Page.btn_clickDOIReminderOverlay_OkBtn().click();
        	
			// To verify PA Lite upgrade confirmation page is displayed. Verify that the PA categories selected in Step 12 are displayed.
			PALite_UpgradeConf_Page.check_PALiteUpgConfPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			PALite_UpgradeConf_Page.check_PACatSelectedIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);
			
			// 13. Go to "User Profile" page.			
			// To verify User Profile page is displayed.
			// To verify that the information entered are correct.
			UserProfile_Action.check_userProfilePageDisplayed_InfoEnteredMatched(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, dataTitle, dataFirstName, dataLastName, 
					dataCompName, dataBusinessEmail, dataCountryTerritory, dataTelephoneNumber);
			
			
			// 14. Click on the "Notifications" link at the left nav.
			// To verify Notifications page is displayed
			// To verify that Notifications checkboxes are checked and preferred e-mail format is set to default (HTML).
			UserProfile_Action.check_notificationsPageDisplayed_AllNofChkbxSelected(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			
			// 15. Click on the "Sourcing Magazines" link at the left nav.						
			// To verify eMag Preference page is displayed.			
			// To verify the eMag title selected in Step 2 and Step 7 are displayed in "Magazine(s) Subscribed" section.
			eMag_Preference_Action.ExecuteEmagPrefPage_eMagTitleSelectedIsDisplayed(
					FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedeMagLiteList, checkedeMagNameList);
			
			
			// 16. Click on the "Product Alert" link at the left nav.
			// To verify PA homepage is displayed. 
			// To verify that the PA categories selected in Step 11 are displayed.
			ProductAlert_Action.ExecutePAHomepage_PACatSelIsDisplayed(
					driver, FilePath_TestResult, TestCaseName, DataSet+1, testFail, checkedCatNameList);

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
	 * @AfterMethod method will be executed after execution of @Test method every time.
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
	public Object[][] eMagUpgrade_0001Data(){
		// To retrieve data from column of SuiteEmag data Sheet.
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
