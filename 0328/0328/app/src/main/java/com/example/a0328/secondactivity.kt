package com.example.a0328

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class secondactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondactivity)

        val txttest = findViewById<TextView> (R.id.txttest)
        val btnBacktoFirst = findViewById<Button>(R.id.btnbacktofirst)
        val text = intent.getBundleExtra(  "key")?.getString(  "name").toString()

        txttest.setText(text)

        btnBacktoFirst.setOnClickListener {

            finish()
        }

    }

    var lastTime: Long = 0
    override fun finish() {

        val currentTime = System.currentTimeMillis()
        if (currentTime - lastTime > 3 * 1000) {
            lastTime = currentTime
            Toast.makeText(this, "再按一下離開", Toast.LENGTH_SHORT).show()
        } else {

            super.finish()
        }
        }

    }

