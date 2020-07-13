package com.example.myapplication.Domain

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import java.util.*

@SuppressLint("ParcelCreator")
class Student() : Parcelable {

    var name : String = ""
    var description : String = ""
    var mark : Float = 0.0F
    var date: String? = null
    var studentGroup: String = ""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        description = parcel.readString().toString()
        mark = parcel.readFloat()
    }

    constructor(name: String, description : String, mark : Float) : this() {
        this.name = name
        this.description = description
        this.mark = mark
    }

    constructor(name: String, description : String, mark : Float, date : String?, studentGroup : String) : this() {
        this.name = name
        this.description = description
        this.mark = mark
        this.date = date
        this.studentGroup = studentGroup
    }

    fun getnDate(): String? {
        return this.date
    }
    companion object : Parceler<Student> {

        override fun Student.write(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(description)
            parcel.writeFloat(mark)
            parcel.writeString(date.toString())
            parcel.writeString(studentGroup)
        }

        override fun create(parcel: Parcel): Student {
            return Student(parcel)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeFloat(mark)
        parcel.writeString(studentGroup)
    }

    override fun describeContents(): Int {
        return 0
    }


}