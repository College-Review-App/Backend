package college.app.backend.classes

import college.app.backend.Interfaces.CollegeDetails
import javax.persistence.*

// Maps the college schema in the MySQL database
// to this class to be used with JPA.

@Entity
@Table(name = "colleges")
data class College (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collegeId")
    var collegeId : Int?,

    @Column(name = "collegeName")
    var collegeName: String,

    @Column(name = "location")
    var location : String,

    @Column(name = "image")
    var image : String,

    @Column(name = "acceptanceRate")
    var acceptanceRate : Int,

    @Column(name = "ranking")
    var ranking : Int,

)

