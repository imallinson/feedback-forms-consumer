package com.qa.feedback_forms_consumer.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.feedback_forms_consumer.persistence.repository.MongoCohortRepo;
import com.qa.feedbackformscohorts.persistence.domain.SentCohort;

@Component
public class CohortReceiver {
	
    @Autowired
    private MongoCohortRepo repo;
    
    private static Long staticCohortID = 1L;
    
    @JmsListener(destination = "CohortQueue", containerFactory = "myFactory")
    public void receiveMessage(SentCohort sentCohort) {
    	sentCohort.setCohortId(staticCohortID);
    	staticCohortID+=1;
        repo.save(sentCohort);
    }

}