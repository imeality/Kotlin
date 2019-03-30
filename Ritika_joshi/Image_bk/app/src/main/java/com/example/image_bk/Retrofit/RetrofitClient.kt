package com.example.image_bk.Retrofit




//import com.github.satoshun.retrofit.converter.kotlinserialization.SerializationConverterFactory
import com.google.gson.Gson
//import com.jakewharton.retrofit2.converter.kotlinx.serialization.serializationConverterFactory
//import kotlinx.serialization.Serializer
//import kotlinx.serialization.json.JSON
//import kotlinx.serialization.json.Json

import okhttp3.MediaType.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.xml.datatype.DatatypeConstants.MINUTES
import okhttp3.OkHttpClient
import java.io.Serializable
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit


object RetrofitClient {
//    val contentType = get("application/json")

    private var ourInstance: Retrofit? = null

    val instance: Retrofit


        get() {
            try
            {


                val client = OkHttpClient.Builder()
                    .connectTimeout(180, TimeUnit.SECONDS)
                    .writeTimeout(240, TimeUnit.SECONDS)
                    .readTimeout(180, TimeUnit.SECONDS)
                    .build()


//            if (ourInstance == null)
//                ourInstance = Retrofit.Builder()
//                    .baseUrl("http://10.0.2.2:3002").client(client)
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
////                    .addConverterFactory(serializationConverterFactory(contentType, Json))
//
////                    .addConverterFactory(SerializationConverterFactory.create())
//                    .build()
//            return ourInstance!!


            if (ourInstance == null)
                ourInstance = Retrofit.Builder().
                    baseUrl("http://3.18.109.111:3002/")
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //  .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
//                    .addConverterFactory(serializationConverterFactory(contentType, Json))

//                    .addConverterFactory(SerializationConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                   //.addConverterFactory(GsonConverterFactory.create())

                    .build()
                return ourInstance!!


        }
            catch (e: InterruptedException)
            {
                println("exception occure")
                return instance;

            }
    }


}

