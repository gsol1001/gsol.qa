/**
 * This Class contains methods that represent the locators available on PA Category Confirmation Page
 * Created: Mon 27 Jul 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/27
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Category Confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class PA_CategoryConf_Page extends BaseClass{
	
    private static WebElement element = null;
    
    public PA_CategoryConf_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * To verify Product Alert homepage is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PACategoryConfPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Product Alert"));
    		    	
    		if(driver.getTitle().equals("Product Alert")){
    			Add_Log.info("Product Alert Category Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_CAT_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Alert Category Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_CAT_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("Error! Product Alert Category Confirmation page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the Country/Territory drop down list.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_clickCountryTerritory() throws Exception{
    	try{
    		//Wait for element to be clickable 
    		WebDriverWait wait = new WebDriverWait(driver, 15); 
    		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#countryDrpdwn"))); 
    		
    		driver.findElement(By.cssSelector("#countryDrpdwn")).click();
    	}catch(Exception e){
    		Add_Log.error("Country/Territory drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the category is added to Product Alert. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param selectedPACategory
     * @return
     * @throws Exception
     */
    public static WebElement check_singlePACategoryAddedToPdtAlert(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String selectedPACategory) throws Exception{
    	try{			
			element = driver.findElement(By.xpath("//*[contains(@class, 'dotList')]/li"));
			String printPACategory = element.getText();
			Add_Log.info("Print PA category ::" + printPACategory);
			
			if(printPACategory.equals(selectedPACategory)){
				Add_Log.info("The categories is added to Product Alert.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_ADDED_TO_PA_EXISTS, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The categories is NOT added to Product Alert");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_ADDED_TO_PA_EXISTS, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify the category is added to Product Alert.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedCatNameList
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_categoryAddedToPdtAlert(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	try{
    		// Fixed on Date 07-Mar-2016
    	/*	WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> categoriesNameList = wait.
    				until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class, 'dotList')]/li")));
    	*/	
    		List<WebElement> categoriesNameList = driver.findElements(By.xpath("//*[contains(@class, 'dotList')]/li/a"));
    				
			List<String> addedCategoriesNameList = new ArrayList<String>();
			for (WebElement element : categoriesNameList){
				Add_Log.info("addedCategoriesNameList ::" + element.getText());
				addedCategoriesNameList.add(element.getText());
			}
			
			if(addedCategoriesNameList.containsAll(checkedCatNameList)){				
				Add_Log.info("The categories is added to Product Alert.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_ADDED_TO_PA_EXISTS, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The categories is NOT added to Product Alert");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_ADDED_TO_PA_EXISTS, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the category is added to Product Alert.
     * Test Case 5L PA_EditCategories_0011
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_categoryAddedToProductAlert(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	try{
    		List<WebElement> categoriesNameList = driver.findElements(
    				By.xpath("//*[contains(@class, 'dotList form_PA_cat regConf_PA_cat')]//li"));
    				
			List<String> addedCategoriesNameList = new ArrayList<String>();
			for (WebElement element : categoriesNameList){
				Add_Log.info("addedCategoriesNameList ::" + element.getText());
				addedCategoriesNameList.add(element.getText());
			}
			
			if(addedCategoriesNameList.containsAll(checkedCatNameList)){				
				Add_Log.info("The categories is added to Product Alert.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_ADDED_TO_PA_EXISTS, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The categories is NOT added to Product Alert");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_ADDED_TO_PA_EXISTS, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
}
