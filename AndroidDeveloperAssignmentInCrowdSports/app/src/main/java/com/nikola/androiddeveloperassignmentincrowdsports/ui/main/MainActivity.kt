package com.nikola.androiddeveloperassignmentincrowdsports.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.nikola.androiddeveloperassignmentincrowdsports.R

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private val tag = "MainActivity: Testing"
    var bundleReceived: Bundle? = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        bundleReceived = intent.extras
        val currentMatch = bundleReceived?.get("currentMatch")
        if (currentMatch == null) {
            Log.d(tag, " There is a problem with the Activity to Activity transaction")
        }
    }



}
