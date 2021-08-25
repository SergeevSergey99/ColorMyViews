package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.colormyviews.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        setListeners()
    }

    private fun setListeners(){
        val clickableViews: List<View> =
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                binding.boxFourText, binding.boxFiveText, binding.contraintLayout,
            binding.redButton, binding.greenButton, binding.yellowButton)

        for (item in clickableViews){
            item.setOnClickListener{
                makeColored(it)
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private  fun makeColored(view:View){
        when(view.id){
            R.id.box_one_text->view.setBackgroundColor(Color.YELLOW)
            R.id.box_two_text->view.setBackgroundColor(Color.CYAN)

            R.id.box_three_text->view.setBackgroundColor(Color.GREEN)
            R.id.box_four_text->view.setBackgroundColor(Color.RED)
            R.id.box_five_text->view.setBackgroundColor(Color.BLUE)

            R.id.red_button->binding.boxThreeText.setBackgroundColor(ContextCompat.getColor(this, R.color.my_red))
            R.id.yellow_button->binding.boxFiveText.setBackgroundColor(ContextCompat.getColor(this, R.color.my_yellow))
            R.id.green_button->binding.boxFourText.setBackgroundColor(ContextCompat.getColor(this, R.color.my_green))

            else->view.setBackgroundColor(Color.LTGRAY)
        }
    }
}