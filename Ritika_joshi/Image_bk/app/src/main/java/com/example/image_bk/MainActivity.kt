package com.example.image_bk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun randomMe(view: View) {

        //create a sIntent to statrt second activity
        val ramdomIntent = Intent(this, SecondActivity::class.java)
        startActivity(ramdomIntent);

    }
}
