/**
 * This Class contains methods that represent the locators available on Supplier Product List Page
 * Created: Thu 26 May 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/05/26
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

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

public class SupplierProductList_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public SupplierProductList_Page(WebDriver driver){
        	super(driver);
    }

    // To verify Supplier's Product List page is displayed.
    public static WebElement check_suppProductListPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		String catTitle = driver.findElement(By.xpath("//h1[contains(@class,'catTitle')]")).getText();
    		String expTitle = "Product List";
    		Add_Log.info("Print title ::" + catTitle);
    		
    		if(catTitle.contains(expTitle)){
    			Add_Log.info("Supplier's Product List page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_PDT_LIST_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Supplier's Product List page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_PDT_LIST_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    			testFail.set(0, true);
    		}
    	}catch (Exception e){
    		Add_Log.error("Error! Supplier Product List page is NOT displayed");
    		throw (e);
    	}
    	return element;
    }
    
    /**
     * Click on "Inquire on This Product" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInquireOnThisProduct() throws Exception{
    	try{
    	/*	WebDriverWait waits = new WebDriverWait(driver, 25);    		
    	//	waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("paTxt1")));
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("//a[contains(text(),'Inquire on This Product')]")));
    	*/
    		// Wait for 3 seconds
    		Thread.sleep(3000);
    		
    		// 28-Apr-17 MR#46135 
    	//	element = driver.findElement(By.xpath("//a[contains(text(),'Inquire on This Product')]"));
    		element = driver.findElement(By.className("pp_inqBtn"));
    		Add_Log.info("Inquire on This Product button is click on the page.");
    		
    	}catch (Exception e){
    		Add_Log.error("Inquire on This Product button is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());   
    		throw (e);
    	}
    	return element;
    }
    
    // To verify "Other categories you may find interesting" section is available on the page.
    public static WebElement check_OtherCategoriesMayInterestingExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{  		    		
    		Boolean isSectionExists = driver.findElements(By.xpath("//*[contains(@class,'mt20 otherIntBox')]")).size() != 0;
    		String proCatTitle = driver.findElement(By.className("proCatTitle")).getText();
    		String expTitle = "Other categories you may find interesting";
    		
    		Add_Log.info("Is 'Other categories you may find interesting' section exists ::" + isSectionExists);
    		Add_Log.info("Print title ::" + proCatTitle);
    		    		
    		if(isSectionExists == true && proCatTitle.equals(expTitle)){
    			Add_Log.info("Other categories you may find interesting section is available on the page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_OTHER_CAT_SECT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Other categories you may find interesting section is NOT available on the page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_OTHER_CAT_SECT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Other categories you may find interesting section is NOT available on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    
    
}
