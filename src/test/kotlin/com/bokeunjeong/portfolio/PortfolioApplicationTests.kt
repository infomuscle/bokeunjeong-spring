package com.bokeunjeong.portfolio

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.kafka.producer.MailKafkaProducer
import com.bokeunjeong.portfolio.service.PortfolioProjectService
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan

@SpringBootTest
class PortfolioApplicationTests {

    val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var portfolioProjectService: PortfolioProjectService

    @Test
    fun contextLoads() {
    }

    //    @Test
    fun testKafkaProduce() {

        var topic = "test"
        var msg = "THIS IS TEST MESSAGE!!!"

        var producer = MailKafkaProducer()
        producer.produce(topic, msg)
        log.info("테스트테스트테스트: {}", msg)
    }

    @Test
    fun testJpaSave() {
        var project = PortfolioProjectDto("test")
        project.name = project.name
        project.description = "test6"

        portfolioProjectService.save(project)
        log.info("테스트테스트테스트: {}", project.name)
    }
}
