/**
 * This Class contains all the methods in the PA Edit Categories Action
 * Created: Thu 25 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/25
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.GlobalNav_MenuBar;
import pageObjects.PA_AddCategories_Page;
import pageObjects.PA_EditCategories_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the PA Edit Categories action.
 * @author Teng Shyh Wei
 *
 */
public class PA_EditCategories_Action {

	/**
	 * As a logged in user, go to PA Edit Categories page.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_GoToPAEditCategoriesPage(String dataUsername, String dataPassword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Go to PA Edit Categories page.
		GlobalNav_MenuBar.menuBar_selectEditCategories();
		
	}
	
	/**
	 * As a logged in user, clean up all the PA Categories. 
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_CleanUpPACategories(String dataUsername, String dataPassword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// To clean up PA Categories if available on the page.
		ProductAlert_Action.ExecuteCleanUpPACategories();
		
	}
	
	/**
	 * Enter product search keyword and click on 'Find Matching Categories' button.
	 * 
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecuteEnterPdtKeyword_ClickFindMatchingCategoriesBtn(String dataProductKeyword) throws Exception{
		
		// Enter text for PA Categories search field
		PA_EditCategories_Page.txtbx_enterPoductKeyword().sendKeys(dataProductKeyword);		
		
		// Wait for 3 seconds.
	//	Thread.sleep(3000);
	//	System.out.println("Wait for 3 seconds after enter product keyword.");
		
		// Click 'Find Matching Categories' button
		PA_EditCategories_Page.btn_clickFindMatchingCategories();
		
	}
	
	/**
	 * To verify category checkboxes are checked. Selected categories are grey-ed out and 
	 * the categories are appear in the selected categories column.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedCatNameList
	 * @throws Exception
	 */
	public static void ExecuteCatChkbxSelected_GreyedOut_AppearInSelColumn(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
		
		// To verify category checkboxes are checked. 
		PA_AddCategories_Page.check_chkbxCategoriesSuggestionsSelected(xls, sheetName, rowNum, testFail);
		
		// To verify selected categories are grey-ed out.		
	//	PA_AddCategories_Page.check_selCatAreGreyedOut(xls, sheetName, rowNum, testFail);
		
		// To verify selected categories are appear in the selected categories column.
		PA_AddCategories_Page.check_selCatAppearInSelColumn(xls, sheetName, rowNum, testFail, checkedCatNameList);
		
	}	
	
	/**
	 * To verify Product Alert Edit Categories page is displayed. There is no suggested categories.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAEditCatPageDisplayed_SuggCatNotAvailable(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Product Alert Edit Categories page is displayed. 
		PA_EditCategories_Page.check_PAEditCategoriesPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify there is no suggested categories.
		PA_EditCategories_Page.check_noPASuggestedCategories(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify PA Edit Categories confirmation page with message "Successful! You have added x product categories." is displayed.
	 *  
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAEditCatConfPage_MsgSuccessfulAddedDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify PA Edit Categories confirmation page is displayed
		PA_EditCategories_Page.check_PAEditCatConfPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify message "Successful! You have added x product categories." is displayed. 
		PA_EditCategories_Page.check_msgSuccessfulAddedPdtCatExists(xls, sheetName, rowNum, testFail);
					
	}
	
	/**
	 * To verify PA Edit Categories confirmation page with message "Successful! You have added x product categories." is displayed. 
	 * To verify recommended categories section is available.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAEditCatConfPage_MsgSuccAdded_RecCatSecExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify PA Edit Categories confirmation page is displayed.
		PA_EditCategories_Page.check_PAEditCatConfPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify message 'Successful! You have added x product categories.' is displayed.
		PA_EditCategories_Page.check_msgSuccessfulAddedPdtCatExists(xls, sheetName, rowNum, testFail);
		
		// To verify recommended categories section is available.
		PA_EditCategories_Page.check_recommendedCategorySectionExists(xls, sheetName, rowNum, testFail);

	}

	/**
	 * To verify PA Edit Categories confirmation page with message "Updated! You have removed all of your product categories." is displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAEditCatConfPage_MsgSuccessfulUpdateDisplayed(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify PA Edit Categories confirmation page is displayed.
		PA_EditCategories_Page.check_PAEditCatConfPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
	    // To verify message "Updated! You have removed all of your product categories" is displayed
		PA_EditCategories_Page.check_msgRemovedAllPdtCatExists(xls, sheetName, rowNum, testFail);
		
	}

}
