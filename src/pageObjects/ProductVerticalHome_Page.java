/**
 * This Class contains methods that represent the locators available on Product Vertical Homepage
 * Created: Thu 03 Sep 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/09/03
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contains methods that represent the locators available on Product Vertical Home page.
 * @author Teng Shyh Wei
 *
 */
public class ProductVerticalHome_Page extends BaseClass{

	private static WebElement element = null;
	
    public ProductVerticalHome_Page(WebDriver driver){
        	super(driver);
    }  
    
    /**
     * Click on 'please select categories' hyperlink.
     * 
     * @return
     * @throws Exception
     */
    public static WebElement lnk_clickPleaseSelectCategories() throws Exception{
    	try{
    		element = driver.findElement(
    				By.xpath("//*[contains(@class, 'ME_seeAll_link')]//a[contains(text(),'please select categories')]"));
    		Add_Log.info("'Please select categories' link is click on the page.");
    		
    	}catch(Exception e){
    		Add_Log.error("'Please select categories' link is NOT found on the page.");
    		throw(e);
    	}
    	return element;
    }
}
