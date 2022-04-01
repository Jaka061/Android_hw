package com.kay.progayim.ui.main.rv

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.data.models.Characters

class CharacterAdapter(private val listener: Listener): RecyclerView.Adapter<ViewHolder>() {

    private var list = listOf<Characters>()

    fun setData(list: List<Characters>) {
        this.list = list
        notifyDataSetChanged()
        Log.e("id","kkkhh")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

     interface Listener{
        fun click(index: Int)

    }

}