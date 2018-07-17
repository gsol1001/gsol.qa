/**
 * This Class contains all the methods in the PA Lite Signup Action.
 * Created: Tue 01 Sep 2014
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

import pageObjects.Home_Page;
import pageObjects.PA_AddCategories_Page;
import pageObjects.ProductListing_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.TopNav_MenuBar;
import utility.Read_XLS;

/**
 * Contain all the methods in the PA Lite Signup action.
 * @author Teng Shyh Wei
 *
 */
public class PALite_Signup_Action {
	
	/**
	 * Subscribe to PA Lite and go to PA Lite Confirmation page.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecutePALiteSignup(String dataBusinessEmail) throws Exception{
		
		// Enter a brand new email address in the Get Notified section textbox and click on "Subscribe" button.
		PALite_Signup_Action.ExecutePAGetNotified_EnterEmailAddr_ClickSubsribeBtn(dataBusinessEmail);
		
		// Click on "Browse categories" tab and choose a category from "Choose an industry" dropdown list.
		PA_AddCategories_Action.ExecuteBrowseCategories_ChooseACategory();
		
		// Check on any category checkboxes.
		PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
		
		// Click on 'Go to Confirmation' button.
		PA_AddCategories_Page.btn_clickGoToConfirmation();
		
		// Back to GSOL homepage
	//	TopNav_MenuBar.lnk_backToGSOLHomePage();
		
	}
	
	// Subscribe to PA Lite and go to PA Lite Confirmation page.
	public static void ExecutePALiteSignup_GoToPALiteConfPage(String dataBusinessEmail, String dataProductKeyword) throws Exception{
		
		// Enter a brand new email address in the Get Notified section textbox and click on "Subscribe" button.
		PALite_Signup_Action.ExecutePAGetNotified_EnterEmailAddr_ClickSubsribeBtn(dataBusinessEmail);
		
		// Enter product search keyword and click on 'Find Matching Categories' button.
		PA_AddCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCatBtn(dataProductKeyword);
		
		// Check on any category checkboxes.
		PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
		
		// Click on 'Go to Confirmation' button.
		PA_AddCategories_Page.btn_clickGoToConfirmation();
		
	}	
	
	/**
	 * Subscribe to PA Lite and go to PA Lite Confirmation page. Go back to GSOL homepage.
	 * 
	 * @param dataBusinessEmail
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecutePALiteSignup(String dataBusinessEmail, String dataProductKeyword) throws Exception{
		
		// Enter a brand new email address in the Get Notified section textbox and click on "Subscribe" button.
		PALite_Signup_Action.ExecutePAGetNotified_EnterEmailAddr_ClickSubsribeBtn(dataBusinessEmail);
		
		// Enter product search keyword and click on 'Find Matching Categories' button.
		PA_AddCategories_Action.ExecuteEnterPdtKeyword_ClickFindMatchingCatBtn(dataProductKeyword);
		
		// Check on any category checkboxes.
		PA_AddCategories_Page.chkbx_selectCategoriesSuggestions().click();
		
		// Click on 'Go to Confirmation' button.
		PA_AddCategories_Page.btn_clickGoToConfirmation();
		
		// Back to GSOL homepage
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		
	}
	
    // =================================================== Start of Enhanced Entrance Link section ==================================================
	
	/**
	 * Enter a brand new email address in the PA Enhanced Entrance email textbox and click on 'Subscribe' button.
	 * L3, L4 entry point.
	 * 
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecutePAEnhancedEntrance_EnterEmailAddr_ClickSubscribeBtn(String dataBusinessEmail) throws Exception{
		
		// Enter text for PA Enhanced Entrance 'Business Email' field.
		ProductListing_Page.txtbx_PAEnhancedEntrance_EnterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Click on PA Enhanced Entrance 'Subscribe' button.
		ProductListing_Page.btn_PAEnhancedEntrance_ClickSubscribe().click();
		
	}
	
	/**
	 * Enter a brand new email address in the PA Enhanced Entrance email textbox and click on 'Subscribe' button.
	 * GSOL PP page entry point.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecutePPEnhancedEntrance_EnterEmailAddr_ClickSubscribeBtn(String dataBusinessEmail) throws Exception{
		
		// Enter text for PA Enhanced Entrance 'Business Email' field.
		ProductProfile_Page.txtbx_PAEnhancedEntrance_EnterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Click on PA Enhanced Entrance 'Subscribe' button.
		ProductProfile_Page.btn_PAEnhancedEntrance_ClickSubscribe();
		
	}
	
	/**
	 * To verify the PA Enhanced Entrance image is changed. 
	 * To verify hyperlink of the Enhanced Entrance is removed and the copy changed to 'View latest products'.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAEnhancedEntrance_ViewLatesPdtLinkExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify the PA Enhanced Entrance image is changed. 
		ProductListing_Page.check_imgPAEnhancedEntranceIsChanged(xls, sheetName, rowNum, testFail);
		
		// The hyperlink of the Enhanced Entrance is removed and the copy changed to "View latest products".		
		ProductListing_Page.check_lnkPAEnhancedEntranced_ViewLatestPdtLinkExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify the PA Enhanced Entrance image is changed. 
	 * To verify hyperlink of the Enhanced Entrance is removed and the copy changed to 'View latest products'.
	 * To verify message "We've sent a confirmation e-mail to autoqa_gsolnewxxxx@gmail.com. 
	 * Click on the link in the e-mail to activate and start receiving free alert when new productsa are posted" 
	 * is displayed beside Enhanced Entrance link.
	 *  
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecutePAEnhancedEntrance_ConfCopyMessageExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataBusinessEmail) throws Exception{
		
		// To verify the PA Enhanced Entrance image is changed. 
		ProductListing_Page.check_imgPAEnhancedEntranceIsChanged(xls, sheetName, rowNum, testFail);
		
		// To verify hyperlink of the Enhanced Entrance is removed and the copy changed to 'View latest products'.
		ProductListing_Page.check_lnkPAEnhancedEntranced_ViewLatestPdtExists(xls, sheetName, rowNum, testFail);
		
		// To verify message "We've sent a confirmation e-mail to autoqa_gsolnewxxxx@gmail.com. 
		// Click on the link in the e-mail to activate and start receiving free alert when new products are posted" 
		// is displayed beside Enhanced Entrance link.
		ProductListing_Page.check_confCopyEnhancedEntranceLinkExists(xls, sheetName, rowNum, testFail, dataBusinessEmail);
		
	}
	
    // ==================================================== End of Enhanced Entrance Link section ===================================================
	
    // ============================================== Start of PA cross promotion (centrewell) section ==============================================
	
	/**
	 * To verify there are suggested categories in PA cross promotion (centrewell) section 
	 * with the first category's checkbox is checked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePACrossPromotion_SuggCatExists_1stCatChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify there are suggested categories in PA cross promotion (centrewell) section.
		ProductListing_Page.check_PACrossPromotion_SuggCatExists(xls, sheetName, rowNum, testFail);
		
		// To verify the first category's checkbox is checked.
		ProductListing_Page.check_PACrossPromotion_1stCatChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Enter a brand new email address in the PA cross promotion (centrewell) section textbox and click on "Subscribe" button.
	 * 
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecutePACrossPromotion_EnterEmailAddr_ClickSubscribeBtn(String dataEmailAddress) throws Exception{
		
	    // Enter text in the PA cross promotion (centrewell) section textbox
		ProductListing_Page.txtbx_PACrossPromotion_EnterEmailAddress().sendKeys(dataEmailAddress);
	
	    // Click on the PA cross promotion (centrewell) section 'Subscribe' button
		ProductListing_Page.btn_PACrossPromotion_ClickSubscribe().click();
		
	}	

    // =============================================== End of PA cross promotion (centrewell) section ===============================================
	
	// ===================================================== Start of PA Catfish Banner section =====================================================
	
	/**
	 * To verify there are suggested categories in PA Catfish Banner section with the first category's checkbox is checked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePACatfishBanner_SuggCatExists_1stCatChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify there are suggested categories in PA Catfish Banner section
		ProductListing_Page.check_PACatfishBanner_suggCatExists(xls, sheetName, rowNum, testFail);
		
		// To verify the first category's checkbox is checked.
		ProductListing_Page.check_PACatfishBanner_1stCatChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Enter a brand new email address in the PA Catfish Banner email field and click on "Register" button.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecutePACatfishBanner_EnterEmailAddr_ClickRegisterBtn(String dataBusinessEmail) throws Exception{
		
		// Enter text for PA Catfish Banner 'Business Email' field.
		ProductListing_Page.txtbx_PACatfishBanner_EnterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Click on the "Register" button.
		ProductListing_Page.btn_PACatfishBanner_ClickRegister().click();
	}
	
	// ====================================================== End of PA Catfish Banner section ======================================================
	
    // ======================================================== Start of Get Notified section =======================================================
	
	/**
	 * Enter a brand new email address in the Get Notified section textbox and click on "Subscribe" button.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecutePAGetNotified_EnterEmailAddr_ClickSubsribeBtn(String dataBusinessEmail) throws Exception{
		
        // Enter text in the Get Notified section textbox
		Home_Page.txtbx_enterGetNotifiedEmailAddress().sendKeys(dataBusinessEmail);

        // Click on Get Notified section 'Subscribe' button
		Home_Page.btn_clickGetNotifiedSubscribe().click();
		
	}	

    // ========================================================== End of Get Notified section =======================================================
	
	// ======================================================== Start of New Products section =======================================================
	
	/**
	 * Verify elements available in "New Products" section.	
	 * To verify Copy header shows "Free Alerts on newly added products!" in black.
	 * To verify Product keyword text box and e-mail address text box is available.
	 * To verify "Subscribe" button is available and displayed next to e-mail address text box.
	 * 		
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteCopyCPP_TxtbxEmailAddr_SubsBtnIsExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify Copy header shows "Free Alerts on newly added products!" in black.
		Home_Page.check_copyCPPFreeAlertsExists(xls, sheetName, rowNum, testFail);
		
		// To verify Product keyword text box and e-mail address text box is available.
		Home_Page.check_txtbxCPPBusinessEmailExists(xls, sheetName, rowNum, testFail);
		
		// To verify "Subscribe" button is available and displayed next to e-mail address text box.
		Home_Page.check_btnSubscribeIsAvailable(xls, sheetName, rowNum, testFail);
	}

	// ========================================================== End of New Products section =======================================================

}
