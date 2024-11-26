package com.example.deliveryservice

import android.app.Application
import com.example.deliveryservice.database.MainDatabase
import com.example.deliveryservice.database.util.provideRestaurantList

class App : Application() {
    companion object {
        lateinit var instance : App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        val db = MainDatabase.getInstance()
        val restaurantDao = db.getRestaurantDao()

        if (restaurantDao.getRestaurants().isEmpty()) {
            provideRestaurantList().forEach { restaurant ->
                restaurantDao.insertRestaurant(restaurant)
            }
        }
    }
}