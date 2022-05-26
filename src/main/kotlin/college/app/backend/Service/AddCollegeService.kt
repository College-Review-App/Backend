package college.app.backend.Service

import college.app.backend.Repository.AddCollegeRepository
import college.app.backend.classes.AddCollege
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class AddCollegeService {

    @Autowired
    lateinit var repository: AddCollegeRepository

    fun addNewCollege(collegeName: String): AddCollege {


        try {
            val college = repository.findAddCollegeByCollegeName(collegeName);
            val currCount = college.collegeCount;
            repository.updateCollegeCountIfCollegeNameExists(collegeName, currCount + 1);
        } catch (e: EmptyResultDataAccessException) {
            print("There is no such college!")
        }

        return repository.save(AddCollege(null, collegeName,  1));

    }
}