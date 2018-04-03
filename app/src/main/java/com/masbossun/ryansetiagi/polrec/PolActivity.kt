package com.masbossun.ryansetiagi.polrec

import android.content.Context
import android.os.Bundle
import android.support.annotation.MainThread
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.view.ContextThemeWrapper
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.pow
import java.math.BigDecimal
import java.util.zip.Inflater
import kotlin.math.sqrt


class PolActivity : Fragment(){

    private var textView: TextView? = null
    private var xValue: EditText? = null
    private var yValue: EditText? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.layout_pol, container, false)

        textView = view.findViewById<View>(R.id.viewHasil) as TextView
        xValue = view.findViewById<View>(R.id.valX) as EditText
        yValue = view.findViewById<View>(R.id.valY) as EditText

        val button = view.findViewById<View>(R.id.viewCalculate) as Button
        button.setOnClickListener(
                View.OnClickListener {
                    buttonClicked(view)
                }
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

    private fun buttonClicked(view: View){
        val xVal = xValue?.text.toString()
        val yVal = yValue?.text.toString()

        val calR = calculateR(xVal, yVal).toString()
        val calDeg = calculateDeg(xVal, yVal).toString()

        if (calR.length >= 15 && calDeg.length >= 15){
            val newCalR = calR.substring(0, 15)
            val newCalDeg = calDeg.substring(0, 15)
            textView?.setText(
                    getString(R.string.calculatePol, newCalR, newCalDeg)
            )
        }else{
            textView?.setText(
                    getString(R.string.calculatePol, calR, calDeg)
            )
        }

    }

    companion object {
        fun newInstance(): PolActivity = PolActivity()
    }

}