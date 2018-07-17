/**
 * This Class contains all the methods in the Inquiry Basket Action
 * Created: Mon 16 March 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/05/18
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.InquiryBasket_Page;
import pageObjects.InquiryForm_Page;
import pageObjects.ProductListing_Page;
import pageObjects.RFIConfirmation_Page;
import pageObjects.TopNav_MenuBar;
import utility.Read_XLS;

/**
 * Contain all the methods in the Inquiry Basket action.
 * @author Teng Shyh Wei
 *
 */
public class InquiryBasket_Action {
	
	public static void ExecuteCleanUpInqBasket() throws Exception{		
		
		// Go to Inquiry Basket page
		ProductListing_Page.lnk_clickGlobalNavAddToBasketIcon().click();
		
		// Clean up Inquiry Basket if available on the page
		InquiryBasket_Page.check_clearInquiryBasket();
		
    	// Go back to GSOL home page
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		
	}
	
	
	/**
	 * Add more than 1 products and suppliers into the inquiry basket.
	 * 
	 * @param dataPdtSearchKeyword
	 * @param dataSuppSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteRFIForm_AddPdtSuppIntoInqBasket(String dataPdtSearchKeyword, 
			String dataSuppSearchKeyword) throws Exception{
		
		// Add more than 1 products into the inquiry basket
		ProductInquiry_Action.ExecuteSelectMulVerPdt_ClickAddToBasketBtn(dataPdtSearchKeyword);
		
		// Due to page optimization, waits for 5 seconds
	//	Thread.sleep(5000);
	//	System.out.println("Waits for 5 seconds.");
	//	TopNav_MenuBar.check_topMenuBarIsVisible();
		
		// Add more than 1 suppliers into the inquiry basket
		SupplierInquiry_Action.ExecuteSelectMulVerSupp_ClickAddToBasketBtn(dataSuppSearchKeyword);
		
	}
	
	
	/**
	 * Fill up and submit the RFI form, verify that RFI form is displayed.
	 * Go back to Inquiry Basket page.
	 * 
	 * @param dataMessage
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteRFIForm_FillUpAndSubmitRFIForm(String dataMessage, Read_XLS xls, 
			String sheetName, int rowNum, List<Boolean> testFail) throws Exception{
		
		// Fill up and submit the RFI form
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		InquiryForm_Page.btn_clickContactSupplierNow();
					
		// To verify is RFI Confirmation page displayed
		RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(xls, sheetName, rowNum, testFail);
		    		
		// Go back to Inquiry Basket page.
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		ProductListing_Page.lnk_clickGlobalNavAddToBasketIcon().click();
					
	}
	
	
	/**
	 * Fill up and submit the RFI form, verify that RFI form is displayed.
	 * Go back to Inquiry Basket page.
	 * 
	 * @param dataMessage
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteRFIForm_FillUpAndSubmitRFIFormAgain(String dataMessage, Read_XLS xls, 
			String sheetName, int rowNum, List<Boolean> testFail) throws Exception{
		
		// Fill up and submit the RFI form
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		InquiryForm_Page.btn_clickContactSupplierNow();
					
		// To verify is RFI Confirmation page displayed
		RFIConfirmation_Page.check_RFIConfirmationPageDisplayed(xls, sheetName, rowNum, testFail);
		    		
		// Go back to Inquiry Basket page.
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		ProductListing_Page.lnk_clickGlobalNavAddToBasketIcon().click();
					
	}
}
