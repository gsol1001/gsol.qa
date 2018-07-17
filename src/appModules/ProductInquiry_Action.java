/**
 * This Class contains all the methods in the Product Inquiry Action
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/07
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.BrowseCategories_Page;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.Home_Page;
import pageObjects.PA_EditCategories_Page;
import pageObjects.PA_Landing_Page;
import pageObjects.ProductListing_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.SupplierHome_Page;
import pageObjects.SupplierProductList_Page;

/**
 * Contain all the methods in the Product Inquiry action.
 * @author Teng Shyh Wei
 *
 */
public class ProductInquiry_Action {
	
	/**
	 * Enter search keyword by select Products Page Types (from excel .xls value).
	 * 
	 * @param dataPageTypes
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSearchByProducts(String dataPageTypes, String dataSearchKeyword) throws Exception{
		
		// Select Products Page Types (from excel .xls value)
		Home_Page.drpdwn_selectPageTypes(dataPageTypes);		
		
		// Enter text for search keyword field
		Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataSearchKeyword);
		
		// Click on the 'Search' button
		Home_Page.btn_clickKeywordButtonSearch();
		
	}
	
	/**
	 * Enter search keyword by select Products Page Types.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSearchByProducts(String dataSearchKeyword) throws Exception{
		
		// Enter text for search keyword field
		Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataSearchKeyword);
		
		// Wait for 3 seconds
		Thread.sleep(3000);
		
		// Click on the 'Search' button
		Home_Page.btn_clickKeywordButtonSearch();
		
		// Due to Bug#85, move the mouse to temp fixed the issue
		ProductListing_Page.btn_mouseoverToSearchBtn();
		
		// Wait for 5 seconds
		Thread.sleep(5000);
		
		// Close the Help Tour overlay.
	//	ProductListing_Page.btn_closeHelpTourOverlay();
		
	}	
	
	// Perform a product keyword search (without close Help Tour overlay)
	public static void ExecuteSearchByProductsAgain(String dataSearchKeyword) throws Exception{
		
		// Enter text for search keyword field
		Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataSearchKeyword);
		
		// Click on the Search button
		Home_Page.btn_clickKeywordButtonSearch();
		
	}
	
	// Perform a product keyword search and go to Supplier List tab view.
	public static void ExecuteSearchByProducts_GoToSupplierListTab(String dataSearchKeyword) throws Exception{
		
		// Enter text for search keyword field
		Home_Page.txtbx_enterGSOLSearchField().sendKeys(dataSearchKeyword);
		
		// Click on the 'Search' button
		Home_Page.btn_clickKeywordButtonSearch();
		
		// Close the Help Tour overlay.
	//	ProductListing_Page.btn_closeHelpTourOverlay();
		
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
	
	}
	
	/**
	 * As a logged in user, enter search keyword by select Products Page Types.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_EnterSearchKeyword(String dataUsername, String dataPassword,
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);

	}
	
	// As a logged in user, enter search keyword and go to Supplier List tab.
	public static void ExecuteLoggedIn_GoToSupplierListTab(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Enter search keyword and go to Supplier List tab.
		ProductInquiry_Action.ExecuteSearchByProducts_GoToSupplierListTab(dataSearchKeyword);
		
	}
	
	
	// Close the Help Tour overlay and click on Supplier List tab.
	public static void ExecuteCloseHelpTourOverlay_ClickOnSuppListTab() throws Exception{
		
		// Close the Help Tour overlay
	//	ProductListing_Page.btn_closeHelpTourOverlay();			
		
		// Click on Supplier List tab
		ProductListing_Page.tab_clickSupplierList().click();
		
	}
	
    // ========================================================== Start of RFI Flow section =========================================================

	/**
	 * Inquire on any product(s) and go to RFI form (KWS page entry point).
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteInqSglVerPdt(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Due to page optimization, waits for 3 seconds
		Thread.sleep(3000);
		System.out.println("Waits for 3 seconds");
		
		// Click 'Inquire Now' button
		ProductListing_Page.btn_clickInqNowForVerPdtAtPdtListing();
		
	}
	
	// Inquire on any product(s) and go to RFI form (KWS page entry point)
	public static void ExecuteInqSglVerPdtAgain(String dataSearchKeyword) throws Exception{
		
		// Perform a product keyword search
		ProductInquiry_Action.ExecuteSearchByProductsAgain(dataSearchKeyword);
		
		// Click on "Inquire Now" button
		ProductListing_Page.btn_clickInqNowForVerPdtAtPdtListing();
		
	}
	
	/**
	 * Products Inquiry - 'inquire now' for single verified product from single category. 
	 * Applied to test case 13A, 13B, 14A, 14B, 15A, 15B.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqNow_SglVerPdt_SglCat() throws Exception{		
		
		// Select single Category Product
		ProductListing_Page.lnk_selectSingleCategory().click();    		
		
		// MR#45284 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Select single Verified Product
		ProductListing_Page.chkbx_selectSingleVerPdt().click();   	
		
		// Click 'Inquire Now' button
		ProductListing_Page.btn_clickInqNowForVerPdtAtPdtListing();

	}
	
	/**
	 * As a new user, inquire for single category product(s) and go to RFI form.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteNonLoggedIn_InqSglVerPdt(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// Products Inquiry - 'inquire now' for single verified product from single category.
		ProductInquiry_Action.ExecuteInqNow_SglVerPdt_SglCat();
		
	}
	
	/**
	 * As a logged in user, inquire on any product(s) and go to RFI form.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_InqSglVerPdt(String dataUsername, String dataPassword,
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// Due to page optimization, waits for 3 seconds
		Thread.sleep(3000);
		System.out.println("Waits for 3 seconds");
		
		// Products Inquiry - 'inquire now' for single verified product from single category.
		ProductInquiry_Action.ExecuteInqNow_SglVerPdt_SglCat();
		
	}
	
	/**
	 * As a logged in user, clean up subscribed PA category, inquire on any product(s) and go to RFI form.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_CleanUpPA_InqSglVerPdt(String dataUsername, String dataPassword,
			String dataSearchKeyword) throws Exception{
		
		// As a logged in user, clean up all the PA Categories. 
		PA_EditCategories_Action.ExecuteLoggedIn_CleanUpPACategories(dataUsername, dataPassword);
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// Products Inquiry - 'inquire now' for single verified product from single category.
		ProductInquiry_Action.ExecuteInqNow_SglVerPdt_SglCat();
		
	}
		
	/**
	 * Product Inquiry - 'inquire now' for multiple verified products from single category.
	 * Applied to test case 13E, 14C, 15C.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqNow_MulVerPdt_SglCat() throws Exception{		
				
		// Select single Category Product
		ProductListing_Page.lnk_selectSingleCategory().click();    		
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Select multiple Verified Products
		ProductListing_Page.chkbx_selectMultipleVerPdt();    		
		
		// 04-Jan-2016 MR45284 Inquire Now button at Inquiry Bar is removed
		// Click 'Inquire Now' button at Inquiry Bar
		ProductListing_Page.btn_clickInqNowForVerPdtAtInqBar();
		
	}
	
	/**
	 * Product Inquiry - 'inquire now' for single verified products from single category.
	 * Make sure the inquired category is one of the subscribed categories for the user.
	 * Applied to test case 13B, 13C, 14D, 15D.
	 * 
	 * @throws Exception
	 */
    public static void ExecuteInqNow_SglVerPdt_SglCat_SubsCat() throws Exception{    	
    	
		// Select single Category Product
		ProductListing_Page.lnk_selectSingleCategory().click();    		
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Select single Verified Product
		ProductListing_Page.chkbx_selectSingleVerPdt().click();   	
		
		// Click 'Inquire Now' button
		ProductListing_Page.btn_clickInqNowForVerPdtAtPdtListing();
    	
    }
    
    /**
     * Product Inquiry - 'inquire now' for multiple verified products from single category.
     * Make sure the inquired category is one of the subscribed categories for the user.
     * Applied to test case 13D, 14E, 15E.
     * 
     * @throws Exception
     */
    public static void ExecuteInqNow_MulVerPdt_SglCat_SubsCat() throws Exception{
    	
		// Select single Category Product
		ProductListing_Page.lnk_selectSingleCategory().click();    		
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Select multiple Verified Products
		ProductListing_Page.chkbx_selectMultipleVerPdt();    		
		
		// Click 'Inquire Now' button at Inquiry Bar
		ProductListing_Page.btn_clickInqNowForVerPdtAtInqBar();
		
    }
    
    /**
     * Product Inquiry - 'inquire now' for multiple verified products from multiple categories.
     * Make sure at least one of the inquired category is one of the subscribed categories in Pre-req.
     * Applied to test case 15F, 15G.
     * 
     * @param dataSearchKeyword
     * @throws Exception
     */
    public static void ExecuteInqNow_MulVerPdt_MulCat(String dataSearchKeyword) throws Exception{
    	
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
    	
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
    	// Select multiple verified products 
		ProductListing_Page.chkbx_selectAllVerPdt();
		
		// Click Inquire Now button
		ProductListing_Page.btn_clickInqNowForVerPdtAtInqBar();
		
    }
    
    /**
     * As a logged in user, Inquire Now for multiple categories products and go to RFI form.
     * 
     * @param dataUsername
     * @param dataPassword
     * @param dataSearchKeyword
     * @throws Exception
     */
    public static void ExecuteLoggedIn_InqMulCatPdt(String dataUsername, String dataPassword,
    		String dataSearchKeyword) throws Exception{
    	
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);		
		
		// Product Inquiry - 'inquire now' for multiple verified products from multiple categories
		ProductInquiry_Action.ExecuteInqNow_MulVerPdt_MulCat(dataSearchKeyword);
		
    }
    
    /**
     * As a logged in user, clean up subscribed PA category, Inquire for multiple categories products and go to RFI form.
     * 
     * @param dataUsername
     * @param dataPassword
     * @param dataSearchKeyword
     * @throws Exception
     */
    public static void ExecuteLoggedIn_CleanUpPA_InqMulCatPdt(String dataUsername, String dataPassword,
    		String dataSearchKeyword) throws Exception{
    	
		// As a logged in user, clean up all the PA Categories. 
		PA_EditCategories_Action.ExecuteLoggedIn_CleanUpPACategories(dataUsername, dataPassword);
		
		// Product Inquiry - 'inquire now' for multiple verified products from multiple categories
		ProductInquiry_Action.ExecuteInqNow_MulVerPdt_MulCat(dataSearchKeyword);
		
    }
    
	/**
	 * Product Inquiry - 'inquire all' for multiple verified products from single category.
	 * Applied to test case 13H, 13I, 14H, 14I, 15H, 15I.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqAll_MulVerPdt_SglCat() throws Exception{		
						
		// Select single Category Product
		ProductListing_Page.lnk_selectSingleCategory().click();    		
				
		// Select multiple Verified Products
	//	ProductListing_Page.chkbx_selectMultipleVerifiedProducts();

		// Click on 'Inquire All' button at Inquiry Bar
	//	ProductListing_Page.btn_clickInqAllForVerPdtAtInqBar().click();
		
		// Click on "Get Quotations" button at Inquiry Bar
		ProductListing_Page.btn_clickGetQuotationsAtInqBar().click();
				
	}
	
	/**
	 * Product Inquiry - 'inquire now' for single unverified product.
	 * Applied to test case 13J, 13K, 14J, 14K, 15J, 15K.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqNow_SglUnvPdt(String dataUnvPdtName) throws Exception{		
				
		// Go to Supplier List tab view
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Select 60 Items per page
		ProductListing_Page.drpdwn_select60ItemsPerPage();	
		
		// Select single Unverified Product
	//	ProductListing_Page.chkbx_selectSingleUnverifiedProduct().click();    		
		
		// Click 'Inquire Now' button
	//	ProductListing_Page.btn_clickInqNowForUnvPdtAtPdtListing().click(); 
		
		// Click on Product hyperlink
		ProductListing_Page.lnk_clickUnvPdtName(dataUnvPdtName);
		
		// Close the Trade Match popup adv.
		SupplierHome_Page.icon_clickCloseBtnOnTradeMatchAdv();
		
		// Click on "Inquire on This Product" button.
		SupplierProductList_Page.btn_clickInquireOnThisProduct().click();
		
	}	
	
	/**
	 * Product Inquiry - 'inquire now' for multiple unverified products. 
	 * Applied to test case 13L, 14L, 15L.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqNow_MulUnvPdt() throws Exception{
				
		// Select 60 Items per page
	//	ProductListing_Page.drpdwn_select60ItemsPerPage();				
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Due to Bug#85, move the mouse to temp fixed the issue
		ProductListing_Page.btn_mouseoverToSearchBtn();
		
		// Select multiple Unverified Products
	//	ProductListing_Page.chkbx_selectMultipleUnvPdt();		
		ProductListing_Page.chkbx_selectFirstUnvPdt();		
		ProductListing_Page.chkbx_selectLastUnvPdt();
		
		// Click Inquire Now button 
		ProductListing_Page.btn_clickInqNowForUnvPdtAtInqBar().click();
		
	}
		
	/**
	 * Product Inquiry - 'inquire all' for multiple unverified products. 
	 * Applied to test case 13M, 14M, 15M.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteInqAll_MulUnvPdt() throws Exception{
				
		// Select multiple Unverified Products
	//	ProductListing_Page.chkbx_selectMultipleUnverifiedProducts();    		
		
		// Click 'Inquire All' button at Inquiry Bar
		ProductListing_Page.btn_clickInqAllForUnvPdtAtInqBar().click(); 
		
	}
		
    // ============================================================ Start of RFS Flow section =======================================================

	/**
	 * RFS Flow - 'request for sample' for single verified products.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteRFSFlow_RequestForSample() throws Exception{		
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// To click on the Rollover Larger image.
		ProductListing_Page.img_clickOnRolloverLargerImage();
		
		// Due to page optimization, waits for 5 seconds
		Thread.sleep(5000);
		System.out.println("Waits for 5 seconds");
		
		// Click 'Request Sample' button
		ProductProfile_Page.btn_clickRequestSample();
		
	}

	// RFS Flow - "request for sample" for single verified products.
	public static void ExecuteRFSFlow_RequestForSampleAgain() throws Exception{
		
		// To click on Rollover Larger image
		ProductListing_Page.img_clickOnRolloverLargerImage();
		
		// Click on "Request Sample" button
		ProductProfile_Page.btn_clickRequestSample();
		
	}
	
	/**
	 * 'request for sample' for single verified products and go to RFS form.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteReqForSample_SglVerPdt(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// Due to page optimization, waits for 10 seconds
		Thread.sleep(10000);
		System.out.println("Waits for 10 seconds.");
		
		// 'request for sample' for single verified products
		ProductInquiry_Action.ExecuteRFSFlow_RequestForSample();
		
	}
	
	// "request for sample" for single verified products and go to RFS form.
	public static void ExecuteReqForSample_SglVerPdtAgain(String dataSearchKeyword) throws Exception{
		
		// Perform a product keyword search
		ProductInquiry_Action.ExecuteSearchByProductsAgain(dataSearchKeyword);
		
		// "Request for Sample" for single verified products
		ProductInquiry_Action.ExecuteRFSFlow_RequestForSampleAgain();
				
	}
	
	/**
	 * As a logged in user, 'request for sample' for single verified products and go to RFS form.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_ReqForSample_SglVerPdt(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// As a logged in user, enter search keyword by select Products Page Types.
		ProductInquiry_Action.ExecuteLoggedIn_EnterSearchKeyword(dataUsername, dataPassword, dataSearchKeyword);		
		
		// 'request for sample' for single verified products
		ProductInquiry_Action.ExecuteRFSFlow_RequestForSample();
		
	}	
	
	/**
	 * As a logged-in user, go to GSOL PP page and click on "Request Latest Price" button.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteLoggedInUser_ClickReqLatestPriceBtn(String dataUsername, 
			String dataPassword, String dataSearchKeyword) throws Exception{
		
		// As a logged in user, enter search keyword by select Products Page Types.
		ProductInquiry_Action.ExecuteLoggedIn_EnterSearchKeyword(dataUsername, dataPassword, dataSearchKeyword);
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// To click on the Rollover Larger image.
		ProductListing_Page.img_clickOnRolloverLargerImage();
		
		// Due to page optimization, waits for 10 seconds
		Thread.sleep(10000);
		System.out.println("Waits for 10 seconds");
		
		// Click on the 'Request Latest Price' button.
		ProductProfile_Page.btn_clickRequestLatestPrice();
		
	}
	
	/**
	 * As a non logged-in user, go to GSOL PP page and click on "Request Latest Price" button.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteNonLoggedInUser_ClickReqLatestPriceBtn(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// To click on the Rollover Larger image.
		ProductListing_Page.img_clickOnRolloverLargerImage();
		
		// Due to page optimization, waits for 10 seconds
		Thread.sleep(10000);
		System.out.println("Waits for 10 seconds");
		
		// Click on the 'Request Latest Price' button.
		ProductProfile_Page.btn_clickRequestLatestPrice();
		
	}
	
    // ============================================================ Start of RFI Form section =======================================================
	
	/**
	 * Enter search keyword by select Products Page Types and click on Supplier Name.
	 * Applied to 11B, 27C
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecutePdtSearch_ClickSuppName(String dataSearchKeyword) throws Exception{
		
		// Enter text for search keyword field and click on Search button
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Due to page optimization, waits for 5 seconds
		Thread.sleep(5000);
		System.out.println("Waits for 5 seconds");
		
		// To click on first Supplier Name Title
		ProductListing_Page.lnk_clickSupplierNameTitle().click();
		
	}
	
	/**
	 * As a logged-in user, go to Supplier Homepage entry point.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_GoToSuppHomepage(String dataUsername, String dataPassword,
			String dataSearchKeyword) throws Exception{
		
		// As a logged in user, enter search keyword by select Products Page Types.
		ProductInquiry_Action.ExecuteLoggedIn_EnterSearchKeyword(dataUsername, dataPassword, dataSearchKeyword);
		
		// Due to page optimization, waits for 5 seconds
		Thread.sleep(5000);
		System.out.println("Waits for 5 seconds");
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// To click on first Supplier Name Title
		ProductListing_Page.lnk_clickSupplierNameTitle().click();
		
	}
	
	
    // ========================================================= Start of Inquiry Basket section ====================================================
	
	/**
	 * Select multiple verified products chkbx.
	 * Applied to RFI Inquiry Basket 1142 / 17A.
	 * 
	 * @param dataPdtSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteInqBasket_SelectMulVerPdtChkbx(String dataPdtSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ExecuteSearchByProducts(dataPdtSearchKeyword);    	
		
    	// Select multiple verified products 
		ProductListing_Page.chkbx_selectMultipleVerPdt();
	//	ProductListing_Page.chkbx_selectAllVerPdt();		
				
	}
	
	/**
	 * 'Add to Basket' for multiple verified products.
	 * 
	 * @param dataPdtSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSelectMulVerPdt_ClickAddToBasketBtn(String dataPdtSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ExecuteSearchByProducts(dataPdtSearchKeyword);
		
		// Select multiple verified products
		ProductListing_Page.chkbx_selectAllVerPdt();
		
		// Click Add to Basket
		ProductListing_Page.lnk_clickAddToBasketInqBar();
	}
		
	// ==================================================== Start of Drilldown pages entry point ====================================================
	
	/**
	 * Go to L1 entry point.
	 * 
	 * @param dataCategoryKeyword
	 * @throws Exception
	 */
	public static void ExecuteL1EntryPoint(String dataCategoryKeyword) throws Exception{
		
		// 21-Dec-2016 UI Removed
		// Select Search Options by Browse Categories
	//	Home_Page.drpdwn_selectBrowseCategories();
		
		// Select Category link based on value from input data
		BrowseCategories_Page.lnk_clickCategoryKeyword(dataCategoryKeyword).click();
		
	}
	
	/**
	 * Go to L2 entry point.
	 * 
	 * @param dataCategoryKeyword
	 * @throws Exception
	 */
	public static void ExecuteL2EntryPoint(String dataCategoryKeyword) throws Exception{

		// Select Search Options by Browse Categories
	//	Home_Page.drpdwn_selectBrowseCategories();
		
		// Select Category link based on value from input data
		BrowseCategories_Page.lnk_clickCategoryKeyword(dataCategoryKeyword).click();
		
	}
	
	/**
	 * Go to L3 entry point.
	 * 
	 * @param dataCategoryKeyword
	 * @throws Exception
	 */
	public static void ExecuteL3EntryPoint(String dataCategoryKeyword) throws Exception{
		
		// 21-Dec-2016 Features removed from eGSOL.
		// Select Search Options by Browse Categories
	//	Home_Page.drpdwn_selectBrowseCategories();
		
		// Select Category link based on value from input data.
		BrowseCategories_Page.lnk_clickCategoryKeyword(dataCategoryKeyword).click();
		
		// Select L3 single category from 'Related Categories' side bar.
		ProductListing_Page.lnk_selectL3Category().click();
	}
	
	/**
	 * As a logged-in user, go to L3 entry points.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataCategoryKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_GoToL3EntryPoint(String dataUsername, String dataPassword, 
			String dataSearchKeyword, String dataCategoryKeyword) throws Exception {
		
		// Login to GSOL
	//	SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// As a logged in user, perform a product keyword search
		ProductInquiry_Action.ExecuteLoggedIn_EnterSearchKeyword(dataUsername, dataPassword, dataSearchKeyword);
		
		// Go to L3 entry point
		ExecuteL3EntryPoint(dataCategoryKeyword);
		
	}
	
	/**
	 * Go to L4 entry point.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteL4EntryPoint(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ExecuteSearchByProducts(dataSearchKeyword);
		
		// To select single Category from 'Related Categories' side bar.
		ProductListing_Page.lnk_selectSingleCategory().click();
		
	}
	
	/**
	 * As a logged-in user, go to L4 entry points.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_GoToL4EntryPoint(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Go to L4 entry point
		ExecuteL4EntryPoint(dataSearchKeyword);
		
	}
		
	// ==================================================== Start of PA Landing page entry point ====================================================
	
	/**
	 * Go to PA Landing page.
	 * 
	 * @throws Exception
	 */
	public static void ExecutePALandingPageEntryPoint() throws Exception{
		
		// Go to PA Edit Categories page.
		GlobalNav_MenuBar.menuBar_selectEditCategories();
		
		// Click on any of the subscribed categories to go to PA Landing page.
		PA_EditCategories_Page.lnk_clickSubsCategories().click();
		
	}
	
	/**
	 * As a logged in user, go to PA Landing page entry point.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_PALandingPageEntryPoint(String dataUsername,
			String dataPassword) throws Exception{
		
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Go to PA Edit Categories page.
		GlobalNav_MenuBar.menuBar_selectEditCategories();
		
		// Click on any of the subscribed categories to go to PA Landing page.
		PA_EditCategories_Page.lnk_clickSubsCategories().click();
		
	}
	
    // Click on PPs "Compare" button and click on "Compare" button.
	public static void ExecuteCompareProducts() throws Exception{
		
		// Click on PPs "Compare" button
		PA_Landing_Page.btn_clickCompare();
		
		// Click on "Products" tab on the bottom
		PA_Landing_Page.tab_clickProducts().click();
		
		// Click on "Compare" button
		PA_Landing_Page.btn_clickComparePPs().click();
		
	}
    
	
	// ===================================================== Start of GSOL PP page entry point ======================================================
	
	/**
	 * As a non logged-in user, go to the GSOL PP page entry point
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteNonLoggedIn_GSOLPPEntryPoint(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types.
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);
		
		// Click on Supplier List tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// To click on the Rollover Larger image to go to GSOL PP page
		ProductListing_Page.img_clickOnRolloverLargerImage();
				
	}

	/**
	 * As a logged-in user, go to GSOL PP page entry point.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_GSOLPPEntryPoint(String dataUsername, String dataPassword,
			String dataSearchKeyword) throws Exception{
		
		// As a logged in user, enter search keyword by select Products Page Types.
		ProductInquiry_Action.ExecuteLoggedIn_EnterSearchKeyword(dataUsername, dataPassword, dataSearchKeyword);
		
		// 03-Jan-2017 New UI on Product Listing page
		// Click on "Supplier List" tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// To click on the Rollover Large image to go to GSOL PP page
		ProductListing_Page.img_clickOnRolloverLargerImage();		
		
	}
	
	// ================================================== Start of Unverified PP page entry point ===================================================
	
	// As a non logged-in user, go to Unverified PP page entry point.
	public static void ExecuteNonLoggedIn_UnverifiedPPEntryPoint(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types.
		ProductInquiry_Action.ExecuteSearchByProducts(dataSearchKeyword);		
		
		// Click on Supplier List tab
		ProductListing_Page.tab_clickSupplierList().click();
		
		// Due to Bug#85, move the mouse to temp fixed the issue
		ProductListing_Page.btn_mouseoverToSearchBtn();
		
		// To click on the Rollover Large image to go to Unverified PP page.
		ProductListing_Page.img_clickOnUnvPPRolloverLargerImage();
		
	}
	
	// =================================================== Start of PA Enhanced Entrance section ====================================================
	
	// From L3 entry point, Click on the PA Enhanced Entrance 'Update me on new products' link.
	public static void ExecutePAEnhancedEntranceL3_ClickUpdateMeOnNewProductsLink(String dataCategoryKeyword) throws Exception{
		
		// Go to L3 entry point
		ProductInquiry_Action.ExecuteL3EntryPoint(dataCategoryKeyword);
		
		// Click on PA Enhance Entry 'Update me on new products' link.
		ProductListing_Page.lnk_clickUpdateMeOnNewProducts();
		
	}

	// ==================================================== End of PA Enhanced Entrance section =====================================================
	
    // ============================================== Start of PA cross promotion (centrewell) section ==============================================
	
	/**
	 * From L1 entry point, click on the product keyword link in the PA cross promotion (centrewell) section.
	 * 
	 * @param dataCategoryKeyword
	 * @throws Exception
	 */
	public static void ExecutePACrossPromotionL1_ClickPdtKeywordLink(String dataCategoryKeyword) throws Exception{
		
		// Go to cross promotion (centrewell) section from L1 entry point.
	//	ExecuteL1EntryPoint(dataCategoryKeyword);
		
		// Select Category link based on value from input data
		BrowseCategories_Page.lnk_clickCategoryKeyword(dataCategoryKeyword).click();
		
		// Click on the product keyword link in the PA cross promotion (centrewell) section
		ProductListing_Page.lnk_clickPdtKeyword_PACrossPromotion().click();
		
	}
	
	/**
	 * From L2 entry point, click on the product keyword link in the PA cross promotion (centrewell) section.
	 * Applied to test case 5C.
	 * 
	 * @throws Exception
	 */
	public static void ExecutePACrossPromotionL2_ClickPdtKeywordLink(String dataCategoryKeyword) throws Exception{
		
		// Go to cross promotion (centrewell) section from L2 entry point.
	//	ExecuteL2EntryPoint(dataCategoryKeyword);
		
		// Select Category link based on value from input data
		BrowseCategories_Page.lnk_clickCategoryKeyword(dataCategoryKeyword).click();
		
		// Click on the product keyword link in the PA cross promotion (centrewell) section
		ProductListing_Page.lnk_clickPdtKeyword_PACrossPromotion().click();
		
	}
	
	/**
	 * From L3 entry point, click on the product keyword link in the PA cross promotion (centrewell) section.
	 * 
	 * @param dataCategoryKeyword
	 * @throws Exception
	 */
	public static void ExecutePACrossPromotionL3_ClickPdtKeywordLink(String dataCategoryKeyword) throws Exception{
		
		// Go to cross promotion (centrewell) section from L3 entry point.
	//	ExecuteL3EntryPoint(dataCategoryKeyword);
		
		// Select Category link based on value from input data.
		BrowseCategories_Page.lnk_clickCategoryKeyword(dataCategoryKeyword).click();
		
		// Click on the product keyword link in the PA cross promotion (centrewell) section
		ProductListing_Page.lnk_clickPdtKeyword_PACrossPromotion().click();
		
	}
		
    // ============================================= Start of eMag cross promotion (centrewell) section =============================================
	
	/**
	 * From the L2 entry points, click on the 'Subscribe' button in the eMag cross promotion (centrewell) section.
	 * 
	 * @param dataL2Keyword
	 * @throws Exception
	 */
	public static void ExecuteEmagCrossPromotionL2_ClickSubscribeBtn(String dataL2Keyword) throws Exception{
		
		// Click on "Browse Product Categories" link at the Footer.
		Home_Page.lnk_clickBrowseProductCategories().click();
		
		// Go to cross promotion (centrewell) section from L2 entry point.
		ExecuteL2EntryPoint(dataL2Keyword);
		
		// Click on the 'Subscribe' button
		ProductListing_Page.btn_clickEmagSubscribe().click();
		
	}
 
	/**
	 * From the L3 entry points, click on the 'Subscribe' button in the eMag cross promotion (centrewell) section.
	 * 		
	 * @param dataL2Keyword
	 * @throws Exception
	 */
	public static void ExecuteEmagCrossPromotionL3_ClickSubscribeBtn(String dataL2Keyword) throws Exception{
		
		// Go to cross promotion (centrewell) section from L3 entry point.
	//	ExecuteL3EntryPoint(dataL2Keyword);
		
		// Select Category link based on value from input data.
		BrowseCategories_Page.lnk_clickCategoryKeyword(dataL2Keyword).click();
		
		// Close the Help Tour overlay
	//	ProductListing_Page.btn_closeHelpTourOverlay();
		
		// Select L3 single category from 'Related Categories' side bar.
		ProductListing_Page.lnk_selectL3Category().click();
		
		// Click on the 'Subscribe' button
		ProductListing_Page.btn_clickEmagSubscribe().click();
		
	}
	
	/**
	 * From the L4 entry points, click on the "Subscribe" button in the eMag cross promotion (centrewell) section.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteEmagCrossPromotionL4_ClickSubscribeBtn(String dataSearchKeyword) throws Exception{
		
		// Go to cross promotion (centrewell) section from L4 entry point.
		ExecuteL4EntryPoint(dataSearchKeyword);
		
		// Click on the 'Subscribe' button
		ProductListing_Page.btn_clickEmagSubscribe().click();
		
	}
	
	
	// ===================================================== Start of New Products entry point ======================================================
	
	/**
	 * Go to New Products entry point.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteNewProductsEntryPoint(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types
		ExecuteSearchByProducts(dataSearchKeyword);
		
		// To click on 'New Products' link located at footer page.
		Home_Page.lnk_clickNewProducts().click();
		
	}
	
	// ===================================================== Start of Top Products entry point ======================================================
	
	/**
	 * Go to TP entry point.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteTPEntryPoint(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Product Page Types
		ExecuteSearchByProducts(dataSearchKeyword);
		
		// To click on 'Top Products' link located at footer page.
		Home_Page.lnk_clickTopProducts().click();
		
	}
	
	/**
	 * As a logged-in user, go to TP entry point
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_GoToTPEntryPoint(String dataUsername, String dataPassword, 
			String dataSearchKeyword) throws Exception{
		
		// Login to GSOL
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Go to TP entry point
		ExecuteTPEntryPoint(dataSearchKeyword);
		
	}
	
	// ================================================= Start of Top China Suppliers entry point ===================================================
	
	/**
	 * Go to TCS entry point.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteTCSEntryPoint(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Product Page Types
		ExecuteSearchByProducts(dataSearchKeyword);
		
		// To click on 'Top China Products' link located at footer page.
		Home_Page.lnk_clickTopChinaSuppliers().click();
	}	
	

	
}
