package com.example.myapplication.Presentation.Contract

import com.example.myapplication.Domain.Note
import com.example.myapplication.Presentation.Base.BaseContract

interface NotesFragmentContract {

    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(notes: ArrayList<Note>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateAddTestNote(note: Note)

        fun initiateAddnewNote(note: Note)

    }

}