package com.example.image_bk.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import kotlinx.android.synthetic.main.*



object RetrofitClient {

    private var ourInstance : Retrofit ?= null

    val instance : Retrofit
    get()

    {
        if(ourInstance==null)
            ourInstance == Retrofit.Builder()
                .baseUrl("http://10.0.0.2:3002/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

        return ourInstance !!
    }
}