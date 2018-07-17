/**
 * This Class contains all the methods in the eMag Lite Confirmation Action.
 * Created: Tue 01 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/01
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.eMagLite_Confirmation_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the eMag Lite Confirmation action.
 * @author Teng Shyh Wei
 *
 */
public class eMagLite_Confirmation_Action {
	
	/**
	 * Enter a brand new email address in the PA upsell section textbox and click on "Subscribe" button.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecuteEnterBusinessEmail_ClickSubscribeBtn(String dataBusinessEmail) throws Exception{
		
		// Enter text for 'Business Email' field.
		eMagLite_Confirmation_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Click on the 'Subscribe' button.
		eMagLite_Confirmation_Page.btn_clickSubscribe().click();
	}
	
    /**
     * To verify eMag Lite Confirmation page is displayed. 
     * To verify that PAIDSUB, PA upsell and upgrade upsell section are available.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @throws Exception
     */
    public static void ExecuteEmagLite_PAIDSUB_PAUpsell_UpgUpsellSecExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{

    	// To verify eMag Lite Confirmation page is displayed.
		eMagLite_Confirmation_Page.check_eMagLiteConfPageDisplayed(xls, sheetName, rowNum, testFail);
		
        // To verify PAIDSUB section are available on the page.
    	eMagLite_Confirmation_Page.check_PAIDSUBSectionExists(xls, sheetName, rowNum, testFail);
    	
        // To verify PA upsell section are available on the page.
    	eMagLite_Confirmation_Page.check_PAUpsellSectionExists(xls, sheetName, rowNum, testFail);
    	
        // To verify upgrade upsell section are available on the page.
    	eMagLite_Confirmation_Page.check_upgradeUpsellSectionExists(xls, sheetName, rowNum, testFail);
    	
    }


}
