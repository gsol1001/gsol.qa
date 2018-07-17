/**
 * This Class contains methods that represent the locators available on PA Lite Edit Categories Page.
 * Created: Mon 07 Jul 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/07
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

public class PALite_EditCategories_Page extends BaseClass{

    private static WebElement element = null;
	
    public PALite_EditCategories_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify PA Lite Edit Categories page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PALiteEditCategoriesPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Edit Alert Lite"));
    		    	
    		if(driver.getTitle().equals("Product Alert - Edit Alert Lite")){
    			Add_Log.info("PA Lite Edit Categories page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_EDIT_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Lite Edit Categories page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_EDIT_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		Add_Log.error("Error! PA Lite Edit Categories page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Register Now" link in the warning message.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickRegisterNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[@id='alertLimitOverlay']//Strong[contains(text(),'Register Now')]"));
    		Add_Log.info("Register Now link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register Now link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Register Now" button in the warning message.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRegisterNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='alertLimitOverlay']//*[@value='Register Now']"));
    		Add_Log.info("Register Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that upgrade upsell section is available.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_upgUpsellSecExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isUpgUpsellSecExists = driver.findElements(By.cssSelector(".regPromot.mt15")).size() != 0;
    		Add_Log.info("Upgrade upsell section is available ::" + isUpgUpsellSecExists);
    		
    		if(isUpgUpsellSecExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPG_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPG_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Upgrade upsell section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Register Now" link in upgrade upsell section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUpgradeUpsellRegisterNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'regPromot_tit')]//a"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Register Now link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register Now link is NOT found in upgrade upsell section");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Register Now" button in upgrade upsell section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickUpgradeUpsellRegisterNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Register Now')]"));
    		
    		Actions actions = new Actions(driver);
    		actions.moveToElement(element).build().perform();
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    		Add_Log.info("Register Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register Now button in NOT found in upgrade upsell section");
    		throw(e);
    	}
    	return element;
    }
}
