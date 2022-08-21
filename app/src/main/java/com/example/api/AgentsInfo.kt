package com.example.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.api.databinding.ActivityAgentsInfoBinding
import com.example.api.databinding.ActivityMainBinding

class AgentsInfo : AppCompatActivity() {
    lateinit var binding: ActivityAgentsInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgentsInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val data = intent.getParcelableExtra<Data>("info")

        binding.name.text= "Name: ${data?.displayName}"
        binding.description.text= "Description: ${data?.description}"
        binding.origin.text= "Origin: "
        binding.lifespan.text= "Lifespan:"

        Glide.with(this).load(data?.displayIcon).into(binding.img)


    }
}