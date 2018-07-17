/**
 * This Class contains methods that represent the locators available on Inquiry Basket Page
 * Created: Mon 16 March 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/16
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Inquiry Basket page.
 * @author Teng Shyh Wei
 *
 */
public class InquiryBasket_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public InquiryBasket_Page(WebDriver driver){
    	super(driver);
    }
    
    /**
     * To verify Inquiry Basket is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqBasketPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Inquiry Basket"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Inquiry Basket")){
    			Add_Log.info("Inquiry Basket page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Inquiry Basket page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Inquiry Basket page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the count (in red) beside the 'Inquiry basket' in Global navigation should indicate '50+'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_countInqBasket50Plus(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String inqBasketCountColor = driver.findElement(By.id("navcount")).getCssValue("color");
    		// rgb(204, 0, 0) equal to #CC0000 in Hex Color (Red color)
    		String redFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();    		
    		
            String countInqBasket = driver.findElement(By.id("navcount")).getText();
            String countInqBasketNo = countInqBasket.substring(1, countInqBasket.length()-1);
            Add_Log.info("Count beside Inquiry basket ::" + countInqBasketNo);
            
            if(inqBasketCountColor.equals(redFromRGB) && countInqBasketNo.equals("50+")){
            	Add_Log.info("Passed. The count beside the Inquiry basket in Global navigation is indicate 50+");
            	SuiteUtility.WriteResultUtility(
            			xls, sheetName, Constant.COL_COUNT_INQ_BASKET_MORE_THAN_50, rowNum, Constant.KEYWORD_PASS);
            }else{
            	Add_Log.info("Failed. The count beside the Inquiry basket in Global navigation is NOT indicate 50+");
            	SuiteUtility.WriteResultUtility(
            			xls, sheetName, Constant.COL_COUNT_INQ_BASKET_MORE_THAN_50, rowNum, Constant.KEYWORD_FAIL);
            	testFail.set(0, true);
            }
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify all the Inquiry Basket checkboxes are checked as default.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_allInquiryBasketChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxInqBasket = driver.findElements(
    				By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]//input[@type='checkbox']"));
    		Add_Log.info("Number of rows ::" + chkbxInqBasket.size());
    		for(WebElement chkbx : chkbxInqBasket){
    			if(chkbx.isSelected()){
    			//	Add_Log.info("All the Inquiry Basket checkboxes are checked as default");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_INQ_BASKET_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("All the Inquiry Basket checkboxes are NOT checked as default");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_INQ_BASKET_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
            		testFail.set(0, true);
    			}
    		}
    	}catch(Exception e){
    		throw(e);
    	}return element;
    }
    
    public static WebElement check_allInqBasketChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxInqBasket = driver.findElements(
    				By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]//input[@type='checkbox']"));
    		Add_Log.info("Number of rows ::" + chkbxInqBasket.size());
    		for(WebElement chkbx : chkbxInqBasket){
    			if(chkbx.isSelected()){
    			//	Add_Log.info("All the Inquiry Basket checkboxes are checked as default");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_INQ_BASKET_CHKBX_SELECTED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("All the Inquiry Basket checkboxes are NOT checked as default");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_INQ_BASKET_CHKBX_SELECTED, rowNum, Constant.KEYWORD_FAIL);
            		testFail.set(0, true);
    			}
    		}
    	}catch(Exception e){
    		throw(e);
    	}return element;
    }
    
    /**
     * To verify all the Inquiry Basket checkboxes are unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_allInqBasketChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxInqBasket = 
    				driver.findElements(By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]"
    						+ "//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxInqBasket){
    			if(!chkbx.isSelected()){    
    			//	Add_Log.info("All the Inquiry Basket checkboxes are unchecked.");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_INQ_BASKET_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_PASS);            	
    			}else{
    				Add_Log.info("NOT all the Inquiry Basket checkboxes are unchecked.");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_INQ_BASKET_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_FAIL);
            		testFail.set(0, true);
    			}
    		}
    	}catch(Exception e){
    		throw(e);
    	}return element;
    }    
    
    /**
     * To click on 'Sort' link in Supplier Name column.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSortBySupplierName() throws Exception{
    	try{
    		// 12-Jul-16 MR#43125		
    	//	element = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'width37_per sortTit')]"
    	//					+ "//*[contains(@class, 'inqBsk_sort')]//a[contains(text(),'Sort')]"));
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'inqBsk_bl')][contains(text(),'Supplier Name')]"));
    		Add_Log.info("Sort Supplier Name link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sort Supplier Name link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the PPs and suppliers are sorted by supplier name in ascending alphabetical order.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suppNameSortByAscending(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<String> displayedNames = new ArrayList<String>();
    		List<String> sortedNames = new ArrayList<String>();
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> verifySupplier = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[3]/p[1]")));
    		Add_Log.info("Number of supplier in Inquiry Basket page ::" + verifySupplier.size());
    		
    		for(WebElement element : verifySupplier){
    			Add_Log.info("" + element.getText());
    			displayedNames.add(element.getText());
    			sortedNames.add(element.getText());
    		}
    		
    		// Before sorting
    		Add_Log.info(displayedNames);
    		
    		// Sort the list
    		Collections.sort(sortedNames);
    		
    		// After sorting
    		Add_Log.info(sortedNames);
    		
    		if(displayedNames.equals(sortedNames)){
    			Add_Log.info("The PPs and suppliers are sorted by supplier name in ascending alphabetical order" + "\n ");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SORT_BY_SUPP_NAME_IN_ASC, rowNum, Constant.KEYWORD_PASS);    			
    		}else{
    			Add_Log.info("The PPs and suppliers are NOT sorted by supplier name in ascending alphabetical order");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SORT_BY_SUPP_NAME_IN_ASC, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the PPs and suppliers are sorted by supplier name in descending alphabetical order.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suppNameSortByDescending(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<String> displayedNames = new ArrayList<String>();
    		List<String> sortedNames = new ArrayList<String>();
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> verifySupplier = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[3]/p[1]")));
    		Add_Log.info("Number of supplier in Inquiry Basket page ::" + verifySupplier.size());
    		
    		for(WebElement element : verifySupplier){
    			Add_Log.info("" + element.getText());
    			displayedNames.add(element.getText());
    			sortedNames.add(element.getText());
    		}
    		
    		// Before sorting
    		Add_Log.info(displayedNames);
    		
    		// Sort the list
    		Collections.sort(sortedNames);    		
    		Collections.reverse(sortedNames);	// Reverse it
    		
    		// After reverse sorting
    		Add_Log.info(sortedNames);
    		
    		if(displayedNames.equals(sortedNames)){
    			Add_Log.info("The PPs and suppliers are sorted by supplier name in descending alphabetical order" + "\n ");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SORT_BY_SUPP_NAME_IN_DESC, rowNum, Constant.KEYWORD_PASS);    			
    		}else{
    			Add_Log.info("The PPs and suppliers are NOT sorted by supplier name in descending alphabetical order");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SORT_BY_SUPP_NAME_IN_DESC, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Filter' link in Supplier Name column.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickFilterBySuppName() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'width37_per sortTit')]"
    						+ "//*[contains(@class, 'inqBsk_sort')]//a[contains(text(),'Filter')]"));
    		Add_Log.info("Filter link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Filter link is NOT found on the page.");
    		throw(e);
    	}
    	return element;    	
    }
    
    /**
     * To click on 'Filter' button on Filter Products page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFilterOnFilterProductsPage() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[1]"));
    		Add_Log.info("Filter button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Filter button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquiry Basket page is refreshed with only results from selected suppliers are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param selectedSuppName
     * @return
     * @throws Exception
     */
    public static WebElement check_onlySelectedSuppDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String selectedSuppName) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> filterSupplier = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[2]/p[1]")));
			
    		List<String> displayedSuppName = new ArrayList<String>();
			for(WebElement element : filterSupplier){
				Add_Log.info("displayedSuppName ::" + element.getText());
				displayedSuppName.add(element.getText());
			}
			
			// Compare selected supplier name with displayed supplier name
			if(displayedSuppName.contains(selectedSuppName)){	
				Add_Log.info("Inquiry Basket page is refreshed with only results from selected suppliers are displayed" + "\n ");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ONLY_SELECTED_SUPP_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Inquiry Basket page is NOT refreshed with only results from selected suppliers are displayed.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ONLY_SELECTED_SUPP_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
   
    /**
     * To click on 'Show All' button on Filter Products page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickShowAllOnFilterProductsPage() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[2]"));
    		Add_Log.info("Show All button is click on the page.");
    		    		
    	}catch(Exception e){
    		Add_Log.error("Show All button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify Inquiry Basket page is refreshed with all the added Suppliers items are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param defaultSuppNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_allAddedSuppItemsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> defaultSuppNameList) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> allSuppliersNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[2]/p[1]")));
    		
			List<String> showAllSuppNameList = new ArrayList<String>();
			for (WebElement element : allSuppliersNameList){
				Add_Log.info("showAllSuppNameList ::" + element.getText());
				showAllSuppNameList.add(element.getText());
			}
			
			if(showAllSuppNameList.containsAll(defaultSuppNameList)){				
				Add_Log.info("Inquiry Basket page is refreshed with all added suppliers items are displayed" + "\n ");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_ADDED_SUPP_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Inquiry Basket page is NOT refreshed with all added suppliers items are displayed.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_ADDED_SUPP_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Filter by Product Category' link in Products column.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickFilterByProductCategory() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'width37_per')]//*[contains(@class, 'inqBsk_sort')]"
    						+ "//a[contains(text(),'Filter by Product Category')]"));
    		Add_Log.info("Filter by Product Category link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Filter by Product Category link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Filter' button on Filter Products page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFilterByPdtCatOnFilterProductsPage() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[1]"));
    		Add_Log.info("Filter button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Filter button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquiry Basket page is refreshed with only results from selected category are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param selectedCategoryName
     * @return
     * @throws Exception
     */
    public static WebElement check_onlySelectedCategoryDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String selectedCategoryName) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> filterCategory = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[3]/p[1]")));
			
			List<String> displayedCategoryName = new ArrayList<String>();
			for (WebElement element : filterCategory){
				Add_Log.info("displayedCategoryName ::" + element.getText());
				displayedCategoryName.add(element.getText());
			}
			
			if(displayedCategoryName.contains(selectedCategoryName)){
				Add_Log.info("Inquiry Basket page is refreshed with only results from selected category are displayed" + "\n ");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ONLY_SELECTED_CAT_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Inquiry Basket page is NOT refreshed with only results from selected category are displayed");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ONLY_SELECTED_CAT_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Show All' button on Filter Products page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickShowAllPdtCatOnFilterProductsPage() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[2]"));
    		Add_Log.info("Show All button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Show All button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquiry Basket page is refreshed with all the added category items are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param defaultCategoryList
     * @return
     * @throws Exception
     */
    public static WebElement check_allAddedCategoryItemsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> defaultCategoryList) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> allCategoryList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[3]/p[1]")));
    		
			List<String> showAllCategoryList = new ArrayList<String>();
			for (WebElement element : allCategoryList){
				Add_Log.info("showAllCategoryList ::" + element.getText());
				showAllCategoryList.add(element.getText());
			}
			
			if(showAllCategoryList.containsAll(defaultCategoryList)){
				Add_Log.info("Inquiry Basket page is refreshed with all added category items are displayed" + "\n ");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_ADDED_CAT_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);	
			}else{
				Add_Log.info("Inquiry Basket page is NOT refreshed with all added category items are displayed.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_ADDED_CAT_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Sort' link in Date Added column.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSortByDateAdded() throws Exception{
    	try{
    		// 12-Jul-16 MR#43125
    	//	element = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'width9_per sortTit')]"
    	//					+ "//*[contains(@class, 'inqBsk_sort')]//a[contains(text(),'Sort')]"));
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'inqBsk_bl')][contains(text(),'Date Added')]"));
    		Add_Log.info("Sort Date Added link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sort Date Added link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the PPs and suppliers are sorted by date in descending order.
     *     
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suppNameSortByDateDescending(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{

    		List<String> displayedDate = new ArrayList<String>();
    		List<String> sortedDate = new ArrayList<String>();
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> verifySupplier = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[4]")));
    		Add_Log.info("Number of row in this table ::" + verifySupplier.size());
    		
    		for(WebElement element : verifySupplier){
    		//	Add_Log.info("" + element.getText());
    			displayedDate.add(element.getText());
    			sortedDate.add(element.getText());
    		}
    		
    		// Before sorting
    		Add_Log.info(displayedDate);
    		
    		// Sort the list in descending order
    		Collections.sort(sortedDate);
    		Collections.reverse(sortedDate);
    		
    		// After sorting
    		Add_Log.info(sortedDate);
    		
    		if(displayedDate.equals(sortedDate)){
    			Add_Log.info("The PPs and suppliers are sorted by date in descending order");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SORT_BY_DATE_IN_DESC, rowNum, Constant.KEYWORD_PASS);   			
    		}else{
    			Add_Log.info("The PPs and suppliers are NOT sorted by date in descending order");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SORT_BY_DATE_IN_DESC, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To click on 'Filter' link in Date Added column.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickFilterByDateAdded() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'width9_per sortTit')]"
    						+ "//*[contains(@class, 'inqBsk_sort')]//a[contains(text(),'Filter')]"));
    		Add_Log.info("Filter link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Filter link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Filter' button on Filter Products page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFilterByDateOnFilterProductsPage() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[1]"));
    		Add_Log.info("Filter button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Filter button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquiry Basket page is refreshed with only results from selected date are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param selectedDate
     * @return
     */
    public static WebElement check_onlySelectedDateDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String selectedDate){
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> filterDate = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[4]")));
			
			List<String> displayedDate = new ArrayList<String>();
			for (WebElement element : filterDate){
			//	Add_Log.info("displayedDate ::" + element.getText());
				displayedDate.add(element.getText());
			}
			
			if(displayedDate.contains(selectedDate)){
				Add_Log.info("Inquiry Basket page is refreshed with only results from selected date are displayed." + "\n ");
	    		SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ONLY_SELECTED_DATE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Inquiry Basket page is NOT refreshed with only results from selected date are displayed");
				SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_ONLY_SELECTED_DATE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Show All' button on Filter Products page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_showAllDateOnFilterProductsPage() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[2]"));
    		Add_Log.info("Show All button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Show All button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquiry Basket page is refreshed with all the added items are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param defaultDateList
     * @return
     * @throws Exception
     */
    public static WebElement check_allAddedItemsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> defaultDateList) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
			List<WebElement> allDateList = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[4]")));
			
			List<String> showAllDateList = new ArrayList<String>();
			for (WebElement element : allDateList){
			//	Add_Log.info("showAllDateList ::" + element.getText());
				showAllDateList.add(element.getText());
			}
			
			if(showAllDateList.containsAll(defaultDateList)){
				Add_Log.info("Inquiry Basket page is refreshed with all the added items are displayed" + "\n ");
				SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.ALL_ADDED_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Inquiry Basket page is NOT refreshed with all the added items are displayed");
	    		SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.ALL_ADDED_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);		
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
            
    /**
     * To click on dustbin icon to remove a PP/supplier.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickDustbin() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=1]"));
    		Add_Log.info("Dustbin icon is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Dustbin icon is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify PP/Supplier is removed from Inquiry Basket.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param countInqBasketbefore
     * @return
     * @throws Exception
     */
    public static WebElement check_selectedPPSuppIsRemoved(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, int countInqBasketbefore) throws Exception{
    	try{
			String countInqBasketAgain = driver.findElement(By.id("navcount")).getText();
			int countInqBasketAfter = Integer.parseInt(countInqBasketAgain.substring(1, countInqBasketAgain.length()-1));
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketAfter);			
			
			if(countInqBasketAfter == countInqBasketbefore - 1){
				Add_Log.info("PP/Suppliers is removed from Inquiry Basket" + "\n ");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_PP_SUPP_IS_REMOVED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("PP/Suppliers is NOT removed from Inquiry Basket");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_PP_SUPP_IS_REMOVED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	
    
    /**
     * Set result pass when "PP/Suppliers is removed from Inquiry Basket".
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selectedPPSuppIsRemoved(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("PP/Suppliers is removed from Inquiry Basket" + "\n ");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_PP_SUPP_IS_REMOVED, rowNum, Constant.KEYWORD_PASS);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result fail when "PP/Suppliers is NOT removed from Inquiry Basket".
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selectedPPSuppIsNotRemoved(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("PP/Suppliers is NOT removed from Inquiry Basket");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_PP_SUPP_IS_REMOVED, rowNum, Constant.KEYWORD_FAIL);
			testFail.set(0, true);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * Click 'Remove All' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickRemoveAll() throws Exception{
    	try{
    		// Date 12-Jul-2016 MR#43125
    	//	driver.findElement(By.xpath("//*[contains(@class, 'inqBsk_sort')]//*[contains(text(),'Remove All')]")).click();
    		driver.findElement(By.xpath("//*[contains(@class, 'inqBsk_bl')][contains(text(),'Remove All')]")).click();
    		    		
    		// Get a handle to the open alert, prompt or confirmation
    		Alert alert = driver.switchTo().alert();    		    	
    		
    		// Accept the alert - equivalent of pressing OK
    		alert.accept();
    		
    		// Cancel the alert = equivalent of pressing CANCEL
    //		alert.dismiss();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	    
        
    /**
     * To click on 'Remove All' link and 'OK' button to accept the alert.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickRemoveAll_ClickOKToAccept(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		driver.findElement(By.xpath("//*[contains(@class, 'inqBsk_bl')][contains(text(),'Remove All')]")).click();
    		
    		// Get a handle to open alert, prompt for confirmation
    		Alert alert = driver.switchTo().alert();
    		    		
    		// Get pop up window message
    		String popupMessage = alert.getText();
    		Add_Log.info("Pop up window message ::" + popupMessage);
    		    		
    		String expectedMessage = "Are you sure you want to remove all items in the inquiry basket?";
    		
    		// To verify a pop up window with message "Are you sure you want to remove all items in inquiry basket?" is displayed.
    		if(popupMessage.equals(expectedMessage)){
    			Add_Log.info("Pop up window with message 'Are you sure you want to remove all items in inquiry basket?' is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MESSAGE_DEL_ALL_INQ_BASKET_ITEMS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Pop up window with message 'Are you sure you want to remove all items in inquiry basket?' is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MESSAGE_DEL_ALL_INQ_BASKET_ITEMS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    		// Accept the alert - equivalent of pressing Ok
    		alert.accept();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Remove All' link and 'Cancel' button to reject the alert.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickRemoveAll_ClickCancelToReject(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		driver.findElement(By.xpath("//*[contains(@class, 'inqBsk_bl')][contains(text(),'Remove All')]")).click();    	
    		
    		// Get a handle to open alert, prompt for confirmation
    		Alert alert = driver.switchTo().alert();
    		
    		// Get pop up window message
    		String popupMessage = alert.getText();
    		Add_Log.info("Pop up window message ::" + popupMessage);
    		    		
    		String expectedMessage = "Are you sure you want to remove all items in the inquiry basket?";
    		
    		// To verify a pop up window with message "Are you sure you want to remove all items in inquiry basket?" is displayed.
    		if(popupMessage.equals(expectedMessage)){
    			Add_Log.info("Pop up window with message 'Are you sure you want to remove all items in inquiry basket?' is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_DEL_ALL_INQ_BASKET_ITEMS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Pop up window with message 'Are you sure you want to remove all items in inquiry basket?' is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_DEL_ALL_INQ_BASKET_ITEMS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    		// Cancel the alert = equivalent of pressing CANCEL
    		alert.dismiss();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result pass when "Inquiry basket page with all the added items are displayed".
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allAddedItemsAreDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("Inquiry basket page with all the added items are displayed.");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_ALL_ADDED_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result fail when "Inquiry basket page with all the added items are NOT displayed".
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allAddedItemsAreNotDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("Inquiry basket page with all the added items are NOT displayed.");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.ALL_ADDED_ITEMS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
			testFail.set(0, true);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify all the items are removed from the Basket.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allAddedItemsRemoved(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isAllItemsRemoved = driver.findElements(By.name("inquiry")).size() != 0;
    		
    		if(isAllItemsRemoved == true){
    			Add_Log.info("All the items are NOT removed from the Basket");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_ADDED_ITEMS_REMOVED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			Add_Log.info("All the items are removed from the Basket");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_ADDED_ITEMS_REMOVED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * To verify message 'Your inquiry basket is empty' is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgYourInqBasketIsEmpty(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 11 Apr 2018 MR#47518 Change 'Your inquiry basket is empty' to 'You have no saved items'
    	/*	Boolean isMsgYourInqBasketIsEmptyExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'mt20')]"
    						+ "//*[contains(text(),'Your inquiry basket is empty')]")).size()!= 0;	*/
    		Boolean isMsgYouHaveNoSavedItemsExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'mt20')]"
    						+ "//*[contains(text(),'You have no saved items')]")).size() != 0;
    		Add_Log.info("Is message 'You have no saved items' available ::" + isMsgYouHaveNoSavedItemsExists);
    		
    		if(isMsgYouHaveNoSavedItemsExists == true){
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_YOUR_INQ_BASKET_IS_EMPTY_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_YOUR_INQ_BASKET_IS_EMPTY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To uncheck all the checkboxes for products and suppliers.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_uncheckedAllInqBasket() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'listing_table_tit')]"
    				+ "//input[@type='checkbox']"));
    		if(element.isSelected()){
    			element.click();
    		}
    		
    	/*	List<WebElement> chkbxInqBasket = 
    				driver.findElements(By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]"
    						+ "//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxInqBasket){
    			if(chkbx.isSelected()){    				
    				chkbx.click();
    			}else{
    				// do nothing
    			}
    		}	*/
    	}catch(Exception e){
    		throw(e);
    	}return element;
    }
    
    /**
     * To check the checkbox on ONE product.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectOneInqBasket() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'listing_table_row inqBsk_row')]"
    						+ "//input[@type='checkbox'])[position()=1]"));
    	}catch(Exception e){
    		throw(e);
    	}return element;
    }
    
    /**
     * To click Inquire Now button at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowAtInquiryBar() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
    		waits.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(@class, 'inquiryCon')]"
    				+ "//a[contains(text(),'Inquire Now')])[position()=1]")));
    		
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'inquiryCon')]"
    				+ "//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that the inquired PP is removed from the basket.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param defaultSuppNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_inquiredPPIsRemoved(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> defaultSuppNameList) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> allPPList = wait.
					until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[contains(@class, 'listing_table_row inqBsk_row')]/li[2]/p[1]")));
			
			List<String> remainPPList = new ArrayList<String>();
			for (WebElement element : allPPList){
				Add_Log.info("remainPPList ::" + element.getText());
				remainPPList.add(element.getText());
			}
			
			if(!remainPPList.equals(defaultSuppNameList)){
				Add_Log.info("The inquired PP is removed from the basket");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQUIRED_PP_IS_REMOVED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The inquired PP is NOT removed from the basket");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQUIRED_PP_IS_REMOVED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	
    
    /**
     * To clean up Inquiry Basket if available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_clearInquiryBasket() throws Exception{
    	try{
    		Boolean isInqBasketSectionExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'mt20')]")).size()!= 0;
    		Add_Log.info("Is Inquiry Basket section available ::" + isInqBasketSectionExists);
    		if(isInqBasketSectionExists == true){   
    			
    			// Click 'Remove All' link
    			InquiryBasket_Page.lnk_clickRemoveAll(); 
    			
    		}else{
    			// Do nothing
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    public static WebElement check_inqBasketNotContainItems() throws Exception{
    	try{
    		Boolean isInqBasketContainItems = 
    				driver.findElements(By.xpath("//.[contains(@class, 'mt20')]")).size()!= 0;
    		Add_Log.info("Inquiry Basket contain items ::" + isInqBasketContainItems);
    		if(isInqBasketContainItems == true){
    			// Clean Inquiry Basket items
    			InquiryBasket_Page.check_clearInquiryBasket();
    			
    		}
    	}catch(Exception e){
    		throw(e);
    	}return element;
    }
    
    // To clean up Inquiry Basket if there is an items in cart
    // Throw NoSuchElementException
    public static WebElement check_cleanUpInqBasketItems() throws Exception{
    	try{
    		Boolean isInqBasketCartContainItems = driver.findElements(By.id("navcount")).size() != 0;
    		Add_Log.info("Is Inquiry Basket cart contain items ::" + isInqBasketCartContainItems);
    		
    		if(isInqBasketCartContainItems == true){  
    			
    			GlobalNav_MenuBar.icon_clickInquiryBasketCart().click();
    			
    			// Remove all items
    			InquiryBasket_Page.lnk_clickRemoveAll();
    			
    			TopNav_MenuBar.lnk_backToGSOLHomePage();
    			
    		}
    	}catch(NoSuchElementException nse){
    		throw(nse);
    	}
    	return element;
    }
    
}