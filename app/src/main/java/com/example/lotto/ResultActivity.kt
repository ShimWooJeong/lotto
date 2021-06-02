package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SimpleAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result")?:return
        val sConstellation = intent.getStringExtra("constellation")

        val year = intent.getStringExtra("year")
        val month = intent.getStringExtra("month")
        val dayOfMonth = intent.getStringExtra("dayOfMonth")


        val result_sorted = result?.sorted()
        //val result_sorted = result?.let {result.sortedBy { it }}

        sConstellation?.let {
            val resultLabel = findViewById<TextView>(R.id.resultLabel)
            resultLabel.text = "${sConstellation}의 " +year+"년"+ month+"월"+ dayOfMonth+"일 로또 번호입니다 "
        }
/*
        result?.let {
            updateLottoBallImages(result.sortedBy{it})
        }
*/
        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)

        val lottoBallImgeStartId = R.drawable.ball_01
        val lottoBallImgeId2 = R.drawable.ball_02
        val lottoBallImgeId3 = R.drawable.ball_03

        imageView1.setImageResource(lottoBallImgeStartId + (result_sorted[0] - 1))
        imageView2.setImageResource(lottoBallImgeStartId + (result_sorted[1] - 1))
        imageView3.setImageResource(lottoBallImgeStartId + (result_sorted[2] - 1))
        imageView4.setImageResource(lottoBallImgeStartId + (result_sorted[3] - 1))
        imageView5.setImageResource(lottoBallImgeStartId + (result_sorted[4] - 1))
        imageView6.setImageResource(lottoBallImgeStartId + (result_sorted[5] - 1))


    }

}