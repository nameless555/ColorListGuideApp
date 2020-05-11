package com.nutchanok.colorlistguideapp.fragments

import android.os.Bundle
import android.view.*
import android.view.SurfaceControl.Transaction
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.colorlistguideapp.R
import com.nutchanok.colorlistguideapp.adapters.ColorAdapter
import com.nutchanok.colorlistguideapp.adapters.FavouriteAdapter
import com.nutchanok.colorlistguideapp.models.FavColor
import kotlinx.android.synthetic.main.fragment_list.*

class FavFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fav, container, false)

        val view = inflater.inflate(R.layout.fragment_fav, container, false)
        val toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.inflateMenu(R.menu.menu)
        toolbar?.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val transactionList: ArrayList<FavColor> =
                (arguments!!.getSerializable("key")) as ArrayList<FavColor>

            recyclerView.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, //แนว
                false
            )

            recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

            recyclerView.adapter = FavouriteAdapter(transactionList, context!!)

        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }
}
