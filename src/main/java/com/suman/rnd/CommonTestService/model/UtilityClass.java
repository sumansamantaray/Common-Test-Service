/**
 * 
 */
package com.suman.rnd.CommonTestService.model;

/**
 * @author samasu5
 *
 */
public class UtilityClass {

	static String returnString;
	public static String getSomeString(String printString) {
		if (returnString == null) {
			returnString = printString;
		}
		System.out.println("The String is: "+returnString);
		return returnString;
	}
}
