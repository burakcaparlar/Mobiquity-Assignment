package com.example.mobiquityassignment.util.extension

import com.example.mobiquityassignment.extension.isNotNull
import com.example.mobiquityassignment.extension.isNull
import com.example.mobiquityassignment.util.`should be`
import org.junit.Test

class AnyExtensionsTest {

    @Test
    fun `when any is null, then isNull() returns true`() {
        // Given
        val any: Any? = null

        // When
        val result = any.isNull()

        // Then
        result `should be` true
    }

    @Test
    fun `when any is not null, then isNull() returns false`() {
        // Given
        val any = Any()

        // When
        val result = any.isNull()

        // Then
        result `should be` false
    }

    @Test
    fun `when any is null, then isNotNull() returns false`() {
        // Given
        val any: Any? = null

        // When
        val result = any.isNotNull()

        // Then
        result `should be` false
    }

    @Test
    fun `when any is not null, then isNotNull() returns true`() {
        // Given
        val any = Any()

        // When
        val result = any.isNotNull()

        // Then
        result `should be` true
    }
}