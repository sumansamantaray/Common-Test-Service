/**
 * 
 */
package com.suman.rnd.CommonTestService.controller;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author samasu5
 *
 */
@Component
public class AnotherScheduler {

	@Scheduled(fixedRate = 2000)
	   public void cronJobSch() {
	      System.out.println("Java cron job expression:POLLER - 2: "+new Date());
	   }
}
