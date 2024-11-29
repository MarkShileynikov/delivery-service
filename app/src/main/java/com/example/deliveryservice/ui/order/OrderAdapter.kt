package com.example.deliveryservice.ui.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryservice.R
import com.example.deliveryservice.database.entity.Order

class OrderAdapter(
    val orders: MutableList<Order>,
    private val onClick : (Int, Int) -> Unit
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orders[position])

        holder.cancelOrder.setOnClickListener {
            onClick(orders[position].id, position)
        }
    }

    fun removeItem(position: Int) {
        orders.removeAt(position)
        notifyDataSetChanged()
    }

    class OrderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val restaurantName: TextView = itemView.findViewById(R.id.restaurantName)
        private val orderId: TextView = itemView.findViewById(R.id.orderId)
        private val date: TextView = itemView.findViewById(R.id.date)
        val cancelOrder: TextView = itemView.findViewById(R.id.cancelOrder)

        fun bind(order: Order) {
            this.restaurantName.text = order.restaurantName
            this.orderId.text = "Номер заказа: ${order.id}"
            this.date.text = order.date
        }
    }
}