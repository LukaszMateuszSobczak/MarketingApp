package com.lukaszsobczak.marketingapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.lukaszsobczak.marketingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPreview.setOnClickListener {

            onPreviewClick()
        }

    }

    private fun onPreviewClick() {
//        Log.d("This my TAG", "contactNameEditText = " + contactNameEditText!!.toString())
        val contactName = binding.inputEditTextContactName.text.toString()
        val contactNumber = binding.inputEditTextContactNumber.text.toString()
        val displayName = binding.inputEditTextContactDisplayName.text.toString()
        val availableDate = binding.inputEditTextAvailableDate.text.toString()
        val junior = binding.checkBoxJunior.isChecked
        val immediateStart = binding.checkBoxImmediateStart.isChecked
        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()


        var message: String = "Name: $contactName, Number: $contactNumber, Display name: $displayName, Available date: $availableDate, Junior: $junior, Immediate start: $immediateStart, Job title: $jobTitle"

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }


}