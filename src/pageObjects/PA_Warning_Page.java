/**
 * This Class contains methods that represent the locators available on PA Warning Page
 * Created: Fri 04 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/04
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
import org.openqa.selenium.support.Color;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Warning page.
 * @author Teng Shyh Wei
 *
 */
public class PA_Warning_Page extends BaseClass{

	private static WebElement element = null;
    
    public PA_Warning_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Warning page is displayed. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_warningPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("Print title ::" + driver.getTitle());
    		Add_Log.info("Print URLs ::" + driver.getCurrentUrl());
    		
    		element = driver.findElement(By.xpath("//*[contains(@class, 'moduleheader')][contains(text(),'Product Alert')]"));
    		String actualTitle = element.getText();
    		String expectedTitle = "Product Alert";
    		
    		if(actualTitle.equals(expectedTitle)){
    			Add_Log.info("PA Warning page is displayed.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_WARNING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Warning page is NOT displayed.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_WARNING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}    		    		    		
    	}catch(Exception e){
    		Add_Log.error("Error! PA Warning page is NOT displayed.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify that warning message "The e-mail address you've entered is already subscribed for Product Alerts." is displayed in red color.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_warningMsgDisplayedInRed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		//*[contains(text(),concat('The e-mail address you',"'",'ve entered is already subscribed for Product Alerts'))]
    		element = driver.findElement(By.xpath("//*[contains(text(),\"The e-mail address you've entered is already subscribed for Product Alerts\")]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		
    		String printText = element.getText();
    		Add_Log.info(printText);
    		
			String fontColorErrorMsg = element.getCssValue("color");
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsg.equals(redFontFromRGB)){
	    		Add_Log.info("Warning message 'The e-mail address you have entered is already subscribed for PA.' is displayed in red color.");
	    		SuiteUtility.WriteResultUtility(
	    				xls, sheetName, Constant.COL_PA_WARNING_MSG_DISPLAYED_IN_RED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Warning message 'The e-mail address you have entered is already subscribed for PA.' is NOT displayed in red color.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_WARNING_MSG_DISPLAYED_IN_RED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
			}
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * To click on the "register" link in the warning message.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickRegister() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//b[contains(text(),'register')]"));
    		Add_Log.info("Register link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
