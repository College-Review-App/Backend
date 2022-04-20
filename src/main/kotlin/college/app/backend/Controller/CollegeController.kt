package college.app.backend.Controller

import college.app.backend.Service.CollegeService
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.GsonJsonParser
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
    @PostMapping("/add-college")
    fun addCollege(@RequestBody college: String): College {
        var collegeName = college.substring(17, college.indexOf(',') - 1)
        var gpa = college.substring(college.indexOf(',') + 7, college.length - 1)
        return service.addCollege(collegeName, gpa.toFloat())
    }
}