package com.lukaszsobczak.marketingapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lukaszsobczak.marketingapp.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreviewBinding
    private lateinit var message: String
    private lateinit var messageData: Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        oldDisplayMessage()
        newDisplayMessage()
        setUpButton()

    }



    private fun setUpButton() {
        binding.buttonSendMessage.setOnClickListener {
            val sendMessageIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${messageData.contactNumber}")
                putExtra("sms_body", message)
            }
//            val sendMessageIntent2 = Intent(Intent.ACTION_SEND)
//            sendMessageIntent2.data = Uri.parse("smsto:")
            startActivity(sendMessageIntent)
        }
    }

    private fun newDisplayMessage() {
        messageData = intent.getSerializableExtra("message") as Message
        val data = intent.getStringExtra("lol")

        message =
            """
            Hello,
           
            My name is ${messageData.contactName} and I am ${messageData.getFullJobDescription()}.
            
            I have a portfolio app to demonstrate my technical skills that I can show on request.
            
            I am able to start a new position ${messageData.checkAvailability()}.
            
            Please get in touch if you have any suitable roles for me.
            
            Thanks and best regards.
            """.trimIndent()

        binding.textViewMessage.text = message
    }


    private fun oldDisplayMessage() {
        val contactName = intent.getStringExtra("contactName")
        val contactNumber = intent.getStringExtra("contactNumber")
        val displayName = intent.getStringExtra("displayName")
        val availableDate = intent.getStringExtra("availableDate")
        val junior = intent.getBooleanExtra("junior", false)
        val immediateStart = intent.getBooleanExtra("immediateStart", false)
        val jobTitle = intent.getStringExtra("jobTitle")

        message =
            """
        Name: $contactName,
        Number: $contactNumber,
        NickName: $displayName,
        Available from: $availableDate,
        Junior: $junior,
        Immediate start: $immediateStart,
        Job title: $jobTitle
        """
        binding.textViewMessage.text = message
    }
}