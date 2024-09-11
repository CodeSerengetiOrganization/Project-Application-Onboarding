package com.mytech.applicationonboarding.service;

import com.mytech.producer.KafkaProducerConfig;
import com.mytech.producer.MessageSenderCaseNew;
import io.swagger.client.model.CaseNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Import(KafkaProducerConfig.class)
public class ManageCaseService {

    @Autowired
    MessageSenderCaseNew senderCaseNew;

    private CaseNew caseNew;

    public void sendCaseNewToKafka(){
        caseNew=new CaseNew();  // Initialize the caseNew object
        caseNew.setCaseId(99);
        caseNew.setCaseStatus(CaseNew.CaseStatusEnum.PENDINGDOCUMENT);
        caseNew.setCaseType(CaseNew.CaseTypeEnum.LOD);
        caseNew.setCreatedBy("Perry Stark");
        caseNew.setCreateDate(LocalDateTime.now() );
        caseNew.setModifiedDate(LocalDateTime.now());
        caseNew.setPendingReviewDate(LocalDateTime.now());
        caseNew.setNote("Kafka note");
        senderCaseNew.sendMessageSync(caseNew);
    }
}
/*
* about @Import:
* Use @Import in your service class if you want KafkaProducerConfig to be automatically included without modifying the test class.
* in this way we do not need to add @ContextConfiguration(classes = KafkaProducerConfig.class) on the unit test code.
* */
