package com.example.mobiquityassignment.util

import com.google.common.truth.Truth.assertThat

infix fun Any?.`should be`(expected: Any?) {
    assertThat(this).isEqualTo(expected)
}