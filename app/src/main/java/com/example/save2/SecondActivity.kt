package com.example.save2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val IntAns1: Int = intent.getIntExtra("Answer1", 2)
        val IntAns2: Int = intent.getIntExtra("Answer2", 4)

        A.setText(IntAns1.toString())
        B.setText(IntAns2.toString())
        if(IntAns1 == 0 || IntAns2 == 0) Answer.text = "Нельзя вводить 0"
        else {
            val x = -IntAns2 / IntAns1
            Answer.text = x.toString()
        }
    }
}
