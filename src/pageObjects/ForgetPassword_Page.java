/**
 * This Class contains methods that represent the locators available on Forget Password Page
 * Created: Thu 18 Jun 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/18
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
 * Contains methods that represent the locators available on Forget Password page.
 * @author Teng Shyh Wei
 *
 */
public class ForgetPassword_Page extends BaseClass{

    private static WebElement element = null;
    
    public ForgetPassword_Page(WebDriver driver){
        	super(driver);
    }
    
	/**
	 * To verify Forget Password page is displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_forgetPasswordPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String forgetPasswordTitle = driver.findElement(By.xpath("//*[contains(@class, 'pageheader')]")).getText();
    		String expectedTitle = "Forgot password?";
    		Add_Log.info("Page title ::" + forgetPasswordTitle);
    		
    		if(forgetPasswordTitle.equals(expectedTitle)){
    			Add_Log.info("Forget Password page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FORGET_PSW_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Forget Password page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FORGET_PSW_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Forget Password page is NOT displayed.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify 'Check Your E-mail' page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_checkYourEmailPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		// xpath not able to escape hyphen, so use cssSelector.
    		Boolean isTitleExists = driver.findElement(By.xpath("//*[contains(text(),'Check Your E-mail')]")).isDisplayed();
    		Add_Log.info("Is title 'Check your email' available on the page ::" + isTitleExists);
    		
    		String pageTitle = driver.findElement(By.cssSelector(".pageheader")).getText();
    		String expectedTitle = "Check Your E-mail";
    		
    		if(pageTitle.equals(expectedTitle)){
    			Add_Log.info("Check Your E-mail page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CHK_YOUR_EMAIL_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Check Your E-mail page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CHK_YOUR_EMAIL_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Check Your E-mail page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'E-mail Address' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterEmailAddress() throws Exception{
    	try{
        	element = driver.findElement(By.name("fld_userid"));
        	Add_Log.info("User is enter text for 'E-mail Address' field.");
        	
    	}catch(Exception e){
    		Add_Log.error("E-mail Address field is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Click on 'Submit' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubmit() throws Exception{
    	try{        		
        	element = driver.findElement(By.xpath("//*[@value='Submit']"));	
        	Add_Log.info("Submit button is click on the page.");
        	
    	}catch(Exception e){
    		Add_Log.error("Submit button is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }    
    
	/**
	 * To verify message "The e-mail address you entered is subscribed to receive Product Alert and/or e-Magazines updates only." 
	 * is displayed in red color font. 
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_msgEmailAddrSubsPAeMagDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		try{			
    		element = driver.findElement(By.xpath("//*[contains(text(),'The e-mail address you entered is "
    				+ "subscribed to receive Product Alert and/or e-Magazines updates only')]"));
			Boolean isMsgVisible = element.isDisplayed();  		  				
				
			String fontColorMsgBusinessEmail = element.getCssValue("color");			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
   					
			if(isMsgVisible == true && fontColorMsgBusinessEmail.equals(redFontFromRGB)){			
				Add_Log.info("Message 'The e-mail address you entered is subscribed to receive "
						+ "Product Alert and/or e-Magazines updates only.' is displayed in red color font");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_MSG_EMAIL_SUBS_TO_PA_EMAG_EXISTS, rowNum, Constant.KEYWORD_PASS);
			} else{				
				Add_Log.info("Message 'The e-mail address you entered is subscribed to receive "
						+ "Product Alert and/or e-Magazines updates only.' is NOT displayed in red color font");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_MSG_EMAIL_SUBS_TO_PA_EMAG_EXISTS, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);	
			}						
		}catch(Exception e){
       		throw(e);
       	}
       	return element;
	}
	
	/**
	 * To verify upgrade upsell section is displayed below the error message.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_upgradeUpsellSecIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		try{
			Boolean isUpgradeUpsellSecExists = driver.findElement(
					By.xpath("//*[contains(@class, 'errorMsg')]/following-sibling::p")).isDisplayed();
			Boolean isUpgradeUpsellDescExists = driver.findElement(
					By.xpath("//*[contains(@class, 'errorMsg')]/following-sibling::li")).isDisplayed();
			if(isUpgradeUpsellSecExists == true && isUpgradeUpsellDescExists == true){
				Add_Log.info("Upgrade upsell section is displayed below the error message");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_UPGRADE_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Upgrade upsell section is NOT displayed below the error message");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_UPGRADE_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}			
		}catch(Exception e){
			Add_Log.error("Upgrade upsell section is NOT found on the page.");
       		throw(e);
       	}
       	return element;
	}
				
	/**
	 * Click on the "Upgrade now" link.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement lnk_clickUpgradeNow() throws Exception{
		try{
			element = driver.findElement(By.xpath("//a[contains(text(),'Upgrade now')]"));
			Add_Log.info("Upgrade now link is click on the page.");
			
		}catch(Exception e){
			Add_Log.error("Upgrade now link is NOT found on the page.");
       		throw(e);
       	}
       	return element;
	}
	
	/**
	 * To verify message 'The e-mail address you entered is not registered with Global Sources.' is displayed in red color font. 
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_msgEmailNotRegisteredDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		try{			
    		element = driver.findElement(By.xpath("//*[contains(text(),'The e-mail address you entered "
    				+ "is not registered with Global Sources')]"));
			Boolean isMsgVisible = element.isDisplayed(); 		  				
				
			String fontColorMsgBusinessEmail = element.getCssValue("color");			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
   					
			if(isMsgVisible == true && fontColorMsgBusinessEmail.equals(redFontFromRGB)){			
				Add_Log.info("Message 'The e-mail address you entered is not registered with Global Sources.' "
						+ "is displayed in red color font");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_MSG_EMAIL_NOT_REG_IN_RED, rowNum, Constant.KEYWORD_PASS);
			} else{				
				Add_Log.info("Message 'The e-mail address you entered is not registered with Global Sources.' "
						+ "is NOT displayed in red color font");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_MSG_EMAIL_NOT_REG_IN_RED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);	
			}
						
		}catch(Exception e){
       		throw(e);
       	}
       	return element;
	}
    
    /**
     * To verify "Register now" link is displayed below the error message.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
	public static WebElement check_lnkRegisterNowDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		try{
			element = driver.findElement(By.xpath("//a[contains(text(),'Register now')]"));
			Boolean isLinkExists = element.isDisplayed();
			Add_Log.info("Is 'Register now' link displayed below the error message ::" + isLinkExists);
			
			if(isLinkExists == true){
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_LINK_REG_NOW_EXISTS, rowNum, Constant.KEYWORD_PASS);
			}else{
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_LINK_REG_NOW_EXISTS, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
		}catch(Exception e){
			Add_Log.error("Register now link is NOT found on the page.");
       		throw(e);
       	}
       	return element;
	}
	
	/**
	 * Click on the 'Register now' link.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement lnk_clickRegisterNow() throws Exception{
		try{
			element = driver.findElement(By.xpath("//a[contains(text(),'Register now')]"));
			Add_Log.info("Register now link is click on the page.");
			
		}catch(Exception e){
			Add_Log.error("Register now link is NOT found on the page.");
       		throw(e);
       	}
       	return element;
	}	

}
