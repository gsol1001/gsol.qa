/**
 * This Class contains all the methods in the Mini Login Action
 * Created: Tue 19 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/19
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.MiniLogin_Page;

/**
 * Contain all the methods in the Mini Registration action.
 * @author Teng Shyh Wei
 *
 */
public class MiniLogin_Action {

	/**
	 * Enter text for "Password" field and click on the "Send Your Inquiry Now" button.
	 * 
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteMiniLogin_EnterPsw_ClickSendYourInquiryNow(
			String dataPassword) throws Exception{
		
		// Enter text for "Password" field.
		MiniLogin_Page.txtbx_enterUserPassword().sendKeys(dataPassword);;
		
		// Click on the "Send Your Inquiry Now" button.
		MiniLogin_Page.btn_clickSendYourInquiryNow().click();
		
	}
}
