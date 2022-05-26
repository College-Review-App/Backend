package college.app.backend.Repository

import college.app.backend.Interfaces.ProfileDetails
import college.app.backend.classes.ApplicantProfile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ApplicantProfileRepository: JpaRepository<ApplicantProfile, Int> {

    // Lists all the applications for a specific college, by college ID
    fun findApplicationsByCollegeCollegeId(college: Int): List<ProfileDetails>

}
