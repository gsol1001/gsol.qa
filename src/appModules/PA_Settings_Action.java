/**
 * This Class contains all the methods in the PA Settings Action.
 * Created: Thu 10 Sep 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/10
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.PA_Settings_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the PA Settings action.
 * @author Teng Shyh Wei
 *
 */
public class PA_Settings_Action {

	/**
	 * Checked all checkboxes and click on 'Update' button.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteCheckedAllCheckboxes_ClickUpdateBtn() throws Exception{
		
		// If the Products Alerts, News Alerts and Supplier Alerts settings are not checked, 
	    // checked on the checkboxes.
		PA_Settings_Page.chkbx_selectAll();
		
		// Click on 'Update' button.
		PA_Settings_Page.btn_clickUpdate().click();
		
	}
	
	/**
	 * Unchecked all checkboxes and click on 'Update' button.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteUncheckAllCheckboxes_ClickUpdateBtn() throws Exception{
		
	    // Uncheck all checkboxes.
		PA_Settings_Page.chkbx_unselectAll();
		
		// Click on 'Update' button.
		PA_Settings_Page.btn_clickUpdate().click();
		
	}
	
	/**
	 * Uncheck 'Product Alerts' checkbox and click on 'Update' button.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteUncheckPAChkbx_ClickUpdateBtn() throws Exception{
		
		// Uncheck 'Product Alerts' checkbox.
		PA_Settings_Page.chkbx_uncheckProductAlerts();
		
		// Click on 'Update' button.
		PA_Settings_Page.btn_clickUpdate().click();
		
	}
	
	/**
	 * Uncheck 'News Alerts' checkbox and click on Update.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteUncheckNewsAlertChkbx_ClickUpdateBtn() throws Exception{
		
		// Uncheck 'News Alerts' checkbox.
		PA_Settings_Page.chkbx_uncheckNewsAlerts();
		
		// Click on 'Update' button.
		PA_Settings_Page.btn_clickUpdate().click();
		
	}
	
	/**
	 * Uncheck 'Supplier Alerts' checkbox and click on 'Update' button.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteUncheckSAChkbx_ClickUpdateBtn() throws Exception{
		
		// Uncheck 'Supplier Alerts' checkbox.
		PA_Settings_Page.chkbx_uncheckSupplierAlerts();
		
		// Click on 'Update' button.
		PA_Settings_Page.btn_clickUpdate().click();
		
	}

	/**
	 * Select 'Good idea. Take me to Edit Categories page.' option and click on 'Submit' button.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteSelectGoodIdeaRadbtn_ClickSubmitBtn() throws Exception{
		
		// Select 'Good idea. Take me to Edit Categories page.' option.
		PA_Settings_Page.radbtn_selectGoodIdeaOption().click();
	//	PA_Settings_Page.radbtn_selectPASettingsOption(dataConfirmRadbtn);

	    // Click on the 'Submit' button
		PA_Settings_Page.btn_clickSubmit().click();
		
	}
	
	/**
	 * Select 'Thanks, but please proceed with unsubscribe.' option and click on 'Submit' button.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteSelectThanksRadbtn_ClickSubmitBtn() throws Exception{
		
		// Select 'Thanks, but please proceed with unsubscribe.' option.
		PA_Settings_Page.radbtn_selectUnsubscribeOption().click();
		
	    // Click on the 'Submit' button
		PA_Settings_Page.btn_clickSubmit().click();
	}
	
	/**
	 * To verify 'You have updated your settings successfully' copy is seen. All the checkboxes should be checked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_msgUpdateSuccessfullyIsSeen_AllChkbxAreSelected(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{

	    // To verify The Product Alert settings page is displayed with 'You have updated your settings successfully.' copy. 
		PA_Settings_Page.check_msgUpdateSuccessfullyIsSeen(xls, sheetName, rowNum, testFail);
		
		// To verify all the checkbox should be checked.
		PA_Settings_Page.check_allChkbxAreSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Product Alert - Settings page is displayed. All the checkboxes should still be checked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_PASettingsPageDisplayed_AllChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{

		// To verify Product Alert - Settings page is displayed. 
		PA_Settings_Page.check_PASettingsPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify all the checkboxes remain checked.
		PA_Settings_Page.check_allChkbxRemainSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify 'You have updated your settings successfully' copy is seen. All the checkboxes are unchecked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_msgUpdateSuccessfullyIsSeen_AllChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
	    // To verify The Product Alert settings page is displayed with 'You have updated your settings successfully.' copy. 
		PA_Settings_Page.check_msgUpdateSuccessfullyIsSeen(xls, sheetName, rowNum, testFail);
		
		// To verify all the checkboxes are unchecked.
		PA_Settings_Page.check_allChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
	}

	/**
	 * To verify 'You have updated your settings successfully' copy is seen. Product Alert checkbox is unchecked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_msgUpdateSuccessfullyIsSeen_PAChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
	    // To verify The Product Alert settings page is displayed with 'You have updated your settings successfully.' copy. 
		PA_Settings_Page.check_msgUpdateSuccessfullyIsSeen(xls, sheetName, rowNum, testFail);
		
		// To verify Product Alert checkbox is unchecked.
		PA_Settings_Page.check_PAChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify 'You have updated your settings successfully' copy is seen. News Alert checkbox is unchecked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_msgUpdateSuccessfullyIsSeen_NewsAlertChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
	    // To verify The Product Alert settings page is displayed with 'You have updated your settings successfully.' copy. 
		PA_Settings_Page.check_msgUpdateSuccessfullyIsSeen(xls, sheetName, rowNum, testFail);
		
		// To verify News Alert checkbox is unchecked.
		PA_Settings_Page.check_newsAlertChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify 'You have updated your settings successfully' copy is seen. Supplier Alert checkbox is unchecked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_msgUpdateSuccessfullyIsSeen_SAChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{		
		
	    // To verify The Product Alert settings page is displayed with 'You have updated your settings successfully.' copy. 
		PA_Settings_Page.check_msgUpdateSuccessfullyIsSeen(xls, sheetName, rowNum, testFail);
		
		// To verify Supplier Alert checkbox is unchecked.
		PA_Settings_Page.check_SAChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
	}	
	

/*	*//**
	 * To verify a 'Are you sure you want to stop receiving Product Alerts, News Alerts and Supplier Alerts?' copy is seen.
	 * To verify there should be 2 radio buttons options:
	 * <p><ul>
	 * <li>'Good idea. Take me to Edit Categories page'
	 * <li>'Thanks, but please proceed with unsubscribe.'
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 *//*
	public static void ExecuteMsgStopAlertsSeen_RadbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
	    // To verify a 'Are you sure you want to stop receiving Product Alerts, News Alerts and Supplier Alerts?' copy is seen. 		
		PA_Settings_Page.check_msgStopAlertsExists(xls, sheetName, rowNum, testFail);
		
		// To verify there should be 2 radio buttons 'Good idea. Take me to Edit Categories page' and 
		// 'Thanks, but please proceed with unsubscribe.' options.
		PA_Settings_Page.check_twoRdbtnOptionsExists(xls, sheetName, rowNum, testFail);
		
	}	
	
	*//**
	 * To verify a 'Are you sure you want to stop receiving Product Alerts?' copy is seen. 
	 * To verify there should be 2 radio buttons options:
	 * <p><ul>
	 * <li>'Good idea. Take me to Edit Categories page'
	 * <li>'Thanks, but please proceed with unsubscribe.'
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 *//*
	public static void ExecuteMsgStopPASeen_RadbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
	    // To verify a 'Are you sure you want to stop receiving Product Alerts?' copy is seen. 		
		PA_Settings_Page.check_msgStopReceivingPAExists(xls, sheetName, rowNum, testFail);
		
		// To verify there should be 2 radio buttons 'Good idea. Take me to Edit Categories page' and 
		// 'Thanks, but please proceed with unsubscribe.' options.
		PA_Settings_Page.check_twoRdbtnOptionsExists(xls, sheetName, rowNum, testFail);
		
	}
	
	*//**
	 * To verify a 'Are you sure you want to stop receiving News Alerts?' copy is seen.
	 * To verify there should be 2 radio buttons options:
	 * <p><ul>
	 * <li>'Good idea. Take me to Edit Categories page'
	 * <li>'Thanks, but please proceed with unsubscribe.'
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 *//*
	public static void ExecuteMsgStopNewsAlertsSeen_RadbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
	    // To verify a 'Are you sure you want to stop receiving News Alerts?' copy is seen. 		
		PA_Settings_Page.check_msgStopReceivingNewsAlertsExists(xls, sheetName, rowNum, testFail);
		
		// To verify there should be 2 radio buttons 'Good idea. Take me to Edit Categories page' and 
		// 'Thanks, but please proceed with unsubscribe.' options.
		PA_Settings_Page.check_twoRdbtnOptionsExists(xls, sheetName, rowNum, testFail);
		
	}
	
	*//**
	 * To verify a 'Are you sure you want to stop receiving Supplier Alerts?' copy is seen. 
	 * To verify there should be 2 radio buttons options:
	 * <p><ul>
	 * <li>'Good idea. Take me to Edit Suppliers page' and 
	 * <li>'Thanks, but please proceed with unsubscribe all.' 
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 *//*
	public static void ExecuteMsgStopSASeen_RadbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
	    // To verify a 'Are you sure you want to stop receiving Supplier Alerts?' copy is seen. 		
		PA_Settings_Page.check_msgStopReceivingSAExists(xls, sheetName, rowNum, testFail);
		
		// To verify there should be 2 radio buttons 'Good idea. Take me to Edit Suppliers page' and 
		// 'Thanks, but please proceed with unsubscribe all.' options.
		PA_Settings_Page.check_twoRadbtOptionsAvailable(xls, sheetName, rowNum, testFail);
		
	}
*/	
	
}
