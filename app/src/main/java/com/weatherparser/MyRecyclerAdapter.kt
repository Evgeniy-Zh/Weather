package com.weatherparser

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.weatherparser.data.Forecast
import kotlinx.android.synthetic.main.list_item.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MyRecyclerAdapter : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {
    var list: List<Forecast> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var listener: ItemClickListener? = null

    override fun onCreateViewHolder(view: ViewGroup, itemType: Int): MyViewHolder {
        val view1 = LayoutInflater.from(view.context).inflate(R.layout.list_item, view, false)
        val myViewHolder = MyViewHolder(view1)
        myViewHolder.itemView.setOnClickListener {
            val position = myViewHolder.adapterPosition
            listener?.onItemClick(position)
        }
        return myViewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, pos: Int) {
        myViewHolder.date.text = SimpleDateFormat
            .getDateInstance()
            .format(Date(list[pos].dateTs * 1000))

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var date: TextView = itemView.date

    }

    interface ItemClickListener {
        fun onItemClick(pos: Int)

        fun onItemLongClick(pos: Int)
    }
}
