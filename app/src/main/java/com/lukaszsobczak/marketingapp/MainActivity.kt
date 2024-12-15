package com.lukaszsobczak.marketingapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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

        // using binding to get all the views id
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createSpinner()

        binding.buttonPreview.setOnClickListener {
            onPreviewClick()
        }

    }

    private fun onPreviewClick() {

        val messageData = Message(
            binding.inputEditTextContactName.text.toString(),
            binding.inputEditTextContactNumber.text.toString(),
            binding.inputEditTextContactDisplayName.text.toString(),
            binding.inputEditTextAvailableDate.text.toString(),
            binding.checkBoxJunior.isChecked,
            binding.checkBoxImmediateStart.isChecked,
            binding.spinnerJobTitle.selectedItem.toString()
        )




        // creating an explicit intent to start a new activity
        val previewActivityIntent = Intent(
            this, PreviewActivity::class.java
        )


        // passing the data to the new activity using serialization
        previewActivityIntent.putExtra("message", messageData)
        // starting the new activity
        startActivity(previewActivityIntent)


    }

    fun createSpinner() {
        // creating a spinner value array
        val spinnerValue: Array<String> = arrayOf(
            "android developer", "ios developer", "backend developer",
            "frontend developer", "designer", "ux designer", "ui designer"
        )

        //creating adapter for the spinner
        val spinnerAdapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_dropdown_item,
            spinnerValue
        )

        //setting the adapter to the spinner
        binding.spinnerJobTitle.adapter = spinnerAdapter

    }

    fun onPreviewClickOld() {
        //Log.d("This my TAG", "contactNameEditText = " + contactNameEditText!!.toString())

        // getting the data from the views
        val contactName = binding.inputEditTextContactName.text.toString()
        val contactNumber = binding.inputEditTextContactNumber.text.toString()
        val displayName = binding.inputEditTextContactDisplayName.text.toString()
        val availableDate = binding.inputEditTextAvailableDate.text.toString()
        val junior = binding.checkBoxJunior.isChecked
        val immediateStart = binding.checkBoxImmediateStart.isChecked
        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()

        // creating an explicit intent to start a new activity
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)

        // passing the data to the new activity
        previewActivityIntent.putExtra("contactName", contactName)
        previewActivityIntent.putExtra("contactNumber", contactNumber)
        previewActivityIntent.putExtra("displayName", displayName)
        previewActivityIntent.putExtra("availableDate", availableDate)
        previewActivityIntent.putExtra("junior", junior)
        previewActivityIntent.putExtra("immediateStart", immediateStart)
        previewActivityIntent.putExtra("jobTitle", jobTitle)

//        var message: String = "Name: $contactName, Number: $contactNumber, " +
//                "Display name: $displayName, Available date: $availableDate, " +
//                "Junior: $junior, Immediate start: $immediateStart, Job title: $jobTitle"
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


}