package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentsActivity : AppCompatActivity(){

    var students : ArrayList<String> = ArrayList();
    var studentsUseCase : StudentsSortUseCase = StudentsSortUseCase()

    var textviewStudentsList : TextView? = null
    var buttonSortByName : Button? = null
    var buttonSortRandom : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initActivity()
        initializeListeners()

    }

    fun initActivity()
    {
        students.add("Adam")
        students.add("Eve")
        students.add("Bill")
        students.add("Zoe")
        students.add("Grizli")
        students.add("Chupakabra")
        students.add("Dog")
        students.add("Cat")
        students.add("Sam")
        students.add("Spider")
        students.add("Bender")
        students.add("Gendalf")
        students.add("Frodo")
        students.add("Geralt")
        students.add("Pig")


        textviewStudentsList = findViewById(R.id.textview_activity_students_list)
        buttonSortByName = findViewById(R.id.button_activity_students_sort_byname)
        buttonSortRandom = findViewById(R.id.button_activity_students_sort_random)


    }

    fun initializeListeners(){


        buttonSortByName!!.setOnClickListener(View.OnClickListener {
            var temp = studentsUseCase.initiateSortStudentsByName(students).toString()
            textviewStudentsList!!.text = temp

        })

        buttonSortRandom!!.setOnClickListener(View.OnClickListener {
            var temp = studentsUseCase.initiateSortStudentsRandom(students).toString()
            textviewStudentsList!!.text = temp
        })
    }


}