package com.example.image_bk.Retrofit




import io.reactivex.Observable


import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface iNodeJS {

    @POST(value = "api/admin")


@FormUrlEncoded
    fun registeruser(@Field(value = "Phone_No")Phone_No : Int,
                      @Field(value = "Password")Password : String
    ):Observable<String>


//    fun loginTask(@Body credentials: RetrofitClient)
//            : Observable<modelclass>
//    @SerializedName

//    @POST(value = "/login")
//    @FormUrlEncoded
//
//    fun LoginAdmin(@Field(value = "Phone_No") Phone_No : Integer,
//                   @Field(value = "Password")Password : String)




}