/**
 * This class contains suite base for module Search.
 * Created: Mon 05 Oct 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/10/05
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSearch;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Suite Base for module Search.
 * @author Teng Shyh Wei
 *
 */
public class SuiteBaseSearch extends SuiteBase{
	
	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName_SuiteSearch_001 = null;
	String SuiteName_SuiteSearch_002 = null;
	String SuiteName_SuiteSearch_003 = null;
	String SuiteName_SuiteSearch_004 = null;
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
		SuiteName_SuiteSearch_001 = "SuiteSearch_001";
		SuiteName_SuiteSearch_002 = "SuiteSearch_002";	
		SuiteName_SuiteSearch_003 = "SuiteSearch_003";
		SuiteName_SuiteSearch_004 = "SuiteSearch_004";
		ToRunColumnName = "SuiteToRun";
		
		// Insert log In applog.log file.
		Add_Log.info("Execution started for Suite Search.");
		
		// If SuiteToRun !== "y" then SuiteSearch_001 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSearch_001)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSearch_001+" So Skipping Execution.");
			// To report SuiteSearch_001 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_001, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSearch_001+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSearch_001);
		}		
		// To report SuiteSearch_001 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_001, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuiteSearch_002 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSearch_002)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSearch_002+" So Skipping Execution.");
			// To report SuiteSearch_002 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_002, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSearch_002+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSearch_002);
		}		
		// To report SuiteSearch_002 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_002, Constant.KEYWORD_EXECUTED);
				

		// If SuiteToRun !== "y" then SuiteSearch_003 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSearch_003)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSearch_003+" So Skipping Execution.");
			// To report SuiteSearch_003 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_003, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSearch_003+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSearch_003);
		}		
		// To report SuiteSearch_003 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_003, Constant.KEYWORD_EXECUTED);
				

		// If SuiteToRun !== "y" then SuiteSearch_004 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSearch_004)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSearch_004+" So Skipping Execution.");
			// To report SuiteSearch_004 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_004, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSearch_004+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSearch_004);
		}		
		// To report SuiteSearch_004 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSearch_004, Constant.KEYWORD_EXECUTED);
		
	}			
	
}
