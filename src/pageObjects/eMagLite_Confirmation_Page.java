/**
 * This Class contains methods that represent the locators available on eMag Lite Form Page
 * Created: Tue 01 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/01
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
 * Contains methods that represent the locators available on eMag Lite Confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class eMagLite_Confirmation_Page extends BaseClass{
	
	private static final Boolean True = null;
	private static WebElement element = null;
    
    public eMagLite_Confirmation_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify eMag Lite Confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagLiteConfPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Sourcing Magazines"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Sourcing Magazines")){
    			Add_Log.info("eMag Lite Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("eMag Lite Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		Add_Log.error("Error! eMag Lite Confirmation page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }

    /**
     * Click on 'Subscribe today' hyperlink at PAIDSUB section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSubscribeToday() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Subscribe today')]"));
    		Add_Log.info("User is click on 'Subscribe today' hyperlink at PAIDSUB section.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe today hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Global Sources's preferred magazine page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_elementSubsPage(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - magazines"));
    		
    		if(driver.getTitle().equals(("Global Souces - magazines"))){
    			Add_Log.info("Global Sources Preferred magazine page is displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_GS_PREF_EMAG_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Global Sources Preferred magazine page is NOT displayed");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_GS_PREF_EMAG_DISPLAYED, rowNum , Constant.KEYWORD_FAIL);
				testFail.set(0, True);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Global Sources's preferred magazine page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Business Email' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//form[@name='reqpalite']//input")); 
    		element.clear();
    		Add_Log.info("User is enter text for Business Email field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Subscribe' button.
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
     * Click on the 'Register Now!' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRegisterNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'registerdiv')]//a"));
    		Add_Log.info("Register Now! button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register Now! button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    // To verify that PAIDSUB, PA upsell and upgrade upsell section are available.
    
    /**
     * To verify PAIDSUB section are available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAIDSUBSectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'ht15')]"));
    	//	Boolean isPAIDSUBSecExists = element.isDisplayed();	
    		
    		Boolean isPAIDSUBSectionExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'ht15')]")).size()!=0;
    		Add_Log.info("Is PAIDSUB section available ::" + isPAIDSUBSectionExists);
    		
    		if(isPAIDSUBSectionExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_PAIDSUB_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_PAIDSUB_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PAIDSUB section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section are available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellSectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isPAUpsellSecExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'pal')]")).size()!=0;
    		Add_Log.info("Is PA upsell section available ::" + isPAUpsellSecExists);
    		
    		if(isPAUpsellSecExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SECTION_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SECTION_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PA upsell section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify upgrade upsell section are available on the page.
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
    		Boolean isUpgradeUpsellSecExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'register')]")).size()!=0;
    		Add_Log.info("Is upgrade upsell section available ::" + isUpgradeUpsellSecExists);
    		
    		if(isUpgradeUpsellSecExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_UPGRADE_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_UPGRADE_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Upgrade upsell section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
