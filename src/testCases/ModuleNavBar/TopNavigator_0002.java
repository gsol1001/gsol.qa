/**
 * This class contains a method for Top Navigator
 * Created: Wed 24 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/24
 * 
 * @TestCaseID 1164 / 23B
 * @TestArea Top Navigator
 * @TestScenarioDesc Global Nav for logged-in/cookied in user
 * @TestStep
 * 
 * 		Reference: Appendix A
 * 		Pre-req: Clear Cache & Cookie on the browse before starting the test.

 * 		1. As a non-logged in user, go to any page in the Appendix A, verify the Top Navigator.
 * 		2. Mouseover the Online Marketplace link at Top Navigator.
 * 		3. Mouseover the Trade Shows link at Top Navigator.
 * 		4. Mouseover the Smart Sourcing link at Top Navigator.
 * 		5. Mouseover the Other Services link at Top Navigator.
 * 		6. Click on each of the links and verify that the corresponding landing page is displayed.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleNavBar;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
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
import pageObjects.TopNav_MenuBar;
import testCases.SuiteBase;
import testCases.ModuleNavBar.SuiteBaseNavBar;

/**
 * This test case contain method to test Top Navigator for logged-in/cookied in user.
 * @author Teng Shyh Wei
 *
 */
public class TopNavigator_0002 extends SuiteBaseNavBar{
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
		FilePath = TestCaseListExcel_SuiteNavBar_001_TestData;
		FilePath_TestResult = TopNavigator_0002_TestResult;
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
	@Test(dataProvider="TopNavigator_0002Data")
	public void TopNavigator_0002Test(String dataTestCaseName,			
			String dataUsername,
			String dataPassword,
			String dataSearchKeyword) throws Exception{

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
			
			// 1. As a logged in user, go to any page in the Appendix A, verify the Top Navigator.
			// 	As a logged in user, enter search keyword and go to Supplier List tab.
			ProductInquiry_Action.ExecuteLoggedIn_GoToSupplierListTab(dataUsername, dataPassword, dataSearchKeyword);
			
			// In Top Navigator, verify that the following links are available in sequence:
			// a. Online Marketplace, b. Trade Shows, c. Magazines, d. Other Services
			TopNav_MenuBar.check_sequenceTopNavAreCorrect(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 2. Mouse hover the Online Marketplace link at Top Navigator.
			TopNav_MenuBar.menuBar_mousehoverOnlineMarketplace();
			
			// To verify all the product verticals listing is displayed under the Online Marketplace link.
    		TopNav_MenuBar.check_subMenuOnlineMarketplaceAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
    		
			// 3. Mouse hover the Trade Shows link at Top Navigator.
			
			// 4. Mouse hover the Smart Sourcing link at Top Navigator.
    		TopNav_MenuBar.menuBar_mousehoverOnSmartSourcing();
			
			// To verify Analyst's Choice, Sourcing News & Advice, New Sourcing Markets, Sourcing Reports, Global Sources Summit 
    		// and Buyer Support are displayed under the Smart Sourcing Link.
			TopNav_MenuBar.check_subMenuSmartSourcingAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			
			// 5. Mouse hover the Other Services link at Top Navigator.
			TopNav_MenuBar.menuBar_mousehoverOnOtherServices();
			
			// To verify RFQ, Product Alerts, Magazines, Private Sourcing Events and About Us 
			// are displayed under the Other Service link.
			TopNav_MenuBar.check_subMenuOtherServiceAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
					
					
			// 6. Click on each of the links and verify that the corresponding landing page is displayed
			TopNav_MenuBar.subMenu_selectAutoPartAndAccessories();
			TopNav_MenuBar.check_autoPartsAndAccessoriesPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
			driver.navigate().back();
						
			TopNav_MenuBar.subMenu_selectConsumerElectronics();
			TopNav_MenuBar.check_consumerElectronicsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
		
			// Added on 08-Oct-2015
			// Removed on 07-May-2018 MR#49404
		/*	TopNav_MenuBar.subMenu_selectDronesRobotics();
			TopNav_MenuBar.check_dronesRoboticsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
		*/
			TopNav_MenuBar.subMenu_selectElectronicComponents();
			TopNav_MenuBar.check_electronicComponentsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
		
			TopNav_MenuBar.subMenu_selectFashionAccessoriesAndFootwear();
			TopNav_MenuBar.check_fashionAccessoriesAndFootwearPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			TopNav_MenuBar.subMenu_selectFashionApparelAndFabrics();
			TopNav_MenuBar.check_fashionApparelAndFabricsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			TopNav_MenuBar.subMenu_selectGiftsAndPremiums();
			TopNav_MenuBar.check_giftsAndPremiumsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			TopNav_MenuBar.subMenu_selectHardware();
			TopNav_MenuBar.check_hardwarePageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			TopNav_MenuBar.subMenu_selectHomeProducts();
			TopNav_MenuBar.check_homeProductsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
		/*	TopNav_MenuBar.subMenu_selectLEDAndSolarProducts();
			TopNav_MenuBar.check_LEDAndSolarProductsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			TopNav_MenuBar.subMenu_selectLEDsAndOptoelectronics();
			TopNav_MenuBar.check_LEDsAndOptoelectronicsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
		*/	
			TopNav_MenuBar.subMenu_selectMachineryAndParts();
			TopNav_MenuBar.check_machineryAndPartsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			TopNav_MenuBar.subMenu_selectMobileElectronics();
			TopNav_MenuBar.check_mobileElectronicsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			TopNav_MenuBar.subMenu_selectSecurityProducts();
			TopNav_MenuBar.check_securityProductsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
			// Added on 21-Sep-2016
			TopNav_MenuBar.subMenu_selectSmartLiving();
			TopNav_MenuBar.check_smartLivingPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();
			
		/*	TopNav_MenuBar.subMenu_selectUnderwearAndSwimwear();
			TopNav_MenuBar.check_underwearAndSwimwearPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();	
		*/	
			
			// Store the current window handle
			String parentHandle = driver.getWindowHandle();	
			
			// Top Navigation for Smart Sourcing
			
			// Click on Analyst's Choice sub menu
			TopNav_MenuBar.subMenu_selectAnalystsChoice();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_analystsChoicePageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);	
						
			// Click on Sourcing News & Advice sub menu
			TopNav_MenuBar.subMenu_selectSourcingNewsAndAdvice();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_sourcingNewsAndAdvicePageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);	
			
			// Click on New Sourcing Markets sub menu
			TopNav_MenuBar.subMenu_selectNewSourcingMarkets();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_newSourcingMarketsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);
			
			// 20-Mar-2018 MR#49221
			// Click on Sourcing Reports sub menu
		/*	TopNav_MenuBar.subMenu_selectSourcingReports();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_sourcingReportsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);
		*/	
			// Click on Global Sources Summit sub menu
			TopNav_MenuBar.subMenu_selectGlobalSourcesSummit();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_GlobalSourcesSummitPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);
			
			// 20-Mar-2018 MR#49221
			// Click on Buyer Support sub menu
		/*	TopNav_MenuBar.subMenu_selectBuyerSupport();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_buyerSupportPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);
		*/	
			
			// Top Navigation for Other Services

			// Click on RFQ sub menu
			TopNav_MenuBar.subMenu_selectRFQ();			
			driver.switchTo().window("externalWin");	// 29-Dec-2015
			TopNav_MenuBar.check_getRequestForQuotationsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);
			
			// Click on Product Alerts sub menu
			TopNav_MenuBar.subMenu_selectProductAlerts();
			TopNav_MenuBar.check_productAlertsPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			driver.navigate().back();			
			
			// Click on Magazines sub menu
			TopNav_MenuBar.subMenu_selectMagazines();			
			switchToNewWindowOpened();					// Switch to new window opened
			TopNav_MenuBar.check_magazinesPageIsDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);		
			switchBackToParentWindow(parentHandle);		// Close opened window and switch back to parent window						
						
			// Click on Private Sourcing Events sub menu
			TopNav_MenuBar.subMenu_selectPrivateSourcingEvents();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_privateSourcingEventsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			switchBackToParentWindow(parentHandle);
			
			// Click on About Us sub menu
			TopNav_MenuBar.subMenu_selectAboutUs();
			switchToNewWindowOpened();
			TopNav_MenuBar.check_aboutUsPageDisplayed(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
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
	 * <code>@AfterMethod</code> method will be executed of @Test method every time.
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
	public Object[][] TopNavigator_0002Data(){
		// To retrieve data from column of SuiteNavBar data Sheet.
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
			Add_Log.info(TestCaseName+" : Reporting test case as PASS In excel." + "\n ");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_PASS);
		}
		else{
			Add_Log.info(TestCaseName+" : Reporting test case as FAIL In excel." + "\n ");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_PASS_FAIL_SKIP, TestCaseName, Constant.KEYWORD_FAIL);			
		}
	}
	
}
