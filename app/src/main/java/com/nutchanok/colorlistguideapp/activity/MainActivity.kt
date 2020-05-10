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
import com.google.android.material.tabs.TabLayout
import com.nutchanok.colorlistguideapp.R
import com.nutchanok.colorlistguideapp.adapters.ColorAdapter
import com.nutchanok.colorlistguideapp.adapters.FavouriteAdapter
import com.nutchanok.colorlistguideapp.fragments.FavFragment
import com.nutchanok.colorlistguideapp.fragments.ListFragment
import com.nutchanok.colorlistguideapp.models.ListColor
import com.nutchanok.colorlistguideapp.models.ListColorResponse
import com.nutchanok.colorlistguideapp.services.MainPresenter
import com.nutchanok.colorlistguideapp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, ListFragment())
                .commit()
        }

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        tabLayout.addTab(tabLayout.newTab().setText("List"))
        tabLayout.addTab(tabLayout.newTab().setText("Fav"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                when (tab) {
                    tabLayout.getTabAt(0) -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.contentContainer, ListFragment())
                            .addToBackStack(null)
                            .commit()

                        tabLayout.getTabAt(0)!!.text = "List"
                    }
                    tabLayout.getTabAt(1) -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.contentContainer, FavFragment())
                            .addToBackStack(null)
                            .commit()
                        tabLayout.getTabAt(1)!!.text = "Fav"
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }


}
