package com.nutchanok.colorlistguideapp.fragments

import android.app.Application
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.colorlistguideapp.R
import com.nutchanok.colorlistguideapp.activity.MainActivity
import com.nutchanok.colorlistguideapp.adapters.ColorAdapter
import com.nutchanok.colorlistguideapp.models.ListColor
import com.nutchanok.colorlistguideapp.models.ListColorResponse
import com.nutchanok.colorlistguideapp.services.MainPresenter
import com.nutchanok.colorlistguideapp.views.MainView
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), MainView {
    private val presenter: MainPresenter = MainPresenter(this)
    var datalth: List<ListColor>? = null
    var datahtl: List<ListColor>? = null
    var b1 = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val toolbar = view?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.inflateMenu(R.menu.menu)
        toolbar?.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getListColor()

    }

    override fun setUserColor(listColorResponse: ListColorResponse) {

        var i: List<ListColor> = listColorResponse.data
        datahtl = i.sortedByDescending { it.year }
        datalth = i.sortedBy { it.year }

        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, //แนว
            false
        )

        recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

        recyclerView.adapter = ColorAdapter(listColorResponse.data, context!!)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.lth -> {

                recyclerView.layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL, //แนว
                    false
                )

                recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

                recyclerView.adapter = ColorAdapter(datalth!!, activity!!)

                true

            }
            R.id.htl -> {
                recyclerView.layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL, //แนว
                    false
                )

                recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

                recyclerView.adapter = ColorAdapter(datahtl!!, activity!!)

                true

            }
            else -> false

        }
    }


}
