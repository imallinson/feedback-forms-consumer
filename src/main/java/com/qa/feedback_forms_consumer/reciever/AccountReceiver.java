package com.qa.feedback_forms_consumer.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.feedback_forms_accounts.persistence.domain.SentAccount;
import com.qa.feedback_forms_consumer.persistence.repository.MongoAccountRepo;



@Component
public class AccountReceiver {
	
    @Autowired
    private MongoAccountRepo repo;

    @JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
    public void receiveMessage(SentAccount sentAccount) {
        repo.save(sentAccount);
    }

}
