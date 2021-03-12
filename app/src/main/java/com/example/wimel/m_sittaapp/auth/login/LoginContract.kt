package com.example.wimel.m_sittaapp.auth.login

import com.example.wimel.m_sittaapp.base.BasePresenter
import com.example.wimel.m_sittaapp.base.BaseView
import com.example.wimel.m_sittaapp.model.response.login.LoginResponse

interface LoginContract {

    interface View: BaseView {
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message:String)

    }

    interface Presenter : LoginContract, BasePresenter {
        fun subimtLogin(username:String, password:String)
    }

}