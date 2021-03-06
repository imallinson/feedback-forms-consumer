package com.qa.feedback_forms_consumer.persistence.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.feedback_forms_accounts.persistence.domain.SentAccount;

@Repository
public interface MongoAccountRepo  extends MongoRepository<SentAccount, Long>{
	
	SentAccount findTopByOrderByAccountIDDesc();
	
}
