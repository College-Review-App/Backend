package college.app.backend.Interfaces

import java.util.*

// Defines an interface for the applicant review class, so that when used,
// only the specified fields in the interface are returned during
// an HTTP request instead of all unnecessary fields.

interface ProfileDetails {
    fun getProfileId(): Int
    fun getProfileDate(): Date
    fun getState(): String
    fun getCountry(): String
    fun getEthnicity(): String
    fun getClassOf(): Int
    fun getFirstGen(): Boolean
    fun getLegacyStudent(): Boolean
    fun getGender(): Int
    fun getFamilyIncome(): Int
    fun getGPA(): Float
    fun getSAT(): Int
    fun getACT(): Int
    fun getIntendedMajor(): String
    fun getExtracurriculars(): String
    fun getAdvice(): String
    fun getOutcome(): Int
}