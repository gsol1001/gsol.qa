/**
 * This Class contains all the methods in the PA Lite Confirmation Action.
 * Created: Thu 08 Oct 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/08
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.PALite_Confirmation_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the PA Lite Confirmation action.
 * @author Teng Shyh Wei
 *
 */
public class PALite_Confirmation_Action {
	
	/**
	 * To verify PA Lite confirmation page is displayed.
	 * To verify that upgrade upsell section is available and up to 10 PA categories selected are displayed.
	 *  
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePALiteConfPage_UpgUpsellSec_UpTo10CatSelAreDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify PA Lite confirmation page is displayed. 
		PALite_Confirmation_Page.check_PALiteConfPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that upgrade upsell section is available.
		PALite_Confirmation_Page.check_upgradeUpsellSecExists(xls, sheetName, rowNum, testFail);
		
		// To verify up to 10 PA categories selected in Step 3-4 are displayed.
		PALite_Confirmation_Page.check_upTo10CatSelAreDisplayed(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Enter text for search keyword field and click on the 'Search' button.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteEnterSearchKeyword_ClickSearchBtn(String dataSearchKeyword) throws Exception{
		
		// Enter text for search keyword field.
		PALite_Confirmation_Page.txtbx_enterGSOLSearchField().sendKeys(dataSearchKeyword);
		
		// Click on the 'Search' button.
		PALite_Confirmation_Page.btn_clickKeywordButtonSearch();
		
		// Close the Help Tour overlay
	//	ProductListing_Page.btn_closeHelpTourOverlay();
		
	}

}
