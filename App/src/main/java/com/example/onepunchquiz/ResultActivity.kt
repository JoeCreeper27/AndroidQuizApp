package com.example.onepunchquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvUserName: TextView =findViewById(R.id.tvUserName)
        val tvScore: TextView = findViewById(R.id.tvScore)
        val btFinish: Button =findViewById(R.id.btFinish)

        val userName=intent.getStringExtra(Constants.USER_NAME)
        tvUserName.text=userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.text="Your Score is $correctAnswers out of $totalQuestions"

        btFinish.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}