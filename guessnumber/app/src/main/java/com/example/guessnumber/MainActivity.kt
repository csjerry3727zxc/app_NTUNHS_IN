package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG: String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler(Looper.getMainLooper())


        val result_textView = findViewById<TextView>(R.id.result_textView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num: Int
        var secret: Int = Random().nextInt(100) + 1

        guess_button.setOnClickListener {
            result_textView.text = editText.text
            validate_num = editText.text.toString().toInt() - secret
            var ans_str: String = "你猜對了歐"



            if (validate_num > 0) {
                ans_str = "你猜得太大了，再小一點。範圍在1到" + editText.text.toString() + "之間。"
            } else if (validate_num < 0) {
                ans_str = "你猜得太小了，再大一點。範圍在" + editText.text.toString() + "到100之間。"
            } else {
                handler.postDelayed({
                    Toast.makeText(this, "6秒後的操作執行了", Toast.LENGTH_SHORT).show()
                }, 6000)
                result_textView.text = "我們再猜一次!!"
                secret = Random().nextInt(100) + 1
                //Toast.makeText(this, editText.text,Toast.LENGTH_LONG)
            }
            result_textView.text = ans_str
        }
            reset_button.setOnClickListener {
                secret = Random().nextInt(100) + 1
                result_textView.text = "我們再猜一次!!"
            }

        }
        override fun onDestroy() {
            super.onDestroy()
            handler.removeCallbacksAndMessages(null)
        }
    }

