/**
 * This class contains suite base for module Refactor
 * Created: Mon 11 Apr 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/04/11
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleRefactor;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Suite Base for module Refactor
 * @author Teng Shyh Wei
 *
 */
public class SuiteBaseRefactor extends SuiteBase{
	
	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName_SuiteRefactor_001 = null;
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
		SuiteName_SuiteRefactor_001 = "SuiteRefactor_001";	
		ToRunColumnName = "SuiteToRun";
		
		// Insert log In applog.log file.
		Add_Log.info("Execution started for Suite Nav Bar.");
		
		// If SuiteToRun !== "y" then SuiteRefactor_001 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRefactor_001)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRefactor_001+" So Skipping Execution.");
			// To report SuiteRefactor_001 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteRefactor_001, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRefactor_001+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRefactor_001);
		}		
		// To report SuiteRefactor_001 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteRefactor_001, Constant.KEYWORD_EXECUTED);
		
	}			
	
}
