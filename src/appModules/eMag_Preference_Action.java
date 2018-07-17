/**
 * This Class contains all the methods in the eMag Preference Action.
 * Created: Wed 15 July 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/15
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.GlobalNav_MenuBar;
import pageObjects.eMag_Preference_Page;
import pageObjects.UserProfile_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the eMag Preference action.
 * @author Teng Shyh Wei
 *
 */
public class eMag_Preference_Action {

	/**
	 * As a logged in user, go to eMag Preference page.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteLoggedInUser_GoToeMagPrefPage(String dataUsername, String dataPassword) throws Exception{
		
		// Login to GSOL
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Generate mouse hover event on Global Notification to click on User Profile.
		GlobalNav_MenuBar.menuBar_selectUserProfile();
		
		// To click on the 'Sourcing Magazines' link at the left nav.
		UserProfile_Page.lnk_clickSideBarSourcingMagazines().click();
		
	}
	
	/**
	 * As a logged-in user, go to eMag Preference page and clear all the subscribed category.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteEmagPrefPage_ClearAllSubsCategory(String dataUsername, String dataPassword) throws Exception{
		
		// Go to eMag Preference page entry point
		ExecuteLoggedInUser_GoToeMagPrefPage(dataUsername, dataPassword);
		
		// To verify eMag Preference page is displayed.
		eMag_Preference_Page.check_eMagPreferencePageDisplayed();
		
		// Clear all the subscribed category
		eMag_Preference_Page.btn_clickUnsubscribe();
		
	}
	
	/**
	 * To verify eMag Preference page is displayed. 
	 * Verify that the eMag title selected in Registration form are displayed in "Magazine(s) Subscribed" section.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedeMagNameList
	 * @throws Exception
	 */
	public static void ExecuteEmagPrefPage_eMagTitleSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, List<String> checkedeMagNameList) throws Exception{
		
		// Click on the "Sourcing Magazines" link at the left nav.
		UserProfile_Page.lnk_clickSideBarSourcingMagazines().click();
					
		// To verify eMag Preference page is displayed.
		eMag_Preference_Page.check_eMagPreferencePageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the eMag title selected in Registration form are displayed in "Magazine(s) Subscribed" section.
		eMag_Preference_Page.check_eMagTitleSelectedIsDisplayed(xls, sheetName, rowNum, testFail, checkedeMagNameList);
		
	}
	
	/**
	 * To verify eMag Preference page is displayed.
	 * Verify that the eMag title selected in pre-req as well as Registration form are displayed in "Magazine(s) Subscribed" section.
	 * Applied to test case 1J.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param checkedeMagLiteList
	 * @param checkedeMagNameList
	 * @throws Exception
	 */
	public static void ExecuteEmagPrefPage_eMagTitleSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, List<String> checkedeMagLiteList, List<String> checkedeMagNameList) throws Exception{
		
		// Click on the "Sourcing Magazines" link at the left nav.
		UserProfile_Page.lnk_clickSideBarSourcingMagazines().click();
					
		// To verify eMag Preference page is displayed.
		eMag_Preference_Page.check_eMagPreferencePageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the eMag title selected in pre-req as well as Registration form are displayed in "Magazine(s) Subscribed" section.
		eMag_Preference_Page.check_eMagTitleSelectedIsDisplayed(
				xls, sheetName, rowNum, testFail, checkedeMagLiteList, checkedeMagNameList);
		
	}
	
	/**
	 * To verify eMag Preference page is displayed. Verify that all the eMag titles are not selected.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void ExecuteEmagPrefPageDisplayed_AlleMagTitleNotSelected(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		
		// Click on the "Sourcing Magazines" link at the left nav.
		UserProfile_Page.lnk_clickSideBarSourcingMagazines().click();
					
		// To verify eMag Preference page is displayed.
		eMag_Preference_Page.check_eMagPreferencePageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that all the eMag titles are not selected
		eMag_Preference_Page.check_alleMagTitleNotSelected(xls, sheetName, rowNum, testFail);
		
	}
	
	/**
	 * To verify eMag Preference page is displayed. Verify that the eMag title added is displayed in 'Magazine(s) Subscribed' section.
	 * Applied to test cases 10B, 10E, 10F, 10G, 10H, 10I
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param addedEmagTitle
	 * @throws Exception
	 */
	public static void ExecuteEmagPrefPage_eMagTitleSelectedIsDisplayed(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String addedEmagTitle) throws Exception{
		
		// To verify eMag Preference page is displayed. 
		eMag_Preference_Page.check_eMagPreferencePageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the eMag title added in eMag Preference page is displayed in 'Magazine(s) Subscribed' section.
		eMag_Preference_Page.check_eMagTitleSelectedIsDisplayed(xls, sheetName, rowNum, testFail, addedEmagTitle);
		
	}

	
}
