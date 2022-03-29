package com.imasha.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imasha.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    private val key = "MY_PREF"
    private val nameKey  = "NAME"
    private val acceptKey = "ACCEPT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = applicationContext.getSharedPreferences(key,Context.MODE_PRIVATE)

        binding.editTextName.setText(sharedPreferences.getString(nameKey,null))
        binding.switchAccept.isChecked = sharedPreferences.getBoolean(acceptKey,false)

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text
            val isAccept = binding.switchAccept.isChecked

            sharedPreferences.edit().putString(nameKey,name.toString()).apply()
            sharedPreferences.edit().putBoolean(acceptKey,isAccept).apply()

        }
    }
}