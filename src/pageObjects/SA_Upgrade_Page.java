/**
 * This Class contains methods that represent the locators available on SA Edit Categories Page.
 * Created: Wed 23 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/23
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
 * Contains methods that represent the locators available on SA Upgrade page.
 * @author Teng Shyh Wei
 *
 */
public class SA_Upgrade_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public SA_Upgrade_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Supplier Alert - Upgrade page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_SAUpgradePageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String SAUpgradeTitle = driver.findElement(By.xpath("//*[contains(@class, 'moduleheader')]")).getText();
    		String expectedTitle = "Supplier Alert";
    		Add_Log.info("Page title ::" + SAUpgradeTitle);
    		
    		if(SAUpgradeTitle.equals(expectedTitle)){
    			Add_Log.info("SA Upgrade page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_UPGRADE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("SA Upgrade page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_UPGRADE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		} 
    	}catch(Exception e){
    		Add_Log.error("Error! SA Upgrade page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Upgrade Now Free" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickUpgradeNowFree() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a"));
    		Add_Log.info("Upgrade Now Free button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Upgrade Now Free button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

}
