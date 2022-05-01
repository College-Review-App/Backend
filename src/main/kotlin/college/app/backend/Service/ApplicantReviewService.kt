package college.app.backend.Service

import college.app.backend.Repository.ApplicantReviewRepository
import college.app.backend.classes.ApplicantReview
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApplicantReviewService {

    @Autowired
    lateinit var repository: ApplicantReviewRepository

    fun getApplications(): List<ApplicantReview> {
        return repository.findAll()
    }

    fun findApplicationsByCollegeId(id: Int): List<ApplicantReview> {
        return repository.findApplicationsByCollegeCollegeId(id);
    }
}
