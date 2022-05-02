package college.app.backend.Service

import college.app.backend.Repository.ApplicantReviewRepository
import college.app.backend.Repository.CollegeRepository
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CollegeService {

    @Autowired
    lateinit var collegeRepository: CollegeRepository

    @Autowired
    lateinit var applicantReviewRepository: ApplicantReviewRepository

    fun getColleges(): List<College> {
        return collegeRepository.findAll()
    }

    fun getCollegeInfoAndApplications(collegeName: String): ResponseEntity<List<Any>> {
        val collegeData = collegeRepository.findCollegeByCollegeName(collegeName)
        val collegeId = collegeData.collegeId ?: throw NullPointerException("College ID was null")
        val collegeApplicants = applicantReviewRepository.findApplicationsByCollegeCollegeId(collegeId!!)
        val body = listOf(collegeData, collegeApplicants)
        return ResponseEntity(body, HttpStatus.OK)
    }

    fun getCollegeByCollegeName(collegeName: String): College {
        return collegeRepository.findCollegeByCollegeName(collegeName);
    }

}