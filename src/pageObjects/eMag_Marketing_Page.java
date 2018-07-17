/**
 * This Class contains methods that represent the locators available on eMag Marketing Page
 * Created: Wed 09 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/09
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on eMag Marketing page.
 * @author Teng Shyh Wei
 *
 */
public class eMag_Marketing_Page extends BaseClass{

	private static WebElement element = null;
    
    public eMag_Marketing_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
    * To verify eMag Marketing page is displayed.
    * 
    * @param xls
    * @param sheetName
    * @param rowNum
    * @param testFail
    * @return
    * @throws Exception
    */
   public static WebElement check_eMagMarketingPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
   		List<Boolean> testFail) throws Exception{
   	try{
   		WebDriverWait wait = new WebDriverWait(driver, 25);
   		wait.until(ExpectedConditions.titleIs("Sourcing Magazines"));
   		    	
   		if(driver.getTitle().equals("Sourcing Magazines")){
   			Add_Log.info("eMag Marketing page is displayed");
   			SuiteUtility.WriteResultUtility(
   					xls, sheetName, Constant.COL_EMAG_MARKETING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
   		}else{
   			Add_Log.info("eMag Marketing page is NOT displayed.");
   			SuiteUtility.WriteResultUtility(
   					xls, sheetName, Constant.COL_EMAG_MARKETING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
   			testFail.set(0, true);
   		}
   	}catch(Exception e){
   		Add_Log.error("Error! eMag Marketing page is NOT displayed");
   		throw(e);
   	}
   	return element;
   }
}
