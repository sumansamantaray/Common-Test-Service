/**
 * 
 */
package com.suman.rnd.CommonTestService.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author samasu5
 *
 */
@Component
public class ReadFile {
	
	static String fileContent = "";
	
public static String readFromTxtFile() {
		
		
		if (!StringUtils.isEmpty(fileContent)) {
			return fileContent;
		}
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("./src/main/resources/milestone_accepted.txt"));
			fileContent = new String(encoded, StandardCharsets.UTF_8);
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return fileContent;
	}

}
