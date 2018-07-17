/**
 * This Class contains methods that represent the locators available on Compare Suppliers Page
 * Created: Fri 27 March 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/27
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

import utility.Read_XLS;

/**
 * Contains methods that represent the locators available on Compare Suppliers page.
 * @author Teng Shyh Wei
 *
 */
public class CompareSuppliers_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public CompareSuppliers_Page(WebDriver driver){
        	super(driver);
    }    
    
    /**
     * To verify Compare Suppliers page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_compareSuppPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Compare Suppliers"));
    		
    		if(driver.getTitle().equals("Global Sources - Compare Suppliers")){
    			Add_Log.info("Compare Suppliers page is displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_COMPARE_SUPP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Compare Suppliers page is NOT displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_COMPARE_SUPP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0,  true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Compare Suppliers page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
	
    /**
     * Check 'Select All' checkbox at Compare Suppliers page.
     * 
     * @return
     * @throws Exception
     */
	public static WebElement chkbx_selectCompareAllSuppliers() throws Exception{
		try{
			element = driver.findElement(By.id("listComSelectAll"));
			Add_Log.info("User is check on 'Select All' checkbox."); 
			
		}catch(Exception e){
			Add_Log.error("Select All checkbox is NOT found on the page.");
			throw(e);
		}
		return element;
	}
	
	/**
	 * Click 'Inquire Now' button at Compare Suppliers page.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement btn_clickInquireNow() throws Exception{
		try{
			element = driver.findElement(
					By.xpath("//*[contains(@class, 'listCom_act')]//a[contains(text(),'Inquire Now')]"));
			Add_Log.info("User is click on 'Inquire Now' button");
			
		}catch(Exception e){
			Add_Log.error("Inquire Now button is NOT found on the page.");
			throw(e);
		}
		return element;
	}

	/**
	 * Click on the 'Add to Basket' button.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement btn_clickAddToBasket() throws Exception{
		try{
			element = driver.findElement(By.xpath("//img[contains(@class, 'basketIco')]"));
			Add_Log.info("User is click on 'Add to Basket' button");
					
		}catch(Exception e){
			Add_Log.error("Add to Basket button is NOT found on the page.");
			throw(e);
		}
		return element;
	}
	
}
