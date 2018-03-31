package com.masbossun.ryansetiagi.polrec

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ryan Setiagi on 28/03/2018.
 */
class RecActivity : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceStae: Bundle?): View? =
            inflater!!.inflate(R.layout.layout_rec, container, false)

    companion object {
        fun newInstance(): RecActivity = RecActivity()
    }

}