package college.app.backend.Controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class HealthCheckController {

    @GetMapping("/health-check")
    @CrossOrigin(origins = ["http://localhost:3000", "https://colley.fyi", "www.colley.fyi", "https://colleyapp.com", "www.colleyapp.com"])
    fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity.ok().build()
    }
}