/**
 * This class contains suite base for module Supplier Alert
 * Created: Fri 16 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/16
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSA;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Suite base for module Supplier Alert.
 * @author Teng Shyh Wei
 *
 */
public class SuiteBaseSA extends SuiteBase{
	
	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName_SuiteSA_001 = null;
	String SuiteName_SuiteSA_002 = null;

	String ToRunColumnName = null;	
	
	/**
	 * Method marked with @BeforeSuite annotation will run before the all suites from test.
	 * This function will be executed before the test cases to check SuiteToRun flag.
	 * 
	 * @throws IOException  if an input or output exception occurred
	 */	
	@BeforeSuite
	public void checkSuiteToRun() throws IOException{
		
		// Called init() function from SuiteBase class to Initialize .xls Files
		init();
		
		// To set TestSuiteList.xls file's path In FilePath Variable.
		FilePath = TestSuiteListExcel;
		SheetName = "SuitesList";
		SuiteName_SuiteSA_001 = "SuiteSA_001";
		SuiteName_SuiteSA_002 = "SuiteSA_002";
		
		ToRunColumnName = "SuiteToRun";
		
		// Insert log In applog.log file.
		Add_Log.info("Execution started for Suite SA.");
		
		// If SuiteToRun !== "y" then SuiteSA_001 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSA_001)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSA_001+" So Skipping Execution.");
			// To report SuiteSA_001 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSA_001, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSA_001+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSA_001);
		}		
		// To report SuiteSA_001 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSA_001, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuiteSA_002 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSA_002)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSA_002+" So Skipping Execution.");
			// To report SuiteSA_002 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSA_002, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSA_002+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSA_002);
		}		
		// To report SuiteSA_002 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSA_002, Constant.KEYWORD_EXECUTED);
		
	}			
	
}
