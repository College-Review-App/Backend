package college.app.backend.classes

import javax.persistence.*

@Entity
@Table(name = "applications")
data class Application (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id : Int?,

        @Column(name = "GPA")
        var GPA : Float,

        @Column(name = "state")
        var state: String,

        @ManyToOne
        @JoinColumn(name = "college_id", referencedColumnName = "id")
        var college : College,
)