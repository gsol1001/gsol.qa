/**
 * This Class contains methods that represent the locators available on Inquiry Form Page
 * Created: Tue 23 December 2014
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
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Contains methods that represent the locators available on Inquiry Form page.
 * @author Teng Shyh Wei
 *
 */
public class InquiryForm_Page extends BaseClass{
	
	private static WebElement element = null;
	private final static String FILE_PATTERN = "//input[@type='file']";
	private final static String FIRST_UPLOAD_FILE_PATH = "C:\\Selenium\\workspace\\gsol.qa\\TestData\\TestData_Files\\unitTest.xls";
	private final static String SECOND_UPLOAD_FILE_PATH = "C:\\Selenium\\workspace\\gsol.qa\\TestData\\TestData_Files\\googlePixel.jpg";
	private final static String THIRD_UPLOAD_FILE_PATH = "C:\\Selenium\\workspace\\gsol.qa\\TestData\\TestData_Files\\regressionTest.pdf";
	
    public InquiryForm_Page(WebDriver driver){
        	super(driver);
    }
    
    // To verify RFI Form is displayed.
    public static WebElement check_RFIFormIsDisplayed() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources -- Inquiry Form"));
    		    	
    		// Wait for Footer section displayed.
    		wait.until(ExpectedConditions.visibilityOfElementLocated(
    				By.xpath("//*[contains(@class, 'GS_copyright')]")));
    		Add_Log.info("RFI form Footer section is displayed.");
    		
    		if(driver.getTitle().equals("Global Sources -- Inquiry Form")){
    			Add_Log.info("RFI form is displayed.");
    		}else{
    			Add_Log.info("RFI form is NOT displayed.");
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! RFI Form is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI form is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIFormIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources -- Inquiry Form"));
    		    	
    		if(driver.getTitle().equals("Global Sources -- Inquiry Form")){
    			Add_Log.info("RFI form is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FORM_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("RFI form is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FORM_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! RFI Form is NOT displayed.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    // To verify RFS form is displayed.
    public static WebElement check_RFSFormIsDisplayed() throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources -- Inquiry Form"));
    		
    		if(driver.getTitle().equals("Global Sources -- Inquiry Form")){
    			Add_Log.info("RFS form is displayed.");
    		}else{
    			Add_Log.info("RFS form is NOT displayed.");
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! RFS Form is NOT displayed.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFS form is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFSFormIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources -- Inquiry Form"));
    		    	
    		if(driver.getTitle().equals("Global Sources -- Inquiry Form")){
    			Add_Log.info("RFS form is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFS_FORM_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("RFS form is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFS_FORM_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! RFS Form is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify User's contact details are pre-populated. 
     *     
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataUsername
     * @return
     * @throws Exception
     */
    public static WebElement check_userContactDetailsPrepopulated(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataUsername) throws Exception{
		try{
			// Click on 'Review and Update Your Business Details to Supplier' link
			InquiryForm_Page.lnk_clickReviewUpdateBusinessDetails().click();
			
			// Get user email address value from Business e-mail text box 
			String userBusinessEmail = driver.findElement(By.id("emailId")).getAttribute("value");
			
        	if(userBusinessEmail.equals(dataUsername)){
        		Add_Log.info("User's contact details are pre-populated");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_USER_CONTACT_DETAILS_PREPOPULATED, rowNum, Constant.KEYWORD_PASS);          		
        	}else{
        		Add_Log.info("User's contact details are NOT pre-populated");
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_USER_CONTACT_DETAILS_PREPOPULATED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
        	}
		}catch(Exception e){
			Add_Log.error("Error! User's contact details are NOT pre-populated.");
			throw(e);
		}
		return element;
	}
    
    /**
     * To verify User's contact details are not pre-populated.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_userContactDetailsNotPrepopulated(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
			// Get user email address value from Business e-mail text box 
			String userBusinessEmail = driver.findElement(By.id("emailId")).getAttribute("value");
			
			if(userBusinessEmail.equals("")){
				Add_Log.info("User's contact details are NOT pre-populated");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_USER_CONTACT_DETAILS_NOT_PREPOPULATED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("User's contact details are pre-populated");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_USER_CONTACT_DETAILS_NOT_PREPOPULATED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    /**
     * To click on "To: 1 verified supplier (1 product)" .
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickToVerifiedSupplier() throws Exception{
    	try{
    		// 26-Sep-2017 MR#47697
    	//	element = driver.findElement(By.xpath("//*[@id='myInquiryForm']//dd/strong//a"));
    		element = driver.findElement(By.xpath("//*[contains(@class, 'RFI_toCon')]//a"));
    		Add_Log.info("User is click on 'To: x verified supplier' link");
    		
    	}catch(Exception e){
    		Add_Log.error("'To: x verified supplier' link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify RFI Inquiry Details window is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_RFIInqDetailsWindowIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		String expectedTitle = driver.getTitle();

    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("RFI - Inquiry Details"));
    		
    		if(expectedTitle.contains("RFI - Inquiry Details")){
    			Add_Log.info("RFI Inquiry Details window is displayed");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_INQUIRY_DETAILS_WINDOW_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("RFI Inquiry Details window is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_INQUIRY_DETAILS_WINDOW_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! RFI Inquiry Details window is NOT displayed.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify that the PP in the RFI Inquiry Details window is tally with the PP in Product Search page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param suppName
     * @return
     * @throws Exception
     */
    public static WebElement check_PPVerSuppIsMatch(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String suppName) throws Exception{
    	try{
    	//	Add_Log.info("Print supplier name ::" + suppName);
    	//	Add_Log.info("Print all info displayed ::"+ driver.getPageSource());
    		
    		element = driver.findElement(By.className("mt5 pp_supName"));
    		String actSuppName = element.getText();    		    		
    		Add_Log.info("Actual Supplier Name is ::" + actSuppName);
    		
    	//	if(driver.getPageSource().contains(suppName)){
    		if(actSuppName.equals(suppName)){
				Add_Log.info("The PP in the RFI Inquiry Details window is tally with the PP in Product Search page");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_PP_RFI_INQUIRY_DETAILS_IS_MATCHING, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The PP in the RFI Inquiry Details window is NOT tally with the PP in Product Search page");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_PP_RFI_INQUIRY_DETAILS_IS_MATCHING, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}	
    	}catch(Exception e){
    		throw(e);
    	}return element;
    }       
    
    /**
     * Select drop down list for Inquire All upsell.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     * 
     */
    public static WebElement drpdwn_selectInqAllUpsell(String selectVal) throws Exception{
    	try{    	
    		WebElement dropdown = driver.findElement(By.id("qTypeSelTarget")); 
    		List<WebElement> allOptions = dropdown.findElements(By.tagName("option")); 
    		for(WebElement option : allOptions){ 
    			
    			System.out.println(String.format("Value is: %s", option.getText())); 
    			
    			if(option.getText().equals(selectVal)){ 
    				option.click(); 
    			} 
    		}
    	}catch(Exception e){
    		Add_Log.error("Inquire All upsell drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select drop down list for Inquire All upsell by hard code.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectInqAllUpsell() throws Exception{
    	try{
    		WebElement inqAllSelector = driver.findElement(By.id("suppInqAllToggler"));
        	inqAllSelector.click();
		
			inqAllSelector = driver.findElement(By.xpath("//*[@id='suppInqAllToggler']/option[2]"));
			inqAllSelector.click();

			if(inqAllSelector.isSelected()){
				Add_Log.info("The category under Inquire All dropdown list is selected");
			}else{
				Add_Log.info("The category under Inquire All dropdown list is NOT selected");
			}
			
    	}catch(Exception e){
    		Add_Log.error("Inquire All upsell drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    /**
     * Select Inquire All Verified upsell checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectInqAllVerUpsell(String value) throws Exception{
    	try{           
            List<WebElement> chkbxVerSelector = driver.findElements(By.id("inqAllToggler"));            
            for(WebElement chkbx : chkbxVerSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            		Add_Log.info("User is select Inquire All Verified upsell chkbx.");
            }
            
    	}catch(Exception e){
    		Add_Log.info("Inquire All Verified upsell checkbox is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Select Inquire All Unverified Upsell checkbox.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectInqAllUnvUpsell(String value) throws Exception{
    	try{            
    		List<WebElement> chkbxUnvSelector = driver.findElements(By.id("unvInqAllToggler"));
            for(WebElement chkbx : chkbxUnvSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            		Add_Log.info("User is select Inquire All Unverified Upsell chkbx.");
            }
    	}catch(Exception e){
    		Add_Log.error("Inquire All Unverified upsell checkbox is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Select Only Verified products Inquire All upsell checkbox.
     * 
     * @param dataOnlyVerInqAllUpsell
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectOnlyVerInqAllUpsell(String dataOnlyVerInqAllUpsell) throws Exception{
    	try{         
    		element = driver.findElement(By.name("expand_type"));
    		if(dataOnlyVerInqAllUpsell.equalsIgnoreCase("y")){
    			element.click();
    			Add_Log.info("User is select Only Verified products Inquire All upsell chkbx.");
    		}else{
    			// do nothing.
    		}
    		
    	/*	List<WebElement> chkbxOnlyVerifiedSelector = driver.findElements(By.name("expand_type"));
            for(WebElement chkbx : chkbxOnlyVerifiedSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            }	*/
    	}catch(Exception e){
    		Add_Log.error("Only Verified products Inquire All upsell chkbx is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Select Only Unverified products Inquire All upsell checkbox.
     * 
     * @param dataOnlyUnvInqAllUpsell
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectOnlyUnvInqAllUpsell(String dataOnlyUnvInqAllUpsell) throws Exception{
    	try{
    		element = driver.findElement(By.name("expand_type"));
    		if(dataOnlyUnvInqAllUpsell.equalsIgnoreCase("y")){
    			element.click();
    			Add_Log.info("User is select Only Unverified Inquire All upsell chkbx.");
    		}else{
    			// do nothing.
    		}
    		
    	/*	List<WebElement> chkbxOnlyUnverifiedSelector = driver.findElements(By.name("expand_type"));
            for(WebElement chkbx : chkbxOnlyUnverifiedSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            }	*/
    	}catch(Exception e){
    		Add_Log.error("Only Unverified products Inquire All upsell chkbx is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Select CC my e-mail address checkbox.
     * 
     * @param dataCcEmailAddress
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectCCEmailAddress(String dataCcEmailAddress) throws Exception{
    	try{
    		element = driver.findElement(By.name("mail_ccyou"));
    		if(dataCcEmailAddress.equalsIgnoreCase("y")){
    			element.click();
    			Add_Log.info("User is select CC Email Address chkbx.");
    		}else{
    			// do nothing.
    		}
    		
    	/*	List<WebElement> chkbxCCSelector = driver.findElements(By.name("mail_ccyou"));
    		for(WebElement chkbx : chkbxCCSelector){
    			if(chkbx.getAttribute("value").equalsIgnoreCase(value))
    				chkbx.click();
    		}	*/
    	}catch(Exception e){
    		Add_Log.error("CC my e-mail address checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Subject field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterSubject() throws Exception{
    	try{
            element = driver.findElement(By.id("subjectId"));
            Add_Log.info("User is enter text for Subject field.");
            
    	}catch(Exception e){
    		Add_Log.error("Subject field is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
       		throw(e);
       	}
       	return element;
    }    
    
    /**
     * Click More Options.
     * 
     * @return
     * @throws Exception
     */
/*    public static WebElement lnk_clickMoreOptions() throws Exception{
    	try{
    		element = driver.findElement(By.id("optMore"));

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * Select Request For checkboxes.
     * 
     * @param value
     * @return
     * @throws Exception
     */
/*    public static WebElement chkbx_selectRequestFor(String value) throws Exception{
    	try{
    		List<WebElement> allChkbx = driver.findElements(By.xpath("//*[@id='RFI_EOQ']/dd/span/input"));
    		List<String> list = new ArrayList <String> (Arrays.asList(value.split(", ")));

    		for (String check : list){
    			for (WebElement chk : allChkbx){
    				if(chk.getAttribute("value").equalsIgnoreCase(check))
    					chk.click();
    			}
    		}

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * Enter text for 'Message' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterMessage() throws Exception{
    	try{
    	/*	WebElement iframeMsg= driver.findElement(By.xpath("//*[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));
    		driver.switchTo().frame(iframeMsg);    		
    		element = driver.findElement(By.cssSelector("body")); 
    	*/ 
    		
    		element = driver.findElement(By.name("inquiry_remarks"));
    		Add_Log.info("User is enter text for Message field.");
    		
    	}catch(Exception e){
    		Add_Log.info("Message field is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Enter number for Expected Order Quantity field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterExpectedOrderQuantity() throws Exception{
    	try{
            element = driver.findElement(By.id("EOQId"));
            Add_Log.info("User is enter text for Expected Order Quantity.");
            
    	}catch(Exception e){
    		Add_Log.error("Expected Order Quantity is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Select drop down list for EOQ's Unit of measurement.
     * 
     * @param selectVal
     * @return
     * @throws Exception
     */
    public static WebElement drpdwn_selectUnitOfMeasurement(String dataUOM) throws Exception{
    	try{
    		driver.findElement(By.xpath("//*[contains(@class, 'cmFormOpt ')]")).click();
    		driver.findElement(By.xpath("//*[text()='"+dataUOM+"']")).click();
    		
    		Add_Log.info(""+dataUOM+" is selected in UOM drop down list.");
    		
    	}catch(Exception e){
    		Add_Log.info("EOQ Unit of Measurement drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for inquiry all remarks field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterInqAllRemarks() throws Exception{
    	try{
    		// new UI found on 3 Nov 2015
    		element = driver.findElement(By.id("inquiryAll_remarks"));
    		Add_Log.info("User is enter text for Inquire All Remarks field.");
    		
    	}catch(Exception e){
    		Add_Log.info("Inquiry all remarks field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Click on 'Attach File(s)' link.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickAttachFile() throws Exception{
    	try{
			element = driver.findElement(By.id("button2"));
		//	element = driver.findElement(By.xpath("//*[@type='file' and @name='fileName']"));
		//	element = driver.findElement(By.xpath("//img[contains(@class, 'attachIco')]"));
			
    	/*	WebElement element = driver.findElement(By.id("button2"));
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    	*/	
		/*	WebElement element = driver.findElement(By.id("button2"));
			
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		*/	
    	}catch(Exception e){
    		Add_Log.error("Attach File link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    /**
     * Select first file and click open to upload.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_uploadFirstFile() throws Exception{
    	try{
    		// Fix on Date 29-Feb-2016
    	/*	InquiryForm_Page.lnk_clickAttachFile().click();
    		driver.findElement(By.xpath(FILE_PATTERN)).sendKeys(FIRST_UPLOAD_FILE_PATH);						                                               
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='files']//*[contains(text(),'firstMeeting.xls')]")));
		*/	
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement elem = driver.findElement(By.xpath("//input[@type='file']"));
            String js = "arguments[0].style.display = 'block';";
            jse.executeScript(js, elem);
            driver.findElement(By.xpath(FILE_PATTERN)).sendKeys(FIRST_UPLOAD_FILE_PATH);
            
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='files']//*[contains(text(),'unitTest.xls')]")));
			Add_Log.info("Attached file is uploaded.");
    	}catch(Exception e){
    		Add_Log.error("User is NOT able to upload file.");
    		throw(e);
    	}
    	return element;
    }
/*    
    public static WebElement link_clickAttachFiles() throws Exception{
    	try{
    		element = driver.findElement(By.id("button2"));
    		
    	}catch(Exception e){
    		Add_Log.error("Attach Files link is NOT found on the page.");
    		throw(e);
    	}
    	return element;    	
    }
    
	public static WebElement btnUploadFile1(String dataFile1Path) throws Exception{
    	try{
    		if(dataFile1Path.isEmpty()){
    			// do nothing
    			Add_Log.info("No input data for Image 1.");
    		}else{
        		LocalFileDetector detector = new LocalFileDetector();
        		File file = detector.getLocalFile(dataFile1Path);
        		((RemoteWebElement)InquiryForm_Page.link_clickAttachFiles()).setFileDetector(detector);
        		InquiryForm_Page.link_clickAttachFiles().sendKeys(file.getAbsolutePath());
        		
    			WebDriverWait wait = new WebDriverWait(driver, 15);
    			wait.until(ExpectedConditions.visibilityOfElementLocated(
    					By.xpath("//*[@id='files']//*[contains(text(),'firstMeeting.xls')]")));
        		Add_Log.info("Attach file is uploaded.");
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Attach file is NOT uploaded.");    		
    		throw(e);
    	}
    	return element;
	}	
	
*/    
    /**
     * Select second file and click open to upload.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_uploadSecondFile() throws Exception{
    	try{
    	/*	InquiryForm_Page.lnk_clickAttachFile().click();
    		driver.findElement(By.xpath(FILE_PATTERN)).sendKeys(SECOND_UPLOAD_FILE_PATH);						                                               
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='files']//*[contains(text(),'secondMeeting.xls')]")));
		*/	
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement elem = driver.findElement(By.xpath("//input[@type='file']"));
            String js = "arguments[0].style.display = 'block';";
            jse.executeScript(js, elem);
            driver.findElement(By.xpath(FILE_PATTERN)).sendKeys(SECOND_UPLOAD_FILE_PATH);
            
            WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='files']//*[contains(text(),'googlePixel.jpg')]")));
    	}catch(Exception e){
    		Add_Log.error("User is NOT able to upload file.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select third file and click open to upload.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_uploadThirdFile() throws Exception{
    	try{
    	/*	InquiryForm_Page.lnk_clickAttachFile().click();
    		driver.findElement(By.xpath(FILE_PATTERN)).sendKeys(THIRD_UPLOAD_FILE_PATH);						                                               
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='files']//*[contains(text(),'thirdMeeting.xls')]")));
		*/	
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement elem = driver.findElement(By.xpath("//input[@type='file']"));
            String js = "arguments[0].style.display = 'block';";
            jse.executeScript(js, elem);
            driver.findElement(By.xpath(FILE_PATTERN)).sendKeys(THIRD_UPLOAD_FILE_PATH);
            
            WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='files']//*[contains(text(),'regressionTest.pdf')]")));
    	}catch(Exception e){
    		Add_Log.error("User is NOT able to upload file");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify first file is successfully uploaded.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_fileIsUploaded(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    
    		WebElement element = driver.findElement(By.xpath("//*[@id='files']//*[contains(text(),'unitTest.xls')]"));
			String firstFileName = element.getText();
			Add_Log.info("First File name ::" + firstFileName);
			
			if(firstFileName.contains("unitTest.xls")){
				Add_Log.info("Passed. First file is uploaded.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FILE_IS_UPLOADED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Failed. First file is NOT uploaded.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_FILE_IS_UPLOADED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
			}
			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify second file is successfully uploaded.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_secondFileIsUploaded(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement secondElement = driver.findElement(By.xpath("//*[@id='files']//*[contains(text(),'googlePixel.jpg')]"));
			String secondFileName = secondElement.getText();
			Add_Log.info("Second File name ::" + secondFileName);
			
			if(secondFileName.contains("googlePixel.jpg")){
				Add_Log.info("Passed. Second file is uploaded.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SECOND_FILE_IS_UPLOADED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Failed. Second file is NOT uploaded.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_SECOND_FILE_IS_UPLOADED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
			}
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify third file is successfully uploaded.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_thirdFileIsUploaded(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement thirdElement = driver.findElement(By.xpath("//*[@id='files']//*[contains(text(),'regressionTest.pdf')]"));
			String thirdFileName = thirdElement.getText();
			Add_Log.info("Third File name ::" + thirdFileName);
			
			if(thirdFileName.contains("regressionTest.pdf")){
				Add_Log.info("Passed. Third file is uploaded.");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_THIRD_FILE_IS_UPLOADED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Failed. Third file is NOT uploaded");
				SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_THIRD_FILE_IS_UPLOADED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
			}
			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }

    // ====================================================== Start of Sample Details Section =======================================================
    
    /**
     * Enter text for 'Number of Samples' field.
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterNumberOfSamples() throws Exception{
    	try{
    		// Date: 23-Jun-2016 id changed
    	//	element = driver.findElement(By.id("numSampleId"));
    		element = driver.findElement(By.id("EOQId"));
    		Add_Log.info("User is enter text for Number of Samples field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Number of Samples field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    // Select radio button for "I'll pay for the sample" field.
    public static WebElement radbtn_selectSamplePayment(String dataSamplePayment) throws Exception{
    	try{
    		List<WebElement> radbtn = driver.findElements(By.name("sample_payment"));
    		for(WebElement radio : radbtn){
    			if(radio.getAttribute("value").equalsIgnoreCase(dataSamplePayment));
    				radio.click();
    		}
    	}catch(Exception e){
    		Add_Log.error("Radio button for 'I'll pay for the sample' field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Select radio button for "I'll pay for the shipment" field.
    public static WebElement radbtn_selectSampleShipment(String dataSampleShipment) throws Exception{
    	try{
    		List<WebElement> radbtn = driver.findElements(By.name("sample_shipment"));
    		for(WebElement radio : radbtn){
    			if(radio.getAttribute("value").equalsIgnoreCase(dataSampleShipment));
    				radio.click();
    		}
    	}catch(Exception e){
    		Add_Log.error("Radio button for 'I'll pay for the shipment' field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    // ======================================================= End of Sample Details Section ========================================================
    
    // ============================================= Start of Your Contact Details to Supplier Section ==============================================
    
    /**
     * Click Review and Update Your Business Details to Supplier.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickReviewUpdateBusinessDetails() throws Exception{
    	try{
    		element = driver.findElement(By.id("reviewSupDetail"));
    		Add_Log.info("Review and Update Your Business Details to Supplier link is click on the page");
    		
    	}catch(Exception e){
    		Add_Log.error("Review and Update Your Business Details to Supplier link is NOT found on the page.");
    		Add_Log.error("User's contact details are not pre-populated in RFI Form.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
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
    		WebElement dropdown = driver.findElement(By.name("contact_detail_title")); 
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
     * Enter text for First/Given Name field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterFirstName() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_first_name"));
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
    		element = driver.findElement(By.name("contact_detail_last_name"));
    		Add_Log.info("User is enter text for Last/Family Name field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Last/Family Name field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Business E-mail field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessEmail() throws Exception{
    	try{
    		element = driver.findElement(By.id("emailId"));
    	//	element.clear();
    		Add_Log.info("User is enter text for Business E-mail field.");
    	}catch(Exception e){
    		Add_Log.error("Business E-mail field is NOT found on the page.");
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
    		WebElement dropdown = driver.findElement(By.id("countryCode")); 
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
     * Enter Business Contact Number's Country Code.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterContactNumberCountryCode() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_tel_country_code"));
    	//	element.clear();
    		
    	}catch(Exception e){
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
    		element = driver.findElement(By.name("contact_detail_tel_area_code"));

    	}catch(Exception e){
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
    		element = driver.findElement(By.name("contact_detail_tel_number"));

    	}catch(Exception e){
    		Add_Log.error("Business Contact Number's Telephone Number field is NOT found on the page.");
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
    		element = driver.findElement(By.name("contact_detail_tel_ext_number"));

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter Company Website URL.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterCompanyWebsiteURL() throws Exception{
    	try{
    		element = driver.findElement(By.id("cwurlId"));
    		Add_Log.info("User is enter text for Company Website URL field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Company Website URL field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // Enter text for Company Website URL field
    public static WebElement txtbx_enterCompWebsiteURL() throws Exception{
    	try{
    		element = driver.findElement(By.id("cwurlId"));
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
    			InquiryForm_Page.txtbx_enterCompWebsiteURL().sendKeys(dataTxtbxCompWebsiteURL);
    			Add_Log.info("User is enter text for Company Website URL");
    			
    		}else if(dataRadbtnCompWebsiteURL.equalsIgnoreCase("n")){
    			element = driver.findElement(By.id("dont_have_website"));
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
    
    /**
     * Click More business details.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickMoreBusinessDetails() throws Exception{
    	try{
    		element = driver.findElement(By.id("moreBuDetail"));
    		Add_Log.info("User is click on More business details link.");
    		
    	}catch(Exception e){
    		Add_Log.error("More business details link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Country in which product(s) will be sold field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterTargetCountry() throws Exception{
    	try{
    		element = driver.findElement(By.id("countryId"));
    		Add_Log.info("User is enter text for Country in which product(s) will be sold field.");
    		
    	}catch(Exception e){
    		Add_Log.error("Country in which product(s) will be sold field is NOT found on the page."); 
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Linkedln Profile URL.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterLinkedlnProfileURL() throws Exception{
    	try{
    		element = driver.findElement(By.id("linkedInInput"));

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Job Title.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterJobTitle() throws Exception{
    	try{
    		element = driver.findElement(By.name("contact_detail_job_title"));

    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for Business Address.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterBusinessAddress() throws Exception{
    	try{
    		element = driver.findElement(By.id("addressId"));
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Enter text for 'Tell the supplier about your company:' field.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement txtbx_enterTellSupplierField() throws Exception{
    	try{
    		element = driver.findElement(By.id("tellSupplierId"));
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    // =============================================== End of Your Contact Details to Supplier Section ==============================================
    
    /**
     * Select Buyer Profile.
     * 
     * @param value
     * @return
     * @throws Exception
     */
    public static WebElement radbtn_selectBuyerProfile(String value) throws Exception{
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
     * Select "Remember my preference" checkbox.
     * 
     * @param dataRememberMyPref
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectRememberMyPreference(String dataRememberMyPref) throws Exception{
    	try{
    		element = driver.findElement(By.name("remember_my_pref"));
    		if(dataRememberMyPref.equalsIgnoreCase("y")){
    			// do nothing.
    		}else if(dataRememberMyPref.equalsIgnoreCase("n")){
    			element.click();
    		}else{
    			// do nothing.
    		}
    		
    	/*	// Clear the checkbox which is selected by default
    		WebElement chkbxRmbMyPreference = driver.findElement(By.name("remember_my_pref"));
    		if(chkbxRmbMyPreference.isSelected()){
    			chkbxRmbMyPreference.click();
    		}
    		
    		List<WebElement> chkbxSelector = driver.findElements(By.name("remember_my_pref"));    		    	
            for(WebElement chkbx : chkbxSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            	
            }	*/ 
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select RFQ upsell checkbox.
     * 
     * @param dataRFQChkbx
     * @return
     * @throws Exception
     */
    public static WebElement chkbxSelectRFQ(String dataRFQUpsell) throws Exception{
    	try{
    		element = driver.findElement(By.name("rfq_check"));
    		if(dataRFQUpsell.equalsIgnoreCase("y")){
    			element.click();
    			Add_Log.info("RFQ chkbx is selected on the page.");
    		}else{
    			// do nothing
    			Add_Log.info("RFQ chkbx is not selected on the page.");
    		}
    	}catch(Exception e){
    		Add_Log.error("RFQ chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Select PA Upsell checkbox for logged in user scenario.
     * 
     * @param dataPAUpsell
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectPAUpsell(String dataPAUpsell) throws Exception{
    	try{
    		element = driver.findElement(By.name("add_cats_to_prefs"));
    		if(dataPAUpsell.equalsIgnoreCase("y")){
    			element.click();
    		}else{
    			// do nothing
    		}
    		
    	/*	List<WebElement> chkbxPAUpsellSelector = driver.findElements(By.name("add_cats_to_prefs"));    		
            for(WebElement chkbx : chkbxPAUpsellSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            }	*/
    	}catch(Exception e){
    		Add_Log.error("PA upsell chkbx is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Select PA upsell checkbox for non-logged in user scenario.
     * 
     * @param dataPAUpsell
     * @return
     * @throws Exception
     */
    public static WebElement chkbx_selectPAUpsellBox(String dataPAUpsell) throws Exception{
    	try{
    		element = driver.findElement(By.name("add_cats_to_prefs"));
    		if(dataPAUpsell.equalsIgnoreCase("y")){
    			// do nothing.
    		}else if(dataPAUpsell.equalsIgnoreCase("n")){
    			element.click();
    		}else{
    			Add_Log.info("Please make sure your input value is either 'y' or 'n'.");
    		}
    		
    	/*	// Clear the checkbox which is selected by default
    		WebElement chkbxPAUpsell = driver.findElement(By.name("add_cats_to_prefs"));
    		if(chkbxPAUpsell.isSelected()){
    			chkbxPAUpsell.click();
    		}
    		
    		List<WebElement> chkbxPAUpsellSelector = driver.findElements(By.name("add_cats_to_prefs"));    		    	
            for(WebElement chkbx : chkbxPAUpsellSelector){
            	if(chkbx.getAttribute("value").equalsIgnoreCase(value))
            		chkbx.click();
            }	*/ 
    	}catch(Exception e){
    		Add_Log.error("PA upsell chkbx is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Click on "Contact Supplier Now" button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContactSupplierNow() throws Exception{
    	try{
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'RFI_btn')]//a"));
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue_inq_btn")));
    		
    		// 20-Sep-2017 MR#47697 Changed "Contact Supplier Now" to "Continue to Next Step" button.
    		// 26-Sep-2017 MR#47697 Changed back to "Contact Supplier Now" button.
    		element = driver.findElement(By.id("continue_inq_btn"));
    		Boolean isBtnVisible = element.isDisplayed();
    		Add_Log.info("Print is Contact Supplier Now button visible ::" + isBtnVisible);
    		    		
    	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	//	executor.executeScript("arguments[0].click();", element);    		
    		element.click();
    		
            Add_Log.info("Contact Supplier Now button is click on the page.");
            
    	}catch(Exception e){
    		Add_Log.error("Contact Supplier Now button is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    
    // Click on "Contact Supplier Now" button in RFS form.
    public static WebElement btn_clickRFSContactSupplierNow() throws Exception{
    	try{
    		// 20-Sep-2017 MR#47697 Changed "Contact Supplier Now" to "Continue to Next Step" button.
    		element = driver.findElement(By.id("continue_inq_btn"));
    		
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    		
    		element.click();
    		Add_Log.info("Contact Supplier Now button is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("Contact Supplier Now button is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
    /**
     * Click on 'Login Now' button at Inquiry Form page.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickLoginOnFormLoginNow() throws Exception{
    	try{
    		// 20-Sep-2017 MR#47697
    		element = driver.findElement(By.id("trigger_loginBox"));
    	//	element = driver.findElement(By.xpath("//*[contains(@class, 'RFI_loginTip')]//a"));
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Add_Log.info("Login Now button is click on the page.");
            
    	}catch(Exception e){
    		Add_Log.error("Login Now button is NOT found on the page.");
    		// Get the list of window handles
    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		Add_Log.info("Print number of window opened ::" + tabs.size());
       		throw(e);
       	}
       	return element;
    }
    
    /**
     * Click on 'Continue to Next Step' button.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement btn_clickContinueToNextStep() throws Exception{
    	try{
    		//*[contains(@class, 'RFI_btn')]//a[contains(text(),'Continue to Next Step')]
    		element = driver.findElement(By.id("continue_inq_btn"));
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(element));    		
            Add_Log.info("Continue to Next Step button is click on the page.");
            
    	}catch(Exception e){
    		Add_Log.error("Continue to Next Step button is NOT found on the page.");
       		throw(e);
       	}
       	return element;
    }
    

    // ====================================================== Start of "To:" checking Section =======================================================
    
    /**
     * To verify Supplier's Name selected in RFI confirmation page is displayed in "To:" field
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_suppNameDisplayed(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isSuppNameExists = driver.findElements(By.xpath("")).size() != 0;
    		Add_Log.info("Is Supplier's Name selected in RFI confirmation page displayed in 'To:' field ::" + isSuppNameExists);
    		
    		if(isSuppNameExists == true){
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_SUPP_NAME_DISPLAYED_AT_TO_FIELD, rowNum, Constant.KEYWORD_PASS);
    		}else{
    		//	SuiteUtility.WriteResultUtility(
    		//			xls, sheetName, Constant.COL_SUPP_NAME_DISPLAYED_AT_TO_FIELD, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    
	// ============================================= Start of Inquire All upsell drop-down list locators ============================================
    
	/**
     * To verify Inquire All upsell drop-down list is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellDrpdwnExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isDrpdwnListExists = driver.findElements(By.id("suppInqAllToggler")).size()!= 0;
        	Add_Log.info("Is Inquire All upsell drop-down list available ::" + isDrpdwnListExists); 
        	
        	Boolean isDrpdwnListVisible = driver.findElement(By.id("suppInqAllToggler")).isDisplayed();
        	Add_Log.info("Is Inquire All upsell drop-down list visible ::" + isDrpdwnListVisible);
        	
        	if(isDrpdwnListExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_EXISTS, rowNum, Constant.KEYWORD_PASS); 
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Inquire All upsell drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Inquire All upsell drop-down list is not available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellDrpdwnNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isDrpdwnListExists = driver.findElements(By.id("suppInqAllToggler")).size()!= 0;
        	Add_Log.info("Is Inquire All upsell drop-down list available ::" + isDrpdwnListExists);
        	
        	if(isDrpdwnListExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify category under Inquire All upsell drop-down list is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellDrpdwnSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{    		
    		WebElement inqAllUpsellDrpDwn = driver.findElement(By.xpath("//*[@id='suppInqAllToggler']/option[2]"));
    		if(inqAllUpsellDrpDwn.isSelected()){
				Add_Log.info("The category under Inquire All upsell dropdown list is selected");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_SELECTED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The category under Inquire All upsell dropdown list is NOT selected");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_SELECTED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		Add_Log.error("Inquire All upsell drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    /**
     * To verify category under Inquire All upsell drop-down list is not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellDrpdwnNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement inqAllUpsellDrpDwn = driver.findElement(By.id("suppInqAllToggler"));
    		if(inqAllUpsellDrpDwn.isSelected()){
				Add_Log.info("The category under Inquire All upsell dropdown list is selected");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_NOT_SELECTED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}else{
				Add_Log.info("The category under Inquire All upsell dropdown list is NOT selected");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_NOT_SELECTED, rowNum, Constant.KEYWORD_PASS);
			}
    	}catch(Exception e){
    		Add_Log.error("Inquire All upsell drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
    /**
     * To verify category selected in Inquire All upsell drop-down list remains unchanged.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUpsellDrpdwnRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		WebElement inqAllUpsellDrpDwn = driver.findElement(By.xpath("//*[@id='suppInqAllToggler']/option[2]"));
    		if(inqAllUpsellDrpDwn.isSelected()){
				Add_Log.info("The category under Inquire All upsell dropdown list is remain selected");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_REMAIN_SELECTED, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The category under Inquire All upsell dropdown list is NOT remain selected");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_INQ_ALL_UPSELL_DRPDWN_REMAIN_SELECTED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
    	}catch(Exception e){
    		Add_Log.error("Inquire All upsell drop down list is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
	// ======================================= Start of Verified products Inquire All upsell checkbox locators ======================================
    
    /**
     * To check Verified products Inquire All upsell checkbox is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllVerChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.id("inqAllToggler")).size()!= 0;
			Add_Log.info("Is Verified products Inquire All upsell checkbox available ::" + isChkbxExists); 
			
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Verified products Inquire All upsell checkbox is not available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllVerChkbxNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.id("inqAllToggler")).size()!= 0;
			Add_Log.info("Is Verified products Inquire All upsell checkbox available ::" + isChkbxExists); 
			
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){    		
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Verified products Inquire All upsell checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllVerChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.id("inqAllToggler")).isSelected();
    		Add_Log.info("Is Verified products Inquire All upsell checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Verified products Inquire All upsell checkbox is not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllVerChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.id("inqAllToggler")).isSelected();
    		Add_Log.info("Is Verified products Inquire All upsell checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		Add_Log.error("Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Verified products Inquire All upsell checkbox is remain selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllVerChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxRemainSelected = driver.findElement(By.id("inqAllToggler")).isSelected();
    		Add_Log.info("Is Verified products Inquire All upsell checkbox remain selected ::" + isChkbxRemainSelected);
    		
        	if(isChkbxRemainSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Verified products Inquire All upsell checkbox is remain unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllVerChkbxRemainUnchecked(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxRemainUnchecked = driver.findElement(By.id("inqAllToggler")).isSelected();
    		Add_Log.info("Is Verified products Inquire All upsell checkbox remain unchecked ::" + isChkbxRemainUnchecked);
    		
    		if(isChkbxRemainUnchecked == true){
    			SuiteUtility.WriteResultUtility(xls, sheetName, 
    					Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_REMAIN_UNCHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(xls, sheetName, 
    					Constant.COL_INQ_ALL_VER_UPSELL_CHKBX_REMAIN_UNCHECKED, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		Add_Log.error("Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Verified products Inquire All upsell checkbox is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyVerInqAllChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.name("expand_type")).size()!= 0;
    		Add_Log.info("Is Verified products Inquire All upsell checkbox available ::" + isChkbxExists);
    		
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Verified products Inquire All upsell checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyVerInqAllChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("expand_type")).isSelected();
    		Add_Log.info("Is Verified products Inquire All upsell checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Verified products Inquire All upsell checkbox is not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyVerInqAllChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("expand_type")).isSelected();
    		Add_Log.info("Is Verified products Inquire All upsell checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Verified products Inquire All upsell checkbox is remain selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyVerInqAllChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxRemainSelected = driver.findElement(By.name("expand_type")).isSelected();
    		Add_Log.info("Is Only Verified products Inquire All upsell checkbox selected ::" + isChkbxRemainSelected);
    		
        	if(isChkbxRemainSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Verified products Inquire All upsell checkbox is remain unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyVerInqAllChkbxRemainUnchecked(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxRemainUnchecked = driver.findElement(By.name("expand_type")).isSelected();
    		Add_Log.info("Is Verified products Inquire All upsell checkbox selected ::" + isChkbxRemainUnchecked);
    		
        	if(isChkbxRemainUnchecked == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_REMAIN_UNCHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_VER_INQ_ALL_UPSELL_CHKBX_REMAIN_UNCHECKED, rowNum, Constant.KEYWORD_PASS);        		
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Verified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	// ====================================== Start of Unverified products Inquire All upsell checkbox locators =====================================
    
    /**
     * To check Unverified products Inquire All upsell checkbox is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUnvChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.id("unvInqAllToggler")).size()!= 0;
    		Add_Log.info("Is Unverified products Inquire All upsell checkbox available ::" + isChkbxExists); 
    		
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_PASS);

        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Unverified product Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Unverified products Inquire All upsell checkbox is not available on the page.
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUnvChkbxNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.id("unvInqAllToggler")).size()!= 0;
    		Add_Log.info("Is Unverified products Inquire All upsell checkbox available ::" + isChkbxExists); 
    		
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Unverified products Inquire All upsell checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUnvChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.id("unvInqAllToggler")).isSelected();
    		Add_Log.info("Is Unverified products Inquire All upsell checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Unverified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Unverified products Inquire All upsell checkbox is not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUnvChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.id("unvInqAllToggler")).isSelected();
    		Add_Log.info("Is Unverified products Inquire All upsell checkbox selected ::" + isChkbxSelected); 
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		Add_Log.error("Unverified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To check Unverified products Inquire All upsell checkbox is remain selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_inqAllUnvChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxRemainSelected = driver.findElement(By.id("unvInqAllToggler")).isSelected();
    		Add_Log.info("Is Unverified products Inquire All upsell checkbox remain selected ::" + isChkbxRemainSelected); 
    		
        	if(isChkbxRemainSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_PASS);

        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_INQ_ALL_UNV_UPSELL_CHKBX_REMAIN_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Unverified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Unverified products Inquire All upsell checkbox is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyUnvInqAllChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.name("expand_type")).size()!= 0;
    		Add_Log.info("Is Only Unverified products Inquire All upsell checkbox available ::" + isChkbxExists); 
    		
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_PASS);

        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Unverified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Unverified products Inquire All upsell checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyUnvInqAllChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("expand_type")).isSelected();
    		Add_Log.info("Is Only Unverified products Inquire All upsell checkbox selected ::" + isChkbxSelected); 
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_SELECTED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_SELECTED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Unverified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Only Unverified products Inquire All upsell checkbox is remain selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_onlyUnvInqAllChkbxRemainSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxRemainSelected = driver.findElement(By.name("expand_type")).isSelected();
    		Add_Log.info("Is Only Unverified products Inquire All upsell checkbox selected ::" + isChkbxRemainSelected); 
    		
        	if(isChkbxRemainSelected == true){
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_REMAIN_SELECTED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(xls, sheetName, 
        				Constant.COL_ONLY_UNV_INQ_ALL_UPSELL_CHKBX_REMAIN_SELECTED, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("Only Unverified products Inquire All upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	// ================================================= Start of CC Email Address checkbox locators ================================================
    
    /**
     * To verify CC Email Address checkbox is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_ccEmailAddrChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{        	
        	Boolean isChkbxExists = driver.findElements(By.name("mail_ccyou")).size()!= 0;
        	Add_Log.info("Is CC Email Address checkbox available ::" + isChkbxExists); 
        	
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_EXISTS, rowNum, Constant.KEYWORD_PASS);  
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("CC Email Address checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify CC Email Address checkbox is not available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_ccEmailAddrChkbxNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
        	Boolean isChkbxExists = driver.findElements(By.name("mail_ccyou")).size()!= 0; 
        	Add_Log.info("Is CC Email Address checkbox available ::" + isChkbxExists); 
        	
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);        		
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify CC Email Address checkbox is selected.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_ccEmailAddrChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("mail_ccyou")).isSelected();
    		Add_Log.info("Is CC Email Address checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("CC Email Address checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify CC Email Address checkbox is not selected.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement check_ccEmailAddrChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("mail_ccyou")).isSelected();
    		Add_Log.info("Is CC Email Address checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_UNCHECKED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		Add_Log.error("CC Email Address checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify CC Email Address checkbox is not available (removed) on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_ccEmailAddrChkbxRemoved(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{        	    		
    		Boolean isChkbxExists = driver.findElement(By.name("mail_ccyou")).isDisplayed();
        	Add_Log.info("Is CC Email Address checkbox available ::" + isChkbxExists); 
        	
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_REMOVED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_CC_EMAIL_ADDR_CHKBX_REMOVED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	// ================================================ Start of Buyer Profile radio button locators ================================================
    
    /**
     * To verify following options are available in the Buyer Profile section:
     * <p><ul>
     * <li>a) Yes, include my Buyer Profile for this inquiry
     * <li>b) No, don not send this time
     * </ul></p>
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfileSectionExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isBuyerProfileOptionYesExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]"
    						+ "//*[contains(text(),'Yes, include my Buyer Profile for this inquiry')]")).size()!= 0;
    		
    		Boolean isBuyerProfileOptionNoExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]"
    						+ "//*[contains(text(),'No, do not send this time')]")).size() != 0;
    		
    		Boolean isChkbxExists = driver.findElements(By.name("remember_my_pref")).size() != 0;
    		
    		Add_Log.info("Is radio button 'Yes, include my Buyer Profile for this inquiry' exists ::" + isBuyerProfileOptionYesExists);
    		Add_Log.info("Is radio button 'No, do not send this time' exists ::" + isBuyerProfileOptionNoExists);
    		Add_Log.info("Is checkbox 'Remember my preference' exists ::" + isChkbxExists);
    		
    		if( (isBuyerProfileOptionYesExists == true) && (isBuyerProfileOptionNoExists == true) && (isChkbxExists == true)){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SECTION_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SECTION_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Buyer Profile section is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Option 'Yes, include my Buyer Profile for this inquiry' is checked as default.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfile_radbtnYesCheckedAsDefault(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRadbtnCheckedAsDefault = 
    				driver.findElement(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]//input[@value='Y']")).isSelected();
    		Add_Log.info("Is radio button 'Yes, include my Buyer Profile for this inquiry' "
    				+ "checked as default ::" + isRadbtnCheckedAsDefault);
    		
    		if(isRadbtnCheckedAsDefault == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OPTION_CHKBX_YES_BUYER_PROFILE_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OPTION_CHKBX_YES_BUYER_PROFILE_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Option 'No, do not send this time' is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfile_radbtnNoIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRadbtnSelected = driver.findElement(
    				By.xpath("//*[contains(@class, 'RFI_buyerProfile')]//input[@value='N']")).isSelected();
    		Add_Log.info("Is radio button 'No, do not send this time' selected ::" + isRadbtnSelected);
    		
    		if(isRadbtnSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OPTION_CHKBX_NO_BUYER_PROFILE_IS_SELECTED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OPTION_CHKBX_NO_BUYER_PROFILE_IS_SELECTED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Option 'No, do not send this time' is checked as default.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfile_radbtnNoCheckedAsDefault(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isRadbtnCheckedAsDefault = driver.findElement(
    				By.xpath("//*[contains(@class, 'RFI_buyerProfile')]//input[@value='N']")).isSelected();
    		Add_Log.info("Is radio button 'No, do not send this time' checked as default ::" + isRadbtnCheckedAsDefault);
    		
    		if(isRadbtnCheckedAsDefault == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OPTION_CHKBX_NO_BUYER_PROFILE_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_OPTION_CHKBX_NO_BUYER_PROFILE_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the following copy is displayed in the Buyer Profile section
     * 'You have chosen to always include your Buyer Profile to suppliers.
     * Note: Supplier(s) will also be able to view your future profile updates.'
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfileAlwaysDiscloseExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isCopyIncludeBuyerProfileExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]"
    						+ "//*[contains(text(),'You have chosen to always include your Buyer Profile to suppliers')]")).size()!= 0;    		
    		Add_Log.info("Is 'You have chosen to always include your Buyer Profile to suppliers.' copy exists ::" + isCopyIncludeBuyerProfileExists);
    		
    		if(isCopyIncludeBuyerProfileExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_ALWAYS_DISCLOSE_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_ALWAYS_DISCLOSE_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify Buyer Profile section is not available in the RFI form.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_buyerProfileSectionNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isBuyerProfileSectionExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]")).size()!= 0;
    		Add_Log.info("Is Buyer Profile section exists in the RFI form ::" + isBuyerProfileSectionExists);
    		if(isBuyerProfileSectionExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SECTION_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SECTION_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify "Remember my preference" checkbox is checked as default.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_rmbMyPrefChkbxSelectedAsDefault(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxCheckedAsDefault = driver.findElement(By.name("remember_my_pref")).isSelected();
    		Add_Log.info("Is Remember my preference checkbox selected as default ::" + isChkbxCheckedAsDefault);
    		
    		if(isChkbxCheckedAsDefault == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Remember my preference checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify "Remember my preference" checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_rmbMyPrefChkbxIsSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("remember_my_pref")).isSelected();
    		Add_Log.info("Is Remember my preference checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("Remember my preference checkbox is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify "Remember my preference" checkbox is not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_rmbMyPrefChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("remember_my_pref")).isSelected();
    		Add_Log.info("Is Remember my preference checkbox selected ::" + isChkbxSelected);
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);	
        	}
    	}catch(Exception e){
    		Add_Log.error("Remember my preference checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify "Remember my preference" checkbox is unchecked.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_rmbMyPrefChkbxIsUnchecked(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("remember_my_pref")).isSelected();
    		Add_Log.info("Is Remember my preference checkbox selected ::" + isChkbxSelected);
    		
    		if(isChkbxSelected == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_IS_UNCHECKED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RMB_MY_PREF_CHKBX_IS_UNCHECKED, rowNum, Constant.KEYWORD_PASS);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("Remember my preference checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    // ================================================= End of Buyer Profile radio button locators =================================================

	// ======================================================= Start of RFQ checkbox locators =======================================================
    
    // To verify RFQ upsell chkbx is available on the page.
    public static WebElement check_RFQUpsellChkbxExists(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.name("rfq_check")).size()!= 0;
        	Add_Log.info("Is RFQ upsell checkbox available ::" + isChkbxExists);
        	
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{	
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("RFQ upsell chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }

    // To verify RFQ upsell chkbx is not available on the page.
    public static WebElement check_RFQUpsellChkbxNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.name("rfq_check")).size()!= 0;
        	Add_Log.info("Is RFQ upsell checkbox available ::" + isChkbxExists); 
        	
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){    		
    		throw(e);
    	}
    	return element;
    }
    
    // To verify RFQ upsell chkbx is selected on the page.
    public static WebElement check_RFQUpsellChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("rfq_check")).isSelected();
    		Add_Log.info("Is RFQ upsell checkbox selected ::" + isChkbxSelected); 
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("RFQ upsell chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify RFQ upsell chkbx is not selected on the page.
    public static WebElement check_RFQUpsellChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("rfq_check")).isSelected();
    		Add_Log.info("Is RFQ upsell checkbox selected ::" + isChkbxSelected); 
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		Add_Log.error("RFQ upsell chkbx is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify RFQ upsell checkbox is checked as default.
    public static WebElement check_RFQUpsellChkbxSelectedAsDefault(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxCheckedAsDefault = driver.findElement(By.name("rfq_check")).isSelected();
    		Add_Log.info("Is RFQ upsell checkbox selected as default ::" + isChkbxCheckedAsDefault);
    		
    		if(isChkbxCheckedAsDefault == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFQ_UPSELL_CHKBX_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("RFQ upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify RFQ upsell copy 'Get quotations from matching suppliers if this supplier does not reply in MessageCenter within 24 hours' is seen 
    public static WebElement check_RFQUpsellCopyAvailable(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector("p.RFI_bookUpdate"));
    		String actText = element.getText();
    		String expText = "Get quotations from matching suppliers if this supplier does not reply in MessageCenter within 24 hours";
    		Add_Log.info("Print act text ::" + actText);
    		
    		if(actText.equals(expText)){
    			Add_Log.info("RFQ upsell copy is available on the page.");
    			SuiteUtility.WriteResultUtility(xls, sheetName, Constant.COL_RFQ_UPSELL_COPY_IS_EXISTS, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("RFQ upsell copy is NOT available on the page.");
    			SuiteUtility.WriteResultUtility(xls, sheetName, Constant.COL_RFQ_UPSELL_COPY_IS_EXISTS, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}    		
    	}catch(Exception e){
    		Add_Log.error("RFQ upsell copy is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
	// ======================================================== End of RFQ checkbox locators ========================================================
    
	// ==================================================== Start of PA upsell checkbox locators ====================================================
    
    /**
     * To verify PA upsell copy 'I want e-mail updates when new {Inquired L4 category} are available.' is seen.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellCopyAvailable(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isPAUpsellCopyExists = driver.findElements(
    				By.xpath("//*[contains(@class, 'RFI_bookUpdate')]")).size() != 0;
        	Add_Log.info("Is PA upsell copy 'I want e-mail updates when new {Inquired L4 category} "
        			+ "are available.' is seen ::" + isPAUpsellCopyExists);
        	
        	if(isPAUpsellCopyExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_COPY_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{	
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_COPY_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("PA upsell copy is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell copy "I want e-mail updates when new products are posted in the categories I'm inquiring on." is seen.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellCopyIsSeen(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// UI change
    	//	element = driver.findElement(By.cssSelector("p.RFI_bookUpdate"));
    		
    		element = driver.findElement(By.xpath("//*[contains(@class, 'RFI_bookUpdate')][2]"));
    		String isPAUpsellCopySeen = element.getText();    		
    		String expectedPAUpsellCopy = "I want e-mail updates when new products are posted in the categories I'm inquiring on.";
    		Add_Log.info("PA upsell copy ::" + isPAUpsellCopySeen);
    		
    		if(isPAUpsellCopySeen.contains(expectedPAUpsellCopy)){
    			Add_Log.info("PA upsell copy 'I want e-mail updates when new products are posted in the categories I'm inquiring on.' is seen");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_COPY_IS_SEEN, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("PA upsell copy 'I want e-mail updates when new products are posted in the categories I'm inquiring on.' is NOT seen");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_COPY_IS_SEEN, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PA upsell copy is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell checkbox is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellChkbxExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.name("add_cats_to_prefs")).size()!= 0;
        	Add_Log.info("Is PA upsell checkbox available ::" + isChkbxExists);
        	
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}else{	
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}
    	}catch(Exception e){
    		Add_Log.error("PA upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell checkbox is not available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellChkbxNotExists(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxExists = driver.findElements(By.name("add_cats_to_prefs")).size()!= 0;
        	Add_Log.info("Is PA upsell checkbox available ::" + isChkbxExists); 
        	
        	if(isChkbxExists == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_NOT_EXISTS, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell checkbox is selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellChkbxSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("add_cats_to_prefs")).isSelected();
    		Add_Log.info("Is PA upsell checkbox selected ::" + isChkbxSelected); 
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
    	}catch(Exception e){
    		Add_Log.error("PA upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify PA upsell checkbox is not selected.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxSelected = driver.findElement(By.name("add_cats_to_prefs")).isSelected();
    		Add_Log.info("Is PA upsell checkbox selected ::" + isChkbxSelected); 
    		
        	if(isChkbxSelected == true){
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);
        	}else{
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_NOT_CHECKED, rowNum, Constant.KEYWORD_PASS);
        	}
    	}catch(Exception e){
    		Add_Log.error("PA upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify PA upsell checkbox is checked as default.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_PAUpsellChkbxSelectedAsDefault(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Boolean isChkbxCheckedAsDefault = driver.findElement(By.name("add_cats_to_prefs")).isSelected();
    		Add_Log.info("Is PA upsell checkbox selected as default ::" + isChkbxCheckedAsDefault);
    		
    		if(isChkbxCheckedAsDefault == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_PA_UPSELL_CHKBX_CHECKED_AS_DEFAULT, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("PA upsell checkbox is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the category in PA upsell changed to sibling category of the inquired L4 category.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_categoryPAUpsellChangedToSiblingCategory(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		/*String categoryPAUpsellAfterLogin = driver.findElement(By.xpath("//*[@id='myInquiryForm']/p[2]/strong")).getText();
			if(categoryPAUpsellBeforeLogin.equals(categoryPAUpsellAfterLogin)){
				Add_Log.info("The category in PA upsell changed to sibling category of the inquired L4 category.");
				SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_CATEGORY_PA_UPSELL_CHANGED_TO_SIBLING_CATEGORY, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("The category in PA upsell are not changed to sibling category");
				SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_CATEGORY_PA_UPSELL_CHANGED_TO_SIBLING_CATEGORY, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}*/
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result Pass when 'category in PA upsell changed to sibling category of the inquired L4 category'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_catPAUpsellChangedToSiblingCategoryIsTrue(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("The category in PA upsell changed to sibling category of the inquired L4 category.");
			SuiteUtility.WriteResultUtility(xls, sheetName, 
					Constant.COL_CAT_PA_UPSELL_CHANGED_TO_SIBLING_CAT, rowNum, Constant.KEYWORD_PASS);			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result Fail when 'category in PA upsell are not changed to sibling category'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_catPAUpsellChangedToSiblingCategoryIsFalse(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("The category in PA upsell are not changed to sibling category");
			SuiteUtility.WriteResultUtility(xls, sheetName, 
					Constant.COL_CAT_PA_UPSELL_CHANGED_TO_SIBLING_CAT, rowNum, Constant.KEYWORD_FAIL);
			testFail.set(0, true);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the category in PA upsell remain unchanged.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_categoryPAUpsellRemainUnchanged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
			/*Add_Log.info("The category in PA upsell remain unchanged.");
			SuiteUtility.WriteResultUtility(xls, sheetName, 
					Constant.COL_CATEGORY_PA_UPSELL_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
			
			Add_Log.info("The category in PA upsell has been changed.");
			SuiteUtility.WriteResultUtility(xls, sheetName, 
					Constant.COL_CATEGORY_PA_UPSELL_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
			testFail.set(0, true);*/
    			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result Pass when 'category in PA upsell remain unchanged'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_catPAUpsellRemainUnchangedIsTrue(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("The category in PA upsell remain unchanged.");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_CAT_PA_UPSELL_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * Set result Fail when 'category in PA upsell has been changed'.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_catPAUpsellRemainUnchangedIsFalse(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		Add_Log.info("The category in PA upsell has been changed.");
			SuiteUtility.WriteResultUtility(
					xls, sheetName, Constant.COL_CAT_PA_UPSELL_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
			testFail.set(0, true);
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
	// ===================================================== End of PA upsell checkbox locators =====================================================
    
    /**
     * To verify Business Email entered is the same as in pre-req.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataBusinessEmail
     * @return
     * @throws Exception
     */
    public static WebElement check_textBusinessEmailEnteredSameAsPrereq(Read_XLS xls, String sheetName, int rowNum,
    		List<Boolean> testFail, String dataBusinessEmail) throws Exception{
    	try{
    		String textEnteredInBusinessEmail = driver.findElement(By.id("emailId")).getAttribute("value");
    		Add_Log.info("Business Email entered ::" + textEnteredInBusinessEmail);
    		
    		if(textEnteredInBusinessEmail.equals(dataBusinessEmail)){
    			Add_Log.info("Business Email entered is the same as in pre-req");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ENTERED_SAME_AS_PRE_REQ, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Business Email entered is NOT the same as in pre-req");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_EMAIL_ENTERED_SAME_AS_PRE_REQ, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Business Email field is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    	
    }
    
	// To verify "Subject" and "Message" fields are entered with text.
	public static WebElement check_subjectMessageFieldsEnteredWithText(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataSubject, String dataMessage) throws Exception{
		try{
			String textEnteredInSubject = driver.findElement(By.id("subjectId")).getAttribute("value");
			Add_Log.info("Print text entered in Subject field ::" + textEnteredInSubject);
			
			String textEnteredInMessage = driver.findElement(By.id("inquiry_remarks")).getAttribute("value");
			Add_Log.info("Print text entered in Message field ::" + textEnteredInMessage);
			
			if(textEnteredInSubject.equals(dataSubject) && textEnteredInMessage.equals(dataMessage)){
				Add_Log.info("Subject and Message fields are entered with text.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_SUBJECT_MSG_FIELDS_ENTERED_WITH_TEXT, rowNum, Constant.KEYWORD_PASS);
			}else{
				Add_Log.info("Subject and Message fields are NOT entered with text.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_SUBJECT_MSG_FIELDS_ENTERED_WITH_TEXT, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
			}
			
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
    /**
     * To verify text entered in 'subject and 'message' fields are remain unchanged.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param dataSubject
     * @param dataMessage
     * @return
     * @throws Exception
     */
    public static WebElement check_textSubjectMessageRemainUnchanged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataSubject, String dataMessage) throws Exception{
    	try{
				// Get the text entered in 'subject' field
	            String textEnteredInSubject = driver.findElement(By.id("subjectId")).getAttribute("value");
	            
	            // Get the text entered in 'message' field
	    		/*WebElement iframeMsg= driver.findElement(By.xpath("//*[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));
	    		driver.switchTo().frame(iframeMsg);    		    		
	    		WebElement iframeBodyMsg = driver.findElement(By.cssSelector("body"));
	    		// Get the text entered in 'message' field
	    		String textEnteredInMessage = iframeBodyMsg.getText();*/
	            
	            String textEnteredInMessage = driver.findElement(By.name("inquiry_remarks")).getAttribute("value");
	            
	    		// To switch back to default frame
	    		// driver.switchTo().defaultContent();	    		       
	
	            if( (textEnteredInSubject.equals(dataSubject)) && (textEnteredInMessage.equals(dataMessage)) ){
	            	
	            	Add_Log.info("The texts entered in 'Subject' and 'Message' fields are remain unchanged.");
	            	SuiteUtility.WriteResultUtility(xls, sheetName, 
							Constant.COL_TEXT_SUBJECT_MSG_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
	            }else{
	            	
	            	Add_Log.info("The texts entered in 'Subject' and 'Message' fields are changed.");
	            	SuiteUtility.WriteResultUtility(xls, sheetName, 
							Constant.COL_TEXT_SUBJECT_MSG_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
					testFail.set(0, true);
	            }    			
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify text entered in 'subject', 'message', and 'country in which product(s) will be sold' fields are remain unchanged.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param dataSubject
     * @param dataMessage
     * @param dataTargetCountry
     * @return
     * @throws Exception
     */
    public static WebElement check_textSubjectMessageTargetCountryRemainUnchanged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataSubject, String dataMessage, String dataTargetCountry) throws Exception{
    	try{
    		WebDriverWait waits = new WebDriverWait(driver, 25);
    		waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("subjectId")));
    		
			// Get the text entered in 'subject' field
            String textEnteredInSubject = driver.findElement(By.id("subjectId")).getAttribute("value");
            Add_Log.info("Print text entered in subject field ::" + textEnteredInSubject);
            
            // Get the text entered in 'message' field
    		/*WebElement iframeMsg = driver.findElement(By.xpath("//*[contains(@class, 'cke_wysiwyg_frame cke_reset')]"));
    		driver.switchTo().frame(iframeMsg);    		    		
    		WebElement iframeBodyMsg = driver.findElement(By.cssSelector("body")); 
    		String textEnteredInMessage = iframeBodyMsg.getText();*/
            String textEnteredInMessage = driver.findElement(By.name("inquiry_remarks")).getAttribute("value");
            Add_Log.info("Print text entered in message field ::" + textEnteredInMessage);
    		                         		    	
    		// To switch back to default frame
    		// driver.switchTo().defaultContent();
    		
    		// Get the text entered in 'country in which product(s) will be sold' field
            String textEnteredInTargetCountry = driver.findElement(By.id("countryId")).getAttribute("value");
            Add_Log.info("Print text entered in country field ::" + textEnteredInTargetCountry);
            
            if( (textEnteredInSubject.equals(dataSubject)) && (textEnteredInMessage.equals(dataMessage)) 
            		&& (textEnteredInTargetCountry.equals(dataTargetCountry)) ){
            	
            	Add_Log.info("The texts entered in 'Subject', 'Message' and "
            			+ "'Country in which product(s) will be sold:' fields are remain unchanged.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_TEXT_SUBJECT_MSG_TARGET_COUNTRY_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
            }else{
            	
            	Add_Log.info("The texts entered in 'Subject', 'Message' and "
            			+ "'Country in which product(s) will be sold:' fields are changed.");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_TEXT_SUBJECT_MSG_TARGET_COUNTRY_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
				testFail.set(0, true);
            }

    	}catch(Exception e){
    		Add_Log.error("Error! 'subject', 'message', and 'country in which product(s) will be sold' fields is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    // To verify the text entered in "Subject", "Message" and "Number of Samples" are remain unchanged.
    public static WebElement check_subjectMessageAndNumOfSamplesRemainUnchanged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataSubject, String dataMessage, String dataNumOfSamples) throws Exception{
    	try{
			// Get the text entered in 'subject' field
            String textEnteredInSubject = driver.findElement(By.id("subjectId")).getAttribute("value");
            Add_Log.info("Print text entered in subject field ::" + textEnteredInSubject);
            
            // Get the text entered in 'message' field
            String textEnteredInMessage = driver.findElement(By.name("inquiry_remarks")).getAttribute("value");
            Add_Log.info("Print text entered in message field ::" + textEnteredInMessage);
            
            // Get the text entered in 'number of samples' field
            String textEnteredInNumOfSamples = driver.findElement(By.id("EOQId")).getAttribute("value");
            Add_Log.info("Print text entered in number of samples field ::" + textEnteredInNumOfSamples);
            
            if( (textEnteredInSubject.equals(dataSubject)) && (textEnteredInMessage.equals(dataMessage)) 
            		&& (textEnteredInNumOfSamples.equals(dataNumOfSamples)) ){
            	Add_Log.info("The text entered in 'Subject', 'Message' and 'Number of Samples' are remain unchanged");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_TEXT_SUBJECT_MSG_NUMOFSAMPLES_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
            }else{
            	Add_Log.info("The text entered in 'Subject', 'Message' and 'Number of Samples' are changed");
            	SuiteUtility.WriteResultUtility(xls, sheetName, 
						Constant.COL_TEXT_SUBJECT_MSG_NUMOFSAMPLES_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
            	testFail.set(0, true);
            }
            
    	}catch(Exception e){
    		Add_Log.error("Error! 'subject', 'message', and 'number of samples' fields is NOT found on the page");
    		throw(e);
    	}
    	return element;
    }
    
    
	// ===================================================== Start of Mandatory fields checking =====================================================    
    
    /**
     * To verify that on the mandatory fields (fields with *), the validation message is displayed in a red color box.
     * 
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
    		// 23-Feb-2017 MR#45847 
    		String errorMsgMessageField = driver.findElement(
    				By.xpath("//*[@id= 'ReqdMessage'][contains(text(),'Please enter your message.')]")).getCssValue("color");
    		String errorMsgFirstName = driver.findElement(
    				By.xpath("//*[@id= 'ReqdFirstName'][contains(text(),'Enter your First/Given Name')]")).getCssValue("color");
    		String errorMsgLastName = driver.findElement(
    				By.xpath("//*[@id= 'ReqdLastName'][contains(text(),'Enter your Last/Family Name')]")).getCssValue("color");
    		String errorMsgBusinessEmail = driver.findElement(
    				By.xpath("//*[@id= 'ReqdEmail'][contains(text(),'Please enter your business e-mail address')]")).getCssValue("color");
    		String errorMsgCompName = driver.findElement(
    				By.xpath("//*[@id= 'ReqdCompanyName'][contains(text(),'Please enter company name.')]")).getCssValue("color");    		
    		String errorMsgCountryCode = driver.findElement(
    				By.xpath("//*[@id= 'ReqdPhoneCtryCode'][contains(text(),'Please enter your country code.')]")).getCssValue("color");
    		String errorMsgTelNumber = driver.findElement(
    				By.xpath("//*[@id= 'ReqdPhone'][contains(text(),'Please enter your telephone number.')]")).getCssValue("color"); 		    	
    		String errorMsgCompWebsiteURL = driver.findElement(
    				By.xpath("//*[@id= 'ReqdWebsiteError'][contains(text(),'Please enter your company website URL.')]")).getCssValue("color"); 	
    		
    /*		element = driver.findElement(By.xpath("//*[@id= 'ReqdFirstName']//*[contains(text(),'Enter your First/Given Name')]"));
    		String fontColor = element.getCssValue("color");
    		String fontBackgroundColor = element.getCssValue("background-color");
    //		String errorMsgColor = driver.findElement(
    //				By.xpath("//*[@id= 'ReqdFirstName']//*[contains(text(),'Enter your First/Given Name')]")).getCssValue("color");
    		Add_Log.info("font color ::" + fontColor);
    		Add_Log.info("background color ::" + fontBackgroundColor);
    		
    		String redFromHex = Color.fromString("#CC0000").asHex();
    		Add_Log.info("red from hex ::" + redFromHex);		*/
    		
    		String redFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		Add_Log.info("red from rgb ::" + redFromRGB);
    		    		
    		if(errorMsgMessageField.equals(redFromRGB) && errorMsgFirstName.equals(redFromRGB) && errorMsgLastName.equals(redFromRGB) 
    				&& errorMsgBusinessEmail.equals(redFromRGB) && errorMsgCompName.equals(redFromRGB) && errorMsgCountryCode.equals(redFromRGB) 
    				&& errorMsgTelNumber.equals(redFromRGB) && errorMsgCompWebsiteURL.equals(redFromRGB)){
    			
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
    		Add_Log.error("Error! On the mandatory fields, the validation message is NOT displayed in a red color box.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify error message for invalid Business Email without at-sign is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgBusinessEmailWithoutAtSign(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{   			
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidEmail1'][contains(text(),'This field must be a single, "
    				+ "valid e-mail address (like yourname@company.com). Please re-enter it now.')]"));		
    		    	
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Is error msg business email without @ sign visible ::" + isErrorMsgVisible);    		
    		
    		String fontColorErrorMsgBusinessEmail = element.getCssValue("color");
    	//	String backgroundColorErrorMsgBusinessEmail = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    	//	String redBackgroundFromRGB = Color.fromString("rgb(255, 235, 235)").asRgba();    		    		
    		
        	if((isErrorMsgVisible == true) && (fontColorErrorMsgBusinessEmail.equals(redFontFromRGB))){
        		Add_Log.info("Error message for invalid Business Email without at-sign is displayed"); 
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_WITHOUT_ATSIGN, rowNum, Constant.KEYWORD_PASS);
        	}else{
        		Add_Log.info("Error message for invalid Business Email without at-sign is NOT displayed"); 
        		SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_WITHOUT_ATSIGN, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
        	}
        	
        	InquiryForm_Page.txtbx_enterBusinessEmail().clear();
        	
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
        
    /**
     * To verify error message for invalid Business Email (special character) 
     * 'Please enter only characters A-Z a-z 0-9 . @ _ - for E-mail Address.' is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgBusinessEmailWithSpecialChar(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    	/*	element = driver.findElement(By.xpath("//*[@id= 'InvalidEmail2']"));
    		WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));	*/
			
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidEmail2'][contains(text(),"
    								+ "'Please enter only characters A-Z a-z 0-9 . @ _ - for E-mail Address.')]"));

    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Is error msg for invalid Business Email with special char visible ::" + isErrorMsgVisible);    		  				
    				
    		String fontColorErrorMsgBusinessEmail = element.getCssValue("color");
    	//	String backgroundColorErrorMsgBusinessEmail = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    	//	String redBackgroundFromRGB = Color.fromString("rgb(255, 235, 235)").asRgba();    		
    		
    		if(isErrorMsgVisible == true && fontColorErrorMsgBusinessEmail.equals(redFontFromRGB)){
    			
    			Add_Log.info("Error message for invalid Business Email 'Please enter only characters "
    					+ "A-Z a-z 0-9 . @ _ - for E-mail Address.' is displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_WITH_SPECIAL_CHAR, rowNum, Constant.KEYWORD_PASS);
    		} else{
    			Add_Log.info("Error message for invalid Business Email 'Please enter only characters "
    					+ "A-Z a-z 0-9 . @ _ - for E-mail Address.' is NOT displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_BUSINESS_EMAIL_WITH_SPECIAL_CHAR, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
    		}
    		
    		InquiryForm_Page.txtbx_enterBusinessEmail().clear();
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify error message for invalid Contact Phone Number 'Please enter only numbers. You may separate the numbers with spaces.' 
     * is displayed in a red color box.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
/*    public static WebElement check_errorMsgInvalidContactPhoneNumber(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidPhone']//*[contains(text(),"
    								+ "'Please enter only numbers. You may separate the numbers with spaces.')]"));
    		String fontColorErrorMsgContactPhoneNumber = element.getCssValue("color");
    		String backgroundColorErrorMsgContactPhoneNumber = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    		String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
    		
    		if(fontColorErrorMsgContactPhoneNumber.equals(redFontFromRGB) 
    				&& backgroundColorErrorMsgContactPhoneNumber.equals(redBackgroundColorErrorMsg)){
    			Add_Log.info("Error message 'Please enter only numbers. You may separate the numbers with spaces.' "
    					+ "is displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_CONTACT_PHONE_NUMBER, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message 'Please enter only numbers. You may separate the numbers with spaces.' "
    					+ "is NOT displayed in a red color box");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_CONTACT_PHONE_NUMBER, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }	*/
    
    /**
     * To verify error message for invalid Contact Phone Number (Country Code) field, 
     * 'Please enter only number.' is displayed in a red color box.
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
    		// 23-Feb-2017 MR#45847 
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidPhone'][contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error message for invalid Country Code is visible ::" + isErrorMsgVisible);
    		
    		String fontColorErrorMsgCountryCode = element.getCssValue("color");
    	//	String backgroundColorErrorMsgCountryCode = element.getCssValue("background-color");
    		
    		String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
    	//	String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
    		
    		if(isErrorMsgVisible == true && fontColorErrorMsgCountryCode.equals(redFontFromRGB)){
    			Add_Log.info("Error message for invalid Country Code 'Please enter only numbers.' is displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_COUNTRY_CODE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Country Code 'Please enter only numbers.' is NOT displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_COUNTRY_CODE, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
    		}
    		
    		InquiryForm_Page.txtbx_enterContactNumberCountryCode().clear();
    		
    	}catch(Exception e){
    		Add_Log.error("Error! Error message for invalid Country Code is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify error message for invalid Contact Phone Number (Area Code) field, 
     * 'Please enter only number.' is displayed in a red color box.
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
    		// 23-Feb-2017 MR#45847
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidPhone'][contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error message for invalid Area Code is visible ::" + isErrorMsgVisible);
    		    		
			String fontColorErrorMsgAreaCode = element.getCssValue("color");
		//	String backgroundColorErrorMsgAreaCode = element.getCssValue("background-color");
			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
		//	String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsgAreaCode.equals(redFontFromRGB)){
				Add_Log.info("Error message for invalid Area Code 'Please enter only numbers.' is displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_AREA_CODE, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Area Code 'Please enter only numbers.' is NOT displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_AREA_CODE, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
			}
			
			InquiryForm_Page.txtbx_enterContactNumberAreaCode().clear();
			
    	}catch(Exception e){
    		Add_Log.error("Error! Error message for invalid Area Code is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify error message for invalid Contact Phone Number (Telephone Number) field,
     * 'Please enter only number.' is displayed in a red color box.
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
    		// 23-Feb-2017 MR#45847
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidPhone'][contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error message for invalid Telephone Number visible ::" + isErrorMsgVisible);
    		
			String fontColorErrorMsgTelNo = element.getCssValue("color");
		//	String backgroundColorErrorMsgTelNo = element.getCssValue("background-color");
			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
		//	String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsgTelNo.equals(redFontFromRGB)){
				Add_Log.info("Error message for invalid Telephone Number 'Please enter only numbers.' is displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_NUMBER, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Telephone Number'Please enter only numbers.' is NOT displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_NUMBER, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
			}
			
			InquiryForm_Page.txtbx_enterContactNumberTelephoneNumber().clear();
			
    	}catch(Exception e){
    		Add_Log.error("Error! Error message for invalid Tel Number is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }    
    
    /**
     * To verify error message for invalid Contact Phone Number (Ext) field,
     * 'Please enter only number.' is displayed in a red color box.
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
    		// 23-Feb-2017 MR#45847
    		element = driver.findElement(By.xpath("//*[@id= 'InvalidPhone'][contains(text(),'Please enter only numbers.')]"));
    		Boolean isErrorMsgVisible = element.isDisplayed();
    		Add_Log.info("Error msg for invalid Telephone Ext visible ::" + isErrorMsgVisible);
    		    		
			String fontColorErrorMsgPhoneExt = element.getCssValue("color");
		//	String backgroundColorErrorMsgPhoneExt = element.getCssValue("background-color");
			
			String redFontFromRGB = Color.fromString("rgb(204, 0, 0)").asRgba();
		//	String redBackgroundColorErrorMsg = Color.fromString("rgb(255, 235, 235)").asRgba();
			
			if(isErrorMsgVisible == true && fontColorErrorMsgPhoneExt.equals(redFontFromRGB)){
				Add_Log.info("Error message for invalid Telephone Ext 'Please enter only numbers.' is displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_EXT, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Error message for invalid Telephone Ext 'Please enter only numbers.' is NOT displayed");
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_INV_TELEPHONE_EXT, rowNum, Constant.KEYWORD_FAIL);        		
        		testFail.set(0, true);
			}
			
			InquiryForm_Page.txtbx_enterContactNumberExtNumber().clear();
			
    	}catch(Exception e){
    		Add_Log.error("Error! Error message for invalid Ext is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify error message for invalid Message field 'Please enter minimum 20 characters.' is available on the page.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @return
     * @throws Exception
     */
    public static WebElement check_errorMsgMessageFieldMin20Char(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[@id= 'ReqdMinLengthMessage'][contains(text(),'Please enter minimum 20 characters.')]"));
    		Boolean isErrorMsgExists = element.isDisplayed();

    		Add_Log.info("Is error message for invalid Message field "
    				+ "'Please enter minimum 20 characters.' available ::" + isErrorMsgExists);    		
    		
    		if(isErrorMsgExists == true){
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_MESSAGE_FIELD_MIN_20_CHAR, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
        				xls, sheetName, Constant.COL_ERROR_MSG_MESSAGE_FIELD_MIN_20_CHAR, rowNum, Constant.KEYWORD_FAIL);
        		testFail.set(0, true);	
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify all the tip boxes/messages are displayed correctly.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_verifyAllTipBoxesAndMessage(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		
    		// Tip box for 'Subject' field
    		InquiryForm_Page.txtbx_enterSubject().sendKeys("");
    		
    		WebElement subjectElement = driver.findElement(By.xpath("//*[@id='subjectId_tip']"
    				+ "[contains(text(),'Example: Inquiry about 5-disc DVD player for US Market')]"));
    		Boolean isTipBoxSubjectVisible = subjectElement.isDisplayed();
    		
    		if(isTipBoxSubjectVisible == true){
    			Add_Log.info("Subject tip boxes are displayed correctly");    			
    		}else{
    			Add_Log.info("Subject tip boxes are NOT displayed correctly");    			
    		}
    		
    		// Tip box for 'EOQ' field
    		InquiryForm_Page.txtbx_enterExpectedOrderQuantity().sendKeys("");
    		
    		WebElement EOQElement = driver.findElement(
    				By.xpath("//*[@id='EOQId_tip'][contains(text(),'Example: 10000')]"));
    		Boolean isTipBoxEOQVisible = EOQElement.isDisplayed();
    		
    		if(isTipBoxEOQVisible == true){
    			Add_Log.info("EOQ tip boxes are displayed correctly");    			
    		}else{
    			Add_Log.info("EOQ tip boxes are NOT displayed correctly");    			
    		}
    		
    		// Tip box for 'Message' field
    		WebElement messageElement = driver.findElement(By.xpath("//*[contains(@class, 'formTipPopBox')]"));
    		Boolean isTipBoxMsgVisible = messageElement.isDisplayed();
    		
    		if(isTipBoxMsgVisible == true){
    			Add_Log.info("Message tip boxes are displayed correctly");
    		}else{
    			Add_Log.info("Message tip boxes are NOT displayed correctly");
    		}
    		
    		
    		// Tip box for 'Business E-mail' field
    		InquiryForm_Page.txtbx_enterBusinessEmail().sendKeys("");
    		
    		WebElement bussinessEmailElement = driver.findElement(By.xpath("//*[@id='emailId_tip']"
    				+ "[contains(text(),'For better supplier response, use your business e-mail address.')]"));
    		Boolean isTipBoxBussinessEmailVisible = bussinessEmailElement.isDisplayed();
    		
    		if(isTipBoxBussinessEmailVisible == true){
    			Add_Log.info("Business E-mail tip boxes are displayed correctly");    			
    		}else{
    			Add_Log.info("Business E-mail tip boxes are NOT displayed correctly");    			
    		}
    		
    		// Tip box for 'Company Website URL' field
    		InquiryForm_Page.txtbx_enterCompanyWebsiteURL().sendKeys("");
    		
    		// Date 21-Dec-2016 New MR Please enter your company website URL.
    	//	WebElement compURLElement = driver.findElement(By.xpath("//*[@id='cwurlId_tip']"
    	//			+ "//*[contains(text(),'Enter your Company Website URL or leave this field empty if none.')]"));
    		WebElement compURLElement = driver.findElement(By.xpath("//*[contains(@class, 'formTipCon')]"
    				+ "[contains(text(),'Tip: Suppliers are more responsive when buyers provide their company website or online store URL.')]"));
    		Boolean isTipBoxCompURLVisible = compURLElement.isDisplayed();
    		
    		if(isTipBoxCompURLVisible == true){
    			Add_Log.info("Company Website URL tip boxes are displayed correctly");    			
    		}else{
    			Add_Log.info("Company Website URL tip boxes are NOT displayed correctly");    			
    		}
    		
    		
    		InquiryForm_Page.lnk_clickMoreBusinessDetails().click();
    		
    		// Tip box for 'Country in which product(s) will be sold' field
    		InquiryForm_Page.txtbx_enterTargetCountry().sendKeys("");
    		
    		WebElement targetCountryElement = driver.findElement(By.xpath("//*[@id='countryId_tip']"
    				+ "[contains(text(),'Enter the country or countries where you plan to sell products')]"));
    		Boolean isTipBoxTargetCountryVisible = targetCountryElement.isDisplayed();
    		
    		if(isTipBoxTargetCountryVisible == true){
    			Add_Log.info("Target Country tip boxes are displayed correctly");    			
    		}else{
    			Add_Log.info("Target Country tip boxes are NOT displayed correctly");    			
    		}
    		
    		// Tip box for 'Linkedln Profile URL' field
    		InquiryForm_Page.txtbx_enterLinkedlnProfileURL().sendKeys("");
    		
    		WebElement linkedlnElement = driver.findElement(By.xpath("//*[@id='linkedInInput_tip']"
    				+ "[contains(text(),'Enter your LinkedIn Profile URL or leave this field empty if none')]"));
    		Boolean isTipBoxLinkedlnVisible = linkedlnElement.isDisplayed();
    		
    		if(isTipBoxLinkedlnVisible == true){
    			Add_Log.info("Linkedln Profile URL tip boxes are displayed correctly");    			
    		}else{
    			Add_Log.info("Linkedln Profile URL tip boxes are NOT displayed correctly");    			
    		}
    		
    		// Tip box for 'Business Address' field
    		InquiryForm_Page.txtbx_enterBusinessAddress().sendKeys("");
    		
    		WebElement businessAddrElement = driver.findElement(By.xpath("//*[@id='addressId_tip']"
    				+ "[contains(text(),'To see more address fields, click on [+]')]"));
    		Boolean isTipBoxBusinessAddrVisible = businessAddrElement.isDisplayed();
    		
    		if(isTipBoxBusinessAddrVisible == true){
    			Add_Log.info("Business Address URL tip boxes are displayed correctly");    			
    		}else{
    			Add_Log.info("Business Address URL tip boxes are NOT displayed correctly");    			
    		}
    		
    		// Tip box for 'Tell the supplier about your company' field
    		InquiryForm_Page.txtbx_enterTellSupplierField().sendKeys("");
    		
    		WebElement tellSuppElement = driver.findElement(By.xpath("//*[@id='tellSupplierId_tip']"));
    		Boolean isTipBoxTellSuppVisible = tellSuppElement.isDisplayed();
    		
    		if(isTipBoxTellSuppVisible == true){
    			Add_Log.info("Tell Supplier tip boxes are displayed correctly");
    		}else{
    			Add_Log.info("Tell Supplier tip boxes are NOT displayed correctly");
    		}
    		
    		
    		if(isTipBoxSubjectVisible == true && isTipBoxEOQVisible == true && isTipBoxBussinessEmailVisible == true &&
    				isTipBoxCompURLVisible == true && isTipBoxTargetCountryVisible == true && isTipBoxLinkedlnVisible == true &&
    				isTipBoxBusinessAddrVisible == true && isTipBoxTellSuppVisible == true){
    			
    			Add_Log.info("All the tip boxes/message are displayed correctly");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_TIP_BOXES_MSG_DISPLAYED_CORRECTLY, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("All the tip boxes/message are NOT displayed correctly");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_ALL_TIP_BOXES_MSG_DISPLAYED_CORRECTLY, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Error! Tip boxed/message are NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
	// ====================================================== End of Mandatory fields checking ======================================================
       
    /**
     * To verify the text entered in RFI static form are remain in the Message field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataMessage
     * @return
     * @throws Exception
     */
    public static WebElement check_textEnteredInRFIStaticFormRemainUnchanged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataMessage) throws Exception{
    	try{
    		// Get the text entered in 'message' field
    		String textEnteredInMessage = driver.findElement(By.name("inquiry_remarks")).getAttribute("value");  
    		
    		if(textEnteredInMessage.equals(dataMessage)){
    			Add_Log.info("The text entered in RFI Static Form are remain in the Message field");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_STATIC_FORM_TEXT_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The text entered in RFI Static Form are NOT remain in the Message field");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_STATIC_FORM_TEXT_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("RFI static form is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify the text entered in RFI Floating Window are remain in the Message field.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @param dataMessageRFIFloatingWindow
     * @return
     * @throws Exception
     */
    public static WebElement check_textEnteredInRFIFloatingWindowRemainUnchanged(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail, String dataMessage) throws Exception{
    	try{
            // Get the text entered in 'message' field
    		String textEnteredInMessage = driver.findElement(By.name("inquiry_remarks")).getAttribute("value");    	
    		
    		if(textEnteredInMessage.equals(dataMessage)){
    			Add_Log.info("The text entered in RFI Floating Window are remain in the Message field");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_TEXT_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("The text entered in RFI Floating Window are NOT remain in the Message field");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_RFI_FLOATING_WINDOW_TEXT_REMAIN_UNCHANGED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("RFI Floating window is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
    
	// ======================================================== Module Buyer Profile checking =======================================================
    
    /**
     * To verify same expected result as step 1 to 4.
     * Applied to test case 26A, 26F.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_sameExpResultAsStep1to4(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 1. To verify RFI form is displayed.
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources -- Inquiry Form"));
    		
    		// 2. The following options are available in the Buyer Profile section:
    		//    a) Yes, include my Buyer Profile for this inquiry
    		//    b) No, do not send this time
    		//    c) "Remember my preference" checkbox is available
    		Boolean isBuyerProfileOptionYesExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]"
    						+ "//*[contains(text(),'Yes, include my Buyer Profile for this inquiry')]")).size()!= 0;
    		
    		Boolean isBuyerProfileOptionNoExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]"
    						+ "//*[contains(text(),'No, do not send this time')]")).size() != 0;
    		
    		Boolean isChkbxExists = driver.findElements(By.name("remember_my_pref")).size() != 0;
    		
    		Add_Log.info("Is radio button 'Yes, include my Buyer Profile for this inquiry' exists ::" + isBuyerProfileOptionYesExists);
    		Add_Log.info("Is radio button 'No, do not send this time' exists ::" + isBuyerProfileOptionNoExists);
    		Add_Log.info("Is checkbox 'Remember my preference' exists ::" + isChkbxExists);
    		
    		// 3. To verify Option 'Yes, include my Buyer Profile for this inquiry' is checked as default.
    		Boolean isRadbtnCheckedAsDefault = 
    				driver.findElement(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]//input[@value='Y']")).isSelected();
    		
    		Add_Log.info("Is radio button 'Yes, include my Buyer Profile for this inquiry' "
    				+ "checked as default ::" + isRadbtnCheckedAsDefault);
    		
    		// 4. To verify "Remember my preference" is checked as default.
    		Boolean isChkbxCheckedAsDefault = driver.findElement(By.name("remember_my_pref")).isSelected();
    		Add_Log.info("Is Remember my preference checkbox selected as default ::" + isChkbxCheckedAsDefault);
    		
    		if(driver.getTitle().equals("Global Sources -- Inquiry Form") && isBuyerProfileOptionYesExists == true
    				&& isBuyerProfileOptionNoExists == true && isChkbxExists == true 
    				&& isRadbtnCheckedAsDefault == true && isChkbxCheckedAsDefault == true){
    			Add_Log.info("Inquiry form is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SAME_EXP_RESULT_AS_STEP_1TO4, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Inquiry form is NOT displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SAME_EXP_RESULT_AS_STEP_1TO4, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify same expected result as step 1 to 2.
     * Applied to test case 26A.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_sameExpResultAsStep1to2(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		// 1. To verify RFI form is displayed.
    		WebDriverWait wait = new WebDriverWait(driver, 25);
    		wait.until(ExpectedConditions.titleIs("Global Sources -- Inquiry Form"));
    		
    		// 2. The following options are available in the Buyer Profile section:
    		//    a) Yes, include my Buyer Profile for this inquiry
    		//    b) No, do not send this time
    		//    c) "Remember my preference" checkbox is available
    		Boolean isBuyerProfileOptionYesExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]"
    						+ "//*[contains(text(),'Yes, include my Buyer Profile for this inquiry')]")).size()!= 0;
    		
    		Boolean isBuyerProfileOptionNoExists = 
    				driver.findElements(By.xpath("//*[contains(@class, 'RFI_buyerProfile')]"
    						+ "//*[contains(text(),'No, do not send this time')]")).size() != 0;
    		
    		Boolean isChkbxExists = driver.findElements(By.name("remember_my_pref")).size() != 0;
    		
    		Add_Log.info("Is radio button 'Yes, include my Buyer Profile for this inquiry' exists ::" + isBuyerProfileOptionYesExists);
    		Add_Log.info("Is radio button 'No, do not send this time' exists ::" + isBuyerProfileOptionNoExists);
    		Add_Log.info("Is checkbox 'Remember my preference' exists ::" + isChkbxExists);
    		
    		if(driver.getTitle().equals("Global Sources -- Inquiry Form") && isBuyerProfileOptionYesExists == true
    				&& isBuyerProfileOptionNoExists == true && isChkbxExists == true){
    			Add_Log.info("Inquiry form is displayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SAME_EXP_RESULT_AS_STEP_1TO2, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			Add_Log.info("Inquiry form is NOT dislayed.");
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_BUYER_PROFILE_SAME_EXP_RESULT_AS_STEP_1TO2, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
    /**
     * To verify Login overlay is displayed.
     * 
     * @param xls
     * @param sheetName
     * @param rowNum
     * @param testFail
     * @return
     * @throws Exception
     */
    public static WebElement check_loginOverlayIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
    		List<Boolean> testFail) throws Exception{
    	try{
    		element = driver.findElement(By.xpath("//*[contains(@class, 'GS_loginFrame')]"));
    		Boolean isLoginOverlayExists = element.isDisplayed();
    		Add_Log.info("Is Login overlay displayed ::" + isLoginOverlayExists);
    		
    		if(isLoginOverlayExists == true){
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LOGIN_OVERLAY_IS_DISPLAYED, rowNum, Constant.KEYWORD_PASS);
    		}else{
    			SuiteUtility.WriteResultUtility(
    					xls, sheetName, Constant.COL_LOGIN_OVERLAY_IS_DISPLAYED, rowNum, Constant.KEYWORD_FAIL);
    			testFail.set(0, true);
    		}
    	}catch(Exception e){
    		Add_Log.error("Login overlay is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
    
}
