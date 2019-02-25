package com.qa.feedback_forms_consumer.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.feedback_forms_accounts.persistence.domain.SentAccount;
import com.qa.feedbackformscohorts.persistence.domain.SentCohort;

@Repository
public interface MongoCohortRepo extends MongoRepository<SentCohort, Long>{
	
	SentCohort findTopByOrderByCohortIdDesc();


}
