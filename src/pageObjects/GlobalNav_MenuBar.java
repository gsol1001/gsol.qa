/**
 * This Class contains methods that represent the locators available on Top Nav Menu Bar
 * Created: Wed 09 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/09
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Contains methods that represent the locators available on Global Nav Menu Bar.
 * @author Teng Shyh Wei
 *
 */
public class GlobalNav_MenuBar extends BaseClass{
	
    private static WebElement element = null;
    
    public GlobalNav_MenuBar(WebDriver driver){
        	super(driver);
    }

    /**
     * Click on Login button at Global Navigation.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_clickGlobalNavigationLogin() throws Exception{
        try{
        	element = driver.findElement(
        			By.xpath("//*[contains(@class, 'GS_userNav_item')][contains(text(),'Login')]"));
        	
        	WebDriverWait waits = new WebDriverWait(driver, 15);
        	waits.until(ExpectedConditions.elementToBeClickable(element));
        
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            
        	Add_Log.info("Login button is click on the page.");
        	
        }catch(Exception e){
        	Add_Log.error("Login button is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    } 
    
    // Generate mouse hover event on Global Notification to click on "Resend e-mail" link
    public static WebElement menuBar_clickResendEmailLink() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]")); 
    		WebElement subMenu = driver.findElement(By.id("DOI_resend"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Resend e-mail link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Resend e-mail link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * Generate mouse hover event on Global Notification to click on User Profile.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_selectUserProfile() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));        		
    		WebElement subMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]"
    				+ "//*[contains(text(),'User Profile')]"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu User Profile is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu User Profile is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Generate mouse hover event on Global Notification to click on 'My Product Alert'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_selectMyProductAlert() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));        		
    		WebElement subMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]"
    						+ "//*[contains(text(),'My Product Alert')]"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu My Product Alert is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu My Product Alert is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Generate mouse hover event on Global Notification to click on Edit Categories.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_selectEditCategories() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]")));
    		
    		Actions actions = new Actions(driver);    		
    		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));        		
    		WebElement subMenu = driver.findElement(By.xpath("//*[@id='useNav_PA']/a"));        		
    		WebElement childSubMenu = driver.findElement(By.xpath("//*[@id='useNav_PA']/ul/li/a"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).moveToElement(childSubMenu).click().build().perform();    		
    		Add_Log.info("Sub menu Edit Categories is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Edit Categories is NOT found on the page");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());

    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Generate mouse hover event on Global Notification to click on 'My Preferred Exhibitors'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_selectMyPreferredExhibitors() throws Exception{
    	try{
    		Actions actions = new Actions(driver);    		
    		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));
    		WebElement subMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]"
    				+ "//*[contains(text(),'My Preferred Exhibitors')]"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu My Preferred Exhibitors is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu My Preferred Exhibitors is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    /**
     * Generate mouse hover event on Global Notification to click on 'Register As Supplier'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_selectRegisterAsSupplier() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));        		
    		WebElement subMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]"
    						+ "//*[contains(text(),'Register as Supplier')]"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Register as Supplier is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Register as Supplier is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Generate mouse hover event on Global Navigation to click on 'Logout' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_clickLogout() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
        	WebElement mainMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]//a[contains(text(),'Logout')]"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Logout button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Logout button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Generate mouse hover event on Global Navigation to click on Register for Buyer.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_selectRegisterForBuyer() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='global_navigation']//a[contains(text(),'Register')]"));       
    		WebElement subMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]"
    						+ "//*[contains(text(),'Buyer')]"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Register for buyer is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Register for buyer is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Generate mouse hover event on Global Navigation to click on Register for Supplier.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_selectRegisterForSupplier() throws Exception{
    	try{
    		Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='global_navigation']//a[contains(text(),'Register')]"));        		
    		WebElement subMenu = driver.findElement(By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]"
    						+ "//*[contains(text(),'Supplier')]"));        		
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();
    		Add_Log.info("Sub menu Register for supplier is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Register for supplier is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the menu "Messages" at Global Navigation.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_clickMessages() throws Exception{
    	try{
    		// 28-Mar-2018 MC project
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item')][contains(text(),'Messages')]"));
    		element = driver.findElement(By.xpath("//*[contains(@class, 'GS_userNav_item')]//*[contains(text(),'Messages')]"));
    		Add_Log.info("Messages menu bar is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Messages menu bar is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the icon "Inquiry Basket" at Global Navigation.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickInquiryBasketCart() throws Exception{
    	try{
    		// 15-Aug-2017 MR#47265 
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    	//	waits.until(ExpectedConditions.visibilityOfElementLocated(By.className("addToBasketIco")));
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.className("addToBasketIcon")));
    		
    		element = driver.findElement(By.xpath("//*[contains(@class, 'addToBasketIco')]"));
    		Add_Log.info("Inquiry Basket Cart is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquiry Basket Cart is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * To verify 'Login' button are exist in Global Navigator.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_loginBtnExistsInGlobalNav(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isLoginBtnExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'GS_userNav_item')][contains(text(),'Login')]")).size() != 0;
    		Add_Log.info("Is 'Login' button exists in Global Navigator ::" + isLoginBtnExists);
    		
    		if(isLoginBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LOGIN_BTN_EXISTS_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LOGIN_BTN_EXISTS_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.info("Login button are NOT exists in Global Navigator.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify user FirstName is displayed in Global Navigator.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataFirstName
     * @return
     * @throws Exception
     */
    public static WebElement check_firstNameDisplayedInGlobalNav(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataFirstName) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'GS_userName')]"));
    		String getFirstName = element.getText();
    		
    		if(getFirstName.equals(dataFirstName)){
    			Add_Log.info("User Given/First Name is displayed in Global Nav.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FIRST_NAME_DISPLAYED_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("User Given/First Name is NOT displayed in Global Nav.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FIRST_NAME_DISPLAYED_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Generate mouse hover on User Nav menu bar at Global Navigator.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_mousehoverOnUserNav() throws Exception{
    	try{
    		// Locate menu bar User Nav
    		WebElement mousehoverMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'GS_userNav_item userName')]"));
			
    		// Hover mouse above the menu but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(mousehoverMenu).build().perform();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify My Product Alert, My Preferred Exhibitors, Private Supplier Catalog, User Profile and Logout button 
     * are displayed under SYP User Nav menu bar.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_subMenuSYPUserAvailable(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> userNavList = wait.
    				until(ExpectedConditions.presenceOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]//li")));

    		List<String> userNavNameList = new ArrayList<String>();
			for (WebElement element : userNavList){
				Add_Log.info("SYP User Nav List ::" + element.getText());
				userNavNameList.add(element.getText());
			}	
			
			String[] expUserNavList = {"My Product Alert", "My Preferred Exhibitors", "Private Supplier Catalog", "User Profile", "Logout"};
			
    		List<String> expSubMenuSYPUser = Arrays.asList(expUserNavList);
    		if(userNavNameList.containsAll(expSubMenuSYPUser)){
    			Add_Log.info("My Product Alert, My Preferred Exhibitors, Private Supplier Catalog, User Profile and Logout button "
    					+ "are displayed under SYP User Nav menu bar");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_SYP_USER_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("My Product Alert, My Preferred Exhibitors, Private Supplier Catalog, User Profile and Logout button "
    					+ "are NOT displayed under SYP User Nav menu bar");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_SYP_USER_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify User Profile, My Product Alert, My Preferred Exhibitors, Register as Supplier and Logout button 
     * are displayed under Non SYP User Nav menu bar.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_subMenuNonSYPUserAvailable(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> userNavList = wait.
    				until(ExpectedConditions.presenceOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]//li")));

    		List<String> userNavNameList = new ArrayList<String>();
			for (WebElement element : userNavList){
				Add_Log.info("Non SYP User Nav List ::" + element.getText());
				userNavNameList.add(element.getText());
			}	
			
			String[] expUserNavList = {"User Profile", "My Product Alert", "My Preferred Exhibitors", "Register as Supplier", "Logout"};
			
    		List<String> expSubMenuNonSYPUser = Arrays.asList(expUserNavList);
    		if(userNavNameList.containsAll(expSubMenuNonSYPUser)){
    			Add_Log.info("User Profile, My Product Alert, My Preferred Exhibitors, Register as Supplier and Logout button "
    					+ "are displayed under non SYP User Nav menu bar");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_NON_SYP_USER_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("User Profile, My Product Alert, My Preferred Exhibitors, Register as Supplier and Logout button "
    					+ "are NOT displayed under non SYP User Nav menu bar");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_NON_SYP_USER_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify DOI Reminder message are displayed under menu User Nav at Global Navigator.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_DOIMsgExistsInGlobalNav(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isDOIMsgExists = driver.findElements(By.id("DOI_alertMsg")).size() != 0;
    		Add_Log.info("Is DOI Reminder message displayed under menu User Nav at Global Navigator ::" + isDOIMsgExists);
    		
    		if(isDOIMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_GLOBAL_NAV_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_GLOBAL_NAV_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify DOI Reminder message are not displayed under menu User Nav at Global Navigator.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_DOIMsgNotExistsInGlobalNav(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isDOIMsgExists = driver.findElements(By.id("DOI_alertMsg")).size() != 0;
    		Add_Log.info("Is DOI Reminder message displayed under menu User Nav at Global Navigator ::" + isDOIMsgExists);
    		
    		if(isDOIMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_GLOBAL_NAV_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_GLOBAL_NAV_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // DOI message changed to "The confirmation e-mail has been sent to autoqa_gsol1001@gmail.com. 
    // Click on the link in the e-mail to activate." is displayed.
    public static WebElement check_DOIMsgChangedIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DOI_cofirmMsg")));
    		
    		Boolean isDOIMsgExists = driver.findElement(By.id("DOI_cofirmMsg")).isDisplayed(); 
    		Add_Log.info("Is DOI message exists ::" + isDOIMsgExists);
    		
    		if(isDOIMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_REMINDER_MSG_CHANGED_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_REMINDER_MSG_CHANGED_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("DOI message is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify Logout are displayed under menu User Nav at Global Navigator.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_logoutBtnExistsInGlobalNav(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> userNavList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop')]/li/a")));
    		
    		List<String> userNavNameList = new ArrayList<String>();
			for (WebElement element : userNavList){
				Add_Log.info("User Nav List ::" + element.getText());
				userNavNameList.add(element.getText());
			}	
			
    		if(userNavNameList.contains("Logout")){
    			Add_Log.info("Logout button is exists in Global Nav.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LOGOUT_BTN_EXISTS_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Logout button is NOT exists in Global Nav.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LOGOUT_BTN_EXISTS_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Logout button are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * Generate mouse hover on Register menu bar at Global Navigator.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_mousehoverOnRegister() throws Exception{
    	try{
    		// Locate menu bar Register
    		WebElement mousehoverMenu = driver.findElement(
    				By.xpath("//*[@id='global_navigation']/ul/li[2]"));
			
    		// Hover mouse above the menu but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(mousehoverMenu).build().perform();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify "Buyer" Register button are exist in Global Navigator.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerRegisterBtnExistsInGlobalNav(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> regList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop GS_reg_pop')]/li/a")));
    		
    		List<String> regNameList = new ArrayList<String>();
			for (WebElement element : regList){
				Add_Log.info("Register List ::" + element.getText());
				regNameList.add(element.getText());
			}	
			
    		if(regNameList.contains("Buyer")){
    			Add_Log.info("'Buyer' Register button are exist in Global Nav.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_REG_EXISTS_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("'Buyer' Register button are NOT exist in Global Nav.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_REG_EXISTS_IN_GLOBAL_NAV, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Buyer register button are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }  
    
    /**
     * To verify Buyer and Supplier button are displayed under the Register menu.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_subMenuRegisterAvailable(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> registerList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'GS_globalNav_pop GS_userNav_pop GS_reg_pop')]//li")));
    		
    		List<String> magazinesNameList = new ArrayList<String>();
			for (WebElement element : registerList){
				Add_Log.info("Magazines List ::" + element.getText());
				magazinesNameList.add(element.getText());
			}	
			
			String[] expRegisterList = {"Buyer", "Supplier"};
			
    		List<String> expSubMenuRegister = Arrays.asList(expRegisterList);
    		if(expSubMenuRegister.containsAll(magazinesNameList)){
    			Add_Log.info("Buyer and Supplier are displayed under the Register Link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_REGISTER_AVAILABLE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Buyer and Supplier are NOT displayed under the Register Link.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUB_MENU_REGISTER_AVAILABLE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Sub menu Register are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
