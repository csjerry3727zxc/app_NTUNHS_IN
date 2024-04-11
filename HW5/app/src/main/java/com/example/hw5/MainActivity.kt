package com.example.hw5

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGuessnumber = findViewById<Button>(R.id.btnGuessnumber)
        val btnRockPaperScissors = findViewById<Button>(R.id.btnRockPaperScissors)
        val edtName = findViewById<AutoCompleteTextView>(R.id.edtName)

        btnGuessnumber.setOnClickListener{
            var bundle = Bundle()
            var name = edtName.text.toString()
            bundle.putString("name",name)

            var seconIntent = Intent(this,guessnumber::class.java)
            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }
        btnRockPaperScissors.setOnClickListener{
            var seconIntent = Intent(this,RockPaperScissors::class.java)
            startActivity(seconIntent)
        }
    }
}