/**
 * This Class contains methods that represent the locators available on PA Edit Categories Page
 * Created: Mon 02 March 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/02
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Edit Categories page.
 * @author Teng Shyh Wei
 *
 */
public class PA_EditCategories_Page extends BaseClass{
	
    private static WebElement element = null;
	
    public PA_EditCategories_Page(WebDriver driver){
        	super(driver);
    }
	
    /**
     * Click on the 'Settings' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSettings() throws Exception{
    	try{            
    		element = driver.findElement(By.xpath("//*[contains(@class, 'userProfile_subnav')]/li[3]/a"));
    		Add_Log.info("Settings link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Settings link is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Click on any of the subscribed categories link to go to PA Landing page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSubsCategories() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'form_remove_catCon')]//a)[position()=1]"));
    		Add_Log.info("PA sucbscribed categories link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("PA subscribed categories link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select all PA Categories checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectAllPACategories() throws Exception{
    	try{            
    		List<WebElement> chkbxPACategories = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_PA_cat form_PA_catCheck mt5')]//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxPACategories){
    			if(!chkbx.isSelected())
    				chkbx.click();
    		}
    		Add_Log.info("All PA Categories checkboxes is selected.");
    		
    	}catch(Exception e){
    		Add_Log.error("PA Categories checkboxes is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Click on the 'Remove From Alert' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRemoveFromAlert() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'tc mt5')]//a[contains(text(),'Remove From Alert')]"));
    		Add_Log.info("Remove From Alert button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Remove From Alert button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Remove From Alert' button and click Ok button to accept the alert.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRemoveFromAlert_ClickOkBtn() throws Exception{
    	try{
        	element = driver.findElement(
        			By.xpath("//*[contains(@class, 'tc mt5')]//a[contains(text(),'Remove From Alert')]"));
        	WebDriverWait wait = new WebDriverWait(driver, 15);
        	wait.until(ExpectedConditions.elementToBeClickable(element));
        	element.click();
        	Add_Log.info("Remove From Alert button is click on the page");
        	
    		// Get a handle to the open alert, prompt or confirmation
    		Alert alert = driver.switchTo().alert();    		
    		
    		// Accept the alert - equivalent of pressing OK
    		alert.accept();
    		
    	}catch(Exception e){
    		Add_Log.error("Remove From Alert button is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To clean up PA Categories if available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_clearPACategories() throws Exception{
    	try{    		
    		Boolean isPAEditCategoriesExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'PA_LiteEdit mt5')]")).size()!= 0;  		
        	Add_Log.info("Is PA Edit Categories available ::" + isPAEditCategoriesExists);         	
        	if(isPAEditCategoriesExists == true){
        		
        		// Select PA Categories checkboxes
        		PA_EditCategories_Page.chkbx_selectAllPACategories();
        		
        		// Click 'Remove From Alert' button
        		PA_EditCategories_Page.btn_clickRemoveFromAlert_ClickOkBtn();	
        		
        	}else{        		
        		// Do nothing
        	}
    	}catch(Exception e){
    		Add_Log.error("Error! Error in PA Categories page.");
    		throw(e);
    	}
    	return element;
    }
    
/*    public static WebElement chkbx_selectOneOfTheSubscribedCategories() throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[contains(@class, 'form_PA_cat form_PA_catCheck mt5')]//a"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(",")));

    		for (String check : list){
    			for (WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    		
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'form_PA_cat form_PA_catCheck mt5')]//a)[position()=1]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
	
    /**
     * Enter text for PA Categories keyword field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPoductKeyword() throws Exception{
    	try{
    		element = driver.findElement(By.id("paCategoriesSearch"));
    		element.clear();    		
    		Add_Log.info("User is enter text for PA Categories keyword field.");
    		
    	}catch(Exception e){
    		Add_Log.error("PA Categories keyword field is NOT found on the page.");
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
    		
    		// Waits for Element to be clickable
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#keywordBtnSearch")));
    		    		    	
    		element = driver.findElement(By.cssSelector("#keywordBtnSearch"));
    		
    		// Verify is Search button displayed
    		Boolean isBtnDisplayed = element.isDisplayed();
    		Add_Log.info("Is Search btn displayed ::" + isBtnDisplayed);
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Find Matching Categories button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Find Matching Categories button is NOT found on the page.");    		
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select the first product categories checkboxes.
     * 
     * @return
     * @throws Exception
     */
	public static WebElement chkbx_selectFirstPACategories() throws Exception{
    	try{    		    		
    	//	element = driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=1]"));
    		
    		WebDriverWait waits = new WebDriverWait(driver, 30);    		
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//*[@id='checkboxL3'])[position()=1]")));
    		
    		element = driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=1]"));
    		element.click();
    		Add_Log.info("1st PA Categories chkbx is selected on the page");
    		
    	}catch(Exception e){
    		Add_Log.error("PA Categories chkbx is NOT found on the page.");
    		throw(e);    		
    	}
    	return element;
    }
	
	/**
	 * Select the second products categories checkboxes.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement chkbx_selectSecondPACategories() throws Exception{
		try{
		//	element = driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=1]"));
			
    		WebDriverWait waits = new WebDriverWait(driver, 30);    		
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//*[@id='checkboxL3'])[position()=1]")));
    		
    		element = driver.findElement(By.xpath("(//*[@id='checkboxL3'])[position()=1]"));
    		element.click();
    		Add_Log.info("2nd PA Categories chkbx is selected on the page.");
    		
		}catch(Exception e){
			Add_Log.error("PA Categories chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
	}
	
	// Test FluentWait 
	public static WebElement chkbx_selectPACategories(final By locator){
		Add_Log.info("Get element by locator" + locator.toString());
		final long startTime = System.currentTimeMillis();
		
		// A wait timeout occurs 3 times within the 90 second limit.
		// So, the method will run between 15-90 seconds, depending on the situation of failure
		Wait<WebDriver> wait = new FluentWait<WebDriver>( driver )
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class);
		int tries = 0;
		boolean found = false;
		WebElement we = null;
		
		while ((System.currentTimeMillis() - startTime) < 91000 ){
			Add_Log.info("Searching for element. Try number " + (tries++));;
			try{
				we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				found = true;
				break;
			}catch(StaleElementReferenceException e){
				Add_Log.info("Stale element: \n" + e.getMessage() + "\n");
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if(found) {
			Add_Log.info("Found element after waiting for " + totalTime + " milliseconds.");
		}else{
			Add_Log.info("Failed to find element after" + totalTime + " milliseconds");
		}
		return we;
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
    		
    	/*	WebElement element = driver.findElement(By.xpath("//*[contains(@class,'PA_form_submit')]//a"));
    	    
    		Actions actions = new Actions(driver);
    		actions.moveToElement(element).build().perform();
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    	*/	
    	}catch(Exception e){
    		Add_Log.error("Go to Confirmation button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // =========================================================== Start of verification section ====================================================
    
    /**
     * To verify PA Edit Categories page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAEditCategoriesPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String editCategoriesTitle = driver.findElement(By.xpath("//*[contains(@class, 'form_h1 mt10')]")).getText();
    		String expectedTitle = "Product Alert - Edit Categories";
    		Add_Log.info("Page title ::" + editCategoriesTitle);
    		
    		if(editCategoriesTitle.equals(expectedTitle)){
    			Add_Log.info("PA Edit Categories page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Edit Categories page is NOT displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    
    	}catch(Exception e){
    		Add_Log.error("Error! PA Edit Categories page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA Edit Categories page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAEditCategoriesPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Edit Alert"));
    		    	
    		if(driver.getTitle().equals("Product Alert - Edit Alert")){
    			Add_Log.info("PA Edit Categories page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Edit Categories page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CATEGORIES_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! PA Edit Categories page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify PA Edit Categories page is displayed.
    public static WebElement check_PAEditCategoriesPageIsDisplayed() throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Edit Alert"));
    		    	
    		if(driver.getTitle().equals("Product Alert - Edit Alert")){
    			Add_Log.info("PA Edit Categories page is displayed");
    		}else{
    			Add_Log.info("PA Edit Categories page is NOT displayed.");
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! PA Edit Categories page is NOT displayed.");
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
    		Boolean isPASuggCatExists = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories PA exists ::" + isPASuggCatExists);
    		
    		if(isPASuggCatExists == true){
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
     * To verify there are suggested categories for the product keyword entered.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatForPdtKeyword_EnteredInPAEditCatPageExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatForPdtKeywordEntered = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories for the product keyword entered exists ::" + isSuggCatForPdtKeywordEntered);
    		
    		if(isSuggCatForPdtKeywordEntered == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_PA_EDIT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_KEYWORD_PA_EDIT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify there are suggested categories for the product keyword entered (repeated step for another keyword).
     *  
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suggCatFor2ndPdtKeyword_EnteredInPAEditCatPageExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		Boolean isSuggCatForPdtKeywordEntered = 
    				driver.findElements(By.xpath("//*[@id='catList_container']//input")).size() != 0;
    		Add_Log.info("Is suggested categories for the product keyword entered exists ::" + isSuggCatForPdtKeywordEntered);
    		
    		if(isSuggCatForPdtKeywordEntered == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_2ND_KEYWORD_PA_EDIT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_BY_2ND_KEYWORD_PA_EDIT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify PA Edit Categories confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAEditCatConfPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Edit Alert"));
    		    	
    		if(driver.getTitle().equals("Product Alert - Edit Alert")){
    			Add_Log.info("PA Edit Categories confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CAT_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Edit Categories confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CAT_CONF_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! PA Edit Categories confirmation page is NOT displayed.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }	
    
    /**
     * To verify message "Successful! You have added x product categories." is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgSuccessfulAddedPdtCatExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'formMsg formMsg_border mt15')]"
    						+ "//*[contains(text(),'Successful! You have added')]")).size()!= 0;
    		Add_Log.info("Is message 'Successful! You have added x product categories.' displayed ::" + isMsgExists);
    		
    		if(isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUCCESSFUL_ADD_PDT_CAT_EXISTS, rowNum, Constant.KEYWORD_PASS);    		
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUCCESSFUL_ADD_PDT_CAT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Message 'Successful! You have added x product categories.' is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA Edit Categories confirmation page with message "Successful! You have added x product categories." is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAEditCatConfPage_MsgSuccessfulAddedDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Edit Alert"));
    		    	
    		Boolean isMsgExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'formMsg formMsg_border mt15')]"
    						+ "//*[contains(text(),'Successful! You have added')]")).size()!= 0;
    		Add_Log.info("Is message 'Successful! You have added x product categories.' displayed ::" + isMsgExists);
    		
    		if(driver.getTitle().equals("Product Alert - Edit Alert") && isMsgExists == true){
    			Add_Log.info("PA Edit Categories confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CAT_CONF_PAGE_MSG_SUCCESSFUL_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Edit Categories confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_EDIT_CAT_CONF_PAGE_MSG_SUCCESSFUL_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}  
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Recommended categories section is available.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_recommendedCategorySectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRecommendedCatSecExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'PA_recommend_cat mt15')]")).size() != 0;
    		Add_Log.info("Is recommended categories section available ::" + isRecommendedCatSecExists);
    		
    		if(isRecommendedCatSecExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RECOMMENDED_CAT_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RECOMMENDED_CAT_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Recommended categories section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Add These Categories' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAddTheseCategories() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'PA_recommend_cat mt15')]//a"));
    		Add_Log.info("Add These Categories button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add These Categories button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify a pop up message is displayed asking user whether want to continue.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_alertMsgContExists_ClickOKBtn(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{   		
    		// Get a handle to open alert, prompt for confirmation
    		Alert alert = driver.switchTo().alert();
    		    		
    		// Get pop up window message
    		String popupMessage = alert.getText();
    		Add_Log.info("Pop up window message ::" + popupMessage);
    		    		
    		String expectedMessage = "Do you want to continue?";
    		
    		// To verify a pop up message is displayed asking user whether want to continue.
    		if(popupMessage.contains(expectedMessage)){
    			Add_Log.info("A pop up message is displayed asking user whether want to continue");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_WANT_TO_CONT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("A pop up message is NOT displayed asking user whether want to continue");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_WANT_TO_CONT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
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
     * To verify message "Updated! You have removed all of your product categories" is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgRemovedAllPdtCatExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'formMsg formMsg_border mt15')]")).size()!= 0;
    		Add_Log.info("Is message 'Updated! You have removed all of your product categories.' displayed ::" + isMsgExists);
    		
    		if(isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_REMOVED_ALL_PDT_CAT_EXISTS, rowNum, Constant.KEYWORD_PASS);    		
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_REMOVED_ALL_PDT_CAT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Message 'Updated! You have removed all of your product categories' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select recommended categories checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectRecommendedCategories() throws Exception{
    	try{
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'PA_recommend_cat mt15')]//li/input"));
    		List<WebElement> chkbxPACategories = driver.findElements(
    				By.xpath("//*[contains(@class, 'PA_recommend_cat mt15')]//li/input"));
    		for(WebElement chkbx : chkbxPACategories){
    			if(!chkbx.isSelected())
    				chkbx.click();
    		}
    		Add_Log.info("Recommended categories checkbox is click on the page");
    		
    	}catch(Exception e){
    		Add_Log.error("Recommended categories checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the categories checkbox are checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_recommendedCategoriesChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'PA_recommend_cat mt15')]//li/input")).isSelected();
    		Add_Log.info("Is recommended categories checkboxes are checked ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RECOMMENDED_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);    			
    		}else{    			
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RECOMMENDED_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
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
			String textValue = element.getAttribute("value");
			Add_Log.info("Default text ::" + textValue);
			
    		String fontColorSelectedCategories = element.getCssValue("color");
    		String greyFontFromRGB = Color.fromString("rgb(153, 153, 153)").asRgba();
    		
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
     * To verify selected categories are added into the selected categories column.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedRecCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_addedToSelectedCategoriesColumn(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedRecCatNameList) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'form_PA_cat form_PA_catCheck mt5')]//li")));
    		
			List<String> PACategoriesNameList = new ArrayList<String>();
			for (WebElement element : selectedCategoriesNameList){
				Add_Log.info("PACategoriesNameList ::" + element.getText());
				PACategoriesNameList.add(element.getText());
			}
			
			if(PACategoriesNameList.containsAll(checkedRecCatNameList)){				
	    		Add_Log.info("Selected categories are added into the selected categories column");
	        	SuiteUtility.WriteResultUtility(
	        			xls, sheetName, Constant.COL_ADDED_TO_SEL_CAT_COLUMN, rowNum, Constant.KEYWORD_PASS);
			}else{
	    		Add_Log.info("Selected categories are NOT added into the selected categories column");
	        	SuiteUtility.WriteResultUtility(
	        			xls, sheetName, Constant.COL_ADDED_TO_SEL_CAT_COLUMN, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}				    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify category checkboxes are checked. Selected categories are grey-ed out and 
     * the categories are appear in the selected categories column.
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
    
    /**
     * To verify Warning message "We're sorry, but you can only receive Product Alert updates in a maximum of 10 categories without full Global Sources registration. 
     * Register Now to get updates in all the categories you've selected, or uncheck some of the categories." is displayed.
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
    		Add_Log.error("Error! Warning message is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }             

}
