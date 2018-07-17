/**
 * This Class contains all the methods in the New Products Action
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

import pageObjects.NewProducts_Page;

/**
 * Contain all the methods in the New Products action.
 * @author Teng Shyh Wei
 *
 */
public class NewProducts_Action {

	/**
	 * Enter a brand new email address in the PA cross promotion (centrewell) section textbox and click on "Subscribe" button.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecuteEnterBusinessEmail_ClickSubscribeBtn(String dataBusinessEmail) throws Exception{
		
		// Enter a brand new email address in the PA cross promotion (centrewell) section textbox.			
		NewProducts_Page.txtbx_enterBusinessEmail().clear();
		NewProducts_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Click on the "Subscribe" button.
		NewProducts_Page.btn_clickSubscribe().click();
		
	}
		
}
