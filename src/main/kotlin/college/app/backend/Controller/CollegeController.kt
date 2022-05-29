package college.app.backend.Controller

import college.app.backend.Service.CollegeService
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class CollegeController {

    @Autowired
    lateinit var service: CollegeService

    // API to return all the colleges in the database
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/get-colleges")
    fun getColleges(): List<College> {
        return service.getColleges()
    }

    // API that takes a college name, and returns the college info and applications
    // for that college
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/get-college-and-applications-from-college-name")
    fun getCollegesAndApplications(@RequestParam collegeName: String): ResponseEntity<List<Any>> {
        return service.getCollegeInfoAndApplications(collegeName)
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/add-requested-college-to-college-db")
    fun addRequestedCollegeToCollegeDB(@RequestBody college: String): College {
        val springParser = JsonParserFactory.getJsonParser()
        val body = springParser.parseMap(college)
        return service.addRequestedCollegeToCollegeDB(body)
    }

}