package com.example.onepunchquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btStar : Button =findViewById(R.id.btStar)
        val etName : EditText =findViewById(R.id.etName)
        btStar.setOnClickListener {
            if (etName.text.isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,QuizActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}