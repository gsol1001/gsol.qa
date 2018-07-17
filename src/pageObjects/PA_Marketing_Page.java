/**
 * This Class contains methods that represent the locators available on PA Marketing Page
 * Created: Mon 06 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/06
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
 * Contains methods that represent the locators available on PA Marketing page.
 * @author Teng Shyh Wei
 *
 */
public class PA_Marketing_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public PA_Marketing_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify PA Marketing page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAMarketingPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String productAlertTitle = driver.findElement(By.xpath("//*[contains(@class, 'PA_MT_tit')]")).getText();
    		// 12-Jul-2017 MR#47152 Updating the PA marketing page
    	//	String expectedTitle = "Get notified of new products with Product Alert";
    		String expectedTitle = "Receive new product updates with Product Alert";
    		Add_Log.info("Page title ::" + productAlertTitle);
    		
    		if(productAlertTitle.equals(expectedTitle)){
    			Add_Log.info("PA Marketing page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_MARKETING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Marketing page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PRODUCT_ALERTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! PA Marketing page is NOT displayed.");
       		throw(e);
       		}
       	return element;
    }
    
    /**
     * Enter text for 'Email' field.
     * 
     * @return
     * @throws Exception
     */
	public static WebElement txtbx_enterEmailAddress() throws Exception{
		try{
			element = driver.findElement(By.xpath("//input[@name='email']"));
			Add_Log.info("User is enter text for Email Address field."); 
			
		}catch(Exception e){
			Add_Log.error("Email Address field is NOT found on the page.");
			throw(e);
		}
		return element;
	}
		
	/**
	 * Click on 'Subscribe' button.
	 * 12-Jul-2017 MR#47152 Changed to "Sign me up" button.
	 * @return
	 * @throws Exception
	 */
	public static WebElement btn_clickSignMeUp() throws Exception{
		try{
		// 	element = driver.findElement(By.xpath("//input[@value='Subscribe']"));
			element = driver.findElement(By.xpath("//input[@value='Sign me up']"));
			Add_Log.info("Sign me up button is click on the page.");
			
		}catch(Exception e){
			Add_Log.error("Sign me up button is NOT found on the page.");
			throw(e);
		}
		return element;
	}

}
