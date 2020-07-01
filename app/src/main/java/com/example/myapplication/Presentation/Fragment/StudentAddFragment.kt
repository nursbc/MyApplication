package com.example.myapplication.Presentation.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplication.Data.Student
import com.example.myapplication.Presentation.Contract.StudentFragmentContract
import com.example.myapplication.Presentation.Presenters.StudentFragmentPresenter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_students_add_student.*

class StudentAddFragment : Fragment(), View.OnClickListener, StudentFragmentContract.View {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_students_add_student, container, false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeListeners()
    }

    override fun initializeViews() {
    }

    override fun initializeListeners() {
        button_fragment_student_cancel_student.setOnClickListener(this)
        button_fragment_student_add_student.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_fragment_student_cancel_student -> {
                button_fragment_student_cancel_student.setOnClickListener {
                    val fragmentManager = fragmentManager
                    fragmentManager?.popBackStack()
                }
            }
            R.id.button_fragment_student_add_student -> {
                when {
                    edittext_fragment_student_write_name.text.toString().isEmpty() -> {
                        edittext_fragment_student_write_name.setText("Write name")
                    }
                    edittext_fragment_student_write_description.text.toString().isEmpty() -> {
                        edittext_fragment_student_write_description.setText("Write description about student")
                    }
                    edittext_fragment_student_write_mark.text.toString().isEmpty() -> {
                        edittext_fragment_student_write_mark.setText("Write mark")
                    }
                    else -> {
                        var student: Student = Student(
                            edittext_fragment_student_write_name.text.toString(),
                            edittext_fragment_student_write_description.text.toString(),
                            edittext_fragment_student_write_mark.text.toString().toFloat()
                        )
                        val fragment =
                            fragmentManager?.findFragmentByTag("StudentsFragment") as StudentsFragment

                        fragment.presenter.initiateAddNewStudent(student)

                        val fragmentManager = fragmentManager
                        fragmentManager?.popBackStack()
                    }
                }
            }
        }
    }


    override fun initializePresenter() {
        TODO("Not yet implemented")
    }

    override fun initializeLayoutManager() {
        TODO("Not yet implemented")
    }

    override fun initializeAdapter() {
        TODO("Not yet implemented")
    }

    override fun initiateUpdateAdapter() {
        TODO("Not yet implemented")
    }

    override fun processData(students: ArrayList<Student>) {
        TODO("Not yet implemented")
    }


    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }

}