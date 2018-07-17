/**
 * This Class contains methods that represent the locators available on Email Page
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/07
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

import utility.Read_XLS;

/**
 * Contains methods that represent the locators available on Email page.
 * @author Teng Shyh Wei
 *
 */
public class Email_Page extends BaseClass{
	
    private static WebElement element = null;
       
    public Email_Page(WebDriver driver){
        	super(driver);
    }
	
	/**
	 * To click on 'Sign in' button.
	 * 
	 * @return
	 * @throws Exception
	 */
    public static WebElement btn_clickSignIn() throws Exception{
    	try{
    		element = driver.findElement(By.id("signIn"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Search Keyword' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterSearchKeyword() throws Exception{
    	try{
    		element = driver.findElement(By.id("gbqfb"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Search' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSearch() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//div[5]/div/div/table/tbody/tr[1]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify sender is 'Global Sources'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_senderIsGlobalSources(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath(""));
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify subject line is 'You're only one step away from contracting suppliers directly'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_subjectLineExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(text(),'only one step away from contracting suppliers directly')]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify header copy is 'Create a password now to send your inquiry!.'
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_headerCopyCreatePswExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(text(),'Create a password now to send your inquiry')]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify header copy is 'Click on the link now to send your inquiry!'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_headerCopyClickLinkExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Click on the link now to send your inquiry')]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify The copy 'Please click here to create a new password and release your inquiry to the supplier.' 
     * with 'here' as a hyperlink, is available.
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_copyClickHyperlinkHereExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("Please click here to create a new password and release your inquiry to the supplier')]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    // To verify that the message, attachments and buyer contact details are correct as of input in the Test Case 32A
    
    
    // To verify that the attachments can be opened.
    public static WebElement check_emailAttachmentsCanBeOpened(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
