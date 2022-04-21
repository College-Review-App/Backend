package college.app.backend.Controller

import college.app.backend.Service.ApplicationService
import college.app.backend.classes.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class ApplicationController {

    @Autowired
    lateinit var service: ApplicationService

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/get-applications")
    fun getApplications(): List<Application> {
        return service.getApplications()
    }

}