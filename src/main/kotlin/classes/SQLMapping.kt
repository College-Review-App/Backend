package classes

import javax.persistence.*

@Entity
data class College (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int,

    @Column(nullable = false)
    var college_name: String,

    @Column(nullable = false)
    var GPA : Double
)
