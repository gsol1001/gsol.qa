/**
 * This Class contains all the methods in the Forget Password Action
 * Created: Mon 20 Jul 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/20
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BuyerRegistration_Page;
import pageObjects.ForgetPassword_Page;
import pageObjects.GlobalNav_MenuBar;
import pageObjects.InquiryForm_Page;
import pageObjects.LogIn_Page;
import pageObjects.MiniLogin_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the Forget Password action.
 * @author Teng Shyh Wei
 *
 */
public class ForgetPassword_Action {
	
	/**
	 * From the Login Page entry point, click on the forgot password link.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteGoToLoginPage_ClickForgotPasswordLink() throws Exception{
		
		// Click Login link at Global Navigation
		GlobalNav_MenuBar.menuBar_clickGlobalNavigationLogin();    
    	
    	// Click on 'Forgot password?' link at Login page
    	LogIn_Page.lnk_clickForgotPassword().click();
    	
	}
	
	/**
	 * From the Registration page entry point, click on the forgot password link.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteGoToRegPage_ClickForgotPasswordLink() throws Exception{
		
		// Generate mouse hover event on Global Navigation to click on Register for Buyer.
		GlobalNav_MenuBar.menuBar_selectRegisterForBuyer();
		
		// Click on the 'Forgot Your Password?' link.
		BuyerRegistration_Page.lnk_clickForgotYourPassword().click();
		
	}
	
	/**
	 * From the Mini Login page entry point, click on the 'forgot password' link.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteGoToMiniLoginPage_ClickForgotPasswordLink(WebDriver driver,
			String dataSearchKeyword) throws Exception{

		// Inquire on any product(s) and go to RFI form.
		ProductInquiry_Action.ExecuteInqSglVerPdt(dataSearchKeyword);
		
		// Click on 'Login Now' button at Inquiry Form page.
	//	InquiryForm_Page.btn_clickLoginOnFormLoginNow().click();
		
		// 02-Feb-2018: Project v337
		// Identify and switch to the Login frame
    //	WebElement iframe = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginFrame')]"));
		WebElement iframe = driver.findElement(By.name("login_form"));
		driver.switchTo().frame(iframe);    		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Click on the "Forgot Password?' link.
		MiniLogin_Page.lnk_clickForgotPassword().click();
		
	}
	
	/**
	 * From the Login page with 'The Login Name or E-mail and Password do not match.' error entry point, 
	 * click on the 'forgot your password' link.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteGoToLoginPage_ClickForgotYourPasswordLink(String dataUsername, 
			String dataPassword) throws Exception{
		
		// Click Login link at Global Navigation
		GlobalNav_MenuBar.menuBar_clickGlobalNavigationLogin();    
    	
    	// Enter text for E-mail (or Username) field            	
        LogIn_Page.txtbx_enterUserID().sendKeys(dataUsername);
        
        // Enter text for Password field
        LogIn_Page.txtbx_enterUserPassword().sendKeys(dataPassword);
        
        // Click on the Login Now submit button
        LogIn_Page.btn_clickLoginNow(); 
        
    	// Click on 'Forgot your password?' link at Login page
    	LogIn_Page.lnk_clickForgotYourPassword().click();
    	
	}
	
	/**
	 * Enter text for email address field and click on "Submit" button.
	 * 
	 * @param dataNewEmailAddress
	 * @throws Exception
	 */
	public static void ExecuteEnterEmailAddr_ClickSubmitBtn(String dataNewEmailAddress) throws Exception{
		
		// Enter text for 'E-mail Address' field
		ForgetPassword_Page.txtbx_enterEmailAddress().sendKeys(dataNewEmailAddress);
		
		// Click on 'Submit' button
		ForgetPassword_Page.btn_clickSubmit().click();
		
	}

	/**
	 * To verify message "The e-mail address you entered is subscribed to receive Product Alert and/or e-Magazines updates only." 
	 * is displayed in red color font.
	 * To verify upgrade upsell section is displayed below the error message.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */ 
	public static void ExecuteMsgEmailAddrSubsPAeMag_UpgradeUpsellSecDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify message "The e-mail address you entered is subscribed to receive Product Alert 
		// and/or e-Magazines updates only." is displayed in red color font. 		
		ForgetPassword_Page.check_msgEmailAddrSubsPAeMagDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify upgrade upsell section is displayed below the error message.
		ForgetPassword_Page.check_upgradeUpsellSecIsDisplayed(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify message "The e-mail address you entered is not registered with Global Sources." is displayed in red color font.
	 * To verify "Register now" link is displayed below the error message.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteMsgEmailAddrNotReg_LinkRegNowDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// To verify message "The e-mail address you entered is not registered with Global Sources." is displayed in red color font. 
		ForgetPassword_Page.check_msgEmailNotRegisteredDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify "Register now" link is displayed below the error message.
		ForgetPassword_Page.check_lnkRegisterNowDisplayed(xls, sheetName, rowNum, testFail);
		
	}
	
}
