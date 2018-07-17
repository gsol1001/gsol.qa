/**
 * This Class contains methods that represent the locators available on Unverified Supplier PP Page
 * Created: Fri 15 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/15
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

public class UnvSupplierPP_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public UnvSupplierPP_Page(WebDriver driver){
        	super(driver);
    }
    
    // To verify Unverified Supplier PP page is displayed.
    public static WebElement check_unvSupplierPPPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName, String getPPName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]/p[1]"));
    		String printSuppName = suppNameElement.getText();
    		Add_Log.info("Print Supplier name ::" + getSuppName);
    		
    		WebElement ppNameElement = driver.findElement(By.xpath(""));
    		String printPPName = ppNameElement.getText();
    		Add_Log.info("Print PP name ::" + getPPName);
    		
    		if(printSuppName.equals(getSuppName) && printPPName.contains(printPPName)){
    			Add_Log.info("Passed. Unverified Supplier PP page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AGG_SUPP_PP_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. Unverified Supplier PP page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AGG_SUPP_PP_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! Unverified Supplier PP page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Close the Trade Match popup adv.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickCloseBtnOnTradeMatchAdv() throws Exception{
    	try{
    		Boolean isTradeMatchAdvExists = driver.findElements(By.id("tm_overlay")).size() != 0;
    		Add_Log.info("Is Trade Match popup adv displayed ::" + isTradeMatchAdvExists);
    		
    		if(isTradeMatchAdvExists == true){
    			// Close the Trade Match popup adv
    			driver.findElement(By.xpath("//*[@id='tm_overlay']/span")).click();
    			Add_Log.info("Trade Match popup adv is closed.");
    			
    		}else{
    			// do nothing
    		}
    	}catch(Exception e){
    		Add_Log.error("Trade Match popup adv is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Inquire Now" button.
    public static WebElement btn_clickInquireNow() throws Exception{
    	try{
    		element = driver.findElement(By.className("pp_inqBtn"));
    		Add_Log.info("User is click on Inquire Now button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    // ========================================================= Start of Left Nav section ==========================================================
    
    /**
     * To click on 'Get e-mail alerts on latest products!' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickPAEnhancedEntrance() throws Exception{
    	try{
    	/*	WebDriverWait waits = new WebDriverWait(driver, 25);    		
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("paTxt1")));
    		waits.until(ExpectedConditions.elementToBeClickable(By.id("paTxt1")));
    	*/	
    		// Wait for 3 seconds
    		Thread.sleep(3000);
    		driver.findElement(By.id("paTxt1")).click();
    		Add_Log.info("Get e-mail alerts on latest products link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Get e-mail alerts on latest products link is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
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
    public static WebElement txtbx_enterPAEnhancedEntrance() throws Exception{
    	try{
    		element = driver.findElement(By.id("paLiteTxt"));
    		Add_Log.info("User is enter text for PA Enhanced Entrance 'Business Email' field.");
    		
    	}catch(Exception e){
    		Add_Log.error("PA Enhanced Entrance Business Email field is NOT found on the page.");
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
    public static WebElement btn_clickSubscribe() throws Exception{
    	try{
    	//	element = driver.findElement(By.id("btId"));
    		driver.findElement(By.id("btId")).sendKeys(Keys.ENTER);
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
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
    		Boolean isTxtbxExists = driver.findElements(By.id("paLiteTxt")).size() != 0;
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
    		Add_Log.error("Error! Email address textbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== End of Left Nav section ===========================================================

    // ====================================================== Start of Contact Details section ======================================================
    
    // Enter text for RFI Static form.
    public static WebElement txtbx_enterRFIStaticForm() throws Exception{
    	try{
    		element = driver.findElement(By.id("inqmsgtextarea"));
    		Add_Log.info("User is enter text for RFI Static form.");
    		
    	}catch(Exception e){
    		Add_Log.error("RFI Static form is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Inquire Now" button.
    public static WebElement btn_clickContactDetailsInquireNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'contact_RFI_btn')]//a"));
    		Add_Log.info("User is click on Inquire Now button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT founs on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================= End of Contact Details section =======================================================
}
