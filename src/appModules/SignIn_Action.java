/**
 * This Class contains all the methods in the Sign In Action
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

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.GlobalNav_MenuBar;
import pageObjects.InquiryForm_Page;
import pageObjects.LogIn_Page;
import pageObjects.MiniLogin_Page;
import pageObjects.MiniRegistration_Page;
import utility.Read_XLS;

    /**
     * Contain all the methods in the Sign In action. 
     * @author Teng Shyh Wei
     *
     */
    public class SignIn_Action {
    	
    	/**
    	 * Enter text for Username and Password field.
    	 * 
    	 * @param dataUsername
    	 * @param dataPassword
    	 * @throws Exception
    	 */
    	public static void ExecuteFillIn_UsernamePassword(String dataUsername, 
    			String dataPassword) throws Exception{
    		
        	// Enter text for Username field  
            LogIn_Page.txtbx_enterUserID().sendKeys(dataUsername);
            
            // Enter text for Password field
            LogIn_Page.txtbx_enterUserPassword().sendKeys(dataPassword);   
            
    	}    
    	
    	/**
    	 * Enter text for Username and Password field, click on the Login Now button.
    	 * 
    	 * @param dataUsername
    	 * @param dataPassword
    	 * @throws Exception
    	 */
    	public static void ExecuteFillIn_UsernamePassword_ClickLoginNowBtn(String dataUsername, 
    			String dataPassword) throws Exception{
    		
        	// Enter text for Username field            	
            LogIn_Page.txtbx_enterUserID().sendKeys(dataUsername);
            
            // Enter text for Password field
            LogIn_Page.txtbx_enterUserPassword().sendKeys(dataPassword);
            
            // Click on the Login Now submit button
            LogIn_Page.btn_clickLoginNow(); 
            
    	}
    	
    	// Enter text for Password field and click on "Login Now" button.
    	public static void ExecuteFillInPassword_ClickLoginNowBtn(String dataPassword) throws Exception{
    		
    		// Enter text for Username field
    		LogIn_Page.txtbx_enterUserPassword().sendKeys(dataPassword);
    		
    		// Click on the Login Now submit button
    		LogIn_Page.btn_clickLoginNow();
    		
    	}
    	
    	/**
    	 * RFI Flow Logged-in User - Login action.
    	 * 
    	 * @param dataUsername
    	 * @param dataPassword
    	 * @throws Exception
    	 */
    	public static void ExecuteLoggedInUser(String dataUsername, String dataPassword) throws Exception{
        	        	
    		// Wait for 5 seconds
    		Thread.sleep(5000);
    		System.out.println("Wait for 5 seconds");
    		
        	// Click Login link at Global Navigation
    		GlobalNav_MenuBar.menuBar_clickGlobalNavigationLogin();        	
        	
    		// To verify Login page is displayed.
    		LogIn_Page.check_loginPageIsDisplayed();
    		
        	// Enter text for Username field
    		LogIn_Page.txtbx_enterUserID().sendKeys(dataUsername);
    		
    		// Enter text for Password field
    		LogIn_Page.txtbx_enterUserPassword().sendKeys(dataPassword);
    		
    		// Click on the Login Now submit button
    		LogIn_Page.btn_clickLoginNow();  
            
    		// Enter text for Username and Password field, click on the Login Now button.
    	//	SignIn_Action.ExecuteFillIn_UsernamePassword_ClickLoginNowBtn(dataUsername, dataPassword);
            
        }
    	
    	/**
    	 * RFI Flow Login on Form - Login action.
    	 * 
    	 * @param driver
    	 * @param dataUsername
    	 * @param dataPassword
    	 * @throws Exception
    	 */
        public static void ExecuteLoginOnForm(WebDriver driver, 
        		String dataUsername, String dataPassword) throws Exception{
        	// 02-Feb-2018: Project v337        	
        	// Click on the "Login Now" link at Login On Form page
    	//	InquiryForm_Page.btn_clickLoginOnFormLoginNow().click();
    		
    		// Identify and switch to the Login frame. 
        //	WebElement iframe = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginFrame')]"));
        	
        	WebElement iframe = driver.findElement(By.name("login_form"));
        	driver.switchTo().frame(iframe);    		
    		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   
    		// Enter text for UserName field
        	LogIn_Page.txtbx_enterLoginOnFormUserID().sendKeys(dataUsername);
        	
        	// Enter text for Password field
        	LogIn_Page.txtbx_enterUserPassword().sendKeys(dataPassword);        
    		
        	// Click on the Login Now submit button
        	LogIn_Page.btn_clickLoginNow();        	
        	
        }
        
        /**
         * RFI Flow Login on Form - Fill in Email and Password field an click on Login Now button.
         * 
         * @param dataUsername
         * @param dataPassword
         * @throws Exception
         */
        public static void ExecuteLoginOnForm_EnterUsernamePassword_ClickLoginNowBtn(String dataUsername,
        		String dataPassword) throws Exception{
        	
        	// Enter text for Username field
        	LogIn_Page.txtbx_enterLoginOnFormUserID().sendKeys(dataUsername);
        	
        	// Enter text for Password field
        	LogIn_Page.txtbx_enterUserPassword().sendKeys(dataPassword);
        	
        	// Click on the Login Now button
        	LogIn_Page.btn_clickLoginNow();
        	
        }
        
        
        /**
         * RFI Flow Post Login - Login action.
         * 
         * @param dataPassword
         * @throws Exception
         */
        public static void ExecutePostLogin(String dataPassword) throws Exception{
        	
        	// Click on the "Continue to Next Step" button.
    		InquiryForm_Page.btn_clickContinueToNextStep().click();
    		
    		// Enter text for Password field
    		MiniLogin_Page.txtbx_enterUserPassword().sendKeys(dataPassword); 
    		
    		// Click on the "Send Your Inquiry Now" button
    		MiniLogin_Page.btn_clickSendYourInquiryNow().click();
    		
        }
        
        // RFI Flow Post Login - Login action. Verify Mini Login page is displayed.
        public static void ExecutePostLogin_CheckMiniLoginPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
        		List<Boolean> testFail, String dataFirstName, String dataPassword) throws Exception{
        	
        	// Click on the "Continue to Next Step" button.
    		InquiryForm_Page.btn_clickContinueToNextStep().click();
    		
    		// To verify Mini Login page is displayed.
    		MiniLogin_Page.check_miniLoginPageIsDisplayed(xls, sheetName, rowNum, testFail, dataFirstName);
    		
    		// Enter text for Password field
    		MiniLogin_Page.txtbx_enterUserPassword().sendKeys(dataPassword); 
    		
    		// Click on the "Send Your Inquiry Now" button
    		MiniLogin_Page.btn_clickSendYourInquiryNow().click();
    		
        }
        
        /**
         * RFI Flow New User - Login action.
         * 
         * @param dataPassword
         * @param dataRePassword
         * @throws Exception
         */        
        public static void ExecuteNewUserLogin(String dataPassword, String dataRePassword) throws Exception{
        	
        	// Click on the "Continue To Next Step" button.
    		InquiryForm_Page.btn_clickContinueToNextStep().click();
    		
    		// Enter text for Create a Password field
    		MiniRegistration_Page.txtbx_enterCreatePassword().sendKeys(dataPassword);
    		
    		// Enter text for Re-enter Password field
    		MiniRegistration_Page.txtbx_enterReEnterPassword().sendKeys(dataRePassword);
    		
    		// Click on the "Send Your Inquiry Now" button
    		MiniRegistration_Page.btn_clickSendYourInquiryNow().click();
    		
        }
        
        // RFI Flow New User - Login action. Verify Mini Registration page is displayed.
        public static void ExecuteNewUserLogin_CheckMiniRegPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
        		List<Boolean> testFail, String dataPassword, String dataRePassword) throws Exception{
        	
        	// Click on the "Continue To Next Step" button.
    		InquiryForm_Page.btn_clickContinueToNextStep().click();
    		
    		// To verify Mini Registration page is displayed.
    		MiniRegistration_Page.check_miniRegistrationPageDisplayed(xls, sheetName, rowNum, testFail);
    		
    		// Enter text for Create a Password field
    		MiniRegistration_Page.txtbx_enterCreatePassword().sendKeys(dataPassword);
    		
    		// Enter text for Re-enter Password field
    		MiniRegistration_Page.txtbx_enterReEnterPassword().sendKeys(dataRePassword);
    		
    		// Click on the "Send Your Inquiry Now" button
    		MiniRegistration_Page.btn_clickSendYourInquiryNow().click();
        	
        }
        
		/**
		 * To verify error message "E-mail Address (or Username) and Password do not match." is displayed in red color font. 
		 * To verify "Please check and try again." is displayed after the error message.
		 * To verify "Forgot your password?" link is displayed after the error message.
		 * To verify "Get live help" link is displayed below the error message.	
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @throws Exception
		 */
        public static void ExecuteInvLoginErrorMsgIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	
			// To verify error message "E-mail Address (or Username) and Password do not match." is displayed in red color font. 
			LogIn_Page.check_errorMsgUsernamePassword_NotMatchDisplayed(xls, sheetName, rowNum, testFail);
			
			// To verify "Please check and try again." is displayed after the error message
			LogIn_Page.check_msgPlsCheckAndTryAgainDisplayed(xls, sheetName, rowNum, testFail);
			
			// To verify "Forgot your password?" link is displayed after the error message
			LogIn_Page.check_lnkForgotYourPasswordDisplayed(xls, sheetName, rowNum, testFail);
			
			// To verify "Get live help" link is displayed below the error message.
			LogIn_Page.check_lnkGetLiveHelpDisplayed(xls, sheetName, rowNum, testFail);
			
        }
        
    }
