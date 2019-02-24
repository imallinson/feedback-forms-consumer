package com.qa.feedback_forms_consumer.persistence.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.feedbackformscohorts.persistence.domain.SentCohort;

@Repository
public interface MongoCohortRepo extends MongoRepository<SentCohort, ObjectId>{

}
