package com.example.rockpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var txtCom: TextView
    private lateinit var txtResult: TextView
    private lateinit var imbtnScissors: ImageButton
    private lateinit var imbtnRock: ImageButton
    private lateinit var imbtnPaper: ImageButton
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCom =findViewById(R.id.txtCom)
        txtResult =findViewById (R.id.txtResult)
        imbtnScissors = findViewById(R.id.imbtnScissors)
        imbtnRock = findViewById(R.id.imbtnRock)
        imbtnPaper = findViewById(R.id.imbtnPaper)
        imageView = findViewById(R.id.imageView)

        imbtnScissors.setOnClickListener {
            playGame (Choice. SCISSORS)
        }
        imbtnRock.setOnClickListener {
        }
        playGame (Choice.ROCK)
        imbtnPaper.setOnClickListener {
            playGame (Choice.PAPER)
        }
    }

    enum class Choice {
        SCISSORS, ROCK, PAPER
    }

    fun playGame (playerChoice: Choice) {
        val choices = Choice.values()
        var computerChoice = choices[Random().nextInt(choices.size)]

        when(computerChoice){
            Choice.PAPER -> imageView.setImageResource(R.drawable.paper)
            Choice.SCISSORS -> imageView.setImageResource(R.drawable.scissor)
            Choice.ROCK -> imageView.setImageResource(R.drawable.rock)
        }


        when {
            playerChoice == computerChoice -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.draw)

            }
            (playerChoice == Choice. SCISSORS && computerChoice == Choice. PAPER) ||
                    (playerChoice == Choice. ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice. PAPER && computerChoice == Choice. ROCK)-> {
                txtCom.setText(getChoiceString (computerChoice))
                txtResult.setText(R.string.win)
            }
            else -> {
                txtCom.setText(getChoiceString (computerChoice))
                txtResult.setText(R.string.lose)
            }
        }
    }

    fun getChoiceString(choice: Choice): Int {
        return when (choice) {
            Choice.ROCK -> R.string.rock
            Choice.SCISSORS -> R.string.scissors
            Choice.PAPER -> R.string.paper
        }
    }
}





