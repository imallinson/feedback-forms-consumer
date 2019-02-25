package com.qa.feedback_forms_consumer.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.FeedbackFormSubmit.persistence.domain.SentFeedbackForm;
import com.qa.feedbackformscohorts.persistence.domain.SentCohort;

@Repository
public interface MongoFeedbackFormRepo extends MongoRepository<SentFeedbackForm, Long> {
	
	SentFeedbackForm findTopByOrderByFeedbackIDDesc();


}
