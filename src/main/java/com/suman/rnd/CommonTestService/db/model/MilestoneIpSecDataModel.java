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
@Table (name = "VSIB_MILESTONE_VOICE_IPSEC")
public class MilestoneIpSecDataModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5460465363946278727L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voice_ipsec_seq")
	@SequenceGenerator(name = "voice_ipsec_seq", sequenceName = "VSIB_MILESTONE_IPSEC_SEQ", allocationSize=1)
	@Column (name = "IPSEC_ID")
	private Long ipsecId;
	
	@Column (name = "IKE")
	private String ike;
	
	@Column (name = "SIP")
	private String sip;
	
	@Column (name = "PRESHARE_KEY")
	private String preshareKey;
	
	@Column (name = "SUBMASK")
	private String subMask;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINOR_MILESTONE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private MilestoneMinorDataModel ipSecMilestoneMinorDataModel;

	/**
	 * @return the ipsecId
	 */
	public Long getIpsecId() {
		return ipsecId;
	}

	/**
	 * @param ipsecId the ipsecId to set
	 */
	public void setIpsecId(Long ipsecId) {
		this.ipsecId = ipsecId;
	}

	/**
	 * @return the ike
	 */
	public String getIke() {
		return ike;
	}

	/**
	 * @param ike the ike to set
	 */
	public void setIke(String ike) {
		this.ike = ike;
	}

	/**
	 * @return the sip
	 */
	public String getSip() {
		return sip;
	}

	/**
	 * @param sip the sip to set
	 */
	public void setSip(String sip) {
		this.sip = sip;
	}

	/**
	 * @return the preshareKey
	 */
	public String getPreshareKey() {
		return preshareKey;
	}

	/**
	 * @param preshareKey the preshareKey to set
	 */
	public void setPreshareKey(String preshareKey) {
		this.preshareKey = preshareKey;
	}

	/**
	 * @return the subMask
	 */
	public String getSubMask() {
		return subMask;
	}

	/**
	 * @param subMask the subMask to set
	 */
	public void setSubMask(String subMask) {
		this.subMask = subMask;
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
	 * @return the ipSecMilestoneMinorDataModel
	 */
	public MilestoneMinorDataModel getIpSecMilestoneMinorDataModel() {
		return ipSecMilestoneMinorDataModel;
	}

	/**
	 * @param ipSecMilestoneMinorDataModel the ipSecMilestoneMinorDataModel to set
	 */
	public void setIpSecMilestoneMinorDataModel(MilestoneMinorDataModel ipSecMilestoneMinorDataModel) {
		this.ipSecMilestoneMinorDataModel = ipSecMilestoneMinorDataModel;
	}

}
