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
import com.example.deliveryservice.database.entity.User

class SignUpActivity : AppCompatActivity(){

    private lateinit var loginView: EditText
    private lateinit var passwordView: EditText
    private lateinit var confirmPasswordView: EditText
    private lateinit var signUpButton: Button
    private lateinit var signInButton: FrameLayout
    private lateinit var error: TextView
    private lateinit var db : MainDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        bindViews()

        db = MainDatabase.getInstance()
    }

    private fun bindViews() {
        loginView = findViewById(R.id.loginView)
        passwordView = findViewById(R.id.passwordView)
        confirmPasswordView = findViewById(R.id.confirmPasswordView)
        signUpButton = findViewById(R.id.signUpButton)
        signInButton = findViewById(R.id.signInButton)
        error = findViewById(R.id.error)

        signInButton.setOnClickListener {
            moveToSignInScreen()
        }

        signUpButton.setOnClickListener {
            signUp()
        }
    }

    private fun moveToSignInScreen() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun signUp() {
        val login = loginView.text.toString().trim()
        val password = passwordView.text.toString().trim()
        val confirmPassword = confirmPasswordView.text.toString().trim()

        if (password != confirmPassword) {
            error.visibility = View.VISIBLE
            error.text = "Пароли не совпадают"
        } else {
            error.visibility = View.INVISIBLE
        }

        if (login.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()) {
            val userDao = db.getUserDao()
            if (!userDao.checkIfUserExists(login)) {
                userDao.insertUser(
                    User(
                        login = login,
                        password = password
                    )
                )
                Toast.makeText(this, "Вы успешно зарегистрировались" , Toast.LENGTH_SHORT).show()
                moveToMainScreen()
            } else {
                Toast.makeText(this, "Данный пользователь уже зарегистрирован" ,Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, "Заполните все поля" ,Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}