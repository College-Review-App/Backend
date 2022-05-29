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

    //Adds a new college to the repository if it does not previously exist.
    //If it does exist increment that college count by 1
    fun addNewCollege(collegeNameMap: Map<String, Any>): AddCollege {
        val collegeName: String = collegeNameMap["collegeName"] as String;
        try {
            val college = repository.findAddCollegeByCollegeName(collegeName);
            val currCount = college.collegeCount;
            repository.updateCollegeCountIfCollegeNameExists(collegeName, currCount + 1);
        } catch (e: EmptyResultDataAccessException) {
            print("There is no such college!")
        }

        return repository.save(AddCollege(null, collegeName,  1));
    }

    fun getAllRequestedColleges() : List<AddCollege> {
        return repository.findAll();
    }

}