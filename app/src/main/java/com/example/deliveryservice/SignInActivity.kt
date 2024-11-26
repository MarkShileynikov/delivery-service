package com.example.deliveryservice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.deliveryservice.database.MainDatabase

class SignInActivity : AppCompatActivity() {

    private lateinit var loginView: EditText
    private lateinit var passwordView: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpButton: FrameLayout
    private lateinit var error: TextView
    private lateinit var db: MainDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_signin)

        bindViews()

        db = MainDatabase.getInstance()
    }

    private fun bindViews() {
        loginView = findViewById(R.id.loginView)
        passwordView = findViewById(R.id.passwordView)
        signInButton = findViewById(R.id.signInButton)
        signUpButton = findViewById(R.id.signUpButton)
        error = findViewById(R.id.error)

        signUpButton.setOnClickListener {
            moveToSignUpScreen()
        }

        signInButton.setOnClickListener {
            signIn()
        }
    }

    private fun moveToSignUpScreen() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun signIn() {
        val login = loginView.text.toString().trim()
        val password = passwordView.text.toString().trim()

        if (login.isNotBlank() && password.isNotBlank()) {
            val userDao = db.getUserDao()

            if (userDao.getUser(login, password) != null) {
                Toast.makeText(this, "Вход выполнен успешно" , Toast.LENGTH_SHORT).show()
                moveToMainScreen()
                finish()
            }
            else {
                error.visibility = View.VISIBLE
                error.text = "Пользователь с такими данными не найден"
            }
        } else {
            Toast.makeText(this, "Заполните все поля" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}