/**
 * This Class contains all the methods in the Supplier Home Action
 * Created: Fri 29 May 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/05/29
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import pageObjects.SupplierHome_Page;

/**
 * Contain all the methods in the Supplier Home action.
 * @author Teng Shyh Wei
 *
 */
public class SupplierHome_Action {
	
	
	/**
	 * Add more verified products and supplier to Inquiry Basket. 
	 * 
	 * @param dataMWSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteInqBasket_AddMorePdtSupp(String dataMWSearchKeyword) throws Exception{
		
		// Enter search Keyword
		SupplierHome_Page.txtbx_enterGSOLSearchField().sendKeys(dataMWSearchKeyword);
		
		// Click Search button
		Home_Page.btn_clickKeywordButtonSearch();
		
		// To select 40 Items per page
		ProductListing_Page.drpdwn_select40ItemsPerPage();
		
    	// Select all verified products 
		ProductListing_Page.chkbx_selectAllVerPdt();
		
		// Click Add to Basket
		ProductListing_Page.lnk_clickAddToBasketInqBar().click();
		
	}
	
	/**
	 * As a logged-in user, go to Supplier PP page entry point.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_SupplierPPEntryPoint(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// As a logged-in user, go to Supplier Homepage.		
		ProductInquiry_Action.ExecuteLoggedIn_GoToSuppHomepage(dataUsername, dataPassword, dataSearchKeyword);
		
		// Close the MW Promo PP overlay.
	//	SupplierHome_Page.icon_clickCloseBtnOnPromoPPOverlay();
		
		// Click on the 'Product List' menu bar
		SupplierHome_Page.menuBar_clickProductList().click();		// Supplier PP entry point
		
	}
	
	// As a logged-in user, go to any category of Supplier's Product List.
	public static void ExecuteLoggedIn_SupplierProductListCategoryEntryPoint(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// As a logged-in user, go to Supplier Homepage.		
		ProductInquiry_Action.ExecuteLoggedIn_GoToSuppHomepage(dataUsername, dataPassword, dataSearchKeyword);		
		
		// Close the MW Promo PP overlay.
	//	SupplierHome_Page.icon_clickCloseBtnOnPromoPPOverlay();
		
		// Click on the sub menu from "Product List"
		SupplierHome_Page.drpdwn_selectProductListCategory();
		
	}
	
	/**
	 * As a logged-in user, go to Supplier ECI pages entry point.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_SupplierECIPagesEntryPoint(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// As a logged-in user, go to Supplier Homepage.
		ProductInquiry_Action.ExecuteLoggedIn_GoToSuppHomepage(dataUsername, dataPassword, dataSearchKeyword);
		
		// Close the MW Promo PP overlay.
	//	SupplierHome_Page.icon_clickCloseBtnOnPromoPPOverlay();
		
		// Click on the sub menu from 'Company Information'
		SupplierHome_Page.drpdwn_selectSupplierECI();		// Supplier ECI pages entry point
		
	}
	
	// Fill in some text in the RFI static form and click on "Continue" button.
	public static void ExecuteRFIStaticForm_EnterMessage_ClickContinueBtn(String dataMessage) throws Exception{
		
		// Fill in some text in the RFI static form
		SupplierHome_Page.txtbx_enterMsgAtRFIStaticForm().sendKeys(dataMessage);
		
		// Click on "Continue" button
		SupplierHome_Page.btn_clickContinue().click();
		
	}
		

}
