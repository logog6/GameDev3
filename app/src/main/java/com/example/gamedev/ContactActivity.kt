package com.example.gamedev

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.lang.Exception

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        val Button:Button=findViewById(R.id.sendEmailBtn)
        Button.setOnClickListener{
            val recipent: EditText = findViewById(R.id.recipentEt)
            val recipent1 = recipent.text.toString()
            val subject: EditText = findViewById(R.id.subjectEt)
            val subject1 = subject.text.toString()
            val messageEt: EditText = findViewById(R.id.messageEt)
            val messageEt1 = messageEt.text.toString()
            sendEmail(recipent1, subject1, messageEt1)

        }
    }
    private fun sendEmail(recipent1:String,subject1:String,messageEt1:String) {
        val mIntent= Intent(Intent.ACTION_SEND)
        mIntent.data= Uri.parse("mailto:")
        mIntent.type="text/plan"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipent1))
        mIntent.putExtra(Intent.EXTRA_SUBJECT,subject1)
        mIntent.putExtra(Intent.EXTRA_TEXT,messageEt1)
        try{
            startActivity(Intent.createChooser(mIntent,"wybierz email"))
        }
        catch (e: Exception){
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }
    }
}