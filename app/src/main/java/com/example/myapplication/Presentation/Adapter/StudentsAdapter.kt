package com.example.myapplication.Presentation.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Data.Student
import com.example.myapplication.R
import com.example.myapplication.Presentation.viewHolder.StudentHolder

class StudentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    lateinit var students: List<Student>

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
    }
}