/**
 * This Class contains methods that represent the locators available on eMag Preference Page.
 * Created: Tue 14 July 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/14
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
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
 * Contains methods that represent the locators available on eMag Preference page.
 * @author Teng Shyh Wei
 *
 */
public class eMag_Preference_Page extends BaseClass{

	private static WebElement element = null;
	public static boolean Testfail = false;
	
    public eMag_Preference_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify eMag Preference page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagPreferencePageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Sourcing Magazines"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Sourcing Magazines")){
    			Add_Log.info("eMag Preference page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_PREFERENCE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("eMag Preference page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_PREFERENCE_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! eMag Preference page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify eMag Preference page is displayed.
    public static WebElement check_eMagPreferencePageDisplayed() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 20);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Sourcing Magazines"));
    		    	
    		if(driver.getTitle().equals("Global Sources - Sourcing Magazines")){
    			Add_Log.info("eMag Preference page is displayed.");
    		}else{
    			Add_Log.info("eMag Preference page is NOT displayed.");
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! eMag Preference page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Subscribe Now' button on any eMag title (e.g: Mobile Electronics).
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubscribeNow() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'mzItemDl')]//a[contains(text(),'Subscribe Now')])[position()=1]"));
    		Add_Log.info("Subscribe Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Subscribe Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Download PDF' button on any eMag title.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickDownloadPDF(String selecteMagTitle) throws Exception{
    	try{
    	//	element = driver.findElement(By.xpath("(//a[contains(@class, 'mzPdf')])[position()=1]"));
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'mzItemDl')]//h3//a[text()='" + selecteMagTitle + "']"));
    		Add_Log.info("Download PDF button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Download PDF button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the 'Subscribe Now' button become '[tick]Subscribed'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement  check_msgSubscribedWithIconTickExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgExists = driver.findElement(
    				By.xpath("//*[contains(@class, 'mzItemDl')]//Strong[contains(text(), 'Subscribed')]")).isDisplayed();
    		Add_Log.info("Is 'Subscribe Now' button become '[tick]Subscribed' ::" + isMsgExists);
    		
    		if(isMsgExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUBS_WITH_TICK_ICON_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SUBS_WITH_TICK_ICON_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Subsribed button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Locate and click on the all the 'Unsubscribe' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickUnsubscribe() throws Exception{
    	try{
    		// Wait for the expected page title
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Global Sources - Sourcing Magazines"));
    		
    		List<String> hrefs = new ArrayList<String>();
    		List<WebElement> links = driver.findElements(By.xpath("//a[contains(text(),'Unsubscribe')]"));
    		
    		Iterator<WebElement> i = links.iterator();
    		while(i.hasNext()){
    			WebElement link = i.next();
    			hrefs.add(link.getAttribute("href"));
    		}
    		
    		Iterator<String> j = hrefs.iterator();
    		while(j.hasNext()){
    			@SuppressWarnings("unused")
    			String href = j.next();
    			WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Unsubscribe')]"));
    			link.click();
    		}
    		Add_Log.info("Unsubscribe button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Unsubscribe button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the selected eMag is displayed in new tab.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataeMagTitle
     * @return
     * @throws Exception
     */
    public static WebElement check_selectedeMagDisplayedInNewTab(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataeMagTitle) throws Exception{
    	try{
			String eMagTitle = dataeMagTitle.trim();
			Add_Log.info("Input data eMag Title is ::" + eMagTitle);
			
			if(eMagTitle.equalsIgnoreCase("Auto Parts & Accessories")){
				if(driver.getTitle().equals("Auto Parts & Accessories - Auto_Parts_&_Accessories.PDF")){
					Add_Log.info("Auto Parts & Accessories is displayed in new tab.");
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Computer Products")){
				if(driver.getTitle().equals("Computer Products - Computer_Products.PDF")){
					Add_Log.info("Computer Products is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
						
			if(eMagTitle.equalsIgnoreCase("Consumer Electronics")){
				if(driver.getTitle().equals("Electronics - Consumer_Electronics.PDF")){
					Add_Log.info("Consumer Electronics is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			// MR 44774
			if(eMagTitle.equalsIgnoreCase("Electronic Components")){
			//	if(driver.getTitle().equals("Gifts & Premiums - Electronic_Components.PDF")){
				if(driver.getTitle().equals("Electronic_Components.PDF")){
					Add_Log.info("Electronic Components is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Fashion Accessories & Footwear")){
				if(driver.getTitle().equals("Fashion Accessories - Fashion_Accessories.PDF")){
					Add_Log.info("Fashion Accessories & Footwear is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Fashion Apparel & Fabrics")){
				if(driver.getTitle().equals("Garments & Textiles - Garments_&_Textiles.PDF")){
					Add_Log.info("Fashion Apparel & Fabrics is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Gifts & Premiums")){
				if(driver.getTitle().equals("Gifts & Premiums - Gifts_&_Premiums.PDF")){
					Add_Log.info("Gifts & Premiums is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Hardware & DIY")){
				if(driver.getTitle().equals("Hardware & DIY - Hardware_&_DIY.PDF")){
					Add_Log.info("Hardware & DIY is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Home Products")){
				if(driver.getTitle().equals("Home Products - Home_Products.PDF")){
					Add_Log.info("Home Products is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("India Products")){
				if(driver.getTitle().equals("India Products - India_Products.PDF")){
					Add_Log.info("India Products is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Korea Products (quarterly)")){
				if(driver.getTitle().equals("Korea Products - Korea_Products.PDF")){
					Add_Log.info("Korea Products (quarterly) is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Machinery & Industrial Supplies")){
				if(driver.getTitle().equals("Machinery & Industrial Supplies - Machinery_&_Industrial_Supplies.PDF")){
					Add_Log.info("Machinery & Industrial Supplies is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Mobile Electronics")){
				if(driver.getTitle().equals("Computer Products - Mobile_Electronics.PDF")){
					Add_Log.info("Mobile Electronics is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Security Products")){
				if(driver.getTitle().equals("Security Products - Security_Products.PDF")){
					Add_Log.info("Security Products is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Solar & Energy Saving Products")){
				if(driver.getTitle().equals("Solar & Energy Saving Products - Solar_&_Energy_Saving_Products.PDF")){
					Add_Log.info("Solar & Energy Saving Products is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(eMagTitle.equalsIgnoreCase("Telecom Products")){
				if(driver.getTitle().equals("Telecom Products - Telecom_Products.PDF")){
					Add_Log.info("Telecom Products is displayed in new tab.");
				}else{
					Testfail = true;
				}
			}
			
			if(Testfail){
				Add_Log.info("Selected eMag is NOT displayed in new tab.");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SEL_EMAG_DISPLAYED_IN_NEW_TAB, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
			}else{
				Add_Log.info("Selected eMag is displayed in new tab.");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_SEL_EMAG_DISPLAYED_IN_NEW_TAB, rowNum, Constant.KEYWORD_PASS);
			}
			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the eMag title selected in Registration form are displayed in "Magazine(s) Subscribed" section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedeMagNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagTitleSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, List<String> checkedeMagNameList) throws Exception{
    	try{
    		//*[contains(@class, 'mzSubBox mt40')]//*[contains(@class, 'mzItemDl')]//h3
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedeMagTitleList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'mzSubBox mt40')]//dt//a")));
    		
			ArrayList<String> displayedeMagTitleList = new ArrayList<String>();
			for (WebElement element : selectedeMagTitleList){
				Add_Log.info("displayedeMagTitleList ::" + element.getText());
				displayedeMagTitleList.add(element.getText());
				Add_Log.info("Displayed eMag ::" + displayedeMagTitleList);
			}
			
			Add_Log.info("displayed list ::" + displayedeMagTitleList);
			Add_Log.info("selected list ::" + checkedeMagNameList);
			
			if(displayedeMagTitleList.equals(checkedeMagNameList)){				
				Add_Log.info("The eMag title selected in Registration form are displayed in 'Magazine(s) Subscribed' section");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_EMAG_TITLE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The eMag title selected in Registration form are NOT displayed in 'Magazine(s) Subscribed' section");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_EMAG_TITLE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the eMag title selected in pre-req and registration form are displayed in "Magazine(s) Subscribed" section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedeMagLiteList
     * @param checkedeMagNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagTitleSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, List<String> checkedeMagLiteList, List<String> checkedeMagNameList) throws Exception{
    	try{
    		//*[contains(@class, 'mzSubBox mt40')]//*[contains(@class, 'mzItemDl')]//h3
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedeMagTitleList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'mzSubBox mt40')]//dt//a")));
    		
			ArrayList<String> displayedeMagTitleList = new ArrayList<String>();
			for (WebElement element : selectedeMagTitleList){
				Add_Log.info("displayedeMagTitleList ::" + element.getText());
				displayedeMagTitleList.add(element.getText());
				Add_Log.info("Displayed eMag ::" + displayedeMagTitleList);
			}
			
			Add_Log.info("selected eMag lite ::" + checkedeMagLiteList);
			Add_Log.info("selected eMag title ::" + checkedeMagNameList);
			Add_Log.info("displayed list ::" + displayedeMagTitleList);
			
			if(displayedeMagTitleList.containsAll(checkedeMagLiteList) && displayedeMagTitleList.containsAll(checkedeMagNameList)){		
				Add_Log.info("The eMag title selected in Registration form are displayed in 'Magazine(s) Subscribed' section");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_PRE_REQ_EMAG_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The eMag title selected in Registration form are NOT displayed in 'Magazine(s) Subscribed' section");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_PRE_REQ_EMAG_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify all the eMag titles are not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_alleMagTitleNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		//*[contains(@class, 'mzSubBox mt40')]//*[contains(text(),'0 monthly e-magazine')]
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'mzSubBox mt40')]//*[contains(text(),'0 e-magazine')]"));
    		Boolean alleMagTitleNotSelected = element.isDisplayed();
    		Add_Log.info("All the eMag titles are not selected is true::" + alleMagTitleNotSelected);
    		
    		if(alleMagTitleNotSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_EMAG_TITLES_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_EMAG_TITLES_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Copy 'You are currently subscribed to 0 e-magazine.' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify eMag title added is displayed in "Magazine(s) Subscribed" section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param addedEmagTitle
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagTitleSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String addedEmagTitle) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedeMagTitleList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'mzSubBox mt40')]//dt//a")));
    		
			ArrayList<String> displayedeMagTitleList = new ArrayList<String>();
			for (WebElement element : selectedeMagTitleList){
				Add_Log.info("displayedeMagTitleList ::" + element.getText());
				displayedeMagTitleList.add(element.getText());
				Add_Log.info("Displayed eMag ::" + displayedeMagTitleList);
			}
			
			Add_Log.info("displayed list ::" + displayedeMagTitleList);
			Add_Log.info("selected eMag ::" + addedEmagTitle);
			
			if(displayedeMagTitleList.contains(addedEmagTitle)){				
				Add_Log.info("The eMag title added is displayed in 'Magazine(s) Subscribed' section");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_EMAG_TITLE_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The eMag title added is NOT displayed in 'Magazine(s) Subscribed' section");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_EMAG_TITLE_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		Add_Log.error("Error! The eMag title added is NOT displayed in 'Magazine(s) Subscribed' section."); 
    		throw(e);
    	}
    	return element;
    }

}
