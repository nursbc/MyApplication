package com.example.myapplication.Presentation.Adapter

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Domain.Student
import com.example.myapplication.Presentation.Activity.StudentsActivity
import com.example.myapplication.Presentation.Fragment.StudentDetailFragment
import com.example.myapplication.R
import com.example.myapplication.Presentation.viewHolder.StudentHolder

class StudentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    var students: List<Student>

    constructor(context: Context?, students: List<Student>){
        this.context = context
        this.students = students
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_student, parent, false)
        return StudentHolder(view)

    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as StudentHolder).initiateBind(students.get(position))

        (holder as StudentHolder).itemView.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            val fragment = StudentDetailFragment();
            bundle.putParcelable  ("StudentDetailsFragment", students.get(position))
            fragment.setArguments(bundle)
            val fragmentManager: FragmentManager = (context as StudentsActivity).fragmentMenager
            fragmentManager?.beginTransaction()?.replace(R.id.relativelayout_activity_students_fragment_container,
                fragment,"StudentDetailFragment")
                ?.addToBackStack(null)
                ?.commit()
        })
    }
}