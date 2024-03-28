package com.example.a0328

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnchangeactivity)
        val btnOpenBrowser = findViewById<Button>(R.id.btnopenbrowser)
        val edtName = findViewById<TextView> (R.id.edtname)


        btnChangeActivity.setOnClickListener {
            var bundle = Bundle()
            var name = edtName.text.toString()
            bundle.putString("name", name)

            var seconIntent = Intent(this, secondactivity::class.java)
            seconIntent.putExtra( "key", bundle)
            startActivity(seconIntent)
        }



        btnOpenBrowser.setOnClickListener {
            var seconIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(seconIntent)
        }
    }
}