/**
 * 
 */
package com.suman.rnd.CommonTestService.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author samasu5
 *
 */
@Entity
@Table (name="VSIB_MILESTONE_ATTRIBUTES")
public class MilestoneAttributesDataModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -636792232302784802L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attributes_seq")
	@SequenceGenerator(name = "attributes_seq", sequenceName = "VSIB_MILESTONE_ATTRIB_SEQ", allocationSize=1)
	@Column (name = "MILESTONE_ATTRIBUTE_ID")
	private Long milestoneAttribId;

	@Size(max = 256)
	@Column (name = "ATTRIBUTE_NAME")
	private String name;
	
	@Size(max = 4000)
	@Column (name = "ATTRIBUTE_VALUE")
	private String value;
	
	@Size(max = 32)
	@Column (name = "MAJOR_MILESTONE")
	private String majorMilestone;
	
	@Size(max = 32)
	@Column (name = "MINOR_MILESTONE")
	private String minorMilestone;
	
	@Size(max = 32)
	@Column (name = "ORDER_ID")
	private String orderId;
	
	@Size(max = 32)
	@Column (name = "SERVICE_ORDER_ID")
	private String serviceOrderId;
	
	@Column (name = "DATE_CREATED")
	private Date dateCreated;

	/**
	 * @return the milestoneAttribId
	 */
	public Long getMilestoneAttribId() {
		return milestoneAttribId;
	}

	/**
	 * @param milestoneAttribId the milestoneAttribId to set
	 */
	public void setMilestoneAttribId(Long milestoneAttribId) {
		this.milestoneAttribId = milestoneAttribId;
	}

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

	/**
	 * @return the majorMilestone
	 */
	public String getMajorMilestone() {
		return majorMilestone;
	}

	/**
	 * @param majorMilestone the majorMilestone to set
	 */
	public void setMajorMilestone(String majorMilestone) {
		this.majorMilestone = majorMilestone;
	}

	/**
	 * @return the minorMilestone
	 */
	public String getMinorMilestone() {
		return minorMilestone;
	}

	/**
	 * @param minorMilestone the minorMilestone to set
	 */
	public void setMinorMilestone(String minorMilestone) {
		this.minorMilestone = minorMilestone;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	
	/**
	 * @return the serviceOrderId
	 */
	public String getServiceOrderId() {
		return serviceOrderId;
	}

	/**
	 * @param serviceOrderId the serviceOrderId to set
	 */
	public void setServiceOrderId(String serviceOrderId) {
		this.serviceOrderId = serviceOrderId;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MilestoneAttributesDataModel [milestoneAttribId=" + milestoneAttribId + ", name=" + name + ", value="
				+ value + ", majorMilestone=" + majorMilestone + ", minorMilestone=" + minorMilestone + ", orderId="
				+ orderId + ", serviceOrderId=" + serviceOrderId + ", dateCreated=" + dateCreated + "]";
	}
	
}
