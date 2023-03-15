package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.test.QuestionsData.jsonString
import com.google.gson.Gson
import java.io.File
import java.net.URI
import java.util.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    var questions:List<Question> = Data.data
    lateinit var q: Question

    var index = -1
    lateinit var question: TextView
    lateinit var answer1: TextView
    lateinit var answer2: TextView
    lateinit var answer3: TextView
    lateinit var answer4: TextView
    lateinit var answer5: TextView
    lateinit var button: Button
    lateinit var win: TextView
    lateinit var lose: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question = findViewById(R.id.question)
        answer1 = findViewById(R.id.answer_1)
        answer2 = findViewById(R.id.answer_2)
        answer3 = findViewById(R.id.answer_3)
        answer4 = findViewById(R.id.answer_4)
        answer5 = findViewById(R.id.answer_5)
        button = findViewById(R.id.next)
        win = findViewById(R.id.win)
        lose = findViewById(R.id.lose)
//        val text = resources.openRawResource(R.raw.data).bufferedReader().use { it.readText() }
//        questions = listOf(Gson().fromJson(text, Question::class.java))
        nextQuestion()
        setListeners()
    }
    fun setListeners() {
        answer1.setOnClickListener {
            val result = rightChoice(1)
            if (result==1) win.text = (win.text.toString().toInt()+1).toString()
            else lose.text = (lose.text.toString().toInt()+1).toString()
        }
        answer2.setOnClickListener {
            val result = rightChoice(2)
            if (result==1) win.text = (win.text.toString().toInt()+1).toString()
            else lose.text = (lose.text.toString().toInt()+1).toString()
        }
        answer3.setOnClickListener {
            val result = rightChoice(3)
            if (result==1) win.text = (win.text.toString().toInt()+1).toString()
            else lose.text = (lose.text.toString().toInt()+1).toString()
        }
        answer4.setOnClickListener {
            val result = rightChoice(4)
            if (result==1) win.text = (win.text.toString().toInt()+1).toString()
            else lose.text = (lose.text.toString().toInt()+1).toString()
        }
        answer5.setOnClickListener {
            val result = rightChoice(5)
            if (result==1) win.text = (win.text.toString().toInt()+1).toString()
            else lose.text = (lose.text.toString().toInt()+1).toString()
        }
        button.setOnClickListener {
            nextQuestion()
        }
    }
    fun rightChoice(answer:Int) : Int {
        when (questions[index].Right) {
            1 -> answer1.text = "+ ${questions[index].Answer1.padStart(1,'+')}"
            2 -> answer2.text = "+ ${questions[index].Answer2.padStart(1,'+')}"
            3 -> answer3.text = "+ ${questions[index].Answer3.padStart(1,'+')}"
            4 -> answer4.text = "+ ${questions[index].Answer4.padStart(1,'+')}"
            5 -> answer5.text = "+ ${questions[index].Answer5.padStart(1,'+')}"
        }
        return if(answer==questions[index].Right) 1 else -1
    }
    fun nextQuestion() {
        index = kotlin.random.Random.nextInt(0, questions.lastIndex)
        question.text = questions[index].Question
        answer1.text = questions[index].Answer1
        answer2.text = questions[index].Answer2
        answer3.text = questions[index].Answer3
        answer4.text = questions[index].Answer4
        answer5.text = questions[index].Answer5
    }
}

data class Question(
    val Question: String,
    val Answer1: String,
    val Answer2: String,
    val Answer3: String,
    val Answer4: String,
    val Answer5: String,
    val Right: Int
)