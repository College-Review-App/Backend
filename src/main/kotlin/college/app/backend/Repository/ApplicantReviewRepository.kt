package college.app.backend.Repository

import college.app.backend.Interfaces.ReviewDetails
import college.app.backend.classes.ApplicantReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ApplicantReviewRepository: JpaRepository<ApplicantReview, Int> {

    // Lists all the applications for a specific college, by college ID
    fun findApplicationsByCollegeCollegeId(college: Int): List<ReviewDetails>

}
