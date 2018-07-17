/**
 * This Class contains methods that represent the locators available on Advanced Search Page
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

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Advanced Search page.
 * @author Teng Shyh Wei
 *
 */
public class AdvancedSearch_Page extends BaseClass{
	
	private static WebElement element = null;

    public AdvancedSearch_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * Close the Inline Banner.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_PAInlineBanner_ClickOnCloseBtn() throws Exception{
    	try{
    	//	element = driver.findElement(By.xpath(""));
    		// Locate the PA Inline Banner section
    		WebElement imgHover = driver.findElement(By.id("PAdropin"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the Close button
    		WebElement inqNowBtn = driver.findElement(By.xpath("//*[@id='PAdropin2']/div/a"));
    		inqNowBtn.click();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Advanced Search page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_advancedSearchPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Find products, manufacturers & suppliers - Global Sources"));
    		    	
    		if(driver.getTitle().equals("Find products, manufacturers & suppliers - Global Sources")){
    			Add_Log.info("Advanced Search page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADVANCED_SEARCH_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Advanced Search page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADVANCED_SEARCH_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}      		
    	}catch(Exception e){
    		Add_Log.error("Error! Advanced Search page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Advance Search box is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_advanceSearchBoxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isAdvSearchBoxExists = driver.findElements(By.cssSelector(".advanceSearchCon")).size() != 0;
    		Add_Log.info("Is Advance Search Box exists ::" + isAdvSearchBoxExists);
    		
    		if(isAdvSearchBoxExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADVANCE_SEARCH_BOX_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADVANCE_SEARCH_BOX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * Select radio button for 'I would like to:' field.
     * 
     * @param dataAdvSearchCondition
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectIWouldLikeTo(String dataAdvSearchCondition) throws Exception{
    	try{
    	//	WebElement radbtnNewSearch = driver.findElement(By.id("newSrch"));
    		WebElement radbtnWithinSearch = driver.findElement(By.id("withinSrch"));
    		
    		if(dataAdvSearchCondition.equalsIgnoreCase("new")){	
    			// do nothing as default selected
    			
    		}else if(dataAdvSearchCondition.equalsIgnoreCase("within")){
    			radbtnWithinSearch.click();
    			
    		}else{
    			// do nothing
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Search within this results' is selected in 'I Would Like To' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_radbtnWithinSearchIsSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRadbtnSelected = driver.findElement(By.id("withinSrch")).isSelected();
    		Add_Log.info("Is 'Search within this results' is selected in 'I Would Like To' field ::" + isRadbtnSelected);
    		
    		if(isRadbtnSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEARCH_WITHIN_RESULTS_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEARCH_WITHIN_RESULTS_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		} 
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'I am Looking for" field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectIAmLookingFor(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.name("search_what")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){     		
    			if(option.getText().equalsIgnoreCase(selectVal)){ 
    				option.click(); 
    			} 
    		}    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Products' is selected in 'I am Looking for:' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_IamLookingForPdtIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement drpDwn = driver.findElement(
    				By.xpath("//*[@name='search_what']//*[contains(text(),'Products')]"));
    		
    		if(drpDwn.isSelected()){
    			Add_Log.info("'Products' is selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_PRODUCTS, rowNum, Constant.KEYWORD_PASS);    			
    		}else{
    			Add_Log.info("'Products' is NOT selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_PRODUCTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Verified Suppliers' is selected in 'I am Looking for:' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_IamLookingForVerSuppIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement drpDwn = driver.findElement(
    				By.xpath("//*[@name='search_what']//*[contains(text(),'Verified Suppliers')]"));

    		if(drpDwn.isSelected()){
    			Add_Log.info("'Verified Suppliers' is selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_VER_SUPP, rowNum, Constant.KEYWORD_PASS);    
    		}else{
    			Add_Log.info("'Verified Suppliers' is NOT selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_VER_SUPP, rowNum, Constant.KEYWORD_FAIL); 
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Other Suppliers' is selected in 'I am Looking for:' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_IamLookingForUnvSuppIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement drpDwn = driver.findElement(
    				By.xpath("//*[@name='search_what']//*[contains(text(),'Other Suppliers')]"));
    		
    		if(drpDwn.isSelected()){
    			Add_Log.info("'Other Suppliers' is selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_UNV_SUPP, rowNum, Constant.KEYWORD_PASS);    
    		}else{
    			Add_Log.info("'Other Suppliers' is NOT selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_UNV_SUPP, rowNum, Constant.KEYWORD_FAIL); 
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'All Supplier types' is selected in 'I am Looking for:' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_IamLookingForAllSuppTypesIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement drpDwn = driver.findElement(
    				By.xpath("//*[@name='search_what']//*[contains(text(),'All Supplier types')]"));
    		
    		if(drpDwn.isSelected()){
    			Add_Log.info("'All Supplier types' is selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_ALL_SUPP_TYPES, rowNum, Constant.KEYWORD_PASS);    
    		}else{
    			Add_Log.info("'All Supplier types' is NOT selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_ALL_SUPP_TYPES, rowNum, Constant.KEYWORD_FAIL);  
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'News' is selected in 'I am Looking for:' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_IamLookingForNewsIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement drpDwn = driver.findElement(
    				By.xpath("//*[@name='search_what']//*[contains(text(),'News')]"));

    		if(drpDwn.isSelected()){
    			Add_Log.info("'News' is selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_NEWS, rowNum, Constant.KEYWORD_PASS);    
    		}else{
    			Add_Log.info("'News' is NOT selected in 'I am Looking for:' field.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_I_AM_LOOKING_FOR_NEWS, rowNum, Constant.KEYWORD_FAIL);  
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Please enter your Keyword(s)' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterYourKeyword() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'adSrch_query ui_input_tip inputTip')][@name='query']"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // Enter text for Advance Search Box 'Please enter your Keyword(s)' field.
    public static WebElement txtbx_enterAdvBoxKeyword() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'advanceSearchCon')]//*[@name='query']"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the keyword is entered in the keyword search textbox.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataSearchKeyword
     * @return
     * @throws Exception
     */
    public static WebElement check_txtbxKeywordIsEntered(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataSearchKeyword) throws Exception{
    	try{
    		// Get the text entered in 'Product Keyword' field
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'adSrch_query ui_input_tip')][@name='query']"));
    		String textEnteredInKeywordField = element.getAttribute("value");  
    		Add_Log.info("Print text entered ::" + textEnteredInKeywordField);
    		
    		if(textEnteredInKeywordField.equals(dataSearchKeyword)){
    			Add_Log.info("Product Keyword is entered in product keyword text box");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_KEYWORD_TXTBX_IS_ENTERED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Keyword is NOT entered in product keyword text box");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_KEYWORD_TXTBX_IS_ENTERED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select radio button for 'Search Method'.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectSearchMethod(String dataSearchMethod) throws Exception{
    	try{
    		Add_Log.info("Input Search Method ::" + dataSearchMethod);
    		WebElement radbtnAny = driver.findElement(By.xpath("//*[@value='matchany']"));
    		WebElement radbtnExact = driver.findElement(By.xpath("//*[@value='matchphrase']"));
    		
    		if(dataSearchMethod.equalsIgnoreCase("all")){	
    			// do nothing as default selected
    			
    		}else if(dataSearchMethod.equalsIgnoreCase("any")){
    			radbtnAny.click();
    			
    		}else if(dataSearchMethod.equalsIgnoreCase("exact")){
    			radbtnExact.click();
    			
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }

    /**
     * To verify 'Match all of my words' is selected in 'Search Method' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_radbtnMatchAllOfMyWordsIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMatchAllOfMyWordsSelected = driver.findElement(By.xpath("//*[@value='matchall']")).isSelected();
    		Add_Log.info("Is 'Match all of my words' selected in 'Search Method' field ::" + isMatchAllOfMyWordsSelected);
    		
    		if(isMatchAllOfMyWordsSelected == true){
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MATCH_ALL_OF_MY_WORDS_CHECKED, rowNum, Constant.KEYWORD_PASS);    			
    		}else{
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MATCH_ALL_OF_MY_WORDS_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Match any of my words' is selected in 'Search Method' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_radbtnMatchAnyOfMyWordsIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMatchAnyOfMyWordSelected = driver.findElement(By.xpath("//*[@value='matchany']")).isSelected();
    		Add_Log.info("Is 'Match any of my words' is selected in 'Search Method' field ::" + isMatchAnyOfMyWordSelected);
    		
    		if(isMatchAnyOfMyWordSelected == true){
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MATCH_ANY_OF_MY_WORDS_CHECKED, rowNum, Constant.KEYWORD_PASS);    			
    		}else{
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MATCH_ANY_OF_MY_WORDS_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;    	   
    }
        
    /**
     * To verify 'Match my exact phrase' is selected in 'Search Method' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_radbtnMatchMyExactPhraseIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMatchMyExactPhraseSelected = driver.findElement(By.xpath("//*[@value='matchphrase']")).isSelected();
    		Add_Log.info("Is 'Match my exact phrase' selected in 'Search Method' field ::" + isMatchMyExactPhraseSelected);
    		
    		if(isMatchMyExactPhraseSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MATCH_MY_EXACT_PHRASE_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MATCH_MY_EXACT_PHRASE_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'Just in the category'.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
	public static WebElement drpdwn_selectJustInTheCategories(String selectVal) throws Exception{
		try{    		
			// WebElement dropdown = driver.findElement(By.name("select_category"));
			// Date: 14-Jan-2016 Element attribute changed.
			WebElement dropdown = driver.findElement(By.name("select_l1_category"));
			List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
			for(WebElement option : allOptions){ 
				
				if(option.getText().equals(selectVal)){ 
					option.click(); 
				} 
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify 'All categories' is selected in 'Just in the category' field.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_allCategoriesIsSelected(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		try{
    		WebElement drpDwn = driver.findElement(
    				By.xpath("//*[@name='select_l1_category']//*[contains(text(),'All Categories')]"));

    		if(drpDwn.isSelected()){
    			Add_Log.info("'All categories' is selected in 'Just in the category' field.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_CATEGORIES_SELECTED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("'All categories' is NOT selected in 'Just in the category' field.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_CATEGORIES_SELECTED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}			
		}catch(Exception e){
			throw(e);			
		}
		return element;
	}
	
	/**
	 * To verify the product vertical (other than All categories) is selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataCategory
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_pdtVerticalIsSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataCategory) throws Exception{
		try{
			Select categoryList = new Select(driver.findElement(By.xpath("//*[@name='select_category']")));					
			String categorySelected = categoryList.getFirstSelectedOption().getText();
			Add_Log.info("Category selected ::" + categorySelected);
			
			if(categorySelected.equals(dataCategory)){
				Add_Log.info("Product vertical is selected.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_PDT_VERTICAL_IS_SELECTED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Product vertical is NOT selected.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_PDT_VERTICAL_IS_SELECTED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
		}catch(Exception e){
			throw(e);			
		}
		return element;
	}
	
	/**
	 * Select list box for 'Select Countries' field.
	 * 
	 * @param selectVal
	 * @return
	 * @throws Exception
	 */
	public static WebElement lstbx_selectCountries(String dataCountry) throws Exception{
		try{
			Select listbox = new Select(driver.findElement(By.name("country_filt")));
			listbox.selectByVisibleText(dataCountry);
			
		/*	WebElement lstbx = driver.findElement(By.name("country_filt"));
			List<WebElement> values = lstbx.findElements(By.tagName("option"));
			for (WebElement val : values) {
				if(val.getText().equals(selectVal)){
					val.click();
				}
			}	*/
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
		
	/**
	 * To verify 'All Countries' is selected in 'Select countries:' field.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */
	public static WebElement check_allCountriesIsSelected(Read_XLS xls, String sheetName, int rowNum, List<Boolean> testFail){
		try{
			Boolean isAllCountriesSelected = driver.findElement(
					By.xpath("//*[@name='country_filt']//option[contains(text(),'All Countries')]")).isSelected();
			Add_Log.info("Is All Countries selected in 'Select countries:' field ::" + isAllCountriesSelected);
			
			if(isAllCountriesSelected == true){
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_COUNTRIES_SELECTED, rowNum, Constant.KEYWORD_PASS);
			}else{
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_ALL_COUNTRIES_SELECTED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
		
	/**
	 * To verify Country (e.g: Taiwan) is selected in "Select countries:" field. (Other than All Countries)
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataCountry
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_inputCountryIsSelected(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataCountry) throws Exception{
		try{
			Select countryList = new Select(driver.findElement(By.xpath("//*[@name='country_filt']")));					
			String countryValue = countryList.getFirstSelectedOption().getText();
			Add_Log.info("Selected Country ::" + countryValue);
			
			if(countryValue.equals(dataCountry)){
				Add_Log.info("Country (Other than 'All Countries') is selected.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INPUT_COUNTRY_IS_SELECTED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Country (Other than 'All Countries') is NOT selected.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INPUT_COUNTRY_IS_SELECTED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	
	/**
	 * Click on 'Search' button.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement btn_clickSearch() throws Exception{
		try{
			element = driver.findElement(
					By.xpath("//*[contains(@class, 'searchbox advancedSearchBox')]//*[@value='Search']"));
			
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * Click on 'Search' button at Advanced Search Box.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement btn_clickAdvBoxSearch() throws Exception{
		try{
			element = driver.findElement(
					By.xpath("//*[contains(@class, 'advanceSearchBox')]//*[@value='Search']"));
			
		}catch(Exception e){
			throw(e);
		}
		return element;
	}

	// ======================================================= Start of Product Advanced Search =====================================================
	
	/**
	 * To verify the results displayed contains all of the keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataSearchKeyword
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @param data3rdKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_pdtResultsContainsAllKeywords(Read_XLS xls, String sheetName, int rowNum, List<Boolean> testFail, 
			String dataSearchKeyword, String data1stKeyword, String data2ndKeyword, String data3rdKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath(""));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allPdtTitle = resultlink.getText();
				results.add(allPdtTitle);
				Add_Log.info("Print all Products title ::" + allPdtTitle);
				
				if(allPdtTitle.toLowerCase().contains(data1stKeyword.toLowerCase()) &&
						allPdtTitle.toLowerCase().contains(data2ndKeyword.toLowerCase()) &&
						allPdtTitle.toLowerCase().contains(data3rdKeyword.toLowerCase())){
				
					Add_Log.info("The results displayed contains all of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains all of the keyword entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);					
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains at least one of the keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @param data3rdKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_pdtResultsContainsAtLeastOneKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword, String data3rdKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath(""));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allPdtTitle = resultlink.getText();
				results.add(allPdtTitle);
				Add_Log.info("Print all Products title ::" + allPdtTitle);
				
				if(allPdtTitle.toLowerCase().contains(data1stKeyword.toLowerCase()) ||
						allPdtTitle.toLowerCase().contains(data2ndKeyword.toLowerCase()) ||
						allPdtTitle.toLowerCase().contains(data3rdKeyword.toLowerCase())){
					
					Add_Log.info("The results displayed contains at least one of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_PASS);					
				}else{
					Add_Log.info("The results displayed does NOT contains at least one of the keyword entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains exact match of the keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataSearchKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_pdtResultsContainsExactMatchKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataSearchKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath(""));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allPdtTitle = resultlink.getText();
				results.add(allPdtTitle);
				Add_Log.info("Print all Products title ::" + allPdtTitle);
				
				if(allPdtTitle.toLowerCase().contains(dataSearchKeyword.toLowerCase())){
					Add_Log.info("The results displayed contains exact match of the keywords entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains exact match of the keywords entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}			
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	// To verify the results displayed contains only the matching PPs from the selected product vertical in Advance search box.
	public static WebElement check_pdtResultsFilteredByPdtVertical(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean>testFail, String dataSearchKeyword) throws Exception{
		try{
			Add_Log.info("Input data search keyword ::" + dataSearchKeyword);
			
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	// To verify the results displayed contains only the matching PPs from the selected country in Advance search box.
	public static WebElement check_pdtResultsFilteredByCountry(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataSearchKeyword) throws Exception{
		try{
			Add_Log.info("Input data search keywords ::" + dataSearchKeyword);
			
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	// ========================================================= End of Product Advanced Search =====================================================
	
	// ======================================================= Start of Supplier Advanced Search ====================================================
	
	/**
	 * To verify the results displayed contains all of the verified suppliers that match the keyword entered in Advance search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_verSuppResultsContainsAllKeywords(Read_XLS xls, String sheetName, int rowNum, List<Boolean> testFail, 
			String data1stKeyword, String data2ndKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'supplierName_tit')]//a"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allSuppName = resultlink.getText();
				results.add(allSuppName);
				Add_Log.info("Print all Supplier Name ::" + allSuppName);
				
				if(allSuppName.toLowerCase().contains(data1stKeyword.toLowerCase()) &&
						allSuppName.toLowerCase().contains(data2ndKeyword.toLowerCase())){
					
    				Add_Log.info("The results displayed contains all of the keyword entered in Advance seach box");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
    				Add_Log.info("The results displayed do NOT contains all of the keyword entered in Advance search box");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains all of the verified suppliers that match at least one of the keyword entered in Advance search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_verSuppResultsContainsAtLeastOneKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'supplierName_tit')]//a"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allSuppName = resultlink.getText();
				results.add(allSuppName);
				Add_Log.info("Print all Supplier Name ::" + allSuppName);
			
				if(allSuppName.toLowerCase().contains(data1stKeyword.toLowerCase()) ||
						allSuppName.toLowerCase().contains(data2ndKeyword.toLowerCase())){
					
					Add_Log.info("The results displayed contains at least one of the keywords entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains at least one of the keywords entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains all of the verified suppliers that match the exact keyword entered in Advance search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_verSuppResultsContainsExactMatchKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'supplierName_tit')]//a"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allSuppName = resultlink.getText();
				results.add(allSuppName);
				Add_Log.info("Print all Supplier Name ::" + allSuppName);
				
				if(allSuppName.toLowerCase().contains(data1stKeyword.toLowerCase())){
					Add_Log.info("The results displayed contains all of the verified suppliers that match the "
							+ "exact keyword entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains all of the verified suppliers that "
							+ "match the exact keyword entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	// ========== Unverified Suppliers
	
	/**
	 * To verify the results displayed contains all of the unverified suppliers 
	 * that match the keyword entered in Advance search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_unvSuppResultsContainsAllKeywords(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'supplierName')]//a"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allUnvSuppName = resultlink.getText();
				results.add(allUnvSuppName);
				Add_Log.info("Print all Unv Supp Name ::" + allUnvSuppName);
				
				if(allUnvSuppName.toLowerCase().contains(data1stKeyword.toLowerCase()) &&
						allUnvSuppName.toLowerCase().contains(data2ndKeyword.toLowerCase())){
					
					Add_Log.info("The results displayed contains all of the unverified suppliers that "
							+ "match the keyword entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains all of the unverified suppliers that "
							+ "match the keyword entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}		
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains all of the unverified suppliers 
	 * that match at least one of the keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_unvSuppResultsContainAtLeastOneKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'supplierName')]//a"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allUnvSuppName = resultlink.getText();
				results.add(allUnvSuppName);
				Add_Log.info("Print all Unv Supp Name ::" + allUnvSuppName);
				
				if(allUnvSuppName.toLowerCase().contains(data1stKeyword.toLowerCase()) ||
						allUnvSuppName.toLowerCase().contains(data2ndKeyword.toLowerCase())){
					
					Add_Log.info("The results displayed contains all of the unverified suppliers that "
							+ "match at least one of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains all of the unverified suppliers that "
							+ "match at least one of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains all of the unverified suppliers 
	 * that match the exact keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataSearchKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_unvSuppResultsContainsExactMatchKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataSearchKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'supplierName')]//a"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allUnvSuppName = resultlink.getText();
				results.add(allUnvSuppName);
				Add_Log.info("Print all Unv Supp Name ::" + allUnvSuppName);
				
				if(allUnvSuppName.toLowerCase().contains(dataSearchKeyword.toLowerCase())){
					Add_Log.info("The results displayed contains all of the unverified suppliers that "
							+ "macth the exact keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains all of the unverfied suppliers that"
							+ "match the exact keyword entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	// ========== All Supplier types
	
	/**
	 * To verify the results displayed contains all of the verified and unverified suppliers 
	 * that match the keyword entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_allSuppResultsContainsAllKeywords(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String data1stKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//a[contains(@class, 'supplierTit')]"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allUnvSuppTitle = resultlink.getText();
				results.add(allUnvSuppTitle);
				Add_Log.info("Print all verified and unverified suppliers name ::" + allUnvSuppTitle);
				
				if(allUnvSuppTitle.toLowerCase().contains(data1stKeyword.toLowerCase())){
					Add_Log.info("The results displayed contains all of the verified and unverified suppliers"
							+ "that match the keyword entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contain all of the verified and unverified");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains all of the verified and unverified suppliers 
	 * that match at least one of the keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_allSuppResultsContainsAtLeastOneKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//a[contains(@class, 'supplierTit')]"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allSuppTitle = resultlink.getText();
				results.add(allSuppTitle);
				Add_Log.info("Print all verified and unverified suppliers name ::" + allSuppTitle);
				
				if(allSuppTitle.toLowerCase().contains(data1stKeyword.toLowerCase()) &&
						allSuppTitle.toLowerCase().contains(data2ndKeyword.toLowerCase())){
					Add_Log.info("The results displayed contains all of the verified and unverified suppliers"
							+ "that match at least one of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains all of the verified and unverified suppliers"
							+ "that match at least one of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}						
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains all of the verified and unverified suppliers 
	 * that match the exact keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_allSuppResultsContainsExatchMatchKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//a[contains(@class, 'supplierTit')]"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultlink = element.get(i);
				String allSuppName = resultlink.getText();
				results.add(allSuppName);
				Add_Log.info("Print all verified and unverified suppliers name ::" + allSuppName);
				
				if(allSuppName.toLowerCase().contains(data1stKeyword.toLowerCase())){
					Add_Log.info("The results displayed contains all of the verified and unverified suppliers"
							+ "that match the exact keyword entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displlayed does NOT contains all of the verified and unverified suppliers "
							+ "that match the exact keyword entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	// ======================================================== End of Supplier Advanced Search =====================================================
	
	// ========================================================= Start of News Advanced Search ======================================================
	
	/**
	 * To verify the results displayed contains all of the keywords entered in Advanced search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @param data3rdKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_newsResultsContainsAllKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword, String data3rdKeyword) throws Exception{
		try{
    		List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'news_title')]"));
    		List<String> results = new ArrayList<String>();
    		int num = element.size();
    		for(int i=0; i<num; i++){
    			WebElement resultlink = element.get(i);
    			String allNewsTitle = resultlink.getText();
    			results.add(allNewsTitle);
    			Add_Log.info("Print all News Title ::" + allNewsTitle);
    			    		    			
    			if(allNewsTitle.toLowerCase().contains(data1stKeyword.toLowerCase()) &&
    					allNewsTitle.toLowerCase().contains(data2ndKeyword.toLowerCase()) &&
    					allNewsTitle.toLowerCase().contains(data3rdKeyword.toLowerCase())){	

    				Add_Log.info("The results displayed contains all of the keyword entered in Advance seach box");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("The results displayed do NOT contains all of the keyword entered in Advance search box");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_RESULTS_CONTAIN_ALL_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}
    		}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains at least one of the keywords entered in Advance search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @param data3rdKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_newsResultsContainsAtLeastOneKeywords(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String data1stKeyword, String data2ndKeyword, String data3rdKeyword) throws Exception{
		try{
			Add_Log.info("Input data search keyword ::" + data1stKeyword + " " + data2ndKeyword + " " + data3rdKeyword);
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'news_title')]"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultLink = element.get(i);
				String allNewsTitle = resultLink.getText();
				results.add(allNewsTitle);
				Add_Log.info("Print all News Title ::" + allNewsTitle);
				
				if(allNewsTitle.toLowerCase().contains(data1stKeyword.toLowerCase()) ||
						allNewsTitle.toLowerCase().contains(data2ndKeyword.toLowerCase()) ||
						allNewsTitle.toLowerCase().contains(data3rdKeyword.toLowerCase())){
					
					Add_Log.info("The results displayed contains at least one of the keywords entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains at least one of the keywords entered in Advance search box.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_AT_LEAST_ONE_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
		
	/**
	 * To verify the results displayed contains exact match of the keywords entered in Advance search box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataSearchKeyword
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_resultsDisplayedExactMatchKeywordsEntered(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataSearchKeyword) throws Exception{
		try{
			Add_Log.info("Input data search keyword ::" + dataSearchKeyword);
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class, 'news_title')]"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement resultLink = element.get(i);
				String allNewsTitle = resultLink.getText();
				results.add(allNewsTitle);
				Add_Log.info("Print all News Title ::" + allNewsTitle);
				
				if(allNewsTitle.toLowerCase().contains(dataSearchKeyword.toLowerCase())){
					Add_Log.info("The results displayed contains exact match of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed does NOT contains exact match of the keywords entered in Advance search box");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_EXACT_MATCH_KEYWORDS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * To verify the results displayed contains only the matching verified suppliers from the selected country.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataCountry
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_resultsDisplayedVerSuppContainsOnlySelectedCountry(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataCountry) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class,'supplierInfo')]//*[contains(@class,'ib')]"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement countryName = element.get(i);
				String allNewsCountry = countryName.getText();
				results.add(allNewsCountry);
				Add_Log.info("Print all News Country ::" + allNewsCountry);
				
				if(allNewsCountry.equals(dataCountry)){
					Add_Log.info("The results displayed contains only the matching verified suppliers from the selected country.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed contains NOT only the matching verified suppliers from the selected country.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;	
	}
	
	/**
	 * To verify the results displayed contains only the matching other suppliers from the selected country.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataCountry
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_resultsDisplayedUnvSuppContainsOnlySelectedCountry(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataCountry) throws Exception{
		try{
			List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class,'unverified_regoin')]"));
			List<String> results = new ArrayList<String>();
			int num = element.size();
			for(int i=0; i<num; i++){
				WebElement countryName = element.get(i);
				String allNewsCountry = countryName.getText();
				results.add(allNewsCountry);
				Add_Log.info("Print all News Country ::" + allNewsCountry);
				
				if(allNewsCountry.equals(dataCountry)){
					Add_Log.info("The results displayed contains only the matching other suppliers from the selected country.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_PASS);
				}else{
					Add_Log.info("The results displayed contains NOT only the matching other suppliers from the selected country.");
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}
		}catch(Exception e){
			throw(e);
		}
		return element;	
	}
	
	/**
	 * To verify the results displayed contains only the matching News from the selected country.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataCountry
	 * @return
	 * @throws Exception
	 */
	public static WebElement check_resultsDisplayedContainsOnlySelectedCountry(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataCountry) throws Exception{
		try{			
			//*[contains(@class,'GS_search_region')]//strong
			element = driver.findElement(By.xpath("//*[contains(@class,'GS_search_region')]//strong"));
			String actFilter = element.getText();
			String expFilter = ""+dataCountry+"";
		//	String expFilter = "Search within the "+dataCountry+" region";
			Add_Log.info("Print act text ::" + actFilter);
			Add_Log.info("Print exp text ::" + expFilter);
			
			if(actFilter.equals(expFilter)){
				Add_Log.info("The results displayed contains only the matching News from the selected country.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The results displayed contains NOT only the matching News from the selected country.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
			
		/*	element = driver.findElement(By.xpath("//*[contains(@class, 'selFilter')]//em"));
			String actFilter = element.getText();
			String expFilter = ""+dataCountry+" Suppliers";
			Add_Log.info("Print act text ::" + actFilter);
			Add_Log.info("Print exp text ::" + expFilter);
			
			if(actFilter.equals(expFilter)){
				Add_Log.info("The results displayed contains only the matching News from the selected country.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The results displayed contains NOT only the matching News from the selected country.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
		*/	
		/*	WebElement elementChkbx = driver.findElement(By.xpath("//*[contains(@class, 'GS_search_region')]//input"));
			WebElement elementRegion = driver.findElement(By.xpath("//*[contains(@class, 'GS_search_region')]//Strong"));
			
			Boolean isChkbxSelected = elementChkbx.isSelected();
			String getRegionName = elementRegion.getText();
			Add_Log.info("Is 'Search within the " + dataCountry + " region' chkbx checked ::" + isChkbxSelected);
			Add_Log.info("Print selected region ::" + getRegionName);
			
			if(isChkbxSelected == true && getRegionName.equalsIgnoreCase(dataCountry)){
				Add_Log.info("The results displayed contains only the matching News from the selected country.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The results displayed contains NOT only the matching News from the selected country");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_RESULTS_CONTAINS_ONLY_SEL_COUNTRY, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}			
		*/	
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	// ========================================================== End of News Advanced Search =======================================================
	
	// ===================================================== Start of Advance Search within Results =================================================
	
	// To verify the results displayed is filtered by all of the keywords entered in Advanced search box.
	

	
}	

