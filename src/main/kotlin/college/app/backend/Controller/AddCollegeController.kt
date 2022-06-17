package college.app.backend.Controller

import college.app.backend.Service.AddCollegeService
import college.app.backend.classes.AddCollege
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class AddCollegeController {

    @Autowired
    lateinit var service: AddCollegeService

    @CrossOrigin(origins = ["http://localhost:3000", "https://colley.fyi", "www.colley.fyi", "https://colleyapp.com", "www.colleyapp.com"])
    @PostMapping("/add-new-college")
    fun addNewCollege(@RequestBody collegeName: String): AddCollege {
        val springParser = JsonParserFactory.getJsonParser()
        val body = springParser.parseMap(collegeName);
        return service.addNewCollege(body);
    }

    @CrossOrigin(origins = ["http://localhost:3000", "https://colley.fyi", "www.colley.fyi", "https://colleyapp.com", "www.colleyapp.com"])
    @GetMapping("/get-all-requested-colleges")
    fun getAllRequestedColleges(): List<AddCollege> {
        return service.getAllRequestedColleges();
    }

}