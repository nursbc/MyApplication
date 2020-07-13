package com.example.myapplication.Presentation.Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Domain.Note
import com.example.myapplication.Presentation.Contract.NotesFragmentContract
import com.example.myapplication.Presentation.Presenters.NotesFragmentPresenter
import com.example.myapplication.Presentation.Presenters.StudentFragmentPresenter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.android.synthetic.main.fragment_students_add_student.*
import java.util.*
import kotlin.collections.ArrayList

class NotesAddFragment : Fragment(), View.OnClickListener, NotesFragmentContract.View {

    var note : Note? = Note()
    var selectDate = Calendar.getInstance()
    val year = selectDate.get(Calendar.YEAR)
    val month = selectDate.get(Calendar.MONTH + 1)
    val day = selectDate.get(Calendar.DAY_OF_MONTH)
    var date : String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_add_note, container, false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_Back_fragment_note_add -> {
                val fragmentManager = fragmentManager
                fragmentManager?.popBackStack()
            }
            R.id.button_select_date_fragment_note_add -> {
                val datePickerDialog = activity?.let {
                    DatePickerDialog(
                        it,
                        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                            edittext_fragment_add_note_note_add_date_text.setText(dayOfMonth.toString() + ":" + monthOfYear.toString() + ":" + year.toString())
                            date = getDate(dayOfMonth, (monthOfYear + 1), year)
                        },
                        year,
                        month,
                        day
                    )
                }
                datePickerDialog?.show()
            }
            R.id.button_add_fragment_note_add -> {
                when {
                    Edittext_fragment_add_note_add_head_text.text.toString().isEmpty() -> {
                        Edittext_fragment_add_note_add_head_text.setText("Write Head")
                    }
                    textview_fragment_add_note_add_description_text.text.toString().isEmpty() -> {
                        textview_fragment_add_note_add_description_text.setText("Write description")
                    }
                    else -> {
                        if (this.date == null) {
                            val frament =
                                fragmentManager?.findFragmentByTag("NotesFragment") as NotesFragment
                            var note = Note(
                                Edittext_fragment_add_note_add_head_text.text.toString(),
                                textview_fragment_add_note_add_description_text.text.toString()
                            )
                            frament.presenter.initiateAddnewNote(note)

                            val fragmentManager = fragmentManager
                            fragmentManager?.popBackStack()
                        } else {
                            val frament =
                                fragmentManager?.findFragmentByTag("NotesFragment") as NotesFragment
                            var note = Note(
                                Edittext_fragment_add_note_add_head_text.text.toString(),
                                textview_fragment_add_note_add_description_text.text.toString(),
                                this.date!!
                            )
                            frament.presenter.initiateAddnewNote(note)

                            val fragmentManager = fragmentManager
                            fragmentManager?.popBackStack()
                        }
                    }
                }
            }
        }

    }


    fun getDate(year: Int, month: Int, day: Int): String {
        var months = (month + 1)
        var date = "$day:$months:$year"
        return date
    }


    override fun initializeListeners()
    {
        button_add_fragment_note_add.setOnClickListener(this)
        button_select_date_fragment_note_add.setOnClickListener(this)
    }

    override fun initializeNotePresenter() {
        TODO("Not yet implemented")
    }

    override fun initializeNoteLayoutManager() {
        TODO("Not yet implemented")
    }

    override fun NoteAdapter(notes : ArrayList<Note>) {
        TODO("Not yet implemented")
    }

    override fun initializeNoteAdapter() {
        TODO("Not yet implemented")
    }

    override fun initiateNoteUpdateAdapter() {
        TODO("Not yet implemented")
    }

    override fun processNoteData(notes: ArrayList<Note>) {
        TODO("Not yet implemented")
    }

    override fun initializeViews() {
        TODO("Not yet implemented")
    }


    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
}