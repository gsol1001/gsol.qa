/**
 * This Class contains all the methods in the Inquiry Form Action
 * Created: Wed 11 February 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/13
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.InquiryForm_Page;
import pageObjects.MiniLogin_Page;
import pageObjects.ProductProfile_Page;
import pageObjects.SupplierHome_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the Inquiry Form action.
 * @author Teng Shyh Wei
 *
 */
public class InquiryForm_Action {	
	
	/**
	 * To verify RFI form is displayed. Verify that user's contact details are pre-populated.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIFormIsDisplayed_UserContactDetailsArePrepopulated(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataUsername) throws Exception{
				
		// To verify RFI form is displayed. 
		InquiryForm_Page.check_RFIFormIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that user's contact details are pre-populated
		InquiryForm_Page.check_userContactDetailsPrepopulated(xls, sheetName, rowNum, testFail, dataUsername);
		
	}
	
	/**
	 * To verify RFI form is displayed. Verify that user's contact details are not pre-populated. 
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_RFIFormIsDisplayed_UserContactDetailsNotPrepopulated(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify RFI form is displayed. 
		InquiryForm_Page.check_RFIFormIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify user's contact details are not pre-populated.
		InquiryForm_Page.check_userContactDetailsNotPrepopulated(xls, sheetName, rowNum, testFail);
		
	}	

	/**
	 * Fill In Subject until Message fields at Inquiry Form page.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void FillIn_SubjectUntilMessageFields(String dataSubject, String dataExpOrderQuantity,
			String dataRequestFor, String dataMessage) throws Exception{
		
		// Enter text for Subject field
		InquiryForm_Page.txtbx_enterSubject().sendKeys(dataSubject);

		// Enter text for Message field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Enter number for Expected Order Quantity
		InquiryForm_Page.txtbx_enterExpectedOrderQuantity().sendKeys(dataExpOrderQuantity);
		
		// Enter text for "Company Website URL" field.
	//	InquiryForm_Page.txtbx_enterCompWebsiteURL(dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL)
		
		// Select drop down list for EOQ's units of measurements.
	//	InquiryForm_Page.drpdwn_selectUnitOfMeasurement(dataUOM);
		
		// Click +More Options
	//	InquiryForm_Page.lnk_clickMoreOptions().click();
		
		// Select Request For checkboxes
	//	InquiryForm_Page.chkbx_selectRequestFor(dataRequestFor);
		    		    		    		    		    		    		
	}
	
	/**
	 * Fill In Inquire All checkboxes and remarks fields.
	 * 
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataInqAllRemarks
	 * @throws Exception
	 */
	public static void FillIn_InqAllChkbx_InqAllRemarks(String dataInqAllVerUpsell, String dataInqAllUnvUpsell,
			String dataInqAllRemarks) throws Exception{
		
		if(dataInqAllVerUpsell.equalsIgnoreCase("y")){	
			
			// Select Inquire All Verified upsell checkbox
			InquiryForm_Page.chkbx_selectInqAllVerUpsell(dataInqAllVerUpsell);
			
			// Select Inquire All Unverified upsell checkbox
			InquiryForm_Page.chkbx_selectInqAllUnvUpsell(dataInqAllUnvUpsell);
			
			// Fill in Inquiry all remarks field
			InquiryForm_Page.txtbx_enterInqAllRemarks().sendKeys(dataInqAllRemarks);
			
		}else{
			// do nothing.
		}		
	}
	
	/**
	 * Fill In Only Verified products Inquire All upsell checkbox and Inquiry all remarks field.
	 * 
	 * @param dataOnlyUnvInqAllUpsell
	 * @param dataInqAllRemarks
	 * @throws Exception
	 */
	public static void FillIn_OnlyUnvInqAllUpsell_InqAllRemarks(String dataOnlyVerInqAllUpsell,
			String dataInqAllRemarks) throws Exception{
		
		if(dataOnlyVerInqAllUpsell.equalsIgnoreCase("y")){

			// Select Only Verified products Inquire All upsell checkbox
			InquiryForm_Page.chkbx_selectOnlyVerInqAllUpsell(dataOnlyVerInqAllUpsell);
			
			// Fill in Inquiry all remarks field
			InquiryForm_Page.txtbx_enterInqAllRemarks().sendKeys(dataInqAllRemarks);
			
		}
	}
		
	/**
	 * Select one of the category under Inquire All dropdown list and enter text for Inquiry all remarks.
	 * 
	 * @param driver
	 * @param dataInqAllRemarks
	 * @throws Exception
	 */
	public static void FillIn_InqAllDrpdwnList_InqAllRemarks(WebDriver driver, String dataInqAllRemarks) throws Exception{
		
	//	driver.findElement(By.id("suppInqAllToggler")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='suppInqAllToggler']/option")));
		
		// Select one of the category under Inquire All dropdown list
		Select inqAllSelector = new Select(driver.findElement(By.id("suppInqAllToggler")));
    	inqAllSelector.selectByIndex(1);
    	
    	// Enter text for inquiry all remarks field
    	InquiryForm_Page.txtbx_enterInqAllRemarks().sendKeys(dataInqAllRemarks);
    	
	}
	
	/**
	 * Fill In Subject and Message fields only at Inquiry Form page. 
	 * 	 
	 * @param dataSubject
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void FillIn_SubjectAndMessageFieldsOnly(String dataSubject, String dataMessage) throws Exception{
		
		// Enter text for Subject field
		InquiryForm_Page.txtbx_enterSubject().sendKeys(dataSubject);
		
		// Enter text for Message field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);    		    		    		    		    		    
		
		// To switch back to default frame
	//	driver.switchTo().defaultContent();
		
	}
		
	// Fill in Subject, Message, Expected Order Quantity and Unit of Measurement.
	public static void FillIn_SubjectMessageEOQUOM(String dataSubject, String dataMessage, String dataEOQ,
			String dataUOM) throws Exception{
	
		// Enter text for Subject field
		InquiryForm_Page.txtbx_enterSubject().sendKeys(dataSubject);
		
		// Enter text for Message field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);    
		
		// Enter text for Expected Order Quantity
		InquiryForm_Page.txtbx_enterExpectedOrderQuantity().sendKeys(dataEOQ);
		
		// Select drop down list for Unit of Measurement
		InquiryForm_Page.drpdwn_selectUnitOfMeasurement(dataUOM);
		
	}
	
	/**
	 * Fill In Subject until Target Country fields at Inquiry Form page.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTargetCountry
	 * @throws Exception
	 */
	public static void FillIn_SubjectUntilTargetCountryFields(String dataSubject, String dataExpOrderQuantity,
			String dataRequestFor, String dataMessage, String dataTargetCountry) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Click More business details
		InquiryForm_Page.lnk_clickMoreBusinessDetails().click();
		
		// Enter text for Country in which product(s) will be sold field
		InquiryForm_Page.txtbx_enterTargetCountry().sendKeys(dataTargetCountry);
		
	}
	
	// Fill In Sample Details at Inquiry Form page.
	public static void FillIn_SampleDetailsFields(String dataNumOfSamples, String dataUOM,
			String dataSamplePayment, String dataSampleShipment) throws Exception{
		
		// Enter text for 'Number of Samples' field.
		InquiryForm_Page.txtbx_enterNumberOfSamples().sendKeys(dataNumOfSamples);
		
		// Select drop down list for EOQ's Unit of measurement.
		InquiryForm_Page.drpdwn_selectUnitOfMeasurement(dataUOM);
		
		// Select radio button for "I'll pay for the sample" field.
		InquiryForm_Page.radbtn_selectSamplePayment(dataSamplePayment);
		
		// Select radio button for "I'll pay for the shipment" field.
		InquiryForm_Page.radbtn_selectSampleShipment(dataSampleShipment);
		
	}
	
	/**
	 * Fill In Contact Details fields at Inquiry Form page.
	 * 
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @throws Exception
	 */
	public static void FillIn_ContactDetailsFields(String dataTitle, String dataFirstName, String dataLastName,
			String dataBusinessEmail, String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Select title from dropdown list
		InquiryForm_Page.drpdwn_selectTitle(dataTitle);
		
		// Enter text for First/Given Name field
		InquiryForm_Page.txtbx_enterFirstName().sendKeys(dataFirstName);
		
		// Enter text for Last/Family Name field
		InquiryForm_Page.txtbx_enterLastName().sendKeys(dataLastName);
		
		// Enter text for Business E-mail field
		InquiryForm_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Enter text for Company Name field
		InquiryForm_Page.txtbx_enterCompanyName().sendKeys(dataCompName);
		
		// Select Country/Territory
		InquiryForm_Page.drpdwn_selectCountryTerritory(dataCountryTerritory);		
		
		// Enter text for Business Contact Number  - Telephone Number
		InquiryForm_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(dataTelephoneNumber);
		
		// Enter text for "Company Website URL" field.
		InquiryForm_Page.txtbx_enterCompWebsiteURL(dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
				
	}
	
	/**
	 * Fill in Subject, Message and Contact Details fields at Inquiry Form page.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @throws Exception
	 */
	public static void FillIn_Subject_Message_ContactDetails(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataTitle, String dataFirstName, String dataLastName, 
			String dataBusinessEmail, String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Fill In Subject until Message fields at Inquiry Form page.
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, 
				dataRequestFor, dataMessage);
		
		// Fill In Contact Details fields at Inquiry Form page.
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail,
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
	}
	
	/**
	 * Fill in Subject, Message and Contact Details fields at Inquiry Form page.
	 * 
	 * @param dataSubject
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @throws Exception
	 */
	public static void FillIn_Subject_Message_ContactDetails(String dataSubject, String dataMessage, String dataTitle, 
			String dataFirstName, String dataLastName, String dataBusinessEmail, String dataCompName, 
			String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Fill In Subject and Message fields only at Inquiry Form page.
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
		
		// Fill In Contact Details fields in Inquiry Form page.
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
	}

	/**
	 * Fill in Subject, Message, EOQ, UOM and Contact Datails field at Inquiry Form page.
	 * 
	 * @param dataSubject
	 * @param dataMessage
	 * @param dataEOQ
	 * @param dataUOM
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @throws Exception
	 */
	public static void FillIn_SubjectMessageEOQ_ContactDetails(String dataSubject, String dataMessage, String dataEOQ, 
			String dataUOM, String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail,
			String dataCompName,  String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL,
			String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Fill in Subject, Message, Expected Order Quantity and Unit of Measurement.
		InquiryForm_Action.FillIn_SubjectMessageEOQUOM(dataSubject, dataMessage, dataEOQ, dataUOM);
		
		// Fill In Contact Details fields in Inquiry Form page.
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
	}
	
	// ======================================================= Start of Buyer Profile module ========================================================
	
	/**
	 * Fill in the 'Message' field and checked 'Remember my preference' checkbox.
	 * Applied to test case 26A.
	 * 
	 * @param dataMessage
	 * @param dataRmbMyPreference
	 * @throws Exception
	 */
	public static void FillInMessage_RememberMyPrefChkbx(String dataMessage, String dataRememberMyPref) throws Exception{
		
		// Enter text for 'Message' field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Select "Remember my preference" checkbox
		InquiryForm_Page.chkbx_selectRememberMyPreference(dataRememberMyPref);
		
	}	
	
	/**
	 * Fill in the 'Message', 'Number of Samples' field and unchecked the "Remember my preference" checkbox.
	 * Applied to test case 26F.
	 * 
	 * @param dataMessage
	 * @param dataNoOfSamples
	 * @throws Exception
	 */
	public static void FillInMessage_NoOfSamples_RememberMyPrefChkbx(String dataMessage, 
			String dataNoOfSamples, String dataRmbMyPreference) throws Exception{
		
		// Enter text for 'Message' field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Enter text for 'Number of Samples' field
		InquiryForm_Page.txtbx_enterNumberOfSamples().sendKeys(dataNoOfSamples);
		
		// Select "Remember my preference" checkbox
		InquiryForm_Page.chkbx_selectRememberMyPreference(dataRmbMyPreference);
		
	}
	
	/**
	 * Fill in the 'Message' field and click on 'Contact Supplier Now' button.
	 * Applied to test case 26B, 26C, 26D.
	 * 
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void FillInMessage_ClickContactSuppNowBtn(String dataMessage) throws Exception{
		
		// Enter text for 'Message' field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Click on the Contact Supplier Now button
		InquiryForm_Page.btn_clickContactSupplierNow();
		
	}	
	
	/**
	 * Fill in the 'Message' field, Select No option in the Buyer Profile section
	 * and click on 'Contact Supplier Now' button.
	 * Applied to test case 26E.
	 * 
	 * @param dataMessage
	 * @param dataBuyerProfile
	 * @throws Exception
	 */
	public static void FillInMessage_RadbtnBuyerProfile_ClickContactSuppNowBtn(String dataMessage, 
			String dataBuyerProfile) throws Exception{		
		
		// Enter text for 'Message' field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Select 'No, please do not send this time' option in the Buyer Profile section.
		InquiryForm_Page.radbtn_selectBuyerProfile(dataBuyerProfile);
		
		// Click on the Contact Supplier Now button
		InquiryForm_Page.btn_clickContactSupplierNow();
		
	}
	
	/**
	 * Fill in the 'Message', 'Number of Samples' fields and click on 'Contact Supplier Now' button.
	 * Applied to test case 26G, 26I, 26J.
	 * 
	 * @param dataMessage
	 * @param dataNoOfSamples
	 * @throws Exception
	 */
	public static void FillInMessage_NoOfSamples_ClickContactSuppNowBtn(String dataMessage, 
			String dataNoOfSamples) throws Exception{
		
		// Enter text for 'Message' field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Enter text for 'Number of Samples' field
		InquiryForm_Page.txtbx_enterNumberOfSamples().sendKeys(dataNoOfSamples);
		
		// Click on the Contact Supplier Now button
		InquiryForm_Page.btn_clickRFSContactSupplierNow();
		
	}
	
	/**
	 * Fill in the 'Message', 'Number of Samples' fields, Select No option in the Buyer Profile section
	 * and click on 'Contact Supplier Now' button.
	 * Applied to test case 26H.
	 * 
	 * @param dataMessage
	 * @param dataNoOfSamples
	 * @param dataBuyerProfile
	 * @throws Exception
	 */
	public static void FillInMsg_NoOfSamples_RadbtnBuyerProfile_ClickContactSuppNowBtn(String dataMessage, 
			String dataNoOfSamples, String dataBuyerProfile) throws Exception{		
		
		// Enter text for 'Message' field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Enter text for 'Number of Samples' field
		InquiryForm_Page.txtbx_enterNumberOfSamples().sendKeys(dataNoOfSamples);
		
		// Select 'No, please do not send this time' option in the Buyer Profile section.
		InquiryForm_Page.radbtn_selectBuyerProfile(dataBuyerProfile);
		
		// Click on the Contact Supplier Now button
		InquiryForm_Page.btn_clickContactSupplierNow();
		
	}
	
	// ======================================================== End of Buyer Profile module =========================================================
	
	// =================================================== Start of RFI Flow Logged-in User (LI1) ===================================================
	
	/**
	 * Inquiry form for 'inquire now' for single verified product from single category.
	 * Applied to test case 15A, 15B, 15D, 5I, 5M.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataInqAllRemarks
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI1_PdtInq_InqNow_SglVerPdt_SglCat_Info (String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataInqAllVerUpsell, String dataInqAllUnvUpsell, 
			String dataInqAllRemarks, String dataPAUpsell) throws Exception{		
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Fill in Inquiry All chkbx and remarks fields
		InquiryForm_Action.FillIn_InqAllChkbx_InqAllRemarks(dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsell(dataPAUpsell);
							
	}
	
	/**
	 * Inquiry form for 'inquire now' for multiple verified products from single category.
	 * Applied to test case 15C, 15E.
	 * 
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI1_PdtInq_InqNow_MulVerPdt_SglCat_Info (String dataInqAllVerUpsell, String dataInqAllUnvUpsell, 
			String dataSubject, String dataExpOrderQuantity, String dataRequestFor, String dataMessage, String dataPAUpsell) throws Exception{		
		
		// Select Inquire All Verified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllVerUpsell(dataInqAllVerUpsell);
		
		// Select Inquire All Unverified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllUnvUpsell(dataInqAllUnvUpsell);
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsell(dataPAUpsell);
							
	}
	
	/**
	 * Inquiry form for 'inquire now' for multiple verified products from multiple categories.
	 * Applied to test case 15F, 15G.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI1_PdtInq_InqNow_MulVerPdt_MulCat_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsell(dataPAUpsell);	
		
	}
	
	/**
	 * Inquiry form for 'inquire all' for multiple verified products from single category.
	 * Applied to test case 15H, 15I.
	 * 
	 * @param dataOnlyUnvInqAllUpsell
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI1_PdtInq_InqAll_MulVerPdt_SglCat_Info(String dataOnlyUnvInqAllUpsell, String dataSubject, 
			String dataExpOrderQuantity, String dataRequestFor, String dataMessage, String dataPAUpsell) throws Exception{		
		
		// Select Only Unverified products Inquire All upsell checkbox
		InquiryForm_Page.chkbx_selectOnlyUnvInqAllUpsell(dataOnlyUnvInqAllUpsell);
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsell(dataPAUpsell);		
					
	}
	
	/**
	 * Inquiry form for 'inquire now' for single unverified product.
	 * Applied to test case 15J, 15K.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataOnlyVerInqAllUpsell
	 * @param dataInqAllRemarks
	 * @throws Exception
	 */
	public static void ExecuteLI1_PdtInq_InqNow_SglUnvPdt_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataOnlyVerInqAllUpsell, 
			String dataInqAllRemarks) throws Exception{		
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);	
					
		// Fill In Only Verified products Inquire All upsell checkbox and Inquiry all remarks field.
		InquiryForm_Action.FillIn_OnlyUnvInqAllUpsell_InqAllRemarks(dataOnlyVerInqAllUpsell, dataInqAllRemarks);
		
	}		
		
	/**
	 * Inquiry form for 'inquire now' for single verified supplier.
	 * Applied to test case 15O.
	 * 
	 * @param driver
	 * @param dataSubject
	 * @param dataMessage
	 * @param dataInqAllRemarks
	 * @throws Exception
	 */
	public static void ExecuteLI1_SuppInq_InqNow_SglVerSupp_InqAllDrpdwnSelected(WebDriver driver, String dataSubject, 
			String dataMessage, String dataInqAllRemarks) throws Exception{				

		// Fill In Subject and Message fields only
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
		
		// Select one of the category under Inquire All dropdown list and enter text for Inquiry all remarks field
		InquiryForm_Action.FillIn_InqAllDrpdwnList_InqAllRemarks(driver, dataInqAllRemarks);
				    	        						
	}
	
	// ==================================================== End of RFI Flow Logged-in User (LI1) ====================================================
	
	// =================================================== Start of RFI Flow Login on Form (LI2) ====================================================
	
	/**
	 * Inquiry form for 'inquire now' for single verified product from single category.
	 * Applied to test case 13A, 13B, 13C
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTargetCountry
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataInqAllRemarks
	 * @throws Exception
	 */
	public static void ExecuteLI2_PdtInq_InqNow_SglVerPdt_SglCat_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataTargetCountry, String dataInqAllVerUpsell, 
			String dataInqAllUnvUpsell, String dataInqAllRemarks) throws Exception{		
		
		// Fill In Subject until Target Country fields
		InquiryForm_Action.FillIn_SubjectUntilTargetCountryFields(dataSubject, dataExpOrderQuantity, 
				dataRequestFor, dataMessage, dataTargetCountry);
		
		// Fill in Inquiry All chkbx and remarks fields
		InquiryForm_Action.FillIn_InqAllChkbx_InqAllRemarks(dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks);
							
	}
	
	/**
	 * Inquiry form for 'inquire now' for multiple verified product from single category.
	 * Applied to test case 13D, 13E.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataTargetCountry
	 * @throws Exception
	 */
	public static void ExecuteLI2_PdtInq_InqNow_MulVerPdt_SglCat_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataInqAllVerUpsell, String dataInqAllUnvUpsell, 
			String dataTargetCountry) throws Exception{		
		
		// Fill In Subject until Target Country fields
		InquiryForm_Action.FillIn_SubjectUntilTargetCountryFields(dataSubject, dataExpOrderQuantity, 
				dataRequestFor, dataMessage, dataTargetCountry);
		
		// Select Inquire All Verified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllVerUpsell(dataInqAllVerUpsell);
		
		// Select Inquire All Unverified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllUnvUpsell(dataInqAllUnvUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire all' for multiple verified products from single category.
	 * Applied to test case 13H, 13I.
	 * 
	 * @param dataOnlyUnvInqAllUpsell
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTargetCountry
	 * @throws Exception
	 */
	public static void ExecuteLI2_PdtInq_InqAll_MulVerPdt_SglCat_Info(String dataOnlyUnvInqAllUpsell, String dataSubject, 
			String dataExpOrderQuantity, String dataRequestFor, String dataMessage, String dataTargetCountry) throws Exception{		
		
		// Select Only Unverified products Inquire All upsell checkbox
		InquiryForm_Page.chkbx_selectOnlyUnvInqAllUpsell(dataOnlyUnvInqAllUpsell);
		
		// Fill In Subject until Target Country fields
		InquiryForm_Action.FillIn_SubjectUntilTargetCountryFields(dataSubject, dataExpOrderQuantity, 
				dataRequestFor, dataMessage, dataTargetCountry);	
					
	}
	
	/**
	 * Inquiry form for 'inquire now' for single unverified product.
	 * Applied to test case 13J, 13K.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataOnlyVerInqAllUpsell
	 * @param dataInqAllRemarks
	 * @param dataTargetCountry
	 * @throws Exception
	 */
	public static void ExecuteLI2_PdtInq_InqNow_SglUnvPdt_Info(String dataSubject, String dataExpOrderQuantity, String dataRequestFor, 
			String dataMessage, String dataOnlyVerInqAllUpsell, String dataInqAllRemarks, String dataTargetCountry) throws Exception{		
		
		// Fill In Subject until Target Country fields
		InquiryForm_Action.FillIn_SubjectUntilTargetCountryFields(dataSubject, dataExpOrderQuantity, 
				dataRequestFor, dataMessage, dataTargetCountry);
		
		// Fill In Only Verified products Inquire All upsell checkbox and Inquiry all remarks field.
		InquiryForm_Action.FillIn_OnlyUnvInqAllUpsell_InqAllRemarks(dataOnlyVerInqAllUpsell, dataInqAllRemarks);
		
	}
	
	/**
	 * Inquiry form for 'inquire now' for single verified supplier.
	 * Applied to test case 13O.
	 * 
	 * @param driver
	 * @param dataSubject
	 * @param dataMessage
	 * @param dataInqAllRemarks
	 * @throws Exception
	 */
	public static void ExecuteLI2_SuppInq_InqNow_SglVerSupp_InqAllDrpdwnSelected(WebDriver driver, String dataSubject, 
			String dataMessage, String dataInqAllRemarks) throws Exception{				
    	
		// Fill In Subject and Message fields only
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
		
		// Select one of the category under Inquire All dropdown list and enter text for Inquiry all remarks field
		InquiryForm_Action.FillIn_InqAllDrpdwnList_InqAllRemarks(driver, dataInqAllRemarks);
					
	}
	
	// ==================================================== End of RFI Flow Login on Form (LI2) =====================================================
	
	// ===================================================== Start of RFI Flow Post Login (LI3) =====================================================
	
	/**
	 * Inquiry form for 'inquire now' for single verified product from single category.
	 * Applied to test case 14A, 14B, 14D.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataInqAllRemarks
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI3_PdtInq_InqNow_SglVerPdt_SglCat_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataInqAllVerUpsell, String dataInqAllUnvUpsell, 
			String dataInqAllRemarks, String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail, 
			String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL,
			String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Fill in Inquiry All chkbx and remarks fields
		InquiryForm_Action.FillIn_InqAllChkbx_InqAllRemarks(dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks);
	
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
				
		// Close the login overlay
		MiniLogin_Page.icon_clickCloseBtn();
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire now' for multiple verified products from single category. 
	 * Applied to test case 14C, 14E.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI3_PdtInq_InqNow_MulVerPdt_SglCat_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataInqAllVerUpsell, String dataInqAllUnvUpsell, 
			String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail, String dataCompName,
			String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Select Inquire All Verified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllVerUpsell(dataInqAllVerUpsell);
		
		// Select Inquire All Unverified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllUnvUpsell(dataInqAllUnvUpsell);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Close the login overlay
		MiniLogin_Page.icon_clickCloseBtn();
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire now' for multiple verified products from multiple categories.
	 * Applied to test case 14F, 14G.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI3_PdtInq_InqNow_MulVerPdt_MulCat_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataTitle, String dataFirstName, String dataLastName,
			String dataBusinessEmail, String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message, and Contact Details fields
		InquiryForm_Action.FillIn_Subject_Message_ContactDetails(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage, 
				dataTitle, dataFirstName, dataLastName, dataBusinessEmail, dataCompName, dataCountryTerritory, dataTelephoneNumber,
				dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);	
				
		// Close the login overlay
		MiniLogin_Page.icon_clickCloseBtn();
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire all' for multiple verified products.
	 * Applied to test case 14H, 14I.
	 * 
	 * @param dataOnlyUnvInqAllUpsell
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteLI3_PdtInq_InqAll_MulVerPdt_Info(String dataOnlyUnvInqAllUpsell, String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail, 
			String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Select Only Unverified products Inquire All upsell checkbox
		InquiryForm_Page.chkbx_selectOnlyUnvInqAllUpsell(dataOnlyUnvInqAllUpsell);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);	
				
		// Close the login overlay
		MiniLogin_Page.icon_clickCloseBtn();
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire now' for single unverified product.
	 * Applied to test case 14J, 14K.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataOnlyVerInqAllUpsell
	 * @param dataInqAllRemarks
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @throws Exception
	 */
	public static void ExecuteLI3_PdtInq_InqNow_SglUnvPdt_Info(String dataSubject, String dataExpOrderQuantity, String dataRequestFor, 
			String dataMessage, String dataOnlyVerInqAllUpsell, String dataInqAllRemarks, String dataTitle, String dataFirstName, 
			String dataLastName, String dataBusinessEmail, String dataCompName, String dataCountryTerritory, 
			String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Fill In Only Verified products Inquire All upsell checkbox and Inquiry all remarks field.
		InquiryForm_Action.FillIn_OnlyUnvInqAllUpsell_InqAllRemarks(dataOnlyVerInqAllUpsell, dataInqAllRemarks);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
	}
		
	/**
	 * Inquiry form for 'inquire now' for single verified supplier.
	 * Applied to test case 14O.
	 * 
	 * @param driver
	 * @param dataSubject
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @throws Exception
	 */
	public static void ExecuteLI3_SuppInq_InqNow_SglVerSupp_InqAllDrpdwnSelected(WebDriver driver, String dataSubject, String dataMessage, 
			String dataInqAllRemarks, String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail, 
			String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL,
			String dataTxtbxCompWebsiteURL) throws Exception{
				
		// Fill In Subject and Message fields
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);

		// Select one of the category under Inquire All dropdown list and enter text for Inquiry all remarks field
		InquiryForm_Action.FillIn_InqAllDrpdwnList_InqAllRemarks(driver, dataInqAllRemarks);
    	
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
	}	
	
	// ====================================================== End of RFI Flow Post Login (LI3) ======================================================	

	// ====================================================== Start of RFI Flow New User (NL1) ======================================================
	
	/**
	 * Inquiry form for 'inquire now' for single verified product from single category. 
	 * Applied to test case 12A, 12B.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataInqAllRemarks
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteNL1_PdtInq_InqNow_SglVerPdt_SglCat_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataInqAllVerUpsell, String dataInqAllUnvUpsell, 
			String dataInqAllRemarks, String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail, 
			String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Fill in Inquiry All chkbx and remarks fields
		InquiryForm_Action.FillIn_InqAllChkbx_InqAllRemarks(dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire now' for multiple verified products from single category. 
	 * Applied to test case 12C.
	 * 
	 * @param dataInqAllVerUpsell
	 * @param dataInqAllUnvUpsell
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteNL1_PdtInq_InqNow_MulVerPdt_SglCat_Info(String dataInqAllVerUpsell, String dataInqAllUnvUpsell, 
			String dataSubject, String dataExpOrderQuantity, String dataRequestFor, String dataMessage, String dataTitle, 
			String dataFirstName, String dataLastName, String dataBusinessEmail, String dataCompName, String dataCountryTerritory, 
			String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Select Inquire All Verified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllVerUpsell(dataInqAllVerUpsell);
		
		// Select Inquire All Unverified upsell checkbox
		InquiryForm_Page.chkbx_selectInqAllUnvUpsell(dataInqAllUnvUpsell);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
	}
	
	/**
	 * Inquiry form for 'inquire now' for multiple verified products from multiple categories. 
	 * Applied to test case 12D, 12E.
	 * 
	 * @param dataCcEmailAddress
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteNL1_PdtInq_InqNow_MulVerPdt_MulCat_Info(String dataCcEmailAddress, String dataSubject, 
			String dataExpOrderQuantity, String dataRequestFor, String dataMessage, String dataTitle, 
			String dataFirstName, String dataLastName, String dataBusinessEmail, String dataCompName, 
			String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{		
		
		// Select Cc Email Address checkbox
		InquiryForm_Page.chkbx_selectCCEmailAddress(dataCcEmailAddress);
		
		// Fill in Subject until Message fields, and Contact Details fields
		InquiryForm_Action.FillIn_Subject_Message_ContactDetails(dataSubject, dataExpOrderQuantity, dataRequestFor, 
				dataMessage, dataTitle, dataFirstName, dataLastName, dataBusinessEmail, dataCompName, dataCountryTerritory,
				dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire all' for multiple verified products from single category. 
	 * Applied to test case 12F, 12G.
	 * 
	 * @param dataOnlyUnvInqAllUpsell
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteNL1_PdtInq_InqAll_MulVerPdt_SglCat_Info(String dataOnlyUnvInqAllUpsell, String dataSubject, 
			String dataExpOrderQuantity, String dataRequestFor, String dataMessage, String dataTitle, 
			String dataFirstName, String dataLastName, String dataBusinessEmail, String dataCompName, 
			String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Select Only Unverified products Inquire All upsell checkbox
		InquiryForm_Page.chkbx_selectOnlyUnvInqAllUpsell(dataOnlyUnvInqAllUpsell);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
	}
	
	/**
	 * Inquiry form for 'inquire now' for single unverified product. 
	 * Applied to test case 12H, 12I.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataOnlyVerInqAllUpsell
	 * @param dataInqAllRemarks
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @throws Exception
	 */
	public static void ExecuteNL1_PdtInq_InqNow_SglUnvPdt_Info(String dataSubject, String dataExpOrderQuantity, 
			String dataRequestFor, String dataMessage, String dataOnlyVerInqAllUpsell, String dataInqAllRemarks, 
			String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail, String dataCompName, 
			String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL) throws Exception{	
		
		// Fill in Subject until Message fields
		InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		
		// Fill In Only Verified products Inquire All upsell checkbox and Inquiry all remarks field.
		InquiryForm_Action.FillIn_OnlyUnvInqAllUpsell_InqAllRemarks(dataOnlyVerInqAllUpsell, dataInqAllRemarks);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
	}	
	
	/**
	 * Inquiry form for 'inquire now' for single verified supplier. 
	 * Applied to test case 12M.
	 * 
	 * @param driver
	 * @param dataSubject
	 * @param dataMessage
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @param dataRadbtnCompWebsiteURL
	 * @param dataTxtbxCompWebsiteURL
	 * @throws Exception
	 */
	public static void ExecuteNL1_SuppInq_InqNow_SglVerSupp_InqAllDrpdwnSelected(WebDriver driver, String dataSubject, 
			String dataMessage, String dataInqAllRemarks, String dataTitle, String dataFirstName, String dataLastName, 
			String dataBusinessEmail, String dataCompName, String dataCountryTerritory, String dataTelephoneNumber,
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Fill In Subject and Message fields
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
		
		// Select one of the category under Inquire All dropdown list and enter text for Inquiry all remarks field
		InquiryForm_Action.FillIn_InqAllDrpdwnList_InqAllRemarks(driver, dataInqAllRemarks);
    	
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
    	
	}
	
	
	// ======================================================== End of RFI Flow New User (NL1) ======================================================

	// ========================================================== Start of chkbc verification =======================================================
	
	// RFQ upsell and PA upsell chkbx is available on the page
	public static void check_RFQUpsellPAUpsellChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To check RFQ upsell chkbx is available on the page.
		InquiryForm_Page.check_RFQUpsellChkbxExists(xls, sheetName, rowNum, testFail);
		
		// To check PA upsell checkbox is available on the page.
		InquiryForm_Page.check_PAUpsellChkbxExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form both Inquire All upsell, PA upsell chkbx is available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_bothInqAll_PAUpsellChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To check Verified products Inquire All upsell checkbox is available on the page.
		InquiryForm_Page.check_inqAllVerChkbxExists(xls, sheetName, rowNum, testFail);
    	
    	// To check Unverified products Inquire All upsell checkbox is available on the page.
		InquiryForm_Page.check_inqAllUnvChkbxExists(xls, sheetName, rowNum, testFail);
    	
    	// To verify CC Email Address checkbox is not available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxNotExists(xls, sheetName, rowNum, testFail);
    	
    	// To verify PA upsell checkbox is available on the page.
		InquiryForm_Page.check_PAUpsellChkbxExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form both Inquire All upsell, PA upsell chkbx is selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_bothInqAll_PAUpsellChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To check Verified products Inquire All upsell checkbox is selected.
		InquiryForm_Page.check_inqAllVerChkbxSelected(xls, sheetName, rowNum, testFail);    		
		
		// To check Unverified products Inquire All upsell checkbox is selected.
		InquiryForm_Page.check_inqAllUnvChkbxSelected(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is selected.
		InquiryForm_Page.check_PAUpsellChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form both Inquire All upsell chkbx is selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_bothInqAllUpsellChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To check Verified products Inquire All upsell checkbox is selected.
		InquiryForm_Page.check_inqAllVerChkbxSelected(xls, sheetName, rowNum, testFail);    		
		
		// To check Unverified products Inquire All upsell checkbox is selected.
		InquiryForm_Page.check_inqAllUnvChkbxSelected(xls, sheetName, rowNum, testFail);
	}
	
	/**
	 * Inquiry Form both Inquire All upsell chkbx is remain selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_bothInqAllUpsellChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To check Verified products Inquire All upsell checkbox is remain selected.
    	InquiryForm_Page.check_inqAllVerChkbxRemainSelected(xls, sheetName, rowNum, testFail);
		
		// To check Unverified products Inquire All upsell checkbox is remain selected.
    	InquiryForm_Page.check_inqAllUnvChkbxRemainSelected(xls, sheetName, rowNum, testFail);
    	
	}
	
	/**
	 * Inquiry Form both Inquire All upsell, PA upsell chkbx is not selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_bothInqAll_PAUpsellChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To check Verified products Inquire All upsell checkbox is not selected.
		InquiryForm_Page.check_inqAllVerChkbxNotSelected(xls, sheetName, rowNum, testFail);    		
		
		// To check Unverified products Inquire All upsell checkbox is not selected.
		InquiryForm_Page.check_inqAllUnvChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
		// To verify PA upsell checkbox is not selected.
    	InquiryForm_Page.check_PAUpsellChkbxNotSelected(xls, sheetName, rowNum, testFail);
    	
	}
	
	/**
	 * Inquiry Form Cc Email Address, PA upsell chkbx is available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_CcEmailAddr_PAUpsellChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To check Verified products Inquire All upsell checkbox is not available on the page.
		InquiryForm_Page.check_inqAllVerChkbxNotExists(xls, sheetName, rowNum, testFail);
    	
    	// To check Unverified products Inquire All upsell checkbox is not available on the page.
		InquiryForm_Page.check_inqAllUnvChkbxNotExists(xls, sheetName, rowNum, testFail);

		// To verify CC Email Address checkbox is available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is available on the page.
		InquiryForm_Page.check_PAUpsellChkbxExists(xls, sheetName, rowNum, testFail);			
		
	}
	
	/**
	 * Inquiry Form Cc Email Address, PA upsell chkbx is selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_CcEmailAddr_PAUpsellChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify CC Email Address checkbox is selected.
		InquiryForm_Page.check_ccEmailAddrChkbxSelected(xls, sheetName, rowNum, testFail);
		
		// To verify PA upsell checkbox is selected.
		InquiryForm_Page.check_PAUpsellChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form Cc Email Address, PA upsell chkbx is not selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_CcEmailAddr_PAUpsellChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify CC Email Address checkbox is not selected.
		InquiryForm_Page.check_ccEmailAddrChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
		// To verify PA upsell checkbox is not selected.
		InquiryForm_Page.check_PAUpsellChkbxNotSelected(xls, sheetName, rowNum, testFail);	
		
	}
	
	/**
	 * Inquiry Form Only Unverified Inquire All, PA upsell chkbx is available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_onlyUnvInqAll_PAUpsellChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Only Unverified products Inquire All upsell checkbox is available on the page.
		InquiryForm_Page.check_onlyUnvInqAllChkbxExists(xls, sheetName, rowNum, testFail);			

		// To verify CC Email Address checkbox is not available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxNotExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is available on the page.
		InquiryForm_Page.check_PAUpsellChkbxExists(xls, sheetName, rowNum, testFail);			
		
	}
	
	/**
	 * Inquiry Form Only Unverified Inquire All, PA upsell chkbx is selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_onlyUnvInqAll_PAUpsellChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify Only Unverified products Inquire All upsell checkbox is selected.
		InquiryForm_Page.check_onlyUnvInqAllChkbxSelected(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is selected.
		InquiryForm_Page.check_PAUpsellChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form Only Unverified Inquire All chkbx selected, PA upsell chkbx not selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_onlyUnvInqAllChkbxSelected_PAUpsellChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// To verify Only Unverified products Inquire All upsell checkbox is selected.
		InquiryForm_Page.check_onlyUnvInqAllChkbxSelected(xls, sheetName, rowNum, testFail);    		
		
		// To verify PA upsell checkbox is not selected.
		InquiryForm_Page.check_PAUpsellChkbxNotSelected(xls, sheetName, rowNum, testFail);	
		
	}
	
	/**
	 * Inquiry Form Only Verified Inquire All upsell chkbx is available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_onlyVerInqAllChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Only Verified products Inquire All upsell checkbox is available on the page.
		InquiryForm_Page.check_onlyVerInqAllChkbxExists(xls, sheetName, rowNum, testFail);					
		
		// To verify CC Email Address checkbox is not available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxNotExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is not available on the page.
		InquiryForm_Page.check_PAUpsellChkbxNotExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form all chkbx are not available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_allChkbxNotExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To check Verified products Inquire All upsell checkbox is not available on the page.
		InquiryForm_Page.check_inqAllVerChkbxNotExists(xls, sheetName, rowNum, testFail);

		// To check Unverified products Inquire All upsell checkbox is not available on the page.
		InquiryForm_Page.check_inqAllUnvChkbxNotExists(xls, sheetName, rowNum, testFail);

		// To verify CC Email Address checkbox is not available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxNotExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is not available on the page.
		InquiryForm_Page.check_PAUpsellChkbxNotExists(xls, sheetName, rowNum, testFail);	
		
	}
	
	/**
	 * Inquiry Form Inquire All upsell drpdwn list, Cc Email Address chkbx is available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_drpdwnInqAllUpsell_CcEmailAddChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Inquire All upsell drop-down list is available on the page.
		InquiryForm_Page.check_inqAllUpsellDrpdwnExists(xls, sheetName, rowNum, testFail);

		// To verify CC Email Address checkbox is available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is not available on the page.
		InquiryForm_Page.check_PAUpsellChkbxNotExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form Inquire All upsell drpdwn list is selected, Cc Email Address chkbx is removed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_drpdwnInqAllUpsellSelected_CcEmailAddChkbcRemoved(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify category under Inquire All upsell drop-down list is selected
		InquiryForm_Page.check_inqAllUpsellDrpdwnSelected(xls, sheetName, rowNum, testFail);
		
		// To verify CC Email Address checkbox is not available (removed) on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxRemoved(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * Inquiry Form only Cc Email Address Chkbx is available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_onlyCcEmailAddrChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Inquire All upsell drop-down list is not available on the page.
		InquiryForm_Page.check_inqAllUpsellDrpdwnNotExists(xls, sheetName, rowNum, testFail); 

		// To verify CC Email Address checkbox is available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is not available on the page.
		InquiryForm_Page.check_PAUpsellChkbxNotExists(xls, sheetName, rowNum, testFail);	
		
	}
	
	/**
	 * Inquiry Form all drpdwn list and chkbx are not available on the page.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_allDrpdwnChkbxNotExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Inquire All upsell drop-down list is not available on the page.
		InquiryForm_Page.check_inqAllUpsellDrpdwnNotExists(xls, sheetName, rowNum, testFail);    		    		
    	
    	// To check CC Email Address checkbox is not available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxNotExists(xls, sheetName, rowNum, testFail);    		   
    	
    	// To verify PA upsell checkbox is not available on the page.
		InquiryForm_Page.check_PAUpsellChkbxNotExists(xls, sheetName, rowNum, testFail); 
		
	}	
	
	/**
	 * RFS Form - CC Email Address chkbx and PA upsell chkbx is available on the page.
	 * Applied to test case 25A, 25B.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataUsername
	 * @throws Exception
	 */
	public static void check_userPrepopulate_CcEmailAddr_PAUpsellChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataUsername) throws Exception{
		
		// To verify user's contact details are pre-populated
		InquiryForm_Page.check_userContactDetailsPrepopulated(xls, sheetName, rowNum, testFail, dataUsername);
		
		// To verify CC Email Address checkbox is available on the page.
		InquiryForm_Page.check_ccEmailAddrChkbxExists(xls, sheetName, rowNum, testFail);

		// To verify PA upsell checkbox is available on the page.
		InquiryForm_Page.check_PAUpsellChkbxExists(xls, sheetName, rowNum, testFail);		
		
	}
	
	// ========================================================= End of chkbx verification ==========================================================
	
	// =========================================================== Start of RFS Form flow ===========================================================
	
	// RFS Flow - Enter some texts in "Subject", "Message" and "Number of Samples" fields.
	public static void ExecuteRFS_FillIn_SubjectMessageAndNumOfSamples(String dataSubject, 
			String dataMessage, String dataNumOfSamples) throws Exception{
		
		// Enter text for Subject field
		InquiryForm_Page.txtbx_enterSubject().sendKeys(dataSubject);
		
		// Enter text for Message field
		InquiryForm_Page.txtbx_enterMessage().sendKeys(dataMessage); 
		
		// Enter text for 'Number of Samples' field.
		InquiryForm_Page.txtbx_enterNumberOfSamples().sendKeys(dataNumOfSamples);
		
	}	
	
	/**
	 * RFS Flow - Fill in all the relevant fields and uncheck the PA upsell checkbox.
	 * Applied to test case 25A, 25B.
	 * 
	 * @param dataSubject
	 * @param dataExpOrderQuantity
	 * @param dataRequestFor
	 * @param dataMessage
	 * @param dataNumberOfSamples
	 * @param dataPAUpsell
	 * @throws Exception
	 */
	public static void ExecuteRFS_FillIn_InquiryForm(String dataSubject, String dataMessage, String dataNumOfSamples, String dataUOM,
			String dataSamplePayment, String dataSampleShipment, String dataRFQUpsell, String dataPAUpsell) throws Exception{
		
		// Fill in Subject and Message fields
	//	InquiryForm_Action.FillIn_SubjectUntilMessageFields(dataSubject, dataExpOrderQuantity, dataRequestFor, dataMessage);
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
		
		// Fill in Sample Details fields
	//	InquiryForm_Page.txtbx_enterNumberOfSamples().sendKeys(dataNumberOfSamples);
		InquiryForm_Action.FillIn_SampleDetailsFields(dataNumOfSamples, dataUOM, dataSamplePayment, dataSampleShipment);
		
		// Select RFQ upsell checkbox
		InquiryForm_Page.chkbxSelectRFQ(dataRFQUpsell);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsell(dataPAUpsell);
		
	}
	
	// RFS Flow - Fill in all the relevant fields (Post Login)
	public static void ExecuteRFS_FillInAllTheRelevantFields(String dataSubject, String dataMessage, String dataNumOfSamples, String dataUOM,
			String dataSamplePayment, String dataSampleShipment, String dataTitle, String dataFirstName, String dataLastName, 
			String dataBusinessEmail, String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL, String dataRFQUpsell, String dataPAUpsell) throws Exception{
		
		// Fill in Subject and Message fields
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
		
		// Fill in Sample Details fields
		InquiryForm_Action.FillIn_SampleDetailsFields(dataNumOfSamples, dataUOM, dataSamplePayment, dataSampleShipment);
		
		// Fill in Your Contact Details to Supplier fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Close the login overlay
		MiniLogin_Page.icon_clickCloseBtn();
		
		// Select RFQ upsell checkbox
		InquiryForm_Page.chkbxSelectRFQ(dataRFQUpsell);
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsell(dataPAUpsell);
		
	}
	
	// ========================================================= Start of RFI Static Form  ==========================================================
	
	/**
	 * RFI form from Static Form - Fill in some text in the RFI static form and click on the 'Continue' button. 
	 * Applied to test case 1067 / 11C.
	 * 
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void ExecuteRFIStaticForm_EnterMessage_ClickContinueBtn(String dataMessage) throws Exception{
		
	    // Enter text at RFI Inquiry Message field
		SupplierHome_Page.txtbx_enterMsgAtRFIStaticForm().sendKeys(dataMessage);
		
		// Click on 'Continue' button
		SupplierHome_Page.btn_clickContinue().click();
		
	}
	
	// RFI form is displayed. The text entered in RFI static form are remain in the message field.
	public static void check_RFIFormDisplayed_TextEnteredInRFIStaticFormRemainUnchanged(Read_XLS xls, String sheetName, 
			int rowNum, List<Boolean> testFail, String dataMessage) throws Exception{
		
		// To verify RFI form is displayed. 
		InquiryForm_Page.check_RFIFormIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify the text entered in RFI static form are remain in the Message field
		InquiryForm_Page.check_textEnteredInRFIStaticFormRemainUnchanged(xls, sheetName, rowNum, testFail, dataMessage);
		
	}	
	
	// RFI form is displayed. Verify that user's contact details are pre-populated. The text entered in RFI static form are remain in the message field.
	public static void check_RFIFormDisplayed_TextEnteredInRFIStaticFormRemainUnchanged(Read_XLS xls, String sheetName, 
			int rowNum, List<Boolean> testFail, String dataUsername, String dataMessage) throws Exception{
		
		// To verify RFI form is displayed. Verify that user's contact details are pre-populated
		InquiryForm_Action.check_RFIFormIsDisplayed_UserContactDetailsArePrepopulated(xls, sheetName, rowNum, testFail, dataUsername);
		
		// To verify the text entered in RFI static form are remain in the Message field
		InquiryForm_Page.check_textEnteredInRFIStaticFormRemainUnchanged(xls, sheetName, rowNum, testFail, dataMessage);
		
	}
	
	// RFI form from Static Form - Fill in all the relevant fields
	public static void ExecuteRFIStaticForm_FillInAllTheRelevantFields(String dataSubject, String dataExpOrderQuantity, String dataUOM,
			String dataInqAllVerUpsell, String dataInqAllUnvUpsell, String dataInqAllRemarks, String dataTitle, String dataFirstName, 
			String dataLastName, String dataBusinessEmail, String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL, String dataPAUpsell) throws Exception{
				
		// Enter text for Subject field
		InquiryForm_Page.txtbx_enterSubject().sendKeys(dataSubject);

		// Enter number for Expected Order Quantity
		InquiryForm_Page.txtbx_enterExpectedOrderQuantity().sendKeys(dataExpOrderQuantity);
		
		// Select drop down list for EOQ's Unit of measurement
		InquiryForm_Page.drpdwn_selectUnitOfMeasurement(dataUOM);
		
		// Fill in Inquiry All chkbx and remarks fields
		InquiryForm_Action.FillIn_InqAllChkbx_InqAllRemarks(dataInqAllVerUpsell, dataInqAllUnvUpsell, dataInqAllRemarks);
	
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
				
		// Close the login overlay
		MiniLogin_Page.icon_clickCloseBtn();
		
		// Select PA upsell checkbox
		InquiryForm_Page.chkbx_selectPAUpsellBox(dataPAUpsell);
		
		// Click on 'Continue to Next Step' button.
		InquiryForm_Page.btn_clickContinueToNextStep().click();
		
	}
	
	// RFI form from Static Form - Fill in all the relevant fields (Unverified Supplier PP page)
	public static void ExecuteRFIStaticForm_FillInAllTheRelevantFields(String dataSubject, String dataExpOrderQuantity,
			String dataUOM, String dataTitle, String dataFirstName, String dataLastName, String dataBusinessEmail,
			String dataCompName, String dataCountryTerritory, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL,
			String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Enter text for Subject field
		InquiryForm_Page.txtbx_enterSubject().sendKeys(dataSubject);

		// Enter number for Expected Order Quantity
		InquiryForm_Page.txtbx_enterExpectedOrderQuantity().sendKeys(dataExpOrderQuantity);
		
		// Select drop down list for EOQ's Unit of measurement
		InquiryForm_Page.drpdwn_selectUnitOfMeasurement(dataUOM);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
				
		// Close the login overlay
		MiniLogin_Page.icon_clickCloseBtn();
		
		// Click on 'Continue to Next Step' button.
		InquiryForm_Page.btn_clickContinueToNextStep().click();
		
	}
	
	// RFI form from Static Form - Fill in all the relevant fields (Company Profile page)
	public static void ExecuteRFIStaticForm_FillInAllTheRelevantFields(String dataSubject, String dataTitle, String dataFirstName,
			String dataLastName, String dataBusinessEmail, String dataCompName, String dataCountryTerritory, String dataTelephoneNumber,
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Enter text for Subject field
		InquiryForm_Page.txtbx_enterSubject().sendKeys(dataSubject);
		
		// Fill In Contact Details fields
		InquiryForm_Action.FillIn_ContactDetailsFields(dataTitle, dataFirstName, dataLastName, dataBusinessEmail, 
				dataCompName, dataCountryTerritory, dataTelephoneNumber, dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Click on 'Continue to Next Step' button.
		InquiryForm_Page.btn_clickContinueToNextStep().click();
		
	}
	
	
	
	// ========================================================== End of RFI Static Form  ===========================================================
	
	// ======================================================== Start of RFI Floating Window ========================================================
	
	/**
	 * RFI Form from Floating Window - Fill in some text in the RFI floating window and click on the 'Continue' button.
	 * Applied to test case 1067 / 11C.
	 * 
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void ExecuteRFIFloatingWindow_EnterMessage_ClickContinueBtn(String dataMessage) throws Exception{
		
		// Enter text at RFI Floating Window Inquiry Message field
		ProductProfile_Page.txtbx_enterMessageInRFIFloatingWindow().sendKeys(dataMessage);
		
		// Click on the "Continue" button at RFI Floating Window Inquiry Message field
		ProductProfile_Page.btn_clickContinueAtRFIFloatingWindow().click();
		
	}
	
	// RFI form is displayed. The text entered in RFI floating window are remain in the message field.
	public static void check_RFIFormDisplayed_TextEnteredInRFIFloatingWindowRemainUnchanged(Read_XLS xls, String sheetName, 
			int rowNum, List<Boolean> testFail, String dataMessage) throws Exception{
		
		// To verify RFI form is displayed. 
		InquiryForm_Page.check_RFIFormIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify the text entered in RFI floating window are remain in the Message field
		InquiryForm_Page.check_textEnteredInRFIFloatingWindowRemainUnchanged(xls, sheetName, rowNum, testFail, dataMessage);
		
	}
	
	// RFI form is displayed. Verify that user's contact details are pre-populated. The text entered in RFI floating window are remain in the message field.
	public static void check_RFIFormDisplayed_TextEnteredInRFIFloatingWindowRemainUnchanged(Read_XLS xls, String sheetName, 
			int rowNum, List<Boolean> testFail, String dataUsername, String dataMessage) throws Exception{
		
		// To verify RFI form is displayed. Verify that user's contact details are pre-populated
		InquiryForm_Action.check_RFIFormIsDisplayed_UserContactDetailsArePrepopulated(xls, sheetName, rowNum, testFail, dataUsername);
		
		// To verify the text entered in RFI floating window are remain in the Message field
		InquiryForm_Page.check_textEnteredInRFIFloatingWindowRemainUnchanged(xls, sheetName, rowNum, testFail, dataMessage);
		
	}
	
	// ========================================================= End of RFI Floating Window =========================================================	
	
	// ===================================================== Start of RFI Request Latest Price ======================================================
	
	/**
	 * As a logged-in user, fill in all the fields for RFI Request Latest Price.
	 * 
	 * @param dataExpOrderQuantity
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void ExecuteRequestLatestPrice_EnterEOQAndMsgFields(String dataExpOrderQuantity, String dataMessage) throws Exception{
		
		// Enter text for "Expected Order Quantity" field.
		ProductProfile_Page.txtbx_enterExpectedOrderQuantity().sendKeys(dataExpOrderQuantity);
		
		// Enter text for "Message" field
		ProductProfile_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Select radio button for "Buyer Profile"
	//	ProductHome_Page.radbtn_selectBuyerProfile(dataBuyerProfile);
		
	}

	/**
	 * As a Non logged-in user, fill in all the fields for RFI Request Latest Price.
	 * 
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataBusinessEmail
	 * @param dataMessage
	 * @param dataBuyerProfile
	 * @throws Exception
	 */
	public static void ExecuteNonLoggedIn_FillInRequestLatestPriceForm(String dataFirstName, String dataLastName, String dataBusinessEmail, 
			String dataExpOrderQuantity, String dataMessage, String dataBuyerProfile) throws Exception{
		
		// Enter text for "First Name" field.
		ProductProfile_Page.txtbx_enterFirstName().sendKeys(dataFirstName);
		
		// Enter text for "Last Name" field.
		ProductProfile_Page.txtbx_enterLastName().sendKeys(dataLastName);
		
		// Enter text for "Business Email" field.
		ProductProfile_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Enter text for "Expected Order Quantity" field.
		ProductProfile_Page.txtbx_enterExpectedOrderQuantity().sendKeys(dataExpOrderQuantity);
		
		// Enter text for "Message" field.
		ProductProfile_Page.txtbx_enterMessage().sendKeys(dataMessage);
		
		// Select radio button for "Buyer Profile".
		ProductProfile_Page.radbtn_selectBuyerProfile(dataBuyerProfile);		
		
	}
	
	// ====================================================== End of RFI Request Latest Price =======================================================
	
	/**
	 * RFI Attachment - Able to upload multiple attachments (Total size less than 2MB).
	 * Applied to test 1191 / 32A.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteRFIAttachment_AttachMoreFiles(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
        // Attach more files.
        InquiryForm_Page.btn_uploadSecondFile();							
		InquiryForm_Page.btn_uploadThirdFile();					
					
        // To verify files are uploaded.
		InquiryForm_Page.check_secondFileIsUploaded(xls, sheetName, rowNum, testFail);
		InquiryForm_Page.check_thirdFileIsUploaded(xls, sheetName, rowNum, testFail);
	}
	
	/**
	 * Fill in all the relevant fields and click on "Contact Supplier Now" button.
	 * 
	 * @param dataSubject
	 * @param dataMessage
	 * @throws Exception
	 */
	public static void ExecuteRFIForm_FillInSubjectMessage_ClickContactSupplierNowBtn(String dataSubject, String dataMessage) throws Exception{
		
		// Fill In Subject and Message fields. 
		InquiryForm_Action.FillIn_SubjectAndMessageFieldsOnly(dataSubject, dataMessage);
		
		// Click on "Contact Supplier Now" button.
		InquiryForm_Page.btn_clickContactSupplierNow();
		
	}

}
