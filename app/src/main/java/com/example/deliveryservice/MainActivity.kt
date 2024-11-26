package com.example.deliveryservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryservice.database.MainDatabase
import com.example.deliveryservice.database.entity.Restaurant

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RestaurantAdapter
    private lateinit var db: MainDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MainDatabase.getInstance()

        bindViews()
    }

    private fun bindViews() {
        val restaurantDao = db.getRestaurantDao()

        val restaurantList = restaurantDao.getRestaurants()

        val recyclerView: RecyclerView = findViewById(R.id.restaurantList)
        adapter = RestaurantAdapter(restaurantList) { restaurant ->
            moveToRestaurantDetailsScreen(restaurant)
        }
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    private fun moveToRestaurantDetailsScreen(restaurant: Restaurant) {
        val intent = Intent(this, RestaurantDetailActivity::class.java)
        intent.putExtra("RESTAURANT_NAME", restaurant.name)
        intent.putExtra("RESTAURANT_PICTURE", restaurant.picture)
        intent.putExtra("RESTAURANT_DESCRIPTION", restaurant.description)
        startActivity(intent)
    }
}