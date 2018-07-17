/**
 * This Class contains methods that represent the locators available on eMag Lite Form Page
 * Created: Tue 01 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/01
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on eMag Lite Form page.
 * @author Teng Shyh Wei
 *
 */
public class eMagLite_Form_Page extends BaseClass{
	
	private static WebElement element = null;
	public static boolean Testfail = false;
    
    public eMagLite_Form_Page(WebDriver driver){
        	super(driver);
    }    

    /**
     * To verify eMag Lite Form page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagLiteFormPageDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources Magazines Sample Request"));
    		    	
    		if(driver.getTitle().equals("Global Sources Magazines Sample Request")){
    			Add_Log.info("eMag Lite Form page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_FORM_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("eMag Lite Form page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAG_LITE_FORM_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    	
    	}catch(Exception e){
    		Add_Log.error("Error! eMag Lite Form page is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select any eMag title checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectAnyEmagTitle(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[contains(@class, 'msgNormal')]//input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for (String check : list){
    			for (WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}    	
    	}catch(Exception e){
    		Add_Log.error("eMag title checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify eMag title checkbox is checked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataEmagTitle
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagLiteTitleChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataEmagTitle) throws Exception{
    	try{
			String eMagTitle = dataEmagTitle.trim();
			Add_Log.info(eMagTitle);
			
			if(eMagTitle.contains("APAD")){
				Boolean isAPADChkbxSelected = driver.findElement(By.xpath("//*[@id='APAD_1']/input")).isSelected();
				Add_Log.info("Is APAD Auto Parts & Accessories chkbx selected ::" + isAPADChkbxSelected);
				if(isAPADChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("ELECD")){
				Boolean isELECDChkbxSelected = driver.findElement(By.xpath("//*[@id='ELECD_1']/input")).isSelected();
				Add_Log.info("Is ELECD Consumer Electronics chkbx selected ::" + isELECDChkbxSelected);
				if(isELECDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("ECD")){
				Boolean isECDChkbxSelected = driver.findElement(By.xpath("//*[@id='ECD_1']/input")).isSelected();
				Add_Log.info("Is ECD Electronic Components chkbx selected ::" + isECDChkbxSelected);
				if(isECDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("FAD")){
				Boolean isFADChkbxSelected = driver.findElement(By.xpath("//*[@id='FAD_1']/input")).isSelected();
				Add_Log.info("Is FAD Fashion Accessories & Footwear chkbx selected ::" + isFADChkbxSelected);
				if(isFADChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("GATD")){
				Boolean isGATDChkbxSelected = driver.findElement(By.xpath("//*[@id='GATD_1']/input")).isSelected();
				Add_Log.info("Is GATD Fashion Apparel & Fabrics chkbx selected ::" + isGATDChkbxSelected);
				if(isGATDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("GHD")){
				Boolean isGHDChkbxSelected = driver.findElement(By.xpath("//*[@id='GHD_1']/input")).isSelected();
				Add_Log.info("Is GHD Gifts & Premiums chkbx selected ::" + isGHDChkbxSelected);
				if(isGHDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("HWD")){
				Boolean isHWDChkbxSelected = driver.findElement(By.xpath("//*[@id='HWD_1']/input")).isSelected();
				Add_Log.info("Is HWD Hardware, Auto & Machinery chkbx selected ::" + isHWDChkbxSelected);
				if(isHWDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("HPD")){
				Boolean isHPDChkbxSelected = driver.findElement(By.xpath("//*[@id='HPD_1']/input")).isSelected();
				Add_Log.info("Is HPD Home Products chkbx selected ::" + isHPDChkbxSelected);
				if(isHPDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("EIS")){
				Boolean isEISChkbxSelected = driver.findElement(By.xpath("//*[@id='EIS_1']/input")).isSelected();
				Add_Log.info("Is EIS India Products chkbx selected ::" + isEISChkbxSelected);
				if(isEISChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("EKS")){
				Boolean isEKSChkbxSelected = driver.findElement(By.xpath("//*[@id='EKS_1']/input")).isSelected();
				Add_Log.info("Is EKS Korea Products chkbx selected ::" + isEKSChkbxSelected);
				if(isEKSChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("ESE")){
				Boolean isESEChkbxSelected = driver.findElement(By.xpath("//*[@id='ESE_1']/input")).isSelected();
				Add_Log.info("Is ESE LED & Solar Products chkbx selected ::" + isESEChkbxSelected);
				if(isESEChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}

			if(eMagTitle.contains("EMBE")){
				Boolean isEMBEChkbxSelected = driver.findElement(By.xpath("//*[@id='EMBE_1']/input")).isSelected();
				Add_Log.info("Is EMBE Mobile Electronics chkbx selected ::" + isEMBEChkbxSelected);
				if(isEMBEChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("SPD")){
				Boolean isSPDChkbxSelected = driver.findElement(By.xpath("//*[@id='SPD_1']/input")).isSelected();
				Add_Log.info("Is SPD Security Products chkbx selected ::" + isSPDChkbxSelected);
				if(isSPDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(Testfail){
				Add_Log.info("eMag Lite Form eMag title checkbox is NOT selected");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_LITE_TITLE_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
			}else{
				Add_Log.info("eMag Lite Form eMag title checkbox is selected");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_LITE_TITLE_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
			}		    	    	
			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify eMag title checkbox is remains checked.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataEmagTitle
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_eMagLiteTitleChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataEmagTitle) throws Exception{
    	try{
			String eMagTitle = dataEmagTitle.trim();
			Add_Log.info(eMagTitle);
			
			if(eMagTitle.contains("APAD")){
				Boolean isAPADChkbxSelected = driver.findElement(By.xpath("//*[@id='APAD_1']/input")).isSelected();
				Add_Log.info("Is APAD Auto Parts & Accessories chkbx selected ::" + isAPADChkbxSelected);
				if(isAPADChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("ELECD")){
				Boolean isELECDChkbxSelected = driver.findElement(By.xpath("//*[@id='ELECD_1']/input")).isSelected();
				Add_Log.info("Is ELECD Consumer Electronics chkbx selected ::" + isELECDChkbxSelected);
				if(isELECDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("ECD")){
				Boolean isECDChkbxSelected = driver.findElement(By.xpath("//*[@id='ECD_1']/input")).isSelected();
				Add_Log.info("Is ECD Electronic Components chkbx selected ::" + isECDChkbxSelected);
				if(isECDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("FAD")){
				Boolean isFADChkbxSelected = driver.findElement(By.xpath("//*[@id='FAD_1']/input")).isSelected();
				Add_Log.info("Is FAD Fashion Accessories & Footwear chkbx selected ::" + isFADChkbxSelected);
				if(isFADChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("GATD")){
				Boolean isGATDChkbxSelected = driver.findElement(By.xpath("//*[@id='GATD_1']/input")).isSelected();
				Add_Log.info("Is GATD Fashion Apparel & Fabrics chkbx selected ::" + isGATDChkbxSelected);
				if(isGATDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("GHD")){
				Boolean isGHDChkbxSelected = driver.findElement(By.xpath("//*[@id='GHD_1']/input")).isSelected();
				Add_Log.info("Is GHD Gifts & Premiums chkbx selected ::" + isGHDChkbxSelected);
				if(isGHDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("HWD")){
				Boolean isHWDChkbxSelected = driver.findElement(By.xpath("//*[@id='HWD_1']/input")).isSelected();
				Add_Log.info("Is HWD Hardware & Machinery chkbx selected ::" + isHWDChkbxSelected);
				if(isHWDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("HPD")){
				Boolean isHPDChkbxSelected = driver.findElement(By.xpath("//*[@id='HPD_1']/input")).isSelected();
				Add_Log.info("Is HPD Home Products chkbx selected ::" + isHPDChkbxSelected);
				if(isHPDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("EIS")){
				Boolean isEISChkbxSelected = driver.findElement(By.xpath("//*[@id='EIS_1']/input")).isSelected();
				Add_Log.info("Is EIS India Products chkbx selected ::" + isEISChkbxSelected);
				if(isEISChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("EKS")){
				Boolean isEKSChkbxSelected = driver.findElement(By.xpath("//*[@id='EKS_1']/input")).isSelected();
				Add_Log.info("Is EKS Korea Products chkbx selected ::" + isEKSChkbxSelected);
				if(isEKSChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("ESE")){
				Boolean isESEChkbxSelected = driver.findElement(By.xpath("//*[@id='ESE_1']/input")).isSelected();
				Add_Log.info("Is ESE LED & Solar Products chkbx selected ::" + isESEChkbxSelected);
				if(isESEChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}

			if(eMagTitle.contains("EMBE")){
				Boolean isEMBEChkbxSelected = driver.findElement(By.xpath("//*[@id='EMBE_1']/input")).isSelected();
				Add_Log.info("Is EMBE Mobile Electronics chkbx selected ::" + isEMBEChkbxSelected);
				if(isEMBEChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("SPD")){
				Boolean isSPDChkbxSelected = driver.findElement(By.xpath("//*[@id='SPD_1']/input")).isSelected();
				Add_Log.info("Is SPD Security Products chkbx selected ::" + isSPDChkbxSelected);
				if(isSPDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(Testfail){
				Add_Log.info("eMag title checkbox is NOT remain selected");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_LITE_TITLE_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
			}else{
				Add_Log.info("eMag title checkbox is remain selected");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_LITE_TITLE_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_PASS);
			}		    	    	
			
    	}catch(Exception e){
    		Add_Log.error("eMag title checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Business E-mail' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_email"));
    		Add_Log.info("User is enter text for Business E-mail field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business E-maid field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Use another email address' hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickUseOtherEmailAddr() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//a[contains (text(),'Use another email address')]"));
    		Boolean isLnkExists = element.isDisplayed();
    		Add_Log.info("Is Lnk exists ::" + isLnkExists);
    		
    		if(isLnkExists == false){
    			
    		}else{
    			
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Continue' button.
     *  
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContinue() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//input[@value='Continue']"));
    		Add_Log.info("Continue button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Continue button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }      
    
    /**
     * Enter text for 'Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPassword() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_UserPassword"));
    		Add_Log.info("User is enter text for Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on the 'Login Now' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickLoginNow() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//input[@value='Login Now']"));
    		Add_Log.info("Login Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Login Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Password field is available.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_passwordFieldIsAvailable(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isPasswordFieldExists = driver.findElements(By.name("fld_UserPassword")).size() != 0;
    		Add_Log.info("Is password field available ::" + isPasswordFieldExists);
    		
    		if(isPasswordFieldExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PASSWORD_FIELD_EXISTS, rowNum, Constant.KEYWORD_PASS);    			
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PASSWORD_FIELD_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify Name, Company Name and Country/Territory fields are available. 
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_allMandatoryFieldsAvailable(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isFirstNameFieldExists = driver.findElements(By.id("firstname")).size() != 0;
    		Boolean isLastNameFieldExists = driver.findElements(By.id("lastname")).size() != 0;
    		Boolean isCompNameFieldExists = driver.findElements(By.name("contact_detail_company_name")).size() != 0;
    		Boolean isCountryFieldExists = driver.findElements(By.name("contact_detail_address_country")).size() != 0;
    		
    		if(isFirstNameFieldExists == true && isLastNameFieldExists == true
    				&& isCompNameFieldExists == true && isCountryFieldExists == true){
    			Add_Log.info("All mandatory fields are available.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("All mandatory fields are NOT available.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Mandatory fields are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify Email address entered in Step 4 is grey-ed out in Business Email field.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataBusinessEmail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_emailAddrIsGreyedOut(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataBusinessEmail) throws Exception{
    	try{
    		WebElement element = driver.findElement(By.name("contact_detail_email_temp"));
    		
			// Get the text entered in 'Business Email' field
            String textPopulatedInEmailAddr = element.getAttribute("value");         
            
			String fontColorEmailAddr = element.getCssValue("color");			
			String greyFontFromRGB = Color.fromString("rgb(109, 109, 109)").asRgba();
			
            if(textPopulatedInEmailAddr.equals(dataBusinessEmail) && fontColorEmailAddr.equals(greyFontFromRGB)){            	
            	Add_Log.info("Email address entered in eMag Lite Form page is pre-populated and grey-ed out in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_GREY, rowNum, Constant.KEYWORD_PASS);
            }else{            	
            	Add_Log.info("Email address entered in eMag Lite Form page is NOT pre-populated and grey-ed out in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_GREY, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
            }
    	}catch(Exception e){
    		Add_Log.error("Email Address field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for First/Given Name field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFirstName() throws Exception{
    	try{
    		element = driver.findElement(By.id("firstname"));
    		Add_Log.info("User is enter text for First/Given Name field.");
    		
    	}catch(Exception e){
    		Add_Log.error("First/Given Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Last/Family Name field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterLastName() throws Exception{
    	try{
    		element = driver.findElement(By.id("lastname"));
    		Add_Log.info("User is enter text for Last/Family Name field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Last/Family Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Company Name field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCompanyName() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_company_name"));
    		Add_Log.info("User is enter text for Company Name field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Company Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for Country/Territory.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectCountryTerritory(String selectVal) throws Exception{
    	try{    		
    		WebElement dropdown = driver.findElement(By.name("contact_detail_address_country")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){ 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		Add_Log.error("Country/Territory field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Submit' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubmit() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//input[@value='Submit']"));
    		Add_Log.info("Submit button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Submit button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
