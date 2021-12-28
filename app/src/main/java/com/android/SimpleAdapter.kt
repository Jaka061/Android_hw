package com.android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SimpleAdapter (
    private val click: (pos: Int) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler, parent, false)
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
            val image = itemView.findViewById<AppCompatImageView>(R.id.img)

            val url = "https://avatarko.ru/img/kartinka/33/multfilm_lyagushka_32117.jpg"
            val url2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfLjvJPiDLSI0kLBSdw2Zw3A71najuxfyqMqaCPECIOJeVgLDF_zMSyZgJH3QQMtqzSFc&usqp=CAU"
            if (adapterPosition % 2 == 0 ) {
                Glide.with(itemView.context).load(url).into(image)
            }else{
                Glide.with(itemView.context).load(url2).into(image)
            }

            txt.text = item
            itemView.setOnClickListener {
                click.invoke(adapterPosition)
            }
        }
    }

}