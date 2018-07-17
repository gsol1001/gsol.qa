/**
 * This Class contains methods that represent the locators available on Registration Confirmation Page
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
 * Contains methods that represent the locators available on Registration Confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class RegistrationConfirmation_Page extends BaseClass{
	
	private static WebElement element = null;

    public RegistrationConfirmation_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * To verify Registration Confirmation page with DOI reminder overlay is displayed.
     * 
     * @param xls 
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_regConfPage_DOIReminderOverlayDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
            element = driver.findElement(By.id("DOI_overlay"));
            Boolean isDOIReminderOverlayExists = element.isDisplayed();
            
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Product Alert"));
    		    	
    		if((driver.getTitle().equals("Product Alert")) && (isDOIReminderOverlayExists == true)){
    			Add_Log.info("Registration confirmation page with DOI reminder overlay is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONF_PAGE_DOI_OVERLAY_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Registration confirmation page with DOI reminder overlay is NOT displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONF_PAGE_DOI_OVERLAY_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("DOI reminder overlay is NOT found in Registration Confirmation page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify DOI reminder overlay is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_DOIReminderOverlayDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
            element = driver.findElement(By.id("DOI_overlay"));
            Boolean isDOIReminderOverlayExists = element.isDisplayed();
            
    		if(isDOIReminderOverlayExists == true){
    			Add_Log.info("DOI reminder overlay is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_REMINDER_OVERLAY_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("DOI reminder overlay is NOT displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_DOI_REMINDER_OVERLAY_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("DOI reminder overlay is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To click on 'Ok' button on DOI Reminder Overlay.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickDOIReminderOverlay_OkBtn() throws Exception{
    	try{
            element = driver.findElement(By.xpath("//*[contains(@class, 'mt15 tc')]/a"));
            Add_Log.info("Ok button (DOI Reminder Overlay) is click on the page.");
            
    	}catch(Exception e){
    		Add_Log.error("Ok button (DOI Reminder Overlay) is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Registration confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_regConfirmationPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Product Alert"));
    		    	
    		if(driver.getTitle().equals("Product Alert")){
    			Add_Log.info("Registration Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONFIRMATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Registration Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONFIRMATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! Registration Confirmation page is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // To verify copy "Hi {First Name}. Thank you for registering with Global Sources." is available on the page.      
    // To verify copy "The verification email has been sent to {email address}" is available on the page.
    public static WebElement check_regConfHeaderCopyExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataFirstName, String dataBusinessEmail) throws Exception{
    	try{
    		WebElement elementH1 = driver.findElement(By.xpath("//*[contains(@class, 'form_h1')]"
    				+ "[contains(text(), \"Hi " + dataFirstName + ". Thank you for registering with Global Sources.\")]"));
    		WebElement elementH2 = driver.findElement(By.xpath("//*[contains(@class, 'bold mt5')]"
    				+ "[contains(text(), \"The verification email has been sent to " + dataBusinessEmail + "\")]"));
    		Boolean isCopyH1Exists = elementH1.isDisplayed();
    		Boolean isCopyH2Exists = elementH2.isDisplayed();
    		Add_Log.info("Is copy 'Hi {First Name}. Thank you for registering with Global Sources.' exists ::" + isCopyH1Exists);
    		Add_Log.info("Is copy 'The verification email has been sent to {email address}' exists ::" + isCopyH1Exists);
    		
    		if(isCopyH1Exists == true && isCopyH2Exists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONF_PAGE_HEADER_COPY_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONF_PAGE_HEADER_COPY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Registration Confirmation page header copy is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify "You've also requested sourcing magazines." statement exists.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    //*[contains(@class, 'formBox')]//*[contains(text(),\"You've also requested sourcing magazines\")]
    public static WebElement check_reqSourcingMagazinesCopyExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'formBox')]"
    				+ "//*[contains(text(),\"You've also requested sourcing magazines\")]"));
    		Boolean isReqSourcingMagazinesCopyExists = element.isDisplayed();
    		Add_Log.info("Is 'You've also requested sourcing magazines' statement exists ::" + isReqSourcingMagazinesCopyExists);
    		
    		if(isReqSourcingMagazinesCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REQ_SOURCING_MAGAZINES_COPY_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REQ_SOURCING_MAGAZINES_COPY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Copy 'You've also requested sourcing magazines' is NOT displayed.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify "You've also requested sourcing magazines." statement not exists.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_reqSourcingMagazinesCopyNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
		try{			
			Boolean isReqSourcingMagazinesCopyExists = 
					driver.findElements(By.xpath("//*[contains(@class, 'formBox')]"
							+ "//*[contains(text(),\"You've also requested sourcing magazines\")]")).size() != 0;
			Add_Log.info("Is 'You've also requested sourcing magazines' statement exists ::" + isReqSourcingMagazinesCopyExists);
			
			if(isReqSourcingMagazinesCopyExists == true){
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_REQ_SOURCING_MAGAZINES_COPY_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}else{
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_REQ_SOURCING_MAGAZINES_COPY_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);	
			}
		}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify copy "You are now successfully following <supplier name> company." is displayed.
     * 
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
    	/*	element = driver.findElement(By.xpath("//*[contains(@class, 'formMsg_txt')]"
    				+ "[contains(text(),'You are now successfully following (" + suppName + ")')]"));
    		String printText = element.getText();
    		Add_Log.info("Print copy text ::" + printText);		*/
    		
    		Boolean isCopyExists = driver.findElements(By.xpath("//*[contains(@class, 'formMsg_txt')]"
    				+ "[contains(text(), \"You are now successfully following (" + suppName + ")\")]")).size() != 0;
    		Add_Log.info("Copy 'You are now successfully following (" + suppName + ").' is available ::" + isCopyExists);    		
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
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
     * To verify copy "To view - or edit - all the suppliers you're following, click here." is displayed in a yellow color background.
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
    		Boolean isCopyExists = driver.findElements(By.xpath("//*[contains(@class, 'formMsg_txt')]"
    				+ "[contains(text(),\"To view - or edit - all the suppliers you're following\")]"
    				+ "//a[contains(text(),'click here')]")).size() != 0;
    		Add_Log.info("Is copy 'To view - or edit - all the suppliers you're following, click here.' displayed ::" + isCopyExists);
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA categories selected in Select Product Alert Categories page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	try{    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'dotList form_PA_cat')]/li")));
    		
			List<String> displayedCatNameList = new ArrayList<String>();
			for(WebElement element : selectedCategoriesNameList){
				Add_Log.info("displayedCatNameList ::" + element.getText());
				displayedCatNameList.add(element.getText());
			}
			
			// Maximum Product Alert category(s)displayed in Registration confirmation page are Six
			if(checkedCatNameList.containsAll(displayedCatNameList)){				
				Add_Log.info("PA categories selected in Select PA Categories page is displayed in Reg Confirmation page");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_REG_CONF_PAGE, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("PA categories selected in Select PA Categories page is NOT displayed in Reg Confirmation page");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_REG_CONF_PAGE, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify the PA categories selected in PA Catfish Banner is displayed in Registration Confirmation page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param checkedCatNameList
     * @return
     * @throws Exception
     */
    public static WebElement check_PACatSelectedInPACatfishBannerIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> selectedCategoriesNameList = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'dotList form_PA_cat')]/li")));
    		
    		List<String> displayedCatNameList = new ArrayList<String>();
    		for(WebElement element : selectedCategoriesNameList){
    			Add_Log.info("displayedCatNameList ::" + element.getText());
    			displayedCatNameList.add(element.getText());
    		}
    		
    		if(displayedCatNameList.containsAll(checkedCatNameList)){
    			Add_Log.info("PA categories selected in PA Catfish Banner is displayed in Registration Confirmation page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_REG_CONF_PAGE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA categories selected in PA Catfish Banner is NOT displayed in Registration Confirmation page.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SEL_CAT_APPEAR_IN_REG_CONF_PAGE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	
    
    // To verify copy "Save time finding suppliers with TradeMatch" is available on the page.
    public static WebElement check_copyTradeMatchExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isCopyExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'Save time finding suppliers with Trade')]")).size()!= 0;
    		Add_Log.info("Is copy 'Save time finding suppliers with TradeMatch' available ::" + isCopyExists);
    		
        	if(isCopyExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_REG_CONF_PAGE_TRADE_MATCH_COPY_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_REG_CONF_PAGE_TRADE_MATCH_COPY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("Copy 'Save time finding suppliers with TradeMatch' is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify copy "Find other products you might be interested in" is available on the page.
    public static WebElement check_copyProductsInterestedExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isCopyExists = 
    				driver.findElements(By.xpath("//*[contains(text(),'Find other products you might be interested in')]")).size()!= 0;
    		Add_Log.info("Is copy 'find other products you might be interested in' available ::" + isCopyExists);
    		
        	if(isCopyExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_REG_CONF_PAGE_PDT_INTERESTED_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_REG_CONF_PAGE_PDT_INTERESTED_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("Copy 'Find other products you might be interested in' is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify copy "See the latest products & deal directly with manufacturers" is available on the page.
    public static WebElement check_copyTradeShowsExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isCopyExists = driver.findElements(
    				By.xpath("//*[contains(text(),\"See the latest products & deal directly with manufacturers\")]")).size() != 0;
    		Add_Log.info("Is copy 'See the latest products & deal directly with manufacturers' displayed ::" + isCopyExists);
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONF_PAGE_TRADE_SHOWS_COPY_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_REG_CONF_PAGE_TRADE_SHOWS_COPY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'See the latest products & deal directly with manufacturers' is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    
}