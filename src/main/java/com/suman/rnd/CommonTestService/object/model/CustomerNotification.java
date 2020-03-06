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
public class CustomerNotification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7047251436520580832L;

	private String milestoneStatus;
	
	private String milestoneCompletionDate;
	
	private MinorMilestoneDetails minorMilestoneDetails;
	

	/**
	 * @return the milestoneStatus
	 */
	public String getMilestoneStatus() {
		return milestoneStatus;
	}

	/**
	 * @param milestoneStatus the milestoneStatus to set
	 */
	public void setMilestoneStatus(String milestoneStatus) {
		this.milestoneStatus = milestoneStatus;
	}

	/**
	 * @return the milestoneCompletionDate
	 */
	public String getMilestoneCompletionDate() {
		return milestoneCompletionDate;
	}

	/**
	 * @param milestoneCompletionDate the milestoneCompletionDate to set
	 */
	public void setMilestoneCompletionDate(String milestoneCompletionDate) {
		this.milestoneCompletionDate = milestoneCompletionDate;
	}

	/**
	 * @return the minorMilestoneDetails
	 */
	public MinorMilestoneDetails getMinorMilestoneDetails() {
		return minorMilestoneDetails;
	}

	/**
	 * @param minorMilestoneDetails the minorMilestoneDetails to set
	 */
	public void setMinorMilestoneDetails(MinorMilestoneDetails minorMilestoneDetails) {
		this.minorMilestoneDetails = minorMilestoneDetails;
	}
}
