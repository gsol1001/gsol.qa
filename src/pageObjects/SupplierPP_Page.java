/**
 * This Class contains methods that represent the locators available on Supplier PP Page
 * Created: Tue 04 Jul 2017
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2017/07/04
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

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

public class SupplierPP_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public SupplierPP_Page(WebDriver driver){
        	super(driver);
    }

    // To verify Verified Supplier PP page is displayed.
    public static WebElement check_verifiedSupplierPPPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName, String getPPName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]/p[1]"));
            String getSuppNameMW = suppNameElement.getText();
            Add_Log.info("Print Supplier name ::" + getSuppNameMW);
            
            WebElement ppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'pp_spd')]"));
            String getPPNameMW = ppNameElement.getText();
            Add_Log.info("Print PP name ::" + getPPNameMW);
            
            if(getSuppNameMW.equals(getSuppName) && getPPNameMW.contains(getPPName)){
            	Add_Log.info("Passed. Verified Supplier PP page is displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_SUPP_PP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
             	
            }else{
             	Add_Log.info("Failed. Verified Supplier PP page is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_SUPP_PP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }
    	}catch(Exception e){
    		Add_Log.error("Error! Verified Supplier PP page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on the "Inquire Now" button.
    public static WebElement btn_clickInquireNow() throws Exception{
    	try{
    		element = driver.findElement(By.className("pp_inqBtn"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw (e);
    	}
    	return element;
    }
}
