package com.example.deliveryservice.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.deliveryservice.database.entity.Restaurant

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurants")
    fun getRestaurants() : List<Restaurant>

    @Insert
    fun insertRestaurant(restaurant: Restaurant)
}