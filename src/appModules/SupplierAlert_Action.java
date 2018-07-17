/**
 * This Class contains all the methods in the Top Products Action
 * Created: Wed 13 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/13
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import org.openqa.selenium.WebDriver;

import pageObjects.GlobalNav_MenuBar;
import pageObjects.SA_EditSuppliers_Page;
import pageObjects.SA_Marketing_Page;
import pageObjects.SupplierHome_Page;
import pageObjects.TopNav_MenuBar;
import pageObjects.UserProfile_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the Supplier Alert action.
 * @author Teng Shyh Wei
 *
 */
public class SupplierAlert_Action {

	public static WebDriver driver;
	
	/**
	 * As a Logged-in user, clean up all the Following Supplier.
	 * 
	 * @param dataUsername
	 * @param dataPassword
	 * @throws Exception
	 */
	public static void ExecuteLoggedIn_CleanUpVerSupp(String dataUsername, String dataPassword) throws Exception{
	
		// Login to GSOL 
		SignIn_Action.ExecuteLoggedInUser(dataUsername, dataPassword);
		
		// Generate mouse hover event on Global Notification to click on User Profile.
		GlobalNav_MenuBar.menuBar_selectUserProfile();
		
		// To click on the 'Supplier Alert' link at left nav.
		UserProfile_Page.lnk_clickSideBarSupplierAlert().click();				
		
		// To clean up SA Suppliers if available on the page.
		SA_EditSuppliers_Page.check_clearSASuppliers();
		
		// Go back to GSOL homepage
		TopNav_MenuBar.lnk_backToGSOLHomePage();
		
	}
	
	/**
	 * From Supplier Homepage entry point, click on the "Follow Me" button next to supplier's name.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSA_GoToSuppHomepage_ClickFollowMeBtn(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types and click on Supplier Name
		ProductInquiry_Action.ExecutePdtSearch_ClickSuppName(dataSearchKeyword);
		
		// To click on 'Follow Me' button next to supplier's name
		SupplierHome_Page.btn_clickFollowMe().click();
		
	}
	
	/**
	 * From Supplier Company Profile page entry point, click on the "Follow Me" button next to supplier's name.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSA_GoToSuppCompProfile_ClickFollowMeBtn(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types and click on Supplier Name
		ProductInquiry_Action.ExecutePdtSearch_ClickSuppName(dataSearchKeyword);
				
		// Go to Supplier Company Profile page by select 'Company Information' menu bar.
		SupplierHome_Page.menuBar_clickCompInformation().click();
		
		// To click on 'Follow Me' button next to supplier's name.
		SupplierHome_Page.btn_clickFollowMe().click();
		
	}
	
	/**
	 * From Supplier Product Showroom page entry point, click on the "Follow Me" button next to supplier's name.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSA_GoToSupplierPdtShowroomPage_ClickFollowMeBtn(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types and click on Supplier Name
		ProductInquiry_Action.ExecutePdtSearch_ClickSuppName(dataSearchKeyword);
			
		// Go to Supplier Product Showroom page by select 'Product List' menu bar.
		SupplierHome_Page.menuBar_clickProductList().click();
		
		// To click on 'Follow Me' button next to supplier's name
		SupplierHome_Page.btn_clickFollowMe().click();
	}
	
	/**
	 * From Supplier PP page entry point, click on the "Follow Me" button next to supplier's name.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSA_GoToSupplierPPpage_ClickFollowMeBtn(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Products Page Types and click on Supplier Name
		ProductInquiry_Action.ExecutePdtSearch_ClickSuppName(dataSearchKeyword);
		
		// Close the MW Promo PP overlay.
	//	SupplierHome_Page.icon_clickCloseBtnOnPromoPPOverlay();
		
		// Go to Supplier Product Showroom page by select 'Product List' menu bar.
		SupplierHome_Page.menuBar_clickProductList().click();
		
		// Mouse hover to the Supplier PP image and click on zoomed image.
		SupplierHome_Page.img_clickFirstPPImgAtLatestProductsSection();
		
		// Close the eMag Popup Form if exists.
		SupplierHome_Page.icon_clickCloseBtnOnEmagPopupForm();
		
		// To click on 'Follow Me' button next to supplier's name
		SupplierHome_Page.btn_clickFollowMe().click();
		
	}
	
	/**
	 * From Supplier ECI pages entry point, click on the "Follow Me" button next to supplier name.
	 * 
	 * @param dataSearchKeyword
	 * @throws Exception
	 */
	public static void ExecuteSA_GoToSupplierECIPage_ClickFollowMeBtn(String dataSearchKeyword) throws Exception{
		
		// Enter search keyword by select Product page Types and click on Supplier Name
		ProductInquiry_Action.ExecutePdtSearch_ClickSuppName(dataSearchKeyword);		
		
		// Close the MW Promo PP overlay.
	//	SupplierHome_Page.icon_clickCloseBtnOnPromoPPOverlay();
		
		// Go to Supplier ECI page by select a sub menu from 'Company Information'.
		SupplierHome_Page.drpdwn_selectSupplierECI();
		
		// To click on 'Follow Me' button next to supplier's name
		SupplierHome_Page.btn_clickFollowMe().click();
	}
	
	/**
	 * Enter a brand new email address and click on "Send me updates" button.
	 * 
	 * @param dataBusinessEmail
	 * @throws Exception
	 */
	public static void ExecuteSA_EnterBusinessEmail_ClickSendMeUpdatesBtn(String dataBusinessEmail) throws Exception{
		
		// Enter text for Business Email field.
		SA_Marketing_Page.txtbx_enterBusinessEmail().sendKeys(dataBusinessEmail);
		
		// Click on the 'Send me updates' button.
		SA_Marketing_Page.btn_clickSendMeUpdates().click();
		
	}
	
	/**
	 * To verify SA Edit Suppliers page is displayed. The Following's Suppliers name is added into "Verified suppliers" section.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param suppName
	 * @throws Exception
	 */
	public static void ExecuteSAEditSuppPage_FollowingSuppAddedToVerSuppSection(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String suppName) throws Exception{
		
		// To verify SA Edit Suppliers page is displayed.
		SA_EditSuppliers_Page.check_SAEditSuppliersPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify the Following's Suppliers name is added into "Verified suppliers" section.			
		SA_EditSuppliers_Page.check_followingSuppAddedToVerSuppSection(xls, sheetName, rowNum, testFail, suppName);
		
	}
	
	/**
	 * To verify SA Edit Suppliers page is displayed. The Following's Suppliers name is added into Supplier Alert.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param suppName
	 * @throws Exception
	 */
	public static void ExecuteSAEditSuppPage_FollowingSuppAddedToSupplierAlert(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail, String suppName) throws Exception{
		
		// To verify SA Edit Suppliers page is displayed.
		SA_EditSuppliers_Page.check_SAEditSuppliersPageDisplayed(xls, sheetName, rowNum, testFail);
		
		// To verify the Following's Suppliers name is added into Supplier Alert.	
		SA_EditSuppliers_Page.check_followingSuppAddedToSupplierAlert(xls, sheetName, rowNum, testFail, suppName);
		
	}
		
}
