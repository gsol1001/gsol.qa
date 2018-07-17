/**
 * This Class contains methods that represent the locators available on Supplier Home Page
 * Created: Tue 31 March 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/03/31
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

/**
 * Contains methods that represent the locators available on Supplier Home page.
 * @author Teng Shyh Wei
 *
 */
public class SupplierHome_Page extends BaseClass{

	private static WebElement element = null;
    
    public SupplierHome_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify the Supplier MW Homepage is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param getSuppName
     * @return
     * @throws Exception
     */
    public static WebElement check_suppMWHomepageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String getSuppName) throws Exception{
    	try{    	
    		WebElement suppNameElement = driver.findElement(By.xpath("//*[contains(@class, 'spNameBox')]/h1"));
            String getSuppNameMW = suppNameElement.getText();
            Add_Log.info("Supplier MW Homepage ::" + getSuppNameMW);
            
            if(getSuppName.equals(getSuppNameMW)){
            	Add_Log.info("Passed. Supplier MW Homepage is displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_SUPP_MW_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
             	
            }else{
             	Add_Log.info("Failed. Supplier MW Homepage is NOT displayed");
             	SuiteUtility.WriteResultUtility(
             			xls, sheetName, Constant.COL_SUPP_MW_HOMEPAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
             	testFail.set(0, true);
            }
        }catch(Exception e){
        	Add_Log.error("Error! Supplier MW Homepage is NOT displayed.");
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
     * Go to Supplier Product List category page by select a sub menu from 'Product List'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectProductListCategory() throws Exception{
    	try{
			Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'spNavA')][contains(text(),'Product List')]"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'navL2 navPcats dotList')]//a)[position()=1]"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();    		
    		
    	}catch(Exception e){
    		Add_Log.error("Product List menu bar is NOT found on the page.");
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
        
    /**
     * Go to Supplier ECI page by select a sub menu from 'Company Information'.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectSupplierECI() throws Exception{
    	try{
			Actions actions = new Actions(driver);
    		WebElement mainMenu = driver.findElement(
    				By.xpath("//*[contains(@class, 'spNavA')][contains(text(),'Company Information')]"));
    		WebElement subMenu = driver.findElement(
    				By.xpath("(//*[contains(@class, 'navL2 navInfoList dotList')]//a)[position()=1]"));
    		actions.moveToElement(mainMenu).moveToElement(subMenu).click().build().perform();    		
    		Add_Log.info("User is click on sub menu link from Company Information menu");
    		
    	}catch(Exception e){
    		Add_Log.error("Sub menu Company Information is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================= End of menu bar navigator ==========================================================
 
    // ========================================================= Start of Left Nav section ==========================================================
    
    /**
     * To click on 'Inquire Now' button at Supplier Home page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInquireNowAtLeftNav() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'serviceBox')]//a[contains(text(),'Inquire Now')]"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Add to Basket' button at Supplier Home page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAddToBasket() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'contact_bsk mt5')]"
    				+ "//a[contains(text(),'Add to Basket')])[position()=1]"));
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Follow Me' button next to supplier's name.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFollowMe() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'serviceBox')]//a[contains(text(),'Follow Me')]"));
    		Add_Log.info("Follow Me button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Follow Me button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'View my followed suppliers' link below the 'Following' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickViewMyFollowedSupp() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'ib mt5')]"
    				+ "[contains(text(),'View my followed suppliers')]"));
    		Add_Log.info("View my followed suppliers link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("View my followed suppliers link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify the 'Follow Me' button in the original page become '(green tick) Following'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_btnFollowingWithGreenTickExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isGreenTickExists = 
    				driver.findElements(By.xpath("//img[contains(@class,'followSupIco2')]")).size() !=0;
    		Boolean isBtnFollowingExists = 
    				driver.findElements(By.xpath("//a[contains(text(),'Following')]")).size() != 0;
    		
    		Add_Log.info("Is green tick icon available on the page ::" + isGreenTickExists);
    		Add_Log.info("Is Following button available on the page ::" + isBtnFollowingExists);
    		
    		if(isGreenTickExists == true && isBtnFollowingExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BTN_FOLLOWING_WITH_GREEN_TICK, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BTN_FOLLOWING_WITH_GREEN_TICK, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that the "View my followed suppliers" hyperlink is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_lnkViewFollowedSuppExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isLinkExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'ib mt5')][contains(text(),'View my followed suppliers')]")).size() != 0;
    		Add_Log.info("Is 'view my followed suppliers' hyperlink available ::" + isLinkExists);
    		
    		if(isLinkExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LINK_VIEW_FOLLOWED_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LINK_VIEW_FOLLOWED_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("View my followed suppliers hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== End of Left Nav section ===========================================================
    
    /**
     * Enter text for search keyword field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterGSOLSearchField() throws Exception{
    	try{
    		element = driver.findElement(By.id("gsolmwquery"));
    		Add_Log.info("User is enter text for search keyword field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Search Keyword field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }      
    
    // ===================================================== Start of Product Highlights section ====================================================
    
    // Mouseover to first PP image at Product Highlights section.
    public static WebElement img_mouseoverFirstPPImgAtPdtHighlightsSection(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='hlProducts']/li[1]/p"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Waiting 10 seconds for the zoomed element to be visible
    		WebElement imgZoom = driver.findElement(
    				By.xpath("//*[@id='morePPBox']/dl"));
    		WebDriverWait wait = new WebDriverWait(driver, 10);
    		wait.until(ExpectedConditions.visibilityOf(imgZoom));
    		
    		// Verify Rollover Large Image is displayed when mouse over to any PP image.
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
    		Add_Log.error("PP image is NOT found on Product Highlights section.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on first PP image at Product Highlights section.
    public static WebElement img_clickFirstPPImageAtPdtHighlightsSection() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='hlProducts']/li[1]/p"));
    		
    		// Hover mouse above the image and click on it
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    	//	imgHover.click();
    		
    		// Click on the Rollover Larger Image
    		WebElement img = driver.findElement(
    				By.xpath("//*[@id='morePPBox']//dd[1]//img"));
    		img.click();
    		
    		Add_Log.info("User is click on first PP image at Product Highlights section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP image is NOT found on Product Highlights section.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on "Inquire Now" button inside the Rollover Large image.
    public static WebElement btn_clickInqNowBtnInRolloverImgPdtHighlights() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='hlProducts']/li[1]/p"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the 'Inquire Now' button
    		WebElement addToBasketBtn = driver.findElement(By.id("InqBtn"));
    		addToBasketBtn.click();
    		Add_Log.info("User is click on Inquire Now button inside the Rollover Large image in Product Highlights section.");    	
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found inside the Rollover large image.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on PP link inside the Rollover Large image.
    public static WebElement lnk_clickPPLinkInRolloverImgPdtHighlights() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='hlProducts']/li[1]/p"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the PP link
    		WebElement ppLink = driver.findElement(By.id("InqSPD"));
    		ppLink.click();
    		Add_Log.info("User is click on PP link inside the Rollover Large image in Product Highlights section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP link is NOT found inside the Rollover large image.");
    	}
    	return element;
    }
    
    // To click on first PP link under the PP image at Product Highlights section.
    public static WebElement lnk_clickFirstPPLinkAtPdtHighlightsSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='hlProducts']/li[1]/a"));
    		Add_Log.info("User is click on first PP link under the PP image at Product Highlights section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP image is NOT found on Product Highlights section.");
    		throw(e);
    	}
    	return element;
    }
    
    
    // ====================================================== End of Product Highlights section =====================================================
    
    // ====================================================== Start of Latest Products section ======================================================
    
    // Click on the "Select all" link.
    public static WebElement lnk_clickOnSelectAll() throws Exception{
    	try{
    		element = driver.findElement(By.className("selectAll"));
    		element.click();
    		Add_Log.info("Select all link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Select all link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Inquire Now" button.
    public static WebElement btn_clickInquireNowOnLatestProducts() throws Exception{
    	try{
    		element = driver.findElement(By.id("inquirenow"));
    		element.click();
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Add to Basket" button.
    public static WebElement btn_clickAddToBasketOnLatestProducts() throws Exception{
    	try{
    		// 11 Apr 2018 MR#47518 Change Inquiry Basket to "Save for Later"
    	//	element = driver.findElement(By.xpath("//*[contains(@class,'proOpt')]//img[contains(@class,'basketIco')]"));
    		element = driver.findElement(By.xpath("//*[contains(@class,'proOpt')]//*[contains(@class,'saveIcon')]"));
    		element.click();
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on first PP image at Latest Products section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickFirstPPImgAtLatestProductsSection() throws Exception{
    	try{
    		// Locate the first image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'catProCont')]//img)[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the zoomed image
    		WebElement ppImg = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//img)[position()=1]"));
    		ppImg.click();
    		Add_Log.info("User is click on first PP image at Latest Products section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP image is NOT found on Latest Products section.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on "Inquire Now" button inside the Rollover Large image.
    public static WebElement btn_clickInqNowBtnInRolloverImgLatestProducts() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='catProList']/li[1]/p"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the 'Add to Basket' button
    		WebElement addToBasketBtn = driver.findElement(By.id("InqBtn"));
    		addToBasketBtn.click();
    		Add_Log.info("User is click on Inquire Now button inside the Rollover Large image in Latest Products section.");    	
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button inside the Rollover Large image in Latest Products section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on Add to Basket button inside the Rollover Large image.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAddToBasketInRolloverImage() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='catProList']/li[1]/p"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the 'Add to Basket' button
    		WebElement addToBasketBtn = driver.findElement(By.id("moAddBsk"));
    		addToBasketBtn.click();
    		Add_Log.info("User is click on Add to Basket button inside the Rollover Large image in Latest Products section.");
    		    	
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found inside the Rollover Large image.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on PP SPD link inside the Rollover Large image.
    public static WebElement lnk_clickPPLinkInRolloverImage() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='catProList']/li[1]/p"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the PP SPD link
    		WebElement ppLink = driver.findElement(By.id("InqSPD"));
    		ppLink.click();
    		Add_Log.info("User is click on PP SPD link inside the Rollover Large image in Latest Products section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP SPD link is NOT found inside the Rollover Large image.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on first PP link under the PP image.
    public static WebElement lnk_clickFirstPPLinkAtLatestProductsSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='catProList']/li[1]/a"));
    		Add_Log.info("User is click on first PP link under the PP image at Latest Products Section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP image is NOT found on Latest Products section.");
    	}
    	return element;
    }
    
    // Select first PP chkbx at Latest Products section.
    public static WebElement chkbx_select1stPPChkbx() throws Exception{
    	try{
    		// Locate the 1st PP Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='catProList']/li[1]/p"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select 1st PP chkbx
    		WebElement firstPPChkbx = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//input"));
    		firstPPChkbx.click();    		
    		Add_Log.info("User select first PP chkbx at Latest Products section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP chkbx is NOT found on Latest Products section.");
    		throw(e);
    	}
    	return element;
    }
    
    // Select second PP chkbx at Latest Products section.
    public static WebElement chkbx_select2ndPPChkbx() throws Exception{
    	try{
    		// Locate the 2nd PP Image
    		WebElement imgHover = driver.findElement(By.xpath("//*[@id='catProList']/li[2]/p"));
    		
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select 2nd PP chkbx
    		WebElement secondPPChkbx = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//input"));
    		secondPPChkbx.click();
    		Add_Log.info("User select 2nd PP chkbx at Latest Products section.");
    		
    	}catch(Exception e){
    		Add_Log.error("PP chkbx is NOT found on Latest Products section.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify PPs chkbx are selected.
    public static WebElement check_multiplePPsChkbxChecked(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 1st PP chkbx
    		WebElement firstPPChkbx = driver.findElement(By.xpath("(//*[@class='proCheckbox'])[position()=1]"));
    		Boolean is1stPPChkbxSelected = firstPPChkbx.isSelected();
    		Add_Log.info("Print is 1st chkbx selected ::" + is1stPPChkbxSelected);
    		
    		// 2nd PP chkbx
    		WebElement secondPPChkbx = driver.findElement(By.xpath("//*[@id='morePPBox']//dd[1]//input"));
    		Boolean is2ndChkbxSelected = secondPPChkbx.isSelected();
    		Add_Log.info("Print is 2nd chkbx selected ::" + is2ndChkbxSelected);
    		
    		if(firstPPChkbx.isSelected() && secondPPChkbx.isSelected()){
    			Add_Log.info("Passed. PPs chkbx are selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.MULTIPLE_PPS_CHKBX_ARE_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. PPs chkbx are NOT selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.MULTIPLE_PPS_CHKBX_ARE_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("PP chkbx is NOT found on Latest Products section.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify all the PPs checkboxes are checked.
    public static WebElement check_allPPsChkbxChecked(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxLatestProducts = driver.findElements(By.xpath("//*[@class='proCheckbox']"));
    		for(WebElement chkbx : chkbxLatestProducts){
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
    		Add_Log.error("PPs checkboxed Latest Products section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click on "Show all products" link.
    public static WebElement lnk_clickShowAllProducts() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'seeAllPro')]//a[contains(text(),'Show all products')]"));
    		element.click();
    		Add_Log.info("User is click on Show all products link.");
    		
    	}catch(Exception e){
    		Add_Log.error("Show all products link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================= End of Latest Products section =======================================================

    // ====================================================== Start of Contact Details section ======================================================
    
    /**
     * To enter text at RFI Static Form.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterMsgAtRFIStaticForm() throws Exception{
    	try{
    		element = driver.findElement(By.id("inqmsgtextarea"));
    		Add_Log.info("User is enter text at RFI Static Form");
    		
    	}catch(Exception e){
    		Add_Log.error("RFI Static Form is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Continue' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContinue() throws Exception{
    	try{
    		// 08-Mar-2018 MR#49166
    	//	element = driver.findElement(By.name("continueInq"));
    		element = driver.findElement(By.xpath("//*[contains(@class,'contact_RFI_btn')]//a"));
    		Add_Log.info("Continue button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Continue button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================= End of Contact Details section =======================================================
    
    // ===================================================== Start of Floating Contact section ======================================================
    
    // In order to view Floating Contact section, scroll to the footer of the page.
    public static WebElement scrollToFooterSection() throws Exception{
    	try{
    		// 03-Mar-2018 MR#49166 
    	//	WebElement elementMove = driver.findElement(By.name("continueInq"));
    		WebElement elementMove = driver.findElement(By.xpath("//*[contains(@class,'contact_RFI_btn')]//a"));
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
    
    /**
     * To click on 'Inquire Now' button at Floating Contact section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInquireNowAtFloatingContactSection() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'contactSupplierBox')]//a[contains(text(),'Inquire Now')]"));
    		Add_Log.info("Inquire Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    // To click on the "Follow Me" button at the Floating Contact section.
    public static WebElement btn_clickFollowMeAtFloatingContactSection() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'contactSupplierBox')]//a[contains(text(),'Follow Me')]"));
    		Add_Log.info("Follow Me buton is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Follow Me button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on the "View my followed suppliers" link at the Floating Contact section.    
    public static WebElement lnk_clickViewMyFollowedSuppliers() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'contactSupplierBox')]//a[contains(text(),'View my followed suppliers')]"));
    		Add_Log.info("View my followed suppliers link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("View my followed suppliers link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    // ====================================================== End of Floating Contact section =======================================================

    
    /**
     * Close the eMag Popup Form.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickCloseBtnOnEmagPopupForm() throws Exception{
    	try{
    		Boolean isEmagPopupExists = driver.findElements(By.id("getEmagPopup")).size() != 0;
    		Add_Log.info("Is eMag Popup form displayed ::" + isEmagPopupExists);
    		
    		if(isEmagPopupExists == true){
    			// Close the eMag popup form
    			driver.findElement(By.id("closeEmag")).click();
    			Add_Log.info("eMag Popup Form is closed.");
    		}
    	}catch(Exception e){
    		Add_Log.error("eMag Popup Form is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Close the MW Promo PP overlay.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickCloseBtnOnPromoPPOverlay() throws Exception{
    	try{    		
    	//	Boolean isPromoPPOverlayExists = driver.findElements(By.id("mwsPromoPP_overlay")).size() != 0;
    		element = driver.findElement(By.xpath("//*[@id='mwsPromoPP_overlay']"));
    		Boolean isPromoPPOverlayExists = element.isDisplayed();
    		Add_Log.info("Is MW Promo PP overlay displayed ::" + isPromoPPOverlayExists);
    		
    		if(isPromoPPOverlayExists == true){
    			// Close the MW Promo PP overlay
    			driver.findElement(By.xpath("//*[contains(@class, 'close ui_overlay_close')]")).click();
    			Add_Log.info("MW Promo PP overlay is closed.");
    		}
    	}catch(Exception e){
    		Add_Log.error("MW Promo PP overlay is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Close the Trade Match popup adv.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickCloseBtnOnTradeMatchAdv() throws Exception{
    	try{
    		Boolean isTradeMatchAdvExists = driver.findElements(By.id("tm_overlay")).size() != 0;
    		Add_Log.info("Is Trade Match popup adv displayed ::" + isTradeMatchAdvExists);
    		
    		if(isTradeMatchAdvExists == true){
    			// Close the Trade Match popup adv
    			driver.findElement(By.xpath("//*[@id='tm_overlay']/span")).click();
    			Add_Log.info("Trade Match popup adv is closed.");
    			
    		}else{
    			// do nothing
    		}
    	}catch(Exception e){
    		Add_Log.error("Trade Match popup adv is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify the Supplier Service icons are matching.
    public static WebElement check_supplierServiceIconsAreMatching(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement elementVerSupp = driver.findElement(By.xpath("//*[contains(@class, 'verifiedSupplierIco')]"));
    	//	WebElement elementTradeShow = driver.findElement(By.xpath("//*[@id='___UI_trigger0_sfPop']/img"));
    		WebElement elementMagazine = driver.findElement(By.xpath("//*[@id='___UI_trigger0_eMagPop']/div/img")); 
    		WebElement elementMajorCust = driver.findElement(By.xpath("//*[@id='___UI_trigger0_customerPop']/div/img"));
    		WebElement elementOnlineStore = driver.findElement(By.xpath("//*[@id='___UI_trigger0_storeFrontPop']/div/img"));
    		
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
    			Add_Log.info("Supplier service icons in Supplier Homepage are matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Supplier service icons in Supplier Homepage are NOT matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
}
