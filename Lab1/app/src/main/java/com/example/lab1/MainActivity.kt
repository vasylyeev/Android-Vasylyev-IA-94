package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.lab1.fragments.InputFragment
import com.example.lab1.fragments.OutputFragment

class MainActivity : AppCompatActivity(), InputFragment.OnTextSent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFragment = InputFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, inputFragment)
            .commit()
    }

    override fun sendData(
        editTextInput: String,
        sansSerifButtonChecked: Boolean,
        monospaceButtonChecked: Boolean,
        serifButtonChecked: Boolean
    ) {
        val outputFragment = OutputFragment()
        val bundle = Bundle()

        if (editTextInput.isNotEmpty()) {
            bundle.putString("editTextInput", editTextInput)
            bundle.putBoolean("sansSerifButtonChecked", sansSerifButtonChecked)
            bundle.putBoolean("monospaceButtonChecked", monospaceButtonChecked)
            bundle.putBoolean("serifButtonChecked", serifButtonChecked)

            outputFragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, outputFragment).addToBackStack(null).commit()

        } else {
            Toast.makeText(applicationContext, "Input field empty!", Toast.LENGTH_SHORT).show()
        }
    }
}