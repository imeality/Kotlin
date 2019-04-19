package com.example.adminpage.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.adminpage.R
import com.example.adminpage.storage.SharedPrefManager


class HomePageAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_admin)



    }



//    override fun onStart() {
//        super.onStart()
//
//        if(SharedPrefManager.getInstance(this).isLoggedIn)
//        {
//            val intent = Intent(applicationContext, HomePageAdmin::class.java)
//            intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            startActivity(intent)
//
//        }
//    }
}
