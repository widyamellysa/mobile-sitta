package com.example.wimel.m_sittaapp.network

import com.example.wimel.m_sittaapp.model.response.login.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Endpoint {
    @FormUrlEncoded
    @GET("login")
    fun login(@Field("username") email:String,
              @Field("password") password:String) : Observable<LoginResponse>
}