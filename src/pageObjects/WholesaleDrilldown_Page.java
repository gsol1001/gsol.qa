/**
 * This Class contains methods that represent the locators available on Wholesale Drilldown Page
 * Created: Tue 12 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/12
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

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Wholesale Drilldown page.
 * @author Teng Shyh Wei
 *
 */
public class WholesaleDrilldown_Page extends BaseClass{

	private static WebElement element = null;
    
    public WholesaleDrilldown_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify the Wholesale L1 Drilldown page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_wholesaleL1DrilldownPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class,'path_link')]"));
    		String pathElement = element.getText();
    		Add_Log.info("Is Wholesale L1 Drilldown page displayed ::" + pathElement);
    		
    		if(pathElement.equals("Wholesale Products")){
    			Add_Log.info("Passed. Wholesale L1 Drilldown page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_L1_DRILLDOWN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. Wholesale L1 Drilldown page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_L1_DRILLDOWN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the Wholesale L3 Drilldown page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_wholesaleL3DrilldownPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class,'path_link')]"));
    		String pathElement = element.getText();
    		Add_Log.info("Is Wholesale L3 Drilldown page is displayed.");
    		
    		if(pathElement.equals("Wholesale Products")){
    			Add_Log.info("Wholesale L3 Drilldown page is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_L3_DRILLDOWN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Wholesale L3 Drilldown page is NOT displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_WHOLESALE_L3_DRILLDOWN_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on L1 Product Keyword link.
     * 
     * @param selectSub
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickL1CategoryKeyword(String selectSub) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//a[contains(@class, 'main_cat_tit')][text()='" + selectSub + "']"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on L3 Product Keyword link.
     * 
     * @param selectSub
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickL3CategoryKeyword(String selectSub) throws Exception{
    	try{
    		
    		// Main cat menu
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'main_cat_menu')]//dd//a[text()='" + selectSub + "']"));
    		
    		// Sub cat menu (mouse over to the right)
    		element = driver.findElement(
    				By.xpath("//*[contains(@class,'sub_menu_col')]//a[text()='" + selectSub + "']"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click 'Inquire Now' button for Verified Product at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForVerPdtAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//*[contains(@class, 'inquiryCon')]//a[contains(text(),'Inquire Now')])[position()=1]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select single Verified Product checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectSingleVerPdt() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//form[@name='inquiry']//input[@type='checkbox'])[position()=1]"));
    		
    	}catch(Exception e){
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
			// Select all chkbx those are odd number 
			List<WebElement> chkbx = driver.findElements(
					By.xpath("//form[@name='inquiry']//input[@type='checkbox']"));
			for(int i=1; i<chkbx.size(); i=i+2){
				chkbx.get(i).click();
			}
			
			int checkedCount = 0;
			for(int i=0; i<chkbx.size(); i++){
				if(chkbx.get(i).isSelected()){
					checkedCount++;
				}
			}
			Add_Log.info("Print number of selected chkbx ::" + checkedCount);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click 'Inquire Now' button for Unverified Product at Inquiry Bar.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickInqNowForUnvPdtAtInqBar() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'unverified_InqBar')]//a[contains(text(), 'Inquire Now')]"));
    		
    	}catch(Exception e){
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
    public static WebElement chkbx_selectSingleUnvPdt() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("(//form[@name='UVinquiry']//input[@type='checkbox'])[position()=1]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To select multiple Unverified Products checkboxes.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectMultipleUnvPdt() throws Exception{
    	try{
    		// Select all chkbx those are odd number
    		List<WebElement> chkbx = driver.findElements(
    				By.xpath("(//form[@name='UVinquiry']//input[@type='checkbox'])"));
    		for(int i=1; i<chkbx.size(); i=i+2){
    			chkbx.get(i).click();
    		}
    		
    		int checkedCount = 0;
    		for(int i=0; i<chkbx.size(); i++){
    			if(chkbx.get(i).isSelected()){
    				checkedCount++;
    			}
    		}
    		Add_Log.info("Print number of selected chkbx ::" + checkedCount);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }

    // ============================================================ Start of Inquiry Now element ====================================================
    
    // To verify the PPs from both Verified & Unverified PP section are selected
    public static WebElement check_bothVerUnvPPAreSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isVerPPChecked = driver.findElement(By.xpath("")).isSelected();
    		Boolean isUnvPPChecked = driver.findElement(By.xpath("")).isSelected();
    		Add_Log.info("Is PP from Verified PP section are selected ::" + isVerPPChecked);
    		Add_Log.info("Is PP from Unverified PP section are selected ::" + isUnvPPChecked);
    		
    		if(isVerPPChecked == true && isUnvPPChecked == true){
    			Add_Log.info("The PP from both Verified & Unverified PP section are selected");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BOTH_VER_UNV_PP_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The PP from both Verified & Unverified PP section are NOT selected");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BOTH_VER_UNV_PP_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the "To:" section only contains Verified PPs.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_toSectionOnlyContainsVerPPs(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'itemboxhdr')]//a"));
    		String expText = element.getText();
    		Add_Log.info("Print text ::" + expText);
    		
    		Boolean isVerPPsExists = driver.findElement(By.xpath("")).isDisplayed();
    		Add_Log.info("Is 'To:' section only contains Verified PPs ::" + isVerPPsExists);
    		
    		if(isVerPPsExists == true){
    			Add_Log.info("'To:' section only contains Verified PPs.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TO_SECT_ONLY_CONTAINS_VER_PP, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("'To:' section does NOT only contains Verified PPs");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TO_SECT_ONLY_CONTAINS_VER_PP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the "To:" section only contains Unverified PPs.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_toSectionOnlyContainsUnvPPs(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isUnvPPsExists = driver.findElement(By.xpath("")).isDisplayed();
    		Add_Log.info("Is 'To:' section only contains Unverified PPs " + isUnvPPsExists);
    		
    		if(isUnvPPsExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TO_SECT_ONLY_CONTAINS_UNV_PP, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_TO_SECT_ONLY_CONTAINS_UNV_PP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // =========================================================== Start of Inquiry Basket element ==================================================
    
    /**
     * To verify "Add to Basket" function is available in Verified PP section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_verPPSec_AddToBasketExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isBtnExists = driver.findElements(By.xpath("//*[contains(@class, 'inquiryBar kwRelateLink')]"
    				+ "//a[contains(text(),'Add to Basket')]")).size() != 0;
    		Add_Log.info("Is 'Add to Basket' button available in Verified PP section" + isBtnExists);
    		
    		if(isBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADD_TO_BASKET_EXISTS_IN_VER_PP, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADD_TO_BASKET_EXISTS_IN_VER_PP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify "Add to Basket" function is NOT available in Unverified PP section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_unvPPSec_AddToBasketNotExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isBtnExists = driver.findElements(By.xpath("")).size() != 0;
    		Add_Log.info("Is 'Add to Basket' button available in Unverified PP section ::" + isBtnExists);
    		
    		if(isBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADD_TO_BASKET_NOT_EXISTS_IN_UNV_PP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ADD_TO_BASKET_NOT_EXISTS_IN_UNV_PP, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify verified PPs are being added to inquiry basket.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_verPPsAddedToInqBasket(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
			// Verify all chkbx those are odd number 
			List<WebElement> chkbx = driver.findElements(
					By.xpath("//form[@name='inquiry']//input[@type='checkbox']"));
			for(int i=1; i<chkbx.size(); i=i+2){
				
		    	String btnAdded = driver.findElement(
		    			By.xpath("//*[contains(@class, 'majorPP_funR')]//a[contains(text(),'Added to Basket')]")).getText();
		    	Add_Log.info("Print button text ::" + btnAdded);
		    	
		    	Boolean isChkbxHidden = driver.findElement(
		    			By.xpath("//form[@name='inquiry']//input[@type='checkbox']")).isDisplayed();
		    	Add_Log.info("Does chkbx still available ::" + isChkbxHidden);
		    		    		
		    	if(btnAdded.equals("Added to Basket") && isChkbxHidden == false){
		    		Add_Log.info("Button value is changed from 'Add to Basket' to 'Added to Basket'.");
		    		Add_Log.info("Chkbx of those selected products are removed");
		    		SuiteUtility.WriteResultUtility(
		    				xls, sheetName, Constant.COL_VER_PP_ADDED_TO_INQ_BASKET, rowNum, Constant.KEYWORD_PASS);
		    		SuiteUtility.WriteResultUtility(
		    				xls, sheetName, Constant.COL_PDT_INQ_CHKBX_REMOVED, rowNum, Constant.KEYWORD_PASS);
		    	}else{
		    		Add_Log.info("Button value is NOT changed from 'Add to Basket' to 'Added to Basket'.");
		    		Add_Log.info("Chkbx of those selected products are NOT removed");
		    		SuiteUtility.WriteResultUtility(
		    				xls, sheetName, Constant.COL_VER_PP_ADDED_TO_INQ_BASKET, rowNum, Constant.KEYWORD_FAIL);
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
     * To verify unverified PPs are NOT added to inquiry basket.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_unvPPsAddedToBasket(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isBtnExists = driver.findElements(
    				By.xpath("//form[@name='UVinquiry']//input[@type='checkbox']")).size() != 0;
    		Add_Log.info("Unverified PPs are NOT added to inquiry basket ::" + isBtnExists);
    		
    		if(isBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_UNV_PP_NOT_ADDED_TO_BASKET, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_UNV_PP_NOT_ADDED_TO_BASKET, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    // =========================================================== Start of Compare Product element =================================================
    
    /**
     * To verify the "Compare Product" button is available in Verified PP section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_verPPSec_ComparePdtBtnExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isBtnExists = driver.findElements(By.xpath("")).size() != 0;
    		Add_Log.info("Is 'Compare Product' button available in Verified PP section ::" + isBtnExists);
    		
    		if(isBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COMPARE_PDT_EXISTS_IN_VER_PP, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COMPARE_PDT_EXISTS_IN_VER_PP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the "Compare Product" button is NOT available in Unverified PP section.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_unvPPSec_ComparePdtBtnNotExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isBtnExists = driver.findElements(By.xpath("")).size() != 0;
    		Add_Log.info("Is 'Compare Product' button available in Unverified PP section ::" + isBtnExists);
    		
    		if(isBtnExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COMPARE_PDT_NOT_EXISTS_IN_UNV_PP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_COMPARE_PDT_NOT_EXISTS_IN_UNV_PP, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify only the MOQ and FOB Price Navigator Filters are displayed, NOT in a collapsed manner.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyMOQAndFOBFiltersDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMOQExists = driver.findElements(By.id("filter_MOQ")).size() != 0;
    		Boolean isFOBExists = driver.findElements(By.id("filter_FOB")).size() != 0;
    		Add_Log.info("Is MOQ filter are displayed ::" + isFOBExists);
    		Add_Log.info("Is FOB filter are displayed ::" + isFOBExists);
    		
    		if(isMOQExists == true && isFOBExists == true){
    			Add_Log.info("Passed. Only the MOQ and FOB Price Navigator Filters are diplayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ONLY_MOQ_FOB_FILTERS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Failed. NOT only the MOQ and FOB Price Navigator Filters are displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ONLY_MOQ_FOB_FILTERS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
