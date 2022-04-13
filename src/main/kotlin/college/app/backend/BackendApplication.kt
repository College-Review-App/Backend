package college.app.backend

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// TODO: Add Database
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class BackendApplication

fun main(args: Array<String>) {
	runApplication<BackendApplication>(*args)
}

// https://medium.com/@tcbasche/cors-in-spring-boot-with-kotlin-55eb5385f0e
// Handle CORS headers for requests
// Temp Solution: Define allowed origins

@RestController
class MessageResource {
	@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
	@GetMapping
	fun index(): List<Message> = listOf(
			Message("1", "Hello"),
			Message("2", "Goodbye")
	)
}

data class Message(val id: String, val text: String)
