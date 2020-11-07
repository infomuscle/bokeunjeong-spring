package com.bokeunjeong.portfolio

import com.bokeunjeong.portfolio.dto.PortfolioProjectDto
import com.bokeunjeong.portfolio.dto.PortfolioSkillDto
import com.bokeunjeong.portfolio.service.PortfolioService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PortfolioApplicationTest {

    val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var portfolioService: PortfolioService

    //    @Test
    fun contextLoads() {
    }

    //    @Test
    fun testKafkaProduce() {

        var topic = "test"
        var msg = "THIS IS TEST MESSAGE!!!"

//        var producer = MailKafkaProducer()
//        producer.produce(topic, msg)
        log.info("테스트테스트테스트: {}", msg)
    }

    //    @Test
    fun testJpaSaveProject() {
        var project = PortfolioProjectDto("test6")
        project.category = "test-ctg6"
        project.description = "test-description6"

        portfolioService.saveProject(project)
        log.info("테스트테스트테스트: {}", project.name)
    }

    //    @Test
    fun testJpaSaveSkill() {
        var skill = PortfolioSkillDto("MySQL")
        skill.type = "Database"
        skill.level = "Intermediate"
        skill.logo = "assets/img/logos/mysql.svg"

        portfolioService.saveSkill(skill)
        log.info("테스트테스트테스트: {}", skill.name)

    }
}
