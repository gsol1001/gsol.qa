/**
 * This Class contains methods that represent the locators available on RFI Confirmation Page
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on RFI Confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class RFIConfirmation_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public RFIConfirmation_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify is RFI Confirmation page displayed with using ExplicitWait.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_isRFIConfirmationPageDisplayed() throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Inquiry Manager"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Inquiry Manager")){
    			Add_Log.info("RFI Confirmation page is displayed");
    		}else{
    			Add_Log.info("RFI Confirmation page is NOT displayed.");
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! RFI Confirmation page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI Confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIConfirmationPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Inquiry Manager"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Inquiry Manager")){
    			Add_Log.info("RFI Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_CONFIRMATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("RFI Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_CONFIRMATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! RFI Confirmation page is NOT displayed.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI Confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIConfirmationPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Inquiry Manager"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Inquiry Manager")){
    			Add_Log.info("RFI Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_CONFIRMATION_PG_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("RFI Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_CONFIRMATION_PG_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! RFI Confirmation page is NOT displayed.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI Confirmation Copy Section is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIConfirmationCopySectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016
    	/*	Boolean isRFIConfirmationCopySectionExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'Your message has been sent')]")).size()!= 0;*/
    		Boolean isRFIConfirmationCopySectionExists = driver.
    				findElements(By.xpath("//*[contains(text(),'Message sent!')]")).size() != 0;
    		Add_Log.info("Is RFI Confirmation Copy section available ::" + isRFIConfirmationCopySectionExists);
    		
        	if(isRFIConfirmationCopySectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_CONFIRMATION_COPY_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_CONFIRMATION_COPY_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}    		        	
    	}catch(Exception e){
    		Add_Log.error("RFI Confirmation Copy section is NOT found on the page.");
    		throw(e);    		
    	}
    	return element;
    }
    
    // Verify RFI Confirmation Copy section is displayed.
    // - Your message has been sent to {company name}. Look out for the supplier's reply to your inquiry in your email inbox or at Global Sources.
    public static WebElement check_RFIConfirmationCopyMessageExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName) throws Exception{
    	try{
    		Boolean isRFIConfirmationCopyHeaderExists = 
    				driver.findElements(By.xpath("//h1[contains(text(),'Message sent!')]")).size() != 0;
    		Add_Log.info("Is RFI Confirmation Copy header available ::" + isRFIConfirmationCopyHeaderExists);
    		
    		Boolean isRFIConfirmationCopyTextExists = 
    				driver.findElements(By.xpath("//*[contains(text(),\'Your message has been sent to " + getSuppName + ".\')]")).size() != 0;
    		Add_Log.info("Is RFI Confirmation Copy text available ::" + isRFIConfirmationCopyTextExists);
    		
    		if(isRFIConfirmationCopyHeaderExists == true && isRFIConfirmationCopyTextExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_CONFIRMATION_COPY_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_CONFIRMATION_COPY_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
    		}    		
    	}catch(Exception e){
    		Add_Log.error("RFI Confirmation Copy message is NOT found on the page.");
    		throw(e);    		
    	}
    	return element;
    }
    
    // ======================================================= Start of Message Center Section ======================================================
    
    /**
     * Click on the 'Message Center' hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickMessageCenter() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'msg_promot mt15')]//a"));
    		Add_Log.info("User is click on Message Center hyperlink.");
    		
    	}catch(Exception e){
    		Add_Log.error("Message Center hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    // ===================================================== Start of Inquire All upsell Section ====================================================
    
    /**
     * To verify Inquire All upsell Section is not available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellSectionNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isInqAllUpsellSectionExists = driver.findElements(By.name("contactSupForm")).size()!= 0;
    		Add_Log.info("Is Inquire All upsell section available ::" + isInqAllUpsellSectionExists); 
    		
        	if(isInqAllUpsellSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);        		
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}        	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquire All upsell section 'contact all other x suppliers of {inquired L4 category}' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellSection_ContactAllOtherSuppExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016 
    		// 'Don't miss out on these x other verified suppliers of {inquired L4 category}'
    	//	Boolean isInqAllUpsellSection_ContactAllOtherSuppExists = driver.findElements(By.name("contactSupForm")).size() != 0;
    		Boolean isInqAllUpsellSection_ContactAllOtherSuppExists = driver.findElements(By.name("contactSupForm")).size()!= 0;
    		
    		Add_Log.info("Is 'Contact all other x suppliers of {Inquired L4 category}' is displayed ::" + isInqAllUpsellSection_ContactAllOtherSuppExists);
    		
        	if(isInqAllUpsellSection_ContactAllOtherSuppExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_OTHER_EXISTS, rowNum, Constant.KEYWORD_PASS);         		
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_OTHER_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify Inquire All upsell section 'Don't miss out on these x other verified suppliers of {inquired L4 category}' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNnum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellSection_DontMissOutOtherSuppExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{    	
    		Boolean isInqAllUpsellSection_DontMissOutOtherSuppExists = driver.findElements(By.name("contactSupForm")).size() != 0;
    		Add_Log.info("Is 'Don't miss out on these x other verified supplier of {inquired L4 category}' displayed :: " + isInqAllUpsellSection_DontMissOutOtherSuppExists);
    		
    		if(isInqAllUpsellSection_DontMissOutOtherSuppExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_DONT_MISS_OUT_OTHER_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{    			
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_DONT_MISS_OUT_OTHER_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);		
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquire All upsell section 'You still have x items in your inquiry basket.' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellSection_ItemsInInqBasketExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isInqAllUpsellSection_ItemsInInqBasketExists = driver.findElements(By.name("contactSupForm")).size() != 0;
    		Add_Log.info("Is 'You still have x items in your inquiry basket' displayed ::" + isInqAllUpsellSection_ItemsInInqBasketExists);
    		
    		if(isInqAllUpsellSection_ItemsInInqBasketExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_ITEMS_IN_INQ_BASKET_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_ITEMS_IN_INQ_BASKET_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquire All upsell section 'Contact All Now' button is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellSection_ContactAllNowBtnExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// UI changed on Date 26-Jan-2016 
    		//*[@name='contactSupForm']//a[contains(text(),'Contact All Suppliers Now')]
    		Boolean isInqAllUpsellSection_ContactAllNowBtnExists = 
    				driver.findElements(By.xpath("//*[@name='contactSupForm']//a[contains(text(),'Contact All Now')]")).size()!= 0;
    		Add_Log.info("Is Contact All Now button available ::" + isInqAllUpsellSection_ContactAllNowBtnExists);
    		
        	if(isInqAllUpsellSection_ContactAllNowBtnExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_NOW_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_NOW_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Contact All Now' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContactAllNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[@name='contactSupForm']//a[contains(text(),'Contact All Now')]"));
    		Add_Log.info("Contact All Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Contact All Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquire All upsell section 'Contact All Suppliers Now' button is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellSection_ContactAllSuppNowBtnExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isInqAllUpsellSection_ContactAllSuppNowBtnExists = driver.findElements(
    				By.xpath("//*[@name='contactSupForm']//a[contains(text(),'Contact All Suppliers Now')]")).size() != 0;
    		Add_Log.info("Is Contact All Suppliers Now button exists ::" + isInqAllUpsellSection_ContactAllSuppNowBtnExists);
    		
    		if(isInqAllUpsellSection_ContactAllSuppNowBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_SUPP_NOW_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_ALL_UPSELL_SEC_CONTACT_ALL_SUPP_NOW_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Contact All Suppliers Now' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContactAllSuppNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[@name='contactSupForm']//a[contains(text(),'Contact All Suppliers Now')]"));
    		Add_Log.info("Contact All Suppliers Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Contact All Suppliers Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ====================================================== End of Inquire All upsell Section =====================================================
    
    // ========================================================= Start of SA upsell Section =========================================================
    
    /**
     * To verify SA upsell section is available on the page.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_SASectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{  
    		Boolean isSupplierAlertSectionExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'Update me on this supplier')]")).size()!= 0;
    		Add_Log.info("Is Supplier Alert section available ::" + isSupplierAlertSectionExists);
        	if(isSupplierAlertSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SA_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SA_UPSELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify SA upsell section is not available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_SASectionNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{  
    		Boolean isSupplierAlertSectionExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'Update me on this supplier')]")).size()!= 0;
    		Add_Log.info("Is Supplier Alert section available ::" + isSupplierAlertSectionExists);
    		
        	if(isSupplierAlertSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SA_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SA_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);     		
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select SA Upsell checkbox.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @param dataFollowSupp
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectSAUpsell(String dataFollowSupp) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'mt5')]//input[@id='checkbox']"));
    		if(dataFollowSupp.equalsIgnoreCase("y")){
    			element.click();
    		}else{
    			// do nothing.
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Follow Now' button.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFollowNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='originalFollowSup']//a[contains(text(),'Follow Now')]"));
    		Add_Log.info("User is click on 'Follow Now' button");
    		
    	}catch(Exception e){
    		Add_Log.error("Follow Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the SA checkbox is pre-checked.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_SAChkbxIsPrechecked(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'mt5')]//input[@id='checkbox']"));
    		Boolean isChkbxPrechecked = element.isSelected();
    		Add_Log.info("Is SA checkbox pre-checked ::" + isChkbxPrechecked);
    		
    		if(isChkbxPrechecked == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_CHKBX_IS_PRECHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_CHKBX_IS_PRECHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify copy "You are now successfully following <supplier name> company." is displayed.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_copySuccFollowingExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String suppName) throws Exception{
    	try{
    		WebElement element = driver.findElement(By.id("savedFollowSup"));
    		String getSAText = element.getText();
    		String expectedText = "You are now successfully following (" + suppName + ")";
    		
    		if(getSAText.contains(expectedText)){
    			Add_Log.info("Copy 'You are now successfully following (" + suppName + ")' is available");
       			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Copy 'You are now successfully following (" + suppName + ")' is NOT available");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }  
    
    /**
     * To verify copy "To view - or edit - all the the suppliers you're following, click here" is displayed.
     * Applied to test case 27F.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_copyViewEditSuppExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{   		
    		WebElement element = driver.findElement(By.id("savedFollowSup"));
    		String getSAText = element.getText();
    		Add_Log.info(getSAText);
    		String expectedText = "To view - or edit - all the suppliers you're following, click here.";
    		
    		if(getSAText.contains(expectedText)){
    			Add_Log.info("Copy 'To view - or edit - all the suppliers you're following, click here.' is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Copy 'To view - or edit - all the the suppliers you're following, click here.' is NOT displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);    			
    		}
    		
    	/*	Boolean isCopyExists = driver.findElements(
    				By.xpath("//*[contains(text(),\"To view - or edit - all the the suppliers you're following\")]"
    						+ "//a[contains(text(),'click here')]")).size() != 0;
    		Add_Log.info("Is copy 'To view - or edit - all the the suppliers you're following, click here.' displayed ::" + isCopyExists);
    	
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(text(),\"To view - or edit - all the the suppliers you're following\")]"
    						+ "//a[contains(text(),'click here')]"));
    		String getText = element.getText();
    		Add_Log.info("Print text ::" + getText);
    		
    		if(isCopyExists == true){	
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}	*/
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify "click here" is a hyperlink.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_clickHereIsHyperlink(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isLinkExists = driver.findElements(
    				By.xpath("//a[contains(text(),'click here')]")).size() != 0;
    		Add_Log.info("'click here' is a hyperlink ::" + isLinkExists);

    		if(isLinkExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CLICK_HERE_IS_HYPERLINK, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_CLICK_HERE_IS_HYPERLINK, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'click here' link in SA copy.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickOnClickHere() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'click here')]"));
    		Add_Log.info("User is click on 'click here' link in SA copy.");
    		
    	}catch(Exception e){
    		Add_Log.error("'click here' link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    // ========================================================== End of SA upsell Section ==========================================================
    
    // ========================================================= Start of PA upsell Section =========================================================
    
    /**
     * Click on PA upsell section 'Subscribe Now' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubscribeNow() throws Exception{
    	try{
    		// MR#41041 Button class changed on Date 26-Jan-2016
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'mt15')]//a[contains(text(),'Subscribe Now')]"));
    		Add_Log.info("Subscribe Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section is not available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PASectionNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isProductAlertSectionExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_PA_cat mt10')]")).size()!= 0;
    		Add_Log.info("Is Product Alert section available ::" + isProductAlertSectionExists);
    		
        	if(isProductAlertSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section 'update me on new {Inquired L4 category}' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param getL4Category
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_UpdateMeOnNewL4Exists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String getL4Category) throws Exception{
    	try{
    		Boolean isPASection_UpdateMeOnNewL4Exists = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_confirmOther')]"
    						+ "//*[contains(text(),'Update me on new " + getL4Category + "')]")).size()!= 0;
    		Add_Log.info("Is PA upsell 'update me on new " + getL4Category + "' available ::" + isPASection_UpdateMeOnNewL4Exists);
    		
    		if(isPASection_UpdateMeOnNewL4Exists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_UPDATE_ME_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_UPDATE_ME_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section 'update me on new {Sibling category}' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param getSiblingCategory
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_UpdateMeOnNewSiblingCatExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String getSiblingCategory) throws Exception{
    	try{
    		Boolean isPASection_UpdateMeOnNewSiblingCatExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_confirmOther')]"
    						+ "//*[contains(text(),'Update me on new " + getSiblingCategory + "')]")).size()!=0;
    		Add_Log.info("Is PA upsell 'Update me on new " + getSiblingCategory + "' available ::" + isPASection_UpdateMeOnNewSiblingCatExists);
    		
    		if(isPASection_UpdateMeOnNewSiblingCatExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_UPDATE_ME_NEW_SIBLING_CAT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_UPDATE_ME_NEW_SIBLING_CAT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section 'update me on new products' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_UpdateMeOnNewPdtExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// #MR41041 UI changed on Date 26-Jan-2016
    	/*	Boolean isPASection_UpdateMeOnNewPdtSuppExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_confirmOther')]"
    						+ "//*[contains(text(), 'Update me on new products and suppliers')]")).size() != 0;*/
    		Boolean isPASection_UpdateMeOnNewPdtExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_confirmOther')]"
    						+ "//*[contains(text(), 'Update me on new products')]")).size() != 0;
    		Add_Log.info("Is PA upsell 'update me on new products' available ::" + isPASection_UpdateMeOnNewPdtExists);
    		
    		if(isPASection_UpdateMeOnNewPdtExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_UPDATE_ME_NEW_PDT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_UPDATE_ME_NEW_PDT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /** 
     * To verify PA upsell section 'Category(s) for your Product Alert: {Inquired L4 category}' is available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_CategoryForYourPA(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isPASection_CategoryForYourPAExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'RFI_PA_cat mt10')]"
    						+ "//*[contains(text(),'Category(s) for your Product Alert:')]")).size()!= 0;
        	Add_Log.info("Is PA upsell 'Category(s) for your Product Alert: {Inquired L4 category}' available ::" + isPASection_CategoryForYourPAExists);
        	
        	if(isPASection_CategoryForYourPAExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_SEC_CAT_FOR_YOUR_PA_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_CAT_FOR_YOUR_PA_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! PA upsell section 'Category(s) for your Product Alert: {Inquired L4 category}' is NOT available on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section 'Category(s) below has been added to your Product Alert: {Inquired L4 category}' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_CategoryAddedExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isPASection_CategoryAddedExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'RFI_PA_cat mt10')]"
    						+ "//*[contains(text(),'Category(s) below has been added to your Product Alert:')]")).size()!= 0;
        	Add_Log.info("Is PA upsell 'category(s) below has been added to your PA: {inquired L4 category}' available ::" + isPASection_CategoryAddedExists);
        	
        	if(isPASection_CategoryAddedExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_SEC_CAT_ADDED_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_CAT_ADDED_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify the L4 category checkbox is checked
    
    /**
     * To verify PA upsell section 'Receive Product Alert in these categories:' is available on the page. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_ReceivePAExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isTextPAUpsellSectionExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_PA_catCon')]"
    						+ "//*[contains(text(),'Receive Product Alert in these categories:')]")).size() != 0;
    		Add_Log.info("Is Text PA upsell section available ::" + isTextPAUpsellSectionExists);
    		if(isTextPAUpsellSectionExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_RECEIVE_PA_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_RECEIVE_PA_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section '[List the inquired L4 categories (checkboxes are pre-checked)]' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_InqL4CatChkbxPrechecked(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{

    		Boolean isPASection_ChkbxPrechecked = 
    				driver.findElement(By.xpath("//*[contains(@class, 'form_PA_cat form_PA_catCheck')]"
    						+ "//input[@type='checkbox']")).isSelected();    	
    		Add_Log.info("Is PA upsell '[List the inquired L4 category (checkbox pre-checked)]' available ::" + isPASection_ChkbxPrechecked);
    		
    		if(isPASection_ChkbxPrechecked == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_CHKBX_PRECHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_CHKBX_PRECHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section '[List the inquired L4 category (max 6, 3 in a row, checkbox pre-checked)]
     * [Subscribe Now]' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_SubsNowBtnExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// To verify the listed inquired L4 category max 6 in the section
    		Boolean isPASection_MaxSixChkbx = 
    				driver.findElements(By.xpath("//*[contains(@class, 'form_PA_cat form_PA_catCheck')]"
    						+ "//input[@type='checkbox']")).size() <= 6;
    		
    		// To verify the listed inquire L4 category max 3 in a row
    	//	Boolean isPAUpsellMax3InRow = driver.findElement(By.xpath("PA")).getSize();
    		
    		// To verify checkbox is pre-checked
    		Boolean isPASection_ChkbxPrechecked = 
    				driver.findElement(By.xpath("//*[contains(@class, 'form_PA_cat form_PA_catCheck')]"
    						+ "//input[@type='checkbox']")).isSelected();
    		
    		// UI changed on Date 26-Jan-2016
    		//*[contains(@class, 'mt15')]//a[contains(text(),'Subscribe Now')]
    		// To verify 'Subscribed Now' button is available on the page
    	/*	Boolean isPASection_SubsNowBtnExists = 
        			driver.findElements(By.xpath("//*[contains(@class, 'mt5')]//a[contains(text(),'Subscribe Now')]")).size() != 0;*/
    		Boolean isPASection_SubsNowBtnExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'mt15')]//a[contains(text(),'Subscribe Now')]")).size() != 0;
    		
    	//	Add_Log.info("Is PA upsell '[List the inquired L4 category (max 2 in a row)]' available ::" + isPAUpsellMax3InRow);
    		Add_Log.info("Is PA upsell '[List the inquired L4 category (max 6)]' available ::" + isPASection_MaxSixChkbx);
    		Add_Log.info("Is PA upsell '[List the inquired L4 category (checkbox pre-checked)]' available ::" + isPASection_ChkbxPrechecked);
        	Add_Log.info("Is PA upsell '[List the inquired L4 category][Subscribe Now]' button available ::" + isPASection_SubsNowBtnExists);
        	
        //	if( (isPAUpsellMaxSix == true) && (isPAUpsellMax3InRow == true) && 
        //			(isPAUpsellChkbxPrechecked == true) && (isPASection_SubscribeNowBtnExists == true) )
        		        		
        	if( (isPASection_ChkbxPrechecked == true) && (isPASection_SubsNowBtnExists == true) ){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_SEC_SUBS_NOW_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_SUBS_NOW_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the copy for PA upsell section 'You're just a step away from receiving e-mail updates! 
     * Activate using the confirmation e-mail sent to you. Resend e-mail.' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_DOIReminderExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='DOI_alertMsg']//span"));
    		String copyDOI = element.getText();
    		String expText = "You're just a step away from receiving e-mail updates! "
    				+ "Activate using the confirmation e-mail sent to you. Resend e-mail.";
    		Add_Log.info("Print DOI reminder text ::" + copyDOI);
    		
    		if(copyDOI.equals(expText)){
    			Add_Log.info("Passed. Copy for PA upsell section 'You're just a step away from receiving e-mail updates! "
    					+ "Activate using the confirmation e-mail sent to you. Resend e-mail.' is available on the page");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_COPY_DOI_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. Copy for PA upsell section 'You're just a step away from receiving e-mail updates! "
    					+ "Activate using the confirmation e-mail sent to you. Resend e-mail.' is NOT available on the page");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_COPY_DOI_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("Error! Copy for PA upsell section is NOT available on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section 'Hi {First Name}, please check your e-mail sent to {email address}' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_CheckEmailExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String datafirstName, String dataBusinessEmail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016
    	/*	Boolean isPASection_CheckEmailExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_confirmOther')]"
    						+ "//*[contains(text(),'Hi " + datafirstName + ", "
    								+ "please check your e-mail, sent to " + dataBusinessEmail + "')]")).size() != 0;	*/
    		Boolean isPASection_CheckEmailExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'RFI_PA_cat mt10 ml10')]//*[contains(text(),'Hi " + datafirstName + ", "
    								+ "please check your e-mail sent to " + dataBusinessEmail + "')]")).size() != 0;
    		Add_Log.info("Is PA upsell section 'Hi " + datafirstName + ", please check your e-mail "
    				+ "sent to " + dataBusinessEmail + "' available ::" + isPASection_CheckEmailExists);
    		
    		if(isPASection_CheckEmailExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_CHECK_EMAIL_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_CHECK_EMAIL_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section 'Hi First Name, as a registered user, you are eligible for free Product Alert e-mail updates.' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_FreePAEmailUpdatesExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataFirstName) throws Exception{
    	try{
    		//*[contains(@class, 'form_confirmOther')]//*[contains(text(),'Hi " + dataFirstName + ", please check your e-mail, sent to " + dataBusinessEmail + "')]
    		Boolean isPASection_FreePAEmailUpdatesExists = driver.findElements(
    				By.xpath("(//*[contains(@class, 'form_confirmOther')]//*[contains(text(),'Hi " + dataFirstName + ", "
    						+ "as a registered user, you are eligible for free Product Alert e-mail updates.')])")).size()!= 0;
    		Add_Log.info("Is PA upsell section 'Hi " + dataFirstName + ", as a registered user, "
    				+ "you are eligible for free Product Alert e-mail updates.' available ::" + isPASection_FreePAEmailUpdatesExists);
    		
    		if(isPASection_FreePAEmailUpdatesExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_FREE_PA_EMAIL_UPDATES_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_FREE_PA_EMAIL_UPDATES_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section '[new PA box] you must click on the link in the e-mail we've sent you to activate your request'
     * is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PASection_NewPABoxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016    		
    	//	element = driver.findElement(By.xpath("//*[@id='DOI_alertMsg']//span[1]"));
    		element = driver.findElement(By.xpath("//*[contains(@class, 'formMsg mt10')]//p[1]"));
    		String newPABox = element.getText(); 		
    		String expText = "You must click on the link in the e-mail we've sent you to activate your request.";
    		Add_Log.info("Print text ::" + newPABox);
    		
    		if(newPABox.equals(expText)){
    			Add_Log.info("'[new PA box] you must click on the link in the e-mail we've sent you to activate your request' "
    					+ "is available on the page");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_NEW_PA_BOX_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("'[new PA box] you must click on the link in the e-mail we've sent you to activate your request' "
    					+ "is NOT available on the page");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_NEW_PA_BOX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== End of PA upsell Section ==========================================================
    
    // ========================================================= Start of RFI upsell Section ======================================================== 
    
    /**
     * To verify RFI upsell section 'Find other products similar to {inquired L4 category}' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param getL4Category
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_ProductsSimilarExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String getL4Category) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_PdtSimilarExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'Find other products similar to  " + getL4Category + "')]")).size()!= 0;
    		Add_Log.info("Is RFI Upsell 'Find other products similar to " + getL4Category + "' available ::" + isRFIUpsellSection_PdtSimilarExists);	
    		
        	if(isRFIUpsellSection_PdtSimilarExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_PDT_SIMILAR_EXISTS, rowNum, Constant.KEYWORD_PASS);  
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_PDT_SIMILAR_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Inquire All' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInquireAll() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//a[contains(text(),'Inquire All')])[position()=1]"));
    		Add_Log.info("Inquire All button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire All button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    /**
     * To verify RFI upsell section 'Find other products in {inquired L4 category}' is available on the page.
     * 
     * @return
     * @throws Exception
     */
    /*public static WebElement check_RFIUpsellSection_ProductsInExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_PdtInExists = 
    				driver.findElements(By.xpath("")).size()!= 0;
    		Add_Log.info("Is RFI Upsell 'find other products in {inquired L4 category}' available ::" + isRFIUpsellSection_ProductsInExists);
        	if(isRFIUpsellSection_ProductsInExists == true){
        		
        	}else{
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }*/
    
    /**
     * To verify RFI upsell section 'Find other products you might be interested in' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_ProductsInterestedExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_PdtInterestedExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'Find other products you might be interested in')]")).size()!= 0;
    		Add_Log.info("Is RFI Upsell 'find other products you might be interested in' available ::" + isRFIUpsellSection_PdtInterestedExists);
    		
        	if(isRFIUpsellSection_PdtInterestedExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_PDT_INTERESTED_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_PDT_INTERESTED_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section 'Find other products you might be interested in' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify RFI upsell section "Recommended Products For You" is available on the page.    
    public static WebElement check_RFIUpsellSection_RecommendedProductsExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_RecommendedPdtExists = driver.findElements(
    				By.xpath("//*[contains(text(),'Recommended Products For You')] ")).size() != 0;
    		Add_Log.info("Is RFI Upsell 'Recommended Products For You' available ::" + isRFIUpsellSection_RecommendedPdtExists);
    		
    		if(isRFIUpsellSection_RecommendedPdtExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_RECOMMENDED_PDT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_RECOMMENDED_PDT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);	
    		}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section 'Recommended Products For You' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify RFI upsell section "Find other {Products}" is available on the page.
    public static WebElement check_RFIUpsellSection_FindOtherProductsExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_FindOtherPdtExists = driver.findElements(
    				By.xpath("//*[contains(text(),'Find other')]")).size() != 0;
    		Add_Log.info("Is RFI Upsell 'Find other {Products}' available ::" + isRFIUpsellSection_FindOtherPdtExists);
    		
    		if(isRFIUpsellSection_FindOtherPdtExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_FIND_OTHER_PDT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_FIND_OTHER_PDT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);	
    		}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section 'Find other {Products}' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Inquire Now' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInquireNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI upsell section '8 sibling categories of the inquired L4 category' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_SiblingCategoriesExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016 //*[contains(@class, 'buyerMatrix_list')]
    	/*	Boolean isRFIUpsellSection_SiblingCategoryExists = 
        			driver.findElements(By.xpath("//*[contains(@class, 'ppImgBox')]")).size()!= 0;	*/
    		Boolean isRFIUpsellSection_SiblingCategoryExists = 
        			driver.findElements(By.xpath("//*[contains(@class, 'buyerMatrix_list')]")).size()!= 0;
    		Add_Log.info("Is RFI upsell '8 sibling categories of the inquired L4 category' are displayed ::" + isRFIUpsellSection_SiblingCategoryExists);
    		
        	if(isRFIUpsellSection_SiblingCategoryExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_SIBLING_CAT_EXISTS, rowNum, Constant.KEYWORD_PASS); 
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_SIBLING_CAT_EXISTS, rowNum, Constant.KEYWORD_FAIL); 
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section '8 sibling categories of the inquired L4 category' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI upsell section '8 PPs of the inquired L4 category are displayed' is available on the page.
     * 
     * @return
     * @throws Exception
     */
    /*public static WebElement check_RFIUpsellSection_ProductProfileExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_ProductProfileExists = 
        			driver.findElements(By.xpath("//*[contains(@class, 'ppImgBox')]")).size()!= 0;
    		Add_Log.info("Is RFI upsell '8 PPs of the inquired L4 category are displayed' are displayed ::" + isRFIUpsellSection_ProductProfileExists);
        	if(isRFIUpsellSection_ProductProfileExists == true){
        		
        	}else{
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }*/
    
    /**
     * To verify RFI upsell section '8 PPs of the inquired L4 category are displayed in each tab' is available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_ProductProfileInTabExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016 
    		//*[contains(@class, 'buyerMatrix_img')] (48 matching nodes)
    	/*	Boolean isRFIUpsellSection_ProductProfileInTabExists = 
        			driver.findElements(By.xpath("//*[contains(@class, 'mul_PPtabCon ui_tab_con')]")).size() != 0;*/	
    	/*	Boolean isRFIUpsellSection_ProductProfileInTabExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'buyerMatrix_img')]")).size() != 0;	*/
    		
    		// Updated on 07 May 2018
    		Boolean isRFIUpsellSection_ProductProfileInTabExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'ppUpsell_img')]")).size() != 0;
    		
    		Add_Log.info("Is RFI upsell '8 PPs of the inquired L4 category are displayed "
    				+ "in each tab' are displayed ::" + isRFIUpsellSection_ProductProfileInTabExists);
    		
        	if(isRFIUpsellSection_ProductProfileInTabExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_PRODUCT_PROFILES_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_PRODUCT_PROFILES_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}        	
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section '8PPs of the inquired L4 category are displated in each tab' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI upsell section 'list up to 8 categories based on the categories listed on supp RFI form' is available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_UpTo8CategoriesExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016    		
    	/*	Boolean isRFIUpsellSection_UpToSixCategoriesExists = 
        			driver.findElements(By.xpath("//*[contains(@class, 'ppImgBox')]")).size()!= 0;*/
    		Boolean isRFIUpsellSection_UpTo8CategoriesExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'buyerMatrix_list')]")).size() != 0;
    		Add_Log.info("Is RFI upsell 'list up to 8 categories based on the categories listed on "
    				+ "supp RFI form' are displayed ::" + isRFIUpsellSection_UpTo8CategoriesExists);
    		
        	if(isRFIUpsellSection_UpTo8CategoriesExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_UP_TO_8CATEGORIES_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_UP_TO_8CATEGORIES_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section 'list up to 8 categories based on categories listed on supp RFI form' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI upsell section 'Inquire Now' button displayed below each category.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_InqNowBtnExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016
    		//*[contains(@class, 'buyerMatrix')]//a[contains(text(),'Inquire Now')]    		
    	/*	Boolean isRFIUpsellSection_InqNowBtnExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'ppList')]//a[contains(text(),'Inquire Now')]")).size() != 0;*/	
    	/*	Boolean isRFIUpsellSection_InqNowBtnExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'buyerMatrix')]//a[contains(text(),'Inquire Now')]")).size() != 0;	*/
    		
    		// Updated on 07 May 2018
    		Boolean isRFIUpsellSection_InqNowBtnExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'ppUpsell')]//a[contains(text(),'Inquire Now')]")).size() != 0;
    		Add_Log.info("Is RFI Upsell Inquire Now button is displayed below each category ::" + isRFIUpsellSection_InqNowBtnExists);
    		
        	if(isRFIUpsellSection_InqNowBtnExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_INQ_NOW_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_INQ_NOW_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section Inquire Now button below each category is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI upsell section 'Inquire All' button displayed below each category.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_InqAllBtnExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#41041 UI changed on Date 26-Jan-2016 
    		//*[contains(@class, 'buyerMatrix')]//a[contains(text(),'Inquire All')]
    	/*	Boolean isRFIUpsellSection_InqAllBtnExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'ppList')]//a[contains(text(),'Inquire All')]")).size()!= 0;*/			
    		Boolean isRFIUpsellSection_InqAllBtnExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'buyerMatrix')]//a[contains(text(),'Inquire All')]")).size()!= 0;
    		Add_Log.info("Is RFI Upsell Inquire All button is displayed below each category ::" + isRFIUpsellSection_InqAllBtnExists);
    		
        	if(isRFIUpsellSection_InqAllBtnExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_INQ_ALL_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_UPSELL_SEC_INQ_ALL_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section Inquire All displayed below each category is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI upsell section headline "Find other suppliers you might be interested in" is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_SuppInterestedExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_SuppInterestedExists = driver.findElements(
    				By.xpath("//*[contains(text(),'Find other suppliers you might be interested in')]")).size() != 0; 
    		Add_Log.info("Is RFI Upsell 'Find other suppliers you might be interested in' exists ::" + isRFIUpsellSection_SuppInterestedExists);
    		
    		if(isRFIUpsellSection_SuppInterestedExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_SUPP_INTERESTED_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_SUPP_INTERESTED_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section headline 'Find other suppliers you might be interested' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI upsell section 'Inquire Now' button is displayed beside the Supplier Name.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIUpsellSection_InqNowExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRFIUpsellSection_InqNowExists = driver.findElements(
    				By.xpath("(//*[contains(@class, 'cmfSupplierList')]//a[contains(text(),'Inquire Now')])[position()=1]")).size() != 0;
    		Add_Log.info("Is RFI Upsell 'Inquire Now' button is displayed :: " + isRFIUpsellSection_InqNowExists);
    		
    		if(isRFIUpsellSection_InqNowExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_INQ_NOW_BESIDED_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_UPSELL_SEC_INQ_NOW_BESIDED_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);    			    			
    			testFail.set(0, true);
    		}    			
    	}catch(Exception e){
    		Add_Log.error("RFI upsell section Inquire Now button beside the Supplier Name is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Inquire Now' button beside the Supplier Name
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowBesideSuppName() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'cmfSupplierList')]"
    				+ "//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button is click on the page");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    // ========================================================== End of RFI upsell Section =========================================================
    
    // ======================================================== Start of eMag upsell Section ========================================================
    
    /**
     * Click on the 'Subscribe' button in the eMag upsell section.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubscribe() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='EMagSubButton']/a"));
    		Add_Log.info("User is click on Subscribe button.");
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that "Subscribe" button is replaced by "You are subscribed to this magazine" message.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgSubsToThisMagExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    	//	Boolean isBtnExists = driver.findElement(By.xpath("//*[contains(@class, 'PAList')]//a[text()='Subscribe']")).isDisplayed();
    		Boolean isMsgExists = driver.findElement(
    				By.xpath("//*[@id='EMagSubButton']//*[text()='You are subscribed to this magazine']")).isDisplayed();
    		
    	//	Add_Log.info("Is Subscribed button exists ::" + isBtnExists);
    		Add_Log.info("Is message 'You are subscribed to this magazine' exists ::" + isMsgExists);
    		
    		if(isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUBS_TO_EMAG_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUBS_TO_EMAG_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("'You are subscribed to this magazine' message is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify eMag Crosspromo section is available on the page.
     * MR#41041 Features removed. UI changed on Date 26-Jan-2016
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagCrosspromoSectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean iseMagCrosspromoSectionExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_confirmOther RFI_eMag clearfix')]")).size()!= 0;
    		Add_Log.info("Is eMag Crosspromo section available ::" + iseMagCrosspromoSectionExists); 
    		
        	if(iseMagCrosspromoSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_CROSSPROMO_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_CROSSPROMO_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify eMag Crosspromo section is not available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagCrosspromoSectionNotExists11(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean iseMagCrosspromoSectionExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'form_confirmOther RFI_eMag clearfix')]")).size()!= 0;
    		Add_Log.info("Is eMag Crosspromo section available ::" + iseMagCrosspromoSectionExists); 
    		
        	if(iseMagCrosspromoSectionExists == true){
        		Add_Log.info("eMag Crosspromo section is available on the page");
        	//	SuiteUtility.WriteResultUtility(
        	//			xls, sheetName, Constant.COL_EMAG_CROSSPROMO_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		Add_Log.info("eMag Crosspromo section is NOT available on the page");
        	//	SuiteUtility.WriteResultUtility(
        	//			xls, sheetName, Constant.COL_EMAG_CROSSPROMO_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS)	;
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================= End of eMag upsell Section =========================================================
    
    // ===================================================== Start of Mini Marketing Box Section ====================================================
    
    /**
     * Click on the "Add other categories to my Product Alert" link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickAddOtherCategoriesToMyPA() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[contains(text(), 'Add other categories to my Product Alert')]"));
    		Add_Log.info("Add other categories to my Product Alert link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add other categories to my Product Alert link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    /**
     * To verify Mini Marketing Box section is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_miniMarketingBoxSectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		// 26-Sep-2017 MR#47697 //*[contains(@class,'entriesBox mt30')]
    		Boolean isMiniMarketingBoxSectionExists = driver.findElements(
    				By.xpath("//*[contains(@class,'form_confirmOther mt30')]//*[contains(text(),'What would you like to do next?')]")).size()!= 0;
        	Add_Log.info("Is Mini Marketing Box section available ::" + isMiniMarketingBoxSectionExists); 
        	
        	if(isMiniMarketingBoxSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Mini Marketing Box section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Mini Marketing Box section 'Go to Global Sources Homepage' link is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_miniMarketingBoxSection_GoToHomepageExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		Boolean isLinkExists = driver.findElements(
    				By.xpath("//*[contains(text(),'Go to Global Sources Homepage')]")).size()!= 0;
        	Add_Log.info("Is Mini Marketing Box section 'Go to Global Sources Homepage' available ::" + isLinkExists); 
        	
        	if(isLinkExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_GS_HOMEPAGE_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_GS_HOMEPAGE_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Mini Marketing Box section 'Go to Global Sources Homepage' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Mini Marketing Box section 'View all products in {Inquired L4 category} category' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_miniMarketingBoxSection_ViewAllProductsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Date 17 Apr 2017 Link removed 
    		Boolean isLinkExists = driver.findElements(By.xpath("//*[starts-with(text(), 'View all products in')]")).size() != 0;
    		Add_Log.info("Is Mini Marketing Box section 'View all products in {Inquired L4 category} category' available ::" + isLinkExists);
    		
        	if(isLinkExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_VIEW_ALL_PDT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_VIEW_ALL_PDT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Mini Marketing Box section 'View all products in {Inquired L4 category}' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Mini Marketing Box section 'View all products in {Inquired L4 category} category' link is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param getL4Category
     * @return
     * @throws Exception
     */
    public static WebElement check_miniMarketingBoxSection_ViewAllProductsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String getL4Category) throws Exception{
    	try{    		
    		Boolean isMiniMarketingBoxSectionExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'View all products in " + getL4Category + " category')]")).size() != 0;
        	Add_Log.info("Is Mini Marketing Box section 'View all products in " + getL4Category + " category' available ::" + isMiniMarketingBoxSectionExists); 
        	
        	if(isMiniMarketingBoxSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_VIEW_ALL_PDT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MINI_MARKETING_VIEW_ALL_PDT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Mini Marketing Box section 'View all products in {Inquired L4 categories} category' link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Mini Marketing Box section "Add other categories to my Product Alert" link is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_miniMarketingBoxSection_AddOtherCategoriesToMyPA(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isLinkExists = driver.findElements(
    				By.xpath("//a[contains(text(), 'Add other categories to my Product Alert')]")).size() != 0;
    		Add_Log.info("Is Mini Marketing Box section 'Add other categories to my Product Alert' link available ::" + isLinkExists);
    		
    		if(isLinkExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MINI_MARKETING_ADD_OTHER_PA_LINK_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MINI_MARKETING_ADD_OTHER_PA_LINK_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Mini Marketing Box section 'Add other categories to my Product Alert' link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ====================================================== End of Mini Marketing Box Section =====================================================
    
    // ======================================================== Start of DOI Reminder Section =======================================================
    
    /**
     * To verify DOI Reminder section is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_DOIReminderSectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		Boolean isDOIReminderSectionExists = driver.findElements(By.xpath("//*[@id='DOI_alertMsg']")).size()!= 0;
        	Add_Log.info("Is DOI Reminder section available ::" + isDOIReminderSectionExists); 
        	
        	if(isDOIReminderSectionExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_DOI_REMINDER_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        	//	captureDebugScreenShot();
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_DOI_REMINDER_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}        	        
    	}catch(Exception e){
    		Add_Log.error("DOI Reminder section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify DOI Reminder section is not available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_DOIReminderSectionNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		Boolean isDOIReminderSectionExists = driver.findElements(By.xpath("//*[@id='DOI_alertMsg']")).size()!= 0;
        	Add_Log.info("Is Mini Marketing Box section available ::" + isDOIReminderSectionExists); 
        	
        	if(isDOIReminderSectionExists == true){	        		
        		testFail.set(0, true);
        	}else{	        		        		

        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }

    // To verify Inquiry Form section is not available on the page.
    public static WebElement check_RFIFormIsNotDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isInqFormExists = driver.findElements(By.id("myInquiryForm")).size() != 0;
    		Add_Log.info("Is Inquiry Form section available in RFI Confirmation page ::" + isInqFormExists);
    		
    		if(isInqFormExists == true){
    			Add_Log.info("Inquiry Form is available on the page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FORM_IS_NOT_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			Add_Log.info("Inquiry Form is NOT available on the page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FORM_IS_NOT_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }

}