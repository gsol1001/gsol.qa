/**
 * This Class contains methods that represent the locators available on DOI Confirmation Page
 * Created: Fri 04 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/04
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
 * Contains methods that represent the locators available on DOI Confirmation Page.
 * @author Teng Shyh Wei
 *
 */
public class DOI_Confirmation_Page extends BaseClass{

	private static WebElement element = null;
    
    public DOI_Confirmation_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify DOI Confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_DOIConfirmationPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Request Confirmation"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Request Confirmation")){
    			Add_Log.info("DOI Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("DOI Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		Add_Log.error("Error! DOI Confirmation page is NOT displayed");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify message "Thank you! Your request is now complete!" is displayed in bold.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_confMsgDisplayedInBold(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Thank you! Your request is now complete!')]"));
    		String fontWeightText = element.getCssValue("font-weight");
    		
    		if(fontWeightText.equals("bold") || fontWeightText.equals("700")){
    			Add_Log.info("Message 'Thank you! Your request is now complete!' is displayed in bold.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CONF_MSG_DISPLAYED_IN_BOLD, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Message 'Thank you! Your request is now complete!' is NOT displayed in bold.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CONF_MSG_DISPLAYED_IN_BOLD, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify upgrade upsell section is available.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_upgradeUpsellSectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isUpgUpsellSecExists = driver.findElements(
    				By.xpath("//*[contains(text(),'Get more FREE services from Global Sources Online')]")).size() != 0;
    		Add_Log.info("Is upgrade upsell section available ::" + isUpgUpsellSecExists);
    		
    		if(isUpgUpsellSecExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPG_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPG_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
	
    /**
     * To click on 'Upgrade Free' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickUpgradeFree() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector("center > a > img"));
    		Add_Log.info("User is click on Upgrade Free button");
    		
    	}catch(Exception e){
    		Add_Log.error("Upgrade Free button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
