package college.app.backend.Controller

import college.app.backend.Service.CollegeService
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class CollegeController {

    @Autowired
    lateinit var service: CollegeService

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/get-colleges")
    fun getColleges(): List<College> {
        return service.getColleges()
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/get-college-and-applications-from-college-name")
    fun getColleges(@RequestParam collegeName: String): ResponseEntity<List<Any>> {
        return service.getCollegeInfoAndApplications(collegeName)
    }
}