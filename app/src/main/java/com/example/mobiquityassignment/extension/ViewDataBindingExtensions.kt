package com.example.mobiquityassignment.extension

import androidx.databinding.ViewDataBinding
import com.example.mobiquityassignment.R
import com.google.android.material.button.MaterialButton

fun ViewDataBinding.getButtonErrorAction(): MaterialButton? =
    root.findViewById(R.id.buttonErrorAction)