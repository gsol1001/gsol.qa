/**
 * This Class contains methods that represent the locators available on Supplier Home Page
 * Created: Tue 12 May 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/05/12
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
 * Contains methods that represent the locators available on Supplier Registration page.
 * @author Teng Shyh Wei
 *
 */
public class SupplierRegistration_Page extends BaseClass{

	private static WebElement element = null;
    
    public SupplierRegistration_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Supplier Registration page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suppRegPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources Free Listing"));
    		    	
    		if(driver.getTitle().equals("Global Sources Free Listing")){
    			Add_Log.info("Supplier Registration page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Supplier Registration page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
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
    		element = driver.findElement(By.id("id_email"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Create Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCreatePassword() throws Exception{
    	try{
    		element = driver.findElement(By.id("id_password"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Confirm Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterConfirmPassword() throws Exception{
    	try{
    		element = driver.findElement(By.id("id_cfpasswd"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'First/Given Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFirstName() throws Exception{
    	try{
    		element = driver.findElement(By.id("id_e_fname"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Last/Family Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterLastName() throws Exception{
    	try{
    		element = driver.findElement(By.id("id_e_lname"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Company Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCompanyName() throws Exception{
    	try{
    		element = driver.findElement(By.id("id_e_company_name"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
}
