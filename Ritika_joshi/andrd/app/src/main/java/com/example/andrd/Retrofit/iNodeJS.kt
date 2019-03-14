package com.example.andrd.Retrofit

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface iNodeJS {

    @POST(value = "admin")
    @FormUrlEncoded

    fun registerUser(@Field(value = "Phone_No") Phone_No : Int,
                      @Field(value = "Password")Password : String):Observable<String>




//    @POST(value = "/login")
//    @FormUrlEncoded
//
//    fun LoginAdmin(@Field(value = "Phone_No") Phone_No : Integer,
//                   @Field(value = "Password")Password : String)
//
}