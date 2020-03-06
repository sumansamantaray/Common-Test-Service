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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author samasu5
 *
 */
@Entity
@Table (name = "VSIB_MILESTONE_SBC")
public class MilestoneABIpAssignDataModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4959177200873715941L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voice_sbc_seq")
	@SequenceGenerator(name = "voice_sbc_seq", sequenceName = "VSIB_SBC_SEQ", allocationSize=1)
	@Column (name = "SBC_ID")
	private Long sbcId;
	
	@Column (name = "SBC_NAME")
	private String sbcName;
	
	@Column (name = "SBC_CITY")
	private String sbcCity;
	
	@Column (name = "STATE")
	private String state;
	
	@Column (name = "ADDRESS")
	private String address;
	
	@Column (name = "NODE")
	private String node;
	
	@Column (name = "AB_CLLI")
	private String ABClli;
	
	@Column (name = "AB_PSUEDO")
	private String ABPsuedo;
	
	@Column (name = "HOST_NAME")
	private String hostName;
	
	@Column (name = "IP_ADDRESS")
	private String ipAddress;
	
	@Column (name = "IP_SUBNET")
	private String ipSubnet;
	
	@Column (name = "CONCURNT_CALL_LIMIT")
	private String concurrentCallLimit;
	
	@Column (name = "CALLS_PER_SECOND")
	private String callsPerSecond;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel sbcMilestoneMinorDataModel;

	/**
	 * @return the sbcId
	 */
	public Long getSbcId() {
		return sbcId;
	}

	/**
	 * @param sbcId the sbcId to set
	 */
	public void setSbcId(Long sbcId) {
		this.sbcId = sbcId;
	}

	/**
	 * @return the sbcName
	 */
	public String getSbcName() {
		return sbcName;
	}

	/**
	 * @param sbcName the sbcName to set
	 */
	public void setSbcName(String sbcName) {
		this.sbcName = sbcName;
	}

	/**
	 * @return the sbcCity
	 */
	public String getSbcCity() {
		return sbcCity;
	}

	/**
	 * @param sbcCity the sbcCity to set
	 */
	public void setSbcCity(String sbcCity) {
		this.sbcCity = sbcCity;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the node
	 */
	public String getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		this.node = node;
	}

	/**
	 * @return the ABClli
	 */
	public String getABClli() {
		return ABClli;
	}

	/**
	 * @param ABClli the ABClli to set
	 */
	public void setABClli(String ABClli) {
		this.ABClli = ABClli;
	}

	/**
	 * @return the ABPsuedo
	 */
	public String getABPsuedo() {
		return ABPsuedo;
	}

	/**
	 * @param ABPsuedo the ABPsuedo to set
	 */
	public void setABPsuedo(String ABPsuedo) {
		this.ABPsuedo = ABPsuedo;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the ipSubnet
	 */
	public String getIpSubnet() {
		return ipSubnet;
	}

	/**
	 * @param ipSubnet the ipSubnet to set
	 */
	public void setIpSubnet(String ipSubnet) {
		this.ipSubnet = ipSubnet;
	}

	/**
	 * @return the concurrentCallLimit
	 */
	public String getConcurrentCallLimit() {
		return concurrentCallLimit;
	}

	/**
	 * @param concurrentCallLimit the concurrentCallLimit to set
	 */
	public void setConcurrentCallLimit(String concurrentCallLimit) {
		this.concurrentCallLimit = concurrentCallLimit;
	}

	/**
	 * @return the callsPerSecond
	 */
	public String getCallsPerSecond() {
		return callsPerSecond;
	}

	/**
	 * @param callsPerSecond the callsPerSecond to set
	 */
	public void setCallsPerSecond(String callsPerSecond) {
		this.callsPerSecond = callsPerSecond;
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
	 * @return the sbcMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getSbcMilestoneMinorDataModel() {
		return sbcMilestoneMinorDataModel;
	}

	/**
	 * @param sbcMilestoneMinorDataModel the sbcMilestoneMinorDataModel to set
	 */
	public void setSbcMilestoneMinorDataModel(MilestoneMinorDataModel sbcMilestoneMinorDataModel) {
		this.sbcMilestoneMinorDataModel = sbcMilestoneMinorDataModel;
	}
	
}
