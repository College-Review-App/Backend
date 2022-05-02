package college.app.backend.Service

import college.app.backend.Interfaces.ReviewDetails
import college.app.backend.Repository.ApplicantReviewRepository
import college.app.backend.classes.ApplicantReview
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ApplicantReviewService {

    @Autowired
    lateinit var repository: ApplicantReviewRepository

    fun getApplications(): List<ApplicantReview> {
        return repository.findAll()
    }

//    fun findAllReviewDetails(): List<ReviewDetails> {
//        return repository.findAllBy()
//    }

    fun findAllReviewDetails(): ResponseEntity<List<Any>> {
        val body = Arrays.asList(repository.findAllBy(), repository.findAllBy())
        return ResponseEntity(body, HttpStatus.OK)
//        return repository.findAllBy()
    }

    fun findApplicationsByCollegeId(id: Int): List<ApplicantReview> {
        return repository.findApplicationsByCollegeCollegeId(id);
    }
}
