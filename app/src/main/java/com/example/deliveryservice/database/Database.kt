package com.example.deliveryservice.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deliveryservice.App
import com.example.deliveryservice.database.dao.RestaurantDao
import com.example.deliveryservice.database.dao.UserDao
import com.example.deliveryservice.database.entity.Restaurant
import com.example.deliveryservice.database.entity.User

@Database(entities = [User::class, Restaurant::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getUserDao() : UserDao
    abstract fun getRestaurantDao() : RestaurantDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getInstance() : MainDatabase {
            val tempInstance =  INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance =  Room.databaseBuilder(
                    App.instance,
                    MainDatabase::class.java,
                    "database"
                ).allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }
}