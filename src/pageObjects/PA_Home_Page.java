/**
 * This Class contains methods that represent the locators available on Product Alert Homepage
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Home page.
 * @author Teng Shyh Wei
 *
 */
public class PA_Home_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public PA_Home_Page(WebDriver driver){
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
    		element = driver.findElement(By.id("paHomeSearch"));
    		element.clear();
    		Add_Log.info("User is enter text for product keyword field in PA Homepage.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product Keyword field is NOT found on the page.");
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
    		WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'PN_Src')]//*[@value='Search']"));        		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Search button is click on the PA Homepage.");
    		
    	}catch(Exception e){
    		Add_Log.error("Search button is NOT found on the PA Homepage.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'select your product categories now' hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickselectPdtCategoriesNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[contains(text(), 'select your product categories now')]"));
    		Add_Log.info("select your product categories now hyperlink is click on the page");
    		
    	}catch(Exception e){
    		Add_Log.error("select your product categories now hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Select your product categories now' hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSelectPdtCategoriesNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[contains(text(), 'Select your product categories now')]"));
    		Add_Log.info("Select your product categories now hyperlink is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Select your product categories now hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Product Categories sidebar 'Show More...' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickShowMore() throws Exception{
    	try{
    		element = driver.findElement(By.id("trigger_selectCat"));
    		Add_Log.info("Show More... link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Show More...link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
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
    public static WebElement check_PAHomepageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Product Alert"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Product Alert")){
    			Add_Log.info("Product Alert homepage is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Alert homepage is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! Product Alert homepage is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }

    /**
     * To verify the PA categories selected in Select PA Categories page are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatSelIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	try{
    		Boolean showMoreLinkExists = driver.findElement(By.id("trigger_selectCat")).isDisplayed();
    		// If "show more..." link exists
    		if(showMoreLinkExists == true){
    			PA_Home_Page.lnk_clickShowMore().click();
    			
        		WebDriverWait wait = new WebDriverWait(driver, 15);
        		List<WebElement> selectedCategoriesNameList = wait.
        				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        						By.xpath("//*[@id='selectCat_overlay']/ul/li/a")));	
        		
    			List<String> displayedCatNameList = new ArrayList<String>();
    			for (WebElement element : selectedCategoriesNameList){
    				Add_Log.info("displayedCatNameList ::" + element.getText());
    				displayedCatNameList.add(element.getText());
    			}
    			
    			if(displayedCatNameList.containsAll(checkedCatNameList)){				
    				Add_Log.info("PA categories selected in Select PA Categories page are displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("PA categories selected in Select PA Categories page are NOT displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}	
    		}else{
        		WebDriverWait wait = new WebDriverWait(driver, 15);
        		List<WebElement> selectedCategoriesNameList = wait.
        				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        						By.xpath("//*[@id='selectCat']/li/a")));
        		
    			List<String> displayedCatNameList = new ArrayList<String>();
    			for (WebElement element : selectedCategoriesNameList){
    				Add_Log.info("displayedCatNameList ::" + element.getText());
    				displayedCatNameList.add(element.getText());
    			}
    			
    			if(displayedCatNameList.containsAll(checkedCatNameList)){				
    				Add_Log.info("PA categories selected in Select PA Categories page are displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("PA categories selected in Select PA Categories page are NOT displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}
    		}	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the PA categories selected in pre-req & Select PA Categories page are displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedPACatNameList
     * @param checkedCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatSelIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedPACatNameList, List<String> checkedCatNameList) throws Exception{
    	try{    		
    	//	Boolean showMoreExists = driver.findElements(By.id("trigger_selectCat")).size() != 0;    		
			element = driver.findElement(By.id("trigger_selectCat"));
			Boolean showMoreExists = element.isDisplayed();
			
    		// If "show more..." link exists
    		if(showMoreExists == true){
    			PA_Home_Page.lnk_clickShowMore().click();
    			
        		WebDriverWait wait = new WebDriverWait(driver, 15);
        		List<WebElement> selectedCategoriesNameList = wait.
        				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        						By.xpath("//*[@id='selectCat_overlay']/ul/li/a")));	
        		
    			List<String> displayedCatNameList = new ArrayList<String>();
    			for (WebElement element : selectedCategoriesNameList){
    				Add_Log.info("displayedCatNameList ::" + element.getText());
    				displayedCatNameList.add(element.getText());
    			}
    			
    			if(displayedCatNameList.containsAll(checkedPACatNameList) && displayedCatNameList.containsAll(checkedCatNameList)){				
    				Add_Log.info("PA categories selected in pre-req & Select PA Categories page are displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_PRE_REQ_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("PA categories selected in pre-req & Select PA Categories page are NOT displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_PRE_REQ_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}	    		
    		}else{
        		WebDriverWait wait = new WebDriverWait(driver, 15);
        		List<WebElement> selectedCategoriesNameList = wait.
        				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        						By.xpath("//*[@id='selectCat']/li/a")));	
        		
    			List<String> displayedCatNameList = new ArrayList<String>();
    			for (WebElement element : selectedCategoriesNameList){
    				Add_Log.info("displayedCatNameList ::" + element.getText());
    				displayedCatNameList.add(element.getText());
    			}
    			
    			if(displayedCatNameList.containsAll(checkedPACatNameList) && displayedCatNameList.containsAll(checkedCatNameList)){				
    				Add_Log.info("PA categories selected in pre-req & Select PA Categories page are displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("PA categories selected in pre-req & Select PA Categories page are NOT displayed in PA homepage");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_PA_HOME, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}	
    		}    		    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that "You currently have no categories selected for Product Alert." statement exists.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgNoSubsPACatDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    	    		    		
    		Boolean isMsgExists = driver.findElements(
    				By.xpath("//p[contains(text(),'You currently have no categories selected for Product Alert.')]")).size()!= 0;
    		Add_Log.info("You currently have no categories selected for Product Alert.' available ::" + isMsgExists);
    		
    		if(isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_NO_CAT_SELECTED_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_NO_CAT_SELECTED_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}    		    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA homepage is displayed. Verify that "You currently have no categories selected for Product Alert." statement exists.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAHomepage_MsgNoSubsPACatDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    	    	
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Product Alert"));
    		    	
    		Boolean isMsgExists = driver.findElements(
    				By.xpath("//p[contains(text(),'You currently have no categories selected for Product Alert.')]")).size()!= 0;
    		Add_Log.info("You currently have no categories selected for Product Alert.' available ::" + isMsgExists);
    		
    		if(driver.getTitle().equals("Global Sources - Product Alert") && isMsgExists == true){
    			Add_Log.info("Product Alert homepage is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_HOMEPAGE_MSG_NO_CAT_SEL_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Alert homepage is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_HOMEPAGE_MSG_NO_CAT_SEL_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}      		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * To verify the category is added to the "Products posted in the last 15 days" column in PA homepage.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param selectedCategory
     * @return
     * @throws Exception
     */
    public static WebElement check_categoryIsAddedToColumnPAHomepage(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String selectedCategory) throws Exception{
    	try{
    	/*	WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> allCategoriesList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.cssSelector("#selectCat>li>a")));	*/
    		
    		List<WebElement> allCategoriesList = driver.findElements(By.xpath("//*[@id='selectCat']/li/a"));
			List<String> PACategoriesList = new ArrayList<String>();
			for (WebElement element : allCategoriesList){
				Add_Log.info("PACategoriesList ::" + element.getText());
				PACategoriesList.add(element.getText());
			}
			
			if(PACategoriesList.contains(selectedCategory)){				
				Add_Log.info("The category is added to the 'Products posted in the last 15 days' column in PA homepage.");
	        	SuiteUtility.WriteResultUtility(
	        			xls, sheetName, Constant.COL_ADDED_TO_COLUMN_PA_HOMEPAGE, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The category is NOT added to the 'Products posted in the last 15 days' column in PA homepage.");
	        	SuiteUtility.WriteResultUtility(
	        			xls, sheetName, Constant.COL_ADDED_TO_COLUMN_PA_HOMEPAGE, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	    	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}