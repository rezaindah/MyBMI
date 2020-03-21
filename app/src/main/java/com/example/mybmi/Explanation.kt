package com.example.mybmi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_explanation.*
import java.security.KeyStore

class Explanation : AppCompatActivity() {
    var score:Double=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explanation)
        score=intent.getDoubleExtra(BMIRES, 0.0)
        expl.text=score.toString()
        //val kosong=score.toDouble().toString()
        if (score >0.0 && score< 18.5) {
            expl.setTextColor(Color.BLUE)
            detil.setText("Underweight")
            //imageView2.visibility= VISIBLE
        } else if (score >= 18.5 && score <= 25) {
            expl.setTextColor(Color.GREEN)
            detil.setText("Normal")
            //imageView2.visibility= View.GONE
        } else if (score > 25 && score <= 30) {
            expl.setTextColor(Color.YELLOW)
            detil.setText("Overweight")
            //imageView2.visibility= View.GONE
        } else {
            expl.setTextColor(Color.RED)
            detil.setText("Obese")
            //imageView2.visibility= View.GONE
        }

    }
}
