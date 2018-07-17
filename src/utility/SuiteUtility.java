/**
 * This class contains a method for Utility functions.
 * This class file will work as intermediate file between Read_XLS.java file and
 * your test suite or test cases files. It will get data reading or data writing
 * requests from test suite or or cases files and send all those requests to 
 * Read_XLS.java. And then Read_XLS.java will performed data reading or data writing
 * action on targeted sheet.
 * 
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/07
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package utility;

/**
 * Contains a method for Utility functions
 * @author Teng Shyh Wei
 *
 */
public class SuiteUtility {	
	
	/**
	 * To check test case's CaseToRun = Y or N In related excel sheet.
	 * If CaseToRun = N or blank, Test case will skip execution. Else It will be executed.
	 * 
	 * @param xls
	 * @param sheetName		the sheet name of this .xls file
	 * @param ToRun
	 * @param testSuite		the test suite name		
	 * @return
	 */
	public static boolean checkToRunUtility(Read_XLS xls, String sheetName, String ToRun, String testSuite){
				
		boolean Flag = false;		
		if(xls.retrieveToRunFlag(sheetName, ToRun, testSuite).equalsIgnoreCase("y")){
			Flag = true;
		}
		else{
			Flag = false;
		}
		return Flag;		
	}
	
	/**
	 * To retrieve DataToRun flags of all data set lines from related test data sheet.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param ColName
	 * @return
	 */
	public static String[] checkToRunUtilityOfData(Read_XLS xls, String sheetName, String ColName){		
		return xls.retrieveToRunFlagTestData(sheetName, ColName);		 	
	}
 
	/**
	 * To retrieve data from Data 1 Column, Data 2 Column, Data 3 Column etc and Expected Result column of Excel data Sheet.
	 * Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programmatically when reading test data.
	 * 
	 * @param xls
	 * @param sheetName
	 * @return
	 */
	public static Object[][] GetTestDataUtility(Read_XLS xls, String sheetName){
	 	return xls.retrieveTestData(sheetName);	
	}
 
	/**
	 * To report result as pass or fail for test cases In TestCasesList sheet.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param ColName
	 * @param rowNum
	 * @param Result
	 * @return
	 */
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String ColName, int rowNum, String Result){			
		return xls.writeResult(sheetName, ColName, rowNum, Result);		 	
	}
	
	/**
	 * To report result as pass or fail for test cases In TestCasesList sheet.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param ColName
	 * @param rowName
	 * @param Result
	 * @return
	 */
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String ColName, String rowName, String Result){			
		return xls.writeResult(sheetName, ColName, rowName, Result);		 	
	}
		
	/**
	 * To retrieve TestCaseName
	 * 
	 * @param sTestCase
	 * @return
	 * @throws Exception
	 */
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
		}catch(Exception e){
			//Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
		}
	}
}

