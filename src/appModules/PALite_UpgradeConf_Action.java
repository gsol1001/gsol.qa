/**
 * This Class contains all the methods in the PA Lite Upgrade Confirmation Action.
 * Created: Oct 14 Oct 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/14
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.PALite_UpgradeConf_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the PA Lite Upgrade Confirmation action.
 * @author Teng Shyh Wei
 *
 */
public class PALite_UpgradeConf_Action {

	/**
	 * To verify PA Lite upgrade confirmation page is displayed. 
	 * To verify that the PA categories selected in Select PA Category page are displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedCatNameList
	 * @throws Exception
	 */
	public static void ExecutePALiteUpgConfPage_PACatSelAreDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
		
		// To verify PA Lite upgrade confirmation page is displayed. 
		PALite_UpgradeConf_Page.check_PALiteUpgConfPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the PA categories selected in Select PA Category page are displayed.
		PALite_UpgradeConf_Page.check_PACatSelectedIsDisplayed(xls, sheetName, rowNum, testFail, checkedCatNameList);
		
	}
	
}
