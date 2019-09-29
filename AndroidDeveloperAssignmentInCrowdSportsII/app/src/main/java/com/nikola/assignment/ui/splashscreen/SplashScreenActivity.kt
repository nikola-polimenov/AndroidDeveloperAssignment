package com.nikola.assignment.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.nikola.assignment.R
import com.nikola.assignment.ui.main.MainActivity
import com.nikola.assignment.utils.Constants

class SplashScreenActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 2500
    //private val tag = "SplashScreenActivity: Testing"
    private lateinit var splashScreenViewModel: SplashScreenViewModel
    private val constants: Constants = Constants()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_splash_screen)
        splashScreenViewModel = ViewModelProviders.of(this).get(SplashScreenViewModel::class.java)
        splashScreenViewModel.getMatch(constants.feedMatchId)
        splashScreenViewModel.getCommentary(constants.feedMatchId)




        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java).putExtra("feedMatchId", constants.feedMatchId))
            finish()
        },splashTimeOut)


    }
}
