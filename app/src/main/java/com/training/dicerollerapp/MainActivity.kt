package com.training.dicerollerapp

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.training.dicerollerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice(){
        val firstRandomNumber = (1..6).random()
        val secondRandomNumber = (1..6).random()

        val shakeAnimation1 = AnimationUtils.loadAnimation(this, R.anim.roll_shake)
        val shakeAnimation2 = AnimationUtils.loadAnimation(this, R.anim.roll_shake)

        shakeAnimation1.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                // No Action Needed
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.diceImage.setImageResource(getDiceImage(firstRandomNumber))
                binding.diceImageTwo.setImageResource(getDiceImage(secondRandomNumber))

                Toast.makeText(this@MainActivity, "You rolled 🎲 $firstRandomNumber and 🎲 $secondRandomNumber!", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // No Action Needed
            }

        })
        binding.diceImage.startAnimation(shakeAnimation1)
        binding.diceImageTwo.startAnimation(shakeAnimation2)
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