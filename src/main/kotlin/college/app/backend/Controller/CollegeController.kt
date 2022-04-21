package college.app.backend.Controller

import college.app.backend.Service.CollegeService
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
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
    fun addCollege(@RequestBody college: String): College{
        val springParser = JsonParserFactory.getJsonParser()
        var body = springParser.parseMap(college)
        return service.addCollege(body)
    }
}