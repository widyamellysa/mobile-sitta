package com.example.wimel.m_sittaapp.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wimel.m_sittaapp.MainActivity
import com.example.wimel.m_sittaapp.R
import com.example.wimel.m_sittaapp.model.response.login.LoginResponse
import com.example.wimel.m_sittaapp.util.MobileSitta
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), LoginContract.View {
    lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = LoginPresenter(this)

        if (!MobileSitta.getApp().getToken().isNullOrEmpty()) {
            val home = Intent(activity, MainActivity::class.java)
            startActivity(home)
            activity?.finish()
        }

        initView()
        initDummy()

        btnLogin.setOnClickListener {

            var username = etUsername.text.toString()
            var password = etPassword.text.toString()

            if (username.isNullOrEmpty()) {
                etUsername.error = "Silahkan masukkan email Anda"
                etUsername.requestFocus()
            } else if (password.isNullOrEmpty()) {
                etPassword.error = "Silahkan masukkan password Anda"
                etPassword.requestFocus()
            } else {
                presenter.subimtLogin(username, password)
            }

        }
    }

    private fun initView() {
//        progressDialog = Dialog(requireContext())
//        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)
//
//        progressDialog?.let {
//            it.setContentView(dialogLayout)
//            it.setCancelable(false)
//            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        }
    }

    override fun onLoginSuccess(loginResponse: LoginResponse) {
        MobileSitta.getApp().setToken(loginResponse.token)

//        val gson = Gson()
//        val json = gson.toJson(loginResponse.user)
//        FoodMarket.getApp().setUser(json)

        val home = Intent(activity, MainActivity::class.java)
        startActivity(home)
        activity?.finish()
    }

    private fun initDummy() {
        etUsername.setText("s1tt@#mbl")
        etPassword.setText("@pi20215!T4")
    }

    override fun onLoginFailed(message: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }
}