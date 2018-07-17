/**
 * This Class contains methods that represent the locators available on News Listing Page.
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on News Listing page.
 * @author Teng Shyh Wei
 *
 */
public class NewsListing_Page extends BaseClass{

    private static WebElement element = null;
    
    public NewsListing_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify the News Keyword Search results page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataSearchKeyword
     * @return
     * @throws Exception
     */
    public static WebElement check_newsKeywordSearchResultPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataSearchKeyword) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - News Search: " + dataSearchKeyword + ""));
    		
    		if(driver.getTitle().equals("Global Sources - News Search: " + dataSearchKeyword + "")){
    			Add_Log.info("The News keyword search result page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEWS_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The News keyword search result page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEWS_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! News keyword search result page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the Article title link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickArticleTitle() throws Exception{
    	try{
    	//	element = driver.findElement(
    	//			By.xpath ("(//*[contains(@class,'title_col')]//a)[position()=1]"));
    		element = driver.findElement(By.xpath("(//*[contains(@class,'title_col')]//a)[last()]"));
    		Add_Log.info("Article title link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Article title link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify there are suggested categories in PA cross promotion (centrewell) section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatPACrossPromotionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatPACrossPromotionExists = driver.findElements(By.xpath("//*[contains(@class, 'PAList')]")).size() != 0;
    		Add_Log.info("Is suggested categories in PA Cross Promotion (centrewell) section exists ::" + isSuggCatPACrossPromotionExists); 
    		
    		if(isSuggCatPACrossPromotionExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_IN_CENTREWELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_IN_CENTREWELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Suggested categories is NOT found in PA cross promotion (centrewell) section."); 
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the first category's checkbox is checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_firstCategoryChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'PAList')]/ul/li[1]/input")).isSelected();
    		Add_Log.info("Is first category chkbx selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_1ST_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_1ST_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("First category's checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * Check on any category checkboxes.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement chkbx_select2ndCategory() throws Exception{
		try{
			element = driver.findElement(By.xpath("//*[contains(@class, 'PAList')]/ul/li[2]/input"));
			Add_Log.info("User is click on 2nd category checkbox.");
			
		}catch(Exception e){
			Add_Log.error("2nd Category checkboxes are NOT found on the page.");
    		throw(e);
    	}
    	return element;
	}
	
	/**
	 * To verify the categories checkboxes are checked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_secondCategoryChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'PAList')]/ul/li[2]/input")).isSelected();
    		Add_Log.info("Is second category chkbx selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("2nd categories checkboxes are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Add Categories' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAddCategories() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'PAList')]//a[contains(text(),'Add Categories')]"));
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
    		Add_Log.info("Add categories button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add categories button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter Email Address in the PA cross promotion (centrewell) section textbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterEmailAddress() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector(".paSubscribe_email.ui_input_tip"));
    		Add_Log.info("User is enter Email Address in PA cross promotion (centrewell) section textbox."); 
    		
    	}catch(Exception e){
    		Add_Log.error("PA cross promotion (centrewell) section textbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Subscribe' button in the PA cross promotion (centrewell) section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubscribe() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'PAList')]//a[text()='Subscribe']"));
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the PA Enhanced Entrance 'Update me on new products' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUpdateMeOnNewProducts() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'Update me on new products')]"));
    		Add_Log.info("Update me on new products link is click on the page.");    		
    		
    	}catch(Exception e){
    		Add_Log.error("Update me on new products link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Email address textbox is displayed beside Enhanced Entrance link.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_txtbxEmailAddrBesideEnhancedEntranceLink(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isTxtbxExists = driver.findElements(By.id("emailBox")).size() != 0;
    		Add_Log.info("Is Email Address textbox displayed beside Enhanced Entrance link ::" + isTxtbxExists);
    		
    		if(isTxtbxExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ADDR_TXTBX_BESIDE_EE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ADDR_TXTBX_BESIDE_EE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Email address textbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for PA Enhanced Entrance 'Business Email' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPAEnhancedEntranceBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.id("paLiteTxt"));
    		Add_Log.info("User is enter text for Business Email field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on PA Enhanced Entrance 'Subscribe' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickPAEnhancedEntranceSubscribe() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribeSubmit")));
    	//	waits.until(ExpectedConditions.elementToBeClickable(By.id("subscribeSubmit")));
    		
    		element = driver.findElement(By.id("subscribeSubmit"));
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Close' icon in PA Catfish Banner.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_PACatfishBanner_ClickOnCloseBtn() throws Exception{
    	try{		
    		// Locate the PA Catfish Banner section
    		WebElement imgHover = driver.findElement(By.id("catfishAd"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the Rollover Larger Image
    		WebElement inqNowBtn = driver.findElement(By.id("catfishClose"));
    		inqNowBtn.click();
    		
    	}catch(Exception e){
    		Add_Log.error("PA Catfish Banner is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
