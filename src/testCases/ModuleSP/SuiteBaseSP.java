/**
 * This class contains suite base for module Supplier Profile
 * Created: Thu 07 Sep 2017
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2017/09/07
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleSP;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Suite base for module Supplier Profile.
 * @author Teng Shyh Wei
 *
 */
public class SuiteBaseSP extends SuiteBase {

	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName_SuiteSP_001 = null;
	String SuiteName_SuiteSP_002 = null;
	String SuiteName_SuiteSP_003 = null;
	String SuiteName_SuiteSP_004 = null;
	String SuiteName_SuiteSP_005 = null;
	String SuiteName_SuiteSP_006 = null;
	String SuiteName_SuiteSP_007 = null;
	String SuiteName_SuiteSP_008 = null;
	
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
		SuiteName_SuiteSP_001 = "SuiteSP_001";
		SuiteName_SuiteSP_002 = "SuiteSP_002";
		SuiteName_SuiteSP_003 = "SuiteSP_003";
		SuiteName_SuiteSP_004 = "SuiteSP_004";
		SuiteName_SuiteSP_005 = "SuiteSP_005";
		SuiteName_SuiteSP_006 = "SuiteSP_006";
		SuiteName_SuiteSP_007 = "SuiteSP_007";
		SuiteName_SuiteSP_008 = "SuiteSP_008";
		
		ToRunColumnName = "SuiteToRun";
		
		// Insert log In applog.log file.
		Add_Log.info("Execution started for Suite SP.");
		
		// If SuiteToRun !== "y" then SuiteSP_001 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_001)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_001+" So Skipping Execution.");
			// To report SuiteSP_001 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_001, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_001+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_001);
		}		
		// To report SuiteSP_001 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_001, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuiteSP_002 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_002)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_002+" So Skipping Execution.");
			// To report SuiteSP_002 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_002, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_002+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_002);
		}		
		// To report SuiteSP_002 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_002, Constant.KEYWORD_EXECUTED);
				
		
		// If SuiteToRun !== "y" then SuiteSP_003 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_003)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_003+" So Skipping Execution.");
			// To report SuiteSP_003 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_003, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_003+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_003);
		}		
		// To report SuiteSP_003 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_003, Constant.KEYWORD_EXECUTED);		

		
		// If SuiteToRun !== "y" then SuiteSP_004 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_004)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_004+" So Skipping Execution.");
			// To report SuiteSP_004 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_004, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_004+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_004);
		}		
		// To report SuiteSP_004 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_004, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuiteSP_005 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_005)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_005+" So Skipping Execution.");
			// To report SuiteSP_005 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_005, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_005+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_005);
		}		
		// To report SuiteSP_005 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_005, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuiteSP_006 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_006)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_006+" So Skipping Execution.");
			// To report SuiteSP_006 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_006, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_006+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_006);
		}		
		// To report SuiteSP_006 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_006, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuiteSP_007 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_007)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_007+" So Skipping Execution.");
			// To report SuiteSP_007 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_007, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_007+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_007);
		}		
		// To report SuiteSP_007 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_007, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuiteSP_008 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteSP_008)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteSP_008+" So Skipping Execution.");
			// To report SuiteSP_008 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_008, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteSP_008+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteSP_008);
		}		
		// To report SuiteSP_008 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuiteSP_008, Constant.KEYWORD_EXECUTED);
		
	}	
}
