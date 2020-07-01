package com.example.myapplication.Data

class Student {

    var name : String = ""
    var description : String = ""
    var mark : Float = 0.0F

    constructor()
    constructor(name: String, description : String, mark : Float)
    {
        this.name = name
        this.description = description
        this.mark = mark
    }
}