package com.orbital.sonic.mvcarchitecture

import android.os.Handler
import android.os.Looper

class LoginApi(userName: String, password: String, loginResultInterface: LoginResult) {
    private val mUserName: String = userName
    private val mPassword: String = password
    private val mLoginResultInterface: LoginResult = loginResultInterface
    private val userModel = UserModel(userName, password)

    fun doLogin() {
        val isLoginSuccess = userModel.checkUserValidity(mUserName, mPassword)

        Handler(Looper.getMainLooper()).postDelayed({
            mLoginResultInterface.onLoginResult(isLoginSuccess)

        }, 5000)

    }
}