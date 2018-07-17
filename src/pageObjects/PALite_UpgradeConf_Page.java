/**
 * This Class contains methods that represent the locators available on PA Lite Upgrade Confirmation Page.
 * Created: Mon Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/14
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Lite Upgrade Confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class PALite_UpgradeConf_Page extends BaseClass{

    private static WebElement element = null;
	
    public PALite_UpgradeConf_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify PA Lite upgrade confirmation page with DOI reminder overlay is displayed.
     * 
     * @param xls 
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PALiteUpgConfPage_DOIReminderOverlayDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
            element = driver.findElement(By.id("DOI_overlay"));
            Boolean isDOIReminderOverlayExists = element.isDisplayed();
            
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Product Alert"));
    		    	
    		if((driver.getTitle().equals("Product Alert")) && (isDOIReminderOverlayExists == true)){
    			Add_Log.info("PA Lite upgrade confirmation page with DOI reminder overlay is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_UPG_CONF_PAGE_DOI_OVERLAY_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Lite upgrade confirmation page with DOI reminder overlay is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_UPG_CONF_PAGE_DOI_OVERLAY_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! PA Lite upgrade confirmation page with DOI reminder overlay is NOT displayed.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To click on 'Ok' button on DOI Reminder Overlay.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickDOIReminderOverlay_OkBtn() throws Exception{
    	try{
            element = driver.findElement(By.xpath("//*[contains(@class, 'mt15 tc')]/a"));
            Add_Log.info("User is click on Ok button on DOI Reminder Overlay.");
            
    	}catch(Exception e){
    		Add_Log.error("OK button on DOI Reminder Overlay is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify PA Lite Upgrade confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PALiteUpgConfPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Product Alert"));
    		    	
    		String actualTitle = driver.findElement(
    				By.xpath("//*[contains(@class, 'formBox')]/h1")).getText();
    	//	String expectedTitle = "Thank you for registering with Global Sources.";
    		Add_Log.info("Page title ::" + actualTitle);
    		
    	//	if(driver.getTitle().equals("Product Alert") && actualTitle.contains(expectedTitle)){
    		if(driver.getTitle().equals("Product Alert")){    		
    			Add_Log.info("PA Lite Upgrade Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_UPG_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Lite Upgrade Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LITE_UPG_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		Add_Log.error("PA Lite Upgrade confirmation page is displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'click here' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickOnClickHere() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'click here')]"));
    		Add_Log.info("Click here link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Click here link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify copy "You are now successfully following <supplier name> company." is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_copySuccFollowingExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String suppName) throws Exception{
    	try{ 		    		
    		Boolean isCopyExists = driver.findElements(By.xpath("//*[contains(@class, 'formMsg_txt')]"
    				+ "[contains(text(),\"You are now successfully following (" + suppName + ")\")]")).size() != 0;
    		Add_Log.info("Copy 'You are now successfully following (" + suppName + ").' is available ::" + isCopyExists);    		
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'You are now successfully following <supplier name> company' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify copy "To view - or edit - all the suppliers you're following, click here." is displayed in a yellow color background.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_copyViewEditSuppExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isCopyExists = driver.findElements(By.xpath("//*[contains(@class, 'formMsg_txt')]"
    				+ "[contains(text(),\"To view - or edit - all the suppliers you're following\")]"
    				+ "//a[contains(text(),'click here')]")).size() != 0;
    		Add_Log.info("Is copy 'To view - or edit - all the suppliers you're following, click here.' displayed ::" + isCopyExists);
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'To view - or edit - all the suppliers you're following, click here.' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that the PA categories selected in Select Product Alert Categories page are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	try{    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'dotList')]/li")));
    		
			List<String> displayedCatNameList = new ArrayList<String>();
			for (WebElement element : selectedCategoriesNameList){
				Add_Log.info("displayedCatNameList ::" + element.getText());
				displayedCatNameList.add(element.getText());
			}
			
			if(displayedCatNameList.containsAll(checkedCatNameList)){				
				Add_Log.info("PA categories selected in Select PA Categories page are displayed.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_LITE_UPG_CONF_PAGE, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("PA categories selected in Select PA Categories page are NOT displayed.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_LITE_UPG_CONF_PAGE, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
}

