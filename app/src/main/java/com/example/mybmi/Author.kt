package com.example.mybmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Author : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)
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
            Toast.makeText(this, "Metric unit", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.us_unit) {

            val intent = Intent(this, Usunit::class.java)
            this.startActivity(intent)
            Toast.makeText(this, "US unit", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.author) {
            Toast.makeText(this, "Author", Toast.LENGTH_LONG).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
