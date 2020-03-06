/**
 * 
 */
package com.suman.rnd.CommonTestService.object.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author samasu5
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinorMilestoneDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2658799418638521043L;
	private List<List<MilestoneAttributes>> milestoneAttributes = new ArrayList<>();
	/**
	 * @return the milestoneAttributes
	 */
	public List<List<MilestoneAttributes>> getMilestoneAttributes() {
		return milestoneAttributes;
	}
	/**
	 * @param milestoneAttributes the milestoneAttributes to set
	 */
	public void setMilestoneAttributes(List<List<MilestoneAttributes>> milestoneAttributes) {
		this.milestoneAttributes = milestoneAttributes;
	}

	
}
