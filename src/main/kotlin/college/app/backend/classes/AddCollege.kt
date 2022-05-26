package college.app.backend.classes

import javax.persistence.*

//Maps the addCollege schema in the mySQL database
//to this class to be used with JPA

@Entity
@Table(name = "addCollege")
data class AddCollege (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id : Int?,

    @Column(name = "collegeName")
    var collegeName: String,

    @Column(name = "collegeCount")
    var collegeCount : Int,
)