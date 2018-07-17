/**
 * This Class contains methods that represent the locators available on PA Settings Page
 * Created: Fri 19 June 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/06/19
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

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
 * Contains methods that represent the locators available on PA Settings page.
 * @author Teng Shyh Wei
 *
 */
public class PA_Settings_Page extends BaseClass{
	
	private static WebElement element = null;
    
    public PA_Settings_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Product Alert - Settings page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PASettingsPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		    		
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Alerts - Settings"));
    		    	
    		if(driver.getTitle().equals("Alerts - Settings")){
    			Add_Log.info("PA Settings page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Settings page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Error! PA Settings page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * If the Products Alerts, News Alerts and Supplier Alerts settings are not checked, checked on the checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectAll() throws Exception{
    	try{
    	//	List<WebElement> chkbxAlerts = driver.findElements(By.xpath("//input[@type='checkbox']"));
    		List<WebElement> chkbxAlerts = driver.findElements(
    				By.xpath("//*[contains(@class, 'userProfile_con')]//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxAlerts){
    			if(!chkbx.isSelected())
    				chkbx.click();
    		}
    		
    	}catch(Exception e){
    		Add_Log.error("Checkboxes in PA Settings page is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * Uncheck all checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_unselectAll() throws Exception{
    	try{
    		List<WebElement> chkbxAlerts = driver.findElements(By.xpath("//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxAlerts){
    			if(chkbx.isSelected())
    				chkbx.click();
    		}
    		
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * Uncheck 'Product Alerts' checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_uncheckProductAlerts() throws Exception{
    	try{
    		WebElement chkbx = driver.findElement(By.name("product_email_on_add"));
    		if(chkbx.isSelected()){
    			chkbx.click();
    		}
    	}catch(Exception e){
    		Add_Log.error("Product Alerts checkbox is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * Uncheck 'News Alerts' checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_uncheckNewsAlerts() throws Exception{
    	try{
    		WebElement chkbx = driver.findElement(By.name("article_email_on_add"));
    		if(chkbx.isSelected()){
    			chkbx.click();
    		}
    	}catch(Exception e){
    		Add_Log.error("News Alerts checkbox is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * Uncheck 'Supplier Alerts' checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_uncheckSupplierAlerts() throws Exception{
    	try{
    		WebElement chkbx = driver.findElement(By.name("supplier_email_on_add"));
    		if(chkbx.isSelected()){
    			chkbx.click();
    		}
    	}catch(Exception e){
    		Add_Log.error("Supplier Alerts checkbox is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * Click on 'Update' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickUpdate() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@value='Update']"));
    		Add_Log.info("Update button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Update button is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify The Product Alert settings page is displayed with 'You have updated your settings successfully.' copy is seen.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgUpdateSuccessfullyIsSeen(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgExists = driver.findElements(By.xpath("//*[contains(@class, 'paEditUpdMsg4')]"
    				+ "//*[contains(text(),'You have updated your settings successfully')]")).size() !=0;
    		Add_Log.info("Is 'You have updated your settings successfully' copy seen ::" + isMsgExists);
    		
    		if(isMsgExists==true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_UPD_SETTINGS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_UPD_SETTINGS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PA settings page is NOT displayed with 'You have updated your setting successfully' copy.");
    		throw(e);
    	}
    	return element;
    }
    
/*    // To verify a 'Are you sure you want to stop receiving Product Alerts, News Alerts and Supplier Alerts?' copy is seen. 
    public static WebElement check_msgStopAlertsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving "
    						+ "Product Alerts,News Alerts and Supplier Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving Product Alerts, "
    				+ "News Alerts and Supplier Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		if(isMsgStopAlertsExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_ALERTS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_ALERTS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }	
    
    // To verify a 'Are you sure you want to stop receiving Product Alerts?' copy is seen.
    public static WebElement check_msgStopReceivingPAExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving Product Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving Product Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		if(isMsgStopAlertsExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_REC_PA_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_REC_PA_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    // To verify a 'Are you sure you want to stop receiving News Alerts?' copy is seen.
    public static WebElement check_msgStopReceivingNewsAlertsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving News Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving News Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		if(isMsgStopAlertsExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_NEWS_ALERT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_NEWS_ALERT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    // To verify a 'Are you sure you want to stop receiving Supplier Alerts?' copy is seen.
    public static WebElement check_msgStopReceivingSAExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving Supplier Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving Supplier Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		if(isMsgStopAlertsExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_REC_SA_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_MSG_STOP_REC_SA_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
*/    
    /**
     * To verify there should be 2 radio buttons options:
     * <p><ul>
     * <li>'Good idea. Take me to Edit Categories page.'
     * <li>'Thanks, but please proceed with unsubscribe.'
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_twoRdbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRadbtnSubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='N']")).size() != 0;
    		Boolean isRadbtnUnsubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='Y']")).size() != 0;
    		Add_Log.info("Is radio button subscribe option exists ::" + isRadbtnSubsExists);
    		Add_Log.info("Is radio button unsubscribe option exists ::" + isRadbtnUnsubsExists);
    		
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb']/parent::*"));
    		String radbtnLabel = element.getText();
    		
    		String expRadbtnSubs = "Good idea. Take me to Edit Categories page.";
    		String expRadbtnUnsubs = "Thanks, but please proceed with unsubscribe.";
    		
    		if(isRadbtnSubsExists == true && isRadbtnUnsubsExists == true 
    				&& radbtnLabel.contains(expRadbtnSubs) && radbtnLabel.contains(expRadbtnUnsubs)){
        		Add_Log.info("There are 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_TWO_RADIO_BTN_OPTIONS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("There are NO 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_TWO_RADIO_BTN_OPTIONS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}    		
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify there should be 2 radio buttons options:
     * <p><ul>
     * <li>'Good idea. Take me to Edit Suppliers page.'
     * <li>'Thanks, but please proceed with unsubscribe all.'
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_twoRadbtOptionsAvailable(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRadbtnSubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='N']")).size() != 0;
    		Boolean isRadbtnUnsubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='Y']")).size() != 0;
    		Add_Log.info("Is radio button subscribe option exists ::" + isRadbtnSubsExists);
    		Add_Log.info("Is radio button unsubscribe option exists ::" + isRadbtnUnsubsExists);
    		
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb']/parent::*"));
    		String radbtnLabel = element.getText();
    		Add_Log.info("Radbtn label name ::" + radbtnLabel);
    		String expRadbtnSubs = "Good idea. Take me to Edit Suppliers page.";
    		String expRadbtnUnsubs = "Thanks, but please proceed with unsubscribe all.";
    		
    		if(isRadbtnSubsExists == true && isRadbtnUnsubsExists == true 
    				&& radbtnLabel.contains(expRadbtnSubs) && radbtnLabel.contains(expRadbtnUnsubs)){
        		Add_Log.info("There are 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_TWO_RADIO_BTN_OPTIONS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("There are NO 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_TWO_RADIO_BTN_OPTIONS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}   
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify a 'Are you sure you want to stop receiving Product Alerts, News Alerts and Supplier Alerts?' copy is seen. 
     * To verify there should be 2 radio buttons options:
     * <p><ul>
     * <li>'Good idea. Take me to Edit Categories page.'
     * <li>'Thanks, but please proceed with unsubscribe.'
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgStopAllAlertsSeen_RdbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving "
    						+ "Product Alerts,News Alerts and Supplier Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving Product Alerts, "
    				+ "News Alerts and Supplier Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		Boolean isRadbtnSubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='N']")).size() != 0;
    		Boolean isRadbtnUnsubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='Y']")).size() != 0;
    		Add_Log.info("Is radio button subscribe option exists ::" + isRadbtnSubsExists);
    		Add_Log.info("Is radio button unsubscribe option exists ::" + isRadbtnUnsubsExists);
    		
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb']/parent::*"));
    		String radbtnLabel = element.getText();
    		
    		String expRadbtnSubs = "Good idea. Take me to Edit Categories page.";
    		String expRadbtnUnsubs = "Thanks, but please proceed with unsubscribe.";
    		
    		if(isMsgStopAlertsExists == true && isRadbtnSubsExists == true && isRadbtnUnsubsExists == true 
    				&& radbtnLabel.contains(expRadbtnSubs) && radbtnLabel.contains(expRadbtnUnsubs)){
        		Add_Log.info("There are 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_ALERT_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("There are NO 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_ALERT_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		} 
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify a 'Are you sure you want to stop receiving Product Alerts?' copy is seen.
     * To verify there should be 2 radio buttons options:
     * <p><ul>
     * <li>'Good idea. Take me to Edit Categories page.'
     * <li>'Thanks, but please proceed with unsubscribe.'
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgStopPASeen_RadbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving Product Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving Product Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		Boolean isRadbtnSubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='N']")).size() != 0;
    		Boolean isRadbtnUnsubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='Y']")).size() != 0;
    		Add_Log.info("Is radio button subscribe option exists ::" + isRadbtnSubsExists);
    		Add_Log.info("Is radio button unsubscribe option exists ::" + isRadbtnUnsubsExists);
    		
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb']/parent::*"));
    		String radbtnLabel = element.getText();
    		
    		String expRadbtnSubs = "Good idea. Take me to Edit Categories page.";
    		String expRadbtnUnsubs = "Thanks, but please proceed with unsubscribe.";
    		
    		if(isMsgStopAlertsExists == true && isRadbtnSubsExists == true && isRadbtnUnsubsExists == true 
    				&& radbtnLabel.contains(expRadbtnSubs) && radbtnLabel.contains(expRadbtnUnsubs)){
        		Add_Log.info("There are 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_PA_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("There are NO 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_PA_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		} 
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify a 'Are you sure you want to stop receiving News Alerts?' copy is seen.
     * To verify there should be 2 radio buttons options:
     * <p><ul>
     * <li>'Good idea. Take me to Edit Categories page.'
     * <li>'Thanks, but please proceed with unsubscribe.'
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgStopNewsAlertsSeen_RadbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving News Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving News Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		Boolean isRadbtnSubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='N']")).size() != 0;
    		Boolean isRadbtnUnsubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='Y']")).size() != 0;
    		Add_Log.info("Is radio button subscribe option exists ::" + isRadbtnSubsExists);
    		Add_Log.info("Is radio button unsubscribe option exists ::" + isRadbtnUnsubsExists);
    		
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb']/parent::*"));
    		String radbtnLabel = element.getText();
    		
    		String expRadbtnSubs = "Good idea. Take me to Edit Categories page.";
    		String expRadbtnUnsubs = "Thanks, but please proceed with unsubscribe.";
    		
    		if(isMsgStopAlertsExists == true && isRadbtnSubsExists == true && isRadbtnUnsubsExists == true 
    				&& radbtnLabel.contains(expRadbtnSubs) && radbtnLabel.contains(expRadbtnUnsubs)){
        		Add_Log.info("There are 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_NA_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("There are NO 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_NA_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}     
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify a 'Are you sure you want to stop receiving Supplier Alerts?' copy is seen.
     * <p><ul>
     * <li>'Good idea. Take me to Edit Suppliers page.'
     * <li>'Thanks, but please proceed with unsubscribe all.'
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_msgStopSASeen_RadbtnOptionsExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMsgStopAlertsExists = driver.findElements(
    				By.xpath("//p[contains(text(),'Are you sure you want to stop receiving Supplier Alerts?')]")).size() != 0;
    		Add_Log.info("Is 'Are you sure you want to stop receiving Supplier Alerts?' copy seen ::" + isMsgStopAlertsExists);
    		
    		Boolean isRadbtnSubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='N']")).size() != 0;
    		Boolean isRadbtnUnsubsExists = driver.findElements(By.xpath("//*[@name='confirm_rb'][@value='Y']")).size() != 0;
    		Add_Log.info("Is radio button subscribe option exists ::" + isRadbtnSubsExists);
    		Add_Log.info("Is radio button unsubscribe option exists ::" + isRadbtnUnsubsExists);
    		
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb']/parent::*"));
    		String radbtnLabel = element.getText();
    		Add_Log.info("Radbtn label name ::" + radbtnLabel);
    		String expRadbtnSubs = "Good idea. Take me to Edit Suppliers page.";
    		String expRadbtnUnsubs = "Thanks, but please proceed with unsubscribe all.";
    		
    		if(isMsgStopAlertsExists == true && isRadbtnSubsExists == true && isRadbtnUnsubsExists == true 
    				&& radbtnLabel.contains(expRadbtnSubs) && radbtnLabel.contains(expRadbtnUnsubs)){
        		Add_Log.info("There are 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_SA_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		Add_Log.info("There are NO 2 radio buttons on PA Settings page.");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_MSG_STOP_SA_SEEN_RADIO_BTN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}  
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * Select 'Good idea. Take me to Edit Categories page.' option.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectGoodIdeaOption() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb'][1]"));
    		Add_Log.info("Radion button 'Good idea. Take me to Edit Categories page.' is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Radio button 'Good idea. Take me to Edit Categories page.' is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * Select 'Thanks, but please proceed with unsubscribe' option.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectUnsubscribeOption() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@name='confirm_rb'][2]"));
    		Add_Log.info("Radio button 'Thanks, but please proceed with unsubscribe' is selected on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Radio button 'Thanks, but please proceed with unsubscribe' is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    // Select Product Alert radio button option.
    public static WebElement radbtn_selectPASettingsOption(String value) throws Exception{
    	try{
    		List<WebElement> radbtn = driver.findElements(By.xpath("//input[@type='radio'][@name='confirm_rb']"));
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
     * Click on the 'Submit' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubmit() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains(text(),'Submit')]"));
    		Add_Log.info("Submit button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Submit button is NOT found on the page.");
			throw(e);
		}
		return element;
    }    
    
    /**
     * To verify all the checkbox should be checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allChkbxAreSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxPACategories = driver.findElements(By.xpath("//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxPACategories){
    			if(chkbx.isSelected()){
    				Add_Log.info("All the checkboxes in PA Settings are checked.");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_ALL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("NOT All the checkboxes in PA Settings are checked.");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_ALL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}    				
    		}    		
    	}catch(Exception e){
    		Add_Log.error("PA checkboxes is NOT checked on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify All the checkboxes should still be checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxPACategories = driver.findElements(By.xpath("//input[@type='checkbox']"));
    		for(WebElement chkbx : chkbxPACategories){
    			if(chkbx.isSelected()){
    				Add_Log.info("All the checkboxes in PA Settings are remain checked.");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_ALL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("NOT All the checkboxes in PA Settings are remain checked.");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_ALL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}    				
    		}    		
    	}catch(Exception e){
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify Product Alert checkbox is unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("product_email_on_add")).isSelected();
    		Add_Log.info("Is Product Alert checkbox selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("Product Alert checkbox is checked.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
    		}else{
    			Add_Log.info("Product Alert checkbox is unchecked.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		Add_Log.error("Product Alert checkbox is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify News Alert checkbox is unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_newsAlertChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("article_email_on_add")).isSelected();
    		Add_Log.info("Is News Alert checkbox selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("News Alert checkbox is checked.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEWS_ALERT_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
    		}else{
    			Add_Log.info("News Alert checkbox is unchecked.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_NEWS_ALERT_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		Add_Log.error("News Alert checkbox is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify Supplier Alert checkbox is unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_SAChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("supplier_email_on_add")).isSelected();
    		Add_Log.info("Is Supplier Alert checkbox selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			Add_Log.info("Supplier Alert checkbox is checked.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
    		}else{
    			Add_Log.info("Supplier Alert checkbox is unchecked.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SA_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		Add_Log.error("Supplier Alert checkbox is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
    /**
     * To verify all the checkboxes are unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		List<WebElement> chkbxPACategories = driver.findElements(By.xpath("//input[@type='checkbox']"));
    		
    		for(WebElement chkbx : chkbxPACategories){
    			if(!chkbx.isSelected()){
    				Add_Log.info("All the checkboxes in PA Settings are unchecked.");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_ALL_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("NOT All the checkboxes in PA Settings are unchecked.");
    				SuiteUtility.WriteResultUtility(
        					xls, sheetName, Constant.COL_PA_SETTINGS_PAGE_ALL_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_FAIL);
    				testFail.set(0, true);
    			}    				
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Checkboxes in PA Settings is NOT found on the page.");
			throw(e);
		}
		return element;
		
    }
    
    /**
     * Click on "Close" icon on PA Unsubscribe overlay.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickOnCloseIcon() throws Exception{
    	try{
			// 28-Aug-17 MR#39192
    		element = driver.findElement(By.xpath("//*[contains(@class, 'close ui_overlay_close')]"));
    		element.click();
    		Add_Log.info("User is click on Close icon on PA Unsubscribe overlay.");
    		
    	}catch(Exception e){
    		Add_Log.error("Close icon on PA Unsubscribe overlay is NOT found on the page.");
			throw(e);
		}
		return element;
    }
    
}
