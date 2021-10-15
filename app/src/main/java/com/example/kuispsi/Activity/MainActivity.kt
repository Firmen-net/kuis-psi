package com.example.kuispsi.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kuispsi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animal)

        findViewById<Button>(R.id.buttoncat).setOnClickListener {
            val intent = Intent(this, CatActvity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttondog).setOnClickListener {
            val intent = Intent(this, DogActivity::class.java)
            startActivity(intent)
        }
    }
}