/**
 * This Class contains methods that represent the locators available on Mini Registration Page.
 * Created: Tue 06 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/16
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
 * Contains methods that represent the locators available on Mini Registration page.
 * @author Teng Shyh Wei
 *
 */
public class MiniRegistration_Page extends BaseClass{
	
    private static WebElement element = null;
    
    public MiniRegistration_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * To verify Mini registration page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_miniRegistrationPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 19-Sep-2017 MR#47697 
    	//	String miniRegTitle = driver.findElement(By.xpath("//*[contains(@class, 'miniSSO_subTit')]")).getText();
    		String miniRegTitle = driver.findElement(By.xpath("//*[contains(@class, 'miniSSO_tit')]")).getText();
    		String expectedTitle = "Suppliers want inquiries from registered users ¡ª Register now for FREE.";
    		Add_Log.info("Page title ::" + miniRegTitle);
    		
    		if(miniRegTitle.equals(expectedTitle)){
    			Add_Log.info("Mini registration page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MINI_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Mini registration page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MINI_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Mini Registration page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Create a Password" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCreatePassword() throws Exception{
    	try{
        	element = driver.findElement(By.name("fld_UserPassword[0]"));
        	element.clear();	     
        	Add_Log.info("User is enter text for Create a Password field.");
        	
    	}catch(Exception e){
    		Add_Log.error("Create a Password field is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Enter text for "Re-enter Password" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterReEnterPassword() throws Exception{
    	try{
        	element = driver.findElement(By.name("cpass"));
        	element.clear();
        	Add_Log.info("User is enter text for Re-enter Password field.");
        	
    	}catch(Exception e){
    		Add_Log.error("Re-enter Password field is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    } 
    
    /**
     * Click on "Send Your Inquiry Now" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSendYourInquiryNow() throws Exception{
    	try{
    		// 18-Sep-2017 MR#47697 Changed "Send Your Inquiry Now" to "Continue to Next Step" button
        	// 26-Sep-2017 MR#47697 Changed back to "Send Your Inquiry Now" button
    		element = driver.findElement(By.xpath("//*[@value='Send Your Inquiry Now']"));
    	//	element = driver.findElement(By.xpath("//*[@value='Continue to Next Step']"));
        	WebDriverWait wait = new WebDriverWait(driver, 15);
        	wait.until(ExpectedConditions.elementToBeClickable(element));
        	
        	Add_Log.info("Send Your Inquiry Now button is click on the page.");
        	
    	}catch(Exception e){
    		Add_Log.error("Send Your Inquiry Now button is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    } 
    
    /**
     * Select drop down list for "Country/Territory".
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectCountryTerritory(String selectVal) throws Exception{
    	try{    		
    		WebElement dropdown = driver.findElement(By.id("regCountry")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){ 
 
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		Add_Log.error("Country/Territory drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Company Name field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCompanyName() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Company.CompanyName[0]"));
    		Add_Log.info("User is enter text for Company Name field.");
    	}catch(Exception e){
    		Add_Log.error("Company Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter Business Contact Number's Telephone Number.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterContactNumberTelephoneNumber() throws Exception{
    	try{
    		// 09-Mar-2017 MR#45847
    	//	element = driver.findElement(By.id("contact_detail_tel_number"));
    		element = driver.findElement(By.id("fld_PhoneNumber"));
    		Add_Log.info("User is enter text for Business Contact Number's Telephone Number field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business Contact Number's Telephone Number field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
