/**
 * 
 */
package com.suman.rnd.CommonTestService.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.suman.rnd.CommonTestService.model.AccordSidServiceModel;

/**
 * @author samasu5
 *
 */
@Component
public class AccordRestClient {
	

	public String getSidFromAccord(String pon, String ccna) {
		String lod = "";
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://acofrdztw05.ebiz.suman.com:7001/cafe2/cx/milestone/getLod")//("http://acotpazpa01.suman.com:7001/cafe2/cx/milestone/getLod")//("http://acofrdztw05.ebiz.suman.com:7001/cafe2/cx/milestone/getLod")
				.queryParam("pon", pon)
				.queryParam("ccna", ccna);
		HttpHeaders headers = new HttpHeaders();
        
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        
//        String targetEndpoint = "http://acofrdztw05.ebiz.suman.com:7001/cafe2/cx/milestone/getLod"; //?pon=R503-JUL13-M1S6&ccna=ATX
        
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AccordSidServiceModel> serviceResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, requestEntity, AccordSidServiceModel.class);
        System.out.println("Successfully called the ACCORD LOD service");
        if (serviceResponse.getBody().getLod() != null) {
        	lod = serviceResponse.getBody().getLod().get(0).getLod();
        }
        System.out.println("LOD Date: "+lod);
        return lod;
	}

}
