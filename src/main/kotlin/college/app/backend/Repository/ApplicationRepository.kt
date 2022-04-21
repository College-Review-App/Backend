package college.app.backend.Repository

import college.app.backend.classes.Application
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ApplicationRepository: JpaRepository<Application, Int> {
}