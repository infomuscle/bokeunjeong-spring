package com.bokeunjeong.portfolio.kafka.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture
import java.util.*
import javax.websocket.SendResult

@Service
class MailKafkaProducer {

//    var prop: Properties = Properties()
//    lateinit var producer: KafkaProducer<String, String>
//
//
//    init {
//        prop.put("bootstrap.servers", "localhost:9092");
//        prop.put("acks", "all");
//        prop.put("block.on.buffer.full", "true");
//        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        producer = KafkaProducer<String, String>(prop)
//    }
//
//    fun produce(topic: String, msg: String): String {
//
//        this.sendMessageAsync(topic, msg)
//
//        return msg
//    }
//
//    private fun sendMessageAsync(topic: String, msg: String): String {
//
//        var record: ProducerRecord<String, String> = ProducerRecord<String, String>(topic, msg)
////        var future: ListenableFuture<SendResult<String, String>>
//        producer.send(record)
//
//        return msg;
//    }
}

