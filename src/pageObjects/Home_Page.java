/**
 * This Class contains methods that represent the locators available on Home Page
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/07
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

	/**
	 * Contains methods that represent the locators available on Home page.
	 * @author Teng Shyh Wei
	 *
	 */
    public class Home_Page extends BaseClass{
    	
    	static WebDriverWait wait;
        private static WebElement element = null;
           
        public Home_Page(WebDriver driver){
            	super(driver);
        }
                
		/**
		 * To verify GSOL homepage is displayed.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_GSOLHomepageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{        		
        		String expectedTitle = "Manufacturers & Suppliers Directory | Global Sources";
        		
                if(driver.getTitle().equals(expectedTitle)){
                	Add_Log.info("GSOL homepage is displayed");
                 	SuiteUtility.WriteResultUtility(
                 			xls, sheetName, Constant.COL_GSOL_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
                 	
                }else{
                 	Add_Log.info("GSOL homepage is NOT displayed");
                 	SuiteUtility.WriteResultUtility(
                 			xls, sheetName, Constant.COL_GSOL_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
                 	testFail.set(0, true);
                }
			}catch(Exception e){
				Add_Log.error("Error! GSOL homepage is NOT displayed.");
				throw(e);
			}
			return element;
		}
		
        /**
         * To verify User's contact details are pre-populated.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @return
         * @throws Exception
         */
        /*public static WebElement check_userLoggedIn(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
			try{
				Boolean isUserLoggedIn = 
						driver.findElements(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]")).size()!= 0; 
    			Add_Log.info("Is User's contact details pre-populated ::" + isUserLoggedIn);
            	if(isUserLoggedIn == true){
            		SuiteUtility.WriteResultUtility(
            				xls, sheetName, Constant.COL_RESULT_USER_LOGGED_IN, rowNum, Constant.KEYWORD_PASS);            		           		
            	}else{
            		SuiteUtility.WriteResultUtility(
            				xls, sheetName, Constant.COL_RESULT_USER_LOGGED_IN, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
            	}
			}catch(Exception e){
				throw(e);
			}
			return element;
		}	*/      
        
        /***
         * To verify User's contact details are not pre-populated.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @return
         * @throws Exception
         */
        /*public static WebElement check_userNotLoggedIn(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		Boolean isUserLoggedIn = 
        				driver.findElements(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]")).size()!= 0; 
    			Add_Log.info("Is User's contact details pre-populated ::" + isUserLoggedIn);
            	if(isUserLoggedIn == true){
            		SuiteUtility.WriteResultUtility(
            				xls, sheetName, Constant.COL_RESULT_USER_NOT_LOGGED_IN, rowNum, Constant.KEYWORD_FAIL);
            		testFail.set(0, true);
            	}else{
            		SuiteUtility.WriteResultUtility(
            				xls, sheetName, Constant.COL_RESULT_USER_NOT_LOGGED_IN, rowNum, Constant.KEYWORD_PASS);
            	}
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }	*/
               
    	// ======================================================== Start of Search section locators ================================================
		
        /**
         * Select Page Types by selecting Products/ Suppliers/ News (value from input data).
         * 
         * @param selectSub
         * @return
         * @throws Exception
         */
        public static WebElement drpdwn_selectPageTypes(String selectSub) throws Exception{
        	try{
        		WebDriverWait waits = new WebDriverWait(driver, 15);
        		waits.until(ExpectedConditions.visibilityOfElementLocated(
        				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
        		waits.until(ExpectedConditions.elementToBeClickable(By.id("qTypeSelTrigger")));
        		
            	driver.findElement(By.id("qTypeSelTrigger")).click();	        	
	        	
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(By.id("qTypeSelTrigger"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("(//*[contains(@class, 'searchType_list')])[1]//a" + "[text()='" + selectSub + "']"));        		
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }        
        
        /**
         * Select 'Products' page types.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement drpdwn_selectProductsPageTypes() throws Exception{
        	try{
        		WebDriverWait waits = new WebDriverWait(driver, 15);
        		waits.until(ExpectedConditions.visibilityOfElementLocated(
        				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
        		waits.until(ExpectedConditions.elementToBeClickable(By.id("qTypeSelTrigger")));
        		
        		driver.findElement(By.id("qTypeSelTrigger")).click();
        		
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(By.id("qTypeSelTrigger"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'searchType_list')]//*[text()='Products']"));
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        	}catch(Exception e){
        		Add_Log.error("Products Page Types drop down list is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Select 'Suppliers' page type.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement drpdwn_selectSuppliersPageTypes() throws Exception{
        	try{
        		WebDriverWait waits = new WebDriverWait(driver, 15);
        		waits.until(ExpectedConditions.visibilityOfElementLocated(
        				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));        
        		waits.until(ExpectedConditions.elementToBeClickable(By.id("qTypeSelTrigger")));
        		
        		driver.findElement(By.id("qTypeSelTrigger")).click();
        		
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(By.id("qTypeSelTrigger"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'searchType_list')]//*[text()='Suppliers']"));
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        		
        		Add_Log.info("Suppliers page types is selected on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Supplier page types is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Select 'News' page type.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement drpdwn_selectNewsPageTypes() throws Exception{
        	try{
        		driver.findElement(By.id("qTypeSelTrigger")).click();
        		
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(By.id("qTypeSelTrigger"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'searchType_list')]//*[text()='News']"));
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        		
        		Add_Log.info("News page types is selected on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("News page types is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        // Clear GSOL Search field.
        public static WebElement txtbx_clearGSOLSearchField() throws Exception{
        	try{
        		element = driver.findElement(By.id("gsolquery"));
        		element.clear();
        		Add_Log.info("Clear GSOL search keyword field.");
        		
        	}catch(Exception e){
        		Add_Log.error("GSOL search keyword field is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Enter text for search keyword field.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement txtbx_enterGSOLSearchField() throws Exception{
        	try{
        		WebDriverWait waits = new WebDriverWait(driver, 15);
        		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("gsolquery")));
        		        		
        		element = driver.findElement(By.id("gsolquery"));
        	//	element.clear();
        		
        		Add_Log.info("User is enter text in GSOL search keyword field.");
        		
        	}catch(Exception e){
        		Add_Log.error("GSOL search keyword field is NOT found on the page.");
        		// Get the list of window handles
        		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        		Add_Log.info("Print number of window opened ::" + tabs.size());
        		throw(e);
        	}
        	return element;
        }                	       

        /**
         * To verify product keyword is entered in product keyword text box.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @param dataSearchKeyword
         * @return
         * @throws Exception
         */
        public static WebElement check_txtbxPdtKeywordIsEntered(Read_XLS xls, String sheetName, int rowNum,
        		List<Boolean> testFail, String dataSearchKeyword) throws Exception{
        	try{
        		// Get the text entered in 'Product Keyword' field
        		String textEnteredInPdtKeyword = driver.findElement(By.id("gsolquery")).getAttribute("value");  
        		
        		if(textEnteredInPdtKeyword.equals(dataSearchKeyword)){
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
         * To verify Product keyword text box is left blank.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @return
         * @throws Exception
         */
        public static WebElement check_txtbxPdtKeywordIsBlank(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		element = driver.findElement(By.id("gsolquery"));
        		String txtbxPdtKeyword = element.getAttribute("value");
        		Add_Log.info("Product Keyword field value ::" + txtbxPdtKeyword);
        		
        		if(txtbxPdtKeyword.isEmpty()){
        			Add_Log.info("Product keyword text box is left blank" );
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PDT_KEYWORD_TXTBX_IS_BLANK, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			Add_Log.info("Product keyword text box is NOT left blank" );
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PDT_KEYWORD_TXTBX_IS_BLANK, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }
        
        // To verify the auto-complete box is displayed.
        // To verify the keyword entered in Step 3 is bolded in the suggested keyword in auto-complete box.
        public static WebElement check_autoCompleteBoxIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail, String dataSearchKeyword) throws Exception{
        	try{      		
        		// To verify the auto-complete box is displayed
        		element = driver.findElement(By.xpath("//*[contains(@class, 'autocomplete-w1')]"));
        		Boolean isAutoCompleteExists = element.isDisplayed();
        		Add_Log.info("Is search auto-complete box displayed ::" + isAutoCompleteExists);
        		
        		if(isAutoCompleteExists == true){
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_AUTO_COMPLETE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_AUTO_COMPLETE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        		
        		// To verify the keyword entered in Step 3 is bolded in suggested keyword in auto-complete box
        		List<WebElement> allElements = driver.findElements(
        				By.xpath("//*[contains(@class, 'autocomplete-w1')]/div/div"));
        		
        		for(WebElement element : allElements){
        			Add_Log.info(element.getText());
        			if(element.getText().contains(dataSearchKeyword)){
        				Add_Log.info("Passed. The keyword entered is bolded in the suggested keyword in auto-complete box");
        				SuiteUtility.WriteResultUtility(
        						xls, sheetName, Constant.COL_SUGG_KEYWORD_IS_BOLD, rowNum, Constant.KEYWORD_PASS);
        			}else{
        				Add_Log.info("Failed. The keyword entered is NOT bolded in the suggested keyword in auto-complete box");
        				SuiteUtility.WriteResultUtility(
        						xls, sheetName, Constant.COL_SUGG_KEYWORD_IS_BOLD, rowNum, Constant.KEYWORD_FAIL);
        				testFail.set(0, true);
        			}
        		}        	
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Click on the "Search" button.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement btn_clickKeywordButtonSearch() throws Exception{
        	try{
            //	element = driver.findElement(By.id("keywordBtnSearch"));
        	//	element = driver.findElement(By.cssSelector("#keywordBtnSearch"));
        	//	element = driver.findElement(By.xpath("//*[contains(@class, 'GS_searchBtn')]"));
        	//	driver.findElement(By.id("keywordBtnSearch")).sendKeys(Keys.ENTER);
        		
        		element = driver.findElement(By.id("keywordBtnSearch"));
        		
        		// To verify Search button is displayed
        		Boolean isBtnDisplayed = element.isDisplayed();
        		Add_Log.info("Is Search btn displayed ::" + isBtnDisplayed);
        		
        		// Waits for Element to be clickable
        		WebDriverWait waits = new WebDriverWait(driver, 25);
        		waits.until(ExpectedConditions.elementToBeClickable(By.id("keywordBtnSearch")));        		
        		
        	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	//	executor.executeScript("arguments[0].click();", element);
        		element.click();
        		Add_Log.info("User is click on the Search button.");
        		
        	}catch(Exception e){
        		Add_Log.error("Search button is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }

        // FluentWait testing
    /*    public static WebElement btn_clickOnSearch() throws Exception{
        	try{
        		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        				.withTimeout(30, TimeUnit.SECONDS) // Wait for 30 seconds
        				.pollingEvery(5, TimeUnit.SECONDS) // Polling every 5 seconds
        				.ignoring(NoSuchElementException.class); // Ignoring NoSuchElementException
        		
        		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
        			public WebElement apply(WebDriver driver){
        				return driver.findElement(By.id("keywordBtnSearch"));
        			}
        		});
        		return foo;
        	}catch(Exception e){
        		Add_Log.error("");
        		throw(e);
        	}
        	return element;
        }	*/
        
        /**
         * To verify a popup window with message "Please enter a keyword first to start your search" is displayed.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @return
         * @throws Exception
         */
        public static WebElement check_alertMsgEnterKeywordToSearch_ClickOkBtn(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		// Get a handle to open alert, prompt for confirmation
        		Alert alert = driver.switchTo().alert();
        		    		
        		// Get pop up window message
        		String popupMessage = alert.getText();
        		Add_Log.info("Pop up window message ::" + popupMessage);
        		    		
        		String expectedMessage = "Please enter a keyword first to start your search.";
        		Add_Log.info("Expected window message ::" + expectedMessage);
        		
        		// To verify a pop up message is displayed asking user whether want to continue.
        		if(expectedMessage.contains(popupMessage)){
        			Add_Log.info("Popup window with message 'Please enter a keyword first to start your search' is displayed");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_ENTER_KEYWORD_TO_SEARCH_EXISTS, rowNum, Constant.KEYWORD_PASS);
        		}else{
            		Add_Log.info("Popup window with message 'Please enter a keyword first to start your search' is NOT displayed");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_ENTER_KEYWORD_TO_SEARCH_EXISTS, rowNum, Constant.KEYWORD_FAIL);
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
         * Select Search Options by Advanced Search.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement drpdwn_selectAdvancedSearch() throws Exception{
			try{
				Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_searchOpt_box')]"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_searchOpt_box')]//a[text()='Advanced Search']"));
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        		
			}catch(Exception e){
				throw(e);
			}
			return element;
		}
		
        /**
         * Select Search Options by Browse Categories.
         * Function is removed.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement drpdwn_selectBrowseCategories() throws Exception{
			try{
				WebDriverWait waits = new WebDriverWait(driver, 25);
				waits.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[contains(@class, 'GS_searchOpt_box')]")));
			/*	waits.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[contains(@class, 'GS_searchOpt_box')]")));
			*/	
				
				Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_searchOpt_box')]"));
			//	waits.until(ExpectedConditions.visibilityOfElementLocated(
			//			By.xpath("//*[contains(@class, 'GS_searchOpt_box')]//a[text()='Browse Categories']")));
        		
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_searchOpt_box')]//li[2]"));
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        		Add_Log.info("Browse Categories is click on the page.");
			}catch(Exception e){
				Add_Log.error("Browse Categories is NOT found on the page.");
				throw(e);
			}
			return element;
		}
        
    	// ================================================== Start of Top Navigation section locators ==============================================
        
        /**
         * Mouse hover on menu bar Online Marketplace to click on sub menu item (from data file).
         * 
         * @param driver
         * @param selectSub
         * @return
         * @throws Exception
         */
        public static WebElement menuBar_selectOnlineMarketplaceItem(WebDriver driver, String selectSub) throws Exception{
        	try{
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='Online Marketplace']"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop GS_nav_omPop')]//a[text()='" + selectSub + "']"));        		
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Generate mouse hover event on menu bar Online Marketplace to click on sub menu item.
         *  
         * @param driver
         * @param selectMain
         * @param selectSub
         * @return
         * @throws Exception
         */
        public static WebElement menuBar_selectOnlineMarketplaceItem(WebDriver driver, String selectMain, String selectSub) throws Exception{
        	try{
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='" + selectMain + "']"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop GS_nav_omPop')]//a[text()='" + selectSub + "']"));        		
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Generate mouse hover event on menu bar Trade Shows to click on sub menu, child sub menu item.
         * 
         * @param selectMain
         * @param selectSub
         * @param selectChild
         * @return
         * @throws Exception
         */
        public static WebElement menuBar_selectTradeShowsItem(String selectMain, String selectSub, String selectChild) throws Exception{        	
        	try{
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='" + selectMain + "']"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[text()='" + selectSub + "']"));
        		WebElement childSubMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_subPop')]//a[text()='" + selectChild + "']"));
        		actions.moveToElement(mainMenu).moveToElement(subMenu).moveToElement(childSubMenu).click().build().perform();      		

        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }        
       
        /**
         * Generate mouse hover event on menu bar Magazines to click on sub menu item.
         * 
         * @param selectMain
         * @param selectSub
         * @return
         * @throws Exception
         */
        public static WebElement menuBar_selectMagazinesItem(String selectMain, String selectSub) throws Exception{
        	try{
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement
        				(By.xpath("//*[contains(@class, 'GS_nav_list')]//a[text()='" + selectMain + "']"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[text()='" + selectSub + "']"));        		
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        		
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * Generate mouse hover event on menu bar Other Services to click on sub menu item.
         * 
         * @param selectMain
         * @param selectSub
         * @return
         * @throws Exception
         */
        public static WebElement menuBar_selectOtherServicesItem(String selectMain, String selectSub) throws Exception{
        	try{
        		Actions actions = new Actions(driver);
        		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]/ul/li[4]/a"));
        		WebElement subMenu = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_nav_pop')]//a[text()='" + selectSub + "']"));        		
        		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
        		
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }
        
    	// ================================================== Start of Footer page section locators =================================================
        
        /**
         * To click on 'Browse Product Categories' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickBrowseProductCategories() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Browse Product Categories')]"));
        		Add_Log.info("Browse Product Categories link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Browse Product Categories link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'New Products' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickNewProducts() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'New Products')]"));
        		Add_Log.info("New Products link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("New Products link is NOT found on the page.");
				throw(e);
			}
			return element;
        }
        
        /**
         * To click on 'Top Products' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickTopProducts() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Top Products')]"));
        		Add_Log.info("Top Product link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Top Product link is NOT found on the page.");
				throw(e);
			}
			return element;
        }
        
        /**
         * To click on 'Top China Suppliers' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickTopChinaSuppliers() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Top China Suppliers')]"));
        		Add_Log.info("Top China Suppliers link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Top China Suppliers link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Source by Country' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickSourceByCountry() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Source by Country')]"));
        		Add_Log.info("Source by Country link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Source by Contry link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Wholesale Directory' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickWholesaleDirectory() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Wholesale Directory')]"));
        		Add_Log.info("Wholesale Directory link is click on the page");
        		
        	}catch(Exception e){
        		Add_Log.error("Wholesale Directory link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Wholesale Products' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickWholesaleProducts() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Wholesale Products')]"));
        		Add_Log.info("Wholesale Products link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Wholesale Products link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Message Center' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickMessageCenter() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Message Center')]"));
        		Add_Log.info("Message Center link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Message Center link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Sourcing e-Magazines' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickSourcingEmag() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Sourcing e-Magazines')]"));
        		Add_Log.info("Sourcing e-Magazines link is click on the page");
        		
        	}catch(Exception e){
        		Add_Log.error("Sourcing e-Magazines link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Get Quotations' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickGetQuotations() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Get Quotations')]"));
        		Add_Log.info("Get Quotations link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Get Quotations link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Our Services' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickOurServices() throws Exception{
        	try{
        		element = driver.findElement(By.xpath("//a[contains(text(),'Our Services')]"));
        		Add_Log.info("Our Services link is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Our Services link is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To click on 'Indonesian' link located at footer page.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement lnk_clickLanguageIndonesian() throws Exception{
        	try{
        		element = driver.findElement(By.id("in"));
        		
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }
        
        /**
         * To verify GSOL is translated to the selected language.
         * 
         * @param xls
         * @param sheetName
         * @param rowNum
         * @param testFail
         * @return
         * @throws Exception
         */
        public static WebElement check_GSOLTranslatedToIndonesianLanguage(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		WebDriverWait wait = new WebDriverWait(driver, 25);
        		wait.until(ExpectedConditions.titleIs("Produsen & Pemasok Direktori | Sumber Global"));
        		    	
        		if(driver.getTitle().equals("Produsen & Pemasok Direktori | Sumber Global")){
        			Add_Log.info("GSOL is translated to Indonesian language");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_GSOL_PAGE_LANGUAGE_TRANSLATED, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			Add_Log.info("GSOL is NOT translated to Indonesian language.");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_GSOL_PAGE_LANGUAGE_TRANSLATED, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        		
        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }              
        
    	// ================================================== Start Get Notified section locators ==============================================
		
        /**
         * Enter text in the Get Notified section textbox.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement txtbx_enterGetNotifiedEmailAddress() throws Exception{
        	try{
	    		// 15-Aug-2017 MR#47265
        	//	element = driver.findElement(By.cssSelector(".GS_footer_PA_filed.ui_input_tip"));
        		element = driver.findElement(By.xpath("//*[contains(@class, 'GS_footer_subscr')]//*[@name='email']"));
        		Add_Log.info("User is enter text in Get Notified section textbox.");
        		
        	}catch(Exception e){
        		Add_Log.error("Get Notified section textbox is NOT found on the page.");
				throw(e);
			}
			return element;
        }
        
        /**
         * Click on Get Notified section 'Subscribe' button.
         * 
         * @return
         * @throws Exception
         */
        public static WebElement btn_clickGetNotifiedSubscribe() throws Exception{
        	try{
	    		// 15-Aug-2017 MR#47265
        	//	element = driver.findElement(By.xpath("//*[contains(@class, 'GS_footer_PAlite')]//*[@value='Subscribe']"));
        		element = driver.findElement(By.xpath("//*[contains(@class, 'GS_footer_subscr')]//*[@value='Subscribe']"));
        		Add_Log.info("Subscribe button is click on the page.");
        		
        	}catch(Exception e){
        		Add_Log.error("Subscribe button is NOT found on the page.");
				throw(e);
			}
			return element;        	
        }
		
		/**
		 * To verify PA upsell and "Subscribe" button are displayed in Get Notified section (Footer).
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_PAUpsell_SubsBtn_DisplayedInGetNotifiedSec(Read_XLS xls, String sheetName, int rowNum,
				List<Boolean> testFail) throws Exception{
			try{
				//*[contains(@class, 'GS_footer_PAlite')]//input
	    		// 15-Aug-2017 MR#47265
			//	Boolean isTxtbxExists = driver.findElements(
			//			By.xpath("//*[contains(@class, 'GS_footer_PA_filed ui_input_tip inputTip')]")).size() != 0;
				
			//	Boolean isBtnExists = driver.findElements(
			//			By.xpath("//*[contains(@class, 'GS_footer_PAlite')]//*[@value='Subscribe']")).size() != 0;
				
				Boolean isTxtbxExists = driver.findElements(
						By.xpath("//*[contains(@class, 'GS_footerSN_input')]")).size() != 0;
				
				Boolean isBtnExists = driver.findElements(
						By.xpath("//*[contains(@class, 'GS_footer_subscr')]//*[@value='Subscribe']")).size() != 0;
				
				Add_Log.info("Is Business Email field in Get Notified section exists ::" + isTxtbxExists);
				Add_Log.info("Is Subscribe button in Get Notified section exists ::" + isBtnExists);
				
				if(isTxtbxExists == true && isBtnExists == true){
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_GET_NOTIFIED_SECTION_EXISTS, rowNum, Constant.KEYWORD_PASS);
				}else{
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_GET_NOTIFIED_SECTION_EXISTS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}catch(Exception e){
				throw(e);
			}
			return element;
		}
     
    	// ================================================= Start of Inquiry Basket section locators ===============================================
			
		/**
		 * To verify there is no count is seen beside the 'Inquiry basket' in the Global navigation.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_noCountBesideInqBasket(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{
				/*Boolean isInqBasketCartContainItems = driver.findElements(By.xpath("//*[@id='navcount']")).size() != 0;  */
				Boolean isInqBasketCartContainItems = driver.findElement(By.xpath("//*[@id='navcount']")).isDisplayed();
				
	    		if(isInqBasketCartContainItems == true){    			
	    			Add_Log.info("The count is seen beside the 'Inquiry basket' in the Global navigation.");
	    			SuiteUtility.WriteResultUtility(
	    					xls, sheetName, Constant.COL_NO_COUNT_BESIDE_INQ_BASKET, rowNum, Constant.KEYWORD_FAIL);
	    			testFail.set(0, true);
	    		}else{			
	    			Add_Log.info("No count is seen beside the 'Inquiry basket' in the Global navigation.");
	    			SuiteUtility.WriteResultUtility(
	    					xls, sheetName, Constant.COL_NO_COUNT_BESIDE_INQ_BASKET, rowNum, Constant.KEYWORD_PASS);	
	    		}		    		
			}catch(Exception e){
				throw(e);
			}
			return element;
		}	
		
		/**
		 * Set result failed when "The count is seen beside the 'Inquiry basket' in the Global navigation".
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_countIsSeenBesideInqBasket(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{
				Add_Log.info("The count is seen beside the 'Inquiry basket' in the Global navigation.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NO_COUNT_BESIDE_INQ_BASKET, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
			}catch(Exception e){
				throw(e);
			}
			return element;
		}
		
		/**
		 * Set result passed when "No count is seen beside the 'Inquiry basket' in the Global navigation".
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_countIsUnseenBesideInqBasket(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{
				Add_Log.info("No count is seen beside the 'Inquiry basket' in the Global navigation.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NO_COUNT_BESIDE_INQ_BASKET, rowNum, Constant.KEYWORD_PASS);	
			}catch(Exception e){
				throw(e);
			}
			return element;			
		}	

    	// =================================================== Start of CPP section locators ===============================================
		
		/**
		 * Enter text for CPP E-mail address text box.
		 * 
		 * @return
		 * @throws Exception
		 */
		public static WebElement txtbx_enterCPPBusinessEmail() throws Exception{
			try{
	    		// 15-Aug-2017 MR#47265
			/*	WebDriverWait waits = new WebDriverWait(driver, 15);
				waits.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@name='email']")));
				element = driver.findElement(
						By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@name='email']"));
			*/	
				WebDriverWait waits = new WebDriverWait(driver, 15);
				waits.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@name='email']")));
				element = driver.findElement(
						By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@name='email']"));
				Add_Log.info("User is enter text for CPP E-mail address  field.");
				
			}catch(Exception e){
				Add_Log.error("CPP E-mail address text box is NOT found on the page.");
				throw(e);
			}
			return element;	
		}
		
		/**
		 * Click on the CPP Subscribe button.
		 * 
		 * @return
		 * @throws Exception
		 */
		public static WebElement btn_clickCPPSubscribe() throws Exception{
			try{
	    		// 15-Aug-2017 MR#47265
			/*	WebDriverWait waits = new WebDriverWait(driver, 15);
				waits.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@value='Subscribe']")));
				
        		WebElement element = driver.findElement(
        				By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@value='Subscribe']"));  
        	*/	
				WebDriverWait waits = new WebDriverWait(driver, 15);
				waits.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@value='Subscribe']")));
				
        		WebElement element = driver.findElement(
        				By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@value='Subscribe']"));  
        		JavascriptExecutor executor = (JavascriptExecutor)driver;
        		executor.executeScript("arguments[0].click();", element);
        		
				Add_Log.info("CPP Subscribe button is click on the page.");
				
			}catch(Exception e){
				Add_Log.info("CPP Subscribe button is NOT found on the page.");				
				throw(e);
			}
			return element;	
		}
		
		/**
		 * To verify 'Free Alerts on newly added products!' copy is available.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_copyCPPFreeAlertsExists(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{
				Boolean isMsgExists = driver.findElements(
						By.xpath("//*[contains(text(),'Free Alerts on newly added products!')]")).size() != 0;
				Add_Log.info("Is 'Free Alerts on newly added products!' copy available ::" + isMsgExists);
				
				if(isMsgExists == true){
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_CPP_MSG_FREE_ALERTS_EXISTS, rowNum, Constant.KEYWORD_PASS);
				}else{
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_CPP_MSG_FREE_ALERTS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}catch(Exception e){
				Add_Log.error("Free Alerts on newly added products copy is NOT found on the page.");
				throw(e);
			}
			return element;	
		}
		
		/**
		 * To verify CPP E-mail address text box is available on the page.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_txtbxCPPBusinessEmailExists(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{
	    		// 15-Aug-2017 MR#47265
				Boolean isTxtbxExists = driver.findElements(
						By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@name='email']")).size() != 0;
			//			By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@name='email']")).size() != 0;
				
				Add_Log.info("CPP E-mail address text box is available on the page ::" + isTxtbxExists);
				
				if(isTxtbxExists == true){
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_CPP_EMAIL_TXTBX_EXISTS, rowNum, Constant.KEYWORD_PASS);
				}else{
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_CPP_EMAIL_TXTBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}catch(Exception e){
				Add_Log.error("CPP E-mail address text box is NOT found on the page.");
				throw(e);
			}
			return element;	
		}
		
		/**
		 * To verify CPP E-mail address is entered in e-mail address text box.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @param dataBusinessEmail
		 * @return
		 * @throws Exception
		 */
        public static WebElement check_txtbxCPPEmailAddrIsEntered(Read_XLS xls, String sheetName, int rowNum,
        		List<Boolean> testFail, String dataBusinessEmail) throws Exception{
        	try{
	    		// 15-Aug-2017 MR#47265
        		// Get the text entered in 'Email Address' field
        		String textEnteredEmailAddr = driver.findElement(
        	//			By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@name='email']")).getAttribute("value");
        				By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@name='email']")).getAttribute("value");  
        		
        		if(textEnteredEmailAddr.equals(dataBusinessEmail)){
        			Add_Log.info("E-mail address is entered in e-mail address text box");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_CPP_EMAIL_TXTBX_IS_ENTERED, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			Add_Log.info("E-mail address is NOT entered in e-mail address text box");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_CPP_EMAIL_TXTBX_IS_ENTERED, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        	}catch(Exception e){
        		Add_Log.error("CPF E-mail Address fiels is NOT found on the page.");
        		throw(e);
        	}
        	return element;
        }
		
		/**
		 * To verify CPP E-mail address text box is left blank.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_txtbxCPPEmailIsBlank(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{
	    		// 15-Aug-2017 MR#47265
        	//	element = driver.findElement(By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@name='email']"));
        		element = driver.findElement(By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@name='email']"));
        		String txtbxEmailAddr = element.getAttribute("value");
        		Add_Log.info("Email Address field value ::" + txtbxEmailAddr);
        		
        		if(txtbxEmailAddr.isEmpty()){
        			Add_Log.info("CPP E-mail address text box is left blank" );
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_CPP_EMAIL_TXTBX_IS_BLANK, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			Add_Log.info("CPP E-mail address text box is NOT left blank" );
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_CPP_EMAIL_TXTBX_IS_BLANK, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
			}catch(Exception e){
				Add_Log.error("CPF E-mail address text box is NOT found on the page.");
				throw(e);
			}
			return element;	
		}
		
		/**
		 * To verify "Subscribe" button is available and displayed next to e-mail address text box.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_btnSubscribeIsAvailable(Read_XLS xls, String sheetName, int rowNum,
				List<Boolean> testFail) throws Exception{
			try{
	    		// 15-Aug-2017 MR#47265
				Boolean isBtnExists = driver.findElements(
						By.xpath("//*[contains(@class, 'GS_newPP_PA')]//input[@value='Subscribe']")).size() != 0;
			//			By.xpath("//*[contains(@class, 'HP_ppAlertLite')]//input[@value='Subscribe']")).size() != 0;
				Add_Log.info("Subscribe button is available on the page ::"+ isBtnExists);
				
				if(isBtnExists == true){
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_CPP_SUBS_BTN_IS_EXISTS, rowNum, Constant.KEYWORD_PASS);
				}else{
					SuiteUtility.WriteResultUtility(
							xls, sheetName, Constant.COL_CPP_SUBS_BTN_IS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
				
			}catch(Exception e){
				Add_Log.error("Subscribe button is NOT found on the page.");
				throw(e);
			}
			return element;
		}
		
		/**
		 * To verify error message "Please enter your e-mail address" is displayed in a pop up window.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
        public static WebElement check_alertMsgEnterEmailAddrExists(Read_XLS xls, String sheetName, int rowNum, 
        		List<Boolean> testFail) throws Exception{
        	try{
        		// Get a handle to open alert, prompt for confirmation
        		Alert alert = driver.switchTo().alert();
        		    		
        		// Get pop up window message
        		String popupMessage = alert.getText();
        		Add_Log.info("Pop up window message ::" + popupMessage);
        		    		
        		String expectedMessage = "Please enter your e-mail address";
        		
        		// To verify a pop up window with message "Please enter your e-mail address" is displayed.
        		if(popupMessage.equals(expectedMessage)){
        			Add_Log.info("Pop up window with message 'Please enter your e-mail address' is displayed.");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_ENTER_EMAIL_ADDR_EXISTS, rowNum, Constant.KEYWORD_PASS);
        		}else{
        			Add_Log.info("Pop up window with message 'Please enter your e-mail address' is NOT displayed.");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_MSG_ENTER_EMAIL_ADDR_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        			testFail.set(0, true);
        		}
        		
        		// Accept the alert - equivalent of pressing Ok
        		alert.accept();

        	}catch(Exception e){
        		throw(e);
        	}
        	return element;
        }

		
		// To verify up to 3PP images with VSPD are displayed in each page. Maximum 3 pages.
		public static WebElement check_upTo3PPImgWithVSPD(Read_XLS xls, String sheetName, int rowNum, 
				List<Boolean> testFail) throws Exception{
			try{
				Boolean isImgExists = driver.findElements(By.xpath("")).size() != 0;
				Add_Log.info("Is 3PP images with VSPD are displayed in each page. Maximum 3 pages ::" + isImgExists);
				
				if(isImgExists == true){
				//	SuiteUtility.WriteResultUtility(
				//			xls, sheetName, Constant.COL_3PP_IMG_WITH_VSPD_CPP, rowNum, Constant.KEYWORD_PASS);
				}else{
				//	SuiteUtility.WriteResultUtility(
				//			xls, sheetName, Constant.COL_3PP_IMG_WITH_VSPD_CPP, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
				}
			}catch(Exception e){
				throw(e);
			}
			return element;
		}
		
		/**
		 * To verify 'Inquire Now' button is available when mouseover the PP image.
		 * 
		 * @param xls
		 * @param sheetName
		 * @param rowNum
		 * @param testFail
		 * @return
		 * @throws Exception
		 */
		public static WebElement check_mouseoverPPImg_InqNowBtnExists(Read_XLS xls, String sheetName, int rowNum,
				List<Boolean> testFail) throws Exception{
			try{
	    		// Locate the first image
	    		WebElement imgHover = driver.findElement(
	    				By.xpath("(//*[contains(@class, 'HP_ppShow_infoCon')])[position()=1]"));
				
	    		// Hover mouse above the image but DONT click
	    		Actions builder = new Actions(driver);
	    		builder.moveToElement(imgHover).build().perform();
	    		
	    		// Verified the 'Inquire Now' button inside the zoomed image.
	    		Boolean isBtnExists = driver.findElements(
	    				By.xpath("//*[contains(@class, 'HP_ppShow_btn')]//a[contains(text(),'Inquire Now')]")).size() != 0;
	    		Add_Log.info("Is Inquire Now button available when mouseover the PP image" + isBtnExists);
	    		
	    		if(isBtnExists == true){
	    			SuiteUtility.WriteResultUtility(
	    					xls, sheetName, Constant.COL_CPP_INQ_NOW_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
	    		}else{
	    			SuiteUtility.WriteResultUtility(
	    					xls, sheetName, Constant.COL_CPP_INQ_NOW_BTN_EXISTS	, rowNum, Constant.KEYWORD_FAIL);
	    			testFail.set(0, true);
	    		}
			}catch(Exception e){
				throw(e);
			}
			return element;
		}
		
    	// ====================================================== End of CPP section locators =======================================================			

    }	
