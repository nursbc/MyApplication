package com.example.myapplication.Presentation.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.myapplication.Presentation.Fragment.NotesFragment

import com.example.myapplication.Presentation.Fragment.StudentsFragment
import com.example.myapplication.Presentation.Fragment.ViewPagerFragment
import com.example.myapplication.R

class StudentsActivity : AppCompatActivity(){

/*    var students : ArrayList<String> = ArrayList();
    var studentsUseCase : StudentsSortUseCase = StudentsSortUseCase()

    var textviewStudentsList : TextView? = null
    var buttonSortByName : Button? = null
    var buttonSortRandom : Button? = null*/

    var currentFragment: Fragment? = null
    lateinit var fragmentMenager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeFragmentManager()
        initializeDefaultFragment()
/*
        initActivity()
        initializeListeners()*/
    }

    fun initializeFragmentManager(){
        fragmentMenager = supportFragmentManager

    }

    fun initializeDefaultFragment(){
        if(currentFragment==null){
            currentFragment = StudentsFragment()
/*                NotesFragment().apply {
                    arguments = Bundle().apply {
                        putString("DATA", "OKAY")
                    }
                }*/

            fragmentMenager.beginTransaction()
/*                .add(R.id.relativelayout_activity_students_fragment_container,currentFragment!!,"StudentsFragment")
                .commit()*/
                .add(R.id.relativelayout_activity_students_fragment_container,currentFragment!!,"StudentsFragment")
                .commit()
        }
    }



/*    fun initActivity()
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
    }*/


}