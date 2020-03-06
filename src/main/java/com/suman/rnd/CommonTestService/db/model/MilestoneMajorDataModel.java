/**
 * 
 */
package com.suman.rnd.CommonTestService.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author samasu5
 *
 */
@Entity
@Table (name="VSIB_ORDER_MILESTONE_MAJOR")
public class MilestoneMajorDataModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1319092587368549477L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mjr_milestone_seq")
	@SequenceGenerator(name = "mjr_milestone_seq", sequenceName = "VSIB_ORDER_MILESTONE_MJR_SEQ", allocationSize=1)
	@Column (name = "MAJOR_MILESTONE_ID")
	private long majorMilestoneId;
	
	@NotNull
    @Size(max = 255)
    @Column(name = "MESSAGE_ID")
	private String messageId;
	
	@NotNull
	@Size(max = 32)
	@Column (name = "CUSTOMER_ID")
	private String customerId;
	
	@NotNull
    @Size(max = 32)
    @Column(name = "ORDER_ID")
	private String orderId;
	
	@NotNull
    @Column(name = "MAJOR_MILESTONE")
	private String majorMilestoneName;
	
	@Size(max = 32)
    @Column(name = "ORDER_TYPE")
	private String orderType;
	
	@Column (name = "ORDER_DATE")
	private Date orderDate;
	
	@Size(max = 32)
    @Column(name = "MAJOR_MILESTONE_STATUS")
	private String mjrMilestoneStatus;
	
	@Size(max = 32)
    @Column(name = "PON")
	private String pon;
	
	@Size(max = 32)
	@Column (name = "PRODUCT_NAME")
	private String productName;
	
	@Size(max = 32)
	@Column (name = "BILLING_ACCOUNT")
	private String billingAccount;
	
	@NotNull
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@Size(max = 255)
	@Column (name = "REMARKS")
	private String remarks;
	
	@OneToMany(mappedBy="milestoneMajorDataModel")
	private List<MilestoneMinorDataModel> minorMilestoneDataList;
	
	@Transient
	private boolean pushFlag;

	/**
	 * @return the majorMilestoneId
	 */
	public long getMajorMilestoneId() {
		return majorMilestoneId;
	}

	/**
	 * @param majorMilestoneId the majorMilestoneId to set
	 */
	public void setMajorMilestoneId(long majorMilestoneId) {
		this.majorMilestoneId = majorMilestoneId;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the majorMilestoneName
	 */
	public String getMajorMilestoneName() {
		return majorMilestoneName;
	}

	/**
	 * @param majorMilestoneName the majorMilestoneName to set
	 */
	public void setMajorMilestoneName(String majorMilestoneName) {
		this.majorMilestoneName = majorMilestoneName;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the mjrMilestoneStatus
	 */
	public String getMjrMilestoneStatus() {
		return mjrMilestoneStatus;
	}

	/**
	 * @param mjrMilestoneStatus the mjrMilestoneStatus to set
	 */
	public void setMjrMilestoneStatus(String mjrMilestoneStatus) {
		this.mjrMilestoneStatus = mjrMilestoneStatus;
	}

	/**
	 * @return the pon
	 */
	public String getPon() {
		return pon;
	}

	/**
	 * @param pon the pon to set
	 */
	public void setPon(String pon) {
		this.pon = pon;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the billingAccount
	 */
	public String getBillingAccount() {
		return billingAccount;
	}

	/**
	 * @param billingAccount the billingAccount to set
	 */
	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
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
	 * @return the pushFlag
	 */
	public boolean isPushFlag() {
		return pushFlag;
	}

	/**
	 * @param pushFlag the pushFlag to set
	 */
	public void setPushFlag(boolean pushFlag) {
		this.pushFlag = pushFlag;
	}

	/**
	 * @return the minorMilestoneDataList
	 */
	public List<MilestoneMinorDataModel> getMinorMilestoneDataList() {
		return minorMilestoneDataList;
	}

	/**
	 * @param minorMilestoneDataList the minorMilestoneDataList to set
	 */
	public void setMinorMilestoneDataList(List<MilestoneMinorDataModel> minorMilestoneDataList) {
		this.minorMilestoneDataList = minorMilestoneDataList;
	}

}
