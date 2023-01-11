package com.neon.wallsplash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.neon.wallsplash.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}