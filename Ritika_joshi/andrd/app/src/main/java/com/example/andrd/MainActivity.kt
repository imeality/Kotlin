package com.example.andrd

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.andrd.Retrofit.RetrofitClient
import com.example.andrd.Retrofit.iNodeJS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    lateinit var myAPI: iNodeJS
    var compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INIT API

        val retrofit = RetrofitClient.instance
        myAPI = retrofit.create(iNodeJS::class.java)

        edt_registration.setOnClickListener {

            register(edt_username.text.toString().toInt(), edt_password.text.toString())

        }


    }

    private fun register(Phone_No: Int, Password: String) {

        compositeDisposable.add(myAPI.registerUser(Phone_No, Password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { message ->
                Toast.makeText(this@MainActivity, "registration successful", Toast.LENGTH_SHORT).show()
            })

    }

//    override fun onStop() {
//        compositeDisposable.clear()
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        compositeDisposable.clear()
//        super.onDestroy()
//    }


}