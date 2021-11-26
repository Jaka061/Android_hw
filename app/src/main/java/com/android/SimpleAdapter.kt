package com.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(private val click: (pos: Int) -> Unit) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    private var list = listOf<String>()

    fun setData(list:List<String>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleAdapter.ViewHolder {
        val itemView:View = LayoutInflater.from(parent.context).inflate(R.layout.recycler,parent,false)
        return ViewHolder(itemView, click )
    }

    override fun onBindViewHolder(holder: SimpleAdapter.ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class  ViewHolder(itemView:View,private  val click:(pos:Int) -> Unit)
        : RecyclerView.ViewHolder(itemView){

            fun bind (item:String){
                val txt = itemView.findViewById<AppCompatTextView>(R.id.item_rec)
                txt.text = item
                itemView.setOnClickListener{
                    click.invoke(adapterPosition)  // *
                }
            }

    }
}