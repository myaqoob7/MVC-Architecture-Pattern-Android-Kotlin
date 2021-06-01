package com.orbital.sonic.mvcarchitecture

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),LoginResult {

    private lateinit var editUserName: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnLogin.setOnClickListener {
            loginResult()
        }
    }

    private fun initViews(){
        editUserName = findViewById(R.id.et_name)
        editPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.bt_submit)
        progressBar = findViewById(R.id.progress_login)
        progressBar.visibility = View.GONE
    }

    private fun loginResult() {
        progressBar.visibility = View.VISIBLE
        val userName = editUserName.text.toString()
        val password = editPassword.text.toString()
        val login = LoginApi(userName, password, this)
        login.doLogin()
    }

    override fun onLoginResult(result: Boolean) {
        progressBar.visibility = View.GONE
        if (result) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show()
        }
    }
}