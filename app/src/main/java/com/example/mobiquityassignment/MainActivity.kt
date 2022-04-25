package com.example.mobiquityassignment

import com.example.mobiquityassignment.core.ui.BaseActivity
import com.example.mobiquityassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_main
}