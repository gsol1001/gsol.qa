/**
 * Use this class file as a master base class file for the test suites.
 * Created: Tue 23 December 2014
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2015/01/07 
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utility.Constant;
import utility.Read_XLS;
import utility.SuiteUtility;

public class SuiteBase {	
	
	public static Logger Add_Log = null;
	public boolean BrowseralreadyLoaded = false;
	public static Properties Param = null;
	public static Properties Object = null;
	public static Properties MenuBar = null;
	public static WebDriver driver = null;
	public static WebDriver ExistingchromeBrowser;
	public static WebDriver ExistingmozillaBrowser;
	public static WebDriver ExistingIEBrowser;
	private static WebElement element = null;
	
	/** Suite Refactor. */
	public static Read_XLS TestCaseListExcel_SuiteRefactor_001_TestData = null;
	
	
	/**
	 * Suite RFI.
	 */
	public static Read_XLS TestSuiteListExcel = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_002_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_003_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_004_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_005_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_006_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_007_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_008_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_009_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_010_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_011_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_012_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_013_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_014_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteRFI_015_TestData = null;
	
	
	/** Suite Reg. */
	public static Read_XLS TestCaseListExcel_SuiteReg_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteReg_002_TestData = null;
	
	
	/** Suite PA. */
	public static Read_XLS TestCaseListExcel_SuitePA_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_002_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_003_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_004_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_005_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_006_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_007_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_008_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePA_009_TestData = null;

	
	/** Suite User Acc. */
	public static Read_XLS TestCaseListExcel_SuiteUserAcc_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteUserAcc_002_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteUserAcc_003_TestData = null;
	
	
	/** Suite Nav Bar. */
	public static Read_XLS TestCaseListExcel_SuiteNavBar_001_TestData = null;
	
	
	/** Suite eMag. */
	public static Read_XLS TestCaseListExcel_SuiteeMag_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteeMag_002_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteeMag_003_TestData = null;
	
	
	/** Suite SA. */
	public static Read_XLS TestCaseListExcel_SuiteSA_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSA_002_TestData = null;
	
	
	/** Suite Search. */
	public static Read_XLS TestCaseListExcel_SuiteSearch_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSearch_002_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSearch_003_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSearch_004_TestData = null;
	
	
	/** Suite Production Bug. */
	public static Read_XLS TestCaseListExcel_SuiteBug_001_TestData = null;
	
	
	/** Suite Product Profile. */
	public static Read_XLS TestCaseListExcel_SuitePP_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePP_002_TestData = null;
	public static Read_XLS TestCaseListExcel_SuitePP_003_TestData = null;
	
	
	/** Suite Supplier Profile. */
	public static Read_XLS TestCaseListExcel_SuiteSP_001_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSP_002_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSP_003_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSP_004_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSP_005_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSP_006_TestData = null;
	public static Read_XLS TestCaseListExcel_SuiteSP_007_TestData = null;
	
	
	/**
	 * Suite Refactor output file.
	 */
	public static Read_XLS Refactor_0001_TestResult = null;
	public static Read_XLS Refactor_0003_TestResult = null;
	public static Read_XLS Refactor_0004_TestResult = null;
	public static Read_XLS Refactor_0005_TestResult = null;
	public static Read_XLS Refactor_0006_TestResult = null;
	public static Read_XLS Refactor_0007_TestResult = null;
	public static Read_XLS Refactor_0008_TestResult = null;
	
	
	/**
	 * Suite RFI output file.
	 */
	public static Read_XLS InqFlowLI1_PdtInq_0001_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0002_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0003_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0004_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0005_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0006_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0007_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0008_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0009_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0010_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0011_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0012_TestResult = null;
	public static Read_XLS InqFlowLI1_PdtInq_0013_TestResult = null;	
	public static Read_XLS InqFlowLI1_SuppInq_0001_TestResult = null;
	public static Read_XLS InqFlowLI1_SuppInq_0002_TestResult = null;
	public static Read_XLS InqFlowLI1_SuppInq_0003_TestResult = null;
	public static Read_XLS InqFlowLI1_SuppInq_0004_TestResult = null;
	public static Read_XLS InqFlowLI1_LoginTest_TestResult = null;
	
	public static Read_XLS InqFlowLI2_PdtInq_0001_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0002_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0003_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0004_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0005_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0006_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0007_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0008_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0009_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0010_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0011_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0012_TestResult = null;
	public static Read_XLS InqFlowLI2_PdtInq_0013_TestResult = null;	
	public static Read_XLS InqFlowLI2_SuppInq_0001_TestResult = null;
	public static Read_XLS InqFlowLI2_SuppInq_0002_TestResult = null;
	public static Read_XLS InqFlowLI2_SuppInq_0003_TestResult = null;
	public static Read_XLS InqFlowLI2_SuppInq_0004_TestResult = null;
	public static Read_XLS InqFlowLI2_LoginTest_TestResult = null;
	
	public static Read_XLS InqFlowLI3_PdtInq_0001_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0002_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0003_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0004_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0005_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0006_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0007_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0008_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0009_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0010_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0011_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0012_TestResult = null;
	public static Read_XLS InqFlowLI3_PdtInq_0013_TestResult = null;	
	public static Read_XLS InqFlowLI3_SuppInq_0001_TestResult = null;
	public static Read_XLS InqFlowLI3_SuppInq_0002_TestResult = null;
	public static Read_XLS InqFlowLI3_SuppInq_0003_TestResult = null;
	public static Read_XLS InqFlowLI3_SuppInq_0004_TestResult = null;
			
	public static Read_XLS InqFlowNL1_PdtInq_0001_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0002_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0003_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0004_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0005_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0006_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0007_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0008_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0009_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0010_TestResult = null;
	public static Read_XLS InqFlowNL1_PdtInq_0011_TestResult = null;
	public static Read_XLS InqFlowNL1_SuppInq_0001_TestResult = null;
	public static Read_XLS InqFlowNL1_SuppInq_0002_TestResult = null;
	public static Read_XLS InqFlowNL1_SuppInq_0003_TestResult = null;
	public static Read_XLS InqFlowNL1_SuppInq_0004_TestResult = null;
	
	public static Read_XLS RFI_Attachment_0001_TestResult = null;	
	public static Read_XLS RFI_Form_0001_TestResult = null;
	public static Read_XLS RFI_Form_0002_TestResult = null;
	public static Read_XLS RFI_Form_0003_TestResult = null;
	public static Read_XLS RFI_Form_0004_TestResult = null;
	public static Read_XLS RFI_Form_0005_TestResult = null;
	public static Read_XLS RFI_Form_0006_TestResult = null;
	public static Read_XLS RFI_Form_0007_TestResult = null;
	public static Read_XLS RFI_Form_0008_TestResult = null;
	public static Read_XLS RFI_Form_0009_TestResult = null;
	public static Read_XLS RFI_Form_0010_TestResult = null;
	public static Read_XLS RFI_Form_0011_TestResult = null;
	public static Read_XLS RFI_InqBasket_0001_TestResult = null;
	public static Read_XLS RFI_InqBasket_0002_TestResult = null;
	public static Read_XLS RFI_InqBasket_0003_TestResult = null;
	public static Read_XLS RFS_Flow_0001_TestResult = null;
	public static Read_XLS RFS_Flow_0002_TestResult = null;
	public static Read_XLS RFS_Form_0001_TestResult = null;
	public static Read_XLS RFI_PALanding_0001_TestResult = null;
	public static Read_XLS RFI_PALanding_0002_TestResult = null;
	public static Read_XLS RFI_PALanding_0003_TestResult = null;
	public static Read_XLS RFI_PALanding_0004_TestResult = null;
	public static Read_XLS RFI_PALanding_0005_TestResult = null;
	public static Read_XLS RFI_RequestLatestPrice_0001_TestResult = null;
	public static Read_XLS RFI_RequestLatestPrice_0002_TestResult = null;
	public static Read_XLS RFI_RequestLatestPrice_0003_TestResult = null;
	
	
	/**
	 * Suite Reg output file.
	 */
	public static Read_XLS Registration_0001_TestResult = null;
	public static Read_XLS Registration_0002_TestResult = null;
	public static Read_XLS Registration_0003_TestResult = null;
	public static Read_XLS Registration_0004_TestResult = null;
	public static Read_XLS Registration_0005_TestResult = null;
	public static Read_XLS Registration_0006_TestResult = null;
	public static Read_XLS Registration_0007_TestResult = null;
	public static Read_XLS Registration_0008_TestResult = null;
	public static Read_XLS Registration_0009_TestResult = null;
	public static Read_XLS Registration_0010_TestResult = null;
	public static Read_XLS Registration_0011_TestResult = null;
	public static Read_XLS Registration_0012_TestResult = null;
	public static Read_XLS Registration_0013_TestResult = null;
	public static Read_XLS Registration_0014_TestResult = null;
	public static Read_XLS Registration_0015_TestResult = null;
	public static Read_XLS Registration_0016_TestResult = null;
	
	
	/**
	 * Suite PA output file.
	 */
	public static Read_XLS PA_EditCategories_0001_TestResult = null;
	public static Read_XLS PA_EditCategories_0002_TestResult = null;
	public static Read_XLS PA_EditCategories_0003_TestResult = null;
	public static Read_XLS PA_EditCategories_0004_TestResult = null;
	public static Read_XLS PA_EditCategories_0005_TestResult = null;
	public static Read_XLS PA_EditCategories_0006_TestResult = null;
	public static Read_XLS PA_EditCategories_0007_TestResult = null;
	public static Read_XLS PA_EditCategories_0008_TestResult = null;
	public static Read_XLS PA_EditCategories_0009_TestResult = null;
	public static Read_XLS PA_EditCategories_0010_TestResult = null;
	public static Read_XLS PA_EditCategories_0011_TestResult = null;
	public static Read_XLS PA_EditCategories_0012_TestResult = null;
	public static Read_XLS PA_EditCategories_0013_TestResult = null;
	public static Read_XLS PA_EditCategories_0014_TestResult = null;
	
	public static Read_XLS PA_EditCategories_0015_TestResult = null;
	public static Read_XLS PA_EditCategories_0016_TestResult = null;
	public static Read_XLS PA_EditCategories_0017_TestResult = null;
	public static Read_XLS PA_EditCategories_0018_TestResult = null;
	public static Read_XLS PA_EditCategories_0019_TestResult = null;
	public static Read_XLS PA_EditCategories_0020_TestResult = null;
	public static Read_XLS PA_EditCategories_0021_TestResult = null;
	public static Read_XLS PA_EditCategories_0022_TestResult = null;
	public static Read_XLS PA_EditCategories_0023_TestResult = null;
	public static Read_XLS PA_EditCategories_0024_TestResult = null;
	public static Read_XLS PA_EditCategories_0025_TestResult = null;
	public static Read_XLS PA_EditCategories_0026_TestResult = null;
	
	public static Read_XLS PA_Homepage_0001_TestResult = null;
	public static Read_XLS PA_Homepage_0002_TestResult = null;
	
	public static Read_XLS PA_LiteSignup_0001_TestResult = null;
	public static Read_XLS PA_LiteSignup_0002_TestResult = null;
	public static Read_XLS PA_LiteSignup_0003_TestResult = null;
	public static Read_XLS PA_LiteSignup_0004_TestResult = null;
	public static Read_XLS PA_LiteSignup_0005_TestResult = null;
	public static Read_XLS PA_LiteSignup_0006_TestResult = null;
	public static Read_XLS PA_LiteSignup_0007_TestResult = null;
	public static Read_XLS PA_LiteSignup_0008_TestResult = null;
	public static Read_XLS PA_LiteSignup_0009_TestResult = null;
	public static Read_XLS PA_LiteSignup_0010_TestResult = null;
	public static Read_XLS PA_LiteSignup_0011_TestResult = null;
	public static Read_XLS PA_LiteSignup_0012_TestResult = null;
	public static Read_XLS PA_LiteSignup_0013_TestResult = null;
	
	public static Read_XLS PA_LiteSignup_0014_TestResult = null;
	public static Read_XLS PA_LiteSignup_0015_TestResult = null;
	public static Read_XLS PA_LiteSignup_0016_TestResult = null;
	public static Read_XLS PA_LiteSignup_0017_TestResult = null;
	public static Read_XLS PA_LiteSignup_0018_TestResult = null;
	public static Read_XLS PA_LiteSignup_0019_TestResult = null;
	public static Read_XLS PA_LiteSignup_0020_TestResult = null;
	public static Read_XLS PA_LiteSignup_0021_TestResult = null;
	public static Read_XLS PA_LiteSignup_0022_TestResult = null;
	public static Read_XLS PA_LiteSignup_0023_TestResult = null;
	public static Read_XLS PA_LiteSignup_0024_TestResult = null;
	public static Read_XLS PA_LiteSignup_0025_TestResult = null;
	public static Read_XLS PA_LiteSignup_0026_TestResult = null;
	public static Read_XLS PA_LiteSignup_0027_TestResult = null;
	public static Read_XLS PA_LiteSignup_0028_TestResult = null;
	public static Read_XLS PA_LiteSignup_0029_TestResult = null;
	
	
	public static Read_XLS PA_Upgrade_0001_TestResult = null;
	public static Read_XLS PA_Upgrade_0002_TestResult = null;
	public static Read_XLS PA_Upgrade_0003_TestResult = null;
	public static Read_XLS PA_Upgrade_0004_TestResult = null;
	public static Read_XLS PA_Upgrade_0005_TestResult = null;
	public static Read_XLS PA_Upgrade_0006_TestResult = null;
	public static Read_XLS PA_Upgrade_0007_TestResult = null;
	
	public static Read_XLS GetNotified_0001_TestResult = null;
	
	
	/**
	 * Suite User Acc output file.
	 */
	public static Read_XLS ForgetPassword_0001_TestResult = null;
	public static Read_XLS ForgetPassword_0002_TestResult = null;
	public static Read_XLS ForgetPassword_0003_TestResult = null;
	public static Read_XLS ForgetPassword_0004_TestResult = null;
	public static Read_XLS Login_0001_TestResult = null;
	public static Read_XLS Login_0002_TestResult = null;
	public static Read_XLS Login_0003_TestResult = null;
	public static Read_XLS Login_0004_TestResult = null;
	public static Read_XLS Login_0005_TestResult = null;
	public static Read_XLS Login_0006_TestResult = null;
	public static Read_XLS Login_0007_TestResult = null;
	public static Read_XLS Login_0008_TestResult = null;
	public static Read_XLS Login_0009_TestResult = null;
	public static Read_XLS Login_0010_TestResult = null;
	public static Read_XLS RFI_BuyerProfile_0001_TestResult = null;
	public static Read_XLS RFI_BuyerProfile_0002_TestResult = null;
	public static Read_XLS RFI_BuyerProfile_0003_TestResult = null;
	public static Read_XLS RFI_BuyerProfile_0004_TestResult = null;
	public static Read_XLS RFI_BuyerProfile_0005_TestResult = null;
	public static Read_XLS RFI_BuyerProfile_0006_TestResult = null;
	public static Read_XLS RFS_BuyerProfile_0001_TestResult = null;
	public static Read_XLS RFS_BuyerProfile_0002_TestResult = null;
	public static Read_XLS RFS_BuyerProfile_0003_TestResult = null;
	public static Read_XLS RFS_BuyerProfile_0004_TestResult = null;
	public static Read_XLS RFS_BuyerProfile_0005_TestResult = null;
	public static Read_XLS UserProfile_0001_TestResult = null;
	
		
	/**
	 * Suite Nav Bar output file.
	 */
	public static Read_XLS GlobalNavigator_0001_TestResult = null;
	public static Read_XLS GlobalNavigator_0002_TestResult = null;
	public static Read_XLS GlobalNavigator_0003_TestResult = null;
	public static Read_XLS GlobalNavigator_0004_TestResult = null;
	public static Read_XLS GlobalNavigator_0005_TestResult = null;
	public static Read_XLS GlobalNavigator_0006_TestResult = null;
	public static Read_XLS TopNavigator_0001_TestResult = null;
	public static Read_XLS TopNavigator_0002_TestResult = null;
	
	
	/**
	 * Suite eMag output file.
	 */
	public static Read_XLS eMagLite_0001_TestResult = null;
	public static Read_XLS eMagLite_0002_TestResult = null;
	public static Read_XLS eMagLite_0003_TestResult = null;
	public static Read_XLS eMagLite_0004_TestResult = null;
	public static Read_XLS eMagUpgrade_0001_TestResult = null;
	public static Read_XLS eMagSubscription_0001_TestResult = null;
	public static Read_XLS eMagSubscription_0002_TestResult = null;
	public static Read_XLS eMagSubscription_0003_TestResult = null;
	public static Read_XLS eMagSubscription_0004_TestResult = null;
	public static Read_XLS eMagSubscription_0005_TestResult = null;
	public static Read_XLS eMagSubscription_0006_TestResult = null;
	public static Read_XLS eMagSubscription_0007_TestResult = null;
	public static Read_XLS eMagSubscription_0008_TestResult = null;
	public static Read_XLS eMagSubscription_0009_TestResult = null;
	public static Read_XLS eMagSubscription_0010_TestResult = null;
	public static Read_XLS eMagSubscription_0011_TestResult = null;
	
	
	/**
	 * Suite SA output file.
	 */
	public static Read_XLS SupplierAlert_0001_TestResult = null;
	public static Read_XLS SupplierAlert_0002_TestResult = null;
	public static Read_XLS SupplierAlert_0003_TestResult = null;
	public static Read_XLS SupplierAlert_0004_TestResult = null;
	public static Read_XLS SupplierAlert_0005_TestResult = null;
	public static Read_XLS SupplierAlert_0006_TestResult = null;
	public static Read_XLS SupplierAlert_0007_TestResult = null;
	public static Read_XLS SupplierAlert_0008_TestResult = null;
	public static Read_XLS SupplierAlert_0009_TestResult = null;
	public static Read_XLS SupplierAlert_0010_TestResult = null;
	public static Read_XLS SupplierAlert_0011_TestResult = null;
	public static Read_XLS SupplierAlert_0012_TestResult = null;
	public static Read_XLS SupplierAlert_0013_TestResult = null;
	
	
	/**
	 * Suite Search output file.
	 */
	public static Read_XLS ProductSearch_0001_TestResult = null;
	public static Read_XLS SupplierSearch_0001_TestResult = null;
	public static Read_XLS NewsSearch_0001_TestResult = null;
	
	public static Read_XLS ProductAdvSearch_0001_TestResult = null;
	public static Read_XLS ProductAdvSearch_0002_TestResult = null;
	public static Read_XLS ProductAdvSearch_0003_TestResult = null;
	public static Read_XLS ProductAdvSearch_0004_TestResult = null;
	public static Read_XLS ProductAdvSearch_0005_TestResult = null;
	
	public static Read_XLS SuppAdvSearch_0001_TestResult = null;
	public static Read_XLS SuppAdvSearch_0002_TestResult = null;
	public static Read_XLS SuppAdvSearch_0003_TestResult = null;
	public static Read_XLS SuppAdvSearch_0004_TestResult = null;
	public static Read_XLS SuppAdvSearch_0005_TestResult = null;
	public static Read_XLS SuppAdvSearch_0006_TestResult = null;
	public static Read_XLS SuppAdvSearch_0007_TestResult = null;
	public static Read_XLS SuppAdvSearch_0008_TestResult = null;
	public static Read_XLS SuppAdvSearch_0009_TestResult = null;
	public static Read_XLS SuppAdvSearch_0010_TestResult = null;
	public static Read_XLS SuppAdvSearch_0011_TestResult = null;
	public static Read_XLS SuppAdvSearch_0012_TestResult = null;
	public static Read_XLS SuppAdvSearch_0013_TestResult = null;
	public static Read_XLS SuppAdvSearch_0014_TestResult = null;
	public static Read_XLS SuppAdvSearch_0015_TestResult = null;
	
	public static Read_XLS NewsAdvSearch_0001_TestResult = null;
	public static Read_XLS NewsAdvSearch_0002_TestResult = null;
	public static Read_XLS NewsAdvSearch_0003_TestResult = null;
	public static Read_XLS NewsAdvSearch_0004_TestResult = null;
	public static Read_XLS NewsAdvSearch_0005_TestResult = null;
	
	public static Read_XLS AdvanceSearch_0001_TestResult = null;
	public static Read_XLS AdvanceSearch_0002_TestResult = null;
	public static Read_XLS AdvanceSearch_0003_TestResult = null;
	public static Read_XLS AdvanceSearch_0004_TestResult = null;
	public static Read_XLS AdvanceSearch_0005_TestResult = null;
	
	
	/**
	 * Suite Production Bug output file.
	 */
	public static Read_XLS ProductionBug_0001_TestResult = null;
	public static Read_XLS ProductionBug_0002_TestResult = null;
	public static Read_XLS ProductionBug_0003_TestResult = null;
	public static Read_XLS ProductionBug_0004_TestResult = null;
	public static Read_XLS ProductionBug_0005_TestResult = null;
	public static Read_XLS ProductionBug_0006_TestResult = null;
	
	
	/**
	 * Suite Product Profile output file.
	 */
	public static Read_XLS ProductProfile_0001_TestResult = null;
	public static Read_XLS ProductProfile_0002_TestResult = null;
	public static Read_XLS ProductProfile_0003_TestResult = null;
	public static Read_XLS ProductProfile_0004_TestResult = null;
	public static Read_XLS ProductProfile_0005_TestResult = null;
	public static Read_XLS ProductProfile_0006_TestResult = null;
	public static Read_XLS ProductProfile_0007_TestResult = null;
	public static Read_XLS ProductProfile_0008_TestResult = null;
	public static Read_XLS ProductProfile_0009_TestResult = null;
	public static Read_XLS ProductProfile_0010_TestResult = null;
	public static Read_XLS ProductProfile_0011_TestResult = null;
	public static Read_XLS ProductProfile_0012_TestResult = null;
	public static Read_XLS ProductProfile_0013_TestResult = null;
	public static Read_XLS ProductProfile_0014_TestResult = null;
	public static Read_XLS ProductProfile_0015_TestResult = null;
	public static Read_XLS ProductProfile_0016_TestResult = null;
	public static Read_XLS ProductProfile_0017_TestResult = null;
	public static Read_XLS ProductProfile_0018_TestResult = null;
	public static Read_XLS ProductProfile_0019_TestResult = null;
	public static Read_XLS ProductProfile_0020_TestResult = null;
	
	
	/**
	 * Suite Supplier Profile output file.
	 */
	public static Read_XLS SupplierProfile_0001_TestResult = null;
	public static Read_XLS SupplierProfile_0002_TestResult = null;
	public static Read_XLS SupplierProfile_0003_TestResult = null;
	public static Read_XLS SupplierProfile_0004_TestResult = null;
	public static Read_XLS SupplierProfile_0005_TestResult = null;
	public static Read_XLS SupplierProfile_0006_TestResult = null;
	public static Read_XLS SupplierProfile_0007_TestResult = null;
	public static Read_XLS SupplierProfile_0008_TestResult = null;
	public static Read_XLS SupplierProfile_0009_TestResult = null;
	public static Read_XLS SupplierProfile_0010_TestResult = null;
	public static Read_XLS SupplierProfile_0011_TestResult = null;
	public static Read_XLS SupplierProfile_0012_TestResult = null;
	public static Read_XLS SupplierProfile_0013_TestResult = null;
	public static Read_XLS SupplierProfile_0014_TestResult = null;
	public static Read_XLS SupplierProfile_0015_TestResult = null;
	public static Read_XLS SupplierProfile_0016_TestResult = null;
	public static Read_XLS SupplierProfile_0017_TestResult = null;
	public static Read_XLS SupplierProfile_0018_TestResult = null;
	public static Read_XLS SupplierProfile_0019_TestResult = null;
	public static Read_XLS SupplierProfile_0020_TestResult = null;
	public static Read_XLS SupplierProfile_0021_TestResult = null;
	public static Read_XLS SupplierProfile_0022_TestResult = null;
	public static Read_XLS SupplierProfile_0023_TestResult = null;
	
	public static Read_XLS SupplierAGG_0001_TestResult = null;
	public static Read_XLS SupplierAGG_0002_TestResult = null;
	public static Read_XLS SupplierAGG_0003_TestResult = null;
	public static Read_XLS SupplierAGG_0004_TestResult = null;
	public static Read_XLS SupplierAGG_0005_TestResult = null;
	public static Read_XLS SupplierAGG_0006_TestResult = null;
	public static Read_XLS SupplierAGG_0007_TestResult = null;
	public static Read_XLS SupplierAGG_0008_TestResult = null;
	public static Read_XLS SupplierAGG_0009_TestResult = null;
	public static Read_XLS SupplierAGG_0010_TestResult = null;
	public static Read_XLS SupplierAGG_0011_TestResult = null;
	public static Read_XLS SupplierAGG_0012_TestResult = null;
	public static Read_XLS SupplierAGG_0013_TestResult = null;
	public static Read_XLS SupplierAGG_0014_TestResult = null;
	public static Read_XLS SupplierAGG_0015_TestResult = null;
	public static Read_XLS SupplierAGG_0016_TestResult = null;
	public static Read_XLS SupplierAGG_0017_TestResult = null;
	public static Read_XLS SupplierAGG_0018_TestResult = null;
	public static Read_XLS SupplierAGG_0019_TestResult = null;
	public static Read_XLS SupplierAGG_0020_TestResult = null;
	public static Read_XLS SupplierAGG_0021_TestResult = null;
	public static Read_XLS SupplierAGG_0022_TestResult = null;
	public static Read_XLS SupplierAGG_0023_TestResult = null;
	public static Read_XLS SupplierAGG_0024_TestResult = null;
	public static Read_XLS SupplierAGG_0025_TestResult = null;
	public static Read_XLS SupplierAGG_0026_TestResult = null;
	public static Read_XLS SupplierAGG_0027_TestResult = null;
	public static Read_XLS SupplierAGG_0028_TestResult = null;
	public static Read_XLS SupplierAGG_0029_TestResult = null;
	public static Read_XLS SupplierAGG_0030_TestResult = null;
	public static Read_XLS SupplierAGG_0031_TestResult = null;
	public static Read_XLS SupplierAGG_0032_TestResult = null;
	public static Read_XLS SupplierAGG_0033_TestResult = null;
	
	
	/**
	 * Initialize Test Data and Properties file.
	 * 
	 * @throws IOException  if an input or output exception occurred
	 */
	public void init() throws IOException{
		
		// To Initialize logger service.
		Add_Log = Logger.getLogger("rootLogger");				
				
		// Initializing Test Suite List(TestSuiteList.xls) File Path Using Constructor Of Read_XLS Utility Class.
		TestSuiteListExcel = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\TestSuiteList.xls");
		
		
		// ======================= Test Result for Module PA =======================
		TestCaseListExcel_SuiteRefactor_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRefactor\\SuiteRefactor_001.xls");
		
		
		// Initializing Test Suite RFI (SuiteRFI.xls) File Path Using Constructor Of Read_XLS Utility Class.
		TestCaseListExcel_SuiteRFI_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_001.xls");
		TestCaseListExcel_SuiteRFI_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_002.xls");
		TestCaseListExcel_SuiteRFI_003_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_003.xls");
		TestCaseListExcel_SuiteRFI_004_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_004.xls");
		TestCaseListExcel_SuiteRFI_005_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_005.xls");
		TestCaseListExcel_SuiteRFI_006_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_006.xls");
		TestCaseListExcel_SuiteRFI_007_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_007.xls");
		TestCaseListExcel_SuiteRFI_008_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_008.xls");
		TestCaseListExcel_SuiteRFI_009_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_009.xls");
		TestCaseListExcel_SuiteRFI_010_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_010.xls");
		TestCaseListExcel_SuiteRFI_011_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_011.xls");
		TestCaseListExcel_SuiteRFI_012_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_012.xls");
		TestCaseListExcel_SuiteRFI_013_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_013.xls");
		TestCaseListExcel_SuiteRFI_014_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_014.xls");
		TestCaseListExcel_SuiteRFI_015_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleRFI\\SuiteRFI_015.xls");
		
		TestCaseListExcel_SuiteReg_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleReg\\SuiteReg_001.xls");
		TestCaseListExcel_SuiteReg_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleReg\\SuiteReg_002.xls");
		
		TestCaseListExcel_SuitePA_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_001.xls");
		TestCaseListExcel_SuitePA_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_002.xls");
		TestCaseListExcel_SuitePA_003_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_003.xls");
		TestCaseListExcel_SuitePA_004_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_004.xls");
		TestCaseListExcel_SuitePA_005_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_005.xls");
		TestCaseListExcel_SuitePA_006_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_006.xls");
		TestCaseListExcel_SuitePA_007_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_007.xls");
		TestCaseListExcel_SuitePA_008_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_008.xls");
		TestCaseListExcel_SuitePA_009_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePA\\SuitePA_009.xls");
		
		TestCaseListExcel_SuiteUserAcc_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleUserAcc\\SuiteUserAcc_001.xls");
		TestCaseListExcel_SuiteUserAcc_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleUserAcc\\SuiteUserAcc_002.xls");
		TestCaseListExcel_SuiteUserAcc_003_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleUserAcc\\SuiteUserAcc_003.xls");
		
		TestCaseListExcel_SuiteNavBar_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleNavBar\\SuiteNavBar_001.xls");
		
		TestCaseListExcel_SuiteeMag_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleeMag\\SuiteeMag_001.xls");
		TestCaseListExcel_SuiteeMag_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleeMag\\SuiteeMag_002.xls");
		TestCaseListExcel_SuiteeMag_003_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleeMag\\SuiteeMag_003.xls");
		
		TestCaseListExcel_SuiteSA_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSA\\SuiteSA_001.xls");
		TestCaseListExcel_SuiteSA_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSA\\SuiteSA_002.xls");
		
		TestCaseListExcel_SuiteSearch_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSearch\\SuiteSearch_001.xls");
		TestCaseListExcel_SuiteSearch_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSearch\\SuiteSearch_002.xls");
		TestCaseListExcel_SuiteSearch_003_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSearch\\SuiteSearch_003.xls");
		TestCaseListExcel_SuiteSearch_004_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSearch\\SuiteSearch_004.xls");
		
		TestCaseListExcel_SuiteBug_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleBug\\SuiteBug_001.xls");
		
		TestCaseListExcel_SuitePP_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePP\\SuitePP_001.xls");
		TestCaseListExcel_SuitePP_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePP\\SuitePP_002.xls");
		TestCaseListExcel_SuitePP_003_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModulePP\\SuitePP_003.xls");
		
		TestCaseListExcel_SuiteSP_001_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSP\\SuiteSP_001.xls");
		TestCaseListExcel_SuiteSP_002_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSP\\SuiteSP_002.xls");
		TestCaseListExcel_SuiteSP_003_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSP\\SuiteSP_003.xls");
		TestCaseListExcel_SuiteSP_004_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSP\\SuiteSP_004.xls");
		TestCaseListExcel_SuiteSP_005_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSP\\SuiteSP_005.xls");
		TestCaseListExcel_SuiteSP_006_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSP\\SuiteSP_006.xls");
		TestCaseListExcel_SuiteSP_007_TestData = new Read_XLS(System.getProperty("user.dir")+"\\TestData\\ModuleSP\\SuiteSP_007.xls");
		
		
		// ====================== Test Result for Module Refactor ======================
		Refactor_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRefactor\\Refactor_0001.xls");
		Refactor_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRefactor\\Refactor_0003.xls");
		Refactor_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRefactor\\Refactor_0004.xls");
		Refactor_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRefactor\\Refactor_0005.xls");
		Refactor_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRefactor\\Refactor_0006.xls");
		Refactor_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRefactor\\Refactor_0007.xls");
		Refactor_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRefactor\\Refactor_0008.xls");
		
		
		// =============== Test Result for RFI Flow Logged-in User (LI1) ===============
		InqFlowLI1_PdtInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0001.xls");
		InqFlowLI1_PdtInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0002.xls");
		InqFlowLI1_PdtInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0003.xls");
		InqFlowLI1_PdtInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0004.xls");
		InqFlowLI1_PdtInq_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0005.xls");
		InqFlowLI1_PdtInq_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0006.xls");
		InqFlowLI1_PdtInq_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0007.xls");
		InqFlowLI1_PdtInq_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0008.xls");
		InqFlowLI1_PdtInq_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0009.xls");
		InqFlowLI1_PdtInq_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0010.xls");
		InqFlowLI1_PdtInq_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0011.xls");
		InqFlowLI1_PdtInq_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0012.xls");
		InqFlowLI1_PdtInq_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_PdtInq_0013.xls");		
		InqFlowLI1_SuppInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_SuppInq_0001.xls");
		InqFlowLI1_SuppInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_SuppInq_0002.xls");
		InqFlowLI1_SuppInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_SuppInq_0003.xls");
		InqFlowLI1_SuppInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_SuppInq_0004.xls");
		InqFlowLI1_LoginTest_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI1_LoginTest.xls");
		
		
		// =============== Test Result for RFI Flow Login on Form (LI2) ===============
		InqFlowLI2_PdtInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0001.xls");
		InqFlowLI2_PdtInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0002.xls");
		InqFlowLI2_PdtInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0003.xls");
		InqFlowLI2_PdtInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0004.xls");
		InqFlowLI2_PdtInq_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0005.xls");
		InqFlowLI2_PdtInq_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0006.xls");
		InqFlowLI2_PdtInq_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0007.xls");
		InqFlowLI2_PdtInq_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0008.xls");
		InqFlowLI2_PdtInq_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0009.xls");
		InqFlowLI2_PdtInq_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0010.xls");
		InqFlowLI2_PdtInq_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0011.xls");
		InqFlowLI2_PdtInq_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0012.xls");
		InqFlowLI2_PdtInq_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_PdtInq_0013.xls");		
		InqFlowLI2_SuppInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_SuppInq_0001.xls");
		InqFlowLI2_SuppInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_SuppInq_0002.xls");
		InqFlowLI2_SuppInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_SuppInq_0003.xls");
		InqFlowLI2_SuppInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_SuppInq_0004.xls");
		InqFlowLI2_LoginTest_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI2_LoginTest.xls");
		
		
		// =============== Test Result for RFI Flow Post Login (LI3) ===============
		InqFlowLI3_PdtInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0001.xls");
		InqFlowLI3_PdtInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0002.xls");
		InqFlowLI3_PdtInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0003.xls");
		InqFlowLI3_PdtInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0004.xls");
		InqFlowLI3_PdtInq_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0005.xls");
		InqFlowLI3_PdtInq_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0006.xls");
		InqFlowLI3_PdtInq_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0007.xls");
		InqFlowLI3_PdtInq_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0008.xls");
		InqFlowLI3_PdtInq_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0009.xls");
		InqFlowLI3_PdtInq_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0010.xls");
		InqFlowLI3_PdtInq_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0011.xls");
		InqFlowLI3_PdtInq_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0012.xls");
		InqFlowLI3_PdtInq_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_PdtInq_0013.xls");		
		InqFlowLI3_SuppInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_SuppInq_0001.xls");
		InqFlowLI3_SuppInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_SuppInq_0002.xls");
		InqFlowLI3_SuppInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_SuppInq_0003.xls");
		InqFlowLI3_SuppInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowLI3_SuppInq_0004.xls");
		
		
		// =============== Test Result for RFI Flow New User (NL1) =================
		InqFlowNL1_PdtInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0001.xls");
		InqFlowNL1_PdtInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0002.xls");
		InqFlowNL1_PdtInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0003.xls");
		InqFlowNL1_PdtInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0004.xls");
		InqFlowNL1_PdtInq_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0005.xls");
		InqFlowNL1_PdtInq_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0006.xls");
		InqFlowNL1_PdtInq_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0007.xls");
		InqFlowNL1_PdtInq_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0008.xls");
		InqFlowNL1_PdtInq_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0009.xls");
		InqFlowNL1_PdtInq_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0010.xls");
		InqFlowNL1_PdtInq_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_PdtInq_0011.xls");				
		InqFlowNL1_SuppInq_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_SuppInq_0001.xls");
		InqFlowNL1_SuppInq_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_SuppInq_0002.xls");
		InqFlowNL1_SuppInq_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_SuppInq_0003.xls");
		InqFlowNL1_SuppInq_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\InqFlowNL1_SuppInq_0004.xls");
		
		
		// ======================= Test Result for Module RFI ======================
		RFI_Attachment_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Attachment_0001.xls");
		RFI_Form_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0001.xls");
		RFI_Form_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0002.xls");
		RFI_Form_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0003.xls");
		RFI_Form_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0004.xls");
		RFI_Form_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0005.xls");
		RFI_Form_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0006.xls");
		RFI_Form_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0007.xls");
		RFI_Form_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0008.xls");
		RFI_Form_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0009.xls");
		RFI_Form_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0010.xls");
		RFI_Form_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_Form_0011.xls");	
		RFI_InqBasket_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_InqBasket_0001.xls");
		RFI_InqBasket_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_InqBasket_0002.xls");
		RFI_InqBasket_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_InqBasket_0003.xls");
		RFS_Flow_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFS_Flow_0001.xls");		
		RFS_Flow_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFS_Flow_0002.xls");	
		RFS_Form_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFS_Form_0001.xls");
		RFI_PALanding_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_PALanding_0001.xls");
		RFI_PALanding_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_PALanding_0002.xls");
		RFI_PALanding_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_PALanding_0003.xls");
	//	RFI_PALanding_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_PALanding_0004.xls");
	//	RFI_PALanding_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_PALanding_0005.xls");
		RFI_RequestLatestPrice_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_RequestLatestPrice_0001.xls");
		RFI_RequestLatestPrice_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_RequestLatestPrice_0002.xls");
		RFI_RequestLatestPrice_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleRFI\\RFI_RequestLatestPrice_0003.xls");
		
		
		// ====================== Test Result for Module Reg =======================
		Registration_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0001.xls");
		Registration_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0002.xls");
		Registration_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0003.xls");
		Registration_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0004.xls");
		Registration_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0005.xls");
		Registration_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0006.xls");
		Registration_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0007.xls");
		Registration_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0008.xls");
		Registration_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0009.xls");
		Registration_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0010.xls");
		Registration_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0011.xls");
		Registration_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0012.xls");
		Registration_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0013.xls");
		Registration_0014_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0014.xls");
		Registration_0015_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0015.xls");
		Registration_0016_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleReg\\Registration_0016.xls");
		
		
		// ======================= Test Result for Module PA =======================
		PA_EditCategories_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0001.xls");
		PA_EditCategories_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0002.xls");
		PA_EditCategories_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0003.xls");
		PA_EditCategories_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0004.xls");
		PA_EditCategories_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0005.xls");
		PA_EditCategories_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0006.xls");
		PA_EditCategories_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0007.xls");
		PA_EditCategories_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0008.xls");
		PA_EditCategories_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0009.xls");
		PA_EditCategories_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0010.xls");
		PA_EditCategories_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0011.xls");
		PA_EditCategories_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0012.xls");
		PA_EditCategories_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0013.xls");
		PA_EditCategories_0014_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0014.xls");
		
		PA_EditCategories_0015_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0015.xls");
		PA_EditCategories_0016_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0016.xls");
		PA_EditCategories_0017_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0017.xls");
		PA_EditCategories_0018_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0018.xls");
		PA_EditCategories_0019_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0019.xls");
		PA_EditCategories_0020_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0020.xls");
		PA_EditCategories_0021_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0021.xls");
		PA_EditCategories_0022_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0022.xls");
		PA_EditCategories_0023_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0023.xls");
		PA_EditCategories_0024_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0024.xls");
		PA_EditCategories_0025_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0025.xls");
		PA_EditCategories_0026_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_EditCategories_0026.xls");
		
		PA_Homepage_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Homepage_0001.xls");
		PA_Homepage_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Homepage_0002.xls");
		
		PA_LiteSignup_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0001.xls");
		PA_LiteSignup_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0002.xls");
		PA_LiteSignup_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0003.xls");
		PA_LiteSignup_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0004.xls");
		PA_LiteSignup_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0005.xls");
		PA_LiteSignup_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0006.xls");
		PA_LiteSignup_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0007.xls");
		PA_LiteSignup_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0008.xls");
		PA_LiteSignup_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0009.xls");
		PA_LiteSignup_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0010.xls");
		PA_LiteSignup_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0011.xls");
		PA_LiteSignup_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0012.xls");
		PA_LiteSignup_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0013.xls");
		
		PA_LiteSignup_0014_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0014.xls");
		PA_LiteSignup_0015_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0015.xls");
		PA_LiteSignup_0016_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0016.xls");
		PA_LiteSignup_0017_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0017.xls");
		PA_LiteSignup_0018_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0018.xls");
		PA_LiteSignup_0019_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0019.xls");
		PA_LiteSignup_0020_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0020.xls");
		PA_LiteSignup_0021_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0021.xls");
		PA_LiteSignup_0022_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0022.xls");
		PA_LiteSignup_0023_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0023.xls");
		PA_LiteSignup_0024_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0024.xls");
		PA_LiteSignup_0025_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0025.xls");
		PA_LiteSignup_0026_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0026.xls");
		PA_LiteSignup_0027_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0027.xls");
	//	PA_LiteSignup_0028_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0028.xls");
	//	PA_LiteSignup_0029_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_LiteSignup_0029.xls");
		
		PA_Upgrade_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Upgrade_0001.xls");
		PA_Upgrade_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Upgrade_0002.xls");
		PA_Upgrade_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Upgrade_0003.xls");
		PA_Upgrade_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Upgrade_0004.xls");
		PA_Upgrade_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Upgrade_0005.xls");
		PA_Upgrade_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Upgrade_0006.xls");
		PA_Upgrade_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\PA_Upgrade_0007.xls");
		
		GetNotified_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePA\\GetNotified_0001.xls");
	
		
		// ===================== Test Result for Module User Acc =====================
		ForgetPassword_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\ForgetPassword_0001.xls");
		ForgetPassword_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\ForgetPassword_0002.xls");
		ForgetPassword_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\ForgetPassword_0003.xls");
		ForgetPassword_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\ForgetPassword_0004.xls");
		Login_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0001.xls");
		Login_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0002.xls");
		Login_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0003.xls");
		Login_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0004.xls");
		Login_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0005.xls");
	//	Login_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0006.xls");
	//	Login_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0007.xls");
		Login_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0008.xls");
		Login_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0009.xls");
		Login_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\Login_0010.xls");
		RFI_BuyerProfile_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFI_BuyerProfile_0001.xls");
		RFI_BuyerProfile_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFI_BuyerProfile_0002.xls");
		RFI_BuyerProfile_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFI_BuyerProfile_0003.xls");
		RFI_BuyerProfile_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFI_BuyerProfile_0004.xls");
		RFI_BuyerProfile_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFI_BuyerProfile_0005.xls");
		RFI_BuyerProfile_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFI_BuyerProfile_0006.xls");
		RFS_BuyerProfile_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFS_BuyerProfile_0001.xls");
		RFS_BuyerProfile_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFS_BuyerProfile_0002.xls");
		RFS_BuyerProfile_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFS_BuyerProfile_0003.xls");
		RFS_BuyerProfile_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFS_BuyerProfile_0004.xls");
		RFS_BuyerProfile_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\RFS_BuyerProfile_0005.xls");
		UserProfile_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleUserAcc\\UserProfile_0001.xls");
		
		
		// ===================== Test Result for Module Nav Bar ======================
		GlobalNavigator_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\GlobalNavigator_0001.xls");
		GlobalNavigator_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\GlobalNavigator_0002.xls");
		GlobalNavigator_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\GlobalNavigator_0003.xls");
		GlobalNavigator_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\GlobalNavigator_0004.xls");
		GlobalNavigator_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\GlobalNavigator_0005.xls");
		GlobalNavigator_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\GlobalNavigator_0006.xls");
		TopNavigator_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\TopNavigator_0001.xls");
		TopNavigator_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleNavBar\\TopNavigator_0002.xls");
		
		
		// ===================== Test Result for Module eMag =========================
		eMagLite_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagLite_0001.xls");
		eMagLite_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagLite_0002.xls");
		eMagLite_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagLite_0003.xls");				
		eMagLite_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagLite_0004.xls");
		eMagUpgrade_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagUpgrade_0001.xls");
		eMagSubscription_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0001.xls");
		eMagSubscription_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0002.xls");
		eMagSubscription_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0003.xls");
		eMagSubscription_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0004.xls");
		eMagSubscription_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0005.xls");
		eMagSubscription_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0006.xls");
		eMagSubscription_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0007.xls");
		eMagSubscription_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0008.xls");
		eMagSubscription_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0009.xls");
		eMagSubscription_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0010.xls");
		eMagSubscription_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleeMag\\eMagSubscription_0011.xls");
		
		
		// ===================== Test Result for Module SA ===========================
		SupplierAlert_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0001.xls");
		SupplierAlert_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0002.xls");
		SupplierAlert_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0003.xls");
		SupplierAlert_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0004.xls");
		SupplierAlert_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0005.xls");
		SupplierAlert_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0006.xls");
		SupplierAlert_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0007.xls");
		SupplierAlert_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0008.xls");
		SupplierAlert_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0009.xls");
		SupplierAlert_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0010.xls");
		SupplierAlert_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0011.xls");		
		SupplierAlert_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0012.xls");
		SupplierAlert_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSA\\SupplierAlert_0013.xls");
		
		
		// ===================== Test Result for Module Search =======================
		ProductSearch_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\ProductSearch_0001.xls");
		SupplierSearch_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SupplierSearch_0001.xls");
		NewsSearch_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\NewsSearch_0001.xls");
		
		ProductAdvSearch_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\ProductAdvSearch_0001.xls");
		ProductAdvSearch_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\ProductAdvSearch_0002.xls");
		ProductAdvSearch_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\ProductAdvSearch_0003.xls");
		ProductAdvSearch_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\ProductAdvSearch_0004.xls");
		ProductAdvSearch_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\ProductAdvSearch_0005.xls");
		
		SuppAdvSearch_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0001.xls");
		SuppAdvSearch_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0002.xls");
		SuppAdvSearch_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0003.xls");
		SuppAdvSearch_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0004.xls");
		SuppAdvSearch_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0005.xls");
		SuppAdvSearch_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0006.xls");
		SuppAdvSearch_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0007.xls");
		SuppAdvSearch_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0008.xls");
		SuppAdvSearch_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0009.xls");
		SuppAdvSearch_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0010.xls");
		SuppAdvSearch_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0011.xls");
		SuppAdvSearch_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0012.xls");
		SuppAdvSearch_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0013.xls");
		SuppAdvSearch_0014_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0014.xls");
		SuppAdvSearch_0015_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\SuppAdvSearch_0015.xls");
		
		NewsAdvSearch_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\NewsAdvSearch_0001.xls");
		NewsAdvSearch_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\NewsAdvSearch_0002.xls");
		NewsAdvSearch_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\NewsAdvSearch_0003.xls");
		NewsAdvSearch_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\NewsAdvSearch_0004.xls");
		NewsAdvSearch_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\NewsAdvSearch_0005.xls");
		
		AdvanceSearch_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\AdvanceSearch_0001.xls");
		AdvanceSearch_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\AdvanceSearch_0002.xls");
		AdvanceSearch_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\AdvanceSearch_0003.xls");
		AdvanceSearch_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\AdvanceSearch_0004.xls");
		AdvanceSearch_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSearch\\AdvanceSearch_0005.xls");
		
		
		// ===================== Test Result for Module Bug =======================
		ProductionBug_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleBug\\ProductionBug_0001.xls");
		ProductionBug_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleBug\\ProductionBug_0002.xls");
		ProductionBug_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleBug\\ProductionBug_0003.xls");
		ProductionBug_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleBug\\ProductionBug_0004.xls");
		ProductionBug_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleBug\\ProductionBug_0005.xls");
		ProductionBug_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleBug\\ProductionBug_0006.xls");
		
		
		// ===================== Test Result for Module PP ========================
		ProductProfile_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0001.xls");
		ProductProfile_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0002.xls");
		ProductProfile_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0003.xls");
		ProductProfile_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0004.xls");
		ProductProfile_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0005.xls");
		ProductProfile_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0006.xls");
		ProductProfile_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0007.xls");
		ProductProfile_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0008.xls");
		ProductProfile_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0009.xls");
		ProductProfile_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0010.xls");
		ProductProfile_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0011.xls");
		ProductProfile_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0012.xls");
		ProductProfile_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0013.xls");
		ProductProfile_0014_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0014.xls");
		ProductProfile_0015_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0015.xls");
		ProductProfile_0016_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0016.xls");
		ProductProfile_0017_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0017.xls");
		ProductProfile_0018_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0018.xls");
		ProductProfile_0019_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0019.xls");
		ProductProfile_0020_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModulePP\\ProductProfile_0020.xls");
		
				
		// ===================== Test Result for Module SP ========================
		SupplierProfile_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0001.xls");
		SupplierProfile_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0002.xls");
		SupplierProfile_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0003.xls");
		SupplierProfile_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0004.xls");
		SupplierProfile_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0005.xls");
		SupplierProfile_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0006.xls");
		SupplierProfile_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0007.xls");
		SupplierProfile_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0008.xls");
		SupplierProfile_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0009.xls");
		SupplierProfile_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0010.xls");
		SupplierProfile_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0011.xls");
		SupplierProfile_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0012.xls");
		SupplierProfile_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0013.xls");
		SupplierProfile_0014_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0014.xls");		
		SupplierProfile_0015_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0015.xls");
		SupplierProfile_0016_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0016.xls");
		SupplierProfile_0017_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0017.xls");
		SupplierProfile_0018_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0018.xls");
		SupplierProfile_0019_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0019.xls");
		SupplierProfile_0020_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0020.xls");
		SupplierProfile_0021_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0021.xls");
		SupplierProfile_0022_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0022.xls");
		SupplierProfile_0023_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierProfile_0023.xls");
		
		SupplierAGG_0001_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0001.xls");
		SupplierAGG_0002_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0002.xls");
		SupplierAGG_0003_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0003.xls");
		SupplierAGG_0004_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0004.xls");
		SupplierAGG_0005_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0005.xls");
		SupplierAGG_0006_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0006.xls");
		SupplierAGG_0007_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0007.xls");
		SupplierAGG_0008_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0008.xls");
		SupplierAGG_0009_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0009.xls");
		SupplierAGG_0010_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0010.xls");
		SupplierAGG_0011_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0011.xls");
		SupplierAGG_0012_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0012.xls");
		SupplierAGG_0013_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0013.xls");
		SupplierAGG_0014_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0014.xls");
		SupplierAGG_0015_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0015.xls");
		SupplierAGG_0016_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0016.xls");
		SupplierAGG_0017_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0017.xls");
		SupplierAGG_0018_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0018.xls");
		SupplierAGG_0019_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0019.xls");
		SupplierAGG_0020_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0020.xls");
		SupplierAGG_0021_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0021.xls");
		SupplierAGG_0022_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0022.xls");
		SupplierAGG_0023_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0023.xls");
		SupplierAGG_0024_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0024.xls");
		SupplierAGG_0025_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0025.xls");
		SupplierAGG_0026_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0026.xls");
		SupplierAGG_0027_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0027.xls");
		SupplierAGG_0028_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0028.xls");
		SupplierAGG_0029_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0029.xls");
		SupplierAGG_0030_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0030.xls");
		SupplierAGG_0031_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0031.xls");
		SupplierAGG_0032_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0032.xls");
		SupplierAGG_0033_TestResult = new Read_XLS(System.getProperty("user.dir")+"\\TestResult\\ModuleSP\\SupplierAGG_0033.xls");
		
		
		
		// Bellow given syntax will Insert log In applog.log file.
		Add_Log.info("All Excel Files Initialised successfully.");
		
		// Initialize Param.properties file.
		Param = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"//UIMap//Param.properties");
		Param.load(fip);
		Add_Log.info("Param.properties file loaded successfully.");		
	
		// Initialize Objects.properties file.
		Object = new Properties();
		fip = new FileInputStream(System.getProperty("user.dir")+"//UIMap//Objects.properties");
		Object.load(fip);
		Add_Log.info("Objects.properties file loaded successfully.");
		
	}
	
	/**
	 * To load Web Browser.
	 * @return
	 * @throws Exception
	 */
	public static WebDriver loadWebBrowser() throws Exception{
		
		// Check If any previous webdriver browser Instance Is exist then run new test In that existing webdriver browser Instance.
		if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla") && ExistingmozillaBrowser!=null){
			driver = ExistingmozillaBrowser;
			return driver;
			
		}else if(Param.getProperty("testBrowser").equalsIgnoreCase("chrome") && ExistingchromeBrowser!=null){
			driver = ExistingchromeBrowser;
			return driver;
			
		}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE") && ExistingIEBrowser!=null){
			driver = ExistingIEBrowser;
			return driver;
		}		
		
		if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla")){
			
			// For Selenium 3.0.0 onward, Firefox driver is required.
		//	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//BrowserDrivers//geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"//BrowserDrivers//geckodriver.exe");
			
			// To Load Firefox driver Instance. 				
			// To solve SSL error. Create object of webdriver's inbuilt class ProfilesIni to access Its method getProfile.
			ProfilesIni firProfiles = new ProfilesIni();
			// Get access of newly created profile WebDriver_Profile.
			FirefoxProfile wbdrverprofile = firProfiles.getProfile("default");
			// Pass wbdrverprofile parameter to FirefoxDriver.
			driver = new FirefoxDriver(wbdrverprofile);		 	
				
			// driver = new FirefoxDriver();
			ExistingmozillaBrowser = driver;
			Add_Log.info("Firefox Driver Instance loaded successfully.");
			

			// To navigate to Global Sources URL. It will read site URL from Param.properties file
			driver.get(Param.getProperty("globalsourcesURL"));
			Add_Log.info("Global Sources Web application launched successfully.");
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			
		}else if(Param.getProperty("testBrowser").equalsIgnoreCase("Chrome")){
			
			// To Load Chrome driver Instance.
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
			driver = new ChromeDriver();
			ExistingchromeBrowser = driver;
			Add_Log.info("Chrome Driver Instance loaded successfully.");
			
			driver.get(Param.getProperty("globalsourcesURL"));
			Add_Log.info("Global Sources Web application launched successfully");
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
				
		}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE")){
			
			// To Load IE driver Instance.
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//BrowserDrivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			ExistingIEBrowser = driver;
			Add_Log.info("IE Driver Instance loaded successfully.");
			
			driver.get(Param.getProperty("globalsourcesURL"));
			Add_Log.info("Global Sources Web application launched successfully");
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
				
		}			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	//	Dimension ffSize = driver.manage().window().getSize();
	//	Add_Log.info("Firefox screen size are ::" + ffSize);
		return driver;
	}
	
	/**
	 * To close Web Browser.
	 */
	public void closeWebBrowser(){
	//	driver.close();
		driver.quit();
		// null browser Instance when close.
		ExistingchromeBrowser=null;
		ExistingmozillaBrowser=null;
		ExistingIEBrowser=null;
	}
	
	/**
	 * Go back to Home Page after each test case completed.
	 * Delete All the Cookies.
	 */
	public void goToGSOLHomePage(){
		driver.get(Param.getProperty("globalsourcesURL"));
		Add_Log.info("Go back to Global Sources Home Page");
	}
	
	/**
	 * Switch to new alert and click on 'OK' button.
	 */
	public void switchToAlert_ClickOnOKBtn(){
		
		// Get a handle to open alert, prompt for confirmation
		Alert alert = driver.switchTo().alert();
		
		// Get pop up window message
		String popupMessage = alert.getText();
		Add_Log.info("Pop up window message ::" + popupMessage);
		
		// Accept the alert = equivalent of pressing OK
		alert.accept();
	}
	
	/**
	 * Switch to new window opened.
	 */
	public void switchToNewWindowOpened(){
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			Add_Log.info("Switch to new window opened. Currently at page ::" + driver.getTitle());
		}
	}
	
	public void switchToNewWindowOpened_FilterProductsPage(){
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle).getTitle().equals("Filter Products");
			Add_Log.info(driver.switchTo().window(winHandle).getTitle());
		}
		Add_Log.info("Switch to new window opened. Currently at page ::" + driver.getTitle());
	}
	
	/**
	 * Switch back to parent window.
	 * @param parentHandle
	 */
	public void switchBackToParentWindow(String parentHandle){
		driver.close();
		driver.switchTo().window(parentHandle);
	}
	
	public void switchBackToParentWindow_InquiryBasketPage(String parentHandle){
		driver.switchTo().window(parentHandle).getTitle().equals("Global Sources - Inquiry Basket");
		Add_Log.info("Switch back to parent window. Currently at page ::" + driver.getTitle());
	}
	
	/**
	 * To verify popup window is closed.
	 * 
	 * @param xls
	 * @param sheetName
	 * @param rowNum
	 * @param testFail
	 * @return
	 * @throws Exception
	 */
	public static WebElement checkPopupWindowIsClosed(Read_XLS xls, String sheetName, int rowNum, 
			List<Boolean> testFail) throws Exception{
		try{
			if(isAlertPresent()){
				Add_Log.info("Failed. Alert is present.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_POPUP_WINDOW_IS_CLOSED, rowNum, Constant.KEYWORD_FAIL);
			}else{
				Add_Log.info("Passed. Alert is NOT present.");
				SuiteUtility.WriteResultUtility(
						xls, sheetName, Constant.COL_POPUP_WINDOW_IS_CLOSED, rowNum, Constant.KEYWORD_PASS);
			}
		}catch(Exception e){
			throw(e);
		}
		return element;
	}
	
	/**
	 * 
	 * @return true if JavaScript Alert is present on the page otherwise false.
	 */
	public static boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex){
			return false;
		}
	}
	
	/**
	 * To capture GSOL Home page screen shot after successfully Login.
	 */
	public void captureAfterLoginScreenShot(){
		
		String destDir = "Screenshots/GSOL_After_Login";
		String fileName = this.getClass().getSimpleName();
		
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) SuiteBase.driver).getScreenshotAs(OutputType.FILE);
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
    	
    	// To create folder to store screenshots
    	new File(destDir).mkdirs();
    	// Set file name with combination of test class name + date time.
    	String destFile = fileName + "_" + dateFormat.format(new Date()) + ".png";
    	
        try {
        	// Store file at destination folder location
     	   	FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch (IOException e) {
             e.printStackTrace();
        }
	}
	
	/**
	 * To capture GSOL products/suppliers page screen shot after perform search.
	 */
	public void captureHomePageScreenShot(){
		
		String destDir = "Screenshots/GSOL_Home_Page";
		String fileName = this.getClass().getSimpleName();
		
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) SuiteBase.driver).getScreenshotAs(OutputType.FILE);
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
    	
    	// To create folder to store screenshots
    	new File(destDir).mkdirs();
    	// Set file name with combination of test class name + date time.
    	String destFile = fileName + "_" + dateFormat.format(new Date()) + ".png";
    	
        try {
        	// Store file at destination folder location
     	   	FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch (IOException e) {
             e.printStackTrace();
        }
	}
	
	/**
	 * To capture RFI Inquiry Form page screen shot before Submit Inquiry.
	 */
	public void captureInquiryFormPageScreenShot(){
		
		String destDir = "Screenshots/RFI_InquiryForm_Page";
		String fileName = this.getClass().getSimpleName();
		
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) SuiteBase.driver).getScreenshotAs(OutputType.FILE);
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
    	
    	// To create folder to store screenshots
    	new File(destDir).mkdirs();
    	// Set file name with combination of test class name + date time.
    	String destFile = fileName + "_" + dateFormat.format(new Date()) + ".png";
    	
        try {
        	// Store file at destination folder location
     	   	FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch (IOException e) {
             e.printStackTrace();
        }
	}
	
	/**
	 * To capture RFI Confirmation page screen shot.
	 */
	public void captureRFIConfirmationPageScreenShot11(){
		
		String destDir = "Screenshots/RFI_Confirmation_Page";
		String fileName = this.getClass().getSimpleName();
		
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) SuiteBase.driver).getScreenshotAs(OutputType.FILE);
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
    	
    	// To create folder to store screenshots
    	new File(destDir).mkdirs();
    	// Set file name with combination of test class name + date time.
    	String destFile = fileName + "_" + dateFormat.format(new Date()) + ".png";
    	
        try {
        	// Store file at destination folder location
     	   	FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch (IOException e) {
             e.printStackTrace();
        }
	}	
	
	/**
	 * To capture Inquiry Basket page screen shot.
	 */
	public void captureInquiryBasketPageScreenShot(){
		
		String destDir = "Screenshots/Inquiry_Basket_Page";
		String fileName = this.getClass().getSimpleName();
		
		// To capture screenshot.
		File scrFile = ((TakesScreenshot) SuiteBase.driver).getScreenshotAs(OutputType.FILE);
    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
    	
    	// To create folder to store screenshots
    	new File(destDir).mkdirs();
    	// Set file name with combination of test class name + date time.
    	String destFile = fileName + "_" + dateFormat.format(new Date()) + ".png";
    	
        try {
        	// Store file at destination folder location
     	   	FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch (IOException e) {
             e.printStackTrace();
        }
	}

	/**
	 * To copy Excel output file to backup directory.
	 */
	public void copyExcelOutputFileToDestDir(){
		
		String destDir = "TestResult/BackupFile_ExcelOutput";
		String fileName = this.getClass().getSimpleName();
		
		File srcFileRFI = new File ("TestResult/ModuleRFI/"+ fileName +".xls");		// Module RFI
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
		
		// To create folder to store screenshots
		new File(destDir).mkdirs();
		String destFile = fileName + "_" + dateFormat.format(new Date()) + ".xls";
		
		try {
			// Store file at destination folder location
			FileUtils.copyFile(srcFileRFI, new File(destDir + "/" + destFile));

		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * To copy applog file to backup directory.
	 */
	public void copyApplogFileToDestDir(){
		
		String destDir = "TestLog/BackupFile_Applog";
		String fileName = "applog";
		
		File srcFile = new File ("src/applog.log");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
		
		// To create folder to store applog.log
		new File(destDir).mkdirs();
		String destFile = fileName + "_" + dateFormat.format(new Date()) + ".log";
		
		try {
			// Store file at destination folder location
			FileUtils.copyFile(srcFile, new File(destDir + "/" + destFile));
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * To copy TestNG Report folder to backup directory.
	 */
	public void copyTestngReportFileToDestDir(){
		
		String destDir = "TestLog/BackupFile_TestngReport";
		String fileName = "test-output";
		
		File srcFile = new File ("test-output");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
		
		// To create folder to store TestNG report
		new File(destDir).mkdirs();
		String destFile = fileName + "_" + dateFormat.format(new Date());
		
		try {
			// Store file at destination folder location
			FileUtils.copyDirectory(srcFile, new File(destDir + "/" + destFile));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To copy TestData folder to backup directory.
	 */
	public void copyTestDataFolderToDestDir(){
		
		String destDir = "TestLog/BackupFile_TestData";
		String fileName = "TestData";
		
		File srcFile = new File ("TestData");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
		
		// To create folder to store TestNG report
		new File(destDir).mkdirs();
		String destFile = fileName + "_" + dateFormat.format(new Date());
		
		try {
			// Store file at destination folder location
			FileUtils.copyDirectory(srcFile, new File(destDir + "/" + destFile));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To copy TestResult folder to backup directory.
	 */
	public void copyTestResultFolderToDestDir(){
		
		String destDir = "TestLog/BackupFile_TestResult";
		String fileName = "TestResult";
		
		File srcFile = new File ("TestResult");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmssaa");
		
		// To create folder to store TestNG report
		new File(destDir).mkdirs();
		String destFile = fileName + "_" + dateFormat.format(new Date());
		
		try {
			// Store file at destination folder location
			FileUtils.copyDirectory(srcFile, new File(destDir + "/" + destFile));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
