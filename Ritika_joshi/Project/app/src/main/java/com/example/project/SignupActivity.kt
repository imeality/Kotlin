package com.example.project

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.signinpage.*
import kotlinx.android.synthetic.main.signuppage.*
import kotlinx.android.synthetic.main.signuppage.view.*
import java.util.Collections.replaceAll
import java.util.regex.Pattern


class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signuppage)
    }

    fun singinbttn(view: View) {
        val signin = Intent(this, SignInActivity::class.java)
        startActivity(signin)
    }

    fun homepage2(view: View) {
//        val  mobilePattern = "/^[0-9]+\$/"
//        val st = mobilePattern.toRegex();
//        val PhoneNo = "/^(\\+\\d)*\\s*(\\(\\d{3}\\)\\s*)*\\d{3}(-{0,1}|\\s{0,1})\\d{2}(-{0,1}|\\s{0,1})\\d{2}\$/"
//        val Regex = "[^\\d]"
//        val PhoneDigits = PhoneNo.replace(Regex.toRegex(), "");
//
//        val rg = "/^[0-9]+\$/"


        val REG = "(\\+91(-)?|91(-)?|0(-)?)?(9)[0-9]{9}"
        var PATTERN: Pattern = Pattern.compile(REG)
        fun CharSequence.isPhoneNumber(): Boolean = PATTERN.matcher(this).find()
        println("+919123456789".isPhoneNumber()) //must true
        val menupage = Intent(this, Home::class.java)

        btnSignUp.setOnClickListener {


            //////////////////////////////////////////////Name Vlaidation////////////////////////////////////////////////////
            if (editname.text.toString().isEmpty()) {

                if (editphone.text.toString().isEmpty()) {
                    if (editpassword.text.toString().isEmpty()) {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                        editpassword?.error = "Password is Mendatory"
                    } else if (conformpassword.text.toString().isEmpty()) {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                        conformpassword?.error = "Rewrite The Password is Mendatory"
                    } else if (conformpassword.text.toString() != editpassword.text.toString()) {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                        conformpassword?.error = "Password And Conform Password Should be Same"
                    } else {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                    }
                } else if (editphone.text.toString().isPhoneNumber() == true) {

                    if (editpassword.text.toString().isEmpty()) {
                        editname?.error = "Name is Mendatory"
                        editpassword?.error = "Password is Mendatory"
                    } else if (conformpassword.text.toString().isEmpty()) {
                        editname?.error = "Name is Mendatory"
                        conformpassword?.error = "Rewrite The Password is Mendatory"
                    } else if (conformpassword.text.toString() != editpassword.text.toString()) {
                        editname?.error = "Name is Mendatory"

                        conformpassword?.error = "Password And Conform Password Should be Same"
                    } else {
                        editname?.error = "Name is Mendatory"
                    }
                } else if (editpassword.text.toString().isEmpty()) {
                    editname?.error = "Name is Mendatory"
                    editphone?.error = "Please Write The Right Phone Number"
                    editpassword?.error = "Password is Mendatory"
                } else if (conformpassword.text.toString().isEmpty()) {
                    editname?.error = "Name is Mendatory"
                    editphone?.error = "Please Write The Right Phone Number"
                    conformpassword?.error = "Rewrite The Password is Mendatory"
                } else if (conformpassword.text.toString() != editpassword.text.toString()) {
                    editname?.error = "Name is Mendatory"
                    editphone?.error = "Please Write The Right Phone Number"

                    conformpassword?.error = "Password And Conform Password Should be Same"
                } else {
                    editname?.error = "Name is Mendatory"
                    editphone?.error = "Please Write The Right Phone Number"
                    editname?.errorColor
                }
            }


            //////////////////////////////////////////////Phone Number Vlaidation////////////////////////////////////////////////////


            if (editphone.text.toString().isEmpty()) {
                if (editname.text.toString().isEmpty()) {
                    if (editpassword.text.toString().isEmpty()) {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                        editpassword?.error = "Password is Mendatory"
                    } else if (conformpassword.text.toString().isEmpty()) {
                        editphone?.error = "Phone Number is Mendatory"
                        editname?.error = "Name is Mendatory"
                        conformpassword?.error = "Rewrite The Password is Mendatory"
                    } else if (conformpassword.text.toString() != editpassword.text.toString()) {

                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                        conformpassword?.error = "Password And Conform Password Should be Same"

                    } else {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                    }
                } else if (editpassword.text.toString().isEmpty()) {
                    editphone?.error = "Phone Number is Mendatory"
                    editpassword?.error = "Password is Mendatory"

                } else if (conformpassword.text.toString().isEmpty()) {

                    editphone?.error = "Phone Number is Mendatory"
                    conformpassword?.error = "Rewrite The Password is Mendatory"

                } else if (conformpassword.text.toString() != editpassword.text.toString()) {

                    editphone?.error = "Phone Number is Mendatory"
                    conformpassword?.error = "Password And Conform Password Should be Same"

                } else {

                    editphone?.error = "Phone Number is Mendatory"
                }

            } else if (editphone.text.toString().isPhoneNumber() != true) {
                if (editname.text.toString().isEmpty()) {
                    if (editpassword.text.toString().isEmpty()) {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Please Write The Right Phone Number"
                        editpassword?.error = "Password is Mendatory"
                    } else if (conformpassword.text.toString().isEmpty()) {
                        editphone?.error = "Please Write The Right Phone Number"
                        editname?.error = "Name is Mendatory"
                        conformpassword?.error = "Rewrite The Password is Mendatory"
                    } else if (conformpassword.text.toString() != editpassword.text.toString()) {

                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Please Write The Right Phone Number"
                        conformpassword?.error = "Password And Conform Password Should be Same"

                    } else {
                        editname?.error = "name is Mendatory"
                        editphone?.error = "Please Write The Right Phone Number"
                    }
                } else if (editpassword.text.toString().isEmpty()) {
                    editphone?.error = "Please Write The Right Phone Number"
                    editpassword?.error = "Password is Mendatory"

                } else if (conformpassword.text.toString().isEmpty()) {

                    editphone?.error = "Please Write The Right Phone Number"
                    conformpassword?.error = "Rewrite The Password is Mendatory"

                } else if (conformpassword.text.toString() != editpassword.text.toString()) {

                    editphone?.error = "Please Write The Right Phone Number"
                    conformpassword?.error = "Password And Conform Password Should be Same"

                } else {

                    editphone?.error = "Please Write The Right Phone Number"
                }
            }


            //////////////////////////////////////////////Password Vlaidation////////////////////////////////////////////////////

            if (editpassword.text.toString().isEmpty()) {
                if (editname.text.toString().isEmpty()) {
                    if (editphone.text.toString().isEmpty()) {
                        editname?.error = "Name is Mendatory"
                        editphone?.error = "Phone Number is Mendatory"
                        editpassword?.error = "Password is Mendatory"
                    } else if (editphone.text.toString().isPhoneNumber() != true) {
                        editname?.error = "Name is Mendatory"
                        editpassword?.error = "Password is Mendatory"
                        editphone?.error = "Please Write The Right Phone Number"

                    } else {
                        editname?.error = "Please Write The Right Phone Number"
                        editpassword?.error = "Password is Mendatory"
                    }
                } else if (editphone.text.toString().isEmpty()) {

                    editphone?.error = "Phone Number is Mendatory"
                    editpassword?.error = "Password is Mendatory"
                } else if (editphone.text.toString().isPhoneNumber() != true) {

                    editpassword?.error = "Password is Mendatory"
                    editphone?.error = "Please Write The Right Phone Number"

                } else {
                    editpassword?.error = "Password is Mendatory"
                }

            } else if (conformpassword.text.toString().isEmpty()) {
                conformpassword?.error = "Rewrite The Password is Mendatory"
            } else if (conformpassword.text.toString() != editpassword.text.toString()) {

                conformpassword?.error = "Password And Conform Password Should be Same"

            }


            //////////////////////////////////////////Conform Password Vlaidation////////////////////////////////////////////////////

            if (conformpassword.text.toString().isNotEmpty()) {
                if (editname.text.toString().isEmpty()) {
                    if (editpassword.text.toString().isEmpty()) {
                        if (editphone.text.toString().isEmpty()) {
                            editname?.error = "Name is Mendatory"
                            editphone?.error = "Phone Number is Mendatory"
                            editpassword?.error = "Password is Mendatory"
                        } else if (editphone.text.toString().isPhoneNumber() != true) {

                            editname?.error = "Name is Mendatory"
                            editphone?.error = "Please Write The Right Phone Number"
                            editpassword?.error = "Password is Mendatory"
                        } else {
                            editname?.error = "Name is Mendatory"
                            editpassword?.error = "Password is Mendatory"
                        }

                    }else if(conformpassword.text.toString() != editpassword.text.toString())
                    {
                        editname?.error = "Name is Mendatory"
                        conformpassword?.error = "Password And Conform Password Should be Same"
                    }

                } else if (editpassword.text.toString().isEmpty()) {
                    if (editphone.text.toString().isEmpty()) {

                        editphone?.error = "Phone Number is Mendatory"
                        editpassword?.error = "Password is Mendatory"
                    }
                } else if (editphone.text.toString().isPhoneNumber() != true) {


                    editphone?.error = "Please Write The Right Phone Number"

                }
            }



            ///////////////////////////////////////////////////////Intent to Home Page///////////////////////////////////////

            if(editname.text.toString().isNotEmpty())
            {
                if(editphone.text.toString().isPhoneNumber()==true)
                {
                    if(editpassword.text.toString()==conformpassword.text.toString())
                    {
                        startActivity(menupage)
                    }
                }
            }

        }
    }
}