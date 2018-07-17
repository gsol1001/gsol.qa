/**
 * This Class contains all the methods in the Product Alert Action
 * Created: Mon 02 March 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/02
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.GlobalNav_MenuBar;
import pageObjects.PA_EditCategories_Page;
import pageObjects.PA_Home_Page;
import pageObjects.TopNav_MenuBar;
import pageObjects.UserProfile_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the Product Alert action.
 * @author Teng Shyh Wei
 *
 */
public class ProductAlert_Action{
	
	public static WebDriver driver;
	public static Logger Add_Log = null;
	
	/**
	 * Select all PA Categories checkboxes and click 'Remove From Alert' button.
	 * 
	 * @throws Exception
	 */
    public static void ExecuteCleanUpPACategories() throws Exception{
    	        	
		// Go to Edit Categories
		GlobalNav_MenuBar.menuBar_selectEditCategories();
		
		// To verify PA Edit Categories page is displayed.
		PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed();
		
		// Clean up PA Categories if available on the page.
		PA_EditCategories_Page.check_clearPACategories();		    
    	
    	// Go back to GSOL home page
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		
    }    
    
    /**
     * Clear all PA categories and add PA categories.
     * 
     * @throws Exception
     */
    public static void ExecuteCleanUpPACategories_AddPACategories() throws Exception{
    	
		// Go to Edit Categories
    	GlobalNav_MenuBar.menuBar_selectEditCategories();
		
    	// To verify PA Edit Categories page is displayed.
    	PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed();
    	
		// Clean up PA Categories if available on the page.
		PA_EditCategories_Page.check_clearPACategories();
		
				    	    			
		// Enter text for PA Categories search field
		PA_EditCategories_Page.txtbx_enterPoductKeyword().sendKeys("cd wallets");	
		
		// Click 'Find Matching Categories' button
		PA_EditCategories_Page.btn_clickFindMatchingCategories();
		
		// Select product categories checkbox
		PA_EditCategories_Page.chkbx_selectFirstPACategories();
		

		// Enter text for PA Categories search field
		PA_EditCategories_Page.txtbx_enterPoductKeyword().sendKeys("cd");	
		
		// Click 'Find Matching Categories' button
		PA_EditCategories_Page.btn_clickFindMatchingCategories();
		
		// Select product categories checkbox
		PA_EditCategories_Page.chkbx_selectSecondPACategories();
		
		
		// Click 'Save Changes' button
		PA_EditCategories_Page.btn_clickSaveChanges().click();		
		
    	// Go back to GSOL home page
		TopNav_MenuBar.lnk_backToGSOLHomePage();
    	
    }
    
    /**
     * Clear all PA categories and add PA categories.
     * 
     * @param data1stPdtKeyword
     * @param data2ndPdtKeyword
     * @throws Exception
     */
    public static void ExecuteCleanUpPACategories_AddPACategories(String data1stPdtKeyword, 
    		String data2ndPdtKeyword) throws Exception{
    	
		// Go to Edit Categories
    	GlobalNav_MenuBar.menuBar_selectEditCategories();
		
    	// To verify PA Edit Categories page is displayed.
    	PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed();
    	
		// Clean up PA Categories if available on the page.
		PA_EditCategories_Page.check_clearPACategories();
		
		
		// Enter text for PA Categories search field
		PA_EditCategories_Page.txtbx_enterPoductKeyword().sendKeys(data1stPdtKeyword);
		
		// Wait for 3 seconds.
	//	Thread.sleep(3000);
	//	System.out.println("Wait for 3 seconds after enter product keyword.");		
				
		// Click 'Find Matching Categories' button
		PA_EditCategories_Page.btn_clickFindMatchingCategories();
		
		// Select product categories checkbox
		PA_EditCategories_Page.chkbx_selectFirstPACategories();


		// Enter text for PA Categories search field
		PA_EditCategories_Page.txtbx_enterPoductKeyword().sendKeys(data2ndPdtKeyword);
		
		// Wait for 3 seconds.
	//	Thread.sleep(3000);
	//	System.out.println("Wait for 3 seconds after enter product keyword.");
		
		// Click 'Find Matching Categories' button
		PA_EditCategories_Page.btn_clickFindMatchingCategories();
		
		// Select product categories checkbox
		PA_EditCategories_Page.chkbx_selectSecondPACategories();
		
		
		// Click 'Save Changes' button
		PA_EditCategories_Page.btn_clickSaveChanges().click();		
		
    	// Go back to GSOL home page
		TopNav_MenuBar.lnk_backToGSOLHomePage();
    	
    }
    
    /**
     * Login to GSOL and clean up all PA categories.
     * 
     * @param driver
     * @param dataUsername
     * @param dataPassword
     * @throws Exception
     */
    public static void ExecuteLoginAction_CleanUpPACategories(WebDriver driver, 
			String dataUsername, String dataPassword) throws Exception{
    	
		// Login to GSOL 
    	SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
    	        
    	// Clean up PA Categories if available on the page.
    	ProductAlert_Action.ExecuteCleanUpPACategories();
		
		// Delete all cookies
		driver.manage().deleteAllCookies();	
		driver.navigate().refresh();
		
    } 
    
    /**
     * Login to GSOL and clean up all PA categories.
     * 
     * @param dataUsername
     * @param dataPassword
     * @throws Exception
     */
    public static void ExecuteLoggedIn_CleanUpPACategories(String dataUsername, 
    		String dataPassword) throws Exception{
    	
		// Login to GSOL 
    	SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
    	
    	// Clear all PA categories 
    	ProductAlert_Action.ExecuteCleanUpPACategories();
    }
    
    /**
     * Login to GSOL, clean up all PA categories and add PA categories.
     * 
     * @param driver
     * @param dataUsername
     * @param dataPassword
     * @throws Exception
     */
    public static void ExecuteLoginAction_CleanUpPACategories_AddPACategories(WebDriver driver, 
			String dataUsername, String dataPassword) throws Exception{
    	
		// Login to GSOL 
    	SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
    	
    	// Clean up PA Categories if available on the page
    	ProductAlert_Action.ExecuteCleanUpPACategories_AddPACategories();
    	
		// Delete all cookies
		driver.manage().deleteAllCookies();	
		driver.navigate().refresh();
		
    }
    
    /**
     * Login to GSOL, clean up all PA categories and add PA categories.
     * 
     * @param dataUsername
     * @param dataPassword
     * @throws Exception
     */
    public static void ExecuteLoginAction_CleanUpPACategories_AddPACategories(String dataUsername,
    		String dataPassword) throws Exception{
    	
		// Login to GSOL 
    	SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
    	
		// Clear all PA categories and add PA categories.
		ProductAlert_Action.ExecuteCleanUpPACategories_AddPACategories();
		
    }
    
    // ================================================================== Module Registration =======================================================
    
    /**
     * To verify PA homepage is displayed. 
     * Verify that the PA categories selected in Select PA Categories page are displayed.
     * 
     * @param driver
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList
     * @throws Exception
     */
    public static void ExecutePAHomepage_PACatSelIsDisplayed(WebDriver driver, Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	
    	// Go back to previous page.
    	driver.navigate().back();
    	
		// Click on the "Product Alert" link at the left nav.
		UserProfile_Page.lnk_clickSideBarProductAlert();
		
		// To verify PA homepage is displayed. 
		PA_Home_Page.check_PAHomepageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the PA categories selected in Select PA Categories page are displayed.
		PA_Home_Page.check_PACatSelIsDisplayed(xls, sheetName, rowNum, testFail, checkedCatNameList);

    }
    
    /**
     * To verify PA homepage is displayed. 
     * Verify that the PA categories selected in pre-req as well as Select PA Categories page are displayed.
     * Applied to test case 1I.
     * 
     * @param driver
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedPACatNameList
     * @param checkedCatNameList
     * @throws Exception
     */
    public static void ExecutePAHomepage_PACatSelIsDisplayed(WebDriver driver, Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedPACatNameList, List<String> checkedCatNameList) throws Exception{
    	
    	// Go back to previous page.
    	driver.navigate().back();
    	
		// Click on the "Product Alert" link at the left nav.
		UserProfile_Page.lnk_clickSideBarProductAlert();
		
		// To verify PA homepage is displayed. 
		PA_Home_Page.check_PAHomepageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the PA categories selected in Select PA Categories page are displayed.
		PA_Home_Page.check_PACatSelIsDisplayed(xls, sheetName, rowNum, testFail, checkedPACatNameList, checkedCatNameList);

    }

    /**
     * To verify PA homepage is displayed. Verify that "You currently have no categories selected for Product Alert." statement exists.
     * 
     * @param driver
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @throws Exception
     */
    public static void ExecutePAHomepage_MsgNoSubsPACatIsDisplayed(WebDriver driver, Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	
    	// Go back to previous page
    	driver.navigate().back();
    	
		// Click on the "Product Alert" link at the left nav.
		UserProfile_Page.lnk_clickSideBarProductAlert();
		
		// To verify PA homepage is displayed. 
		PA_Home_Page.check_PAHomepageIsDisplayed(xls, sheetName, rowNum, testFail);
		
    	// To verify "You currently have no categories selected for Product Alert." statement exists.
    	PA_Home_Page.check_msgNoSubsPACatDisplayed(xls, sheetName, rowNum, testFail);
    }
    
    // ============================================================== Module Product Alert ==========================================================
    
    /**
     * To verify PA homepage is displayed. Verify that "You currently have no categories selected for Product Alert." statement exists.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @throws Exception
     */
    public static void ExecutePAHomepage_MsgNoSubsPACatDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
		
		// To verify PA homepage is displayed. 
		PA_Home_Page.check_PAHomepageIsDisplayed(xls, sheetName, rowNum, testFail);
		
    	// To verify "You currently have no categories selected for Product Alert." statement exists.
    	PA_Home_Page.check_msgNoSubsPACatDisplayed(xls, sheetName, rowNum, testFail);
    	
    }
    
    /**
     * Enter a product keyword in product keyword textbox and click on "Search" button.
     * 
     * @param dataProductKeyword
     * @throws Exception
     */
    public static void ExecutePAHomepage_EnterPdtKeyword_ClickSearchBtn(String dataProductKeyword) throws Exception{
    	
    	// Enter text for product keyword
		PA_Home_Page.txtbx_enterProductKeyword().sendKeys(dataProductKeyword);
		
		// Click on 'Search' button
		PA_Home_Page.btn_clickSearch();
		
    }
}
