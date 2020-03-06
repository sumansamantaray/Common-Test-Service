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
@Table (name="VSIB_ORDER_MILESTONE_ERROR")
public class MilestoneErrorDataModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3834388958175019713L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "err_milestone_seq")
	@SequenceGenerator(name = "err_milestone_seq", sequenceName = "VSIB_MILESTONE_ERROR_SEQ", allocationSize=1)
	@Column (name = "MILESTONE_ERROR_ID")
	private Long minorMilestoneId;
	
	@Size(max = 8)
	@Column (name = "SUP_INDICATOR")
	private String supIndicator;
	
	@Size(max = 8)
	@Column (name = "CODE")
	private String errorCode;
	
	@Size(max = 255)
	@Column (name = "DESCRIPTION")
	private String errorDescription;
	
	@Column (name = "DATE_CREATED")
	private Date dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel errMilestoneMinorDataModel;

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
	 * @return the supIndicator
	 */
	public String getSupIndicator() {
		return supIndicator;
	}

	/**
	 * @param supIndicator the supIndicator to set
	 */
	public void setSupIndicator(String supIndicator) {
		this.supIndicator = supIndicator;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
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
	 * @return the errMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getErrMilestoneMinorDataModel() {
		return errMilestoneMinorDataModel;
	}

	/**
	 * @param errMilestoneMinorDataModel the errMilestoneMinorDataModel to set
	 */
	public void setErrMilestoneMinorDataModel(MilestoneMinorDataModel errMilestoneMinorDataModel) {
		this.errMilestoneMinorDataModel = errMilestoneMinorDataModel;
	}
	
}
