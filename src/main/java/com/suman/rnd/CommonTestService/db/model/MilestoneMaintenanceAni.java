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
@Table (name = "VSIB_MILESTONE_MAINTENANCE_ANI")
public class MilestoneMaintenanceAni implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -635624365623935234L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voice_mtnce_ani_seq")
	@SequenceGenerator(name = "voice_mtnce_ani_seq", sequenceName = "VSIB_MTNANCE_ANI_SEQ", allocationSize=1)
	@Column (name = "MTNANCE_ANI_ID")
	private Long maintenanceAniId;
	
	@Column (name = "PORT_NUMBER")
	private String portNumber;
	
	@Column (name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel mtnceAniMilestoneMinorDataModel;

	/**
	 * @return the maintenanceAniId
	 */
	public Long getMaintenanceAniId() {
		return maintenanceAniId;
	}

	/**
	 * @param maintenanceAniId the maintenanceAniId to set
	 */
	public void setMaintenanceAniId(Long maintenanceAniId) {
		this.maintenanceAniId = maintenanceAniId;
	}

	/**
	 * @return the portNumber
	 */
	public String getPortNumber() {
		return portNumber;
	}

	/**
	 * @param portNumber the portNumber to set
	 */
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * @return the mtnceAniMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getMtnceAniMilestoneMinorDataModel() {
		return mtnceAniMilestoneMinorDataModel;
	}

	/**
	 * @param mtnceAniMilestoneMinorDataModel the mtnceAniMilestoneMinorDataModel to set
	 */
	public void setMtnceAniMilestoneMinorDataModel(MilestoneMinorDataModel mtnceAniMilestoneMinorDataModel) {
		this.mtnceAniMilestoneMinorDataModel = mtnceAniMilestoneMinorDataModel;
	}
	
	
}
