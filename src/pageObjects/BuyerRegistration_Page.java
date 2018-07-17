/**
 * This Class contains methods that represent the locators available on Buyer Registration Page
 * Created: Mon 06 April 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/04/06
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Buyer Registration page.
 * @author Teng Shyh Wei
 *
 */
public class BuyerRegistration_Page extends BaseClass{
	
	private static WebElement element = null;
    public static boolean Testfail = false;
    
    public BuyerRegistration_Page(WebDriver driver){
        	super(driver);
    }

    /**
     * Click on the 'Forgot Your Password? link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickForgotYourPassword() throws Exception{
    	try{
    		// 03 May 2017 MR#46385
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'reg_login')]"
    	//			+ "//a[contains(text(),'Forgot your password')]"));
    		element = driver.findElement(By.xpath("//*[contains(@class, 'reg_login')]"
    				+ "//a[contains(text(),'Forget password')]"));
    		
    		Add_Log.info("Forgot Your Password? link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Forgot Your Password? link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // ====================================================== Start of Mandatory field Section ======================================================
    
    /**
     * Enter text for 'Business E-mail' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.id("bMail"));
    		Add_Log.info("User is enter text in Business E-mail field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Business E-mail field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
       
    /**
     * Enter text for 'Create a Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCreateAPassword() throws Exception{
    	try{
    		element = driver.findElement(By.id("cPassword"));
    		Add_Log.info("User is enter text in Create a Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Create a Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Re-enter Password' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterReenterPassword() throws Exception{
    	try{
    		element = driver.findElement(By.name("cpass"));
    		Add_Log.info("User is enter text in Re-enter Password field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Re-enter Password field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for Title.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectTitle(String selectVal) throws Exception{
    	try{    		
    		WebElement dropdown = driver.findElement(By.name("fld_Salutation[0]")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){ 

    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		Add_Log.error("Title drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'First/Given Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFirstName() throws Exception{
    	try{
    		element = driver.findElement(By.id("firstname"));
    		Add_Log.info("User is enter text in First/Given Name field.");
    		
    	}catch(Exception e){
    		Add_Log.error("First/Given Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Last/Family Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterLastName() throws Exception{
    	try{
    		element = driver.findElement(By.id("lastname"));
    		Add_Log.info("User is enter text in Last/Family Name field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Last/Family Name field is NOT found on the page.");
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
    		WebElement dropdown = driver.findElement(By.id("regCountry")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){ 

    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		Add_Log.error("Country/Territory drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Company Name" field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCompanyName() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Company.CompanyName[0]"));
    		Add_Log.info("User is enter text in Company Name field");
    		
    	}catch(Exception e){
    		Add_Log.error("Company Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter Business Contact Number's Country Code.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterContactNumberCountryCode() throws Exception{
    	try{
    		// MR45847 
    	//	element = driver.findElement(By.id("contact_detail_tel_country_code"));
    		element = driver.findElement(By.id("fld_PhoneCountry"));
    	//	Add_Log.info("User is enter text for Business Contact Number's Country Code.");
    		
    	}catch(Exception e){
    		Add_Log.error("Country Code field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter Business Contact Number's Area Code.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterContactNumberAreaCode() throws Exception{
    	try{
    		// MR45847
    	//	element = driver.findElement(By.id("contact_detail_tel_area_code"));
    		element = driver.findElement(By.id("fld_PhoneArea"));
    	//	Add_Log.info("User is enter text for Business Contact Number's Area Code.");
    		
    	}catch(Exception e){
    		Add_Log.error("Area Code field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter Business Contact Number's Telephone Number.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterContactNumberTelephoneNumber() throws Exception{
    	try{
    		// MR#45847
    	//	element = driver.findElement(By.id("contact_detail_tel_number"));
    		element = driver.findElement(By.id("fld_PhoneNumber"));
    	//	Add_Log.info("User is enter text for Business Contact Number's Telephone Number.");

    	}catch(Exception e){
    		Add_Log.error("Telephone Number field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter Business Contact Number's Extension Number.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterContactNumberExtNumber() throws Exception{
    	try{
    		// MR45847
    	//	element = driver.findElement(By.id("contact_detail_tel_ext_number"));
    		element = driver.findElement(By.id("fld_PhoneExtension"));
    	//	Add_Log.info("User is enter text for Business Contact Number's Extension Number.");

    	}catch(Exception e){
    		Add_Log.error("Extension Number fiedl is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Enter text for Company Website URL field
    public static WebElement txtbx_enterCompWebsiteURL() throws Exception{
    	try{
    		element = driver.findElement(By.id("companyURL"));
    		Add_Log.info("User is enter text for Company Website URL field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Company Website URL field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Select radio button for "Company Website URL" field
    public static WebElement txtbx_enterCompWebsiteURL(String dataRadbtnCompWebsiteURL, 
    		String dataTxtbxCompWebsiteURL) throws Exception{
    	try{
    		if(dataRadbtnCompWebsiteURL.equalsIgnoreCase("y")){
    			// do nothing
    			BuyerRegistration_Page.txtbx_enterCompWebsiteURL().sendKeys(dataTxtbxCompWebsiteURL);
    			Add_Log.info("User is enter text for Company Website URL");
    			
    		}else if(dataRadbtnCompWebsiteURL.equalsIgnoreCase("n")){
    			element = driver.findElement(By.id("nourl"));
    			element.click();
    		}else{
    			Add_Log.info("Please make sure your input value is either 'y' or 'n'.");
    		}
    		    		
    	}catch(Exception e){
    		Add_Log.error("Company Website URL field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // =========================================================== End of Mandatory field Section ===================================================

    // ======================================================= Start of eMag, PA, Nof field Section =================================================
    
    /**
     * Select any eMag title checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectAnyEmagTitle(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[contains(@class, 'reg_mag mt10')]//input"));
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
        
    // To store selected eMag Title.
    public static WebElement store_selectedEmagTitle(String dataEmagTitle, ArrayList<String> checkedeMagList) throws Exception{
    	try{
    		String eMagTitle = dataEmagTitle.trim();
    		Add_Log.info(eMagTitle);
    		
    		ArrayList<String> checkedeMagNameList = new ArrayList<String>();
    		if(eMagTitle.contains("APAD")){
    			Add_Log.info("Auto Parts & Accessories");
    			String eMagAPAD = "Auto Parts & Accessories";
    			checkedeMagNameList.add(eMagAPAD);
    		}
    		if(eMagTitle.contains("ELECD")){
    			Add_Log.info("Consumer Electronics");
    			String eMagELECD = "Consumer Electronics";
    			checkedeMagNameList.add(eMagELECD);
    		}
    		if(eMagTitle.contains("ECD")){
    			Add_Log.info("Electronic Components");
    			String eMagECD = "Electronic Components";
    			checkedeMagNameList.add(eMagECD);
    		}
    		if(eMagTitle.contains("FAD")){
    			Add_Log.info("Fashion Accessories & Footwear");
    			String eMagFAD = "Fashion Accessories & Footwear";
    			checkedeMagNameList.add(eMagFAD);
    		}
    		if(eMagTitle.contains("GATD")){
    			Add_Log.info("Fashion Apparel & Fabrics");
    			String eMagGATD = "Fashion Apparel & Fabrics";
    			checkedeMagNameList.add(eMagGATD);
    		}
    		if(eMagTitle.contains("GHD")){
    			Add_Log.info("Gifts & Premiums");
    			String eMagGHD = "Gifts & Premiums";
    			checkedeMagNameList.add(eMagGHD);
    		}
    		if(eMagTitle.contains("HWD")){
    			Add_Log.info("Hardware & Machinery");
    			String eMagHWD = "Hardware & Machinery";
    			checkedeMagNameList.add(eMagHWD);
    		}
    		if(eMagTitle.contains("HPD")){
    			Add_Log.info("Home Products");
    			String eMagHPD = "Home Products";
    			checkedeMagNameList.add(eMagHPD);
    		}
    		if(eMagTitle.contains("EIS")){
    			Add_Log.info("India Products");
    			String eMagEIS = "India Products";
    			checkedeMagNameList.add(eMagEIS);
    		}
    		if(eMagTitle.contains("EKS")){
    			Add_Log.info("Korea Products");
    			String eMagEKS = "Korea Products";
    			checkedeMagNameList.add(eMagEKS);
    		}
    		if(eMagTitle.contains("ESE")){
    			Add_Log.info("LED & Solar Products");
    			String eMagESE = "LED & Solar Products";
    			checkedeMagNameList.add(eMagESE);
    		}
    		if(eMagTitle.contains("EMBE")){
    			Add_Log.info("Mobile Electronics");
    			String eMagEMBE = "Mobile Electronics";
    			checkedeMagNameList.add(eMagEMBE);
    		}
    		if(eMagTitle.contains("SPD")){
    			Add_Log.info("Security Products");
    			String eMagSPD = "Security Products";
    			checkedeMagNameList.add(eMagSPD);
    		}
    		
    		Add_Log.info("Selected eMag ::" + checkedeMagNameList);
    		
    	}catch(Exception e){
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
    public static WebElement check_eMagTitleChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataEmagTitle) throws Exception{
    	try{
			String eMagTitle = dataEmagTitle.trim();
			Add_Log.info(eMagTitle);
			
		/*	if(eMagTitle.contains("APAD")){
				Boolean isAPADChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[1]/label/input")).isSelected();
				Add_Log.info("Is APAD Auto Parts & Accessories chkbx selected ::" + isAPADChkbxSelected);
				if(isAPADChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}	// removed on 11-Jan-2017
		*/	
			if(eMagTitle.contains("ECD")){
				Boolean isECDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[1]/label/input")).isSelected();
				Add_Log.info("Is ECD Electronic Components chkbx selected ::" + isECDChkbxSelected);
				if(isECDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("ELECD")){
				Boolean isELECDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[2]/label/input")).isSelected();
				Add_Log.info("Is ELECD Electronics chkbx selected ::" + isELECDChkbxSelected);
				if(isELECDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("FAD")){
				Boolean isFADChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[3]/label/input")).isSelected();
				Add_Log.info("Is FAD Fashion Accessories & Footwear chkbx selected ::" + isFADChkbxSelected);
				if(isFADChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("GATD")){
				Boolean isGATDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[4]/label/input")).isSelected();
				Add_Log.info("Is GATD Fashion Apparel & Fabrics chkbx selected ::" + isGATDChkbxSelected);
				if(isGATDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("GHD")){
				Boolean isGHDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[5]/label/input")).isSelected();
				Add_Log.info("Is GHD Gifts & Premiums chkbx selected ::" + isGHDChkbxSelected);
				if(isGHDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("HWD")){
				Boolean isHWDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[6]/label/input")).isSelected();
				Add_Log.info("Is HWD Hardware, Auto & Machinery chkbx selected ::" + isHWDChkbxSelected);
				if(isHWDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("HPD")){
				Boolean isHPDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[7]/label/input")).isSelected();
				Add_Log.info("Is HPD Home Products chkbx selected ::" + isHPDChkbxSelected);
				if(isHPDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("EIS")){
				Boolean isEISChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[8]/label/input")).isSelected();
				Add_Log.info("Is EIS India Products chkbx selected ::" + isEISChkbxSelected);
				if(isEISChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
			if(eMagTitle.contains("EKS")){
				Boolean isEKSChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[9]/label/input")).isSelected();
				Add_Log.info("Is EKS Korea Products chkbx selected ::" + isEKSChkbxSelected);
				if(isEKSChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
						
			if(eMagTitle.contains("SLVD")){
				Boolean isSLVDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[10]/label/input")).isSelected();
				Add_Log.info("Is SLVD Smart Living chkbx selected ::" + isSLVDChkbxSelected);
				if(isSLVDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}
			
		/*	if(eMagTitle.contains("ESE")){
				Boolean isESEChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[11]/label/input")).isSelected();
				Add_Log.info("Is ESE LED & Solar Products chkbx selected ::" + isESEChkbxSelected);
				if(isESEChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}		// removed on 22-Sep-2016
			
			if(eMagTitle.contains("EMIS")){
				Boolean isEMISChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[12]/label/input")).isSelected();
				Add_Log.info("Is EMIS Machinery & Parts chkbx selected ::" + isEMISChkbxSelected);
				if(isEMISChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}		// removed on 28-Sep-2015
			
			if(eMagTitle.contains("EMBE")){
				Boolean isEMBEChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[12]/label/input")).isSelected();
				Add_Log.info("Is EMBE Mobile Electronics chkbx selected ::" + isEMBEChkbxSelected);
				if(isEMBEChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}		// removed on 22-Sep-2016
			
			if(eMagTitle.contains("SPD")){
				Boolean isSPDChkbxSelected = driver.findElement(
						By.xpath("//*[contains(@class, 'reg_mag mt10')]/li[13]/label/input")).isSelected();
				Add_Log.info("Is SPD Security Products chkbx selected ::" + isSPDChkbxSelected);
				if(isSPDChkbxSelected == true){
				//	Testfail = false;
				}else{
					Testfail = true;					
				}
			}		// removed on 22-Sep-2016
		*/	
			if(Testfail){
				Add_Log.info("eMag title checkbox is NOT selected");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_TITLE_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
			}else{
				Add_Log.info("eMag title checkbox is selected");
				SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_TITLE_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
			}
			
    	/*	List<WebElement> isChkbxSelected = driver.findElements(
    				By.xpath("//*[contains(@class, 'reg_mag mt10')]/li/label/input"));
    		for(WebElement checkbox : isChkbxSelected){
    			if(checkbox.isSelected()){
    				Add_Log.info("eMag title checkbox is selected");
    				SuiteUtility.WriteResultUtility(
            				xls, sheetName, Constant.COL_EMAG_TITLE_CHKBX_SELECTED, rowNum, Constant.KEYWORD_PASS);
    			}else{
    				Add_Log.info("eMag title checkbox is NOT selected");
    				SuiteUtility.WriteResultUtility(
            				xls, sheetName, Constant.COL_EMAG_TITLE_CHKBX_SELECTED, rowNum, Constant.KEYWORD_FAIL);
            		testFail.set(0, true);
    			}
    		}	*/
    		
    	/*	Boolean isChkbxSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'reg_mag mt10')]/li/label/input")).isSelected();    		
    		Add_Log.info("Is eMag title chkbx selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_TITLE_CHKBX_SELECTED, rowNum, Constant.KEYWORD_PASS);
    		}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_EMAG_TITLE_CHKBX_SELECTED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}    */		    	    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
   
    /**
     * To verify all the eMag title checkboxes are unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_eMagTitleChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxUnchecked = driver.findElement(
    				By.xpath("//*[contains(@class, 'reg_mag mt10')]/li/label/input")).isSelected();
    		Add_Log.info("Is all the eMag title checkboxes are unchecked ::" + isChkbxUnchecked);
    		
    		if(isChkbxUnchecked == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_EMAG_TITLE_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_EMAG_TITLE_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}    		
    		
    	}catch(Exception e){
    		Add_Log.error("eMag title checkboxes are NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Enter a product keyword' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterProductKeyword() throws Exception{
    	try{
    		element = driver.findElement(By.id("gsolquery"));
    		Add_Log.info("User is enter text in product keyword field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Product keyword field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Product keyword is entered in the textbox.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataProductKeyword
     * @return
     * @throws Exception
     */
    public static WebElement check_pdtKeywordTxtbxIsEntered(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataProductKeyword) throws Exception{
    	try{
    		// Get the text entered in 'Product Keyword' field
    		String textEnteredInPdtKeyword = driver.findElement(By.id("gsolquery")).getAttribute("value");  
    		
    		if(textEnteredInPdtKeyword.equals(dataProductKeyword)){
    			Add_Log.info("Product Keyword is entered in the textbox");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_PDT_KEYWORD_TXTBX_IS_ENTERED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Product Keyword is NOT entered in the textbox");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_PDT_KEYWORD_TXTBX_IS_ENTERED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Product Keyword field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the PA Alert field is blank.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_pdtKeywordTxtbxIsBlank(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.id("gsolquery"));
    		String txtbxPdtKeyword = element.getAttribute("value");
    		
    		if(txtbxPdtKeyword.isEmpty()){
    			Add_Log.info("PA Alert field is empty" );
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_PDT_KEYWORD_TXTBX_IS_BLANK, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA Alert field is NOT empty" );
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_PDT_KEYWORD_TXTBX_IS_BLANK, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PA Alert field is NOT found on the page.");
    		throw(e);    		
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell section is not available.
     *  
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellSectionNotExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isPAUpsellSectionExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'reg_PA_box')]")).size()!= 0;
    		Add_Log.info("Is PA upsell section available ::" + isPAUpsellSectionExists);
    		
    		if(isPAUpsellSectionExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_SEC_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);    		
    	}
    	return element;
    }
    
    /**
     * Select Mail Announce checkbox.
     * 
     * @param dataMailAnnouce
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectMailAnnounce(String dataMailAnnouce) throws Exception{
    	try{
    		element = driver.findElement(By.name("dummy_MailAnnounce[0]"));
    		if(dataMailAnnouce.equalsIgnoreCase("y")){
    			// do nothing.
    		}else if(dataMailAnnouce.equalsIgnoreCase("n")){
    			element.click();
    		}else{
    			Add_Log.info("Please make sure your input value is either 'y' or 'n'.");
    		}	
    		
    	/*	// Clear the checkbox which is selected by default
    		WebElement chkbxMailAnnounce = driver.findElement(By.name("dummy_MailAnnounce[0]"));
    		if(chkbxMailAnnounce.isSelected()){
    			chkbxMailAnnounce.click();
    		}
    		
    		List<WebElement> chkbxMailAnnounceSelector = driver.findElements(By.name("dummy_MailAnnounce[0]"));    		    	
            for(WebElement chkbx : chkbxMailAnnounceSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            }	*/ 
    	}catch(Exception e){
    		Add_Log.error("Mail Announce checkbox is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Select Mail Marketing checkbox.
     * 
     * @param dataMailMarketing
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectMailMarketing(String dataMailMarketing) throws Exception{
    	try{
    		element= driver.findElement(By.name("dummy_MailMarketing[0]"));
    		if(dataMailMarketing.equalsIgnoreCase("y")){
    			// do nothing.
    		}else if(dataMailMarketing.equalsIgnoreCase("n")){
    			element.click();
    		}else{
    			Add_Log.info("Please make sure your input value is either 'y' or 'n'.");
    		}	
    		
    	/*	// Clear the checkbox which is selected by default
    		WebElement chkbxMailMarketing = driver.findElement(By.name("dummy_MailMarketing[0]"));
    		if(chkbxMailMarketing.isSelected()){
    			chkbxMailMarketing.click();
    		}
    		
    		List<WebElement> chkbxMailMarketingSelector = driver.findElements(By.name("dummy_MailMarketing[0]"));    		    	
            for(WebElement chkbx : chkbxMailMarketingSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            }	*/ 
    	}catch(Exception e){ 
    		Add_Log.error("Mail Marketing checkbox is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Notification checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_notificationChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMailAnnounceChkbxSelected = driver.findElement(By.name("dummy_MailAnnounce[0]")).isSelected();
    		Boolean isMailMarketingChkbxSelected = driver.findElement(By.name("dummy_MailMarketing[0]")).isSelected();
    		
    		Add_Log.info("Is chkbx 'New products, features and special offers from Global Sources' selected ::" + isMailAnnounceChkbxSelected);
    		Add_Log.info("Is chkbx 'Products and services from Global Sources partners' selected ::" + isMailAnnounceChkbxSelected);
    		
        	if((isMailAnnounceChkbxSelected == true) && (isMailMarketingChkbxSelected == true)){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_NOTIFICATION_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_NOTIFICATION_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Notification checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Notification checkbox is Not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_notificationChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isMailAnnounceChkbxSelected = driver.findElement(By.name("dummy_MailAnnounce[0]")).isSelected();
    		Boolean isMailMarketingChkbxSelected = driver.findElement(By.name("dummy_MailMarketing[0]")).isSelected();
    		
    		Add_Log.info("Is chkbx 'New products, features and special offers from Global Sources' selected ::" + isMailAnnounceChkbxSelected);
    		Add_Log.info("Is chkbx 'Products and services from Global Sources partners' selected ::" + isMailAnnounceChkbxSelected);
    		
        	if((isMailAnnounceChkbxSelected == true) && (isMailMarketingChkbxSelected == true)){
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_NOTIFICATION_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_NOTIFICATION_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		Add_Log.error("Notification checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To click on 'Register Now' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickRegisterNow() throws Exception{
    	try{
            element = driver.findElement(By.xpath("//*[contains(@class, 'mt30')]//input"));
            Add_Log.info("Register Now button is click on the page.");
            
    	}catch(Exception e){
    		Add_Log.error("Register Now button is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // ===================================================== Start of Mandatory field Checking Section ==============================================
    
    /**
     * To verify the Email address entered in eMag Lite form is pre-populated in 'Business Email' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataEmailAddress
     * @return
     * @throws Exception
     */
    public static WebElement check_txtEmailAddrPrepopulated(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataBusinessEmail) throws Exception{
    	try{
    		WebElement element = driver.findElement(By.id("bMail"));
    		
			// Get the text entered in 'Business Email' field
            String textPopulatedInEmailAddr = element.getAttribute("value");         
			
            if(textPopulatedInEmailAddr.equals(dataBusinessEmail)){            	
            	Add_Log.info("The Email address pre-populated in 'Business Email' field is same as entered in eMag Lite Form.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_SAME_AS_ENTERED_IN_EMAG_LITE, rowNum, Constant.KEYWORD_PASS);
            }else{            	
            	Add_Log.info("The Email address pre-polulated in 'Business Email' field is same as entered in eMag Lite Form.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_SAME_AS_ENTERED_IN_EMAG_LITE, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
            }            	            
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify all mandatory fields are filled up.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_allMandatoryFieldsFilledUp(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String txtbxBusinessEmail = driver.findElement(By.id("bMail")).getAttribute("value");
    		String txtbxCreatePsw = driver.findElement(By.id("cPassword")).getAttribute("value");
    		String txtbxReenterPsw = driver.findElement(By.name("cpass")).getAttribute("value");
    		String txtbxFirstName = driver.findElement(By.id("firstname")).getAttribute("value");
    		String txtbxLastName = driver.findElement(By.id("lastname")).getAttribute("value");
    		String txtbxCompName = driver.findElement(By.name("fld_Company.CompanyName[0]")).getAttribute("value");
    	//	String txtbxPhoneNumber = driver.findElement(By.id("contact_detail_tel_number")).getAttribute("value");
    		String txtbxPhoneNumber = driver.findElement(By.id("fld_PhoneNumber")).getAttribute("value");
    		
    		if(txtbxBusinessEmail.isEmpty() && txtbxCreatePsw.isEmpty() && txtbxReenterPsw.isEmpty() && 
    				txtbxFirstName.isEmpty() && txtbxLastName.isEmpty() && txtbxCompName.isEmpty() &&
    				txtbxPhoneNumber.isEmpty()){
    			Add_Log.info("All mandatory fields are NOT filled up." );
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_FILLED_UP, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			Add_Log.info("All mandatory fields are filled up." );
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_MANDATORY_FIELDS_FILLED_UP, rowNum, Constant.KEYWORD_PASS);    			
    		}
    	}catch(Exception e){
    		Add_Log.error("Mandatory fields is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the Page refreshes with error validations. 
     * Check that on the mandatory fields (fields with *), the validation message is displayed in a red color box as follow:
     * <p><ul>
     * <li>Business E-mail: Please enter your e-mail address.
     * <li>Create Login Name: Please enter a login name.
     * <li>Create a Password: Please enter login password.
     * <li>First/Given Name: Please enter your first/given name.
     * <li>Last/Family Name: Please enter your last/family name.
     * <li>Company Name: Please enter your company name.
     * <li>Telephone Number: Please enter your telephone number.
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_validationMsgIsDisplayedInRedColor (Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String errorMsgBusinessEmail = driver.findElement(
    				By.xpath("//*[@id= 'ReqdEmail']//*[contains(text(),'Please enter your e-mail address')]")).getCssValue("color");
    		String errorMsgCreateAPassword = driver.findElement(
    				By.xpath("//*[@id='ReqdPassword']//*[contains(text(),'Please enter login password')]")).getCssValue("color");    		    		
    		String errorMsgFirstName = driver.findElement(
    				By.xpath("//*[@id= 'ReqdFirstName']//*[contains(text(),'Please enter your first/given name')]")).getCssValue("color");
    		String errorMsgLastName = driver.findElement(
    				By.xpath("//*[@id= 'ReqdLastName']//*[contains(text(),'Please enter your last/family name')]")).getCssValue("color");
    		String errorMsgCompName = driver.findElement(
    				By.xpath("//*[@id= 'ReqdCompanyName']//*[contains(text(),'Please enter your company name')]")).getCssValue("color");    		
    		String errorMsgBusinessContactNumber = driver.findElement(
    				By.xpath("//*[@id= 'ReqdPhoneNum']//*[contains(text(),'Please enter your telephone number')]")).getCssValue("color"); 		    	    		 		    	
    		
    		String redFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		Add_Log.info("red from rgb ::" + redFromRGB);
    		    		
    		if(errorMsgBusinessEmail.equals(redFromRGB) && errorMsgCreateAPassword.equals(errorMsgCreateAPassword) && 
    				errorMsgFirstName.equals(redFromRGB) && errorMsgLastName.equals(redFromRGB) && 
    				errorMsgCompName.equals(redFromRGB) && errorMsgBusinessContactNumber.equals(redFromRGB)){
    			
    			Add_Log.info("On the mandatory fields, the validation message is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ERROR_MSG_IN_RED_COLOR_BOX, rowNum, Constant.KEYWORD_PASS);
    			
    		}else{
    			Add_Log.info("On the mandatory fields, the validation message is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ERROR_MSG_IN_RED_COLOR_BOX, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
    		}    		    		
    	}catch(Exception e){
    		Add_Log.error("Validation message is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify message "This e-mail address is already registered. 
     * Please use another e-mail address or login now using this address." is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgBusinessEmailAlrRegistered(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{ 
    		Boolean isErrorMsgVisible = driver.findElements(By.xpath("//*[@id= 'RegisteredEmail']"
    				+ "//*[contains(text(),'This e-mail address is already registered.')]")).size() != 0;
    		Add_Log.info("Is error msg business email already registered visible ::" + isErrorMsgVisible);
    		
    		element = driver.findElement(By.xpath("//*[@id= 'RegisteredEmail']"
    				+ "//*[contains(text(),'This e-mail address is already registered.')]"));		
    		    	
    	//	Boolean isErrorMsgVisible = element.isDisplayed();
    	//	Add_Log.info("Is error msg business email already registered visible ::" + isErrorMsgVisible);    		
    		
    		String fontColorErrorMsgBusinessEmail = element.getCssValue("color");
    		String backgroundColorErrorMsgBusinessEmail = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		String redBackgroundFromRGB = Color.fromString("rgb(255, 235, 235)").asRgba();    		    		
    		
        	if((isErrorMsgVisible == true) && (fontColorErrorMsgBusinessEmail.equals(redFontFromRGB)) 
        			&& (backgroundColorErrorMsgBusinessEmail.equals(redBackgroundFromRGB))){
        		Add_Log.info("Error message for business email already registered is displayed in a red color box"); 
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_ALR_REGISTERED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		Add_Log.info("Error message for business email already registered is NOT displayed in a red color box"); 
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_ALR_REGISTERED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
        	
        	BuyerRegistration_Page.txtbx_enterBusinessEmail().clear();
        	BuyerRegistration_Page.txtbx_enterBusinessEmail().sendKeys(Keys.TAB);
        	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify message "Please enter a valid e-mail address. Example: jsun@company.com"  is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgBusinessEmailWithoutAtSign(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{   			
    		Boolean isErrorMsgVisible = driver.findElement(By.xpath("//*[@id= 'InvalidEmail1']"
    				+ "//*[contains(text(),'Please enter a valid e-mail address. Example: jsun@company.com')]")).isDisplayed();
    		Add_Log.info("Is error msg business email without @ sign visible ::" + isErrorMsgVisible);
    		
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidEmail1']"
    				+ "//*[contains(text(),'Please enter a valid e-mail address. Example: jsun@company.com')]"));		
    		    	
    	//	Boolean isErrorMsgVisible = element.isDisplayed();
    	//	Add_Log.info("Is error msg business email without @ sign visible ::" + isErrorMsgVisible);    		
    		
    		String fontColorErrorMsgBusinessEmail = element.getCssValue("color");
    		String backgroundColorErrorMsgBusinessEmail = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		String redBackgroundFromRGB = Color.fromString("rgb(255, 235, 235)").asRgba();    		    		
    		
        	if((isErrorMsgVisible == true) && (fontColorErrorMsgBusinessEmail.equals(redFontFromRGB)) 
        			&& (backgroundColorErrorMsgBusinessEmail.equals(redBackgroundFromRGB))){
        		Add_Log.info("Error message for invalid Business Email without at-sign is displayed in a red color box"); 
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_WITHOUT_AT_SIGN, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		Add_Log.info("Error message for invalid Business Email without at-sign is NOT displayed in a red color box"); 
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_WITHOUT_AT_SIGN, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
        	
        	BuyerRegistration_Page.txtbx_enterBusinessEmail().clear();
        	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify message "Your e-mail address can contain only characters A-Z a-z 0-9 . @ _ -"  is displayed in a red color box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_errorMsgBusinessEmailWithSpecialChar(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{			
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidEmail2']"
    				+ "//*[contains(text(),'Your e-mail address can contain only characters A-Z a-z 0-9 . @ _ - ')]"));

    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Is error msg business email with special char visible ::" + isErrorMsgVisible);    		  				
    				
    		String fontColorErrorMsgBusinessEmail = element.getCssValue("color");
    		String backgroundColorErrorMsgBusinessEmail = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		String redBackgroundFromRGB = Color.fromString("rgb(255, 235, 235)").asRgba();    		
    		
    		if(isErrorMsgVisible == true && fontColorErrorMsgBusinessEmail.equals(redFontFromRGB) 
    				&& backgroundColorErrorMsgBusinessEmail.equals(redBackgroundFromRGB)){
    			
    			Add_Log.info("Error message for invalid Business Email with special character is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_SPECIAL_CHAR, rowNum, Constant.KEYWORD_PASS);
    		} else{
    			Add_Log.info("Error message for invalid Business Email with special character is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_SPECIAL_CHAR, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
    		}
    		
    		BuyerRegistration_Page.txtbx_enterBusinessEmail().clear();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify message "Your password can only contain A-Z, a-z, 0-9 and special characters (such as @, &, ?) with no spaces." 
     * is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgPasswordWithSpace(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidPassword']//*[contains(text(),'Your password can only "
    				+ "contain A-Z, a-z, 0-9 and special characters (such as @, &, ?) with no spaces')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Is error msg Password with space visible::" + isErrorMsgVisible);
    		
    		String fontColorErrorMsg = element.getCssValue("color");
    		String backgroundColorErrorMsg = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		String redBackgroundFromRGB = Color.fromString("rgb(255, 235, 235)").asRgba();    		
    		
    		if(isErrorMsgVisible == true && fontColorErrorMsg.equals(redFontFromRGB) 
    				&& backgroundColorErrorMsg.equals(redBackgroundFromRGB)){
    			
    			Add_Log.info("Error message for password with space is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ERROR_MSG_PSW_WITH_SPACE, rowNum, Constant.KEYWORD_PASS);
    		}else{    			
    			Add_Log.info("Error message for password with space is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ERROR_MSG_PSW_WITH_SPACE, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	/**
	 * To verify message "Passwords do not match." is displayed in a red color box.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_errorMsgPasswordsDoNotMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[@id= 'NotMatchPassword']//*[contains(text(),'Passwords do not match')]"));

    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Is error msg passwords do not match visible ::" + isErrorMsgVisible);    		  				
    				
    		String fontColorErrorMsg = element.getCssValue("color");
    		String backgroundColorErrorMsg = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		String redBackgroundFromRGB = Color.fromString("rgb(255, 235, 235)").asRgba();    		
    		
    		if(isErrorMsgVisible == true && fontColorErrorMsg.equals(redFontFromRGB) 
    				&& backgroundColorErrorMsg.equals(redBackgroundFromRGB)){
    			
    			Add_Log.info("Error message for passwords do not match is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_PSW_DO_NOT_MATCH, rowNum, Constant.KEYWORD_PASS);
    		} else{
    			Add_Log.info("Error message for passwords do not match is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_PSW_DO_NOT_MATCH, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
    		}    		    		    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify message "Please enter only numbers for your country code, area code, telephone number and extension. 
     * You may separate the numbers with a space or dash." is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgInvCountryCode(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#45847
    	//	Boolean isErrorMsgExists = driver.findElements(By.xpath("//*[@id= 'OtherPhoneError']"
    	//			+ "//*[contains(text(),'Please enter only numbers. You may separate the numbers with spaces.')]")).size() != 0;
    		    	
    		Boolean isErrorMsgExists = driver.findElements(By.xpath("//*[@id= 'NumericPhoneError']"
    				+ "//*[contains(text(),'Please enter only numbers.')]")).size() != 0;
    		Add_Log.info("Error message for invalid country code is exists ::" + isErrorMsgExists);
    		
    		element = driver.findElement(By.xpath("//*[@id= 'NumericPhoneError']"
    				+ "//*[contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error message for invalid Country Code is visible ::" + isErrorMsgVisible);
    		
    		String fontColorErrorMsgCountryCode = element.getCssValue("color");
    		String backgroundColorErrorMsgCountryCode = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
    		
    		if(isErrorMsgExists == true && fontColorErrorMsgCountryCode.equals(redFontFromRGB) &&
    				backgroundColorErrorMsgCountryCode.equals(redBackgroundColorErrorMsg)){
    			Add_Log.info("Error message for invalid Country Code is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_COUNTRY_CODE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Country Code is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_COUNTRY_CODE, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
    		}
    		
    		BuyerRegistration_Page.txtbx_enterContactNumberCountryCode().clear();
    	//	BuyerRegistration_Page.txtbx_enterContactNumberCountryCode().sendKeys(Keys.TAB);
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * To verify message "Please enter only numbers for your country code, area code, telephone number and extension. 
     * You may separate the numbers with a space or dash." is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgInvAreaCode(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#45847
    	//	element = driver.findElement(By.xpath("//*[@id= 'OtherPhoneError']"
    	//			+ "//*[contains(text(),'Please enter only numbers. You may separate the numbers with spaces.')]"));
    		
    		element = driver.findElement(By.xpath("//*[@id= 'NumericPhoneError']//*[contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error message for invalid Area Code is visible ::" + isErrorMsgVisible);
    		    		
			String fontColorErrorMsgAreaCode = element.getCssValue("color");
			String backgroundColorErrorMsgAreaCode = element.getCssValue("background-color");
			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
			String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsgAreaCode.equals(redFontFromRGB) &&
					backgroundColorErrorMsgAreaCode.equals(redBackgroundColorErrorMsg)){
				Add_Log.info("Error message for invalid Area Code is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_AREA_CODE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Area Code is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_AREA_CODE, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
			}
			
			BuyerRegistration_Page.txtbx_enterContactNumberAreaCode().clear();
			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify message "Please enter only numbers for your country code, area code, telephone number and extension. 
     * You may separate the numbers with a space or dash." is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgInvTelephoneNumber(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#45847
    	/*	WebDriverWait waits = new WebDriverWait(driver, 15);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id= 'OtherPhoneError']"
    				+ "//*[contains(text(),'Please enter only numbers. You may separate the numbers with spaces.')]")));
    	*/	
    	//	element = driver.findElement(By.xpath("//*[@id= 'OtherPhoneError']"
    	//			+ "//*[contains(text(),'Please enter only numbers. You may separate the numbers with spaces.')]"));
    		
    		element = driver.findElement(By.xpath("//*[@id= 'NumericPhoneError']//*[contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error message for invalid Telephone Number visible ::" + isErrorMsgVisible);
    		
    		String printErrorMsg = element.getText();
    		Add_Log.info("Print error message ::" + printErrorMsg);
    		
			String fontColorErrorMsgTelNo = element.getCssValue("color");
			String backgroundColorErrorMsgTelNo = element.getCssValue("background-color");
			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
			String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsgTelNo.equals(redFontFromRGB) &&
					backgroundColorErrorMsgTelNo.equals(redBackgroundColorErrorMsg)){
				Add_Log.info("Error message for invalid Telephone Number is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_NUMBER, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Telephone Number is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_NUMBER, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
			}
			
			BuyerRegistration_Page.txtbx_enterContactNumberTelephoneNumber().clear();
			Add_Log.info("Clear Business Contact Number's Telephone Number field.");
			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify message "Please enter only numbers for your country code, area code, telephone number and extension. 
     * You may separate the numbers with a space or dash." is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgInvPhoneExt(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// MR#45847
    	//	element = driver.findElement(By.xpath("//*[@id= 'OtherPhoneError']"
    	//			+ "//*[contains(text(),'Please enter only numbers. You may separate the numbers with spaces.')]"));
    		
    		element = driver.findElement(By.xpath("//*[@id= 'NumericPhoneError']//*[contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error message for invalid Telephone Ext visible ::" + isErrorMsgVisible);
    		    		
			String fontColorErrorMsgPhoneExt = element.getCssValue("color");
			String backgroundColorErrorMsgPhoneExt = element.getCssValue("background-color");
			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
			String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsgPhoneExt.equals(redFontFromRGB) &&
					backgroundColorErrorMsgPhoneExt.equals(redBackgroundColorErrorMsg)){
				Add_Log.info("Error message for invalid Telephone Ext is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_EXT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Telephone Ext is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_EXT, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
			}
			
			BuyerRegistration_Page.txtbx_enterContactNumberExtNumber().clear();
			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ====================================================== End of Mandatory field Checking Section ===============================================
    
	// ========================================================== Used in Forget Password module ====================================================
    
	/**
	 * To verify Registration page is displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_buyerRegPageIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 03 May 2017 MR#46385
    	//	String registrationPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'form_h1 mt10')]")).getText();    		
    		// 22 Mar 2018 MR#49317
    	//	String registrationPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'tit mt10')]")).getText();
    		
    		String registrationPageTitle = driver.findElement(By.xpath("//*[contains(@class, 'tit mr10')]")).getText();
    		String expectedTitle = "Already registered?";
    		Add_Log.info("Page title ::" + registrationPageTitle);
    		
    		if(registrationPageTitle.equals(expectedTitle)){
    			Add_Log.info("Buyer registration page is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Buyer registration page is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Registration page is not displayed.");
       		throw(e);
       	}
       	return element;
    }
    
	/**
	 * To verify "Business Email" field is blank.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
    public static WebElement check_txtbxBusinessEmailBlank(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.id("bMail"));
    		String txtbxBusinessEmail = element.getAttribute("value");
    		
    		if(txtbxBusinessEmail.isEmpty()){
    			Add_Log.info("Business Email field is blank");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUSINESS_EMAIL_FIELD_BLANK, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Business Email field is NOT blank");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUSINESS_EMAIL_FIELD_BLANK, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // To verify Email address entered is pre-populated in "Business Email" field.
    public static WebElement check_txtEmailAddrPrepopulatedInBusinessEmailField(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataEmailAddress) throws Exception{
    	try{
    		WebElement element = driver.findElement(By.id("bMail"));
    		
			// Get the text entered in 'subject' field
            String textPopulatedInEmailAddr = element.getAttribute("value");             
            Add_Log.info("Print text entered in Subject field ::" + textPopulatedInEmailAddr);
            
            if(textPopulatedInEmailAddr.equals(dataEmailAddress)){            	
            	Add_Log.info("Email address entered is pre-populated in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_BUSINESS_EMAIL_FIELD, rowNum, Constant.KEYWORD_PASS);
            }else{            	
            	Add_Log.info("Email address entered is NOT pre-populated in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_BUSINESS_EMAIL_FIELD, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
            }  
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Email address entered is pre-populated and grey-ed out in 'Business Email' field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataEmailAddress
     * @return
     * @throws Exception
     */
    public static WebElement check_txtEmailAddrPrepopulatedInGrey(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataEmailAddress) throws Exception{
    	try{
    		WebElement element = driver.findElement(By.id("bMail"));
    		
			// Get the text entered in 'subject' field
            String textPopulatedInEmailAddr = element.getAttribute("value");         
            
			String fontColorEmailAddr = element.getCssValue("color");			
			String greyFontFromRGB = Color.fromString("rgb(109, 109, 109)").asRgba();
			
			Add_Log.info("Print text entered in Subject field ::" + textPopulatedInEmailAddr);
			Add_Log.info("Print font color ::" + fontColorEmailAddr);
			Add_Log.info("Print grey color ::" + greyFontFromRGB);
			
            if(textPopulatedInEmailAddr.equals(dataEmailAddress) && fontColorEmailAddr.equals(greyFontFromRGB)){            	
            	Add_Log.info("Email address entered is pre-populated and grey-ed out in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_GREY, rowNum, Constant.KEYWORD_PASS);
            }else{            	
            	Add_Log.info("Email address entered is NOT pre-populated and grey-ed out in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_GREY, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
            }            	            
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * To verify Email address entered is pre-populated and grey-ed out in 'Business Email' field.
     * Specific for 4F, 4U, 4V, 4W.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataEmailAddress
     * @return
     * @throws Exception
     */ 
    public static WebElement check_txtEmailAddrPrepopulatedInGray(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataEmailAddress) throws Exception{
    	try{
    		WebElement element = driver.findElement(By.id("bMail"));
    		
			// Get the text entered in 'subject' field
            String textPopulatedInEmailAddr = element.getAttribute("value");         
            
			String fontColorEmailAddr = element.getCssValue("color");			
		//	String greyFontFromRGB = Color.fromString("rgb(84, 84, 84)").asRgba();
			String greyFontFromRGB = Color.fromString("rgb(109, 109, 109)").asRgba();
			
			Add_Log.info("Print text entered in Subject field ::" + textPopulatedInEmailAddr);
			Add_Log.info("Print font color ::" + fontColorEmailAddr);
			Add_Log.info("Print grey color ::" + greyFontFromRGB);
			
            if(textPopulatedInEmailAddr.equals(dataEmailAddress) && fontColorEmailAddr.equals(greyFontFromRGB)){            	
            	Add_Log.info("Email address entered is pre-populated and grey-ed out in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_GREY, rowNum, Constant.KEYWORD_PASS);
            }else{            	
            	Add_Log.info("Email address entered is NOT pre-populated and grey-ed out in 'Business Email' field.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_EMAIL_ADDR_PREPOPULATED_IN_GREY, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
            }            	            
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
}
