/**
 * 
 */
package com.suman.rnd.object.model;

import java.io.Serializable;

/**
 * @author samasu5
 *
 */
public class PushToCpqObjectModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4214543972608555922L;
	
	private String proxyhost;
	private int port;
	private String clientId;
	private String userName;
	private String aud;
	private String oauthUrl;
	private String pushUrl;
	private String payload;
	private String jksFile;
	private String jksPassword;
	private String jksKey;
	private String jksValue;
	private String signedJwtToken;
	
	
	/**
	 * @return the proxyhost
	 */
	public String getProxyhost() {
		return proxyhost;
	}
	/**
	 * @param proxyhost the proxyhost to set
	 */
	public void setProxyhost(String proxyhost) {
		this.proxyhost = proxyhost;
	}
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the aud
	 */
	public String getAud() {
		return aud;
	}
	/**
	 * @param aud the aud to set
	 */
	public void setAud(String aud) {
		this.aud = aud;
	}
	/**
	 * @return the oauthUrl
	 */
	public String getOauthUrl() {
		return oauthUrl;
	}
	/**
	 * @param oauthUrl the oauthUrl to set
	 */
	public void setOauthUrl(String oauthUrl) {
		this.oauthUrl = oauthUrl;
	}
	/**
	 * @return the pushUrl
	 */
	public String getPushUrl() {
		return pushUrl;
	}
	/**
	 * @param pushUrl the pushUrl to set
	 */
	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}
	/**
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}
	/**
	 * @param payload the payload to set
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}
	/**
	 * @return the jksFile
	 */
	public String getJksFile() {
		return jksFile;
	}
	/**
	 * @param jksFile the jksFile to set
	 */
	public void setJksFile(String jksFile) {
		this.jksFile = jksFile;
	}
	/**
	 * @return the jksPassword
	 */
	public String getJksPassword() {
		return jksPassword;
	}
	/**
	 * @param jksPassword the jksPassword to set
	 */
	public void setJksPassword(String jksPassword) {
		this.jksPassword = jksPassword;
	}
	/**
	 * @return the jksKey
	 */
	public String getJksKey() {
		return jksKey;
	}
	/**
	 * @param jksKey the jksKey to set
	 */
	public void setJksKey(String jksKey) {
		this.jksKey = jksKey;
	}
	/**
	 * @return the jksValue
	 */
	public String getJksValue() {
		return jksValue;
	}
	/**
	 * @param jksValue the jksValue to set
	 */
	public void setJksValue(String jksValue) {
		this.jksValue = jksValue;
	}
	/**
	 * @return the signedJwtToken
	 */
	public String getSignedJwtToken() {
		return signedJwtToken;
	}
	/**
	 * @param signedJwtToken the signedJwtToken to set
	 */
	public void setSignedJwtToken(String signedJwtToken) {
		this.signedJwtToken = signedJwtToken;
	}
	
}
