package com.example.hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import java.util.*


class guessnumber : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guessnumber)
        handler = Handler(Looper.getMainLooper())


        val btnBackToFirst  = findViewById<Button>(R.id.btnBackToFirst)
        val textView = findViewById<TextView>(R.id.textView)
        val guess_button = findViewById<Button>(R.id.guess_botton)
        val reset_button = findViewById<Button>(R.id.reset_botton)
        val editText = findViewById<EditText>(R.id.editText)
        val valdate_num: Int
        var secret: Int = Random().nextInt(100) + 1
        var minNum = 1
        var maxNum = 100
        guess_button.setOnClickListener {
            val guess = editText.text.toString().toIntOrNull()
            if (guess != null) {
                if (guess == secret) {
                    textView.text = "猜對了！"
                    handler.postDelayed({
                        Toast.makeText(this, "6秒之後執行重置", Toast.LENGTH_SHORT).show()
                    }, 6000)
                } else if (guess > secret) {
                    maxNum = guess
                    textView.text = "介於：$minNum ~ $maxNum 之間"

                } else if (guess < secret) {
                    minNum = guess
                    textView.text = "介於：$minNum ~ $maxNum 之間"
                }
            } else {
                textView.text = "請輸入一個數字"
            }
        }
        reset_button.setOnClickListener {
            secret = Random().nextInt(100) + 1
            textView.text = "讓我們在猜一次"
        }
        btnBackToFirst.setOnClickListener {
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }

    }
}