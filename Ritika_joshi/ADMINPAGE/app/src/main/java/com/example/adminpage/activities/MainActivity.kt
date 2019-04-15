package com.example.adminpage.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.adminpage.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun signupbttn(view: View) {

        //create a sIntent to statrt second activity
        val rndmIntent = Intent(this, SignupActivity::class.java)
        startActivity(rndmIntent);

    }

    fun singinbttn(view: View)
    {
        val signin = Intent(this, SignInActivity::class.java)
        startActivity(signin)
    }
}
