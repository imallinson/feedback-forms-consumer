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
    
    @JmsListener(destination = "CohortQueue", containerFactory = "myFactory")
    public void receiveMessage(SentCohort sentCohort) {
    	
		if (repo.count() < 1) {
	    	sentCohort.setCohortID( 1L);
		} else {
			sentCohort.setCohortID(repo.findTopByOrderByCohortIDDesc().getCohortID() + 1);
		}
		repo.save(sentCohort);
	}

}
