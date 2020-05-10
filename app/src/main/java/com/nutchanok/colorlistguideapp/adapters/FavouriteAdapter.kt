package com.nutchanok.colorlistguideapp.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.colorlistguideapp.R
import com.nutchanok.colorlistguideapp.models.ListColor
import kotlinx.android.synthetic.main.list_user_color.view.*


class FavouriteAdapter(private val items: List<ListColor>, val context: Context) :
    RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

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
            Toast.makeText(context, holder.id.text, Toast.LENGTH_SHORT).show()

        }


    }


}