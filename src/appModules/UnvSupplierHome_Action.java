/**
 * This Class contains all the methods in the Unverified Supplier Home Action
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

import pageObjects.UnvSupplier_Homepage;

/**
 * Contain all the methods in the Unverified Supplier Home action.
 * @author Teng Shyh Wei
 *
 */
public class UnvSupplierHome_Action {
	
	// Fill in some text in the RFI static form and click on the "Continue" button.
	public static void ExecuteFillInRFIStaticForm_ClickContinueBtn(String dataMessage) throws Exception{
		
		// Enter text for RFI Static form.
		UnvSupplier_Homepage.txtbx_enterRFIStaticForm().sendKeys(dataMessage);
		
		// Click on "Continue" button.
		UnvSupplier_Homepage.btn_clickContinue().click();
		
	}
	
	// Check on multiple PPs checkboxes and click on "Inquire Now" button.
	public static void ExecuteSelectMultiplePPsChkbx_ClickInquireNowBtn() throws Exception{
		
		// Check on multiple PPs checkboxes.
		UnvSupplier_Homepage.chkbx_select1stPPChkbxAtRelatedVerPdtList();
		UnvSupplier_Homepage.chkbx_select3rdPPChkbxAtRelatedVerPdtList();
		
		// Click on "Inquire Now" button.
		UnvSupplier_Homepage.btn_clickInquireNowBtnAtRelatedVerPdtList().click();
		
	}
		
	// Click on "Select all" link and click on "Inquire Now" button.
	public static void ExecuteClickSelectAllLink_ClickInquireNowBtn() throws Exception{
	
		// Click on "Select all" link.
		UnvSupplier_Homepage.lnk_clickSelectAllAtReleatedVerPdtList().click();
		
		// Click on "Inquire Now" button.
		UnvSupplier_Homepage.btn_clickInquireNowBtnAtRelatedVerPdtList().click();
		
	}
	
	// Scroll to the footer of the page and click on Inquire Now button.
	public static void ExecuteClickInqNowBtnAtFloatingContactSection() throws Exception{
		
		// In order to view Floating Contact section, scroll to the footer of the page.
		UnvSupplier_Homepage.scrollToFooterSection();
		
		// Click on "Inquire Now" button.
		UnvSupplier_Homepage.btn_clickInquireNowAtFloatingContactSection().click();
		
	}
	
	// Scroll to the footer of the page and click on Product Alert link.
	public static void ExecuteClickPALinkAtFloatingContactSection() throws Exception{
		
		// In order to view Floating Contact section, scroll to the footer of the page.
		UnvSupplier_Homepage.scrollToFooterSection();
		
		// Click on PA "Get e-mail alerts on latest products!" link
		UnvSupplier_Homepage.lnk_clickPALinkAtFloatingContactSection().click();
		
	}
	
	
	

}
