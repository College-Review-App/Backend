package college.app.backend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query


// TODO: Add Database
@SpringBootApplication
class BackendApplication(@Autowired val jdbcTemplate: JdbcTemplate) : CommandLineRunner {
    override fun run(vararg args: String?) {
        var colleges =  jdbcTemplate.query(
                "SELECT * FROM CollegeData"
        ) { rs, rowNum ->
            College(rs.getString("id"),
                    rs.getString("college_name"),
                    rs.getDouble("GPA"))
        }
        println(colleges)
    }
}

//test line delete later

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}

// https://medium.com/@tcbasche/cors-in-spring-boot-with-kotlin-55eb5385f0e
// Handle CORS headers for requests
// Temp Solution: Define allowed origins

@RestController
class CollegeResource {
    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
    @GetMapping
    fun index(): List<College> = listOf(
            College("1", "Hello", 4.00),
            College("2", "Goodbye", 3.98)
    )
}

//@RequestMapping(path = ["/blogs"])
//@RestController
//class GetCollegeData(@Autowired val jdbcTemplate: JdbcTemplate) {
//    @GetMapping
//    fun index() {
//        var colleges =  jdbcTemplate.query(
//                "SELECT * FROM CollegeData"
//        ) { rs, rowNum ->
//            College(rs.getString("id"),
//                    rs.getString("college_name"),
//                    rs.getDouble("GPA"))
//        }
//        println(colleges)
//    }
//}

data class College(val id: String, val college_name: String, val GPA: Double)
