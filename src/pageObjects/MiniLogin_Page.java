/**
 * This Class contains all the methods in the Mini Login page
 * Created: Tue 19 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/19
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

/**
 * Contains methods that represent the locators available on Mini Login page.
 * @author Teng Shyh Wei
 *
 */
public class MiniLogin_Page extends BaseClass{

    private static WebElement element = null;
    
    public MiniLogin_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Mini Login page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataFirstName
     * @return
     * @throws Exception
     */
    public static WebElement check_miniLoginPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataFirstName) throws Exception{
    	try{
    		// 19-Sep-2017 MR#47697     		
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'miniSSO_subTit')]"));
    		element = driver.findElement(By.xpath("//*[contains(@class, 'miniSSO_tit')]"));
    		String miniLoginTitle = element.getText().trim();
    		String expectedTitle = "Hi " + dataFirstName + "! One more step to send your inquiry.";
    		Add_Log.info("Page title ::" + miniLoginTitle);
    		Add_Log.info("Exp title ::" + expectedTitle);
    		
    		if(miniLoginTitle.equals(expectedTitle)){
    			Add_Log.info("Mini Login page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MINI_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Mini Login page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MINI_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Mini Login page is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Password" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterUserPassword() throws Exception{
    	try{
    		element = driver.findElement(By.id("cPassword"));
    		Add_Log.info("User is enter text for Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Password field is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Send Your Inquiry Now" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSendYourInquiryNow() throws Exception{
    	try{
    		// 18-Sep-2017 MR#47697 Changed from "Send Your Inquiry Now" to "Continue to Next Step" button
    		// 26-Sep-2017 MR#47697 Changed back to "Send Your Inquiry Now" button
    		element = driver.findElement(By.xpath("//*[@value='Send Your Inquiry Now']"));
    	//	element = driver.findElement(By.xpath("//*[@value='Continue to Next Step']"));
    		Add_Log.info("Send Your Inquiry Now button is click on the page.");
    		
    	}catch(Exception e){    		
    		Add_Log.error("Send Your Inquiry Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on "Forgot password?" link at Mini Login overlay.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickForgotPassword() throws Exception{
    	try{
        	// 02-Feb-2018: Project v337 
    	//	element = driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]"));
    		element = driver.findElement(By.id("forgotPwdLink"));
    		Add_Log.info("Forgot password link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Forgot password link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Close' icon in Login overlay.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickCloseBtn() throws Exception{
    	try{
    	//	element = driver.findElement(By.xpath("//div[@id='login_overlay']/div"));
    		WebElement iframe = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginFrame')]"));
    		element = driver.findElement(
    				By.xpath("//div[contains(@class, 'ui_overlay_close formOverlay_close listClose')]"));
    		
    		Boolean isLoginOverlayExists = iframe.isDisplayed();
    		Add_Log.info("Is iframe Login overlay exists ::" + isLoginOverlayExists);
    		
    		if(isLoginOverlayExists == true){
    			element.click();
    			Add_Log.info("User is click on the Close icon in Login overlay.");
    		}else{
    			// do nothing
    		}
    	}catch(Exception e){
    		Add_Log.error("Login overlay is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
