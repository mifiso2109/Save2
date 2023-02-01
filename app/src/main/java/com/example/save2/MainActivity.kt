package com.example.save2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a2 = findViewById<EditText>(R.id.A)
        val b2 = findViewById<EditText>(R.id.B)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        val num1 = pref.getInt("num1", 0)
        val num2 = pref.getInt("num2", 0)
        val res = pref.getString("res", "")

        a2.setText(num1.toString())
        b2.setText(num2.toString())
        Answer.text = res


        onCount.setOnClickListener {
            val a: Int = a2.text.toString().toInt()
            val b: Int = b2.text.toString().toInt()
            if(a == 0 || b == 0)Answer.text = "Нельзя вводить 0"
            else{
                val x = -b/a
                if(a > 0) Answer.text = ("${x}; +∞")
                if(a < 0) Answer.text = ("-∞; ${x}")
            }
        }

        onSave.setOnClickListener {
            editor.putInt("num1", a2.text.toString().toInt())
            editor.putInt("num2", b2.text.toString().toInt())
            editor.putString("res", Answer.text.toString())
            editor.apply()
        }

        onClear.setOnClickListener {
            editor.clear()
            editor.apply()
            a2.setText("0")
            b2.setText("0")
            Answer.text = "0"
        }

        onImport.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            val a: Int = a2.text.toString().toInt()
            val b: Int = b2.text.toString().toInt()
            intent.putExtra("Answer1", a)
            intent.putExtra("Answer2", b)
            startActivity(intent)
        }

    }
}
