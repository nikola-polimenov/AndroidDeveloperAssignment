package com.nikola.androiddeveloperassignmentincrowdsportsii.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProviders
import com.nikola.androiddeveloperassignmentincrowdsportsii.R
import com.nikola.androiddeveloperassignmentincrowdsportsii.ui.main.MainActivity
import com.nikola.androiddeveloperassignmentincrowdsportsii.utils.Constants

class SplashScreenActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 2500
    //private val tag = "SplashScreenActivity: Testing"
    private lateinit var splashScreenViewModel: SplashScreenViewModel
    private val constants: Constants = Constants()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        splashScreenViewModel = ViewModelProviders.of(this).get(SplashScreenViewModel::class.java)
        splashScreenViewModel.getMatch(constants.feedMatchId)
        splashScreenViewModel.getCommentary(constants.feedMatchId)




        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },splashTimeOut)


    }
}
