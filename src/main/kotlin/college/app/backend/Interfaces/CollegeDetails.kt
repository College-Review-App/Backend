package college.app.backend.Interfaces

import java.util.*

// Defines an interface for the college class, so that when used,
// only the specified fields in the interface are returned during
// an HTTP request instead of all unnecessary fields.

interface CollegeDetails {
    fun getCollegeId(): Int
    fun getCollegeName(): String
    fun getLocation(): String
}