package com.example.mobiquityassignment.extension

import android.content.res.Resources
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter


@BindingAdapter("android:drawableRes")
fun ImageView.drawableRes(@DrawableRes drawableRes: Int?) {
    if ((drawableRes.isNotNull()) and (drawableRes != Resources.ID_NULL)) {
        setImageDrawable(context.getCompatDrawable(drawableRes!!))
    }
}