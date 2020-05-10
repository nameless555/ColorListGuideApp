package com.nutchanok.colorlistguideapp.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.colorlistguideapp.R
import com.nutchanok.colorlistguideapp.adapters.ColorAdapter
import com.nutchanok.colorlistguideapp.adapters.FavouriteAdapter
import com.nutchanok.colorlistguideapp.models.ListColor
import com.nutchanok.colorlistguideapp.models.ListColorResponse
import com.nutchanok.colorlistguideapp.services.MainPresenter
import com.nutchanok.colorlistguideapp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, View.OnClickListener {

    private val presenter: MainPresenter = MainPresenter(this)
    var datalth: List<ListColor>? = null
    var datahtl: List<ListColor>? = null
    var b1 = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getListColor()
        btnlist.setOnClickListener(this)
        btnFavourite.setOnClickListener(this)
    }

    override fun setUserColor(listColorResponse: ListColorResponse) {


        var i: List<ListColor> = listColorResponse.data
        datahtl = i.sortedByDescending { it.year }
        datalth = i.sortedBy { it.year }



        recyclerView.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL, //แนว
            false
        )

        recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

        recyclerView.adapter = ColorAdapter(listColorResponse.data, application)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.lth -> {// About option clicked.}

                recyclerView.layoutManager = LinearLayoutManager(
                    applicationContext,
                    LinearLayoutManager.VERTICAL, //แนว
                    false
                )

                recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

                if (b1 == 1) {
                    recyclerView.adapter = ColorAdapter(datalth!!, application)

                } else {
                    recyclerView.adapter = FavouriteAdapter(datalth!!, application)

                }
                true

            }
            R.id.htl -> {
                recyclerView.layoutManager = LinearLayoutManager(
                    applicationContext,
                    LinearLayoutManager.VERTICAL, //แนว
                    false
                )

                recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

                if (b1 == 1) {
                    recyclerView.adapter = ColorAdapter(datahtl!!, application)

                } else {
                    recyclerView.adapter = FavouriteAdapter(datalth!!, application)

                }
                true
            }
            else -> {
                false
            }
        }
    }


    override fun onClick(v: View?) {

        when (v!!.id) {
            btnlist.id -> {
                b1 = 1
                recyclerView.layoutManager = LinearLayoutManager(
                    applicationContext,
                    LinearLayoutManager.VERTICAL, //แนว
                    false
                )

                recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?
                recyclerView.adapter = ColorAdapter(datalth!!, application)

            }
            btnFavourite.id -> {


                b1 = 0
                recyclerView.layoutManager = LinearLayoutManager(
                    applicationContext,
                    LinearLayoutManager.VERTICAL, //แนว
                    false
                )

                recyclerView.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?
                recyclerView.adapter = FavouriteAdapter(datalth!!, application)

            }
        }
    }


}
