/**
 * This class contains suite base for module Product Profile
 * Created: Mon 11 Sep 2017
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2017/09/11
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModulePP;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Suite base for module Product Profile.
 * @author Teng Shyh Wei
 *
 */

public class SuiteBasePP extends SuiteBase{
	
	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName_SuitePP_001 = null;
	String SuiteName_SuitePP_002 = null;
	String SuiteName_SuitePP_003 = null;
	
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
		SuiteName_SuitePP_001 = "SuitePP_001";
		SuiteName_SuitePP_002 = "SuitePP_002";
		SuiteName_SuitePP_003 = "SuitePP_003";
		
		ToRunColumnName = "SuiteToRun";
		
		// Insert log In applog.log file.
		Add_Log.info("Execution started for Suite PP.");
		
		// If SuiteToRun !== "y" then SuitePP_001 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePP_001)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePP_001+" So Skipping Execution.");
			// To report SuitePP_001 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePP_001, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePP_001+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePP_001);
		}		
		// To report SuitePP_001 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePP_001, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuitePP_002 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePP_002)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePP_002+" So Skipping Execution.");
			// To report SuitePP_002 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePP_002, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePP_002+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePP_002);
		}		
		// To report SuitePP_002 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePP_002, Constant.KEYWORD_EXECUTED);
		
				
		// If SuiteToRun !== "y" then SuitePP_003 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePP_003)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePP_003+" So Skipping Execution.");
			// To report SuitePP_003 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePP_003, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePP_003+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePP_003);
		}		
		// To report SuitePP_003 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePP_003, Constant.KEYWORD_EXECUTED);
		
	}	
}
