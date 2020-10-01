package com.bokeunjeong.portfolio.kafka.consumer

import org.springframework.kafka.annotation.KafkaListener

class MailKafkaConsumer {

//    @KafkaListener
    fun consumeMailTopic(msg: String) {

        // send email 로직

    }

}