/**
 * Functions related to read data from .xls files will be will be created In this class.
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

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

/**
 * This class contains all methods to read data from .xls files
 * @author Teng Shyh Wei
 *
 */
public class Read_XLS {
	
	public String fileLocation;
	public FileInputStream ipstr = null;
	public FileOutputStream opstr = null;
	private HSSFWorkbook wb = null;
	private HSSFSheet ws = null;	
	
	/**
	 * To retrieve file location of .xls file
	 * 
	 * @param fileLocation  the file's path of this .xls file
	 */
	public Read_XLS(String fileLocation) {		
		this.fileLocation = fileLocation;
		try {
			ipstr = new FileInputStream(fileLocation);
			wb = new HSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			ipstr.close();
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * To retrieve No Of Rows from .xls file's sheets.
	 * 
	 * @param wsName  	the worksheet name of this .xls file
	 * @return			no of rows from worksheet of .xls file
	 */
	public int retrieveNoOfRows(String wsName){		
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex == -1)
			return 0;
		else{
			ws = wb.getSheetAt(sheetIndex);
			int rowCount = ws.getLastRowNum()+1;		
			return rowCount;		
		}
	}
	
	/**
	 * To retrieve No Of Columns from .xls file's sheets.
	 * 
	 * @param wsName  	the worksheet name of this .xls file
	 * @return			no of columns from worksheet of .xls file
	 */
	public int retrieveNoOfCols(String wsName){
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex == -1)
			return 0;
		else{
			ws = wb.getSheetAt(sheetIndex);
			int colCount = ws.getRow(0).getLastCellNum();			
			return colCount;
		}
	}
	
	/**
	 * To retrieve SuiteToRun and CaseToRun flag of test suite and test case.
	 * 
	 * @param wsName	the worksheet name of this .xls file
	 * @param colName	the column name or this .xls file
	 * @param rowName	the row name of this .xls file
	 * @return
	 */
	public String retrieveToRunFlag(String wsName, String colName, String rowName){
		
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex == -1)
			return null;
		else{
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);
			int colNumber = -1;
			int rowNumber = -1;			
			
			HSSFRow Suiterow = ws.getRow(0);				
			
			for(int i=0; i<colNum; i++){
				if(Suiterow.getCell(i).getStringCellValue().equals(colName.trim())){
					colNumber = i;					
				}					
			}
			
			if(colNumber == -1){
				return "";				
			}
						
			for(int j=0; j<rowNum; j++){
				HSSFRow Suitecol = ws.getRow(j);				
				if(Suitecol.getCell(0).getStringCellValue().equals(rowName.trim())){
					rowNumber = j;	
				}					
			}
			
			if(rowNumber == -1){
				return "";				
			}
			
			HSSFRow row = ws.getRow(rowNumber);
			HSSFCell cell = row.getCell(colNumber);
			if(cell == null){
				return "";
			}
			String value = cellToString(cell);
			return value;			
		}			
	}
	
	/**
	 * This function will read "DataToRun" flag from different test cases data sheets.
	 * 
	 * @param wsName	the worksheet name of this .xls file
	 * @param colName	the column name of this .xls file
	 * @return
	 */
	public String[] retrieveToRunFlagTestData(String wsName, String colName){
		
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex == -1)
			return null;
		else{
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);
			int colNumber = -1;					
			
			HSSFRow Suiterow = ws.getRow(0);				
			String data[] = new String[rowNum-1];
			for(int i=0; i<colNum; i++){
				if(Suiterow.getCell(i).getStringCellValue().equals(colName.trim())){
					colNumber = i;					
				}					
			}
			
			if(colNumber == -1){
				return null;				
			}
			
			for(int j=0; j<rowNum-1; j++){
				HSSFRow Row = ws.getRow(j+1);
				if(Row == null){
					data[j] = "";
				}
				else{
					HSSFCell cell = Row.getCell(colNumber);
					if(cell == null){
						data[j] = "";
					}
					else{
						String value = cellToString(cell);
						data[j] = value;	
					}	
				}
			}
			
			return data;			
		}			
	}
	
	/**
	 * This function will read Test Data from different test cases data sheets.
	 * 
	 * @param wsName	the worksheet name of this .xls file
	 * @return
	 */
	public Object[][] retrieveTestData(String wsName){
		int sheetIndex = wb.getSheetIndex(wsName);
		if(sheetIndex == -1)
			return null;
		else{
			
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);
		
			Object data[][] = new Object[rowNum-1][colNum-2];
		
			for (int i=0; i<rowNum-1; i++){
				HSSFRow row = ws.getRow(i+1);
				for(int j=0; j< colNum-2; j++){					
					if(row == null){
						data[i][j] = "";
					}
					else{
						HSSFCell cell = row.getCell(j);	
					
						if(cell == null){
							data[i][j] = "";							
						}
						else{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String value = cellToString(cell);
							data[i][j] = value;						
						}
					}
				}				
			}	
				
			return data;		
		}
	}		
	
	/**
	 * 
	 * 
	 * @param cell	the excel cell of this .xls file
	 * @return
	 */
	public static String cellToString(HSSFCell cell){
		int type;
		Object result;
		type = cell.getCellType();			
		switch (type){
			case 0 :
				result = cell.getNumericCellValue();
				break;
				
			case 1 : 
				result = cell.getStringCellValue();
				break;
				
			default :
				throw new RuntimeException("Unsupportd cell.");			
		}
		return result.toString();
	}
	
	/**
	 * To write result In test data and test case list sheet.
	 * This function will write Pass/Fail/Skip results In "TestCasesList" sheets and test cases data sheets
	 * 
	 * @param wsName	the worksheet name of this .xls file
	 * @param colName	the column name if this .xls file
	 * @param rowNumber	the row number of this .xls file
	 * @param Result
	 * @return
	 */
	public boolean writeResult(String wsName, String colName, int rowNumber, String Result){
		try{
			int sheetIndex = wb.getSheetIndex(wsName);
			if(sheetIndex == -1)
				return false;			
			int colNum = retrieveNoOfCols(wsName);
			int colNumber = -1;
					
			
			HSSFRow Suiterow = ws.getRow(0);			
			for(int i=0; i<colNum; i++){				
				if(Suiterow.getCell(i).getStringCellValue().equals(colName.trim())){
					colNumber = i;					
				}					
			}
			
			if(colNumber==-1){
				return false;				
			}
			
			HSSFRow Row = ws.getRow(rowNumber);
			HSSFCell cell = Row.getCell(colNumber);
			if(cell == null)
		        cell = Row.createCell(colNumber);			
			
			cell.setCellValue(Result);
			
			HSSFCellStyle style = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			
			// If test result equal to 'Pass' or 'Passed', set GREEN font color
			if(Result.equalsIgnoreCase("Passed") || Result.equalsIgnoreCase("Pass") || Result.equalsIgnoreCase("Executed"))
			{
			    font.setColor(HSSFColor.GREEN.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}
			// If test result equal to 'Fail' or 'Failed', set RED font color
			else if(Result.equalsIgnoreCase("Failed") || Result.equalsIgnoreCase("Fail"))
			{
			    font.setColor(HSSFColor.RED.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}
			// If test result equal to 'Skip; or 'Skipped', set ORANGE font color
			else if(Result.equalsIgnoreCase("Skipped") || Result.equalsIgnoreCase("Skip"))
			{
			    font.setColor(HSSFColor.ORANGE.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}			
			else
			{
			    font.setColor(HSSFColor.BLACK.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}
			
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
		    cell.setCellStyle(style);
						
			opstr = new FileOutputStream(fileLocation);
			wb.write(opstr);
			opstr.close();
						
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * To write result In test suite list sheet.
	 * This function will write execution status Skipped/Executed In "SuitesList" sheet.
	 * 
	 * @param wsName	the worksheet name of this .xls file
	 * @param colName	the column name of this .xls file
	 * @param rowName	the row name of this .xls file
	 * @param Result
	 * @return
	 */
	public boolean writeResult(String wsName, String colName, String rowName, String Result){
		try{
			int rowNum = retrieveNoOfRows(wsName);
			int rowNumber = -1;
			int sheetIndex = wb.getSheetIndex(wsName);
			if(sheetIndex == -1)
				return false;			
			int colNum = retrieveNoOfCols(wsName);
			int colNumber = -1;
								
			HSSFRow Suiterow = ws.getRow(0);			
			for(int i=0; i<colNum; i++){				
				if(Suiterow.getCell(i).getStringCellValue().equals(colName.trim())){
					colNumber=i;					
				}					
			}
			
			if(colNumber==-1){
				return false;				
			}
			
			for (int i=0; i<rowNum-1; i++){
				HSSFRow row = ws.getRow(i+1);				
				HSSFCell cell = row.getCell(0);	
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String value = cellToString(cell);	
				if(value.equals(rowName)){
					rowNumber = i+1;
					break;
				}
			}		
			
			HSSFRow Row = ws.getRow(rowNumber);
			HSSFCell cell = Row.getCell(colNumber);
			if(cell == null)
		        cell = Row.createCell(colNumber);			
			
			cell.setCellValue(Result);
			
			HSSFCellStyle style = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			
			// If test result equal to 'Pass' or 'Passed', set GREEN font color
			if(Result.equalsIgnoreCase("Passed") || Result.equalsIgnoreCase("Pass") || Result.equalsIgnoreCase("Executed"))
			{
			    font.setColor(HSSFColor.GREEN.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}
			// If test result equal to 'Fail' or 'Failed', set RED font color
			else if(Result.equalsIgnoreCase("Failed") || Result.equalsIgnoreCase("Fail"))
			{
			    font.setColor(HSSFColor.RED.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}
			// If test result equal to 'Skip; or 'Skipped', set ORANGE font color
			else if(Result.equalsIgnoreCase("Skipped") || Result.equalsIgnoreCase("Skip"))
			{
			    font.setColor(HSSFColor.ORANGE.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}			
			else
			{
			    font.setColor(HSSFColor.BLACK.index);
			    //font.setBoldweight(Font.BOLDWEIGHT_BOLD);

			}
			
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
		    cell.setCellStyle(style);
		    
			opstr = new FileOutputStream(fileLocation);
			wb.write(opstr);
			opstr.close();			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
