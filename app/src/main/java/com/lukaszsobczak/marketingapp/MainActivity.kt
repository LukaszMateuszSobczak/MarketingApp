package com.lukaszsobczak.marketingapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val previewButton: Button = findViewById(R.id.button_preview)

        previewButton.setOnClickListener {
            onPreviewClick()
        }

    }

    private fun onPreviewClick() {
        val contactNameEditText: TextInputEditText = findViewById(R.id.input_edit_text_contact_name)
        val contactNumberEditText: TextInputEditText =
            findViewById(R.id.input_edit_text_contact_number)
        val displayNameEditText: TextInputEditText =
            findViewById(R.id.input_edit_text_contact_display_name)
        val availableDateEditText: TextInputEditText =
            findViewById(R.id.input_edit_text_available_date)

        var contactName = contactNameEditText.text.toString()
        var contactNumber = contactNumberEditText.text.toString()
        var displayName = displayNameEditText.text.toString()
        var availableDate = availableDateEditText.text.toString()

        var message: String = "Witaj $contactName. Twój numer telefonu to $contactNumber"

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }


}