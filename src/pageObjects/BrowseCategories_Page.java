/**
 * This Class contains methods that represent the locators available on Browse Categories Page
 * Created: Thu 09 July 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/09
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Browse Categories page.
 * @author Teng Shyh Wei
 *
 */
public class BrowseCategories_Page extends BaseClass{
	
	private static WebElement element = null;

    public BrowseCategories_Page(WebDriver driver){
        	super(driver);
    }
    
    // To verify Browse Categories page is displayed.
    public static WebElement check_browseCategoriesPageDisplayed() throws Exception{
    	try{
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Computer Product Suppliers' link (L1). (to be removed since is hardcode)
     * 
     * @return
     * @throws Exception
     */
/*    public static WebElement lnk_selectComputerProductSuppliers1hard() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Computer Product')]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * Select 'Communications and Networking' link (L2). (to be removed since is hardcode)
     * 
     * @return
     * @throws Exception
     */
/*    public static WebElement lnk_selectCommAndNetworking() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Communications and Networking')]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * Select L1 or L2 category based on value from input data.
     * 
     * @param selectSub
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickCategoryKeyword(String selectSub) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'categ-blk')]//*[contains(text(), \"" + selectSub + "\")]"));  
    		Add_Log.info(selectSub + " is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error(selectSub + " is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for the PA Inline Banner email address textbox.
     * 
     * @return
     * @throws Exception 
     */
    public static WebElement txtbx_enterPAInlineBannerEmailAddr() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("PAdropin2")));
    		
    		element = driver.findElement(By.xpath("//*[@id='PAdropin2']//input"));
    		
    	}catch(Exception e){
    		Add_Log.error("PA Inline Banner email address textbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Subscribe' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubscribe() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='PAdropin2']/table//a"));
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Browse Categories page with A 'Did you mean:xxxxx' message is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgDidYouMeanExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgExists = driver.findElements(
    						By.xpath("//*[contains(@class, 'guessKW')]//.[contains(text(),'Did you mean:')]")).size()!= 0;
    		Add_Log.info("Is Browse Categories page with A 'Did you mean:xxxxx' message is displayed ::" + isMsgExists);
    		
    		if(isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_DID_YOU_MEAN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_DID_YOU_MEAN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Did you mean: keyword' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickGuessKeyword() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'guessKW')]//a"));
    		Add_Log.info("User is click on 'Did you mean: {keyword}' link.");
    	}catch(Exception e){
    		Add_Log.info("Did you mean: {keyword} link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
