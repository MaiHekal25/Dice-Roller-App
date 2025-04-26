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
        val randomNumber = (1..6).random()
        when(randomNumber){
            1 -> binding.diceImage.setImageResource(R.drawable.dice_1)
            2 -> binding.diceImage.setImageResource(R.drawable.dice_2)
            3 -> binding.diceImage.setImageResource(R.drawable.dice_3)
            4 -> binding.diceImage.setImageResource(R.drawable.dice_4)
            5 -> binding.diceImage.setImageResource(R.drawable.dice_5)
            6 -> binding.diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}