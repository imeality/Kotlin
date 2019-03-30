package com.example.image_bk

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.image_bk.Retrofit.RetrofitClient
import com.example.image_bk.Retrofit.iNodeJS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*


import kotlinx.android.synthetic.main.activity_second.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity : AppCompatActivity() {


    lateinit var myAPI: iNodeJS
    var compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)




//INIT API


        val retrofit: Retrofit = RetrofitClient.instance
        myAPI = retrofit.create(iNodeJS::class.java)

        edt_registration.setOnClickListener {
//            val intent = Intent(applicationContext, SecondActivity::class.java)
//            startActivity(intent)
            val a =phonenumber.text.toString().toInt();
            val b = password.text.toString();
            register(a, b)
            println("My log message $a");




//            if(phonenumber.text.toString().length<0)
//            {
//                phonenumber?.error="please not fill in the blank"
//             //   Toast.makeText(parent,"Your message.", Toast.LENGTH_LONG).show();
//
//            }

        }
    }

 private fun register(Phone_No: Int, Password: String) {
     println("Hello, world! $Phone_No")
        compositeDisposable.add(myAPI.registeruser(Phone_No,Password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

            .subscribe({
                result ->
                println("Hello, hii, world! $Phone_No")
                "registration done"
            }, { error ->
                error.printStackTrace()
                println("Hello, hii, worlddddddddddddd! $Phone_No")
                Log.e("SecondActivity","Api call error")
            }
            ))

    }




    override fun onStart() {
        compositeDisposable.clear()
        super.onStart()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}




