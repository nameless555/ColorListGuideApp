package com.nutchanok.colorlistguideapp.adapters

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nutchanok.colorlistguideapp.R
import com.nutchanok.colorlistguideapp.models.ListColor
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.list_user_color.view.*

class ColorAdapter(private val items: List<ListColor>, private val context: Context) :
    RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_user_color, null)
        itemLayoutView.layoutParams =
            RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

        return ViewHolder(itemLayoutView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {
        val id: TextView = itemsView.tvId
        val name: TextView = itemsView.tvName
        val year: TextView = itemsView.tvYear
        val color: TextView = itemsView.tvColor
        val pantone_value: TextView = itemsView.tv_pantone_value
        val ll: LinearLayout = itemsView.llColor

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.id.text = items[position].id.toString()
        holder.name.text = items[position].name.toString()
        holder.year.text = items[position].year.toString()
        holder.color.text = items[position].color.toString()
        holder.pantone_value.text = items[position].pantone_value.toString()
        holder.ll.setBackgroundColor(Color.parseColor(items[position].color))

        holder.ll?.setOnClickListener {
//            showDialog()
            Toast.makeText(context, holder.id.text, Toast.LENGTH_SHORT).show()

        }


    }

    fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("The message here")
        dialogBuilder.setPositiveButton("Done",
            DialogInterface.OnClickListener { dialog, whichButton -> })
        val b = dialogBuilder.create()
        b.show()
    }
}