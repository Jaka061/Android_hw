package com.kay.progayim


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.database.Employee

class EmpAdapter(val context: Context, private val click: (item: Long) -> Unit) : RecyclerView.Adapter<EmpAdapter.ViewHolder>(){

    private var list = listOf<Employee>()
    fun setData(list: List<Employee>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emp = list[position]
        holder.bind(emp)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View, private val click: (id: Long) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(item: Employee) {
            val id = itemView.findViewById<AppCompatTextView>(R.id.dbId)
            val name = itemView.findViewById<AppCompatTextView>(R.id.dbName)
            val update = itemView.findViewById<AppCompatButton>(R.id.btnUpdate)
            val delete = itemView.findViewById<AppCompatButton>(R.id.btnDelete)

            id.text = item.id.toString()
            name.text = item.name

            update.setOnClickListener {
                click.invoke(item.id!!)
            }
4
//            delete.setOnClickListener {
//                val builder1 = AlertDialog.Builder(context)
//                builder1.setMessage("Are you sure you want to delete this Emp")
//                builder1.setCancelable(true)
//
//                builder1.setPositiveButton("Yes") {
//                        dialog, id -> click.invoke(item.id!!)
//                }
//                builder1.setNegativeButton("No") {
//                        dialog, id -> dialog.cancel()
//                }
//                val alert11 = builder1.create()
//                alert11.show()
//            }
            itemView.setOnClickListener {
                click.invoke(item.id!!)
            }
        }
    }
}
