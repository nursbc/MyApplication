package com.example.myapplication.Presentation.Activity.Lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R

class Task1Activity1 : AppCompatActivity() {

    var buttonGoToActivity2 : Button? = null
    var editTextUserSurname : TextView? = null
    var stringSendTextViewToActivity2 : String = ""
    var s =  editTextUserSurname?.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1_lab6)

        initActivity()
        initializeListeners()
        var s =  editTextUserSurname!!.text.toString()
        Log.e("text", s)

    }

    fun initActivity()
    {
        buttonGoToActivity2 = findViewById(R.id.button_activity1_lab6)
        editTextUserSurname = findViewById(R.id.edittext_activity1_lab6_write_surname)
    }

    fun initializeListeners(){

        editTextUserSurname?.setOnClickListener{
            editTextUserSurname?.text = ""
        }

        buttonGoToActivity2!!.setOnClickListener(View.OnClickListener {


                stringSendTextViewToActivity2 = editTextUserSurname?.text.toString()
                initiateActivity2Lab6Transition(stringSendTextViewToActivity2)

        })

    }

    fun initiateActivity2Lab6Transition(stringSendToactivity2 : String){

        var intent = Intent(this, Task1Activity2::class.java)

        intent.putExtra("name", stringSendToactivity2)

        startActivity(intent)

    }

}