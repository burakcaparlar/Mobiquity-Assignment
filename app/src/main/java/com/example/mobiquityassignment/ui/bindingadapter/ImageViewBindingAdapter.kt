package com.example.mobiquityassignment.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mobiquityassignment.R

@BindingAdapter("android:setImageUrl")
fun setImageUrl(imageView: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrBlank()) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .apply(options)
            .into(imageView)
    }
}

private var options: RequestOptions = RequestOptions()
    .centerCrop()
    .placeholder(R.drawable.glide_progress_animation)
    .error(R.drawable.ic_glide_error)