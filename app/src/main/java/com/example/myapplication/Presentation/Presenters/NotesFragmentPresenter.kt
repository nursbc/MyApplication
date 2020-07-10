package com.example.myapplication.Presentation.Presenters

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.myapplication.Domain.Note
import com.example.myapplication.Presentation.Contract.NotesFragmentContract
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class NotesFragmentPresenter : NotesFragmentContract.Presenter {

    var view : NotesFragmentContract.View? = null

    var notes : ArrayList<Note> = ArrayList()

    var calendar: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.O)
    var data = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val temp = getDate(data.year, data.month.value, data.dayOfMonth)

    constructor()
    {

    }


    override fun initializeData() {
        view?.processData(notes.apply {
            add(Note(temp, "Vajnie", "Dela"))
            add(
                Note(
                    getDate(2020, 1, 26),
                    "Vajnie",
                    "Dela"
                )
            )
            add(
                Note(
                    getDate(2020, 3, 1),
                    "pora uje",
                    "Sport"
                )
            )
            add(
                Note(
                    getDate(2020, 3, 8),
                    "s druziami",
                    "Progulka"
                )
            )
            add(
                Note(
                    getDate(2020, 4, 26),
                    "Dela",
                    "Dela"
                )
            )
            add(
                Note(
                    getDate(2020, 5, 26),
                    "Dela",
                    "Dela"
                )
            )
        })

        view?.initializeAdapter()
    }

    fun getDate(year: Int, month: Int, day: Int): Date {
        val cal = Calendar.getInstance()
        cal[Calendar.YEAR] = year
        cal[Calendar.MONTH] = month
        cal[Calendar.DAY_OF_MONTH] = day
        cal[Calendar.HOUR_OF_DAY] = 0
        cal[Calendar.MINUTE] = 0
        cal[Calendar.SECOND] = 0
        cal[Calendar.MILLISECOND] = 0
        return cal.time
    }

    override fun initiateAddTestNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun initiateAddnewNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun attach(view: NotesFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        this.view = null
    }


}