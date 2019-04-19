package com.example.adminpage.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

import com.example.adminpage.R
import com.example.adminpage.api.RetrofitClient
import com.example.adminpage.models.DefaultResponse
import com.example.adminpage.storage.SharedPrefManager


import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Callback
import retrofit2.Response

class SignupActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var a  = findViewById(R.id.textViewLogin) as TextView;
        a.setOnClickListener{
            val ramdomIntent = Intent(this@SignupActivity,SignInActivity::class.java)
            startActivity(ramdomIntent);
        }



        buttonSignUp.setOnClickListener {

            val Password = editpassword.text.toString().trim()
            val Phone_No = editphoneno.text.toString().trim()
            val Name = editTextName.text.toString().trim()





            RetrofitClient.instance.admin(Name,Phone_No,Password)
                .enqueue(object : Callback<DefaultResponse> {
                    override fun onFailure(call: retrofit2.Call<DefaultResponse>, t: Throwable) {
                        //   println("hello $Phone_No")
                       // Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        Toast.makeText(applicationContext,"Some Issue Occure",Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: retrofit2.Call<DefaultResponse>, response: Response<DefaultResponse>) {
                      //  Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        Toast.makeText(applicationContext,"Admin Created Created Succesfully",Toast.LENGTH_LONG).show()

                        startActivity(Intent(this@SignupActivity,SignInActivity::class.java))
                    }

                })

        }



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
