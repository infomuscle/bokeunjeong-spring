package com.bokeunjeong.portfolio

import com.bokeunjeong.portfolio.kafka.producer.MailKafkaProducer
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PortfolioApplicationTests {

    val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun contextLoads() {
    }

    @Test
    fun testKafkaProduce() {

        var topic = "test"
        var msg = "THIS IS TEST MESSAGE!!!"

        var producer = MailKafkaProducer()
        producer.produce(topic, msg)
        log.info("테스트테스트테스트: {}", msg)

    }

}
