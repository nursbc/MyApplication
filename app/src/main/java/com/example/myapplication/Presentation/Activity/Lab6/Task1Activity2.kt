package com.example.myapplication.Presentation.Activity.Lab6

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class Task1Activity2 : AppCompatActivity() {

    var textViewShowSurname : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_lab6)

        var intetn : String = intent.getStringExtra("name").toString()

        initActivity(intetn)
    }

    fun initActivity(stringShowSurname : String)
    {
        textViewShowSurname = findViewById(R.id.textview_activity2_lab6_show_surname)
        textViewShowSurname?.text = stringShowSurname
    }

}