/**
 * 
 */
package com.suman.rnd.CommonTestService.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author samasu5
 *
 */
@Configuration
public class MilestoneInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	MilestoneInterceptor milestoneInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(milestoneInterceptor);
    }
}
