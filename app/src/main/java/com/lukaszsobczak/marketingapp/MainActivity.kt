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
//    private var previewButton: Button? = null
//    private var contactNameEditText: TextInputEditText? = null
//    private var contactNumberEditText: TextInputEditText? = null
//    private var displayNameEditText: TextInputEditText? = null
//    private var availableDateEditText: TextInputEditText? = null
//    private var juniorCheckBox: CheckBox? = null
//    private var immediateStartCheckBox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

//        contactNameEditText = findViewById(R.id.input_edit_text_contact_name)
//        contactNumberEditText = findViewById(R.id.input_edit_text_contact_number)
//        displayNameEditText = findViewById(R.id.input_edit_text_contact_display_name)
//        availableDateEditText = findViewById(R.id.input_edit_text_available_date)
//        previewButton = findViewById(R.id.button_preview)
//        juniorCheckBox = findViewById(R.id.check_box_junior)
//        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)

        binding.buttonPreview.setOnClickListener {
            onPreviewClick()
        }

    }

    private fun onPreviewClick() {
//        Log.d("This my TAG", "contactNameEditText = " + contactNameEditText!!.toString())
        var contactName = binding.inputEditTextContactName.text.toString()
        var contactNumber = binding.inputEditTextContactNumber.text.toString()

        var message: String = "Witaj $contactName. Twój numer telefonu to $contactNumber"

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }


}