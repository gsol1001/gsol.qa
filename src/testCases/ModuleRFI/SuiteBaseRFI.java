/**
 * This class contains suite base for module RFI
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/07
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases.ModuleRFI;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import testCases.SuiteBase;
import utility.Read_XLS;
import utility.SuiteUtility;

/**
 * Suite base for module RFI
 * @author Teng Shyh Wei
 *
 */
public class SuiteBaseRFI extends SuiteBase{
	
	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName = null;
	String SuiteName_SuiteRFI_002 = null;
	String SuiteName_SuiteRFI_003 = null;
	String SuiteName_SuiteRFI_004 = null;
	String SuiteName_SuiteRFI_005 = null;
	String SuiteName_SuiteRFI_006 = null;
	String SuiteName_SuiteRFI_007 = null;
	String SuiteName_SuiteRFI_008 = null;
	String SuiteName_SuiteRFI_009 = null;
	String SuiteName_SuiteRFI_010 = null;
	String SuiteName_SuiteRFI_011 = null;
	String SuiteName_SuiteRFI_012 = null;
	String SuiteName_SuiteRFI_013 = null;
	String SuiteName_SuiteRFI_014 = null;
	String SuiteName_SuiteRFI_015 = null;
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
		SuiteName = "SuiteRFI_001";
		SuiteName_SuiteRFI_002 = "SuiteRFI_002";
		SuiteName_SuiteRFI_003 = "SuiteRFI_003";
		SuiteName_SuiteRFI_004 = "SuiteRFI_004";
		SuiteName_SuiteRFI_005 = "SuiteRFI_005";
		SuiteName_SuiteRFI_006 = "SuiteRFI_006";
		SuiteName_SuiteRFI_007 = "SuiteRFI_007";
		SuiteName_SuiteRFI_008 = "SuiteRFI_008";
		SuiteName_SuiteRFI_009 = "SuiteRFI_009";
		SuiteName_SuiteRFI_010 = "SuiteRFI_010";
		SuiteName_SuiteRFI_011 = "SuiteRFI_011";
		SuiteName_SuiteRFI_012 = "SuiteRFI_012";
		SuiteName_SuiteRFI_013 = "SuiteRFI_013";
		SuiteName_SuiteRFI_014 = "SuiteRFI_014";
		SuiteName_SuiteRFI_015 = "SuiteRFI_015";
		ToRunColumnName = "SuiteToRun";
		
		// Insert log In applog.log file.
		Add_Log.info("Execution started for Suite RFI.");
		
		// If SuiteToRun !== "y" then SuiteRFI_001 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName+" So Skipping Execution.");
			// To report SuiteRFI_001 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName);
		}		
		// To report SuiteRFI_001 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_002 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_002)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_002+" So Skipping Execution.");
			// To report SuiteRFI_002 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_002, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_002+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_002);
		}		
		// To report SuiteRFI_002 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_002, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_003 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_003)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_003+" So Skipping Execution.");
			// To report SuiteRFI_003 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_003, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_003+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_003);
		}		
		// To report SuiteRFI_003 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_003, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_004 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_004)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_004+" So Skipping Execution.");
			// To report SuiteRFI_004 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_004, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_004+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_004);
		}		
		// To report SuiteRFI_004 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_004, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_005 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_005)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_005+" So Skipping Execution.");
			// To report SuiteRFI_005 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_005, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_005+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_005);
		}		
		// To report SuiteRFI_005 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_005, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_006 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_006)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_006+" So Skipping Execution.");
			// To report SuiteRFI_006 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_006, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_006+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_006);
		}		
		// To report SuiteRFI_006 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_006, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_007 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_007)){			
			SuiteUtility.WriteResultUtility(FilePath, "SuiteToRun = N for "+SuiteName_SuiteRFI_007+" So Skipping Execution.", SheetName, 0, SheetName);
			// To report SuiteRFI_007 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_007, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_007+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_007);
		}		
		// To report SuiteRFI_007 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_007, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_008 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_008)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_008+" So Skipping Execution.");
			// To report SuiteRFI_008 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_008, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_008+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_008);
		}		
		// To report SuiteRFI_008 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_008, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_009 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_009)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_009+" So Skipping Execution.");
			// To report SuiteRFI_009 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_009, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_009+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_009);
		}		
		// To report SuiteRFI_009 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_009, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_010 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_010)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_010+" So Skipping Execution.");
			// To report SuiteRFI_010 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_010, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_010+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_010);
		}		
		// To report SuiteRFI_010 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_010, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_011 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_011)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_011+" So Skipping Execution.");
			// To report SuiteRFI_011 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_011, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_011+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_011);
		}		
		// To report SuiteRFI_011 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_011, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_012 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_012)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_012+" So Skipping Execution.");
			// To report SuiteRFI_012 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_012, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_012+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_012);
		}		
		// To report SuiteRFI_012 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_012, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_013 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_013)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_013+" So Skipping Execution.");
			// To report SuiteRFI_013 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_013, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_013+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_013);
		}		
		// To report SuiteRFI_013 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_013, "Executed");
		
		
		// If SuiteToRun !== "y" then SuiteRFI_014 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_014)){			
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_014+" So Skipping Execution.");
			// To report SuiteRFI_014 as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_014, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_014+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_014);
		}		
		// To report SuiteRFI_014 as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_014, "Executed");
		
		// If SuiteToRun !== "y" then SuiteRFI 015 will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName, ToRunColumnName, SuiteName_SuiteRFI_015)){
			Add_Log.info("SuiteToRun = N for "+SuiteName_SuiteRFI_015+" So Skipping Execution.");
			// To report SuiteRFI_015 as 'Skipped' In SuiteList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_015, "Skipped");
			// It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName_SuiteRFI_015+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName_SuiteRFI_015);
		}
		// To report SuiteRFI_015 as 'Executed' In SuiteList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName_SuiteRFI_015, "Executed");
		
	}	

}
