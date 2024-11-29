package com.example.deliveryservice.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deliveryservice.database.entity.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE login = :login AND password = :password")
    fun getUser(login: String, password: String) : User

    @Query("SELECT COUNT(*) FROM users WHERE login = :login")
    fun checkIfUserExists(login: String) : Boolean

    @Query("SELECT id FROM users WHERE login = :login")
    fun getUserId(login: String) : Int
}