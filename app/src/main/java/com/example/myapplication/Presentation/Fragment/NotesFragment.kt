package com.example.myapplication.Presentation.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Domain.Note
import com.example.myapplication.Presentation.Adapter.NotesAdapter
import com.example.myapplication.Presentation.Contract.NotesFragmentContract
import com.example.myapplication.Presentation.Presenters.NotesFragmentPresenter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_notes.*
import kotlinx.android.synthetic.main.fragment_students.*

class NotesFragment : Fragment(), View.OnClickListener, NotesFragmentContract.View {

    var notes : ArrayList<Note> = ArrayList()
    var notesAdapter : NotesAdapter? = null

    lateinit var presenter : NotesFragmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_notes, container, false)

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        initializeListeners()
        initializeNotePresenter()
        initializeNoteLayoutManager()
        initializeNoteAdapter()
        presenter.initializeData()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.button_back_fragment_note -> {
                val fragmentManager = fragmentManager
                fragmentManager?.popBackStack()
            }
            R.id.fragment_notes_floating_button_create -> {
                val fragmentManager = fragmentManager
                fragmentManager?.beginTransaction()?.add(R.id.relativelayout_activity_students_fragment_container, NotesAddFragment(), "NotesAddFragment")
                    ?.hide(this)
                    ?.addToBackStack(null)
                    ?.commit()
            }
            R.id.button_back_fragment_note_update -> {
                initializeNoteAdapter()
            }
        }

    }


    override fun initializeNotePresenter() {
        presenter = NotesFragmentPresenter()
        presenter.attach(this)
    }

    override fun initializeNoteLayoutManager() {
        recyclervyew_fragment_note?.layoutManager = LinearLayoutManager(context)
    }

    override fun NoteAdapter(notes : ArrayList<Note>) {
        notesAdapter = NotesAdapter(context, notes)
        recyclervyew_fragment_note.adapter = notesAdapter
    }

    override fun initializeNoteAdapter() {
        notesAdapter = NotesAdapter(context, notes)
        recyclervyew_fragment_note.adapter = notesAdapter
    }


    override fun initiateNoteUpdateAdapter() {
        notesAdapter?.notifyDataSetChanged()
    }

    override fun processNoteData(notes: ArrayList<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
    }

    override fun initializeViews() {
        recyclervyew_fragment_note?.visibility = View.VISIBLE
    }

    override fun initializeListeners() {
        fragment_notes_floating_button_create.setOnClickListener(this)
        button_back_fragment_note.setOnClickListener(this)
        button_back_fragment_note_update.setOnClickListener(this)
    }

    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
}