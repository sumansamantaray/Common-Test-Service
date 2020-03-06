/**
 * 
 */
package com.suman.rnd.CommonTestService.object.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author samasu5
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MilestoneAttributes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5347748715183728384L;

	private String name;
	
	private String value;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
