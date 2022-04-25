package com.example.mobiquityassignment.extension

import android.view.ViewStub

fun ViewStub.inflate(inflate: Boolean) {
    if (inflate) {
        inflate()
    }
}