package com.example.photoeditor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}