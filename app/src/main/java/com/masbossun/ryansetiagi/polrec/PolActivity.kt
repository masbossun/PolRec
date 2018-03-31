package com.masbossun.ryansetiagi.polrec

import android.content.Context
import android.os.Bundle
import android.support.annotation.MainThread
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.pow
import kotlin.math.sqrt


class PolActivity : Fragment(){

    private var textViewR: TextView? = null
    private var textViewDeg: TextView? = null
    private var xValue: EditText? = null
    private var yValue: EditText? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.layout_pol, container, false)

        textViewR = view.findViewById<View>(R.id.viewHasilR) as TextView
        textViewDeg = view.findViewById<View>(R.id.viewHasilDeg) as TextView
        xValue = view.findViewById<View>(R.id.valX) as EditText
        yValue = view.findViewById<View>(R.id.valY) as EditText

        val button = view.findViewById<View>(R.id.viewCalculate) as Button
        button.setOnClickListener(
                View.OnClickListener { buttonClicked(view) }
        )

        return view
    }

    private fun calculateR(x: String, y: String): Double{
        val exponent = 2.0
        val r = Math.sqrt( Math.pow(x.toDouble(),exponent) + Math.pow(y.toDouble(),exponent) )
        return r
    }

    private fun calculateDeg(x: String, y: String): Double{
        val deg = ( Math.atan( y.toDouble() / x.toDouble() ) * 180 ) / Math.PI
        return deg
    }

    fun buttonClicked(view: View){
        val xVal = xValue?.text.toString()
        val yVal = yValue?.text.toString()

        val calR = calculateR(xVal, yVal)
        val calDeg = calculateDeg(xVal, yVal)

        textViewR?.setText(calR.toString())
        textViewDeg?.setText(calDeg.toString())
    }

    companion object {
        fun newInstance(): PolActivity = PolActivity()
    }

}