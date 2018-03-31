package com.masbossun.ryansetiagi.polrec

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Ryan Setiagi on 28/03/2018.
 */
class SampleAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? =
            when(position){
                0 -> RecActivity.newInstance()
                1 -> PolActivity.newInstance()
                else -> null
            }

    override fun getPageTitle(position: Int): CharSequence =
            when(position){
                0 -> "Rectangular"
                1 -> "Polar"
                else -> ""
            }

    override fun getCount(): Int = 2
}