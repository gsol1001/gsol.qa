/**
 * This Class contains methods that represent the locators available on Product Profile Page
 * Created: Mon 05 January 2015
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
import org.openqa.selenium.Dimension;
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
 * Contains methods that represent the locators available on Product Profile page.
 * @author Teng Shyh Wei
 *
 */
public class ProductProfile_Page extends BaseClass{

	private static WebElement element = null;
	
    public ProductProfile_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify the GSOL PP page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param getPdtName
     * @return
     * @throws Exception
     */
    public static WebElement check_GSOLPPpageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String getPdtName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'pp_supName')]"));
            String getSuppNamePP = suppNameElement.getText();
            Add_Log.info("GSOL PP page ::" + getSuppNamePP);
            
            if(getPdtName.equals(getSuppNamePP)){
            	Add_Log.info("Passed. GSOL PP page is displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_GSOL_PP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);             	
            }else{
             	Add_Log.info("Passed. GSOL PP page is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_GSOL_PP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }
    	}catch(Exception e){
    		Add_Log.error("GSOL PP page is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());		
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
    		// 27-Mar-17 MR#45755 - Redesign GSOL PP page
    	//	element = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'pp_inqBtn')]//a[contains(text(),'Inquire Now')]"));
    		element = driver.findElement(By.className("pp_inqBtn"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on Supplier link.
    public static WebElement lnk_clickSupplierName() throws Exception{
    	try{
    		// 27-Mar-17 MR#45755 - Redesign GSOL PP page
    	//	element = driver.findElement(By.className("pp_supName"));
    		element = driver.findElement(By.xpath("//*[contains(@class, 'pp_supName')]//a"));
    		Add_Log.info("Supplier Name link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier Name link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    // =================================================== Start of Enhanced Entrance Link section ==================================================

    /**
     * Click on the PA Enhanced Entrance 'Update me on new products' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUpdateMeOnNewProducts() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'Update me on new products')]"));
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
    		Add_Log.info("Update me on new product link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Update me on new product link is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Email address textbox is displayed beside Enhanced Entrance link.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_txtbxEmailAddrBesideEnhancedEntranceLink(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isTxtbxExists = driver.findElements(By.id("emailBox")).size() != 0;
    		Add_Log.info("Is Email Address textbox displayed beside Enhanced Entrance link ::" + isTxtbxExists);
    		
    		if(isTxtbxExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ADDR_TXTBX_BESIDE_EE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ADDR_TXTBX_BESIDE_EE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Email Address textbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for PA Enhanced Entrance 'Business Email' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_PAEnhancedEntrance_EnterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.id("paLiteTxt_L4"));
    		Add_Log.info("User is enter text for PA Enhanced Entrance Business Email field.");
    		
    	}catch(Exception e){
    		Add_Log.error("PA Enhanced Entrance Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on PA Enhanced Entrance 'Subscribe' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_PAEnhancedEntrance_ClickSubscribe() throws Exception{
    	try{   
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(By.id("subscribeSubmit")));
    		
    		element = driver.findElement(By.id("subscribeSubmit"));
    		element.click();
    		
    	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	//	executor.executeScript("arguments[0].click();", element);
    	
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Under PA Path + PA Link, verified that DOI message is displayed.
    public static WebElement check_DOIMsgUnderPALinkIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isDOIMsgExists = driver.findElements(By.id("DOI_alertMsg2")).size() != 0;
    		Add_Log.info("Is DOI message displayed under the PA Path ::" + isDOIMsgExists);
    		
    		if(isDOIMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_UNDER_PALINK_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_UNDER_PALINK_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! DOI message under the PA Path is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // Under PA Path + PA Link, verified that DOI message is not displayed.
    public static WebElement check_DOIMsgUnderPALinkIsNotDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isDOIMsgExists = driver.findElements(By.id("DOI_alertMsg2")).size() != 0;
    		Add_Log.info("Is DOI message displayed under PA Path ::" + isDOIMsgExists);
    		
    		if(isDOIMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_UNDER_PALINK_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_MSG_UNDER_PALINK_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! ");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Resend e-mail" link.
    public static WebElement link_clickResendEmail() throws Exception{
    	try{
    		element = driver.findElement(By.id("DOI_resend2"));
    		Add_Log.info("User is click on Resend e-mail link.");
    		
    	}catch(Exception e){
    		Add_Log.error("Resend e-mail link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // DOI message changed to "The confirmation e-mail has been sent to autoqa_gsol1001@gmail.com. 
    // Click on the link in the e-mail to activate." is displayed.
    public static WebElement check_DOIMsgChangedIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isDOIMsgExists = driver.findElement(By.id("DOI_cofirmMsg2")).isDisplayed(); 
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
    
    // ===================================================== End of Enhanced Entrance Link section ==================================================
    
    // ======================================================= Start of Supplier Alert section ======================================================
    
    /**
     * From GSOL PP page entry point. Click on the 'Follow Me' button next to suppliers's name.
     *         
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickFollowMe() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//img[contains(@class, 'followSupIco')]"));
    		Add_Log.info("Follow me button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Follow me button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that the "Follow Me" icon in the original page become "Following" (green tick icon).
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_iconFollowingWithGreenTickExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//img[contains(@class,'followSupIco2')]"));    		
    		Boolean isFollowingBtnExists = element.isDisplayed();
    		Add_Log.info("Is green tick icon available on the page ::" + isFollowingBtnExists);
    		
    		if(isFollowingBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BTN_FOLLOWING_WITH_GREEN_TICK, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BTN_FOLLOWING_WITH_GREEN_TICK, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Following icon is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Following" icon
    public static WebElement icon_clickFollowing() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//img[contains(@class, 'followSupIco2')]"));
    		Add_Log.info("Following button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Following button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    // ========================================================= End of Supplier Alert section ======================================================

    // ======================================================= Start of Request Sample section ======================================================
    
    /**
     * Click on the 'Request Sample' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRequestSample() throws Exception{
    	try{    		
    		WebDriverWait waits = new WebDriverWait(driver, 25);
    		
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
    		
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_copyright')]")));
    		
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("//*[contains(@class, 'pp_mSubList')]//a[contains(text(),'Request Sample')]")));
    		
    	//	element = driver.findElement(By.xpath("//a[contains(text(),'Request Sample')]"));
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'reqSampleIco')]"));
    		
    		// 27-Mar-17 MR#45755 - Redesign GSOL PP page
    		element = driver.findElement(By.xpath("//*[contains(@class, 'pp_mSubList')]//a[contains(text(),'Request Sample')]"));
    		element.click();
    		Add_Log.info("Request Sample button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Request Sample button is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());   
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================= End of Request Sample section ======================================================

    // ==================================================== Start of Request Latest Price section ===================================================
    
    /**
     * Click on the 'Request Latest Price' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRequestLatestPrice() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.elementToBeClickable(By.id("showReqPriceBox")));
    		
    		// 27-Mar-17 MR#45755 - Redesign GSOL PP page
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'reqPriceIco')]"));
    		element = driver.findElement(By.id("showReqPriceBox"));
    		element.click();
    		Add_Log.info("Request Latest Price button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Request Latest Price button is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "First Name" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFirstName() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_first_name"));
    		Add_Log.info("User is enter text for First Name field.");
    		
    	}catch(Exception e){
    		Add_Log.error("First Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Last Name" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterLastName() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_last_name"));
    		Add_Log.info("User is enter text for Last Name field.");    
    		
    	}catch(Exception e){
    		Add_Log.error("Last Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Business Email" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_email"));
    		Add_Log.info("User is enter text for Business Email field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Message" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterMessage() throws Exception{
    	try{
    		element = driver.findElement(By.name("inquiry_remarks"));
    		Add_Log.info("User is enter text for Message field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Message field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Expected Order Quantity" field.
     * 
     * @return
     * @throws Exception
     */
    
    public static WebElement txtbx_enterExpectedOrderQuantity() throws Exception{
    	try{
    		element = driver.findElement(By.name("inquiry_order_quantity"));
    		Add_Log.info("User is enter text for Expected Order Quantity field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Expected Order Quantity field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for EOQ's Unit of measurement.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectUnitOfMeasurement(String dataUOM) throws Exception{
    	try{
    		driver.findElement(By.xpath("//*[contains(@class, 'cmForm_Txt')]")).click();
    		driver.findElement(By.xpath("//*[text()='"+dataUOM+"']")).click();
    		
    		Add_Log.info(""+dataUOM+" is selected in UOM drop down list.");
    		
    	}catch(Exception e){
    		Add_Log.info("EOQ Unit of Measurement drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select Buyer Profile radio button.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectBuyerProfile(String value) throws Exception{
    	try{
    		List<WebElement> radbtn = driver.findElements(By.name("show_addl_buyer_info_flag"));
    		for(WebElement radio : radbtn){
    			if(radio.getAttribute("value").equalsIgnoreCase(value));
    				radio.click();
    		}
    	}catch(Exception e){
    		Add_Log.error("Buyer Profile radio button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * Select RFQ checkbox.
     * 
     * @param dataRFQChkbx
     * @return
     * @throws Exception
     */
    public static WebElement chkbxSelectRFQ(String dataRFQUpsell) throws Exception{
    	try{
    		element = driver.findElement(By.name("rfq_check"));
    		if(dataRFQUpsell.equalsIgnoreCase("y")){
    			element.click();
    			Add_Log.info("RFQ chkbx is selected on the page.");
    		}else{
    			// do nothing
    			Add_Log.info("RFQ chkbx is not selected on the page.");
    		}
    	}catch(Exception e){
    		Add_Log.error("RFQ chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Contact Supplier Now" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContactSupplierNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Contact Supplier Now')]"));
    		Add_Log.info("Contact Supplier Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Contact Supplier Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Request Latest Price overlay is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_requestLatestPriceOverlayDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("reqPriceBox")));
    		
    		element = driver.findElement(By.id("reqPriceBox"));
    		Boolean isOverlayExists = element.isDisplayed();
    		Add_Log.info("Is Request Latest Price overlay is displayed ::" + isOverlayExists);
    		
    		if(isOverlayExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GET_LATEST_PRICE_OVERLAY_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_GET_LATEST_PRICE_OVERLAY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Request Latest Price overlay is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	// To verify the user first name and last name is pre-populated in the name fields.
	// To verify the user email address is pre-populated and grey-ed out in the Business Email field.
    public static WebElement check_userNameBusinessEmailPrepopulated(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataFirstName, String dataLastName, String dataBusinessEmail) throws Exception{
    	try{
    		String getFirstName = driver.findElement(By.name("contact_detail_first_name")).getAttribute("value");
    		String getLastName = driver.findElement(By.name("contact_detail_last_name")).getAttribute("value");
    		String getBusinessEmail = driver.findElement(By.name("contact_detail_email")).getAttribute("value");
    		
    		if(getFirstName.equals(dataFirstName) && getLastName.equals(dataLastName)
    				&& getBusinessEmail.equals(dataBusinessEmail)){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NAME_EMAIL_PREPOPULATED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NAME_EMAIL_PREPOPULATED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify all the mandatory fields are filled up.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allMandatoryFieldsFilledUp(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String txtbxFirstName = driver.findElement(By.name("contact_detail_first_name")).getAttribute("value");
    		String txtbxLastName = driver.findElement(By.name("contact_detail_last_name")).getAttribute("value");
    		String txtbxBusinessEmail = driver.findElement(By.name("contact_detail_email")).getAttribute("value");
    		String txtbxEOQ = driver.findElement(By.name("inquiry_order_quantity")).getAttribute("value");
    		String txtbxMessage = driver.findElement(By.name("inquiry_remarks")).getAttribute("value");
    		
    		if(txtbxFirstName.isEmpty() && txtbxLastName.isEmpty() && txtbxBusinessEmail.isEmpty()
    				&& txtbxEOQ.isEmpty() && txtbxMessage.isEmpty()){
    			Add_Log.info("All mandatory fields are NOT filled up.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_FILLED_UP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			Add_Log.info("All mandatory fields are filled up.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_FILLED_UP, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    // ====================================================== End of Request Latest Price section ===================================================

    // ====================================================== Start of Inquiry Basket section =======================================================
    
    /**
     * Click on the 'Add to Basket' button at Product Profile page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAddToBasket() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//img[contains(@class, 'basketIco')]"));
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================== End of Inquiry Basket section =======================================================
    
    // ========================================================= Start of Static Form section =======================================================
    
    /**
     * Enter text at RFI Static Form.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterMsgAtRFIStaticForm() throws Exception{
    	try{
    		element = driver.findElement(By.id("contact_RFI"));
    		Add_Log.info("User is enter text at RFI Static Form");
    		
    	}catch(Exception e){
    		Add_Log.error("RFI Static Form is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());   
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Continue" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContinue() throws Exception{
    	try{
    		WebElement element = driver.findElement(By.xpath("//*[contains(@class,'contact_RFI_btn')]//a"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		Add_Log.info("Continue button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Continue button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== End of Static Form section ========================================================
 
    // =================================================== Start of RFI Form form Floating Window ===================================================
    
    /**
     * To verify RFI floating window is displayed at the bottom right hand corner of the browser. 
     * The text in the RFI floating window is grey-ed out. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */   
    public static WebElement check_RFIFloatingWindowExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("floatInq")));
    		
    		Boolean isRFIFloatingWindowExists = driver.findElements(By.id("floatInq")).size()!= 0;
    		Add_Log.info("Is RFI floating window displayed at the bottom right hand corner of the browser ::" + isRFIFloatingWindowExists);
    		
    		element = driver.findElement(By.id("floatInq"));
    		int x = element.getLocation().getX();
    		int y = element.getLocation().getY();
    		
    		Dimension dimensions = element.getSize();
    		int height = dimensions.height;
    		int weight = dimensions.width;
    		
    		Add_Log.info("Coordinate x is ::" + x);
    		Add_Log.info("Coordinate y is ::" + y);
    		    		
    		Add_Log.info("Height is ::" + height);
    		Add_Log.info("Weight is ::" + weight);
    		
    		int right = x + weight;
    		int bottom = y + height;
    		Add_Log.info("left position ::" + x);			
    		Add_Log.info("top position ::" + y);
    		Add_Log.info("right position ::" + right);
    		Add_Log.info("bottom position ::" + bottom);
    		
    		
    		if(isRFIFloatingWindowExists == true ){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		Add_Log.error("RFI Floating window is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());   
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * The text in the RFI floating window is grey-ed out.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_textRFIFloatingWindowIsGray(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
		try{
			element = driver.findElement(By.id("txt_InqInfo"));
			String textValue = element.getAttribute("value");
			Add_Log.info("Default text ::" + textValue);
			
    		String fontColorTextInRFIFloatingWindow = element.getCssValue("color");
    		String greyFontFromRGB = Color.fromString("rgb(153, 153, 153)").asRgba();
    		
    		if(fontColorTextInRFIFloatingWindow.equals(greyFontFromRGB)){
    			Add_Log.info("The text in the RFI floating window is grey-ed out.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_TEXT_IS_GRAY, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The text in the RFI floating window is NOT grey-ed out.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_TEXT_IS_GRAY, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
		}catch(Exception e){
    		throw(e);
    	}
    	return element;    	
    }
    
    /**
     * To click on the RFI floating window.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement click_RFIFloatingWindow() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("floatInq_con")));
    		
			// Locate the floating window
    		WebElement mouseHover = driver.findElement(By.id("floatInq_con"));
			
    		// Hover mouse above the floating window but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(mouseHover).build().perform();
    		
    		// Locate the floating window textarea
    		WebElement txtarea = driver.findElement(By.id("txt_InqInfo"));
    		txtarea.click();	    		
    		Add_Log.info("User is click on RFI floating window.");
    		
    	}catch(Exception e){
    		Add_Log.error("RFI floating window is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI floating window is enlarged. The text in the RFI floating window become black color.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIFloatingWindowEnlarged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    	
    		Boolean isRFIFloatingWindowEnlarged = driver.findElements(
    				By.xpath("//*[contains(@class, 'floatInqBox floatInq_largeBox')]")).size()!= 0;
        	Add_Log.info("Is RFI floating window enlarged ::" + isRFIFloatingWindowEnlarged);
        	if(isRFIFloatingWindowEnlarged == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_ENLARGED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_ENLARGED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
        	        	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * The text in the RFI floating window become black color.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_textRFIFloatingWindowIsBlack(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.id("txt_InqInfo"));
    		String textEntered = element.getAttribute("value");
    		Add_Log.info("Text entered in the RFI floating window ::" + textEntered);
    		
    		String fontColorTextInRFIFloatingWindow = element.getCssValue("color");    		
    		String blackFontFromRGB = Color.fromString("rgb(0, 0, 0)").asRgba();
    		
    		if(fontColorTextInRFIFloatingWindow.equals(blackFontFromRGB)){
    			Add_Log.info("The text in the RFI floating window become black color.");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_TEXT_IS_BLACK, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The text in the RFI floating window is NOT black color.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_TEXT_IS_BLACK, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To enter text at RFI Floating Window Inquiry Message field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterMessageInRFIFloatingWindow() throws Exception{
    	try{
    		element = driver.findElement(By.id("txt_InqInfo"));
    		Add_Log.info("User is enter text at RFI Floating Window Inquiry Message field.");
    		
    	}catch(Exception e){
    		Add_Log.error("RFI Floating window is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Continue' button at RFI Floating Window.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContinueAtRFIFloatingWindow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'floatInq_btn')]//a[contains(text(),'Continue')]"));
    		Add_Log.info("Continue button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Continue button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify the pop up window with message "Please select at least one product to inquired on" is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_popupMsgPlsSelectPPIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Get a handle to open alert, prompt for confirmation
    		Alert alert = driver.switchTo().alert();
    		
    		// Get pop up window message
    		String popupMessage = alert.getText();
    		String expMessage = "Please select at least one product to inquired on";
    		Add_Log.info("Print popup window message" + popupMessage);
    		
    		if(popupMessage.equals(expMessage)){
    			Add_Log.info("Popup window with message 'Please select at least one product to inquired on' is displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_POPUP_MSG_SELECT_PP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Popup window with message 'Please select at least one product to inquired on' is NOT displayed");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_POPUP_MSG_SELECT_PP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    		// Accept the alert = equivalent of pressing OK
    		alert.accept();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }    
    
    // ==================================================== End of RFI Form form Floating Window ====================================================
    
    // To verify the Supplier Service icons are matching.
    public static WebElement check_supplierServiceIconsAreMatching(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement elementVerSupp = driver.findElement(
    				By.xpath("//*[contains(@class, 'pp_contact')]//*[contains(@class, 'verifiedSupplierIco_m')]"));
    	//	WebElement elementTradeShow = driver.findElement(By.xpath("//*[@id='___UI_trigger0_sfPop']/img"));
    		WebElement elementMagazine = driver.findElement(By.xpath("//*[contains(@class, 'emagazineIco')]")); 
    		WebElement elementMajorCust = driver.findElement(By.xpath("//*[contains(@class, 'majorCustIco')]"));
    		WebElement elementOnlineStore = driver.findElement(By.xpath("//*[contains(@class, 'storeFrontIco')]"));
    		
    		Boolean isVerSuppIconExists = elementVerSupp.isDisplayed();
    	//	Boolean isTradeShowIconExists = elementTradeShow.isDisplayed();
    		Boolean isMagazineIconExists = elementMagazine.isDisplayed();
    		Boolean isMajorCustIconExists = elementMajorCust.isDisplayed();
    		Boolean isOnlineStoreIconExists = elementOnlineStore.isDisplayed();
    		
    		Add_Log.info("Is Verified Supplier icon displayed ::" + isVerSuppIconExists);
    	//	Add_Log.info("Is Trade Show icon displayed ::" + isTradeShowIconExists);
    		Add_Log.info("Is Magazine icon displayed ::" + isMagazineIconExists);
    		Add_Log.info("Is Major Cust icon displayed ::" + isMajorCustIconExists);
    		Add_Log.info("Is Online Store icon displayed ::" + isOnlineStoreIconExists);
    		
    		if(isVerSuppIconExists == true && isMagazineIconExists == true && isMajorCustIconExists == true
    				&& isOnlineStoreIconExists == true){
    			Add_Log.info("Supplier service icons in GSOL PP page are matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Supplier service icons in GSOL PP page are NOT matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0,  true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Supplier Service icons are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
