/**
 * This Class contains methods that represent the locators available on New Products Page.
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
 * Contains methods that represent the locators available on New Products page.
 * @author Teng Shyh Wei
 *
 */
public class NewProducts_Page extends BaseClass{

    private static WebElement element = null;
    
    public NewProducts_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify New Products page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_newProductsPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("New Products"));
    		    	
    		if(driver.getTitle().equals("New Products")){
    			Add_Log.info("New Products page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEW_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("New Products page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEW_PRODUCTS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		Add_Log.error("Error! New Products page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Business Email" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.name("email"));
    		Add_Log.info("User is enter text for Business Email field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Subscribe" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubscribe() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Subscribe')]"));
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
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
    				By.xpath("//*[contains(@class, 'browsetop')]//*[text()='" + selectSub + "']"));  
    		Add_Log.info("User is click on "+selectSub+" category.");
    		
    	}catch(Exception e){
    		Add_Log.error(""+selectSub+" category is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
