/**
 * 
 */
package com.suman.rnd.CommonTestService.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.suman.rnd.CommonTestService.utils.ExcelToCsvConverter;

/**
 * @author samasu5
 *
 */
@Controller
public class ExcelToCsvConverterController {
	
	@Autowired
	ExcelToCsvConverter excelToCsvConverter;

	@PostMapping(path = "tocsv")
	public ResponseEntity<?> convertToCsv(@RequestParam("file") MultipartFile file, @RequestParam(value = "columns") int numberOfColumns) throws FileNotFoundException {
		
		Path filepath = Paths.get("./src/main/resources/", file.getOriginalFilename());

	    try (OutputStream os = Files.newOutputStream(filepath)) {
	        os.write(file.getBytes());
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    File convertedFile = excelToCsvConverter.convertToCsv(filepath.toString(), numberOfColumns);
	    
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(convertedFile));
//		return ResponseEntity.ok().body("{\"success\":1}");
	    return ResponseEntity.ok()
	            .contentLength(convertedFile.length())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
/*//                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body("");*/
	}
}
