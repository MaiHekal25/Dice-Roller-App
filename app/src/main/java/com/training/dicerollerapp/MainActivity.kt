package com.training.dicerollerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.training.dicerollerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice(){
        val firstRandomNumber = (1..6).random()
        val secondRandomNumber = (1..6).random()

        val diceImageOne = getDiceImage(firstRandomNumber)
        val diceImageTwo = getDiceImage(secondRandomNumber)

        binding.diceImage.setImageResource(diceImageOne)
        binding.diceImageTwo.setImageResource(diceImageTwo)
    }

    // Helper function to get the dice image based on roll
    private fun getDiceImage(roll: Int) : Int{
        return when(roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}