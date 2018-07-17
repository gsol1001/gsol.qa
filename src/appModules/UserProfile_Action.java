/**
 * This Class contains all the methods in the User Profile Action
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
import pageObjects.TopNav_MenuBar;
import pageObjects.UserProfile_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the User Profile action.
 * @author Teng Shyh Wei
 *
 */
public class UserProfile_Action {

	/**
	 * Go to "User Profile" page.
	 * 
	 * @throws Exception
	 */
	public static void ExecuteReg_GoToUserProfilePage() throws Exception{
		
		// Back to GSOL home page.
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		
        // Generate mouse hover event on Global Notification to click on User Profile menu bar.
		GlobalNav_MenuBar.menuBar_selectUserProfile();
		
	}
	
	/**
	 * To verify the information entered during registration are correct.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataTitle
	 * @param dataFirstName
	 * @param dataLastName
	 * @param dataCompanyName
	 * @param dataBusinessEmail
	 * @param dataCountryTerritory
	 * @param dataTelephoneNumber
	 * @throws Exception
	 */
	public static void check_userProfilePageDisplayed_InfoEnteredMatched(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String dataTitle, String dataFirstName, String dataLastName, String dataCompanyName, 
			String dataBusinessEmail, String dataCountryTerritory, String dataTelephoneNumber) throws Exception{
		
		// Go to 'User Profile' page
		UserProfile_Action.ExecuteReg_GoToUserProfilePage();
		
		// To verify User Profile page is displayed.
		UserProfile_Page.check_userProfilePageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that the information entered are correct.
		UserProfile_Page.check_infoEnteredDuringRegistrationAreMatch(xls, sheetName, rowNum, testFail, dataTitle, 
				dataFirstName, dataLastName, dataCompanyName, dataBusinessEmail, dataCountryTerritory, dataTelephoneNumber);
		
	}
	
	/**
	 * To verify that Notifications checkboxes are checked and preferred e-mail format is set to default (HTML).
	 * Applied to test case 1A, 1C, 1E, 1G, 1I, 1J.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_notificationsPageDisplayed_AllNofChkbxSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// Click on the "Notifications" link at the left nav.
		UserProfile_Page.lnk_clickSideBarNotification().click();
					
		// To verify Notifications page is displayed.
		UserProfile_Page.check_notificationsPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that Notifications checkboxes are checked.
		UserProfile_Page.check_allNotificationChkbxSelected(xls, sheetName, rowNum, testFail);
		
		// To verify that preferred e-mail format is set to default (HTML).
		UserProfile_Page.check_emailFormatSetToDefault(xls, sheetName, rowNum, testFail);		
		
	}
	
	/**
	 * To verify that Notifications checkboxes are unchecked and preferred e-mail format is set to default (HTML).
	 * Applied to test case 1B, 1D, 1F, 1H.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @throws Exception
	 */
	public static void check_notificationsPageDisplayed_AllNofChkbxNotSelected(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail) throws Exception{
		
		// Click on the "Notifications" link at the left nav.
		UserProfile_Page.lnk_clickSideBarNotification().click();
		
		// To verify Notifications page is displayed
		UserProfile_Page.check_notificationsPageIsDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify that Notifications checkboxes are unchecked.
		UserProfile_Page.check_allNotificationChkbxNotSelected(xls, sheetName, rowNum, testFail);
		
		// To verify that preferred e-mail format is set to default (HTML).
		UserProfile_Page.check_emailFormatSetToDefault(xls, sheetName, rowNum, testFail);
		
	}
}
