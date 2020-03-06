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
public class MilestoneMinorObjectModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1651572190313035215L;

	private String milestoneLabel;
    
	private int version;
    
	private String minorMilestoneStatus;
    
	private String parentBucket;
    
	private String milestoneDate;
    
	private String dateCreated;
	
	private String Remarks;
	
	private CustomerNotification customerNotification;


	/**
	 * @return the milestoneLabel
	 */
	public String getMilestoneLabel() {
		return milestoneLabel;
	}

	/**
	 * @param milestoneLabel the milestoneLabel to set
	 */
	public void setMilestoneLabel(String milestoneLabel) {
		this.milestoneLabel = milestoneLabel;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the minorMilestoneStatus
	 */
	public String getMinorMilestoneStatus() {
		return minorMilestoneStatus;
	}

	/**
	 * @param minorMilestoneStatus the minorMilestoneStatus to set
	 */
	public void setMinorMilestoneStatus(String minorMilestoneStatus) {
		this.minorMilestoneStatus = minorMilestoneStatus;
	}

	/**
	 * @return the parentBucket
	 */
	public String getParentBucket() {
		return parentBucket;
	}

	/**
	 * @param parentBucket the parentBucket to set
	 */
	public void setParentBucket(String parentBucket) {
		this.parentBucket = parentBucket;
	}

	/**
	 * @return the milestoneDate
	 */
	public String getMilestoneDate() {
		return milestoneDate;
	}

	/**
	 * @param milestoneDate the milestoneDate to set
	 */
	public void setMilestoneDate(String milestoneDate) {
		this.milestoneDate = milestoneDate;
	}

	/**
	 * @return the dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return Remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	/**
	 * @return the customerNotification
	 */
	public CustomerNotification getCustomerNotification() {
		return customerNotification;
	}

	/**
	 * @param customerNotification the customerNotification to set
	 */
	public void setCustomerNotification(CustomerNotification customerNotification) {
		this.customerNotification = customerNotification;
	}

}
