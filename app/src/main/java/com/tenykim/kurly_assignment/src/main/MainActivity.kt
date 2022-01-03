package com.tenykim.kurly_assignment.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.tenykim.kurly_assignment.R
import com.tenykim.kurly_assignment.config.ApplicationClass
import com.tenykim.kurly_assignment.databinding.ActivityMainBinding
import com.tenykim.kurly_assignment.service.GithubService
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        binding.search.setOnClickListener {
            val q = binding.keyword.text.toString()

            Toast.makeText(this, "Hello, Github! Your input is $q.", Toast.LENGTH_SHORT).show()

            // EditText clear
            binding.keyword.text.clear()
        }
    }
}