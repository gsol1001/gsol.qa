/**
 * This Class contains methods that represent the locators available on Unverified Supplier Homepage.
 * Created: Thu 26 May 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/05/26
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

public class UnvSupplier_Homepage extends BaseClass{
	
	private static WebElement element = null;
    
    public UnvSupplier_Homepage(WebDriver driver){
        	super(driver);
    }
    
    // To verify AGG Supplier homepage is displayed.
    public static WebElement check_AGGSuppHomepageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]/h1"));
            String getSuppNameMW = suppNameElement.getText();
            Add_Log.info("AGG Supplier Homepage ::" + getSuppNameMW);
            
            if(getSuppName.equals(getSuppNameMW)){
            	Add_Log.info("Passed. AGG Supplier homepage is displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_SUPP_HOMEPAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
             	
            }else{
             	Add_Log.info("Failed. AGG Supplier homepage is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_SUPP_HOMEPAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }
    	}catch(Exception e){
    		Add_Log.error("Error! AGG Supplier homepage is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify AGG Supplier Product List page is displayed.
    public static WebElement check_AGGSuppProductListPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]//p"));
            String getSuppNameMW = suppNameElement.getText();
            Add_Log.info("Print supplier name ::" + getSuppNameMW);
            
    		WebElement pathElement = driver.findElement(By.xpath("//*[contains(@class, 'c6 mt10')]"));
    		String getPagePath = pathElement.getText();
    		Add_Log.info("Print page path ::" + getPagePath);
    		            
            if(getSuppName.equals(getSuppNameMW) && getPagePath.contains("Product List")){
            	Add_Log.info("Passed. AGG Supplier Product List page is displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_PROD_LIST_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
             	
            }else{
             	Add_Log.info("Failed. AGG Supplier Product List page is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_PROD_LIST_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }
    	}catch(Exception e){
    		Add_Log.error("Error! AGG Supplier Product List page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    // To verify AGG Supplier PP page is displayed.
    public static WebElement check_AGGSuppPPPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName, String getPPName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]//p"));
            String getSuppNameMW = suppNameElement.getText();
            Add_Log.info("Print supplier name ::" + getSuppNameMW);
            
    		WebElement ppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'pp_spd')]"));
    		String getPPSPD = ppNameElement.getText();
    		Add_Log.info("Print page path ::" + getPPSPD);
    		       
    		//*[contains(@class, 'pp_spd')]
    		
            if(getSuppName.equals(getSuppNameMW) && getPPName.equals(getPPSPD)){
            	Add_Log.info("Passed. AGG Supplier PP page is displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_SUPP_PP_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
             	
            }else{
             	Add_Log.info("Failed. AGG Supplier PP page is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_PROD_LIST_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }
    	}catch(Exception e){
    		Add_Log.error("Error! AGG Supplier PP page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    
    // To verify AGG Supplier Company Profile page is displayed.
    public static WebElement check_AGGSuppCompProfilePageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]//p"));
            String getSuppNameMW = suppNameElement.getText();
            Add_Log.info("Print supplier name ::" + getSuppNameMW);
            
    		WebElement pathElement = driver.findElement(By.xpath("//*[contains(@class, 'c6 mt10')]"));
    		String getPagePath = pathElement.getText();
    		Add_Log.info("Print page path ::" + getPagePath);
    		
            if(getSuppName.equals(getSuppNameMW) && getPagePath.contains("Company Information")){
            	Add_Log.info("Passed. AGG Supplier Company Profile page is displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_COMP_PROFILE_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
             	
            }else{
             	Add_Log.info("Failed. AGG Supplier Company Profile page is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_AGG_COMP_PROFILE_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }            
    	}catch(Exception e){
    		Add_Log.error("Error! AGG Supplier Company Profile page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    // To verify AGG Supplier Trade Shows page is displayed.
    public static WebElement check_AGGSuppTradeShowsPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String getSuppName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]//p"));
    		String getSuppNameMW = suppNameElement.getText();
    		Add_Log.info("Print supplier name ::" + getSuppNameMW);
    		
    		WebElement pathElement = driver.findElement(By.xpath("//*[contains(@class, 'c6 mt10')]"));
    		String getPagePath = pathElement.getText();
    		Add_Log.info("Print page path ::" + getPagePath);
    		
    		if(getSuppNameMW.equals(getSuppName) && getPagePath.contains("Trade Shows")){
    			Add_Log.info("Passed. AGG Supplier Trade Shows page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AGG_SUPP_TRADE_SHOWS_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. AGG Supplier Trade Shows page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AGG_SUPP_TRADE_SHOWS_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! AGG Supplier Trade Shows page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify AGG Supplier Contact Us page is displayed.
    public static WebElement check_AGGSuppContactUsPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String getSuppName) throws Exception{
    	try{
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]//p"));
    		String getSuppNameMW = suppNameElement.getText();
    		Add_Log.info("Print supplier name ::" + getSuppNameMW);
    		
    		WebElement pathElement = driver.findElement(By.xpath("//*[contains(@class, 'c6 mt10')]"));
    		String getPagePath = pathElement.getText();
    		Add_Log.info("Print page path ::" + getPagePath);
    		
    		if(getSuppNameMW.equals(getSuppName) && getPagePath.contains("Contact Us")){
    			Add_Log.info("Passed. AGG Supplier Contact Us page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AGG_SUPP_CONTACT_US_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. AGG Supplier Contact Us page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_AGG_SUPP_CONTACT_US_PAGE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! AGG Supplier Contact Us page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // Close the Trade Match overlay
    public static WebElement icon_clickCloseBtnOnTradeMatchOverlay() throws Exception{
    	try{    		
    		element = driver.findElement(By.xpath("//*[@id='tm_overlay']"));
    		Boolean isPromoTMOverlayExists = element.isDisplayed();
    		Add_Log.info("Is Trade Match Promo overlay displayed ::" + isPromoTMOverlayExists);
    		
    		if(isPromoTMOverlayExists == true){
    			// Close the Trade Match Promo overlay
    			driver.findElement(By.xpath("//*[@id='tm_overlay']//span")).click();
    			Add_Log.info("Trade Match Promo overlay is closed.");
    		}
    	}catch(Exception e){
    		Add_Log.error("Trade Match Promo overlay is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================== Start of menu bar navigator =========================================================
    
    /**
     * Go to Supplier Product Showroom page by select 'Product List' menu bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_clickProductList() throws Exception{
    	try{
    		element = driver.findElement(
        			By.xpath("//*[contains(@class, 'spNavA')][contains(text(),'Product List')]"));
    		Add_Log.info("Product List menu bar is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product List menu bar is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());   
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Go to Supplier Company Profile page by select 'Company Information' menu bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement menuBar_clickCompInformation() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'spNavA')][contains(text(),'Company Information')]"));
    		Add_Log.info("Company Information menu bar is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Company Information menu bar is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Go to Supplier Trade Shows page by select 'Trade Shows' menu bar.
    public static WebElement menuBar_clickTradeShows() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'spNavA')][contains(text(),'Trade Shows')]"));
    		Add_Log.info("Trade Shows menu bar is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Trade Shows menu bar is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Contact Us" menu.
    public static WebElement menuBar_clickContactUs() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'spNavA')][contains(text(),'Contact Us')]"));
    		Add_Log.info("Contact Us menu bar is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Contact Us menu bar is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================= End of menu bar navigator ==========================================================
    
    // ========================================================= Start of Left Nav section ==========================================================
    
    // Click on "Get e-mail alerts on latest products!" link.
    public static WebElement lnk_clickGetEmailAlertsOnLatestPdt() throws Exception{
    	try{
    		element = driver.findElement(By.id("paTxt1"));
    		Add_Log.info("User is click on 'Get e-mail alerts on latest products' link.");
    		
    	}catch(Exception e){
    		Add_Log.error("'Get e-mail alerts on latest products' link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify Email address textbox is displayed beside Product Alert link.
    public static WebElement check_txtbxEmailAddrBesideProductAlertLink(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isTxtbxExists = driver.findElements(By.id("paLiteTxt")).size() != 0;
    		Add_Log.info("Is Email Address textbox displayed beside Product Alert link ::" + isTxtbxExists);
    		
    		if(isTxtbxExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ADDR_TXTBX_BESIDE_PA, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ADDR_TXTBX_BESIDE_PA, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Email Address textbox beside the PA link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Enter a brand new email address in the email textbox and click on "Subscribe" button.
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.id("paLiteTxt"));
    		Add_Log.info("User is enter text in Email address textbox field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Email address textbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on Product Alert 'Subscribe' button.
    public static WebElement btn_clickProductAlertSubscribe() throws Exception{
    	try{   
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pa_form']//input[@value='Subscribe']")));
    		
    		element = driver.findElement(By.xpath("//*[@id='pa_form']//input[@value='Subscribe']"));
    		element.click();

    		Add_Log.info("Product Alert Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product Alert Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    // ========================================================= Start of Left Nav section ==========================================================
    
    // =================================================== Start of Production Promotion section ====================================================

    // Click on "Inquire Now" button below the header Production Promotion section
    public static WebElement btn_ProdPromoSection_ClickInquireNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@name='inquiryProducts']//*[contains(@class, 'proOpt_left')]//a"));
    		Add_Log.info("User is click on Inquire Now button below the header Production Promotion section.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Select all" link
    public static WebElement lnk_clickSelectAll() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@name='inquiryProducts']//*[@class='selectAll']"));
    		Add_Log.info("User is click on Select all link,");
    		
    	}catch(Exception e){
    		Add_Log.error("Select all link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Select first PP checkbox at Production Promotion section.
    public static WebElement chkbx_select1stPPChkbx() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'catProCont')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select 1st PP chkbx
    		WebElement firstPPChkbx = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//input"));
    		firstPPChkbx.click();    		
    		Add_Log.info("User select first PP chkbx at Production Promotion section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    // Select second PP checkbox at Production Promotion section.
    public static WebElement chkbx_select2ndPPChkbx() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'catProCont')]//img)[position()=2]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select 2nd PP chkbx
    		WebElement secondPPChkbx = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//input"));
    		secondPPChkbx.click();
    		Add_Log.info("User select second PP chkbx at Production Promotion section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify all the PPs checkboxes are checked.
    public static WebElement check_allPPsChkbxChecked(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxUnvPdtList = driver.findElements(
    				By.xpath("//*[@id='unverProList']//*[@class='proCheckbox']"));
    		for(WebElement chkbx : chkbxUnvPdtList){
    			if(chkbx.isSelected()){
    				Add_Log.info("Passed. All the PPs checkboxed are checked.");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_ALL_PPS_CHKBX_ARE_CHECKED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("Failed. Not all the PPs checkboxes are checked.");
    				SuiteUtility.WriteResultUtility(
    						xls, sheetName, Constant.COL_ALL_PPS_CHKBX_ARE_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}    				
    		}
    	}catch(Exception e){
    		Add_Log.error("PPs checkboxed Production Promotion section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on first PP image in Production promotion section and go to Unverified Supplier PP page.
    public static WebElement img_clickFirstPPImgAtProdPromoSection() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("(//*[contains(@class, 'catProCont')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the zoomed image.
    		WebElement ppImg = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//img"));
    		ppImg.click();
    		Add_Log.info("User is click on first PP image in Production Promotion section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP image is NOT found on Production Promotion section.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on first PP SPD in Production promotion section  and go to Unverified Supplier PP page.
    public static WebElement lnk_clickPPSPDUnderPPImg() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[@id='unverProList']/li/a)[position()=1]"));
    		Add_Log.info("PP SPD is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP SPD is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Inquire Now" button inside the Rollover Larger image.
    public static WebElement btn_clickInquireNowInsidePPImg() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("(//*[contains(@class, 'catProCont')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the 'Inquire Now' button
    		WebElement inqNowBtn = driver.findElement(By.id("InqBtn"));
    		inqNowBtn.click();
    		Add_Log.info("User is click on Inquire Now button inside the PP image.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button inside the PP image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on PP SPD link inside the Rollover Larger image.
    public static WebElement lnk_clickPPSPDInsidePPImg() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("(//*[contains(@class, 'catProCont')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the PP SPD link
    		WebElement ppSPDLnk = driver.findElement(By.id("InqSPD"));
    		ppSPDLnk.click();
    		Add_Log.info("User is click on PP SPD link inside the PP image.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP SPD link inside the PP image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	// Mouseover to any PP image in Production Promotion section.    		
	// To verify that Rollover Large Image is displayed when mouse over to any PP image.
    public static WebElement check_mouseoverPPImg_RolloverLargeImgIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("(//*[contains(@class, 'catProCont')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Waiting 10 seconds for the zoomed element to be visible
    		WebElement imgZoom = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')])[position()=1]"));
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
    		Add_Log.error("Error! Rollover Larger Image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ==================================================== End of Production promotion section =====================================================

    // ====================================================== Start of Contact Details section ======================================================
    
    // Enter text for RFI Static form.
    public static WebElement txtbx_enterRFIStaticForm() throws Exception{
    	try{
    		element = driver.findElement(By.id("inqmsgtextarea"));
    		Add_Log.info("User is enter text for RFI Static form.");
    		
    	}catch(Exception e){
    		Add_Log.error("RFI Static form is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Continue" button.
    public static WebElement btn_clickContinue() throws Exception{
    	try{
    		element = driver.findElement(By.name("continueInq"));
    		Add_Log.info("User is click on Continue button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Continue button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================= End of Contact Details section =======================================================
    
    // ============================================= Start of Related verified productions list section =============================================
    
    // Click on "Inquire Now" button.
    public static WebElement btn_clickInquireNowBtnAtRelatedVerPdtList() throws Exception{
    	try{
    		element = driver.findElement(By.id("inquirenow"));
    		Add_Log.info("User is click on Inquire Now button at Related verified production list section.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button at Related verified production list section is NOT found on the page .");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Add to Basket" button.
    public static WebElement btn_clickAddToBasket() throws Exception{
    	try{
    		element = driver.findElement(By.id("moAddBsk"));
    		Add_Log.info("Add to basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Select all" link.
    public static WebElement lnk_clickSelectAllAtReleatedVerPdtList() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@name='inquiry']//*[@class='selectAll']"));
    		Add_Log.info("User is click on Select all link at Related verified production list section.");
    		
    	}catch(Exception e){
    		Add_Log.error("Select all link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Select first PP checkbox at Related verified production list section.
    public static WebElement chkbx_select1stPPChkbxAtRelatedVerPdtList() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select 1st PP chkbx
    		WebElement firstPPChkbx = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//input"));
    		firstPPChkbx.click();    		
    		Add_Log.info("User select first PP chkbx at Related verified production list section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP chkbx at Related verified production list section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    // Select third PP checkbox at Related verified production list section.
    public static WebElement chkbx_select3rdPPChkbxAtRelatedVerPdtList() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')]//img)[position()=3]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select 3rd PP chkbx
    		WebElement thirdPPChkbx = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//input"));
    		thirdPPChkbx.click();
    		Add_Log.info("User select third PP chkbx at Related Verified production list section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP chkbx at Related verified production list section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on first PP image in Related verified production list section and go to Unverified Supplier PP page.
    public static WebElement img_clickFirstPPImgAtRelatedVerPdtList() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the zoomed image.
    		WebElement ppImg = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//img"));
    		ppImg.click();
    		Add_Log.info("User is click on first PP image in Related verified production list section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP image is NOT found on Related verified production list section.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Inquire Now" button inside the Rollover Larger image.
    public static WebElement btn_clickInquireNowInsidePPImgAtRelatedVerPdtList() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')])[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the 'Inquire Now' button
    		WebElement inqNowBtn = driver.findElement(By.id("InqBtn"));
    		inqNowBtn.click();
    		Add_Log.info("User is click on Inquire Now button inside the PP image.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button inside the PP image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on PP SPD link inside the Rollover Larger image.
    public static WebElement lnk_clickPPSPDInsidePPImgAtRelatedVerPdtList() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')])[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the PP SPD link
    		WebElement ppSPDLink = driver.findElement(By.id("InqSPD"));
    		ppSPDLink.click();
    		Add_Log.info("User is click on PP SPD link inside the PP image.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP SPD link inside the PP image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on first PP SPD in Related verified production list section and go to Verified Supplier PP page.
    public static WebElement lnk_clickPPSPDUnderPPImgAtRelatedVerPdtList() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='catProList']/li[1]/a"));
    		Add_Log.info("User is click on PP SPD link under the PP image");
    		
    	}catch(Exception e){
    		Add_Log.error("PP SPD link in Related verified production list section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * At Related verified productions list section, mouse over to any verified PP image.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickOnRolloverLargerImage() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')])[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the Rollover Larger Image
    	//	WebElement inqNowBtn = driver.findElement(
    	//			By.xpath("(//*[@id='morePPBox']/dl/dd[1]/a/img)[position()=1]"));
    	//	inqNowBtn.click();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that Rollover Large Image is displayed when mouse over to any PP image.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement img_rolloverLargerImageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Locate the image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')])[position()=1]"));
    		
    		// Hovering over image
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Waiting 10 seconds for the zoomed element to be visible
    		WebElement imgZoom = driver.findElement(
    				By.xpath("(//*[@id='morePPBox']/dl/dd[1]/a/img)[position()=1]"));
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
    		
    		element = driver.findElement(By.id("moAddBsk"));
    		Boolean isAddToBasketBtnExists = element.isDisplayed();
    		Add_Log.info("Is Add to Basket button exists ::" + isAddToBasketBtnExists);
    		
    		if(isAddToBasketBtnExists == true){
    			Add_Log.info("Add to Basket button is available inside the PP image.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADD_TO_BASKET_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Add to Basket button is NOT available inside the PP imahe");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADD_TO_BASKET_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    		// Click on "Add to Basket" button
    		UnvSupplier_Homepage.btn_clickAddToBasket().click();
    		
    	//	element = driver.findElement(By.id("moAddBsk"));
    		String actText = element.getText();
    		String expText = " Added to Basket";
    		Add_Log.info("Print act text ::" + actText);
    		Add_Log.info("Print exp text ::" + expText);
    		
    		if(actText.equals(expText)){
    			Add_Log.info("Add to Basket button is changed to Added to Basket");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADDED_TO_BASKET_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Add to Basket button is NOT changed to Added to Basket");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADDED_TO_BASKET_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		throw(e);    	
    	}
    	return element;
    }
    
    // To verify PP is added to Inquiry Basket, "Add to Basket" button is changed to "Added to Basket" button.
    public static WebElement check_btnAddedToBasketExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Locate the image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[@id='catProList']//*[contains(@class, 'catProCont')])[position()=1]"));
    		
    		// Hovering over image
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Waiting 10 seconds for the zoomed element to be visible
    		WebElement imgZoom = driver.findElement(
    				By.xpath("(//*[@id='morePPBox']/dl/dd[1]/a/img)[position()=1]"));
    		WebDriverWait wait = new WebDriverWait(driver, 10);
    		wait.until(ExpectedConditions.visibilityOf(imgZoom));
    		
    		element = driver.findElement(By.id("moAddBsk"));
    		String actText = element.getText();
    		String expText = " Added to Basket";
    		Add_Log.info("Print act text ::" + actText);
    		Add_Log.info("Print exp text ::" + expText);
    		
    		if(actText.equals(expText)){
    			Add_Log.info("Add to Basket button is changed to Added to Basket");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADDED_TO_BASKET_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Add to Basket button is NOT changed to Added to Basket");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADDED_TO_BASKET_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify on top of the verified PP image, "Added to Basket" wording is displayed.
    public static WebElement check_wordAddedToBasketOnTopOfImgExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[@id='catProList']"
    				+ "//*[contains(@class, 'catProCont')]//span)[position()=1]"));
    		String actText = element.getText();
    		String expText = "Added to Basket";
    		Add_Log.info("Print act text ::" + actText);
    		
    		if(actText.equals(expText)){
    			Add_Log.info("Added to Basket wording is displayed on top of verified PP image.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WORD_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Added to Basket wording is NOT displayed on top of verified PP image.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WORD_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To check the count beside the "Inquiry basket" in the global navigation tally the number of products added. 
    public static WebElement check_countInqBasketIsCorrect(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String countElement = driver.findElement(By.id("navcount")).getText();			
			int countInqBasket = Integer.parseInt(countElement.substring(1, countElement.length()-1));		// ignore '(' and ')'
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasket);			
    		
    		if(countInqBasket == 1){    			
        		Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is tally with the number of products added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is NOT tally with the number of products added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		} 
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ============================================== End of Related verified productions list section ==============================================
    
    // ================================================= Start of Verified Supplier Profile section =================================================

    // Click on "Inquire Now" button at Verified Supplier Profile section
    public static WebElement btn_clickInquireNowAtVerSuppProfileSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'vspOpt')]//a)[position()=1]"));
    		Add_Log.info("User is click on Inquire Now button at Verified Supplier Profile section.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button at Verified Supplier Profile section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ================================================== End of Verified Supplier Profile section ==================================================
    
    // ===================================================== Start of Floating Contact section ======================================================
    
    // In order to view Floating Contact section, scroll to the footer of the page.
    public static WebElement scrollToFooterSection() throws Exception{
    	try{
    		WebElement elementMove = driver.findElement(By.xpath("//*[contains(@class, 'footFunIco')]"));    		
    		Actions action = new Actions(driver);
    		action.moveToElement(elementMove).build().perform();
    		
    	//	WebElement element = driver.findElement(By.name("continueInq"));
    	//	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    		
    		Add_Log.info("Scroll action to footer of the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Error! Scroll action error.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Inquire Now" button at Floating Contact section.
    public static WebElement btn_clickInquireNowAtFloatingContactSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'csSec')]//a"));
    		Add_Log.info("User is click on Inquire Now button at Floating Contact section.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button at Floating Contact section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on PA "Get e-mail alerts on latest products!" link.
    public static WebElement lnk_clickPALinkAtFloatingContactSection() throws Exception{
    	try{
    		element = driver.findElement(By.className("paTxtCont2"));
    		Add_Log.info("User is click on 'Get e-mail alerts on latest products!' link at Floating Contact section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'Get e-mail alerts on latest products!' link at Floating Contact section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ====================================================== End of Floating Contact section =======================================================
    
}
