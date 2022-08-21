package com.example.api

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ActivityMainBinding
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceStatic: Bundle?) {
        super.onCreate(savedInstanceStatic)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = APIService.api_instance.getAgents()
        call.enqueue(object : Callback<ValoModel> {
            override fun onResponse(
                call: Call<ValoModel>,
                response: Response<ValoModel>
            ) {
                if(response.isSuccessful) {
                    val res = response.body()
                    binding.recyclerview.adapter = res?.let { RecylclerAdapter(it) }
                }
            }

            override fun onFailure(call: Call<ValoModel>, t: Throwable) {
                Log.d("API Fetch", "Error while fetching", t)
            }
    })
    }
}