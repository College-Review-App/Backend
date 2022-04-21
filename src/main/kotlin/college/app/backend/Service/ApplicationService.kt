package college.app.backend.Service

import college.app.backend.Repository.ApplicationRepository
import college.app.backend.classes.Application
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApplicationService {

    @Autowired
    lateinit var repository: ApplicationRepository

    fun getApplications(): List<Application> {
        return repository.findAll()
    }

}
