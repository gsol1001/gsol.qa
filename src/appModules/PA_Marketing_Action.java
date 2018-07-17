/**
 * This Class contains all the methods in the PA Marketing Action
 * Created: Wed 14 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/14
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.PA_Marketing_Page;

/**
 * Contain all the methods in the PA Marketing action.
 * @author Teng Shyh Wei
 *
 */
public class PA_Marketing_Action {

	/**
	 * Enter a brand new email address in the email textbox and click on "Subscribe" button.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecutePAMarketing_EnterEmailAddr_ClickSignMeUpBtn(String dataBusinessEmail) throws Exception{
		
		// Enter a brand new email address in the email textbox.
		PA_Marketing_Page.txtbx_enterEmailAddress().sendKeys(dataBusinessEmail);
		
		// Click on 'Sign me up' button.
		PA_Marketing_Page.btn_clickSignMeUp().click();
			
	}
}
