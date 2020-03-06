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

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.suman.rnd.CommonTestService.db.model.MilestoneAttributesDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneCircuitsDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneErrorDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneMajorDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneMinorDataModel;
import com.suman.rnd.CommonTestService.db.model.MilestoneVlanDataModel;
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
public class ConvertObjects {

	static Date getDate() {
		return new Date();
	}
	
	public MilestoneMajorDataModel convertObjectModelToDataModel(MilestoneMajorObjectModel milestoneMajorObjectModel) {
		
		MilestoneMajorDataModel milestoneMajorDataModel = new MilestoneMajorDataModel();
		milestoneMajorDataModel.setMessageId(milestoneMajorObjectModel.getMessageId());
		milestoneMajorDataModel.setCustomerId(milestoneMajorObjectModel.getCustomerId());
		milestoneMajorDataModel.setOrderId(milestoneMajorObjectModel.getOrderId());
		milestoneMajorDataModel.setOrderDate(convertDate(milestoneMajorObjectModel.getOrderDate()));
		milestoneMajorDataModel.setMajorMilestoneName(milestoneMajorObjectModel.getOrderStatus());
		milestoneMajorDataModel.setPon(milestoneMajorObjectModel.getPon());
		milestoneMajorDataModel.setOrderType(milestoneMajorObjectModel.getOrderType());
		milestoneMajorDataModel.setProductName(milestoneMajorObjectModel.getProductName());
		milestoneMajorDataModel.setBillingAccount(milestoneMajorObjectModel.getBillingAccount());
		MilestoneMinorObjectModel milestoneMinorObjectModel= milestoneMajorObjectModel.getOrderMilestoneInfo().get(0);
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
		
		
		if (milestoneAttributeList != null) {
			List<MilestoneErrorDataModel> errorsDataModelList = new ArrayList<>();
			List<MilestoneCircuitsDataModel> circuitAttribList = new ArrayList<>();
			List<List<MilestoneAttributesDataModel>> milestoneAttributeDbList = new ArrayList<>();
			milestoneMinorDataModel.setAttributesList(milestoneAttributeDbList);
			for (List<MilestoneAttributes> attributeList : milestoneAttributeList) {
				List<String> attributeNames = getAttributeNames(attributeList);
				if (attributeNames.stream().anyMatch("Service Order Id"::equalsIgnoreCase)) {
					String serviceOrderId = attributeList.stream().filter(attribute -> "Service Order Id".equalsIgnoreCase(attribute.getName()))
							.map(attribute -> attribute.getValue()).collect(Collectors.joining());
					attributeList.removeIf(attribute -> "Service Order Id".equalsIgnoreCase(attribute.getName()));
					List<MilestoneAttributesDataModel> attributeDataModel = populateAttributes(attributeList, milestoneMajorDataModel, serviceOrderId);
					milestoneAttributeDbList.add(attributeDataModel);
				} else if (attributeNames.stream().anyMatch("Type"::equalsIgnoreCase)) {
					String typeValue = attributeList.stream().filter(attribute -> "Type".equalsIgnoreCase(attribute.getName()))
							.map(attribute -> attribute.getValue()).collect(Collectors.joining());
					switch (typeValue) {
						case "Error":
							MilestoneErrorDataModel errorsDataModel = populateErrorAttribs(attributeList, milestoneMinorDataModel);
							errorsDataModelList.add(errorsDataModel);
							break;
						case "EVC":
							MilestoneCircuitsDataModel circuitsDataModelEvc = populateCircuitAttribs(attributeList, milestoneMinorDataModel);
							circuitAttribList.add(circuitsDataModelEvc);
							break;
						case "UNI":
							MilestoneCircuitsDataModel circuitsDataModelUni = populateCircuitAttribs(attributeList, milestoneMinorDataModel);
							circuitAttribList.add(circuitsDataModelUni);
							break;
						case "vlan":
							attributeList.removeIf(attribute -> "Type".equalsIgnoreCase(attribute.getName()));
							for (MilestoneCircuitsDataModel circuitAttrib : circuitAttribList) {
								if ("EVC".equalsIgnoreCase(circuitAttrib.getCircuitType())) {
									List<MilestoneVlanDataModel> vlanDataModelList = populateVlanAttribs(attributeList, circuitAttrib);
									circuitAttrib.setVlanDataModelList(vlanDataModelList);
								}
							}
							break;
						default:
							break;
					}
					
					
				} else {
					List<MilestoneAttributesDataModel> attributeDataModel = populateAttributes(attributeList, milestoneMajorDataModel, null);
					milestoneAttributeDbList.add(attributeDataModel);
				}
			}
			if (errorsDataModelList.size() > 0) {
				milestoneMinorDataModel.setMilestoneErrorDataModel(errorsDataModelList);
			}
			if (circuitAttribList.size() > 0) {
				milestoneMinorDataModel.setMilestoneCircuitDataList(circuitAttribList);
			}
		}
		
		
		return milestoneMajorDataModel;
	}
	
	private List<MilestoneVlanDataModel> populateVlanAttribs(List<MilestoneAttributes> attributeList,
			MilestoneCircuitsDataModel circuitAttrib) {
		
		List<MilestoneVlanDataModel> vlanDataModelList = new ArrayList<>();
		
		for (int i = 0; i < attributeList.size(); i+=2) {
			MilestoneVlanDataModel vlanDataModel = new MilestoneVlanDataModel();
			vlanDataModel.setVlanStart(attributeList.get(i).getValue());
			vlanDataModel.setVlanEnd(attributeList.get(i+1).getValue());
			vlanDataModel.setDateCreated(getDate());
			vlanDataModel.setMilestoneCctDataModel(circuitAttrib);
			vlanDataModelList.add(vlanDataModel);
		}
		
		return vlanDataModelList;
	}

	private MilestoneErrorDataModel populateErrorAttribs(List<MilestoneAttributes> attributeList, MilestoneMinorDataModel milestoneMinorDataModel) {
		
		Date recordCreationDate = new Date();
		MilestoneErrorDataModel errorDataModel = new MilestoneErrorDataModel();
		for (MilestoneAttributes errorAttribute : attributeList) {
			if ("Customer Action".equalsIgnoreCase(errorAttribute.getName())) {
				errorDataModel.setSupIndicator(errorAttribute.getValue());
			} else if ("Error Description".equalsIgnoreCase(errorAttribute.getName())) {
				errorDataModel.setErrorDescription(errorAttribute.getValue());
				errorDataModel.setErrorCode(errorAttribute.getValue().substring(0, errorAttribute.getValue().indexOf("-")).trim());
			}
		}
		errorDataModel.setDateCreated(recordCreationDate);
		errorDataModel.setErrMilestoneMinorDataModel(milestoneMinorDataModel);
		return errorDataModel;
	}

	private MilestoneCircuitsDataModel populateCircuitAttribs(List<MilestoneAttributes> attributeList, MilestoneMinorDataModel milestoneMinorDataModel) {
		Date recordCreationDate = new Date();
		
		MilestoneCircuitsDataModel circuitDataModel = new MilestoneCircuitsDataModel();
		for (MilestoneAttributes circuitAttribute : attributeList) {
			if ("Type".equalsIgnoreCase(circuitAttribute.getName())) {
				circuitDataModel.setCircuitType(circuitAttribute.getValue());
			} else if ("Circuit Id".equalsIgnoreCase(circuitAttribute.getName())) {
				circuitDataModel.setCircuitId(circuitAttribute.getValue());
			} else if ("Customer Circuit Id".equalsIgnoreCase(circuitAttribute.getName())) {
				circuitDataModel.setCustomerCctId(circuitAttribute.getValue());
			} else if("Service Order".equalsIgnoreCase(circuitAttribute.getValue()));
		}
		circuitDataModel.setDateCreated(recordCreationDate);
		circuitDataModel.setCctMilestoneMinorDataModel(milestoneMinorDataModel);
		return circuitDataModel;
	}

	private List<MilestoneAttributesDataModel> populateAttributes(List<MilestoneAttributes> attributeList, 
			MilestoneMajorDataModel milestoneMajorDataModel, String serviceOrderId) {
		
		List<MilestoneAttributesDataModel> milestoneAttributesDataModelList = new ArrayList<>();
		for (MilestoneAttributes milestoneAttributes : attributeList) {
			MilestoneAttributesDataModel attributeDataModel = new MilestoneAttributesDataModel();
			attributeDataModel.setMajorMilestone(milestoneMajorDataModel.getMajorMilestoneName());
			attributeDataModel.setOrderId(milestoneMajorDataModel.getOrderId());
			attributeDataModel.setServiceOrderId(serviceOrderId);
			attributeDataModel.setMinorMilestone(milestoneMajorDataModel.getMinorMilestoneDataList().get(0).getMinorMilestoneName());
			attributeDataModel.setName(milestoneAttributes.getName());
			attributeDataModel.setValue(milestoneAttributes.getValue());
			attributeDataModel.setDateCreated(getDate());
			milestoneAttributesDataModelList.add(attributeDataModel);
		}
		return milestoneAttributesDataModelList;
	}

	private List<String> getAttributeNames(List<MilestoneAttributes> attributeList) {
		
		if (attributeList != null) {
			return attributeList.stream().map(MilestoneAttributes::getName).collect(Collectors.toList());
		}
		return new ArrayList<String>();
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
}
