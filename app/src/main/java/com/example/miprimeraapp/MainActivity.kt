package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun convertBinary(view: View) {
        val editText = findViewById<TextView>(R.id.countText)
        val binaryNumber = findViewById<EditText>(R.id.editTextBinary)
        val constant = 2.0

        var length: Int =  binaryNumber.length()
        val binary: String = binaryNumber.text.toString()
        var result = 0

        val isInRange: Boolean = length in 1..8

        if(isInRange){
            for(i in binary) {
                result += (i.digitToInt() * constant.pow((length - 1).toDouble())).toInt()
                if(i.digitToInt() !in 0..1){
                    result = 0
                    break
                }
                length--
            }
        }

        editText.apply { text = result.toString() }
    }

}