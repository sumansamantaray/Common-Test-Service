package com.suman.rnd.CommonTestService.repository;

import org.springframework.data.repository.CrudRepository;

import com.suman.rnd.CommonTestService.db.model.MessageMappingDataModel;


public interface MessageMappingRepository extends CrudRepository<MessageMappingDataModel, Long> {

}
