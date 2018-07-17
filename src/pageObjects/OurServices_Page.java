/**
 * This Class contains methods that represent the locators available on Our Service Page
 * Created: Tue 01 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/01
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
 * Contains methods that represent the locators available on Our Services page.
 * @author Teng Shyh Wei
 *
 */
public class OurServices_Page extends BaseClass{
	
    private static WebElement element = null;
    
    public OurServices_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * To verify Our Services page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_ourServicesPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Buyer Tools - Buyer Marketing"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Buyer Tools - Buyer Marketing")){
    			Add_Log.info("Our Service page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OUR_SERVICES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Our Service page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OUR_SERVICES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		Add_Log.error("Error! Our Services page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on "Sample preview" link under eMag section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSamplePreview() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Sample preview')]"));
    		Add_Log.info("Sample preview link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sample preview link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
