package college.app.backend.Interfaces

import java.util.*

interface ReviewDetails {
    fun getReviewDate(): Date
    fun getState(): String
    fun getGPA(): Float
    fun getIntendedMajor(): String
    fun getExtracurriculars(): String
    fun getAdvice(): String
    fun getOutcome(): Int
}