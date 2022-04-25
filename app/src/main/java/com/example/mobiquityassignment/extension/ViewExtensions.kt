package com.example.mobiquityassignment.extension

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView

@BindingAdapter("android:isVisible")
fun View.isVisible(isVisible: Boolean?) {
    if (isVisible.isNull()) {
        return
    } else {
        visibility = if (isVisible.orFalse()) View.VISIBLE else View.GONE
    }
}

@BindingAdapter("android:setValue")
fun setValue(textView: MaterialTextView, value: String?) {
    value?.let {
        textView.text = it
    }
}
