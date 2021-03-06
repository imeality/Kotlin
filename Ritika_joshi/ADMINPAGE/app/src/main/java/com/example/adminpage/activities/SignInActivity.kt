package com.example.adminpage.activities

import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import android.view.ActionMode
import android.widget.TextView
import com.example.adminpage.R
import com.example.adminpage.api.RetrofitClient
import com.example.adminpage.models.LoginResponse
import com.example.adminpage.storage.SharedPrefManager


import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        var a  = findViewById(R.id.textViewRegister) as TextView;
        a.setOnClickListener{
            val ramdomIntent = Intent(this@SignInActivity,SignupActivity::class.java)
            startActivity(ramdomIntent);
        }


        buttonLogin.setOnClickListener{
            val Phone_No = editTextEmail.text.toString().trim();
            val Password = editTextPassword.text.toString().trim();





            RetrofitClient.instance.userLogin(Phone_No,Password)
                .enqueue(object: Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                        if (!response.body()?.error!!)
                        {
                           // SharedPrefManager.getInstance(this@SignInActivity).saveUser(response.body()?.user!!)

                            val intent = Intent(this@SignInActivity, HomePageAdmin::class.java)
                            //intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)

                        }

                        else if(response.body()?.error!!){
                          Toast.makeText(applicationContext,"some problem occure",Toast.LENGTH_LONG).show()
                        }

                    }

                })

        }

    }

//    override fun onStart() {
//        super.onStart()
//
//        if(SharedPrefManager.getInstance(this).isLoggedIn)
//        {
//
//            val intent = Intent(applicationContext, HomePageAdmin::class.java)
//            intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            startActivity(intent)
//
//        }
//    }
}