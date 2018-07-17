/**
 * This Class contains all the methods in the Advanced Search Action
 * Created: Thu 22 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/22
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import java.util.List;

import pageObjects.AdvancedSearch_Page;
import utility.Read_XLS;

/**
 * Contain all the methods in the Advanced Search action.
 * @author Teng Shyh Wei
 *
 */
public class AdvancedSearch_Action {

	// Fill in all the fields in Advanced Search section.
	public static void ExecuteAdvSearch_FillInAllFields(String dataLookingFor, String dataSearchKeyword,
			String dataSearchMethod, String dataCategory, String dataCountry) throws Exception{
		
		System.out.println("I am Looking for ::" + dataLookingFor);
		
		// Select drop down list for 'I am Looking for" field.
		AdvancedSearch_Page.drpdwn_selectIAmLookingFor(dataLookingFor);
		
		// Enter text for 'Please enter your Keyword(s)' field.
		AdvancedSearch_Page.txtbx_enterYourKeyword().sendKeys(dataSearchKeyword);
		
		// Select radio button for 'Search Method'.
		AdvancedSearch_Page.radbtn_selectSearchMethod(dataSearchMethod);
		
		// Select drop down list for 'Just in the category'.
		AdvancedSearch_Page.drpdwn_selectJustInTheCategories(dataCategory);
		
		// Select list box for 'Select Countries' field.
		AdvancedSearch_Page.lstbx_selectCountries(dataCountry);
		
	}
	
	/**
	 * Fill in all the fields in Advanced Search section.
	 * 
	 * @param dataLookingFor
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @param dataSearchMethod
	 * @param dataCategory
	 * @param dataCountry
	 * @throws Exception
	 */
	public static void ExecuteAdvSearch_FillInAllFields(String dataLookingFor, String data1stKeyword, String data2ndKeyword,
			String dataSearchMethod, String dataCategory, String dataCountry) throws Exception{
		
		System.out.println("I am Looking for ::" + dataLookingFor);
		
		// Select drop down list for 'I am Looking for" field.
		AdvancedSearch_Page.drpdwn_selectIAmLookingFor(dataLookingFor);
		
		// Enter text for 'Please enter your Keyword(s)' field.
		String dataSearchKeyword = data1stKeyword + " " + data2ndKeyword;
		AdvancedSearch_Page.txtbx_enterYourKeyword().sendKeys(dataSearchKeyword);
		
		// Select radio button for 'Search Method'.
		AdvancedSearch_Page.radbtn_selectSearchMethod(dataSearchMethod);
		
		// Select drop down list for 'Just in the category'.
		AdvancedSearch_Page.drpdwn_selectJustInTheCategories(dataCategory);
		
		// Select list box for 'Select Countries' field.
		AdvancedSearch_Page.lstbx_selectCountries(dataCountry);
		
	}
	
	/**
	 * Fill in all the fields in Advanced Search section.
	 * 
	 * @param dataLookingFor
	 * @param dataSearchKeyword
	 * @param data1stKeyword
	 * @param data2ndKeyword
	 * @param data3rdKeyword
	 * @param dataSearchMethod
	 * @param dataCategory
	 * @param dataCountry
	 * @throws Exception
	 */
	public static void ExecuteAdvSearch_FillInAllFields(String dataLookingFor, String data1stKeyword, String data2ndKeyword, 
			String data3rdKeyword, String dataSearchMethod, String dataCategory, String dataCountry) throws Exception{
		
		// Select drop down list for 'I am Looking for" field.
		AdvancedSearch_Page.drpdwn_selectIAmLookingFor(dataLookingFor);
		
		// Enter text for 'Please enter your Keyword(s)' field.
		String dataSearchKeyword = data1stKeyword + " " + data2ndKeyword + " " + data3rdKeyword;
		AdvancedSearch_Page.txtbx_enterYourKeyword().sendKeys(dataSearchKeyword);
		
		// Select radio button for 'Search Method'.
		AdvancedSearch_Page.radbtn_selectSearchMethod(dataSearchMethod);
		
		// Select drop down list for 'Just in the category'.
		AdvancedSearch_Page.drpdwn_selectJustInTheCategories(dataCategory);
		
		// Select list box for 'Select Countries' field.
		AdvancedSearch_Page.lstbx_selectCountries(dataCountry);
		
	}
	
	/**
	 * Fill in all the fields in Advance Search box.
	 * 
	 * @param dataAdvSearchCondition
	 * @param dataLookingFor
	 * @param dataSearchKeyword
	 * @param dataSearchMethod
	 * @param dataCategory
	 * @param dataCountry
	 * @throws Exception
	 */
	public static void ExecuteAdvSearchBox_FillInAllFields(String dataAdvSearchCondition, String dataLookingFor, String data1stKeyword,
			String data2ndKeyword, String data3rdKeyword, String dataSearchMethod, String dataCategory, String dataCountry) throws Exception{
		
		// Select "Search within this results" in "I would like to:" field.
		AdvancedSearch_Page.radbtn_selectIWouldLikeTo(dataAdvSearchCondition);
		
		// Select drop down list for 'I am Looking for" field.
		AdvancedSearch_Page.drpdwn_selectIAmLookingFor(dataLookingFor);
		
		// Enter text for 'Please enter your Keyword(s)' field at Advance Search box.
		String dataSearchKeyword = data1stKeyword + " " + data2ndKeyword + " " + data3rdKeyword;
		AdvancedSearch_Page.txtbx_enterYourKeyword().sendKeys(dataSearchKeyword);
		
		// Select radio button for 'Search Method'.
		AdvancedSearch_Page.radbtn_selectSearchMethod(dataSearchMethod);
		
		// Select drop down list for 'Just in the category'.
		AdvancedSearch_Page.drpdwn_selectJustInTheCategories(dataCategory);
		
		// Select list box for 'Select Countries' field.
		AdvancedSearch_Page.lstbx_selectCountries(dataCountry);
		
	}
	
	/**
	 * To verify the results displayed contains only the matching all supplier types from the selected country.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @param dataCountry
	 * @throws Exception
	 */
	public static void check_resultsDisplayedAllSuppContainsOnlySelectedCountry(Read_XLS xls, String sheetName, int rowNum,
			List<Boolean> testFail, String dataCountry) throws Exception{
		
		// To verify the results displayed contains only the matching verified suppliers from the selected country.
		AdvancedSearch_Page.check_resultsDisplayedVerSuppContainsOnlySelectedCountry(xls, sheetName, rowNum, testFail, dataCountry);
		
		// To verify the results displayed contains only the matching other suppliers from the selected country.
		AdvancedSearch_Page.check_resultsDisplayedUnvSuppContainsOnlySelectedCountry(xls, sheetName, rowNum, testFail, dataCountry);
		
	}
	
}
