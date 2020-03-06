/**
 * 
 */
package com.suman.rnd.CommonTestService.object.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author samasu5
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MilestoneMajorObjectModel implements Serializable {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 4154371922276649429L;
	

	private String messageId;
    
	private String customerId;
    
	private String orderId;
	
	private String orderStatus;
	
	private String orderType;
	
	private String orderDate;
	
	private String majorMilestoneStatus;
	
	private String pon;
	
	private String productName;

	private String billingAccount;
	
	private String remarks;
	
	private List<MilestoneMinorObjectModel> orderMilestoneInfo = new ArrayList<>();

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
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the majorMilestoneStatus
	 */
	public String getMajorMilestoneStatus() {
		return majorMilestoneStatus;
	}

	/**
	 * @param majorMilestoneStatus the majorMilestoneStatus to set
	 */
	public void setMajorMilestoneStatus(String majorMilestoneStatus) {
		this.majorMilestoneStatus = majorMilestoneStatus;
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
	 * @return the orderMilestoneInfo
	 */
	public List<MilestoneMinorObjectModel> getOrderMilestoneInfo() {
		return orderMilestoneInfo;
	}

	/**
	 * @param orderMilestoneInfo the orderMilestoneInfo to set
	 */
	public void setOrderMilestoneInfo(List<MilestoneMinorObjectModel> orderMilestoneInfo) {
		this.orderMilestoneInfo = orderMilestoneInfo;
	}

}
