/**
 * This Class contains methods that represent the locators available on PA Landing page
 * Created: Thu 04 Feb 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/02/04
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on PA Landing page.
 * @author Teng Shyh Wei
 *
 */
public class PA_Landing_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public PA_Landing_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify PA Landing page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PALandingPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources: Product Alert"));
    		
    		if(driver.getTitle().equals("Global Sources: Product Alert")){
    			Add_Log.info("PA Landing page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LANDING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Landing page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_LANDING_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0,  true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! PA Landing page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify a popup window with message "Please select at least one product to inquire on." is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_alertMsgPlsSelectAtLeastOnePdt(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Get a handle to open alert, prompt for confirmation
    		Alert alert = driver.switchTo().alert();
    		    		
    		// Get pop up window message
    		String popupMessage = alert.getText();
    		Add_Log.info("Pop up window message ::" + popupMessage);
    		    		
    		String expectedMessage = "Please select at least one product to inquire on.";
    		
    		// To verify a pop up window with message "Please select at least one product to inquire on" is displayed.
    		if(popupMessage.equals(expectedMessage)){
    			Add_Log.info("Pop up window with message 'Please select at least one product to inquire on' is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALERT_MSG_SELECT_PDT_TO_INQ_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Pop up window with message 'Are you sure you want to remove all items in inquiry basket?' is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALERT_MSG_SELECT_PDT_TO_INQ_EXISTS, rowNum, Constant.KEYWORD_FAIL);
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
     * To verify popup window is closed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     */
    public static WebElement check_popupWindowIsClosed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
        	if(isAlertPresent()){
        		Add_Log.info("Failed. Alert is present.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_POPUP_WINDOW_IS_CLOSED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		Add_Log.info("Passed. Alert is NOT present.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_POPUP_WINDOW_IS_CLOSED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		Add_Log.error("Popup window is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * 
     * @return True if JavaScript Alert is present on the page otherwise false.
     */
    public static boolean isAlertPresent(){
    	try{
    		driver.switchTo().alert();
    		return true;
    	}catch(NoAlertPresentException ex){
    		return false;
    	}
    }
    
    /**
     * To select single Verified Product checkbox.
     * MR#45889 17-May-2017 Chkbc is removed.
     * 
     * @return
     * @throws Exception
     */
   public static WebElement chkbx_selectSingleVerPdt() throws Exception{
    	try{
    		// Date: 01-Sep-2016 UI Changed
    		// (//*[contains(@class, 'kwRelateLink')]//input[@type='checkbox'])[position()=1]
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'detail_dsecript')]"
    				+ "//input[@type='checkbox'])[position()=1]"));
    		
    	}catch(Exception e){
    		Add_Log.error("Verified product checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }		
    
    /**
     * To select multiple Verified Products checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectMultipleVerPdt11() throws Exception{
    	try{
    		// Date: 01-Sep-2016 UI Changed
    		//*[contains(@class, 'kwRelateLink')]//input[@type='checkbox']
    		
    		// Select all chkbx those are odd number
    		List<WebElement> chkbx = driver.findElements(
    				By.xpath("//*[contains(@class, 'detail_dsecript')]//input[@type='checkbox']"));
    		for(int i=1; i<chkbx.size(); i=i+2){
    			chkbx.get(i).click();
    		}
    		
    		int checkedCount = 0;
    		for(int i=0; i<chkbx.size(); i++){
    			if(chkbx.get(i).isSelected()){
    				checkedCount++;
    			}
    		}
    		Add_Log.info("Number of selected chkbx ::" + checkedCount);;
    	}catch(Exception e){
    		Add_Log.error("Verified products checkboxes are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PP checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_ppChkbxIsSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Date: 01-Sep-2016 UI Changed
    	//	element = driver.findElement(By.xpath("(//*[contains(@class, 'kwRelateLink')]"
    	//			+ "//input[@type='checkbox'])[position()=1]"));
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'detail_dsecript')]"
    				+ "//input[@type='checkbox'])[position()=1]"));
    		Boolean isChkbxSelected = element.isSelected();
    		Add_Log.info("Is PP checkbox selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("The verify PP checkbox is selected.");
    			SuiteUtility.WriteResultUtility(xls, sheetName, Constant.COL_PP_CHKBX_IS_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The verify PP checkbox is NOT selected.");
    			SuiteUtility.WriteResultUtility(xls, sheetName, Constant.COL_PP_CHKBX_IS_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PP checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Verified Product at Product Listing details.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForVerPdtAtPdtListing() throws Exception{
    	try{
    		// Date: 01-Sep-2016 UI Changed
    	//	element = driver.findElement(By.xpath("(//*[contains(@class, 'kwRelateLink')]"
    	//			+ "//a[contains(text(),'Inquire Now')])[position()=2]"));
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'detail_dsecript')]"
    				+ "//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Verified Product at Inquiry Bar.
     * MR45284 03-Jan-2017 Inquiry Bar is removed.
     * @return
     * @throws Exception
     */
/*    public static WebElement btn_clickInqNowForVerPdtAtInqBar() throws Exception{
    	try{
    		// Date: 01-Sep-2016 UI Changed
    	//	element = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'inquiryBar kwRelateLink')]//a[contains(text(),'Inquire Now')]"));
    		
    		// Date: 03-Jan-2017 MR45284
    	//	element = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'inquiryBar clearfix')]//a[contains(text(),'Inquire Now')]"));
    		
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'detail_dsecript')]//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * To click Inquire Now button for Verified Product at bottom Inquiry Bar.
     * MR45284 03-Jan-2017 Inquiry Bar is removed.
     * 
     * @return
     * @throws Exception
     */
/*    public static WebElement btn_clickInqNowForVerPdtAtBtmInqBar() throws Exception{
    	try{
    		// Date: 01-Sep-2016 UI Changed
    	//	element = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'inquiryBar bottomBar kwRelateLink')]//a[contains(text(),'Inquire Now')]"));
    		
    		// Date: 03-Jan-2017 MR45284
    	//	element = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'inquiryBar clearfix')]//a[contains(text(),'Inquire Now')]"));
    		
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'detail_dsecript')]//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }	*/
    
    
    /**
     * To click Inquire All button for Verified Product at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqAllForVerPdtAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'inquiryCon')]"
    				+ "//a[contains(text(),'Inquire All')])[position()=1]"));
    		Add_Log.info("Inquire All button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Inquire All button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that Rollover Large Image is displayed when mouse over to any PP image.
     * MR#45889 17-May-2017 Rollover Large Image feature is removed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
/*    public static WebElement img_rolloverLargerImageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Locate the image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'detail_ppImg')])[position()=1]"));
    		
    		// Hovering over image
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Waiting 10 seconds for the zoomed element to be visible
    		WebElement imgZoom = driver.findElement(
    				By.xpath("(//*[contains(@class, 'ppPopBox_img')])[position()=1]"));
    		WebDriverWait wait = new WebDriverWait(driver, 10);
    		wait.until(ExpectedConditions.visibilityOf(imgZoom));
    		
    		if(imgZoom.isDisplayed()){
    			Add_Log.info("Rollover Large Image is displayed when mouse over to PP image.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ROLLOVER_LARGE_IMAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Rollover Large Image is NOT displayed when mouse over to PP image.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ROLLOVER_LARGE_IMAGE_DISPLAYED , rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Rollover Large Image is NOT displayed when mouse over to PP image.");
    		throw(e);    	
    	}
    	return element;
    }	*/
    
    /**
     * To click on the 'Inquire Now' button in Rollover Larger image.
     * MR#45889 17-May-2017 Inquire Now button is removed.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowOnRolloverImage() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'detail_ppImg')])[position()=1]"));

    		// Hover mouse above the image but DONT click
    		Actions action = new Actions(driver);
    		action.moveToElement(imgHover).build().perform();
    		
    		// Locate the Inquire Now button
    		WebElement inqNowBtn = driver.findElement(By.id("InqBtn2"));
    		action.moveToElement(inqNowBtn);
    		inqNowBtn.click();
    		
    		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
    				+ "evObj.initEvent('mouseover', true, false); "
    				+ "arguments[0].dispatchEvent(evObj);} "
    				+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript(mouseOverScript, imgHover);
    				
    	//	WebElement inqNowBtn = driver.findElement(By.id("InqBtn2"));
    	//	inqNowBtn.click();
    	    
    		Add_Log.info("User is click on Inquire Now button in Rollover Large image.");
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button in Rollover Large image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }	
    
    // Click on "Add" button.
    public static WebElement btn_clickAddToBasket() throws Exception{
    	try{
    		// CLick on  btn those are odd number
    		List<WebElement> btn = driver.findElements(
    				By.xpath("//img[contains(@class, 'basketIco_b')]"));
    		for(int i=1; i<btn.size(); i=i+2){
    			btn.get(i).click();
    		}
    		
    		int checkedCount = 0;
    		for(int i=0; i<btn.size(); i++){
    			if(btn.get(i).isSelected()){
    				checkedCount++;
    			}
    		}
    		Add_Log.info("Number of btn clicked ::" + checkedCount);;
    	}catch(Exception e){
    		Add_Log.error("Add button are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Compare" button
    public static WebElement btn_clickCompare() throws Exception{
    	try{
    		// Click on Compare btn those are odd number
    		List<WebElement> btn = driver.findElements(
    				By.xpath("//*[@name='inquiry']//a[contains(@class, 'UI_comparePP_btn')]"));
    		for(int i=1; i<btn.size(); i=i+2){
    			btn.get(i).click();
    		}
   
    	}catch(Exception e){
    		Add_Log.error("Compare button are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on "Product" tab on the bottom of the page.
    public static WebElement tab_clickProducts() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='comTitPP']/strong"));
    		Add_Log.info("User is click on Products tab");
    		
    	}catch(Exception e){
    		Add_Log.error("Products tab is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on "Compare" button.
    public static WebElement btn_clickComparePPs() throws Exception{
    	try{
    		element = driver.findElement(By.id("compareBtnPP"));
    		Add_Log.info("User is click on Compare button");
    		
    	}catch(Exception e){
    		Add_Log.error("Compare button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
