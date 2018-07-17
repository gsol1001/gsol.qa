/**
 * This Class contains all the methods in the Browse Product Categories Action
 * Created: Wed 21 Dec 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/12/21
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.BrowseCategories_Page;
import pageObjects.Home_Page;

/**
 * Contain all the methods in the Browse Product Categories action.
 * @author Teng Shyh Wei
 *
 */
public class BrowseProductCategories_Action {
	
	/**
	 * Perform a product keyword search and click on "Browse Product Categories" link.
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteBrowsePdtCategoriesEntryPoint(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// Click on "Browse Product Categories" link at Footer
		Home_Page.lnk_clickBrowseProductCategories().click();
		
	}

	/**
	 * As a logged-in user, perform a product keyword search and click on "Browse Product Categories" link.
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_BrowsePdtCategoriesEntryPoint(String dataUsername,
			String dataPassword, String dataSearchKeyword) throws Exception{
		
		// As a logged in user, perform a product keyword search
		ProductInquiry_Action.ExecuteLoggedIn_EnterSearchKeyword(dataUsername, dataPassword, dataSearchKeyword);
		
		// Click on "Browse Product Categories" link.
		Home_Page.lnk_clickBrowseProductCategories().click();
		
	}
	
	/**
	 * Enter a brand new email address in the PA Inline Banner textbox and click on "Subscribe" button.
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecuteEnterEmailAddr_ClickSubscribeBtn(String dataEmailAddress) throws Exception{
		
		// Enter text for the PA Inline Banner email address textbox.
		BrowseCategories_Page.txtbx_enterPAInlineBannerEmailAddr().sendKeys(dataEmailAddress);
		
		// Click on the 'Subscribe' button.
		BrowseCategories_Page.btn_clickSubscribe().click();
		
	}

}
