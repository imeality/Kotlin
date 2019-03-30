package com.example.project

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.signinpage.*
import kotlinx.android.synthetic.main.signinpage.view.*
import java.util.regex.Pattern

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signinpage)

    }

        fun signupbttn(view: View) {


            //create a sIntent to statrt second activity
            val rndmIntent = Intent(this, SignupActivity::class.java)
            startActivity(rndmIntent);

        }


        fun homepage(view: View) {



            val REG = "(\\+91(-)?|91(-)?|0(-)?)?(9)[0-9]{9}"
            var PATTERN: Pattern = Pattern.compile(REG)
            fun CharSequence.isPhoneNumber(): Boolean = PATTERN.matcher(this).find()
            println("+919123456789".isPhoneNumber()) //must true


            btnSignIn.setOnClickListener {

                if (username.text.toString().isEmpty()) {
                    if (password.text.toString().isEmpty()) {
                        password?.error = " password mendatory"
                        username?.error = " username mendatory"
                        //Toast.makeText(parent,"Your message.", Toast.LENGTH_LONG).show();
                    } else {
                        username?.error = "username is mendatory"
                    }

                } else if (username.text.toString().isPhoneNumber() != true)
                {
                    if (password.text.toString().isEmpty()) {
                        password?.error = " password mendatory"
                        username?.error = " username Should be mobile number"
                        //Toast.makeText(parent,"Your message.", Toast.LENGTH_LONG).show();
                    } else {
                        username?.error = "username Should be mobile number"
                    }
                }
                if (password.text.toString().isEmpty()) {
                    if (username.text.toString().isEmpty()) {
                        password?.error = "password mendatory"
                        username?.error = " username mendatory"
                        //Toast.makeText(parent,"Your message.", Toast.LENGTH_LONG).show();
                    }
                    else if(username.text.toString().isPhoneNumber() != true)
                    {
                        password?.error = " password mendatory"
                        username?.error = " username Should be mobile number"
                    }
                    else
                    {
                        password?.error = " password mendatory"
                    }
                }

                if(username.text.toString().isNotEmpty())
                {
                    if(username.text.toString().isPhoneNumber()==true)
                    {
                        if(password.text.toString().isNotEmpty())
                        {
                            var homemenu = Intent(this , Home::class.java)
                            startActivity(homemenu)
                        }
                    }
                }


            }
        }
    }
