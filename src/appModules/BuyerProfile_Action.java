/**
 * This Class contains all the methods in the Buyer Profile Action
 * Created: Tue 18 Aug 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/08/18
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.BuyerProfile_Page;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.TopNav_MenuBar;
import pageObjects.UserProfile_Page;

/**
 * Contain all the methods in the Buyer Profile action.
 * @author Teng Shyh Wei
 *
 */
public class BuyerProfile_Action {
	
	/**
	 * Set Buyer Profile setting to "Always ask me before sending future inquiries." in User Profile.
	 * 
	 * @throws Exception  if any exception occurred
	 */
	public static void ExecuteBuyerProfile_SetAlwaysAsk() throws Exception{
		
        // Generate mouse hover event on Global Notification to click on User Profile
		GlobalNav_MenuBar.menuBar_selectUserProfile();
		
	    // To click on the 'Buyer Profile' link at the left nav.
		UserProfile_Page.lnk_clickSideBarBuyerProfile().click();
		
		// To verify Buyer Profile page is displayed.
		BuyerProfile_Page.check_buyerProfilePageIsDisplayed();
		
	    // Select 'Always ask before sending future inquiries' radio button
		BuyerProfile_Page.radbtn_selectAlwaysAsk().click();
		
		// Back to GSOL home page.
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		
	}

}
