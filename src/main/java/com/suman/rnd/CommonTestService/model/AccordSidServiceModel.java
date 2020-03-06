/**
 * 
 */
package com.suman.rnd.CommonTestService.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author samasu5
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"pon",
"ccna",
"asrid",
"code",
"message",
"lod"
})
public class AccordSidServiceModel {
	
	
	@JsonProperty("pon")
	private String pon;
	@JsonProperty("ccna")
	private String ccna;
	@JsonProperty("asrid")
//	private Integer asrid;
	private long asrid;
	@JsonProperty("code")
	private String code;
	@JsonProperty("message")
	private String message;
	@JsonProperty("lod")
	private List<AccordLod> lod = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("pon")
	public String getPon() {
	return pon;
	}

	@JsonProperty("pon")
	public void setPon(String pon) {
	this.pon = pon;
	}

	@JsonProperty("ccna")
	public String getCcna() {
	return ccna;
	}

	@JsonProperty("ccna")
	public void setCcna(String ccna) {
	this.ccna = ccna;
	}

	@JsonProperty("code")
	public String getCode() {
	return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
	this.code = code;
	}

	@JsonProperty("message")
	public String getMessage() {
	return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
	this.message = message;
	}
	

	/**
	 * @return the asrid
	 */
	@JsonProperty("asrid")
	public long getAsrid() {
		return asrid;
	}

	/**
	 * @param asrid the asrid to set
	 */
	@JsonProperty("asrid")
	public void setAsrid(long asrid) {
		this.asrid = asrid;
	}

	@JsonProperty("lod")
	public List<AccordLod> getLod() {
	return lod;
	}

	@JsonProperty("lod")
	public void setLod(List<AccordLod> lod) {
	this.lod = lod;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
