package com.mytech.applicationonboarding.service;

import com.mytech.producer.KafkaProducerConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
* Remember to start Kafka server and listener to see the message sent by the unit test code.
* */
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = KafkaProducerConfig.class)
@SpringBootTest
public class ManageCaseServiceTests {
    @Autowired
    ManageCaseService manageCaseService;

    @Test
    public void shouldSendCaseNewObjectToKafka(){
        manageCaseService.sendCaseNewToKafka();
    }
}
