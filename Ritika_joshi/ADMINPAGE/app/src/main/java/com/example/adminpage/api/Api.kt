package com.example.adminpage.api


import com.example.adminpage.models.DefaultResponse
import com.example.adminpage.models.LoginResponse
import retrofit2.Call
import retrofit2.http.*


interface Api {



  // @FormUrlEncoded

    @POST("/api/adminsignup/{Name}/{Phone_No}/{Password}/")

    fun admin(
          @Path("Name")Name:String,
          @Path("Phone_No")Phone_No:String,
          @Path("Password")Password:String
        //   @Field("Phone_No")Phone_No:String
    ): Call<DefaultResponse>


  //@FormUrlEncoded
  @POST("/api/adminlogin/{Phone_No}/{Password}")

    fun userLogin(

    @Path("Password")Password:String,
    @Path("Phone_No")Phone_No:String
    ): Call<LoginResponse>
}
