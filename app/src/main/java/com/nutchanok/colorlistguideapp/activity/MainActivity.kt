package com.nutchanok.colorlistguideapp.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.android.material.tabs.TabLayout
import com.nutchanok.colorlistguideapp.R
import com.nutchanok.colorlistguideapp.fragments.FavFragment
import com.nutchanok.colorlistguideapp.fragments.ListFragment
import com.nutchanok.colorlistguideapp.models.FavColor


class MainActivity : AppCompatActivity() {

    var lifav: ArrayList<FavColor>? = ArrayList()
    var transactionList: ArrayList<FavColor> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mMessageReceiver, IntentFilter("custom-message"));

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

//                        tabLayout.getTabAt(0)!!.text = "List"
                    }
                    tabLayout.getTabAt(1) -> {

//                        val bundle = Bundle()
//                        bundle.putSerializable("key", lifav)
//
//                        supportFragmentManager
//                            .beginTransaction()
//                            .replace(R.id.contentContainer, FavFragment())
//                            .addToBackStack(null)
//                            .commit()
//                        tabLayout.getTabAt(1)!!.text = "Fav"

//                        val expsenseTransaction: FragmentTransaction =
//                            supportFragmentManager.beginTransaction()
//
//                        val bundle = Bundle()
//                        bundle.putSerializable("key", lifav)
//                        expsenseTransaction
//                        .replace(R.id.contentContainer, FavFragment())
//                        .commit()


                        val bundle = Bundle()
                        bundle.putSerializable("key", lifav)
                        val myFragment = FavFragment()
                        myFragment.arguments = bundle
                        var fragmentTransaction = supportFragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.contentContainer, myFragment)
                        fragmentTransaction.commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }


    var mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(
            context: Context?,
            intent: Intent
        ) {
            val itemId = intent.getIntExtra("itemId", 0)
            val itemName = intent.getStringExtra("itemName")
            val itemYear = intent.getIntExtra("itemYear", 0)
            val itemColor = intent.getStringExtra("itemColor")
            val itemPantone = intent.getStringExtra("itemPantone")


            lifav?.add(
                FavColor(
                    id = itemId,
                    name = itemName,
                    year = itemYear,
                    color = itemColor,
                    pantone_value = itemPantone
                )
            )

            Toast.makeText(this@MainActivity, "$itemId $itemName", Toast.LENGTH_SHORT).show()
        }
    }


}
