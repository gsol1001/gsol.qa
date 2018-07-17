/**
 * This Class contains all the methods in the Compare Suppliers Action
 * Created: Fri 27 March 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/27
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.CompareSuppliers_Page;

/**
 * Contain all the methods in the Compare Suppliers action.
 * @author Teng Shyh Wei
 *
 */
public class CompareSuppliers_Action {
	
	/**
	 * Click 'Select All' checkbox and click 'Inquire Now' button.
	 * 
	 * @throws Exception  if any exception occurred
	 */
	public static void ExecuteSelectAllChkbx_ClickInqNowBtn()throws Exception{
		
		// Check 'Select All' checkbox at Compare Suppliers page
		CompareSuppliers_Page.chkbx_selectCompareAllSuppliers().click();    	
		
		// Click 'Inquire Now' button at Compare Suppliers page
		CompareSuppliers_Page.btn_clickInquireNow().click();
		
	}
}
