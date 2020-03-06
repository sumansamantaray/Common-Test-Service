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
@Table (name = "VSIB_MILESTONE_VOICE_TEST_NUMBERS")
public class MilestoneTestNumbersDataModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6590603936448656675L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voice_test_numbers_seq")
	@SequenceGenerator(name = "voice_test_numbers_seq", sequenceName = "VSIB_MILESTONE_TEST_NO_SEQ", allocationSize=1)
	@Column (name = "TEST_NUMBERS_ID")
	private Long testNumbersId;
	
	@Column(name = "TEST_NUMBERS")
	private String testNumbers;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel testNumbersMilestoneMinorDataModel;

	/**
	 * @return the testNumbersId
	 */
	public Long getTestNumbersId() {
		return testNumbersId;
	}

	/**
	 * @param testNumbersId the testNumbersId to set
	 */
	public void setTestNumbersId(Long testNumbersId) {
		this.testNumbersId = testNumbersId;
	}

	/**
	 * @return the testNumbers
	 */
	public String getTestNumbers() {
		return testNumbers;
	}

	/**
	 * @param testNumbers the testNumbers to set
	 */
	public void setTestNumbers(String testNumbers) {
		this.testNumbers = testNumbers;
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
	 * @return the testNumbersMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getTestNumbersMilestoneMinorDataModel() {
		return testNumbersMilestoneMinorDataModel;
	}

	/**
	 * @param testNumbersMilestoneMinorDataModel the testNumbersMilestoneMinorDataModel to set
	 */
	public void setTestNumbersMilestoneMinorDataModel(MilestoneMinorDataModel testNumbersMilestoneMinorDataModel) {
		this.testNumbersMilestoneMinorDataModel = testNumbersMilestoneMinorDataModel;
	}
	
}
