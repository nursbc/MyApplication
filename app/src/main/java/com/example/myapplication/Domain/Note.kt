package com.example.myapplication.Domain

import java.time.DateTimeException
import java.util.*

class Note {

    var date: Date? = null
    var description: String = ""
    var head: String = "";

    constructor(description: String, head: String)
    {
        date = Calendar.getInstance().getTime();
        this.description = description
        this.head = head
    }
    constructor(date: Date, description: String, head: String)
    {
        this.date = date
        this.description = description
        this.head = head
    }


}

