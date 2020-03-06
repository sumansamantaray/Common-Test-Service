/**
 * 
 */
package com.suman.rnd.CommonTestService.model;

import java.util.HashMap;
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
"lod",
"service_type",
"refnum"
})
public class AccordLod {

	
	@JsonProperty("lod")
	private String lod;
	@JsonProperty("service_type")
	private String serviceType;
	@JsonProperty("refnum")
	private String refnum;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("lod")
	public String getLod() {
	return lod;
	}

	@JsonProperty("lod")
	public void setLod(String lod) {
	this.lod = lod;
	}

	@JsonProperty("service_type")
	public String getServiceType() {
	return serviceType;
	}

	@JsonProperty("service_type")
	public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
	}

	@JsonProperty("refnum")
	public String getRefnum() {
	return refnum;
	}

	@JsonProperty("refnum")
	public void setRefnum(String refnum) {
	this.refnum = refnum;
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
