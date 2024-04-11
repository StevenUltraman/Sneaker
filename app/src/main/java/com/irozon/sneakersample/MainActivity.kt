package com.irozon.sneakersample

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.irozon.sneaker.Sneaker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment, MainFragment()).commit()

        val viewGroup = findViewById<ViewGroup>(R.id.viewGroup)

        findViewById<View>(R.id.btShowError).setOnClickListener {
            Sneaker.with(this)
                .setTitle("Error!!")
                .setMessage("This is the error message")
                .setTypeface(Typeface.createFromAsset(this.assets, "font/Slabo27px-Regular.ttf"))
                .sneakError()
        }
        findViewById<View>(R.id.btShowSuccess).setOnClickListener {
            val sneaker = Sneaker.with(viewGroup)
            val view = LayoutInflater.from(this).inflate(R.layout.custom_view, sneaker.getView(), false)
            view.findViewById<TextView>(R.id.tvInstall).setOnClickListener {
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            }
            sneaker.sneakCustom(view)
        }
    }
}