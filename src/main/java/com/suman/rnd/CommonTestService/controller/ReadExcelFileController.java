/**
 * 
 */
package com.suman.rnd.CommonTestService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suman.rnd.CommonTestService.utils.ReadFromExcel;

/**
 * @author samasu5
 *
 */
@RestController
public class ReadExcelFileController {
	
	@Autowired
	ReadFromExcel readFromExcel;
	
	@GetMapping(path = "loadfiledatatodb")
	public void loadExcelFileDataToDb() {
		readFromExcel.readFromFile();
	}

}
