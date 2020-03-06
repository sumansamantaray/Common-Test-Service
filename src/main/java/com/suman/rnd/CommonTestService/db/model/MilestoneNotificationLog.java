/**
 * 
 */
package com.suman.rnd.CommonTestService.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author samasu5
 *
 */
@Entity
@Table (name="VSIB_MILESTONE_MSG_LOG")
@Component
public class MilestoneNotificationLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6334563636115550241L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "milestone_msg_seq")
	@SequenceGenerator(name = "milestone_msg_seq", sequenceName = "VSIB_MILESTONE_MSG_SEQ", allocationSize=1)
    @Column(name = "MSG_LOG_ID")
	private Long id;
    
    
	@Column(name = "INCOMING_MSG")
	@Lob
	private String incomingMessage;
	
	
	@Column(name = "SOURCE_APP")
	private String sourceApp;
	
	
	@Column(name = "DESTINATION_APP")
	private String destinationApp;
	
	
	@Column(name = "OUTGOING_MSG")
	@Lob
	private String outgoingMessage;
	
	@Column (name = "DATE_CREATED", insertable = false)
	private Date dateCreated;
	
	@Column (name = "DATE_LAST_UPDATED")
	private Date dateLastUpdated;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the incomingMessage
	 */
	public String getIncomingMessage() {
		return incomingMessage;
	}

	/**
	 * @param incomingMessage the incomingMessage to set
	 */
	public void setIncomingMessage(String incomingMessage) {
		this.incomingMessage = incomingMessage;
	}

	/**
	 * @return the sourceApp
	 */
	public String getSourceApp() {
		return sourceApp;
	}

	/**
	 * @param sourceApp the sourceApp to set
	 */
	public void setSourceApp(String sourceApp) {
		this.sourceApp = sourceApp;
	}

	/**
	 * @return the destinationApp
	 */
	public String getDestinationApp() {
		return destinationApp;
	}

	/**
	 * @param destinationApp the destinationApp to set
	 */
	public void setDestinationApp(String destinationApp) {
		this.destinationApp = destinationApp;
	}

	/**
	 * @return the outgoingMessage
	 */
	public String getOutgoingMessage() {
		return outgoingMessage;
	}

	/**
	 * @param outgoingMessage the outgoingMessage to set
	 */
	public void setOutgoingMessage(String outgoingMessage) {
		this.outgoingMessage = outgoingMessage;
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
	 * @return the dateLastUpdated
	 */
	public Date getDateLastUpdated() {
		return dateLastUpdated;
	}

	/**
	 * @param dateLastUpdated the dateLastUpdated to set
	 */
	public void setDateLastUpdated(Date dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}
	
}
