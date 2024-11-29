package com.example.deliveryservice.ui.order

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryservice.R
import com.example.deliveryservice.database.MainDatabase
import com.example.deliveryservice.database.entity.Order

class OrderActivity : AppCompatActivity() {

    private lateinit var db: MainDatabase
    private lateinit var adapter: OrderAdapter
    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_order)

        userId = intent.getIntExtra("USER_ID", 0)

        db = MainDatabase.getInstance()

        bindViews()
    }

    private fun bindViews() {
        val orderDao = db.getOrderDao()

        val orderList = orderDao.getOrders(userId)

        if (orderList.isNotEmpty()) {
            val recyclerView: RecyclerView = findViewById(R.id.orderList)
            recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = OrderAdapter(orderList) { orderId, position ->
                orderDao.deleteOrder(orderId)
                adapter.removeItem(position)
                if (adapter.orders.isEmpty()) {
                    findViewById<FrameLayout>(R.id.noOrders).visibility = View.VISIBLE
                }
            }
            recyclerView.adapter = adapter
        } else {
            findViewById<FrameLayout>(R.id.noOrders).visibility = View.VISIBLE
        }
    }

}