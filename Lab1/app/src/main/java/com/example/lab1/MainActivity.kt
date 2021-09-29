package com.example.lab1

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val editText: EditText = findViewById(R.id.ediText)
        val sansSerifButton: RadioButton = findViewById(R.id.radioButton1)
        val monospaceButton: RadioButton = findViewById(R.id.radioButton2)
        val serifButton: RadioButton = findViewById(R.id.radioButton3)
        val okButton: Button = findViewById(R.id.button1)
        val cancelButton: Button = findViewById(R.id.button2)

        okButton.setOnClickListener {
            val text = editText.text.toString()
            if (text.isNotEmpty()) {
                var font: Typeface = Typeface.DEFAULT

                when {
                    sansSerifButton.isChecked -> {
                        font = Typeface.SANS_SERIF
                    }
                    monospaceButton.isChecked -> {
                        font = Typeface.MONOSPACE
                    }
                    serifButton.isChecked -> {
                        font = Typeface.SERIF
                    }
                }

                textView.text = text
                textView.typeface = font
            } else {
                textView.text = ""
                Toast.makeText(applicationContext, "Input field is empty", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        cancelButton.setOnClickListener {
            textView.text = ""
            editText.text.clear()
            sansSerifButton.isChecked = true
            monospaceButton.isChecked = false
            serifButton.isChecked = false
        }

    }
}