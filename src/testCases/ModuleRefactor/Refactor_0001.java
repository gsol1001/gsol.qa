/**
 * This class contains a method for Top Navigator
 * Created: Mon 11 Apr 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/04/11
 * 
 * @TestCaseID 1.2
 * @TestArea Top Navigator
 * @TestScenarioDesc Global Nav for non logged-in user
 * @TestStep
 * 
 * 		Reference: Appendix A
 * 		Pre-req: Clear Cache & Cookie on the browse before starting the test.

 * 		1. As a non-logged in user, go to any GSOL PP page, verify the Top Navigator.
 * 		2. Mouseover the Online Marketplace link at Top Navigator.
 * 		3. Mouseover the Trade Shows link at Top Navigator.
 * 		4. Mouseover the Magazines & Reports link at Top Navigator.
 * 		5. Mouseover the Other Services link at Top Navigator.
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleRefactor;

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

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;
import pageObjects.BaseClass;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.TopNav_MenuBar;
import testCases.SuiteBase;
import testCases.ModuleRFI.SuiteBaseRFI;
/**
 * This test case contain method to test Top Nav
 * @author Teng Shyh Wei
 *
 */
public class Refactor_0001 extends SuiteBaseRFI{
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
		FilePath = TestCaseListExcel_SuiteRefactor_001_TestData;
		FilePath_TestResult = Refactor_0001_TestResult;
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
	 * @throws Exception  if any exception occurred
	 */
	@BeforeMethod
	public void beforeMethod() throws Exception {
        
		// To Initialize Firefox browser.
		driver = SuiteBase.loadWebBrowser();
		new BaseClass(driver);
		
	}
	
	/**
	 * This is the starting of the Main Test. Accepts all column's String data In every Iteration.
	 */
	@Test(dataProvider="Refactor_0001Data")
	public void Refactor_0001Test(String dataTestCaseName) throws Exception{
			
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
			
			// 1. As a non-logged in user, go to any GSOL PP page, verify the Top Navigator.
			
			// In Top Navigator, verify that the following links are available in sequence:
			// a. Online Marketplace, b. Trade Shows, c. Magazines, d. Other Services
			TopNav_MenuBar.check_sequenceTopNavAreCorrect(FilePath_TestResult, TestCaseName, DataSet+1, testFail);			
						
			// 2. Mouse hover the Online Marketplace link at Top Navigator.
			TopNav_MenuBar.menuBar_mousehoverOnlineMarketplace();
    		
    		// To verify all the product verticals listing is displayed under the Online Marketplace link.
    		TopNav_MenuBar.check_subMenuOnlineMarketplaceAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

			// 3. Mouse hover the Trade Shows link at Top Navigator. (Skip as maintenance by SITE team)
			TopNav_MenuBar.menuBar_mousehoverOnTradeShows();
    		
			// To verify Global Sources Exhibitions, Electronics, Mobile Electronics, Gifts & Home, Fashion, Hardware & Machinery,
			// and Other Trade Shows are displayed under the Trade Shows link.
			TopNav_MenuBar.check_subMenuTradeShowsAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 4. Mouse hover the Magazines & Reports link at Top Navigator.
    		TopNav_MenuBar.menuBar_mousehoverOnSmartSourcing();
			
			// To verify Magazines and Sourcing Reports are displayed under the Magazines Link.
			TopNav_MenuBar.check_subMenuSmartSourcingAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 5. Mouse hover the Other Services link at Top Navigator.
			TopNav_MenuBar.menuBar_mousehoverOnOtherServices();
			
			// To verify Product Alerts, Sourcing News & Advice, Private Sourcing Events, Buyer Support and About Us 
			// are displayed under the Other Service link.
			TopNav_MenuBar.check_subMenuOtherServiceAvailable1(FilePath_TestResult, TestCaseName, DataSet+1, testFail);
			
			// 6. Mouse hover the Register button at Global Navigator.
			GlobalNav_MenuBar.menuBar_mousehoverOnRegister();
			
			// To verify Buyer and Supplier button are displayed under the Register menu.
			GlobalNav_MenuBar.check_subMenuRegisterAvailable(FilePath_TestResult, TestCaseName, DataSet+1, testFail);

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
	 * 
	 * @throws Exception  if any exception occurred
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
	 * @return  all column's data
	 */
	@DataProvider
	public Object[][] Refactor_0001Data(){
		// To retrieve data from column of SuiteRefactor data Sheet.
		// Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programmatically when reading test data.
		return SuiteUtility.GetTestDataUtility(FilePath, TestCaseName);
	}			
	
	/**
	 * To close browser and report result as pass or fail for test cases In TestCasesList sheet.
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
