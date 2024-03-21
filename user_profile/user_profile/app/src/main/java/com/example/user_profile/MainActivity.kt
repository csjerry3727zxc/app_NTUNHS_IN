package com.example.user_profile
import androidx.appcompat.app.AlertDialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val city = arrayListOf("請選擇","臺北市","新北市","桃園市","新竹縣","新竹市")
        var gender=""
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,city)


        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_Male = findViewById<RadioButton>(R.id.radBtn_Male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Female)


        val chkbox1 = findViewById<CheckBox>(R.id.ckb1)
        val chkbox2 = findViewById<CheckBox>(R.id.ckb2)
        val chkbox3 = findViewById<CheckBox>(R.id.ckb3)
        val chkbox4 = findViewById<CheckBox>(R.id.ckb4)

        val btn_send = findViewById<Button>(R.id.btn_send)
        val applyDate = findViewById<EditText>(R.id.applydate)


        applyDate.setOnClickListener{
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    var format = "${setDateFormat(year, month, day)}"
                    applyDate.setText(format)
                }
            }, year, month, day).show()
        }



        btn_send.setOnClickListener {
            // 获取EditText的值
            val idText = findViewById<EditText>(R.id.editTextText).text.toString()
            val pwdText = findViewById<EditText>(R.id.editTextText1).text.toString()
            val nameText = findViewById<EditText>(R.id.editTextText2).text.toString()
            val birthDate = findViewById<EditText>(R.id.applydate).text.toString()

            // 获取CheckBox的值
            val hobbies = StringBuilder()
            if (chkbox1.isChecked) hobbies.append("\n游泳")
            if (chkbox2.isChecked) hobbies.append("\n騎自行車")
            if (chkbox3.isChecked) hobbies.append("\n慢跑")
            if (chkbox4.isChecked) hobbies.append("\n打籃球")

            // 构建信息字符串
            val message = "ID: $idText\nPWD: $pwdText\nName: $nameText\n生日: $birthDate\n性別: $gender\n愛好:$hobbies"

            // 显示AlertDialog
            AlertDialog.Builder(this)
                .setTitle("提交的信息")
                .setMessage(message)
                .setPositiveButton("確定", null)
                .show()

        }



        radGrp_Gender.setOnCheckedChangeListener { _, checkedId ->
            gender= radGrp_Gender.findViewById<RadioButton>(checkedId).text.toString()
            Toast.makeText(this,gender,Toast.LENGTH_LONG).show()
        }


    }
    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }
}

