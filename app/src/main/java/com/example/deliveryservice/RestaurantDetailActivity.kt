package com.example.deliveryservice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RestaurantDetailActivity : AppCompatActivity() {

    private lateinit var restaurantPictureView: ImageView
    private lateinit var restaurantNameView : TextView
    private lateinit var restaurantDescriptionView: TextView
    private lateinit var orderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        bindViews()
    }

    private fun bindViews() {
        val restaurantPicture = intent.getIntExtra("RESTAURANT_PICTURE", 0)
        val restaurantName = intent.getStringExtra("RESTAURANT_NAME") ?: ""
        val restaurantDescription = intent.getStringExtra("RESTAURANT_DESCRIPTION") ?: ""

        restaurantPictureView = findViewById(R.id.picture)
        restaurantNameView = findViewById(R.id.restaurantName)
        restaurantDescriptionView = findViewById(R.id.description)
        orderButton = findViewById(R.id.order)

        restaurantPictureView.setImageResource(restaurantPicture)
        restaurantNameView.text = restaurantName
        restaurantDescriptionView.text = restaurantDescription

        orderButton.setOnClickListener {
            Toast.makeText(this, "Заказ оформлен!" , Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}