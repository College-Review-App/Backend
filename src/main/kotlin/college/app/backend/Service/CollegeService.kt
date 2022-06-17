package college.app.backend.Service

import college.app.backend.Interfaces.CollegeDetails
import college.app.backend.Repository.ApplicantProfileRepository
import college.app.backend.Repository.CollegeRepository
import college.app.backend.classes.College
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CollegeService {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var collegeRepository: CollegeRepository

    @Autowired
    lateinit var applicantProfileRepository: ApplicantProfileRepository

    // Gets all colleges in the database
    fun getColleges(): List<CollegeDetails> {
        return collegeRepository.findAllBy()
    }

    // Takes the name of the college, and gets the college information from that name
    // and all the applications for that college. It then combines these two points of
    // data into one JSON object and returns it.
    fun getCollegeInfoAndApplications(collegeName: String): ResponseEntity<List<Any>> {
        val collegeData = collegeRepository.findCollegeByCollegeName(collegeName)
        var collegeId: Int = -1;
        if (collegeData.collegeId == null) {
            logger.error("College ID was null")
            throw NullPointerException("College ID was null")
        } else {
            collegeId = collegeData.collegeId!!;
        }
        val collegeApplicants = applicantProfileRepository.findApplicationsByCollegeCollegeId(collegeId)
        val body = listOf(collegeData, collegeApplicants)
        return ResponseEntity(body, HttpStatus.OK)
    }

    // Calls the method to get a college's info from its name
    fun getCollegeByCollegeName(collegeName: String): College {
        return collegeRepository.findCollegeByCollegeName(collegeName);
    }

    fun addRequestedCollegeToCollegeDB(collegeInfo: Map<String, Any>): College {
        val collegeName: String = collegeInfo["collegeName"] as String;
        val location: String = collegeInfo["location"] as String;
        val image: String = collegeInfo["image"] as String;
        val acceptanceRate: Int = collegeInfo["acceptanceRate"] as Int;
        val ranking: Int = collegeInfo["ranking"] as Int;
        return collegeRepository.save(College(null, collegeName, location, image, acceptanceRate, ranking));
    }

}