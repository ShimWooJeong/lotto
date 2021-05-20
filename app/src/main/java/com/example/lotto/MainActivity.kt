package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cv_constell = findViewById<CardView>(R.id.cv_constell)

        cv_constell.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }

        val cv_name = findViewById<CardView>(R.id.cv_name)

        cv_name.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }

    }

}