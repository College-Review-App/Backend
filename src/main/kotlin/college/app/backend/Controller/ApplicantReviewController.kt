package college.app.backend.Controller

import college.app.backend.Interfaces.ReviewDetails
import college.app.backend.Service.ApplicantReviewService
import college.app.backend.classes.College
import college.app.backend.Service.CollegeService
import college.app.backend.classes.ApplicantReview
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class ApplicantReviewController {

    @Autowired
    lateinit var service: ApplicantReviewService

    @Autowired
    lateinit var collegeService: CollegeService

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/get-applications")
    fun getApplications(): List<ApplicantReview> {
        return service.getApplications()
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/find-applications-by-college-id")
    fun findApplicationByCollegeId(@RequestParam id: Int): List<ReviewDetails> {
        return service.findApplicationsByCollegeId(id)
    }
//
//    @CrossOrigin(origins = ["http://localhost:3000"])
//    @GetMapping("/find-applications-by-college-name")
//    fun findApplicationsByCollegeName(@RequestParam collegeName: String): List<ApplicantReview> {
//        print(collegeName);
//        var id = collegeService.getCollegeIdByCollegeName(collegeName);
//        print(id);
//        return service.findApplicationsByCollegeId(id);
//    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/add-applications-by-college-name")
    fun findApplicationsByCollegeName(@RequestParam collegeName: String, @RequestBody application: String): ApplicantReview {
        val springParser = JsonParserFactory.getJsonParser()
        val body = springParser.parseMap(application)
        val college = collegeService.getCollegeByCollegeName(collegeName);
        return service.addApplicationsByCollege(body, college);
    }

}