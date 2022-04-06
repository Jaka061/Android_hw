package com.kay.progayim

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.database.User

class EmpAdapter(private val click: (id: Long) -> Unit, private val del: (id: Long) -> Unit,
                 private val upd: (id: Long) -> Unit
) : RecyclerView.Adapter<EmpAdapter.ViewHolder>(){

    private var list = mutableListOf<User>()

    fun setData(list: List<User>) {
        this.list = list as MutableList<User>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item: View = LayoutInflater.from(parent.context).inflate(R.layout.recycle, parent, false)
        return ViewHolder(item , click , del ,upd )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emp = list[position]
        holder.bind(emp)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View, private val click: (id: Long) -> Unit,private val del: (id: Long) -> Unit,private val upd: (id: Long) -> Unit ) :
        RecyclerView.ViewHolder(itemView) {
            fun bind(emp: User) {
            val id = itemView.findViewById<AppCompatTextView>(R.id.dbId)
            val name = itemView.findViewById<AppCompatTextView>(R.id.dbName)
            val update = itemView.findViewById<AppCompatButton>(R.id.btnUpdate)
            val delete = itemView.findViewById<AppCompatButton>(R.id.btnDelete)

            id.text = emp.id.toString()
            name.text = emp.name

            itemView.setOnClickListener {
                Log.e("TAG00", "click id= ${emp.id}")
                click.invoke(emp.id!!)
            }
            update.setOnClickListener {
                upd.invoke(emp.id!!)
            }
            delete.setOnClickListener {
                 del.invoke(emp.id!!)
            }

        }
        }
}
