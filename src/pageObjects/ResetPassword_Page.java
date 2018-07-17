/**
 * This Class contains methods that represent the locators available on Reset Password Page
 * Created: Mon 30 Nov 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/11/30
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Reset Password page.
 * @author Teng Shyh Wei
 *
 */
public class ResetPassword_Page extends BaseClass{

	private static WebElement element = null;
	
    public ResetPassword_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Change or Set Password page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_ChangeOrSetPswPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		String pageTitle = driver.findElement(
    				By.xpath("//*[Contains (text(),'Change/Set Password')]")).getText();
    		String expectedTitle = "Change/Set Password";
    		
    		if(pageTitle.equals(expectedTitle)){
    			Add_Log.info("Change/Set Password page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CHANGE_PSW_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Change/Set Password page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CHANGE_PSW_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Change/Set Password page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
   
    /**
     * Enter text for 'Existing Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterExistingPassword() throws Exception{
    	try{
    		element = driver.findElement(By.name("oldpass"));
    		Add_Log.info("User is enter text for Existing Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Existing Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * Enter text for 'New Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterNewPassword() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_UserPassword[0]"));
    		Add_Log.info("User is enter text for New Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("New Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Confirm New Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterConfirmNewPassword() throws Exception{
    	try{
    		element = driver.findElement(By.name("cpass"));
    		Add_Log.info("User is enter text for Confirm New Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Confirm New Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Submit' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubmit() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@value='Submit']"));
    		Add_Log.info("Submit button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Submit button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
