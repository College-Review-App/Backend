package college.app.backend.Repository

import college.app.backend.Interfaces.CollegeDetails
import college.app.backend.classes.College
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CollegeRepository: JpaRepository<College, Int> {

    fun findAllBy(): List<CollegeDetails>

    // Returns data for a specific college by the college name
    fun findCollegeByCollegeName(collegeName: String): College

}