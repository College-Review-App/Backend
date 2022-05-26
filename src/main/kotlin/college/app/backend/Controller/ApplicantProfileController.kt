package college.app.backend.Controller

import college.app.backend.Interfaces.ProfileDetails
import college.app.backend.Service.ApplicantProfileService
import college.app.backend.classes.College
import college.app.backend.Service.CollegeService
import college.app.backend.classes.ApplicantProfile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class ApplicantProfileController {

    @Autowired
    lateinit var applicantProfileService: ApplicantProfileService

    @Autowired
    lateinit var collegeService: CollegeService

    // API to get all applicant reviews in the database
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/get-profiles")
    fun getApplications(): List<ApplicantProfile> {
        return applicantProfileService.getApplications()
    }

    // API that takes a college ID, and returns the applications for that specific college ID.
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/find-profiles-by-college-id")
    fun findApplicationByCollegeId(@RequestParam id: Int): List<ProfileDetails> {
        return applicantProfileService.findApplicationsByCollegeId(id)
    }

    // API that adds a new application
    @CrossOrigin(origins = ["http://localhost:3000"])
    @PostMapping("/add-application-by-college-name")
    fun findApplicationsByCollegeName(@RequestParam collegeName: String, @RequestBody application: String): ApplicantProfile {
        val springParser = JsonParserFactory.getJsonParser()
        val body = springParser.parseMap(application)
        val college = collegeService.getCollegeByCollegeName(collegeName);
        return applicantProfileService.addApplicationsByCollege(body, college);
    }

}