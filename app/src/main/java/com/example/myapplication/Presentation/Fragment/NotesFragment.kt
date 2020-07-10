package com.example.myapplication.Presentation.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Domain.Note
import com.example.myapplication.Presentation.Adapter.NotesAdapter
import com.example.myapplication.Presentation.Contract.NotesFragmentContract
import com.example.myapplication.Presentation.Presenters.NotesFragmentPresenter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_notes.*

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
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        presenter.initializeData()
    }

    override fun onClick(v: View?) {


    }

    override fun initializePresenter() {
        presenter = NotesFragmentPresenter()
        presenter.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclervyew_fragment_note?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        notesAdapter = NotesAdapter(context, notes)
        recyclervyew_fragment_note.adapter = notesAdapter
    }

    override fun initiateUpdateAdapter() {
        notesAdapter?.notifyDataSetChanged()
    }

    override fun processData(notes: ArrayList<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
    }

    override fun initializeViews() {
        recyclervyew_fragment_note?.visibility = View.VISIBLE
    }

    override fun initializeListeners() {
        fragment_notes_floating_button_create.setOnClickListener(this)
    }

    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
}