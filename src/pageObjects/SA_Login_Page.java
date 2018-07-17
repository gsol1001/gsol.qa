/**
 * This Class contains methods that represent the locators available on SA Login Page.
 * Created: Fri 02 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/02
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
 * Contains methods that represent the locators available on SA Login page.
 * @author Teng Shyh Wei
 *
 */
public class SA_Login_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public SA_Login_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * To verify SA Login page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_SALoginPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception {
    	try{
    		String pageTitle = driver.findElement(By.xpath("//*[contains(@class, 'moduleheader')]")).getText();
    		String expectedTitle = "Login";
    		Add_Log.info("Page title ::" + pageTitle);
    		
    		if(pageTitle.equals(expectedTitle)){
    			Add_Log.info("SA Login page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("SA Login page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		Add_Log.error("Error! SA Login page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPassword() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_UserPassword"));
    		Add_Log.info("User is enter text for Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Login Now' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickLoginNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@value='Login Now']"));
    		Add_Log.info("Login Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Login Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    
    
}
