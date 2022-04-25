package com.example.mobiquityassignment.util.extension

import com.example.mobiquityassignment.extension.orFalse
import com.example.mobiquityassignment.util.`should be`
import org.junit.Test

class BooleanExtensionsTest {

    @Test
    fun `when boolean is true or false, then orFalse() returns itself`() {
        // Given
        val booleanTrue = true
        val booleanFalse = false

        // When
        val resultBooleanTrue = booleanTrue.orFalse()
        val resultBooleanFalse = booleanFalse.orFalse()

        // Then
        resultBooleanTrue `should be` booleanTrue
        resultBooleanFalse `should be` booleanFalse
    }

    @Test
    fun `when boolean is null, then orFalse() returns false`() {
        // Given
        val booleanNull: Boolean? = null

        // When
        val result = booleanNull.orFalse()

        // Then
        result `should be` false
    }
}