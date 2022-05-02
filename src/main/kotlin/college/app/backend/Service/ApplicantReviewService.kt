package college.app.backend.Service

import college.app.backend.Interfaces.ReviewDetails
import college.app.backend.Repository.ApplicantReviewRepository
import college.app.backend.classes.ApplicantReview
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Service
class ApplicantReviewService {

    @Autowired
    lateinit var repository: ApplicantReviewRepository

    fun getApplications(): List<ApplicantReview> {
        return repository.findAll()
    }

    fun findApplicationsByCollegeId(id: Int): List<ReviewDetails> {
        return repository.findApplicationsByCollegeCollegeId(id);
    }

    fun addApplicationsByCollege(applicationInfo: Map<String, Any>, college: College): ApplicantReview {
        val currDate = LocalDateTime.now();
        val city: String = applicationInfo["city"] as String;
        val state: String = applicationInfo["state"] as String;
        val country: String = applicationInfo["country"] as String;
        val race: String = applicationInfo["race"] as String;
        val gender: Int = applicationInfo["gender"] as Int;
        val familyIncome: Int = applicationInfo["familyIncome"] as Int;
        val highschool: String = applicationInfo["highschool"] as String;
        val GPA: Float = applicationInfo["GPA"] as Float;
        val SAT: Int = applicationInfo["SAT"] as Int;
        val ACT: Int = applicationInfo["ACT"] as Int;
        val intendedMajor: String = applicationInfo["intendedMajor"] as String;
        val extracurriculars: String = applicationInfo["extracurriculars"] as String;
        val advice: String = applicationInfo["advice"] as String;
        val outcome: Int = applicationInfo["outcome"] as Int;
        val isVerified: Boolean = applicationInfo["isVerified"] as Boolean;
        return repository.save(ApplicantReview(null, college, currDate ,city, state, country, race, gender, familyIncome, highschool, GPA, SAT, ACT, intendedMajor, extracurriculars, advice, 0, outcome, isVerified));
    }

}
