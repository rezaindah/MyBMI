package com.example.mybmi

import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class Usunit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usunit)
        setOnClickListenerForButton()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.metric) {
            val intent = Intent(this, Home::class.java)
            this.startActivity(intent)
            Toast.makeText(this, "US unit", Toast.LENGTH_LONG).show()

            return true
        }
        if (id == R.id.us_unit) {
            Toast.makeText(this, "US unit", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.author) {
            val intent = Intent(this, Author::class.java)
            this.startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun calculateBMI(): Double {
        var weight: Double = (inWeight.getText().toString().toDouble())
        var height: Double = (inHeight.getText().toString().toDouble())

        var calculatedBMI = (703*weight)/(height*height)

        return calculatedBMI
    }

    private fun setOnClickListenerForButton() {
        btnCal.setOnClickListener {
            if (TextUtils.isEmpty(inWeight.getText().toString())){
                Toast.makeText(this, "Empty field is not allowed!", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(inHeight.getText().toString())) {
                Toast.makeText(this, "Empty field is not allowed!", Toast.LENGTH_SHORT).show()
            }else{
                val tvBMI = findViewById(R.id.bmiResult) as TextView
                tvBMI.text = calculateBMI().toString()
                var min=0
                var max=calculateBMI()

                val valueAnimator = ValueAnimator.ofFloat(min.toFloat(), max.toFloat())

                valueAnimator.addUpdateListener {
                    val value = it.animatedValue as Float
                    // 2
                    tvBMI.text= value.toString()
                }


                if (calculateBMI() < 18.5) {
                    tvBMI.setTextColor(Color.BLUE)
                } else if (calculateBMI() >= 18.5 && calculateBMI() <= 25) {
                    tvBMI.setTextColor(Color.GREEN)
                } else if (calculateBMI() > 25 && calculateBMI() <= 30) {
                    tvBMI.setTextColor(Color.YELLOW)
                } else {
                    tvBMI.setTextColor(Color.RED)
                }
                valueAnimator.start()

            }
        }
    }

    fun onButtonClick(view: View) {
        val intent = Intent(this, Explanation::class.java).apply { putExtra(BMIRES,calculateBMI()) }
        this.startActivity(intent)
    }

}