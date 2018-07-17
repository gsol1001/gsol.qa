/**
 * This Class contains methods that represent the locators available on Supplier Listing Page
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
 * Contains methods that represent the locators available on Supplier Listing page.
 * @author Teng Shyh Wei
 *
 */
public class SupplierListing_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public SupplierListing_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify the Supplier Keyword Search results page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataSearchKeyword
     * @return
     * @throws Exception
     */
    public static WebElement check_supplierKWSPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataSearchKeyword) throws Exception{
    	try{    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Supplier Search: " + dataSearchKeyword + ""));
    		
    		if(driver.getTitle().equalsIgnoreCase("Global Sources - Supplier Search: " + dataSearchKeyword + "")){
    			Add_Log.info("The Supplier keyword search results page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The Supplier keyword search results page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.info("Supplier KWS page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify the Supplier Keyword Search results page is displayed.
    public static WebElement check_supplierKWSPageIsDisplayed(String dataSearchKeyword) throws Exception{
    	try{    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Supplier Search: " + dataSearchKeyword + ""));
    		
    		if(driver.getTitle().equalsIgnoreCase("Global Sources - Supplier Search: " + dataSearchKeyword + "")){
    			Add_Log.info("The Supplier keyword search results page is displayed.");
    		}else{
    			Add_Log.info("The Supplier keyword search results page is NOT displayed.");
    		}
    	}catch(Exception e){
    		Add_Log.info("Supplier KWS page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // ===================================================== Start of Verified Supplier section =====================================================
        
    /**
     * To click on first Supplier Name Title.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSupplierName() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'supplierTit')])[position()=1]"));
    		Add_Log.info("User is click on Supplier Name.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier Name is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select single verified supplier checkbox.
     * 
     * @throws Exception
     */
    public static WebElement chkbx_selectSingleVerSupp() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierInfo')]//input[@type='checkbox'])[position()=1]"));
    		Add_Log.info("Single verified supplier checkbox is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Verified supplier checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select multiple verified suppliers checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectMultipleVerSupp() throws Exception{
    	try{
    	//	driver.findElement(By.xpath("(//*[contains(@class, 'supplierInfo')]//input[@type='checkbox'])[position()=1]")).click();
    	//	driver.findElement(By.xpath("(//*[contains(@class, 'supplierInfo')]//input[@type='checkbox'])[position()=2]")).click();
    		
    		// Select all chkbx those are odd number
    		List<WebElement> chkbx = driver.findElements(
    				By.xpath("//*[contains(@class, 'supplierInfo')]//input[@type='checkbox']"));
    		for(int i=1; i<chkbx.size(); i=i+2){
    			chkbx.get(i).click();
    		}
    		Add_Log.info("Multiple verified supplier checkboxes are selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Verified supplier checkboxes are NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select all verified suppliers checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectAllVerSupp() throws Exception{
    	try{
    		List<WebElement> chkbxVerSupp = 
    				driver.findElements(By.xpath("//*[contains(@class, 'supplierName_tit')]//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxVerSupp){
    			if(!chkbx.isSelected())
    				chkbx.click();
    		}
    		Add_Log.info("All verified suppliers checkboxes are selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Verified suppliers checkboxes are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Verified Supplier at Supplier Listing details.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForVerSuppAtSuppListing() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'mt5')]//a[contains(text(),'Inquire Now')])[position()=1]"));
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            
    		Add_Log.info("Inquire Now button for Verified Supplier is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button for Verified Supplier is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Verified Supplier at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForVerSuppAtInqBar() throws Exception{
    	try{
    		// 04-Jan-2017 MR45284 Inquire Now button at Inquiry Bar is removed
    	//	element = driver.findElement(By.xpath("(//*[contains(@class, 'inquiryCon')]"
    	//			+ "//a[contains(text(),'Inquire Now')])[position()=1]"));
    		
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'mt5')]//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button for Verified Supplier is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button for Verified Supplier is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Add to Basket button at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAddToBasketInquiryBar() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'funBox ml10')])[position()=1]"));
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the Rollover Larger image.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickOnRolloverLargerImage() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierPP_img')])[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the Rollover Larger Image
    		WebElement inqNowBtn = driver.findElement(
    				By.xpath("(//*[@id='morePPBox']/dl/dd[1]/div/a/img)[position()=1]"));
    		inqNowBtn.click();
    		
    	}catch(Exception e){
    		Add_Log.error("Rollover Large image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Follow Me" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFollowMe() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//div[contains(@class, 'GS_globalNav clearfix')]")));
    		
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//div[contains(@class, 'GS_copyright')]")));
    		
    		// MR#46899 17-May-2017
    	//	waits.until(ExpectedConditions.elementToBeClickable(
    	//			By.xpath("(//a[contains(text(),'Follow Me')])[position()=1]")));
    		
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//*[contains(@class, 'followSupIco')])[position()=1]")));
    		
    	/*	WebElement element = driver.findElement(
    				By.xpath("(//img[contains(@class, 'followSupIco')])[position()=1]"));
       		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    	*/	
    		WebElement element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'followSupIco')])[position()=1]"));
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    	//	element.click();
    		Add_Log.info("Follow button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Follow button is NOT found on the page.");
    	//	driver.findElement(By.xpath("(//a[contains(text(),'Follow Me')])[position()=1]")).click();
    		throw(e);
    	}
    	return element;
    }
    
    // ====================================================== End of Verified Supplier section ======================================================
    
    // ==================================================== Start of Unverified Supplier section ====================================================
    
    /**
     * To click on first unverified Supplier Name Title.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUnvSupplierNameTitle() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'unverified_listing')]//a)[position()=1]"));
    		Add_Log.info("Unverified Supplier name title is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified Supplier name title is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select single unverified supplier radio button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectSingleUnvSupp() throws Exception{
    	try{    	
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierInfo')]//input[@type='radio'])[position()=1]"));
    		Add_Log.info("Unverified supplier radio button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified supplier radio button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Unverified Supplier at Supplier Listing details.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForUnvSuppAtSuppListing() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'unverified_btn')]"
    				+ "//a[contains(text(),'Inquire Now')])[position()=1]"));
    		
    		// 20-Mar-2017 Wait for element
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            
    		Add_Log.info("Inquire Now for Unverified Supplier is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Inquire Now for Unverified Supplier is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Unverified Supplier at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForUnvSuppAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'inquiryCon')]"
    				+ "//a[contains(text(),'Inquire Now')])[last()]"));
    		Add_Log.info("Inquire Now for Unverified Supplier is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now for Unverified Supplier is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ===================================================== End of Unverified Supplier section =====================================================
    
    // ===================================================== Start of Compare Supplier function =====================================================
    
    /**
     * To click on "Compare Supplier" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickCompareSupplier() throws Exception{
    	try{
    		List<WebElement> btnCompareSupp = 
    				driver.findElements(By.xpath("//*[contains(@class, 'mainCon pr')]//*[contains(@class, 'funTxt')]"));
    		for(WebElement btnCS : btnCompareSupp){
    			if(!btnCS.isSelected())
    				btnCS.click();
    		}
    		Add_Log.info("User is click on Compare Supplier button.");
    	}catch(Exception e){
    		Add_Log.error("Compare Supplier button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on "Suppliers" tab on the bottom of the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickSuppliers() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='comTitSup']/strong")));
    		element = driver.findElement(By.xpath("//*[@id='comTitSup']/strong"));
    		Add_Log.info("User is click on Suppliers tab");
    		
    	}catch(Exception e){
    		Add_Log.error("Suppliers tab is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on "Compare" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickCompare() throws Exception{
    	try{
    		element = driver.findElement(By.id("compareBtnSup"));
    		Add_Log.info("User is click on Compare button");
    	}catch(Exception e){
    		Add_Log.error("Compare button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ====================================================== End of Compare Supplier function ======================================================
    
    // ====================================================== Start of Inquiry Basket function ======================================================
    
    // To verify the page refreshes and a 'Added to basket' is seen instead of checkboxes on those selected suppliers.
    public static WebElement check_btnAddedToBasketIsSeen_selectedPdtChkbxHidden(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 'Added to Basket' button
    		String btnAddedToBasket = driver.findElement(
    				By.xpath("//*[contains(@class, 'mt5')]//a[contains(text(),'Added to Basket')]")).getText();
    		
    		Boolean isChkbxHidden = driver.findElements(
    				By.xpath("//*[contains(@class, 'supplierName_tit')]//input[@type='checkbox']")).size()!=0;
    		Add_Log.info("Does chkbx still available ::" + isChkbxHidden);    		    
    		
    		if(btnAddedToBasket.equals("Added to Basket") && isChkbxHidden == false){
    			Add_Log.info("Button value is changed from 'Add to Basket' to 'Added to Basket'.");
    			Add_Log.info("Chkbx of those selected products are removed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_INQ_BTN_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_PASS);
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_INQ_CHKBX_REMOVED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Button value is NOT changed from 'Add to Basket' to 'Added to Basket'.");
    			Add_Log.info("Chkbx of those selected products are NOT removed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_INQ_BTN_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_INQ_CHKBX_REMOVED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	
    
    // To verify that the count beside the 'Inquiry basket' in the Global navigation is in Red color
    public static WebElement check_inqBasketCountIsRed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		
    		// To verify that the count beside the 'Inquiry basket' in the Global navigation is in Red color
    		String inqBasketCount = driver.findElement(By.id("navcount")).getCssValue("color");
    		
    		// rgb(204, 0, 0) equal to #CC0000 in Hex Color (Red color)
    		String redFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		
    		if(inqBasketCount.equals(redFromRGB)){
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is in Red color");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_INQ_BASKET_COUNT_RED_COLOR, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is NOT in Red color");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_INQ_BASKET_COUNT_RED_COLOR, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To check that the count (red in color) beside the 'Inquiry basket' in the Global navigation is 
    // tally the number of products and suppliers added
    public static WebElement check_inqBasketCountMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    	/*	String inqBasketCountColor = driver.findElement(By.id("navcount")).getCssValue("color");
    		String redFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		
    		String countInqBasketVerSupp = driver.findElement(By.id("navcount")).getText();
			// Ignore '(' and ')'
			int countInqBasketForVerSupp = 
					Integer.parseInt(countInqBasketVerSupp.substring(1, countInqBasketVerSupp.length()-1));
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketForVerSupp);			
    		
			int totalChkbxSelected = chkbxVerPdtSelected + chkbxVerSuppSelected;
			Add_Log.info("Total chkbx selected ::" + totalChkbxSelected);
			
    		if(inqBasketCountColor.equals(redFromRGB) && countInqBasketForVerSupp == totalChkbxSelected){
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is "
    					+ "tally with the number of products and suppliers added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_TOTAL_COUNT_MATCH, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is "
    					+ "NOT tally with the number of products and suppliers added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_TOTAL_COUNT_MATCH, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}	*/
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result pass when "Count beside the 'Inquiry basket' in the Global navigation is 
     * tally with the number of products and suppliers added".
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqBasketTotalCountIsMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is "
    				+ "tally with the number of products and suppliers added." + "\n ");
    		SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_INQ_BASKET_TOTAL_COUNT_MATCH, rowNum, Constant.KEYWORD_PASS);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result fail when "Count beside the 'Inquiry basket' in the Global navigation 
     * is NOT tally with the number of products and suppliers added".
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqBasketTotalCountNotMatch(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is "
    				+ "NOT tally with the number of products and suppliers added.");
    		SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_INQ_BASKET_TOTAL_COUNT_MATCH, rowNum, Constant.KEYWORD_FAIL);
			testFail.set(0, true);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================= End of Inquiry Basket function =======================================================
    
    // To verify the Supplier Service icons are matching.
    public static WebElement check_supplierServiceIconsAreMatching(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		WebElement elementVerSupp = driver.findElement(By.xpath("//*[@id='___UI_trigger0_verifiedSupPop']/div/span"));
    		WebElement elementTradeShow = driver.findElement(By.xpath("//*[@id='___UI_trigger0_sfPop']/div/span"));
    		WebElement elementMagazine = driver.findElement(By.xpath("//*[@id='___UI_trigger0_eMagPop']/div/span"));
    		WebElement elementMajorCust = driver.findElement(By.xpath("//*[@id='___UI_trigger0_customerPop']/div/span"));
    		WebElement elementOnlineStore = driver.findElement(By.xpath("//*[@id='___UI_trigger0_storefrontPop']/div/span"));
    		
    		String getVerSupp = elementVerSupp.getText();
    		String getTradeShow = elementTradeShow.getText();
    		String getMagazine = elementMagazine.getText();
    		String getMajorCust = elementMajorCust.getText();
    		String getOnlineStore = elementOnlineStore.getText();
    		
    		Add_Log.info("Print Supplier icon text ::" + getVerSupp);
    		Add_Log.info("Print Supplier icon text ::" + getTradeShow);
    		Add_Log.info("Print Supplier icon text ::" + getMagazine);
    		Add_Log.info("Print Supplier icon text ::" + getMajorCust);
    		Add_Log.info("Print Supplier icon text ::" + getOnlineStore);
    		
    		if(getVerSupp.equals("Verified Supplier") && getTradeShow.equals("Trade Show") && getMagazine.equals("Magazine")
    				&& getMajorCust.equals("Major Customer") && getOnlineStore.equals("Online Store")){
    			Add_Log.info("Supplier service icons in Supplier KWS page are matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Supplier service icons in Supplier KWS page are NOT matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier Service icon are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
