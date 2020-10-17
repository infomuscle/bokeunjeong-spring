package com.bokeunjeong.portfolio.kafka.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@EnableKafka
@Configuration
class KafkaConsumerConfiguration {

    fun consumerFactory(groupId: String): ConsumerFactory<String, String> {
        var props = HashMap<String, Any>()

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId)
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)

        return DefaultKafkaConsumerFactory<String, String>(props)
    }

    fun kafkaListnerContainerFactory(groupId: String): ConcurrentKafkaListenerContainerFactory<String, String> {
        var factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = consumerFactory(groupId)

        return factory
    }

    @Bean
    fun testKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        return kafkaListnerContainerFactory("test")
    }

}