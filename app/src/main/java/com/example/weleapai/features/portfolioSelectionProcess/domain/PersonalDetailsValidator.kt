package com.example.weleapai.features.portfolioSelectionProcess.domain

import android.os.Build
import android.util.Patterns
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.Period
import java.util.Calendar
import java.util.Locale

object PersonalDetailsValidator {

    fun validateFullName(fullName: String): ValidationResult {
        return if (fullName.isBlank()) {
            ValidationResult(false, "Full Name cannot be empty.")
        } else {
            ValidationResult(true)
        }
    }

    fun validateEmail(email: String): ValidationResult {
        return if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ValidationResult(false, "Invalid email address.")
        } else {
            ValidationResult(true)
        }
    }

    fun validatePhoneNumber(phone: String): ValidationResult {
        return if (phone.isBlank() || phone.length < 10) {
            ValidationResult(false, "Invalid phone number.")
        } else {
            ValidationResult(true)
        }
    }

    fun validateDateOfBirth(dob: String): ValidationResult {
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        sdf.isLenient = false // strictly check format
        return try {
            val dobDate = sdf.parse(dob) ?: return ValidationResult(false, "Invalid date format.")

            val today = Calendar.getInstance()
            val dobCalendar = Calendar.getInstance()
            dobCalendar.time = dobDate

            var age = today.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR)

            // If birthday not yet occurred this year, subtract one year
            if (today.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
                age--
            }

            if (age >= 18) {
                ValidationResult(true)
            } else {
                ValidationResult(false, "You must be at least 18 years old.")
            }
        } catch (e: Exception) {
            ValidationResult(false, "Date of Birth must be in format dd-MM-yyyy.")
        }
    }


    fun validateAddress(address: String): ValidationResult {
        return if (address.isBlank()) {
            ValidationResult(false, "Address cannot be empty.")
        } else {
            ValidationResult(true)
        }
    }
}
