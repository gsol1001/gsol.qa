/**
 * This Class contains all the methods in the Mini Registration Action
 * Created: Tue 19 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/19
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.MiniRegistration_Page;

/**
 * Contain all the methods in the Mini Registration action.
 * @author Teng Shyh Wei
 *
 */
public class MiniRegistration_Action {

    /**
     * Fill in the "Create a Password" and "Re-enter Password" fields and click on "Send Your Inquiry Now" button
     * 
     * @param dataPassword
     * @param dataRePassword
     * @throws Exception
     */
    public static void ExecuteMiniReg_EnterPassword_ClickSendYourInquiryNow(String dataPassword, String dataRePassword) throws Exception{
    
		// Enter text for Create a Password field
    	MiniRegistration_Page.txtbx_enterCreatePassword().sendKeys(dataPassword);
		
		// Enter text for Re-enter Password field
    	MiniRegistration_Page.txtbx_enterReEnterPassword().sendKeys(dataRePassword);
		
		// Click on the "Send Your Inquiry Now" button
    	MiniRegistration_Page.btn_clickSendYourInquiryNow().click();
		
    }
    
	/**
	 * Fill up all the mandatory fields in Mini Registration page.
	 * 
	 * @param dataCreatePassword
	 * @param dataReenterPassword
	 * @param dataCountry
	 * @param dataCompName
	 * @param dataPhoneNumber
	 * @throws Exception
	 */
	public static void ExecuteMiniReg_EnterMandatoryFields(String dataCreatePassword, String dataReenterPassword,
			String dataCountry, String dataCompName, String dataPhoneNumber) throws Exception{
		
		// Enter text for "Create a Password" field.
		MiniRegistration_Page.txtbx_enterCreatePassword().sendKeys(dataCreatePassword);
		
		// Enter text for "Re-enter Password" field.
		MiniRegistration_Page.txtbx_enterReEnterPassword().sendKeys(dataReenterPassword);
		
		// Select drop down list for "Country/Territory".
		MiniRegistration_Page.drpdwn_selectCountryTerritory(dataCountry);
		
		// Enter text for "Company Name" field.
		MiniRegistration_Page.txtbx_enterCompanyName().sendKeys(dataCompName);
		
		// Enter text for "Telephone Number" field.
		MiniRegistration_Page.txtbx_enterContactNumberTelephoneNumber().sendKeys(dataPhoneNumber);
		
	}
	
	
}
