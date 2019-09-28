package com.nikola.androiddeveloperassignmentincrowdsportsii.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.nikola.androiddeveloperassignmentincrowdsportsii.R

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    //private val tag = "MainActivity: Testing"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }



}
