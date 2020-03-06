/**
 * 
 */
package com.suman.rnd.CommonTestService.threading;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.suman.rnd.CommonTestService.utils.ReadFile;

/**
 * @author samasu5
 *
 */
public class Tasks implements Runnable {

	
	private int taskId;
	
	private List<String> resultSet;
	
	public Tasks() {
		
	}

	  public Tasks(int id)
	  {
	    this.taskId = id;
	  }
	  
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/OrderMilestone/ordermilestone");
		HttpHeaders headers = new HttpHeaders();
        
        // Request to return JSON format
        headers.setContentType(MediaType.TEXT_PLAIN);
        
//        String targetEndpoint = "http://acofrdztw05.ebiz.suman.com:7001/cafe2/cx/milestone/getLod"; //?pon=R503-JUL13-M1S6&ccna=ATX
        String fileContent = ReadFile.readFromTxtFile();
        HttpEntity<?> requestEntity = new HttpEntity<>(fileContent, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> serviceResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.POST, requestEntity, String.class);
        System.out.println("RESPONSE**"+ serviceResponse.getBody());
        resultSet.add(serviceResponse.getBody());
		
	}

	/**
	 * @return the resultSet
	 */
	public List<String> getResultSet() {
		return resultSet;
	}

	/**
	 * @param resultSet the resultSet to set
	 */
	public void setResultSet(List<String> resultSet) {
		this.resultSet = resultSet;
	}
	
	

}
