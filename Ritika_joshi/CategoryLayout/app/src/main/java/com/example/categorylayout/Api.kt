package com.example.categorylayout

import com.example.myapplication.models.DefaultResponse
import io.reactivex.Observable
import retrofit2.http.*


interface Api {



  // @FormUrlEncoded

    @POST("/api/category/{Category_Name}/{Category_Image}/")

    fun admin(
          @Path("Category_Name")Category_Name:String,
          @Path("Category_Image")Category_Image:String
    ): retrofit2.Call<DefaultResponse>



    @GET("/api/category")
    fun getApi() : Observable<List<DefaultResponse>>


}
