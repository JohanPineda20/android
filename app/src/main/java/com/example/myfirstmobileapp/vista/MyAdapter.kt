package com.example.myfirstmobileapp.vista

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    val totalTabs: Int): FragmentPagerAdapter(fm){

    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                Tienda()
            }
            1 -> {
                MisTiendas()
            }
            2 -> {
                Productos()
            }
            else -> getItem(position)
        }

    }
}