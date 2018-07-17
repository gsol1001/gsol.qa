/**
 * This Class contains methods that represent the locators available on SA Edit Suppliers Page.
 * Created: Fri 25 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/25
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on SA Edit Suppliers page.
 * @author Teng Shyh Wei
 *
 */
public class SA_EditSuppliers_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public SA_EditSuppliers_Page(WebDriver driver){
        	super(driver);
    }
    
	/**
	 * To verify SA Edit Supplier page is displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_SAEditSuppliersPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.titleIs("Product Alert - Edit Supplier Alert"));
    		    	
    		if(driver.getTitle().equals("Product Alert - Edit Supplier Alert")){
    			Add_Log.info("SA Edit Suppliers page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_EDIT_SUPP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("SA Edit Suppliers page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_EDIT_SUPP_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}   
    	}catch(Exception e){
    		Add_Log.error("Error! SA Edit Suppliers page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the Following's Supplier name is added into "Verified suppliers" section
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param suppName
     * @return
     * @throws Exception
     */
    public static WebElement check_followingSuppAddedToVerSuppSection(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String suppName) throws Exception{
    	try{
    	/*	WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> verSupp = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[@id='subscribedList']//a")));
    		
			List<String> followingVerSuppList = new ArrayList<String>();
			for (WebElement element : verSupp){
				Add_Log.info("displayedCatNameList ::" + element.getText());
				followingVerSuppList.add(element.getText());
			}
		*/	

			WebElement suppElement = driver.findElement(By.xpath("//*[contains(@class, 'SAtable mt5')]//a"));
			String followingVerSupp = suppElement.getText();
			Add_Log.info("Print following Verified suppliers ::" + followingVerSupp);
			
			if(followingVerSupp.contains(suppName)){
				Add_Log.info("The following's Supplier name is added into Verified suppliers section");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_FOLLOWING_SUPP_ADDED_TO_VER_SUPP_SECTION, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The following's Supplier name is NOT added into Verified suppliers section");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_FOLLOWING_SUPP_ADDED_TO_VER_SUPP_SECTION, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}    		
    	}catch(Exception e){
    		Add_Log.error("Verified suppliers section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify the Following's Supplier name is added into Supplier Alert
    public static WebElement check_followingSuppAddedToSupplierAlert(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String suppName) throws Exception{    	
    	try{    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		List<WebElement> verSupp = wait.
    				until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
    						By.xpath("//*[contains(@class, 'SAtable mt5')]//a")));
    		
			List<String> followingVerSuppList = new ArrayList<String>();
			for (WebElement element : verSupp){
				Add_Log.info("displayedVerSuppList ::" + element.getText());
				followingVerSuppList.add(element.getText());
			}
			
			if(followingVerSuppList.contains(suppName)){
				Add_Log.info("The following's Supplier name is added into Verified suppliers section");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_FOLLOWING_SUPP_ADDED_TO_VER_SUPP_SECTION, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The following's Supplier name is NOT added into Verified suppliers section");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_FOLLOWING_SUPP_ADDED_TO_VER_SUPP_SECTION, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		Add_Log.error("Error! The following's Supplier name is NOT found on Supplier Alert page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Select all' checkbox for Verified Exhibitor.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_checkSelectAllVerExhibitor() throws Exception{
    	try{
    		element = driver.findElement(By.id("selectUpcomingCSFSupplier"));
    		Add_Log.info("Select all chkbx is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Select all chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Verified Exhibitor 'Remove' button and click on Ok button to accept the alert.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRemoveVerExhibitor_ClickOkBtn() throws Exception{
    	try{
    		driver.findElement(By.id("link_upcoming")).click();
    		
    		// Get a handle to the open alert, prompt or confirmation
    		Alert alert = driver.switchTo().alert();
    		
    		// Accept the alert - equivalent of pressing OK
    		alert.accept();
    		
    	}catch(Exception e){
    		Add_Log.error("Verified Exhibitor Remove button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Select all' checkbox for Verified Suppliers.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_checkSelectAllVerSupp() throws Exception{
    	try{
    		element = driver.findElement(By.id("selectAllVerifyAupplier"));
    		Add_Log.info("User is click on 'Select all' checkbox for Verified Suppliers section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'Select all' checkbox for Verified Suppliers section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Select all' checkbox on verified suppliers section is checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selectAllChkbxOnVerSuppIsSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.id("selectAllVerifyAupplier"));
    		Boolean isChkbxSelected = element.isSelected();
    		Add_Log.info("Is 'Select all' chkbx for verified suppliers selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_ALL_CHKBX_VER_SUPP_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_ALL_CHKBX_VER_SUPP_CHECKED, rowNum, Constant.KEYWORD_PASS);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("'Select all' checkbox on verified suppliers section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Verified Suppliers 'Remove' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRemove() throws Exception{
    	try{
    		element = driver.findElement(By.id("link_save"));
    		Add_Log.info("Remove button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Remove button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Verified Suppliers 'Remove' button and click on Ok button to accept the alert.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRemoveVerSupp_ClickOkBtn() throws Exception{
    	try{
    		driver.findElement(By.id("link_save")).click();
    		
    		// Get a handle to the open alert, prompt or confirmation
    		Alert alert = driver.switchTo().alert();    		
    		
    		// Accept the alert - equivalent of pressing OK
    		alert.accept();
    		
    	}catch(Exception e){
    		Add_Log.error("Verified Suppliers section 'Remove' button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify a popup window with message "Are you sure you want to stop following the x selected supplier(s)?" is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_alertMsgStopFollowSuppExists_ClickOKBtn(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		
    		// Get a handle to open alert, prompt for confirmation
    		Alert alert = driver.switchTo().alert();
    		
    		// Get pop up window message
    		String popupMessage = alert.getText();
    		Add_Log.info("Pop up window message ::" + popupMessage);
    		    		
    		String expectedMessage = "Are you sure you want to stop following the  1   selected supplier(s)?";
    		
    		// To verify a pop up window with message "Are you sure you want to stop following the x selected supplier(s)?" is displayed.
    		if(popupMessage.equals(expectedMessage)){
    			Add_Log.info("Pop up window with message 'Are you sure you want to stop following the x selected supplier(s)?' is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_FOLLOW_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Pop up window with message 'Are you sure you want to stop following the x selected supplier(s)?' is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_FOLLOW_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    		
    		// Accept the alert = equivalent of pressing OK
    		alert.accept();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify SA Edit Suppliers confirmation page with message 
     * "You have successfully removed the suppliers from your Supplier Alert updates." is displayed. 
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgSuccessfullyRemovedSuppliersExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector((".paSAEditUpdMsg")));
    		String printMsg = element.getText();
    		String expMsg = "You have successfully removed the suppliers from your Supplier Alert updates.";
    		Add_Log.info("Print SA Edit Suppliers confirmation page message ::" + printMsg);
    		
    		if(printMsg.equals(expMsg)){
    			Add_Log.info("SA Edit Suppliers confirmation page with message "
    					+ "'You have successfully removed the suppliers from your Supplier Alert updates.' is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUCCESSFUL_REMOVED_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("SA Edit Suppliers confirmation page with message "
    					+ "'You have successfully removed the suppliers from your Supplier Alert updates.' is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_SUCCESSFUL_REMOVED_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Message 'You gave successfullt removed the suppliers from your Supplier Alert updates.' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify the copy "Number of suppliers you are currently following: 0" is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_copyNoFollowingSuppIsExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("(//*[contains(@class, 'userProfile_con')]//table//table//td)[position()=1]"));
    		String getText = element.getText();
    		Add_Log.info("Print text ::" + getText);
    		
    		String expText = "Number of suppliers you are currently following: 0";
    		if(getText.equalsIgnoreCase(expText)){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_ZERO_FOLLOWING_SUPP_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COPY_ZERO_FOLLOWING_SUPP_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Copy 'Number of suppliers you are currently following: 0' is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Select all' checkbox for Unverified Suppliers.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_checkSelectAllUnvSupp() throws Exception{
    	try{
    		element = driver.findElement(By.id("selectAllUnVerifySupplier"));
    		Add_Log.info("User is click on 'Select all' checkbox for Unverified Suppliers section.");
    		
    	}catch(Exception e){
    		Add_Log.error("'Select all' checkbox for Unverified Suppliers section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify 'Select all' checkbox on other suppliers section is checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_selectAllChkbxOnUnvSuppIsSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.id("selectAllUnVerifySupplier"));
    		Boolean isChkbxSelected = element.isSelected();
    		Add_Log.info("Is 'Select all' chkbx on other supplier selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_ALL_CHKBX_UNV_SUPP_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SELECT_ALL_CHKBX_UNV_SUPP_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("'Select all' checkbox on other suppliers section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on Unverified Suppliers 'Remove' button and click Ok button to accept the alert.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRemoveUnvSupp_ClickOkBtn() throws Exception{
    	try{
    		driver.findElement(By.id("link_save_bottom")).click();
    		
    		// Get a handle to the open alert, prompt or confirmation
    		Alert alert = driver.switchTo().alert();    		
    		
    		// Accept the alert - equivalent of pressing OK
    		alert.accept();
    		
    	}catch(Exception e){
    		Add_Log.error("Unverified Suppliers section Remove button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To clean up SA Suppliers if available on the page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_clearSASuppliers() throws Exception{
    	try{    		
    		// To check if following verified exhibitors available on the page.
    		Boolean isVerExhibitorsExists = 
    				driver.findElements(By.id("selectUpcomingCSFSupplier")).size() != 0;
    		Add_Log.info("Is following Verified Exhibitors available ::" + isVerExhibitorsExists);
    		if(isVerExhibitorsExists == true){
    			
    			// Select all Verified Exhibitor checkboxes
    			SA_EditSuppliers_Page.chkbx_checkSelectAllVerExhibitor().click();
    			    			
    			// Click on 'Remove' button
    			SA_EditSuppliers_Page.btn_clickRemoveVerExhibitor_ClickOkBtn();    			
    			
    		}
    		
    		// To check if following verified suppliers available on the page.
    		Boolean isVerSuppExists = 
    				driver.findElements(By.id("selectAllVerifyAupplier")).size() != 0;
        	Add_Log.info("Is following Verified Suppliers available ::" + isVerSuppExists);              	
        	if(isVerSuppExists == true){
        		
        		// Select all Verified Suppliers checkboxes
        		SA_EditSuppliers_Page.chkbx_checkSelectAllVerSupp().click();
        		
        		// Click on 'Remove' button
        		SA_EditSuppliers_Page.btn_clickRemoveVerSupp_ClickOkBtn();	
        		
        	}
        	
        	// To check if following unverified suppliers available on the page.
    		Boolean isUnvSuppExists = 
    				driver.findElements(By.id("selectAllUnVerifySupplier")).size() != 0;
        	Add_Log.info("Is following Unverified Suppliers available ::" + isUnvSuppExists);
        	if(isUnvSuppExists == true){
        		       
        		// Select all Unverified Suppliers checkboxes
        		SA_EditSuppliers_Page.chkbx_checkSelectAllUnvSupp().click();
        		
        		// Click on 'Remove' button
        		SA_EditSuppliers_Page.btn_clickRemoveUnvSupp_ClickOkBtn();
        		
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
   
}
