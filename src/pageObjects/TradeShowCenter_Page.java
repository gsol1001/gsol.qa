/**
 * This Class contains methods that represent the locators available on Trade Show Center Page
 * Created: Fri 04 Dec 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/12/04
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Read_XLS;

/**
 * Contains methods that represent the locators available on Trade Show Center home page.
 * @author Teng Shyh Wei
 *
 */
public class TradeShowCenter_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public TradeShowCenter_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify the Trade Show Center page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_tradeShowCenterPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Trade shows, conferences, exhibitions - Trade Show Center - Global Sources"));
    		    	
    		if(driver.getTitle().equals("Trade shows, conferences, exhibitions - Trade Show Center - Global Sources")){
    			Add_Log.info("Trade Show Center page is displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_TRADE_SHOW_CENTER_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Trade Show Center page is NOT displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_TRADE_SHOW_CENTER_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
