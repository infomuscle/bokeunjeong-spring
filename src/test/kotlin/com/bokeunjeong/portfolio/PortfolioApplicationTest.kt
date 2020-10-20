package com.bokeunjeong.portfolio

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import com.bokeunjeong.portfolio.kafka.producer.MailKafkaProducer
import com.bokeunjeong.portfolio.service.PortfolioService
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PortfolioApplicationTest {

    val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var portfolioService: PortfolioService

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

//    @Test
    fun testJpaSaveProject() {
        var project = PortfolioProjectDto("test")
        project.name = project.name
        project.description = "test6"

        portfolioService.saveProject(project)
        log.info("테스트테스트테스트: {}", project.name)
    }

    @Test
    fun testJpaSaveSkill() {
        var skill = PortfolioSkillDto("Python")
        skill.skillType = "Language"
        skill.skillLevel = "Advanced"

        portfolioService.saveSkill(skill)
        log.info("테스트테스트테스트: {}", skill.name)

    }
}
