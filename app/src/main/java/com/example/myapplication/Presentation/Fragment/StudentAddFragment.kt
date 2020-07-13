package com.example.myapplication.Presentation.Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Domain.Student
import com.example.myapplication.Presentation.Contract.StudentFragmentContract
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_students_add_student.*
import java.util.*
import kotlin.collections.ArrayList

class StudentAddFragment : Fragment(), View.OnClickListener, StudentFragmentContract.View {

    var student : Student? = null
    var selectDate = Calendar.getInstance()
    val year = selectDate.get(Calendar.YEAR)
    val month = selectDate.get(Calendar.MONTH)
    val day = selectDate.get(Calendar.DAY_OF_MONTH)
    var date : String? = null


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
        button_fragment_student_cancel_add.setOnClickListener(this)
        button_fragment_student_add_student.setOnClickListener(this)
        button_fragment_student_add_date.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_fragment_student_cancel_add -> {
                val fragmentManager = fragmentManager
                    fragmentManager?.popBackStack()

            }
            R.id.button_fragment_student_add_date ->
            {
                val datePickerDialog = activity?.let { DatePickerDialog(it, DatePickerDialog.OnDateSetListener  { view, year, monthOfYear, dayOfMonth ->
                    textview_fragment_student_add_show_date.setText(dayOfMonth.toString() + ":" + (monthOfYear + 1).toString() + ":" + year.toString())
                            date = getDate(year, monthOfYear, dayOfMonth)
                        }, year, month, day)
                    }
                datePickerDialog?.show()
            }

            R.id.button_fragment_student_add_student -> {
                when {
                    edittext_fragment_student_add_write_name.text.toString().isEmpty() -> {
                        edittext_fragment_student_add_write_name.setText("Write name")
                    }
                    edittext_fragment_student_add_write_description.text.toString().isEmpty() -> {
                        edittext_fragment_student_add_write_description.setText("Write description about student")
                    }
                    edittext_fragment_student_add_write_mark.text.toString().isEmpty() -> {
                        edittext_fragment_student_add_write_mark.setText("Write mark")
                    }
                    else -> {
                        var student : Student =
                            Student(
                                edittext_fragment_student_add_write_name.text.toString(),
                                edittext_fragment_student_add_write_description.text.toString(),
                                edittext_fragment_student_add_write_mark.text.toString().toFloat(),
                                this.date,
                                edittext_fragment_student_add_write_group.text.toString()
                            )
                        val fragment = fragmentManager?.findFragmentByTag("StudentsFragment") as StudentsFragment

                        fragment.presenter.initiateAddNewStudent(student)

                        val fragmentManager = fragmentManager
                        fragmentManager?.popBackStack()
                    }

                }
            }
        }
    }

    fun getDate(year: Int, month: Int, day: Int): String {
        var months = (month + 1)
        var date = "$year:$months:$day"
        return date
    }



    override fun initializePresenter() {
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