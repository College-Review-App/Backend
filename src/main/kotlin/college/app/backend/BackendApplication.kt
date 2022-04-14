package college.app.backend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}

// https://medium.com/@tcbasche/cors-in-spring-boot-with-kotlin-55eb5385f0e
// Handle CORS headers for requests
// Temp Solution: Define allowed origins

@RequestMapping(path = ["/test"])
@RestController
class CollegeResource {
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping
    fun index(): List<College> = listOf(
            College("1", "Hello", 4.00),
            College("2", "Goodbye", 3.98)
    )
}

@RequestMapping(path = ["/colleges"])
@RestController
class GetCollegeData(@Autowired val jdbcTemplate: JdbcTemplate) {
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping
    fun index(): List<College> {
        var colleges =  jdbcTemplate.query(
                "SELECT * FROM CollegeData"
        ) { rs, rowNum ->
            College(rs.getString("id"),
                    rs.getString("college_name"),
                    rs.getDouble("GPA"))
        }
        return colleges
    }
}

@RequestMapping(path = ["/add"])
@RestController
class AddNewCollege(@Autowired val jdbcTemplate: JdbcTemplate) {
    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping
    fun addCollege(): String {
        var SQL = "INSERT INTO CollegeData (college_name, GPA) VALUES ('University of Texas', 3.87)"
        var res = jdbcTemplate.update(SQL)
        if (res > 0) {
            return "Added New Row"
        } else {
            return "Failed"
        }
    }
}



data class College(val id: String, val college_name: String, val GPA: Double)
