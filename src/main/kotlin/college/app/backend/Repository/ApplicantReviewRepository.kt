package college.app.backend.Repository

import college.app.backend.Interfaces.ReviewDetails
import college.app.backend.classes.ApplicantReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface ApplicantReviewRepository: JpaRepository<ApplicantReview, Int> {

    fun findApplicationsByCollegeCollegeId(college: Int): List<ReviewDetails>

}
