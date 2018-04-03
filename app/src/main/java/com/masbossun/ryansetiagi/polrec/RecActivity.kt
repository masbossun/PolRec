package com.masbossun.ryansetiagi.polrec

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * Created by Ryan Setiagi on 28/03/2018.
 */
class RecActivity : Fragment() {

    private var textView: TextView? = null
    private var rValue: EditText? = null
    private var degValue: EditText? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceStae: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.layout_rec, container, false)

        textView = view.findViewById<View>(R.id.viewHasil) as TextView
        rValue = view.findViewById<View>(R.id.valR) as EditText
        degValue = view.findViewById<View>(R.id.valDeg) as EditText

        val button = view.findViewById<View>(R.id.viewCalculate) as Button
        button.setOnClickListener(View.OnClickListener { buttonClicked(view) })


        return view
    }

    private fun toRadian(x: String): Double{
        val X = (x.toDouble() * Math.PI) / 180
        return X
    }

    private fun calculateX(r: String, deg: String): Double{
        val x = r.toDouble() * Math.cos( toRadian(deg) )
        return x
    }

    private fun calculateY(r: String, deg: String): Double{
        val y = r.toDouble() * Math.sin( toRadian(deg) )
        return y
    }

    private fun buttonClicked(view: View){
        val valR = rValue?.text.toString()
        val valDeg = degValue?.text.toString()

        val calX = calculateX(valR, valDeg).toString()
        val calY = Math.abs(calculateY(valR, valDeg)).toString()

        if (calculateY(valR, valDeg) > 0){
            if (calX.length > 15 && calY.length > 15){
                val newX = calX.substring(0, 15)
                val newY = calY.substring(0, 15)
                textView?.setText(getString(R.string.calculateRecPositive, newX, newY))
            }else{
                textView?.setText(getString(R.string.calculateRecPositive, calX, calY))
            }
        }else{
            if (calX.length > 15 && calY.length > 15){
                val newX = calX.substring(0, 15)
                val newY = calY.substring(0, 15)
                textView?.setText(getString(R.string.calculateRecNegative, newX, newY))
            }else{
                textView?.setText(getString(R.string.calculateRecNegative, calX, calY))
            }
        }

    }



    companion object {
        fun newInstance(): RecActivity = RecActivity()
    }

}