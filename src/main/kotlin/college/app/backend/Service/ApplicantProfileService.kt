package college.app.backend.Service

import college.app.backend.Interfaces.ProfileDetails
import college.app.backend.Repository.ApplicantProfileRepository
import college.app.backend.classes.ApplicantProfile
import college.app.backend.classes.College
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.reflect.typeOf

@Service
class ApplicantProfileService {

    @Autowired
    lateinit var applicantProfileRepository: ApplicantProfileRepository

    // Gets all applications in the database
    fun getApplications(): List<ApplicantProfile> {
        return applicantProfileRepository.findAll()
    }

    // Calls the method to get all applications by a specific college ID
    fun findApplicationsByCollegeId(id: Int): List<ProfileDetails> {
        return applicantProfileRepository.findApplicationsByCollegeCollegeId(id);
    }

    // Parses a map and writes the resulting data into a new applicant profile in MySQL
    fun addApplicationsByCollege(applicationInfo: Map<String, Any>, college: College): ApplicantProfile {
        // Handles when GPA is an int (4.00 given as 4) or a double
        var gpaValue: Float = if (applicationInfo["GPA"] is Int) {
            (applicationInfo["GPA"] as Int).toFloat();
        } else {
            (applicationInfo["GPA"] as Double).toFloat()
        }

        println(applicationInfo["GPA"]!!::class.java.typeName)
        val currDate = LocalDateTime.now();
        val city: String = applicationInfo["city"] as String;
        val state: String = applicationInfo["state"] as String;
        val country: String = applicationInfo["country"] as String;
        val ethnicity: String = applicationInfo["ethnicity"] as String;
        val classOf: Int = applicationInfo["classOf"] as Int;
        val firstGen: Boolean = applicationInfo["firstGen"] as Boolean;
        val legacyStudent: Boolean = applicationInfo["legacyStudent"] as Boolean;
        val gender: Int = applicationInfo["gender"] as Int;
        val familyIncome: Int = applicationInfo["familyIncome"] as Int;
        val GPA: Float = gpaValue;
        val SAT: Int = applicationInfo["SAT"] as Int;
        val ACT: Int = applicationInfo["ACT"] as Int;
        val intendedMajor: String = applicationInfo["intendedMajor"] as String;
        val extracurriculars: String = applicationInfo["extracurriculars"] as String;
        val advice: String = applicationInfo["advice"] as String;
        val outcome: Int = applicationInfo["outcome"] as Int;
        return applicantProfileRepository.save(
            ApplicantProfile(
                null,
                college,
                currDate,
                city,
                state,
                country,
                ethnicity,
                classOf,
                firstGen,
                legacyStudent,
                gender,
                familyIncome,
                GPA,
                SAT,
                ACT,
                intendedMajor,
                extracurriculars,
                advice,
                0,
                outcome,
                false
            )
        );
    }

}
