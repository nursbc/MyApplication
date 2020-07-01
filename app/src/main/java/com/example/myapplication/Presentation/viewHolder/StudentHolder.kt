package com.example.myapplication.Presentation.viewHolder

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Data.Student
import com.example.myapplication.R

class StudentHolder (itemview : View) : RecyclerView.ViewHolder(itemview)
{
    var context : Context? = null
    var textViewName : TextView? = null
    var textDescription : TextView? = null
    var textMark : TextView? = null

    init
    {
        initializeView()
    }

    fun initializeView()
    {
        textViewName = itemView.findViewById(R.id.textview_viewholder_student_name)
        textDescription = itemView.findViewById(R.id.textview_viewholder_student_description)
        textMark = itemView.findViewById(R.id.textview_viewholder_student_mark)
    }

    fun initiateBind(student : Student)
    {
        textViewName?.setText(student.name)
        textDescription?.setText(student.description)
        textMark?.setText(student.mark.toString())
    }
}