package com.example.areaapp2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    private lateinit var widthWidget: EditText
    private lateinit var heightWidget: EditText
    private lateinit var resultWidget: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        widthWidget = findViewById(R.id.widthEditText)
        heightWidget = findViewById(R.id.heightEditText)
        resultWidget = findViewById(R.id.resultTextView)

        widthWidget.doAfterTextChanged {
            calculateArea()
        }

        heightWidget.doAfterTextChanged {
            calculateArea()
        }
    }

    fun calculateArea() {
        val width = widthWidget.text.toString().toDoubleOrNull()
        val height = heightWidget.text.toString().toDoubleOrNull()

        if (width == null || height == null) {
            return
        }

        val area = width * height

        val message = "Result is"
        val displayMessage = "$message $area"

        resultWidget.text = displayMessage
    }
}