package com.nikola.androiddeveloperassignmentincrowdsports.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.nikola.androiddeveloperassignmentincrowdsports.network.NetworkRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val networkRepository:NetworkRepository = NetworkRepository()
    private val tag = "MainViewModel Testing:"


}