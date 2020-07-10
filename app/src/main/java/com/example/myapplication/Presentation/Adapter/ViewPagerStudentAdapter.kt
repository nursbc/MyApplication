package com.example.myapplication.Presentation.Adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myapplication.Domain.Student
import com.example.myapplication.Presentation.Fragment.StudentDetailFragment

class ViewPagerStudentAdapter(fragmentManager : FragmentManager, var students: ArrayList<Student>) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return StudentDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("ViewPagerStudentAdapter", students.get(position))
            }
        }
    }

    override fun getCount(): Int {
        return students.size
    }


}