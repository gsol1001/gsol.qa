/**
 * This Class contains methods that represent the locators available on SA Marketing Page.
 * Created: Fri 25 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/25
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on SA Marketing page.
 * @author Teng Shyh Wei
 *
 */
public class SA_Marketing_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public SA_Marketing_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify SA marketing pop-up page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_SAMarketingPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Supplier Alert"));
    		    	
    		if(driver.getTitle().equals("Supplier Alert")){
    			Add_Log.info("SA Marketing page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_MARKETING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("SA Marketing page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_MARKETING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		Add_Log.error("Error! SA Marketing page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Business Email field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector(".srch2"));
    		Add_Log.info("User is enter text for Business Email field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Send me updates' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSendMeUpdates() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Send me updates')]"));
    		Add_Log.info("Send me updates button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Send me updates button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

}
