package com.example.kuispsi.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuispsi.CatAdapter
import com.example.kuispsi.CatClient
import com.example.kuispsi.CatModel
import com.example.kuispsi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatActvity : AppCompatActivity() {
    private val lists = ArrayList<CatModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)

        findViewById<Button>(R.id.buttonmenu).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<RecyclerView>(R.id.rvCat).setHasFixedSize(true)
        findViewById<RecyclerView>(R.id.rvCat).layoutManager = LinearLayoutManager(this)

        for (i in 1..6) {
            CatClient.instance.getPicts().enqueue(object : Callback<CatModel> {
                override fun onResponse(call: Call<CatModel>, response: Response<CatModel>) {
                    val responseCode = response.code().toString()
                    findViewById<TextView>(R.id.tvCatMain).text = responseCode
                    response.body()?.let { lists.addAll(listOf(it)) }
                    val adapter = CatAdapter(lists)
                    findViewById<RecyclerView>(R.id.rvCat).adapter = adapter
                }

                override fun onFailure(call: Call<CatModel>, t: Throwable) {

                }

            })
        }
    }
}