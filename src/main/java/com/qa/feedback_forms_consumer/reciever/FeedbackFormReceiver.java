package com.qa.feedback_forms_consumer.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.FeedbackFormSubmit.persistence.domain.SentFeedbackForm;
import com.qa.feedback_forms_consumer.persistence.repository.MongoFeedbackFormRepo;

@Component
public class FeedbackFormReceiver {

    @Autowired
    private MongoFeedbackFormRepo repo;

    @JmsListener(destination = "FormQueue", containerFactory = "myFactory")
    public void receiveMessage(SentFeedbackForm sentFeedbackForm) {
    	
		if (repo.count() < 1) {
			sentFeedbackForm.setFeedbackID(1L);
		} else {
			sentFeedbackForm.setFeedbackID(repo.findTopByOrderByFeedbackIDDesc().getFeedbackID() + 1);
		}
		repo.save(sentFeedbackForm);
	}
}