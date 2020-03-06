package com.suman.rnd.CommonTestService.object.model;

import java.io.Serializable;

public class MilestoneNotificationResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7407809163166922356L;

	private String orderMilestoneId;
	
	private String orderMilestoneMessage;

	/**
	 * @return the orderMilestoneId
	 */
	public String getOrderMilestoneId() {
		return orderMilestoneId;
	}

	/**
	 * @param orderMilestoneId the orderMilestoneId to set
	 */
	public void setOrderMilestoneId(String orderMilestoneId) {
		this.orderMilestoneId = orderMilestoneId;
	}

	/**
	 * @return the orderMilestoneMessage
	 */
	public String getOrderMilestoneMessage() {
		return orderMilestoneMessage;
	}

	/**
	 * @param orderMilestoneMessage the orderMilestoneMessage to set
	 */
	public void setOrderMilestoneMessage(String orderMilestoneMessage) {
		this.orderMilestoneMessage = orderMilestoneMessage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderMilestoneResponse [orderMilestoneId=" + orderMilestoneId + ", orderMilestoneMessage="
				+ orderMilestoneMessage + "]";
	}
}
