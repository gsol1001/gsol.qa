/**
 * This Class contains methods that represent the locators available on eMag Preference Page
 * Created: Wed 02 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/02
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
import org.openqa.selenium.support.Color;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on eMag Warning page.
 * @author Teng Shyh Wei
 *
 */
public class eMag_Warning_Page extends BaseClass{

	private static WebElement element = null;
    
    public eMag_Warning_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify eMag warning page is displayed indicating that user has already subscribed to eMag lite. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagWarningPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String eMagWarningTitle = driver.findElement(
    				By.xpath("//div[contains(text(), 'Registration required to process this request for this e-mail address')]")).getText();
    		String expectedTitle = "Registration required to process this request for this e-mail address";
    		Add_Log.info("Page title ::" + eMagWarningTitle);
    		
    		if(eMagWarningTitle.equals(expectedTitle)){
    			Add_Log.info("eMag warning page is displayed indicating that user has already subscribe to eMag lite.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_WARNING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);        		
    		}else{
    			Add_Log.info("eMag warning page is NOT displayed indicating that user has already subscribe to eMag lite.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_WARNING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("eMag Warning page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that message "Registration required to process this request for this e-mail address" is displayed in red color font.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagWarningMsgDisplayedInRed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//div[contains(text(), 'Registration required to process this request for this e-mail address')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		
			String fontColorErrorMsgTelNo = element.getCssValue("color");
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsgTelNo.equals(redFontFromRGB)){
				Add_Log.info("Message 'Registration required to process this request for this e-mail address' is displayed in red color font.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_WARNING_MSG_DISPLAYED_IN_RED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Message 'Registration required to process this request for this e-mail address' is NOT displayed in red color font.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_WARNING_MSG_DISPLAYED_IN_RED, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
