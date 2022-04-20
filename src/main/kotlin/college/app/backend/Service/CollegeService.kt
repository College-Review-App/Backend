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

    fun addCollege(college_name: String, GPA: Float): College {
        return repository.save(College(null, college_name, GPA));
    }
}