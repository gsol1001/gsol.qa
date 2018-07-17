/**
 * This Class contains methods that represent the locators available on Wholesale Drilldown Page
 * Created: Tue 12 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/12
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
 * Contains methods that represent the locators available on Wholesale Products Keyword page.
 * @author Teng Shyh Wei
 *
 */
public class WholesalePdtKeyword_Page extends BaseClass{

	private static WebElement element = null;
    
    public WholesalePdtKeyword_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Wholesale Products Keyword page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_wholesalePdtKeywordPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class,'path_link')]"));
    		String pathElement = element.getText();
    		Add_Log.info("Print path link ::" + pathElement);
    		
    		if(pathElement.equals("Wholesale Products")){
    			Add_Log.info("Wholesale Products page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_PDT_KEYWORD_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Wholesale Products page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_PDT_KEYWORD_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("China products from wholesale suppliers & distributors | Global Sources"));
    		    	
    		if(driver.getTitle().equals("China products from wholesale suppliers & distributors | Global Sources")){
    			Add_Log.info("Wholesale Products Keyword page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_PDT_KEYWORD_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Wholesale Products Keyword page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_PDT_KEYWORD_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
}
