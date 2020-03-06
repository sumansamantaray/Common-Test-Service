/**
 * 
 */
package com.suman.rnd.CommonTestService.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * @author samasu5
 *
 */
@Component
public class ExcelToCsvConverter {

//	static private Pattern rxquote = Pattern.compile("\"");
	
	public File convertToCsv(String fileName, int numberOfColumns) {
		
		/*try {
			//First we read the Excel file in binary format into FileInputStream
	        FileInputStream input_document = new FileInputStream(fileName);
	        // Read workbook into HSSFWorkbook
	        XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document); 
	        // Read worksheet into HSSFSheet
	        XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
	        // To iterate over the rows
	        Iterator<Row> rowIterator = my_worksheet.iterator();
	        // OpenCSV writer object to create CSV file
	        FileWriter my_csv=new FileWriter("./src/main/resources/convertedCSVFile.csv");
	        CSVWriter my_csv_output=new CSVWriter(my_csv); 
	        //Loop through rows.
	        while(rowIterator.hasNext()) {
	                Row row = rowIterator.next(); 
	                int i=0;//String array
	                //change this depending on the length of your sheet
	                String[] csvdata = new String[numberOfColumns];
	                Iterator<Cell> cellIterator = row.cellIterator();
	                        while(cellIterator.hasNext()) {
	                                Cell cell = cellIterator.next(); //Fetch CELL
	                                switch(cell.getCellType()) { //Identify CELL type
	                                        //you need to add more code here based on
	                                        //your requirement / transformations
	                                case STRING:
	                                        csvdata[i]= cell.getStringCellValue();                                              
	                                        break;
	                                }
	                                i=i+1;
	                        }
	        my_csv_output.writeNext(csvdata);
	        }
	        my_csv_output.close(); //close the CSV file
	        //we created our file..!!
	        input_document.close(); //close xls
		} catch (Exception exp) {
			exp.printStackTrace();
		}*/
		
		
		
		
		try {
			Workbook wb = new XSSFWorkbook(new File(fileName));
//			int sheetNo = Integer.parseInt(args[index++]);
			FormulaEvaluator fe = null;
			/*if ( index < args.length ) {
			    fe = wb.getCreationHelper().createFormulaEvaluator();
			}*/
			DataFormatter formatter = new DataFormatter();
			PrintStream out = new PrintStream(new FileOutputStream("./src/main/resources/convertedCSVFile2.csv"),
			                                  true, "UTF-8");
			byte[] bom = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
			out.write(bom);
			{
			    Sheet sheet = wb.getSheetAt(0);
			    for (int r = 0, rn = sheet.getLastRowNum() ; r <= rn ; r++) {
			        Row row = sheet.getRow(r);
			        if ( row == null ) { out.println(','); continue; }
			        boolean firstCell = true;
			        for (int c = 0, cn = row.getLastCellNum() ; c < cn ; c++) {
			            Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			            if ( ! firstCell ) out.print(',');
			            if ( cell != null ) {
			                if ( fe != null ) cell = fe.evaluateInCell(cell);
			                String value = formatter.formatCellValue(cell);
			                if ( cell.getCellTypeEnum() == CellType.FORMULA ) {
			                    value = "=" + value;
			                }
			                out.print(encodeValue(value));
			            }
			            firstCell = false;
			        }
			        out.println();
			    }
			}
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return getFile();
	}
	
	static private String encodeValue(String value) {
	    boolean needQuotes = false;
	    Pattern rxquote = Pattern.compile("\"");
	    if ( value.indexOf(',') != -1 || value.indexOf('"') != -1 ||
	         value.indexOf('\n') != -1 || value.indexOf('\r') != -1 )
	        needQuotes = true;
	    Matcher m = rxquote.matcher(value);
	    if ( m.find() ) needQuotes = true; value = m.replaceAll("\"\"");
	    if ( needQuotes ) return "\"" + value + "\"";
	    else return value;
	}
	
	private File getFile() {
		File file = null;
		try {
			file = new File("./src/main/resources/convertedCSVFile2.csv");
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		return file; 
	}
}
