/**
 * 
 */
package com.suman.rnd.CommonTestService.repository;
import org.springframework.data.repository.CrudRepository;

import com.suman.rnd.CommonTestService.db.model.MilestoneNotificationLog;



/**
 * @author samasu5
 *
 */
public interface MilestoneMessageRepository extends CrudRepository<MilestoneNotificationLog, Long>{

}
