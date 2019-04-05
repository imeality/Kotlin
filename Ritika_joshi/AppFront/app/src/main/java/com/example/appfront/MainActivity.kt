package com.example.appfront

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun menu1(view: View) {

        //create a sIntent to statrt second activity
        val rndmIntent = Intent(this, FoodItem::class.java)
        startActivity(rndmIntent);

    }

}
