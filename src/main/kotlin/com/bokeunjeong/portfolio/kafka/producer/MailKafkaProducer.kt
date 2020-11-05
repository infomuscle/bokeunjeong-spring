package com.bokeunjeong.portfolio.kafka.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Service
import java.util.*

@Service
class MailKafkaProducer {

    var props: Properties = Properties()
    lateinit var producer: KafkaProducer<String, String>


    init {
        props.put("bootstrap.servers", "kafka:9092");
//        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("block.on.buffer.full", "true");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = KafkaProducer<String, String>(props)
    }

    fun produce(topic: String, msg: String): String {

        this.sendMessageAsync(topic, msg)

        return msg
    }

    private fun sendMessageAsync(topic: String, msg: String): String {

        var record: ProducerRecord<String, String> = ProducerRecord<String, String>(topic, msg)
//        var future: ListenableFuture<SendResult<String, String>>
        producer.send(record)

        return msg;
    }
}

