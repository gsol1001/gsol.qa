/**
 * This Class contains methods that represent the locators available on Login Page
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/07
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

	/**
	 * Contains methods that represent the locators available on Login page.
	 * @author Teng Shyh Wei
	 *
	 */
    public class LogIn_Page extends BaseClass {
    	
        private static WebElement element = null;
        
        public LogIn_Page(WebDriver driver){
            	super(driver);
        }
        
        /**
         * To verify Login page is displayed.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @return
         * @throws Exception
         */
        public static WebElement check_loginPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		String loginPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginForm_tit')]")).getText();
        		String expectedTitle = "Login for access to all your Global Sources services";
        		Add_Log.info("Page title ::" + loginPageTitle);
        		
                if(loginPageTitle.equals(expectedTitle)){
                	Add_Log.info("GSOL Login page is displayed");
                 	SuiteUtility.WriteResultUtility(
                 			xls, sheetName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
                 	
                }else{
                 	Add_Log.info("GSOL Login page is NOT displayed");
                 	SuiteUtility.WriteResultUtility(
                 			xls, sheetName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
                 	testFail.set(0, true);
                }
        	}catch(Exception e){
        		Add_Log.error("Error! GSOL Login page is NOT displayed.");
        		// Get the list of window handles
        		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        		Add_Log.info("Print number of window opened ::" + tabs.size());
           		throw(e);
           		}
           	return element;
        }
        
        // To verify Login page is displayed.
        public static WebElement check_loginPageIsDisplayed() throws Exception{
        	try{
        		String loginPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginForm_tit')]")).getText();
        		String expectedTitle = "Login for access to all your Global Sources services";
        		Add_Log.info("Page title ::" + loginPageTitle);
        		
                if(loginPageTitle.equals(expectedTitle)){
                	Add_Log.info("GSOL Login page is displayed.");                 	
                }else{
                 	Add_Log.info("GSOL Login page is NOT displayed.");
                // 	testFail.set(0, true);
                }
        	}catch(Exception e){
        		Add_Log.error("Error! GSOL Login page is NOT displayed.");
        		// Get the list of window handles
        		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        		Add_Log.info("Print number of window opened ::" + tabs.size());
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To verify PA Login page is displayed.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @return
         * @throws Exception
         */
        public static WebElement check_PALoginPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
        		List<Boolean> testFail) throws Exception{
        	try{
        		String loginPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginForm_tit')]")).getText();
        		String expectedTitle = "Login to edit your Product Alert Categories";
        		Add_Log.info("Page title ::" + loginPageTitle);
        		
        		if(loginPageTitle.equals(expectedTitle)){
        			Add_Log.info("GSOL PA Login page is displayed.");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			Add_Log.info("GSOL PA Login page is NOT displayed.");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        	}catch(Exception e){
        		Add_Log.error("Error! GSOL PA Login page is NOT displayed.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To verify eMag Login page is displayed.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @return
         * @throws Exception
         */
        public static WebElement check_eMagLoginPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
        		List<Boolean> testFail) throws Exception{
        	try{
        		String loginPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginForm_tit')]")).getText();
        		String expectedTitle = "Login to Global Sources to get your free e-magazines";
        		Add_Log.info("Page title ::" + loginPageTitle);
        		
        		if(loginPageTitle.equals(expectedTitle)){
        			Add_Log.info("GSOL eMag Login page is displayed.");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			Add_Log.info("GSOL eMag Login page is NOT displayed.");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_GSOL_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        	}catch(Exception e){
        		Add_Log.error("Error! GSOL eMag Login page is NOT displayed.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Enter text for Username field.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement txtbx_enterUserID() throws Exception{
        	try{
        		WebDriverWait wait = new WebDriverWait(driver, 15);
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fld_UserID")));
        		
	            element = driver.findElement(By.name("fld_UserID"));
	            element.clear();
	            Add_Log.info("User is enter text for Username field.");
	            
        	}catch(Exception e){
        		Add_Log.error("Username field is NOT found on the page.");
        		// Get the list of window handles
        		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        		Add_Log.info("Print number of window opened ::" + tabs.size());
           		throw(e);
           	}
           	return element;
        }
        
        /**
         * Enter text for Password field.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement txtbx_enterUserPassword() throws Exception{
        	try{
	        	element = driver.findElement(By.name("fld_UserPassword"));
	        	element.clear();
	        	Add_Log.info("User is enter text for Password field.");
	        	
        	}catch(Exception e){
        		Add_Log.error("Password field is NOT found on the page.");
           		throw(e);
           	}
           	return element;
        }
        
        /**
         * Click Login Now button at Main Login page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement btn_clickLoginNow() throws Exception{
        	try{        		
	        	element = driver.findElement(By.xpath("//*[@value='Login Now']"));
	        
        		// To verify is "Login Now" button displayed
        		Boolean isBtnDisplayed = element.isDisplayed();
        		Add_Log.info("Is Login Now btn displayed ::" + isBtnDisplayed);
        		
        		// Wait for element to be clickable
        		WebDriverWait wait = new WebDriverWait(driver, 15);
        		wait.until(ExpectedConditions.elementToBeClickable(element));
        		
	        	JavascriptExecutor executor = (JavascriptExecutor)driver;
	        	executor.executeScript("arguments[0].click();", element);
	            
	        	Add_Log.info("User is click on Login Now button.");
	        	
        	}catch(Exception e){
        		Add_Log.error("Login Now button is NOT found on the page.");
           		throw(e);
           	}
           	return element;
        }
        
        /**
         * Click on 'Forgot password?' link at Login page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickForgotPassword() throws Exception{
        	try{
        		element = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_loginSubmit mt25')]//a[contains(text(),'Forgot password')]"));
        		Add_Log.info("Forget password? link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Forget password? link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Click on 'Register now' link at Login page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickRegisterNow() throws Exception{
        	try{
        		element = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_login_reg')]//a[contains(text(),'Register now')]"));
        		Add_Log.info("Register now link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Register now link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Click on 'Forgot your password?' link at Login page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickForgotYourPassword() throws Exception{
        	try{
        		element = driver.findElement(        				
        				By.xpath("//*[contains(@class, 'GS_login_error')]//a[contains(text(),'Forgot your password?')]"));
        		Add_Log.info("Forgot your password? link is click on the page.");        		
        		
        	}catch(Exception e){
        		Add_Log.error("Forgot your password? link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Enter text for User ID in Login overlay.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement txtbx_enterLoginOnFormUserID() throws Exception{
        	try{
        		element = driver.findElement(By.name("fld_UserID"));
        		element.clear();
        		Add_Log.info("User is enter text for Username field in Login overlay.");

        	}catch(Exception e){
        		Add_Log.error("User ID is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Enter text for User Password in Login overlay.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement txtbx_enterLoginOnFormUserPassword() throws Exception{
        	try{        		
        		element = driver.findElement(By.name("fld_UserPassword"));
        		element.clear();
        		Add_Log.info("User is enter text for Password field in Login overlay.");
        		
        	}catch(Exception e){
        		Add_Log.error("User Password field is NOT found on the page.");
        		throw(e);
        		
        	}
        	return element;
        }     
        
        /**
         * To verify "E-mail (or Username)" and "Password" fields are filled up.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @param dataUsername
         * @param dataPassword
         * @return
         * @throws Exception
         */
        public static WebElement check_txtbxUsernamePasswordIsEntered(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail, String dataUsername, String dataPassword) throws Exception{
        	try{
	            String textEnteredInUsername = driver.findElement(By.name("fld_UserID")).getAttribute("value");    	            
	            String textEnteredInPassword = driver.findElement(By.name("fld_UserPassword")).getAttribute("value");
	               		           	
	            if((textEnteredInUsername.equals(dataUsername)) && (textEnteredInPassword.equals(dataPassword))){
	            	
	            	Add_Log.info("'E-mail (or Username)' and 'Password' fields are filled up.");
	            	SuiteUtility.WriteResultUtility(xls, sheetName, 
							Constant.COL_TXTBX_USERNAME_PSW_IS_ENTERED, rowNum, Constant.KEYWORD_PASS);
	            }else{
	            	
	            	Add_Log.info("'E-mail (or Username)' and 'Password' fields are NOT filled up.");
	            	SuiteUtility.WriteResultUtility(xls, sheetName, 
							Constant.COL_TXTBX_USERNAME_PSW_IS_ENTERED, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
	            }
        	}catch(Exception e){
        		Add_Log.error("Username and Password field is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }       
        
		/**
		 * To verify error message "E-mail Address (or Username) and Password do not match." is displayed in red color font.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
        public static WebElement check_errorMsgUsernamePassword_NotMatchDisplayed(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{        		
        		element = driver.findElement(By.xpath("//*[contains(@class, 'GS_login_error')]"
        				+ "//*[contains(text(),'E-mail Address (or Username) and Password do not match')]"));		        		    	
        		Boolean isErrorMsgExists = element.isDisplayed(); 		
        		
        		String fontColorErrorMsgBusinessEmail = element.getCssValue("color");        		
        		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();	    		
        		
            	if((isErrorMsgExists == true) && (fontColorErrorMsgBusinessEmail.equals(redFontFromRGB))){
            		Add_Log.info("Error message 'E-mail Address (or Username) and Password do not match' is displayed in red color font"); 
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_USERNAME_PSW_NOT_MATCH_EXISTS, rowNum, Constant.KEYWORD_PASS);
            	}else{
            		Add_Log.info("Error message 'E-mail Address (or Username) and Password do not match' is NOT displayed in red color font"); 
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_USERNAME_PSW_NOT_MATCH_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
            	}
        	}catch(Exception e){
        		Add_Log.error("Error message 'E-mail Address (or Username) and Password do not match' is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
		/**
		 * To verify "Please check and try again." is displayed below the error message.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */        
        public static WebElement check_msgPlsCheckAndTryAgainDisplayed(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		element = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_login_error')]//*[contains(text(),'Please check and try again')]"));
        		Boolean isMsgExists = element.isDisplayed();
        		Add_Log.info("Is msg 'Please check and try again' displayed ::" + isMsgExists);
        		
        		if(isMsgExists == true){
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_PLS_TRY_AGAIN_EXISTS, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_PLS_TRY_AGAIN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        	}catch(Exception e){
        		Add_Log.error("Error message 'Please check and try again' is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
		/**
		 * To verify "Forgot your password?" link is displayed below the error message.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
        public static WebElement check_lnkForgotYourPasswordDisplayed(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		element = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_login_error')]//a[contains(text(),'Forgot your password?')]"));
        		Boolean isLinkExists = element.isDisplayed();
        		Add_Log.info("Is 'Forgot your password?' link displayed below the error message::" + isLinkExists);
        		
        		if(isLinkExists == true){
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_LINK_FORGOT_PSW_EXISTS, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_LINK_FORGOT_PSW_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}        		
        	}catch(Exception e){
        		Add_Log.error("Forgot your password link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
		/**
		 * To verify "Get live help" link is displayed below the error message.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
        public static WebElement check_lnkGetLiveHelpDisplayed(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		element = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_login_error')]//a[contains(text(),'Get live help')]"));
        		Boolean isLinkExists = element.isDisplayed();
        		Add_Log.info("Is 'Get live help' link displayed below the error message ::" + isLinkExists);
        		
        		if(isLinkExists == true){
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_LINK_GET_LIVE_HELP_EXISTS, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_LINK_GET_LIVE_HELP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}        		
        	}catch(Exception e){
        		Add_Log.error("Get live help link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
                
    }
