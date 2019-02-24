package com.qa.feedback_forms_consumer.persistence.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.feedback_forms_accounts.persistence.domain.SentAccount;

@Repository
public interface MongoAccountRepo  extends MongoRepository<SentAccount, ObjectId>{

}
