/**
 * This Class contains all the methods in the Unverified Supplier PP Action
 * Created: Fri 06 Oct 2017
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2017/10/06
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.UnvSupplierPP_Page;

/**
 * Contain all the methods in the Unverified Supplier PP action.
 * @author Teng Shyh Wei
 *
 */
public class UnvSupplierPP_Action {

	public static void ExecuteFillInRFIStaticForm_ClickInquireNowBtn(String dataMessage) throws Exception{
		
		// Enter text for RFI Static form.
		UnvSupplierPP_Page.txtbx_enterRFIStaticForm().sendKeys(dataMessage);
		
		// Click on "Inquire Now" button.
		UnvSupplierPP_Page.btn_clickContactDetailsInquireNow().click();
		
	}
}
