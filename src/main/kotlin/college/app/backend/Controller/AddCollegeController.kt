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

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/add-new-college")
    fun addNewCollege(@RequestParam collegeName: String): AddCollege {
        return service.addNewCollege(collegeName);
    }

}