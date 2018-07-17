/**
 * This Class contains all the methods in the Registration Action
 * Created: Thu 18 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/18
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.BuyerRegistration_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the Registration action.
 * @author Teng Shyh Wei
 *
 */
public class Registration_Action {
	
	/**
	 * Fill up all the mandatory fields.
	 * 
	 * @param dataBusinessEmail
	 * @param dataCreateAPassword
	 * @param dataReenterPassword
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCountryTerritory
	 * @param dataCompanyName
	 * @param dataTelephoneNumber
	 * @throws Exception
	 */
	public static void ExecuteReg_EnterMandatoryField(String dataBusinessEmail, String dataCreateAPassword, 
			String dataReenterPassword, String dataTitle, String dataFirstName, String dataLastName,
			String dataCountryTerritory, String dataCompanyName, String dataTelephoneNumber,
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Enter text for 'Business E-mail' field
		BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Enter text for "Create a Password" field
		BuyerRegistration_Page.txtbx_enterCreateAPassword().sendKeys(dataCreateAPassword);
		
		// Enter text for "Re-enter Password" field
		BuyerRegistration_Page.txtbx_enterReenterPassword().sendKeys(dataReenterPassword);
		
		// Select drop down list for Title
		BuyerRegistration_Page.drpdwn_selectTitle(dataTitle);
		
		// Enter text for "First/Given Name" field
		BuyerRegistration_Page.txtbx_enterFirstName().sendKeys(dataFirstName);
		
		// Enter text for "Last/Family Name" field
		BuyerRegistration_Page.txtbx_enterLastName().sendKeys(dataLastName);
		
		// Select drop down list for Country/Territory
		BuyerRegistration_Page.drpdwn_selectCountryTerritory(dataCountryTerritory);
		
		// Enter text for "Company Name" field
		BuyerRegistration_Page.txtbx_enterCompanyName().sendKeys(dataCompanyName);
		
		// Enter Business Contact Number's Telephone Number
		BuyerRegistration_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(dataTelephoneNumber);
		
		// Enter text for "Company Website URL" field
		BuyerRegistration_Page.txtbx_enterCompWebsiteURL(dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
	}
	
	/**
	 * Fill up all the mandatory fields (except Business E-mail).
	 *  
	 * @param dataCreateAPassword
	 * @param dataReenterPassword
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCountryTerritory
	 * @param dataCompanyName
	 * @param dataTelephoneNumber
	 * @throws Exception
	 */
	public static void ExecuteReg_EnterMandatoryField(String dataCreateAPassword, String dataReenterPassword, 
			String dataTitle, String dataFirstName, String dataLastName, String dataCountryTerritory, 
			String dataCompanyName, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Enter text for "Create a Password" field
		BuyerRegistration_Page.txtbx_enterCreateAPassword().sendKeys(dataCreateAPassword);
		
		// Enter text for "Re-enter Password" field
		BuyerRegistration_Page.txtbx_enterReenterPassword().sendKeys(dataReenterPassword);
		
		// Select drop down list for Title
		BuyerRegistration_Page.drpdwn_selectTitle(dataTitle);
		
		// Enter text for "First/Given Name" field
		BuyerRegistration_Page.txtbx_enterFirstName().sendKeys(dataFirstName);
		
		// Enter text for "Last/Family Name" field
		BuyerRegistration_Page.txtbx_enterLastName().sendKeys(dataLastName);
		
		// Select drop down list for Country/Territory
		BuyerRegistration_Page.drpdwn_selectCountryTerritory(dataCountryTerritory);
		
		// Enter text for "Company Name" field
		BuyerRegistration_Page.txtbx_enterCompanyName().sendKeys(dataCompanyName);
		
		// Enter Business Contact Number's Telephone Number
		BuyerRegistration_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(dataTelephoneNumber);
		
		// Enter text for "Company Website URL" field
		BuyerRegistration_Page.txtbx_enterCompWebsiteURL(dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
	}
	
	/**
	 * Fill up all the fields in Registration form.
	 * 
	 * @param dataBusinessEmail
	 * @param dataCreateAPassword
	 * @param dataReenterPassword
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCountryTerritory
	 * @param dataCompanyName
	 * @param dataTelephoneNumber
	 * @param dataEmagTitle
	 * @param dataProductKeyword
	 * @param dataMailAnnouce
	 * @param dataMailMarketing
	 * @throws Exception
	 */
	public static void ExecuteReg_FillUp_eMag_PA_Notification(String dataBusinessEmail, String dataCreateAPassword,
			String dataReenterPassword, String dataTitle, String dataFirstName, String dataLastName, 
			String dataCountryTerritory, String dataCompanyName, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, 
			String dataTxtbxCompWebsiteURL, String dataEmagTitle, String dataProductKeyword, String dataMailAnnouce, 
			String dataMailMarketing) throws Exception{
		
		// Fill up all the mandatory fields.	
		Registration_Action.ExecuteReg_EnterMandatoryField(dataBusinessEmail, dataCreateAPassword, dataReenterPassword, 
				dataTitle, dataFirstName, dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber, 
				dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Check any eMag title checkbox (e.g: Electronics).
		BuyerRegistration_Page.chkbx_selectAnyEmagTitle(dataEmagTitle);
												
		// Enter a product keyword in PA textbox (e.g: MP3).
		BuyerRegistration_Page.txtbx_enterProductKeyword().sendKeys(dataProductKeyword);
		
		// Make sure the Notification checkboxes are checked.
		BuyerRegistration_Page.chkbx_selectMailAnnounce(dataMailAnnouce);
		BuyerRegistration_Page.chkbx_selectMailMarketing(dataMailMarketing);
		
	}
	
	/**
	 * Fill up all the fields in Registration form (except Business E-mail).
	 * 
	 * @param dataCreateAPassword
	 * @param dataReenterPassword
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCountryTerritory
	 * @param dataCompanyName
	 * @param dataTelephoneNumber
	 * @param dataEmagTitle
	 * @param dataProductKeyword
	 * @param dataMailAnnouce
	 * @param dataMailMarketing
	 * @throws Exception
	 */
	public static void ExecuteReg_FillUp_eMag_PA_Notification(String dataCreateAPassword, String dataReenterPassword, 
			String dataTitle, String dataFirstName, String dataLastName, String dataCountryTerritory, String dataCompanyName, 
			String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL, String dataEmagTitle,
			String dataProductKeyword, String dataMailAnnouce, String dataMailMarketing) throws Exception{
		
		// Fill up all the mandatory fields (except Business E-mail).
		Registration_Action.ExecuteReg_EnterMandatoryField(dataCreateAPassword, dataReenterPassword, dataTitle, 
				dataFirstName, dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber, 
				dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Check any eMag title checkbox (e.g: Electronics).
		BuyerRegistration_Page.chkbx_selectAnyEmagTitle(dataEmagTitle);
												
		// Enter a product keyword in PA textbox (e.g: MP3).
		BuyerRegistration_Page.txtbx_enterProductKeyword().sendKeys(dataProductKeyword);
		
		// Make sure the Notification checkboxes are checked.
		BuyerRegistration_Page.chkbx_selectMailAnnounce(dataMailAnnouce);
		BuyerRegistration_Page.chkbx_selectMailMarketing(dataMailMarketing);
		
	}
	
	/**
	 * Fill up all the fields in Registration form.
	 * Applied to test case 1060 / 9A.
	 * eMag upgrade from eMag Lite confirmation page.
	 * 
	 * @param dataCreateAPassword
	 * @param dataReenterPassword
	 * @param dataTitle
	 * @param dataTelephoneNumber
	 * @throws Exception
	 */
	public static void ExecuteReg_FillUp_PswAndPhoneNo(String dataCreateAPassword, String dataReenterPassword, 
			String dataTitle, String dataTelephoneNumber, String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL) throws Exception{
		
		// Enter text for "Create a Password" field
		BuyerRegistration_Page.txtbx_enterCreateAPassword().sendKeys(dataCreateAPassword);
		
		// Enter text for "Re-enter Password" field
		BuyerRegistration_Page.txtbx_enterReenterPassword().sendKeys(dataReenterPassword);
		
		// Select drop down list for Title
		BuyerRegistration_Page.drpdwn_selectTitle(dataTitle);
		
		// Enter Business Contact Number's Telephone Number
		BuyerRegistration_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(dataTelephoneNumber);		
		
		// Enter text for "Company Website URL" field
		BuyerRegistration_Page.txtbx_enterCompWebsiteURL(dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
	}
	
	/**
	 * Fill up all the mandatory fields.
	 * Check any eMag title checkbox (e.g: Electronics).
	 * Make sure the Notification checkboxes are checked.
	 * Applied to test case 1047 / 6D (PA upgrade from Edit Categories)
	 * 
	 * @param dataCreateAPassword
	 * @param dataReenterPassword
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCountryTerritory
	 * @param dataCompanyName
	 * @param dataTelephoneNumber
	 * @param dataEmagTitle
	 * @param dataMailAnnouce
	 * @param dataMailMarketing
	 * @throws Exception
	 */
	public static void ExecuteReg_FillUp_eMag_Notification(String dataCreateAPassword, String dataReenterPassword, String dataTitle, 
			String dataFirstName, String dataLastName, String dataCountryTerritory, String dataCompanyName, String dataTelephoneNumber, 
			String dataRadbtnCompWebsiteURL, String dataTxtbxCompWebsiteURL, String dataEmagTitle, String dataMailAnnouce, 
			String dataMailMarketing) throws Exception{
		
		// Fill up all the mandatory fields (except Business E-mail).
		Registration_Action.ExecuteReg_EnterMandatoryField(dataCreateAPassword, dataReenterPassword, 
				dataTitle, dataFirstName, dataLastName, dataCountryTerritory, dataCompanyName, dataTelephoneNumber,
				dataRadbtnCompWebsiteURL, dataTxtbxCompWebsiteURL);
		
		// Check any eMag title checkbox (e.g: Electronics).
		BuyerRegistration_Page.chkbx_selectAnyEmagTitle(dataEmagTitle);											
		
		// Make sure the Notification checkboxes are checked.
		BuyerRegistration_Page.chkbx_selectMailAnnounce(dataMailAnnouce);
		BuyerRegistration_Page.chkbx_selectMailMarketing(dataMailMarketing);
		
	}
	
	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkbox is checked.
	 * To verify Product keyword is entered in the textbox.
	 * To verify the Notification checkboxes are checked.
	 * Applied to test case 1A, 1I, 1J.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmagTitle
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecuteReg_eMag_PA_Notification_FilledUp(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataEmagTitle, String dataProductKeyword) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkbox is checked.
		BuyerRegistration_Page.check_eMagTitleChkbxSelected(xls, sheetName, rowNum, testFail, dataEmagTitle);
		
		// To verify Product keyword is entered in the textbox
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsEntered(xls, sheetName, rowNum, testFail, dataProductKeyword);
		
		// To verify the Notification checkboxes are checked.
		BuyerRegistration_Page.check_notificationChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkbox is checked.
	 * To verify Product keyword is entered in the textbox.
	 * To verify the notification checkbox are unchecked.
	 * Applied to test case 1B.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmagTitle
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecuteReg_OnlyEmagPA_FilledUp(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataEmagTitle, String dataProductKeyword) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkbox is checked.
		BuyerRegistration_Page.check_eMagTitleChkbxSelected(xls, sheetName, rowNum, testFail, dataEmagTitle);
		
		// To verify Product keyword is entered in the textbox
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsEntered(xls, sheetName, rowNum, testFail, dataProductKeyword);
		
		// To verify the notification checkbox are unchecked.
		BuyerRegistration_Page.check_notificationChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
	}

	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkboxes is checked.
	 * To verify PA Alert field is blank.
	 * To verify the notification checkboxes are checked.
	 * Applied to test case 1C.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmagTitle
	 * @throws Exception
	 */
	public static void ExecuteReg_OnlyEmagNotification_FilledUp(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataEmagTitle) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkboxes is checked.
		BuyerRegistration_Page.check_eMagTitleChkbxSelected(xls, sheetName, rowNum, testFail, dataEmagTitle);
		
		// To verify PA Alert field is blank.
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsBlank(xls, sheetName, rowNum, testFail);
		
		// To verify The Notification checkboxes are checked.
		BuyerRegistration_Page.check_notificationChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkboxes is checked.
	 * To verify PA Alert field is blank.
	 * To verify the notification checkbox are unchecked.
	 * Applied to test case 1D.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmagTitle
	 * @throws Exception
	 */
	public static void ExecuteReg_OnlyEmagTitleChkbxFilledUp(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataEmagTitle) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkboxes is checked.
		BuyerRegistration_Page.check_eMagTitleChkbxSelected(xls, sheetName, rowNum, testFail, dataEmagTitle);
		
		// To verify PA Alert field is blank.
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsBlank(xls, sheetName, rowNum, testFail);
		
		// To verify the notification checkbox are unchecked.
		BuyerRegistration_Page.check_notificationChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkboxes are unchecked.
	 * To verify PA Alert field is blank.
	 * To verify the Notification checkboxes are checked.
	 * Applied to test case 1E, 1G.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteReg_OnlyNotificationChkbxFilledUp(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkboxes are unchecked.
		BuyerRegistration_Page.check_eMagTitleChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
		// To verify PA Alert field is blank.
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsBlank(xls, sheetName, rowNum, testFail);
		
		// To verify the Notification checkboxes are checked.
		BuyerRegistration_Page.check_notificationChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkboxes are unchecked.
	 * To verify PA Alert field is blank.
	 * To verify the notification checkbox are unchecked.
	 * Applied to test case 1F, 1H.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteReg_eMag_PA_Notification_NotFilledUp(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkboxes are unchecked.
		BuyerRegistration_Page.check_eMagTitleChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
		// To verify PA Alert field is blank.
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsBlank(xls, sheetName, rowNum, testFail);
		
		// To verify the notification checkbox are unchecked.
		BuyerRegistration_Page.check_notificationChkbxNotSelected(xls, sheetName, rowNum, testFail);
	}
	
	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkboxes are unchecked.
	 * To verify Product keyword is entered in the textbox.
	 * To verify The Notification checkboxes are unchecked.
	 * Applied to test case 1L
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecuteReg_OnlyPATxtbxFilledUp(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataProductKeyword) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkboxes are unchecked.
		BuyerRegistration_Page.check_eMagTitleChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
		// To verify Product keyword is entered in the textbox.
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsEntered(xls, sheetName, rowNum, testFail, dataProductKeyword);
		
		// To verify The Notification checkboxes are unchecked.
		BuyerRegistration_Page.check_notificationChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify all mandatory fields are filled up.
	 * To verify eMag title checkboxes are unchecked.
	 * To verify Product keyword is entered in the textbox.
	 * To verify The Notification checkboxes are checked.
	 * Applied to test case 1M.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataProductKeyword
	 * @throws Exception
	 */
	public static void ExecuteReg_PA_Notification_FilledUp(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataProductKeyword) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkboxes are unchecked.
		BuyerRegistration_Page.check_eMagTitleChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
		// To verify Product keyword is entered in the textbox.
		BuyerRegistration_Page.check_pdtKeywordTxtbxIsEntered(xls, sheetName, rowNum, testFail, dataProductKeyword);
		
		// To verify the Notification checkboxes are checked.
		BuyerRegistration_Page.check_notificationChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Mandatory fields are filled up.
	 * To verify eMag title checkbox is checked.
	 * To verify the Notification checkboxes are checked.
	 * Applied to test case 6D.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmagTitle
	 * @throws Exception
	 */
	public static void ExecutePAUpgrade_OnlyEmagNotification_FilledUp(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataEmagTitle) throws Exception{
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify eMag title checkboxes is checked.
		BuyerRegistration_Page.check_eMagTitleChkbxSelected(xls, sheetName, rowNum, testFail, dataEmagTitle);
		
		// To verify The Notification checkboxes are checked.
		BuyerRegistration_Page.check_notificationChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Mandatory fields are filled up.
	 * To verify the Notification checkboxes are checked.
	 * Applied to test case 6E, 6H
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecutePAUpgrade_OnlyMandatoryNotification_FilledUp(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{		
		
		// To verify all mandatory fields are filled up.
		BuyerRegistration_Page.check_allMandatoryFieldsFilledUp(xls, sheetName, rowNum, testFail);
		
		// To verify The Notification checkboxes are checked.
		BuyerRegistration_Page.check_notificationChkbxSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Registration page is displayed.
	 * To verify Email address entered is pre-populated in "Business Email" field.
	 * Applied to test case PA_LiteSignup_0005 4F.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecuteRegPageDisplayed_EmailAddrPrepopulatedInBusinessEmailField(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataEmailAddress) throws Exception{
		
		// To verify Registration page is displayed.
		BuyerRegistration_Page.check_buyerRegPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify Email address entered is pre-populated in "Business Email" field.
		BuyerRegistration_Page.check_txtEmailAddrPrepopulatedInBusinessEmailField(xls, sheetName, rowNum, testFail, dataEmailAddress);
		
	}
	
	/**
	 * To verify Registration page is displayed. 
	 * To verify Email address entered in is pre-populated and grey-ed out in "Business Email" field.
	 * Applied to test case 3B.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecuteRegPageDisplayed_EmailAddrPrepopulatedInGrey(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataEmailAddress) throws Exception{
		
		// To verify Registration page is displayed. 
		BuyerRegistration_Page.check_buyerRegPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify Email address entered is pre-populated and grey-ed out in 'Business Email' field.
		BuyerRegistration_Page.check_txtEmailAddrPrepopulatedInGrey(xls, sheetName, rowNum, testFail, dataEmailAddress);
		
	}
	
	/**
	 * To verify Registration page is displayed.
	 * To verify Email address entered in is pre-populated and grey-ed out in "Business Email" field.
	 * Applied to test case PA_LiteSignup_0005/ 4F, 4U, 4V, 4W.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecuteRegPageDisplayed_EmailAddrPrepopulatedInGray(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataEmailAddress) throws Exception{
		
		// To verify Registration page is displayed.
		BuyerRegistration_Page.check_buyerRegPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify Email address entered is pre-populated and grey-ed out in 'Business Email' field.
		BuyerRegistration_Page.check_txtEmailAddrPrepopulatedInGray(xls, sheetName, rowNum, testFail, dataEmailAddress);
		
	}
	
	/**
	 * To verify Registration page is displayed. 
	 * To verify that the PA Lite user email address is pre-populated and grey-ed out in the Business Email field. 
	 * To verify PA upsell section is not available.
	 * Applied to test case 6D, 6E
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmailAddress
	 * @throws Exception
	 */
	public static void ExecuteRegPage_EmailPrepopulated_PAUpsellSecNotExists(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataEmailAddress) throws Exception{
		
		// To verify Registration page is displayed. 
		BuyerRegistration_Page.check_buyerRegPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the PA Lite user email address is pre-populated and grey-ed out in the Business Email field. 
		BuyerRegistration_Page.check_txtEmailAddrPrepopulatedInGrey(xls, sheetName, rowNum, testFail, dataEmailAddress);
		
		// To verify PA upsell section is not available.
		BuyerRegistration_Page.check_PAUpsellSectionNotExists(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify Registration page is displayed with "Business Email" field is blank.
	 * Applied to test case 3C.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteRegPageDisplayed_TxtbxBusinessEmailBlank(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify Registration page is displayed.
		BuyerRegistration_Page.check_buyerRegPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify "Business Email" field is blank.
		BuyerRegistration_Page.check_txtbxBusinessEmailBlank(xls, sheetName, rowNum, testFail);
		
	}
	
}
