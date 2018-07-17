/**
 * This Class contains all the methods in the eMag Lite Form Action.
 * Created: Tue 01 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/01
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import pageObjects.eMagLite_Form_Page;

/**
 * Contain all the methods in the eMag Lite Form action.
 * @author Teng Shyh Wei
 *
 */
public class eMagLite_Form_Action {

	/**
	 * Enter text for 'Business E-mail' field and click on 'Continue' button.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecuteEmagLiteSignup_EnterEmailAddr_ClickContinueBtn(
			String dataBusinessEmail) throws Exception{
		
	    // Enter text for 'Business E-mail' field
		eMagLite_Form_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
	    // Click on the 'Continue' button 
		eMagLite_Form_Page.btn_clickContinue().click();
		
	}
	
	/**
	 * Enter the password in Password field and click on "Login Now" button.
	 * 
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteeMagLiteSignup_EnterPassword_ClickLoginNowBtn(String dataPassword) throws Exception{
		
	    // Enter text for 'Password' field.
		eMagLite_Form_Page.txtbx_enterPassword().sendKeys(dataPassword);
		
	    // Click on the 'Login Now' button
	    eMagLite_Form_Page.btn_clickLoginNow().click();
		
	}
	
	/**
	 * Fill up all the mandatory fields and click on "Submit" button. 
	 * 
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @throws Exception
	 */
	public static void ExecuteFillInMandatoryFields_ClickSubmitBtn(String dataFirstName, String dataLastName,
			String dataCompName, String dataCountryTerritory) throws Exception{
		
		// Enter text for First/Given Name field.
		eMagLite_Form_Page.txtbx_enterFirstName().sendKeys(dataFirstName);
		
		// Enter text for Last/Family Name field.
		eMagLite_Form_Page.txtbx_enterLastName().sendKeys(dataLastName);
		
		// Enter text for Company Name field.
		eMagLite_Form_Page.txtbx_enterCompanyName().sendKeys(dataCompName);
		
		// Select drop down list for Country/Territory.
		eMagLite_Form_Page.drpdwn_selectCountryTerritory(dataCountryTerritory);
		
	    // To click on 'Submit' button.
		eMagLite_Form_Page.btn_clickSubmit().click();
	}
	
	/**
	 * Subscribe to eMag Lite using autoqa_gsolnewxxxx@gmail.com and go to eMag Lite confirmation page.
	 * 
	 * @param driver
	 * @param dataPrefEmagTitle
	 * @param dataBusinessEmail
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCompName
	 * @param dataCountryTerritory
	 * @throws Exception
	 */
	public static void ExecuteSubscribeToEmagLite(WebDriver driver, String dataPrefEmagTitle, String dataBusinessEmail, String dataFirstName,
			String dataLastName, String dataCompName, String dataCountryTerritory) throws Exception{
		
		// Go to eMag Lite form page.
	//	driver.get(Param.getProperty("eMagLiteFormURL"));
		
		// Select eMag title checkboxes.
		eMagLite_Form_Page.chkbx_selectAnyEmagTitle(dataPrefEmagTitle);
		
		// Enter eMag Lite email address and click on 'Continue' button.
		eMagLite_Form_Action.ExecuteEmagLiteSignup_EnterEmailAddr_ClickContinueBtn(dataBusinessEmail);
		
		// Fill up all the mandatory fields and click on 'Submit' button.
		eMagLite_Form_Action.ExecuteFillInMandatoryFields_ClickSubmitBtn(dataFirstName, dataLastName, dataCompName, dataCountryTerritory);
		
		// Switch to alert and click on 'OK' button to accept.
		Alert alert = driver.switchTo().alert();
		
		// Accept the alert = equivalent of pressing OK
		alert.accept();
		
	}

}
