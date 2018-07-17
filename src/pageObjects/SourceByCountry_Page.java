/**
 * This Class contains methods that represent the locators available on Source by Country page
 * Created: Thu 09 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/09
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Read_XLS;

/** 
 * Contains methods that represent the locators available on Source by Country page.
 * @author Teng Shyh Wei
 *
 */
public class SourceByCountry_Page extends BaseClass{

	private static WebElement element = null;
    
    public SourceByCountry_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Source by Country page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_sourceByCountryPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Country Search"));
    		
    		if(driver.getTitle().equals("Global Sources - Country Search")){
    			Add_Log.info("Source by Country page is displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_SOURCE_BY_COUNTRY_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Source by Country page is NOT displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_SOURCES_BY_COUNTRY_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Sources by Country page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'Select a category' field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectACategory(String selectVal) throws Exception{
    	try{
    		WebElement dropdown	= driver.findElement(By.name("select_category"));
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option"));
    		for(WebElement option : allOptions){
    			
    			if(option.getText().equals(selectVal)){
    				option.click();
    			}
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down value either 'Products' or 'Suppliers by name'.
     *  
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectSearchTypes(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.name("search_what")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){ 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Enter keywords:' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterKeywords() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'adSrch_query ui_input_tip inputTip')][@name='query']"));
    		Add_Log.info("User is enter text for Enter keywords field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Enter keyword field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Search All Countries/Territories' checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectSearchAllCountries() throws Exception{
    	try{
    		element = driver.findElement(By.name("country_filt"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Countries' checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectCountries(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.name("country_filt"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for (String check : list){
    			for (WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    		
    	}catch(Exception e){
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
    public static WebElement btn_clickSearch() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@value='Search']"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Advanced Search' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickAdvancedSearch() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Advanced Search')]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
}
