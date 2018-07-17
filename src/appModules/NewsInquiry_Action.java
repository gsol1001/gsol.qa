/**
 * This Class contains all the methods in the News Inquiry Action
 * Created: Wed 06 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/06
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.Home_Page;
import pageObjects.NewsListing_Page;

/**
 * Contain all the methods in the News Inquiry action.
 * @author Teng Shyh Wei
 *
 */
public class NewsInquiry_Action {
	
	/**
	 * Enter search keyword by select News Page Types.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSearchByNews(String dataSearchKeyword) throws Exception{
		
		// Select 'News' Page Types
		Home_Page.drpdwn_selectNewsPageTypes();
		
		// Enter text for search keyword field
		Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataSearchKeyword);
		
		// Click on the 'Search' button
		Home_Page.btn_clickKeywordButtonSearch();
		
	}	
	
	/**
	 * Go to Article entry point and click on the Article title link.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteArticleEntryPoint_ClickArticleTitle(String dataSearchKeyword) throws Exception{
		
		// Go to Article entry point
		ExecuteSearchByNews(dataSearchKeyword);
		
		// Click on the Article title link
		NewsListing_Page.lnk_clickArticleTitle().click();
		
	}
	
	/**
	 * Enter a brand new email address in the PA cross promotion (centrewell) section textbox and click on "Subscribe" button.
	 * 
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecutePACrossPromotion_EnterEmailAddr_ClickSubscribeBtn(String dataEmailAddress) throws Exception{
		
	    // Enter text in the PA cross promotion (centrewell) section textbox
		NewsListing_Page.txtbx_enterEmailAddress().sendKeys(dataEmailAddress);
		
	    // Click on the PA cross promotion (centrewell) section 'Subscribe' button
		NewsListing_Page.btn_clickSubscribe().click();
		
	}
	
	/**
	 * Enter a brand new email address in the PA Enhanced Entrance email textbox and click on "Subscribe" button.
	 * 
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecutePAEnhancedEntrance_EnterEmailAddr_ClickSubscribeBtn(String dataEmailAddress) throws Exception{
		
		// Enter text for PA Enhanced Entrance 'Business Email' field.
		NewsListing_Page.txtbx_enterPAEnhancedEntranceBusinessEmail().sendKeys(dataEmailAddress);
		
		// Click on PA Enhanced Entrance 'Subscribe' button.
		NewsListing_Page.btn_clickPAEnhancedEntranceSubscribe().click();
		
	}

}
