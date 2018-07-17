/**
 * This Class contains methods that represent the locators available on User Profile Page
 * Created: Mon 06 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/06
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on User Profile page.
 * @author Teng Shyh Wei
 *
 */
public class UserProfile_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public UserProfile_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify User Profile page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_userProfilePageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'pageheader')]"));
    		String userProfileTitle = element.getText();
    		String expectedTitle = "User Profile";
    		Add_Log.info("Page title ::" + userProfileTitle);
    		
    		if(userProfileTitle.equals(expectedTitle)){
    			Add_Log.info("User Profile page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_USER_PROFILE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("User Profile page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_USER_PROFILE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! User Profile page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that the information entered during registration are correct.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param dataTitle
     * @param dataFirstName
     * @param dataLastName
     * @param dataCompName
     * @param dataBusinessEmail
     * @param dataCountryTerritory
     * @param dataCountryCode
     * @param dataTelephoneNumber
     * @return
     * @throws Exception
     */
    public static WebElement check_infoEnteredDuringRegistrationAreMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataTitle, String dataFirstName, String dataLastName, String dataCompName, 
    		String dataBusinessEmail, String dataCountryTerritory, String dataTelephoneNumber) throws Exception{
    	try{    		
    		
    		// Get the value selected in "Salutation" field
    		String valueSelectedInTitle = new Select(driver.findElement(By.name("fld_Salutation[0]"))).getFirstSelectedOption().getText();
    		
    		// Get the text entered in 'First/Given Name' field
            String txtEnteredInFirstName = driver.findElement(By.id("firstname")).getAttribute("value");
            
            // Get the text entered in 'Last/Family Name' field
            String txtEnteredInLastName = driver.findElement(By.id("lastname")).getAttribute("value");
            
            // Get the text entered in 'Company Name' field
            String txtEnteredInCompName = driver.findElement(By.name("fld_Company.CompanyName[0]")).getAttribute("value");
            
            // Get the text entered in 'Business E-mail' field
            String txtEnteredInBusinessEmail = driver.findElement(By.name("fld_Mail[0]")).getAttribute("value");                
            
            // Get the value selected in "Country/Territory" field
            String valueSelectedInCountry = new Select(driver.findElement(By.id("regCountry"))).getFirstSelectedOption().getText();
            
            // Get the text entered in 'Telephone Number' field
            String txtEnteredInTelephoneNumber = driver.findElement(By.id("fld_PhoneNumber")).getAttribute("value");                                        
            
            if( (valueSelectedInTitle.equals(dataTitle)) && (txtEnteredInFirstName.equals(dataFirstName)) && 
            		(txtEnteredInLastName.equals(dataLastName)) && (txtEnteredInCompName.equals(dataCompName)) && 
            		(txtEnteredInBusinessEmail.equals(dataBusinessEmail)) && (valueSelectedInCountry.equals(dataCountryTerritory)) &&
            		(txtEnteredInTelephoneNumber.equals(dataTelephoneNumber)) ){
            	
            	Add_Log.info("The information entered during registration are remain unchanged.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_USER_PROFILE_INFO_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
            }else{
            	
            	Add_Log.info("The information entered during registration are NOT remain unchanged.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_USER_PROFILE_INFO_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
            }
            
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== Start of User Account section =====================================================
    
    /**
     * To click on the 'Buyer Profile' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSideBarBuyerProfile() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Buyer Profile')]"));
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		Add_Log.info("Buyer Profile link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Buyer Profile link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'Notification' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSideBarNotification() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Notification')]"));
    		Add_Log.info("Notification link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Notification link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Notifications page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_notificationsPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String notificationsTitle = driver.findElement(
    				By.xpath("//*[contains(@class, 'headername')][contains(text(),'Notifications')]")).getText();
    		String expectedTitle = "Notifications";
    		Add_Log.info("Page title ::" + notificationsTitle);
    		
    		if(notificationsTitle.equals(expectedTitle)){
    			Add_Log.info("Notifications page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NOTIFICATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Notifications page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NOTIFICATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * To verify that Notifications checkboxes are checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_allNotificationChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'userProfile_con')]//input[@type='checkbox']")).isSelected();
    		Add_Log.info("Is all notification checkboxes are checked ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_NOTIFICATION_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_NOTIFICATION_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that Notification checkboxes are unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_allNotificationChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'userProfile_con')]//input[@type='checkbox']")).isSelected();    	    		
    		Add_Log.info("Is all notification checkboxes are checked ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_NOTIFICATION_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_NOTIFICATION_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_PASS);    			
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that preferred e-mail format is set to default (HTML).
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_emailFormatSetToDefault(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isEmailFormatSetToDefault = driver.findElement(
    				By.xpath("(//*[contains(@class, 'userProfile_con')]//input[@type='radio'])[position()=1]")).isSelected();
    		Add_Log.info("Is e-mail format set to default (HTML) ::" + isEmailFormatSetToDefault); 
    		
    		if(isEmailFormatSetToDefault == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_FORMAT_SET_TO_DEFAULT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_FORMAT_SET_TO_DEFAULT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================= Start of Buyer Services section ====================================================
    
    /**
     * To click on the 'Product Alert' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSideBarProductAlert() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//a[contains(text(),'Product Alert')])[position()=1]"));
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Product Alert link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product Alert link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'Supplier Alert' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSideBarSupplierAlert() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Supplier Alert')]"));
    		Add_Log.info("Supplier Alert link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier Alert link is NOT found on the page.");
        	throw(e);
        }
        return element;
    }
        
    /**
     * To click on the 'Edit Supplier' link at left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSideBarEditSuppliers() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(), 'Edit Suppliers')]"));
    		Add_Log.info("Edit Supplier link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Edit Supplier link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'Settings' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSettings() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
    		Add_Log.info("Settings link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Settings link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'Sourcing Magazines' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSideBarSourcingMagazines() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Sourcing Magazines')]"));
    		Add_Log.info("Sourcing Magazines link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Sourcing Magazines link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
   
    /**
     * To click on the 'China Sourcing Reports' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickChinaSourcingReports() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'China Sourcing Reports')]"));
    		Add_Log.info("China Sourcing Reports link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("China Sourcing Reports link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'Private Sourcing Events' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickPrivateSourcingEvents() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Private Sourcing Events')]"));
    		Add_Log.info("Private Sourcing Events link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Private Sourcing Events link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'Trade Show Center' link at the left nav.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickTradeShowCenter() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Trade Show Center')]"));
    		Add_Log.info("Trade Show Center link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Trade Show Center link is NOT found on thr page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on "Buyer Profile" link in User Profile page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickBuyerProfile() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//a[contains(text(),'Buyer Profile')])[last()]"));
    		Add_Log.info("Buyer Profile link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Buyer Profile link is NOT found on the page.");
    		    		
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== End of Buyer Services section =====================================================
    
}
