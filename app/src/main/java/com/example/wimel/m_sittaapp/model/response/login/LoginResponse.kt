package com.example.wimel.m_sittaapp.model.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @Expose
    @SerializedName("code")
    val code: String,

    @Expose
    @SerializedName("token")
    val token: String
)