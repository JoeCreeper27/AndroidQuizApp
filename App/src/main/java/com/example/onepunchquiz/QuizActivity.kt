package com.example.onepunchquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectionOptionPosition: Int = 0
    private var mCorrectAnswer:Int =0
    private var mUserName:String?=null

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        progressBar = findViewById(R.id.pbProgress)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        btSubmit = findViewById(R.id.btSubmit)

        mQuestionList = Constants.getQuestions()
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        setQuestion()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btSubmit?.setOnClickListener(this)

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]

        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${mQuestionList?.size}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour





        if (mCurrentPosition == mQuestionList!!.size) {
            btSubmit?.text = "FINISH"
        }else{
            btSubmit?.text="SUBMIT"
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#444444"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()

        mSelectionOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#FFFFFF"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.tvOptionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tvOptionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tvOptionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tvOptionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btSubmit -> {
                if (mSelectionOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectionOptionPosition) {
                        answerView(mSelectionOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btSubmit?.text = "FINISH"
                    } else {
                        btSubmit?.text = "NEXT"
                    }
                    mSelectionOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}
