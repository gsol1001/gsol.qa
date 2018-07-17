/**
 * This Class contains methods that represent the locators available on Visitor Registration Page
 * Created: Fri 04 Dec 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/12/04
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

import utility.Read_XLS;

/**
 * Contains methods that represent the locators available on Visitor Registration page.
 * @author Teng Shyh Wei
 *
 */
public class VisitorRegistration_Page extends BaseClass{

	private static WebElement element = null;
    
    public VisitorRegistration_Page(WebDriver driver){
        	super(driver);
    }
    
    /**
     * To verify Visitor Registration page is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_visitorRegPageDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		String pageTitle = driver.findElement(By.xpath("")).getText();
    		String expTitle = "Visitor Registration";
    		
    		if(pageTitle.equals(expTitle)){
    			Add_Log.info("Visitor Registration page is displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_VISITOR_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Visitor Registration page is NOT displayed.");
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_VISITOR_REG_PAGE_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // =================================================== Start of Your Details section ============================================================
    
    /**
     * Select radio button for 'Title' field.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectTitle(String value) throws Exception{
    	try{
    		List<WebElement> radbtn = driver.findElements(By.name("show_addl_buyer_info_flag"));
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
     * Enter text for 'First/Given Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFirstName() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Parties.Party[0].FirstName[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Family Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFamilyName() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Parties.Party[0].LastName[0]"));
    			
    	}catch(Exception e){
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
    public static WebElement txtbx_enteBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("fld_Parties.Party[0].Email[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Re-enter Business E-mail' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterReenterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("fld_Parties.Party[0].ReEnterEmail[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'Job Function' field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectJobFunction(String selectVal) throws Exception{
    	try{
    		WebElement dropdown= driver.findElement(By.name("fld_Parties.Party[0].JobFunction[0]")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for (WebElement option : allOptions) { 
    			
    			System.out.println(String.format("Value is: %s", option.getText())); 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Job Title' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterJobTitle() throws Exception{
    	try{
    		element = driver.findElement(By.xpath("fld_Parties.Party[0].JobTitle[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'Country/Territory' field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectCountryTerritory(String selectVal) throws Exception{
    	try{
    		WebElement dropdown= driver.findElement(By.name("fld_Parties.Party.Country[0]")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for (WebElement option : allOptions) { 
    			
    			System.out.println(String.format("Value is: %s", option.getText())); 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Tel Number' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterTelNumber() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Parties.Party[0].JobTitle[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Company Name' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCompanyName() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Parties.Party.CompanyName[0]"));
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for "Address Line 1' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterAddressLine1() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Parties.Party.Address1[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'City' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCity() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Parties.Party.City[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'State/Province' field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectStateProvince(String selectVal) throws Exception{
    	try{
    		WebElement dropdown= driver.findElement(By.name("fld_Parties.Party.State[0]")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for (WebElement option : allOptions) { 
    			
    			System.out.println(String.format("Value is: %s", option.getText())); 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}    	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Zip/Postal code' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterPostalCode() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_Parties.Party.PostCode[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'Business Type' field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectBusinessType(String selectVal) throws Exception{
    	try{
    		WebElement dropdown= driver.findElement(By.name("fld_Company.BusinessFunction[0]")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for (WebElement option : allOptions) { 
    			
    			System.out.println(String.format("Value is: %s", option.getText())); 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}  
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for 'Annual Import value' field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectAnnualImportValue(String selectVal) throws Exception{
    	try{
    		WebElement dropdown= driver.findElement(By.name("fld_Company.BusinessFunction[0]")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for (WebElement option : allOptions){ 
    			
    			System.out.println(String.format("Value is: %s", option.getText())); 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ================================================= Start of Your Product Preferences section ==================================================

    // Select checkboxes for PA categories.
    public static WebElement chkbx_selectPACategories() throws Exception{
    	try{
    		// Dynamic checkbox based on Trade Show
    		
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ================================================= Start of Register Your Colleagues section ==================================================
    
    /**
     * Select drop down list for 'Number of Colleagues you wish to register' field.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectNumberOfColleagues(String selectVal) throws Exception{
    	try{
    		WebElement dropdown = driver.findElement(By.name("cmbColleague"));
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option"));
    		for (WebElement option : allOptions){
    			
    			System.out.println(String.format("Value is : %s", option.getText()));
    			
    			if(option.getText().equals(selectVal)){
    				option.click();
    			}
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // ================================================== End of Register Your Colleagues section ===================================================
    		
    /**
     * Select Terms and Conditions checkbox.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectTermsConditions() throws Exception{
    	try{
    		element = driver.findElement(By.name("PICN[0]"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // Select checkbox for 'Yes, I want to register for Globalsources.com and receive periodic updates on Global Sources Services' field.
    public static WebElement chkbx_selectRegGS() throws Exception{
    	try{
    		element = driver.findElement(By.name("fld_CoReg[0]"));

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // Select checkbox for 'Yes, please notify me by e-mail when new products are online in categories I'm interested in (as indicated above)' field.
    public static WebElement chkbx_selectAddPA() throws Exception{
    	try{
    		element = driver.findElement(By.name("AddPA[0]"));

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * 
     * 
     * Click on the 'Submit' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickSubmit() throws Exception{
    	try{
    		element = driver.findElement(By.xpath(""));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
}
