package com.example.deliveryservice.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name: String,
    val picture: Int,
    val description: String,
)