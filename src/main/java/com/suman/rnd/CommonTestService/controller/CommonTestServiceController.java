/**
 * 
 */
package com.suman.rnd.CommonTestService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.suman.rnd.CommonTestService.db.model.MilestoneMajorDataModel;
import com.suman.rnd.CommonTestService.object.model.MilestoneMajorObjectModel;
import com.suman.rnd.CommonTestService.repository.OrderMilestoneRepository;
import com.suman.rnd.CommonTestService.utils.AccordRestClient;
import com.suman.rnd.CommonTestService.utils.ConvertObjects;
import com.suman.rnd.CommonTestService.utils.CreatePdfFile;
import com.suman.rnd.CommonTestService.utils.MilestoneNotificationPostClient;
import com.AB.cx.cpq.push.model.PushToCpqObjectModel;
import com.AB.cx.cpq.push.utils.RestTemplateUtils;



/**
 * @author samasu5
 *
 */
@Controller
public class CommonTestServiceController {

	@Autowired
	AccordRestClient accordRestClient;
	
	@Autowired
	MilestoneNotificationPostClient milestonePostClient;
	
	@Autowired
	CreatePdfFile createPdfFile;
	
	@Autowired
	ConvertObjects convertObjects;
	
	@Autowired
	OrderMilestoneRepository milestoneRepository;
	
	@GetMapping(path = "testPushCpqMultiThreading")
	public void testPushCpqThreading(@RequestParam(value = "dummyTest") String dummyText) {
		System.out.println("The text sent in the request: "+dummyText);
		
		PushToCpqObjectModel pushToCpqModel = new PushToCpqObjectModel();
		pushToCpqModel.setProxyhost("proxy.ebiz.suman.com");
		pushToCpqModel.setPort(80);
		pushToCpqModel.setClientId("3MVG9JamK_x9K2XJ_MVL9i9xD3mh2wTXvUECCAEWgk79qyVgTs3uAYHBLTC3qAeZuTLx5Fo7P597XULopnVkG");
		pushToCpqModel.setUserName("suman.samantaray@suman.com.abccxuat");
		pushToCpqModel.setAud("https://test.suman.com");
		pushToCpqModel.setOauthUrl("https://abccx--abccxuat.my.suman.com/services/oauth2/token");
		pushToCpqModel.setPushUrl("https://abccx--abccxuat.my.suman.com/services/apexrest/v1/order");
		pushToCpqModel.setJksFile("cx.jks");
		pushToCpqModel.setJksPassword("fugazetta");
		pushToCpqModel.setJksValue("1");
		pushToCpqModel.setJksKey("abccx");
		pushToCpqModel.setPayload("{\"test\":\"test\"}");
		System.out.println("Response from CPQ ************** "+new RestTemplateUtils().pushToCPQ(pushToCpqModel));
		
	}
	
	@GetMapping(path = "getSidFromAccord")
	public ResponseEntity<?> getSidFromAccord(@RequestParam(value = "pon") String pon,
			@RequestParam(value = "ccna", required = false) String ccna) {
		System.out.println("PON: "+pon+", CCNA: "+ccna);
//		createPdfFile.createFile();
		return new ResponseEntity<String>(accordRestClient.getSidFromAccord(pon, ccna), HttpStatus.OK);
	}
	
	@GetMapping(path = "postMilestone")
	public ResponseEntity<?> postMilestoneMessage() {
		return new ResponseEntity<String>(milestonePostClient.milestonePostRequest(), HttpStatus.OK);
	}
	
	@RequestMapping("/")
    public String welcome() {
        return "index";
    }
	
	@PostMapping (path = "/testPost", consumes = "text/plain", produces = "application/json")
	public ResponseEntity<?> testPost() {
		System.out.println("Inside Text plain");
		return ResponseEntity.ok().body("{\"success\":1}");
	}
	
	@PostMapping (path = "/testPost", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> testPost(@RequestBody String name) {
		System.out.println("Inside Application JSON "+name);
		return ResponseEntity.ok().body("{\"success\":1}");
	}
	@PostMapping (path = "/testMilestone", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> testMilestone(@RequestBody MilestoneMajorObjectModel milestone) {
		System.out.println("Inside Application JSON "+milestone.getOrderMilestoneInfo().get(0).getCustomerNotification().getMinorMilestoneDetails().getMilestoneAttributes().get(0).get(0).getValue());
		MilestoneMajorDataModel milestoneDataModel = convertObjects.convertObjectModelToDataModel(milestone);
		milestoneRepository.insertMilestoneStatus(milestoneDataModel);
		return ResponseEntity.ok().body("{\"success\":1}");
	}
}
