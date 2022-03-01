package com.kay.progayim

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class EmpAdapter(private val click: (id: Long) -> Unit) : RecyclerView.Adapter<EmpAdapter.ViewHolder>(){

    private var list = listOf<Item>()

    fun setData(list: List<Item>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle, parent, false)
        return ViewHolder(item , click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View, private val click: (id: Long) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item) {
            val title = itemView.findViewById<AppCompatTextView>(R.id.Title)
            title.text = item.title

            itemView.setOnClickListener {
                click.invoke(item.episode_id!!)
            }
        }
    }
}
