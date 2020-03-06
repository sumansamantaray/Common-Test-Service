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
@Table (name = "VSIB_MILESTONE_VOICE_TEST_DATA")
public class MilestoneVoiceTestDataModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -822915244664612955L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voice_test_data_seq")
	@SequenceGenerator(name = "voice_test_data_seq", sequenceName = "VSIB_MILESTONE_TESTDATA_SEQ", allocationSize=1)
	@Column (name = "TEST_DATA_ID")
	private Long testDataId;
	
	@Column (name = "ACTUAL_TEST_DATE")
	private String actualTestDate;
	
	@Column (name = "PASSED")
	private String passed;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel testDataMilestoneMinorDataModel;

	/**
	 * @return the testDataId
	 */
	public Long getTestDataId() {
		return testDataId;
	}

	/**
	 * @param testDataId the testDataId to set
	 */
	public void setTestDataId(Long testDataId) {
		this.testDataId = testDataId;
	}

	/**
	 * @return the actualTestDate
	 */
	public String getActualTestDate() {
		return actualTestDate;
	}

	/**
	 * @param actualTestDate the actualTestDate to set
	 */
	public void setActualTestDate(String actualTestDate) {
		this.actualTestDate = actualTestDate;
	}

	/**
	 * @return the passed
	 */
	public String getPassed() {
		return passed;
	}

	/**
	 * @param passed the passed to set
	 */
	public void setPassed(String passed) {
		this.passed = passed;
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
	 * @return the testDataMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getTestDataMilestoneMinorDataModel() {
		return testDataMilestoneMinorDataModel;
	}

	/**
	 * @param testDataMilestoneMinorDataModel the testDataMilestoneMinorDataModel to set
	 */
	public void setTestDataMilestoneMinorDataModel(MilestoneMinorDataModel testDataMilestoneMinorDataModel) {
		this.testDataMilestoneMinorDataModel = testDataMilestoneMinorDataModel;
	}
	
	
}
