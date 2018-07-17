/**
 * This Class contains all the methods in the Supplier Inquiry Action
 * Created: Wed 11 February 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/05/29
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.CompareSuppliers_Page;
import pageObjects.Home_Page;
import pageObjects.SupplierListing_Page;

/**
 * Contain all the methods in the Supplier Inquiry action.
 * @author Teng Shyh Wei
 *
 */
public class SupplierInquiry_Action {
	
	/**
	 * Enter search keyword by select Suppliers Page Types. (from excel xls value)
	 * 
	 * @param dataPageTypes
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSearchBySuppliers(String dataPageTypes, String dataSearchKeyword) throws Exception{
		
		// Select Suppliers Page Types  (from excel .xls value)
		Home_Page.drpdwn_selectPageTypes(dataPageTypes);		
		
		// Enter search Keyword
		Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataSearchKeyword);
		
		// Wait for 3 seconds
		Thread.sleep(3000);
		
		// Click Search button
		Home_Page.btn_clickKeywordButtonSearch();
		
		// To verify Supplier KWS page is displayed.
		SupplierListing_Page.check_supplierKWSPageIsDisplayed(dataSearchKeyword);
		
	}	
	
	/**
	 * Enter search keyword by select Suppliers Page Types.
	 * 
	 * @param dataSuppSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSearchBySuppliers(String dataSuppSearchKeyword) throws Exception{
		
		// Select Suppliers Page Types
		Home_Page.drpdwn_selectSuppliersPageTypes();		
		
		// Wait for 3 seconds
		Thread.sleep(3000);
		
		// Enter search Keyword
		Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataSuppSearchKeyword);
		
		// Click Search button
		Home_Page.btn_clickKeywordButtonSearch();
		
	}
	
	// As a logged in user, enter Supplier search keyword.
	public static void ExecuteLoggedIn_SearchBySupplierKeyword(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Enter Supplier search keyword
		SupplierInquiry_Action.ExecuteSearchBySuppliers(dataSearchKeyword);		
		
	}
		
	// As a logged in user, enter search keyword and go to Supplier homepage.
	public static void ExecuteLoggedIn_GoToSupplierHomepage(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Enter search keyword and go to Supplier homepage.
		SupplierInquiry_Action.ExecuteSearchBySuppliers(dataSearchKeyword);
		
		// Click on first Supplier Name Title.
		SupplierListing_Page.lnk_clickSupplierName().click();
		
	}
	
	// As a non-logged in user, perform a supplier keyword search and go to Supplier homepage.
	public static void ExecuteNonLoggedIn_GoToSupplierHomepage(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword and go to Supplier homepage.
		SupplierInquiry_Action.ExecuteSearchBySuppliers(dataSearchKeyword);
		
		// Click on first Supplier Name Title.
		SupplierListing_Page.lnk_clickSupplierName().click();
		
	}
	
	// As a logged in user, perform a supplier keyword search and go to AGG Supplier homepage.
	public static void ExecuteLoggedIn_GoToAGGSupplierHomepage(String dataUsername, String dataPassword,
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Do a Supplier keyword search.
		SupplierInquiry_Action.ExecuteSearchBySuppliers(dataSearchKeyword);
		
		// Click on Unverified Supplier Name link
		SupplierListing_Page.lnk_clickUnvSupplierNameTitle().click();
		
	}
	
	// As a non-logged in user, perform a supplier keyword search and go to AGG Supplier homepage.
	public static void ExecuteNonLoggedIn_GoToAGGSupplierHomepage(String dataSearchKeyword) throws Exception{
		
		// Do a Supplier keyword search.
		SupplierInquiry_Action.ExecuteSearchBySuppliers(dataSearchKeyword);
		
		// Click on Unverified Supplier Name link
		SupplierListing_Page.lnk_clickUnvSupplierNameTitle().click();
		
	}
	
	/**
	 * 'Inquire Now' for single verified supplier. 
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqNow_SglVerSupp() throws Exception{				
		
		// Select single verified supplier
		SupplierListing_Page.chkbx_selectSingleVerSupp().click();    		
		
		// Click 'Inquire Now' button 
		SupplierListing_Page.btn_clickInqNowForVerSuppAtSuppListing(); 
	}
	
	
	/**
	 * 'Inquire Now' for multiple verified suppliers.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqNow_MulVerSupp() throws Exception{		
				
		// Select multiple verified suppliers
		SupplierListing_Page.chkbx_selectMultipleVerSupp();
		
		// Click 'Inquire Now' button 
		SupplierListing_Page.btn_clickInqNowForVerSuppAtInqBar().click();
		
	}
	
	// Click on "Compare Supplier" button and click on "Compare" button
	public static void ExecuteCompareSuppliers() throws Exception{
		
		// Click on "Compare Supplier" button
		SupplierListing_Page.btn_clickCompareSupplier();
		
		// Click on "Suppliers" tab on the bottom
		SupplierListing_Page.tab_clickSuppliers().click();
		
		// Click on "Compare" button
		SupplierListing_Page.btn_clickCompare().click();
		
	}
	
	// Check on "Select All" checkbox and click on "Inquire Now" button.
	public static void ExecuteSelectAllChkbx_ClickInqNowBtn() throws Exception{
		
		// Check on "Select All" checkbox
		CompareSuppliers_Page.chkbx_selectCompareAllSuppliers().click();
		
		// Click on "Inquire Now" button
		CompareSuppliers_Page.btn_clickInquireNow().click();
		
	}
	
	/**
	 * 'Inquire Now' for single unverified supplier.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqNow_SglUnvSupp() throws Exception{
				
		// Select single unverified supplier
		SupplierListing_Page.radbtn_selectSingleUnvSupp().click();
		
		// Click 'Inquire Now' button 
		SupplierListing_Page.btn_clickInqNowForUnvSuppAtSuppListing();
		
	}
	
	
	/**
	 * Select multiple verified suppliers.
	 * 
	 * @param dataSuppSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSelectMulVerSupp(String dataSuppSearchKeyword) throws Exception{
		
		// Enter search keyword by select Suppliers Page Types
		ExecuteSearchBySuppliers(dataSuppSearchKeyword);
				
		// Select multiple verified suppliers (except first chkbx)
	//	SupplierListing_Page.chkbx_selectMultipleVerifiedSuppliers();
		
    	// Select all verified suppliers 		
		SupplierListing_Page.chkbx_selectAllVerSupp();
		
		// Click Add to Basket
	//	SupplierListing_Page.lnk_clickAddToBasketInquiryBar().click();
		
	}
	
	
	/**
	 * 'Add to Basket' for multiple verified suppliers.
	 * 
	 * @param dataSuppSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSelectMulVerSupp_ClickAddToBasketBtn(String dataSuppSearchKeyword) throws Exception{
		
		// Enter search keyword by select Suppliers Page Types
		ExecuteSearchBySuppliers(dataSuppSearchKeyword);
				
    	// Select multiple verified suppliers 		
		SupplierListing_Page.chkbx_selectAllVerSupp();
		
		// Click Add to Basket
		SupplierListing_Page.btn_clickAddToBasketInquiryBar().click();
		
	}		
	
}
