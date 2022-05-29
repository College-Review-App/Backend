package college.app.backend.Repository

import college.app.backend.classes.AddCollege
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional;

@Repository
interface AddCollegeRepository: JpaRepository<AddCollege, Int> {

    fun findAddCollegeByCollegeName(collegeName : String): AddCollege

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE addCollege college SET college.collegeCount = :currentCount WHERE college.collegeName = :collegeName",
            nativeQuery = true
    )
    fun updateCollegeCountIfCollegeNameExists(collegeName : String, currentCount : Int) : Unit

}