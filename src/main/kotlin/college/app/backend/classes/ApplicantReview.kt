package college.app.backend.classes

import java.time.LocalDateTime
import javax.persistence.*

// Maps the applicant review schema in the MySQL database
// to this class to be used with JPA.

@Entity
@Table(name = "applicantReviews")
data class ApplicantReview (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "reviewId")
        var reviewId : Int?,

        @ManyToOne
        @JoinColumn(name = "collegeId", referencedColumnName = "collegeId")
        var college : College,

        @Column(name = "reviewDate")
        var reviewDate : LocalDateTime,

        @Column(name = "city")
        var city : String,

        @Column(name = "state")
        var state: String,

        @Column(name = "country")
        var country : String,

        @Column(name = "race")
        var race : String,

        @Column(name = "gender")
        var gender : Int,

        @Column(name = "familyIncome")
        var familyIncome : Int,

        @Column(name = "highschool")
        var highschool : String,

        @Column(name = "GPA")
        var GPA : Float,

        @Column(name = "SAT")
        var SAT : Int,

        @Column(name = "ACT")
        var ACT : Int,

        @Column(name = "intendedMajor")
        var intendedMajor : String,

        @Column(name = "extracurriculars")
        var extracurriculars : String,

        @Column(name = "advice")
        var advice : String,

        @Column(name = "likes")
        var likes : Int,

        @Column(name = "outcome")
        var outcome : Int,

        @Column(name = "isVerified")
        var isVerified : Boolean,
)