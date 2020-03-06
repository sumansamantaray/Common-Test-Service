/**
 * 
 */
package com.suman.rnd.CommonTestService.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.suman.rnd.CommonTestService.threading.Tasks;

/**
 * @author samasu5
 *
 */
@Component
public class MilestoneNotificationPostClient {

	
	public String milestonePostRequest() {
		
		multiThreadRestCall();
        Tasks tasks = new Tasks();
        return tasks.getResultSet().toString();
        
	}
	
	public void multiThreadRestCall( ) {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
	    IntStream.range(0, 10).forEach(i -> service.submit(new Tasks(i)));
	}
}
