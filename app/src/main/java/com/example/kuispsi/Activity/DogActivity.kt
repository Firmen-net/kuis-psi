package com.example.kuispsi.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuispsi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogActivity : AppCompatActivity() {
    private val lists = ArrayList<DogModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)

        findViewById<Button>(R.id.buttonmenu).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<RecyclerView>(R.id.rvDog).setHasFixedSize(true)
        findViewById<RecyclerView>(R.id.rvDog).layoutManager = LinearLayoutManager(this)

        for (i in 1..6) {
            DogClient.instance.getPicts().enqueue(object : Callback<DogModel> {
                override fun onResponse(call: Call<DogModel>, response: Response<DogModel>) {
                    val responseCode = response.code().toString()
                    findViewById<TextView>(R.id.tvDogMain).text = responseCode
                    response.body()?.let { lists.addAll(listOf(it)) }
                    val adapter = DogAdapter(lists)
                    findViewById<RecyclerView>(R.id.rvDog).adapter = adapter
                }

                override fun onFailure(call: Call<DogModel>, t: Throwable) {

                }
            })
        }
    }
}