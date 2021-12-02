package com.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.android.databinding.ActivityMainBinding
import com.android.databinding.RecycleBinding

class SimpleAdapter (
    private val click: (pos: Int) -> Unit) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<String>()
    private lateinit var binding : RecycleBinding

    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.recycle, parent, false)

        //binding = RecycleBinding.inflate(bindViewHolder()
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        itemView: View,
        private val click: (pos: Int) -> Unit ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: String) {

            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_txt)
            txt.text = item
            itemView.setOnClickListener {
                click.invoke(adapterPosition)
            }
        }
    }
}