package college.app.backend.Repository

import college.app.backend.classes.ApplicantReview
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface ApplicantReviewRepository: JpaRepository<ApplicantReview, Int> {
    fun findApplicationsByCollegeCollegeId(college: Int): List<ApplicantReview>

//    @Query(
//            value = "SELECT * FROM applications JOIN colleges ON applications.college_id = colleges.id WHERE colleges.id = :id",
//            nativeQuery = true
//    )
//    fun findByCollegeId(id: Int): List<ApplicantReview>
}
