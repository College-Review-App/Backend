package college.app.backend.Controller

import college.app.backend.Interfaces.ProfileDetails
import college.app.backend.Service.ApplicantProfileService
import college.app.backend.classes.College
import college.app.backend.Service.CollegeService
import college.app.backend.classes.ApplicantProfile
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParserFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class ApplicantProfileController {

    val logger: Logger = LoggerFactory.getLogger("Applicant Profile Controller")

    @Autowired
    lateinit var applicantProfileService: ApplicantProfileService

    @Autowired
    lateinit var collegeService: CollegeService

    // API to get all applicant reviews in the database
    @CrossOrigin(origins = ["http://localhost:3000", "https://colley.fyi", "www.colley.fyi", "https://colleyapp.com", "www.colleyapp.com"])
    @GetMapping("/get-profiles")
    fun getApplications(): List<ApplicantProfile> {
        return applicantProfileService.getApplications()
    }

    // API that takes a college ID, and returns the applications for that specific college ID.
    @CrossOrigin(origins = ["http://localhost:3000", "https://colley.fyi", "www.colley.fyi", "https://colleyapp.com", "www.colleyapp.com"])
    @GetMapping("/find-profiles-by-college-id")
    fun findApplicationByCollegeId(@RequestParam id: Int): List<ProfileDetails> {
        return applicantProfileService.findApplicationsByCollegeId(id)
    }

    // API that adds a new application
    @CrossOrigin(origins = ["http://localhost:3000", "https://colley.fyi", "www.colley.fyi", "https://colleyapp.com", "www.colleyapp.com"])
    @PostMapping("/add-application-by-college-name")
    fun findApplicationsByCollegeName(@RequestParam collegeName: String, @RequestBody application: String): ApplicantProfile {
        logger.info("Request Body: $application")
        val springParser = JsonParserFactory.getJsonParser()
        val body = springParser.parseMap(application)
        val college = collegeService.getCollegeByCollegeName(collegeName);
        return applicantProfileService.addApplicationsByCollege(body, college);
    }

}