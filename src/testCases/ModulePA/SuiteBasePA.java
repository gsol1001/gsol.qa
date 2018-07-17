/**
 * This class contains suite base for module Product Alert
 * Created: Thu 23 Jul 2015
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/07/23
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModulePA;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import testCases.SuiteBase;
import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Suite base for module Product Alert.
 * @author Teng Shyh Wei
 *
 */
public class SuiteBasePA extends SuiteBase{
	
	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName_SuitePA_001 = null;
	String SuiteName_SuitePA_002 = null;
	String SuiteName_SuitePA_003 = null;
	String SuiteName_SuitePA_004 = null;
	String SuiteName_SuitePA_005 = null;
	String SuiteName_SuitePA_006 = null;
	String SuiteName_SuitePA_007 = null;
	String SuiteName_SuitePA_008 = null;
	String SuiteName_SuitePA_009 = null;
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
		SuiteName_SuitePA_001 = "SuitePA_001";
		SuiteName_SuitePA_002 = "SuitePA_002";	
		SuiteName_SuitePA_003 = "SuitePA_003";
		SuiteName_SuitePA_004 = "SuitePA_004";
		SuiteName_SuitePA_005 = "SuitePA_005";
		SuiteName_SuitePA_006 = "SuitePA_006";
		SuiteName_SuitePA_007 = "SuitePA_007";
		SuiteName_SuitePA_008 = "SuitePA_008";
		SuiteName_SuitePA_009 = "SuitePA_009";
				
		ToRunColumnName = "SuiteToRun";
		
		// Insert log In applog.log file.
		Add_Log.info("Execution started for Suite PA.");
		
		// If SuiteToRun !== "y" then SuitePA_001 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_001)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_001+" So Skipping Execution.");
			// To report SuitePA_001 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_001, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_001+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_001);
		}		
		// To report SuitePA_001 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_001, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuitePA_002 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_002)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_002+" So Skipping Execution.");
			// To report SuitePA_002 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_002, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_002+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_002);
		}		
		// To report SuitePA_002 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_002, Constant.KEYWORD_EXECUTED);
				
		
		// If SuiteToRun !== "y" then SuitePA_003 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_003)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_003+" So Skipping Execution.");
			// To report SuitePA_003 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_003, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_003+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_003);
		}		
		// To report SuitePA_003 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_003, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuitePA_004 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_004)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_004+" So Skipping Execution.");
			// To report SuitePA_004 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_004, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_004+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_004);
		}		
		// To report SuitePA_004 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_004, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuitePA_005 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_005)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_005+" So Skipping Execution.");
			// To report SuitePA_005 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_005, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_005+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_005);
		}		
		// To report SuitePA_005 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_005, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuitePA_006 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_006)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_006+" So Skipping Execution.");
			// To report SuitePA_006 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_006, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_006+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_006);
		}		
		// To report SuitePA_006 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_006, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuitePA_007 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_007)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_007+" So Skipping Execution.");
			// To report SuitePA_007 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_007, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_007+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_007);
		}		
		// To report SuitePA_007 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_007, Constant.KEYWORD_EXECUTED);

		
		// If SuiteToRun !== "y" then SuitePA_008 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_008)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_008+" So Skipping Execution.");
			// To report SuitePA_008 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_008, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_008+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_008);
		}		
		// To report SuitePA_008 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_008, Constant.KEYWORD_EXECUTED);
		
		
		// If SuiteToRun !== "y" then SuitePA_009 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuitePA_009)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuitePA_009+" So Skipping Execution.");
			// To report SuitePA_009 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_009, Constant.KEYWORD_SKIP);
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuitePA_009+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuitePA_009);
		}		
		// To report SuitePA_009 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, Constant.COL_SKIPPED_EXECUTED, SuiteName_SuitePA_009, Constant.KEYWORD_EXECUTED);
		
	}			
	
}
