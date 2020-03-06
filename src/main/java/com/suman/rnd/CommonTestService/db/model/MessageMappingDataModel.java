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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author samasu5
 *
 */
@Entity
@Table (name = "VSIB_CX_MSG_MAPPING")
public class MessageMappingDataModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 407233815274703348L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msg_mapping_seq")
	@SequenceGenerator(name = "msg_mapping_seq", sequenceName = "VSIB_MSG_MAP_SEQ", allocationSize=1)
	@Column (name = "MSG_MAP_ID")
	private Long msgMappingId;
	
	@Column (name = "ERROR_CODE")
	private String errorCode;
	
	@Column (name = "SOURCE_MESSAGE")
	private String sourceMessage;
	
	@Column(name = "CX_MESSAGE")
	private String cxMessage;

	/**
	 * @return the msgMappingId
	 */
	public Long getMsgMappingId() {
		return msgMappingId;
	}

	/**
	 * @param msgMappingId the msgMappingId to set
	 */
	public void setMsgMappingId(Long msgMappingId) {
		this.msgMappingId = msgMappingId;
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
	 * @return the sourceMessage
	 */
	public String getSourceMessage() {
		return sourceMessage;
	}

	/**
	 * @param sourceMessage the sourceMessage to set
	 */
	public void setSourceMessage(String sourceMessage) {
		this.sourceMessage = sourceMessage;
	}

	/**
	 * @return the cxMessage
	 */
	public String getCxMessage() {
		return cxMessage;
	}

	/**
	 * @param cxMessage the cxMessage to set
	 */
	public void setCxMessage(String cxMessage) {
		this.cxMessage = cxMessage;
	}

}
