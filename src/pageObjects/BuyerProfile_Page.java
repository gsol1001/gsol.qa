/**
 * This Class contains methods that represent the locators available on Buyer Profile Page
 * Created: Fri 26 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/26
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
 * Contains methods that represent the locators available on Buyer Profile page.
 * @author Teng Shyh Wei
 *
 */
public class BuyerProfile_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public BuyerProfile_Page(WebDriver driver){
        	super(driver);
    }    

    /**
     * To verify Buyer Profile page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowName
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfilePageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Buyer Profile"));
    		    	
    		if(driver.getTitle().equals("Buyer Profile")){
    			Add_Log.info("Buyer Profile page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Buyer Profile page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Buyer Profile page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify Buyer Profile page is displayed. 
    public static WebElement check_buyerProfilePageIsDisplayed() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Buyer Profile"));
    		
    		if(driver.getTitle().equals("Buyer Profile")){
    			Add_Log.info("Buyer Profile page is displayed.");
    		}else{
    			Add_Log.info("Buyer Profile page is NOT displayed.");
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Buyer Profile page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the following options are available in the My Buyer Profile Setting section.
     * <p><ul>
     * <li> a. Always ask me before sending future inquiries
     * <li> b. Do not ask me again. Always disclose my Buyer Profile to suppliers.
     * <li> c. Do not ask me again. I do not wish to disclose my Buyer Profile to suppliers in relation to future inquiries
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfileSettingSectionExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isAlwaysAskRadioBtnExists = driver.findElement(By.id("radio1")).isDisplayed();
    		Boolean isAlwaysDiscloseRadioBtnExists = driver.findElement(By.id("radio3")).isDisplayed();
    		Boolean isAlwaysNotDiscloseRadioBtnExists = driver.findElement(By.id("radio2")).isDisplayed();
    		
    		Add_Log.info("Is Always Ask radio btn exists ::" + isAlwaysAskRadioBtnExists);
    		Add_Log.info("Is Always Disclose radio btn exists ::" + isAlwaysDiscloseRadioBtnExists);
    		Add_Log.info("Is Always Not Disclose radio btn exists ::" + isAlwaysNotDiscloseRadioBtnExists);
    		
    		if(isAlwaysAskRadioBtnExists==true && isAlwaysDiscloseRadioBtnExists == true &&
    				isAlwaysNotDiscloseRadioBtnExists == true){
    			Add_Log.info("My Buyer Profile Setting section is available on the page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SETTING_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("My Buyer Profile Setting section is NOT available on the page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SETTING_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("My Buyer Profile Setting section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Always ask before sending future inquiries' radio button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectAlwaysAsk() throws Exception{
    	try{
    		element = driver.findElement(By.id("radio1"));
    		Add_Log.info("Always ask before sending future inquiries radio button is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Always ask before sending future inquiries radio button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify "Always ask before sending future inquiries" radio button is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_radioBtnAlwaysAskIsSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.id("radio1"));
    		Boolean isRadioBtnSelected = element.isSelected();
    		Add_Log.info("Is Always ask before sending future inquiries radio button selected ::" + isRadioBtnSelected);
    		
    		if(isRadioBtnSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALWAYS_ASK_RADIO_BTN_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALWAYS_ASK_RADIO_BTN_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Always ask before sending future inquiries radio button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
