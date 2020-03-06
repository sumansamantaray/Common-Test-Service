/**
 * 
 */
package com.suman.rnd.CommonTestService.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table (name="VSIB_MILESTONE_CIRCUITS")
public class MilestoneCircuitsDataModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8248544024891714320L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cct_milestone_seq")
	@SequenceGenerator(name = "cct_milestone_seq", sequenceName = "VSIB_MILESTONE_CIRCUIT_SEQ", allocationSize=1)
	@Column (name = "MILESTONE_CIRCUIT_ID")
	private long milestoneCircuitId;
	
    @Size(max = 8)
    @Column(name = "TYPE")
	private String circuitType;
    
    @Size(max = 32)
    @Column(name = "CIRCUIT_ID")
	private String circuitId;
    
    @Size(max = 32)
    @Column(name = "CUST_CIRCUIT_ID")
	private String customerCctId;
    
    @Size(max = 32)
    @Column(name = "SERVICE_ORDER")
	private String cctServiceOrder;
    
    @Column(name = "DATE_CREATED")
	private Date dateCreated;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel cctMilestoneMinorDataModel;
    
    @OneToMany(mappedBy="milestoneCctDataModel")
    private List<MilestoneVlanDataModel> vlanDataModelList;

	/**
	 * @return the milestoneCircuitId
	 */
	public long getMilestoneCircuitId() {
		return milestoneCircuitId;
	}

	/**
	 * @param milestoneCircuitId the milestoneCircuitId to set
	 */
	public void setMilestoneCircuitId(long milestoneCircuitId) {
		this.milestoneCircuitId = milestoneCircuitId;
	}

	/**
	 * @return the circuitType
	 */
	public String getCircuitType() {
		return circuitType;
	}

	/**
	 * @param circuitType the circuitType to set
	 */
	public void setCircuitType(String circuitType) {
		this.circuitType = circuitType;
	}

	/**
	 * @return the circuitId
	 */
	public String getCircuitId() {
		return circuitId;
	}

	/**
	 * @param circuitId the circuitId to set
	 */
	public void setCircuitId(String circuitId) {
		this.circuitId = circuitId;
	}

	/**
	 * @return the customerCctId
	 */
	public String getCustomerCctId() {
		return customerCctId;
	}

	/**
	 * @param customerCctId the customerCctId to set
	 */
	public void setCustomerCctId(String customerCctId) {
		this.customerCctId = customerCctId;
	}

	/**
	 * @return the cctServiceOrder
	 */
	public String getCctServiceOrder() {
		return cctServiceOrder;
	}

	/**
	 * @param cctServiceOrder the cctServiceOrder to set
	 */
	public void setCctServiceOrder(String cctServiceOrder) {
		this.cctServiceOrder = cctServiceOrder;
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
	 * @return the cctMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getCctMilestoneMinorDataModel() {
		return cctMilestoneMinorDataModel;
	}

	/**
	 * @param cctMilestoneMinorDataModel the cctMilestoneMinorDataModel to set
	 */
	public void setCctMilestoneMinorDataModel(MilestoneMinorDataModel cctMilestoneMinorDataModel) {
		this.cctMilestoneMinorDataModel = cctMilestoneMinorDataModel;
	}

	/**
	 * @return the vlanDataModelList
	 */
	public List<MilestoneVlanDataModel> getVlanDataModelList() {
		return vlanDataModelList;
	}

	/**
	 * @param vlanDataModelList the vlanDataModelList to set
	 */
	public void setVlanDataModelList(List<MilestoneVlanDataModel> vlanDataModelList) {
		this.vlanDataModelList = vlanDataModelList;
	}
    
}
