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

    fun addCollege(collegeInfo: Map<String, Any>): College {
        val collegeName: String = collegeInfo["college_name"] as String
        val location: String = collegeInfo["location"] as String
        return repository.save(College(null, collegeName, location));
    }
}