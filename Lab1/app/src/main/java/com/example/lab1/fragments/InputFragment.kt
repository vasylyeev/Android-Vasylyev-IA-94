package com.example.lab1.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.lab1.R
import java.lang.ClassCastException

class InputFragment : Fragment() {

    private lateinit var onTextSentListener: OnTextSent

    interface OnTextSent {
        fun sendData(
            editTextInput: String,
            sansSerifButtonChecked: Boolean,
            monospaceButtonChecked: Boolean,
            serifButtonChecked: Boolean
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onTextSentListener = context as OnTextSent
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + " must implement onTextSent"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val editText: EditText = view?.findViewById(R.id.ediText) as EditText
        val sansSerifButton: RadioButton = view?.findViewById(R.id.radioButton1) as RadioButton
        val monospaceButton: RadioButton = view?.findViewById(R.id.radioButton2) as RadioButton
        val serifButton: RadioButton = view?.findViewById(R.id.radioButton3) as RadioButton
        val okButton: Button = view?.findViewById(R.id.button1) as Button
        val cancelButton: Button = view?.findViewById(R.id.button2) as Button

        var sansSerifButtonChecked = false
        var monospaceButtonChecked = false
        var serifButtonChecked = false

        okButton.setOnClickListener {
            val editTextInput = editText.text.toString()

            when {
                sansSerifButton.isChecked -> {
                    sansSerifButtonChecked = true
                }
                monospaceButton.isChecked -> {
                    monospaceButtonChecked = true
                }
                serifButton.isChecked -> {
                    serifButtonChecked = true
                }
            }
            passData(
                editTextInput,
                sansSerifButtonChecked,
                monospaceButtonChecked,
                serifButtonChecked
            )
        }

        cancelButton.setOnClickListener {
            editText.text.clear()
            sansSerifButton.isChecked = true
            monospaceButton.isChecked = false
            serifButton.isChecked = false
        }
    }

    private fun passData(
        editTextInput: String,
        sansSerifButtonChecked: Boolean,
        monospaceButtonChecked: Boolean,
        serifButtonChecked: Boolean
    ) {
        onTextSentListener.sendData(
            editTextInput,
            sansSerifButtonChecked,
            monospaceButtonChecked,
            serifButtonChecked
        )
    }

}