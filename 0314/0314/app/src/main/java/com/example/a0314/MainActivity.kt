package com.example.a0314

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.a0314.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val password = binding.etPassword.text.toString()
            val nickname = binding.etNickname.text.toString()
            val email = binding.etEmail.text.toString()
            val phone = binding.etPhone.text.toString()
            val dob = binding.etDob.text.toString()
            val gender = binding.etGender.text.toString()
            val address = binding.etAddress.text.toString()

            val userInfo = "Name: $name\n..."

            AlertDialog.Builder(this)
                .setTitle("User Information")
                .setMessage(userInfo)
                .setPositiveButton("OK", null)
                .show()
        }
    }
}