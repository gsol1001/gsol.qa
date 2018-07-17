/**
 * This Class contains methods that represent the locators available on Preferred Exhibitors Page
 * Created: Wed 20 May 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/05/20
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

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Preferred Exhibitors page.
 * @author Teng Shyh Wei
 *
 */
public class PreferredExhibitors_Page extends BaseClass{
	
    private static WebElement element = null;
	
    public PreferredExhibitors_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify My Preferred Exhibitors page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_myPreferredExhibitorsPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("My Preferred Exhibitors - Global Sources Trade Show Center"));
    		
    		if(driver.getTitle().equals("My Preferred Exhibitors - Global Sources Trade Show Center")){
    			Add_Log.info("My Preferred Exhibitors page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MY_PREF_EXHIBITORS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("My Preferred Exhibitors page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MY_PREF_EXHIBITORS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("My Preferred Exhibitors page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }

}
