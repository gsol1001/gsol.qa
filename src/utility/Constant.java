/**
 * Functions related to constant will be created In this class.
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/02/12
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package utility;

/**
 * This class contains all constant variables
 * @author Teng Shyh Wei
 *
 */
public class Constant {
	
	// Result's constant variables
	public static final String KEYWORD_PASS = "Passed";
    public static final String KEYWORD_FAIL = "Failed";
    public static final String KEYWORD_SKIP = "Skipped";
    public static final String KEYWORD_EXECUTED = "Executed";
    
	// Test Data Sheet Columns
    public static final String COL_PASS_FAIL_SKIP = "Pass/Fail/Skip";
    public static final String COL_SKIPPED_EXECUTED = "Skipped/Executed";
	public static final String COL_OVERALL_TEST_CASE_RESULT = "overall result (passed/failed/skipped)";
    public static final String COL_USER_CONTACT_DETAILS_PREPOPULATED = "user's contact details (pre-populated)";
    public static final String COL_USER_CONTACT_DETAILS_NOT_PREPOPULATED = "user's contact details (not pre-populated)";
    public static final String COL_POPUP_WINDOW_IS_CLOSED = "popup window is closed (true)";
    public static final String COL_PP_CHKBX_IS_CHECKED = "PP chkbx is selected (available)";
    
    /**
     * Inquiry Form part
     */
    public static final String COL_RFI_FORM_IS_DISPLAYED = "RFI form (displayed)";
    public static final String COL_RFS_FORM_IS_DISPLAYED = "RFS form (displayed)";
    
    public static final String COL_INQ_ALL_UPSELL_DRPDWN_EXISTS = "inq all upsell drpdwn list (available)";
    public static final String COL_INQ_ALL_UPSELL_DRPDWN_NOT_EXISTS = "inq all upsell drpdwn list (not available)";
    public static final String COL_INQ_ALL_UPSELL_DRPDWN_SELECTED = "inq all upsell drpdwn list (selected)";
    public static final String COL_INQ_ALL_UPSELL_DRPDWN_NOT_SELECTED = "inq all upsell drpdwn list (not selected)";
	public static final String COL_INQ_ALL_UPSELL_DRPDWN_REMAIN_SELECTED = "inq all upsell drpdwn list (remain selected)";
			
    public static final String COL_INQ_ALL_VER_UPSELL_CHKBX_EXISTS = "ver pdt inq all upsell chkbx (available)";
	public static final String COL_INQ_ALL_VER_UPSELL_CHKBX_NOT_EXISTS = "ver pdt inq all upsell chkbx (not available)";		
	public static final String COL_INQ_ALL_VER_UPSELL_CHKBX_CHECKED = "ver pdt inq all upsell chkbx (selected)";
	public static final String COL_INQ_ALL_VER_UPSELL_CHKBX_NOT_CHECKED = "ver pdt inq all upsell chkbx (not selected)";
	public static final String COL_INQ_ALL_VER_UPSELL_CHKBX_REMAIN_CHECKED = "ver pdt inq all upsell chkbx (remain selected)";
	public static final String COL_INQ_ALL_VER_UPSELL_CHKBX_REMAIN_UNCHECKED = "ver pdt inq all upsell chkbx (remain unchecked)";
	
	public static final String COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_EXISTS = "only ver pdt inq all upsell chkbx (available)";
	public static final String COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_CHECKED = "only ver pdt inq all upsell chkbx (selected)";
	public static final String COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_NOT_CHECKED = "only ver pdt inq all upsell chkbx (not selected)";
	public static final String COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_REMAIN_CHECKED = "only ver pdt inq all upsell chkbx (remain selected)";
	public static final String COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_REMAIN_UNCHECKED = "only ver pdt inq all upsell chkbx (remain unchecked)";
	
	public static final String COL_INQ_ALL_UNV_UPSELL_CHKBX_EXISTS = "unv pdt inq all upsell chkbx (available)";
	public static final String COL_INQ_ALL_UNV_UPSELL_CHKBX_NOT_EXISTS = "unv pdt inq all upsell chkbx (not available)";		
	public static final String COL_INQ_ALL_UNV_UPSELL_CHKBX_CHECKED = "unv pdt inq all upsell chkbx (selected)";
	public static final String COL_INQ_ALL_UNV_UPSELL_CHKBX_NOT_CHECKED = "unv pdt inq all upsell chkbx (not selected)";
	public static final String COL_INQ_ALL_UNV_UPSELL_CHKBX_REMAIN_CHECKED = "unv pdt inq all upsell chkbx (remain selected)";
	
	public static final String COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_EXISTS = "only unv pdt inq all upsell chkbx (available)";
	public static final String COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_SELECTED = "only unv pdt inq all upsell chkbx (selected)";	
	public static final String COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_REMAIN_SELECTED = "only unv pdt inq all upsell chkbx (remain selected)";
	
	public static final String COL_CC_EMAIL_ADDR_CHKBX_EXISTS = "cc my e-mail addr chkbx (available)";
	public static final String COL_CC_EMAIL_ADDR_CHKBX_NOT_EXISTS = "cc my e-mail addr chkbx (not available)";	
	public static final String COL_CC_EMAIL_ADDR_CHKBX_CHECKED = "cc my e-mail addr chkbx (selected)";
	public static final String COL_CC_EMAIL_ADDR_CHKBX_UNCHECKED = "cc my e-mail addr chkbx (not selected)";
	public static final String COL_CC_EMAIL_ADDR_CHKBX_REMOVED = "cc my e-mail addr chkbx (removed)";
	
	public static final String COL_BUYER_PROFILE_SECTION_EXISTS = "options in the buyer profile section (available)";
	public static final String COL_OPTION_CHKBX_YES_BUYER_PROFILE_CHECKED_AS_DEFAULT = "option 'yes, pls include my buyer profile for this inquiry' (selected as default)";
	public static final String COL_OPTION_CHKBX_NO_BUYER_PROFILE_IS_SELECTED = "option 'no, pls do not send this time' (selected)";
	public static final String COL_OPTION_CHKBX_NO_BUYER_PROFILE_CHECKED_AS_DEFAULT = "option 'no, pls do not send this time' (selected as default)";
	public static final String COL_BUYER_PROFILE_SECTION_NOT_EXISTS = "buyer profile section (not available)";
	public static final String COL_BUYER_PROFILE_ALWAYS_DISCLOSE_EXISTS = "buyer profile always disclose section (available)";
	public static final String COL_RMB_MY_PREF_CHKBX_CHECKED_AS_DEFAULT = "rmb my preference chkbx (selected as default)";
	public static final String COL_RMB_MY_PREF_CHKBX_CHECKED = "rmb my preference chkbx (selected)";
	public static final String COL_RMB_MY_PREF_CHKBX_NOT_CHECKED = "rmb my preference chkbx (not selected)";
	public static final String COL_RMB_MY_PREF_CHKBX_IS_UNCHECKED = "rmb my preference chkbx (unchecked)";
	
	public static final String COL_RFQ_UPSELL_CHKBX_EXISTS = "RFQ upsell chkbx (available)";
	public static final String COL_RFQ_UPSELL_CHKBX_NOT_EXISTS = "RFQ upsell chkbx (not available)";
	public static final String COL_RFQ_UPSELL_CHKBX_CHECKED = "RFQ upsell chkbx (selected)";
	public static final String COL_RFQ_UPSELL_CHKBX_NOT_CHECKED = "RFQ upsell chkbx (not selected)";
	public static final String COL_RFQ_UPSELL_CHKBX_CHECKED_AS_DEFAULT = "RFQ upsell chkbx (selected as default)";
	public static final String COL_RFQ_UPSELL_COPY_IS_EXISTS = "RFQ upsell copy is seen (available)";
	
	public static final String COL_PA_UPSELL_COPY_EXISTS = "PA upsell copy (available)";
	public static final String COL_PA_UPSELL_COPY_IS_SEEN = "PA upsell copy (seen)";
	public static final String COL_PA_UPSELL_CHKBX_EXISTS = "PA upsell chkbx (available)";
	public static final String COL_PA_UPSELL_CHKBX_NOT_EXISTS = "PA upsell chkbx (not available)";				
	public static final String COL_PA_UPSELL_CHKBX_CHECKED = "PA upsell chkbx (selected)";
	public static final String COL_PA_UPSELL_CHKBX_NOT_CHECKED = "PA upsell chkbx (not selected)";
	public static final String COL_PA_UPSELL_CHKBX_CHECKED_AS_DEFAULT = "PA upsell chkbx (selected as default)";
	public static final String COL_CAT_PA_UPSELL_REMAIN_UNCHANGED = "cat in PA upsell chkbx (remain unchanged)";
	public static final String COL_CAT_PA_UPSELL_CHANGED_TO_SIBLING_CAT = "cat in PA upsell chkbx changed to sibling cat";
	
	public static final String COL_SUBJECT_MSG_FIELDS_ENTERED_WITH_TEXT = "'subject' and 'msg' fields are entered with text (available)";
	public static final String COL_TEXT_SUBJECT_MSG_REMAIN_UNCHANGED = "text entered in 'subject' and 'msg' (remain unchanged)";
	public static final String COL_TEXT_SUBJECT_MSG_TARGET_COUNTRY_REMAIN_UNCHANGED = "text entered in 'subject', 'msg' and 'country in which pdt(s) will be sold' (remain unchanged)";
	public static final String COL_TEXT_SUBJECT_MSG_NUMOFSAMPLES_REMAIN_UNCHANGED = "text entered in 'subject', 'msg' and 'num of samples' (remain unchanged)";
	public static final String COL_EMAIL_ENTERED_SAME_AS_PRE_REQ = "business email entered same as pre-req (available)";
	
	public static final String COL_GET_LATEST_PRICE_OVERLAY_EXISTS = "get latest price overlay (displayed)";
	public static final String COL_NAME_EMAIL_PREPOPULATED = "first name, last name and business email pre-populated (available)";
	
	
	/**
	 * RFI Confirmation Section
	 */
	public static final String COL_RFI_CONFIRMATION_PAGE_DISPLAYED = "RFI confirmation page (displayed)";
	public static final String COL_RFI_CONFIRMATION_PG_DISPLAYED = "RFI confirmation pg (displayed)";
	public static final String COL_RFI_CONFIRMATION_COPY_SEC_EXISTS = "RFI confirmation copy section (available)";
	
	public static final String COL_INQ_ALL_UPSELL_SEC_NOT_EXISTS = "inq all upsell section (not available)";
	public static final String COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_OTHER_EXISTS = "inq all upsell - contact all other x supp of {inq L4 cat} (available)";
	public static final String COL_INQ_ALL_UPSELL_SEC_DONT_MISS_OUT_OTHER_SUPP_EXISTS = "inq all upsell - dont miss out on these x other ver supp of {inq L4 cat} (available)";
	public static final String COL_INQ_ALL_UPSELL_SEC_ITEMS_IN_INQ_BASKET_EXISTS = "inq all upsell - you still hv x items in your inq basket (available)";
	public static final String COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_NOW_BTN_EXISTS = "inq all upsell - contact all now btn (available)";
	public static final String COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_SUPP_NOW_BTN_EXISTS = "inq all upsell - contact all supp now btn (available)";
	
	public static final String COL_SA_UPSELL_SEC_EXISTS = "SA upsell section (available)";
	public static final String COL_SA_UPSELL_SEC_NOT_EXISTS = "SA upsell section (not available)";
	public static final String COL_SA_CHKBX_IS_PRECHECKED = "SA chkbx is pre-checked (available)";
	
	public static final String COL_PA_UPSELL_SECTION_EXISTS = "PA upsell section (available)";
	public static final String COL_PA_UPSELL_SEC_NOT_EXISTS = "PA upsell section (not available)";
	public static final String COL_PA_UPSELL_SEC_UPDATE_ME_EXISTS = "PA upsell - update me on new {inq L4 cat} (available)";
	public static final String COL_PA_UPSELL_SEC_UPDATE_ME_NEW_SIBLING_CAT_EXISTS = "PA upsell - update me on new {sibling cat} (available)";
	public static final String COL_PA_UPSELL_SEC_UPDATE_ME_NEW_PDT_EXISTS = "PA upsell - update me on new pdt (available)";
	public static final String COL_PA_UPSELL_SEC_CAT_FOR_YOUR_PA_EXISTS = "PA upsell - category(s) for your PA: {inq L4 cat} (available)";
	public static final String COL_PA_UPSELL_SEC_CAT_ADDED_EXISTS = "PA upsell - category(s) below has been added to your PA: {inq L4 cat} (available)";				
	public static final String COL_PA_UPSELL_SEC_SUBS_NOW_EXISTS = "PA upsell - [list the inq L4 cat (max 6, 2 in a row, chkbx pre-checked)] [subs now] (available)";
	public static final String COL_PA_UPSELL_SEC_COPY_DOI_EXISTS = "PA upsell - DOI reminder with resend e-mail link (available)";
	public static final String COL_PA_UPSELL_SEC_CHECK_EMAIL_EXISTS = "PA upsell - hi first name, pls check your e-mail, sent to xyz@xyz.com (available)";
	public static final String COL_PA_UPSELL_SEC_FREE_PA_EMAIL_UPDATES_EXISTS = "PA upsell - hi first name, as a reg user, you are eligible for free PA e-mail updates (available)";
	public static final String COL_PA_UPSELL_SEC_NEW_PA_BOX_EXISTS = "PA upsell - [new PA box] you must click on the link in the e-mail we'sent you to act your req (available)";
	public static final String COL_PA_UPSELL_SEC_RECEIVE_PA_EXISTS = "PA upsell - receive PA in these categories (available)";
	public static final String COL_PA_UPSELL_SEC_CHKBX_PRECHECKED = "PA upsell - [list the inq L4 cat (chkbx is pre-checked)] (available)";	
	
	public static final String COL_RFI_UPSELL_SEC_EXISTS = "RFI upsell section (available)";
	public static final String COL_RFI_UPSELL_SEC_PDT_SIMILAR_EXISTS = "RFI upsell - find other pdt similar to {inq L4 cat} (available)";
	public static final String COL_RFI_UPSELL_SEC_PDT_INTERESTED_EXISTS = "RFI upsell - find other pdt you might be interested in (available)";
	public static final String COL_RFI_UPSELL_SEC_SUPP_INTERESTED_EXISTS = "RFI upsell - find other suppliers you might be interested in (available)";
	public static final String COL_RFI_UPSELL_SEC_RECOMMENDED_PDT_EXISTS = "RFI upsell - recommended products for you (available)";
	public static final String COL_RFI_UPSELL_SEC_FIND_OTHER_PDT_EXISTS = "RFI upsell - find other {product} (available)";
	public static final String COL_RFI_UPSELL_SEC_SIBLING_CAT_EXISTS = "RFI upsell - 8 sibling categories of the inq L4 cat (available)";
	public static final String COL_RFI_UPSELL_SEC_PRODUCT_PROFILES_EXISTS = "RFI upsell - 8 PPs of the inq L4 cat are displayed in each tab (available)";
	public static final String COL_RFI_UPSELL_SEC_UP_TO_8CATEGORIES_EXISTS = "RFI upsell - list up to 8 cat based on the cat listed on supp RFI form (available)";
	public static final String COL_RFI_UPSELL_SEC_INQ_NOW_BTN_EXISTS = "RFI upsell - inq now btn is displayed below each category (available)";
	public static final String COL_RFI_UPSELL_SEC_INQ_ALL_BTN_EXISTS = "RFI upsell - inq all btn is displayed below each category (available)";
	public static final String COL_RFI_UPSELL_SEC_INQ_NOW_BESIDED_SUPP_EXISTS = "RFI upsell - inq now btn is displayed beside supp name (available)";			
	
	public static final String COL_EMAG_CROSSPROMO_SEC_EXISTS = "eMag crosspromo section (available)";
	//public static final String COL_SUBS_BTN_REPLACED_BY_MSG = "subs button replaced by msg (available)";
	
	public static final String COL_MINI_MARKETING_SEC_EXISTS = "mini marketing box section (available)";
	public static final String COL_MINI_MARKETING_GS_HOMEPAGE_EXISTS = "mini marketing box - go to GS homepage (available)";
	public static final String COL_MINI_MARKETING_VIEW_ALL_PDT_EXISTS = "mini marketing box - view all pdt in {inq L4 cat} category (available)";
	public static final String COL_MINI_MARKETING_ADD_OTHER_PA_LINK_EXISTS = "mini marketing box - 'add other categories to my PA' link (available)";
	
	public static final String COL_DOI_REMINDER_SEC_EXISTS = "DOI reminder section (available)";
		
	public static final String COL_RFI_FORM_IS_NOT_DISPLAYED = "RFI form (not available)";
    //public static final String COL_RESULT_USER_LOGGED_IN = "user's contact details (pre-populated)";
    //public static final String COL_RESULT_USER_NOT_LOGGED_IN = "user's contact details (not pre-populated)";
	//public static final String COL_INQUIRE_ALL_UPSELL_SECTION_EXISTS = "inquire all upsell section (available)";
	
	//public static final String COL_RFI_UPSELL_SECTION_NOT_EXISTS = "RFI upsell section (not available)";
	//public static final String COL_EMAG_CROSSPROMO_SECTION_NOT_EXISTS = "DOI reminder section (not available)";
	//public static final String COL_MINI_MARKETING_SECTION_NOT_EXISTS = "mini marketing box section (not available)";
	
	
	// RFI Form - Business Details section
	public static final String COL_ERROR_MSG_IN_RED_COLOR_BOX = "mandatory fields validation msg is displayed in a red color box (available)";
	public static final String COL_ERROR_MSG_BUSINESS_EMAIL_WITHOUT_ATSIGN = "msg 'this field must be a single, valid e-mail addr. pls re-enter it now' (available)";
	public static final String COL_ERROR_MSG_BUSINESS_EMAIL_WITH_SPECIAL_CHAR = "msg 'pls enter only char A-Z a-z 0-9 . @ _ - for email address' (available)";
	public static final String COL_ERROR_MSG_INV_COUNTRY_CODE = "country code msg 'pls enter only numbers. you may separate the numbers with spaces' (available)";
	public static final String COL_ERROR_MSG_INV_AREA_CODE = "area code msg 'pls enter only numbers. you may separate the numbers with spaces' (available)";
	public static final String COL_ERROR_MSG_INV_TELEPHONE_NUMBER = "tel no msg 'pls enter only numbers. you may separate the numbers with spaces' (available)";
	public static final String COL_ERROR_MSG_INV_TELEPHONE_EXT = "tel ext msg 'pls enter only numbers. you may separate the numbers with spaces' (available)";
	public static final String COL_ERROR_MSG_MESSAGE_FIELD_MIN_20_CHAR = "msg 'pls enter minimum 20 characters' (available)";
	public static final String COL_ALL_TIP_BOXES_MSG_DISPLAYED_CORRECTLY = "all the tip boxes/messages are displayed correctly (available)";
//	public static final String COL_ERROR_MSG_CONTACT_PHONE_NUMBER = "pls enter only numbers. you may separate the numbers with spaces (available)";
	
	public static final String COL_GSOL_PAGE_LANGUAGE_TRANSLATED = "gsol translated to selected language";
	public static final String COL_RFI_STATIC_FORM_TEXT_REMAIN_UNCHANGED = "text entered in RFI static form (remain unchanged)";
	
	public static final String COL_PA_LANDING_PAGE_DISPLAYED = "PA landing page (displayed)";
	public static final String COL_ALERT_MSG_SELECT_PDT_TO_INQ_EXISTS = "alert msg 'pls select at least one pdt to inq on.' (available)";
	public static final String COL_RFI_FLOATING_WINDOW_EXISTS = "RFI floating window (available)";
	public static final String COL_RFI_FLOATING_WINDOW_TEXT_IS_GRAY = "RFI floating window font color (gray)";
	public static final String COL_RFI_FLOATING_WINDOW_ENLARGED = "RFI floating window (enlarged)";
	public static final String COL_RFI_FLOATING_WINDOW_TEXT_IS_BLACK = "RFI floating window font color (black)";
	public static final String COL_RFI_FLOATING_WINDOW_TEXT_REMAIN_UNCHANGED = "text entered in RFI floating window (remain unchanged)";
	
	public static final String COL_ROLLOVER_LARGE_IMAGE_DISPLAYED = "rollover large image is displayed when mouse over to PP image (available)";
	public static final String COL_RFI_INQUIRY_DETAILS_WINDOW_DISPLAYED = "RFI inquiry details window (displayed)";
	public static final String COL_PP_RFI_INQUIRY_DETAILS_IS_MATCHING = "PP in the RFI inquiry details window (matching)";
	
	
	// Inquiry Basket
	public static final String COL_INQ_BASKET_PAGE_DISPLAYED = "inq basket page (displayed)";
	public static final String COL_PDT_INQ_ADDED_TO_BASKET_EXISTS = "pdt inq - btn 'added to basket' (available)";
	public static final String COL_PDT_INQ_CHKBX_REMOVED = "pdt inq - chkbx on those selected products (removed)";
	public static final String COL_PDT_INQ_BASKET_COUNT_RED_COLOR = "pdt inq - count beside inq basket in global nav (red color)";
	public static final String COL_INQ_BASKET_COUNT_MATCH = "pdt inq - inq basket count and number of products added (matching)";
	public static final String COL_GSOL_PP_PAGE_DISPLAYED = "gsol PP page/supplier PP page (displayed)";
	public static final String COL_PP_PAGE_BTN_ADDED_TO_BASKET = "gsol PP page btn 'added to basket' (available)";
	
	public static final String COL_SUPP_INQ_BTN_ADDED_TO_BASKET_EXISTS = "supp inq - btn 'added to basket' (available)";
	public static final String COL_SUPP_INQ_CHKBX_REMOVED = "supp inq - chkbx on those selected products (removed)";
	public static final String COL_SUPP_INQ_BASKET_COUNT_RED_COLOR = "supp inq - count beside inq basket in global nav (red color)";
	public static final String COL_INQ_BASKET_TOTAL_COUNT_MATCH = "supp inq - inq basket count and number of pdt & supp added (matching)";
	public static final String COL_SUPP_MW_HOMEPAGE_DISPLAYED = "supp MW homepage (displayed)";
	public static final String COL_MW_PAGE_BTN_ADDED_TO_BASKET = "supp MW homepage btn 'added to basket' (available)";
	public static final String COL_COUNT_INQ_BASKET_MORE_THAN_50 = "inq basket count (50+)";
	public static final String COL_NO_COUNT_BESIDE_INQ_BASKET = "count beside the inq basket (not available)";
//	public static final String COL_BTN_VIEW_BASKET_EXISTS = "button 'View basket' (available)";
	
	public static final String COL_INQ_BASKET_CHKBX_CHECKED = "all inq basket chkbx (selected)";
	public static final String COL_INQ_BASKET_CHKBX_UNCHECKED = "all inq basket chkbx (not selected)";
	public static final String COL_SORT_BY_SUPP_NAME_IN_ASC = "the PPs and suppliers are sorted by supp name (ascending)";
	public static final String COL_SORT_BY_SUPP_NAME_IN_DESC = "the PPs and suppliers are sorted by supp name (descending)";
	public static final String COL_ONLY_SELECTED_SUPP_DISPLAYED = "only results from selected suppliers are displayed (available)";
	public static final String COL_ALL_ADDED_SUPP_ITEMS_DISPLAYED = "all the added suppliers items are displayed (available)";
	public static final String COL_ONLY_SELECTED_CAT_DISPLAYED = "only results from selected category are displayed (available)";
	public static final String COL_ALL_ADDED_CAT_ITEMS_DISPLAYED = "all the added category items are displayed (available)";
	public static final String COL_SORT_BY_DATE_IN_DESC = "the PPs and suppliers are sorted by date (descending)";
	public static final String COL_ONLY_SELECTED_DATE_DISPLAYED = "only results from selected date are displayed (available)";
	public static final String ALL_ADDED_ITEMS_DISPLAYED = "all the added items are displayed (available)";
	public static final String COL_PP_SUPP_IS_REMOVED = "a PP/supp is removed from inq basket";
	public static final String COL_MSG_DEL_ALL_INQ_BASKET_ITEMS_EXISTS = "1st alert window - are you sure you want to remove all items in inq basket (available)"; 
	public static final String COL_ALL_ADDED_ITEMS_DISPLAYED = "inq basket page with all the added items are displayed (available)";
	public static final String COL_MESSAGE_DEL_ALL_INQ_BASKET_ITEMS_EXISTS = "2nd alert window - are you sure you want to remove all items in inq basket (available)"; 
	public static final String COL_ALL_ADDED_ITEMS_REMOVED = "all the items from the inq basket (removed)";
	public static final String COL_MSG_YOUR_INQ_BASKET_IS_EMPTY_EXISTS = "msg 'your inquiry basket is empty' (available)";
	public static final String COL_INQ_BASKET_CHKBX_SELECTED = "all inquiry basket chkbx (selected)";
	public static final String COL_INQUIRED_PP_IS_REMOVED = "the inquired PP (removed)";
	
	public static final String COL_ADD_TO_BASKET_BTN_EXISTS = "btn add to basket (available)";
	public static final String COL_ADDED_TO_BASKET_BTN_EXISTS = "add to basket btn is changed to added to basket btn (true)";
	public static final String COL_WORD_ADDED_TO_BASKET_EXISTS = "word added to basket on top of verified PP img (available)";
	
	
	// RFI Attachment
	public static final String COL_FILE_IS_UPLOADED = "first file (uploaded)";
	public static final String COL_SECOND_FILE_IS_UPLOADED = "second file (uploaded)";
	public static final String COL_THIRD_FILE_IS_UPLOADED = "third file (uploaded)";
	//public static final String COL_FILES_ARE_UPLOADED = "files are uploaded";
	
	
	// Registration Module
	public static final String COL_EMAIL_ADDR_SAME_AS_ENTERED_IN_EMAG_LITE = "email addr same as entered in eMag lite (available)";
	
	public static final String COL_EMAG_TITLE_CHKBX_CHECKED = "eMag title chkbx (selected)";
	public static final String COL_ALL_EMAG_TITLE_CHKBX_NOT_CHECKED = "all eMag title chkbx (not selected)";
	public static final String COL_PA_PDT_KEYWORD_TXTBX_IS_ENTERED = "PA pdt keyword is entered (available)";
	public static final String COL_PA_PDT_KEYWORD_TXTBX_IS_BLANK = "PA pdt keyword is blank (available)";
	public static final String COL_NOTIFICATION_CHKBX_CHECKED = "notification chkbx (selected)";
	public static final String COL_NOTIFICATION_CHKBX_NOT_CHECKED = "notification chkbx (not selected)";
	
	public static final String COL_SELECT_PA_CAT_PAGE_DISPLAYED = "select PA categories page (displayed)";
	public static final String COL_SUGG_CAT_BY_KEYWORD_REG_FORM_EXISTS = "sugg cat for pdt keyword entered in reg form (available)";
	public static final String COL_SUGG_CAT_BY_KEYWORD_SEL_PA_PAGE_EXISTS = "sugg cat for pdt keyword entered in select PA page (available)";
	public static final String COL_SUGG_CAT_BY_BROWSE_CAT_EXISTS = "sugg cat by browse cat (available)";
	public static final String COL_SUGG_CAT_PA_NOT_EXISTS = "PA suggested categories (not available)";
	public static final String COL_PDT_KEYWORD_IS_ENTERED = "pdt keyword is entered (available)";
	public static final String COL_SEL_PA_CAT_PAGE_NO_SUGG_CAT = "no sugg cat at sel PA cat page (available)";
	
	public static final String COL_CAT_PA_LITE_APPEAR_IN_SEL_CAT_COL = "cat sel in pre-req are appear in sel cat col (available)";
	
	public static final String COL_REG_CONF_PAGE_DOI_OVERLAY_DISPLAYED = "reg conf page with DOI reminder overlay (displayed)";
	public static final String COL_DOI_REMINDER_OVERLAY_DISPLAYED = "DOI reminder overlay (displayed)";
	public static final String COL_REG_CONFIRMATION_PAGE_DISPLAYED = "reg conf page (displayed)";
	public static final String COL_REG_CONF_PAGE_HEADER_COPY_EXISTS = "reg conf page header copy (available)";
	public static final String COL_REQ_SOURCING_MAGAZINES_COPY_EXISTS = "you've also req sourcing magazines copy (available)";
	public static final String COL_REQ_SOURCING_MAGAZINES_COPY_NOT_EXISTS = "you've also req sourcing magazines copy (not available)";
	public static final String COL_SEL_CAT_APPEAR_IN_REG_CONF_PAGE = "sel cat are appear in reg conf page (available)";
	public static final String COL_SEL_CAT_APPEAR_IN_PA_LITE_UPG_CONF_PAGE = "sel cat are appear in PA lite upg conf page (available)";
	public static final String COL_PA_LITE_UPG_CONF_PAGE_DOI_OVERLAY_DISPLAYED = "PA lite upg conf page with DOI reminder overlay (displayed)";
	
	public static final String COL_REG_CONF_PAGE_TRADE_MATCH_COPY_EXISTS = "save time finding suppliers with TradeMatch copy (available)";
	public static final String COL_REG_CONF_PAGE_PDT_INTERESTED_EXISTS = "find other pdt you might be interested in copy(available)";
	public static final String COL_REG_CONF_PAGE_TRADE_SHOWS_COPY_EXISTS = "see the latest products & deal directly with manufacturers copy (available)";
	
	public static final String COL_USER_PROFILE_PAGE_DISPLAYED = "user profile page (displayed)";
	public static final String COL_USER_PROFILE_INFO_REMAIN_UNCHANGED = "the info entered during reg (remain unchanged)";
	
	public static final String COL_NOTIFICATION_PAGE_DISPLAYED = "notifications page (displayed)";
	public static final String COL_ALL_NOTIFICATION_CHKBX_CHECKED = "notifications chkbx (selected)";
	public static final String COL_ALL_NOTIFICATION_CHKBX_UNCHECKED = "notifications chkbx (not selected)";
	public static final String COL_EMAIL_FORMAT_SET_TO_DEFAULT = "pref e-mail format set to default (available)";		
	
	public static final String COL_EMAG_PREFERENCE_PAGE_DISPLAYED = "eMag preference page (displayed)";
	public static final String COL_EMAG_MARKETING_PAGE_DISPLAYED = "eMag marketing page (displayed)";
	public static final String COL_SEL_EMAG_TITLE_IS_DISPLAYED = "eMag title sel is displayed in 'magazine(s) subscribed' sec (available)";
	public static final String COL_ALL_EMAG_TITLES_NOT_CHECKED = "all eMag titles (not selected)";
	public static final String COL_SEL_PRE_REQ_EMAG_IS_DISPLAYED = "eMag title sel in pre-req & sel PA cat page are appear in 'magazine(s) subscribed' sec (available)";
	
	public static final String COL_SEL_CAT_APPEAR_IN_PA_HOME = "sel cat are appear in PA homepage (available)";
	public static final String COL_SEL_PRE_REQ_CAT_APPEAR_IN_PA_HOME = "PA cat sel in pre-req & sel PA cat page are appear in PA homepage (available)";
	
	public static final String COL_ERROR_MSG_BUSINESS_EMAIL_ALR_REGISTERED = "error msg business email alr registered (available)";
	public static final String COL_ERROR_MSG_BUSINESS_EMAIL_WITHOUT_AT_SIGN = "error msg business email without @ sign (available)";
	public static final String COL_ERROR_MSG_BUSINESS_EMAIL_SPECIAL_CHAR = "error msg business email with special char (available)";
	public static final String COL_ERROR_MSG_PSW_WITH_SPACE = "error msg psw with spaces (available)";
	public static final String COL_ERROR_MSG_PSW_DO_NOT_MATCH = "error msg psw do not match (available)";	
	
	
	// Login Module
	public static final String COL_LOGIN_OVERLAY_IS_DISPLAYED = "login overlay (displayed)";
	public static final String COL_MINI_LOGIN_PAGE_DISPLAYED = "mini login page (displayed)";
	public static final String COL_MINI_REG_PAGE_DISPLAYED = "mini registration page (displayed)";
	public static final String COL_GSOL_LOGIN_PAGE_DISPLAYED = "login page (displayed)";
	public static final String COL_TXTBX_USERNAME_PSW_IS_ENTERED = "username and psw field (entered)";	
	public static final String COL_LAST_VIEWED_PAGE_DISPLAYED = "user last viewed page (displayed)";
	
	public static final String COL_LOGIN_BTN_EXISTS_IN_GLOBAL_NAV = "login btn exists in global nav (available)";
	public static final String COL_LOGOUT_BTN_EXISTS_IN_GLOBAL_NAV = "logout btn exists in global nav (available)";
	public static final String COL_FIRST_NAME_DISPLAYED_IN_GLOBAL_NAV = "first name displayed in global nav (available)";
	public static final String COL_BUYER_REG_EXISTS_IN_GLOBAL_NAV = "buyer reg btn exists in global nav (available)";
	public static final String COL_GET_NOTIFIED_SECTION_EXISTS = "PA upsell & subs btn exists in get notified sec (available)";
	
	public static final String COL_MSG_USERNAME_PSW_NOT_MATCH_EXISTS = "error msg username and psw not match (available)";
	public static final String COL_MSG_PLS_TRY_AGAIN_EXISTS = "msg 'pls check and try again' (available)";
	public static final String COL_LINK_FORGOT_PSW_EXISTS = "lnk forgot your password (available)";
	public static final String COL_LINK_GET_LIVE_HELP_EXISTS = "lnk get live help (available)";
	
	
	// Forget Password Module
	public static final String COL_FORGET_PSW_PAGE_DISPLAYED = "forget password page (displayed)";
	public static final String COL_CHK_YOUR_EMAIL_PAGE_DISPLAYED = "check your email page (displayed)";
	public static final String COL_CHANGE_PSW_PAGE_DISPLAYED = "change or set password page (displayed)";
	public static final String COL_MSG_EMAIL_SUBS_TO_PA_EMAG_EXISTS = "msg 'the email addr you entered is subs to receive PA/eMag updates only' (available)";
	public static final String COL_UPGRADE_UPSELL_SEC_EXISTS = "upg upsell sec below error msg (available)";
	public static final String COL_MSG_EMAIL_NOT_REG_IN_RED = "msg 'the email addr you entered is not reg with GS' (red color)";
	public static final String COL_LINK_REG_NOW_EXISTS = "lnk register now (available)";
	
	public static final String COL_EMAIL_ADDR_PREPOPULATED_IN_BUSINESS_EMAIL_FIELD = "email addr pre-populated in business email field (available)";
	public static final String COL_EMAIL_ADDR_PREPOPULATED_IN_GREY = "email addr pre-populated in grey (available)";
	public static final String COL_BUSINESS_EMAIL_FIELD_BLANK = "business email field is blank (available)";
	
	
	// Buyer Profile Module
	public static final String COL_BUYER_PROFILE_PAGE_DISPLAYED = "buyer profile page (displayed)";
	public static final String COL_BUYER_PROFILE_SAME_EXP_RESULT_AS_STEP_1TO4 = "buyer profile - same exp result as step 1 - 4 (available)";
	public static final String COL_BUYER_PROFILE_SAME_EXP_RESULT_AS_STEP_1TO2 = "buyer profile - same exp result as step 1 - 2 (available)";
	public static final String COL_BUYER_PROFILE_SETTING_SEC_EXISTS = "buyer profile setting section (available)";
	public static final String COL_ALWAYS_ASK_RADIO_BTN_CHECKED = "always ask radio button (selected)";
	
	
	// Navigation Bar Module
	public static final String COL_GSOL_HOMEPAGE_DISPLAYED = "GSOL homepage (displayed)";
	public static final String COL_SUB_MENU_REGISTER_AVAILABLE = "sub menu under register (available)";
	public static final String COL_BUYER_REG_PAGE_DISPLAYED = "buyer registration page (displayed)";
	public static final String COL_SUPP_REG_PAGE_DISPLAYED = "supp registration page (displayed)";
	public static final String COL_MSG_CENTER_LOGIN_PAGE_DISPLAYED = "message center login page (displayed)";
	public static final String COL_MSG_CENTER_HOMEPAGE_DISPLAYED = "message center home page (displayed)";
	public static final String COL_MC_EMAIL_VERIFICATION_PAGE_DISPLAYED = "MC email verification page (displayed)";
		
	public static final String COL_TOP_NAV_ARE_IN_SEQUENCE_ = "top nav menu are in sequence (available)";
	public static final String COL_SUB_MENU_ONLINE_MARKETPLACE_AVAILABLE = "sub menu under online marketplace (available)";
	public static final String COL_SUB_MENU_TRADE_SHOWS_AVAILABLE = "sub menu under trade shows (available)";
	public static final String COL_SUB_MENU_SMART_SOURCING_AVAILABLE = "sub menu under smart sourcing (available)";
	public static final String COL_SUB_MENU_OTHER_SERVICE_AVAILABLE = "sub menu under other service (available)";	
	
	public static final String COL_AUTO_PARTS_ACCESSORIES_PAGE_DISPLAYED = "auto parts & accessories page (displayed)";
	public static final String COL_CONSUMER_ELECTRONICS_PAGE_DISPLAYED = "consumer electronics page (displayed)";
	public static final String COL_DRONES_ROBOTICS_PAGE_DISPLAYED = "drones & robotics page (displayed)";
	public static final String COL_ELECTRONIC_COMPONENTS_PAGE_DISPLAYED = "electronic components page (displayed)";
	public static final String COL_FASHION_ACCESSORIES_FOOTWEAR_PAGE_DISPLAYED = "fashion accessories & footwear page (displayed)";
	public static final String COL_FASHION_APPAREL_FABRICS_PAGE_DISPLAYED = "fashion apparel & fabrics page (displayed)";
	public static final String COL_GIFTS_PREMIUMS_PAGE_DISPLAYED = "gifts & premiums page (displayed)";
	public static final String COL_HARDWARE_PAGE_DISPLAYED = "hardware page (displayed)";
	public static final String COL_HOME_PRODUCTS_PAGE_DISPLAYED = "home products page (displayed)";
	public static final String COL_LED_SOLAR_PRODUCTS_PAGE_DISPLAYED = "led & solar products page (displayed)";
	public static final String COL_LED_OPTOELECTRONICS_PAGE_DISPLAYED = "leds & optoelectronics page (displayed)";
	public static final String COL_MACHINERY_PARTS_PAGE_DISPLAYED = "machinery & parts page (displayed)";
	public static final String COL_MOBILE_ELECTRONICS_PAGE_DISPLAYED = "mobile electronics page (displayed)";
	public static final String COL_SECURITY_PRODUCTS_PAGE_DISPLAYED = "security products page (displayed)";
	public static final String COL_SMART_LIVING_PAGE_DISPLAYED = "smart living page (displayed)";
	public static final String COL_UNDERWEAR_SWIMWEAR_PAGE_DISPLAYED = "underwear & swimwear page (displayed)";
	
	public static final String COL_ANALYSTS_CHOICE_PAGE_DISPLAYED = "analysts choice page (displayed)";
	public static final String COL_SOURCING_NEWS_ADVICE_PAGE_DISPLAYED = "sourcing news & advice page (displayed)";
	public static final String COL_NEW_SOURCING_MARKETS_PAGE_DISPLAYED = "new sourcing markets page (displayed)";
	public static final String COL_SOURCING_REPORTS_PAGE_DISPLAYED = "sourcing reports page (displayed)";
	public static final String COL_GS_SUMMIT_PAGE_DISPLAYED = "global sources submit page (displayed)";
	public static final String COL_BUYER_SUPPORT_PAGE_DISPLAYED = "buyer support page (displayed)";
	
	public static final String COL_GET_QUOTATIONS_PAGE_DISPLAYED = "get quotations page (displayed)";
	public static final String COL_PRODUCT_ALERTS_PAGE_DISPLAYED = "product alerts page (displayed)";
	public static final String COL_MAGAZINES_PAGE_DISPLAYED = "magazines page (displayed)";
	public static final String COL_PRIVATE_SOURCING_EVENT_PAGE_DISPLAYED = "private sourcing event page (displayed)";
	public static final String COL_ABOUT_US_PAGE_DISPLAYED = "about us page (displayed)";	
	
	public static final String COL_MY_PREF_EXHIBITORS_PAGE_DISPLAYED = "my preferred exhibitors page (displayed)";
	
	public static final String COL_SUB_MENU_SYP_USER_AVAILABLE = "sub menu under SYP username (available)";
	public static final String COL_SUB_MENU_NON_SYP_USER_AVAILABLE = "sub menu under non SYP username (available)";
	public static final String COL_DOI_MSG_GLOBAL_NAV_EXISTS = "DOI reminder msg under global nav (available)";
	public static final String COL_DOI_MSG_GLOBAL_NAV_NOT_EXISTS = "DOI reminder msg under global nav (not available)";
	
	public static final String COL_DOI_MSG_UNDER_PALINK_EXISTS = "DOI reminder msg under PA link (available)";
	public static final String COL_DOI_MSG_UNDER_PALINK_NOT_EXISTS = "DOI reminder msg under PA link (not available)";
	public static final String COL_DOI_REMINDER_MSG_CHANGED_EXISTS = "DOI reminder msg changed (available)";
	
	
	// PA Edit Categories
	public static final String COL_PA_EDIT_CATEGORIES_PAGE_DISPLAYED = "PA edit categories page (displayed)";
	public static final String COL_PA_ADD_CATEGORIES_PAGE_DISPLAYED = "PA add categories page (displayed)";
	public static final String COL_PA_LITE_EDIT_CATEGORIES_PAGE_DISPLAYED = "PA lite edit categories page (displayed)";
	
	public static final String COL_SUGG_CAT_BY_KEYWORD_PA_EDIT_EXISTS = "sugg cat based on the keyword in PA edit cat page (available)";
	public static final String COL_SUGG_CAT_BY_2ND_KEYWORD_PA_EDIT_EXISTS = "sugg cat based on 2nd keyword in PA edit cat page (available)";
	public static final String COL_SUGG_CAT_BY_KEYWORD_PA_ADD_EXISTS = "sugg cat based on the keyword in PA add cat page (available)";
	public static final String COL_SUGG_CAT_IN_CENTREWELL_SEC_EXISTS = "sugg cat in PA cross promotion sec (available)";
	public static final String COL_SUGG_CAT_BY_KEYWORD_L3_EXISTS = "sugg cat based on the keyword in L1, L2, L3 or new pdt (available)";
	public static final String COL_SUGG_CAT_BY_KEYWORD_L3_TP_UNV_PP_EXISTS = "sugg cat based on the keyword in L3, TP or unv PP page (available)";
	public static final String COL_SUGG_CAT_BY_VERTICAL_TITLE_KEYWORD_EXISTS = "sugg cat based on the vertical title keyword (available)";
	public static final String COL_SUGG_CAT_BY_KEYWORD_PA_HOMEPAGE_EXISTS = "sugg cat based on the keyword entered in PA homepage (available)";		
	//public static final String COL_SUGG_CAT_BY_KEYWORD_CATFISH_BANNER = "sugg cat based on the pre-populated keyword in catfish banner (available)";
	public static final String COL_SUGG_CAT_IN_CATFISH_BANNER_EXISTS = "sugg cat in PA catfish banner sec (available)";
	public static final String COL_SUGG_CAT_BY_PDT_KEYWORD_EXISTS = "sugg cat based on the keyword entered (available)";
	
	public static final String COL_CATEGORY_CHECKBOXES_CHECKED = "category chkbx (selected)";
	public static final String COL_SEL_CAT_GRAYED_OUT = "sel cat are grey-ed out (available)";
	public static final String COL_SEL_CAT_APPEAR_IN_SEL_COLUMN = "sel cat are appear in the sel cat col (available)";
	public static final String COL_CAT_CHKBX_CHECKED_GREYED_OUT_APPEAR_IN_RIGHT = "cat chkbx sel, grey-ed out, appear in sel cat col (available)";
	
	public static final String COL_PA_EDIT_CAT_CONF_PAGE_DISPLAYED = "PA edit categories conf page (displayed)";
	public static final String COL_MSG_SUCCESSFUL_ADD_PDT_CAT_EXISTS = "msg 'successful! you hv added x pdt cat' (available)";
	public static final String COL_PA_EDIT_CAT_CONF_PAGE_MSG_SUCCESSFUL_EXISTS = "PA edit cat conf page with msg successful added (available)";
	public static final String COL_RECOMMENDED_CAT_SEC_EXISTS = "recommended cat sec (available)";
	public static final String COL_RECOMMENDED_CAT_CHKBX_CHECKED = "recommended cat chkbx (selected)";
	public static final String COL_ADDED_TO_SEL_CAT_COLUMN = "recommended cat added to sel cat column (available)";
	
	public static final String COL_1ST_CAT_CHKBX_CHECKED = "first category's checkbox (selected)";
	public static final String COL_2ND_CAT_CHKBX_CHECKED = "any categories checkboxes (selected)";
	public static final String COL_ALL_CAT_CHKBX_CHECKED = "all categories checkboxes (selected)";
	
	public static final String COL_PA_ENHANCED_ENTRANCE_IMG_CHANGED = "PA enhanced entrance img is changed (available)";
	public static final String COL_LINK_VIEW_LATEST_PDT_EXISTS = "copy changed to lnk 'view latest pdt' (available)";
	public static final String COL_ADDED_TO_COLUMN_PA_HOMEPAGE = "cat added to column PA homepage (available)";
	
	
	public static final String COL_PA_CAT_CONF_PAGE_DISPLAYED = "PA category conf page (displayed)";
	public static final String COL_SEL_CAT_ADDED_TO_PA_EXISTS = "category added to PA (available)";
	//public static final String COL_VERTICAL_TITLE_HYPERLINK_EXISTS = "vertical title hyperlink (available)";
	
	
	// PA Homepage
	public static final String COL_PA_HOMEPAGE_DISPLAYED = "PA homepage (displayed)";
	public static final String COL_PA_SETTINGS_PAGE_DISPLAYED = "PA settings page (displayed)";
	
	public static final String COL_MSG_NO_CAT_SELECTED_EXISTS = "msg 'you currently hv no cat sel for PA' (available)";
	public static final String COL_PA_HOMEPAGE_MSG_NO_CAT_SEL_EXISTS = "PA homepage with msg 'you currently hv no cat sel for PA' (available)";
	public static final String COL_MSG_WANT_TO_CONT_EXISTS = "msg 'are you sure want to continue' (available)";
	public static final String COL_MSG_REMOVED_ALL_PDT_CAT_EXISTS = "msg 'updated! you hv removed all of your pdt cat' (available)";
	
	public static final String COL_PA_SETTINGS_PAGE_ALL_CHKBX_CHECKED= "PA settings page all chkbx (selected)";
	public static final String COL_PA_SETTINGS_PAGE_ALL_CHKBX_UNCHECKED = "PA settings page all chkbx (not selected)";
	public static final String COL_PA_SETTINGS_PAGE_ALL_CHKBX_REMAIN_CHECKED = "PA settings page all chkbx (remain selected)";
	public static final String COL_PA_CHKBX_NOT_CHECKED = "PA settings page - PA chkbx (not selected)";
	public static final String COL_NEWS_ALERT_CHKBX_NOT_CHECKED = "PA settings page - News Alert chkbx (not selected)";
	public static final String COL_SA_CHKBX_NOT_CHECKED = "PA settings page - SA chkbx (not selected)";
	public static final String COL_MSG_UPD_SETTINGS_EXISTS = "msg 'you hv updated your settings successfully' (available)";
	public static final String COL_MSG_STOP_ALERTS_EXISTS = "msg 'are you sure you want to stop receiving PA, NA and SA' (available)";
	public static final String COL_MSG_STOP_REC_PA_EXISTS = "msg 'are you sure you want to stop receiving PA' (available)";
	public static final String COL_MSG_STOP_NEWS_ALERT_EXISTS = "msg 'are you sure you want to stop receiving News Alert' (available)";
	public static final String COL_MSG_STOP_REC_SA_EXISTS = "msg 'are you sure you want to stop receiving SA' (available)";
	public static final String COL_TWO_RADIO_BTN_OPTIONS_EXISTS = "there are 2 radbtn options (available)";
	public static final String COL_MSG_STOP_ALERT_SEEN_RADIO_BTN_EXISTS = "msg stop all alert seen, radbtn options exists (available)";
	public static final String COL_MSG_STOP_PA_SEEN_RADIO_BTN_EXISTS = "msg stop PA seen, radbtn options exists (available)";
	public static final String COL_MSG_STOP_NA_SEEN_RADIO_BTN_EXISTS = "msg stop NA seen, radbtn options exists (available)";
	public static final String COL_MSG_STOP_SA_SEEN_RADIO_BTN_EXISTS = "msg stop SA seen, radbtn options exists (available)";
	
	
	// PA Lite Signup
	public static final String COL_PA_MARKETING_PAGE_DISPLAYED = "PA marketing page (displayed)";
	public static final String COL_PA_LITE_CONF_PAGE_DISPLAYED = "PA lite confirmation page (displayed)";
	public static final String COL_PA_LITE_UPG_CONF_PAGE_DISPLAYED = "PA lite upg conf page (displayed)";
	public static final String COL_PA_LITE_UPG_UPSELL_SEC_EXISTS = "PA lite upg upsell section (available)";
	public static final String COL_UP_TO_10_PA_CAT_SEL_DISPLAYED = "up to 10 PA cat sel is displayed (available)";
	public static final String COL_PDT_KEYWORD_IS_PREPOPULATED = "pdt keyword is pre-populated (available)";
	public static final String COL_MSG_EXCEED_MAX_CAT_SUBS_EXISTS = "alert window - user has exceeded the max cat subs (available)";
	public static final String COL_ERROR_MSG_POPUP_WINDOW_CLOSED = "error msg pop-up window is closed (available)";
	public static final String COL_COUNT_SEL_CAT_NOT_MORE_THAN_10 = "sel cat not more than 10 (available)";
	public static final String COL_EMAIL_ADDR_TXTBX_BESIDE_EE = "email addr txtbx beside enhanced entrance link (available)";
	public static final String COL_EE_CONF_COPY_EXISTS = "conf copy enhanced entrance link (available)";
	
	
	// PA Upgrade
	public static final String COL_DOI_CONF_PAGE_DISPLAYED = "DOI confirmation page (displayed)";
	public static final String COL_CONF_MSG_DISPLAYED_IN_BOLD = "conf msg displayed in bold (available)";
	public static final String COL_PA_UPG_UPSELL_SEC_EXISTS = "upgrade upsell section (available)";
	public static final String COL_PA_WARNING_PAGE_DISPLAYED = "PA warning page (displayed)";
	public static final String COL_PA_WARNING_MSG_DISPLAYED_IN_RED = "warning msg displayed in red (available)";
	
	
	// eMag Lite
	public static final String COL_OUR_SERVICES_PAGE_DISPLAYED = "our services page (displayed)";
	public static final String COL_EMAG_LITE_FORM_PAGE_DISPLAYED = "eMag lite form page (displayed)";
	public static final String COL_EMAG_LITE_TITLE_CHKBX_CHECKED = "eMag lite title chkbx (selected)";
	public static final String COL_EMAG_LITE_TITLE_CHKBX_REMAIN_CHECKED = "eMag lite title chkbx (remain selected)";
	public static final String COL_PASSWORD_FIELD_EXISTS = "password field (available)";
	public static final String COL_ALL_MANDATORY_FIELDS_EXISTS = "all mandatory fields (available)";
	public static final String COL_ALL_MANDATORY_FIELDS_FILLED_UP = "all mandatory fields filled up (available)";
	
	public static final String COL_EMAG_LITE_CONF_PAGE_DISPLAYED = "eMag lite conf page (displayed)";	
	public static final String COL_EMAG_LITE_PAIDSUB_SEC_EXISTS = "PAIDSUB section (available)";
	public static final String COL_EMAG_LITE_PA_UPSELL_SEC_EXISTS = "PA upsell section (available)"; 
	public static final String COL_EMAG_LITE_UPGRADE_UPSELL_SEC_EXISTS = "upgrade upsell section (available)";
	public static final String COL_EMAG_WARNING_PAGE_DISPLAYED = "eMag warning page (displayed)";
	public static final String COL_EMAG_WARNING_MSG_DISPLAYED_IN_RED = "eMag warning msg displayed in red (available)";
	

	// eMag Subscription
	public static final String COL_EMAG_SUBS_PAGE_DISPLAYED = "eMag subscriptions page (displayed)";
	public static final String COL_GS_MAG_MOBILE_APP_EXISTS = "GS magazines mobile app page (displayed)";
	public static final String COL_APP_STORE_GS_EMAG_EXISTS = "app store for GS magazines mobile app (displayed)";
	public static final String COL_GOOGLE_PLAY_GS_EMAG_EXISTS = "google play for GS magazines mobile app (displayed)";
	public static final String COL_SUBS_WITH_TICK_ICON_EXISTS = "'subscribe now' btn became '[tick]subscribed'";
	public static final String COL_MSG_SUBS_TO_EMAG_EXISTS = "msg 'you are subs to this magazine' (available)";
	public static final String COL_SEL_EMAG_DISPLAYED_IN_NEW_TAB = "selected eMag displayed in new tab (available)";

	
	// SA Module
	public static final String COL_SA_MARKETING_PAGE_DISPLAYED = "SA marketing page (displayed)";
	public static final String COL_SA_EDIT_SUPP_PAGE_DISPLAYED = "SA edit suppliers page (displayed)";
	public static final String COL_SA_EDIT_CATEGORIES_PAGE_DISPLAYED = "SA edit categories page (displayed)";
	public static final String COL_SA_UPGRADE_PAGE_DISPLAYED  ="SA upgrade page (displayed)";
	public static final String COL_SA_LOGIN_PAGE_DISPLAYED = "SA login page (displayed)";	
	public static final String COL_SA_CONFIRMATION_PAGE_DISPLAYED = "SA confirmation page (displayed)";
	public static final String COL_COPY_SKIP_THIS_STEP_EXISTS = "copy skip this step (available)";
	public static final String COL_BTN_FOLLOWING_WITH_GREEN_TICK = "btn following with green tick (available)";
	public static final String COL_COPY_SUCC_FOLLOWING_EXISTS = "copy successful following (available)";
	public static final String COL_COPY_VIEW_EDIT_SUPP_EXISTS = "copy view edit following supp (available)";
	public static final String COL_CLICK_HERE_IS_HYPERLINK = "click here is a hyperlink (available)";
	public static final String COL_FOLLOWING_SUPP_ADDED_TO_VER_SUPP_SECTION = "following supp name added to ver supp section (available)";
	public static final String COL_LINK_VIEW_FOLLOWED_SUPP_EXISTS = "lnk view my followed supp (available)";
	public static final String COL_SELECT_ALL_CHKBX_VER_SUPP_CHECKED = "select all chkbx for ver supp (selected)";
	public static final String COL_MSG_STOP_FOLLOW_SUPP_EXISTS = "popup msg stop follow supp (available)";
	public static final String COL_MSG_SUCCESSFUL_REMOVED_SUPP_EXISTS = "msg 'you hv successfully removed the supp from your SA updates' (available)";
	public static final String COL_COPY_ZERO_FOLLOWING_SUPP_EXISTS = "copy 0 following supp (available)";
	public static final String COL_SELECT_ALL_CHKBX_UNV_SUPP_CHECKED = "select all chkbx for unv supp (selected)";
	
	public static final String COL_AGG_SUPP_HOMEPAGE_IS_DISPLAYED = "AGG supplier homepage (displayed)";
	public static final String COL_AGG_PROD_LIST_PAGE_IS_DISPLAYED = "AGG supp product list page (displayed)";
	public static final String COL_AGG_SUPP_PP_PAGE_IS_DISPLAYED = "AGG supp PP page (displayed)";
	public static final String COL_AGG_COMP_PROFILE_PAGE_IS_DISPLAYED = "AGG supp comp profile page (displayed)";
	public static final String COL_AGG_SUPP_TRADE_SHOWS_PAGE_IS_DISPLAYED = "AGG supp trade shows page (displayed)";
	public static final String COL_AGG_SUPP_CONTACT_US_PAGE_IS_DISPLAYED = "AGG supp contact us page (displayed)";
	
	public static final String COL_SUPP_PDT_LIST_PAGE_DISPLAYED = "supplier product list page (displayed)";
	public static final String COL_SUPP_PP_PAGE_DISPLAYED = "supplier PP page (displayed)";
	public static final String COL_SUPP_OTHER_CAT_SECT_EXISTS = "other categories you may find interesting section (displayed)";
	
	
	// Supplier Homepage Module
	public static final String MULTIPLE_PPS_CHKBX_ARE_CHECKED = "multiple PPs chkbx are checked (available)";
	public static final String COL_ALL_PPS_CHKBX_ARE_CHECKED = "all PPs chkbx are checked (available)";
	
	
	// Supplier AGG Homepage Module
	public static final String COL_EMAIL_ADDR_TXTBX_BESIDE_PA = "email addr txtbx beside product alert link (available)";
	
	
	// Search Module 
	public static final String COL_ADVANCED_SEARCH_PAGE_DISPLAYED = "advanced search page (displayed)";
	public static final String COL_ADVANCE_SEARCH_BOX_EXISTS = "advanced search box (available)";	
	public static final String COL_AUTO_COMPLETE_IS_DISPLAYED = "search auto complete is displayed (available)";
	public static final String COL_SUGG_KEYWORD_IS_BOLD = "sugg keyword in auto complete is bold (available)";
	public static final String COL_SEARCH_WITHIN_RESULTS_CHECKED = "search within this cat is sel in 'i would like to:' field (available)";
	public static final String COL_I_AM_LOOKING_FOR_PRODUCTS = "products is selected in 'i am looking for:' field (available)";
	public static final String COL_I_AM_LOOKING_FOR_VER_SUPP = "ver supp is selected in 'i am looking for:' field (available)";
	public static final String COL_I_AM_LOOKING_FOR_UNV_SUPP = "other supp is selected in 'i am looking for:' field (available)";
	public static final String COL_I_AM_LOOKING_FOR_ALL_SUPP_TYPES = "all supp types is selected in 'i am looking for:' field (available)";
	public static final String COL_I_AM_LOOKING_FOR_NEWS = "news is selected in 'i am looking for:' field (available)";
	public static final String COL_MATCH_ALL_OF_MY_WORDS_CHECKED = "match all of my words is selected in 'search method' field (available)";
	public static final String COL_MATCH_ANY_OF_MY_WORDS_CHECKED = "match any of my words is selected in 'search method' field (available)";
	public static final String COL_MATCH_MY_EXACT_PHRASE_CHECKED = "match my exact phrase is selected in 'search method' field (available)";
	public static final String COL_ALL_CATEGORIES_SELECTED = "all categories is selected in 'just in the category:' field (available)";
	public static final String COL_PDT_VERTICAL_IS_SELECTED = "pdt vertical is selected (available)";
	public static final String COL_ALL_COUNTRIES_SELECTED = "all countries is selected in 'select countries:' field (available)";
	public static final String COL_INPUT_COUNTRY_IS_SELECTED = "input country is selected (available)";
	public static final String COL_PDT_KEYWORD_TXTBX_IS_ENTERED = "pdt keyword text box is entered (available)";
	public static final String COL_PDT_KEYWORD_TXTBX_IS_BLANK = "pdt keyword text box is blank (available)";
	public static final String COL_MSG_ENTER_KEYWORD_TO_SEARCH_EXISTS = "pls enter a keyword first to start your search (available)";	
	public static final String COL_MSG_DID_YOU_MEAN_EXISTS = "msg 'did you mean' (available)";
	public static final String COL_KEYWORD_SEARCH_RESULT_PAGE_DISPLAYED = "keyword search result page (displayed)";
	public static final String COL_SUPP_SEARCH_RESULT_PAGE_DISPLAYED = "supp search result page (displayed)";
	public static final String COL_NEWS_SEARCH_RESULT_PAGE_DISPLAYED = "news search result page (displayed)";
	public static final String COL_RESULTS_CONTAIN_ALL_KEYWORDS = "results displayed contains all of the keywords entered (available)";
	public static final String COL_RESULTS_AT_LEAST_ONE_KEYWORDS = "results displayed contains at least one of the keyword entered (available)";
	public static final String COL_RESULTS_EXACT_MATCH_KEYWORDS = "results displayed contains exact match of the keywords entered (available)";
	public static final String COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY = "results displayed contains only selected country (available)";
	
	public static final String COL_FILTER_BY_MANUFACTURER_CHKBX_CHECKED = "filter by manufacturer chkbx (selected)";
	public static final String COL_QUICK_FILTERS_MANUFACTURER_CHKBX_CHECKED = "quick filters manufacturer chkbx (selected)";
	public static final String COL_SEL_FILTER_CONTAINS_MANUFACTURER = "selected filter contains manufacturer (available)";
	public static final String COL_FILTER_BY_3_STAR_CHKBX_CHECKED = "filter by 3 star chkbx (selected)";
	public static final String COL_SEL_FILTER_CONTAINS_3STAR = "selected filter contains 3 star (available)";
	
	
	// CPP Module
	public static final String COL_CPP_MSG_FREE_ALERTS_EXISTS = "copy 'Free Alerts on newly added products' (available)";
	public static final String COL_CPP_EMAIL_TXTBX_EXISTS = "CPP email text box (available)";
	public static final String COL_CPP_EMAIL_TXTBX_IS_ENTERED = "CPP email text box is entered (available)";
	public static final String COL_CPP_EMAIL_TXTBX_IS_BLANK = "CPP email text box is blank (available)";
	public static final String COL_CPP_SUBS_BTN_IS_EXISTS = "CPP subs btn (available)"; 
	public static final String COL_MSG_ENTER_EMAIL_ADDR_EXISTS = "alert window - pls enter your e-mail addr (available)";
	public static final String COL_CPP_INQ_NOW_BTN_EXISTS = "inq now btn when mouseover PP img (available)";
	
	
	// Wholesale Module
	public static final String COL_TO_SECT_ONLY_CONTAINS_VER_PP = "to: section only contains ver PPs (available)";
	public static final String COL_TO_SECT_ONLY_CONTAINS_UNV_PP = "to: section only contains unv PPs (available)";
	public static final String COL_BOTH_VER_UNV_PP_CHKBX_CHECKED = "PPs from both ver & unv (selected)";
	public static final String COL_ADD_TO_BASKET_EXISTS_IN_VER_PP = "add to basket btn in ver PP section (available)";
	public static final String COL_ADD_TO_BASKET_NOT_EXISTS_IN_UNV_PP = "add to basket btn in unv PP section (not available)";
	public static final String COL_VER_PP_ADDED_TO_INQ_BASKET = "ver PPs are added to inq basket (available)";
	public static final String COL_UNV_PP_NOT_ADDED_TO_BASKET = "unv PPs are not added to inq basket (available)";
	public static final String COL_COMPARE_PDT_EXISTS_IN_VER_PP = "compare pdt btn in ver PP section (available)";
	public static final String COL_COMPARE_PDT_NOT_EXISTS_IN_UNV_PP = "compare pdt btn in unv PP section (not available)";
	public static final String COL_ONLY_MOQ_FOB_FILTERS_DISPLAYED = "only MOQ and FOB filters displayed (available)";
	
	
	// Entry Point
	public static final String COL_L4_CATEGORY_PAGE_DISPLAYED = "L4 category page (displayed)";
	
	
	// Production Bug
	public static final String COL_SUPP_SERVICE_ICONS_MATCHING = "supp service icon are matching (true)";
	
	
	// GSOL Footer
	public static final String COL_NEW_PRODUCTS_PAGE_DISPLAYED = "new products page (displayed)";
	public static final String COL_TOP_PRODUCTS_PAGE_DISPLAYED = "top products page (displayed)";
	public static final String COL_TOP_CHN_SUPP_PAGE_DISPLAYED = "top china suppliers page (displayed)";
	public static final String COL_WHOLESALE_L1_DRILLDOWN_PAGE_DISPLAYED = "wholesale L1 drilldown page (displayed)";
	public static final String COL_WHOLESALE_L3_DRILLDOWN_PAGE_DISPLAYED = "wholesale L3 drilldown page (displayed)";
	public static final String COL_WHOLESALE_PDT_KEYWORD_PAGE_DISPLAYED = "wholesale pdt keyword page (displayed)";
	
	}
