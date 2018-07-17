/**
 * This Class contains all the methods in the Product Profile Action
 * Created: Wed 20 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/20
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.ProductProfile_Page;

/**
 * Contain all the methods in the Product Profile action.
 * @author Teng Shyh Wei
 *
 */
public class ProductProfile_Action {
	
	/**
	 * Enter message at RFI Static Form and click on "Continue" button.
	 * 
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void ExecuteRFIStaticForm_EnterMessage_ClickContinueBtn(String dataMessage) throws Exception{
		
		// Enter text at RFI Static Form.
		ProductProfile_Page.txtbx_enterMsgAtRFIStaticForm().sendKeys(dataMessage);
		
		// Click on the "Continue" button.
		ProductProfile_Page.btn_clickContinue();
		
	}
	
	public static void ExecutePALink_EnterBusinessEmail_ClickSubscribeBtn(String dataBusinessEmail) throws Exception{
		
		// Enter text for PA Enhanced Entrance 'Business Email' field.
		ProductProfile_Page.txtbx_PAEnhancedEntrance_EnterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Click on PA Enhanced Entrance 'Subscribe' button.
		ProductProfile_Page.btn_PAEnhancedEntrance_ClickSubscribe();
		
	}
}
