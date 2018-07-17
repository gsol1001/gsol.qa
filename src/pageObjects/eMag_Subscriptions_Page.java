/**
 * This Class contains methods that represent the locators available on eMag Subscriptions Page.
 * Created: Tue 01 Dec 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/12/01
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
 * Contains methods that represent the locators available on eMag Subscription page.
 * @author Teng Shyh Wei
 *
 */
public class eMag_Subscriptions_Page extends BaseClass{

	private static WebElement element = null;
	
    public eMag_Subscriptions_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify eMag Subscription page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagSubscriptionsPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources magazines"));
    		    	
    		if(driver.getTitle().equals("Global Sources magazines")){
    			Add_Log.info("eMag Subscriptions page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_SUBS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("eMag Subscriptions page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_SUBS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("eMag Subscription page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on Free "e-magazine subscriptions" hyperlink.
    public static WebElement lnk_clickFreeEmagSubs() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'subscriptions')]"));
    		Add_Log.info("User is click on Free 'e-magazine subscriptions' hyperlink.");
    		
    	}catch(Exception e){
    		Add_Log.error("Free 'e-magazine subscriptions' hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Global Sources Magazines Mobile App' page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_GSMagazinesMobileAppPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources Magazines Mobile App"));
    		
    		if(driver.getTitle().equals("Global Sources Magazines Mobile App")){
    			Add_Log.info("Global Sources Magazine Mobile App page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GS_MAG_MOBILE_APP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Global Sources Magazine Mobile App page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GS_MAG_MOBILE_APP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Global Sources Magazines Mobile App page is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * To click on "Available on the App Store" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAvailableOnAppStore() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//img[contains(@src,'APPLE_APP')]"));
    		Add_Log.info("User is click on 'Available on the App Store' button.");
    		
    	}catch(Exception e){
    		Add_Log.error("'Available on the App Store' button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify App Store for Global Sources Magazines Mobile App is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_appStoreGSMagazineDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources Magazines on the App Store"));
    		
    		if(driver.getTitle().equals("Global Sources Magazines on the App Store")){
    			Add_Log.info("App Store for Global Sources Magazines Mobile App is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_APP_STORE_GS_EMAG_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("App Store for Global Sources Magazines Mobile App is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_APP_STORE_GS_EMAG_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! App Store for Global Sources Magazines Mobile App is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the "Available on Google Play" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAvailableOnGooglePlay() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//img[contains(@src,'GOOGLE_PLAY')]"));
    		Add_Log.info("User is click on 'Available on Google Play' button.");
    		
    	}catch(Exception e){
    		Add_Log.error("'Available on Google Play' button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Google Play for Global Sources Magazines Mobile App is displayed.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_googlePlayGSMagazineDisplayed(Read_XLS xls, String sheetName, int rowNum,
    	List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources Magazines ¨C Android Apps on Google Play"));
    		Add_Log.info("Print title ::" + driver.getTitle());
    		
    		if(driver.getTitle().equals("Global Sources Magazines ¨C Android Apps on Google Play")){
    			Add_Log.info("Google Play for Global Sources Magazines Mobile App is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GOOGLE_PLAY_GS_EMAG_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Google Play for Global Sources Magazines Mobile App is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GOOGLE_PLAY_GS_EMAG_EXISTS, rowNum, Constant.KEYWORD_FAIL);		
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Google Play for Global Sources Magazines Mobile App is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
}
