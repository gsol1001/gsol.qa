/**
 * This Class contains methods that represent the locators available on PA Lite Confirmation Page.
 * Created: Fri 19 June 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/19
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Lite Confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class PALite_Confirmation_Page extends BaseClass{
	
    private static WebElement element = null;
	
    public PALite_Confirmation_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * To verify PA Lite confirmation page is displayed. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PALiteConfPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Product Alert"));
    		    	
    		String actualTitle = driver.findElement(
    				By.xpath("//*[contains(@class, 'PA_LiteConfirm_main')]/h1")).getText();
    		String expectedTitle = "Thank you for subscribing to Product Alert.";
    		Add_Log.info("Page title ::" + actualTitle);
    		
    		if(driver.getTitle().equals("Product Alert") && actualTitle.equals(expectedTitle)){
    			Add_Log.info("PA Lite Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Lite Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		Add_Log.error("Error! PA Lite confirmation page is NOT displayed.");
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
    public static WebElement check_upgradeUpsellSecExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isUpgradeUpsellSectionExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'PA_LiteConfirm mt10')]")).size()!= 0;
    		Add_Log.info("Is upgrade upsell section available ::" + isUpgradeUpsellSectionExists); 
    		
        	if(isUpgradeUpsellSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_LITE_UPG_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_LITE_UPG_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("PA upgrade upsell section is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }

    /**
     * To verify that up to 10 PA categories selected in Select PA Categories page are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_upTo10CatSelAreDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isPACategories_MaxTenDisplayed = 
    				driver.findElements(By.xpath("//*[contains(@class, 'dotList form_PA_cat')]/li")).size() <= 10;
    	
    		Add_Log.info("Is up to 10 PA categories selected in Select PA Categories page are displayed ::" + isPACategories_MaxTenDisplayed); 
    		
        	if(isPACategories_MaxTenDisplayed == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_UP_TO_10_PA_CAT_SEL_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_UP_TO_10_PA_CAT_SEL_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Upgrade Free' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickUpgradeFree() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'tc mt5')]//a"));
    		Add_Log.info("Upgrade Free button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Upgrade Free button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Edit Categories' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickEditCategories() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector(".PA_editCat"));
    		Add_Log.info("Edit Categories link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Edit Categories link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for search keyword field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterGSOLSearchField() throws Exception{
    	try{
    	//	element = driver.findElement(By.id("gsolquery2"));
    		element = driver.findElement(By.id("gsolquery"));
    		element.clear();
    		Add_Log.info("User is enter text for GSOL search keyword field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Search keyword field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }                	       
    
    /**
     * Click on the 'Search' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickKeywordButtonSearch() throws Exception{
    	try{
    	//	element = driver.findElement(By.id("inAllBtnSearch"));
    		
    		WebElement element = driver.findElement(By.id("inAllBtnSearch"));        		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("User is click on the Search button");
    		
    	}catch(Exception e){
    		Add_Log.error("Search button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
  
}
