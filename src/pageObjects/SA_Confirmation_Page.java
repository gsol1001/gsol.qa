/**
 * This Class contains methods that represent the locators available on SA Confirmation Page.
 * Created: Fri 02 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/02
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

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on SA Confirmation page.
 * @author Teng Shyh Wei
 *
 */
public class SA_Confirmation_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public SA_Confirmation_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * To verify SA Confirmation page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_SAConfPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    	//	WebDriverWait waits = new WebDriverWait(driver, 15);
    	//	waits.until(ExpectedConditions.titleIs("Supplier Alert - Confirmation"));
    	//	waits.until(ExpectedConditions.numberOfWindowsToBe(2));
    		
    		if(driver.getTitle().equals("Supplier Alert - Confirmation")){
    			Add_Log.info("SA Confirmation page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_CONFIRMATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("SA Confirmation page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_CONFIRMATION_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		Add_Log.error("Error! SA Confirmation page is NOT displayed.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size()); 
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify copy "Hi <First name>. You are now successfully following <supplier name> company." is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param firstName
     * @param suppName
     * @return
     * @throws Exception
     */
    public static WebElement check_copySuccFollowingSuppExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String firstName, String suppName) throws Exception{
    	try{
    		Boolean isCopyExists = driver.findElements(By.xpath("//*[contains(@class, 'paEditUpdMsg2')]"
    				+ "[contains(text(), \"Hi " + firstName + ". You are now successfully following " + suppName + "\")]")).size() != 0;
    		Add_Log.info("Copy 'Hi " + firstName + ". "
    				+ "You are now successfully following " + suppName + " company.' is available ::" + isCopyExists);
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'Hi <First name>. You are now successfully following <supplier name> company' is NOT found on the page.");
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
    		WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'paEditUpdMsg2')]"));
    		String getText = element.getText();
    		Add_Log.info("Print text ::" + getText);
    		
    		// Supplier's name may contains hyphen
    		Boolean isCopyExists = driver.findElements(By.xpath("//*[contains(@class, 'paEditUpdMsg2')]"
    				+ "[contains(text(),\"You are now successfully following " + suppName + "\")]")).size() != 0;
    		Add_Log.info("Copy 'You are now successfully following " + suppName + ".' is available ::" + isCopyExists);
    		
    		if(isCopyExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_SUCC_FOLLOWING_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'You are now successfully following <supplier name> company' is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size()); 
    		throw(e);
    	}
    	return element;
    }  
    
    /**
     * To verify copy "To view - or edit - all the the suppliers you're following, click here" is displayed.
     * Applied to test case 27E.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgViewEditSuppExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//tbody//td[2]"));
    		String getText = element.getText();    		
    		String expectedCopy = "To view - or edit - all the the suppliers you're following, click here.";
    		Add_Log.info("Print text ::" + getText);
    		
    		if(getText.contains(expectedCopy)){
    			Add_Log.info("copy 'To view - or edit - all the the suppliers you're following, click here' is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("copy 'To view - or edit - all the the suppliers you're following, click here' is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_VIEW_EDIT_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'To view - or edit - all the the suppliers you're following, click here' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify copy "To view - or edit - all the the suppliers you're following, click here" is displayed.
     * Applied to test case 27F.
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
    		Boolean isCopyExists = driver.findElements(
    				By.xpath("//*[contains(text(),\"To view  - or  edit  - all the the suppliers you're following\")]"
    						+ "//a[contains(text(),'click here')]")).size() != 0;
    		Add_Log.info("Is copy 'To view  - or  edit  - all the the suppliers you're following, click here.' displayed ::" + isCopyExists);
    	
    		WebElement element = driver.findElement(
    				By.xpath("//*[contains(text(),\"To view  - or  edit  - all the the suppliers you're following\")]"
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
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'To view - or edit - all the the suppliers you're following, click here' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify "click here" is a hyperlink.
     * 
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
    		Add_Log.info("Click here hyperlink is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on the 'click here' link in SA copy.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickOnClickHere() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'click here')]"));
    		Add_Log.info("Click here link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Click here link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
