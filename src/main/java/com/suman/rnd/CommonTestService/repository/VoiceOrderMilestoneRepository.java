/**
 * 
 */
package com.suman.rnd.CommonTestService.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

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

/**
 * @author samasu5
 *
 */
@Repository
public class VoiceOrderMilestoneRepository {
	
private static final Logger LOGGER = LoggerFactory.getLogger(OrderMilestoneRepository.class);
	
	@PersistenceContext
	EntityManager em;
	
	static Map<String, String> orderMilestoneConfigMap;
	
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	
	@Transactional
	public void insertMilestoneStatus(MilestoneMajorDataModel orderMilestoneData) {

		LOGGER.info("[insertMilestoneStatus] Persisting the order milestone records to DB");
		em.persist(orderMilestoneData);
		for (MilestoneMinorDataModel minorMilestoneDataModel : orderMilestoneData.getMinorMilestoneDataList()) {
			em.persist(minorMilestoneDataModel);
			if (minorMilestoneDataModel.getMilestoneErrorDataModel() != null) {
				for (MilestoneErrorDataModel errorData : minorMilestoneDataModel.getMilestoneErrorDataModel()) {
					em.persist(errorData);
				}
				
			}
			if (minorMilestoneDataModel.getIpSecDataList() != null) {
				for (MilestoneIpSecDataModel ipSeDataModel : minorMilestoneDataModel.getIpSecDataList()) {
					em.persist(ipSeDataModel);
				}
				
			}
			if (minorMilestoneDataModel.getMntanceAniDataList() != null) {
				for (MilestoneMaintenanceAni milestoneMaintenanceAni : minorMilestoneDataModel.getMntanceAniDataList()) {
					em.persist(milestoneMaintenanceAni);
				}
				
			}
			if (minorMilestoneDataModel.getSbcMilestoneDataModel() != null) {
				for (MilestoneABIpAssignDataModel milestoneABIpAssignDataModel : minorMilestoneDataModel.getSbcMilestoneDataModel()) {
					em.persist(milestoneABIpAssignDataModel);
				}
				
			}
			if (minorMilestoneDataModel.getSipSourceIpDataList() != null) {
				for (MilestoneSipSourceIpDataModel milestoneSipSourceIpDataModel : minorMilestoneDataModel.getSipSourceIpDataList()) {
					em.persist(milestoneSipSourceIpDataModel);
				}
				
			}
			if (minorMilestoneDataModel.getTestNumbersDataList() != null) {
				for (MilestoneTestNumbersDataModel milestoneTestNumbersDataModel : minorMilestoneDataModel.getTestNumbersDataList()) {
					em.persist(milestoneTestNumbersDataModel);
				}
				
			}
			if (minorMilestoneDataModel.getVoiceTestDataList() != null) {
				for (MilestoneVoiceTestDataModel milestoneVoiceTestDataModel : minorMilestoneDataModel.getVoiceTestDataList()) {
					em.persist(milestoneVoiceTestDataModel);
				}
				
			}
			
		}
		List<List<MilestoneAttributesDataModel>> milestoneAttribList = orderMilestoneData.getMinorMilestoneDataList().get(0).getAttributesList();
		if (milestoneAttribList != null && milestoneAttribList.size() > 0) {
			updateAttributeTable (orderMilestoneData);
		}
		
	}
	
	public void updateAttributeTable (MilestoneMajorDataModel orderMilestoneData) {
		LOGGER.info("[updateAttributeTable] Insert or Update VSIB_MILESTONE_ATTRIBUTES table.");
		Session session = em.unwrap(Session.class);
		session.doWork(new Work() {
			
			String majorMilestone = orderMilestoneData.getMajorMilestoneName();
	    	String minorMilestone = new ArrayList<>(orderMilestoneData.getMinorMilestoneDataList()).get(0).getMinorMilestoneName();
	    	String orderId = orderMilestoneData.getOrderId();
	    	List<MilestoneAttributesDataModel> orderMileStoneList =	fetchAttributesRecords(majorMilestone, minorMilestone, orderId);
	    	boolean hasRecords = orderMileStoneList.size() > 0? Boolean.TRUE : Boolean.FALSE;

		    @Override
		    public void execute(Connection connection) throws SQLException {
		    	
		    	PreparedStatement stmt = null;
		    	
		    	if (hasRecords) {
		    		LOGGER.info("[updateAttributeTable] Found records in VSIB_MILESTONE_ATTRIBUTES table with major milestone: "+majorMilestone+", minor milestone: "+minorMilestone+" and order id: "+orderId);
		    		stmt = connection.prepareStatement("update VSIB_MILESTONE_ATTRIBUTES set ATTRIBUTE_VALUE = ?, DATE_CREATED = ?"
			    			+ " where ATTRIBUTE_NAME = ? AND ORDER_ID = ? AND MAJOR_MILESTONE = ? AND MINOR_MILESTONE = ? "
			    			+ " AND (SERVICE_ORDER_ID = ? OR SERVICE_ORDER_ID is null)");
		    		LOGGER.info("[updateAttributeTable] Update Attribute value of VSIB_MILESTONE_ATTRIBUTES table.");
		    	} else {
		    		LOGGER.info("[updateAttributeTable] Insert new records to VSIB_MILESTONE_ATTRIBUTES table for major milestone: "+majorMilestone+", minor milestone: "+minorMilestone+" and order id: "+orderId);
		    		stmt = connection.prepareStatement("insert into VSIB_MILESTONE_ATTRIBUTES (MILESTONE_ATTRIBUTE_ID, ATTRIBUTE_VALUE, DATE_CREATED, ATTRIBUTE_NAME,  ORDER_ID, MAJOR_MILESTONE, MINOR_MILESTONE, SERVICE_ORDER_ID) VALUES (VSIB_MILESTONE_ATTRIB_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)");
		    	}

		    	List<MilestoneMinorDataModel> milestoneMinorDataModelList = orderMilestoneData.getMinorMilestoneDataList();
		    	for (MilestoneMinorDataModel milestoneMinorDataModel : milestoneMinorDataModelList) {
		    		for (List<MilestoneAttributesDataModel> milestoneAttribDataList : milestoneMinorDataModel.getAttributesList()) {
		    			for (MilestoneAttributesDataModel milestoneAttribData : milestoneAttribDataList) {
		    				// Update the attributes if it is not null. There is no restriction for insert
			    			if (!(StringUtils.isEmpty(milestoneAttribData.getValue()) && hasRecords)) {
			    				stmt.setString(1, milestoneAttribData.getValue());
				    			stmt.setTimestamp(2, getCurrentTimeStamp());
				    			stmt.setString(3, milestoneAttribData.getName());
						        stmt.setString(4, orderId);
						        stmt.setString(5, majorMilestone);
						        stmt.setString(6, minorMilestone);
						        stmt.setString(7, milestoneAttribData.getServiceOrderId());
						        
						        stmt.addBatch(); // this will just collect the data values
			    			}
		    			}
		    			
		    			
		    		}
		    	}
		    			
			    int[] rowCount = stmt.executeBatch(); // this will actually execute the updates all in one
			    stmt.close();
		    }
		});
		
//		 Connection connection = em.unwrap(Session.class).co // get the DB connection from somewhere
		    
	}
	
	public List<MilestoneAttributesDataModel> fetchAttributesRecords(String majorMilestone, String minorMilestone, String orderId) {
		LOGGER.info("[fetchAttributesRecords] Fetch VSIB_MILESTONE_ATTRIBUTES table with major milestone: "+majorMilestone+", minor milestone: "+minorMilestone+" and order id: "+orderId);
		Query query =  em.createNativeQuery("select * from VSIB_MILESTONE_ATTRIBUTES c where c.ORDER_ID = :orderId and c.MAJOR_MILESTONE = :majorMilestone AND c.MINOR_MILESTONE = :minorMilestone", MilestoneAttributesDataModel.class);
		query.setParameter("orderId", orderId);
		query.setParameter("majorMilestone", majorMilestone);
		query.setParameter("minorMilestone", minorMilestone);
		
		List<MilestoneAttributesDataModel> orderMileStoneList = query.getResultList();
		return orderMileStoneList;
	}

}
