package com.example.myapplication.api

import com.example.myapplication.models.DefaultResponse
import com.example.myapplication.models.LoginResponse

import retrofit2.http.*


interface Api {



  // @FormUrlEncoded

    @POST("/api/adminsignup/{Name}/{Phone_No}/{Password}/")

    fun admin(
          @Path("Name")Name:String,
          @Path("Phone_No")Phone_No:String,
          @Path("Password")Password:String
        //   @Field("Phone_No")Phone_No:String
    ): retrofit2.Call<DefaultResponse>


  //@FormUrlEncoded
  @POST("/api/adminlogin/{Phone_No}/{Password}")

    fun userLogin(

    @Path("Password")Password:String,
    @Path("Phone_No")Phone_No:String
    ): retrofit2.Call<LoginResponse>
}
