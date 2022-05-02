package college.app.backend.Repository

import college.app.backend.classes.College
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CollegeRepository: JpaRepository<College, Int> {

    fun findCollegeByCollegeName(collegeName: String): College

}