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
    private static Long staticFeedbackFormID = 1L;

    @JmsListener(destination = "FormQueue", containerFactory = "myFactory")
    public void receiveMessage(SentFeedbackForm sentFeedbackForm) {
        sentFeedbackForm.setFeedbackID(staticFeedbackFormID);
        staticFeedbackFormID+=1;
        repo.save(sentFeedbackForm);
    }

}