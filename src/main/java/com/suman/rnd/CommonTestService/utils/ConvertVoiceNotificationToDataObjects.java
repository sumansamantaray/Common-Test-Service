/**
 * 
 */
package com.suman.rnd.CommonTestService.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.suman.rnd.CommonTestService.db.model.MilestoneAttributesDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneErrorDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneIpSecDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneMaintenanceAni;
import com.suman.rnd.CommonTestService.db.model.MilestoneMajorDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneMinorDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneSipSourceIpDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneTestNumbersDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneVoiceTestDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneABIpAssignDataModel;
import com.suman.rnd.CommonTestService.object.model.CustomerNotification;
import com.suman.rnd.CommonTestService.object.model.MilestoneAttributes;
import com.suman.rnd.CommonTestService.object.model.MilestoneMajorObjectModel;
import com.suman.rnd.CommonTestService.object.model.MilestoneMinorObjectModel;
import com.suman.rnd.CommonTestService.object.model.MinorMilestoneDetails;

/**
 * @author samasu5
 *
 */
@Component
public class ConvertVoiceNotificationToDataObjects {
	
	
	static Date getDate() {
		return new Date();
	}
	
	public MilestoneMajorDataModel convertVoiceNotification(MilestoneMajorObjectModel milestoneObjectModel) {
		
		MilestoneMajorDataModel milestoneMajorDataModel = new MilestoneMajorDataModel();
		milestoneMajorDataModel.setMessageId(milestoneObjectModel.getMessageId());
		milestoneMajorDataModel.setCustomerId(milestoneObjectModel.getCustomerId());
		milestoneMajorDataModel.setOrderId(milestoneObjectModel.getOrderId());
		milestoneMajorDataModel.setOrderDate(convertDate(milestoneObjectModel.getOrderDate()));
		milestoneMajorDataModel.setMajorMilestoneName(milestoneObjectModel.getOrderStatus());
		milestoneMajorDataModel.setPon(milestoneObjectModel.getPon());
		milestoneMajorDataModel.setOrderType(milestoneObjectModel.getOrderType());
		milestoneMajorDataModel.setProductName(milestoneObjectModel.getProductName());
		milestoneMajorDataModel.setBillingAccount(milestoneObjectModel.getBillingAccount());
		MilestoneMinorObjectModel milestoneMinorObjectModel= milestoneObjectModel.getOrderMilestoneInfo().get(0);
		MilestoneMinorDataModel milestoneMinorDataModel = new MilestoneMinorDataModel();
		milestoneMinorDataModel.setMinorMilestoneDate(convertDate(milestoneMinorObjectModel.getMilestoneDate()));
		milestoneMinorDataModel.setMinorMilestoneName(milestoneMinorObjectModel.getMilestoneLabel());
		milestoneMinorDataModel.setVersion(String.valueOf(milestoneMinorObjectModel.getVersion()));
		milestoneMinorDataModel.setMilestoneBucket(milestoneMinorObjectModel.getParentBucket());
		milestoneMajorDataModel.setDateCreated(getDate());
		milestoneMinorDataModel.setDateCreated(getDate());
		
		milestoneMinorDataModel.setMilestoneMajorDataModel(milestoneMajorDataModel);
		List<MilestoneMinorDataModel> minorDataModelList = new ArrayList<>();
		minorDataModelList.add(milestoneMinorDataModel);
		milestoneMajorDataModel.setMinorMilestoneDataList(minorDataModelList);
		
		CustomerNotification customerNotification = milestoneMinorObjectModel.getCustomerNotification();
		milestoneMajorDataModel.setMjrMilestoneStatus(customerNotification.getMilestoneStatus());
		
		MinorMilestoneDetails minorMilestoneDetails = customerNotification.getMinorMilestoneDetails();
		List<List<MilestoneAttributes>> milestoneAttributeList = minorMilestoneDetails.getMilestoneAttributes();
		
		List<MilestoneIpSecDataModel> ipSecDataList = null;
		List<MilestoneVoiceTestDataModel> voiceTestDataModelList = null;
		List<MilestoneSipSourceIpDataModel> sipSourceIpDataList = null;
		List<MilestoneTestNumbersDataModel> testNumbersDataList = null;
		List<MilestoneMaintenanceAni> mntanceAniDataList = null;
		List<MilestoneABIpAssignDataModel> sbcMilestoneDataModel = null;
		List<MilestoneErrorDataModel> errorsDataModelList = null;
		
		List<List<MilestoneAttributesDataModel>> milestoneAttributeDbList = new ArrayList<>();
		milestoneMinorDataModel.setAttributesList(milestoneAttributeDbList);
		
		for (List<MilestoneAttributes> attributeList : milestoneAttributeList) {
			List<String> attributeNames = getAttributeNames(attributeList);
			
			if (attributeNames.stream().anyMatch("Type"::equalsIgnoreCase)) {
				String typeValue = attributeList.stream().filter(attribute -> "Type".equalsIgnoreCase(attribute.getName()))
						.map(attribute -> attribute.getValue()).collect(Collectors.joining());
				switch (typeValue) {
					case "IPSecData":
						if (ipSecDataList == null) {
							ipSecDataList = new ArrayList<>();
						}
						MilestoneIpSecDataModel ipSecDataModel = populateIpSecData(attributeList, milestoneMinorDataModel);
						ipSecDataList.add(ipSecDataModel);
						break;
					case "CustomerTest":
						if (voiceTestDataModelList == null) {
							voiceTestDataModelList = new ArrayList<>();
						}
						MilestoneVoiceTestDataModel voiceTestCustTestDataModel = populateTestData(attributeList, milestoneMinorDataModel);
						voiceTestDataModelList.add(voiceTestCustTestDataModel);
						break;
					case "ICTest&Turnup-IPSec":
						if (voiceTestDataModelList == null) {
							voiceTestDataModelList = new ArrayList<>();
						}
						MilestoneVoiceTestDataModel voiceTestIpSecDataModel = populateTestData(attributeList, milestoneMinorDataModel);
						voiceTestDataModelList.add(voiceTestIpSecDataModel);
						break;
					case "SIPSourceIP":
						if (sipSourceIpDataList == null) {
							sipSourceIpDataList = new ArrayList<>();
						}
						MilestoneSipSourceIpDataModel milestoneSipSourceIpDataModel = populateSipSourceIp(attributeList, milestoneMinorDataModel);
						sipSourceIpDataList.add(milestoneSipSourceIpDataModel);
						break;
					case "TestNumbers":
						testNumbersDataList = populateTestNumbers(attributeList, milestoneMinorDataModel);
						break;
					case "MaintainanceANI":
						mntanceAniDataList = populateMaintainanceAni(attributeList, milestoneMinorDataModel);
						break;
					case "ICTest&Turnup-SIP":
						if (voiceTestDataModelList == null) {
							voiceTestDataModelList = new ArrayList<>();
						}
						MilestoneVoiceTestDataModel voiceTestSipDataModel = populateTestData(attributeList, milestoneMinorDataModel);
						voiceTestDataModelList.add(voiceTestSipDataModel);
						break;
					case "ABIPAssignment":
						if (sbcMilestoneDataModel == null) {
							sbcMilestoneDataModel = new ArrayList<>();
						}
						MilestoneABIpAssignDataModel milestoneABIpAssignDataModel = populateSbc(attributeList, milestoneMinorDataModel);
						sbcMilestoneDataModel.add(milestoneABIpAssignDataModel);
						break;
					case "ICTest&Turnup":
						if (voiceTestDataModelList == null) {
							voiceTestDataModelList = new ArrayList<>();
						}
						MilestoneVoiceTestDataModel voiceTestIcTestDataModel = populateTestData(attributeList, milestoneMinorDataModel);
						voiceTestDataModelList.add(voiceTestIcTestDataModel);
						break;
					case "Error":
						if (errorsDataModelList == null) {
							errorsDataModelList = new ArrayList<>();
						}
						MilestoneErrorDataModel errorsDataModel = populateErrorAttribs(attributeList, milestoneMinorDataModel);
						errorsDataModelList.add(errorsDataModel);
						break;
					default:
						break;
				}
				
				
			} else {
				List<MilestoneAttributesDataModel> attributeDataModel = populateMilestoneAttributes(attributeList, milestoneMajorDataModel);
				milestoneAttributeDbList.add(attributeDataModel);
			}
			
			if(ipSecDataList != null) {
				milestoneMinorDataModel.setIpSecDataList(ipSecDataList);
			}
			if(voiceTestDataModelList != null) {
				milestoneMinorDataModel.setVoiceTestDataList(voiceTestDataModelList);
			}
			if(sipSourceIpDataList != null) {
				milestoneMinorDataModel.setSipSourceIpDataList(sipSourceIpDataList);
			}
			if(testNumbersDataList != null) {
				milestoneMinorDataModel.setTestNumbersDataList(testNumbersDataList);
			}
			if(mntanceAniDataList != null) {
				milestoneMinorDataModel.setMntanceAniDataList(mntanceAniDataList);
			}
			if(sbcMilestoneDataModel != null) {
				milestoneMinorDataModel.setSbcMilestoneDataModel(sbcMilestoneDataModel);
			}
			if(errorsDataModelList != null) {
				milestoneMinorDataModel.setMilestoneErrorDataModel(errorsDataModelList);
			}
		}
		
		return milestoneMajorDataModel;
	}
	
	private MilestoneErrorDataModel populateErrorAttribs(List<MilestoneAttributes> attributeList,
			MilestoneMinorDataModel milestoneMinorDataModel) {
		
		MilestoneErrorDataModel errorDataModel = new MilestoneErrorDataModel();
		errorDataModel.setDateCreated(getDate());
		errorDataModel.setErrMilestoneMinorDataModel(milestoneMinorDataModel);
		
		for (MilestoneAttributes errorAttribute : attributeList) {
			switch (errorAttribute.getName()) {
			case "Customer Action":
				errorDataModel.setSupIndicator("N");
				if ("Request Change".equalsIgnoreCase(errorAttribute.getValue())) {
					errorDataModel.setSupIndicator("Y");
				}
				break;
			case "Error Description":
				errorDataModel.setErrorDescription(errorAttribute.getValue());
				errorDataModel.setErrorCode(errorAttribute.getValue().substring(0, errorAttribute.getValue().indexOf("-")).trim());
				break;
			default:
				break;
			}
		}
		
		
		return errorDataModel;
	}

	private List<MilestoneAttributesDataModel> populateMilestoneAttributes(List<MilestoneAttributes> attributeList,
			MilestoneMajorDataModel milestoneMajorDataModel) {
		
		List<MilestoneAttributesDataModel> milestoneAttributesDataModelList = new ArrayList<>();
		for (MilestoneAttributes milestoneAttributes : attributeList) {
			MilestoneAttributesDataModel attributeDataModel = new MilestoneAttributesDataModel();
			attributeDataModel.setMajorMilestone(milestoneMajorDataModel.getMajorMilestoneName());
			attributeDataModel.setOrderId(milestoneMajorDataModel.getOrderId());
			attributeDataModel.setServiceOrderId(null);
			attributeDataModel.setMinorMilestone(milestoneMajorDataModel.getMinorMilestoneDataList().get(0).getMinorMilestoneName());
			attributeDataModel.setName(milestoneAttributes.getName());
			attributeDataModel.setValue(milestoneAttributes.getValue());
			attributeDataModel.setDateCreated(getDate());
			milestoneAttributesDataModelList.add(attributeDataModel);
		}
		return milestoneAttributesDataModelList;
		
	}

	private MilestoneABIpAssignDataModel populateSbc(List<MilestoneAttributes> attributeList,
			MilestoneMinorDataModel milestoneMinorDataModel) {
		
		MilestoneABIpAssignDataModel milestoneABIpAssignDataModel = new MilestoneABIpAssignDataModel();
		
		milestoneABIpAssignDataModel.setDateCreated(getDate());
		milestoneABIpAssignDataModel.setSbcMilestoneMinorDataModel(milestoneMinorDataModel);
		
		for (MilestoneAttributes milestoneAttrib : attributeList) {
			
			switch (milestoneAttrib.getName()) {
			case "SCB Name":
				milestoneABIpAssignDataModel.setSbcName(milestoneAttrib.getValue());
				break;
			case "SBC City":
				milestoneABIpAssignDataModel.setSbcCity(milestoneAttrib.getValue());
				break;
			case "State":
				milestoneABIpAssignDataModel.setState(milestoneAttrib.getValue());
				break;
			case "Address":
				milestoneABIpAssignDataModel.setAddress(milestoneAttrib.getValue());
				break;
			case "Node":
				milestoneABIpAssignDataModel.setNode(milestoneAttrib.getValue());
				break;
			case "AB CLLI":
				milestoneABIpAssignDataModel.setABClli(milestoneAttrib.getValue());
				break;
			case "AB Psuedo NPA/NXX":
				milestoneABIpAssignDataModel.setABPsuedo(milestoneAttrib.getValue());
				break;
			case "Host Name":
				milestoneABIpAssignDataModel.setHostName(milestoneAttrib.getValue());
				break;
			case "IP Address":
				milestoneABIpAssignDataModel.setIpAddress(milestoneAttrib.getValue());
				break;
			case "IP Subnet":
				milestoneABIpAssignDataModel.setIpSubnet(milestoneAttrib.getValue());
				break;
			case "Concurrent Call Limit":
				milestoneABIpAssignDataModel.setConcurrentCallLimit(milestoneAttrib.getValue());
				break;
			case "Calls Per Second":
				milestoneABIpAssignDataModel.setCallsPerSecond(milestoneAttrib.getValue());
				break;
			default:
				break;
			}
		}
		return milestoneABIpAssignDataModel;
	}

	private List<MilestoneMaintenanceAni> populateMaintainanceAni(List<MilestoneAttributes> attributeList,
			MilestoneMinorDataModel milestoneMinorDataModel) {
		
		List<MilestoneMaintenanceAni> maintenanceAniList = new ArrayList<>();
		for (MilestoneAttributes milestoneAttrib : attributeList) {
			if (!("Type".equalsIgnoreCase(milestoneAttrib.getName()))) {
				MilestoneMaintenanceAni maintenanceAni = new MilestoneMaintenanceAni();
				
				maintenanceAni.setPortNumber(milestoneAttrib.getName());
				maintenanceAni.setPhoneNumber(milestoneAttrib.getValue());
				maintenanceAni.setDateCreated(getDate());
				maintenanceAni.setMtnceAniMilestoneMinorDataModel(milestoneMinorDataModel);
				maintenanceAniList.add(maintenanceAni);
			}
		}
		return maintenanceAniList;
	}

	private List<MilestoneTestNumbersDataModel> populateTestNumbers(List<MilestoneAttributes> attributeList,
			MilestoneMinorDataModel milestoneMinorDataModel) {
		
		List<MilestoneTestNumbersDataModel> testNumbersList = new ArrayList<>();
		for (MilestoneAttributes milestoneAttrib : attributeList) {
			if (!("Type".equalsIgnoreCase(milestoneAttrib.getName()))) {
				MilestoneTestNumbersDataModel milestoneTestNumbersDataModel = new MilestoneTestNumbersDataModel();
				
				milestoneTestNumbersDataModel.setDateCreated(getDate());
				milestoneTestNumbersDataModel.setTestNumbersMilestoneMinorDataModel(milestoneMinorDataModel);
				milestoneTestNumbersDataModel.setTestNumbers(milestoneAttrib.getValue());
				testNumbersList.add(milestoneTestNumbersDataModel);
			}
		}
		return testNumbersList;
	}

	private MilestoneSipSourceIpDataModel populateSipSourceIp(List<MilestoneAttributes> attributeList,
			MilestoneMinorDataModel milestoneMinorDataModel) {
		
		MilestoneSipSourceIpDataModel milestoneSipSourceIpDataModel = new MilestoneSipSourceIpDataModel();
		
		milestoneSipSourceIpDataModel.setDateCreated(getDate());
		milestoneSipSourceIpDataModel.setSipIpDataMilestoneMinorDataModel(milestoneMinorDataModel);
		
		for (MilestoneAttributes milestoneAttrib : attributeList) {
			
			switch (milestoneAttrib.getName()) {
			case "Service Type":
				milestoneSipSourceIpDataModel.setServiceType(milestoneAttrib.getValue());
				break;
			case "Header method to be used with service":
				milestoneSipSourceIpDataModel.setHeaderMethod(milestoneAttrib.getValue());
				break;
			case "IP Address":
				milestoneSipSourceIpDataModel.setIpAddress(milestoneAttrib.getValue());
				break;
			case "Service Location IP":
				milestoneSipSourceIpDataModel.setServiceLocationIp(milestoneAttrib.getValue());
				break;
			case "NPA/NXX":
				milestoneSipSourceIpDataModel.setNpaNxx(milestoneAttrib.getValue());
				break;
			case "SIP Concurrent Limit":
				milestoneSipSourceIpDataModel.setSipConcurrentLimit(milestoneAttrib.getValue());
				break;
			default:
				break;
			}
		}
		return milestoneSipSourceIpDataModel;
	}

	private MilestoneVoiceTestDataModel populateTestData(List<MilestoneAttributes> attributeList,
			MilestoneMinorDataModel milestoneMinorDataModel) {
		
		MilestoneVoiceTestDataModel milestoneVoiceTestDataModel = new MilestoneVoiceTestDataModel();
		
		milestoneVoiceTestDataModel.setDateCreated(getDate());
		milestoneVoiceTestDataModel.setTestDataMilestoneMinorDataModel(milestoneMinorDataModel);
		
		for (MilestoneAttributes milestoneAttrib : attributeList) {
			
			switch (milestoneAttrib.getName()) {
			case "Actual Test Date":
				milestoneVoiceTestDataModel.setActualTestDate(milestoneAttrib.getValue());
				break;
			case "Passed":
				milestoneVoiceTestDataModel.setPassed(milestoneAttrib.getValue());
				break;
			default:
				break;
			}
		}
		return milestoneVoiceTestDataModel;
	}

	private MilestoneIpSecDataModel populateIpSecData(List<MilestoneAttributes> attributeList, MilestoneMinorDataModel milestoneMinorDataModel) {
		
		MilestoneIpSecDataModel milestoneIpSecDataModel = new MilestoneIpSecDataModel();
		
		milestoneIpSecDataModel.setDateCreated(getDate());
		milestoneIpSecDataModel.setIpSecMilestoneMinorDataModel(milestoneMinorDataModel);
		
		for (MilestoneAttributes milestoneAttrib : attributeList) {
			
			switch (milestoneAttrib.getName()) {
			case "IKE":
				milestoneIpSecDataModel.setIke(milestoneAttrib.getValue());
				break;
			case "SIP":
				milestoneIpSecDataModel.setSip(milestoneAttrib.getValue());
				break;
			case "Preshare Key":
				milestoneIpSecDataModel.setPreshareKey(milestoneAttrib.getValue());
				break;
			case "Sub Mask":
				milestoneIpSecDataModel.setSubMask(milestoneAttrib.getValue());
				break;
			default:
				break;
			}
		}
		
		return milestoneIpSecDataModel;
	}

	private Date convertDate(String dateString) { 
		
		final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		Calendar cal = new GregorianCalendar();
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            Date d = df.parse(dateString);
	            cal.setTime(d);;
	        } catch (ParseException e) {
	        }
	        return cal.getTime();
	}

	private List<String> getAttributeNames(List<MilestoneAttributes> attributeList) {
	
		if (attributeList != null) {
			return attributeList.stream().map(MilestoneAttributes::getName).collect(Collectors.toList());
		}
		return new ArrayList<String>();
	}
}
