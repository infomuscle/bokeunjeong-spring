package com.bokeunjeong.portfolio.kafka.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class MailKafkaConsumer {

    val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["test"], groupId = "test", containerFactory = "testKafkaListenerContainerFactory")
    fun consumeMailTopic(msg: String) {

        log.info("된다된다 컨슈머")

        // send email 로직

    }

}