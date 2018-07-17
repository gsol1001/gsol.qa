/**
 * This Class contains methods that represent the locators available on Top China Supplier Page
 * Created: Wed 09 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/09
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
 * Contains methods that represent the locators available on Top China Suppliers page.
 * @author Teng Shyh Wei
 *
 */
public class TopChinaSuppliers_Page extends BaseClass{

	private static WebElement element = null;
    
    public TopChinaSuppliers_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Top China Suppliers page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception if any other exception error occurred.
     */
    public static WebElement check_TopChinaSuppliersPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("China Suppliers & Manufacturers for Made In China Products"));
    		    	
    		if(driver.getTitle().equals("China Suppliers & Manufacturers for Made In China Products")){
    			Add_Log.info("Top China Suppliers page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TOP_CHN_SUPP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Top China Suppliers page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TOP_CHN_SUPP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! Top China Suppliers page is NOT found on the page.");
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
    public static WebElement lnk_clickL2CategoryKeyword(String selectSub) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'browsetop')]//a[text()='" + selectSub + "']"));
    		Add_Log.info("L2 category link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("L2 category link is NOT found on the page.");
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
    public static WebElement lnk_clickL3CategoryKeyword(String selectSub) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'darkblue')][text()='" + selectSub + "']"));
    		Add_Log.info("L3 category link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("L3 category link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on the "Inquire Now" button.
    public static WebElement btn_clickInquireNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'UItrigger_inquiryBox button')])[position()=1]"));
    		Add_Log.info("User is click on TCS page Inquire Now button.");
    		
    	}catch(Exception e){
    		Add_Log.error("TCS page Inquire Now button is NOT found on the page.");
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
    
    /**
     * Click on the "Get Free E-Magazine" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickGetFreeEmag() throws Exception{
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
