package college.app.backend.Interfaces

import java.util.*

// Defines an interface for the applicant review class, so that when used,
// only the specified fields in the interface are returned during
// an HTTP request instead of all unnecessary fields.

interface ReviewDetails {
    fun getReviewId(): Int
    fun getReviewDate(): Date
    fun getState(): String
    fun getGPA(): Float
    fun getIntendedMajor(): String
    fun getExtracurriculars(): String
    fun getAdvice(): String
    fun getOutcome(): Int
}