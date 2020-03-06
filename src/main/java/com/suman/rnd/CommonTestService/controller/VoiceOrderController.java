/**
 * 
 */
package com.suman.rnd.CommonTestService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suman.rnd.CommonTestService.db.model.MilestoneMajorDataModel;
import com.suman.rnd.CommonTestService.object.model.MilestoneMajorObjectModel;
import com.suman.rnd.CommonTestService.repository.VoiceOrderMilestoneRepository;
import com.suman.rnd.CommonTestService.utils.ConvertVoiceNotificationToDataObjects;


/**
 * @author samasu5
 *
 */
@RestController
public class VoiceOrderController {
	private static final Logger LOGGER = LoggerFactory.getLogger(VoiceOrderController.class);
	
	@Autowired
	private ConvertVoiceNotificationToDataObjects convertVoiceNotification;
	
	@Autowired
	private VoiceOrderMilestoneRepository voiceMilestoneRepository;
	
	@PostMapping(path = "/ordermilestone/v1/voiceorder", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> processVoiceOrderMilestones(@RequestBody MilestoneMajorObjectModel milestone) {
		System.out.println("Inside it ##################");
		MilestoneMajorDataModel milestoneDataModel = null;
		
		milestoneDataModel = convertVoiceNotification.convertVoiceNotification(milestone);
		
		if (milestoneDataModel.getMajorMilestoneName() != null) {
			voiceMilestoneRepository.insertMilestoneStatus(milestoneDataModel);
		}
		/*try {
			milestoneDataModel = convertObjectsToDbModel.convertObjectModelToDataModel(milestone);
		} 
		catch (Exception exp) {
			LOGGER.error("Exception while converting WM input milestone object model to DB model: "+exp.toString());
			orderMilestoneResponse.setStatus("error");
			orderMilestoneResponse.setOrderMilestoneMessage("Exception while converting WM input milestone object model to DB model: "+exp.toString());
			return ResponseEntity.ok().body(orderMilestoneResponse);
		}
		
		if (milestoneDataModel.getMajorMilestoneName() != null) {
			milestoneRepository.insertMilestoneStatus(milestoneDataModel);
		}
		if ("Completed".equalsIgnoreCase(milestone.getOrderMilestoneInfo().get(0).getMinorMilestoneStatus())
				|| "Completed".equalsIgnoreCase(
						milestone.getOrderMilestoneInfo().get(0).getCustomerNotification().getMilestoneStatus())) {
			pushMilestoneNotification.pushMilestoneToCPQ(milestone);
			LOGGER.info("[checkPushNotification] The milestone notification is pushed to CPQ.");
		}
		
		orderMilestoneResponse.setStatus("success");
		orderMilestoneResponse.setOrderMilestoneMessage("Successfully persisted the Order Milestone data.");*/
		
		return ResponseEntity.ok().body("success");
	}

}
