/**
 * 
 */
package com.suman.rnd.CommonTestService.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author samasu5
 *
 */
@Entity
@Table (name="VSIB_ORDER_MILESTONE_VLAN")
public class MilestoneVlanDataModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5002548808507899270L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vlan_milestone_seq")
	@SequenceGenerator(name = "vlan_milestone_seq", sequenceName = "VSIB_MILESTONE_VLAN_SEQ", allocationSize=1)
	@Column (name = "MILESTONE_VLAN_ID")
	private long milestoneVlanId;
	
	@Size(max = 32)
    @Column(name = "VLAN_START")
	private String vlanStart;
	
	@Size(max = 32)
    @Column(name = "VLAN_END")
	private String vlanEnd;
	
    @Column(name = "DATE_CREATED")
	private Date dateCreated;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MILESTONE_CIRCUIT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MilestoneCircuitsDataModel milestoneCctDataModel;

	/**
	 * @return the milestoneVlanId
	 */
	public long getMilestoneVlanId() {
		return milestoneVlanId;
	}

	/**
	 * @param milestoneVlanId the milestoneVlanId to set
	 */
	public void setMilestoneVlanId(long milestoneVlanId) {
		this.milestoneVlanId = milestoneVlanId;
	}

	/**
	 * @return the vlanStart
	 */
	public String getVlanStart() {
		return vlanStart;
	}

	/**
	 * @param vlanStart the vlanStart to set
	 */
	public void setVlanStart(String vlanStart) {
		this.vlanStart = vlanStart;
	}

	/**
	 * @return the vlanEnd
	 */
	public String getVlanEnd() {
		return vlanEnd;
	}

	/**
	 * @param vlanEnd the vlanEnd to set
	 */
	public void setVlanEnd(String vlanEnd) {
		this.vlanEnd = vlanEnd;
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

	/**
	 * @return the milestoneCctDataModel
	 */
	public MilestoneCircuitsDataModel getMilestoneCctDataModel() {
		return milestoneCctDataModel;
	}

	/**
	 * @param milestoneCctDataModel the milestoneCctDataModel to set
	 */
	public void setMilestoneCctDataModel(MilestoneCircuitsDataModel milestoneCctDataModel) {
		this.milestoneCctDataModel = milestoneCctDataModel;
	}
    
}
