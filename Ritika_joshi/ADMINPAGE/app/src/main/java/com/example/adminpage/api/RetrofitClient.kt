package com.example.myapplication.api

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder
import com.google.gson.Gson



object RetrofitClient
{
private val Auth = "Basic"+Base64.encodeToString("abcd : 123456".toByteArray(),Base64.NO_WRAP)

private const val BASE_URL = "http://10.0.2.2:3002"

    private val okHttpClient = OkHttpClient.Builder().addInterceptor{
        chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .addHeader("Authirization", Auth)
            .method(original.method(),original.body())
        val  request = requestBuilder.build()
        chain.proceed(request)
    }.build()

    var gson = GsonBuilder()
        .setLenient()
        .create()

    val client = OkHttpClient.Builder()
        .connectTimeout(180, TimeUnit.SECONDS)
        .writeTimeout(240, TimeUnit.SECONDS)
        .readTimeout(180, TimeUnit.SECONDS)
        .build()

    val instance : Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)

    }

    }

