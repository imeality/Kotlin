package com.example.image_bk.Retrofit

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface iNodeJS {

    @POST(value = "/api/admin")
    @FormUrlEncoded

    fun registerEmail(@Field(value = "Phone_No") Phone_No : Integer,
                      @Field(value = "Password")Password : String)




//    @POST(value = "/login")
//    @FormUrlEncoded
//
//    fun LoginAdmin(@Field(value = "Phone_No") Phone_No : Integer,
//                   @Field(value = "Password")Password : String)
//
}