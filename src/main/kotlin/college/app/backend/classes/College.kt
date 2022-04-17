package college.app.backend.classes

import javax.persistence.*

@Entity
@Table(name = "CollegeData")
data class College (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id : Int,

    @Column(name = "college_name")
    var college_name: String,

    @Column(name = "GPA")
    var GPA : Float,
)
