package com.example.deliveryservice.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "restaurant_name")
    val restaurantName: String,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    val date: String,
)