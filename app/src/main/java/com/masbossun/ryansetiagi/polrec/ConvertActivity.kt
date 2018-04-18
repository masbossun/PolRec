package com.masbossun.ryansetiagi.polrec

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_convert.*

class ConvertActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)
        toolbar.setTitleTextColor(ContextCompat.getColor(applicationContext, R.color.textColor))
        setSupportActionBar(toolbar)

        rectangularButton.setOnClickListener {
            val firstText = firstVal.text.toString()
            val secondText = secondVal.text.toString()
            if (TextUtils.isEmpty(firstText) && TextUtils.isEmpty(secondText)){
                Toast.makeText(applicationContext, "Kolom harus diisi", Toast.LENGTH_SHORT).show()
            }else{
                toRec()
            }
        }
        polarButton.setOnClickListener {
            val firstText = firstVal.text.toString()
            val secondText = secondVal.text.toString()
            if (TextUtils.isEmpty(firstText) && TextUtils.isEmpty(secondText)){
                Toast.makeText(applicationContext, "Kolom harus diisi", Toast.LENGTH_SHORT).show()
            }else{
                toPol()
            }
        }

    }


    private fun toRadian(x: String): Double{
        return (x.toDouble() * Math.PI) / 180
    }


    // to Rectangular function ---------------

    private fun calculateX(r: String, deg: String): Double{
        return r.toDouble() * Math.cos( toRadian(deg) )
    }

    private fun calculateY(r: String, deg: String): Double{
        return r.toDouble() * Math.sin( toRadian(deg) )
    }

    private fun toRec(){
        val valR = firstVal.text.toString()
        val valDeg = secondVal.text.toString()

        val calX = calculateX(valR, valDeg).toString()
        val calY = Math.abs(calculateY(valR, valDeg)).toString()

        if (calculateY(valR, valDeg) > 0){
            if (calX.length > 15 && calY.length > 15){
                val newX = calX.substring(0, 15)
                val newY = calY.substring(0, 15)
                viewHasil.setText(getString(R.string.calculateRecPositive, newX, newY))
            }else{
                viewHasil.setText(getString(R.string.calculateRecPositive, calX, calY))
            }
        }else{
            if (calX.length > 15 && calY.length > 15){
                val newX = calX.substring(0, 15)
                val newY = calY.substring(0, 15)
                viewHasil.setText(getString(R.string.calculateRecNegative, newX, newY))
            }else{
                viewHasil.setText(getString(R.string.calculateRecNegative, calX, calY))
            }
        }
    }


    //To Polar Function ----------------

    private fun calculateR(x: String, y: String): Double{
        val exponent = 2.0
        return Math.sqrt( Math.pow(x.toDouble(),exponent) + Math.pow(y.toDouble(),exponent) )
    }

    private fun calculateDeg(x: String, y: String): Double{
        return ( Math.atan( y.toDouble() / x.toDouble() ) * 180 ) / Math.PI
    }

    private fun toPol(){
        val xVal = firstVal.text.toString()
        val yVal = secondVal.text.toString()

        val calR = calculateR(xVal, yVal).toString()
        val calDeg = calculateDeg(xVal, yVal).toString()

        if (calR.length >= 15 && calDeg.length >= 15){
            val newCalR = calR.substring(0, 15)
            val newCalDeg = calDeg.substring(0, 15)
            viewHasil.setText(
                    getString(R.string.calculatePol, newCalR, newCalDeg)
            )
        }else{
            viewHasil.setText(
                    getString(R.string.calculatePol, calR, calDeg)
            )
        }
    }

}