/**
 * This Class contains methods that represent the locators available on PA Add Categories Page
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

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Add Categories page.
 * @author Teng Shyh Wei
 *
 */
public class PA_AddCategories_Page extends BaseClass{
	
    private static WebElement element = null;
    
    public PA_AddCategories_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * Enter text for product keyword.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterProductKeyword() throws Exception{
    	try{
    		element = driver.findElement(By.id("paCategoriesSearch"));
    		element.clear();
    		Add_Log.info("User is enter text in Product Keyword field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product Keyword text field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Find Matching Categories' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFindMatchingCategories() throws Exception{
    	try{
    	//	element = driver.findElement(By.id("keywordBtnSearch"));
    	//	driver.findElement(By.id("keywordBtnSearch")).sendKeys(Keys.ENTER);
    		
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.elementToBeClickable(By.id("keywordBtnSearch")));
    		
    		WebElement element = driver.findElement(By.id("keywordBtnSearch"));
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Find Matching Categories button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Find Matching Categories button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Check on any category checkboxes.
     * 
     * @return
     * @throws Exception
     */
	public static WebElement chkbx_selectCategoriesSuggestions() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 30);
    		waits.until(ExpectedConditions.elementToBeClickable(By.id("checkboxL3")));    		
    		
    		element = driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=1]"));
    		Add_Log.info("User select Categories Suggestions chkbx");
    		
    	}catch(Exception e){
    		Add_Log.error("Categories Suggestion chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
	
	/**
	 * Check on any category checkboxes more than 10 times.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement chkbx_selectMoreThan10Categories() throws Exception{
		try{
			// 08-Mar-2017 MR#45612 Changed from max 20 to 10 PA Categories			
			driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=2]")).click();
		//	driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=3]")).click();
		//	driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=4]")).click();
		//	driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=5]")).click();
			Add_Log.info("User select 2nd Categories chkbx.");
			
		}catch(Exception e){
			Add_Log.error("PA Categories chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
	}
	
    /**
     * Click on 'Go to Confirmation' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickGoToConfirmation() throws Exception{
    	try{
    		WebElement element = driver.findElement(By.id("submitBtn"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Go to Confirmation button is click on the page.");
    		
    	/*	WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
    		
    		element = driver.findElement(By.id("submitBtn"));
    		Add_Log.info("Go to Confirmation button is click on the page.");
    	*/	
    	}catch(Exception e){
    		Add_Log.error("Go to Confirmation button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on "Browser categories" tab and choose a category (e.g: Electronics) from "Choose an industry" dropdown list.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectBrowseCategories() throws Exception{
    	try{
			Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.id("PA_formOpt"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[@id='PA_formOpt']//*[contains(text(),'Browse')]"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("User is select Browser from the drop down list.");
    		
    	}catch(Exception e){
    		Add_Log.error("");
    		throw(e);
    	}
    	return element;
    }
    
    // Select 'Fashion Accessories' category from 'Choose an industry to browse available categories' drop down list.
    public static WebElement drpdwn_selectFashionAccessories() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.id("selectL1"));
    		WebElement subMenu = driver.findElement(
    				By.xpath(".//*[@id='selectL1']//*[contains(text(),'Fashion Accessories')]"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		
    	}catch(Exception e){ 
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Mobile Electronics' category from 'Choose an industry to browse available categories' drop down list.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectElectronicsCategory() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.id("selectL1"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[@id='selectL1']//*[contains(text(),'Electronic Components')]"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		
    	}catch(Exception e){ 
    		throw(e);
    	}
    	return element;
    }
    
    public static WebElement drpdwn_selectHealthAndPersonalCare() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.id("selectL1"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[@id='selectL1']//*[contains(text(),'Health & Personal Care')]"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		
    	}catch(Exception e){ 
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Save Changes' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSaveChanges() throws Exception{
    	try{
    		element = driver.findElement(By.id("saveBtn"));
    		Add_Log.info("Save Changes button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Save Changes button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Skip this step' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSkipThisStep() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Skip this step')]"));
    		Add_Log.info("Skip this step link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Skip this step link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Product Alert Add Categories page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAAddCategoriesPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		    		    	
    		String addCategoriesTitle = driver.findElement(By.xpath("//*[contains(@class, 'form_h1 mt10')]")).getText();
    		String expectedTitle = "Product Alert - Add Categories";
    		Add_Log.info("Page title ::" + addCategoriesTitle);
    		
    		if(addCategoriesTitle.equals(expectedTitle)){
    			Add_Log.info("Product Alert Add Categories page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_ADD_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Alert Add Categories page is NOT displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_ADD_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! Product Alert Add Categories page is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Product keyword is entered in the textbox.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataProductKeyword
     * @return
     * @throws Exception
     */
    public static WebElement check_pdtKeywordIsEntered(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataProductKeyword) throws Exception{
    	try{
    		// Get the text entered in 'product keyword' field
    		String textEnteredInProductKeyword = driver.findElement(By.id("paCategoriesSearch")).getAttribute("value");	                      
	            
    		if(textEnteredInProductKeyword.equals(dataProductKeyword)){	            	
	            Add_Log.info("Product keyword is entered in the textbox");
	            SuiteUtility.WriteResultUtility(
	            		xls, sheetName, Constant.COL_PDT_KEYWORD_IS_ENTERED, rowNum, Constant.KEYWORD_PASS);
	            }else{	            
	            Add_Log.info("Product keyword is NOT entered in the textbox");
	            SuiteUtility.WriteResultUtility(
	            		xls, sheetName, Constant.COL_PDT_KEYWORD_IS_ENTERED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify suggested categories for the product keyword entered are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByKeywordEnteredExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories based on the product keyword entered exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_PA_ADD_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_PA_ADD_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify there are suggested categories based on the keyword entered in L1, L2, L3 or New Product.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByKeywordInL3Exists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories based on the keyword entered in "
    				+ "L1, L2, L3 or New Product exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_L3_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_L3_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Suggested categories based on the keyword entered is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify there are suggested categories based on the keyword in L3, TP or Unverified PP page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByKeywordInL3TPUnvPPExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories based on the keyword entered in "
    				+ "L1, L2, L3 or New Product exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_L3_TP_UNV_PP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_L3_TP_UNV_PP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Suggested categories based on the keyword entered is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify there are suggested categories based on the keyword entered in PA homepage.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByKeyword_EnteredInPAHomepageExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories based on keyword entered in PA homepage exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_PA_HOMEPAGE_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_PA_HOMEPAGE_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Suggested categories based on the keyword entered is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify there are suggested categories based on the vertical title keyword.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByKeyword_VerticalTitleExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories based on vertical title keyword exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_VERTICAL_TITLE_KEYWORD_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_VERTICAL_TITLE_KEYWORD_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
      
    /**
     * To verify category checkboxes are checked. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_chkbxCategoriesSuggestionsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = 
    				driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=1]")).isSelected();
    		Add_Log.info("Is category checkboxes are checked ::" + isChkbxSelected);    		
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("Category checkboxes are checked.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CATEGORY_CHECKBOXES_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Category checkboxes are NOT checked");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CATEGORY_CHECKBOXES_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("Category checkboxes is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify selected categories are grey-ed out.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selCatAreGreyedOut(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
			element = driver.findElement(By.xpath("//*[@id='catList_container']/dl[1]//span"));
			
    		String fontColorSelectedCategories = element.getCssValue("color");
    		String greyFontFromRGB = Color.fromString("rgb(153, 153, 153)").asRgba();
    		
    		Add_Log.info("Print actual color ::" + fontColorSelectedCategories);
    		Add_Log.info("Print expected color ::" + greyFontFromRGB);
    		
    		if(fontColorSelectedCategories.equals(greyFontFromRGB)){
    			Add_Log.info("The selected categories are grey-ed out.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_GRAYED_OUT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The selected categories are NOT grey-ed out.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_GRAYED_OUT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify selected categories are appear in the selected categories column.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_selCatAppearInSelColumn(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	try{			
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='selectList_container']/li/span[1]")));
    		
			List<String> rightCategoriesNameList = new ArrayList<String>();
			for (WebElement element : selectedCategoriesNameList){
				Add_Log.info("rightCategoriesNameList ::" + element.getText());
				rightCategoriesNameList.add(element.getText());
			}
			
			if(rightCategoriesNameList.containsAll(checkedCatNameList)){				
				Add_Log.info("Selected categories are appear in the selected categories column");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_SEL_COLUMN, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Selected categories are NOT appear in the selected categories column");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_SEL_COLUMN, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify category checkboxes are checked. Selected categories are grey-ed out 
     * and the categories are appear in the selected categories column.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList2
     * @return
     * @throws Exception
     */
    public static WebElement check_catChkbxChecked_GreyedOut_AppearInSelColumn(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList2) throws Exception{
    	try{
    		// To verify category checkboxes are checked.
    		Boolean isChkbxSelected = 
    				driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=1]")).isSelected();
    		Add_Log.info("Is category checkboxes are checked ::" + isChkbxSelected);
    		
    		// MR45612 "selected categories are grey-ed out" is removed
    		// To verify selected categories are grey-ed out.
		//	element = driver.findElement(By.xpath("//*[@id='catList_container']/dl[1]//span"));
			
    	//	String fontColorSelectedCategories = element.getCssValue("color");
    	//	String greyFontFromRGB = Color.fromString("rgb(153, 153, 153)").asRgba();
    		
    		// To verify selected categories are appear in selected categories column.
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='selectList_container']/li/span[1]")));
    		
			List<String> rightCategoriesNameList = new ArrayList<String>();
			for (WebElement element : selectedCategoriesNameList){
				Add_Log.info("rightCategoriesNameList ::" + element.getText());
				rightCategoriesNameList.add(element.getText());
			}
			
    	//	if(isChkbxSelected == true && fontColorSelectedCategories.equals(greyFontFromRGB)
    		if(isChkbxSelected == true && rightCategoriesNameList.containsAll(checkedCatNameList2)){
    		//	Add_Log.info("The selected categories are grey-ed out.");
    			Add_Log.info("Selected categories are appear in the selected categories column");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CAT_CHKBX_CHECKED_GREYED_OUT_APPEAR_IN_RIGHT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    		//	Add_Log.info("The selected categories are NOT grey-ed out.");
    			Add_Log.info("Selected categories are NOT appear in the selected categories column");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CAT_CHKBX_CHECKED_GREYED_OUT_APPEAR_IN_RIGHT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================== Registration Module =================================================================
    
    /**
     * To verify Select Product Alert Categories page is displayed. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selPACatPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Add Categories"));
    		    	
    		if(driver.getTitle().equals("Product Alert - Add Categories")){
    			Add_Log.info("Select Product Alert Categories page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_PA_CAT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Select Product Alert Categories page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_PA_CAT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Select Product Alert Categories page is NOT displayed.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Select Product Alet Categories page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selPACatPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Product Alert"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Product Alert")){
    			Add_Log.info("Select Product Alert Categories page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_PA_CAT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Select Product Alert Categories page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_PA_CAT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Select Product Alert Categories page is NOT displayed.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify there are suggested categories based on the keyword entered.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByPdtKeywordEnteredExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories based on the product keyword entered exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_PDT_KEYWORD_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_PDT_KEYWORD_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Suggested categories based on the keyword entered is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify there are suggested categories for the product keyword entered in Registration form.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByKeyword_EnteredInRegFormExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories for the product keyword entered in Reg form exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_REG_FORM_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_REG_FORM_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Suggested categories based on the keyword entered is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify suggested categories for the product keyword entered in Select PA Categories page are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByKeyword_EnteredInSelPAPageExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    	/*    Boolean isSuggCatExists = driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories for the product keyword entered in Select PA Categories page exists ::" + isSuggCatExists);
    	*/	
    		Boolean isSuggCatExists = driver.findElement(By.xpath("//*[@id='catList_container']//input")).isDisplayed();
    		Add_Log.info("Is suggested categories for the product keyword entered in Select PA Categories page exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_SEL_PA_PAGE_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_SEL_PA_PAGE_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! Suggested categories based on the keyword entered is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify suggested categories for the category selected in 'Browse Categories' are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatByBrowseCategoriesExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    	    Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories for the product keyword entered in Reg form exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_BROWSE_CAT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_BROWSE_CAT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify there is no suggested categories.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_noPASuggestedCategories(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories PA exists ::" + isSuggCatExists);
    		
    		if(isSuggCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_PA_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_PA_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);    			
    		}
    	}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Select Product Alert Categories page is displayed. There is no suggested categories.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selPACatPageDisplayed_SuggCatNotAvailable(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Add Categories"));
    		    
    		Boolean isSuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories PA exists ::" + isSuggCatExists);
    		    		
    		if(driver.getTitle().equals("Product Alert - Add Categories") && isSuggCatExists == false){
    			Add_Log.info("Select Product Alert Categories page is displayed");
    			Add_Log.info("There is no suggested categories is ::true");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_PA_CAT_PAGE_NO_SUGG_CAT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Select Product Alert Categories page is NOT displayed.");
    			Add_Log.info("There is no suggested categories is :: FALSE");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_PA_CAT_PAGE_NO_SUGG_CAT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify the categories previously selected in pre req (subscribe to PA lite) are appear in the selected categories column.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedPACatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_catSelInPrereqAppearInSelCatCol(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedPACatNameList) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'PA_upgrade_cat')]//li")));
    		
			List<String> displayedCatNameList = new ArrayList<String>();
			for (WebElement element : selectedCategoriesNameList){
				Add_Log.info("displayedCatNameList ::" + element.getText());
				displayedCatNameList.add(element.getText());
			}
			
			if(displayedCatNameList.containsAll(checkedPACatNameList)){				
				Add_Log.info("The categories previously selected in pre-req are appear in the selected categories column.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CAT_PA_LITE_APPEAR_IN_SEL_CAT_COL, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The categories previously selected in pre-req are NOT appear in the selected categories column.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CAT_PA_LITE_APPEAR_IN_SEL_CAT_COL, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	    		
    	}catch(Exception e){
    		throw(e);
    		
    	}
    	return element;
    }
        
    // =========================================================== Module PA Lite Signup ============================================================
    
	/**
	 * To verify Error message window is pop-up indicating that user has exceeded the maximum categories subscribed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_msgExceed10CatSubs_ClickOKToAccept(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		// Get pop up window message
    		element = driver.findElement(By.xpath("(//*[@id='alertLimitOverlay']//td)[position()=3]"));
    		String popupMessage = element.getText();
    		Add_Log.info("Pop up window message ::" + popupMessage);
    		    		
			// 08-Mar-2017 MR#45612 Changed from max 20 to 10 PA Categories
    		String expectedMessage = "We're sorry, but you can only receive Product Alert updates in a maximum of 10 categories "
    				+ "without full Global Sources registration. Register Now to get updates in all the categories you've selected, "
    				+ "or uncheck some of the categories.";
    		
    		if(popupMessage.equals(expectedMessage)){
    			Add_Log.info("Error message window is pop-up indicating that user has exceeded the maximum categories subscribed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_EXCEED_MAX_CAT_SUBS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message window is NOT pop-up indicating that user has exceeded the maximum categories subscribed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_EXCEED_MAX_CAT_SUBS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the window popup 'Close' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickClose() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='button'][@value='Close']"));
    		Add_Log.info("User is click on Close button");
    		
    	}catch(Exception e){
    		Add_Log.error("Close button is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Error message pop-up window is closed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgPopupWindowIsClosed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isOverlayExists = driver.findElement(By.xpath("//*[@id='alertLimitOverlay']")).isDisplayed();
    		Add_Log.info("Is error message pop-up window displayed ::" + isOverlayExists);
    		
    		if(isOverlayExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ERROR_MSG_POPUP_WINDOW_CLOSED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ERROR_MSG_POPUP_WINDOW_CLOSED, rowNum, Constant.KEYWORD_PASS);
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Remove some of the categories by clicking on the dustbin sign in the selected categories column until the categories selected are less than 10.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickDustbin() throws Exception{
    	try{
    		// 03-Mar-2017 MR#45612
    		// Unchecked 2nd PA Categories chkbx
    		driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=2]")).click();
    	/*	driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=1]")).click();
    		driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=2]")).click();
    		driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=3]")).click();
    		driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=4]")).click();
    		driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=5]")).click();
    		driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=6]")).click();
    		driver.findElement(By.xpath("(//*[contains(@class, 'trashIco')])[position()=7]")).click();
    	*/	
    		Add_Log.info("Unchecked 2nd PA Categories chkbx.");
    		
    	}catch(Exception e){
    		Add_Log.error("2nd PA Categories chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify the categories are removed (selected categories not more than 10).
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_selCategoriesNotMoreThan10(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
			// 08-Mar-2017 MR#45612 Changed from max 20 to 10 PA Categories	
            String countSelCat = driver.findElement(By.id("selCatCnt")).getText();
            Add_Log.info("Count selected categories ::" + countSelCat);
            
            int countPA = Integer.parseInt(countSelCat);
            Add_Log.info("Count selected categories ::" + countPA);
            
            if(countPA <= 10){
            	Add_Log.info("Passed. Seleced categories is not more than 10");
            	SuiteUtility.WriteResultUtility(
            			xls, sheetName, Constant.COL_COUNT_SEL_CAT_NOT_MORE_THAN_10, rowNum, Constant.KEYWORD_PASS);
            }else{
            	Add_Log.info("Failed. Selected categories is more than 10");
            	SuiteUtility.WriteResultUtility(
            			xls, sheetName, Constant.COL_COUNT_SEL_CAT_NOT_MORE_THAN_10, rowNum, Constant.KEYWORD_FAIL);
            	testFail.set(0, true);
            }
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // =========================================================== Module Supplier Alert ============================================================
    
    // To verify that "Skip this step if you wish to follow suppliers only. (You can choose Product Alert categories at a later time.)" 
    // link copy is available below the "Registration" copy.
    public static WebElement check_copySkipThisStepExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isCopyExists = driver.findElements(
    				By.xpath("//a//Strong[contains(text(), 'Skip this step')]")).size() != 0;
    		Add_Log.info("Is copy available below the Registration copy ::" + isCopyExists);
    	//	Boolean isTextExists = driver.findElements(
    	//			By.xpath("//*[contains(text(), '(You can choose Product Alert categories at a later time.)')]")).size() != 0;
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SKIP_THIS_STEP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SKIP_THIS_STEP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
