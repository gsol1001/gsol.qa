/**
 * This Class contains all the methods in the Compare Products Action
 * Created: Thu 18 May 2017
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2017/05/18
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.CompareProducts_Page;

/**
 * Contain all the methods in the Compare Products action.
 * @author Teng Shyh Wei
 *
 */
public class CompareProducts_Action {
	
	/**
	 * Click 'Select All' checkbox and click 'Inquire Now' button.
	 * 
	 * @throws Exception  if any exception occurred
	 */
	public static void ExecuteSelectAllChkbx_ClickInqNowBtn()throws Exception{
		
		// Check 'Select All' checkbox at Compare Products page
		CompareProducts_Page.chkbx_selectCompareAllProducts().click();    	
		
		// Click 'Inquire Now' button at Compare Products page
		CompareProducts_Page.btn_clickInquireNow().click();
		
	}

}
