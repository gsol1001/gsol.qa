/**
 * This Class contains methods that represent the locators available on Product Listing Page
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
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Product Listing page.
 * @author Teng Shyh Wei
 *
 */
public class ProductListing_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public ProductListing_Page(WebDriver driver){
        	super(driver);
    }   
    
    // Mouse over the driver to Search button.
    public static WebElement btn_mouseoverToSearchBtn() throws Exception{
    	try{
    		// Due to Bug#85, move the mouse to temp fixed the issue
    		WebElement elementMove = driver.findElement(By.id("keywordBtnSearch"));    		
    		Actions action = new Actions(driver);
    		action.moveToElement(elementMove).build().perform();
    		Add_Log.info("Mouseover action.");
    		
    	}catch(Exception e){
    		Add_Log.error("Error! Mouseover error.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Close the Help Tour overlay.
     * 14-Jul-2017 MR47140 Help Tour overlay is removed from search results page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_closeHelpTourOverlay11() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'helpTourPopup none')]")));
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'helpTourPopup none')]")));
    		
    		element = driver.findElement(By.xpath("//*[contains(@class, 'helpTourPopup none')]"));
    		Boolean isHelpTourOverlayExists = element.isDisplayed();
    		Add_Log.info("Is Help Tour overlay displayed ::" + isHelpTourOverlayExists);
    		
    		if(isHelpTourOverlayExists == true){
    			// Close the Help Tour overlay
    			WebElement btnClose = driver.findElement(By.xpath("//*[contains(@class, 'helpTourClose none')]"));
    			btnClose.click();
    			Add_Log.info("Help Tour overlay is closed.");
    		}else{
    			// do nothing
    			Add_Log.info("Help Tour overlay is not displayed.");
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("Unable to locate Help Tour overlay on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select sort filter drop down list.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectSortFilterList(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.name("SortFiltList")); 
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
    
    // Click on "List View" icon.
    public static WebElement icon_selectListView() throws Exception{
    	try{
    		element = driver.findElement(By.className("ppListIco"));
    		element.click();
    		Add_Log.info("List View icon is click on the page.");
    		
    	}
    	catch(Exception e){
    		Add_Log.error("List View icon is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select 40 Items per page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_select40ItemsPerPage() throws Exception{
    	try{
    		Select dropdown = new Select(driver.findElement(By.xpath("//*[@name='SelectedItemsBox']")));
    		dropdown.selectByValue("40");
    		Add_Log.info("User select value 40 in Items per page drop down list");
    		
    	}catch(Exception e){
    		Add_Log.error("Items per page drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select 60 Items per page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_select60ItemsPerPage() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("SelectedItemsBox")));
    		
    		Select dropdown = new Select(driver.findElement(By.name("SelectedItemsBox")));
    		dropdown.selectByValue("60");
    		Add_Log.info("User select value 60 in Items per page drop down list.");
    		
    	}catch(Exception e){
    		Add_Log.error("Items per page drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================= Start of Quick Filter section ========================================================
    
    /**
     * To click on "Product List" tab.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickProductList() throws Exception{
    	try{
    		// 03-Jan-2017 MR45284 New UI on KWS Listing page
    	//	element = driver.findElement(By.xpath("//a[contains(text(),'Product List')]"));
    		element = driver.findElement(By.xpath("//*[contains(text(),'Product List')]"));
    		Add_Log.info("Product List view tab is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product List view tab is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on "Product Gallery" tab view.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickProductGalleryTabView() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'galleryIco')]"));
    		Add_Log.info("Product Gallery Tab View is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product Gallery Tab View is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on "Product List" tab view.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickProductListTabView() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'ppListIco')]"));
    		Add_Log.info("Product List Tab View is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product List Tab View is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on "Supplier List" tab.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickSupplierList() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 20);
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Supplier List')]")));
    		
    		element = driver.findElement(By.xpath("//a[contains(text(),'Supplier List')]"));
    		Add_Log.info("Supplier List view tab is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier List view tab is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To click on "Exhibitor List" tab.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickExhibitorList() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Exhibitor List')]"));
    		Add_Log.info("Exhibitor List view tab is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier List view tab is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Quick Filters" checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectQuickFilters(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[contains(@class, 'qFilter_item')]//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));
    		
    		for(String check : list){
    			for(WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    // ======================================================== End= of Quick Filter section ========================================================
    
    
    // ====================================================== Start of Left Navigation section ======================================================
    
    /**
     * To select single Category from 'Related Categories' side bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_selectSingleCategory() throws Exception{
    	try{
    		// Date 1-Sep-2016 UI Changed
    		//*[contains(@class, 'sidebar_con relateCat kwRelateLink')]
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'sidebar_con relateCat')]")));
    		
    	//	element = driver.findElement(
    	//			By.xpath("(//*[contains(@class, 'sidebar_con relateCat')]/li/a)[position()=1]"));
    		
    		// 03-Jan-2017: Select 2nd category
    		// 08-Feb-2017: Select 1st category
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'sidebar_con relateCat')]/li/a)[position()=1]"));
    		
    	/*	WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("catList")));
    		
    		element = driver.findElement(
    				By.xpath("(//*[@id='catList']/li[1]/a)[position()=1]"));
    	*/	
    		// Print selected category into console
    		String txt_getSelectedCategoryName = element.getText();
    		Add_Log.info("Selected single category are ::" + txt_getSelectedCategoryName);
    		
    	}catch(Exception e){
    		Add_Log.error("Related Categories side bar is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select L3 single category from 'Related Categories' side bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_selectL3Category() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[@id='l2CatId']/li/a)[position()=1]"));
    		
    		// Print selected category into console
    		String txt_getSelectedCategoryName = element.getText();
    		Add_Log.info("Selected single category are ::" + txt_getSelectedCategoryName);
    		
    	}catch(Exception e){
    		Add_Log.error("Related Categories side bar is NOT found on the page.");
        	throw(e);
        }
        return element;
    }
    
    // ========================================================== Start of Filter by section ========================================================
    
    /**
     * Click on Supplier Ranking "Show More" link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickShowMore() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='filter_rank']/li[7]"));
    		Add_Log.info("User is click on Supplier Ranking 'Show More' link.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier Ranking 'Show More' link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Supplier Ranking" checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectSuppRanking(String dataSuppRanking) throws Exception{
    	try{
    	/*	List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_rank']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for (String check : list){
    			for (WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}	*/
    		
    		element = driver.findElement(By.xpath("//*[@id='filter_rank']/li//input[@value='"+dataSuppRanking+"']"));
    		element.click();
    		Add_Log.info(""+dataSuppRanking+" Star chkbx is selected in Supplier Ranking chkbx.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier Ranking chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Business Types" checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectBusinessTypes(String dataBusinessTypes) throws Exception{
    	try{
    	/*	List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_busType']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for (String check : list){
    			for (WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}	*/
    		
    		element = driver.findElement(By.xpath("//*[@id='filter_busType']/li//input[@value='"+dataBusinessTypes+"']"));
    		element.click();
    		Add_Log.info(""+dataBusinessTypes+" chkbx is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business Type chkbx is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Supplier Locations" checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectSuppLocations(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_location']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for(String check : list){
    			for(WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Past Export Countries' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPastExportCountries() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@value='Search Export Countries']"));
    		Add_Log.info("User is enter text for Past Export Countries field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Past Export Countries field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Past Export Countries' checkboxes.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectPassExportCountries(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filterScrollBox']//li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));
    		
    		for(String check : list){
    			for(WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    	}catch(Exception e){
    		Add_Log.error("Past Export Countries checkboxes are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on "Select Trade Show(s)" hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSelectTradeShow() throws Exception{
    	try{
    		element = driver.findElement(By.id("trigger_tradeShows"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Upcoming Trade Show" checkbox and click on "Confirm" button.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectUpcomingTradeShow(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='tradeShow_overlay']/ul/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));
    		
    		for(String check : list){
    			for(WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    		
    		driver.findElement(By.xpath("//*[@id='tradeShow_overlay']//a[contains(text(),'Confirm')]")).click();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * Click on "More Filters". 
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickMoreFilters() throws Exception{
    	try{
    		element = driver.findElement(By.id("trigger_sidebarNavigators"));
    		Add_Log.info("User is click on More Filters link.");
    		
    	}catch(Exception e){
    		Add_Log.error("More Filters link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend Trade Show section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickToExpendTradeShowSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_ZS']/img"));
    		Add_Log.info("User is click on + icon to expend Trade Show section.");
    		
    	}catch(Exception e){
    		Add_Log.error("+ icon is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Trade Show" checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectTradeShow(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_TS']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));
    		
    		for(String check : list){
    			for(WebElement chk: allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    	}catch(Exception e){
    		Add_Log.error("Trade Show checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend FOB Price section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickToExpendFOBPriceSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_FOB']/img"));
    		Add_Log.info("User is click on + icon to expend FOB Price section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the FOB Price section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * Enter text for 'FOB Price (USD)' minimum value field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFOBPriceMinVal() throws Exception{
    	try{
    		element = driver.findElement(By.id("FOBPriceMinVal"));    		
    		Add_Log.info("User is enter text for 'FOB Price (USB)' minimum value field.");
    		
    	}catch(Exception e){
    		Add_Log.error("'FOB Price (USB)' minimum value field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    /**
     * Enter text for 'FOB Price (USD)' maximum value field
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFOBPriceMaxVal() throws Exception{
    	try{
    		element = driver.findElement(By.id("FOBPriceMaxVal"));
    		Add_Log.info("User is enter text for 'FOB Price (USB)' maximum value field.");
    		
    	}catch(Exception e){
    		Add_Log.error("'FOB Price (USB)' maximum value field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the FOB Price 'GO' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFOBPriceGO() throws Exception{
    	try{
    		element = driver.findElement(By.id("FOBGoButton"));
    		Add_Log.info("User is click on FOB Price 'GO' button.");
    		
    	}catch(Exception e){
    		Add_Log.error("FOB Price 'GO' button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend Min Order section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickToExpendMinOrderSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_MOQ']/img"));
    		Add_Log.info("User is click on '+' icon to expend Min Order section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the Min Order section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on filter "Min. Order" icon.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickFilterMinOrder() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_MOQ']/img"));
    		Add_Log.info("User is click on folter 'Min. Order' icon.");
    		
    	}catch(Exception e){
    		Add_Log.error("Filter 'Min. Order' icon is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Min Order Quantity" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterMinOrderQuantity() throws Exception{
    	try{
    		element = driver.findElement(By.id("MOQ"));
    		Add_Log.info("User is enter text for 'Min Order Quantity' field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Min Order Quantity field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Min Order Quantity "GO" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickMOQ_GoBtn() throws Exception{
    	try{
    		element = driver.findElement(By.id("moqGoButton"));
    		Add_Log.info("User is click on Min Order Quantity 'GO' button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Min Order Quantity 'GO' button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend Credentials section
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickToExpendCredentialsSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_credentials']/img"));
    		Add_Log.info("User is click on '+' icon to expend Credentials section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the Credentials section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Credentials' checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectCredentials(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_credentials']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));
    		
    		for(String check : list){
    			for(WebElement chk: allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    	}catch(Exception e){
    		Add_Log.error("Credentials checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend Product Certificates section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickToExpendPdtCertSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_prodCert']/img"));
    		Add_Log.info("User is click on '+' icon to expend the Product Certificates section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the Product Certificates section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * Select 'Product Certificates' checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectPdtCertificates(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_prodCert']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));
    		
    		for(String check : list){
    			for(WebElement chk: allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    	}catch(Exception e){
    		Add_Log.error("Product Certificates checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend Company Certification section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickToExpendCompCertSection() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_comCert']/img"));
    		Add_Log.info("User is click on '+' icon to expend the Company Certification section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the Company Certification section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select 'Company Certificated' checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectCompCertificates(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_comCert']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));
    		
    		for(String check : list){
    			for(WebElement chk: allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    	}catch(Exception e){
    		Add_Log.error("Company Certificated checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend "Services" sections.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickFilterServices() throws Exception{ 
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_OEM']/img"));
    		Add_Log.info("User is click on '+' icon to expend the 'Services' sections.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the 'Services' sections is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Services" checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectServices(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath(".//*[@id='filter_OEM']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for (String check : list){
    			for (WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("'Services' checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend "Lead Time (Days)" section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickFilterLeadTime() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_leadTime']/img"));
    		Add_Log.info("User is click on '+' icon to expend the 'Lead Time (Days)' section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the 'Lead Time (Days)' section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Lead Time (Days)" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterLeadTimes() throws Exception{
    	try{
    		element = driver.findElement(By.id("leadTime"));
    		Add_Log.info("User is enter text for 'Lead Time (Days)' field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Lead Time (Days) field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Lead Time "GO" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickLeadTimeGO() throws Exception{
    	try{
    		element = driver.findElement(By.id("leadTimeGoButton"));
    		Add_Log.info("User is click on Lead Time 'Lead Time' button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Lead Time 'GO' button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend "Years in Business" section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickFilterYearsInBusiness() throws Exception{
    	try{
    		element = driver.findElement(By.id("trigger_filter_Years"));
    		Add_Log.info("User is click on '+' icon to expend 'Years in Business' section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the 'Years in Business' section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Years in Business" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterYearsInBusiness() throws Exception{
    	try{
    		element = driver.findElement(By.id("busYears"));
    		Add_Log.info("User is enter text for 'Years in Business' field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Year in Business field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Years in Business "GO" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickYearsInBusinessGO() throws Exception{
    	try{
    		element = driver.findElement(By.id("busYearsGoButton"));
    		Add_Log.info("User is click on Years in Business 'GO' button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Years in Business 'GO' button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend "Monthly Capacity" section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_clickFilterMonthlyCapacity() throws Exception{
    	try{
    		element = driver.findElement(By.id("trigger_filter_mCapacity"));
    		Add_Log.info("User is click on '+' icon to expend 'Monthly Capacity' section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the 'Monthly Capacity' section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Monthly Capacity" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterMonthlyCapacity() throws Exception{
    	try{
    		element = driver.findElement(By.id("mCapacity"));
    		Add_Log.info("User is enter text for 'Monthly Capacity' field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Monthly Capacity field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Monthly Capacity "GO" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickMonthlyCapacityGO() throws Exception{
    	try{
    		element = driver.findElement(By.id("mCapacityGoButton"));
    		Add_Log.info("User is click on Monthly Capacity 'GO' button.");
    		
    	}catch(Exception e){
    		Add_Log.error("Monthly Capacity 'GO' button is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click '+' icon to expend "Associations" section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFilterAssociations() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='trigger_filter_ZS']/img"));
    		Add_Log.info("Click '+' icon to expend 'Associations' section.");
    		 
    	}catch(Exception e){
    		Add_Log.error("'+' icon to expend the 'Associations' section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select "Associations" checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectAssociations(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='filter_ZS']/li//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for(String check : list){
    			for(WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}
    	}catch(Exception e){
    		Add_Log.error("Associations checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== End of Left Navigation section ====================================================
    
    // ========================================================= Start of Inquiry Checkbox element ==================================================
    
    /**
     * To select single Verified Product checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectSingleVerPdt() throws Exception{
    	try{
    		// Old UI (//*[contains(@class, 'majorPP_check')]//input[@type='checkbox'])[position()=1]	
    		// UI changed on Date 02-Oct-2015
    		// New UI (//*[contains(@class, 'wt_pchk')]//input[@type='checkbox'])[position()=1]
    		
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'majorPP_check')]//input[@type='checkbox'])[position()=1]"));    		
    		Add_Log.info("User select single verified product checkbox.");
    		
    	}catch(Exception e){
    		Add_Log.error("Verified Product checkbox is NOT found on the page.");
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
    public static WebElement chkbx_selectMultipleVerPdt() throws Exception{
    	try{
    		// UI changed on Date 25-Sep-2015
		//	driver.findElement(By.xpath("(//*[contains(@class, 'majorPP_check')]//input[@type='checkbox'])[position()=1]")).click();
		//	driver.findElement(By.xpath("(//*[contains(@class, 'majorPP_check')]//input[@type='checkbox'])[last()]")).click();
			
			// Select all chkbx those are odd number 
			List<WebElement> chkbx = driver.findElements(
					By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox']"));
			for(int i=1; i<chkbx.size(); i=i+2){
				chkbx.get(i).click();
			}
			
			int checkedCount = 0;
			for(int i=0; i<chkbx.size(); i++){
				if(chkbx.get(i).isSelected()){
					checkedCount++;
				}
			}
			Add_Log.info("Number of selected chkbx ::" + checkedCount);
			Add_Log.info("User select multiple verified product checkboxes.");
			
    	}catch(Exception e){
    		Add_Log.error("Verified Product checkbox are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select single Unverified Product checkbox.
     * 
     * @return
     * @throws Exception
     */
/*    public static WebElement chkbx_selectSingleUnvPdt() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[position()=1]"));

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * To select multiple Unverified Product checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectMultipleUnvPdt() throws Exception{
    	try{
    	/*	// Locate the first image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'unverified_detail')]//*[contains(@class, 'supplierPP_img')])[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select the checkbox inside the zoomed image
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    	//	waits.until(ExpectedConditions.elementToBeClickable(
    	//			By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[position()=1]")));
    		WebElement inqNowBtn = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[position()=1]"));
    		inqNowBtn.click();
    	

    		// Locate the last image
    		WebElement imgHoverLast = driver.findElement(
    				By.xpath("(//*[contains(@class, 'unverified_detail')]//*[contains(@class, 'supplierPP_img')])[last()]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builderLast = new Actions(driver);
    		builderLast.moveToElement(imgHoverLast).build().perform();
    	
    		// Select the checkbox inside the zoomed image
    		WebDriverWait waitsLast = new WebDriverWait(driver, 15);
    	//	waitsLast.until(ExpectedConditions.elementToBeClickable(
    	//			By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[last()]")));
    		WebElement inqNowBtnLast = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[last()]"));
    		inqNowBtnLast.click();  */
    		
    		// Locate the first image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'unverified_detail')]//*[contains(@class, 'supplierPP_img')])[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Select the checkbox inside the zoomed image
    		WebElement inqNowBtn = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[position()=1]"));
    		inqNowBtn.click();
    		
    		// Locate the last image
    		WebElement imgHoverLast = driver.findElement(
    				By.xpath("(//*[contains(@class, 'unverified_detail')]//*[contains(@class, 'supplierPP_img')])[last()]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builderLast = new Actions(driver);
    		builderLast.moveToElement(imgHoverLast).build().perform();
    		
    		// Select the checkbox inside the zoomed image
    		WebElement inqNowBtnLast = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[position()=1]"));
    		inqNowBtnLast.click();   
    		Thread.sleep(2000);	
    		Add_Log.info("Multiple unverified product checkboxes is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified product checkboxes are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Select first unverified product checkbox.
    public static WebElement chkbx_selectFirstUnvPdt() throws Exception{
    	try{
    		// Locate the first image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierPP_img')])[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();    		
    		
    		// Select the checkbox inside the zoomed image
    		WebElement inqNowBtn = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[position()=1]"));
    		inqNowBtn.click();
    		Add_Log.info("First unverified product checkbox is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("First unverified product checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Select last unverified product checkbox.
    public static WebElement chkbx_selectLastUnvPdt() throws Exception{
    	try{
    		// Locate the last image
    		WebElement imgHoverLast = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierPP_img')])[last()]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builderLast = new Actions(driver);
    		builderLast.moveToElement(imgHoverLast).build().perform();
    	
    		// Select the checkbox inside the zoomed image
    		WebElement inqNowBtnLast = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//input[@type='checkbox'])[last()]"));
    		inqNowBtnLast.click();    
    		Add_Log.info("Last unverified product checkbox is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Last unverified product checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select all Verified Products checkboxes.
     * 
     * @return
     * @throws Exception
     */
    //*[contains(@class, 'majorPP_check')]//input[@type='checkbox']	[old xpath]
    //*[contains(@class, 'wt_pchk')]//input[@type='checkbox']
    public static WebElement chkbx_selectAllVerPdt() throws Exception{
    	try{
    		List<WebElement> chkbxVerPdt = driver.findElements(
    				By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxVerPdt){
    			if(!chkbx.isSelected())
    				chkbx.click();
    			
    		}
    		Add_Log.info("All Verified Products checkboxes are selected on the page.");
    		
    	/*	List<WebElement> chkbx1 = driver.findElements(
    				By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox' ]"));
    		int chkbxCount = chkbx1.size();
    		Add_Log.info("Total chkbx ::" + chkbxCount);	*/
    		
    	}catch(Exception e){
    		Add_Log.error("Verified Products checkboxes are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ========================================================== End of Inquiry Checkbox element ===================================================
    
    // ========================================================== Start of Inquiry Button element ===================================================
    
    /**
     * To click on "Inquire Now" button in Product List tab view.
     * Applier to Product Gallery tab view and Product List tab view.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickProductListTabViewInqNow() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 25);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
    		
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//*[contains(@class, 'UItrigger_inquiryBox button')])[position()=1]")));
    		
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'UItrigger_inquiryBox button')])[position()=1]"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Inquire Now button for Verified Product is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button for Verified Product is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Verified Product at Product Listing details. 
     * Applied to Supplier List tab view and Exhibitor List tab view.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForVerPdtAtPdtListing() throws Exception{
    	try{
        	// UI changed on Date 28-Sep-2015 
    	//	element = driver.findElement(By.xpath("(//*[contains(@class, 'wt_pinq')]"
    	//			+ "//a[contains(text(),'Inquire Now')])[position()=1]"));
    		
    		WebDriverWait waits = new WebDriverWait(driver, 25);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
    		
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//*[contains(@class, 'majorPP_inquire')]//a[contains(text(),'Inquire Now')])[position()=1]")));
    		
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'majorPP_inquire')]"
    				+ "//a[contains(text(),'Inquire Now')])[position()=1]"));
    	//	element.click();
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Inquire Now button for Verified Product is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button for Verified Product is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To click 'Inquire Now' button for Verified Product at Inquiry Bar. (Multiple PPs)
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForVerPdtAtInqBar() throws Exception{
    	try{
    		// 04-Jan-2017 MR45284 Inquire Now button at Inquiry Bar is removed
    	//	element = driver.findElement(
    	//			By.xpath("(//*[contains(@class, 'inquiryCon')]//a[contains(text(),'Inquire Now')])[position()=1]"));
    		
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'majorPP_inquire')]//a[contains(text(),'Inquire Now')])[position()=1]"));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            
    		Add_Log.info("Inquire Now button for Verified Product is click on the page.");
    		
    	}catch(Exception e){    		
    		Add_Log.error("Inquire Now button for Verified Product is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());   
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire All button for Verified Product at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    /*public static WebElement btn_clickInqAllForVerPdtAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'inquiryCon')]//a[contains(text(),'Inquire All')])[position()=1]"));
    		Add_Log.info("Inquire All button for Verified Product is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire All button for Verified Product is NOT found on tha page.");
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * To click on 'Get Quotations' button at Inquiry Bar.
     * Date: 06-Apr-2016 Inquire All button changed to Get Quotations button.
     * Date: 04-Jan-2017 Get Quotations button at Inquiry Bar is removed.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickGetQuotationsAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'inquiryCon')]"
    				+ "//a[contains(text(),'Get Quotations')])[position()=1]"));
    		Add_Log.info("Get Quotations button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Get Quotations button is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());   
    		throw(e);
    	}
    	return element;
    }	
    
    /**
     * To click Inquire Now button for Unverified Product at Product Listing details.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForUnvPdtAtPdtListing() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[@id='unverifpparea']//a[contains(text(),'Inquire Now')])[position()=1]"));
    		Add_Log.info("Inquire Now button for Unverified Product is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button for Unverified Product is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire Now button for Unverified Product at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForUnvPdtAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'inquiryCon')]//a[contains(text(),'Inquire Now')])[last()]"));
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
    		Add_Log.info("Inquire Now button for Unverified Product is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button for Unverified Product is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click Inquire All button for Unverified Product at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqAllForUnvPdtAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'inquiryCon')]//a[contains(text(),'Inquire All')])[last()]"));
    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
        	wait.until(ExpectedConditions.elementToBeClickable(element));
        	Add_Log.info("Inquire All button for Unverified Product is click on the page.");
        	
    	}catch(Exception e){
    		Add_Log.error("Inquire All button for Unverified Product is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        

    // ======================================================= End of Inquiry Button element ========================================================
    
    // ==================================================== Start of Unverified Products element ====================================================
    
    // To click on Unverified Supplier Name link.
    public static WebElement lnk_clickUnvSuppName() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[@id='unverifpparea']//p[1]/a)[position()=1]"));
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("argument[0].click()", element);
    		Add_Log.info("Unverified Supplier Name link is NOT found on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Unverified Supplier Name link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on Unverified Product Name hyperlink.
     * 
     * @param dataUnvPdtName
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUnvPdtName(String dataUnvPdtName) throws Exception{
    	try{
    	//	element = driver.findElement(
    	//			By.xpath("//*[@id='unverifpparea']//a[contains(text(),'" + dataUnvPdtName + "')]"));
    		// Wait for hyperlink to be clickable
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='unverified_listing clearfix']//h3")));
    		wait.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("//*[@name='UVinquiry']//a[contains(text(),'" + dataUnvPdtName + "')]")));
    		
    		// 03-Jan-2017 New UI
    		element = driver.findElement(
    				By.xpath("//*[@name='UVinquiry']//a[contains(text(),'" + dataUnvPdtName + "')]"));
    		
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Unverified Product Name link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified Product Name link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    
    // ===================================================== End of Unverified Products element =====================================================
    
    // ====================================================== Start of Inquiry Basket element =======================================================
    
    // Click on "Add to Basket" button those are odd number
    public static WebElement btn_clickMultipleAddToBasket() throws Exception{
    	try{
    		// 11 Apr 2018 MR#47518 Change Inquiry Basket to "Save for Later"
    	//	List<WebElement> btnAdd = driver.findElements(
    	//			By.xpath("//*[@name='inquiry']//img[contains(@class, 'basketIco')]")) ;
    		List<WebElement> btnAdd = driver.findElements(
    				By.xpath("//*[@name='inquiry']//*[contains(@class, 'saveIcon')]")) ;
    		for(int i=1; i<btnAdd.size(); i=i+2){
    			btnAdd.get(i).click();
    		}
    		
    	/*	int btnCount = 0;
    		for(int i=0; i<btnAdd.size(); i++){
    			if(btnAdd.get(i).isSelected()){
    				btnCount++;
    			}
    		}	*/
    	//	Add_Log.info("Number of Add to Basket button click ::" + btnCount);
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Click All the "Add to Basket" button on the Product Listing page.
    public static WebElement btn_clickAllAddToBasket() throws Exception{
    	try{
    		List<WebElement> btnAdd = driver.findElements(
    				By.xpath("//*[@name='inquiry']//img[contains(@class, 'basketIco')]"));
    		for(int i=1; i<btnAdd.size(); i=i+1){
    			btnAdd.get(i).click();
    		}
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Add to Basket' button at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickAddToBasketInqBar() throws Exception{
    	try{
    		WebElement element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'funBox ml10')])[position()=1]"));
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    		// Wait for Global Navigator displayed
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
    		Add_Log.info("Global Navigator is displayed.");
    		
    		// Wait for Footer page displayed.
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_copyright')]")));
    		Add_Log.info("Footer page is displayed.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Add to Basket' button at Product Listing.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickAddToBasketPdtListing() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'mt5')]"
    				+ "//a[contains(text(),'Add to Basket')][position()=1]"));
    		Add_Log.info("Add to Basket button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To click on 'Add to basket' icon at Global Navigation.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickGlobalNavAddToBasketIcon() throws Exception{
    	try{    		
    		// 15-Aug-2017 MR#47265 
    	//	element = driver.findElement(By.xpath("//img[contains(@class, 'addToBasketIco')]"));    	
    		element = driver.findElement(By.xpath("//i[contains(@class, 'addToBasketIcon')]"));
    		
    	/*	// Locate the Image
    		WebElement imgHover = driver.findElement(By.id("navcount"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the Basket Image
    		WebElement inqNowBtn = driver.findElement(By.id("navcount"));
    		inqNowBtn.click();	
    	*/	
    	}catch(Exception e){
    		driver.navigate().refresh();
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the page refreshes and a 'Added to basket' is seen instead of checkboxes on those selected products.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_btnAddedIsSeen_selectedPdtChkbxHidden(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{

			// Verify all chkbx those are odd number 
			List<WebElement> chkbx = driver.findElements(
					By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox']"));
			for(int i=1; i<chkbx.size(); i=i+2){
				
		    	//	String btnAddedToBasket = driver.findElement(
		    	//			By.xpath("//*[contains(@class, 'mt5')]//a[contains(text(),'Added to Basket')]")).getText();
		    	String btnAdded = driver.findElement(
		    			By.xpath("//*[contains(@class, 'majorPP_funR')]//a[contains(text(),'Added')]")).getText();
		    	Add_Log.info("Print button text ::" + btnAdded);
		    	
		    	Boolean isChkbxHidden = driver.findElement(
		    			By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox']")).isDisplayed();
		    	Add_Log.info("Does chkbx still available ::" + isChkbxHidden);
		    		    		
		    	if(btnAdded.equals("Added") && isChkbxHidden == false){
		    		Add_Log.info("Button value is changed from 'Add' to 'Added'.");
		    		Add_Log.info("Chkbx of those selected products are removed");
		    		SuiteUtility.WriteResultUtility(
		    				xls, sheetName, Constant.COL_PDT_INQ_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_PASS);
		    		SuiteUtility.WriteResultUtility(
		    				xls, sheetName, Constant.COL_PDT_INQ_CHKBX_REMOVED, rowNum, Constant.KEYWORD_PASS);
		    	}else{
		    		Add_Log.info("Button value is NOT changed from 'Add' to 'Added'.");
		    		Add_Log.info("Chkbx of those selected products are NOT removed");
		    		SuiteUtility.WriteResultUtility(
		    				xls, sheetName, Constant.COL_PDT_INQ_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_FAIL);
		    		SuiteUtility.WriteResultUtility(
		    				xls, sheetName, Constant.COL_PDT_INQ_CHKBX_REMOVED, rowNum, Constant.KEYWORD_FAIL);
		    		testFail.set(0, true);
		    	}
			}

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify button value changed from 'Add' to 'Added'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_btnAddedToBasketIsSeen(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		// 'Add to Basket' button
    	//	String beforeAddCart = driver.findElement(
    	//			By.xpath("//*[contains(@class, 'mt5')]//a[contains(text(),'Add to Basket')]")).getText();
    		
    		// 'Added to Basket' button
    		String afterAddCart = driver.findElement(
    				By.xpath("//*[contains(@class, 'mt5')]//a[contains(text(),'Added to Basket')]")).getText();
    		
    		if(afterAddCart.equals("Added to Basket")){
    			Add_Log.info("Button value is changed from 'Add to Basket' to 'Added to Basket'.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_INQ_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Button value is NOT changed from 'Add to Basket' to 'Added to Basket'.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_INQ_ADDED_TO_BASKET_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Added to Basket button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify checkboxes on those selected products are removed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_chkbxHiddenAfterAddedToBasket(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox']"));
    		Boolean isChkbxHidden = element.isDisplayed();
    		Add_Log.info("Does chkbx still available ::" + isChkbxHidden);
    		
    		if(isChkbxHidden == true){
    			// failed
    			Add_Log.info("Chkbx of those selected products are NOT removed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_INQ_CHKBX_REMOVED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);    			
    		}else{
    			Add_Log.info("Chkbx of those selected products are removed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_INQ_CHKBX_REMOVED, rowNum, Constant.KEYWORD_PASS);
    		}
    		
    	/*	List<WebElement> chkbxVerifiedProducts = 
    				driver.findElements(By.xpath("//*[contains(@class, 'majorPP_check')]//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxVerifiedProducts){
    			if(!chkbx.isSelected())
    				chkbx.click();
    		}	*/
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To check that the count (red in color) beside the 'Inquiry basket' in the Global navigation tally the number of products added.
    
    /**
     * To verify that the count beside the 'Inquiry basket' in the Global navigation is in Red color.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
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
    					xls, sheetName, Constant.COL_PDT_INQ_BASKET_COUNT_RED_COLOR, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is NOT in Red color");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_INQ_BASKET_COUNT_RED_COLOR, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check that the count beside the 'Inquiry basket' in the Global navigation tally the number of products added.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param chkbxVerPdtSelected
     * @return
     * @throws Exception
     */
    public static WebElement check_inqBasketCountMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, int chkbxVerPdtSelected) throws Exception{
    	try{
			String countInqBasketVerPdt = driver.findElement(By.id("navcount")).getText();			
			int countInqBasketForVerPdt = Integer.parseInt(countInqBasketVerPdt.substring(1, countInqBasketVerPdt.length()-1));		
			Add_Log.info("Count beside Inquiry basket ::" + countInqBasketForVerPdt);			
    		
    		if(countInqBasketForVerPdt == chkbxVerPdtSelected){    			
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is tally with the number of products added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is NOT tally with the number of products added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    		
    	/*	String inqBasketCount = driver.findElement(By.id("navcount")).getText();
			// Ignore '(' and ')'
			int inqBasketCountNo = Integer.parseInt(inqBasketCount.substring(1, inqBasketCount.length()-1));
			Add_Log.info("Count beside Inquiry basket ::" + inqBasketCountNo);			
    		
    		if(inqBasketCountNo == chkbxCount){
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is tally with the number of products added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is NOT tally with the number of products added.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}	 */    
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result Pass when "Count beside the 'Inquiry basket' in the Global navigation is tally with the number of products added.".
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqBasketCountIsMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is tally with the number of products added.");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_PASS);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result Fail when "Count beside the 'Inquiry basket' in the Global navigation is 
     * NOT tally with the number of products added."
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_inqBasketCountNotMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("Count beside the 'Inquiry basket' in the Global navigation is NOT tally with the number of products added.");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_INQ_BASKET_COUNT_MATCH, rowNum, Constant.KEYWORD_FAIL);
			testFail.set(0, true);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ============================================================ End of Inquiry Basket element ===================================================
    
    // ====================================================== Start of Rollover Larger Image Section ================================================
    
    /**
     * Click on the 'Matching products' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickMatchingProducts() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class,'showMorePP')]//a[contains(text(),'Matching products')])[position()=1]"));
    		Add_Log.info("Matching products link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Matching products link is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Rollover Large Image is displayed when mouse over to PP image.
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
    		// Locate the small image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierPP_img')])[position()=1]"));
    		
    		// Hovering over image
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
    		Add_Log.info("Rollover Large image is NOT found on the page.");
    		throw(e);    	
    	}
    	return element;
    }
    
    /**
     * To click on the Rollover Larger image (GSOL PP page entry point).
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickOnRolloverLargerImage() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//div[contains(@class, 'GS_globalNav clearfix')]")));
    		
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//div[contains(@class, 'GS_copyright')]")));
    		
    		// UI changed on Date 23-Oct-2015
    		// Script updated on Date 28-Feb-2017
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//img[contains(@class, 'majorPP_img')])[position()=1]"));
		
    		// Hover mouse above the image but DONT click
    		Actions action = new Actions(driver);
    		action.moveToElement(imgHover).build().perform();    		
    		imgHover.click();
    
    		Add_Log.info("Rollover Large image is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.info("Rollover Large image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To click on the Unverified PP Rollover large image
     * 
     * @return
     * @throws Exception
     */
    public static WebElement img_clickOnUnvPPRolloverLargerImage() throws Exception{
    	try{
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierPP_img')]//img)[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions action = new Actions(driver);
    		action.moveToElement(imgHover).build().perform();
    		
    		// Click on the Rollover Larger Image
    		WebElement img = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_Pop_img')]//img)[position()=1]"));
    		img.click();
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified PP Rollover large image is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'Inquire Now' button in Rollover Larger image.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowOnRolloverImage() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'supplierPP_img')])[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Locate the Inquire Now button
    	/*	WebElement inqNowBtn = driver.findElement(
    				By.xpath("(//*[contains(@class, 'morePP_PopBox')]//dl/dd[2]/p[1]/a)[position()=1]"));
    		inqNowBtn.click();	*/
    		
    		WebElement inqNowBtn = driver.findElement(By.id("InqBtn"));
    		inqNowBtn.click();
    		
    	}catch(Exception e){
    		Add_Log.info("Inquire Now button is NOT found in Rollover Large image.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    // To click on the "Inquire Now" button in Rollover Larger image. (Product List tab)
    public static WebElement btn_clickInqNowOnRolloverImagePdtListTab() throws Exception{
    	try{
    		// Locate the Image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'detail_ppImg')])[position()=1]"));
    		
    		// Hover mouse above the image but DONT click
    		Actions action = new Actions(driver);
    		action.moveToElement(imgHover).build().perform();
    		
    		// Locate and click on "Inquire Now" button.
    		WebElement inqNowBtn = driver.findElement(By.id("InqBtn2"));
    		action.moveToElement(inqNowBtn);
    		inqNowBtn.click();
    		
    		Add_Log.info("Inquire Now button in Rollover Larger image is click on the page.");
    	}catch(Exception e){
    		Add_Log.error("Inquire Now button in Rollover Larger image is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ======================================================= End of Rollover Larger Image Section =================================================
    
    // =============================================== Start of PA cross promotion (centrewell) Section =============================================
  
    /**
     * Click on the product keyword link in the PA cross promotion (centrewell) section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickPdtKeyword_PACrossPromotion() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'PACon_addTxt')]//a"));
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
    		Add_Log.info("Product keyword link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product keyword link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify vertical title name is displayed as a hyperlink in PA cross promotion section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
/*    public static WebElement check_verticalTitleNameDisplayedAsHyperlink(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isHyperlinkExists = driver.findElements(By.xpath("//*[contains(@class, 'PACon_addTxt')]//a")).size() != 0;
    		Add_Log.info("Is vertical title name is displayed as a hyperlink in PA cross promotion section ::" + isHyperlinkExists);
    		
    		if(isHyperlinkExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_VERTICAL_TITLE_HYPERLINK_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_VERTICAL_TITLE_HYPERLINK_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * Enter text in the PA cross promotion (centrewell) section textbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_PACrossPromotion_EnterEmailAddress() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector(".paSubscribe_email.ui_input_tip"));
    		Add_Log.info("User is enter text in the PA cross promotion (centrewell) section textbox.");
    		
    	}catch(Exception e){
    		Add_Log.error("PA cross promotion (centrewell) section textbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Subscribe' button in the PA cross promotion (centrewell) section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_PACrossPromotion_ClickSubscribe() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'PAList')]//a[text()='Subscribe']"));
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify there are suggested categories in PA cross promotion (centrewell) section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PACrossPromotion_SuggCatExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'PAList')]")));
    		
    		Boolean isSuggCatPACrossPromotionExists = driver.findElements(By.xpath("//*[contains(@class, 'PAList')]")).size() != 0;
    		Add_Log.info("Is suggested categories in PA Cross Promotion (centrewell) section exists ::" + isSuggCatPACrossPromotionExists); 
    		
    		if(isSuggCatPACrossPromotionExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_IN_CENTREWELL_SEC_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_IN_CENTREWELL_SEC_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Suggested categories is NOT found in PA cross promotion (centrewell) section.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the first category's checkbox is checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PACrossPromotion_1stCatChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'PAList')]/ul/li[1]/input")).isSelected();
    		Add_Log.info("Is first category chkbx selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_1ST_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_1ST_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("First category's checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * Check on any category checkboxes.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static WebElement chkbx_select2ndCategory() throws Exception{
		try{
			element = driver.findElement(By.xpath("//*[contains(@class, 'PAList')]/ul/li[2]/input"));
			Add_Log.info("Suggested categories chkbx in PA cross promotion is click on the page.");
			
		}catch(Exception e){
			Add_Log.error("Suggested categories in PA cross promotion is NOT found on the page.");
    		throw(e);
    	}
    	return element;
	}
	
	/**
	 * To verify the 2nd categories checkboxes are checked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_PACrossPromotion_2ndCatChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'PAList')]/ul/li[2]/input")).isSelected();
    		Add_Log.info("Is second category chkbx selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PA Cross Promotion 2nd Category Chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Add Categories' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickAddCategories() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'PA_btn')]//a"));
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		Add_Log.info("Add Categories button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Add Categories button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    

        
    // ================================================ End of PA cross promotion (centrewell) Section ==============================================

    // ============================================= Start of eMag cross promotion (centrewell) Section =============================================
    
    // Click on the "register" link in the eMag cross promotion (centrewell) section.
    public static WebElement lnk_clickRegister() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'addtionalCon mt10')]//strong[contains(text(),'register')]"));
    		Add_Log.info("Register link eMag cross promotion (centrewell) section is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register link in eMag cross promotion (centrewell) section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Subscribe now" hyperlink in the eMag cross promotion (centrewell) section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSubscribeNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//Strong[text()='Subscribe now']"));
    		Add_Log.info("Subscribe now hyperlink is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe now hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Subscribe' button in the eMag cross promotion (centrewell) section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickEmagSubscribe() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='EMagSubButton']/a")));
    		
    		element = driver.findElement(By.xpath("//*[@id='EMagSubButton']/a"));
    		Add_Log.info("User is click on eMag Subscribe button in the eMag cross promotion (centrewell) section.");
    		
    	}catch(Exception e){
    		Add_Log.error("eMag Subscribe button is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the Recommend eMag 'Subscribe' button in the eMag cross promotion (centrewell) section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRecommendEmagSubs() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='RecomEMagSubButton']/a"));
    		Add_Log.info("Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on "More e-magazine titles available" hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickMoreEmagTitlesAvailable() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(text(),'More e-magazine titles available')]"));
    		Add_Log.info("More e-magazine titles available hyperlink is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("More e-magazine titles available hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on "Subscribe for print copies" hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSubsPrintCopies() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[text()='Subscribe for print copies']"));
    		Add_Log.info("Subscribe for print copies hyperlink is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe for print copies hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on "Global Sources Magazines" app hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickGSMagazinesApp() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[text()='\"Global Sources Magazines\" app']"));
    		Add_Log.info("Global Sources Magazines app hyperlink is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("GLobal Sources Magazines app hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that 'Subscribe' button is replaced by 'You are subscribed to this magazine' message.
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
    	//	Boolean isBtnExists = driver.findElement(By.xpath("//*[@id='EMagSubButton']/a")).isDisplayed();
    		Boolean isMsgExists = driver.findElement(
    				By.xpath("//*[@id='EMagSubButton']//*[text()='You are subscribed to this magazine']")).isDisplayed();
    		
    	//	Add_Log.info("Is Subscribed button exists ::" + isBtnExists);
    		Add_Log.info("Is message 'You are subscribed to this magazine' available ::" + isMsgExists);
    		
    		if (isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUBS_TO_EMAG_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUBS_TO_EMAG_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.info("'You are subscribed to this magazine' message is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that Recommend eMag 'Subscribe' button is replace by 'You are subscribed to this magazine' message.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgRecomEmagSubsToThisMagExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgExists = driver.findElement(By.xpath("//*[@id='RecomEMagSubButton']"
    				+ "//*[text()='You are subscribed to this magazine']")).isDisplayed();
    		Add_Log.info("Is message 'You are subscribed to this magazine' available ::" + isMsgExists);
    		
    		if(isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUBS_TO_EMAG_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUBS_TO_EMAG_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    				
    	}catch(Exception e){
    		Add_Log.error("");
    		throw(e);
    	}
    	return element;
    }
    
    // ============================================== End of eMag cross promotion (centrewell) Section ==============================================
    
    // ====================================================== Start of PA Enhanced Entrance Section =================================================
    
    /**
     * To verify the L4 category page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataL4Category
     * @return
     * @throws Exception
     */
    public static WebElement check_L4CategoryPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataL4Category) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'path mt5')]//strong"));
    		String getL4Text = element.getText();
    		Add_Log.info("Print L4 categories" + getL4Text);
    		
    		if(getL4Text.equals(dataL4Category)){
    			Add_Log.info("L4 categories page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_L4_CATEGORY_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("L4 categories page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_L4_CATEGORY_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the PA Enhanced Entrance 'Update me on new products' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUpdateMeOnNewProducts() throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'Update me on new products')]")));
    		
    		element = driver.findElement(By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'Update me on new products')]"));
    		element.click();
    		Add_Log.info("Update me on new products link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Update me on new products link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the PA Enhanced Entrance 'View latest products' link.
     * Applied to new user flow. (PA_LiteSignup_0008, PA_LiteSignup_0026, PA_LiteSignup_0027)
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickViewLatestProducts() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[@id='trigger_eConfirmBox'][contains(text(),'View latest products')]"));
    		Add_Log.info("View latest products link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("View latest products link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the PA Enhanced Entrance "View latest products" link.
     * Applied to logged in user. (ProductProfile_0006)
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickPAViewLatestProducts() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'View latest products')]"));
    		Add_Log.info("View latest products link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("View latest products link is NOT found on the page.");
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
    		Add_Log.error("Email address textbox is NOT found on the page.");
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
    		element = driver.findElement(By.id("paLiteTxt"));
    		Add_Log.info("User is enter text for Business Email field.");
    		
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
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    	//	waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribeSubmit")));
    	//	waits.until(ExpectedConditions.elementToBeClickable(By.id("subscribeSubmit")));
    		waits.until(ExpectedConditions.invisibilityOfElementLocated(By.id("GS_quotBoxPop")));
    		
    		element = driver.findElement(By.id("subscribeSubmit"));
    		Add_Log.info("PA Enhanced Entrance Subscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("PA Enhanced Entrance Subscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the PA Enhanced Entrance image is changed. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_imgPAEnhancedEntranceIsChanged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".paIco_check")));
    		
    	//	Boolean isImgBeforeClickedExists = driver.findElement(By.cssSelector(".paIco")).isDisplayed();
    		Boolean isPAEnhanceEntranceImgChanged = driver.findElement(By.cssSelector(".paIco_check")).isDisplayed();
    	//	Add_Log.info("Is image 'Update me on new products' exists ::" + isImgBeforeClickedExists);
    		Add_Log.info("Is image 'View latest products' exists ::" + isPAEnhanceEntranceImgChanged);
    		
    	//	if(isImgBeforeClickedExists == false && isPAEnhanceEntranceImgChanged == true){
    		if(isPAEnhanceEntranceImgChanged == true){
    			Add_Log.info("The PA Enhanced Entrance image is changed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_ENHANCED_ENTRANCE_IMG_CHANGED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The PA Enhanced Entrance image is NOT changed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_ENHANCED_ENTRANCE_IMG_CHANGED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("The PA Enhanced Entrance image is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());

    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify hyperlink of the Enhanced Entrance is removed and the copy changed to 'View latest products'.
     * Applied to new user flow. (PA_LiteSignup_0008, PA_LiteSignup_0026, PA_LiteSignup_0027)
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_lnkPAEnhancedEntranced_ViewLatestPdtExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    	/*	Boolean isLinkUpdateMeOnNewPdtExists = driver.findElement(
    				By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'Update me on new products')]")).isDisplayed();
    		Add_Log.info("Is hyperlink Update me on new products exists ::" + isLinkUpdateMeOnNewPdtExists);
    	*/	
    		
    		Boolean isLinkViewLatestPdtExists  = driver.findElement(
    				By.xpath("//a[@id='trigger_eConfirmBox'][contains(text(),'View latest products')]")).isDisplayed();
    		Add_Log.info("Is hyperlink View latest products exists ::" + isLinkViewLatestPdtExists);
    		
    	//	if(isLinkUpdateMeOnNewPdtExists == false && isLinkViewLatestPdtExists == true){
    		if(isLinkViewLatestPdtExists == true){
    			Add_Log.info("Hyperlink of the Enhanced Entrance is removed and the copy changed to 'View latest products'.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LINK_VIEW_LATEST_PDT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Hyperlink of the Enhanced Entrance is NOT removed and the copy is NOT changed to 'View latest products'.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LINK_VIEW_LATEST_PDT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify hyperlink of the Enhanced Entrance is removed and the copy changed to 'View latest products'.
     * Applied to logged in user.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_lnkPAEnhancedEntranced_ViewLatestPdtLinkExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    	/*	Boolean isLinkUpdateMeOnNewPdtExists = driver.findElement(
    				By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'Update me on new products')]")).isDisplayed();
    		Add_Log.info("Is hyperlink Update me on new products exists ::" + isLinkUpdateMeOnNewPdtExists);
    	*/	
    		Boolean isLinkViewLatestPdtExists  = driver.findElement(
    				By.xpath("//a[@id='trigger_paTipBox'][contains(text(),'View latest products')]")).isDisplayed();
    		Add_Log.info("Is hyperlink View latest products exists ::" + isLinkViewLatestPdtExists);
    		
    	//	if(isLinkUpdateMeOnNewPdtExists == false && isLinkViewLatestPdtExists == true){
    		if(isLinkViewLatestPdtExists == true){
    			Add_Log.info("Hyperlink of the Enhanced Entrance is removed and the copy changed to 'View latest products'.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LINK_VIEW_LATEST_PDT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Hyperlink of the Enhanced Entrance is NOT removed and the copy is NOT changed to 'View latest products'.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LINK_VIEW_LATEST_PDT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
	
    /**
     * To verify message "We've send a confirmation e-mail to autoqa_gsolnewxxxx@gmail.com
     * Click on the link in the e-mail to activate and start receiving free alerts when new product in posted." 
     * is displayed beside Enhanced Entrance.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataBusinessEmail
     * @return
     * @throws Exception
     */
    public static WebElement check_confCopyEnhancedEntranceLinkExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataBusinessEmail) throws Exception{
    	try{
    		// Fluent wait until Confirm Box is visible
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eConfirmBox")));
    		
    		// Locate the Confirmation Box
    		WebElement imgHover = driver.findElement(By.id("eConfirmBox"));
    		// Hover mouse above the Confirmation Box but don't click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		element = driver.findElement(By.xpath("//*[@id='eConfirmBox']//p"));
    		String copyMessage = element.getText();    		    		    		
    		String expMessage = "We've sent a confirmation e-mail to " + dataBusinessEmail + ".\nClick on the "
    				+ "link in the e-mail to activate and start receiving free alerts when new products are posted!";
    		Add_Log.info("Print get message ::" + copyMessage);
    		Add_Log.info("Print exp message ::" + expMessage);
    		
    		if(copyMessage.equalsIgnoreCase(expMessage)){
    			Add_Log.info("Confirmation copy is displayed beside Enhanced Entrance");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EE_CONF_COPY_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Confirmation copy is NOT displayed beside Enhanced Entrance");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EE_CONF_COPY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }    
    
    // ===================================================== End of PA Enhanced Entrance Section ====================================================

	// ================================================= Start of PA Catfish Banner section locators ================================================
    
    /**
     * To click on 'Close' icon in PA Catfish Banner.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement icon_PACatfishBanner_ClickOnCloseBtn() throws Exception{
    	try{		
    		// Locate the PA Catfish Banner section
    		WebElement imgHover = driver.findElement(By.id("catfishAd"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the Rollover Larger Image
    		WebElement inqNowBtn = driver.findElement(By.id("catfishClose"));
    		inqNowBtn.click();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify there are suggested categories in PA Catfish Banner section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatfishBanner_suggCatExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuggCatPACatfishBannerExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'catfishPAList')]")).size() != 0;
    		Add_Log.info("Is suggested categories in PA Catfish Banner section exists ::" + isSuggCatPACatfishBannerExists); 
    		
    		if(isSuggCatPACatfishBannerExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_IN_CATFISH_BANNER_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUGG_CAT_IN_CATFISH_BANNER_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the first category's checkbox PA Catfish Banner section is checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatfishBanner_1stCatChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[@id='catfishAd']//li[1]/label/input")).isSelected();
    		Add_Log.info("Is first category chkbx PA Catfish Banner selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_1ST_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_1ST_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Check on any category checkboxes in PA Catfish Banner section.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectPACatfishBanner_2ndCatChkbx() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='catfishAd']//li[2]/label/input"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select all category checkboxes in PA Catfish Banner section (except 1st checkbox).
     *   
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectAllPACatfishBanner() throws Exception{
    	try{
			// Select all chkbx except the 1st 
			List<WebElement> chkbx = driver.findElements(
					By.xpath("//*[contains(@class, 'catfishPAList')]//input"));
			for(int i=1; i<chkbx.size(); i++){
				chkbx.get(i).click();
			}
			
			int checkedCount = 0;
			for(int i=0; i<chkbx.size(); i++){
				if(chkbx.get(i).isSelected()){
					checkedCount++;
				}
			}
			Add_Log.info("Number of selected chkbx ::" + checkedCount);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the categories checkboxes in PA Catfish Banner section are checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatfishBanner_2ndCatChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[@id='catfishAd']//li[2]/label/input")).isSelected();
    		Add_Log.info("Is second category chkbx selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify all the categories checkboxes in PA Catfish Banner section are selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatfishBanner_AllCatChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> els = driver.findElements(
    				By.xpath("//*[contains(@class, 'catfishPAList')]//input")) ;
    		for(WebElement chkbx : els){
    			if(chkbx.isSelected()){
    				Add_Log.info("All the categories checkboxes in PA Catfish Banner section are selected");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("All the categories checkboxes in PA Catfish Banner section are NOT selected");
        			SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_2ND_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}
    		}
    		
    	/*	Boolean isChkbxSelected = driver.findElement(By.xpath("//*[@id='catfishAd']//input")).isSelected();
    		Add_Log.info("Is all the categories checkboxes selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("All categories checkboxes in PA Catfish Banner section are selected.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_ALL_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("All categories checkboxes in PA Catfish Banner section are NOT selected.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_ALL_CAT_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}	*/
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for PA Catfish Banner 'Business Email' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_PACatfishBanner_EnterBusinessEmail() throws Exception{
    	try{
    		// Locate the PA Catfish Banner area
    		WebElement imgHover = driver.findElement(By.name("PAinline"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    	//	element = driver.findElement(By.xpath("//*[@id='catfishAd']//input[@name='email']"));
    		element = driver.findElement(By.xpath("//*[@name='PAemail']//input[@name='email']"));
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on PA Catfish Banner 'Register' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_PACatfishBanner_ClickRegister() throws Exception{
    	try{
    	//	element = driver.findElement(By.xpath("//*[@id='catfishAd']//a[contains(text(),'Subscribe')]"));
    		
    		// UI changed on Date 07-Jan-2016
    		element = driver.findElement(By.xpath("//*[@name='PAemail']//input[@value='Register']"));
    		Add_Log.info("Register button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Register button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that the product keyword is pre-populated in PA Catfish Banner section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataCategoryKeyword
     * @return
     * @throws Exception
     */
    public static WebElement check_textPrepopulatedInPdtKeyword(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataCategoryKeyword) throws Exception{
    	try{
    		// Get the text entered in 'Product Keyword(s)' field
    		String textPrepopulatedInPdtKeyword = driver.findElement(By.name("searchQueryKeyword")).getAttribute("value");  
    		Add_Log.info("Text pre-populated in product keyword field ::" + textPrepopulatedInPdtKeyword);
    		
    		if(textPrepopulatedInPdtKeyword.equals(dataCategoryKeyword)){
    			Add_Log.info("Product Keyword is pre-populated in the textbox");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_KEYWORD_IS_PREPOPULATED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Keyword is NOT pre-populated in the textbox");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PDT_KEYWORD_IS_PREPOPULATED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	// ====================================================== End of PA Catfish Banner section locators =============================================
    
    // =========================================================== Start of Supplier Alert Module ===================================================
    
    /**
     * Click on the "Follow Me" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickFollowMe() throws Exception{
    	try{
    		// Wait until Global Navigator is loaded
    		WebDriverWait waits = new WebDriverWait(driver, 20);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_globalNav clearfix')]")));
    		Add_Log.info("Global Nav is displayed.");
    		
    		// Wait until Footer Copyright is loaded
    		waits.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_copyright')]")));
    		Add_Log.info("Footer page is displayed.");
    		
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//img[contains(@class, 'followSupIco')])[position()=1]")));
    		
    		WebElement element = driver.findElement(
    				By.xpath("(//img[contains(@class, 'followSupIco')])[position()=1]"));
       		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		Add_Log.info("Follow Me button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Follow Me button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the "Compare Supplier" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickCompareSupplier() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(text(),'Compare Supplier')])[position()=1]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Mouse hover on the image to click on the "Compare Product" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_mousehoverImg_ClickComparePdtBtn() throws Exception{
    	try{
    		// Locate the first image
    		WebElement imgHover = driver.findElement(
    				By.xpath("(//*[contains(@class, 'majorPP_detailCon')]//a)[position()=1]"));
			
    		// Hover mouse above the image but DONT click
    		Actions builder = new Actions(driver);
    		builder.moveToElement(imgHover).build().perform();
    		
    		// Click on the 'Compare Supplier' button.
    		WebElement btnCompSupp = driver.findElement(By.xpath("//*[contains(text(),'Compare Product')]"));
    		btnCompSupp.click();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify the "Follow Me" button in the Product Listing page changed to "(green tick) Following".
    public static WebElement check_btnFollowingWithGreenTickExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isGreenTickExists = driver.findElements(By.xpath("//img[contains(@class,'followSupIco2')]")).size() != 0;
    		Boolean isBtnFollowingExists = driver.findElements(By.xpath("//a[contains(text(),'Following')]")).size() != 0;
    		Add_Log.info("Is green tick icon available on the page ::" + isGreenTickExists);
    		Add_Log.info("Is Following button available on the page" + isBtnFollowingExists);
    		
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
    
	// ====================================================== Start of Footer page section locators =================================================
    
  
    // ======================================================== End of Footer page section locators =================================================

	// =================================================== Start of Advanced Search Filter by section  ==============================================

    // To verify Manufacturer chkbx in Business Types field is selected .
    public static WebElement check_manufacturerChkbxFilterByIsSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadBlockContent")));
    		
    		element = driver.findElement(By.xpath("//*[@value='Manufacturer']"));
    		Boolean isChkbxSelected = element.isSelected();
    		Add_Log.info("Is Manufacturer chkbx in Filter by selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("Manufacturer chkbx in Business Types field is selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FILTER_BY_MANUFACTURER_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Manufacturer chkbx in Business Types field is NOT selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FILTER_BY_MANUFACTURER_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify Manufacturer chkbx in Quick Filter field is selected .
    public static WebElement check_manufacturerChkbxQuickFilterSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.name("qk_bustype"));
    		Boolean isChkbxSelected = element.isSelected();
    		Add_Log.info("Is Manufacturer chkbx in Quick Filters selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("Manufacturer chkbx in Quick Filters is selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_QUICK_FILTERS_MANUFACTURER_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Manufacturer chkbx in Quick Filters is NOT selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_QUICK_FILTERS_MANUFACTURER_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify selected filter contains "Manufacturer" keyword
    public static WebElement check_selFilterContainsManufacturer(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'selFilter')]//em"));
    		String actFilter = element.getText();
    		Add_Log.info("Print filtered criteria ::" + actFilter);
    		
    		if(actFilter.contains("Manufacturer")){
    			Add_Log.info("The selected filter contains Manufacturer.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_FILTER_CONTAINS_MANUFACTURER, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The selected filter does NOT contains Manufacturer.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_FILTER_CONTAINS_MANUFACTURER, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify "3 star" chkbx in Supplier Ranking field is selected.
    public static WebElement check_3StarChkbxFilterByIsSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadBlockContent")));;
    		
    		element = driver.findElement(By.xpath("//*[@filter-value='3 star']"));
    		Boolean isChkbxSelected = element.isSelected();
    		Add_Log.info("Is 3 star chkbx in Filter by selected::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("3 star chkbx in Filter by is selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FILTER_BY_3_STAR_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("3 star chkbx in Filter by is NOT selected.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FILTER_BY_3_STAR_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify selected filter contains "3 star" keyword
    public static WebElement check_selFilterContains3Star(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'selFilter')]//em"));
    		String actFilter = element.getText();
    		Add_Log.info("Print filtered criteria ::" + actFilter);
    		
    		if(actFilter.contains("3 Star")){
    			Add_Log.info("The selected filter contains 3 Star");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_FILTER_CONTAINS_3STAR, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The selected filter does NOT contains 3 Star");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_FILTER_CONTAINS_3STAR, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	// ==================================================== End of Advanced Search Filter by section  ===============================================
    
	// =================================================== Start of Compare Product/Supplier section  ===============================================
    
    /**
     * Click on Product tab at Compare Box.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickProductsTabAtCompareBox() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='comTitPP']//strong"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Supplier tab at Compare Box.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement tab_clickSuppliersTabAtCompareBox() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id='comTitSup']//strong"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Compare' button at Products Compare Box.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickCompareAtPdtCompareBox() throws Exception{
    	try{
    		element = driver.findElement(By.id("compareBtnPP")); 
    				
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Compare' button at Suppliers Compare Box.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickCompareAtSuppCompareBox() throws Exception{
    	try{
    		element = driver.findElement(By.id("compareBtnSup"));
    	//	element.sendKeys(Keys.CONTROL +"t");
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	// ==================================================== End of Compare Product/Supplier section  ================================================
    
    /**
     * To click on first Supplier Name Title.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickSupplierNameTitle() throws Exception{
    	try{
    		// comdev.qa	date: 23-Oct-2015
    	//	element = driver.findElement(By.xpath("(//*[contains(@class, 'supplierName_tit')]//a)[position()=1]"));
    		
    		WebDriverWait waits = new WebDriverWait(driver, 20);
    		waits.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("(//a[contains(@class, 'supplierTit')])[position()=1]")));
    		
    		element = driver.findElement(By.xpath("(//a[contains(@class, 'supplierTit')])[position()=1]"));
    		Add_Log.info("Supplier name title is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Supplier name title is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To click on first unverified Supplier Name Title.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUnvSupplierNameTitle() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'unverified_detail')]//a)[position()=1]"));
    		Add_Log.info("Unverified Supplier name title is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified Supplier name title is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To click on first unverified PP SPD.
    public static WebElement lnk_clickUnvPPSPD() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[@id='unverifpparea']//dt//a)[position()=1]"));
    		Add_Log.info("Unverified PP SPD is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified PP SPD is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the Keyword Search results page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_productKWSPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataKeyword) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Product Search: " + dataKeyword + ""));
    		    	
    		if(driver.getTitle().equals("Global Sources - Product Search: " + dataKeyword + "")){
    			Add_Log.info("The Product keyword search result page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_KEYWORD_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The Product keyword search result page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_KEYWORD_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify Product Vertical Keyword Search result page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataSearchKeyword
     * @return
     * @throws Exception
     */
    public static WebElement check_pdtKeywordSearchResultPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataSearchKeyword) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Product Search: " + dataSearchKeyword + ""));
    		
    		if(driver.getTitle().equals("Global Sources - Product Search: " + dataSearchKeyword + "")){
    			Add_Log.info("Product Vertical Keyword Search result page is displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_PDT_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Vertical Keyword Search result page is NOT displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_PDT_SEARCH_RESULT_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * Click on 'Did you mean: xxxxx' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickDidYouMean() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'guessKW')]/a"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify user last viewed page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param pageTitleBeforeLogin
     * @return
     * @throws Exception
     */
    public static WebElement check_lastViewedPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String pageTitleBeforeLogin) throws Exception{
    	try{
    		String pageTitleAfterLogin = driver.getTitle();
    		Add_Log.info("Page Title After Login ::" + pageTitleAfterLogin);
    		
    		if(pageTitleAfterLogin.equals(pageTitleBeforeLogin)){
    			Add_Log.info("User last viewed page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LAST_VIEWED_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("User last viewed page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LAST_VIEWED_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // To verify the Supplier Service icons are matching.
    public static WebElement check_supplierServiceIconsAreMatching(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement elementVerSupp = driver.findElement(By.xpath("//*[@id='___UI_trigger0_verifiedSupPop']/img"));
    		WebElement elementTradeShow = driver.findElement(By.xpath("//*[@id='___UI_trigger0_sfPop']/img"));
    		WebElement elementMagazine = driver.findElement(By.xpath("//*[@id='___UI_trigger0_eMagPop']/img")); 
    		WebElement elementMajorCust = driver.findElement(By.xpath("//*[@id='___UI_trigger0_customerPop']/img"));
    	//	WebElement elementOnlineStore = driver.findElement(By.xpath("//*[@id='___UI_trigger0_storeFrontPop']/img"));
    		
    		Boolean isVerSuppIconExists = elementVerSupp.isDisplayed();
    		Boolean isTradeShowIconExists = elementTradeShow.isDisplayed();
    		Boolean isMagazineIconExists = elementMagazine.isDisplayed();
    		Boolean isMajorCustIconExists = elementMajorCust.isDisplayed();
    	//	Boolean isOnlineStoreIconExists = elementOnlineStore.isDisplayed();
    		
    		Add_Log.info("Is Verified Supplier icon displayed ::" + isVerSuppIconExists);
    		Add_Log.info("Is Trade Show icon displayed ::" + isTradeShowIconExists);
    		Add_Log.info("Is Magazine icon displayed ::" + isMagazineIconExists);
    		Add_Log.info("Is Major Cust icon displayed ::" + isMajorCustIconExists);
    	//	Add_Log.info("Is Online Store icon displayed ::" + isOnlineStoreIconExists);
    		
    		if(isVerSuppIconExists == true && isTradeShowIconExists == true && isMagazineIconExists == true){
    			Add_Log.info("Supplier service icons in Product KWS page are matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Supplier service icons in Product KWS page are NOT matching");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUPP_SERVICE_ICONS_MATCHING, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0,  true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
