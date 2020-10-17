package com.bokeunjeong.portfolio.kafka.consumer

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class MailKafkaConsumer {

    @KafkaListener(topics = ["test"], groupId = "test", containerFactory = "testKafkaListenerContainerFactory")
    fun consumeMailTopic(msg: String) {


        println("된다된다 컨슈머")

        // send email 로직

    }

}