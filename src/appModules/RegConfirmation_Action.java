/**
 * This Class contains all the methods in the Registration Confirmation Action
 * Created: Wed 22 Jul 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/22
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.RegistrationConfirmation_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the Registration Confirmation action.
 * @author Teng Shyh Wei
 *
 */
public class RegConfirmation_Action {
	
	/**
	 * To verify Registration confirmation page is displayed. 
	 * Verify that "You've also requested sourcing magazines." statement exists and 
	 * the PA categories selected in Select PA Categories page are displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedCatNameList
	 * @throws Exception
	 */
	public static void ExecuteRegConfPage_ReqSMCopy_PACatSelIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
		
		// To verify Registration confirmation page is displayed. 
		RegistrationConfirmation_Page.check_regConfirmationPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify "You've also requested sourcing magazines." statement exists.
		RegistrationConfirmation_Page.check_reqSourcingMagazinesCopyExists(xls, sheetName, rowNum, testFail);
		
	    // To verify PA categories selected in Select Product Alert Categories page is displayed.
		RegistrationConfirmation_Page.check_PACatSelectedIsDisplayed(xls, sheetName, rowNum, testFail, checkedCatNameList);
	}

	/**
	 * To verify Registration confirmation page is displayed. 
	 * Verify that "You've also requested sourcing magazines." statement is NOT exists and 
	 * the PA categories selected in Select PA Categories are displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedCatNameList
	 * @throws Exception
	 */
	public static void ExecuteRegConfPage_NoReqSMCopy_PACatSelIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
		
		// To verify Registration confirmation page is displayed. 
		RegistrationConfirmation_Page.check_regConfirmationPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify "You've also requested sourcing magazines." statement not exists.
		RegistrationConfirmation_Page.check_reqSourcingMagazinesCopyNotExists(xls, sheetName, rowNum, testFail);
		
	    // To verify PA categories selected in Select Product Alert Categories page is displayed.
		RegistrationConfirmation_Page.check_PACatSelectedIsDisplayed(xls, sheetName, rowNum, testFail, checkedCatNameList);
		
	}
	
	/**
	 * To verify the Registration confirmation page is displayed.
	 * Verify that "You've also requested sourcing magazines." statement is NOT exists and
	 * the PA categories selected in PA Catfish Banner are displayed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedCatNameList
	 * @throws Exception
	 */
	public static void ExecuteRegConfPage_NoReqSMCopy_PACatSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, List<String> checkedCatNameList) throws Exception{
		
		// To verify the Registration confirmation page is displayed.
		RegistrationConfirmation_Page.check_regConfirmationPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that "You've also requested sourcing magazines." statement is not exists.
		RegistrationConfirmation_Page.check_reqSourcingMagazinesCopyNotExists(xls, sheetName, rowNum, testFail);
		
		// To verify that the PA categories selected in PA Catfish Banner are displayed.
		RegistrationConfirmation_Page.check_PACatSelectedInPACatfishBannerIsDisplayed(xls, sheetName, rowNum, testFail, checkedCatNameList);
		
	}

}
