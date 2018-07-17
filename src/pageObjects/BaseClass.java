/**
 * Framework - GSOL Automation Selenium Testing
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

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Base Class
 * @author Teng Shyh Wei
 *
 */
public class BaseClass {
	
	public static Logger Add_Log = null;
	public static WebDriver driver;
	//public static boolean bResult;
	
	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		//BaseClass.bResult = true;
		Add_Log = Logger.getLogger("rootLogger");
	}	
}
