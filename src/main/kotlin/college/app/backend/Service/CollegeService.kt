package college.app.backend.Service

import college.app.backend.Repository.CollegeRepository
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeService {

    @Autowired
    lateinit var repository: CollegeRepository

    fun getColleges(): List<College> {
        return repository.findAll()
    }

    fun getCollegeIdByCollegeName(collegeName: String): Int {
        return repository.findCollegeIdByCollegeName(collegeName)
    }

}