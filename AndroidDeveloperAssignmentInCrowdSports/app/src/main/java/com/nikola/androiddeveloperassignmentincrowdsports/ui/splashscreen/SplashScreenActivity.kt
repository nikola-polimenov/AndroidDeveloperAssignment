package com.nikola.androiddeveloperassignmentincrowdsports.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nikola.androiddeveloperassignmentincrowdsports.R
import com.nikola.androiddeveloperassignmentincrowdsports.network.matchmodels.Match
import com.nikola.androiddeveloperassignmentincrowdsports.ui.main.MainActivity
import com.nikola.androiddeveloperassignmentincrowdsports.utils.Constants

class SplashScreenActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 2500
    private val tag = "SplashScreenActivity: Testing"
    private lateinit var splashScreenViewModel: SplashScreenViewModel
    private val constants: Constants = Constants()
    private var matchCheck:Boolean = false
    private var matchCommentaryCheck:Boolean = false
    var bundle: Bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        splashScreenViewModel = ViewModelProviders.of(this).get(SplashScreenViewModel::class.java)
        splashScreenViewModel.getMatch(constants.feedMatchId)
        splashScreenViewModel.getCommentary(constants.feedMatchId)

        splashScreenViewModel.currentMatch.observe(this, Observer {
            matchCheck = true
        })
        splashScreenViewModel.currentMatchCommentary.observe(this, Observer {
            matchCommentaryCheck = true
        })

        when (matchCheck) {
            true -> {
                when(matchCommentaryCheck) {
                    true -> {
                        bundle = bundleOf("currentMatch" to splashScreenViewModel.currentMatch,
                            "currentMatchCommentary" to splashScreenViewModel.currentMatchCommentary)

                    }
                }
            }
        }


        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java), bundle)
            finish()
        },splashTimeOut)


    }
}
