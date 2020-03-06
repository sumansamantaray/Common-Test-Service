/**
 * 
 */
package com.suman.rnd.CommonTestService.interceptor;

import java.io.InputStream;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.suman.rnd.CommonTestService.db.model.MilestoneNotificationLog;
import com.suman.rnd.CommonTestService.repository.MilestoneMessageRepository;


/**
 * @author samasu5
 *
 */
@Component
public class MilestoneInterceptor implements HandlerInterceptor {
	
	MilestoneMessageRepository milestoneMessageRepository;
	
	MilestoneNotificationLog milestoneNotificationLog;
	
	@Autowired
	public MilestoneInterceptor(MilestoneMessageRepository milestoneMessageRepository,
			MilestoneNotificationLog milestoneNotificationLog) {
		super();
		this.milestoneMessageRepository = milestoneMessageRepository;
		this.milestoneNotificationLog = milestoneNotificationLog;
	}

	

	@Override
	   public boolean preHandle
	      (HttpServletRequest request, HttpServletResponse response, Object handler) 
	      throws Exception {
	      
	      System.out.println("*************** Pre Handle method is Calling *****************");
//	      System.out.println("########### Request ->"+request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
	      System.out.println("########### Request ->"+request.getInputStream());
	      int c = 0;
	      InputStream in = request.getInputStream();
	    		  while ((c=in.read()) != -1)
	    	        {
	    	            System.out.print((char) c);
	    	        }
	      milestoneNotificationLog.setSourceApp("source App");
	      milestoneNotificationLog.setIncomingMessage("incomingMessage");
	      milestoneNotificationLog.setDestinationApp("destinationApp");
	      milestoneNotificationLog.setDateLastUpdated(new Date());
	      milestoneMessageRepository.save(milestoneNotificationLog);
	      return true;
	   }
	
	@Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, ModelAndView modelAndView) throws Exception {
	      
	      System.out.println("############### Post Handle method is Calling #################");
	      /*System.out.println("########### Request ->"+request.getInputStream());
	      System.out.println("########### Response ->"+response.getWriter());*/
	   }
}
