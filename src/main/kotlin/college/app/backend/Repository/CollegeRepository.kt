package college.app.backend.Repository

import college.app.backend.classes.College
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CollegeRepository: JpaRepository<College, Int> {
    @Query(
            value = "SELECT collegeId from colleges WHERE colleges.collegeName = :collegeName LIMIT 1",
            nativeQuery = true
    )
    fun findCollegeIdByCollegeName(collegeName: String): Int

    //returns a college from the database based on the int college id passed in
    fun findCollegeByCollegeId(collegeId: Int): College

}