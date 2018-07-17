/**
 * This Class contains methods that represent the locators available on Message Center Page
 * Created: Wed 29 Jul 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/29
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Message Center page.
 * @author Teng Shyh Wei
 *
 */
public class MessageCenter_Page extends BaseClass{

    private static WebElement element = null;
    
    public MessageCenter_Page(WebDriver driver){
        super(driver);
    }
    
    /**
     * Click on the 'Get Quotations' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickGetQuotations() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'Get Quotations')]"));
    		Add_Log.info("User is click on the Get Quotations button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Get Quotations button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "All" button at side bar nav list.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickNavListAll() throws Exception{
    	try{
    		element = driver.findElement(By.id("all-folder"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Buying Requests" button at side bar nav list.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickBuyingRequests() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfq"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Inquiries" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInquiries() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfi"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Favorites" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFavorites() throws Exception{
    	try{
    		element = driver.findElement(By.id("favorite-folder"));
    				
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on "(+) new tag" link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickAddNewTag() throws Exception{
    	try{
    		element = driver.findElement(By.id("btn-create-tag"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Trash" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickTrash() throws Exception{
    	try{
    		element = driver.findElement(By.id("trash-folder"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Select All" checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_clickSelectAll() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[@id='id-content-1']//input[@id='id-select-all']"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Search" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterSearchKeyword() throws Exception{
    	try{
    		element = driver.findElement(By.id("search"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the Search Icon.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickBtnSearch() throws Exception{
    	try{
    		element = driver.findElement(By.id("id-btn-search"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // =========================================================== Start of Get Quotations section ==================================================
    
    /**
     * Enter text for 'Product Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterProductName() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqProductName"));
    		Add_Log.info("User is enter text for Product Name field.");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Select a product category' hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSelectPdtCategory() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'gs-keyword-selected')]//a"));
    		Add_Log.info("Select a product category link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Select a product category link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the Level one category.
     * 
     * @param dataL1Category
     * @return
     * @throws Exception
     */
    public static WebElement lstbx_clickL1Category(String dataL1Category) throws Exception{
    	try{
			Select listbox = new Select(driver.findElement(By.id("id-category-l")));
			listbox.selectByVisibleText(dataL1Category);
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the Level three category.
     * 
     * @param dataL3Category
     * @return
     * @throws Exception
     */
    public static WebElement lstbx_clickL3Category(String dataL3Category) throws Exception{
    	try{
    		Select listbox = new Select(driver.findElement(By.id("id-category-l3")));
    		listbox.selectByVisibleText(dataL3Category);
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the Level four category.
     * 
     * @param dataL4Category
     * @return
     * @throws Exception
     */
    public static WebElement lstbx_clickL4Category(String dataL4Category) throws Exception{
    	try{
    		Select listbox = new Select(driver.findElement(By.id("id-category-l4")));
    		listbox.selectByVisibleText(dataL4Category);
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Done' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickDone() throws Exception{
    	try{
    		element = driver.findElement(By.id("id-btn-done"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'About Your Product' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterAboutYourProduct() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqProductDescription"));
    		Add_Log.info("User is enter text for About Your Product field.");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }  
	
    /**
     * Click on the 'Upload Product Image/Attachment' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickUploadPdtImg() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqForm"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Upload Product Image/Attachment.
     * 
     * @param dataPdtImgPath
     * @return
     * @throws Exception
     */
	public static WebElement btn_UploadProductImage(String dataPdtImgPath) throws Exception{
    	try{
    		LocalFileDetector detector = new LocalFileDetector();
    		File file = detector.getLocalFile(dataPdtImgPath);
    		((RemoteWebElement)MessageCenter_Page.btn_clickUploadPdtImg()).setFileDetector(detector);
    		MessageCenter_Page.btn_clickUploadPdtImg().sendKeys(file.getAbsolutePath());
    		
		//	WebDriverWait wait = new WebDriverWait(driver, 15);
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dz-preview dz-image-preview")));
    		Add_Log.info("Product Image/Attachment is uploaded.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product Image/Attachment is NOT uploaded.");    		
    		throw(e);
    	}
    	return element;
	}
    
    /**
     * Enter text for 'Estimated Order Quantity' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterEstOrderQuantity() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqProductOrderQuantity"));
    		Add_Log.info("User is enter text for Estimated Order Quantity field.");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for Quantity Unit.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectQuantityUnit(String selectVal) throws Exception{
    	try{
    		driver.findElement(By.id("quantityUnit_chosen")).click();
    		
    		WebElement dropdown = driver.findElement(By.id("quantityUnit_chosen")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){ 
    			
    			if(option.getText().equals(selectVal)){ 
    				Add_Log.info("Print option ::" + option.getText());
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Preferred Unit Price' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPrefUnitPrice() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqProductUnitPrice"));
    		Add_Log.info("User is enter text for Preferred Unit Price field.");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for Currency.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectCurrency(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.id("rfqCurrency_chosen")); 
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
     * Select drop down list for Valid To.
     * 
     * @param select
     * @return
     */
    public static WebElement drpdwn_selectValidTo(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.id("rfqProductExpiryDateSelect_chosen")); 
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
     * Select drop down list for Shipment Terms.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectShipmentTerms(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.id("rfqShipmentTerm")); 
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
     * Select drop down list for Payment Terms.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectPaymentTerms(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.id("rfqPaymentTerm")); 
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
     * Enter text for 'Required Company Certification(s)' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCompCertification() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqCompanyCertification"));
    		Add_Log.info("User is enter text for Required Company Certification(s) field.");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Required Product Certification(s)' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPdtCertification() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqProductCertification"));
    		Add_Log.info("User is enter text for Required Product Certification(s) field.");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Business email' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.id("userEmail"));
    		Add_Log.info("User is enter text for Business Email field.");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Buyer Profile' checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectBuyerProfile(String value) throws Exception{
    	try{
    		List<WebElement> radbtn = driver.findElements(By.name("rfqShowProfile"));
    		for(WebElement radio : radbtn){
    			if(radio.getAttribute("value").equalsIgnoreCase(value));
    				radio.click();
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * Select checkbox for AGG OptIn.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement ckbx_selectAggOptIn(String dataAggOptIn) throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqAGGOptIn"));
    		if(dataAggOptIn.equalsIgnoreCase("y")){
    			// do nothing.
    			
    		}else if(dataAggOptIn.equalsIgnoreCase("n")){
    			element.click();
    			Add_Log.info("AGG OptIn chkbx is unchecked on the page.");
    		}else{
    			Add_Log.info("Please make sure your input value is either 'y' or 'n'.");
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("AGG OptIn checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Submit' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubmit() throws Exception{
    	try{
    		element = driver.findElement(By.id("rfqFormSubmit"));
    		Add_Log.info("Submit button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Submit button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    // ============================================================ End of Get Quotations section ===================================================
    
    /**
     * To verify Message Center Login page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_messageCenterLoginPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@class='moduleheader'][contains(text(),'Login')]"));
    		String msgCenterTitle = element.getText();
    		String expectedTitle = "Login";
    		Add_Log.info("Module header title ::" + msgCenterTitle);
    		
    		if(msgCenterTitle.equals(expectedTitle)){
    			Add_Log.info("Message Center Login page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_CENTER_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Message Center Login page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_CENTER_LOGIN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Message Center home page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_messageCenterHomePageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("MessageCenter - Global Sources"));
    		    	
    		if(driver.getTitle().equals("MessageCenter - Global Sources")){
    			Add_Log.info("Message Center homepage is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MC_EMAIL_VERIFICATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Message Center homepage is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MC_EMAIL_VERIFICATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify Message Center Email Verification page is displayed.
    public static WebElement check_MCEmailVerificationPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Email Verification"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Email Verification")){
    			Add_Log.info("Message Center Email Verification page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_CENTER_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Message Center Email Verification page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_CENTER_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify all the Message Center mandatory fields are filled up.
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
    		String txtbxPdtName = driver.findElement(By.id("rfqProductName")).getAttribute("value");
    		String txtbxPdtDesc = driver.findElement(By.id("rfqProductDescription")).getAttribute("value");
    		String txtbxPdtOrderQuantity = driver.findElement(By.id("rfqProductOrderQuantity")).getAttribute("value");
    		
    		if(txtbxPdtName.isEmpty() && txtbxPdtDesc.isEmpty() && txtbxPdtOrderQuantity.isEmpty()){
    			Add_Log.info("All mandatory fields are filled up.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_FILLED_UP, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("All mandatory fields are NOT filled up");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_FILLED_UP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
