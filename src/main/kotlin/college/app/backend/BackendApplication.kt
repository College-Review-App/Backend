package college.app.backend

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class BackendApplication

fun main(args: Array<String>) {
    val logger = LoggerFactory.getLogger("Root")
    logger.info("Colley backend running")
    runApplication<BackendApplication>(*args)
}