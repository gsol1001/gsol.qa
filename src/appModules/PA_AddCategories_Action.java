/**
 * This Class contains all the methods in the PA Add Categories Action
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

import pageObjects.PA_AddCategories_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the PA Add Categories action.
 * @author Teng Shyh Wei
 *
 */
public class PA_AddCategories_Action {

	// ===================================================== PA Add Categories by Search Keyword ==================================================== 
	/**
	 * Enter product search keyword and click on 'Find Matching Categories' button.
	 * 
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecuteEnterPdtKeyword_ClickFindMatchingCatBtn(String dataProductKeyword) throws Exception{
		
		// Enter a product keyword in product keyword textbox.
		PA_AddCategories_Page.txtbx_enterProductKeyword().sendKeys(dataProductKeyword);	
		
		// Click on 'Find Matching Categories' button
		PA_AddCategories_Page.btn_clickFindMatchingCategories();
		
	}
	
	/**
	 * Search for a keyword or choose an industry and check on any category checkboxes which are different from the categories in pre-req.
	 * 
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecuteEnterPdtKeyword_SelectCategoriesSuggestionsChkbx(String dataProductKeyword) throws Exception{
		
		// Enter product search keyword and click on 'Find Matching Categories' button.
		PA_AddCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCatBtn(dataProductKeyword);
		
		// Check on any category checkboxes.
		PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
		
	}
	
	// =================================================== PA Add Categories by Browser Categories ==================================================
	
	/**
	 * Click on "Browser categories" tab and choose a category (e.g: Electronics) from "Choose an industry" dropdown list.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteBrowseCategories_ChooseACategory() throws Exception{
		
		// Select 'Browse' from the drop down list.
		PA_AddCategories_Page.drpdwn_selectBrowseCategories();
		
		// Select 'Electronic Components' category from 'Choose an industry to browse available categories' drop down list.
		PA_AddCategories_Page.drpdwn_selectElectronicsCategory();
		
	}
	
	/**
	 * Click on "Browse categories" tab and choose an industry and check on any category checkboxes.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteBrowseCategories_SelectCategoriesSuggestionsChkbx() throws Exception{
		
		// Click on "Browser categories" tab and choose a category (e.g: Electronics) from "Choose an industry" dropdown list.
		ExecuteBrowseCategories_ChooseACategory();
		
		// Check on any category checkboxes.
		PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
		
	}
	
	/**
	 * Click on "Browser categories" tab and choose category "Fashion Accessories" from "Choose an industry" dropdown list.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteBrowseCategories_CheckedMoreThan10Cat_ClickSaveChangesBtn() throws Exception{
		
		// Select 'Browse' from the drop down list.
		PA_AddCategories_Page.drpdwn_selectBrowseCategories();
		
		// Select 'Fashion Accessories' category from 'Choose an industry to browse available categories' drop down list.
	//	PA_AddCategories_Page.drpdwn_selectFashionAccessories();
		PA_AddCategories_Page.drpdwn_selectHealthAndPersonalCare();
		
		// Check on any category checkboxes.
		PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
		
		// Click on 'Save Changes' button.
		PA_AddCategories_Page.btn_clickSaveChanges().click();
		
	}
		
	// ============================================================ Module Registration =============================================================
	
	/**
	 * To verify Select Product Alert Categories page is displayed with suggested categories based on the keyword entered.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteSelPACatPage_SuggCatByPdtKeywordEnteredExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Select Product Alert Categories page is displayed. 
		PA_AddCategories_Page.check_selPACatPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify there are suggested categories based on the product keyword entered.
		PA_AddCategories_Page.check_suggCatByPdtKeywordEnteredExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Select Product Alert Categories page is displayed. 
	 * There are suggested categories for the product keyword entered in Registration page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteSelPACatPageDisplayed_SuggCatAvailable(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Select Product Alert Categories page is displayed. 
		PA_AddCategories_Page.check_selPACatPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify there are suggested categories for the product keyword entered in Registration page
		PA_AddCategories_Page.check_suggCatByKeyword_EnteredInRegFormExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Select Product Alert Categories page is displayed. There is no suggested categories.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteSelPACatPageDisplayed_SuggCatNotAvailable(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Select Product Alert Categories page is displayed. 
		PA_AddCategories_Page.check_selPACatPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify there is no suggested categories.
		PA_AddCategories_Page.check_noPASuggestedCategories(xls, sheetName, rowNum, testFail);
		
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
	
	
	// ========================================================= Module PA Edit Categories ==========================================================
	
	/**
	 * To verify Product Alert Add Categories page is displayed.
	 * There are suggested categories based on the keyword in L1, L2, L3 or New Product.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAAddCatPage_SuggCatByKeywordL3Exists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Product Alert Add Categories page is displayed.
		PA_AddCategories_Page.check_PAAddCategoriesPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// There are suggested categories based on the keyword in L1, L2, L3 or New Product.
		PA_AddCategories_Page.check_suggCatByKeywordInL3Exists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Product Alert Add Categories page is displayed. 
	 * There are suggested categories based on the keyword entered in PA Add Categories page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAAddCatPage_SuggCatByKeywordExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
				
		// To verify Product Alert Add Categories page is displayed. 
		PA_AddCategories_Page.check_PAAddCategoriesPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// There are suggested categories based on the keyword entered in PA Add Categories page.
		PA_AddCategories_Page.check_suggCatByKeyword_EnteredInPAHomepageExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Product Alert Add Categories page is displayed. 
	 * There are suggested categories based on the vertical title keyword.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */	
	public static void ExecutePAAddCatPage_SuggCatByVerticalTitleKeywordExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
				
		// To verify Product Alert Add Categories page is displayed. 
		PA_AddCategories_Page.check_PAAddCategoriesPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// There are suggested categories based on the vertical title keyword.
		PA_AddCategories_Page.check_suggCatByKeyword_VerticalTitleExists(xls, sheetName, rowNum, testFail);
		
	}
	
	// =========================================================== Module PA Lite Signup ============================================================
	
	/**
	 * To verify Select Product Alert Categories page is displayed. 
	 * There are suggested categories based on the keyword in L1, L2 or L3.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteSelPACatPage_SuggCatByKeywordL3Exists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Select Product Alert Categories page is displayed. 
		PA_AddCategories_Page.check_selPACatPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// There are suggested categories based on the keyword in L1, L2, L3 or New Product.
		PA_AddCategories_Page.check_suggCatByKeywordInL3Exists(xls, sheetName, rowNum, testFail);
		
	}
	
}
