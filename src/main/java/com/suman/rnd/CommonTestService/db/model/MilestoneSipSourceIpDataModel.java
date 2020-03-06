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
@Table (name = "VSIB_MILESTONE_SIP_SOURCE_IP")
public class MilestoneSipSourceIpDataModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7364641456913111888L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voice_sip_source_ip_seq")
	@SequenceGenerator(name = "voice_sip_source_ip_seq", sequenceName = "VSIB_MILESTONE_SIP_SOURCE_SEQ", allocationSize=1)
	@Column (name = "SIP_SOURCE_IP_ID")
	private Long sipSourceIpId;
	
	@Column (name = "SERVICE_TYPE")
	private String serviceType;
	
	@Column (name = "HEADER_METHOD")
	private String headerMethod;
	
	@Column (name = "IP_ADDRESS")
	private String ipAddress;
	
	@Column (name = "SERVICE_LOCATION_IP")
	private String serviceLocationIp;
	
	@Column (name = "NPA_NXX")
	private String npaNxx;
	
	@Column (name = "SIP_CONCURRENT_LIMIT")
	private String sipConcurrentLimit;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel sipIpDataMilestoneMinorDataModel;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	/**
	 * @return the sipSourceIpId
	 */
	public Long getSipSourceIpId() {
		return sipSourceIpId;
	}

	/**
	 * @param sipSourceIpId the sipSourceIpId to set
	 */
	public void setSipSourceIpId(Long sipSourceIpId) {
		this.sipSourceIpId = sipSourceIpId;
	}

	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return the headerMethod
	 */
	public String getHeaderMethod() {
		return headerMethod;
	}

	/**
	 * @param headerMethod the headerMethod to set
	 */
	public void setHeaderMethod(String headerMethod) {
		this.headerMethod = headerMethod;
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
	 * @return the serviceLocationIp
	 */
	public String getServiceLocationIp() {
		return serviceLocationIp;
	}

	/**
	 * @param serviceLocationIp the serviceLocationIp to set
	 */
	public void setServiceLocationIp(String serviceLocationIp) {
		this.serviceLocationIp = serviceLocationIp;
	}

	/**
	 * @return the npaNxx
	 */
	public String getNpaNxx() {
		return npaNxx;
	}

	/**
	 * @param npaNxx the npaNxx to set
	 */
	public void setNpaNxx(String npaNxx) {
		this.npaNxx = npaNxx;
	}

	/**
	 * @return the sipConcurrentLimit
	 */
	public String getSipConcurrentLimit() {
		return sipConcurrentLimit;
	}

	/**
	 * @param sipConcurrentLimit the sipConcurrentLimit to set
	 */
	public void setSipConcurrentLimit(String sipConcurrentLimit) {
		this.sipConcurrentLimit = sipConcurrentLimit;
	}

	/**
	 * @return the sipIpDataMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getSipIpDataMilestoneMinorDataModel() {
		return sipIpDataMilestoneMinorDataModel;
	}

	/**
	 * @param sipIpDataMilestoneMinorDataModel the sipIpDataMilestoneMinorDataModel to set
	 */
	public void setSipIpDataMilestoneMinorDataModel(MilestoneMinorDataModel sipIpDataMilestoneMinorDataModel) {
		this.sipIpDataMilestoneMinorDataModel = sipIpDataMilestoneMinorDataModel;
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
	
}
