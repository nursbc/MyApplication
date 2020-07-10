package com.example.myapplication.Presentation.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Domain.Student
import com.example.myapplication.Presentation.Adapter.ViewPagerStudentAdapter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_viewpager.*

class ViewPagerFragment : Fragment() {
    var rootView : View? = null

    var students : ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_viewpager, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initializeViewPagerAdapter()
    }

    fun initData()
    {
        students.add(
            Student(
                "Adam",
                "Good Student",
                mark = 5.0F
            )
        )
        students.add(
            Student(
                "Eve",
                "Bad Student",
                mark = 4.0F
            )
        )
        students.add(
            Student(
                "Bill",
                "Avarage Student",
                mark = 3.0F
            )
        )
        students.add(
            Student(
                "Zoe",
                "Avarage Student",
                mark = 2.0F
            )
        )
        students.add(
            Student(
                "Grizli",
                "Bad Student",
                mark = 4.0F
            )
        )
        students.add(
            Student(
                "Chupakabra",
                "Bad Student",
                mark = 4.0F
            )
        )
        students.add(
            Student(
                "Dog",
                "Good Student",
                mark = 2.0F
            )
        )
        students.add(
            Student(
                "Cat",
                "Avarage Student",
                mark = 3.0F
            )
        )
        students.add(
            Student(
                "Sam",
                "Good Student",
                mark = 4.0F
            )
        )
        students.add(
            Student(
                "Spider",
                "Bad Student",
                mark = 3.0F
            )
        )
        students.add(
            Student(
                "Bender",
                "bad Student",
                mark = 1.0F
            )
        )
        students.add(
            Student(
                "Gendalf",
                "Good Student",
                mark = 5.0F
            )
        )
        students.add(
            Student(
                "Frodo",
                "Avarage Student",
                mark = 4.0F
            )
        )
        students.add(
            Student(
                "Geralt",
                "Good Student",
                mark = 2.0F
            )
        )
        students.add(
            Student(
                "Pig",
                "Bad Student",
                mark = 2.0F
            )
        )


    }

    fun initializeViewPagerAdapter()
    {
        viewpager_fragment_viewpager?.adapter = ViewPagerStudentAdapter(activity?.supportFragmentManager!!, students)
    }
}