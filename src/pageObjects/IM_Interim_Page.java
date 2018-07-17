/**
 * This Class contains methods that represent the locators available on IM Interim Page
 * Created: Thu 01 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/01
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contains methods that represent the locators available on IM Interim page.
 * @author Teng Shyh Wei
 *
 */
public class IM_Interim_Page extends BaseClass{
	
	private static WebElement element = null;
	
    public IM_Interim_Page(WebDriver driver){
    	super(driver);
    }

    // To verify IM Interim page with message "Contact <xx suppliers> using xxx Messenger" is displayed.
    public static WebElement check_msgContactSuppliersExists() throws Exception{
    	try{
    		
    	}catch(Exception e){
    		throw(e);
    	}
    	return element;
    }
    
}
