package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt

fun getRandomLottoNumber (): Int{
    return Random().nextInt(45)+1
}

fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    while(true) {
        val number = getRandomLottoNumber()
        var flag_exist = 0

        if (lottoNumbers.size < 1) {
            lottoNumbers.add(number)
            continue
        } else {
            for (j in 0 until lottoNumbers.size) {
                if (number == lottoNumbers[j]) {
                    flag_exist = 1
                    break
                }
            }
            if (flag_exist == 0)
                lottoNumbers.add(number)
            if (lottoNumbers.size >= 6)
                break
        }
    }
    return lottoNumbers
}

fun getShuffledLottoNumbers() : MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for(number in 1..45){
        lottoNumbers.add(number)
    }
    lottoNumbers.shuffle()

    return lottoNumbers.subList(0, 6);
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cv_random = findViewById<CardView>(R.id.cv_random)
        cv_random.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumbers()))
            startActivity(intent)
        }

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