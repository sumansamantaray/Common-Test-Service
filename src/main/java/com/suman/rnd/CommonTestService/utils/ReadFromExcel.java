package com.suman.rnd.CommonTestService.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monitorjbl.xlsx.StreamingReader;
import com.suman.rnd.CommonTestService.db.model.MessageMappingDataModel;
import com.suman.rnd.CommonTestService.repository.MessageMappingRepository;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
@Component
public class ReadFromExcel {
	
	@Autowired
	private MessageMappingRepository messageMappingRepository;

	public static Sheet datatypeSheet;
	static {
		try {
			FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\samasu5\\Documents\\Project-Doc\\CX\\Release_4\\CRs\\CX Notifications - modified list 7312019v2.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            datatypeSheet = workbook.getSheetAt(1);
            workbook.close();
            
            /**
             * Commented this approach. Need to test this if the file size is in MB
             * 
             * InputStream is = new FileInputStream(new File("/path/to/workbook.xlsx"));
            	Workbook workbook1 = StreamingReader.builder()
                    .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                    .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                    .open(is);            // InputStream or File for XLSX file (required)
             */
            
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	
	
	public void readFromFile() {
		
		Iterator<Row> rowIterator = ReadFromExcel.datatypeSheet.iterator();
		String jeopardyDesc = "";
		int errorCode = 0;
		int countRow = 0;
		
		
        while (rowIterator.hasNext()) {
        	if (countRow == 0) {
        		countRow++;
        		Row currentRow = rowIterator.next();
        		continue;
        	}
        	System.out.println("\n");
        	int countCell = 0;
        	Row currentRow = rowIterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            MessageMappingDataModel messageMappingDataModel = new MessageMappingDataModel();

            while (cellIterator.hasNext()) {
            	if (countCell == 2 || countCell == 3 || countCell == 5) {
            		Cell currentCell = cellIterator.next();
//                  cellIterator.next();
            		if (countCell == 2) {
            			errorCode = (int)currentCell.getNumericCellValue();
            			System.out.print(errorCode);
            			messageMappingDataModel.setErrorCode(String.valueOf(errorCode) == null ? String.valueOf(errorCode) : String.valueOf(errorCode).trim());
            		} else if (countCell == 3) {
            			String sourceMessage = currentCell.getStringCellValue();
            			System.out.print(sourceMessage);
            			messageMappingDataModel.setSourceMessage(sourceMessage == null ? sourceMessage : sourceMessage.trim());
            		} else if (countCell == 5) {
            			String cxMessage = currentCell.getStringCellValue();
            			System.out.print(jeopardyDesc);
            			messageMappingDataModel.setCxMessage(cxMessage == null ? cxMessage : cxMessage.trim());
            			messageMappingRepository.save(messageMappingDataModel);
            		} 
            		
            		
            	} else {
            		Cell currentCell = cellIterator.next();
            	}
            	countCell++;
                
            }
        }
		
	}


}
