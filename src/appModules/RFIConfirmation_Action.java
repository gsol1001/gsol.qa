/**
 * This Class contains all the methods in the RFI Confirmation Action
 * Created: Wed 11 February 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/02/11
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.RFIConfirmation_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the RFI Confirmation action.
 * @author Teng Shyh Wei
 *
 */
public class RFIConfirmation_Action {	
		
	/**
	 * To verify Inquire All upsell section.
	 * <p><ul>
	 * <li>'contact all other x suppliers of {inquired L4 category}' is available on the page.
	 * <li>'Contact All Now' button is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
/*	public static void check_inqAllUpsellSectionExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Inquire All upsell section 'contact all other x suppliers of {inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_inqAllUpsellSection_ContactAllOtherSuppExists(xls, sheetName, rowNum, testFail);
		
		// To verify Inquire All upsell section 'Contact All Now' button is available on the page.
		RFIConfirmation_Page.check_inqAllUpsellSection_ContactAllNowBtnExists(xls, sheetName, rowNum, testFail);
		
	}	*/
	
	/**
	 * To verify Inquire All upsell section.
	 * <p><ul>
	 * <li>'Don't miss out on these x other verified suppliers of {inquired L4 category}' is available on the page.
	 * <li>'Contact All Suppliers Now' button is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	// 12-Jul-2016 MR#44206 Inquire All entry point is removed.
	public static void check_inqAllUpsellSection_DontMissOutOtherSuppExists11(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Inquire All upsell section 'Don't miss out of these x other verified suppliers of {inquired L4 category}.' is available on the page.
		RFIConfirmation_Page.check_inqAllUpsellSection_DontMissOutOtherSuppExists(xls, sheetName, rowNum, testFail);
		
		// To verify Inquire All upsell section 'Contact All Suppliers Now' button is available on the page.
		RFIConfirmation_Page.check_inqAllUpsellSection_ContactAllSuppNowBtnExists(xls, sheetName, rowNum, testFail);
		
	}	
	
	/**
	 * To verify Inquire All upsell section.
	 * <p><ul>
	 * <li>'You still have x items in your inquiry basket.' is available on the page.
	 * <li>'Contact All Now' button is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_inqAllUpsellSection_ItemsInInqBasketExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Inquire All upsell section 'You still have x items in your inquiry basket.' is available on the page.
		RFIConfirmation_Page.check_inqAllUpsellSection_ItemsInInqBasketExists(xls, sheetName, rowNum, testFail);
		
		// To verify Inquire All upsell section 'Contact All Now' button is available on the page.
		RFIConfirmation_Page.check_inqAllUpsellSection_ContactAllNowBtnExists(xls, sheetName, rowNum, testFail);
		
	}
	
	
	/**
	 * To verify PA upsell section. 
	 * <p><ul>
	 * <li>'update me on new {Inquired L4 category}' is available on the page.
	 * <li>'Category(s) below has been added to your Product Alert: {Inquired L4 category}' is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_PAUpsellSection_UpdateMeOnNewL4Cat_CatAddedExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String getL4Category) throws Exception{
		
		// To verify PA upsell section 'update me on new {Inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_PASection_UpdateMeOnNewL4Exists(xls, sheetName, rowNum, testFail, getL4Category);
		
		// To verify PA upsell section 'Category(s) below has been added to your Product Alert: {Inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_PASection_CategoryAddedExists(xls, sheetName, rowNum, testFail);    		
    			
	}
	
	/**
	 * To verify PA upsell section. 
	 * <p><ul>
	 * <li>'update me on new {Inquired L4 category}' is available on the page.
	 * <li>'[List the inquired L4 category (max 6, 3 in a row, checkbox pre-checked)][Subscribe Now]' is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_PAUpsellSection_UpdateMeOnNewL4Cat_SubsNowBtnExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String getL4Category) throws Exception{
		
		// To verify PA upsell section 'update me on new {Inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_PASection_UpdateMeOnNewL4Exists(xls, sheetName, rowNum, testFail, getL4Category);

		// To verify PA upsell section '[List the inquired L4 category (max 6, 3 in a row, checkbox pre-checked)]
		// [Subscribe Now]' is available on the page.
		RFIConfirmation_Page.check_PASection_SubsNowBtnExists(xls, sheetName, rowNum, testFail); 
		
	}
	
	/**
	 * To verify PA upsell section. 
	 * <p><ul>
	 * <li>'update me on new {Sibling category}' is available on the page.
	 * <li>'Category(s) below has been added to your Product Alert: {Inquired L4 category}' is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_PAUpsellSection_UpdateMeOnNewSiblingCat_CatAddedExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String getSibCategory) throws Exception{

		// To verify PA upsell section 'update me on new {Sibling category}' is available on the page.
		RFIConfirmation_Page.check_PASection_UpdateMeOnNewSiblingCatExists(xls, sheetName, rowNum, testFail, getSibCategory);

		// To verify PA upsell section 'Category(s) below has been added to your Product Alert: {Inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_PASection_CategoryAddedExists(xls, sheetName, rowNum, testFail);    
		
	}
	
	/**
	 * To verify PA upsell section.
	 * <p><ul>
	 * <li>'update me on new products' is available on the page.
	 * <li>'Category(s) below has been added to your Product Alert: {Inquired L4 category}' is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_PAUpsellSection_UpdateMeOnNewPdtSupp_CatAddedExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify PA upsell section 'update me on new products' is available on the page.
		RFIConfirmation_Page.check_PASection_UpdateMeOnNewPdtExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell section 'Category(s) below has been added to your Product Alert: {Inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_PASection_CategoryAddedExists(xls, sheetName, rowNum, testFail);  
		
	}
	
	/**
	 * To verify PA upsell section.
	 * <p><ul>
	 * <li>'update me on new products and suppliers' is available on the page.
	 * <li>'[List the inquired L4 category (max 6, 3 in a row, checkbox pre-checked)][Subscribe Now]' is available on the page.
	 * </ul></p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_PAUpdateSection_UpdateMeOnNewPdtSupp_SubsNowBtnExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify PA upsell section 'update me on new products' is available on the page.
		RFIConfirmation_Page.check_PASection_UpdateMeOnNewPdtExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell section '[List the inquired L4 category (max 6, 3 in a row, checkbox pre-checked)][Subscribe Now]' is available on the page.
		RFIConfirmation_Page.check_PASection_SubsNowBtnExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify RFI upsell section.
	 * <p><ul> 
	 * <li>'Find other products similar to {inquired L4 category}' is available on the page.
	 * <li>'8 sibling categories of the inquired L4 category' is available on the page.
	 * <li>'Inquire All' button displayed below each category is available on the page.
	 * </ul><p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param getL4Category
	 * @throws Exception
	 */
	public static void check_RFIUpsellSection_PdtSimilar_InqAllExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String getL4Category) throws Exception{
		
		// To verify RFI upsell section 'Find other products similar to {inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductsSimilarExists(xls, sheetName, rowNum, testFail, getL4Category);

		// To verify RFI upsell section '8 sibling categories of the inquired L4 category' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_SiblingCategoriesExists(xls, sheetName, rowNum, testFail);

		// To verify RFI upsell section 'Inquire All' button displayed below each category.
		RFIConfirmation_Page.check_RFIUpsellSection_InqAllBtnExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify RFI upsell section.
	 * <p><ul>
	 * <li>'Find other products similar to {inquired L4 category}' is available on the page.
	 * <li>'8 sibling categories of the inquired L4 category' is available on the page.
	 * <li>'Inquire Now' button displayed below each category.
	 * </ul><p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIUpsellSection_PdtSimilar_InqNowExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String getL4Category) throws Exception{
		
		// To verify RFI upsell section 'Find other products similar to {inquired L4 category}' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductsSimilarExists(xls, sheetName, rowNum, testFail, getL4Category);

		// To verify RFI upsell section '8 sibling categories of the inquired L4 category' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_SiblingCategoriesExists(xls, sheetName, rowNum, testFail);

		// To verify RFI upsell section 'Inquire Now' button displayed below each category.
		RFIConfirmation_Page.check_RFIUpsellSection_InqNowBtnExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify RFI upsell section. 
	 * <p><ul>
	 * <li>'Find other products you might be interested in' is available on the page.
	 * <li>'8 PPs of the inquired L4 category are displayed in each tab' is available on the page.
	 * <li>'Inquire Now' button displayed below each category
	 * </ul><p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIUpsellSection_PdtInterested_InqNowExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify RFI upsell section 'Find other products you might be interested in' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductsInterestedExists(xls, sheetName, rowNum, testFail);

		// To verify RFI upsell section '8 PPs of the inquired L4 category are displayed in each tab' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductProfileInTabExists(xls, sheetName, rowNum, testFail);
		  
		// To verify RFI upsell section 'Inquire Now' button displayed below each category
		RFIConfirmation_Page.check_RFIUpsellSection_InqNowBtnExists(xls, sheetName, rowNum, testFail);
	}
	
	/**
	 * To verify RFI upsell section.
	 * <p><ul>
	 * <li>'Find other products you might be interested in' is available on the page.
	 * <li>'8 PPs of the inquired L4 category are displayed in each tab' is available on the page.
	 * <li>'Inquire All' button displayed below each category
	 * </ul><p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIUpsellSection_PdtInterested_InqAllExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify RFI upsell section 'Find other products you might be interested in' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductsInterestedExists(xls, sheetName, rowNum, testFail);
		
		// To verify RFI upsell section 'list up to 8 categories based on the categories listed on supp RFI form' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_UpTo8CategoriesExists(xls, sheetName, rowNum, testFail);

		// To verify RFI upsell section 'Inquire All' button displayed below each category.
		RFIConfirmation_Page.check_RFIUpsellSection_InqAllBtnExists(xls, sheetName, rowNum, testFail);
	}
	
	/**
	 * To verify RFI upsell section.
	 * <p><ul>
	 * <li>'Recommended Products For You' is available on the page.
	 * <li>'8 PPs of the inquired L4 category are displayed in each tab' is available on the page.
	 * <li>'Inquire Now' button displayed below each category
	 * </ul><p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIUpsellSection_RecommendedPdt_InqNowExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify RFI upsell section 'Recommended Products For You' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_RecommendedProductsExists(xls, sheetName, rowNum, testFail);
		
		// To verify RFI upsell section '8 PPs of the inquired L4 category are displayed in each tab' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductProfileInTabExists(xls, sheetName, rowNum, testFail);
		  
		// To verify RFI upsell section 'Inquire Now' button displayed below each category
		RFIConfirmation_Page.check_RFIUpsellSection_InqNowBtnExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify RFI upsell section.
	 * <p><ul>
	 * <li>'Recommended Products For You' is available on the page.
	 * <li>'8 PPs of the inquired L4 category are displayed in each tab' is available on the page.
	 * <li>'Inquire All' button displayed below each category
	 * </ul><p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIUpsellSection_RecommendedPdt_InqAllExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify RFI upsell section 'Recommended Products For You' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_RecommendedProductsExists(xls, sheetName, rowNum, testFail);
		
		// To verify RFI upsell section 'list up to 8 categories based on the categories listed on supp RFI form' is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_UpTo8CategoriesExists(xls, sheetName, rowNum, testFail);

		// To verify RFI upsell section 'Inquire All' button displayed below each category.
		RFIConfirmation_Page.check_RFIUpsellSection_InqAllBtnExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify RFI upsell section.
	 * <p><ul>
	 * <li>'Find other suppliers you might be interested in' is displayed.
	 * <li>'Inquire Now' button is displayed beside the supplier name.
	 * </ul><p>
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIUpsellSection_SuppInterested_InqNowExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
	
		// To verify RFI upsell section headline 'Find other suppliers you might be interested in" is displayed. 
		RFIConfirmation_Page.check_RFIUpsellSection_SuppInterestedExists(xls, sheetName, rowNum, testFail);		
		
		// To verify 'Inquire Now' button is displayed beside the supplier name.
		RFIConfirmation_Page.btn_clickInqNowBesideSuppName().click();
		
	}
	
	/**
	 * To verify RFI Confirmation page only have RFI Confirmation Copy section, DOI Reminder section, and Mini Marketing Box section.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_onlyRFIConfirmationCopy_DOIReminder_MiniMarketingBoxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify RFI Confirmation Copy section is available on the page.
		RFIConfirmation_Page.check_RFIConfirmationCopySectionExists(xls, sheetName, rowNum, testFail);
				                
		// To verify DOI Reminder section is available on the page.
		RFIConfirmation_Page.check_DOIReminderSectionExists(xls, sheetName, rowNum, testFail);
		
		// To verify Mini Marketing Box section is available on the page.
		RFIConfirmation_Page.check_miniMarketingBoxSectionExists(xls, sheetName, rowNum, testFail); 
		
	}
	
	/**
	 * To verify RFI Confirmation page only have RFI Confirmation Copy section, RFI upsell section and Mini Marketing Box section.
	 * Applied to AGG Supplier
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param getSuppName
	 * @throws Exception
	 */
	public static void check_onlyRFIConfirmationCopy_RFIUpsell_MiniMarketingBoxSectionExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String getSuppName) throws Exception{
		
		// To verify RFI Confirmation Copy section is available on the page.
		RFIConfirmation_Page.check_RFIConfirmationCopyMessageExists(xls, sheetName, rowNum, testFail, getSuppName);
		                	
		// To verify RFI Upsell section - Headline "Find other products you might be interested in" is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductsInterestedExists(xls, sheetName, rowNum, testFail);
		
		// To verify Mini Marketing Box section is available on the page.
    	RFIConfirmation_Page.check_miniMarketingBoxSectionExists(xls, sheetName, rowNum, testFail);
    	
	}
	
	/**
	 * To verify RFI Confirmation page only have RFI Confirmation Copy section, RFI upsell section and Mini Marketing Box section.
	 * Applied to AGG Supplier PP page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param getSuppName
	 * @throws Exception
	 */
	public static void check_onlyRFIConfirmationCopy_RFIUpsell_MiniMarketingBoxSectionIsExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String getSuppName) throws Exception{
		
		// To verify RFI Confirmation Copy section is available on the page.
		RFIConfirmation_Page.check_RFIConfirmationCopyMessageExists(xls, sheetName, rowNum, testFail, getSuppName);
		                	
		// To verify RFI Upsell section - Headline "Find other {Products}" is available on the page.
		RFIConfirmation_Page.check_RFIUpsellSection_FindOtherProductsExists(xls, sheetName, rowNum, testFail);
		
		// To verify Mini Marketing Box section is available on the page.
    	RFIConfirmation_Page.check_miniMarketingBoxSectionExists(xls, sheetName, rowNum, testFail);
    	
	}
	
	/**
	 * To verify RFI Confirmation page only have RFI Confirmation Copy section and Mini Marketing Box section.
	 * Applied to FL Supplier
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param getSuppName
	 * @throws Exception
	 */
	public static void check_onlyRFIConfirmationCopy_MiniMarketingBoxSectionExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String getSuppName) throws Exception{		
			
		// To verify RFI Confirmation Copy section is available on the page.
	//	RFIConfirmation_Page.check_RFIConfirmationCopySectionExists(xls, sheetName, rowNum, testFail);
		RFIConfirmation_Page.check_RFIConfirmationCopyMessageExists(xls, sheetName, rowNum, testFail, getSuppName);
		                	
		// To verify Mini Marketing Box section is available on the page.
    	RFIConfirmation_Page.check_miniMarketingBoxSectionExists(xls, sheetName, rowNum, testFail);    	    
    	
	}
	
	/**
	 * 4. RFI Confirmation page is displayed. Verify that
	 * a. Verify RFI Confirmation Copy section is displayed.
	 * - Your message has been sent to {company name}. Look out for the supplier's reply to your inquiry in your email inbox or at Global Sources.
	 * b. RFI Upsell section:
	 * - Headline "Find other products you might be interested in" is displayed.
	 * - Headline "Find other suppliers you might be interested in" is displayed.
	 * c. Mini-Marketing box section are available.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param getSuppName
	 * @throws Exception
	 */
	public static void check_RFIConfirmationForSupplierInquiryExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String getSuppName) throws Exception{
		
		// To verify RFI confirmation copy is displayed.
		RFIConfirmation_Page.check_RFIConfirmationCopyMessageExists(xls, sheetName, rowNum, testFail, getSuppName);
		
		// To verify RFI Upsell section is displayed.
		// To verify - Headline "Find other products you might be interested in" is displayed.
		// To verify - Headline "Find other suppliers you might be interested in" is displayed.
		RFIConfirmation_Page.check_RFIUpsellSection_ProductsInterestedExists(xls, sheetName, rowNum, testFail);
	//	RFIConfirmation_Page.check_RFIUpsellSection_SuppInterestedExists(xls, sheetName, rowNum, testFail);
		
    	// To verify Mini Marketing Box section is available on the page.
    	RFIConfirmation_Page.check_miniMarketingBoxSectionExists(xls, sheetName, rowNum, testFail);
    	
	}

}
