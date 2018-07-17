/**
 * This Class contains methods that represent the locators available on Top Products Page
 * Created: Fri 11 Dec 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/12/11
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
 * Contains methods that represent the locators available on Top Products page.
 * @author Teng Shyh Wei
 *
 */
public class TopProducts_Page extends BaseClass{

	private static WebElement element = null;
    
    public TopProducts_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Top Products page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_topProductsPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Top products from China & Asia manufacturers"));
    		    	
    		if(driver.getTitle().equals("Top products from China & Asia manufacturers")){
    			Add_Log.info("Top Products page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TOP_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Top Products page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TOP_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    
    	}catch(Exception e){
    		Add_Log.error("Error! Top Products page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select L2 category based on value from input data.
     * 
     * @param selectSub
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickL2CategoryKeyword(String dataL2Category) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'browsetop')]//*[text()=\"" + dataL2Category + "\"]"));
    		Add_Log.info(""+dataL2Category+" link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("L2 category keyword is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select L3 category based on value from input data.
     * 
     * @param selectSub
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickL3CategoryKeyword(String dataL3Category) throws Exception{
    	try{
    		// Wait for element to be clickable
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("//*[contains(@class, 'darkblue')][text()='" + dataL3Category + "']")));
    		
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'darkblue')][text()='" + dataL3Category + "']"));
    		Add_Log.info(""+dataL3Category+" link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("L3 category keyword is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Gallery View link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickGalleryView() throws Exception {
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'viewList')]//a"));
    		Add_Log.info("Gallery View link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Gallery View link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on the "Inquire Now" button.
    public static WebElement btn_clickInquireNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'UItrigger_inquiryBox button')])[position()=1]"));
    		Add_Log.info("User is click on TP page Inquire Now button.");
    		
    	}catch(Exception e){
    		Add_Log.error("TP page Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * Click on the "Subscribe now" hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSubscribeNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Subscribe now')]"));
    		Add_Log.info("Subscribe now link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe now link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Get Free E-Magazine" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickGetFreeEmag11() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//a[contains(text(),'Get Free E-Magazine')])[position()=1]"));
    		Add_Log.info("Get Free E-Magazine button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Get Free E-Magazine button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
