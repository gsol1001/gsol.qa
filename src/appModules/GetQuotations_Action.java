/**
 * This Class contains all the methods in the Get Quotations Action
 * Created: Wed 06 Apr 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/04/06
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.MessageCenter_Page;

/**
 * Contain all the methods in the Get Quotations action.
 * @author Teng Shyh Wei
 *
 */
public class GetQuotations_Action {
	
	// RFI Flow Logged-in user.
	public static void ExecuteLI1_FillInAllInfo(String dataProductName, String dataL1Category, String dataL3Category, String dataL4Category, 
			String dataAboutProduct, String dataPdtImgPath, String dataEstOrderQuantity, String dataQuantityUnit, String dataCurrency, 
			String dataPrefUnitPrice, String dataValidTo, String dataShipmentTerms, String dataPaymentTerms, String dataCompCert, String dataPdtCert, 
			String dataAggOptIn) throws Exception{
		
		// Enter text for 'Product Name' field.
		MessageCenter_Page.txtbx_enterProductName().sendKeys(dataProductName);
		
		// Click on the 'Select a product category' hyperlink.
	//	MessageCenter_Page.lnk_clickSelectPdtCategory().click();
		
		// Click on the Level one category.
	//	MessageCenter_Page.lstbx_clickL1Category(dataL1Category);
		
		// Click on the Level three category.
	//	MessageCenter_Page.lstbx_clickL3Category(dataL3Category);
				
		// Click on the Level four category.
	//	MessageCenter_Page.lstbx_clickL4Category(dataL4Category);		
		
		// Enter text for 'About Your Product' field.
		MessageCenter_Page.txtbx_enterAboutYourProduct().sendKeys(dataAboutProduct);
		
		// Upload Product Image/Attachment.
		MessageCenter_Page.btn_UploadProductImage(dataPdtImgPath);
		
		// Enter text for 'Estimated Order Quantity' field.
		MessageCenter_Page.txtbx_enterEstOrderQuantity().sendKeys(dataEstOrderQuantity);
		
		// Select drop down list for Quantity Unit.
		MessageCenter_Page.drpdwn_selectQuantityUnit(dataQuantityUnit);
		
		// Select drop down list for Currency.
		MessageCenter_Page.drpdwn_selectCurrency(dataCurrency);
		
		// Enter text for 'Preferred Unit Price' field.
		MessageCenter_Page.txtbx_enterPrefUnitPrice().sendKeys(dataPrefUnitPrice);
		
		// Select drop down list for Valid To.
		MessageCenter_Page.drpdwn_selectValidTo(dataValidTo);
	
		
		// Select drop down list for Shipment Terms.
		MessageCenter_Page.drpdwn_selectShipmentTerms(dataShipmentTerms);
		
		// Select drop down list for Payment Terms.
		MessageCenter_Page.drpdwn_selectPaymentTerms(dataPaymentTerms);
		
		// Enter text for 'Required Company Certification(s)' field.
		MessageCenter_Page.txtbx_enterCompCertification().sendKeys(dataCompCert);
		
		// Enter text for 'Required Product Certification(s)' field.
		MessageCenter_Page.txtbx_enterPdtCertification().sendKeys(dataPdtCert);
		
		
		// Select checkbox for AGG OptIn.
		MessageCenter_Page.ckbx_selectAggOptIn(dataAggOptIn);
		
		// Click on 'Submit' button.
		MessageCenter_Page.btn_clickSubmit().click();
	}
	
	// RFI Flow New User. Fill in all the information and click submit button.
	public static void ExecuteNL1_FillInAllInfo(String dataProductName, String dataAboutProduct, String dataEstOrderQuantity,
			String dataQuantityUnit, String dataCurrency, String dataPrefUnitPrice, String dataValidTo, 
			String dataShipmentTerms, String dataPaymentTerms, String dataCompCert, String dataPdtCert,
			String dataBusinessEmail, String dataBuyerProfile, String dataAggOptIn) throws Exception{
		
		// Enter text for 'Product Name' field.
		MessageCenter_Page.txtbx_enterProductName().sendKeys(dataProductName);
		
		// Click on the 'Select a product category' hyperlink.
		MessageCenter_Page.lnk_clickSelectPdtCategory().click();
		
		// Enter text for 'About Your Product' field.
		MessageCenter_Page.txtbx_enterAboutYourProduct().sendKeys(dataAboutProduct);
		
		// Enter text for 'Estimated Order Quantity' field.
		MessageCenter_Page.txtbx_enterEstOrderQuantity().sendKeys(dataEstOrderQuantity);
		
		// Select drop down list for Quantity Unit.
		MessageCenter_Page.drpdwn_selectQuantityUnit(dataQuantityUnit);
		
		// Select drop down list for Currency.
		MessageCenter_Page.drpdwn_selectCurrency(dataCurrency);
		
		// Enter text for 'Preferred Unit Price' field.
		MessageCenter_Page.txtbx_enterPrefUnitPrice().sendKeys(dataPrefUnitPrice);
		
		// Select drop down list for Valid To.
		MessageCenter_Page.drpdwn_selectValidTo(dataValidTo);
	
		
		// Select drop down list for Shipment Terms.
		MessageCenter_Page.drpdwn_selectShipmentTerms(dataShipmentTerms);
		
		// Select drop down list for Payment Terms.
		MessageCenter_Page.drpdwn_selectPaymentTerms(dataPaymentTerms);
		
		// Enter text for 'Required Company Certification(s)' field.
		MessageCenter_Page.txtbx_enterCompCertification().sendKeys(dataCompCert);
		
		// Enter text for 'Required Product Certification(s)' field.
		MessageCenter_Page.txtbx_enterPdtCertification().sendKeys(dataPdtCert);
		
		// Enter text for 'Business email' field.
		MessageCenter_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Select 'Buyer Profile' checkbox.
		MessageCenter_Page.radbtn_selectBuyerProfile(dataBuyerProfile);
		
		// Select checkbox for AGG OptIn.
		MessageCenter_Page.ckbx_selectAggOptIn(dataAggOptIn);
		
		// Click on 'Submit' button.
		MessageCenter_Page.btn_clickSubmit().click();		
		
	}

}
