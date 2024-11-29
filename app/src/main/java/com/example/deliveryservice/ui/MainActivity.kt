package com.example.deliveryservice.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryservice.R
import com.example.deliveryservice.database.MainDatabase
import com.example.deliveryservice.database.entity.Restaurant
import com.example.deliveryservice.ui.order.OrderActivity
import com.example.deliveryservice.ui.restaurant.RestaurantDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RestaurantAdapter
    private lateinit var db: MainDatabase
    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userId = intent.getIntExtra("USER_ID", 0)

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

        val orderButton : Button = findViewById(R.id.orders)

        orderButton.setOnClickListener {
            moveToOrdersScreen()
        }
    }

    private fun moveToRestaurantDetailsScreen(restaurant: Restaurant) {
        val intent = Intent(this, RestaurantDetailActivity::class.java)
        intent.putExtra("RESTAURANT_NAME", restaurant.name)
        intent.putExtra("RESTAURANT_PICTURE", restaurant.picture)
        intent.putExtra("RESTAURANT_DESCRIPTION", restaurant.description)
        intent.putExtra("USER_ID", userId)

        startActivity(intent)
    }

    private fun moveToOrdersScreen() {
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("USER_ID", userId)
        startActivity(intent)
    }
}