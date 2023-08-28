package com.surbhi.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.surbhi.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var liveDataClass: LiveDataClass
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveDataClass = ViewModelProvider(this)[LiveDataClass::class.java]
        binding.btnRed.setOnClickListener {
            liveDataClass.color.value = 1
        }
        binding.btnBlue.setOnClickListener {
            liveDataClass.color.value = 2
        }
        binding.btnGreen.setOnClickListener {
            liveDataClass.color.value = 3
        }
      binding.btnPlus.setOnClickListener {
          number += 1
          liveDataClass.number.value = number

      }
        binding.btnMinus.setOnClickListener {
            number -= 1
            liveDataClass.number.value = number

        }
        binding.btnClear.setOnClickListener {
            number = 0
            liveDataClass.number.value = number

        }
    }
}