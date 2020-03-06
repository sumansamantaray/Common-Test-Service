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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author samasu5
 *
 */
@Entity
@Table (name="VSIB_ORDER_MILESTONE_MINOR")
public class MilestoneMinorDataModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3571734905345021044L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mnr_milestone_seq")
	@SequenceGenerator(name = "mnr_milestone_seq", sequenceName = "VSIB_ORDER_MILESTONE_MNR_SEQ", allocationSize=1)
	@Column (name = "MINOR_MILESTONE_ID")
	private Long minorMilestoneId;
	
	@Size(max = 32)
    @Column(name = "MINOR_MILESTONE")
	private String minorMilestoneName;
	
	@Size(max = 32)
    @Column(name = "VERSION")
	private String version;
	
	@Size(max = 32)
    @Column(name = "MINOR_MILESTONE_STATUS")
	private String minorMilestoneStatus;
	
	@Size(max = 32)
    @Column(name = "MILESTONE_BUCKET")
	private String milestoneBucket;
	
    @Column(name = "MILESTONE_DATE")
	private Date minorMilestoneDate;
	
	@NotNull
    @Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@Size(max = 255)
    @Column(name = "REMARKS")
	private String remarks;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAJOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMajorDataModel milestoneMajorDataModel;
	
	@Transient
	private List<List<MilestoneAttributesDataModel>> attributesList;
	
	@OneToMany(mappedBy="cctMilestoneMinorDataModel")
	private List<MilestoneCircuitsDataModel> milestoneCircuitDataList;
	
	@OneToMany(mappedBy="errMilestoneMinorDataModel")
	private List<MilestoneErrorDataModel> milestoneErrorDataModel;
	
	@OneToMany(mappedBy="ipSecMilestoneMinorDataModel")
	private List<MilestoneIpSecDataModel> ipSecDataList;
	
	@OneToMany(mappedBy="testDataMilestoneMinorDataModel")
	private List<MilestoneVoiceTestDataModel> voiceTestDataList;
	
	@OneToMany(mappedBy="sipIpDataMilestoneMinorDataModel")
	private List<MilestoneSipSourceIpDataModel> sipSourceIpDataList;
	
	@OneToMany(mappedBy="testNumbersMilestoneMinorDataModel")
	private List<MilestoneTestNumbersDataModel> testNumbersDataList;
	
	@OneToMany(mappedBy="mtnceAniMilestoneMinorDataModel")
	private List<MilestoneMaintenanceAni> mntanceAniDataList;
	

	@OneToMany(mappedBy="sbcMilestoneMinorDataModel")
	private List<MilestoneABIpAssignDataModel> sbcMilestoneDataModel;
	
	

	/**
	 * @return the minorMilestoneId
	 */
	public Long getMinorMilestoneId() {
		return minorMilestoneId;
	}

	/**
	 * @param minorMilestoneId the minorMilestoneId to set
	 */
	public void setMinorMilestoneId(Long minorMilestoneId) {
		this.minorMilestoneId = minorMilestoneId;
	}

	/**
	 * @return the minorMilestoneName
	 */
	public String getMinorMilestoneName() {
		return minorMilestoneName;
	}

	/**
	 * @param minorMilestoneName the minorMilestoneName to set
	 */
	public void setMinorMilestoneName(String minorMilestoneName) {
		this.minorMilestoneName = minorMilestoneName;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
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
	 * @return the milestoneBucket
	 */
	public String getMilestoneBucket() {
		return milestoneBucket;
	}

	/**
	 * @param milestoneBucket the milestoneBucket to set
	 */
	public void setMilestoneBucket(String milestoneBucket) {
		this.milestoneBucket = milestoneBucket;
	}

	/**
	 * @return the minorMilestoneDate
	 */
	public Date getMinorMilestoneDate() {
		return minorMilestoneDate;
	}

	/**
	 * @param minorMilestoneDate the minorMilestoneDate to set
	 */
	public void setMinorMilestoneDate(Date minorMilestoneDate) {
		this.minorMilestoneDate = minorMilestoneDate;
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
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the milestoneMajorDataModel
	 */
	public MilestoneMajorDataModel getMilestoneMajorDataModel() {
		return milestoneMajorDataModel;
	}

	/**
	 * @param milestoneMajorDataModel the milestoneMajorDataModel to set
	 */
	public void setMilestoneMajorDataModel(MilestoneMajorDataModel milestoneMajorDataModel) {
		this.milestoneMajorDataModel = milestoneMajorDataModel;
	}

	/**
	 * @return the attributesList
	 */
	public List<List<MilestoneAttributesDataModel>> getAttributesList() {
		return attributesList;
	}

	/**
	 * @param attributesList the attributesList to set
	 */
	public void setAttributesList(List<List<MilestoneAttributesDataModel>> attributesList) {
		this.attributesList = attributesList;
	}

	/**
	 * @return the milestoneCircuitDataList
	 */
	public List<MilestoneCircuitsDataModel> getMilestoneCircuitDataList() {
		return milestoneCircuitDataList;
	}

	/**
	 * @param milestoneCircuitDataList the milestoneCircuitDataList to set
	 */
	public void setMilestoneCircuitDataList(List<MilestoneCircuitsDataModel> milestoneCircuitDataList) {
		this.milestoneCircuitDataList = milestoneCircuitDataList;
	}

	/**
	 * @return the milestoneErrorDataModel
	 */
	public List<MilestoneErrorDataModel> getMilestoneErrorDataModel() {
		return milestoneErrorDataModel;
	}

	/**
	 * @param milestoneErrorDataModel the milestoneErrorDataModel to set
	 */
	public void setMilestoneErrorDataModel(List<MilestoneErrorDataModel> milestoneErrorDataModel) {
		this.milestoneErrorDataModel = milestoneErrorDataModel;
	}

	/**
	 * @return the ipSecDataList
	 */
	public List<MilestoneIpSecDataModel> getIpSecDataList() {
		return ipSecDataList;
	}

	/**
	 * @param ipSecDataList the ipSecDataList to set
	 */
	public void setIpSecDataList(List<MilestoneIpSecDataModel> ipSecDataList) {
		this.ipSecDataList = ipSecDataList;
	}

	/**
	 * @return the voiceTestDataList
	 */
	public List<MilestoneVoiceTestDataModel> getVoiceTestDataList() {
		return voiceTestDataList;
	}

	/**
	 * @param voiceTestDataList the voiceTestDataList to set
	 */
	public void setVoiceTestDataList(List<MilestoneVoiceTestDataModel> voiceTestDataList) {
		this.voiceTestDataList = voiceTestDataList;
	}

	/**
	 * @return the sipSourceIpDataList
	 */
	public List<MilestoneSipSourceIpDataModel> getSipSourceIpDataList() {
		return sipSourceIpDataList;
	}

	/**
	 * @param sipSourceIpDataList the sipSourceIpDataList to set
	 */
	public void setSipSourceIpDataList(List<MilestoneSipSourceIpDataModel> sipSourceIpDataList) {
		this.sipSourceIpDataList = sipSourceIpDataList;
	}

	/**
	 * @return the testNumbersDataList
	 */
	public List<MilestoneTestNumbersDataModel> getTestNumbersDataList() {
		return testNumbersDataList;
	}

	/**
	 * @param testNumbersDataList the testNumbersDataList to set
	 */
	public void setTestNumbersDataList(List<MilestoneTestNumbersDataModel> testNumbersDataList) {
		this.testNumbersDataList = testNumbersDataList;
	}

	/**
	 * @return the mntanceAniDataList
	 */
	public List<MilestoneMaintenanceAni> getMntanceAniDataList() {
		return mntanceAniDataList;
	}

	/**
	 * @param mntanceAniDataList the mntanceAniDataList to set
	 */
	public void setMntanceAniDataList(List<MilestoneMaintenanceAni> mntanceAniDataList) {
		this.mntanceAniDataList = mntanceAniDataList;
	}

	/**
	 * @return the sbcMilestoneDataModel
	 */
	public List<MilestoneABIpAssignDataModel> getSbcMilestoneDataModel() {
		return sbcMilestoneDataModel;
	}

	/**
	 * @param sbcMilestoneDataModel the sbcMilestoneDataModel to set
	 */
	public void setSbcMilestoneDataModel(List<MilestoneABIpAssignDataModel> sbcMilestoneDataModel) {
		this.sbcMilestoneDataModel = sbcMilestoneDataModel;
	}
	
}
